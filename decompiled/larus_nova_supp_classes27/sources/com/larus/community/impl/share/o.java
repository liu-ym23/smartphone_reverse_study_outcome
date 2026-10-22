package com.larus.community.impl.share;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Function2 {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ float c;

    public /* synthetic */ o(Bitmap r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
        this.c = 0.0f;
    }

    public final Object invoke(Object r14, Object r15) {
        Bitmap r0 = this.a;
        Bitmap r1 = this.b;
        float r2 = this.c;
        int r16 = ((Integer) r14).intValue();
        int r17 = ((Integer) r15).intValue();
        p.a.getClass();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        int r4 = r16 * 2;     // Catch: Throwable -> L17
        Bitmap r5 = Bitmap.createBitmap(r4, r17, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L17
        Canvas r6 = new Canvas(r5);     // Catch: Throwable -> L17
        Bitmap r7 = p.b(r0, r16, r17);     // Catch: Throwable -> L17
        if (r1.getWidth() == r16) goto L6;
    L9:
        Bitmap r8 = Bitmap.createScaledBitmap(r1, r16, r17, true);     // Catch: Throwable -> L17
    L10:
        Bitmap r9 = Bitmap.createBitmap(r4, r17, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L17
        Canvas r10 = new Canvas(r9);     // Catch: Throwable -> L17
        r10.drawBitmap(r7, 0.0f, 0.0f, null);     // Catch: Throwable -> L17
        r10.drawBitmap(r8, r16, 0.0f, null);     // Catch: Throwable -> L17
        Paint r18 = new Paint();     // Catch: Throwable -> L17
        r18.setAntiAlias(true);     // Catch: Throwable -> L17
        Shader.TileMode r11 = Shader.TileMode.CLAMP;     // Catch: Throwable -> L17
        r18.setShader(new BitmapShader(r9, r11, r11));     // Catch: Throwable -> L17
        r6.drawRoundRect(new RectF(0.0f, 0.0f, r4, r17), r2, r2, r18);     // Catch: Throwable -> L17
        r9.recycle();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r7, r0) == true) goto L14;
        r7.recycle();     // Catch: Throwable -> L17
    L14:
        if (Intrinsics.areEqual(r8, r1) == true) goto L26;
        r8.recycle();     // Catch: Throwable -> L17
    L26:
        return r5;
    L6:
        if (r1.getHeight() != r17) goto L9;
        r8 = r1;
    L17:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Throwable r111 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r111 == null) goto L23;
        FLogger.a.e("ImageCombineUtils", "combineImagesHorizontallyInternal error", r111);
        return r1;
    L23:
        throw new KotlinNothingValueException();
    }
}
