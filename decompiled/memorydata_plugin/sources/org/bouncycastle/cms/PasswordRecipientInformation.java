package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class PasswordRecipientInformation extends RecipientInformation {
    static Map BLOCKSIZES;
    static Map KEYSIZES;
    private PasswordRecipientInfo info;

    static {
        KEYSIZES = new HashMap();
        HashMap r0 = new HashMap();
        BLOCKSIZES = r0;
        r0.put(CMSAlgorithm.DES_EDE3_CBC, Integers.valueOf(8));
        BLOCKSIZES.put(CMSAlgorithm.AES128_CBC, Integers.valueOf(16));
        BLOCKSIZES.put(CMSAlgorithm.AES192_CBC, Integers.valueOf(16));
        BLOCKSIZES.put(CMSAlgorithm.AES256_CBC, Integers.valueOf(16));
        KEYSIZES.put(CMSAlgorithm.DES_EDE3_CBC, Integers.valueOf(192));
        KEYSIZES.put(CMSAlgorithm.AES128_CBC, Integers.valueOf(128));
        KEYSIZES.put(CMSAlgorithm.AES192_CBC, Integers.valueOf(192));
        KEYSIZES.put(CMSAlgorithm.AES256_CBC, Integers.valueOf(256));
    }

    PasswordRecipientInformation(PasswordRecipientInfo r3, AlgorithmIdentifier r4, CMSSecureReadable r5, AuthAttributesProvider r6) {
        CMSSecureReadable r7 = (CMSSecureReadable) ZeusTransformUtils.wrapperContextForParams(r5, CMSSecureReadable.class, "com.obric.memorydata.plugin");
        AuthAttributesProvider r8 = (AuthAttributesProvider) ZeusTransformUtils.wrapperContextForParams(r6, AuthAttributesProvider.class, "com.obric.memorydata.plugin");
        super(r3.getKeyEncryptionAlgorithm(), r4, r7, r8);
        this.info = r3;
        this.rid = new PasswordRecipientId();
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
        return this.info.getKeyDerivationAlgorithm();
    }

    @Override // org.bouncycastle.cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient r5) {
        PasswordRecipient r6 = (PasswordRecipient) ZeusTransformUtils.preCheckCast((Recipient) ZeusTransformUtils.wrapperContextForParams(r5, Recipient.class, "com.obric.memorydata.plugin"), PasswordRecipient.class, "com.obric.memorydata.plugin");
        AlgorithmIdentifier r0 = AlgorithmIdentifier.getInstance(AlgorithmIdentifier.getInstance(this.info.getKeyEncryptionAlgorithm()).getParameters());
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(KEYSIZES.get(r0.getAlgorithm()), Integer.class, "com.obric.memorydata.plugin")).intValue();
        byte[] r2 = r6.calculateDerivedKey(r6.getPasswordConversionScheme(), getKeyDerivationAlgorithm(), r1);
        return r6.getRecipientOperator(r0, this.messageAlgorithm, r2, this.info.getEncryptedKey().getOctets());
    }
}
