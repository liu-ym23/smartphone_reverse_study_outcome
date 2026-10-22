package org.apache.commons.math3.dfp;

/* JADX INFO: loaded from: classes6.dex */
public class DfpMath {
    public static Dfp acos(Dfp r3) {
        boolean r0 = r3.lessThan(r3.getZero());
        Dfp r4 = Dfp.copysign(r3, r3.getOne());
        Dfp r1 = atan(r4.getOne().subtract(r4.multiply(r4)).sqrt2().divide(r4));
        if (r0 == false) goto L6;
        r1 = r4.getField().getPi().subtract(r1);
    L6:
        return r4.newInstance(r1);
    }

    public static Dfp asin(Dfp r2) {
        return atan(r2.divide(r2.getOne().subtract(r2.multiply(r2)).sqrt2()));
    }

    public static Dfp atan(Dfp r11) {
        Dfp r0 = r11.getField().getZero2();
        Dfp r1 = r11.getField().getOne2();
        Dfp[] r2 = r11.getField().getSqr2Split();
        Dfp[] r3 = r11.getField().getPiSplit();
        Dfp r5 = r2[0].subtract(r1).add(r2[1]);
        Dfp r7 = new Dfp(r11);
        if (r7.lessThan(r0) == false) goto L5;
        r7 = r7.negate();
        boolean r4 = true;
    L7:
        if (r7.greaterThan(r1) == false) goto L9;
        r7 = r1.divide(r7);
        boolean r8 = true;
    L11:
        if (r7.greaterThan(r5) == false) goto L13;
        Dfp[] r6 = {r2[0].subtract(r1), r2[1]};
        Dfp[] r9 = split(r7);
        Dfp[] r10 = splitMult(r9, r6);
        r10[0] = r10[0].add(r1);
        r9[0] = r9[0].subtract(r6[0]);
        r9[1] = r9[1].subtract(r6[1]);
        Dfp[] r12 = splitDiv(r9, r10);
        r7 = r12[0].add(r12[1]);
        boolean r13 = true;
    L14:
        Dfp r14 = atanInternal(r7);
        if (r13 == false) goto L17;
        r14 = r14.add(r3[0].divide(8)).add(r3[1].divide(8));
    L17:
        if (r8 == false) goto L19;
        r14 = r3[0].divide(2).subtract(r14).add(r3[1].divide(2));
    L19:
        if (r4 == false) goto L22;
        r14 = r14.negate();
    L22:
        return r11.newInstance(r14);
    L13:
        r13 = false;
        goto L14
    L9:
        r8 = false;
        goto L11
    L5:
        r4 = false;
        goto L7
    }

    public static Dfp atanInternal(Dfp r5) {
        Dfp r0 = new Dfp(r5);
        Dfp r1 = new Dfp(r0);
        Dfp r2 = new Dfp(r0);
        int r3 = 3;
    L4:
        if (r3 >= 90) goto L9;
        r1 = r1.multiply(r5).multiply(r5).negate();
        r0 = r0.add(r1.divide(r3));
        if (r0.equals(r2) == true) goto L9;
        r2 = new Dfp(r0);
        r3 = r3 + 2;
    L9:
        return r0;
    }

