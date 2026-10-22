package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat192 {
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
        return (int) (r6 >>> 32);
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
        return (int) (r6 >>> 32);
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
        long r18 = (r16 >>> 32) + ((((long) r9[r10 + 5]) & 4294967295L) + (4294967295L & ((long) r11[r17])));
        r11[r17] = (int) r18;
        return (int) (r18 >>> 32);
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
        int r110 = r12 + 5;
        int r111 = r14 + 5;
        long r24 = (r22 >>> 32) + ((((long) r11[r110]) & 4294967295L) + (4294967295L & ((long) r13[r111])));
        int r25 = (int) r24;
        r11[r110] = r25;
        r13[r111] = r25;
        return (int) (r24 >>> 32);
    }

    public static void copy(int[] r2, int r3, int[] r4, int r5) {
        r4[r5 + 0] = r2[r3 + 0];
        r4[r5 + 1] = r2[r3 + 1];
        r4[r5 + 2] = r2[r3 + 2];
        r4[r5 + 3] = r2[r3 + 3];
        r4[r5 + 4] = r2[r3 + 4];
        r4[r5 + 5] = r2[r3 + 5];
    }

    public static void copy64(long[] r3, int r4, long[] r5, int r6) {
        r5[r6 + 0] = r3[r4 + 0];
        r5[r6 + 1] = r3[r4 + 1];
        r5[r6 + 2] = r3[r4 + 2];
    }

    public static void copy64(long[] r3, long[] r4) {
        r4[0] = r3[0];
        r4[1] = r3[1];
        r4[2] = r3[2];
    }

    public static int[] create() {
        return new int[6];
    }

    public static long[] create64() {
        return new long[3];
    }

    public static int[] createExt() {
        return new int[12];
    }

    public static long[] createExt64() {
        return new long[6];
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
        int r0 = 5;
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
        int r0 = 2;
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
        if (r3.bitLength() > 192) goto L12;
        int[] r0 = create();
        int r1 = 0;
    L8:
        if (r1 >= 6) goto L10;
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
        if (r1 >= 6) goto L13;
        int r6 = r3[r1];
        r5 = r6 >>> (r4 & 31);
        goto L6
    }

    public static boolean gte(int[] r5, int r6, int[] r7, int r8) {
        int r0 = 5;
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
        int r0 = 5;
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
        if (r1 >= 6) goto L12;
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
        if (r2 >= 3) goto L12;
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
        if (r1 >= 6) goto L9;
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
        if (r1 >= 3) goto L9;
        if (r6[r1] != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r28, int r29, int[] r30, int r31, int[] r32, int r33) {
        long r0 = ((long) r30[r31 + 0]) & 4294967295L;
        long r4 = ((long) r30[r31 + 1]) & 4294967295L;
        long r6 = ((long) r30[r31 + 2]) & 4294967295L;
        long r8 = ((long) r30[r31 + 3]) & 4294967295L;
        long r10 = ((long) r30[r31 + 4]) & 4294967295L;
        long r12 = ((long) r30[r31 + 5]) & 4294967295L;
        long r14 = ((long) r28[r29 + 0]) & 4294967295L;
        long r2 = (r14 * r0) + 0;
        r32[r33 + 0] = (int) r2;
        long r1 = (r2 >>> 32) + (r14 * r4);
        r32[r33 + 1] = (int) r1;
        long r3 = (r1 >>> 32) + (r14 * r6);
        r32[r33 + 2] = (int) r3;
        long r5 = (r3 >>> 32) + (r14 * r8);
        r32[r33 + 3] = (int) r5;
        long r7 = (r5 >>> 32) + (r14 * r10);
        r32[r33 + 4] = (int) r7;
        long r9 = (r7 >>> 32) + (r14 * r12);
        r32[r33 + 5] = (int) r9;
        r32[r33 + 6] = (int) (r9 >>> 32);
        int r11 = 1;
        int r13 = r33;
        int r15 = 1;
    L4:
        if (r15 >= 6) goto L6;
        r13 = r13 + r11;
        long r16 = ((long) r28[r29 + r15]) & 4294967295L;
        int r24 = r13 + 0;
        long r17 = ((r16 * r0) + (((long) r32[r24]) & 4294967295L)) + 0;
        r32[r24] = (int) r17;
        int r18 = r13 + 1;
        long r26 = r12;
        long r19 = (r17 >>> 32) + ((r16 * r4) + (((long) r32[r18]) & 4294967295L));
        r32[r18] = (int) r19;
        int r110 = r13 + 2;
        long r20 = (r19 >>> 32) + ((r16 * r6) + (((long) r32[r110]) & 4294967295L));
        r32[r110] = (int) r20;
        int r21 = r13 + 3;
        long r22 = (r20 >>> 32) + ((r16 * r8) + (((long) r32[r21]) & 4294967295L));
        r32[r21] = (int) r22;
        int r23 = r13 + 4;
        long r25 = (r22 >>> 32) + ((r16 * r10) + (((long) r32[r23]) & 4294967295L));
        r32[r23] = (int) r25;
        int r27 = r13 + 5;
        long r34 = (r25 >>> 32) + ((r16 * r26) + (((long) r32[r27]) & 4294967295L));
        r32[r27] = (int) r34;
        r32[r13 + 6] = (int) (r34 >>> 32);
        r15 = r15 + 1;
        r6 = r6;
        r12 = r26;
        r11 = 1;
        goto L4
    }

    public static void mul(int[] r30, int[] r31, int[] r32) {
        long r1 = ((long) r31[0]) & 4294967295L;
        long r6 = ((long) r31[1]) & 4294967295L;
        long r9 = ((long) r31[2]) & 4294967295L;
        long r12 = ((long) r31[3]) & 4294967295L;
        long r14 = ((long) r31[4]) & 4294967295L;
        long r8 = ((long) r31[5]) & 4294967295L;
        long r10 = ((long) r30[0]) & 4294967295L;
        long r3 = (r10 * r1) + 0;
        r32[0] = (int) r3;
        long r4 = (r3 >>> 32) + (r10 * r6);
        r32[1] = (int) r4;
        long r5 = (r4 >>> 32) + (r10 * r9);
        r32[2] = (int) r5;
        long r7 = (r5 >>> 32) + (r10 * r12);
        r32[3] = (int) r7;
        long r11 = (r7 >>> 32) + (r10 * r14);
        r32[4] = (int) r11;
        long r13 = (r11 >>> 32) + (r10 * r8);
        r32[5] = (int) r13;
        int r15 = 6;
        r32[6] = (int) (r13 >>> 32);
        int r16 = 1;
    L3:
        if (r16 >= r15) goto L5;
        long r17 = ((long) r30[r16]) & 4294967295L;
        int r18 = r16 + 0;
        long r0 = ((r17 * r1) + (((long) r32[r18]) & 4294967295L)) + 0;
        r32[r18] = (int) r0;
        int r19 = r16 + 1;
        long r26 = r6;
        long r2 = (r0 >>> 32) + ((r17 * r6) + (((long) r32[r19]) & 4294967295L));
        r32[r19] = (int) r2;
        int r20 = r16 + 2;
        long r28 = r8;
        long r21 = (r2 >>> 32) + ((r17 * r9) + (((long) r32[r20]) & 4294967295L));
        r32[r20] = (int) r21;
        int r22 = r16 + 3;
        long r23 = (r21 >>> 32) + ((r17 * r12) + (((long) r32[r22]) & 4294967295L));
        r32[r22] = (int) r23;
        int r24 = r16 + 4;
        long r25 = (r23 >>> 32) + ((r17 * r14) + (((long) r32[r24]) & 4294967295L));
        r32[r24] = (int) r25;
        int r27 = r16 + 5;
        long r29 = (r25 >>> 32) + ((r17 * r28) + (((long) r32[r27]) & 4294967295L));
        r32[r27] = (int) r29;
        r32[r16 + 6] = (int) (r29 >>> 32);
        r16 = r19;
        r1 = r1;
        r6 = r26;
        r8 = r28;
        r15 = 6;
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
        long r23 = (r21 >>> 32) + (((r0 * r22) + r20) + (4294967295L & ((long) r16[r17 + 5])));
        r18[r19 + 5] = (int) r23;
        return (r23 >>> 32) + r22;
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
        return Nat.incAt(6, r18, r19, 4);
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
        return Nat.incAt(6, r12, r13, 3);
    }

    public static int mulAddTo(int[] r30, int[] r31, int[] r32) {
        int r0 = 0;
        long r3 = 4294967295L;
        long r1 = ((long) r31[0]) & 4294967295L;
        long r5 = ((long) r31[1]) & 4294967295L;
        long r7 = ((long) r31[2]) & 4294967295L;
        long r9 = ((long) r31[3]) & 4294967295L;
        long r11 = ((long) r31[4]) & 4294967295L;
        long r13 = ((long) r31[5]) & 4294967295L;
        long r17 = 0;
    L4:
        if (r0 >= 6) goto L7;
        long r21 = r13;
        long r14 = ((long) r30[r0]) & r3;
        int r23 = r0 + 0;
        long r24 = r1;
        long r4 = ((r14 * r1) + (((long) r32[r23]) & r3)) + 0;
        r32[r23] = (int) r4;
        int r16 = r0 + 1;
        long r6 = (r4 >>> 32) + ((r14 * r5) + (((long) r32[r16]) & 4294967295L));
        r32[r16] = (int) r6;
        int r25 = r0 + 2;
        long r2 = (r6 >>> 32) + ((r14 * r7) + (((long) r32[r25]) & 4294967295L));
        r32[r25] = (int) r2;
        int r8 = r0 + 3;
        long r10 = (r2 >>> 32) + ((r14 * r9) + (((long) r32[r8]) & 4294967295L));
        r32[r8] = (int) r10;
        int r12 = r0 + 4;
        long r15 = (r10 >>> 32) + ((r14 * r11) + (((long) r32[r12]) & 4294967295L));
        r32[r12] = (int) r15;
        int r18 = r0 + 5;
        long r19 = (r15 >>> 32) + ((r14 * r21) + (((long) r32[r18]) & 4294967295L));
        r32[r18] = (int) r19;
        int r20 = r0 + 6;
        long r22 = ((r19 >>> 32) + (((long) r32[r20]) & 4294967295L)) + r17;
        r32[r20] = (int) r22;
        r17 = r22 >>> 32;
        r0 = r16;
        r3 = 4294967295L;
        r13 = r21;
        r1 = r24;
        r5 = r5;
        r7 = r7;
        goto L4
    L7:
        return (int) r17;
    }

    public static void square(int[] r38, int r39, int[] r40, int r41) {
        long r0 = ((long) r38[r39 + 0]) & 4294967295L;
        int r5 = 0;
        int r6 = 12;
        int r7 = 5;
    L3:
        int r8 = r7 - 1;
        long r9 = ((long) r38[r39 + r7]) & 4294967295L;
        long r10 = r9 * r9;
        int r11 = r6 - 1;
        r40[r41 + r11] = (r5 << 31) | ((int) (r10 >>> 33));
        r6 = r11 - 1;
        r40[r41 + r6] = (int) (r10 >>> 1);
        r5 = (int) r10;
        if (r8 <= 0) goto L5;
        r7 = r8;
        goto L3
    L5:
        long r12 = r0 * r0;
        r40[r41 + 0] = (int) r12;
        long r13 = ((long) r38[r39 + 1]) & 4294967295L;
        int r14 = r41 + 2;
        long r15 = ((long) r40[r14]) & 4294967295L;
        long r16 = ((((long) (r5 << 31)) & 4294967295L) | (r12 >>> 33)) + (r13 * r0);
        int r17 = (int) r16;
        r40[r41 + 1] = (r17 << 1) | (((int) (r12 >>> 32)) & 1);
        int r18 = r17 >>> 31;
        long r19 = r15 + (r16 >>> 32);
        long r20 = ((long) r38[r39 + 2]) & 4294967295L;
        int r110 = r41 + 3;
        long r111 = ((long) r40[r110]) & 4294967295L;
        int r21 = r41 + 4;
        long r112 = ((long) r40[r21]) & 4294967295L;
        long r113 = r19 + (r20 * r0);
        int r114 = (int) r113;
        r40[r14] = (r114 << 1) | r18;
        int r22 = r114 >>> 31;
        long r115 = r111 + ((r113 >>> 32) + (r20 * r13));
        long r116 = r112 + (r115 >>> 32);
        long r4 = ((long) r38[r39 + 3]) & 4294967295L;
        int r23 = r41 + 5;
        long r117 = (((long) r40[r23]) & 4294967295L) + (r116 >>> 32);
        int r24 = r41 + 6;
        long r25 = (((long) r40[r24]) & 4294967295L) + (r117 >>> 32);
        long r118 = (r115 & 4294967295L) + (r4 * r0);
        int r2 = (int) r118;
        r40[r110] = (r2 << 1) | r22;
        long r119 = (r116 & 4294967295L) + ((r118 >>> 32) + (r4 * r13));
        long r120 = (r117 & 4294967295L) + ((r119 >>> 32) + (r4 * r20));
        long r26 = r25 + (r120 >>> 32);
        long r27 = r120 & 4294967295L;
        long r121 = ((long) r38[r39 + 4]) & 4294967295L;
        int r3 = r41 + 7;
        long r28 = (((long) r40[r3]) & 4294967295L) + (r26 >>> 32);
        long r29 = r26 & 4294967295L;
        int r210 = r41 + 8;
        long r30 = (((long) r40[r210]) & 4294967295L) + (r28 >>> 32);
        long r122 = (r119 & 4294967295L) + (r121 * r0);
        int r31 = (int) r122;
        r40[r21] = (r2 >>> 31) | (r31 << 1);
        int r32 = r31 >>> 31;
        long r33 = r27 + ((r122 >>> 32) + (r121 * r13));
        long r123 = r29 + ((r33 >>> 32) + (r121 * r20));
        long r34 = (r28 & 4294967295L) + ((r123 >>> 32) + (r121 * r4));
        long r35 = r30 + (r34 >>> 32);
        long r36 = r34 & 4294967295L;
        long r124 = ((long) r38[r39 + 5]) & 4294967295L;
        int r37 = r41 + 9;
        long r42 = (((long) r40[r37]) & 4294967295L) + (r35 >>> 32);
        int r211 = r41 + 10;
        long r43 = (((long) r40[r211]) & 4294967295L) + (r42 >>> 32);
        long r44 = (r33 & 4294967295L) + (r0 * r124);
        int r1 = (int) r44;
        r40[r23] = (r1 << 1) | r32;
        long r125 = (r123 & 4294967295L) + ((r44 >>> 32) + (r124 * r13));
        long r45 = r36 + ((r125 >>> 32) + (r124 * r20));
        long r46 = (r35 & 4294967295L) + ((r45 >>> 32) + (r124 * r4));
        long r47 = (r42 & 4294967295L) + ((r46 >>> 32) + (r124 * r121));
        long r48 = r43 + (r47 >>> 32);
        int r49 = (int) r125;
        r40[r24] = (r1 >>> 31) | (r49 << 1);
        int r50 = (int) r45;
        r40[r3] = (r49 >>> 31) | (r50 << 1);
        int r51 = r50 >>> 31;
        int r52 = (int) r46;
        r40[r210] = r51 | (r52 << 1);
        int r53 = r52 >>> 31;
        int r54 = (int) r47;
        r40[r37] = r53 | (r54 << 1);
        int r55 = r54 >>> 31;
        int r56 = (int) r48;
        r40[r211] = r55 | (r56 << 1);
        int r57 = r56 >>> 31;
        int r58 = r41 + 11;
        r40[r58] = r57 | ((r40[r58] + ((int) (r48 >>> 32))) << 1);
    }

    public static void square(int[] r36, int[] r37) {
        long r1 = ((long) r36[0]) & 4294967295L;
        int r6 = 12;
        int r8 = 0;
        int r7 = 5;
    L3:
        int r9 = r7 - 1;
        long r10 = ((long) r36[r7]) & 4294967295L;
        long r11 = r10 * r10;
        int r12 = r6 - 1;
        r37[r12] = (r8 << 31) | ((int) (r11 >>> 33));
        r6 = r12 - 1;
        r37[r6] = (int) (r11 >>> 1);
        int r13 = (int) r11;
        if (r9 <= 0) goto L5;
        r7 = r9;
        r8 = r13;
        goto L3
    L5:
        long r14 = r1 * r1;
        long r15 = (((long) (r13 << 31)) & 4294967295L) | (r14 >>> 33);
        r37[0] = (int) r14;
        long r16 = ((long) r36[1]) & 4294967295L;
        long r17 = ((long) r37[2]) & 4294967295L;
        long r18 = r15 + (r16 * r1);
        int r19 = (int) r18;
        r37[1] = (r19 << 1) | (((int) (r14 >>> 32)) & 1);
        long r110 = r17 + (r18 >>> 32);
        long r20 = ((long) r36[2]) & 4294967295L;
        long r5 = ((long) r37[3]) & 4294967295L;
        long r111 = ((long) r37[4]) & 4294967295L;
        long r112 = r110 + (r20 * r1);
        int r21 = (int) r112;
        r37[2] = (r21 << 1) | (r19 >>> 31);
        long r22 = r5 + ((r112 >>> 32) + (r20 * r16));
        long r113 = r111 + (r22 >>> 32);
        long r114 = ((long) r36[3]) & 4294967295L;
        long r23 = (((long) r37[5]) & 4294967295L) + (r113 >>> 32);
        long r115 = r113 & 4294967295L;
        long r116 = (((long) r37[6]) & 4294967295L) + (r23 >>> 32);
        long r24 = (r22 & 4294967295L) + (r114 * r1);
        int r3 = (int) r24;
        r37[3] = (r3 << 1) | (r21 >>> 31);
        long r4 = r115 + ((r24 >>> 32) + (r114 * r16));
        long r25 = (r23 & 4294967295L) + ((r4 >>> 32) + (r114 * r20));
        long r117 = r116 + (r25 >>> 32);
        long r26 = r25 & 4294967295L;
        long r118 = ((long) r36[4]) & 4294967295L;
        long r27 = (((long) r37[7]) & 4294967295L) + (r117 >>> 32);
        long r119 = r117 & 4294967295L;
        long r120 = (((long) r37[8]) & 4294967295L) + (r27 >>> 32);
        long r28 = (r4 & 4294967295L) + (r118 * r1);
        int r0 = (int) r28;
        r37[4] = (r3 >>> 31) | (r0 << 1);
        long r29 = r26 + ((r28 >>> 32) + (r118 * r16));
        long r30 = r119 + ((r29 >>> 32) + (r118 * r20));
        long r31 = (r27 & 4294967295L) + ((r30 >>> 32) + (r118 * r114));
        long r121 = r120 + (r31 >>> 32);
        long r122 = ((long) r36[5]) & 4294967295L;
        long r32 = (((long) r37[9]) & 4294967295L) + (r121 >>> 32);
        long r123 = r121 & 4294967295L;
        long r124 = (((long) r37[10]) & 4294967295L) + (r32 >>> 32);
        long r33 = (r29 & 4294967295L) + (r1 * r122);
        int r2 = (int) r33;
        r37[5] = (r0 >>> 31) | (r2 << 1);
        int r34 = r2 >>> 31;
        long r35 = (r30 & 4294967295L) + ((r33 >>> 32) + (r16 * r122));
        long r38 = (r31 & 4294967295L) + ((r35 >>> 32) + (r122 * r20));
        long r39 = r123 + ((r38 >>> 32) + (r122 * r114));
        long r40 = (r32 & 4294967295L) + ((r39 >>> 32) + (r122 * r118));
        long r125 = r124 + (r40 >>> 32);
        int r41 = (int) r35;
        r37[6] = r34 | (r41 << 1);
        int r42 = (int) r38;
        r37[7] = (r41 >>> 31) | (r42 << 1);
        int r43 = r42 >>> 31;
        int r44 = (int) r39;
        r37[8] = r43 | (r44 << 1);
        int r45 = r44 >>> 31;
        int r46 = (int) r40;
        r37[9] = r45 | (r46 << 1);
        int r47 = r46 >>> 31;
        int r48 = (int) r125;
        r37[10] = r47 | (r48 << 1);
        r37[11] = (r48 >>> 31) | ((r37[11] + ((int) (r125 >>> 32))) << 1);
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
        return (int) (r5 >> 32);
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
        return (int) (r6 >> 32);
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
        long r6 = (r5 >> 32) + ((((long) r11[5]) & 4294967295L) - (4294967295L & ((long) r10[5])));
        r11[5] = (int) r6;
        return (int) (r6 >> 32);
    }

    public static BigInteger toBigInteger(int[] r4) {
        byte[] r0 = new byte[24];
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L10;
        int r2 = r4[r1];
        if (r2 == 0) goto L8;
        Pack.intToBigEndian(r2, r0, (5 - r1) << 2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }

    public static BigInteger toBigInteger64(long[] r7) {
        byte[] r0 = new byte[24];
        int r1 = 0;
    L4:
        if (r1 >= 3) goto L10;
        long r3 = r7[r1];
        if (r3 == 0) goto L8;
        Pack.longToBigEndian(r3, r0, (2 - r1) << 3);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new BigInteger(1, r0);
    }
}
