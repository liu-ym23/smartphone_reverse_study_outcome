package org.apache.poi.ss.format;

/* JADX INFO: loaded from: classes7.dex */
public class SimpleFraction {
    private final int denominator;
    private final int numerator;

    public SimpleFraction(int r1, int r2) {
        this.numerator = r1;
        this.denominator = r2;
    }

    public static SimpleFraction buildFractionExactDenominator(double r2, int r4) {
        return new SimpleFraction((int) Math.round(r2 * ((double) r4)), r4);
    }

    private static SimpleFraction buildFractionMaxDenominator(double r37, double r39, int r41, int r42) {
        long r4 = (long) Math.floor(r37);
        String r9 = ")";
        String r10 = "/";
        if (r4 > 2147483647L) goto L45;
        int r13 = 1;
        if (Math.abs(r4 - r37) < r39) goto L7;
        int r8 = 0;
        double r23 = r37;
        long r14 = r4;
        boolean r16 = false;
        long r21 = 0;
        long r6 = 1;
        long r17 = 1;
    L9:
        r8 = r8 + r13;
        long r27 = r14;
        double r25 = 1.0d / (r23 - r4);
        long r15 = (long) Math.floor(r25);
        long r31 = r4;
        long r5 = (r15 * r27) + r17;
        long r18 = (r15 * r6) + r21;
        if (r39 != 0.0d) goto L18;
        if (r41 <= 0) goto L18;
        String r35 = r9;
        String r36 = r10;
        long r11 = r41;
        if (Math.abs(r18) <= r11) goto L20;
        if (Math.abs(r6) >= r11) goto L20;
        return new SimpleFraction((int) r27, (int) r6);
    L20:
        if (r5 > 2147483647L) goto L43;
        if (r18 > 2147483647L) goto L43;
        long r28 = r6;
        double r7 = r5 / r18;
        if (r8 < r42) goto L26;
    L30:
        r6 = r28;
        long r12 = r27;
        r16 = true;
    L31:
        if (r16 == true) goto L32;
        r14 = r12;
        r4 = r31;
        r9 = r35;
        r10 = r36;
        r13 = 1;
        goto L9
    L32:
        if (r8 >= r42) goto L40;
        if (r18 >= r41) goto L38;
        return new SimpleFraction((int) r5, (int) r18);
    L38:
        return new SimpleFraction((int) r12, (int) r6);
    L40:
        throw new RuntimeException("Unable to convert " + r37 + " to fraction after " + r42 + " iterations");
    L26:
        if (Math.abs(r7 - r37) <= r39) goto L30;
        if (r18 >= r41) goto L30;
        r12 = r5;
        r6 = r18;
        r23 = r25;
        r21 = r28;
        r17 = r27;
        r31 = r15;
    L43:
        throw new RuntimeException("Overflow trying to convert " + r37 + " to fraction (" + r5 + r36 + r18 + r35);
    L18:
        r35 = r9;
        r36 = r10;
        goto L20
    L7:
        return new SimpleFraction((int) r4, 1);
    L45:
        throw new IllegalArgumentException("Overflow trying to convert " + r37 + " to fraction (" + r4 + "/1)");
    }

    public static SimpleFraction buildFractionMaxDenominator(double r6, int r8) {
        return buildFractionMaxDenominator(r6, 0.0d, r8, 100);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }
}
