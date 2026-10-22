package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap r10, Function1<? super Canvas, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        r11.invoke(new Canvas(r10));
        return r10;
    }

    public static final boolean contains(Bitmap r10, Point r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        int r12 = r10.getWidth();
        int r13 = r11.x;
        if (r13 < 0) goto L6;
        if (r13 >= r12) goto L6;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L14;
        int r15 = r11.y;
        if (r15 < 0) goto L14;
        if (r15 >= r10.getHeight()) goto L14;
        return true;
    L14:
        return false;
    L6:
        r14 = false;
        goto L7
    }

    public static final boolean contains(Bitmap r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "p");
        float r12 = r11.x;
        if (r12 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r12 >= r10.getWidth()) goto L11;
        float r13 = r11.y;
        if (r13 < 0.0f) goto L11;
        if (r13 >= r10.getHeight()) goto L11;
        return true;
    }

    public static final Bitmap createBitmap(int r10, int r11, Bitmap.Config r12) {
        Intrinsics.checkNotNullParameter(r12, "config");
        Bitmap r13 = Bitmap.createBitmap(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "createBitmap(width, height, config)");
        return r13;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int r10, int r11, Bitmap.Config r12, boolean r13, ColorSpace r14) {
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r14, "colorSpace");
        Bitmap r15 = Bitmap.createBitmap(r10, r11, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return r15;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r10, int r11, Bitmap.Config r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = Bitmap.Config.ARGB_8888;
    L5:
        Intrinsics.checkNotNullParameter(r12, "config");
        Bitmap r15 = Bitmap.createBitmap(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r15, "createBitmap(width, height, config)");
        return r15;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r10, int r11, Bitmap.Config r12, boolean r13, ColorSpace r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r12 = Bitmap.Config.ARGB_8888;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r13 = true;
    L9:
        if ((r15 & 16) == 0) goto L11;
        r14 = ColorSpace.get(ColorSpace.Named.SRGB);
        Intrinsics.checkNotNullExpressionValue(r14, "get(ColorSpace.Named.SRGB)");
    L11:
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r14, "colorSpace");
        Bitmap r17 = Bitmap.createBitmap(r10, r11, r12, r13, r14);
        Intrinsics.checkNotNullExpressionValue(r17, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return r17;
    }

    public static final int get(Bitmap r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getPixel(r11, r12);
    }

    public static final Bitmap scale(Bitmap r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Bitmap r14 = Bitmap.createScaledBitmap(r10, r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "createScaledBitmap(this, width, height, filter)");
        return r14;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = true;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Bitmap r16 = Bitmap.createScaledBitmap(r10, r11, r12, r13);
        Intrinsics.checkNotNullExpressionValue(r16, "createScaledBitmap(this, width, height, filter)");
        return r16;
    }

    public static final void set(Bitmap r10, int r11, int r12, @ColorInt int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.setPixel(r11, r12, r13);
    }
}
