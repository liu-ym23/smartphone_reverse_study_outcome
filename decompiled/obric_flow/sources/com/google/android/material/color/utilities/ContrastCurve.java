package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double r5, double r10, double r11, double r12) {
        this.low = r5;
        this.normal = r10;
        this.medium = r11;
        this.high = r12;
    }

    public double getContrast(double r14) {
        if (r14 > (-1.0d)) goto L7;
        return this.low;
    L7:
        if (r14 >= 0.0d) goto L11;
        return MathUtils.lerp(this.low, this.normal, (r14 - (-1.0d)) / 1.0d);
    L11:
        if (r14 >= 0.5d) goto L15;
        return MathUtils.lerp(this.normal, this.medium, (r14 - 0.0d) / 0.5d);
    L15:
        if (r14 >= 1.0d) goto L19;
        return MathUtils.lerp(this.medium, this.high, (r14 - 0.5d) / 0.5d);
    L19:
        return this.high;
    }
}
