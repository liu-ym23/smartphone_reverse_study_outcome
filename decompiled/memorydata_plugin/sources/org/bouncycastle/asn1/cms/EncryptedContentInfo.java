package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptedContentInfo extends ASN1Object {
    private AlgorithmIdentifier contentEncryptionAlgorithm;
    private ASN1ObjectIdentifier contentType;
    private ASN1OctetString encryptedContent;

    private EncryptedContentInfo(ASN1Sequence r6) {
        if (r6.size() < 2) goto L9;
        this.contentType = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        this.contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r6.getObjectAt(1));
        if (r6.size() <= 2) goto L10;
        this.encryptedContent = ASN1OctetString.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(2), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Truncated Sequence Found");
    }

    public static EncryptedContentInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptedContentInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptedContentInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptedContentInfo) ZeusTransformUtils.preCheckCast(r2, EncryptedContentInfo.class, "com.obric.memorydata.plugin");
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.contentEncryptionAlgorithm;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public ASN1OctetString getEncryptedContent() {
        return this.encryptedContent;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.contentType);
        r0.add(this.contentEncryptionAlgorithm);
        if (this.encryptedContent == null) goto L6;
        r0.add(new BERTaggedObject(false, 0, this.encryptedContent));
    L6:
        return new BERSequence(r0);
    }
}
