package org.bouncycastle.cms.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.RecipientOperator;

/* JADX INFO: loaded from: classes7.dex */
public class JceKeyTransEnvelopedRecipient extends JceKeyTransRecipient {
    public JceKeyTransEnvelopedRecipient(PrivateKey r3) {
        super((PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.cms.KeyTransRecipient
    public RecipientOperator getRecipientOperator(AlgorithmIdentifier r2, final AlgorithmIdentifier r3, byte[] r4) {
        Key r5 = extractSecretKey(r2, r3, r4);
        final Cipher r6 = this.contentHelper.createContentCipher(r5, r3);
        return new RecipientOperator(new AnonymousClass1(this, r3, r6));
    }
}
