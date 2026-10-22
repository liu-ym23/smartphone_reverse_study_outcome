package org.apache.poi.poifs.crypt.cryptoapi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoAPIEncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public CryptoAPIEncryptionInfoBuilder() {
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r7, CipherAlgorithm r8, HashAlgorithm r9, int r10, int r11, ChainingMode r12) {
        if (r8 != null) goto L4;
        r8 = CipherAlgorithm.rc4;
    L4:
        if (r9 != null) goto L7;
        r9 = HashAlgorithm.sha1;
    L7:
        if (r10 != (-1)) goto L9;
        r10 = 40;
    L9:
        CipherAlgorithm r1 = r8;
        HashAlgorithm r2 = r9;
        int r3 = r10;
        r7.setHeader(new CryptoAPIEncryptionHeader(r1, r2, r3, r11, r12));
        r7.setVerifier(new CryptoAPIEncryptionVerifier(r1, r2, r3, r11, r12));
        CryptoAPIDecryptor r6 = new CryptoAPIDecryptor();
        r6.setEncryptionInfo(r7);
        r7.setDecryptor(r6);
        CryptoAPIEncryptor r13 = new CryptoAPIEncryptor();
        r13.setEncryptionInfo(r7);
        r7.setEncryptor(r13);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r2, LittleEndianInput r3) {
        LittleEndianInput r1 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        r1.readInt();
        CryptoAPIEncryptionHeader r4 = new CryptoAPIEncryptionHeader(r1);
        r2.setHeader(r4);
        r2.setVerifier(new CryptoAPIEncryptionVerifier(r1, r4));
        Decryptor r5 = new CryptoAPIDecryptor();
        r5.setEncryptionInfo(r2);
        r2.setDecryptor(r5);
        Encryptor r6 = new CryptoAPIEncryptor();
        r6.setEncryptionInfo(r2);
        r2.setEncryptor(r6);
    }
}
