package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410ParamSetParameters extends ASN1Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ASN1Integer f17967a;
    int keySize;
    ASN1Integer p;
    ASN1Integer q;

    public GOST3410ParamSetParameters(int r1, BigInteger r2, BigInteger r3, BigInteger r4) {
        this.keySize = r1;
        this.p = new ASN1Integer(r2);
        this.q = new ASN1Integer(r3);
        this.f17967a = new ASN1Integer(r4);
    }

    public BigInteger getA() {
        return this.f17967a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(new ASN1Integer(this.keySize));
        r0.add(this.p);
        r0.add(this.q);
        r0.add(this.f17967a);
        return new DERSequence(r0);
    }
}
