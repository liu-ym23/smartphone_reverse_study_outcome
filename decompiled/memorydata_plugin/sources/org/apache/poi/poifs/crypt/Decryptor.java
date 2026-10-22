package org.apache.poi.poifs.crypt;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Decryptor implements GenericRecord {
    protected EncryptionInfo encryptionInfo;
    private byte[] integrityHmacKey;
    private byte[] integrityHmacValue;
    private SecretKey secretKey;
    private byte[] verifier;

    public Decryptor() {
    }

    public static Decryptor getInstance(EncryptionInfo r1) {
        Decryptor r2 = r1.getDecryptor();
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new EncryptedDocumentException("Unsupported version");
    }

    static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    public InputStream getDataStream(InputStream r1, int r2, int r3) {
        throw new EncryptedDocumentException("this decryptor doesn't support reading from a stream");
    }

    public abstract InputStream getDataStream(DirectoryNode r1);

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        SecretKey r0 = this.secretKey;
        if (r0 != null) goto L5;
        Supplier r3 = $$Lambda$Decryptor$FW3EfsHfGYFuLK1E4DoZAzjx0X8.INSTANCE;
    L7:
        return GenericRecordUtil.getGenericProperties("secretKey", r3, "verifier", new $$Lambda$hkTlyWdtI0_UxFKhAG_63um7yw(this), "integrityHmacKey", new $$Lambda$D2hIzyjswCvRR_oMwVIEijZSUg(this), "integrityHmacValue", new $$Lambda$aFKsN0RP6mVlCoMmHoYctTe7h4(this));
    L5:
        r0.getClass();
        r3 = new $$Lambda$SJQFim5AslTUp6TA1Y_p1iGFU(r0);
        goto L7
    }

    public byte[] getIntegrityHmacKey() {
        return this.integrityHmacKey;
    }

    public byte[] getIntegrityHmacValue() {
        return this.integrityHmacValue;
    }

    public int getKeySizeInBytes() {
        return this.encryptionInfo.getHeader().getKeySize() / 8;
    }

    public SecretKey getSecretKey() {
        return this.secretKey;
    }

    public byte[] getVerifier() {
        return this.verifier;
    }

    public Cipher initCipherForBlock(Cipher r1, int r2) {
        throw new EncryptedDocumentException("this decryptor doesn't support initCipherForBlock");
    }

    public void setChunkSize(int r1) {
        throw new EncryptedDocumentException("this decryptor doesn't support changing the chunk size");
    }

    public void setEncryptionInfo(EncryptionInfo r1) {
        this.encryptionInfo = r1;
    }

    public void setIntegrityHmacKey(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.integrityHmacKey = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setIntegrityHmacValue(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.integrityHmacValue = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setSecretKey(SecretKey r3) {
        this.secretKey = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r3, SecretKey.class, "com.obric.memorydata.plugin");
    }

    public void setVerifier(byte[] r3) {
        if (r3 != null) goto L4;
        byte[] r4 = null;
    L5:
        this.verifier = r4;
        return;
    L4:
        r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public abstract boolean verifyPassword(String r1);
}
