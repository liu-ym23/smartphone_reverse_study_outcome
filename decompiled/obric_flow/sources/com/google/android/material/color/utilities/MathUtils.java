package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double r5, double r10, double r11) {
        if (r11 >= r5) goto L6;
        return r5;
    L6:
        if (r11 <= r10) goto L8;
        return r10;
    L8:
        return r11;
    }

    public static int clampInt(int r5, int r10, int r11) {
        if (r11 >= r5) goto L4;
        return r5;
    L4:
        if (r11 <= r10) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static double differenceDegrees(double r5, double r10) {
        return 180.0d - Math.abs(Math.abs(r5 - r10) - 180.0d);
    }

    public static double lerp(double r5, double r10, double r11) {
        double r12 = (1.0d - r11) * r5;
        return (r11 * r10) + r12;
    }

    public static double[] matrixMultiply(double[] r17, double[][] r18) {
        double r5 = r17[0];
        double[] r10 = r18[0];
        double r11 = r10[0] * r5;
        double r12 = r17[1];
        double r13 = (r10[1] * r12) + r11;
        double r14 = r17[2];
        double r15 = (r10[2] * r14) + r13;
        double[] r16 = r18[1];
        double r19 = (r16[2] * r14) + ((r16[1] * r12) + (r16[0] * r5));
        double[] r20 = r18[2];
        return new double[]{r15, r19, (r14 * r20[2]) + ((r12 * r20[1]) + (r5 * r20[0]))};
    }

    public static double rotationDirection(double r5, double r10) {
        if (sanitizeDegreesDouble(r10 - r5) > 180.0d) goto L5;
        return 1.0d;
    L5:
        return -1.0d;
    }

    public static double sanitizeDegreesDouble(double r5) {
        double r10 = r5 % 360.0d;
        if (r10 < 0.0d) goto L5;
        return r10;
    L5:
        return r10 + 360.0d;
    }

    public static int sanitizeDegreesInt(int r5) {
        int r10 = r5 % 360;
        if (r10 < 0) goto L5;
        return r10;
    L5:
        return r10 + 360;
    }

    public static int signum(double r5) {
        if (r5 >= 0.0d) goto L7;
        return -1;
    L7:
        if (r5 != 0.0d) goto L10;
        return 0;
    L10:
        return 1;
    }
}
