package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ElGamalPrivateKeySpec extends ElGamalKeySpec {
    private BigInteger x;

    public BigInteger getX() {
        return this.x;
    }
}
