package org.bouncycastle.asn1.x9;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class DHDomainParameters extends ASN1Object {
    private ASN1Integer g;
    private ASN1Integer j;
    private ASN1Integer p;
    private ASN1Integer q;
    private DHValidationParms validationParms;

    private DHDomainParameters(ASN1Sequence r3) {
        if (r3.size() < 3) goto L15;
        if (r3.size() > 5) goto L15;
        Enumeration r4 = r3.getObjects();
        this.p = ASN1Integer.getInstance(r4.nextElement());
        this.g = ASN1Integer.getInstance(r4.nextElement());
        this.q = ASN1Integer.getInstance(r4.nextElement());
        ASN1Encodable r0 = getNext(r4);
        if (r0 != null) goto L9;
    L11:
        if (r0 == null) goto L16;
        this.validationParms = DHValidationParms.getInstance(r0.toASN1Primitive());
        return;
    L16:
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ASN1Integer.class) == false) goto L11;
        this.j = ASN1Integer.getInstance(r0);
        r0 = getNext(r4);
    L15:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static DHDomainParameters getInstance(Object r3) {
        if (r3 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, DHDomainParameters.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L12;
        return new DHDomainParameters((ASN1Sequence) ZeusTransformUtils.preCheckCast(r3, ASN1Sequence.class, "com.obric.memorydata.plugin"));
    L12:
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + r3.getClass().getName());
    L14:
        return (DHDomainParameters) ZeusTransformUtils.preCheckCast(r3, DHDomainParameters.class, "com.obric.memorydata.plugin");
    }

    private static ASN1Encodable getNext(Enumeration r2) {
        Enumeration r3 = (Enumeration) ZeusTransformUtils.wrapperContextForParams(r2, Enumeration.class, "com.obric.memorydata.plugin");
        if (r3.hasMoreElements() == true) goto L7;
        return null;
    L7:
        return (ASN1Encodable) ZeusTransformUtils.preCheckCast(r3.nextElement(), ASN1Encodable.class, "com.obric.memorydata.plugin");
    }

    public ASN1Integer getG() {
        return this.g;
    }

    public ASN1Integer getP() {
        return this.p;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(this.p);
        r0.add(this.g);
        r0.add(this.q);
        ASN1Integer r1 = this.j;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        DHValidationParms r2 = this.validationParms;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        return new DERSequence(r0);
    }
}
