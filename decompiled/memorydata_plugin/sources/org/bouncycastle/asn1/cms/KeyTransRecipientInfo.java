package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class KeyTransRecipientInfo extends ASN1Object {
    private ASN1OctetString encryptedKey;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private RecipientIdentifier rid;
    private ASN1Integer version;

    private KeyTransRecipientInfo(ASN1Sequence r4) {
        this.version = (ASN1Integer) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1Integer.class, "com.obric.memorydata.plugin");
        this.rid = RecipientIdentifier.getInstance(r4.getObjectAt(1));
        this.keyEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r4.getObjectAt(2));
        this.encryptedKey = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(3), ASN1OctetString.class, "com.obric.memorydata.plugin");
    }

    public static KeyTransRecipientInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, KeyTransRecipientInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new KeyTransRecipientInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (KeyTransRecipientInfo) ZeusTransformUtils.preCheckCast(r2, KeyTransRecipientInfo.class, "com.obric.memorydata.plugin");
    }

    public ASN1OctetString getEncryptedKey() {
        return this.encryptedKey;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.rid;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(this.version);
        r0.add(this.rid);
        r0.add(this.keyEncryptionAlgorithm);
        r0.add(this.encryptedKey);
        return new DERSequence(r0);
    }
}
