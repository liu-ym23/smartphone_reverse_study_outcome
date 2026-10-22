package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes7.dex */
public class SecT193Field {
    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        long r1 = r5[3];
        r7[3] = r6[3] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        r7[4] = r5[4] ^ r6[4];
        r7[5] = r5[5] ^ r6[5];
        long r1 = r5[6];
        r7[6] = r6[6] ^ r1;
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
        r6[2] = r5[2];
        r6[3] = r5[3];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
        r6[2] = r6[2] ^ r5[2];
        r6[3] = r6[3] ^ r5[3];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(193, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat256.createExt64();
        Nat256.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 193) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r26) {
        long r1 = r26[0];
        long r4 = r26[1];
        long r7 = r26[2];
        long r10 = r26[3];
        long r13 = r26[4];
        long r16 = r26[5];
        long r19 = r26[6];
        long r22 = r26[7];
        r26[0] = r1 ^ (r4 << 49);
        r26[1] = (r4 >>> 15) ^ (r7 << 34);
        r26[2] = (r7 >>> 30) ^ (r10 << 19);
        r26[3] = ((r10 >>> 45) ^ (r13 << 4)) ^ (r16 << 53);
        r26[4] = ((r13 >>> 60) ^ (r19 << 38)) ^ (r16 >>> 11);
        r26[5] = (r19 >>> 26) ^ (r22 << 23);
        r26[6] = r22 >>> 41;
        r26[7] = 0;
    }

    public static void implExpand(long[] r16, long[] r17) {
        long r1 = r16[0];
        long r4 = r16[1];
        long r7 = r16[2];
        long r10 = r16[3];
        r17[0] = r1 & 562949953421311L;
        r17[1] = ((r1 >>> 49) ^ (r4 << 15)) & 562949953421311L;
        r17[2] = ((r4 >>> 34) ^ (r7 << 30)) & 562949953421311L;
        r17[3] = (r7 >>> 19) ^ (r10 << 45);
    }

    public static void implMultiply(long[] r24, long[] r25, long[] r26) {
        long[] r8 = new long[4];
        long[] r9 = new long[4];
        implExpand(r24, r8);
        implExpand(r25, r9);
        long[] r15 = new long[8];
        implMulwAcc(r15, r8[0], r9[0], r26, 0);
        implMulwAcc(r15, r8[1], r9[1], r26, 1);
        implMulwAcc(r15, r8[2], r9[2], r26, 2);
        implMulwAcc(r15, r8[3], r9[3], r26, 3);
        int r0 = 5;
    L3:
        if (r0 <= 0) goto L5;
        r26[r0] = r26[r0] ^ r26[r0 - 1];
        r0 = r0 - 1;
        goto L3
    L5:
        implMulwAcc(r15, r8[0] ^ r8[1], r9[0] ^ r9[1], r26, 1);
        implMulwAcc(r15, r8[2] ^ r8[3], r9[2] ^ r9[3], r26, 3);
        int r1 = 7;
    L6:
        if (r1 <= 1) goto L8;
        r26[r1] = r26[r1] ^ r26[r1 - 2];
        r1 = r1 - 1;
        goto L6
    L8:
        long r11 = r8[0] ^ r8[2];
        long r20 = r8[1] ^ r8[3];
        long r22 = r9[0] ^ r9[2];
        long r10 = r9[1] ^ r9[3];
        implMulwAcc(r15, r11 ^ r20, r22 ^ r10, r26, 3);
        long[] r2 = new long[3];
        implMulwAcc(r15, r11, r22, r2, 0);
        implMulwAcc(r15, r20, r10, r2, 1);
        long r3 = r2[0];
        long r5 = r2[1];
        long r12 = r2[2];
        r26[2] = r26[2] ^ r3;
        r26[3] = (r3 ^ r5) ^ r26[3];
        r26[4] = r26[4] ^ (r12 ^ r5);
        r26[5] = r26[5] ^ r12;
        implCompactExt(r26);
    }

    public static void implMulwAcc(long[] r17, long r18, long r20, long[] r22, int r23) {
        r17[1] = r20;
        r17[2] = r17[1] << 1;
        r17[3] = r17[2] ^ r20;
        r17[4] = r17[2] << 1;
        r17[5] = r17[4] ^ r20;
        r17[6] = r17[3] << 1;
        r17[7] = r17[6] ^ r20;
        int r3 = (int) r18;
        long r4 = (r17[(r3 >>> 3) & 7] << 3) ^ r17[r3 & 7];
        long r8 = 0;
        int r10 = 36;
    L3:
        int r11 = (int) (r18 >>> r10);
        long r12 = (((r17[r11 & 7] ^ (r17[(r11 >>> 3) & 7] << 3)) ^ (r17[(r11 >>> 6) & 7] << 6)) ^ (r17[(r11 >>> 9) & 7] << 9)) ^ (r17[(r11 >>> 12) & 7] << 12);
        r4 = r4 ^ (r12 << r10);
        r8 = r8 ^ (r12 >>> (-r10));
        r10 = r10 - 15;
        if (r10 > 0) goto L3;
        r22[r23] = r22[r23] ^ (562949953421311L & r4);
        int r0 = r23 + 1;
        r22[r0] = r22[r0] ^ ((r4 >>> 49) ^ (r8 << 15));
    }

    public static void implSquare(long[] r4, long[] r5) {
        Interleave.expand64To128(r4, 0, 3, r5, 0);
        r5[6] = r4[3] & 1;
    }

    public static void invert(long[] r2, long[] r3) {
        if (Nat256.isZero64(r2) == true) goto L7;
        long[] r0 = Nat256.create64();
        long[] r1 = Nat256.create64();
        square(r2, r0);
        squareN(r0, 1, r1);
        multiply(r0, r1, r0);
        squareN(r1, 1, r1);
        multiply(r0, r1, r0);
        squareN(r0, 3, r1);
        multiply(r0, r1, r0);
        squareN(r0, 6, r1);
        multiply(r0, r1, r0);
        squareN(r0, 12, r1);
        multiply(r0, r1, r0);
        squareN(r0, 24, r1);
        multiply(r0, r1, r0);
        squareN(r0, 48, r1);
        multiply(r0, r1, r0);
        squareN(r0, 96, r1);
        multiply(r0, r1, r3);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void reduce(long[] r24, long[] r25) {
        long r1 = r24[0];
        long r4 = r24[1];
        long r7 = r24[2];
        long r10 = r24[3];
        long r12 = r24[4];
        long r14 = r24[5];
        long r16 = r24[6];
        long r8 = r7 ^ (r16 << 63);
        long r11 = r10 ^ ((r16 >>> 1) ^ (r16 << 14));
        long r13 = r12 ^ (r16 >>> 50);
        long r5 = r4 ^ (r14 << 63);
        long r9 = r8 ^ ((r14 >>> 1) ^ (r14 << 14));
        long r15 = r11 ^ (r14 >>> 50);
        long r2 = r1 ^ (r13 << 63);
        long r6 = r5 ^ ((r13 >>> 1) ^ (r13 << 14));
        long r17 = r9 ^ (r13 >>> 50);
        long r18 = r15 >>> 1;
        r25[0] = (r2 ^ r18) ^ (r18 << 15);
        r25[1] = (r18 >>> 49) ^ r6;
        r25[2] = r17;
        r25[3] = 1 & r15;
    }

    public static void sqrt(long[] r15, long[] r16) {
        long r1 = Interleave.unshuffle(r15[0]);
        long r4 = Interleave.unshuffle(r15[1]);
        long r8 = (r1 & 4294967295L) | (r4 << 32);
        long r2 = (r1 >>> 32) | (r4 & (-4294967296L));
        long r11 = Interleave.unshuffle(r15[2]);
        long r5 = (r11 & 4294967295L) ^ (r15[3] << 32);
        long r10 = r11 >>> 32;
        r16[0] = r8 ^ (r2 << 8);
        r16[1] = ((r5 ^ (r10 << 8)) ^ (r2 >>> 56)) ^ (r2 << 33);
        long r3 = r2 >>> 31;
        r16[2] = r3 ^ ((r10 >>> 56) ^ (r10 << 33));
        r16[3] = r10 >>> 31;
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat256.createExt64();
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r2) {
        return ((int) r2[0]) & 1;
    }
}
