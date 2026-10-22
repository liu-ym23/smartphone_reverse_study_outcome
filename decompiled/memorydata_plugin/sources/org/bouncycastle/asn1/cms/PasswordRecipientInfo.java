package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
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
public class PasswordRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private ASN1Integer version;

    private PasswordRecipientInfo(ASN1Sequence r6) {
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6.getObjectAt(1), ASN1TaggedObject.class) == false) goto L5;
        this.keyDerivationAlgorithm = AlgorithmIdentifier.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r6.getObjectAt(2));
        ASN1Encodable r7 = r6.getObjectAt(3);
    L6:
        this.encryptedKey = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r7, ASN1OctetString.class, "com.obric.memorydata.plugin");
        return;
    L5:
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r6.getObjectAt(1));
        r7 = r6.getObjectAt(2);
        goto L6
    }

    public static PasswordRecipientInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, PasswordRecipientInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new PasswordRecipientInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (PasswordRecipientInfo) ZeusTransformUtils.preCheckCast(r2, PasswordRecipientInfo.class, "com.obric.memorydata.plugin");
    }

    public static PasswordRecipientInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
        return this.keyDerivationAlgorithm;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(this.version);
        if (this.keyDerivationAlgorithm == null) goto L5;
        r0.add(new DERTaggedObject(false, 0, this.keyDerivationAlgorithm));
    L5:
        r0.add(this.keyEncryptionAlgorithm);
        r0.add(this.encryptedKey);
        return new DERSequence(r0);
    }
}
