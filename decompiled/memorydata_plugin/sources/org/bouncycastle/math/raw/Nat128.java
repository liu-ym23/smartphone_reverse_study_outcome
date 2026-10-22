package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat128 {
    public static int add(int[] r10, int[] r11, int[] r12) {
        long r1 = ((((long) r10[0]) & 4294967295L) + (((long) r11[0]) & 4294967295L)) + 0;
        r12[0] = (int) r1;
        long r2 = (r1 >>> 32) + ((((long) r10[1]) & 4294967295L) + (((long) r11[1]) & 4294967295L));
        r12[1] = (int) r2;
        long r3 = (r2 >>> 32) + ((((long) r10[2]) & 4294967295L) + (((long) r11[2]) & 4294967295L));
        r12[2] = (int) r3;
        long r4 = (r3 >>> 32) + ((((long) r10[3]) & 4294967295L) + (((long) r11[3]) & 4294967295L));
        r12[3] = (int) r4;
        return (int) (r4 >>> 32);
    }

    public static int addBothTo(int[] r10, int[] r11, int[] r12) {
        long r1 = (((((long) r10[0]) & 4294967295L) + (((long) r11[0]) & 4294967295L)) + (((long) r12[0]) & 4294967295L)) + 0;
        r12[0] = (int) r1;
        long r2 = (r1 >>> 32) + (((((long) r10[1]) & 4294967295L) + (((long) r11[1]) & 4294967295L)) + (((long) r12[1]) & 4294967295L));
        r12[1] = (int) r2;
        long r3 = (r2 >>> 32) + (((((long) r10[2]) & 4294967295L) + (((long) r11[2]) & 4294967295L)) + (((long) r12[2]) & 4294967295L));
        r12[2] = (int) r3;
        long r4 = (r3 >>> 32) + (((((long) r10[3]) & 4294967295L) + (((long) r11[3]) & 4294967295L)) + (((long) r12[3]) & 4294967295L));
        r12[3] = (int) r4;
        return (int) (r4 >>> 32);
    }

    public static void copy(int[] r2, int r3, int[] r4, int r5) {
        r4[r5 + 0] = r2[r3 + 0];
        r4[r5 + 1] = r2[r3 + 1];
        r4[r5 + 2] = r2[r3 + 2];
        r4[r5 + 3] = r2[r3 + 3];
    }

    public static void copy64(long[] r3, int r4, long[] r5, int r6) {
        r5[r6 + 0] = r3[r4 + 0];
        r5[r6 + 1] = r3[r4 + 1];
    }

    public static void copy64(long[] r3, long[] r4) {
        r4[0] = r3[0];
        r4[1] = r3[1];
    }

    public static int[] create() {
        return new int[4];
    }

    public static long[] create64() {
        return new long[2];
    }

    public static int[] createExt() {
        return new int[8];
    }

    public static long[] createExt64() {
        return new long[4];
    }

    public static boolean eq(int[] r3, int[] r4) {
        int r0 = 3;
    L3:
        if (r0 < 0) goto L9;
        if (r3[r0] != r4[r0]) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static boolean eq64(long[] r6, long[] r7) {
        int r1 = 1;
    L3:
        if (r1 < 0) goto L9;
        if (r6[r1] != r7[r1]) goto L6;
        r1 = r1 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static int[] fromBigInteger(BigInteger r3) {
        if (r3.signum() < 0) goto L12;
        if (r3.bitLength() > 128) goto L12;
        int[] r0 = create();
        int r1 = 0;
    L8:
        if (r1 >= 4) goto L10;
        r0[r1] = r3.intValue();
        r3 = r3.shiftRight(32);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException();
    }

    public static int getBit(int[] r3, int r4) {
        if (r4 != 0) goto L7;
        int r5 = r3[0];
    L6:
        return r5 & 1;
    L7:
        int r1 = r4 >> 5;
        if (r1 >= 0) goto L10;
    L13:
        return 0;
    L10:
        if (r1 >= 4) goto L13;
        int r6 = r3[r1];
        r5 = r6 >>> (r4 & 31);
        goto L6
    }

    public static boolean gte(int[] r5, int[] r6) {
        int r0 = 3;
    L4:
        if (r0 < 0) goto L12;
        int r2 = r5[r0] ^ Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE ^ r6[r0];
        if (r2 < r3) goto L7;
        if (r2 > r3) goto L10;
        r0 = r0 - 1;
        goto L4
    L10:
        return true;
    L7:
        return false;
    L12:
        return true;
    }

    public static boolean isOne(int[] r4) {
        if (r4[0] == 1) goto L5;
        return false;
    L5:
        int r1 = 1;
    L7:
        if (r1 >= 4) goto L12;
        if (r4[r1] != 0) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isOne64(long[] r7) {
        if (r7[0] == 1) goto L5;
        return false;
    L5:
        int r2 = 1;
    L7:
        if (r2 >= 2) goto L12;
        if (r7[r2] != 0) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isZero(int[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L9;
        if (r3[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean isZero64(long[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L9;
        if (r6[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r26, int[] r27, int[] r28) {
        long r1 = ((long) r27[0]) & 4294967295L;
        int r5 = 1;
        long r6 = ((long) r27[1]) & 4294967295L;
        long r9 = ((long) r27[2]) & 4294967295L;
        long r12 = ((long) r27[3]) & 4294967295L;
        long r14 = ((long) r26[0]) & 4294967295L;
        long r3 = (r14 * r1) + 0;
        r28[0] = (int) r3;
        char r0 = ' ';
        long r4 = (r3 >>> 32) + (r14 * r6);
        r28[1] = (int) r4;
        long r7 = (r4 >>> 32) + (r14 * r9);
        r28[2] = (int) r7;
        long r8 = (r7 >>> 32) + (r14 * r12);
        r28[3] = (int) r8;
        int r10 = 4;
        r28[4] = (int) (r8 >>> 32);
    L3:
        if (r5 >= r10) goto L5;
        long r15 = ((long) r26[r5]) & 4294967295L;
        int r11 = r5 + 0;
        int r13 = r5;
        long r16 = ((r15 * r1) + (((long) r28[r11]) & 4294967295L)) + 0;
        r28[r11] = (int) r16;
        int r17 = r13 + 1;
        long r22 = r1;
        long r18 = (r16 >>> r0) + ((r15 * r6) + (((long) r28[r17]) & 4294967295L));
        r28[r17] = (int) r18;
        int r19 = r13 + 2;
        long r2 = (r18 >>> 32) + ((r15 * r9) + (((long) r28[r19]) & 4294967295L));
        r28[r19] = (int) r2;
        r0 = ' ';
        int r20 = r13 + 3;
        long r21 = (r2 >>> 32) + ((r15 * r12) + (((long) r28[r20]) & 4294967295L));
        r28[r20] = (int) r21;
        r28[r13 + 4] = (int) (r21 >>> 32);
        r5 = r17;
        r1 = r22;
        r6 = r6;
        r10 = 4;
        goto L3
    }

    public static int mulAddTo(int[] r26, int[] r27, int[] r28) {
        int r0 = 0;
        long r3 = 4294967295L;
        long r1 = ((long) r27[0]) & 4294967295L;
        long r5 = ((long) r27[1]) & 4294967295L;
        long r7 = ((long) r27[2]) & 4294967295L;
        long r9 = ((long) r27[3]) & 4294967295L;
        long r13 = 0;
    L4:
        if (r0 >= 4) goto L7;
        long r11 = ((long) r26[r0]) & r3;
        int r15 = r0 + 0;
        long r4 = ((r11 * r1) + (((long) r28[r15]) & r3)) + 0;
        r28[r15] = (int) r4;
        int r6 = r0 + 1;
        long r2 = (r4 >>> 32) + ((r11 * r5) + (((long) r28[r6]) & 4294967295L));
        r28[r6] = (int) r2;
        int r17 = r0 + 2;
        long r8 = (r2 >>> 32) + ((r11 * r7) + (((long) r28[r17]) & 4294967295L));
        r28[r17] = (int) r8;
        int r10 = r0 + 3;
        long r12 = (r8 >>> 32) + ((r11 * r9) + (((long) r28[r10]) & 4294967295L));
        r28[r10] = (int) r12;
        int r14 = r0 + 4;
        long r16 = r13 + ((r12 >>> 32) + (((long) r28[r14]) & 4294967295L));
        r28[r14] = (int) r16;
        r13 = r16 >>> 32;
        r0 = r6;
        r3 = 4294967295L;
        r1 = r1;
        r5 = r5;
        goto L4
    L7:
        return (int) r13;
    }

    public static void square(int[] r29, int[] r30) {
        long r3 = 4294967295L;
        long r1 = ((long) r29[0]) & 4294967295L;
        char r5 = 3;
        int r6 = 8;
        int r8 = 0;
        int r7 = 3;
    L3:
        int r9 = r7 - 1;
        long r10 = ((long) r29[r7]) & r3;
        long r11 = r10 * r10;
        int r12 = r6 - 1;
        r30[r12] = (r8 << 31) | ((int) (r11 >>> 33));
        r6 = r12 - 1;
        r30[r6] = (int) (r11 >>> 1);
        int r13 = (int) r11;
        if (r9 <= 0) goto L5;
        r7 = r9;
        r8 = r13;
        r5 = r5;
        r3 = r3;
        goto L3
    L5:
        long r14 = r1 * r1;
        long r15 = (((long) (r13 << 31)) & r3) | (r14 >>> 33);
        r30[0] = (int) r14;
        long r16 = ((long) r29[1]) & r3;
        long r17 = ((long) r30[2]) & r3;
        long r18 = r15 + (r16 * r1);
        int r19 = (int) r18;
        r30[1] = (r19 << 1) | (((int) (r14 >>> 32)) & 1);
        long r110 = r17 + (r18 >>> 32);
        long r20 = ((long) r29[2]) & r3;
        long r21 = ((long) r30[r5]) & r3;
        long r111 = ((long) r30[4]) & r3;
        long r4 = r110 + (r20 * r1);
        int r22 = (int) r4;
        r30[2] = (r22 << 1) | (r19 >>> 31);
        long r23 = r21 + ((r4 >>> 32) + (r20 * r16));
        long r112 = r111 + (r23 >>> 32);
        long r113 = ((long) r29[3]) & 4294967295L;
        long r24 = (((long) r30[5]) & 4294967295L) + (r112 >>> 32);
        long r114 = r112 & 4294967295L;
        long r115 = (((long) r30[6]) & 4294967295L) + (r24 >>> 32);
        long r25 = (r23 & 4294967295L) + (r1 * r113);
        int r2 = (int) r25;
        r30[3] = (r2 << 1) | (r22 >>> 31);
        long r26 = r114 + ((r25 >>> 32) + (r16 * r113));
        long r27 = (r24 & 4294967295L) + ((r26 >>> 32) + (r113 * r20));
        long r116 = r115 + (r27 >>> 32);
        int r0 = (int) r26;
        r30[4] = (r2 >>> 31) | (r0 << 1);
        int r28 = (int) (4294967295L & r27);
        r30[5] = (r0 >>> 31) | (r28 << 1);
        int r31 = r28 >>> 31;
        int r32 = (int) r116;
        r30[6] = r31 | (r32 << 1);
        r30[7] = (r32 >>> 31) | ((r30[7] + ((int) (r116 >>> 32))) << 1);
    }

    public static int sub(int[] r10, int[] r11, int[] r12) {
        long r1 = ((((long) r10[0]) & 4294967295L) - (((long) r11[0]) & 4294967295L)) + 0;
        r12[0] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r10[1]) & 4294967295L) - (((long) r11[1]) & 4294967295L));
        r12[1] = (int) r2;
        long r3 = (r2 >> 32) + ((((long) r10[2]) & 4294967295L) - (((long) r11[2]) & 4294967295L));
        r12[2] = (int) r3;
        long r4 = (r3 >> 32) + ((((long) r10[3]) & 4294967295L) - (((long) r11[3]) & 4294967295L));
        r12[3] = (int) r4;
        return (int) (r4 >> 32);
    }

    public static int subFrom(int[] r10, int[] r11) {
        long r1 = ((((long) r11[0]) & 4294967295L) - (((long) r10[0]) & 4294967295L)) + 0;
        r11[0] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r11[1]) & 4294967295L) - (((long) r10[1]) & 4294967295L));
        r11[1] = (int) r2;
        long r3 = (r2 >> 32) + ((((long) r11[2]) & 4294967295L) - (((long) r10[2]) & 4294967295L));
        r11[2] = (int) r3;
        long r4 = (r3 >> 32) + ((((long) r11[3]) & 4294967295L) - (4294967295L & ((long) r10[3])));
        r11[3] = (int) r4;
        return (int) (r4 >> 32);
    }

    public static BigInteger toBigInteger(int[] r4) {
        byte[] r0 = new byte[16];
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L10;
        int r2 = r4[r1];
        if (r2 == 0) goto L8;
        Pack.intToBigEndian(r2, r0, (3 - r1) << 2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }

    public static BigInteger toBigInteger64(long[] r6) {
        byte[] r0 = new byte[16];
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L10;
        long r2 = r6[r1];
        if (r2 == 0) goto L8;
        Pack.longToBigEndian(r2, r0, (1 - r1) << 3);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
