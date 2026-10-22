package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {
    private final BigInteger d;

    public ECPrivateKeyParameters(BigInteger r2, ECDomainParameters r3) {
        super(true, r3);
        this.d = r3.validatePrivateScalar(r2);
    }

    public BigInteger getD() {
        return this.d;
    }
}
