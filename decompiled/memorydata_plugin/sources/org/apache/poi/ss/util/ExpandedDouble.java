package org.apache.poi.ss.util;

import com.ttnet.org.chromium.net.NetError;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
final class ExpandedDouble {
    private static final BigInteger BI_FRAC_MASK = null;
    private static final BigInteger BI_IMPLIED_FRAC_MSB = null;
    private final int _binaryExponent;
    private final BigInteger _significand;

    static {
        BI_FRAC_MASK = BigInteger.valueOf(4503599627370495L);
        BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(4503599627370496L);
    }

    public ExpandedDouble(long r3) {
        int r0 = Math.toIntExact(r3 >> 52);
        if (r0 != 0) goto L5;
        BigInteger r4 = BigInteger.valueOf(r3).and(BI_FRAC_MASK);
        int r5 = 64 - r4.bitLength();
        this._significand = r4.shiftLeft(r5);
        int r6 = (-1023) - r5;
    L6:
        this._binaryExponent = r6;
        return;
    L5:
        this._significand = getFrac(r3);
        r6 = (r0 & 2047) + NetError.ERR_BT_FRAME_CODEC_ERROR;
        goto L6
    }

    ExpandedDouble(BigInteger r3, int r4) {
        if (r3.bitLength() != 64) goto L7;
        this._significand = r3;
        this._binaryExponent = r4;
        return;
    L7:
        throw new IllegalArgumentException("bad bit length");
    }

    public static ExpandedDouble fromRawBitsAndExponent(long r1, int r3) {
        return new ExpandedDouble(getFrac(r1), r3);
    }

    private static BigInteger getFrac(long r0) {
        return BigInteger.valueOf(r0).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
    }

    public int getBinaryExponent() {
        return this._binaryExponent;
    }

    public NormalisedDecimal normaliseBaseTen() {
        return NormalisedDecimal.create(this._significand, this._binaryExponent);
    }
}
