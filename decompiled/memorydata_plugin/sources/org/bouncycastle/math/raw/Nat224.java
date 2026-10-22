package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat224 {
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
        long r6 = (r5 >>> 32) + ((((long) r10[5]) & 4294967295L) + (((long) r11[5]) & 4294967295L));
        r12[5] = (int) r6;
        long r7 = (r6 >>> 32) + ((((long) r10[6]) & 4294967295L) + (((long) r11[6]) & 4294967295L));
        r12[6] = (int) r7;
        return (int) (r7 >>> 32);
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
        long r6 = (r5 >>> 32) + (((((long) r10[5]) & 4294967295L) + (((long) r11[5]) & 4294967295L)) + (((long) r12[5]) & 4294967295L));
        r12[5] = (int) r6;
        long r7 = (r6 >>> 32) + (((((long) r10[6]) & 4294967295L) + (((long) r11[6]) & 4294967295L)) + (((long) r12[6]) & 4294967295L));
        r12[6] = (int) r7;
        return (int) (r7 >>> 32);
    }

    public static void copy(int[] r2, int r3, int[] r4, int r5) {
        r4[r5 + 0] = r2[r3 + 0];
        r4[r5 + 1] = r2[r3 + 1];
        r4[r5 + 2] = r2[r3 + 2];
        r4[r5 + 3] = r2[r3 + 3];
        r4[r5 + 4] = r2[r3 + 4];
        r4[r5 + 5] = r2[r3 + 5];
        r4[r5 + 6] = r2[r3 + 6];
    }

    public static void copy(int[] r2, int[] r3) {
        r3[0] = r2[0];
        r3[1] = r2[1];
        r3[2] = r2[2];
        r3[3] = r2[3];
        r3[4] = r2[4];
        r3[5] = r2[5];
        r3[6] = r2[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
    }

    public static boolean eq(int[] r3, int[] r4) {
        int r0 = 6;
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
        if (r3.bitLength() > 224) goto L12;
        int[] r0 = create();
        int r1 = 0;
    L8:
        if (r1 >= 7) goto L10;
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
        if (r1 >= 7) goto L13;
        int r6 = r3[r1];
        r5 = r6 >>> (r4 & 31);
        goto L6
    }

    public static boolean gte(int[] r5, int[] r6) {
        int r0 = 6;
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
        if (r1 >= 7) goto L12;
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
        if (r1 >= 7) goto L9;
        if (r3[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r32, int[] r33, int[] r34) {
        long r1 = ((long) r33[0]) & 4294967295L;
        long r6 = ((long) r33[1]) & 4294967295L;
        long r9 = ((long) r33[2]) & 4294967295L;
        long r12 = ((long) r33[3]) & 4294967295L;
        long r14 = ((long) r33[4]) & 4294967295L;
        long r8 = ((long) r33[5]) & 4294967295L;
        long r10 = ((long) r33[6]) & 4294967295L;
        long r11 = ((long) r32[0]) & 4294967295L;
        long r3 = (r11 * r1) + 0;
        r34[0] = (int) r3;
        long r4 = (r3 >>> 32) + (r11 * r6);
        r34[1] = (int) r4;
        long r5 = (r4 >>> 32) + (r11 * r9);
        r34[2] = (int) r5;
        long r7 = (r5 >>> 32) + (r11 * r12);
        r34[3] = (int) r7;
        long r13 = (r7 >>> 32) + (r11 * r14);
        r34[4] = (int) r13;
        long r15 = (r13 >>> 32) + (r11 * r8);
        r34[5] = (int) r15;
        long r16 = (r15 >>> 32) + (r11 * r10);
        r34[6] = (int) r16;
        int r17 = 7;
        r34[7] = (int) (r16 >>> 32);
        int r18 = 1;
    L3:
        if (r18 >= r17) goto L5;
        long r19 = ((long) r32[r18]) & 4294967295L;
        int r20 = r18 + 0;
        long r0 = ((r19 * r1) + (((long) r34[r20]) & 4294967295L)) + 0;
        r34[r20] = (int) r0;
        int r110 = r18 + 1;
        long r26 = r6;
        long r2 = (r0 >>> 32) + ((r19 * r6) + (((long) r34[r110]) & 4294967295L));
        r34[r110] = (int) r2;
        int r21 = r18 + 2;
        long r30 = r8;
        long r22 = (r2 >>> 32) + ((r19 * r9) + (((long) r34[r21]) & 4294967295L));
        r34[r21] = (int) r22;
        int r23 = r18 + 3;
        long r24 = (r22 >>> 32) + ((r19 * r12) + (((long) r34[r23]) & 4294967295L));
        r34[r23] = (int) r24;
        int r25 = r18 + 4;
        long r27 = (r24 >>> 32) + ((r19 * r14) + (((long) r34[r25]) & 4294967295L));
        r34[r25] = (int) r27;
        int r28 = r18 + 5;
        long r29 = (r27 >>> 32) + ((r19 * r30) + (((long) r34[r28]) & 4294967295L));
        r34[r28] = (int) r29;
        int r31 = r18 + 6;
        long r35 = (r29 >>> 32) + ((r19 * r10) + (((long) r34[r31]) & 4294967295L));
        r34[r31] = (int) r35;
        r34[r18 + 7] = (int) (r35 >>> 32);
        r18 = r110;
        r1 = r1;
        r6 = r26;
        r8 = r30;
        r17 = 7;
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
        long r21 = (r12 >>> 32) + (((r0 * r20) + r11) + (((long) r16[r17 + 4]) & 4294967295L));
        r18[r19 + 4] = (int) r21;
        long r22 = ((long) r14[r15 + 5]) & 4294967295L;
        long r23 = (r21 >>> 32) + (((r0 * r22) + r20) + (((long) r16[r17 + 5]) & 4294967295L));
        r18[r19 + 5] = (int) r23;
        long r24 = ((long) r14[r15 + 6]) & 4294967295L;
        long r25 = (r23 >>> 32) + (((r0 * r24) + r22) + (4294967295L & ((long) r16[r17 + 6])));
        r18[r19 + 6] = (int) r25;
        return (r25 >>> 32) + r24;
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
        return Nat.incAt(7, r18, r19, 4);
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
        return Nat.incAt(7, r12, r13, 3);
    }

    public static int mulAddTo(int[] r32, int[] r33, int[] r34) {
        long r1 = ((long) r33[0]) & 4294967295L;
        long r5 = ((long) r33[1]) & 4294967295L;
        long r7 = ((long) r33[2]) & 4294967295L;
        long r9 = ((long) r33[3]) & 4294967295L;
        long r11 = ((long) r33[4]) & 4294967295L;
        long r13 = ((long) r33[5]) & 4294967295L;
        long r0 = ((long) r33[6]) & 4294967295L;
        long r21 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 7) goto L7;
        long r23 = r0;
        long r3 = ((long) r32[r2]) & 4294967295L;
        int r25 = r2 + 0;
        long r26 = r13;
        long r14 = ((r3 * r1) + (((long) r34[r25]) & 4294967295L)) + 0;
        r34[r25] = (int) r14;
        int r16 = r2 + 1;
        long r30 = r5;
        long r15 = (r14 >>> 32) + ((r3 * r5) + (((long) r34[r16]) & 4294967295L));
        r34[r16] = (int) r15;
        int r6 = r2 + 2;
        long r17 = (r15 >>> 32) + ((r3 * r7) + (((long) r34[r6]) & 4294967295L));
        r34[r6] = (int) r17;
        int r8 = r2 + 3;
        long r18 = (r17 >>> 32) + ((r3 * r9) + (((long) r34[r8]) & 4294967295L));
        r34[r8] = (int) r18;
        int r10 = r2 + 4;
        long r19 = (r18 >>> 32) + ((r3 * r11) + (((long) r34[r10]) & 4294967295L));
        r34[r10] = (int) r19;
        int r12 = r2 + 5;
        long r110 = (r19 >>> 32) + ((r3 * r26) + (((long) r34[r12]) & 4294967295L));
        r34[r12] = (int) r110;
        int r20 = r2 + 6;
        long r111 = (r110 >>> 32) + ((r3 * r23) + (((long) r34[r20]) & 4294967295L));
        r34[r20] = (int) r111;
        int r4 = r2 + 7;
        long r22 = ((r111 >>> 32) + (((long) r34[r4]) & 4294967295L)) + r21;
        r34[r4] = (int) r22;
        r21 = r22 >>> 32;
        r2 = r16;
        r0 = r23;
        r13 = r26;
        r5 = r30;
        goto L4
    L7:
        return (int) r21;
    }

    public static void square(int[] r40, int[] r41) {
        long r1 = ((long) r40[0]) & 4294967295L;
        int r6 = 14;
        int r8 = 0;
        int r7 = 6;
    L3:
        int r9 = r7 - 1;
        long r10 = ((long) r40[r7]) & 4294967295L;
        long r11 = r10 * r10;
        int r12 = r6 - 1;
        r41[r12] = (r8 << 31) | ((int) (r11 >>> 33));
        r6 = r12 - 1;
        r41[r6] = (int) (r11 >>> 1);
        int r13 = (int) r11;
        if (r9 <= 0) goto L5;
        r7 = r9;
        r8 = r13;
        goto L3
    L5:
        long r14 = r1 * r1;
        long r15 = (((long) (r13 << 31)) & 4294967295L) | (r14 >>> 33);
        r41[0] = (int) r14;
        long r16 = ((long) r40[1]) & 4294967295L;
        long r17 = ((long) r41[2]) & 4294967295L;
        long r18 = r15 + (r16 * r1);
        int r19 = (int) r18;
        r41[1] = (r19 << 1) | (((int) (r14 >>> 32)) & 1);
        long r110 = r17 + (r18 >>> 32);
        long r20 = ((long) r40[2]) & 4294967295L;
        long r5 = ((long) r41[3]) & 4294967295L;
        long r111 = ((long) r41[4]) & 4294967295L;
        long r112 = r110 + (r20 * r1);
        int r21 = (int) r112;
        r41[2] = (r21 << 1) | (r19 >>> 31);
        long r22 = r5 + ((r112 >>> 32) + (r20 * r16));
        long r113 = r111 + (r22 >>> 32);
        long r114 = ((long) r40[3]) & 4294967295L;
        long r23 = (((long) r41[5]) & 4294967295L) + (r113 >>> 32);
        long r115 = r113 & 4294967295L;
        long r116 = (((long) r41[6]) & 4294967295L) + (r23 >>> 32);
        long r24 = (r22 & 4294967295L) + (r114 * r1);
        int r3 = (int) r24;
        r41[3] = (r3 << 1) | (r21 >>> 31);
        long r4 = r115 + ((r24 >>> 32) + (r114 * r16));
        long r25 = (r23 & 4294967295L) + ((r4 >>> 32) + (r114 * r20));
        long r117 = r116 + (r25 >>> 32);
        long r26 = r25 & 4294967295L;
        long r118 = ((long) r40[4]) & 4294967295L;
        long r27 = (((long) r41[7]) & 4294967295L) + (r117 >>> 32);
        long r119 = r117 & 4294967295L;
        long r120 = (((long) r41[8]) & 4294967295L) + (r27 >>> 32);
        long r28 = (r4 & 4294967295L) + (r118 * r1);
        int r0 = (int) r28;
        r41[4] = (r3 >>> 31) | (r0 << 1);
        long r29 = r26 + ((r28 >>> 32) + (r118 * r16));
        long r30 = r119 + ((r29 >>> 32) + (r118 * r20));
        long r31 = (r27 & 4294967295L) + ((r30 >>> 32) + (r118 * r114));
        long r121 = r120 + (r31 >>> 32);
        long r122 = ((long) r40[5]) & 4294967295L;
        long r32 = (((long) r41[9]) & 4294967295L) + (r121 >>> 32);
        long r123 = r121 & 4294967295L;
        long r124 = (((long) r41[10]) & 4294967295L) + (r32 >>> 32);
        long r33 = (r29 & 4294967295L) + (r122 * r1);
        int r34 = (int) r33;
        r41[5] = (r34 << 1) | (r0 >>> 31);
        long r35 = (r30 & 4294967295L) + ((r33 >>> 32) + (r122 * r16));
        long r36 = (r31 & 4294967295L) + ((r35 >>> 32) + (r122 * r20));
        long r210 = r123 + ((r36 >>> 32) + (r122 * r114));
        long r37 = (r32 & 4294967295L) + ((r210 >>> 32) + (r122 * r118));
        long r125 = r124 + (r37 >>> 32);
        long r38 = r37 & 4294967295L;
        long r126 = ((long) r40[6]) & 4294967295L;
        long r39 = (((long) r41[11]) & 4294967295L) + (r125 >>> 32);
        long r127 = r125 & 4294967295L;
        long r128 = (((long) r41[12]) & 4294967295L) + (r39 >>> 32);
        long r42 = (r35 & 4294967295L) + (r1 * r126);
        int r2 = (int) r42;
        r41[6] = (r34 >>> 31) | (r2 << 1);
        int r43 = r2 >>> 31;
        long r44 = (r36 & 4294967295L) + ((r42 >>> 32) + (r16 * r126));
        long r45 = (r210 & 4294967295L) + ((r44 >>> 32) + (r126 * r20));
        long r46 = r38 + ((r45 >>> 32) + (r126 * r114));
        long r47 = r127 + ((r46 >>> 32) + (r126 * r118));
        long r48 = (r39 & 4294967295L) + ((r47 >>> 32) + (r126 * r122));
        long r129 = r128 + (r48 >>> 32);
        int r49 = (int) r44;
        r41[7] = r43 | (r49 << 1);
        int r50 = (int) r45;
        r41[8] = (r49 >>> 31) | (r50 << 1);
        int r51 = r50 >>> 31;
        int r52 = (int) r46;
        r41[9] = r51 | (r52 << 1);
        int r53 = r52 >>> 31;
        int r54 = (int) r47;
        r41[10] = r53 | (r54 << 1);
        int r55 = r54 >>> 31;
        int r56 = (int) r48;
        r41[11] = r55 | (r56 << 1);
        int r57 = r56 >>> 31;
        int r58 = (int) r129;
        r41[12] = r57 | (r58 << 1);
        r41[13] = (r58 >>> 31) | ((r41[13] + ((int) (r129 >>> 32))) << 1);
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
        long r6 = (r5 >> 32) + ((((long) r10[5]) & 4294967295L) - (((long) r11[5]) & 4294967295L));
        r12[5] = (int) r6;
        long r7 = (r6 >> 32) + ((((long) r10[6]) & 4294967295L) - (((long) r11[6]) & 4294967295L));
        r12[6] = (int) r7;
        return (int) (r7 >> 32);
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
        long r5 = (r4 >> 32) + ((((long) r11[4]) & 4294967295L) - (((long) r10[4]) & 4294967295L));
        r11[4] = (int) r5;
        long r6 = (r5 >> 32) + ((((long) r11[5]) & 4294967295L) - (((long) r10[5]) & 4294967295L));
        r11[5] = (int) r6;
        long r7 = (r6 >> 32) + ((((long) r11[6]) & 4294967295L) - (4294967295L & ((long) r10[6])));
        r11[6] = (int) r7;
        return (int) (r7 >> 32);
    }

    public static BigInteger toBigInteger(int[] r4) {
        byte[] r0 = new byte[28];
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L10;
        int r2 = r4[r1];
        if (r2 == 0) goto L8;
        Pack.intToBigEndian(r2, r0, (6 - r1) << 2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
