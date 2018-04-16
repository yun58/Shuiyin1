package com.weishi.shuiyin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.w3c.dom.Text;

import static android.R.attr.width;

public class MainActivity extends AppCompatActivity {
    private ImageView ff;
    private ImageView ff222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ff = (ImageView) findViewById(R.id.ff);
        ff222 = (ImageView) findViewById(R.id.ff222);
        Bitmap sourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.head);
        Bitmap waterBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bottom_btn_recording_pressed02);
        Bitmap watermarkBitmap = ImageUtil.createWaterMaskCenter(sourBitmap, waterBitmap);
        watermarkBitmap = ImageUtil.createWaterMaskLeftBottom(this, watermarkBitmap, waterBitmap, 0, 0);
        Bitmap textBitmap = ImageUtil.drawTextToRightBottom(this, watermarkBitmap, "左上角", 40, Color.RED, 0, 0);

        ff.setImageBitmap(sourBitmap);
        ff222.setImageBitmap(textBitmap);

    }

    public int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public Bitmap addVerBitmap3(Bitmap first, String title, String content) {
        int width = first.getWidth();
        int height = first.getHeight();
//        int height2 = second.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(first, 0, 0, null);
//        canvas.drawBitmap(second, Dp2Px(this,85), first.getHeight(), null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setTextSize(Dp2Px(this,25));
        canvas.drawText(title, 0,0, paint);
        paint.setTextSize(Dp2Px(this,40));
        canvas.drawText(content, Dp2Px(this,first.getWidth()/2) , first.getHeight()/2, paint);
        return result;

    }


}
