package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public static Bitmap a(Bitmap r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "sourceBitmap");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        if (r7.isRecycled() == false) goto L6;
        return r7;
    L6:
        Bitmap r1 = r7.copy(z0.b(r7.getConfig()), false);     // Catch: Throwable -> L8
        Bitmap r2 = Bitmap.createBitmap(r1.getWidth(), r1.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L8
        Canvas r3 = new Canvas(r2);     // Catch: Throwable -> L8
        Paint r4 = new Paint();     // Catch: Throwable -> L8
        r4.setAntiAlias(true);     // Catch: Throwable -> L8
        Shader.TileMode r5 = Shader.TileMode.CLAMP;     // Catch: Throwable -> L8
        r4.setShader(new BitmapShader(r1, r5, r5));     // Catch: Throwable -> L8
        r3.drawRoundRect(new RectF(0.0f, 0.0f, r1.getWidth(), r1.getHeight()), r8, r8, r4);     // Catch: Throwable -> L8
        Object r9 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r9);
        if (r6 == null) goto L13;
        FLogger.a.e("ImageCombineUtils", "Error in addRoundedCorners, returning original bitmap", r6);
    L13:
        Object r10 = r7;
        if (Result.isFailure-impl(r9) == true) goto L18;
        r10 = r9;
    L18:
        return (Bitmap) r10;
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static Bitmap b(Bitmap r8, int r9, int r10) {
        int r0 = r8.getWidth();
        int r1 = r8.getHeight();
        FLogger r2 = FLogger.a;
        r2.d("ImageCombineUtils", "Source: " + r0 + 'x' + r1 + ", Target: " + r9 + 'x' + r10);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        if (Math.abs((r0 / r1) - (r9 / r10)) > 0.01f) goto L6;
        r2.d("ImageCombineUtils", "Same aspect ratio - direct scale");     // Catch: Throwable -> L12
        Bitmap r3 = Bitmap.createScaledBitmap(r8, r9, r10, true);     // Catch: Throwable -> L12
    L10:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L18;
        FLogger.a.e("ImageCombineUtils", "Error in processBitmapToTargetSize, trying fallback", r6);
    L18:
        if (Result.exceptionOrNull-impl(r4) == null) goto L33;
        Object r11 = Result.constructor-impl(Bitmap.createScaledBitmap(r8, r9, r10, true));     // Catch: Throwable -> L22
    L24:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L27;
        FLogger.a.e("ImageCombineUtils", "Fallback also failed, returning original", r12);
    L27:
        Object r13 = r8;
        if (Result.isFailure-impl(r11) == true) goto L31;
        r13 = r11;
    L31:
        r4 = (Bitmap) r13;
    L22:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        return (Bitmap) r4;
    L6:
        if (r0 < r9) goto L9;
        if (r1 < r10) goto L9;
        r2.d("ImageCombineUtils", "Center crop - source is larger with different ratio");     // Catch: Throwable -> L12
        int r7 = r8.getWidth();     // Catch: Throwable -> L12
        int r15 = r8.getHeight();     // Catch: Throwable -> L12
        r3 = Bitmap.createBitmap(r8, Math.max(0, (r7 - r9) / 2), Math.max(0, (r15 - r10) / 2), Math.min(r9, r7), Math.min(r10, r15));     // Catch: Throwable -> L12
    L9:
        r2.d("ImageCombineUtils", "Scale up and crop - different ratio");     // Catch: Throwable -> L12
        r3 = d(r8, r9, r10);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static Bitmap d(Bitmap r6, int r7, int r8) {
        float r0 = r6.getWidth();
        float r1 = r6.getHeight();
        float r2 = Math.max(r7 / r0, r8 / r1);
        FLogger.a.d("ImageCombineUtils", "Scale factor: " + r2);
        int r3 = (int) (r0 * r2);
        int r4 = (int) (r1 * r2);
        Bitmap r5 = Bitmap.createScaledBitmap(r6, r3, r4, true);
        if (r3 != r7) goto L6;
        if (r4 != r8) goto L6;
        return r5;
    L6:
        Bitmap r9 = Bitmap.createBitmap(r5, Math.max(0, (r3 - r7) / 2), Math.max(0, (r4 - r8) / 2), r7, r8);
        if (Intrinsics.areEqual(r5, r6) == true) goto L9;
        r5.recycle();
    L9:
        return r9;
    }

    public static Bitmap c(Function2 r10, int r11, int r12, Bitmap r13) {
        if (z2.a.disablePuzzleSizeLimit() == true) goto L5;
        float r0 = 1.0f;
        Throwable r1 = null;
    L8:
        if (r0 < 0.25f) goto L30;
        int r2 = (int) (r11 * r0);
        int r4 = (int) (r12 * r0);
        if (r2 > 4096) goto L29;
        if (r4 > 4096) goto L29;
        FLogger.a.d("ImageCombineUtils", "Attempting operation with scale: " + r0 + ", size: " + r2 + 'x' + r4);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl((Bitmap) r10.invoke(Integer.valueOf(r2), Integer.valueOf(r4)));     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r3) == true) goto L21;
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L8;
        if ((r6 instanceof OutOfMemoryError) == false) goto L27;
        FLogger.a.w("ImageCombineUtils", "OOM occurred with scale: " + r0 + ", trying smaller scale", r6);
    L28:
        r0 = r0 * 0.75f;
        r1 = r6;
        goto L8
    L27:
        FLogger.a.e("ImageCombineUtils", "Unexpected error with scale: " + r0, r6);
        goto L28
    L21:
        return (Bitmap) r3;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        FLogger.a.w("ImageCombineUtils", "Bitmap size too large: " + r2 + 'x' + r4 + ", scaling down");
        r0 = r0 * 0.75f;
        goto L8
    L30:
        FLogger.a.e("ImageCombineUtils", "All attempts failed, returning fallback bitmap", r1);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L33
        Object r15 = Result.constructor-impl(a(r13, i5.q()));     // Catch: Throwable -> L33
    L35:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L38;
        Object r17 = r15;
    L40:
        return (Bitmap) r17;
    L38:
        FLogger.a.e("ImageCombineUtils", "Even fallback failed, returning original bitmap", r16);
        r17 = r13;
    L33:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L5:
        return (Bitmap) r10.invoke(Integer.valueOf(r11), Integer.valueOf(r12));
    }
}
