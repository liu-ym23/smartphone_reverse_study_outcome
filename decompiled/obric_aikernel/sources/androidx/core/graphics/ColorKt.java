package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(long r10) {
        return Color.red(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(Color r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getComponent(0);
    }

    public static final int component1(@ColorInt int r10) {
        return (r10 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(long r10) {
        return Color.green(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(Color r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getComponent(1);
    }

    public static final int component2(@ColorInt int r10) {
        return (r10 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(long r10) {
        return Color.blue(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(Color r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getComponent(2);
    }

    public static final int component3(@ColorInt int r10) {
        return (r10 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(long r10) {
        return Color.alpha(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(Color r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getComponent(3);
    }

    public static final int component4(@ColorInt int r10) {
        return r10 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int r10, ColorSpace.Named r11) {
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        return Color.convert(r10, ColorSpace.get(r11));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int r10, ColorSpace r11) {
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        return Color.convert(r10, r11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long r10, ColorSpace.Named r11) {
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        return Color.convert(r10, ColorSpace.get(r11));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long r10, ColorSpace r11) {
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        return Color.convert(r10, r11);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(Color r10, ColorSpace.Named r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        Color r12 = r10.convert(ColorSpace.get(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "convert(ColorSpace.get(colorSpace))");
        return r12;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(Color r10, ColorSpace r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "colorSpace");
        Color r12 = r10.convert(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "convert(colorSpace)");
        return r12;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getAlpha(long r10) {
        return Color.alpha(r10);
    }

    public static final int getAlpha(@ColorInt int r10) {
        return (r10 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getBlue(long r10) {
        return Color.blue(r10);
    }

    public static final int getBlue(@ColorInt int r10) {
        return r10 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorSpace getColorSpace(long r10) {
        ColorSpace r11 = Color.colorSpace(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "colorSpace(this)");
        return r11;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getGreen(long r10) {
        return Color.green(r10);
    }

    public static final int getGreen(@ColorInt int r10) {
        return (r10 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(@ColorInt int r10) {
        return Color.luminance(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(long r10) {
        return Color.luminance(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getRed(long r10) {
        return Color.red(r10);
    }

    public static final int getRed(@ColorInt int r10) {
        return (r10 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isSrgb(long r10) {
        return Color.isSrgb(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isWideGamut(long r10) {
        return Color.isWideGamut(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color plus(Color r10, Color r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "c");
        Color r12 = ColorUtils.compositeColors(r11, r10);
        Intrinsics.checkNotNullExpressionValue(r12, "compositeColors(c, this)");
        return r12;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(@ColorInt int r10) {
        Color r11 = Color.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(long r10) {
        Color r11 = Color.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }

    @ColorInt
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final int toColorInt(long r10) {
        return Color.toArgb(r10);
    }

    @ColorInt
    public static final int toColorInt(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Color.parseColor(r10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long toColorLong(@ColorInt int r10) {
        return Color.pack(r10);
    }
}
