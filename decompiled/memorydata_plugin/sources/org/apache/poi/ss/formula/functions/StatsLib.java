package org.apache.poi.ss.formula.functions;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
final class StatsLib {
    public static double avedev(double[] r9) {
        int r0 = r9.length;
        int r1 = 0;
        double r2 = 0.0d;
        int r4 = 0;
        double r5 = 0.0d;
    L3:
        if (r4 >= r0) goto L5;
        r5 = r5 + r9[r4];
        r4 = r4 + 1;
        goto L3
    L5:
        double r6 = r5 / ((double) r9.length);
        int r3 = r9.length;
    L6:
        if (r1 >= r3) goto L9;
        r2 = r2 + Math.abs(r9[r1] - r6);
        r1 = r1 + 1;
        goto L6
    L9:
        return r2 / ((double) r9.length);
    }

    public static double devsq(double[] r13) {
        if (r13 != null) goto L4;
    L14:
        return Double.NaN;
    L4:
        if (r13.length < 1) goto L14;
        int r0 = r13.length;
        int r2 = r13.length;
        int r3 = 0;
        int r6 = 0;
        double r7 = 0.0d;
    L6:
        if (r6 >= r2) goto L8;
        r7 = r7 + r13[r6];
        r6 = r6 + 1;
        goto L6
    L8:
        double r8 = r7 / ((double) r0);
        int r4 = r13.length;
        double r9 = 0.0d;
    L9:
        if (r3 >= r4) goto L11;
        double r11 = r13[r3] - r8;
        r9 = r9 + (r11 * r11);
        r3 = r3 + 1;
        goto L9
    L11:
        if (r0 != 1) goto L18;
        return 0.0d;
    L18:
        return r9;
    }

    public static double kthLargest(double[] r1, int r2) {
        int r3 = r2 - 1;
        if (r1 != null) goto L5;
    L8:
        return Double.NaN;
    L5:
        if (r1.length <= r3) goto L8;
        if (r3 < 0) goto L8;
        Arrays.sort(r1);
        return r1[(r1.length - r3) - 1];
    }

    public static double kthSmallest(double[] r1, int r2) {
        int r3 = r2 - 1;
        if (r1 != null) goto L5;
    L8:
        return Double.NaN;
    L5:
        if (r1.length <= r3) goto L8;
        if (r3 < 0) goto L8;
        Arrays.sort(r1);
        return r1[r3];
    }

    public static double median(double[] r4) {
        if (r4 != null) goto L4;
    L9:
        return Double.NaN;
    L4:
        if (r4.length < 1) goto L9;
        int r0 = r4.length;
        Arrays.sort(r4);
        int r2 = r0 % 2;
        int r1 = r0 / 2;
        if (r2 != 0) goto L12;
        return (r4[r1] + r4[r1 - 1]) / 2.0d;
    L12:
        return r4[r1];
    }

    public static double stdev(double[] r4) {
        if (r4 != null) goto L4;
    L6:
        return Double.NaN;
    L4:
        if (r4.length <= 1) goto L6;
        return Math.sqrt(devsq(r4) / ((double) (r4.length - 1)));
    }

    public static double stdevp(double[] r4) {
        if (r4 != null) goto L4;
    L6:
        return Double.NaN;
    L4:
        if (r4.length <= 1) goto L6;
        return Math.sqrt(devsq(r4) / ((double) r4.length));
    }

    public static double var(double[] r4) {
        if (r4 != null) goto L4;
    L6:
        return Double.NaN;
    L4:
        if (r4.length <= 1) goto L6;
        return devsq(r4) / ((double) (r4.length - 1));
    }

    public static double varp(double[] r4) {
        if (r4 != null) goto L4;
    L6:
        return Double.NaN;
    L4:
        if (r4.length <= 1) goto L6;
        return devsq(r4) / ((double) r4.length);
    }
}
