package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP384R1Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};
        PExt = new int[]{1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};
    }

    public static void add(int[] r1, int[] r2, int[] r3) {
        if (Nat.add(12, r1, r2, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r3, P) == true) goto L8;
    }

    public static void addExt(int[] r1, int[] r2, int[] r3) {
        if (Nat.add(24, r1, r2, r3) == 0) goto L5;
    L8:
        int[] r4 = PExtInv;
        if (Nat.addTo(r4.length, r4, r3) == 0) goto L14;
        Nat.incAt(24, r3, r4.length);
        return;
    L14:
        return;
    L5:
        if (r3[23] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(24, r3, PExt) == true) goto L8;
    }

    public static void addOne(int[] r2, int[] r3) {
        if (Nat.inc(12, r2, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r3, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) + 1;
        r12[0] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r12[1]) & 4294967295L) - 1);
        r12[1] = (int) r2;
        long r3 = r2 >> 32;
        if (r3 == 0) goto L5;
        long r4 = r3 + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r4;
        r3 = r4 >> 32;
    L5:
        long r5 = r3 + ((((long) r12[3]) & 4294967295L) + 1);
        r12[3] = (int) r5;
        long r6 = (r5 >> 32) + ((4294967295L & ((long) r12[4])) + 1);
        r12[4] = (int) r6;
        if ((r6 >> 32) == 0) goto L9;
        Nat.incAt(12, r12, 5);
        return;
    }

    public static int[] fromBigInteger(BigInteger r3) {
        int[] r4 = Nat.fromBigInteger(384, r3);
        if (r4[11] != (-1)) goto L7;
        int[] r0 = P;
        if (Nat.gte(12, r4, r0) == false) goto L7;
        Nat.subFrom(12, r0, r4);
    L7:
        return r4;
    }

    public static void inv(int[] r1, int[] r2) {
        Mod.checkedModOddInverse(P, r1, r2);
    }

    public static int isZero(int[] r3) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 12) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat.create(24);
        Nat384.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiply(int[] r0, int[] r1, int[] r2, int[] r3) {
        Nat384.mul(r0, r1, r3);
        reduce(r3, r2);
    }

    public static void negate(int[] r2, int[] r3) {
        if (isZero(r2) == 0) goto L5;
        int[] r4 = P;
        Nat.sub(12, r4, r4, r3);
        return;
    L5:
        Nat.sub(12, P, r2, r3);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[48];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 12);
        if (Nat.lessThan(12, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r40, int[] r41) {
        long r1 = ((long) r40[16]) & 4294967295L;
        long r5 = ((long) r40[17]) & 4294967295L;
        long r7 = ((long) r40[18]) & 4294967295L;
        long r9 = ((long) r40[19]) & 4294967295L;
        long r11 = ((long) r40[20]) & 4294967295L;
        long r13 = ((long) r40[21]) & 4294967295L;
        long r10 = ((long) r40[22]) & 4294967295L;
        long r8 = ((long) r40[23]) & 4294967295L;
        long r2 = ((((long) r40[12]) & 4294967295L) + r11) - 1;
        long r12 = (((long) r40[13]) & 4294967295L) + r10;
        long r14 = ((((long) r40[14]) & 4294967295L) + r10) + r8;
        long r15 = (((long) r40[15]) & 4294967295L) + r8;
        long r30 = r5 + r13;
        long r32 = r13 - r8;
        long r16 = r10 - r8;
        long r34 = r2 + r32;
        long r17 = ((((long) r40[0]) & 4294967295L) + r34) + 0;
        r41[0] = (int) r17;
        long r18 = (r17 >> 32) + ((((((long) r40[1]) & 4294967295L) + r8) - r2) + r12);
        r41[1] = (int) r18;
        long r3 = (r18 >> 32) + ((((((long) r40[2]) & 4294967295L) - r13) - r12) + r14);
        r41[2] = (int) r3;
        long r4 = (r3 >> 32) + ((((((long) r40[3]) & 4294967295L) - r14) + r15) + r34);
        r41[3] = (int) r4;
        long r6 = (r4 >> 32) + ((((((((long) r40[4]) & 4294967295L) + r1) + r13) + r12) - r15) + r34);
        r41[4] = (int) r6;
        long r19 = (r6 >> 32) + (((((((long) r40[5]) & 4294967295L) - r1) + r12) + r14) + r30);
        r41[5] = (int) r19;
        long r20 = (r19 >> 32) + (((((((long) r40[6]) & 4294967295L) + r7) - r5) + r14) + r15);
        r41[6] = (int) r20;
        long r21 = (r20 >> 32) + (((((((long) r40[7]) & 4294967295L) + r1) + r9) - r7) + r15);
        r41[7] = (int) r21;
        long r22 = (r21 >> 32) + (((((((long) r40[8]) & 4294967295L) + r1) + r5) + r11) - r9);
        r41[8] = (int) r22;
        long r23 = (r22 >> 32) + ((((((long) r40[9]) & 4294967295L) + r7) - r11) + r30);
        r41[9] = (int) r23;
        long r24 = (r23 >> 32) + (((((((long) r40[10]) & 4294967295L) + r7) + r9) - r32) + r16);
        r41[10] = (int) r24;
        long r25 = (r24 >> 32) + ((((((long) r40[11]) & 4294967295L) + r9) + r11) - r16);
        r41[11] = (int) r25;
        reduce32((int) ((r25 >> 32) + 1), r41);
    }

    public static void reduce32(int r11, int[] r12) {
        if (r11 == 0) goto L8;
        long r2 = ((long) r11) & 4294967295L;
        long r6 = ((((long) r12[0]) & 4294967295L) + r2) + 0;
        r12[0] = (int) r6;
        long r7 = (r6 >> 32) + ((((long) r12[1]) & 4294967295L) - r2);
        r12[1] = (int) r7;
        long r8 = r7 >> 32;
        if (r8 == 0) goto L7;
        long r9 = r8 + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r9;
        r8 = r9 >> 32;
    L7:
        long r10 = r8 + ((((long) r12[3]) & 4294967295L) + r2);
        r12[3] = (int) r10;
        long r13 = (r10 >> 32) + ((4294967295L & ((long) r12[4])) + r2);
        r12[4] = (int) r13;
        long r3 = r13 >> 32;
    L10:
        if (r3 == 0) goto L14;
        if (Nat.incAt(12, r12, 5) == 0) goto L14;
    L17:
        addPInvTo(r12);
        return;
    L14:
        if (r12[11] == (-1)) goto L16;
        return;
    L16:
        if (Nat.gte(12, r12, P) == true) goto L17;
        return;
    L8:
        r3 = 0;
        goto L10
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat.create(24);
        Nat384.square(r1, r0);
        reduce(r0, r2);
    }

    public static void square(int[] r0, int[] r1, int[] r2) {
        Nat384.square(r0, r2);
        reduce(r2, r1);
    }

    public static void squareN(int[] r0, int r1, int[] r2, int[] r3) {
        Nat384.square(r0, r3);
    L3:
        reduce(r3, r2);
        r1 = r1 - 1;
        if (r1 <= 0) goto L6;
        Nat384.square(r2, r3);
        goto L3
    }

    private static void subPInvFrom(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) - 1;
        r12[0] = (int) r1;
        long r2 = (r1 >> 32) + ((((long) r12[1]) & 4294967295L) + 1);
        r12[1] = (int) r2;
        long r3 = r2 >> 32;
        if (r3 == 0) goto L5;
        long r4 = r3 + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r4;
        r3 = r4 >> 32;
    L5:
        long r5 = r3 + ((((long) r12[3]) & 4294967295L) - 1);
        r12[3] = (int) r5;
        long r6 = (r5 >> 32) + ((4294967295L & ((long) r12[4])) - 1);
        r12[4] = (int) r6;
        if ((r6 >> 32) == 0) goto L9;
        Nat.decAt(12, r12, 5);
        return;
    }

    public static void subtract(int[] r1, int[] r2, int[] r3) {
        if (Nat.sub(12, r1, r2, r3) == 0) goto L6;
        subPInvFrom(r3);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(12, r2, 0, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r3, P) == true) goto L8;
    }
}
