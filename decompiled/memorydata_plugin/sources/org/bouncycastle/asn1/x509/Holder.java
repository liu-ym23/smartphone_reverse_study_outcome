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
public class Holder extends ASN1Object {
    IssuerSerial baseCertificateID;
    GeneralNames entityName;
    ObjectDigestInfo objectDigestInfo;
    private int version;

    private Holder(ASN1Sequence r7) {
        this.version = 1;
        if (r7.size() > 3) goto L21;
        int r2 = 0;
    L6:
        if (r2 == r7.size()) goto L18;
        ASN1TaggedObject r3 = ASN1TaggedObject.getInstance(r7.getObjectAt(r2));
        int r4 = r3.getTagNo();
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L11;
        this.entityName = GeneralNames.getInstance(r3, false);
    L17:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r4 != 2) goto L14;
        this.objectDigestInfo = ObjectDigestInfo.getInstance(r3, false);
        goto L17
    L14:
        throw new IllegalArgumentException("unknown tag in Holder");
    L16:
        this.baseCertificateID = IssuerSerial.getInstance(r3, false);
        goto L17
    L18:
        this.version = 1;
        return;
    L21:
        throw new IllegalArgumentException("Bad sequence size: " + r7.size());
    }

    private Holder(ASN1TaggedObject r3) {
        this.version = 1;
        int r1 = r3.getTagNo();
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        this.entityName = GeneralNames.getInstance(r3, true);
    L9:
        this.version = 0;
        return;
    L7:
        throw new IllegalArgumentException("unknown tag in Holder");
    L8:
        this.baseCertificateID = IssuerSerial.getInstance(r3, true);
        goto L9
    }

    public static Holder getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Holder.class) == false) goto L7;
        return (Holder) ZeusTransformUtils.preCheckCast(r2, Holder.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ASN1TaggedObject.class) == true) goto L9;
        if (r2 != null) goto L12;
        return null;
    L12:
        return new Holder(ASN1Sequence.getInstance(r2));
    L9:
        return new Holder(ASN1TaggedObject.getInstance(r2));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getEntityName() {
        return this.entityName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.version != 1) goto L16;
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        if (this.baseCertificateID == null) goto L8;
        r0.add(new DERTaggedObject(false, 0, this.baseCertificateID));
    L8:
        if (this.entityName == null) goto L11;
        r0.add(new DERTaggedObject(false, 1, this.entityName));
    L11:
        if (this.objectDigestInfo == null) goto L14;
        r0.add(new DERTaggedObject(false, 2, this.objectDigestInfo));
    L14:
        return new DERSequence(r0);
    L16:
        if (this.entityName == null) goto L20;
        return new DERTaggedObject(true, 1, this.entityName);
    L20:
        return new DERTaggedObject(true, 0, this.baseCertificateID);
    }
}
