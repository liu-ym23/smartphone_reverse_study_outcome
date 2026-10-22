package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP224R1Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{1, 0, 0, -1, -1, -1, -1};
        PExt = new int[]{1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};
        PExtInv = new int[]{-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat224.add(r0, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r1, int[] r2) {
        if (Nat.inc(7, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r2, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r12) {
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
        long r5 = r2 + ((4294967295L & ((long) r12[3])) + 1);
        r12[3] = (int) r5;
        if ((r5 >> 32) == 0) goto L9;
        Nat.incAt(7, r12, 4);
        return;
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat224.fromBigInteger(r2);
        if (r3[6] != (-1)) goto L7;
        int[] r0 = P;
        if (Nat224.gte(r3, r0) == false) goto L7;
        Nat224.subFrom(r0, r3);
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
        if (r0 >= 7) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat224.createExt();
        Nat224.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(int[] r1, int[] r2, int[] r3) {
        if (Nat224.mulAddTo(r1, r2, r3) == 0) goto L5;
    L8:
        int[] r4 = PExtInv;
        if (Nat.addTo(r4.length, r4, r3) == 0) goto L14;
        Nat.incAt(14, r3, r4.length);
        return;
    L14:
        return;
    L5:
        if (r3[13] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(14, r3, PExt) == true) goto L8;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat224.sub(r3, r3, r2);
        return;
    L5:
        Nat224.sub(P, r1, r2);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[28];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 7);
        if (Nat.lessThan(7, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r30, int[] r31) {
        long r1 = ((long) r30[10]) & 4294967295L;
        long r5 = ((long) r30[11]) & 4294967295L;
        long r7 = ((long) r30[12]) & 4294967295L;
        long r9 = ((long) r30[13]) & 4294967295L;
        long r12 = ((((long) r30[7]) & 4294967295L) + r5) - 1;
        long r14 = (((long) r30[8]) & 4294967295L) + r7;
        long r8 = (((long) r30[9]) & 4294967295L) + r9;
        long r10 = ((((long) r30[0]) & 4294967295L) - r12) + 0;
        long r23 = r10 & 4294967295L;
        long r11 = (r10 >> 32) + ((((long) r30[1]) & 4294967295L) - r14);
        r31[1] = (int) r11;
        long r6 = (r11 >> 32) + ((((long) r30[2]) & 4294967295L) - r8);
        r31[2] = (int) r6;
        long r13 = (r6 >> 32) + (((((long) r30[3]) & 4294967295L) + r12) - r1);
        long r15 = r13 & 4294967295L;
        long r16 = (r13 >> 32) + (((((long) r30[4]) & 4294967295L) + r14) - r5);
        r31[4] = (int) r16;
        long r17 = (r16 >> 32) + (((((long) r30[5]) & 4294967295L) + r8) - r7);
        r31[5] = (int) r17;
        long r18 = (r17 >> 32) + (((((long) r30[6]) & 4294967295L) + r1) - r9);
        r31[6] = (int) r18;
        long r2 = (r18 >> 32) + 1;
        long r19 = r15 + r2;
        long r3 = r23 - r2;
        r31[0] = (int) r3;
        long r4 = r3 >> 32;
        if (r4 == 0) goto L5;
        long r20 = r4 + (((long) r31[1]) & 4294967295L);
        r31[1] = (int) r20;
        long r21 = (r20 >> 32) + (4294967295L & ((long) r31[2]));
        r31[2] = (int) r21;
        r19 = r19 + (r21 >> 32);
    L5:
        r31[3] = (int) r19;
        if ((r19 >> 32) == 0) goto L10;
        if (Nat.incAt(7, r31, 4) == 0) goto L10;
    L13:
        addPInvTo(r31);
        return;
    L10:
        if (r31[6] == (-1)) goto L12;
        return;
    L12:
        if (Nat224.gte(r31, P) == true) goto L13;
    }

    public static void reduce32(int r11, int[] r12) {
        if (r11 == 0) goto L8;
        long r2 = ((long) r11) & 4294967295L;
        long r6 = ((((long) r12[0]) & 4294967295L) - r2) + 0;
        r12[0] = (int) r6;
        long r7 = r6 >> 32;
        if (r7 == 0) goto L7;
        long r8 = r7 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r8;
        long r9 = (r8 >> 32) + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r9;
        r7 = r9 >> 32;
    L7:
        long r10 = r7 + ((4294967295L & ((long) r12[3])) + r2);
        r12[3] = (int) r10;
        long r3 = r10 >> 32;
    L10:
        if (r3 == 0) goto L14;
        if (Nat.incAt(7, r12, 4) == 0) goto L14;
    L17:
        addPInvTo(r12);
        return;
    L14:
        if (r12[6] == (-1)) goto L16;
        return;
    L16:
        if (Nat224.gte(r12, P) == true) goto L17;
        return;
    L8:
        r3 = 0;
        goto L10
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat224.createExt();
        Nat224.square(r1, r0);
        reduce(r0, r2);
    }

    public static void squareN(int[] r1, int r2, int[] r3) {
        int[] r0 = Nat224.createExt();
        Nat224.square(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        Nat224.square(r3, r0);
        goto L3
    }

    private static void subPInvFrom(int[] r12) {
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
        long r5 = r2 + ((4294967295L & ((long) r12[3])) - 1);
        r12[3] = (int) r5;
        if ((r5 >> 32) == 0) goto L9;
        Nat.decAt(7, r12, 4);
        return;
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat224.sub(r0, r1, r2) == 0) goto L6;
        subPInvFrom(r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(7, r2, 0, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r3, P) == true) goto L8;
    }
}
