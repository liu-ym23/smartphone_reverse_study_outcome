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
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class KEKRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private KEKIdentifier kekid;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    public KEKRecipientInfo(ASN1Sequence r4) {
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin");
        this.kekid = KEKIdentifier.getInstance(r4.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r4.getObjectAt(2));
        this.encryptedKey = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(3), ASN1OctetString.class, "com.obric.memorydata.plugin");
    }

    public static KEKRecipientInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, KEKRecipientInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new KEKRecipientInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (KEKRecipientInfo) ZeusTransformUtils.preCheckCast(r2, KEKRecipientInfo.class, "com.obric.memorydata.plugin");
    }

    public static KEKRecipientInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public KEKIdentifier getKekid() {
        return this.kekid;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(this.version);
        r0.add(this.kekid);
        r0.add(this.keyEncryptionAlgorithm);
        r0.add(this.encryptedKey);
        return new DERSequence(r0);
    }
}
