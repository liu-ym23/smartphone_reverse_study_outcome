package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;

/* JADX INFO: loaded from: classes7.dex */
public class SecT283Field {
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};
    }

    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        long r1 = r5[4];
        r7[4] = r6[4] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        r7[4] = r5[4] ^ r6[4];
        r7[5] = r5[5] ^ r6[5];
        r7[6] = r5[6] ^ r6[6];
        r7[7] = r5[7] ^ r6[7];
        long r1 = r5[8];
        r7[8] = r6[8] ^ r1;
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
        r6[2] = r5[2];
        r6[3] = r5[3];
        r6[4] = r5[4];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
        r6[2] = r6[2] ^ r5[2];
        r6[3] = r6[3] ^ r5[3];
        r6[4] = r6[4] ^ r5[4];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(283, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat.create64(9);
        Nat320.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 283) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r32) {
        long r1 = r32[0];
        long r4 = r32[1];
        long r7 = r32[2];
        long r10 = r32[3];
        long r13 = r32[4];
        long r16 = r32[5];
        long r19 = r32[6];
        long r22 = r32[7];
        long r25 = r32[8];
        long r28 = r32[9];
        r32[0] = r1 ^ (r4 << 57);
        r32[1] = (r4 >>> 7) ^ (r7 << 50);
        r32[2] = (r7 >>> 14) ^ (r10 << 43);
        r32[3] = (r10 >>> 21) ^ (r13 << 36);
        r32[4] = (r13 >>> 28) ^ (r16 << 29);
        r32[5] = (r16 >>> 35) ^ (r19 << 22);
        r32[6] = (r19 >>> 42) ^ (r22 << 15);
        r32[7] = (r22 >>> 49) ^ (r25 << 8);
        r32[8] = (r25 >>> 56) ^ (r28 << 1);
        r32[9] = r28 >>> 63;
    }

    public static void implExpand(long[] r19, long[] r20) {
        long r1 = r19[0];
        long r4 = r19[1];
        long r7 = r19[2];
        long r10 = r19[3];
        long r13 = r19[4];
        r20[0] = r1 & 144115188075855871L;
        r20[1] = ((r1 >>> 57) ^ (r4 << 7)) & 144115188075855871L;
        r20[2] = ((r4 >>> 50) ^ (r7 << 14)) & 144115188075855871L;
        r20[3] = ((r7 >>> 43) ^ (r10 << 21)) & 144115188075855871L;
        r20[4] = (r10 >>> 36) ^ (r13 << 28);
    }

    public static void implMultiply(long[] r34, long[] r35, long[] r36) {
        long[] r8 = new long[5];
        long[] r9 = new long[5];
        implExpand(r34, r8);
        implExpand(r35, r9);
        long[] r10 = new long[26];
        implMulw(r36, r8[0], r9[0], r10, 0);
        implMulw(r36, r8[1], r9[1], r10, 2);
        implMulw(r36, r8[2], r9[2], r10, 4);
        implMulw(r36, r8[3], r9[3], r10, 6);
        implMulw(r36, r8[4], r9[4], r10, 8);
        long r16 = r8[0] ^ r8[1];
        long r18 = r9[0] ^ r9[1];
        long r20 = r8[0] ^ r8[2];
        long r22 = r9[0] ^ r9[2];
        long r24 = r8[2] ^ r8[4];
        long r26 = r9[2] ^ r9[4];
        long r28 = r8[3] ^ r8[4];
        long r30 = r9[3] ^ r9[4];
        implMulw(r36, r20 ^ r8[3], r22 ^ r9[3], r10, 18);
        implMulw(r36, r24 ^ r8[1], r26 ^ r9[1], r10, 20);
        long r1 = r16 ^ r28;
        long r3 = r18 ^ r30;
        long r32 = r1 ^ r8[2];
        long r11 = r3 ^ r9[2];
        implMulw(r36, r1, r3, r10, 22);
        implMulw(r36, r32, r11, r10, 24);
        implMulw(r36, r16, r18, r10, 10);
        implMulw(r36, r20, r22, r10, 12);
        implMulw(r36, r24, r26, r10, 14);
        implMulw(r36, r28, r30, r10, 16);
        r36[0] = r10[0];
        r36[9] = r10[9];
        long r2 = r10[0] ^ r10[1];
        long r4 = r10[2] ^ r2;
        long r5 = r10[10] ^ r4;
        r36[1] = r5;
        long r12 = r10[3] ^ r10[4];
        long r6 = r4 ^ (r12 ^ (r10[11] ^ r10[12]));
        r36[2] = r6;
        long r7 = r2 ^ r12;
        long r13 = r10[5] ^ r10[6];
        long r14 = (r7 ^ r13) ^ r10[8];
        long r17 = r10[13] ^ r10[14];
        r36[3] = (r14 ^ r17) ^ ((r10[18] ^ r10[22]) ^ r10[24]);
        long r19 = (r10[7] ^ r10[8]) ^ r10[9];
        long r21 = r19 ^ r10[17];
        r36[8] = r21;
        long r15 = (r19 ^ r13) ^ (r10[15] ^ r10[16]);
        r36[7] = r15;
        long r23 = r5 ^ r15;
        long r25 = r10[19] ^ r10[20];
        long r110 = r10[25] ^ r10[24];
        long r27 = r25 ^ r110;
        r36[4] = (r27 ^ (r10[18] ^ r10[23])) ^ r23;
        r36[5] = ((r6 ^ r21) ^ r27) ^ (r10[21] ^ r10[22]);
        r36[6] = (((((r14 ^ r10[0]) ^ r10[9]) ^ r17) ^ r10[21]) ^ r10[23]) ^ r10[25];
        implCompactExt(r36);
    }

    public static void implMulw(long[] r16, long r17, long r19, long[] r21, int r22) {
        r16[1] = r19;
        r16[2] = r16[1] << 1;
        r16[3] = r16[2] ^ r19;
        r16[4] = r16[2] << 1;
        r16[5] = r16[4] ^ r19;
        r16[6] = r16[3] << 1;
        r16[7] = r16[6] ^ r19;
        long r3 = r16[((int) r17) & 7];
        long r8 = 0;
        int r10 = 48;
    L3:
        int r11 = (int) (r17 >>> r10);
        long r12 = (r16[r11 & 7] ^ (r16[(r11 >>> 3) & 7] << 3)) ^ (r16[(r11 >>> 6) & 7] << 6);
        r3 = r3 ^ (r12 << r10);
        r8 = r8 ^ (r12 >>> (-r10));
        r10 = r10 - 9;
        if (r10 > 0) goto L3;
        r21[r22] = 144115188075855871L & r3;
        r21[r22 + 1] = (((((r17 & 72198606942111744L) & ((r19 << 7) >> 63)) >>> 8) ^ r8) << 7) ^ (r3 >>> 57);
    }

    public static void implSquare(long[] r2, long[] r3) {
        Interleave.expand64To128(r2, 0, 4, r3, 0);
        r3[8] = Interleave.expand32to64((int) r2[4]);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat320.isZero64(r3) == true) goto L7;
        long[] r0 = Nat320.create64();
        long[] r1 = Nat320.create64();
        square(r3, r0);
        multiply(r0, r3, r0);
        squareN(r0, 2, r1);
        multiply(r1, r0, r1);
        squareN(r1, 4, r0);
        multiply(r0, r1, r0);
        squareN(r0, 8, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 17, r0);
        multiply(r0, r1, r0);
        square(r0, r0);
        multiply(r0, r3, r0);
        squareN(r0, 35, r1);
        multiply(r1, r0, r1);
        squareN(r1, 70, r0);
        multiply(r0, r1, r0);
        square(r0, r0);
        multiply(r0, r3, r0);
        squareN(r0, 141, r1);
        multiply(r1, r0, r1);
        square(r1, r4);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat320.createExt64();
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = Nat320.createExt64();
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void reduce(long[] r36, long[] r37) {
        long r1 = r36[0];
        long r4 = r36[1];
        long r7 = r36[2];
        long r10 = r36[3];
        long r13 = r36[4];
        long r16 = r36[5];
        long r18 = r36[6];
        long r21 = r36[7];
        long r23 = r36[8];
        long r11 = r10 ^ ((((r23 << 37) ^ (r23 << 42)) ^ (r23 << 44)) ^ (r23 << 49));
        long r14 = r13 ^ ((((r23 >>> 27) ^ (r23 >>> 22)) ^ (r23 >>> 20)) ^ (r23 >>> 15));
        long r8 = r7 ^ ((((r21 << 37) ^ (r21 << 42)) ^ (r21 << 44)) ^ (r21 << 49));
        long r12 = r11 ^ ((((r21 >>> 27) ^ (r21 >>> 22)) ^ (r21 >>> 20)) ^ (r21 >>> 15));
        long r5 = r4 ^ ((((r18 << 37) ^ (r18 << 42)) ^ (r18 << 44)) ^ (r18 << 49));
        long r9 = r8 ^ ((((r18 >>> 27) ^ (r18 >>> 22)) ^ (r18 >>> 20)) ^ (r18 >>> 15));
        long r2 = r1 ^ ((((r16 << 37) ^ (r16 << 42)) ^ (r16 << 44)) ^ (r16 << 49));
        long r6 = r5 ^ ((((r16 >>> 27) ^ (r16 >>> 22)) ^ (r16 >>> 20)) ^ (r16 >>> 15));
        long r17 = r14 >>> 27;
        r37[0] = (((r2 ^ r17) ^ (r17 << 5)) ^ (r17 << 7)) ^ (r17 << 12);
        r37[1] = r6;
        r37[2] = r9;
        r37[3] = r12;
        r37[4] = 134217727 & r14;
    }

    public static void sqrt(long[] r21, long[] r22) {
        long[] r1 = Nat320.create64();
        long r3 = Interleave.unshuffle(r21[0]);
        long r6 = Interleave.unshuffle(r21[1]);
        long r10 = (r3 & 4294967295L) | (r6 << 32);
        r1[0] = (r3 >>> 32) | (r6 & (-4294967296L));
        long r7 = Interleave.unshuffle(r21[2]);
        long r15 = Interleave.unshuffle(r21[3]);
        long r17 = (r7 & 4294967295L) | (r15 << 32);
        r1[1] = (r7 >>> 32) | ((-4294967296L) & r15);
        long r8 = Interleave.unshuffle(r21[4]);
        long r9 = 4294967295L & r8;
        r1[2] = r8 >>> 32;
        multiply(r1, ROOT_Z, r22);
        r22[0] = r22[0] ^ r10;
        r22[1] = r22[1] ^ r17;
        r22[2] = r22[2] ^ r9;
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat.create64(9);
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat.create64(9);
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat.create64(9);
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r4) {
        return ((int) (r4[0] ^ (r4[4] >>> 15))) & 1;
    }
}
