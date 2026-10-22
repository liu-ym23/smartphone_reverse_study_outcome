package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECNamedCurveParameterSpec extends ECParameterSpec {
    private String name;

    public ECNamedCurveParameterSpec(String r7, ECCurve r8, ECPoint r9, BigInteger r10, BigInteger r11, byte[] r12) {
        super(r8, r9, r10, r11, r12);
        this.name = r7;
    }

    public String getName() {
        return this.name;
    }
}
