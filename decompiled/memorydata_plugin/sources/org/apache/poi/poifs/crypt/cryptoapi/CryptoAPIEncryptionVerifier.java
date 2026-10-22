package org.apache.poi.poifs.crypt.cryptoapi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoAPIEncryptionVerifier extends StandardEncryptionVerifier {
    public CryptoAPIEncryptionVerifier(CipherAlgorithm r1, HashAlgorithm r2, int r3, int r4, ChainingMode r5) {
        super(r1, r2, r3, r4, r5);
    }

    public CryptoAPIEncryptionVerifier(LittleEndianInput r3, CryptoAPIEncryptionHeader r4) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifier(byte[] r1) {
        super.setEncryptedVerifier(r1);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifierHash(byte[] r1) {
        super.setEncryptedVerifierHash(r1);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setSalt(byte[] r1) {
        super.setSalt(r1);
    }
}
