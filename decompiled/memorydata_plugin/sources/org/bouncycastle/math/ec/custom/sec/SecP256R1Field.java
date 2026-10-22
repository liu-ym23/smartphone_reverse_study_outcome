package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP256R1Field {
    static final int[] P = null;
    private static final int[] PExt = null;

    static {
        P = new int[]{-1, -1, -1, 0, 0, 0, 1, -1};
        PExt = new int[]{1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat256.add(r0, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r1, int[] r2) {
        if (Nat.inc(8, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r2, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) + 1;
        r12[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r3;
        long r4 = (r3 >> 32) + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r4;
        r2 = r4 >> 32;
    L5:
        long r5 = r2 + ((((long) r12[3]) & 4294967295L) - 1);
        r12[3] = (int) r5;
        long r6 = r5 >> 32;
        if (r6 == 0) goto L8;
        long r7 = r6 + (((long) r12[4]) & 4294967295L);
        r12[4] = (int) r7;
        long r8 = (r7 >> 32) + (((long) r12[5]) & 4294967295L);
        r12[5] = (int) r8;
        r6 = r8 >> 32;
    L8:
        long r9 = r6 + ((((long) r12[6]) & 4294967295L) - 1);
        r12[6] = (int) r9;
        r12[7] = (int) ((r9 >> 32) + ((4294967295L & ((long) r12[7])) + 1));
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat256.fromBigInteger(r2);
        if (r3[7] != (-1)) goto L7;
        int[] r0 = P;
        if (Nat256.gte(r3, r0) == false) goto L7;
        Nat256.subFrom(r0, r3);
    L7:
        return r3;
    }

    public static void inv(int[] r1, int[] r2) {
        Mod.checkedModOddInverse(P, r1, r2);
    }

    public static int isZero(int[] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 8) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat256.createExt();
        Nat256.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiply(int[] r0, int[] r1, int[] r2, int[] r3) {
        Nat256.mul(r0, r1, r3);
        reduce(r3, r2);
    }

    public static void multiplyAddToExt(int[] r1, int[] r2, int[] r3) {
        if (Nat256.mulAddTo(r1, r2, r3) == 0) goto L5;
    L8:
        Nat.subFrom(16, PExt, r3);
        return;
    L5:
        if ((r3[15] >>> 1) >= Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (Nat.gte(16, r3, PExt) == true) goto L8;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat256.sub(r3, r3, r2);
        return;
    L5:
        Nat256.sub(P, r1, r2);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[32];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 8);
        if (Nat.lessThan(8, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r34, int[] r35) {
        long r1 = ((long) r34[8]) & 4294967295L;
        long r5 = ((long) r34[9]) & 4294967295L;
        long r7 = ((long) r34[10]) & 4294967295L;
        long r9 = ((long) r34[11]) & 4294967295L;
        long r11 = ((long) r34[12]) & 4294967295L;
        long r13 = ((long) r34[13]) & 4294967295L;
        long r14 = ((long) r34[14]) & 4294967295L;
        long r15 = ((long) r34[15]) & 4294967295L;
        long r2 = r1 - 6;
        long r22 = r2 + r5;
        long r6 = r5 + r7;
        long r8 = (r7 + r9) - r15;
        long r10 = r9 + r11;
        long r12 = r11 + r13;
        long r16 = r13 + r14;
        long r24 = r14 + r15;
        long r23 = r16 - r22;
        long r3 = (((((long) r34[0]) & 4294967295L) - r10) - r23) + 0;
        r35[0] = (int) r3;
        long r4 = (r3 >> 32) + ((((((long) r34[1]) & 4294967295L) + r6) - r12) - r24);
        r35[1] = (int) r4;
        long r17 = (r4 >> 32) + (((((long) r34[2]) & 4294967295L) + r8) - r16);
        r35[2] = (int) r17;
        long r18 = (r17 >> 32) + ((((((long) r34[3]) & 4294967295L) + (r10 << 1)) + r23) - r24);
        r35[3] = (int) r18;
        long r19 = (r18 >> 32) + ((((((long) r34[4]) & 4294967295L) + (r12 << 1)) + r14) - r6);
        r35[4] = (int) r19;
        long r20 = (r19 >> 32) + (((((long) r34[5]) & 4294967295L) + (r16 << 1)) - r8);
        r35[5] = (int) r20;
        long r21 = (r20 >> 32) + (((((long) r34[6]) & 4294967295L) + (r24 << 1)) + r23);
        r35[6] = (int) r21;
        long r25 = (r21 >> 32) + (((((((long) r34[7]) & 4294967295L) + (r15 << 1)) + r2) - r8) - r12);
        r35[7] = (int) r25;
        reduce32((int) ((r25 >> 32) + 6), r35);
    }

    public static void reduce32(int r12, int[] r13) {
        if (r12 == 0) goto L11;
        long r3 = ((long) r12) & 4294967295L;
        long r7 = ((((long) r13[0]) & 4294967295L) + r3) + 0;
        r13[0] = (int) r7;
        long r8 = r7 >> 32;
        if (r8 == 0) goto L7;
        long r9 = r8 + (((long) r13[1]) & 4294967295L);
        r13[1] = (int) r9;
        long r10 = (r9 >> 32) + (((long) r13[2]) & 4294967295L);
        r13[2] = (int) r10;
        r8 = r10 >> 32;
    L7:
        long r11 = r8 + ((((long) r13[3]) & 4294967295L) - r3);
        r13[3] = (int) r11;
        long r14 = r11 >> 32;
        if (r14 == 0) goto L10;
        long r15 = r14 + (((long) r13[4]) & 4294967295L);
        r13[4] = (int) r15;
        long r16 = (r15 >> 32) + (((long) r13[5]) & 4294967295L);
        r13[5] = (int) r16;
        r14 = r16 >> 32;
    L10:
        long r17 = r14 + ((((long) r13[6]) & 4294967295L) - r3);
        r13[6] = (int) r17;
        long r18 = (r17 >> 32) + ((4294967295L & ((long) r13[7])) + r3);
        r13[7] = (int) r18;
        long r4 = r18 >> 32;
    L13:
        if (r4 == 0) goto L15;
    L18:
        addPInvTo(r13);
        return;
    L15:
        if (r13[7] == (-1)) goto L17;
        return;
    L17:
        if (Nat256.gte(r13, P) == true) goto L18;
        return;
    L11:
        r4 = 0;
        goto L13
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat256.createExt();
        Nat256.square(r1, r0);
        reduce(r0, r2);
    }

    public static void square(int[] r0, int[] r1, int[] r2) {
        Nat256.square(r0, r2);
        reduce(r2, r1);
    }

    public static void squareN(int[] r0, int r1, int[] r2, int[] r3) {
        Nat256.square(r0, r3);
    L3:
        reduce(r3, r2);
        r1 = r1 - 1;
        if (r1 <= 0) goto L6;
        Nat256.square(r2, r3);
        goto L3
    }

    private static void subPInvFrom(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) - 1;
        r12[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r3;
        long r4 = (r3 >> 32) + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r4;
        r2 = r4 >> 32;
    L5:
        long r5 = r2 + ((((long) r12[3]) & 4294967295L) + 1);
        r12[3] = (int) r5;
        long r6 = r5 >> 32;
        if (r6 == 0) goto L8;
        long r7 = r6 + (((long) r12[4]) & 4294967295L);
        r12[4] = (int) r7;
        long r8 = (r7 >> 32) + (((long) r12[5]) & 4294967295L);
        r12[5] = (int) r8;
        r6 = r8 >> 32;
    L8:
        long r9 = r6 + ((((long) r12[6]) & 4294967295L) + 1);
        r12[6] = (int) r9;
        r12[7] = (int) ((r9 >> 32) + ((4294967295L & ((long) r12[7])) - 1));
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat256.sub(r0, r1, r2) == 0) goto L6;
        subPInvFrom(r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(8, r2, 0, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[7] == (-1)) goto L7;
        return;
    L7:
        if (Nat256.gte(r3, P) == true) goto L8;
    }
}
