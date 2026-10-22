package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PointProviderLab implements PointProvider {
    public PointProviderLab() {
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public double distance(double[] r10, double[] r11) {
        double r5 = r10[0] - r11[0];
        double r12 = r10[1] - r11[1];
        double r13 = r10[2] - r11[2];
        double r14 = r12 * r12;
        double r15 = r13 * r13;
        return r15 + (r14 + (r5 * r5));
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public double[] fromInt(int r10) {
        double[] r11 = ColorUtils.labFromArgb(r10);
        return new double[]{r11[0], r11[1], r11[2]};
    }

    @Override // com.google.android.material.color.utilities.PointProvider
    public int toInt(double[] r10) {
        return ColorUtils.argbFromLab(r10[0], r10[1], r10[2]);
    }
}
