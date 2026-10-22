package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class KeyTransRecipientInformation extends RecipientInformation {
    private KeyTransRecipientInfo info;

    KeyTransRecipientInformation(KeyTransRecipientInfo r3, AlgorithmIdentifier r4, CMSSecureReadable r5, AuthAttributesProvider r6) {
        CMSSecureReadable r7 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r8 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r6, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        super(r3.getKeyEncryptionAlgorithm(), r4, r7, r8);
        this.info = r3;
        RecipientIdentifier r9 = r3.getRecipientIdentifier();
        boolean r10 = r9.isTagged();
        ASN1Encodable r11 = r9.getId();
        if (r10 == false) goto L5;
        KeyTransRecipientId r12 = new KeyTransRecipientId(ASN1OctetString.getInstance(r11).getOctets());
    L6:
        this.rid = r12;
        return;
    L5:
        IssuerAndSerialNumber r13 = IssuerAndSerialNumber.getInstance(r11);
        r12 = new KeyTransRecipientId(r13.getName(), r13.getSerialNumber().getValue());
        goto L6
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient r3) {
        return ((KeyTransRecipient) ZeusTransformUtils.preCheckCast((Recipient) ZeusTransformUtils.wrapperContextForParams(r3, Recipient.class, "com.obric.memorydata.plugin"), KeyTransRecipient.class, "com.obric.memorydata.plugin")).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.info.getEncryptedKey().getOctets());
    }
}
