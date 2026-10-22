package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FiniteFields {
    static final FiniteField GF_2 = null;
    static final FiniteField GF_3 = null;

    static {
        GF_2 = new PrimeField(BigInteger.valueOf(2));
        GF_3 = new PrimeField(BigInteger.valueOf(3));
    }

    public static PolynomialExtensionField getBinaryExtensionField(int[] r3) {
        if (r3[0] != 0) goto L15;
        int r0 = 1;
    L6:
        if (r0 >= r3.length) goto L13;
        if (r3[r0] <= r3[r0 - 1]) goto L11;
        r0 = r0 + 1;
        goto L6
    L11:
        throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
    L13:
        return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(r3));
    L15:
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static FiniteField getPrimeField(BigInteger r3) {
        int r0 = r3.bitLength();
        if (r3.signum() <= 0) goto L19;
        if (r0 < 2) goto L19;
        if (r0 >= 3) goto L17;
        int r1 = BigIntegers.intValueExact(r3);
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L17;
        return GF_3;
    L15:
        return GF_2;
    L17:
        return new PrimeField(r3);
    L19:
        throw new IllegalArgumentException("'characteristic' must be >= 2");
    }
}
