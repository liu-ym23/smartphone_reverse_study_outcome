package org.apache.poi.ss.util;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
final class MutableFPNumber {
    private static final BigInteger BI_MAX_BASE = null;
    private static final BigInteger BI_MIN_BASE = null;
    private int _binaryExponent;
    private BigInteger _significand;

    private static final class Rounder {
        private static final BigInteger[] HALF_BITS = null;

        static {
            BigInteger[] r1 = new BigInteger[33];
            long r3 = 1;
            int r5 = 1;
        L3:
            if (r5 >= 33) goto L5;
            r1[r5] = BigInteger.valueOf(r3);
            r3 = r3 << 1;
            r5 = r5 + 1;
            goto L3
        L5:
            HALF_BITS = r1;
        }

        public static BigInteger round(BigInteger r1, int r2) {
            if (r2 >= 1) goto L6;
            return r1;
        L6:
            return r1.add(HALF_BITS[r2]);
        }
    }

    private static final class TenPower {
        private static final BigInteger FIVE = null;
        private static final TenPower[] _cache = null;
        public final BigInteger _divisor;
        public final int _divisorShift;
        public final BigInteger _multiplicand;
        public final int _multiplierShift;

        static {
            FIVE = BigInteger.valueOf(5);
            _cache = new TenPower[350];
        }

        private TenPower(int r5) {
            BigInteger r0 = FIVE.pow(r5);
            int r1 = r0.bitLength();
            BigInteger r2 = BigInteger.ONE.shiftLeft(r1 + 80).divide(r0);
            int r3 = r2.bitLength() - 80;
            this._divisor = r2.shiftRight(r3);
            this._divisorShift = -(((r1 - r3) + r5) + 80);
            int r4 = r0.bitLength() - 68;
            if (r4 <= 0) goto L5;
            this._multiplierShift = r5 + r4;
            this._multiplicand = r0.shiftRight(r4);
            return;
        L5:
            this._multiplierShift = r5;
            this._multiplicand = r0;
        }

        static TenPower getInstance(int r2) {
            TenPower[] r0 = _cache;
            TenPower r1 = r0[r2];
            if (r1 != null) goto L6;
            TenPower r3 = new TenPower(r2);
            r0[r2] = r3;
            return r3;
        L6:
            return r1;
        }
    }

    static {
        BI_MIN_BASE = new BigInteger("0B5E620F47FFFE666", 16);
        BI_MAX_BASE = new BigInteger("0E35FA9319FFFE000", 16);
    }

    public MutableFPNumber(BigInteger r1, int r2) {
        this._significand = r1;
        this._binaryExponent = r2;
    }

    private void mulShift(BigInteger r2, int r3) {
        BigInteger r4 = this._significand.multiply(r2);
        this._significand = r4;
        this._binaryExponent += r3;
        int r5 = (r4.bitLength() - 72) & (-32);
        if (r5 <= 0) goto L6;
        this._significand = this._significand.shiftRight(r5);
        this._binaryExponent += r5;
        return;
    }

    public NormalisedDecimal createNormalisedDecimal(int r4) {
        return new NormalisedDecimal(this._significand.shiftRight((64 - this._binaryExponent) - 1).longValue(), (this._significand.intValue() << (this._binaryExponent - 39)) & 16777088, r4);
    }

    public int get64BitNormalisedExponent() {
        return (this._binaryExponent + this._significand.bitLength()) - 64;
    }

    public boolean isAboveMinRep() {
        if (this._significand.compareTo(BI_MIN_BASE.shiftLeft(this._significand.bitLength() - 64)) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBelowMaxRep() {
        if (this._significand.compareTo(BI_MAX_BASE.shiftLeft(this._significand.bitLength() - 64)) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void multiplyByPowerOfTen(int r2) {
        TenPower r0 = TenPower.getInstance(Math.abs(r2));
        if (r2 >= 0) goto L5;
        BigInteger r3 = r0._divisor;
        int r1 = r0._divisorShift;
    L6:
        mulShift(r3, r1);
        return;
    L5:
        r3 = r0._multiplicand;
        r1 = r0._multiplierShift;
        goto L6
    }

    public void normalise64bit() {
        int r0 = this._significand.bitLength();
        int r1 = r0 - 64;
        if (r1 != 0) goto L5;
        return;
    L5:
        if (r1 < 0) goto L19;
        this._binaryExponent += r1;
        if (r1 <= 32) goto L10;
        int r2 = (r1 - 1) & 16777184;
        this._significand = this._significand.shiftRight(r2);
        r1 = r1 - r2;
        r0 = r0 - r2;
    L10:
        if (r1 < 1) goto L17;
        BigInteger r3 = Rounder.round(this._significand, r1);
        this._significand = r3;
        if (r3.bitLength() <= r0) goto L14;
        r1 = r1 + 1;
        this._binaryExponent++;
    L14:
        this._significand = this._significand.shiftRight(r1);
        return;
    L17:
        throw new IllegalStateException();
    L19:
        throw new IllegalStateException("Not enough precision");
    }
}
