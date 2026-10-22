package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP224K1Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-6803, -2, -1, -1, -1, -1, -1};
        PExt = new int[]{46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};
        PExtInv = new int[]{-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat224.add(r0, r1, r2) == 0) goto L5;
    L8:
        Nat.add33To(7, 6803, r2);
        return;
    L5:
        if (r2[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r2, int[] r3) {
        if (Nat.inc(7, r2, r3) == 0) goto L5;
    L8:
        Nat.add33To(7, 6803, r3);
        return;
    L5:
        if (r3[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r3, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat224.fromBigInteger(r2);
        if (r3[6] == (-1)) goto L5;
    L7:
        return r3;
    L5:
        if (Nat224.gte(r3, P) == false) goto L7;
        Nat.add33To(7, 6803, r3);
        goto L7
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

    public static void reduce(int[] r7, int[] r8) {
        if (Nat224.mul33DWordAdd(6803, Nat224.mul33Add(6803, r7, 7, r7, 0, r8, 0), r8, 0) == 0) goto L5;
    L8:
        Nat.add33To(7, 6803, r8);
        return;
    L5:
        if (r8[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r8, P) == true) goto L8;
    }

    public static void reduce32(int r2, int[] r3) {
        if (r2 == 0) goto L7;
        if (Nat224.mul33WordAdd(6803, r2, r3, 0) == 0) goto L7;
    L10:
        Nat.add33To(7, 6803, r3);
        return;
    L7:
        if (r3[6] == (-1)) goto L9;
        return;
    L9:
        if (Nat224.gte(r3, P) == true) goto L10;
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

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat224.sub(r0, r1, r2) == 0) goto L6;
        Nat.sub33From(7, 6803, r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(7, r2, 0, r3) == 0) goto L5;
    L8:
        Nat.add33To(7, 6803, r3);
        return;
    L5:
        if (r3[6] == (-1)) goto L7;
        return;
    L7:
        if (Nat224.gte(r3, P) == true) goto L8;
    }
}
