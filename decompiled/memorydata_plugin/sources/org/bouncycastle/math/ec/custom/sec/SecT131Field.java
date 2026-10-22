package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes7.dex */
public class SecT131Field {
    private static final long[] ROOT_Z = null;

    static {
        ROOT_Z = new long[]{2791191049453778211L, 2791191049453778402L, 6};
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
        long r1 = r5[4];
        r7[4] = r6[4] ^ r1;
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
        return Nat.fromBigInteger64(131, r1);
    }

    public static void halfTrace(long[] r3, long[] r4) {
        long[] r0 = Nat.create64(5);
        Nat192.copy64(r3, r4);
        int r1 = 1;
    L4:
        if (r1 >= 131) goto L6;
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
        r20[0] = r1 ^ (r4 << 44);
        r20[1] = (r4 >>> 20) ^ (r7 << 24);
        r20[2] = ((r7 >>> 40) ^ (r10 << 4)) ^ (r13 << 48);
        r20[3] = ((r10 >>> 60) ^ (r16 << 28)) ^ (r13 >>> 16);
        r20[4] = r16 >>> 36;
        r20[5] = 0;
    }

    public static void implMultiply(long[] r31, long[] r32, long[] r33) {
        long r0 = r31[0];
        long r2 = r31[1];
        long r4 = r31[2] << 40;
        long r13 = (r4 ^ (r2 >>> 24)) & 17592186044415L;
        long r3 = r2 << 20;
        long r17 = (r3 ^ (r0 >>> 44)) & 17592186044415L;
        long r19 = r0 & 17592186044415L;
        long r1 = r32[0];
        long r5 = r32[1];
        long r21 = ((r5 >>> 24) ^ (r32[2] << 40)) & 17592186044415L;
        long r6 = r5 << 20;
        long r23 = (r6 ^ (r1 >>> 44)) & 17592186044415L;
        long r25 = r1 & 17592186044415L;
        long[] r12 = new long[10];
        implMulw(r33, r19, r25, r12, 0);
        implMulw(r33, r13, r21, r12, 2);
        long r27 = (r19 ^ r17) ^ r13;
        long r29 = (r25 ^ r23) ^ r21;
        implMulw(r33, r27, r29, r12, 4);
        long r14 = (r17 << 1) ^ (r13 << 2);
        long r16 = (r23 << 1) ^ (r21 << 2);
        implMulw(r33, r19 ^ r14, r25 ^ r16, r12, 6);
        implMulw(r33, r27 ^ r14, r29 ^ r16, r12, 8);
        long r7 = r12[6] ^ r12[8];
        long r8 = r12[7] ^ r12[9];
        long r15 = (r7 << 1) ^ r12[6];
        long r9 = (r7 ^ (r8 << 1)) ^ r12[7];
        long r18 = r12[0];
        long r110 = (r12[1] ^ r12[0]) ^ r12[4];
        long r20 = r12[1] ^ r12[5];
        long r111 = ((r18 ^ r15) ^ (r12[2] << 4)) ^ (r12[2] << 1);
        long r10 = (((r110 ^ r9) ^ (r12[3] << 4)) ^ (r12[3] << 1)) ^ (r111 >>> 44);
        long r11 = (r20 ^ r8) ^ (r10 >>> 44);
        long r22 = r10 & 17592186044415L;
        long r112 = ((r111 & 17592186044415L) >>> 1) ^ ((r22 & 1) << 43);
        long r24 = (r22 >>> 1) ^ ((r11 & 1) << 43);
        long r113 = r112 ^ (r112 << 1);
        long r114 = r113 ^ (r113 << 2);
        long r115 = r114 ^ (r114 << 4);
        long r116 = r115 ^ (r115 << 8);
        long r117 = r116 ^ (r116 << 16);
        long r118 = (r117 ^ (r117 << 32)) & 17592186044415L;
        long r26 = r24 ^ (r118 >>> 43);
        long r28 = r26 ^ (r26 << 1);
        long r30 = r28 ^ (r28 << 2);
        long r34 = r30 ^ (r30 << 4);
        long r35 = r34 ^ (r34 << 8);
        long r36 = r35 ^ (r35 << 16);
        long r37 = (r36 ^ (r36 << 32)) & 17592186044415L;
        long r38 = (r11 >>> 1) ^ (r37 >>> 43);
        long r39 = r38 ^ (r38 << 1);
        long r40 = r39 ^ (r39 << 2);
        long r41 = r40 ^ (r40 << 4);
        long r42 = r41 ^ (r41 << 8);
        long r43 = r42 ^ (r42 << 16);
        long r44 = r43 ^ (r43 << 32);
        r33[0] = r18;
        r33[1] = (r110 ^ r118) ^ r12[2];
        r33[2] = ((r20 ^ r37) ^ r118) ^ r12[3];
        r33[3] = r37 ^ r44;
        r33[4] = r12[2] ^ r44;
        r33[5] = r12[3];
        implCompactExt(r33);
    }

