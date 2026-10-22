package com.bytedance.android.livesdk.interactivity.like.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final float j = 0.0f;
    public static final int k = 0;
    public static final String l = null;
    public static final String m = null;

    static {
        a = s1.f(32.0f);
        b = s1.f(36.0f);
        c = ColorProtector.parseColor("#BDBDBE");
        d = -1;
        e = s1.f(1.3f);
        f = s1.f(11.0f);
        g = ColorProtector.parseColor("#FF308A");
        h = -s1.f(2.0f);
        i = -1;
        j = s1.f(2.0f);
        s1.f(54.0f);
        k = s1.f(22.0f);
        l = i2.b("/digg/live_digg_double_like_stmosphere.webp");
        m = i2.b("/digg/live_digg_double_like_stmosphere_begin.webp");
    }

    public static Bitmap a(Bitmap r11, int r13) {
        Intrinsics.checkNotNullParameter(r11, "avatar");
        int r0 = a;
        int r1 = b;
        Bitmap r2 = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_4444);
        Canvas r3 = new Canvas(r2);
        Paint r4 = new Paint();
        r4.setAntiAlias(true);
        Rect r6 = new Rect(0, 0, r0, r0);
        RectF r8 = new RectF(r6);
        float r5 = r0 / 2;
        r3.drawARGB(0, 0, 0, 0);
        r4.setColor(c);
        r3.drawRoundRect(r8, r5, r5, r4);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r3.drawBitmap(r11, null, r6, r4);
        r4.setColor(d);
        r4.setStyle(Paint.Style.STROKE);
        r4.setStrokeWidth(e);
        r3.drawCircle(r8.centerX(), r8.centerY(), r8.width() / 2, r4);
        String r14 = "+" + r13;
        Paint r15 = new Paint();
        r15.setAntiAlias(true);
        r15.setTextAlign(Paint.Align.CENTER);
        r15.setTextSize(f);
        r15.setTextSkewX(-0.25f);
        r15.setFakeBoldText(true);
        float r7 = r5 + h;
        float r9 = r1 - r15.getFontMetrics().bottom;
        r15.setStyle(Paint.Style.FILL_AND_STROKE);
        r15.setColor(i);
        r15.setStrokeWidth(j);
        r3.drawText(r14, r7, r9, r15);
        r15.setColor(g);
        r15.setStrokeWidth(0.0f);
        r3.drawText(r14, r7, r9, r15);
        return r2;
    }
}
