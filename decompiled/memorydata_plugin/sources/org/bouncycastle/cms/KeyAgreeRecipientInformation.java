package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import org.bouncycastle.asn1.cms.OriginatorPublicKey;
import org.bouncycastle.asn1.cms.RecipientEncryptedKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreeRecipientInformation extends RecipientInformation {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientInfo info;

    KeyAgreeRecipientInformation(KeyAgreeRecipientInfo r3, RecipientId r4, ASN1OctetString r5, AlgorithmIdentifier r6, CMSSecureReadable r7, AuthAttributesProvider r8) {
        CMSSecureReadable r9 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r7, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r10 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r8, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        super(r3.getKeyEncryptionAlgorithm(), r6, r9, r10);
        this.info = r3;
        this.rid = r4;
        this.encryptedKey = r5;
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorId(OriginatorId r1) {
        throw new CMSException("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorPublicKey(AlgorithmIdentifier r1, OriginatorPublicKey r2) {
        return new SubjectPublicKeyInfo(r1, r2.getPublicKey().getBytes());
    }

    private SubjectPublicKeyInfo getSenderPublicKeyInfo(AlgorithmIdentifier r2, OriginatorIdentifierOrKey r3) {
        OriginatorPublicKey r0 = r3.getOriginatorKey();
        if (r0 != null) goto L5;
        IssuerAndSerialNumber r4 = r3.getIssuerAndSerialNumber();
        if (r4 == null) goto L9;
        OriginatorId r5 = new OriginatorId(r4.getName(), r4.getSerialNumber().getValue());
    L11:
        return getPublicKeyInfoFromOriginatorId(r5);
    L9:
        r5 = new OriginatorId(r3.getSubjectKeyIdentifier().getKeyIdentifier());
        goto L11
    L5:
        return getPublicKeyInfoFromOriginatorPublicKey(r2, r0);
    }

    static void readRecipientInfo(List r10, KeyAgreeRecipientInfo r11, AlgorithmIdentifier r12, CMSSecureReadable r13, AuthAttributesProvider r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        CMSSecureReadable r16 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r13, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r17 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r14, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        ASN1Sequence r0 = r11.getRecipientEncryptedKeys();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L10;
        RecipientEncryptedKey r2 = RecipientEncryptedKey.getInstance(r0.getObjectAt(r1));
        KeyAgreeRecipientIdentifier r3 = r2.getIdentifier();
        IssuerAndSerialNumber r4 = r3.getIssuerAndSerialNumber();
        if (r4 == null) goto L8;
        KeyAgreeRecipientId r5 = new KeyAgreeRecipientId(r4.getName(), r4.getSerialNumber().getValue());
    L9:
        r15.add(new KeyAgreeRecipientInformation(r11, r5, r2.getEncryptedKey(), r12, r16, r17));
        r1 = r1 + 1;
        goto L4
    L8:
        r5 = new KeyAgreeRecipientId(r3.getRKeyID().getSubjectKeyIdentifier().getOctets());
        goto L9
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient r8) {
        Recipient r9 = (Recipient) ZeusTransformUtils.wrapperContextForParams(r8, Recipient.class, "com.obric.memorydata.plugin");
        AlgorithmIdentifier r0 = ((KeyAgreeRecipient) ZeusTransformUtils.preCheckCast(r9, KeyAgreeRecipient.class, "com.obric.memorydata.plugin")).getPrivateKeyAlgorithmIdentifier();
        return ((KeyAgreeRecipient) ZeusTransformUtils.preCheckCast(r9, KeyAgreeRecipient.class, "com.obric.memorydata.plugin")).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, getSenderPublicKeyInfo(r0, this.info.getOriginator()), this.info.getUserKeyingMaterial(), this.encryptedKey.getOctets());
    }
}
