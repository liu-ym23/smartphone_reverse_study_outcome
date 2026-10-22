package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes7.dex */
public class SecT163Field {
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{-5270498306774157648L, 5270498306774195053L, 19634136210L};
    }

    public static void add(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        long r1 = r5[2];
        r7[2] = r6[2] ^ r1;
    }

    public static void addExt(long[] r5, long[] r6, long[] r7) {
        r7[0] = r5[0] ^ r6[0];
        r7[1] = r5[1] ^ r6[1];
        r7[2] = r5[2] ^ r6[2];
        r7[3] = r5[3] ^ r6[3];
        r7[4] = r5[4] ^ r6[4];
        long r1 = r5[5];
        r7[5] = r6[5] ^ r1;
    }

    public static void addOne(long[] r5, long[] r6) {
        r6[0] = r5[0] ^ 1;
        r6[1] = r5[1];
        r6[2] = r5[2];
    }

    private static void addTo(long[] r5, long[] r6) {
        r6[0] = r6[0] ^ r5[0];
        r6[1] = r6[1] ^ r5[1];
        r6[2] = r6[2] ^ r5[2];
    }

    public static long[] fromBigInteger(BigInteger r1) {
        return Nat.fromBigInteger64(163, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat192.createExt64();
        Nat192.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 163) goto L6;
        implSquare(r4, r0);
        reduce(r0, r4);
        implSquare(r4, r0);
        reduce(r0, r4);
        addTo(r3, r4);
        r1 = r1 + 2;
        goto L4
    }

    public static void implCompactExt(long[] r20) {
        long r1 = r20[0];
        long r4 = r20[1];
        long r7 = r20[2];
        long r10 = r20[3];
        long r13 = r20[4];
        long r16 = r20[5];
        r20[0] = r1 ^ (r4 << 55);
        r20[1] = (r4 >>> 9) ^ (r7 << 46);
        r20[2] = (r7 >>> 18) ^ (r10 << 37);
        r20[3] = (r10 >>> 27) ^ (r13 << 28);
        r20[4] = (r13 >>> 36) ^ (r16 << 19);
        r20[5] = r16 >>> 45;
    }

    public static void implMultiply(long[] r31, long[] r32, long[] r33) {
        long r0 = r31[0];
        long r2 = r31[1];
        long r10 = (r2 >>> 46) ^ (r31[2] << 18);
        long r3 = r2 << 9;
        long r17 = (r3 ^ (r0 >>> 55)) & 36028797018963967L;
        long r19 = r0 & 36028797018963967L;
        long r1 = r32[0];
        long r4 = r32[1];
        long r21 = (r4 >>> 46) ^ (r32[2] << 18);
        long r5 = r4 << 9;
        long r23 = (r5 ^ (r1 >>> 55)) & 36028797018963967L;
        long r25 = r1 & 36028797018963967L;
        long[] r12 = new long[10];
        implMulw(r33, r19, r25, r12, 0);
        implMulw(r33, r10, r21, r12, 2);
        long r27 = (r19 ^ r17) ^ r10;
        long r29 = (r25 ^ r23) ^ r21;
        implMulw(r33, r27, r29, r12, 4);
        long r11 = (r17 << 1) ^ (r10 << 2);
        long r18 = (r23 << 1) ^ (r21 << 2);
        implMulw(r33, r19 ^ r11, r25 ^ r18, r12, 6);
        implMulw(r33, r27 ^ r11, r29 ^ r18, r12, 8);
        long r6 = r12[6] ^ r12[8];
        long r7 = r12[7] ^ r12[9];
        long r13 = (r6 << 1) ^ r12[6];
        long r8 = (r6 ^ (r7 << 1)) ^ r12[7];
        long r110 = r12[0];
        long r111 = (r12[1] ^ r12[0]) ^ r12[4];
        long r22 = r12[1] ^ r12[5];
        long r14 = ((r110 ^ r13) ^ (r12[2] << 4)) ^ (r12[2] << 1);
        long r9 = (((r111 ^ r8) ^ (r12[3] << 4)) ^ (r12[3] << 1)) ^ (r14 >>> 55);
        long r15 = (r22 ^ r7) ^ (r9 >>> 55);
        long r16 = r9 & 36028797018963967L;
        long r112 = ((r14 & 36028797018963967L) >>> 1) ^ ((r16 & 1) << 54);
        long r20 = (r16 >>> 1) ^ ((r15 & 1) << 54);
        long r113 = r112 ^ (r112 << 1);
        long r114 = r113 ^ (r113 << 2);
        long r115 = r114 ^ (r114 << 4);
        long r116 = r115 ^ (r115 << 8);
        long r117 = r116 ^ (r116 << 16);
        long r118 = (r117 ^ (r117 << 32)) & 36028797018963967L;
        long r24 = r20 ^ (r118 >>> 54);
        long r26 = r24 ^ (r24 << 1);
        long r28 = r26 ^ (r26 << 2);
        long r30 = r28 ^ (r28 << 4);
        long r34 = r30 ^ (r30 << 8);
        long r35 = r34 ^ (r34 << 16);
        long r36 = (r35 ^ (r35 << 32)) & 36028797018963967L;
        long r37 = (r15 >>> 1) ^ (r36 >>> 54);
        long r38 = r37 ^ (r37 << 1);
        long r39 = r38 ^ (r38 << 2);
        long r40 = r39 ^ (r39 << 4);
        long r41 = r40 ^ (r40 << 8);
        long r42 = r41 ^ (r41 << 16);
        long r43 = r42 ^ (r42 << 32);
        r33[0] = r110;
        r33[1] = (r111 ^ r118) ^ r12[2];
        r33[2] = ((r22 ^ r36) ^ r118) ^ r12[3];
        r33[3] = r36 ^ r43;
        r33[4] = r12[2] ^ r43;
        r33[5] = r12[3];
        implCompactExt(r33);
    }

    public static void implMulw(long[] r16, long r17, long r19, long[] r21, int r22) {
        r16[1] = r19;
        r16[2] = r16[1] << 1;
        r16[3] = r16[2] ^ r19;
        r16[4] = r16[2] << 1;
        r16[5] = r16[4] ^ r19;
        r16[6] = r16[3] << 1;
        r16[7] = r16[6] ^ r19;
        long r3 = r16[((int) r17) & 3];
        long r8 = 0;
        int r10 = 47;
    L3:
        int r11 = (int) (r17 >>> r10);
        long r12 = (r16[r11 & 7] ^ (r16[(r11 >>> 3) & 7] << 3)) ^ (r16[(r11 >>> 6) & 7] << 6);
        r3 = r3 ^ (r12 << r10);
        r8 = r8 ^ (r12 >>> (-r10));
        r10 = r10 - 9;
        if (r10 > 0) goto L3;
        r21[r22] = 36028797018963967L & r3;
        r21[r22 + 1] = (r3 >>> 55) ^ (r8 << 9);
    }

    public static void implSquare(long[] r2, long[] r3) {
        Interleave.expand64To128(r2, 0, 3, r3, 0);
    }

    public static void invert(long[] r2, long[] r3) {
        if (Nat192.isZero64(r2) == true) goto L7;
        long[] r0 = Nat192.create64();
        long[] r1 = Nat192.create64();
        square(r2, r0);
        squareN(r0, 1, r1);
        multiply(r0, r1, r0);
        squareN(r1, 1, r1);
        multiply(r0, r1, r0);
        squareN(r0, 3, r1);
        multiply(r0, r1, r0);
        squareN(r1, 3, r1);
        multiply(r0, r1, r0);
        squareN(r0, 9, r1);
        multiply(r0, r1, r0);
        squareN(r1, 9, r1);
        multiply(r0, r1, r0);
        squareN(r0, 27, r1);
        multiply(r0, r1, r0);
        squareN(r1, 27, r1);
        multiply(r0, r1, r0);
        squareN(r0, 81, r1);
        multiply(r0, r1, r3);
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

    public static void reduce(long[] r24, long[] r25) {
        long r1 = r24[0];
        long r4 = r24[1];
        long r7 = r24[2];
        long r10 = r24[3];
        long r12 = r24[4];
        long r14 = r24[5];
        long r8 = r7 ^ ((((r14 << 29) ^ (r14 << 32)) ^ (r14 << 35)) ^ (r14 << 36));
        long r11 = r10 ^ ((((r14 >>> 35) ^ (r14 >>> 32)) ^ (r14 >>> 29)) ^ (r14 >>> 28));
        long r5 = r4 ^ ((((r12 << 29) ^ (r12 << 32)) ^ (r12 << 35)) ^ (r12 << 36));
        long r15 = ((r12 >>> 35) ^ (r12 >>> 32)) ^ (r12 >>> 29);
        long r9 = r8 ^ ((r12 >>> 28) ^ r15);
        long r2 = r1 ^ ((((r11 << 29) ^ (r11 << 32)) ^ (r11 << 35)) ^ (r11 << 36));
        long r13 = ((r11 >>> 35) ^ (r11 >>> 32)) ^ (r11 >>> 29);
        long r6 = r5 ^ ((r11 >>> 28) ^ r13);
        long r16 = r9 >>> 35;
        r25[0] = (((r2 ^ r16) ^ (r16 << 3)) ^ (r16 << 6)) ^ (r16 << 7);
        r25[1] = r6;
        r25[2] = 34359738367L & r9;
    }

    public static void sqrt(long[] r14, long[] r15) {
        long[] r0 = Nat192.create64();
        long r2 = Interleave.unshuffle(r14[0]);
        long r5 = Interleave.unshuffle(r14[1]);
        long r9 = (r2 & 4294967295L) | (r5 << 32);
        r0[0] = (r2 >>> 32) | (r5 & (-4294967296L));
        long r3 = Interleave.unshuffle(r14[2]);
        long r6 = r3 & 4294967295L;
        r0[1] = r3 >>> 32;
        multiply(r0, ROOT_Z, r15);
        r15[0] = r15[0] ^ r9;
        r15[1] = r15[1] ^ r6;
    }

    public static void square(long[] r1, long[] r2) {
        long[] r0 = Nat192.createExt64();
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat192.createExt64();
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat192.createExt64();
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r4) {
        return ((int) (r4[0] ^ (r4[2] >>> 29))) & 1;
    }
}
