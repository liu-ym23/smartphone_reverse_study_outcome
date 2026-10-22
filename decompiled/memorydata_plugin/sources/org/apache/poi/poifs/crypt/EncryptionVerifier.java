package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public abstract class EncryptionVerifier implements GenericRecord {
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private byte[] encryptedKey;
    private byte[] encryptedVerifier;
    private byte[] encryptedVerifierHash;
    private HashAlgorithm hashAlgorithm;
    private byte[] salt;
    private int spinCount;

    public EncryptionVerifier() {
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }

    public byte[] getEncryptedVerifier() {
        return this.encryptedVerifier;
    }

    public byte[] getEncryptedVerifierHash() {
        return this.encryptedVerifierHash;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("salt", new $$Lambda$C21MJsvvDLwL7nmlIAZ4ZsdJws(this));
        r0.put("encryptedVerifier", new $$Lambda$IFisCaKAhTajYBdjn4Xsi5_ebus(this));
        r0.put("encryptedVerifierHash", new $$Lambda$qtDee3MCm8Zsr5uZ7dSKn2ZVr34(this));
        r0.put("encryptedKey", new $$Lambda$LVWKTVvBCxM5bYWURQjGhPU32M(this));
        r0.put("spinCount", new $$Lambda$q3CWlYFxlAmHkWM9XjqhV7sYLp8(this));
        r0.put("cipherAlgorithm", new $$Lambda$xyCff5qEI47rr1u0uWptNNhQ5vw(this));
        r0.put("chainingMode", new $$Lambda$eDB1QNm5Rmt07Qw7vobw57TNuyw(this));
        r0.put("hashAlgorithm", new $$Lambda$nAhwxHZCP9rnVtS6t3cvjoI2NsY(this));
        return Collections.unmodifiableMap(r0);
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public int getSpinCount() {
        return this.spinCount;
    }

    public void setChainingMode(ChainingMode r1) {
        this.chainingMode = r1;
    }

    public void setCipherAlgorithm(CipherAlgorithm r1) {
        this.cipherAlgorithm = r1;
    }

    public void setEncryptedKey(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.encryptedKey = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setEncryptedVerifier(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.encryptedVerifier = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setEncryptedVerifierHash(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.encryptedVerifierHash = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setHashAlgorithm(HashAlgorithm r1) {
        this.hashAlgorithm = r1;
    }

    public void setSalt(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.salt = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setSpinCount(int r1) {
        this.spinCount = r1;
    }
}
