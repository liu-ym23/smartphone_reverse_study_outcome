package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bitmap a(Bitmap r19, float r20, float r21, Path r22, boolean r23, Function2 r24) {
        Intrinsics.checkNotNullParameter(r19, "inBitmap");
        Intrinsics.checkNotNullParameter(r24, "bitmapProvider");
        if (Math.abs(r20 - 1.0f) <= 1.0E-4f) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        if (r23 == true) goto L12;
        return r19;
    L12:
        Matrix r9 = new Matrix();
        if (r6 == false) goto L15;
        r9.postScale(r20, r21, r19.getWidth() / 2.0f, r19.getHeight() / 2.0f);
    L15:
        Rect r1 = null;
        if (r23 == false) goto L21;
        int r2 = r19.getWidth();
        int r7 = r19.getHeight();
        if (r22 == null) goto L21;
        Matrix r10 = new Matrix();
        r10.setScale(r2 / 100.0f, r7 / 100.0f);
        Path r3 = new Path(r22);
        r3.transform(r10);
    L22:
        float r4 = 0.0f;
        if (r3 == null) goto L73;
        PathMeasure r8 = new PathMeasure(r3, false);
        float[] r11 = new float[2];
        float r12 = Float.NEGATIVE_INFINITY;
        float r13 = Float.NEGATIVE_INFINITY;
        float r14 = Float.POSITIVE_INFINITY;
        float r15 = Float.POSITIVE_INFINITY;
    L25:
        float r16 = r8.getLength();
        if (r16 <= r4) goto L56;
    L29:
        if (r4 > r16) goto L43;
        r8.getPosTan(r4, r11, null);
        float r17 = r11[0];
        float r18 = r11[1];
        if (r17 >= r15) goto L34;
        r15 = r17;
    L34:
        if (r17 <= r13) goto L37;
        r13 = r17;
    L37:
        if (r18 >= r14) goto L40;
        r14 = r18;
    L40:
        if (r18 <= r12) goto L42;
        r12 = r18;
    L42:
        r4 = r4 + 1.0f;
        goto L29
    L43:
        r8.getPosTan(r16, r11, null);
        float r5 = r11[0];
        float r110 = r11[1];
        if (r5 >= r15) goto L47;
        r15 = r5;
    L47:
        if (r5 <= r13) goto L50;
        r13 = r5;
    L50:
        if (r110 >= r14) goto L53;
        r14 = r110;
    L53:
        if (r110 <= r12) goto L56;
        r12 = r110;
    L56:
        if (r8.nextContour() == false) goto L58;
        r4 = 0.0f;
        goto L25
    L58:
        if (r15 != Float.POSITIVE_INFINITY) goto L60;
        boolean r25 = true;
    L61:
        if (r25 == false) goto L63;
        RectF r26 = new RectF();
    L64:
        r9.mapRect(r26);
        int r27 = r19.getWidth();
        int r28 = r19.getHeight();
        if (r26.isEmpty() == true) goto L73;
        int r111 = Math.min(Math.max((int) Math.floor(r26.left), 0), r27);
        int r112 = Math.min(Math.max((int) Math.floor(r26.top), 0), r28);
        int r29 = Math.min(Math.max((int) Math.ceil(r26.right), 0), r27);
        int r30 = Math.min(Math.max((int) Math.ceil(r26.bottom), 0), r28);
        if (r29 <= r111) goto L73;
        if (r30 <= r112) goto L73;
        r1 = new Rect(r111, r112, r29, r30);
        goto L73
    L63:
        r26 = new RectF(r15, r14, r13, r12);
        goto L64
    L60:
        r25 = false;
    L73:
        if (r1 == null) goto L75;
        int r31 = r1.width();
    L76:
        if (r1 == null) goto L78;
        int r32 = r1.height();
    L79:
        Bitmap r33 = (Bitmap) r24.invoke(Integer.valueOf(r31), Integer.valueOf(r32));
        r33.setHasAlpha(true);
        Canvas r34 = new Canvas(r33);
        r34.drawColor(-16777216);
        Matrix r35 = new Matrix(r9);
        if (r1 == null) goto L82;
        r35.postTranslate(-r1.left, -r1.top);
    L82:
        Paint r36 = new Paint(3);
        int r37 = r34.save();
        r34.concat(r35);
        if (r3 != null) goto L91;
    L85:
        r34.drawBitmap(r19, 0.0f, 0.0f, r36);     // Catch: Throwable -> L88
        r34.restoreToCount(r37);
        return r33;
    L88:
        th = move-exception;
        r34.restoreToCount(r37);
        throw th;
    L91:
        r34.clipPath(r3);     // Catch: Throwable -> L88
        goto L85
    L78:
        r32 = r19.getHeight();
        goto L79
    L75:
        r31 = r19.getWidth();
    L21:
        r3 = null;
        goto L22
    L5:
        if (Math.abs(r21 - 1.0f) > 1.0E-4f) goto L8;
        r6 = false;
        goto L9
    }
}
