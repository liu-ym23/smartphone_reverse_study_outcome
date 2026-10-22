package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;

/* JADX INFO: loaded from: classes7.dex */
public class SecT409Field {
    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        r7[4] = r5[4] ^ r6[4];
        r7[5] = r5[5] ^ r6[5];
        long r1 = r5[6];
        r7[6] = r6[6] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        int r0 = 0;
    L4:
        if (r0 >= 13) goto L6;
        r7[r0] = r5[r0] ^ r6[r0];
        r0 = r0 + 1;
        goto L4
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
        r6[2] = r5[2];
        r6[3] = r5[3];
        r6[4] = r5[4];
        r6[5] = r5[5];
        r6[6] = r5[6];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
        r6[2] = r6[2] ^ r5[2];
        r6[3] = r6[3] ^ r5[3];
        r6[4] = r6[4] ^ r5[4];
        r6[5] = r6[5] ^ r5[5];
        r6[6] = r6[6] ^ r5[6];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(409, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat.create64(13);
        Nat448.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 409) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r43) {
        long r1 = r43[0];
        long r4 = r43[1];
        long r7 = r43[2];
        long r10 = r43[3];
        long r13 = r43[4];
        long r16 = r43[5];
        long r19 = r43[6];
        long r22 = r43[7];
        long r25 = r43[8];
        long r28 = r43[9];
        long r31 = r43[10];
        long r34 = r43[11];
        long r37 = r43[12];
        long r39 = r43[13];
        r43[0] = r1 ^ (r4 << 59);
        r43[1] = (r4 >>> 5) ^ (r7 << 54);
        r43[2] = (r7 >>> 10) ^ (r10 << 49);
        r43[3] = (r10 >>> 15) ^ (r13 << 44);
        r43[4] = (r13 >>> 20) ^ (r16 << 39);
        r43[5] = (r16 >>> 25) ^ (r19 << 34);
        r43[6] = (r19 >>> 30) ^ (r22 << 29);
        r43[7] = (r22 >>> 35) ^ (r25 << 24);
        r43[8] = (r25 >>> 40) ^ (r28 << 19);
        r43[9] = (r28 >>> 45) ^ (r31 << 14);
        r43[10] = (r31 >>> 50) ^ (r34 << 9);
        r43[11] = ((r34 >>> 55) ^ (r37 << 4)) ^ (r39 << 63);
        r43[12] = r39 >>> 1;
    }

    public static void implExpand(long[] r25, long[] r26) {
        long r1 = r25[0];
        long r4 = r25[1];
        long r7 = r25[2];
        long r10 = r25[3];
        long r13 = r25[4];
        long r16 = r25[5];
        long r19 = r25[6];
        r26[0] = r1 & 576460752303423487L;
        r26[1] = ((r1 >>> 59) ^ (r4 << 5)) & 576460752303423487L;
        r26[2] = ((r4 >>> 54) ^ (r7 << 10)) & 576460752303423487L;
        r26[3] = ((r7 >>> 49) ^ (r10 << 15)) & 576460752303423487L;
        r26[4] = ((r10 >>> 44) ^ (r13 << 20)) & 576460752303423487L;
        r26[5] = ((r13 >>> 39) ^ (r16 << 25)) & 576460752303423487L;
        r26[6] = (r16 >>> 34) ^ (r19 << 30);
    }

    public static void implMultiply(long[] r23, long[] r24, long[] r25) {
        long[] r8 = new long[7];
        long[] r9 = new long[7];
        implExpand(r23, r8);
        implExpand(r24, r9);
        long[] r11 = new long[8];
        int r13 = 0;
    L3:
        if (r13 >= 7) goto L5;
        implMulwAcc(r11, r8[r13], r9[r13], r25, r13 << 1);
        r13 = r13 + 1;
        goto L3
    L5:
        long r0 = r25[0];
        long r2 = r25[1];
        long r1 = r0 ^ r25[2];
        r25[1] = r1 ^ r2;
        long r3 = r2 ^ r25[3];
        long r4 = r1 ^ r25[4];
        r25[2] = r4 ^ r3;
        long r5 = r3 ^ r25[5];
        long r6 = r4 ^ r25[6];
        r25[3] = r6 ^ r5;
        long r7 = r5 ^ r25[7];
        long r10 = r6 ^ r25[8];
        r25[4] = r10 ^ r7;
        long r12 = r7 ^ r25[9];
        long r14 = r10 ^ r25[10];
        r25[5] = r14 ^ r12;
        long r15 = r12 ^ r25[11];
        long r16 = r14 ^ r25[12];
        r25[6] = r16 ^ r15;
        long r17 = r16 ^ (r15 ^ r25[13]);
        r25[7] = r25[0] ^ r17;
        r25[8] = r25[1] ^ r17;
        r25[9] = r25[2] ^ r17;
        r25[10] = r25[3] ^ r17;
        r25[11] = r25[4] ^ r17;
        r25[12] = r25[5] ^ r17;
        r25[13] = r17 ^ r25[6];
        implMulwAcc(r11, r8[0] ^ r8[1], r9[0] ^ r9[1], r25, 1);
        implMulwAcc(r11, r8[0] ^ r8[2], r9[0] ^ r9[2], r25, 2);
        implMulwAcc(r11, r8[0] ^ r8[3], r9[0] ^ r9[3], r25, 3);
        implMulwAcc(r11, r8[1] ^ r8[2], r9[1] ^ r9[2], r25, 3);
        implMulwAcc(r11, r8[0] ^ r8[4], r9[0] ^ r9[4], r25, 4);
        implMulwAcc(r11, r8[1] ^ r8[3], r9[1] ^ r9[3], r25, 4);
        implMulwAcc(r11, r8[0] ^ r8[5], r9[0] ^ r9[5], r25, 5);
        implMulwAcc(r11, r8[1] ^ r8[4], r9[1] ^ r9[4], r25, 5);
        implMulwAcc(r11, r8[2] ^ r8[3], r9[2] ^ r9[3], r25, 5);
        implMulwAcc(r11, r8[0] ^ r8[6], r9[0] ^ r9[6], r25, 6);
        implMulwAcc(r11, r8[1] ^ r8[5], r9[1] ^ r9[5], r25, 6);
        implMulwAcc(r11, r8[2] ^ r8[4], r9[2] ^ r9[4], r25, 6);
        implMulwAcc(r11, r8[1] ^ r8[6], r9[1] ^ r9[6], r25, 7);
        implMulwAcc(r11, r8[2] ^ r8[5], r9[2] ^ r9[5], r25, 7);
        implMulwAcc(r11, r8[3] ^ r8[4], r9[3] ^ r9[4], r25, 7);
        implMulwAcc(r11, r8[2] ^ r8[6], r9[2] ^ r9[6], r25, 8);
        implMulwAcc(r11, r8[3] ^ r8[5], r9[3] ^ r9[5], r25, 8);
        implMulwAcc(r11, r8[3] ^ r8[6], r9[3] ^ r9[6], r25, 9);
        implMulwAcc(r11, r8[4] ^ r8[5], r9[4] ^ r9[5], r25, 9);
        implMulwAcc(r11, r8[4] ^ r8[6], r9[4] ^ r9[6], r25, 10);
        implMulwAcc(r11, r8[5] ^ r8[6], r9[5] ^ r9[6], r25, 11);
        implCompactExt(r25);
    }

    public static void implMulwAcc(long[] r16, long r17, long r19, long[] r21, int r22) {
        r16[1] = r19;
        r16[2] = r16[1] << 1;
        r16[3] = r16[2] ^ r19;
        r16[4] = r16[2] << 1;
        r16[5] = r16[4] ^ r19;
        r16[6] = r16[3] << 1;
        r16[7] = r16[6] ^ r19;
        int r3 = (int) r17;
        long r4 = (r16[(r3 >>> 3) & 7] << 3) ^ r16[r3 & 7];
        long r8 = 0;
        int r10 = 54;
    L3:
        int r11 = (int) (r17 >>> r10);
        long r12 = r16[r11 & 7] ^ (r16[(r11 >>> 3) & 7] << 3);
        r4 = r4 ^ (r12 << r10);
        r8 = r8 ^ (r12 >>> (-r10));
        r10 = r10 - 6;
        if (r10 > 0) goto L3;
        r21[r22] = r21[r22] ^ (576460752303423487L & r4);
        int r0 = r22 + 1;
        r21[r0] = r21[r0] ^ ((r4 >>> 59) ^ (r8 << 5));
    }

    public static void implSquare(long[] r2, long[] r3) {
        Interleave.expand64To128(r2, 0, 6, r3, 0);
        r3[12] = Interleave.expand32to64((int) r2[6]);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat448.isZero64(r3) == true) goto L7;
        long[] r0 = Nat448.create64();
        long[] r1 = Nat448.create64();
        long[] r2 = Nat448.create64();
        square(r3, r0);
        squareN(r0, 1, r1);
        multiply(r0, r1, r0);
        squareN(r1, 1, r1);
        multiply(r0, r1, r0);
        squareN(r0, 3, r1);
        multiply(r0, r1, r0);
        squareN(r0, 6, r1);
        multiply(r0, r1, r0);
        squareN(r0, 12, r1);
        multiply(r0, r1, r2);
        squareN(r2, 24, r0);
        squareN(r0, 24, r1);
        multiply(r0, r1, r0);
        squareN(r0, 48, r1);
        multiply(r0, r1, r0);
        squareN(r0, 96, r1);
        multiply(r0, r1, r0);
        squareN(r0, 192, r1);
        multiply(r0, r1, r0);
        multiply(r0, r2, r4);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat448.createExt64();
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat448.createExt64();
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void reduce(long[] r32, long[] r33) {
        long r1 = r32[0];
        long r4 = r32[1];
        long r7 = r32[2];
        long r10 = r32[3];
        long r13 = r32[4];
        long r16 = r32[5];
        long r19 = r32[6];
        long r21 = r32[7];
        long r23 = r32[12];
        long r17 = r16 ^ (r23 << 39);
        long r110 = r19 ^ ((r23 >>> 25) ^ (r23 << 62));
        long r22 = r21 ^ (r23 >>> 2);
        long r24 = r32[11];
        long r14 = r13 ^ (r24 << 39);
        long r18 = r17 ^ ((r24 >>> 25) ^ (r24 << 62));
        long r111 = r110 ^ (r24 >>> 2);
        long r25 = r32[10];
        long r11 = r10 ^ (r25 << 39);
        long r15 = r14 ^ ((r25 >>> 25) ^ (r25 << 62));
        long r112 = r18 ^ (r25 >>> 2);
        long r26 = r32[9];
        long r8 = r7 ^ (r26 << 39);
        long r12 = r11 ^ ((r26 >>> 25) ^ (r26 << 62));
        long r113 = r15 ^ (r26 >>> 2);
        long r27 = r32[8];
        long r5 = r4 ^ (r27 << 39);
        long r9 = r8 ^ ((r27 >>> 25) ^ (r27 << 62));
        long r114 = r12 ^ (r27 >>> 2);
        long r2 = r1 ^ (r22 << 39);
        long r6 = r5 ^ ((r22 >>> 25) ^ (r22 << 62));
        long r20 = r9 ^ (r22 >>> 2);
        long r28 = r111 >>> 25;
        r33[0] = r2 ^ r28;
        r33[1] = (r28 << 23) ^ r6;
        r33[2] = r20;
        r33[3] = r114;
        r33[4] = r113;
        r33[5] = r112;
        r33[6] = r111 & 33554431;
    }

    public static void sqrt(long[] r27, long[] r28) {
        long r1 = Interleave.unshuffle(r27[0]);
        long r4 = Interleave.unshuffle(r27[1]);
        long r8 = (r1 & 4294967295L) | (r4 << 32);
        long r2 = (r1 >>> 32) | (r4 & (-4294967296L));
        long r13 = Interleave.unshuffle(r27[2]);
        long r15 = Interleave.unshuffle(r27[3]);
        long r17 = (r13 & 4294967295L) | (r15 << 32);
        long r14 = (r13 >>> 32) | (r15 & (-4294967296L));
        long r19 = Interleave.unshuffle(r27[4]);
        long r21 = Interleave.unshuffle(r27[5]);
        long r23 = (r19 & 4294967295L) | (r21 << 32);
        long r11 = (r19 >>> 32) | (r21 & (-4294967296L));
        long r20 = Interleave.unshuffle(r27[6]);
        long r6 = r20 & 4294967295L;
        long r22 = r20 >>> 32;
        r28[0] = r8 ^ (r2 << 44);
        r28[1] = (r17 ^ (r14 << 44)) ^ (r2 >>> 20);
        r28[2] = (r23 ^ (r11 << 44)) ^ (r14 >>> 20);
        r28[3] = (((r22 << 44) ^ r6) ^ (r11 >>> 20)) ^ (r2 << 13);
        long r3 = r2 >>> 51;
        r28[4] = r3 ^ ((r22 >>> 20) ^ (r14 << 13));
        r28[5] = (r11 << 13) ^ (r14 >>> 51);
        r28[6] = (r22 << 13) ^ (r11 >>> 51);
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat.create64(13);
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat.create64(13);
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat.create64(13);
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
