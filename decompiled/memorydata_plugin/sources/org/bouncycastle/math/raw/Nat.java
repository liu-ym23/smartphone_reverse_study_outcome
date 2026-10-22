package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat {
    public static int add(int r9, int[] r10, int[] r11, int[] r12) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        long r1 = r0 + ((((long) r10[r2]) & 4294967295L) + (4294967295L & ((long) r11[r2])));
        r12[r2] = (int) r1;
        r0 = r1 >>> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int add33To(int r8, int r9, int[] r10) {
        long r1 = (((long) r10[0]) & 4294967295L) + (((long) r9) & 4294967295L);
        r10[0] = (int) r1;
        long r2 = (r1 >>> 32) + ((4294967295L & ((long) r10[1])) + 1);
        r10[1] = (int) r2;
        if ((r2 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r8, r10, 2);
    }

    public static int addBothTo(int r9, int[] r10, int[] r11, int[] r12) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        long r1 = r0 + (((((long) r10[r2]) & 4294967295L) + (((long) r11[r2]) & 4294967295L)) + (4294967295L & ((long) r12[r2])));
        r12[r2] = (int) r1;
        r0 = r1 >>> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int addTo(int r10, int[] r11, int r12, int[] r13, int r14) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L6;
        int r7 = r14 + r2;
        long r1 = r0 + ((((long) r11[r12 + r2]) & 4294967295L) + (4294967295L & ((long) r13[r7])));
        r13[r7] = (int) r1;
        r0 = r1 >>> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int addTo(int r9, int[] r10, int[] r11) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        long r1 = r0 + ((((long) r10[r2]) & 4294967295L) + (4294967295L & ((long) r11[r2])));
        r11[r2] = (int) r1;
        r0 = r1 >>> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int addWordAt(int r6, int r7, int[] r8, int r9) {
        long r0 = (((long) r7) & 4294967295L) + (4294967295L & ((long) r8[r9]));
        r8[r9] = (int) r0;
        if ((r0 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r6, r8, r9 + 1);
    }

    public static int addWordTo(int r6, int r7, int[] r8) {
        long r0 = (((long) r7) & 4294967295L) + (4294967295L & ((long) r8[0]));
        r8[0] = (int) r0;
        if ((r0 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r6, r8, 1);
    }

    public static int cadd(int r10, int r11, int[] r12, int[] r13, int[] r14) {
        long r0 = ((long) (-(r11 & 1))) & 4294967295L;
        long r4 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r10) goto L6;
        long r5 = r4 + ((((long) r12[r15]) & 4294967295L) + (((long) r13[r15]) & r0));
        r14[r15] = (int) r5;
        r4 = r5 >>> 32;
        r15 = r15 + 1;
        goto L3
    L6:
        return (int) r4;
    }

    public static int compare(int r4, int[] r5, int[] r6) {
        int r7 = r4 - 1;
    L3:
        if (r7 < 0) goto L11;
        int r1 = r5[r7] ^ Integer.MIN_VALUE;
        int r2 = Integer.MIN_VALUE ^ r6[r7];
        if (r1 < r2) goto L6;
        if (r1 > r2) goto L9;
        r7 = r7 - 1;
        goto L3
    L9:
        return 1;
    L6:
        return -1;
    L11:
        return 0;
    }

    public static void copy(int r0, int[] r1, int r2, int[] r3, int r4) {
        System.arraycopy(r1, r2, r3, r4, r0);
    }

    public static int[] create(int r0) {
        return new int[r0];
    }

    public static long[] create64(int r0) {
        return new long[r0];
    }

    public static int dec(int r4, int[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L9;
        int r3 = r5[r1] - 1;
        r5[r1] = r3;
        if (r3 != (-1)) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return 0;
    L9:
        return -1;
    }

    public static int decAt(int r2, int[] r3, int r4) {
    L3:
        if (r4 >= r2) goto L9;
        int r1 = r3[r4] - 1;
        r3[r4] = r1;
        if (r1 != (-1)) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return -1;
    }

    public static boolean eq(int r3, int[] r4, int[] r5) {
        int r6 = r3 - 1;
    L3:
        if (r6 < 0) goto L9;
        if (r4[r6] != r5[r6]) goto L6;
        r6 = r6 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static int equalTo(int r3, int[] r4, int r5) {
        int r6 = r5 ^ r4[0];
        int r1 = 1;
    L3:
        if (r1 >= r3) goto L6;
        r6 = r6 | r4[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return (((r6 >>> 1) | (r6 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int r3, int[] r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r3) goto L6;
        r1 = r1 | r4[r0];
        r0 = r0 + 1;
        goto L3
    L6:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static int[] fromBigInteger(int r3, BigInteger r4) {
        if (r4.signum() < 0) goto L11;
        if (r4.bitLength() > r3) goto L11;
        int r5 = (r3 + 31) >> 5;
        int[] r0 = create(r5);
        int r1 = 0;
    L7:
        if (r1 >= r5) goto L9;
        r0[r1] = r4.intValue();
        r4 = r4.shiftRight(32);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    L11:
        throw new IllegalArgumentException();
    }

    public static long[] fromBigInteger64(int r4, BigInteger r5) {
        if (r5.signum() < 0) goto L11;
        if (r5.bitLength() > r4) goto L11;
        int r6 = (r4 + 63) >> 6;
        long[] r0 = create64(r6);
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L9;
        r0[r1] = r5.longValue();
        r5 = r5.shiftRight(64);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    L11:
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
        if (r1 >= r3.length) goto L13;
        int r6 = r3[r1];
        r5 = r6 >>> (r4 & 31);
        goto L6
    }

    public static boolean gte(int r4, int[] r5, int[] r6) {
        int r7 = r4 - 1;
    L3:
        if (r7 < 0) goto L11;
        int r1 = r5[r7] ^ Integer.MIN_VALUE;
        int r2 = Integer.MIN_VALUE ^ r6[r7];
        if (r1 < r2) goto L6;
        if (r1 > r2) goto L9;
        r7 = r7 - 1;
        goto L3
    L9:
        return true;
    L6:
        return false;
    L11:
        return true;
    }

    public static int inc(int r4, int[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L9;
        int r3 = r5[r1] + 1;
        r5[r1] = r3;
        if (r3 != 0) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return 0;
    L9:
        return 1;
    }

    public static int inc(int r4, int[] r5, int[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L10;
        int r3 = r5[r1] + 1;
        r6[r1] = r3;
        r1 = r1 + 1;
        if (r3 == 0) goto L4;
    L7:
        if (r1 >= r4) goto L9;
        r6[r1] = r5[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return 0;
    L10:
        return 1;
    }

    public static int incAt(int r2, int[] r3, int r4) {
    L3:
        if (r4 >= r2) goto L9;
        int r1 = r3[r4] + 1;
        r3[r4] = r1;
        if (r1 != 0) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return 1;
    }

    public static int incAt(int r3, int[] r4, int r5, int r6) {
    L3:
        if (r6 >= r3) goto L9;
        int r1 = r5 + r6;
        int r2 = r4[r1] + 1;
        r4[r1] = r2;
        if (r2 != 0) goto L6;
        r6 = r6 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return 1;
    }

    public static boolean isOne(int r4, int[] r5) {
        if (r5[0] == 1) goto L5;
        return false;
    L5:
        int r1 = 1;
    L6:
        if (r1 >= r4) goto L11;
        if (r5[r1] != 0) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean isZero(int r3, int[] r4) {
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L8;
        if (r4[r1] != 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static int lessThan(int r9, int[] r10, int[] r11) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        r0 = (r0 + ((((long) r10[r2]) & 4294967295L) - (4294967295L & ((long) r11[r2])))) >> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int mul31BothAdd(int r14, int r15, int[] r16, int r17, int[] r18, int[] r19, int r20) {
        long r0 = ((long) r15) & 4294967295L;
        long r4 = ((long) r17) & 4294967295L;
        long r6 = 0;
        int r8 = 0;
    L3:
        long r9 = ((((long) r16[r8]) & 4294967295L) * r0) + ((((long) r18[r8]) & 4294967295L) * r4);
        int r11 = r20 + r8;
        long r7 = r6 + (r9 + (((long) r19[r11]) & 4294967295L));
        r19[r11] = (int) r7;
        r6 = r7 >>> 32;
        r8 = r8 + 1;
        if (r8 < r14) goto L3;
        return (int) r6;
    }

    public static int mulWordAddTo(int r12, int r13, int[] r14, int r15, int[] r16, int r17) {
        long r0 = ((long) r13) & 4294967295L;
        long r4 = 0;
        int r6 = 0;
    L3:
        int r9 = r17 + r6;
        long r5 = r4 + (((((long) r14[r15 + r6]) & 4294967295L) * r0) + (((long) r16[r9]) & 4294967295L));
        r16[r9] = (int) r5;
        r4 = r5 >>> 32;
        r6 = r6 + 1;
        if (r6 < r12) goto L3;
        return (int) r4;
    }

    public static int shiftDownBit(int r2, int[] r3, int r4) {
    L2:
        r2 = r2 - 1;
        if (r2 < 0) goto L6;
        int r0 = r3[r2];
        r3[r2] = (r4 << 31) | (r0 >>> 1);
        r4 = r0;
        goto L2
    L6:
        return r4 << 31;
    }

    public static int shiftDownBits(int r3, int[] r4, int r5, int r6) {
    L2:
        r3 = r3 - 1;
        if (r3 < 0) goto L6;
        int r0 = r4[r3];
        r4[r3] = (r6 << (-r5)) | (r0 >>> r5);
        r6 = r0;
        goto L2
    L6:
        return r6 << (-r5);
    }

    public static int shiftDownBits(int r4, int[] r5, int r6, int r7, int r8, int[] r9, int r10) {
    L2:
        r4 = r4 - 1;
        if (r4 < 0) goto L6;
        int r0 = r5[r6 + r4];
        r9[r10 + r4] = (r8 << (-r7)) | (r0 >>> r7);
        r8 = r0;
        goto L2
    L6:
        return r8 << (-r7);
    }

    public static int shiftDownWord(int r1, int[] r2, int r3) {
    L2:
        r1 = r1 - 1;
        if (r1 < 0) goto L5;
        int r0 = r2[r1];
        r2[r1] = r3;
        r3 = r0;
        goto L2
    L5:
        return r3;
    }

    public static int shiftUpBit(int r4, int[] r5, int r6, int r7, int[] r8, int r9) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L6;
        int r1 = r5[r6 + r0];
        int r10 = r7 >>> 31;
        r8[r9 + r0] = r10 | (r1 << 1);
        r0 = r0 + 1;
        r7 = r1;
        goto L3
    L6:
        return r7 >>> 31;
    }

    public static int shiftUpBit(int r3, int[] r4, int r5, int[] r6) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L6;
        int r1 = r4[r0];
        int r7 = r5 >>> 31;
        r6[r0] = r7 | (r1 << 1);
        r0 = r0 + 1;
        r5 = r1;
        goto L3
    L6:
        return r5 >>> 31;
    }

    public static long shiftUpBit64(int r7, long[] r8, int r9, long r10, long[] r12, int r13) {
        int r0 = 0;
    L4:
        if (r0 >= r7) goto L7;
        long r2 = r8[r9 + r0];
        long r11 = r10 >>> 63;
        r12[r13 + r0] = r11 | (r2 << 1);
        r0 = r0 + 1;
        r10 = r2;
        goto L4
    L7:
        return r10 >>> 63;
    }

    public static int shiftUpBits(int r4, int[] r5, int r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L6;
        int r1 = r5[r0];
        int r8 = r7 >>> (-r6);
        r5[r0] = r8 | (r1 << r6);
        r0 = r0 + 1;
        r7 = r1;
        goto L3
    L6:
        return r7 >>> (-r6);
    }

    public static int shiftUpBits(int r4, int[] r5, int r6, int r7, int[] r8) {
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L6;
        int r1 = r5[r0];
        int r9 = r7 >>> (-r6);
        r8[r0] = r9 | (r1 << r6);
        r0 = r0 + 1;
        r7 = r1;
        goto L3
    L6:
        return r7 >>> (-r6);
    }

    public static long shiftUpBits64(int r7, long[] r8, int r9, int r10, long r11) {
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L6;
        int r1 = r9 + r0;
        long r2 = r8[r1];
        long r12 = r11 >>> (-r10);
        r8[r1] = r12 | (r2 << r10);
        r0 = r0 + 1;
        r11 = r2;
        goto L3
    L6:
        return r11 >>> (-r10);
    }

    public static long shiftUpBits64(int r7, long[] r8, int r9, int r10, long r11, long[] r13, int r14) {
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L6;
        long r1 = r8[r9 + r0];
        long r12 = r11 >>> (-r10);
        r13[r14 + r0] = r12 | (r1 << r10);
        r0 = r0 + 1;
        r11 = r1;
        goto L3
    L6:
        return r11 >>> (-r10);
    }

    public static int sub(int r9, int[] r10, int[] r11, int[] r12) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        long r1 = r0 + ((((long) r10[r2]) & 4294967295L) - (4294967295L & ((long) r11[r2])));
        r12[r2] = (int) r1;
        r0 = r1 >> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int sub33From(int r8, int r9, int[] r10) {
        long r1 = (((long) r10[0]) & 4294967295L) - (((long) r9) & 4294967295L);
        r10[0] = (int) r1;
        long r2 = (r1 >> 32) + ((4294967295L & ((long) r10[1])) - 1);
        r10[1] = (int) r2;
        if ((r2 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r8, r10, 2);
    }

    public static int subFrom(int r10, int[] r11, int r12, int[] r13, int r14) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L6;
        int r3 = r14 + r2;
        long r1 = r0 + ((((long) r13[r3]) & 4294967295L) - (4294967295L & ((long) r11[r12 + r2])));
        r13[r3] = (int) r1;
        r0 = r1 >> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int subFrom(int r9, int[] r10, int[] r11) {
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L6;
        long r1 = r0 + ((((long) r11[r2]) & 4294967295L) - (4294967295L & ((long) r10[r2])));
        r11[r2] = (int) r1;
        r0 = r1 >> 32;
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) r0;
    }

    public static int subWordFrom(int r7, int r8, int[] r9) {
        long r1 = (((long) r9[0]) & 4294967295L) - (4294967295L & ((long) r8));
        r9[0] = (int) r1;
        if ((r1 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r7, r9, 1);
    }

    public static BigInteger toBigInteger(int r4, int[] r5) {
        byte[] r0 = new byte[r4 << 2];
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L9;
        int r2 = r5[r1];
        if (r2 == 0) goto L7;
        Pack.intToBigEndian(r2, r0, ((r4 - 1) - r1) << 2);
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return new BigInteger(1, r0);
    }

    public static void zero(int r2, int[] r3) {
        int r1 = 0;
    L3:
        if (r1 >= r2) goto L5;
        r3[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }

    public static void zero64(int r3, long[] r4) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        r4[r0] = 0;
        r0 = r0 + 1;
        goto L3
    }
}
