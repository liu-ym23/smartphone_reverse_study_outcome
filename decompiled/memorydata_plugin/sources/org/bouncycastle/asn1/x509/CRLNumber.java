package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes7.dex */
public class CRLNumber extends ASN1Object {
    private BigInteger number;

    public CRLNumber(BigInteger r2) {
        if (BigIntegers.ZERO.compareTo(r2) > 0) goto L7;
        this.number = r2;
        return;
    L7:
        throw new IllegalArgumentException("Invalid CRL number : not in (0..MAX)");
    }

    public BigInteger getCRLNumber() {
        return this.number;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.number);
    }

    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
