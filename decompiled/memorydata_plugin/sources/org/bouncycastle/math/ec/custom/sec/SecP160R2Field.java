package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class SecP160R2Field {
    static final int[] P = null;
    private static final int[] PExt = null;
    private static final int[] PExtInv = null;

    static {
        P = new int[]{-21389, -2, -1, -1, -1};
        PExt = new int[]{457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};
        PExtInv = new int[]{-457489321, -42779, -2, -1, -1, 42777, 2};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        if (Nat160.add(r0, r1, r2) == 0) goto L5;
    L8:
        Nat.add33To(5, 21389, r2);
        return;
    L5:
        if (r2[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r2, P) == true) goto L8;
    }

    public static void addOne(int[] r2, int[] r3) {
        if (Nat.inc(5, r2, r3) == 0) goto L5;
    L8:
        Nat.add33To(5, 21389, r3);
        return;
    L5:
        if (r3[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r3, P) == true) goto L8;
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat160.fromBigInteger(r2);
        if (r3[4] != (-1)) goto L7;
        int[] r0 = P;
        if (Nat160.gte(r3, r0) == false) goto L7;
        Nat160.subFrom(r0, r3);
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
        if (r0 >= 5) goto L7;
        r1 = r1 | r3[r0];
        r0 = r0 + 1;
        goto L4
    L7:
        return (((r1 >>> 1) | (r1 & 1)) - 1) >> 31;
    }

    public static void multiply(int[] r1, int[] r2, int[] r3) {
        int[] r0 = Nat160.createExt();
        Nat160.mul(r1, r2, r0);
        reduce(r0, r3);
    }

    public static void multiplyAddToExt(int[] r1, int[] r2, int[] r3) {
        if (Nat160.mulAddTo(r1, r2, r3) == 0) goto L5;
    L8:
        int[] r4 = PExtInv;
        if (Nat.addTo(r4.length, r4, r3) == 0) goto L14;
        Nat.incAt(10, r3, r4.length);
        return;
    L14:
        return;
    L5:
        if (r3[9] == (-1)) goto L7;
        return;
    L7:
        if (Nat.gte(10, r3, PExt) == true) goto L8;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat160.sub(r3, r3, r2);
        return;
    L5:
        Nat160.sub(P, r1, r2);
    }

    public static void random(SecureRandom r3, int[] r4) {
        byte[] r0 = new byte[20];
    L3:
        r3.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r4, 0, 5);
        if (Nat.lessThan(5, r4, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r7, int[] r8) {
        if (Nat160.mul33DWordAdd(21389, Nat160.mul33Add(21389, r7, 5, r7, 0, r8, 0), r8, 0) == 0) goto L5;
    L8:
        Nat.add33To(5, 21389, r8);
        return;
    L5:
        if (r8[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r8, P) == true) goto L8;
    }

    public static void reduce32(int r2, int[] r3) {
        if (r2 == 0) goto L7;
        if (Nat160.mul33WordAdd(21389, r2, r3, 0) == 0) goto L7;
    L10:
        Nat.add33To(5, 21389, r3);
        return;
    L7:
        if (r3[4] == (-1)) goto L9;
        return;
    L9:
        if (Nat160.gte(r3, P) == true) goto L10;
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat160.createExt();
        Nat160.square(r1, r0);
        reduce(r0, r2);
    }

    public static void squareN(int[] r1, int r2, int[] r3) {
        int[] r0 = Nat160.createExt();
        Nat160.square(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        Nat160.square(r3, r0);
        goto L3
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat160.sub(r0, r1, r2) == 0) goto L6;
        Nat.sub33From(5, 21389, r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        if (Nat.shiftUpBit(5, r2, 0, r3) == 0) goto L5;
    L8:
        Nat.add33To(5, 21389, r3);
        return;
    L5:
        if (r3[4] == (-1)) goto L7;
        return;
    L7:
        if (Nat160.gte(r3, P) == true) goto L8;
    }
}
