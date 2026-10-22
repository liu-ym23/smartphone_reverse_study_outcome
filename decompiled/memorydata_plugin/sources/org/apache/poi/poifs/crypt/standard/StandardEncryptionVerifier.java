package org.apache.poi.poifs.crypt.standard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class StandardEncryptionVerifier extends EncryptionVerifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int verifierHashSize;

    static {
    }

    public StandardEncryptionVerifier(CipherAlgorithm r1, HashAlgorithm r2, int r3, int r4, ChainingMode r5) {
        setCipherAlgorithm(r1);
        setHashAlgorithm(r2);
        setChainingMode(r5);
        setSpinCount(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        this.verifierHashSize = r2.hashSize;
    }

    public StandardEncryptionVerifier(LittleEndianInput r3, StandardEncryptionHeader r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r5.readInt();
        if (r0 != 16) goto L7;
        byte[] r1 = new byte[16];
        r5.readFully(r1);
        setSalt(r1);
        byte[] r2 = new byte[16];
        r5.readFully(r2);
        setEncryptedVerifier(r2);
        this.verifierHashSize = r5.readInt();
        byte[] r6 = new byte[r4.getCipherAlgorithm().encryptedVerifierHashLength];
        r5.readFully(r6);
        setEncryptedVerifierHash(r6);
        setSpinCount(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        setCipherAlgorithm(r4.getCipherAlgorithm());
        setChainingMode(r4.getChainingMode());
        setEncryptedKey(null);
        setHashAlgorithm(r4.getHashAlgorithm());
        return;
    L7:
        throw new IllegalArgumentException("Salt size != 16: " + r0);
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

    public void write(LittleEndianByteArrayOutputStream r3) {
        byte[] r0 = getSalt();
        r3.writeInt(r0.length);
        r3.write(r0);
        r3.write(getEncryptedVerifier());
        r3.writeInt(20);
        r3.write(getEncryptedVerifierHash());
    }
}
