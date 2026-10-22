package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes7.dex */
public class SecT233Field {
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
        r7[6] = r5[6] ^ r6[6];
        long r1 = r5[7];
        r7[7] = r6[7] ^ r1;
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
        return Nat.fromBigInteger64(233, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat256.createExt64();
        Nat256.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 233) goto L6;
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
        r26[0] = r1 ^ (r4 << 59);
        r26[1] = (r4 >>> 5) ^ (r7 << 54);
        r26[2] = (r7 >>> 10) ^ (r10 << 49);
        r26[3] = (r10 >>> 15) ^ (r13 << 44);
        r26[4] = (r13 >>> 20) ^ (r16 << 39);
        r26[5] = (r16 >>> 25) ^ (r19 << 34);
        r26[6] = (r19 >>> 30) ^ (r22 << 29);
        r26[7] = r22 >>> 35;
    }

    public static void implExpand(long[] r16, long[] r17) {
        long r1 = r16[0];
        long r4 = r16[1];
        long r7 = r16[2];
        long r10 = r16[3];
        r17[0] = r1 & 576460752303423487L;
        r17[1] = ((r1 >>> 59) ^ (r4 << 5)) & 576460752303423487L;
        r17[2] = ((r4 >>> 54) ^ (r7 << 10)) & 576460752303423487L;
        r17[3] = (r7 >>> 49) ^ (r10 << 15);
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
        Interleave.expand64To128(r2, 0, 4, r3, 0);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat256.isZero64(r3) == true) goto L7;
        long[] r0 = Nat256.create64();
        long[] r1 = Nat256.create64();
        square(r3, r0);
        multiply(r0, r3, r0);
        square(r0, r0);
        multiply(r0, r3, r0);
        squareN(r0, 3, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 7, r0);
        multiply(r0, r1, r0);
        squareN(r0, 14, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 29, r0);
        multiply(r0, r1, r0);
        squareN(r0, 58, r1);
        multiply(r1, r0, r1);
        squareN(r1, 116, r0);
        multiply(r0, r1, r0);
        square(r0, r4);
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

    public static void reduce(long[] r27, long[] r28) {
        long r1 = r27[0];
        long r4 = r27[1];
        long r7 = r27[2];
        long r10 = r27[3];
        long r12 = r27[4];
        long r14 = r27[5];
        long r16 = r27[6];
        long r18 = r27[7];
        long r11 = r10 ^ (r18 << 23);
        long r13 = r12 ^ ((r18 >>> 41) ^ (r18 << 33));
        long r15 = r14 ^ (r18 >>> 31);
        long r8 = r7 ^ (r16 << 23);
        long r17 = r11 ^ ((r16 >>> 41) ^ (r16 << 33));
        long r19 = r13 ^ (r16 >>> 31);
        long r5 = r4 ^ (r15 << 23);
        long r9 = r8 ^ ((r15 >>> 41) ^ (r15 << 33));
        long r110 = r17 ^ (r15 >>> 31);
        long r2 = r1 ^ (r19 << 23);
        long r6 = r5 ^ ((r19 >>> 41) ^ (r19 << 33));
        long r20 = r9 ^ (r19 >>> 31);
        long r111 = r110 >>> 41;
        r28[0] = r2 ^ r111;
        r28[1] = (r111 << 10) ^ r6;
        r28[2] = r20;
        r28[3] = 2199023255551L & r110;
    }

    public static void sqrt(long[] r25, long[] r26) {
        long r2 = Interleave.unshuffle(r25[0]);
        long r5 = Interleave.unshuffle(r25[1]);
        long r9 = (r2 & 4294967295L) | (r5 << 32);
        long r3 = (r2 >>> 32) | (r5 & (-4294967296L));
        long r6 = Interleave.unshuffle(r25[2]);
        int r14 = 3;
        long r15 = Interleave.unshuffle(r25[3]);
        long r7 = (4294967295L & r6) | (r15 << 32);
        long r8 = (r6 >>> 32) | (r15 & (-4294967296L));
        long r12 = r8 >>> 27;
        long r10 = r8 ^ ((r3 >>> 27) | (r8 << 37));
        long r4 = r3 ^ (r3 << 37);
        long[] r11 = Nat256.createExt64();
        int[] r16 = {32, 117, 191};
        int r13 = 0;
    L3:
        if (r13 >= r14) goto L5;
        int r17 = r16[r13] >>> 6;
        int r1 = r16[r13] & 63;
        r11[r17] = r11[r17] ^ (r4 << r1);
        int r18 = r17 + 1;
        int r19 = -r1;
        r11[r18] = r11[r18] ^ ((r10 << r1) | (r4 >>> r19));
        int r110 = r17 + 2;
        r11[r110] = r11[r110] ^ ((r12 << r1) | (r10 >>> r19));
        int r111 = r17 + 3;
        r11[r111] = r11[r111] ^ (r12 >>> r19);
        r13 = r13 + 1;
        r14 = 3;
        goto L3
    L5:
        reduce(r11, r26);
        r26[0] = r26[0] ^ r9;
        r26[1] = r26[1] ^ r7;
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

    public static int trace(long[] r4) {
        return ((int) (r4[0] ^ (r4[2] >>> 31))) & 1;
    }
}
