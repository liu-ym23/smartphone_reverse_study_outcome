package org.bouncycastle.pqc.math.linearalgebra;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes7.dex */
public final class PolynomialRingGF2 {
    public static int degree(int r1) {
        int r0 = -1;
    L3:
        if (r1 == 0) goto L5;
        r0 = r0 + 1;
        r1 = r1 >>> 1;
        goto L3
    L5:
        return r0;
    }

    public static int gcd(int r1, int r2) {
    L2:
        int r0 = r2;
        int r3 = r1;
        r1 = r0;
        if (r1 == 0) goto L5;
        r2 = remainder(r3, r1);
        goto L2
    L5:
        return r3;
    }

    public static int getIrreduciblePolynomial(int r3) {
        if (r3 >= 0) goto L8;
        PrintStream r4 = System.err;
        String r1 = "The Degree is negative";
    L5:
        r4.println(r1);
        return 0;
    L8:
        if (r3 <= 31) goto L11;
        r4 = System.err;
        r1 = "The Degree is more then 31";
        goto L5
    L11:
        if (r3 != 0) goto L13;
        return 1;
    L13:
        int r2 = (1 << r3) + 1;
        int r5 = 1 << (r3 + 1);
    L14:
        if (r2 >= r5) goto L19;
        if (isIrreducible(r2) == true) goto L17;
        r2 = r2 + 2;
        goto L14
    L17:
        return r2;
    L19:
        return 0;
    }

    public static boolean isIrreducible(int r6) {
        if (r6 != 0) goto L5;
        return false;
    L5:
        int r1 = degree(r6) >>> 1;
        int r3 = 2;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        r3 = modMultiply(r3, r3, r6);
        if (gcd(r3 ^ 2, r6) != 1) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static int modMultiply(int r4, int r5, int r6) {
        int r7 = remainder(r4, r6);
        int r8 = remainder(r5, r6);
        int r0 = 0;
        if (r8 == 0) goto L12;
        int r1 = 1 << degree(r6);
    L5:
        if (r7 == 0) goto L12;
        if (((byte) (r7 & 1)) != 1) goto L9;
        r0 = r0 ^ r8;
    L9:
        r7 = r7 >>> 1;
        r8 = r8 << 1;
        if (r8 < r1) goto L5;
        r8 = r8 ^ r6;
    L12:
        return r0;
    }

    public static int remainder(int r2, int r3) {
        if (r3 != 0) goto L6;
        System.err.println("Error: to be divided by 0");
        return 0;
    L6:
        if (degree(r2) < degree(r3)) goto L8;
        r2 = r2 ^ (r3 << (degree(r2) - degree(r3)));
        goto L6
    L8:
        return r2;
    }
}
