package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeExpressive extends DynamicScheme {
    private static final double[] HUES = null;
    private static final double[] SECONDARY_ROTATIONS = null;
    private static final double[] TERTIARY_ROTATIONS = null;

    static {
        HUES = new double[]{0.0d, 21.0d, 51.0d, 121.0d, 151.0d, 191.0d, 271.0d, 321.0d, 360.0d};
        SECONDARY_ROTATIONS = new double[]{45.0d, 95.0d, 45.0d, 20.0d, 45.0d, 90.0d, 45.0d, 45.0d, 45.0d};
        TERTIARY_ROTATIONS = new double[]{120.0d, 120.0d, 20.0d, 45.0d, 20.0d, 15.0d, 20.0d, 120.0d, 120.0d};
    }

    public SchemeExpressive(Hct r12, boolean r13, double r14) {
        Variant r5 = Variant.EXPRESSIVE;
        TonalPalette r10 = TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(r12.getHue() + 240.0d), 40.0d);
        double[] r11 = HUES;
        super(r12, r5, r13, r14, r10, TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(r12, r11, SECONDARY_ROTATIONS), 24.0d), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(r12, r11, TERTIARY_ROTATIONS), 32.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(r12.getHue() + 15.0d), 8.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(r12.getHue() + 15.0d), 12.0d));
    }
}
