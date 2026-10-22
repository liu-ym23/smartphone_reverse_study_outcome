package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class AttCertValidityPeriod extends ASN1Object {
    ASN1GeneralizedTime notAfterTime;
    ASN1GeneralizedTime notBeforeTime;

    private AttCertValidityPeriod(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        this.notBeforeTime = ASN1GeneralizedTime.getInstance(r3.getObjectAt(0));
        this.notAfterTime = ASN1GeneralizedTime.getInstance(r3.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static AttCertValidityPeriod getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, AttCertValidityPeriod.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new AttCertValidityPeriod(ASN1Sequence.getInstance(r2));
    L5:
        return (AttCertValidityPeriod) ZeusTransformUtils.preCheckCast(r2, AttCertValidityPeriod.class, "com.obric.memorydata.plugin");
    }

    public ASN1GeneralizedTime getNotAfterTime() {
        return this.notAfterTime;
    }

    public ASN1GeneralizedTime getNotBeforeTime() {
        return this.notBeforeTime;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.notBeforeTime);
        r0.add(this.notAfterTime);
        return new DERSequence(r0);
    }
}
