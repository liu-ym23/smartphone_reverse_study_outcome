package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class SymmAlgorithm extends ASN1Enumerated {
    public static final SymmAlgorithm aes128Ccm = null;

    static {
        aes128Ccm = new SymmAlgorithm(BigInteger.ZERO);
    }

    public SymmAlgorithm(BigInteger r1) {
        super(r1);
        assertValues();
    }

    public void assertValues() {
        if (BigIntegers.intValueExact(getValue()) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("invalid enumeration value " + getValue());
    }
}
