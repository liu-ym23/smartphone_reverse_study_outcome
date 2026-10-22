package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct r12, boolean r13, double r14) {
        super(r12, Variant.MONOCHROME, r13, r14, TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d), TonalPalette.fromHueAndChroma(r12.getHue(), 0.0d));
    }
}
