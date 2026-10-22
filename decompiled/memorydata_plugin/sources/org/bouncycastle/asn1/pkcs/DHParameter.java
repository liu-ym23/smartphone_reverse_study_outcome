package org.bouncycastle.asn1.pkcs;

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
public class DHParameter extends ASN1Object {
    ASN1Integer g;
    ASN1Integer l;
    ASN1Integer p;

    public DHParameter(BigInteger r2, BigInteger r3, int r4) {
        this.p = new ASN1Integer(r2);
        this.g = new ASN1Integer(r3);
        if (r4 == 0) goto L5;
        ASN1Integer r5 = new ASN1Integer(r4);
    L6:
        this.l = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    private DHParameter(ASN1Sequence r3) {
        Enumeration r4 = r3.getObjects();
        this.p = ASN1Integer.getInstance(r4.nextElement());
        this.g = ASN1Integer.getInstance(r4.nextElement());
        if (r4.hasMoreElements() == false) goto L5;
        ASN1Integer r5 = (ASN1Integer) ZeusTransformUtils.preCheckCast(r4.nextElement(), ASN1Integer.class, "com.obric.memorydata.plugin");
    L6:
        this.l = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static DHParameter getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, DHParameter.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new DHParameter(ASN1Sequence.getInstance(r2));
    L5:
        return (DHParameter) ZeusTransformUtils.preCheckCast(r2, DHParameter.class, "com.obric.memorydata.plugin");
    }

    public BigInteger getG() {
        return this.g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPositiveValue();
    }

    public BigInteger getP() {
        return this.p.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.p);
        r0.add(this.g);
        if (getL() == null) goto L6;
        r0.add(this.l);
    L6:
        return new DERSequence(r0);
    }
}
