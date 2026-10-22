package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class DSAParameter extends ASN1Object {
    ASN1Integer g;
    ASN1Integer p;
    ASN1Integer q;

    public DSAParameter(BigInteger r2, BigInteger r3, BigInteger r4) {
        this.p = new ASN1Integer(r2);
        this.q = new ASN1Integer(r3);
        this.g = new ASN1Integer(r4);
    }

    private DSAParameter(ASN1Sequence r3) {
        if (r3.size() != 3) goto L7;
        Enumeration r4 = r3.getObjects();
        this.p = ASN1Integer.getInstance(r4.nextElement());
        this.q = ASN1Integer.getInstance(r4.nextElement());
        this.g = ASN1Integer.getInstance(r4.nextElement());
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static DSAParameter getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DSAParameter.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DSAParameter(ASN1Sequence.getInstance(r2));
    L5:
        return (DSAParameter) ZeusTransformUtils.preCheckCast(r2, DSAParameter.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.p);
        r0.add(this.q);
        r0.add(this.g);
        return new DERSequence(r0);
    }
}
