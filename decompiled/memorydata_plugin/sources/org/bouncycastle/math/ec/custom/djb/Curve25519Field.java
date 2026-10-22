package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class Curve25519Field {
    static final int[] P = null;
    private static final int[] PExt = null;

    static {
        P = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        PExt = new int[]{361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};
    }

    public static void add(int[] r0, int[] r1, int[] r2) {
        Nat256.add(r0, r1, r2);
        if (Nat256.gte(r2, P) == false) goto L6;
        subPFrom(r2);
        return;
    }

    public static void addOne(int[] r1, int[] r2) {
        Nat.inc(8, r1, r2);
        if (Nat256.gte(r2, P) == false) goto L6;
        subPFrom(r2);
        return;
    }

    private static int addPTo(int[] r9) {
        long r1 = (((long) r9[0]) & 4294967295L) - 19;
        r9[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        r2 = Nat.decAt(7, r9, 1);
    L5:
        long r3 = r2 + ((4294967295L & ((long) r9[7])) + 2147483648L);
        r9[7] = (int) r3;
        return (int) (r3 >> 32);
    }

    public static int[] fromBigInteger(BigInteger r2) {
        int[] r3 = Nat256.fromBigInteger(r2);
    L3:
        int[] r0 = P;
        if (Nat256.gte(r3, r0) == false) goto L6;
        Nat256.subFrom(r0, r3);
        goto L3
    L6:
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

    public static void multiplyAddToExt(int[] r0, int[] r1, int[] r2) {
        Nat256.mulAddTo(r0, r1, r2);
        if (Nat.gte(16, r2, PExt) == false) goto L6;
        subPExtFrom(r2);
        return;
    }

    public static void negate(int[] r1, int[] r2) {
        if (isZero(r1) == 0) goto L5;
        int[] r3 = P;
        Nat256.sub(r3, r3, r2);
        return;
    L5:
        Nat256.sub(P, r1, r2);
    }

    public static void random(SecureRandom r5, int[] r6) {
        byte[] r0 = new byte[32];
    L3:
        r5.nextBytes(r0);
        Pack.littleEndianToInt(r0, 0, r6, 0, 8);
        r6[7] = r6[7] & Integer.MAX_VALUE;
        if (Nat.lessThan(8, r6, P) == 0) goto L3;
    }

    public static void randomMult(SecureRandom r1, int[] r2) {
    L2:
        random(r1, r2);
        if (isZero(r2) != 0) goto L2;
    }

    public static void reduce(int[] r8, int[] r9) {
        int r7 = r8[7];
        Nat.shiftUpBit(8, r8, 8, r7, r9, 0);
        int r10 = Nat256.mulByWordAddTo(19, r8, r9) << 1;
        int r2 = r9[7];
        int r11 = r10 + ((r2 >>> 31) - (r7 >>> 31));
        r9[7] = (r2 & Integer.MAX_VALUE) + Nat.addWordTo(7, r11 * 19, r9);
        if (Nat256.gte(r9, P) == false) goto L6;
        subPFrom(r9);
        return;
    }

    public static void reduce27(int r3, int[] r4) {
        int r1 = r4[7];
        int r5 = (r3 << 1) | (r1 >>> 31);
        r4[7] = (r1 & Integer.MAX_VALUE) + Nat.addWordTo(7, r5 * 19, r4);
        if (Nat256.gte(r4, P) == false) goto L6;
        subPFrom(r4);
        return;
    }

    public static void square(int[] r1, int[] r2) {
        int[] r0 = Nat256.createExt();
        Nat256.square(r1, r0);
        reduce(r0, r2);
    }

    public static void squareN(int[] r1, int r2, int[] r3) {
        int[] r0 = Nat256.createExt();
        Nat256.square(r1, r0);
    L3:
        reduce(r0, r3);
        r2 = r2 - 1;
        if (r2 <= 0) goto L6;
        Nat256.square(r3, r0);
        goto L3
    }

    private static int subPExtFrom(int[] r15) {
        long r1 = ((long) r15[0]) & 4294967295L;
        int[] r5 = PExt;
        long r2 = r1 - (((long) r5[0]) & 4294967295L);
        r15[0] = (int) r2;
        long r3 = r2 >> 32;
        if (r3 == 0) goto L5;
        r3 = Nat.decAt(8, r15, 1);
    L5:
        long r4 = r3 + ((((long) r15[8]) & 4294967295L) + 19);
        r15[8] = (int) r4;
        long r6 = r4 >> 32;
        if (r6 == 0) goto L8;
        r6 = Nat.incAt(15, r15, 9);
    L8:
        long r7 = r6 + ((((long) r15[15]) & 4294967295L) - (4294967295L & ((long) (r5[15] + 1))));
        r15[15] = (int) r7;
        return (int) (r7 >> 32);
    }

    private static int subPFrom(int[] r9) {
        long r1 = (((long) r9[0]) & 4294967295L) + 19;
        r9[0] = (int) r1;
        long r2 = r1 >> 32;
        if (r2 == 0) goto L5;
        r2 = Nat.incAt(7, r9, 1);
    L5:
        long r3 = r2 + ((4294967295L & ((long) r9[7])) - 2147483648L);
        r9[7] = (int) r3;
        return (int) (r3 >> 32);
    }

    public static void subtract(int[] r0, int[] r1, int[] r2) {
        if (Nat256.sub(r0, r1, r2) == 0) goto L6;
        addPTo(r2);
        return;
    }

    public static void twice(int[] r2, int[] r3) {
        Nat.shiftUpBit(8, r2, 0, r3);
        if (Nat256.gte(r3, P) == false) goto L6;
        subPFrom(r3);
        return;
    }
}
