package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class KEKRecipientInformation extends RecipientInformation {
    private KEKRecipientInfo info;

    KEKRecipientInformation(KEKRecipientInfo r3, AlgorithmIdentifier r4, CMSSecureReadable r5, AuthAttributesProvider r6) {
        CMSSecureReadable r7 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r8 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r6, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        super(r3.getKeyEncryptionAlgorithm(), r4, r7, r8);
        this.info = r3;
        this.rid = new KEKRecipientId(r3.getKekid().getKeyIdentifier().getOctets());
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient r3) {
        return ((KEKRecipient) ZeusTransformUtils.preCheckCast((Recipient) ZeusTransformUtils.wrapperContextForParams(r3, Recipient.class, "com.obric.memorydata.plugin"), KEKRecipient.class, "com.obric.memorydata.plugin")).getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, this.info.getEncryptedKey().getOctets());
    }
}
