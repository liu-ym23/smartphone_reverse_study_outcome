package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410PublicKeyParameters extends GOST3410KeyParameters {
    private BigInteger y;

    public GOST3410PublicKeyParameters(BigInteger r2, GOST3410Parameters r3) {
        super(false, r3);
        this.y = r2;
    }

    public BigInteger getY() {
        return this.y;
    }
}
