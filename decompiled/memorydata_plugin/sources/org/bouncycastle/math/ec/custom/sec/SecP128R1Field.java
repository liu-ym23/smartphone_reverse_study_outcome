package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP128R1Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-1, -1, -1, -3};
        PExt = new int[]{1, 0, 0, 4, -2, -1, 3, -4};
        PExtInv = new int[]{-1, -1, -1, -5, 1, 0, -4, 3};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat128.add(r0, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if ((r2[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r1, int[] r2) {
        if (Nat.inc(4, r1, r2) == 0) goto L5;
    L8:
        addPInvTo(r2);
        return;
    L5:
        if ((r2[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r2, P) == true) goto L8;
    }

    private static void addPInvTo(int[] r8) {
        long r1 = (((long) r8[0]) & 4294967295L) + 1;
        r8[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r8[1]) & 4294967295L);
        r8[1] = (int) r3;
        long r4 = (r3 >> 32) + (((long) r8[2]) & 4294967295L);
        r8[2] = (int) r4;
        r2 = r4 >> 32;
    L5:
        r8[3] = (int) (r2 + ((4294967295L & ((long) r8[3])) + 2));
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat128.fromBigInteger(r2);
        if ((r3[3] >>> 1) < 2147483646) goto L7;
        int[] r0 = P;
        if (Nat128.gte(r3, r0) == false) goto L7;
        Nat128.subFrom(r0, r3);
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
        if (r0 >= 4) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat128.createExt();
        Nat128.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(int[] r0, int[] r1, int[] r2) {
        if (Nat128.mulAddTo(r0, r1, r2) == 0) goto L5;
    L8:
        int[] r3 = PExtInv;
        Nat.addTo(r3.length, r3, r2);
        return;
    L5:
        if ((r2[7] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat256.gte(r2, PExt) == true) goto L8;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat128.sub(r3, r3, r2);
        return;
    L5:
        Nat128.sub(P, r1, r2);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[16];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 4);
        if (Nat.lessThan(4, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r22, int[] r23) {
        long r2 = ((long) r22[0]) & 4294967295L;
        long r7 = ((long) r22[1]) & 4294967295L;
        long r10 = ((long) r22[2]) & 4294967295L;
        long r13 = ((long) r22[3]) & 4294967295L;
        long r1 = ((long) r22[4]) & 4294967295L;
        long r9 = ((long) r22[5]) & 4294967295L;
        long r6 = ((long) r22[6]) & 4294967295L;
        long r3 = ((long) r22[7]) & 4294967295L;
        long r14 = r13 + r3;
        long r8 = r6 + (r3 << 1);
        long r4 = r10 + r8;
        long r11 = r9 + (r8 << 1);
        long r12 = r7 + r11;
        long r5 = r1 + (r11 << 1);
        long r15 = r2 + r5;
        long r16 = r14 + (r5 << 1);
        r23[0] = (int) r15;
        long r17 = r12 + (r15 >>> 32);
        r23[1] = (int) r17;
        long r18 = r4 + (r17 >>> 32);
        r23[2] = (int) r18;
        long r19 = r16 + (r18 >>> 32);
        r23[3] = (int) r19;
        reduce32((int) (r19 >>> 32), r23);
    }

    public static void reduce32(int r11, int[] r12) {
    L3:
        if (r11 == 0) goto L9;
        long r2 = ((long) r11) & 4294967295L;
        long r6 = (((long) r12[0]) & 4294967295L) + r2;
        r12[0] = (int) r6;
        long r7 = r6 >> 32;
        if (r7 == 0) goto L7;
        long r8 = r7 + (((long) r12[1]) & 4294967295L);
        r12[1] = (int) r8;
        long r9 = (r8 >> 32) + (((long) r12[2]) & 4294967295L);
        r12[2] = (int) r9;
        r7 = r9 >> 32;
    L7:
        long r10 = r7 + ((4294967295L & ((long) r12[3])) + (r2 << 1));
        r12[3] = (int) r10;
        r11 = (int) (r10 >> 32);
        goto L3
    L9:
        if ((r12[3] >>> 1) >= 2147483646) goto L11;
        return;
    L11:
        if (Nat128.gte(r12, P) == false) goto L18;
        addPInvTo(r12);
        return;
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat128.createExt();
        Nat128.square(r1, r0);
        reduce(r0, r2);
    }

    public static void squareN(int[] r1, int r2, int[] r3) {
        int[] r0 = Nat128.createExt();
        Nat128.square(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        Nat128.square(r3, r0);
        goto L3
    }

    private static void subPInvFrom(int[] r8) {
        long r1 = (((long) r8[0]) & 4294967295L) - 1;
        r8[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        long r3 = r2 + (((long) r8[1]) & 4294967295L);
        r8[1] = (int) r3;
        long r4 = (r3 >> 32) + (((long) r8[2]) & 4294967295L);
        r8[2] = (int) r4;
        r2 = r4 >> 32;
    L5:
        r8[3] = (int) (r2 + ((4294967295L & ((long) r8[3])) - 2));
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat128.sub(r0, r1, r2) == 0) goto L6;
        subPInvFrom(r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(4, r2, 0, r3) == 0) goto L5;
    L8:
        addPInvTo(r3);
        return;
    L5:
        if ((r3[3] >>> 1) >= 2147483646) goto L7;
        return;
    L7:
        if (Nat128.gte(r3, P) == true) goto L8;
    }
}
