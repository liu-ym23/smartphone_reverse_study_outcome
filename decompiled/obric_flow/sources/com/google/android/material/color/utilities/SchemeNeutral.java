package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeNeutral extends DynamicScheme {
    public SchemeNeutral(Hct r12, boolean r13, double r14) {
        super(r12, Variant.NEUTRAL, r13, r14, TonalPalette.fromHueAndChroma(r12.getHue(), 12.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 8.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 16.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 2.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 2.0d));
    }
}
