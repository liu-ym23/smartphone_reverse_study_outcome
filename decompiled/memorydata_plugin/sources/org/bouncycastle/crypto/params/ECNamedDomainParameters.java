package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes7.dex */
public class ECNamedDomainParameters extends ECDomainParameters {
    private ASN1ObjectIdentifier name;

    public ECNamedDomainParameters(ASN1ObjectIdentifier r1, X9ECParameters r2) {
        super(r2);
        this.name = r1;
    }

    public ECNamedDomainParameters(ASN1ObjectIdentifier r7, ECCurve r8, ECPoint r9, BigInteger r10, BigInteger r11, byte[] r12) {
        super(r8, r9, r10, r11, r12);
        this.name = r7;
    }

    public ASN1ObjectIdentifier getName() {
        return this.name;
    }
}
