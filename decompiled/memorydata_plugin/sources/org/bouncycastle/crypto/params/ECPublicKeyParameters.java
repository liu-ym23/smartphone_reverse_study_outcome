package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECPublicKeyParameters extends ECKeyParameters {
    private final ECPoint q;

    public ECPublicKeyParameters(ECPoint r2, ECDomainParameters r3) {
        super(false, r3);
        this.q = r3.validatePublicPoint(r2);
    }

    public ECPoint getQ() {
        return this.q;
    }
}
