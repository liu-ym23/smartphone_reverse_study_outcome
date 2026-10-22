package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP192R1Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, -1, -2, -1, -1, -1};
        PExt = new int[]{1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};
        PExtInv = new int[]{-1, -1, -3, -1, -2, -1, 1, 0, 2};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat192.add(r0, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r1, int[] r2) {
        if (Nat.inc(6, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if (r2[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r2, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) + 1;
        r12[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r3;
        r2 = r3 >> 32;
    L5:
        long r4 = r2 + ((4294967295L & ((long) r12[2])) + 1);
        r12[2] = (int) r4;
        if ((r4 >> 32) == 0) goto L9;
        Nat.incAt(6, r12, 3);
        return;
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat192.fromBigInteger(r2);
        if (r3[5] != (-1)) goto L7;
        int[] r0 = P;
        if (Nat192.gte(r3, r0) == false) goto L7;
        Nat192.subFrom(r0, r3);
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
        if (r0 >= 6) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat192.createExt();
        Nat192.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(int[] r1, int[] r2, int[] r3) {
        if (Nat192.mulAddTo(r1, r2, r3) == 0) goto L5;
    L8:
        int[] r4 = PExtInv;
        if (Nat.addTo(r4.length, r4, r3) == 0) goto L14;
        Nat.incAt(12, r3, r4.length);
        return;
    L14:
        return;
    L5:
        if (r3[11] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(12, r3, PExt) == true) goto L8;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat192.sub(r3, r3, r2);
        return;
    L5:
        Nat192.sub(P, r1, r2);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[24];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 6);
        if (Nat.lessThan(6, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r26, int[] r27) {
        long r2 = ((long) r26[6]) & 4294967295L;
        long r6 = ((long) r26[7]) & 4294967295L;
        long r8 = ((long) r26[8]) & 4294967295L;
        long r10 = ((long) r26[9]) & 4294967295L;
        long r12 = ((long) r26[10]) & 4294967295L;
        long r13 = r12 + r2;
        long r14 = (((long) r26[11]) & 4294967295L) + r6;
        long r7 = ((((long) r26[0]) & 4294967295L) + r13) + 0;
        int r1 = (int) r7;
        long r9 = (r7 >> 32) + ((((long) r26[1]) & 4294967295L) + r14);
        r27[1] = (int) r9;
        long r15 = r13 + r8;
        long r16 = r14 + r10;
        long r3 = (r9 >> 32) + ((((long) r26[2]) & 4294967295L) + r15);
        long r11 = r3 & 4294967295L;
        long r4 = (r3 >> 32) + ((((long) r26[3]) & 4294967295L) + r16);
        r27[3] = (int) r4;
        long r17 = ((long) r26[4]) & 4294967295L;
        long r5 = (r4 >> 32) + (r17 + (r15 - r2));
        r27[4] = (int) r5;
        long r18 = ((long) r26[5]) & 4294967295L;
        long r19 = (r5 >> 32) + (r18 + (r16 - r6));
        r27[5] = (int) r19;
        long r20 = r19 >> 32;
        long r21 = r11 + r20;
        long r22 = r20 + (((long) r1) & 4294967295L);
        r27[0] = (int) r22;
        long r23 = r22 >> 32;
        if (r23 == 0) goto L5;
        long r24 = r23 + (4294967295L & ((long) r27[1]));
        r27[1] = (int) r24;
        r21 = r21 + (r24 >> 32);
    L5:
        r27[2] = (int) r21;
        if ((r21 >> 32) == 0) goto L10;
        if (Nat.incAt(6, r27, 3) == 0) goto L10;
    L13:
        addPInvTo(r27);
        return;
    L10:
        if (r27[5] == (-1)) goto L12;
        return;
    L12:
        if (Nat192.gte(r27, P) == true) goto L13;
    }

    public static void reduce32(int r11, int[] r12) {
        if (r11 == 0) goto L8;
        long r2 = ((long) r11) & 4294967295L;
        long r6 = ((((long) r12[0]) & 4294967295L) + r2) + 0;
        r12[0] = (int) r6;
        long r7 = r6 >> 32;
        if (r7 == 0) goto L7;
        long r8 = r7 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r8;
        r7 = r8 >> 32;
    L7:
        long r9 = r7 + ((4294967295L & ((long) r12[2])) + r2);
        r12[2] = (int) r9;
        long r3 = r9 >> 32;
    L10:
        if (r3 == 0) goto L14;
        if (Nat.incAt(6, r12, 3) == 0) goto L14;
    L17:
        addPInvTo(r12);
        return;
    L14:
        if (r12[5] == (-1)) goto L16;
        return;
    L16:
        if (Nat192.gte(r12, P) == true) goto L17;
        return;
    L8:
        r3 = 0;
        goto L10
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat192.createExt();
        Nat192.square(r1, r0);
        reduce(r0, r2);
    }

    public static void squareN(int[] r1, int r2, int[] r3) {
        int[] r0 = Nat192.createExt();
        Nat192.square(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        Nat192.square(r3, r0);
        goto L3
    }

    private static void subPInvFrom(int[] r12) {
        long r1 = (((long) r12[0]) & 4294967295L) - 1;
        r12[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r3;
        r2 = r3 >> 32;
    L5:
        long r4 = r2 + ((4294967295L & ((long) r12[2])) - 1);
        r12[2] = (int) r4;
        if ((r4 >> 32) == 0) goto L9;
        Nat.decAt(6, r12, 3);
        return;
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat192.sub(r0, r1, r2) == 0) goto L6;
        subPInvFrom(r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(6, r2, 0, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if (r3[5] == (-1)) goto L7;
        return;
    L7:
        if (Nat192.gte(r3, P) == true) goto L8;
    }
}
