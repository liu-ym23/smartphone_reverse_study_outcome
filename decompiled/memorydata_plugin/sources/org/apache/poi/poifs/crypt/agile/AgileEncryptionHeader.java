package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class AgileEncryptionHeader extends EncryptionHeader {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public AgileEncryptionHeader(CipherAlgorithm r1, HashAlgorithm r2, int r3, int r4, ChainingMode r5) {
        setCipherAlgorithm(r1);
        setHashAlgorithm(r2);
        setKeySize(r3);
        setBlockSize(r4);
        setChainingMode(r5);
    }

    public AgileEncryptionHeader(EncryptionDocument r4) {
        KeyData r0 = r4.getKeyData();     // Catch: Exception -> L24
        if (r0 == null) goto L23;
        int r1 = r0.getKeyBits().intValue();
        CipherAlgorithm r2 = r0.getCipherAlgorithm();
        setCipherAlgorithm(r2);
        setCipherProvider(r2.provider);
        setKeySize(r1);
        setFlags(0);
        setSizeExtra(0);
        setCspName(null);
        setBlockSize(r0.getBlockSize().intValue());
        setChainingMode(r0.getCipherChaining());
        if (getChainingMode() != ChainingMode.cbc) goto L8;
    L12:
        int r3 = r0.getHashSize().intValue();
        setHashAlgorithm(r0.getHashAlgorithm());
        if (getHashAlgorithm().hashSize != r3) goto L21;
        int r5 = r0.getSaltSize().intValue();
        setKeySalt(r0.getSaltValue());
        if (getKeySalt().length != r5) goto L19;
        DataIntegrity r6 = r4.getDataIntegrity();
        setEncryptedHmacKey(r6.getEncryptedHmacKey());
        setEncryptedHmacValue(r6.getEncryptedHmacValue());
        return;
    L19:
        throw new EncryptedDocumentException("Invalid salt length");
    L21:
        throw new EncryptedDocumentException("Unsupported hash algorithm: " + r0.getHashAlgorithm() + " @ " + r3 + " bytes");
    L8:
        if (getChainingMode() == ChainingMode.cfb) goto L12;
        throw new EncryptedDocumentException("Unsupported chaining mode - " + r0.getCipherChaining());
    L23:
        throw new NullPointerException("keyData not set");     // Catch: Exception -> L24
    L25:
        throw new EncryptedDocumentException("Unable to parse keyData");
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$AgileEncryptionHeader$fppQz6iOYdXi9sNDGRjlvbtamK4(this), "encryptedHmacKey", new $$Lambda$o7gjYjIMUJ04mjZtJ34y6KXaLgU(this), "encryptedHmacValue", new $$Lambda$9lKrHao6vJn8sDSfLi4NNKUaVE(this));
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$AgileEncryptionHeader() {
        return super.getGenericProperties();
    }

    public void setEncryptedHmacKey(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.encryptedHmacKey = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setEncryptedHmacValue(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.encryptedHmacValue = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public void setKeySalt(byte[] r3) {
        if (r3 == null) goto L8;
        if (r3.length != getBlockSize()) goto L8;
        super.setKeySalt(r3);
        return;
    L8:
        throw new EncryptedDocumentException("invalid verifier salt");
    }
}
