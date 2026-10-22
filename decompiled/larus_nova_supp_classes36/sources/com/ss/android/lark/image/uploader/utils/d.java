package com.ss.android.lark.image.uploader.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final d a = null;
    public static final Paint b = null;

    public d() {
    }

    static {
        a = new d();
        b = new Paint(6);
    }

    public final Bitmap a(Bitmap r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "inBitmap");
        switch(r8) {
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        return r7;
    L8:
        Matrix r1 = new Matrix();
        switch(r8) {
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L18;
        };
    L11:
        r1.setRotate(-90.0f);
        goto L18
    L12:
        r1.setRotate(-90.0f);
        r1.postScale(-1.0f, 1.0f);
        goto L18
    L13:
        r1.setRotate(90.0f);
        goto L18
    L14:
        r1.setRotate(90.0f);
        r1.postScale(-1.0f, 1.0f);
        goto L18
    L15:
        r1.setRotate(180.0f);
        r1.postScale(-1.0f, 1.0f);
        goto L18
    L16:
        r1.setRotate(180.0f);
        goto L18
    L17:
        r1.setScale(-1.0f, 1.0f);
    L18:
        RectF r9 = new RectF(0.0f, 0.0f, r7.getWidth(), r7.getHeight());
        r1.mapRect(r9);
        int r2 = Math.round(r9.width());
        int r3 = Math.round(r9.height());
        Bitmap.Config r4 = r7.getConfig();
        if (r4 != null) goto L21;
        r4 = Bitmap.Config.ARGB_8888;
    L21:
        Bitmap r5 = Bitmap.createBitmap(r2, r3, r4);
        r1.postTranslate(-r9.left, -r9.top);
        r5.setHasAlpha(r7.hasAlpha());
        monitor-enter(this);
        Canvas r10 = new Canvas(r5);     // Catch: Throwable -> L26
        r10.drawBitmap(r7, r1, b);     // Catch: Throwable -> L26
        r10.setBitmap(null);     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L26:
        th = move-exception;
        throw th;
    L5:
        r0 = true;
        goto L6
    }
}
