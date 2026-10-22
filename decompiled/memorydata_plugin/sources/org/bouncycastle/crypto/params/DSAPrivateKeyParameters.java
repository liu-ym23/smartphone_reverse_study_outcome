package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class DSAPrivateKeyParameters extends DSAKeyParameters {
    private BigInteger x;

    public DSAPrivateKeyParameters(BigInteger r2, DSAParameters r3) {
        super(true, r3);
        this.x = r2;
    }

    public BigInteger getX() {
        return this.x;
    }
}