    public static Dfp cos(Dfp r8) {
        Dfp r0 = r8.getField().getPi();
        Dfp r1 = r8.getField().getZero2();
        Dfp r3 = r8.remainder(r0.multiply(2));
        if (r3.lessThan(r1) == false) goto L6;
        r3 = r3.negate();
    L6:
        if (r3.greaterThan(r0.divide(2)) == false) goto L8;
        r3 = r0.subtract(r3);
        boolean r4 = true;
    L10:
        if (r3.lessThan(r0.divide(4)) == false) goto L12;
        Dfp r2 = cosInternal(new Dfp[]{r3, r1});
    L13:
        if (r4 == false) goto L16;
        r2 = r2.negate();
    L16:
        return r8.newInstance(r2);
    L12:
        Dfp[] r5 = r8.getField().getPiSplit();
        r2 = sinInternal(new Dfp[]{r5[0].divide(2).subtract(r3), r5[1].divide(2)});
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    public static Dfp cosInternal(Dfp[] r6) {
        Dfp r1 = r6[0].getOne();
        Dfp r7 = r6[0].add(r6[1]);
        Dfp r8 = r7.multiply(r7);
        Dfp r0 = new Dfp(r1);
        Dfp r3 = r1;
        int r4 = 2;
        Dfp r2 = r3;
    L4:
        if (r4 >= 90) goto L9;
        r1 = r1.multiply(r8).negate();
        r2 = r2.divide((r4 - 1) * r4);
        r3 = r3.add(r1.multiply(r2));
        if (r3.equals(r0) == true) goto L9;
        r0 = new Dfp(r3);
        r4 = r4 + 2;
    L9:
        return r3;
    }

    public static Dfp pow(Dfp r7, int r8) {
        Dfp r0 = r7.getOne();
        if (r8 != 0) goto L6;
        return r0;
    L6:
        if (r8 >= 0) goto L8;
        r8 = -r8;
        boolean r2 = true;
    L9:
        Dfp r3 = new Dfp(r7);
        int r4 = 1;
    L10:
        Dfp r5 = new Dfp(r3);
        r3 = r3.multiply(r3);
        int r6 = r4 * 2;
        if (r8 <= r6) goto L12;
        r4 = r6;
        goto L10
    L12:
        r8 = r8 - r4;
        r0 = r0.multiply(r5);
        if (r8 >= 1) goto L9;
        if (r2 == false) goto L17;
        r0 = r7.getOne().divide(r0);
    L17:
        return r7.newInstance(r0);
    L8:
        r2 = false;
        goto L9
    }

    public static Dfp sin(Dfp r8) {
        Dfp r0 = r8.getField().getPi();
        Dfp r1 = r8.getField().getZero2();
        Dfp r3 = r8.remainder(r0.multiply(2));
        if (r3.lessThan(r1) == false) goto L5;
        r3 = r3.negate();
        boolean r2 = true;
    L7:
        if (r3.greaterThan(r0.divide(2)) == false) goto L10;
        r3 = r0.subtract(r3);
    L10:
        if (r3.lessThan(r0.divide(4)) == false) goto L12;
        Dfp r4 = sinInternal(split(r3));
    L13:
        if (r2 == false) goto L16;
        r4 = r4.negate();
    L16:
        return r8.newInstance(r4);
    L12:
        Dfp[] r6 = r8.getField().getPiSplit();
        r4 = cosInternal(new Dfp[]{r6[0].divide(2).subtract(r3), r6[1].divide(2)});
        goto L13
    L5:
        r2 = false;
        goto L7
    }

    public static Dfp sinInternal(Dfp[] r6) {
        Dfp r1 = r6[0].add(r6[1]);
        Dfp r2 = r1.multiply(r1);
        Dfp r7 = r6[0].getOne();
        Dfp r0 = new Dfp(r1);
        int r4 = 3;
        Dfp r3 = r1;
    L4:
        if (r4 >= 90) goto L9;
        r1 = r1.multiply(r2).negate();
        r7 = r7.divide((r4 - 1) * r4);
        r3 = r3.add(r1.multiply(r7));
        if (r3.equals(r0) == true) goto L9;
        r0 = new Dfp(r3);
        r4 = r4 + 2;
    L9:
        return r3;
    }

    public static Dfp[] split(Dfp r3) {
        Dfp[] r1 = new Dfp[2];
        Dfp r0 = r3.multiply(r3.power10K(r3.getRadixDigits() / 2));
        r1[0] = r3.add(r0).subtract(r0);
        r1[1] = r3.subtract(r1[0]);
        return r1;
    }

    public static Dfp[] splitDiv(Dfp[] r5, Dfp[] r6) {
        Dfp[] r0 = {r5[0].divide(r6[0]), r5[1].multiply(r6[0]).subtract(r5[0].multiply(r6[1]))};
        r0[1] = r0[1].divide(r6[0].multiply(r6[0]).add(r6[0].multiply(r6[1])));
        return r0;
    }

    public static Dfp[] splitMult(Dfp[] r5, Dfp[] r6) {
        Dfp[] r0 = {r5[0].multiply(r6[0]), r5[0].getZero()};
        if (r0[0].classify() != 1) goto L5;
    L8:
        return r0;
    L5:
        if (r0[0].equals(r0[1]) == true) goto L8;
        r0[1] = r5[0].multiply(r6[1]).add(r5[1].multiply(r6[0])).add(r5[1].multiply(r6[1]));
        goto L8
    }
}
