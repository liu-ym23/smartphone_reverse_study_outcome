package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Enumeration;
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

/* JADX INFO: loaded from: classes7.dex */
public class ContentInfo extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1Encodable content;
    private ASN1ObjectIdentifier contentType;
    private boolean isBer;

    public ContentInfo(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        ASN1Encodable r5 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin");
        this.isBer = true;
        this.contentType = r3;
        this.content = r5;
    }

    private ContentInfo(ASN1Sequence r5) {
        this.isBer = true;
        Enumeration r0 = r5.getObjects();
        this.contentType = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r0.nextElement(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        if (r0.hasMoreElements() == false) goto L5;
        this.content = ((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r0.nextElement(), ASN1TaggedObject.class, "com.obric.memorydata.plugin")).getObject();
    L5:
        this.isBer = ZeusTransformUtils.instanceOf(r5, BERSequence.class);
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

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.contentType);
        if (this.content == null) goto L6;
        r0.add(new BERTaggedObject(true, 0, this.content));
    L6:
        if (this.isBer == false) goto L10;
        return new BERSequence(r0);
    L10:
        return new DLSequence(r0);
    }
}
