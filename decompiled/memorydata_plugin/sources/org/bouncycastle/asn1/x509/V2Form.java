package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class V2Form extends ASN1Object {
    IssuerSerial baseCertificateID;
    GeneralNames issuerName;
    ObjectDigestInfo objectDigestInfo;

    private V2Form(ASN1Sequence r6) {
        if (r6.size() > 3) goto L21;
        if (ZeusTransformUtils.instanceOf(r6.getObjectAt(0), ASN1TaggedObject.class) == true) goto L7;
        this.issuerName = GeneralNames.getInstance(r6.getObjectAt(0));
        int r1 = 1;
    L9:
        if (r1 == r6.size()) goto L19;
        ASN1TaggedObject r3 = ASN1TaggedObject.getInstance(r6.getObjectAt(r1));
        if (r3.getTagNo() != 0) goto L14;
        this.baseCertificateID = IssuerSerial.getInstance(r3, false);
    L16:
        r1 = r1 + 1;
        goto L9
    L14:
        if (r3.getTagNo() != 1) goto L18;
        this.objectDigestInfo = ObjectDigestInfo.getInstance(r3, false);
        goto L16
    L18:
        throw new IllegalArgumentException("Bad tag number: " + r3.getTagNo());
    L19:
        return;
    L7:
        r1 = 0;
        goto L9
    L21:
        throw new IllegalArgumentException("Bad sequence size: " + r6.size());
    }

    public static V2Form getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, V2Form.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new V2Form(ASN1Sequence.getInstance(r2));
    L5:
        return (V2Form) ZeusTransformUtils.preCheckCast(r2, V2Form.class, "com.obric.memorydata.plugin");
    }

    public static V2Form getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getIssuerName() {
        return this.issuerName;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        GeneralNames r1 = this.issuerName;
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if (this.baseCertificateID == null) goto L9;
        r0.add(new DERTaggedObject(false, 0, this.baseCertificateID));
    L9:
        if (this.objectDigestInfo == null) goto L12;
        r0.add(new DERTaggedObject(false, 1, this.objectDigestInfo));
    L12:
        return new DERSequence(r0);
    }
}
