package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreeRecipientInfo extends ASN1Object {
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private OriginatorIdentifierOrKey originator;
    private ASN1Sequence recipientEncryptedKeys;
    private ASN1OctetString ukm;
    private ASN1Integer version;

    private KeyAgreeRecipientInfo(ASN1Sequence r6) {
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin");
        this.originator = OriginatorIdentifierOrKey.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true);
        int r1 = 2;
        if (ZeusTransformUtils.instanceOf(r6.getObjectAt(2), ASN1TaggedObject.class) == false) goto L5;
        this.ukm = ASN1OctetString.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(2), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), true);
        r1 = 3;
    L5:
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r6.getObjectAt(r1));
        this.recipientEncryptedKeys = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r1 + 1), ASN1Sequence.class, "com.obric.memorydata.plugin");
    }

    public static KeyAgreeRecipientInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, KeyAgreeRecipientInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new KeyAgreeRecipientInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (KeyAgreeRecipientInfo) ZeusTransformUtils.preCheckCast(r2, KeyAgreeRecipientInfo.class, "com.obric.memorydata.plugin");
    }

    public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public OriginatorIdentifierOrKey getOriginator() {
        return this.originator;
    }

    public ASN1Sequence getRecipientEncryptedKeys() {
        return this.recipientEncryptedKeys;
    }

    public ASN1OctetString getUserKeyingMaterial() {
        return this.ukm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(5);
        r0.add(this.version);
        r0.add(new DERTaggedObject(true, 0, this.originator));
        if (this.ukm == null) goto L5;
        r0.add(new DERTaggedObject(true, 1, this.ukm));
    L5:
        r0.add(this.keyEncryptionAlgorithm);
        r0.add(this.recipientEncryptedKeys);
        return new DERSequence(r0);
    }
}
