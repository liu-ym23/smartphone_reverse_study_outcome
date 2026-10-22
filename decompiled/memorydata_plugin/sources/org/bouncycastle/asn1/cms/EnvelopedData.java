package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class EnvelopedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private OriginatorInfo originatorInfo;
    private ASN1Set recipientInfos;
    private ASN1Set unprotectedAttrs;
    private ASN1Integer version;

    private EnvelopedData(ASN1Sequence r6) {
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin");
        ASN1Encodable r1 = r6.getObjectAt(1);
        int r4 = 2;
        if (ZeusTransformUtils.instanceOf(r1, ASN1TaggedObject.class) == false) goto L5;
        this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r1, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
        r4 = 3;
        r1 = r6.getObjectAt(2);
    L5:
        this.recipientInfos = ASN1Set.getInstance(r1);
        int r2 = r4 + 1;
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(r6.getObjectAt(r4));
        if (r6.size() <= r2) goto L9;
        this.unprotectedAttrs = ASN1Set.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r2), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
        return;
    }

    public static EnvelopedData getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EnvelopedData.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EnvelopedData(ASN1Sequence.getInstance(r2));
    L5:
        return (EnvelopedData) ZeusTransformUtils.preCheckCast(r2, EnvelopedData.class, "com.obric.memorydata.plugin");
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(this.version);
        if (this.originatorInfo == null) goto L5;
        r0.add(new DERTaggedObject(false, 0, this.originatorInfo));
    L5:
        r0.add(this.recipientInfos);
        r0.add(this.encryptedContentInfo);
        if (this.unprotectedAttrs == null) goto L9;
        r0.add(new DERTaggedObject(false, 1, this.unprotectedAttrs));
    L9:
        return new BERSequence(r0);
    }
}
