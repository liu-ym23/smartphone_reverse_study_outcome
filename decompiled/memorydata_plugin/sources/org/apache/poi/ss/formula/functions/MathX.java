package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: classes7.dex */
final class MathX {
    public static double acosh(double r4) {
        return Math.log(Math.sqrt(Math.pow(r4, 2.0d) - 1.0d) + r4);
    }

    public static double asinh(double r4) {
        return Math.log(Math.sqrt((r4 * r4) + 1.0d) + r4);
    }

    public static double atanh(double r4) {
        return Math.log((r4 + 1.0d) / (1.0d - r4)) / 2.0d;
    }

    public static double average(double[] r6) {
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = r1 + r6[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return r1 / ((double) r6.length);
    }

    public static double ceiling(double r4, double r6) {
        if (r4 > 0.0d) goto L5;
    L8:
        if (r4 != 0.0d) goto L10;
    L18:
        return 0.0d;
    L10:
        if (r6 == 0.0d) goto L18;
        if (r6 != 1.0d) goto L17;
        return Math.ceil(r4);
    L17:
        return scaledRoundUsingBigDecimal(r4, r6, RoundingMode.CEILING);
    L5:
        if (r6 >= 0.0d) goto L8;
        return Double.NaN;
    }

    public static double cosh(double r4) {
        return (Math.pow(2.718281828459045d, r4) + Math.pow(2.718281828459045d, -r4)) / 2.0d;
    }

    public static double factorial(double r0) {
        return factorial((int) r0);
    }

    public static double factorial(int r5) {
        if (r5 >= 0) goto L4;
        return Double.NaN;
    L4:
        if (r5 > 170) goto L8;
        int r0 = 1;
        double r1 = 1.0d;
    L6:
        if (r0 > r5) goto L13;
        r1 = r1 * ((double) r0);
        r0 = r0 + 1;
        goto L6
    L13:
        return r1;
    L8:
        return Double.POSITIVE_INFINITY;
    }

    public static double floor(double r8, double r10) {
        if (r10 != 0.0d) goto L8;
        if (r8 == 0.0d) goto L8;
        return Double.NaN;
    L8:
        if (r8 == 0.0d) goto L21;
        if (r10 == 0.0d) goto L21;
        if (r10 != 1.0d) goto L16;
        return Math.floor(r8);
    L16:
        if (r10 >= 0.0d) goto L20;
        if (r8 < 0.0d) goto L20;
        return Double.NaN;
    L20:
        return scaledRoundUsingBigDecimal(r8, r10, RoundingMode.FLOOR);
    L21:
        return 0.0d;
    }

    public static double max(double[] r6) {
        int r0 = r6.length;
        double r1 = Double.NEGATIVE_INFINITY;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = Math.max(r1, r6[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static double min(double[] r6) {
        int r0 = r6.length;
        double r1 = Double.POSITIVE_INFINITY;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = Math.min(r1, r6[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static double mod(double r2, double r4) {
        if (r4 != 0.0d) goto L6;
        return Double.NaN;
    L6:
        short r0 = sign(r2);
        double r3 = r2 % r4;
        if (r0 != sign(r4)) goto L10;
        return r3;
    L10:
        return (r3 + r4) % r4;
    }

    public static double nChooseK(int r6, int r7) {
        if (r7 < 0) goto L9;
        if (r6 < r7) goto L9;
        int r0 = r6 - r7;
        int r1 = Math.min(r0, r7);
        int r8 = Math.max(r0, r7);
        double r2 = 1.0d;
    L6:
        if (r8 >= r6) goto L12;
        r8 = r8 + 1;
        r2 = r2 * ((double) r8);
        goto L6
    L12:
        return r2 / factorial(r1);
    L9:
        return Double.NaN;
    }

    public static double product(double[] r6) {
        if (r6 != null) goto L4;
    L8:
        return 0.0d;
    L4:
        if (r6.length <= 0) goto L8;
        double r0 = 1.0d;
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        r0 = r0 * r6[r3];
        r3 = r3 + 1;
        goto L6
    L11:
        return r0;
    }

    public static double round(double r0, double r2) {
        return round(r0, (int) r2);
    }

    public static double round(double r1, int r3) {
        return round(r1, r3, RoundingMode.HALF_UP);
    }

    private static double round(double r1, int r3, RoundingMode r4) {
        if (Double.isNaN(r1) == false) goto L5;
        return Double.NaN;
    L5:
        if (Double.isInfinite(r1) == false) goto L8;
        return Double.NaN;
    L8:
        return new BigDecimal(NumberToTextConverter.toText(r1)).setScale(r3, r4).doubleValue();
    }

    public static double roundDown(double r0, double r2) {
        return roundDown(r0, (int) r2);
    }

    public static double roundDown(double r1, int r3) {
        return round(r1, r3, RoundingMode.DOWN);
    }

    public static double roundUp(double r0, double r2) {
        return roundUp(r0, (int) r2);
    }

    public static double roundUp(double r1, int r3) {
        return round(r1, r3, RoundingMode.UP);
    }

    public static double scaledRoundUsingBigDecimal(double r0, double r2, RoundingMode r4) {
        BigDecimal r3 = BigDecimal.valueOf(r2);
        return BigDecimal.valueOf(r0).divide(r3, MathContext.DECIMAL128).setScale(0, r4).multiply(r3).doubleValue();
    }

    public static short sign(double r3) {
        if (r3 != 0.0d) goto L6;
        int r4 = 0;
    L10:
        return (short) r4;
    L6:
        if (r3 >= 0.0d) goto L8;
        r4 = -1;
        goto L10
    L8:
        r4 = 1;
        goto L10
    }

    public static double sinh(double r4) {
        return (Math.pow(2.718281828459045d, r4) - Math.pow(2.718281828459045d, -r4)) / 2.0d;
    }

    public static double sum(double[] r6) {
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + r6[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static double sumsq(double[] r6) {
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        double r4 = r6[r3];
        r1 = r1 + (r4 * r4);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public static double tanh(double r4) {
        double r2 = Math.pow(2.718281828459045d, r4);
        double r5 = Math.pow(2.718281828459045d, -r4);
        return (r2 - r5) / (r2 + r5);
    }
}
