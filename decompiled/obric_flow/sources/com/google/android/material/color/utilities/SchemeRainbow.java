package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeRainbow extends DynamicScheme {
    public SchemeRainbow(Hct r12, boolean r13, double r14) {
        super(r12, Variant.RAINBOW, r13, r14, TonalPalette.fromHueAndChroma(r12.getHue(), 48.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 16.0d), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(r12.getHue() + 60.0d), 24.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d));
    }
}
