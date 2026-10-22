package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {
    private BigInteger x;

    public GOST3410PrivateKeyParameters(BigInteger r2, GOST3410Parameters r3) {
        super(true, r3);
        this.x = r2;
    }

    public BigInteger getX() {
        return this.x;
    }
}
