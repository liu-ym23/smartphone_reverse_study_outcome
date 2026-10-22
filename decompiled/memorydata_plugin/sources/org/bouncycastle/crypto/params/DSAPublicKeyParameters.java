package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class DSAPublicKeyParameters extends DSAKeyParameters {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;
    private BigInteger y;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public DSAPublicKeyParameters(BigInteger r2, DSAParameters r3) {
        super(false, r3);
        this.y = validate(r2, r3);
    }

    private BigInteger validate(BigInteger r2, DSAParameters r3) {
        if (r3 == null) goto L12;
        BigInteger r1 = TWO;
        if (r1.compareTo(r2) > 0) goto L11;
        if (r3.getP().subtract(r1).compareTo(r2) < 0) goto L11;
        if (ONE.equals(r2.modPow(r3.getQ(), r3.getP())) == false) goto L11;
        return r2;
    L11:
        throw new IllegalArgumentException("y value does not appear to be in correct group");
    L12:
        return r2;
    }

    public BigInteger getY() {
        return this.y;
    }
}
