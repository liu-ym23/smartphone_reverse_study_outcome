package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: loaded from: classes7.dex */
public class AgileEncryptionVerifier extends EncryptionVerifier {
    private int blockSize;
    private int keyBits;

    public AgileEncryptionVerifier(CipherAlgorithm r2, HashAlgorithm r3, int r4, int r5, ChainingMode r6) {
        this.keyBits = -1;
        this.blockSize = -1;
        setCipherAlgorithm(r2);
        setHashAlgorithm(r3);
        setChainingMode(r6);
        setKeySize(r4);
        setBlockSize(r5);
        setSpinCount(100000);
    }

    public AgileEncryptionVerifier(EncryptionDocument r4) {
        this.keyBits = -1;
        this.blockSize = -1;
        Iterator<KeyEncryptor> r5 = r4.getKeyEncryptors().iterator();
        PasswordKeyEncryptor r0 = null;
    L4:
        if (r5.hasNext() == false) goto L7;
        r0 = ((KeyEncryptor) ZeusTransformUtils.preCheckCast(r5.next(), KeyEncryptor.class, "com.obric.memorydata.plugin")).getPasswordKeyEncryptor();
        if (r0 == null) goto L4;
    L7:
        if (r0 == null) goto L30;
        setCipherAlgorithm(r0.getCipherAlgorithm());
        setKeySize(r0.getKeyBits().intValue());
        setBlockSize(r0.getBlockSize().intValue());
        int r6 = r0.getHashSize().intValue();
        setHashAlgorithm(r0.getHashAlgorithm());
        if (getHashAlgorithm().hashSize != r6) goto L28;
        Integer r7 = r0.getSpinCount();
        if (r7 == null) goto L13;
        setSpinCount(r7.intValue());
    L13:
        setEncryptedVerifier(r0.getEncryptedVerifierHashInput());
        setSalt(r0.getSaltValue());
        setEncryptedKey(r0.getEncryptedKeyValue());
        setEncryptedVerifierHash(r0.getEncryptedVerifierHashValue());
        Integer r8 = r0.getSaltSize();
        if (r8 == null) goto L26;
        if (r8.intValue() != getSalt().length) goto L26;
        setChainingMode(r0.getCipherChaining());
        if (r0.getCipherChaining() != ChainingMode.cbc) goto L20;
        return;
    L20:
        if (r0.getCipherChaining() != ChainingMode.cfb) goto L23;
        return;
    L23:
        throw new EncryptedDocumentException("Unsupported chaining mode - " + r0.getCipherChaining());
    L26:
        throw new EncryptedDocumentException("Invalid salt size");
    L28:
        throw new EncryptedDocumentException("Unsupported hash algorithm: " + r0.getHashAlgorithm() + " @ " + r6 + " bytes");
    L30:
        throw new IllegalArgumentException("encryptedKey not set");
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    public void setBlockSize(int r1) {
        this.blockSize = r1;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public final void setCipherAlgorithm(CipherAlgorithm r3) {
        super.setCipherAlgorithm(r3);
        if (r3.allowedKeySize.length != 1) goto L6;
        setKeySize(r3.defaultKeySize);
        return;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedKey(byte[] r1) {
        super.setEncryptedKey(r1);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifier(byte[] r1) {
        super.setEncryptedVerifier(r1);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifierHash(byte[] r1) {
        super.setEncryptedVerifierHash(r1);
    }

    public void setKeySize(int r5) {
        this.keyBits = r5;
        int[] r0 = getCipherAlgorithm().allowedKeySize;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        if (r0[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new EncryptedDocumentException("KeySize " + r5 + " not allowed for cipher " + getCipherAlgorithm());
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setSalt(byte[] r3) {
        if (r3 == null) goto L8;
        if (r3.length != getCipherAlgorithm().blockSize) goto L8;
        super.setSalt(r3);
        return;
    L8:
        throw new EncryptedDocumentException("invalid verifier salt");
    }
}
