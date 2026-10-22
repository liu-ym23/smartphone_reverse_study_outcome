package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public class KeyData {
    private Integer blockSize;
    private CipherAlgorithm cipherAlgorithm;
    private ChainingMode cipherChaining;
    private HashAlgorithm hashAlgorithm;
    private Integer hashSize;
    private Integer keyBits;
    private Integer saltSize;
    private byte[] saltValue;

    public KeyData() {
    }

    public KeyData(Element r3) {
        Element r4 = EncryptionDocument.getTag((Element) ZeusTransformUtils.wrapperContextForParams(r3, Element.class, "com.obric.memorydata.plugin"), "http://schemas.microsoft.com/office/2006/encryption", "keyData");
        if (r4 == null) goto L14;
        this.saltSize = EncryptionDocument.getIntAttr(r4, "saltSize");
        this.blockSize = EncryptionDocument.getIntAttr(r4, "blockSize");
        this.keyBits = EncryptionDocument.getIntAttr(r4, "keyBits");
        this.hashSize = EncryptionDocument.getIntAttr(r4, "hashSize");
        this.cipherAlgorithm = CipherAlgorithm.fromXmlId(r4.getAttribute("cipherAlgorithm"), this.keyBits.intValue());
        this.cipherChaining = ChainingMode.fromXmlId(r4.getAttribute("cipherChaining"));
        HashAlgorithm r0 = HashAlgorithm.fromEcmaId(r4.getAttribute("hashAlgorithm"));
        this.hashAlgorithm = r0;
        if (this.cipherAlgorithm == null) goto L12;
        if (this.cipherChaining == null) goto L12;
        if (r0 == null) goto L12;
        this.saltValue = EncryptionDocument.getBinAttr(r4, "saltValue");
        return;
    L12:
        throw new EncryptedDocumentException("Cipher algorithm, chaining mode or hash algorithm was null");
    L14:
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
}
