package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
public class ECPrivateKeySpec extends ECKeySpec {
    private BigInteger d;

    public BigInteger getD() {
        return this.d;
    }
}
