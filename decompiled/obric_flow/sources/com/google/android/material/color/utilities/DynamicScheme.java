package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DynamicScheme {
    public final double contrastLevel;
    public final TonalPalette errorPalette;
    public final boolean isDark;
    public final TonalPalette neutralPalette;
    public final TonalPalette neutralVariantPalette;
    public final TonalPalette primaryPalette;
    public final TonalPalette secondaryPalette;
    public final int sourceColorArgb;
    public final Hct sourceColorHct;
    public final TonalPalette tertiaryPalette;
    public final Variant variant;

    public DynamicScheme(Hct r5, Variant r10, boolean r11, double r12, TonalPalette r13, TonalPalette r14, TonalPalette r15, TonalPalette r16, TonalPalette r17) {
        this.sourceColorArgb = r5.toInt();
        this.sourceColorHct = r5;
        this.variant = r10;
        this.isDark = r11;
        this.contrastLevel = r12;
        this.primaryPalette = r13;
        this.secondaryPalette = r14;
        this.tertiaryPalette = r15;
        this.neutralPalette = r16;
        this.neutralVariantPalette = r17;
        this.errorPalette = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static double getRotatedHue(Hct r10, double[] r11, double[] r12) {
        double r5 = r10.getHue();
        int r13 = 0;
        if (r12.length == 1) goto L5;
        int r14 = r11.length;
    L8:
        if (r13 > (r14 - 2)) goto L16;
        double r15 = r11[r13];
        int r16 = r13 + 1;
        double r17 = r11[r16];
        if (r15 >= r5) goto L15;
        if (r5 >= r17) goto L15;
        return MathUtils.sanitizeDegreesDouble(r5 + r12[r13]);
    L15:
        r13 = r16;
        goto L8
    L16:
        return r5;
    L5:
        return MathUtils.sanitizeDegreesDouble(r5 + r12[0]);
    }
}
