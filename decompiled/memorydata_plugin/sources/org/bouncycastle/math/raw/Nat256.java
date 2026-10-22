package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat256 {
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
        long r8 = (r7 >>> 32) + ((((long) r10[7]) & 4294967295L) + (((long) r11[7]) & 4294967295L));
        r12[7] = (int) r8;
        return (int) (r8 >>> 32);
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
        long r8 = (r7 >>> 32) + (((((long) r10[7]) & 4294967295L) + (((long) r11[7]) & 4294967295L)) + (((long) r12[7]) & 4294967295L));
        r12[7] = (int) r8;
        return (int) (r8 >>> 32);
    }

    public static int addTo(int[] r9, int r10, int[] r11, int r12, int r13) {
        long r0 = ((long) r13) & 4294967295L;
        long r4 = ((long) r9[r10 + 0]) & 4294967295L;
        int r14 = r12 + 0;
        long r1 = r0 + (r4 + (((long) r11[r14]) & 4294967295L));
        r11[r14] = (int) r1;
        int r6 = r12 + 1;
        long r2 = (r1 >>> 32) + ((((long) r9[r10 + 1]) & 4294967295L) + (((long) r11[r6]) & 4294967295L));
        r11[r6] = (int) r2;
        int r7 = r12 + 2;
        long r3 = (r2 >>> 32) + ((((long) r9[r10 + 2]) & 4294967295L) + (((long) r11[r7]) & 4294967295L));
        r11[r7] = (int) r3;
        int r8 = r12 + 3;
        long r5 = (r3 >>> 32) + ((((long) r9[r10 + 3]) & 4294967295L) + (((long) r11[r8]) & 4294967295L));
        r11[r8] = (int) r5;
        int r15 = r12 + 4;
        long r16 = (r5 >>> 32) + ((((long) r9[r10 + 4]) & 4294967295L) + (((long) r11[r15]) & 4294967295L));
        r11[r15] = (int) r16;
        int r17 = r12 + 5;
        long r18 = (r16 >>> 32) + ((((long) r9[r10 + 5]) & 4294967295L) + (((long) r11[r17]) & 4294967295L));
        r11[r17] = (int) r18;
        int r19 = r12 + 6;
        long r20 = (r18 >>> 32) + ((((long) r9[r10 + 6]) & 4294967295L) + (((long) r11[r19]) & 4294967295L));
        r11[r19] = (int) r20;
        int r110 = r12 + 7;
        long r21 = (r20 >>> 32) + ((((long) r9[r10 + 7]) & 4294967295L) + (4294967295L & ((long) r11[r110])));
        r11[r110] = (int) r21;
        return (int) (r21 >>> 32);
    }

    public static int addTo(int[] r10, int[] r11) {
        long r1 = ((((long) r10[0]) & 4294967295L) + (((long) r11[0]) & 4294967295L)) + 0;
        r11[0] = (int) r1;
        long r2 = (r1 >>> 32) + ((((long) r10[1]) & 4294967295L) + (((long) r11[1]) & 4294967295L));
        r11[1] = (int) r2;
        long r3 = (r2 >>> 32) + ((((long) r10[2]) & 4294967295L) + (((long) r11[2]) & 4294967295L));
        r11[2] = (int) r3;
        long r4 = (r3 >>> 32) + ((((long) r10[3]) & 4294967295L) + (((long) r11[3]) & 4294967295L));
        r11[3] = (int) r4;
        long r5 = (r4 >>> 32) + ((((long) r10[4]) & 4294967295L) + (((long) r11[4]) & 4294967295L));
        r11[4] = (int) r5;
        long r6 = (r5 >>> 32) + ((((long) r10[5]) & 4294967295L) + (((long) r11[5]) & 4294967295L));
        r11[5] = (int) r6;
        long r7 = (r6 >>> 32) + ((((long) r10[6]) & 4294967295L) + (((long) r11[6]) & 4294967295L));
        r11[6] = (int) r7;
        long r8 = (r7 >>> 32) + ((((long) r10[7]) & 4294967295L) + (4294967295L & ((long) r11[7])));
        r11[7] = (int) r8;
        return (int) (r8 >>> 32);
    }

    public static int addToEachOther(int[] r11, int r12, int[] r13, int r14) {
        int r0 = r12 + 0;
        int r5 = r14 + 0;
        long r1 = ((((long) r11[r0]) & 4294967295L) + (((long) r13[r5]) & 4294967295L)) + 0;
        int r6 = (int) r1;
        r11[r0] = r6;
        r13[r5] = r6;
        int r7 = r12 + 1;
        int r8 = r14 + 1;
        long r2 = (r1 >>> 32) + ((((long) r11[r7]) & 4294967295L) + (((long) r13[r8]) & 4294967295L));
        int r9 = (int) r2;
        r11[r7] = r9;
        r13[r8] = r9;
        int r10 = r12 + 2;
        int r15 = r14 + 2;
        long r3 = (r2 >>> 32) + ((((long) r11[r10]) & 4294967295L) + (((long) r13[r15]) & 4294967295L));
        int r16 = (int) r3;
        r11[r10] = r16;
        r13[r15] = r16;
        int r17 = r12 + 3;
        int r18 = r14 + 3;
        long r4 = (r3 >>> 32) + ((((long) r11[r17]) & 4294967295L) + (((long) r13[r18]) & 4294967295L));
        int r19 = (int) r4;
        r11[r17] = r19;
        r13[r18] = r19;
        int r20 = r12 + 4;
        int r21 = r14 + 4;
        long r22 = (r4 >>> 32) + ((((long) r11[r20]) & 4294967295L) + (((long) r13[r21]) & 4294967295L));
        int r23 = (int) r22;
        r11[r20] = r23;
        r13[r21] = r23;
        int r24 = r12 + 5;
        int r25 = r14 + 5;
        long r26 = (r22 >>> 32) + ((((long) r11[r24]) & 4294967295L) + (((long) r13[r25]) & 4294967295L));
        int r27 = (int) r26;
        r11[r24] = r27;
        r13[r25] = r27;
        int r28 = r12 + 6;
        int r29 = r14 + 6;
        long r30 = (r26 >>> 32) + ((((long) r11[r28]) & 4294967295L) + (((long) r13[r29]) & 4294967295L));
        int r31 = (int) r30;
        r11[r28] = r31;
        r13[r29] = r31;
        int r110 = r12 + 7;
        int r111 = r14 + 7;
        long r32 = (r30 >>> 32) + ((((long) r11[r110]) & 4294967295L) + (4294967295L & ((long) r13[r111])));
        int r33 = (int) r32;
        r11[r110] = r33;
        r13[r111] = r33;
        return (int) (r32 >>> 32);
    }

    public static void copy(int[] r2, int r3, int[] r4, int r5) {
        r4[r5 + 0] = r2[r3 + 0];
        r4[r5 + 1] = r2[r3 + 1];
        r4[r5 + 2] = r2[r3 + 2];
        r4[r5 + 3] = r2[r3 + 3];
        r4[r5 + 4] = r2[r3 + 4];
        r4[r5 + 5] = r2[r3 + 5];
        r4[r5 + 6] = r2[r3 + 6];
        r4[r5 + 7] = r2[r3 + 7];
    }

    public static void copy64(long[] r3, int r4, long[] r5, int r6) {
        r5[r6 + 0] = r3[r4 + 0];
        r5[r6 + 1] = r3[r4 + 1];
        r5[r6 + 2] = r3[r4 + 2];
        r5[r6 + 3] = r3[r4 + 3];
    }

    public static void copy64(long[] r3, long[] r4) {
        r4[0] = r3[0];
        r4[1] = r3[1];
        r4[2] = r3[2];
        r4[3] = r3[3];
    }

    public static int[] create() {
        return new int[8];
    }

    public static long[] create64() {
        return new long[4];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static long[] createExt64() {
        return new long[8];
    }

    public static boolean diff(int[] r7, int r8, int[] r9, int r10, int[] r11, int r12) {
        boolean r0 = gte(r7, r8, r9, r10);
        if (r0 == false) goto L5;
        sub(r7, r8, r9, r10, r11, r12);
    L6:
        return r0;
    L5:
        sub(r9, r10, r7, r8, r11, r12);
        goto L6
    }

    public static boolean eq(int[] r3, int[] r4) {
        int r0 = 7;
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

    public static boolean eq64(long[] r5, long[] r6) {
        int r0 = 3;
    L3:
        if (r0 < 0) goto L9;
        if (r5[r0] != r6[r0]) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static int[] fromBigInteger(BigInteger r3) {
        if (r3.signum() < 0) goto L12;
        if (r3.bitLength() > 256) goto L12;
        int[] r0 = create();
        int r1 = 0;
    L8:
        if (r1 >= 8) goto L10;
        r0[r1] = r3.intValue();
        r3 = r3.shiftRight(32);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    L12:
        throw new IllegalArgumentException();
    }

    public static int getBit(int[] r2, int r3) {
        if (r3 != 0) goto L8;
        int r4 = r2[0];
    L6:
        return r4 & 1;
    L8:
        if ((r3 & 255) == r3) goto L10;
        return 0;
    L10:
        int r0 = r3 >>> 5;
        int r5 = r2[r0];
        r4 = r5 >>> (r3 & 31);
        goto L6
    }

    public static boolean gte(int[] r5, int r6, int[] r7, int r8) {
        int r0 = 7;
    L4:
        if (r0 < 0) goto L12;
        int r2 = r5[r6 + r0] ^ Integer.MIN_VALUE;
        int r3 = Integer.MIN_VALUE ^ r7[r8 + r0];
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

    public static boolean gte(int[] r5, int[] r6) {
        int r0 = 7;
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
        if (r1 >= 8) goto L12;
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
        if (r2 >= 4) goto L12;
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
        if (r1 >= 8) goto L9;
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
        if (r1 >= 4) goto L9;
        if (r6[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r32, int r33, int[] r34, int r35, int[] r36, int r37) {
        long r0 = ((long) r34[r35 + 0]) & 4294967295L;
        long r4 = ((long) r34[r35 + 1]) & 4294967295L;
        long r6 = ((long) r34[r35 + 2]) & 4294967295L;
        long r8 = ((long) r34[r35 + 3]) & 4294967295L;
        long r10 = ((long) r34[r35 + 4]) & 4294967295L;
        long r12 = ((long) r34[r35 + 5]) & 4294967295L;
        long r14 = ((long) r34[r35 + 6]) & 4294967295L;
        long r15 = ((long) r34[r35 + 7]) & 4294967295L;
        long r16 = ((long) r32[r33 + 0]) & 4294967295L;
        long r2 = (r16 * r0) + 0;
        r36[r37 + 0] = (int) r2;
        long r1 = (r2 >>> 32) + (r16 * r4);
        r36[r37 + 1] = (int) r1;
        long r3 = (r1 >>> 32) + (r16 * r6);
        r36[r37 + 2] = (int) r3;
        long r5 = (r3 >>> 32) + (r16 * r8);
        r36[r37 + 3] = (int) r5;
        long r7 = (r5 >>> 32) + (r16 * r10);
        r36[r37 + 4] = (int) r7;
        long r9 = (r7 >>> 32) + (r16 * r12);
        r36[r37 + 5] = (int) r9;
        long r11 = (r9 >>> 32) + (r16 * r14);
        r36[r37 + 6] = (int) r11;
        long r13 = (r11 >>> 32) + (r16 * r15);
        r36[r37 + 7] = (int) r13;
        r36[r37 + 8] = (int) (r13 >>> 32);
        int r17 = 1;
        int r18 = r37;
        int r19 = 1;
    L4:
        if (r19 >= 8) goto L6;
        r18 = r18 + r17;
        long r20 = ((long) r32[r33 + r19]) & 4294967295L;
        int r110 = r18 + 0;
        long r21 = ((r20 * r0) + (((long) r36[r110]) & 4294967295L)) + 0;
        r36[r110] = (int) r21;
        int r27 = r18 + 1;
        long r28 = r12;
        long r22 = (r21 >>> 32) + ((r20 * r4) + (((long) r36[r27]) & 4294967295L));
        r36[r27] = (int) r22;
        int r111 = r18 + 2;
        long r23 = (r22 >>> 32) + ((r20 * r6) + (((long) r36[r111]) & 4294967295L));
        r36[r111] = (int) r23;
        int r24 = r18 + 3;
        long r25 = (r23 >>> 32) + ((r20 * r8) + (((long) r36[r24]) & 4294967295L));
        r36[r24] = (int) r25;
        int r26 = r18 + 4;
        long r29 = (r25 >>> 32) + ((r20 * r10) + (((long) r36[r26]) & 4294967295L));
        r36[r26] = (int) r29;
        int r30 = r18 + 5;
        long r31 = (r29 >>> 32) + ((r20 * r28) + (((long) r36[r30]) & 4294967295L));
        r36[r30] = (int) r31;
        int r38 = r18 + 6;
        long r39 = (r31 >>> 32) + ((r20 * r14) + (((long) r36[r38]) & 4294967295L));
        r36[r38] = (int) r39;
        int r40 = r18 + 7;
        long r41 = (r39 >>> 32) + ((r20 * r15) + (((long) r36[r40]) & 4294967295L));
        r36[r40] = (int) r41;
        r36[r18 + 8] = (int) (r41 >>> 32);
        r19 = r19 + 1;
        r12 = r28;
        r6 = r6;
        r17 = 1;
        goto L4
    }

    public static void mul(int[] r35, int[] r36, int[] r37) {
        long r1 = ((long) r36[0]) & 4294967295L;
        long r6 = ((long) r36[1]) & 4294967295L;
        long r9 = ((long) r36[2]) & 4294967295L;
        long r12 = ((long) r36[3]) & 4294967295L;
        long r14 = ((long) r36[4]) & 4294967295L;
        long r8 = ((long) r36[5]) & 4294967295L;
        long r10 = ((long) r36[6]) & 4294967295L;
        long r11 = ((long) r36[7]) & 4294967295L;
        long r13 = ((long) r35[0]) & 4294967295L;
        long r3 = (r13 * r1) + 0;
        r37[0] = (int) r3;
        long r4 = (r3 >>> 32) + (r13 * r6);
        r37[1] = (int) r4;
        long r5 = (r4 >>> 32) + (r13 * r9);
        r37[2] = (int) r5;
        long r7 = (r5 >>> 32) + (r13 * r12);
        r37[3] = (int) r7;
        long r15 = (r7 >>> 32) + (r13 * r14);
        r37[4] = (int) r15;
        long r16 = (r15 >>> 32) + (r13 * r8);
        r37[5] = (int) r16;
        long r17 = (r16 >>> 32) + (r13 * r10);
        r37[6] = (int) r17;
        long r18 = (r17 >>> 32) + (r13 * r11);
        r37[7] = (int) r18;
        int r19 = 8;
        r37[8] = (int) (r18 >>> 32);
        int r20 = 1;
    L3:
        if (r20 >= r19) goto L5;
        long r110 = ((long) r35[r20]) & 4294967295L;
        int r21 = r20 + 0;
        long r0 = ((r110 * r1) + (((long) r37[r21]) & 4294967295L)) + 0;
        r37[r21] = (int) r0;
        int r111 = r20 + 1;
        long r29 = r6;
        long r2 = (r0 >>> 32) + ((r110 * r6) + (((long) r37[r111]) & 4294967295L));
        r37[r111] = (int) r2;
        int r22 = r20 + 2;
        long r33 = r8;
        long r23 = (r2 >>> 32) + ((r110 * r9) + (((long) r37[r22]) & 4294967295L));
        r37[r22] = (int) r23;
        int r24 = r20 + 3;
        long r25 = (r23 >>> 32) + ((r110 * r12) + (((long) r37[r24]) & 4294967295L));
        r37[r24] = (int) r25;
        int r26 = r20 + 4;
        long r27 = (r25 >>> 32) + ((r110 * r14) + (((long) r37[r26]) & 4294967295L));
        r37[r26] = (int) r27;
        int r28 = r20 + 5;
        long r30 = (r27 >>> 32) + ((r110 * r33) + (((long) r37[r28]) & 4294967295L));
        r37[r28] = (int) r30;
        int r31 = r20 + 6;
        long r32 = (r30 >>> 32) + ((r110 * r10) + (((long) r37[r31]) & 4294967295L));
        r37[r31] = (int) r32;
        int r34 = r20 + 7;
        long r38 = (r32 >>> 32) + ((r110 * r11) + (((long) r37[r34]) & 4294967295L));
        r37[r34] = (int) r38;
        r37[r20 + 8] = (int) (r38 >>> 32);
        r20 = r111;
        r1 = r1;
        r6 = r29;
        r8 = r33;
        r19 = 8;
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
        long r25 = (r23 >>> 32) + (((r0 * r24) + r22) + (((long) r16[r17 + 6]) & 4294967295L));
        r18[r19 + 6] = (int) r25;
        long r26 = ((long) r14[r15 + 7]) & 4294967295L;
        long r27 = (r25 >>> 32) + (((r0 * r26) + r24) + (4294967295L & ((long) r16[r17 + 7])));
        r18[r19 + 7] = (int) r27;
        return (r27 >>> 32) + r26;
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
        return Nat.incAt(8, r18, r19, 4);
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
        return Nat.incAt(8, r12, r13, 3);
    }

    public static int mulAddTo(int[] r34, int[] r35, int[] r36) {
        long r1 = ((long) r35[0]) & 4294967295L;
        long r5 = ((long) r35[1]) & 4294967295L;
        long r7 = ((long) r35[2]) & 4294967295L;
        long r9 = ((long) r35[3]) & 4294967295L;
        long r11 = ((long) r35[4]) & 4294967295L;
        long r13 = ((long) r35[5]) & 4294967295L;
        long r0 = ((long) r35[6]) & 4294967295L;
        long r2 = ((long) r35[7]) & 4294967295L;
        long r23 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 8) goto L7;
        long r25 = r2;
        long r4 = ((long) r34[r3]) & 4294967295L;
        int r27 = r3 + 0;
        long r28 = r13;
        long r14 = ((r4 * r1) + (((long) r36[r27]) & 4294967295L)) + 0;
        r36[r27] = (int) r14;
        int r16 = r3 + 1;
        long r32 = r5;
        long r15 = (r14 >>> 32) + ((r4 * r5) + (((long) r36[r16]) & 4294967295L));
        r36[r16] = (int) r15;
        int r6 = r3 + 2;
        long r17 = (r15 >>> 32) + ((r4 * r7) + (((long) r36[r6]) & 4294967295L));
        r36[r6] = (int) r17;
        int r8 = r3 + 3;
        long r18 = (r17 >>> 32) + ((r4 * r9) + (((long) r36[r8]) & 4294967295L));
        r36[r8] = (int) r18;
        int r10 = r3 + 4;
        long r19 = (r18 >>> 32) + ((r4 * r11) + (((long) r36[r10]) & 4294967295L));
        r36[r10] = (int) r19;
        int r12 = r3 + 5;
        long r110 = (r19 >>> 32) + ((r4 * r28) + (((long) r36[r12]) & 4294967295L));
        r36[r12] = (int) r110;
        int r20 = r3 + 6;
        long r111 = (r110 >>> 32) + ((r4 * r0) + (((long) r36[r20]) & 4294967295L));
        r36[r20] = (int) r111;
        int r21 = r3 + 7;
        long r112 = (r111 >>> 32) + ((r4 * r25) + (((long) r36[r21]) & 4294967295L));
        r36[r21] = (int) r112;
        int r22 = r3 + 8;
        long r24 = ((r112 >>> 32) + (((long) r36[r22]) & 4294967295L)) + r23;
        r36[r22] = (int) r24;
        r23 = r24 >>> 32;
        r3 = r16;
        r2 = r25;
        r13 = r28;
        r5 = r32;
        goto L4
    L7:
        return (int) r23;
    }

    public static int mulByWordAddTo(int r11, int[] r12, int[] r13) {
        long r0 = ((long) r11) & 4294967295L;
        long r4 = (((((long) r13[0]) & 4294967295L) * r0) + (((long) r12[0]) & 4294967295L)) + 0;
        r13[0] = (int) r4;
        long r5 = (r4 >>> 32) + (((((long) r13[1]) & 4294967295L) * r0) + (((long) r12[1]) & 4294967295L));
        r13[1] = (int) r5;
        long r6 = (r5 >>> 32) + (((((long) r13[2]) & 4294967295L) * r0) + (((long) r12[2]) & 4294967295L));
        r13[2] = (int) r6;
        long r7 = (r6 >>> 32) + (((((long) r13[3]) & 4294967295L) * r0) + (((long) r12[3]) & 4294967295L));
        r13[3] = (int) r7;
        long r8 = (r7 >>> 32) + (((((long) r13[4]) & 4294967295L) * r0) + (((long) r12[4]) & 4294967295L));
        r13[4] = (int) r8;
        long r9 = (r8 >>> 32) + (((((long) r13[5]) & 4294967295L) * r0) + (((long) r12[5]) & 4294967295L));
        r13[5] = (int) r9;
        long r10 = (r9 >>> 32) + (((((long) r13[6]) & 4294967295L) * r0) + (((long) r12[6]) & 4294967295L));
        r13[6] = (int) r10;
        long r14 = (r10 >>> 32) + ((r0 * (((long) r13[7]) & 4294967295L)) + (4294967295L & ((long) r12[7])));
        r13[7] = (int) r14;
        return (int) (r14 >>> 32);
    }

    public static void square(int[] r47, int r48, int[] r49, int r50) {
        long r0 = ((long) r47[r48 + 0]) & 4294967295L;
        int r5 = 0;
        int r6 = 16;
        int r7 = 7;
    L3:
        int r8 = r7 - 1;
        long r9 = ((long) r47[r48 + r7]) & 4294967295L;
        long r10 = r9 * r9;
        int r11 = r6 - 1;
        r49[r50 + r11] = (r5 << 31) | ((int) (r10 >>> 33));
        r6 = r11 - 1;
        r49[r50 + r6] = (int) (r10 >>> 1);
        r5 = (int) r10;
        if (r8 <= 0) goto L5;
        r7 = r8;
        goto L3
    L5:
        long r12 = r0 * r0;
        r49[r50 + 0] = (int) r12;
        long r13 = ((long) r47[r48 + 1]) & 4294967295L;
        int r14 = r50 + 2;
        long r15 = ((long) r49[r14]) & 4294967295L;
        long r16 = ((((long) (r5 << 31)) & 4294967295L) | (r12 >>> 33)) + (r13 * r0);
        int r17 = (int) r16;
        r49[r50 + 1] = (r17 << 1) | (((int) (r12 >>> 32)) & 1);
        int r18 = r17 >>> 31;
        long r19 = r15 + (r16 >>> 32);
        long r20 = ((long) r47[r48 + 2]) & 4294967295L;
        int r110 = r50 + 3;
        long r111 = ((long) r49[r110]) & 4294967295L;
        int r21 = r50 + 4;
        long r112 = ((long) r49[r21]) & 4294967295L;
        long r113 = r19 + (r20 * r0);
        int r114 = (int) r113;
        r49[r14] = (r114 << 1) | r18;
        int r22 = r114 >>> 31;
        long r115 = r111 + ((r113 >>> 32) + (r20 * r13));
        long r116 = r112 + (r115 >>> 32);
        long r4 = ((long) r47[r48 + 3]) & 4294967295L;
        int r23 = r50 + 5;
        long r117 = (((long) r49[r23]) & 4294967295L) + (r116 >>> 32);
        int r24 = r50 + 6;
        long r25 = (((long) r49[r24]) & 4294967295L) + (r117 >>> 32);
        long r118 = (r115 & 4294967295L) + (r4 * r0);
        int r2 = (int) r118;
        r49[r110] = (r2 << 1) | r22;
        long r119 = (r116 & 4294967295L) + ((r118 >>> 32) + (r4 * r13));
        long r120 = (r117 & 4294967295L) + ((r119 >>> 32) + (r4 * r20));
        long r26 = r25 + (r120 >>> 32);
        long r27 = r120 & 4294967295L;
        long r121 = ((long) r47[r48 + 4]) & 4294967295L;
        int r3 = r50 + 7;
        long r28 = (((long) r49[r3]) & 4294967295L) + (r26 >>> 32);
        long r29 = r26 & 4294967295L;
        int r210 = r50 + 8;
        long r30 = (((long) r49[r210]) & 4294967295L) + (r28 >>> 32);
        long r122 = (r119 & 4294967295L) + (r121 * r0);
        int r31 = (int) r122;
        r49[r21] = (r2 >>> 31) | (r31 << 1);
        int r32 = r31 >>> 31;
        long r33 = r27 + ((r122 >>> 32) + (r121 * r13));
        long r123 = r29 + ((r33 >>> 32) + (r121 * r20));
        long r34 = (r28 & 4294967295L) + ((r123 >>> 32) + (r121 * r4));
        long r35 = r30 + (r34 >>> 32);
        long r36 = r34 & 4294967295L;
        long r124 = ((long) r47[r48 + 5]) & 4294967295L;
        int r37 = r50 + 9;
        long r38 = (((long) r49[r37]) & 4294967295L) + (r35 >>> 32);
        int r211 = r50 + 10;
        long r39 = (((long) r49[r211]) & 4294967295L) + (r38 >>> 32);
        long r40 = (r33 & 4294967295L) + (r124 * r0);
        int r41 = (int) r40;
        r49[r23] = r32 | (r41 << 1);
        int r42 = r41 >>> 31;
        long r125 = (r123 & 4294967295L) + ((r40 >>> 32) + (r124 * r13));
        long r43 = r36 + ((r125 >>> 32) + (r124 * r20));
        long r212 = (r35 & 4294967295L) + ((r43 >>> 32) + (r124 * r4));
        long r44 = (r38 & 4294967295L) + ((r212 >>> 32) + (r124 * r121));
        long r310 = r212 & 4294967295L;
        long r45 = r39 + (r44 >>> 32);
        long r46 = r44 & 4294967295L;
        long r126 = ((long) r47[r48 + 6]) & 4294967295L;
        int r127 = r50 + 11;
        long r51 = (((long) r49[r127]) & 4294967295L) + (r45 >>> 32);
        long r52 = r45 & 4294967295L;
        int r213 = r50 + 12;
        long r53 = (((long) r49[r213]) & 4294967295L) + (r51 >>> 32);
        long r54 = (r125 & 4294967295L) + (r126 * r0);
        int r128 = (int) r54;
        r49[r24] = r42 | (r128 << 1);
        int r55 = r128 >>> 31;
        long r56 = (r43 & 4294967295L) + ((r54 >>> 32) + (r126 * r13));
        long r311 = r310 + ((r56 >>> 32) + (r126 * r20));
        long r129 = r46 + ((r311 >>> 32) + (r126 * r4));
        long r214 = r311 & 4294967295L;
        long r312 = r52 + ((r129 >>> 32) + (r126 * r121));
        long r57 = (r51 & 4294967295L) + ((r312 >>> 32) + (r126 * r124));
        long r58 = r53 + (r57 >>> 32);
        long r59 = r57 & 4294967295L;
        long r130 = ((long) r47[r48 + 7]) & 4294967295L;
        int r131 = r50 + 13;
        long r60 = (((long) r49[r131]) & 4294967295L) + (r58 >>> 32);
        long r61 = r58 & 4294967295L;
        int r410 = r50 + 14;
        long r62 = (((long) r49[r410]) & 4294967295L) + (r60 >>> 32);
        long r63 = (r56 & 4294967295L) + (r0 * r130);
        int r1 = (int) r63;
        r49[r3] = (r1 << 1) | r55;
        long r64 = r214 + ((r63 >>> 32) + (r130 * r13));
        long r132 = (r129 & 4294967295L) + ((r64 >>> 32) + (r130 * r20));
        long r65 = (r312 & 4294967295L) + ((r132 >>> 32) + (r130 * r4));
        long r66 = r59 + ((r65 >>> 32) + (r130 * r121));
        long r67 = r61 + ((r66 >>> 32) + (r130 * r124));
        long r68 = (r60 & 4294967295L) + ((r67 >>> 32) + (r130 * r126));
        long r69 = r62 + (r68 >>> 32);
        int r70 = (int) r64;
        r49[r210] = (r1 >>> 31) | (r70 << 1);
        int r71 = r70 >>> 31;
        int r72 = (int) r132;
        r49[r37] = r71 | (r72 << 1);
        int r73 = r72 >>> 31;
        int r74 = (int) r65;
        r49[r211] = r73 | (r74 << 1);
        int r75 = r74 >>> 31;
        int r76 = (int) r66;
        r49[r127] = r75 | (r76 << 1);
        int r77 = r76 >>> 31;
        int r78 = (int) r67;
        r49[r213] = r77 | (r78 << 1);
        int r79 = r78 >>> 31;
        int r80 = (int) r68;
        r49[r131] = r79 | (r80 << 1);
        int r81 = r80 >>> 31;
        int r82 = (int) r69;
        r49[r410] = r81 | (r82 << 1);
        int r83 = r82 >>> 31;
        int r84 = r50 + 15;
        r49[r84] = r83 | ((r49[r84] + ((int) (r69 >>> 32))) << 1);
    }

    public static void square(int[] r48, int[] r49) {
        long r1 = ((long) r48[0]) & 4294967295L;
        int r6 = 16;
        int r8 = 0;
        int r7 = 7;
    L3:
        int r9 = r7 - 1;
        long r10 = ((long) r48[r7]) & 4294967295L;
        long r11 = r10 * r10;
        int r12 = r6 - 1;
        r49[r12] = (r8 << 31) | ((int) (r11 >>> 33));
        r6 = r12 - 1;
        r49[r6] = (int) (r11 >>> 1);
        int r13 = (int) r11;
        if (r9 <= 0) goto L5;
        r7 = r9;
        r8 = r13;
        goto L3
    L5:
        long r14 = r1 * r1;
        long r15 = (((long) (r13 << 31)) & 4294967295L) | (r14 >>> 33);
        r49[0] = (int) r14;
        long r16 = ((long) r48[1]) & 4294967295L;
        long r17 = ((long) r49[2]) & 4294967295L;
        long r18 = r15 + (r16 * r1);
        int r19 = (int) r18;
        r49[1] = (r19 << 1) | (((int) (r14 >>> 32)) & 1);
        long r110 = r17 + (r18 >>> 32);
        long r20 = ((long) r48[2]) & 4294967295L;
        long r5 = ((long) r49[3]) & 4294967295L;
        long r111 = ((long) r49[4]) & 4294967295L;
        long r112 = r110 + (r20 * r1);
        int r21 = (int) r112;
        r49[2] = (r21 << 1) | (r19 >>> 31);
        long r22 = r5 + ((r112 >>> 32) + (r20 * r16));
        long r113 = r111 + (r22 >>> 32);
        long r114 = ((long) r48[3]) & 4294967295L;
        long r23 = (((long) r49[5]) & 4294967295L) + (r113 >>> 32);
        long r115 = r113 & 4294967295L;
        long r116 = (((long) r49[6]) & 4294967295L) + (r23 >>> 32);
        long r24 = (r22 & 4294967295L) + (r114 * r1);
        int r3 = (int) r24;
        r49[3] = (r3 << 1) | (r21 >>> 31);
        long r4 = r115 + ((r24 >>> 32) + (r114 * r16));
        long r25 = (r23 & 4294967295L) + ((r4 >>> 32) + (r114 * r20));
        long r117 = r116 + (r25 >>> 32);
        long r26 = r25 & 4294967295L;
        long r118 = ((long) r48[4]) & 4294967295L;
        long r27 = (((long) r49[7]) & 4294967295L) + (r117 >>> 32);
        long r119 = r117 & 4294967295L;
        long r120 = (((long) r49[8]) & 4294967295L) + (r27 >>> 32);
        long r28 = (r4 & 4294967295L) + (r118 * r1);
        int r29 = (int) r28;
        r49[4] = (r3 >>> 31) | (r29 << 1);
        int r30 = r29 >>> 31;
        long r31 = r26 + ((r28 >>> 32) + (r118 * r16));
        long r32 = r119 + ((r31 >>> 32) + (r118 * r20));
        long r33 = (r27 & 4294967295L) + ((r32 >>> 32) + (r118 * r114));
        long r121 = r120 + (r33 >>> 32);
        long r34 = r33 & 4294967295L;
        long r122 = ((long) r48[5]) & 4294967295L;
        long r35 = (((long) r49[9]) & 4294967295L) + (r121 >>> 32);
        long r123 = r121 & 4294967295L;
        long r124 = (((long) r49[10]) & 4294967295L) + (r35 >>> 32);
        long r36 = (r31 & 4294967295L) + (r122 * r1);
        int r0 = (int) r36;
        r49[5] = (r0 << 1) | r30;
        long r37 = (r32 & 4294967295L) + ((r36 >>> 32) + (r122 * r16));
        long r38 = r34 + ((r37 >>> 32) + (r122 * r20));
        long r39 = r123 + ((r38 >>> 32) + (r122 * r114));
        long r40 = (r35 & 4294967295L) + ((r39 >>> 32) + (r122 * r118));
        long r125 = r124 + (r40 >>> 32);
        long r126 = ((long) r48[6]) & 4294967295L;
        long r41 = (((long) r49[11]) & 4294967295L) + (r125 >>> 32);
        long r127 = r125 & 4294967295L;
        long r128 = (((long) r49[12]) & 4294967295L) + (r41 >>> 32);
        long r42 = (r37 & 4294967295L) + (r126 * r1);
        int r43 = (int) r42;
        r49[6] = (r43 << 1) | (r0 >>> 31);
        long r44 = (r38 & 4294967295L) + ((r42 >>> 32) + (r126 * r16));
        long r310 = (r39 & 4294967295L) + ((r44 >>> 32) + (r126 * r20));
        long r45 = (r40 & 4294967295L) + ((r310 >>> 32) + (r126 * r114));
        long r311 = r127 + ((r45 >>> 32) + (r126 * r118));
        long r46 = (r41 & 4294967295L) + ((r311 >>> 32) + (r126 * r122));
        long r129 = r128 + (r46 >>> 32);
        long r47 = r46 & 4294967295L;
        long r130 = ((long) r48[7]) & 4294967295L;
        long r50 = (((long) r49[13]) & 4294967295L) + (r129 >>> 32);
        long r131 = r129 & 4294967295L;
        long r132 = (((long) r49[14]) & 4294967295L) + (r50 >>> 32);
        long r51 = (r44 & 4294967295L) + (r1 * r130);
        int r2 = (int) r51;
        r49[7] = (r43 >>> 31) | (r2 << 1);
        int r52 = r2 >>> 31;
        long r53 = (r310 & 4294967295L) + ((r51 >>> 32) + (r16 * r130));
        long r54 = (r45 & 4294967295L) + ((r53 >>> 32) + (r130 * r20));
        long r55 = (r311 & 4294967295L) + ((r54 >>> 32) + (r130 * r114));
        long r56 = r47 + ((r55 >>> 32) + (r130 * r118));
        long r57 = r131 + ((r56 >>> 32) + (r130 * r122));
        long r58 = (r50 & 4294967295L) + ((r57 >>> 32) + (r130 * r126));
        long r133 = r132 + (r58 >>> 32);
        int r59 = (int) r53;
        r49[8] = r52 | (r59 << 1);
        int r60 = r59 >>> 31;
        int r61 = (int) r54;
        r49[9] = r60 | (r61 << 1);
        int r62 = r61 >>> 31;
        int r63 = (int) r55;
        r49[10] = r62 | (r63 << 1);
        int r64 = r63 >>> 31;
        int r65 = (int) r56;
        r49[11] = r64 | (r65 << 1);
        int r66 = r65 >>> 31;
        int r67 = (int) r57;
        r49[12] = r66 | (r67 << 1);
        int r68 = r67 >>> 31;
        int r69 = (int) r58;
        r49[13] = r68 | (r69 << 1);
        int r70 = r69 >>> 31;
        int r71 = (int) r133;
        r49[14] = r70 | (r71 << 1);
        r49[15] = (r71 >>> 31) | ((r49[15] + ((int) (r133 >>> 32))) << 1);
    }

    public static int sub(int[] r9, int r10, int[] r11, int r12, int[] r13, int r14) {
        long r0 = ((((long) r9[r10 + 0]) & 4294967295L) - (((long) r11[r12 + 0]) & 4294967295L)) + 0;
        r13[r14 + 0] = (int) r0;
        long r1 = (r0 >> 32) + ((((long) r9[r10 + 1]) & 4294967295L) - (((long) r11[r12 + 1]) & 4294967295L));
        r13[r14 + 1] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r9[r10 + 2]) & 4294967295L) - (((long) r11[r12 + 2]) & 4294967295L));
        r13[r14 + 2] = (int) r2;
        long r3 = (r2 >> 32) + ((((long) r9[r10 + 3]) & 4294967295L) - (((long) r11[r12 + 3]) & 4294967295L));
        r13[r14 + 3] = (int) r3;
        long r4 = (r3 >> 32) + ((((long) r9[r10 + 4]) & 4294967295L) - (((long) r11[r12 + 4]) & 4294967295L));
        r13[r14 + 4] = (int) r4;
        long r5 = (r4 >> 32) + ((((long) r9[r10 + 5]) & 4294967295L) - (((long) r11[r12 + 5]) & 4294967295L));
        r13[r14 + 5] = (int) r5;
        long r6 = (r5 >> 32) + ((((long) r9[r10 + 6]) & 4294967295L) - (((long) r11[r12 + 6]) & 4294967295L));
        r13[r14 + 6] = (int) r6;
        long r7 = (r6 >> 32) + ((((long) r9[r10 + 7]) & 4294967295L) - (((long) r11[r12 + 7]) & 4294967295L));
        r13[r14 + 7] = (int) r7;
        return (int) (r7 >> 32);
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
        long r8 = (r7 >> 32) + ((((long) r10[7]) & 4294967295L) - (((long) r11[7]) & 4294967295L));
        r12[7] = (int) r8;
        return (int) (r8 >> 32);
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
        long r7 = (r6 >> 32) + ((((long) r11[6]) & 4294967295L) - (((long) r10[6]) & 4294967295L));
        r11[6] = (int) r7;
        long r8 = (r7 >> 32) + ((((long) r11[7]) & 4294967295L) - (4294967295L & ((long) r10[7])));
        r11[7] = (int) r8;
        return (int) (r8 >> 32);
    }

    public static BigInteger toBigInteger(int[] r4) {
        byte[] r0 = new byte[32];
        int r1 = 0;
    L4:
        if (r1 >= 8) goto L10;
        int r2 = r4[r1];
        if (r2 == 0) goto L8;
        Pack.intToBigEndian(r2, r0, (7 - r1) << 2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }

    public static BigInteger toBigInteger64(long[] r6) {
        byte[] r0 = new byte[32];
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L10;
        long r2 = r6[r1];
        if (r2 == 0) goto L8;
        Pack.longToBigEndian(r2, r0, (3 - r1) << 3);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
