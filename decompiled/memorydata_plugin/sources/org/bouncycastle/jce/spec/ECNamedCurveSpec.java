package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes7.dex */
public class ECNamedCurveSpec extends java.security.spec.ECParameterSpec {
    private String name;

    public ECNamedCurveSpec(String r1, EllipticCurve r2, ECPoint r3, BigInteger r4, BigInteger r5) {
        super(r2, r3, r4, r5.intValue());
        this.name = r1;
    }

    public String getName() {
        return this.name;
    }
}
