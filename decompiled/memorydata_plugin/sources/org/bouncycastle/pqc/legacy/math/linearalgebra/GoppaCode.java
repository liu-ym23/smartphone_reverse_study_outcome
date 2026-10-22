package org.bouncycastle.pqc.legacy.math.linearalgebra;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes7.dex */
public final class GoppaCode {
    public static GF2Matrix createCanonicalCheckMatrix(GF2mField r17, PolynomialGF2mSmallM r18) {
        int r3 = r17.getDegree();
        int r5 = 1 << r3;
        int r6 = r18.getDegree();
        int r9 = 0;
        int[][] r8 = (int[][]) Array.newInstance(int.class, new int[]{r6, r5});
        int[][] r10 = (int[][]) Array.newInstance(int.class, new int[]{r6, r5});
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10[0][r11] = r17.inverse(r18.evaluateAt(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        int r12 = 1;
    L6:
        if (r12 >= r6) goto L11;
        int r13 = 0;
    L8:
        if (r13 >= r5) goto L10;
        r10[r12][r13] = r17.mult(r10[r12 - 1][r13], r13);
        r13 = r13 + 1;
        goto L8
    L10:
        r12 = r12 + 1;
        goto L6
    L11:
        int r14 = 0;
    L12:
        if (r14 >= r6) goto L20;
        int r15 = r9;
    L14:
        if (r15 >= r5) goto L19;
        int r16 = r9;
    L16:
        if (r16 > r14) goto L18;
        r8[r14][r15] = r17.add(r8[r14][r15], r17.mult(r10[r16][r15], r18.getCoefficient((r6 + r16) - r14)));
        r16 = r16 + 1;
        goto L16
    L18:
        r15 = r15 + 1;
        r9 = 0;
        goto L14
    L19:
        r14 = r14 + 1;
        r9 = 0;
        goto L12
    L20:
        int[][] r0 = (int[][]) Array.newInstance(int.class, new int[]{r6 * r3, (r5 + 31) >>> 5});
        int r2 = 0;
    L21:
        if (r2 >= r5) goto L33;
        int r4 = r2 >>> 5;
        int r19 = 1 << (r2 & 31);
        int r110 = 0;
    L23:
        if (r110 >= r6) goto L31;
        int r111 = r8[r110][r2];
        int r112 = 0;
    L25:
        if (r112 >= r3) goto L30;
        if (((r111 >>> r112) & 1) == 0) goto L29;
        int[] r113 = r0[(((r110 + 1) * r3) - r112) - 1];
        r113[r4] = r113[r4] ^ r19;
    L29:
        r112 = r112 + 1;
        goto L25
    L30:
        r110 = r110 + 1;
        goto L23
    L31:
        r2 = r2 + 1;
        goto L21
    L33:
        return new GF2Matrix(r5, r0);
    }
}
