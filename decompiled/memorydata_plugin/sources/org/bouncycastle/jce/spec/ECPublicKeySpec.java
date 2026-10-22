package org.bouncycastle.jce.spec;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECPublicKeySpec extends ECKeySpec {
    private ECPoint q;

    public ECPoint getQ() {
        return this.q;
    }
}
