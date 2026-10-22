package org.apache.poi.poifs.crypt.binaryrc4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class BinaryRC4EncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public BinaryRC4EncryptionInfoBuilder() {
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r1, CipherAlgorithm r2, HashAlgorithm r3, int r4, int r5, ChainingMode r6) {
        r1.setHeader(new BinaryRC4EncryptionHeader());
        r1.setVerifier(new BinaryRC4EncryptionVerifier());
        BinaryRC4Decryptor r0 = new BinaryRC4Decryptor();
        r0.setEncryptionInfo(r1);
        r1.setDecryptor(r0);
        BinaryRC4Encryptor r7 = new BinaryRC4Encryptor();
        r7.setEncryptionInfo(r1);
        r1.setEncryptor(r7);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r2, LittleEndianInput r3) {
        LittleEndianInput r1 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r2.getVersionMajor();
        r2.getVersionMinor();
        r2.setHeader(new BinaryRC4EncryptionHeader());
        r2.setVerifier(new BinaryRC4EncryptionVerifier(r1));
        BinaryRC4Decryptor r4 = new BinaryRC4Decryptor();
        r4.setEncryptionInfo(r2);
        r2.setDecryptor(r4);
        BinaryRC4Encryptor r5 = new BinaryRC4Encryptor();
        r5.setEncryptionInfo(r2);
        r2.setEncryptor(r5);
    }
}
