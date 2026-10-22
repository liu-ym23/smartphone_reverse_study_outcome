package org.apache.poi.poifs.crypt.xor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class XOREncryptionInfoBuilder implements EncryptionInfoBuilder {
    public XOREncryptionInfoBuilder() {
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r1, CipherAlgorithm r2, HashAlgorithm r3, int r4, int r5, ChainingMode r6) {
        r1.setHeader(new XOREncryptionHeader());
        r1.setVerifier(new XOREncryptionVerifier());
        XORDecryptor r0 = new XORDecryptor();
        r0.setEncryptionInfo(r1);
        r1.setDecryptor(r0);
        XOREncryptor r7 = new XOREncryptor();
        r7.setEncryptionInfo(r1);
        r1.setEncryptor(r7);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r2, LittleEndianInput r3) {
        LittleEndianInput r1 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r2.setHeader(new XOREncryptionHeader());
        r2.setVerifier(new XOREncryptionVerifier(r1));
        XORDecryptor r4 = new XORDecryptor();
        r4.setEncryptionInfo(r2);
        r2.setDecryptor(r4);
        XOREncryptor r5 = new XOREncryptor();
        r5.setEncryptionInfo(r2);
        r2.setEncryptor(r5);
    }
}
