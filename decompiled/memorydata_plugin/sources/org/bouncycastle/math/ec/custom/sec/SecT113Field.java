package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;

/* JADX INFO: loaded from: classes7.dex */
public class SecT113Field {
    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        long r1 = r5[1];
        r7[1] = r6[1] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        long r1 = r5[3];
        r7[3] = r6[3] ^ r1;
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(113, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat128.createExt64();
        Nat128.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 113) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implMultiply(long[] r21, long[] r22, long[] r23) {
        long r0 = r21[0];
        long r2 = r21[1] << 7;
        long r11 = (r2 ^ (r0 >>> 57)) & 144115188075855871L;
        long r13 = r0 & 144115188075855871L;
        long r1 = r22[0];
        long r3 = r22[1] << 7;
        long r15 = (r3 ^ (r1 >>> 57)) & 144115188075855871L;
        long r17 = r1 & 144115188075855871L;
        long[] r6 = new long[6];
        implMulw(r23, r13, r17, r6, 0);
        implMulw(r23, r11, r15, r6, 2);
        implMulw(r23, r13 ^ r11, r17 ^ r15, r6, 4);
        long r4 = r6[1] ^ r6[2];
        long r5 = r6[0];
        long r12 = r6[3];
        long r14 = (r6[4] ^ r5) ^ r4;
        long r7 = r4 ^ (r6[5] ^ r12);
        r23[0] = r5 ^ (r14 << 57);
        r23[1] = (r14 >>> 7) ^ (r7 << 50);
        r23[2] = (r7 >>> 14) ^ (r12 << 43);
        r23[3] = r12 >>> 21;
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
        Interleave.expand64To128(r2, 0, 2, r3, 0);
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat128.isZero64(r3) == true) goto L7;
        long[] r0 = Nat128.create64();
        long[] r1 = Nat128.create64();
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
        squareN(r1, 28, r0);
        multiply(r0, r1, r0);
        squareN(r0, 56, r1);
        multiply(r1, r0, r1);
        square(r1, r4);
        return;
    L7:
        throw new IllegalStateException();
    }

    public static void multiply(long[] r1, long[] r2, long[] r3) {
        long[] r0 = new long[8];
        implMultiply(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(long[] r1, long[] r2, long[] r3) {
        long[] r0 = new long[8];
        implMultiply(r1, r2, r0);
        addExt(r3, r0, r3);
    }

    public static void reduce(long[] r16, long[] r17) {
        long r1 = r16[0];
        long r4 = r16[1];
        long r6 = r16[2];
        long r8 = r16[3];
        long r5 = r4 ^ ((r8 << 15) ^ (r8 << 24));
        long r14 = r8 >>> 49;
        long r7 = r6 ^ ((r8 >>> 40) ^ r14);
        long r2 = r1 ^ ((r7 << 15) ^ (r7 << 24));
        long r9 = r7 >>> 49;
        long r10 = r5 ^ ((r7 >>> 40) ^ r9);
        long r11 = r10 >>> 49;
        r17[0] = (r2 ^ r11) ^ (r11 << 9);
        r17[1] = 562949953421311L & r10;
    }

    public static void sqrt(long[] r10, long[] r11) {
        long r1 = Interleave.unshuffle(r10[0]);
        long r4 = Interleave.unshuffle(r10[1]);
        long r6 = (4294967295L & r1) | (r4 << 32);
        long r2 = (r1 >>> 32) | (r4 & (-4294967296L));
        r11[0] = ((r2 << 57) ^ r6) ^ (r2 << 5);
        long r0 = r2 >>> 59;
        r11[1] = r0 ^ (r2 >>> 7);
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat128.createExt64();
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat128.createExt64();
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat128.createExt64();
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
