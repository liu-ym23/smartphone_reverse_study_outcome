package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public TonalPalette f8525a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public TonalPalette f8526a2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public TonalPalette f8527a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public TonalPalette f8528n1;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public TonalPalette f8529n2;

    private CorePalette(int r11, boolean r12) {
        Hct r13 = Hct.fromInt(r11);
        double r5 = r13.getHue();
        double r10 = r13.getChroma();
        if (r12 == false) goto L5;
        this.f8525a1 = TonalPalette.fromHueAndChroma(r5, r10);
        this.f8526a2 = TonalPalette.fromHueAndChroma(r5, r10 / 3.0d);
        this.f8527a3 = TonalPalette.fromHueAndChroma(60.0d + r5, r10 / 2.0d);
        this.f8528n1 = TonalPalette.fromHueAndChroma(r5, Math.min(r10 / 12.0d, 4.0d));
        this.f8529n2 = TonalPalette.fromHueAndChroma(r5, Math.min(r10 / 6.0d, 8.0d));
    L6:
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
        return;
    L5:
        this.f8525a1 = TonalPalette.fromHueAndChroma(r5, Math.max(48.0d, r10));
        this.f8526a2 = TonalPalette.fromHueAndChroma(r5, 16.0d);
        this.f8527a3 = TonalPalette.fromHueAndChroma(60.0d + r5, 24.0d);
        this.f8528n1 = TonalPalette.fromHueAndChroma(r5, 4.0d);
        this.f8529n2 = TonalPalette.fromHueAndChroma(r5, 8.0d);
        goto L6
    }

    public static CorePalette contentOf(int r5) {
        return new CorePalette(r5, true);
    }

    public static CorePalette of(int r5) {
        return new CorePalette(r5, false);
    }
}
