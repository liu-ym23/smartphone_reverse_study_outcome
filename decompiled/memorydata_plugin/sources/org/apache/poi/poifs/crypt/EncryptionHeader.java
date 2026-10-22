package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public abstract class EncryptionHeader implements GenericRecord {
    private int blockSize;
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private String cspName;
    private int flags;
    private HashAlgorithm hashAlgorithm;
    private int keyBits;
    private byte[] keySalt;
    private CipherProvider providerType;
    private int sizeExtra;

    public EncryptionHeader() {
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public CipherProvider getCipherProvider() {
        return this.providerType;
    }

    public String getCspName() {
        return this.cspName;
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("flags", new $$Lambda$m08KUqZaH3geo8WwNhnfcxa8gKM(this));
        r0.put("sizeExtra", new $$Lambda$ZCb7ETWdFitApzeM4SCUrDOhWo(this));
        r0.put("cipherAlgorithm", new $$Lambda$2rsOtE1cxFrZBuAvgtxftZNSQ(this));
        r0.put("hashAlgorithm", new $$Lambda$lmB1MQgKwYaLixiCLchgFgkk8A(this));
        r0.put("keyBits", new $$Lambda$ynR8IvgucoROgw7PsLd613h4gY(this));
        r0.put("blockSize", new $$Lambda$JzoiVLkUm7MKXp5tjbGrpfDvTE(this));
        r0.put("providerType", new $$Lambda$tHjIv4t7EVSDQvp2ys6fsN1Y(this));
        r0.put("chainingMode", new $$Lambda$G1ww79YkJplwq2It4Fc0vQB3RMc(this));
        r0.put("keySalt", new $$Lambda$rhJ9jAQXiqudH7lnZYM78NQgVrM(this));
        r0.put("cspName", new $$Lambda$TDYJMMZzOToqhaexa7vWIqXm5JE(this));
        return Collections.unmodifiableMap(r0);
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getKeySalt() {
        return this.keySalt;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    public int getSizeExtra() {
        return this.sizeExtra;
    }

    public void setBlockSize(int r1) {
        this.blockSize = r1;
    }

    public void setChainingMode(ChainingMode r1) {
        this.chainingMode = r1;
    }

    public void setCipherAlgorithm(CipherAlgorithm r3) {
        this.cipherAlgorithm = r3;
        if (r3.allowedKeySize.length != 1) goto L6;
        setKeySize(r3.defaultKeySize);
        return;
    }

    public void setCipherProvider(CipherProvider r1) {
        this.providerType = r1;
    }

    public void setCspName(String r1) {
        this.cspName = r1;
    }

    public void setFlags(int r1) {
        this.flags = r1;
    }

    public void setHashAlgorithm(HashAlgorithm r1) {
        this.hashAlgorithm = r1;
    }

    public void setKeySalt(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.keySalt = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
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

    public void setSizeExtra(int r1) {
        this.sizeExtra = r1;
    }
}
