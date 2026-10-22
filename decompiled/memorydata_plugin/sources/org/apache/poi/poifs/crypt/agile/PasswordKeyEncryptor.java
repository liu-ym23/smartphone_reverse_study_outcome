package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public class PasswordKeyEncryptor {
    private Integer blockSize;
    private CipherAlgorithm cipherAlgorithm;
    private ChainingMode cipherChaining;
    private byte[] encryptedKeyValue;
    private byte[] encryptedVerifierHashInput;
    private byte[] encryptedVerifierHashValue;
    private HashAlgorithm hashAlgorithm;
    private Integer hashSize;
    private Integer keyBits;
    private Integer saltSize;
    private byte[] saltValue;
    private Integer spinCount;

    public PasswordKeyEncryptor() {
    }

    public PasswordKeyEncryptor(Element r3) {
        Element r4 = (Element) ZeusTransformUtils.wrapperContextForParams(r3, Element.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.saltSize = EncryptionDocument.getIntAttr(r4, "saltSize");
        this.blockSize = EncryptionDocument.getIntAttr(r4, "blockSize");
        this.keyBits = EncryptionDocument.getIntAttr(r4, "keyBits");
        this.hashSize = EncryptionDocument.getIntAttr(r4, "hashSize");
        this.cipherAlgorithm = CipherAlgorithm.fromXmlId(r4.getAttribute("cipherAlgorithm"), this.keyBits.intValue());
        this.cipherChaining = ChainingMode.fromXmlId(r4.getAttribute("cipherChaining"));
        this.hashAlgorithm = HashAlgorithm.fromEcmaId(r4.getAttribute("hashAlgorithm"));
        this.saltValue = EncryptionDocument.getBinAttr(r4, "saltValue");
        this.spinCount = EncryptionDocument.getIntAttr(r4, "spinCount");
        this.encryptedVerifierHashInput = EncryptionDocument.getBinAttr(r4, "encryptedVerifierHashInput");
        this.encryptedVerifierHashValue = EncryptionDocument.getBinAttr(r4, "encryptedVerifierHashValue");
        this.encryptedKeyValue = EncryptionDocument.getBinAttr(r4, "encryptedKeyValue");
        return;
    L7:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    }

    public Integer getBlockSize() {
        return this.blockSize;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public ChainingMode getCipherChaining() {
        return this.cipherChaining;
    }

    public byte[] getEncryptedKeyValue() {
        return this.encryptedKeyValue;
    }

    public byte[] getEncryptedVerifierHashInput() {
        return this.encryptedVerifierHashInput;
    }

    public byte[] getEncryptedVerifierHashValue() {
        return this.encryptedVerifierHashValue;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public Integer getHashSize() {
        return this.hashSize;
    }

    public Integer getKeyBits() {
        return this.keyBits;
    }

    public Integer getSaltSize() {
        return this.saltSize;
    }

    public byte[] getSaltValue() {
        return this.saltValue;
    }

    public Integer getSpinCount() {
        return this.spinCount;
    }
}
