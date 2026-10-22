package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    private Contrast() {
    }

    public static double darker(double r11, double r13) {
        if (r11 >= 0.0d) goto L5;
    L23:
        return -1.0d;
    L5:
        if (r11 > 100.0d) goto L23;
        double r12 = ColorUtils.yFromLstar(r11);
        double r10 = ((r12 + 5.0d) / r13) - 5.0d;
        if (r10 < 0.0d) goto L23;
        if (r10 > 100.0d) goto L23;
        double r14 = ratioOfYs(r12, r10);
        double r15 = Math.abs(r14 - r13);
        if (r14 < r13) goto L15;
    L17:
        double r16 = ColorUtils.lstarFromY(r10) - LUMINANCE_GAMUT_MAP_TOLERANCE;
        if (r16 < 0.0d) goto L23;
        if (r16 > 100.0d) goto L23;
        return r16;
    L15:
        if (r15 <= CONTRAST_RATIO_EPSILON) goto L17;
        return -1.0d;
    }

    public static double darkerUnsafe(double r5, double r10) {
        return Math.max(0.0d, darker(r5, r10));
    }

    public static double lighter(double r11, double r13) {
        if (r11 >= 0.0d) goto L5;
    L23:
        return -1.0d;
    L5:
        if (r11 > 100.0d) goto L23;
        double r12 = ColorUtils.yFromLstar(r11);
        double r10 = ((r12 + 5.0d) * r13) - 5.0d;
        if (r10 < 0.0d) goto L23;
        if (r10 > 100.0d) goto L23;
        double r14 = ratioOfYs(r10, r12);
        double r15 = Math.abs(r14 - r13);
        if (r14 < r13) goto L15;
    L17:
        double r16 = ColorUtils.lstarFromY(r10) + LUMINANCE_GAMUT_MAP_TOLERANCE;
        if (r16 < 0.0d) goto L23;
        if (r16 > 100.0d) goto L23;
        return r16;
    L15:
        if (r15 <= CONTRAST_RATIO_EPSILON) goto L17;
        return -1.0d;
    }

    public static double lighterUnsafe(double r5, double r10) {
        double r11 = lighter(r5, r10);
        if (r11 >= 0.0d) goto L6;
        return 100.0d;
    L6:
        return r11;
    }

    public static double ratioOfTones(double r5, double r10) {
        return ratioOfYs(ColorUtils.yFromLstar(r5), ColorUtils.yFromLstar(r10));
    }

    public static double ratioOfYs(double r5, double r10) {
        double r11 = Math.max(r5, r10);
        if (r11 == r10) goto L7;
        r5 = r10;
    L7:
        return (r11 + 5.0d) / (r5 + 5.0d);
    }
}
