package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat160 {
    public static int add(int[] r10, int[] r11, int[] r12) {
        long r1 = ((((long) r10[0]) & 4294967295L) + (((long) r11[0]) & 4294967295L)) + 0;
        r12[0] = (int) r1;
        long r2 = (r1 >>> 32) + ((((long) r10[1]) & 4294967295L) + (((long) r11[1]) & 4294967295L));
        r12[1] = (int) r2;
        long r3 = (r2 >>> 32) + ((((long) r10[2]) & 4294967295L) + (((long) r11[2]) & 4294967295L));
        r12[2] = (int) r3;
        long r4 = (r3 >>> 32) + ((((long) r10[3]) & 4294967295L) + (((long) r11[3]) & 4294967295L));
        r12[3] = (int) r4;
        long r5 = (r4 >>> 32) + ((((long) r10[4]) & 4294967295L) + (((long) r11[4]) & 4294967295L));
        r12[4] = (int) r5;
        return (int) (r5 >>> 32);
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
        long r5 = (r4 >>> 32) + (((((long) r10[4]) & 4294967295L) + (((long) r11[4]) & 4294967295L)) + (((long) r12[4]) & 4294967295L));
        r12[4] = (int) r5;
        return (int) (r5 >>> 32);
    }

    public static void copy(int[] r2, int r3, int[] r4, int r5) {
        r4[r5 + 0] = r2[r3 + 0];
        r4[r5 + 1] = r2[r3 + 1];
        r4[r5 + 2] = r2[r3 + 2];
        r4[r5 + 3] = r2[r3 + 3];
        r4[r5 + 4] = r2[r3 + 4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
    }

    public static boolean eq(int[] r3, int[] r4) {
        int r0 = 4;
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

    public static int[] fromBigInteger(BigInteger r3) {
        if (r3.signum() < 0) goto L12;
        if (r3.bitLength() > 160) goto L12;
        int[] r0 = create();
        int r1 = 0;
    L8:
        if (r1 >= 5) goto L10;
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
        if (r1 >= 5) goto L13;
        int r6 = r3[r1];
        r5 = r6 >>> (r4 & 31);
        goto L6
    }

    public static boolean gte(int[] r5, int[] r6) {
        int r0 = 4;
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
        if (r1 >= 5) goto L12;
        if (r4[r1] != 0) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isZero(int[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= 5) goto L9;
        if (r3[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r27, int[] r28, int[] r29) {
        long r1 = ((long) r28[0]) & 4294967295L;
        int r5 = 1;
        long r6 = ((long) r28[1]) & 4294967295L;
        long r9 = ((long) r28[2]) & 4294967295L;
        long r12 = ((long) r28[3]) & 4294967295L;
        long r14 = ((long) r28[4]) & 4294967295L;
        long r8 = ((long) r27[0]) & 4294967295L;
        long r10 = (r8 * r1) + 0;
        r29[0] = (int) r10;
        long r3 = (r10 >>> 32) + (r8 * r6);
        r29[1] = (int) r3;
        long r4 = (r3 >>> 32) + (r8 * r9);
        r29[2] = (int) r4;
        long r7 = (r4 >>> 32) + (r8 * r12);
        r29[3] = (int) r7;
        long r11 = (r7 >>> 32) + (r8 * r14);
        r29[4] = (int) r11;
        int r13 = 5;
        r29[5] = (int) (r11 >>> 32);
    L3:
        if (r5 >= r13) goto L5;
        long r15 = ((long) r27[r5]) & 4294967295L;
        int r16 = r5 + 0;
        long r0 = ((r15 * r1) + (((long) r29[r16]) & 4294967295L)) + 0;
        r29[r16] = (int) r0;
        int r17 = r5 + 1;
        long r25 = r6;
        long r2 = (r0 >>> 32) + ((r15 * r6) + (((long) r29[r17]) & 4294967295L));
        r29[r17] = (int) r2;
        int r18 = r5 + 2;
        long r19 = r14;
        long r20 = (r2 >>> 32) + ((r15 * r9) + (((long) r29[r18]) & 4294967295L));
        r29[r18] = (int) r20;
        int r21 = r5 + 3;
        long r22 = (r20 >>> 32) + ((r15 * r12) + (((long) r29[r21]) & 4294967295L));
        r29[r21] = (int) r22;
        int r23 = r5 + 4;
        long r24 = (r22 >>> 32) + ((r15 * r19) + (((long) r29[r23]) & 4294967295L));
        r29[r23] = (int) r24;
        r29[r5 + 5] = (int) (r24 >>> 32);
        r5 = r17;
        r14 = r19;
        r1 = r1;
        r6 = r25;
        r13 = 5;
        goto L3
    }

    public static long mul33Add(int r13, int[] r14, int r15, int[] r16, int r17, int[] r18, int r19) {
        long r0 = ((long) r13) & 4294967295L;
        long r4 = ((long) r14[r15 + 0]) & 4294967295L;
        long r6 = ((r0 * r4) + (((long) r16[r17 + 0]) & 4294967295L)) + 0;
        r18[r19 + 0] = (int) r6;
        long r9 = ((long) r14[r15 + 1]) & 4294967295L;
        long r7 = (r6 >>> 32) + (((r0 * r9) + r4) + (((long) r16[r17 + 1]) & 4294967295L));
        r18[r19 + 1] = (int) r7;
        long r5 = r7 >>> 32;
        long r8 = ((long) r14[r15 + 2]) & 4294967295L;
        long r10 = r5 + (((r0 * r8) + r9) + (((long) r16[r17 + 2]) & 4294967295L));
        r18[r19 + 2] = (int) r10;
        long r11 = ((long) r14[r15 + 3]) & 4294967295L;
        long r12 = (r10 >>> 32) + (((r0 * r11) + r8) + (((long) r16[r17 + 3]) & 4294967295L));
        r18[r19 + 3] = (int) r12;
        long r20 = ((long) r14[r15 + 4]) & 4294967295L;
        long r21 = (r12 >>> 32) + (((r0 * r20) + r11) + (4294967295L & ((long) r16[r17 + 4])));
        r18[r19 + 4] = (int) r21;
        return (r21 >>> 32) + r20;
    }

    public static int mul33DWordAdd(int r15, long r16, int[] r18, int r19) {
        long r3 = ((long) r15) & 4294967295L;
        long r7 = r16 & 4294967295L;
        int r1 = r19 + 0;
        long r9 = ((r3 * r7) + (((long) r18[r1]) & 4294967295L)) + 0;
        r18[r1] = (int) r9;
        long r13 = r16 >>> 32;
        long r4 = (r3 * r13) + r7;
        int r8 = r19 + 1;
        long r10 = (r9 >>> 32) + (r4 + (((long) r18[r8]) & 4294967295L));
        r18[r8] = (int) r10;
        int r11 = r19 + 2;
        long r5 = (r10 >>> 32) + (r13 + (((long) r18[r11]) & 4294967295L));
        r18[r11] = (int) r5;
        int r12 = r19 + 3;
        long r6 = (r5 >>> 32) + (4294967295L & ((long) r18[r12]));
        r18[r12] = (int) r6;
        if ((r6 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(5, r18, r19, 4);
    }

    public static int mul33WordAdd(int r10, int r11, int[] r12, int r13) {
        long r0 = ((long) r10) & 4294967295L;
        long r14 = ((long) r11) & 4294967295L;
        int r4 = r13 + 0;
        long r1 = ((r0 * r14) + (((long) r12[r4]) & 4294967295L)) + 0;
        r12[r4] = (int) r1;
        int r7 = r13 + 1;
        long r2 = (r1 >>> 32) + (r14 + (((long) r12[r7]) & 4294967295L));
        r12[r7] = (int) r2;
        long r15 = r2 >>> 32;
        int r3 = r13 + 2;
        long r16 = r15 + (((long) r12[r3]) & 4294967295L);
        r12[r3] = (int) r16;
        if ((r16 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(5, r12, r13, 3);
    }

    public static int mulAddTo(int[] r30, int[] r31, int[] r32) {
        int r0 = 0;
        long r3 = 4294967295L;
        long r1 = ((long) r31[0]) & 4294967295L;
        long r5 = ((long) r31[1]) & 4294967295L;
        long r7 = ((long) r31[2]) & 4294967295L;
        long r9 = ((long) r31[3]) & 4294967295L;
        long r11 = ((long) r31[4]) & 4294967295L;
        long r15 = 0;
    L4:
        if (r0 >= 5) goto L7;
        long r13 = ((long) r30[r0]) & r3;
        int r21 = r0 + 0;
        long r4 = ((r13 * r1) + (((long) r32[r21]) & r3)) + 0;
        r32[r21] = (int) r4;
        int r6 = r0 + 1;
        long r26 = r5;
        long r2 = (r4 >>> 32) + ((r13 * r5) + (((long) r32[r6]) & 4294967295L));
        r32[r6] = (int) r2;
        int r22 = r0 + 2;
        long r24 = r7;
        long r8 = (r2 >>> 32) + ((r13 * r7) + (((long) r32[r22]) & 4294967295L));
        r32[r22] = (int) r8;
        int r10 = r0 + 3;
        long r12 = (r8 >>> 32) + ((r13 * r9) + (((long) r32[r10]) & 4294967295L));
        r32[r10] = (int) r12;
        int r14 = r0 + 4;
        long r16 = (r12 >>> 32) + ((r13 * r11) + (((long) r32[r14]) & 4294967295L));
        r32[r14] = (int) r16;
        int r17 = r0 + 5;
        long r18 = ((r16 >>> 32) + (((long) r32[r17]) & 4294967295L)) + r15;
        r32[r17] = (int) r18;
        r15 = r18 >>> 32;
        r0 = r6;
        r3 = 4294967295L;
        r1 = r1;
        r7 = r24;
        r5 = r26;
        goto L4
    L7:
        return (int) r15;
    }

    public static int mulWordsAdd(int r8, int r9, int[] r10, int r11) {
        long r0 = ((long) r8) & 4294967295L;
        long r12 = (((long) r9) & 4294967295L) * r0;
        int r1 = r11 + 0;
        long r13 = (r12 + (((long) r10[r1]) & 4294967295L)) + 0;
        r10[r1] = (int) r13;
        int r2 = r11 + 1;
        long r14 = (r13 >>> 32) + (4294967295L & ((long) r10[r2]));
        r10[r2] = (int) r14;
        if ((r14 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(5, r10, r11, 2);
    }

    public static void square(int[] r32, int[] r33) {
        long r1 = ((long) r32[0]) & 4294967295L;
        int r6 = 10;
        int r8 = 0;
        int r7 = 4;
    L3:
        int r9 = r7 - 1;
        long r10 = ((long) r32[r7]) & 4294967295L;
        long r11 = r10 * r10;
        int r12 = r6 - 1;
        r33[r12] = (r8 << 31) | ((int) (r11 >>> 33));
        r6 = r12 - 1;
        r33[r6] = (int) (r11 >>> 1);
        int r13 = (int) r11;
        if (r9 <= 0) goto L5;
        r7 = r9;
        r8 = r13;
        goto L3
    L5:
        long r14 = r1 * r1;
        long r15 = (((long) (r13 << 31)) & 4294967295L) | (r14 >>> 33);
        r33[0] = (int) r14;
        long r16 = ((long) r32[1]) & 4294967295L;
        long r17 = ((long) r33[2]) & 4294967295L;
        long r18 = r15 + (r16 * r1);
        int r19 = (int) r18;
        r33[1] = (r19 << 1) | (((int) (r14 >>> 32)) & 1);
        long r110 = r17 + (r18 >>> 32);
        long r20 = ((long) r32[2]) & 4294967295L;
        long r111 = ((long) r33[3]) & 4294967295L;
        long r5 = ((long) r33[4]) & 4294967295L;
        long r112 = r110 + (r20 * r1);
        int r21 = (int) r112;
        r33[2] = (r21 << 1) | (r19 >>> 31);
        int r113 = r21 >>> 31;
        long r114 = r111 + ((r112 >>> 32) + (r20 * r16));
        long r22 = r5 + (r114 >>> 32);
        long r115 = ((long) r32[3]) & 4294967295L;
        long r23 = (((long) r33[5]) & 4294967295L) + (r22 >>> 32);
        long r24 = (((long) r33[6]) & 4294967295L) + (r23 >>> 32);
        long r116 = (r114 & 4294967295L) + (r115 * r1);
        int r117 = (int) r116;
        r33[3] = (r117 << 1) | r113;
        int r118 = r117 >>> 31;
        long r25 = (r22 & 4294967295L) + ((r116 >>> 32) + (r115 * r16));
        long r26 = (r23 & 4294967295L) + ((r25 >>> 32) + (r115 * r20));
        long r27 = r24 + (r26 >>> 32);
        long r119 = ((long) r32[4]) & 4294967295L;
        long r120 = (((long) r33[7]) & 4294967295L) + (r27 >>> 32);
        long r28 = r27 & 4294967295L;
        long r29 = (((long) r33[8]) & 4294967295L) + (r120 >>> 32);
        long r30 = (r25 & 4294967295L) + (r1 * r119);
        int r2 = (int) r30;
        r33[4] = (r2 << 1) | r118;
        long r31 = (r26 & 4294967295L) + ((r30 >>> 32) + (r119 * r16));
        long r34 = r28 + ((r31 >>> 32) + (r119 * r20));
        long r3 = (4294967295L & r120) + ((r34 >>> 32) + (r119 * r115));
        long r35 = r29 + (r3 >>> 32);
        int r0 = (int) r31;
        r33[5] = (r2 >>> 31) | (r0 << 1);
        int r4 = (int) r34;
        r33[6] = (r0 >>> 31) | (r4 << 1);
        int r36 = r4 >>> 31;
        int r37 = (int) r3;
        r33[7] = r36 | (r37 << 1);
        int r38 = r37 >>> 31;
        int r39 = (int) r35;
        r33[8] = r38 | (r39 << 1);
        r33[9] = (r39 >>> 31) | ((r33[9] + ((int) (r35 >>> 32))) << 1);
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
        long r5 = (r4 >> 32) + ((((long) r10[4]) & 4294967295L) - (((long) r11[4]) & 4294967295L));
        r12[4] = (int) r5;
        return (int) (r5 >> 32);
    }

    public static int subFrom(int[] r10, int[] r11) {
        long r1 = ((((long) r11[0]) & 4294967295L) - (((long) r10[0]) & 4294967295L)) + 0;
        r11[0] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r11[1]) & 4294967295L) - (((long) r10[1]) & 4294967295L));
        r11[1] = (int) r2;
        long r3 = (r2 >> 32) + ((((long) r11[2]) & 4294967295L) - (((long) r10[2]) & 4294967295L));
        r11[2] = (int) r3;
        long r4 = (r3 >> 32) + ((((long) r11[3]) & 4294967295L) - (((long) r10[3]) & 4294967295L));
        r11[3] = (int) r4;
        long r5 = (r4 >> 32) + ((((long) r11[4]) & 4294967295L) - (4294967295L & ((long) r10[4])));
        r11[4] = (int) r5;
        return (int) (r5 >> 32);
    }

    public static BigInteger toBigInteger(int[] r4) {
        byte[] r0 = new byte[20];
        int r1 = 0;
    L4:
        if (r1 >= 5) goto L10;
        int r2 = r4[r1];
        if (r2 == 0) goto L8;
        Pack.intToBigEndian(r2, r0, (4 - r1) << 2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
