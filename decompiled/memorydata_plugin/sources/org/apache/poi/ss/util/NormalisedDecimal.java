package org.apache.poi.ss.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
final class NormalisedDecimal {
    private static final BigDecimal BD_2_POW_24 = null;
    private final int _fractionalPart;
    private final int _relativeDecimalExponent;
    private final long _wholePart;

    static {
        BD_2_POW_24 = new BigDecimal(BigInteger.ONE.shiftLeft(24));
    }

    NormalisedDecimal(long r1, int r3, int r4) {
        this._wholePart = r1;
        this._fractionalPart = r3;
        this._relativeDecimalExponent = r4;
    }

    public static NormalisedDecimal create(BigInteger r2, int r3) {
        if (r3 <= 49) goto L5;
    L8:
        int r0 = -(((15204352 - (315653 * r3)) + 524288) >> 20);
    L9:
        MutableFPNumber r1 = new MutableFPNumber(r2, r3);
        if (r0 == 0) goto L13;
        r1.multiplyByPowerOfTen(-r0);
    L13:
        switch(r1.get64BitNormalisedExponent()) {
            case 44: goto L23;
            case 45: goto L23;
            case 46: goto L21;
            case 47: goto L24;
            case 48: goto L24;
            case 49: goto L17;
            case 50: goto L19;
            default: goto L15;
        };
    L19:
        r1.multiplyByPowerOfTen(-1);
        r0 = r0 + 1;
    L23:
        r1.multiplyByPowerOfTen(1);
        r0 = r0 - 1;
    L24:
        r1.normalise64bit();
        return r1.createNormalisedDecimal(r0);
    L15:
        throw new IllegalStateException("Bad binary exp " + r1.get64BitNormalisedExponent() + ".");
    L17:
        if (r1.isBelowMaxRep() == false) goto L19;
    L21:
        if (r1.isAboveMinRep() == false) goto L23;
    L5:
        if (r3 < 46) goto L8;
        r0 = 0;
        goto L9
    }

    private String getFractionalDigits() {
        if (this._fractionalPart != 0) goto L7;
        return "0";
    L7:
        return getFractionalPart().toString().substring(2);
    }

    public int compareNormalised(NormalisedDecimal r6) {
        int r0 = this._relativeDecimalExponent - r6._relativeDecimalExponent;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        long r1 = this._wholePart;
        long r2 = r6._wholePart;
        if (r1 <= r2) goto L10;
        return 1;
    L10:
        if (r1 >= r2) goto L14;
        return -1;
    L14:
        return this._fractionalPart - r6._fractionalPart;
    }

    public int getDecimalExponent() {
        return this._relativeDecimalExponent + 14;
    }

    public BigDecimal getFractionalPart() {
        return BigDecimal.valueOf(this._fractionalPart).divide(BD_2_POW_24);
    }

    public String getSignificantDecimalDigits() {
        return Long.toString(this._wholePart);
    }

    public String getSignificantDecimalDigitsLastDigitRounded() {
        long r0 = this._wholePart + 5;
        StringBuilder r4 = new StringBuilder(24);
        r4.append(r0);
        r4.setCharAt(r4.length() - 1, '0');
        return r4.toString();
    }

    public NormalisedDecimal roundUnits() {
        long r0 = this._wholePart;
        if (this._fractionalPart < 8388608) goto L5;
        r0 = r0 + 1;
    L5:
        int r6 = this._relativeDecimalExponent;
        if (r0 >= 1000000000000000L) goto L10;
        return new NormalisedDecimal(r0, 0, r6);
    L10:
        return new NormalisedDecimal(r0 / 10, 0, r6 + 1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getName());
        r0.append(" [");
        String r1 = String.valueOf(this._wholePart);
        r0.append(r1.charAt(0));
        r0.append('.');
        r0.append(r1.substring(1));
        r0.append(' ');
        r0.append(getFractionalDigits());
        r0.append('E');
        r0.append(getDecimalExponent());
        r0.append(']');
        return r0.toString();
    }
}
