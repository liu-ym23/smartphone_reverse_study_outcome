package com.larus.bmhome.chat.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bitmap a(Bitmap r7, float r8) {
        if (r7 == null) goto L14;
    L8:
        e = move-exception;
        FLogger.a.e("MapImageLoader", "[roundBitmap] error:" + e.getMessage());
        return null;
    L4:
        if (r7.isRecycled() == true) goto L15;
        Bitmap r0 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L8
        Canvas r1 = new Canvas(r0);     // Catch: Exception -> L8
        Paint r2 = new Paint();     // Catch: Exception -> L8
        r2.setAntiAlias(true);     // Catch: Exception -> L8
        Rect r3 = new Rect(0, 0, r7.getWidth(), r7.getHeight());     // Catch: Exception -> L8
        RectF r4 = new RectF(r3);     // Catch: Exception -> L8
        r1.drawARGB(0, 0, 0, 0);     // Catch: Exception -> L8
        r1.drawRoundRect(r4, r8, r8, r2);     // Catch: Exception -> L8
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));     // Catch: Exception -> L8
        r1.drawBitmap(r7, r3, r3, r2);     // Catch: Exception -> L8
        return r0;
    L15:
        return null;
    L14:
        return null;
    }
}
