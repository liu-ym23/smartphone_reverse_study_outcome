package org.apache.poi.poifs.crypt.binaryrc4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class BinaryRC4EncryptionVerifier extends EncryptionVerifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public BinaryRC4EncryptionVerifier() {
        setSpinCount(-1);
        setCipherAlgorithm(CipherAlgorithm.rc4);
        setChainingMode(null);
        setEncryptedKey(null);
        setHashAlgorithm(HashAlgorithm.md5);
    }

    public BinaryRC4EncryptionVerifier(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r1 = new byte[16];
        r4.readFully(r1);
        setSalt(r1);
        byte[] r2 = new byte[16];
        r4.readFully(r2);
        setEncryptedVerifier(r2);
        byte[] r0 = new byte[16];
        r4.readFully(r0);
        setEncryptedVerifierHash(r0);
        setSpinCount(-1);
        setCipherAlgorithm(CipherAlgorithm.rc4);
        setChainingMode(null);
        setEncryptedKey(null);
        setHashAlgorithm(HashAlgorithm.md5);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifier(byte[] r1) {
        super.setEncryptedVerifier(r1);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifierHash(byte[] r1) {
        super.setEncryptedVerifierHash(r1);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setSalt(byte[] r3) {
        if (r3 == null) goto L8;
        if (r3.length != 16) goto L8;
        super.setSalt(r3);
        return;
    L8:
        throw new EncryptedDocumentException("invalid verifier salt");
    }

    public void write(LittleEndianByteArrayOutputStream r2) {
        r2.write(getSalt());
        r2.write(getEncryptedVerifier());
        r2.write(getEncryptedVerifierHash());
    }
}