    public static void implMulw(long[] r18, long r19, long r21, long[] r23, int r24) {
        r18[1] = r21;
        r18[2] = r18[1] << 1;
        r18[3] = r18[2] ^ r21;
        r18[4] = r18[2] << 1;
        r18[5] = r18[4] ^ r21;
        r18[6] = r18[3] << 1;
        r18[7] = r18[6] ^ r21;
        int r3 = (int) r19;
        long r8 = (((r18[r3 & 7] ^ (r18[(r3 >>> 3) & 7] << 3)) ^ (r18[(r3 >>> 6) & 7] << 6)) ^ (r18[(r3 >>> 9) & 7] << 9)) ^ (r18[(r3 >>> 12) & 7] << 12);
        long r11 = 0;
        int r4 = 30;
    L3:
        int r13 = (int) (r19 >>> r4);
        long r14 = (((r18[r13 & 7] ^ (r18[(r13 >>> 3) & 7] << 3)) ^ (r18[(r13 >>> 6) & 7] << 6)) ^ (r18[(r13 >>> 9) & 7] << 9)) ^ (r18[(r13 >>> 12) & 7] << 12);
        r8 = r8 ^ (r14 << r4);
        r11 = r11 ^ (r14 >>> (-r4));
        r4 = r4 - 15;
        if (r4 > 0) goto L3;
        r23[r24] = 17592186044415L & r8;
        r23[r24 + 1] = (r8 >>> 44) ^ (r11 << 20);
    }

    public static void implSquare(long[] r4, long[] r5) {
        Interleave.expand64To128(r4, 0, 2, r5, 0);
        r5[4] = ((long) Interleave.expand8to16((int) r4[2])) & 4294967295L;
    }

    public static void invert(long[] r3, long[] r4) {
        if (Nat192.isZero64(r3) == true) goto L7;
        long[] r0 = Nat192.create64();
        long[] r1 = Nat192.create64();
        square(r3, r0);
        multiply(r0, r3, r0);
        squareN(r0, 2, r1);
        multiply(r1, r0, r1);
        squareN(r1, 4, r0);
        multiply(r0, r1, r0);
        squareN(r0, 8, r1);
        multiply(r1, r0, r1);
        squareN(r1, 16, r0);
        multiply(r0, r1, r0);
        squareN(r0, 32, r1);
        multiply(r1, r0, r1);
        square(r1, r1);
        multiply(r1, r3, r1);
        squareN(r1, 65, r0);
        multiply(r0, r1, r0);
        square(r0, r4);
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

    public static void reduce(long[] r21, long[] r22) {
        long r1 = r21[0];
        long r4 = r21[1];
        long r7 = r21[2];
        long r10 = r21[3];
        long r12 = r21[4];
        long r5 = r4 ^ ((r12 << 61) ^ (r12 << 63));
        long r8 = r7 ^ ((((r12 >>> 3) ^ (r12 >>> 1)) ^ r12) ^ (r12 << 5));
        long r11 = r10 ^ (r12 >>> 59);
        long r2 = r1 ^ ((r11 << 61) ^ (r11 << 63));
        long r6 = r5 ^ ((((r11 >>> 3) ^ (r11 >>> 1)) ^ r11) ^ (r11 << 5));
        long r9 = r8 ^ (r11 >>> 59);
        long r13 = r9 >>> 3;
        r22[0] = (((r2 ^ r13) ^ (r13 << 2)) ^ (r13 << 3)) ^ (r13 << 8);
        r22[1] = (r13 >>> 56) ^ r6;
        r22[2] = 7 & r9;
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
        long[] r0 = Nat.create64(5);
        implSquare(r1, r0);
        reduce(r0, r2);
    }

    public static void squareAddToExt(long[] r1, long[] r2) {
        long[] r0 = Nat.create64(5);
        implSquare(r1, r0);
        addExt(r2, r0, r2);
    }

    public static void squareN(long[] r1, int r2, long[] r3) {
        long[] r0 = Nat.create64(5);
        implSquare(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        implSquare(r3, r0);
        goto L3
    }

    public static int trace(long[] r6) {
        return ((int) ((r6[0] ^ (r6[1] >>> 59)) ^ (r6[2] >>> 1))) & 1;
    }
}
