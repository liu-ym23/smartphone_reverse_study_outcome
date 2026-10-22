package org.apache.commons.math3.util;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes6.dex */
public class Precision {
    public static final double EPSILON = 0.0d;
    private static final long NEGATIVE_ZERO_DOUBLE_BITS = 0;
    private static final int NEGATIVE_ZERO_FLOAT_BITS = 0;
    private static final long POSITIVE_ZERO_DOUBLE_BITS = 0;
    private static final int POSITIVE_ZERO_FLOAT_BITS = 0;
    public static final double SAFE_MIN = 0.0d;

    static {
        POSITIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(0.0d);
        NEGATIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(-0.0d);
        POSITIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(0.0f);
        NEGATIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(-0.0f);
        EPSILON = Double.longBitsToDouble(4368491638549381120L);
        SAFE_MIN = Double.longBitsToDouble(4503599627370496L);
    }

    public static int compareTo(double r0, double r2, double r4) {
        if (equals(r0, r2, r4) == false) goto L7;
        return 0;
    L7:
        if (r0 >= r2) goto L10;
        return -1;
    L10:
        return 1;
    }

    public static boolean equals(double r1, double r3) {
        return equals(r1, r3, 1);
    }

    public static boolean equals(double r2, double r4, double r6) {
        if (equals(r2, r4, 1) == false) goto L5;
        return true;
    L5:
        if (FastMath.abs(r4 - r2) <= r6) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equals(double r11, double r13, int r15) {
        long r0 = Double.doubleToRawLongBits(r11);
        long r2 = Double.doubleToRawLongBits(r13);
        if (((r0 ^ r2) & Long.MIN_VALUE) == 0) goto L5;
        long r7 = POSITIVE_ZERO_DOUBLE_BITS;
        if (r0 >= r2) goto L10;
        long r3 = r2 - r7;
        long r1 = r0 - NEGATIVE_ZERO_DOUBLE_BITS;
    L11:
        long r8 = r15;
        if (r3 <= r8) goto L15;
    L13:
        boolean r16 = false;
    L17:
        if (r16 == false) goto L24;
        if (Double.isNaN(r11) == true) goto L24;
        if (Double.isNaN(r13) == true) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (r1 > (r8 - r3)) goto L13;
    L6:
        r16 = true;
        goto L17
    L10:
        long r4 = r0 - r7;
        r1 = r2 - NEGATIVE_ZERO_DOUBLE_BITS;
        r3 = r4;
        goto L11
    L5:
        if (FastMath.abs(r0 - r2) > r15) goto L13;
        goto L6
    }

    public static boolean equals(float r6, float r7, int r8) {
        int r0 = Float.floatToRawIntBits(r6);
        int r1 = Float.floatToRawIntBits(r7);
        if (((r0 ^ r1) & Integer.MIN_VALUE) == 0) goto L5;
        int r2 = POSITIVE_ZERO_FLOAT_BITS;
        if (r0 >= r1) goto L10;
        int r3 = r1 - r2;
        int r4 = r0 - NEGATIVE_ZERO_FLOAT_BITS;
    L11:
        if (r3 <= r8) goto L14;
    L12:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L23;
        if (Float.isNaN(r6) == true) goto L23;
        if (Float.isNaN(r7) == true) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (r4 > (r8 - r3)) goto L12;
    L6:
        r9 = true;
        goto L16
    L10:
        int r5 = r1 - NEGATIVE_ZERO_FLOAT_BITS;
        r3 = r0 - r2;
        r4 = r5;
        goto L11
    L5:
        if (FastMath.abs(r0 - r1) > r8) goto L12;
        goto L6
    }

    public static boolean equalsIncludingNaN(double r4, double r6) {
        if (r4 == r4) goto L5;
    L8:
        if (r4 == r4) goto L10;
        boolean r5 = true;
    L12:
        if (r6 == r6) goto L14;
        boolean r7 = true;
    L16:
        if ((r5 ^ r7) == false) goto L18;
        return false;
    L18:
        return true;
    L14:
        r7 = false;
        goto L16
    L10:
        r5 = false;
        goto L12
    L5:
        if (r6 != r6) goto L8;
        return equals(r4, r6, 1);
    }

    public static boolean equalsIncludingNaN(float r4, float r5) {
        if (r4 == r4) goto L5;
    L8:
        if (r4 == r4) goto L10;
        boolean r6 = true;
    L12:
        if (r5 == r5) goto L14;
        boolean r7 = true;
    L16:
        if ((r6 ^ r7) == false) goto L18;
        return false;
    L18:
        return true;
    L14:
        r7 = false;
        goto L16
    L10:
        r6 = false;
        goto L12
    L5:
        if (r5 != r5) goto L8;
        return equals(r4, r5, 1);
    }

    public static boolean equalsWithRelativeTolerance(double r5, double r7, double r9) {
        if (equals(r5, r7, 1) == false) goto L5;
        return true;
    L5:
        double r1 = FastMath.max(FastMath.abs(r5), FastMath.abs(r7));
        if (FastMath.abs((r5 - r7) / r1) <= r9) goto L10;
        return false;
    L10:
        return true;
    }

    public static double round(double r1, int r3) {
        return round(r1, r3, 4);
    }

    public static double round(double r3, int r5, int r6) {
        double r7 = new BigDecimal(Double.toString(r3)).setScale(r5, r6).doubleValue();     // Catch: NumberFormatException -> L7
        if (r7 == 0.0d) goto L6;
        return r7;
    L6:
        return r3 * 0.0d;
    L8:
        if (Double.isInfinite(r3) == false) goto L10;
        return r3;
    L10:
        return Double.NaN;
    }
}
