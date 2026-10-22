package org.bouncycastle.asn1.oiw;

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
public class ElGamalParameter extends ASN1Object {
    ASN1Integer g;
    ASN1Integer p;

    public ElGamalParameter(BigInteger r2, BigInteger r3) {
        this.p = new ASN1Integer(r2);
        this.g = new ASN1Integer(r3);
    }

    private ElGamalParameter(ASN1Sequence r4) {
        Enumeration r5 = r4.getObjects();
        this.p = (ASN1Integer) ZeusTransformUtils.preCheckCast(r5.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
        this.g = (ASN1Integer) ZeusTransformUtils.preCheckCast(r5.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
    }

    public static ElGamalParameter getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ElGamalParameter.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ElGamalParameter(ASN1Sequence.getInstance(r2));
    L5:
        return (ElGamalParameter) ZeusTransformUtils.preCheckCast(r2, ElGamalParameter.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.p);
        r0.add(this.g);
        return new DERSequence(r0);
    }
}
