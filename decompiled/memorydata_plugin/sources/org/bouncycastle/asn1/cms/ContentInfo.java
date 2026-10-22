package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.DLTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class ContentInfo extends ASN1Object implements CMSObjectIdentifiers {
    private final ASN1Encodable content;
    private final ASN1ObjectIdentifier contentType;
    private final boolean isDefiniteLength;

    private ContentInfo(ASN1Sequence r5) {
        if (r5.size() < 1) goto L19;
        if (r5.size() > 2) goto L19;
        this.contentType = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r5.getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r5.size() <= 1) goto L15;
        ASN1TaggedObject r0 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r5.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (r0.isExplicit() == false) goto L14;
        if (r0.getTagNo() != 0) goto L14;
        ASN1Primitive r1 = r0.getObject();
    L16:
        this.content = r1;
        this.isDefiniteLength = !ZeusTransformUtils.instanceOf(r5, BERSequence.class);
        return;
    L14:
        throw new IllegalArgumentException("Bad tag for 'content'");
    L15:
        r1 = null;
    L19:
        throw new IllegalArgumentException("Bad sequence size: " + r5.size());
    }

    public static ContentInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ContentInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ContentInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (ContentInfo) ZeusTransformUtils.preCheckCast(r2, ContentInfo.class, "com.obric.memorydata.plugin");
    }

    public ASN1Encodable getContent() {
        return this.content;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.contentType);
        if (this.content == null) goto L10;
        if (this.isDefiniteLength == false) goto L7;
        ASN1Encodable r1 = new DLTaggedObject(0, this.content);
    L8:
        r0.add(r1);
        goto L10
    L7:
        r1 = new BERTaggedObject(0, this.content);
    L10:
        if (this.isDefiniteLength == false) goto L13;
        return new DLSequence(r0);
    L13:
        return new BERSequence(r0);
    }
}
