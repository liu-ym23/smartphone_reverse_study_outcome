package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class AttCertIssuer extends ASN1Object implements ASN1Choice {
    ASN1Primitive choiceObj;
    ASN1Encodable obj;

    public AttCertIssuer(GeneralNames r1) {
        this.obj = r1;
        this.choiceObj = r1.toASN1Primitive();
    }

    public AttCertIssuer(V2Form r3) {
        this.obj = r3;
        this.choiceObj = new DERTaggedObject(false, 0, this.obj);
    }

    public static AttCertIssuer getInstance(Object r3) {
        if (r3 == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r3, AttCertIssuer.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r3, V2Form.class) == false) goto L12;
        return new AttCertIssuer(V2Form.getInstance(r3));
    L12:
        if (ZeusTransformUtils.instanceOf(r3, GeneralNames.class) == false) goto L16;
        return new AttCertIssuer((GeneralNames) ZeusTransformUtils.preCheckCast(r3, GeneralNames.class, "com.obric.memorydata.plugin"));
    L16:
        if (ZeusTransformUtils.instanceOf(r3, ASN1TaggedObject.class) == false) goto L20;
        return new AttCertIssuer(V2Form.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r3, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false));
    L20:
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L24;
        return new AttCertIssuer(GeneralNames.getInstance(r3));
    L24:
        throw new IllegalArgumentException("unknown object in factory: " + r3.getClass().getName());
    L26:
        return (AttCertIssuer) ZeusTransformUtils.preCheckCast(r3, AttCertIssuer.class, "com.obric.memorydata.plugin");
    }

    public ASN1Encodable getIssuer() {
        return this.obj;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.choiceObj;
    }
}
