package org.apache.poi.poifs.crypt.standard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class StandardDecryptor extends Decryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long _length;

    static {
    }

    public StandardDecryptor() {
        this._length = -1;
    }

    public static byte[] fillAndXor(byte[] r3, byte r4) {
        byte[] r0 = new byte[64];
        Arrays.fill(r0, r4);
        int r5 = 0;
    L4:
        if (r5 >= r3.length) goto L7;
        r0[r5] = (byte) (r0[r5] ^ r3[r5]);
        r5 = r5 + 1;
        goto L4
    L7:
        return CryptoFunctions.getMessageDigest(HashAlgorithm.sha1).digest(r0);
    }

    public static SecretKey generateSecretKey(String r4, EncryptionVerifier r5, int r6) {
        HashAlgorithm r0 = r5.getHashAlgorithm();
        byte[] r7 = CryptoFunctions.hashPassword(r4, r0, r5.getSalt(), r5.getSpinCount());
        byte[] r1 = new byte[4];
        LittleEndian.putInt(r1, 0, 0);
        byte[] r8 = CryptoFunctions.generateKey(r7, r0, r1, r0.hashSize);
        byte[] r2 = fillAndXor(r8, (byte) 54);
        byte[] r9 = fillAndXor(r8, (byte) 92);
        byte[] r3 = new byte[r2.length + r9.length];
        System.arraycopy(r2, 0, r3, 0, r2.length);
        System.arraycopy(r9, 0, r3, r2.length, r9.length);
        return new SecretKeySpec(Arrays.copyOf(r3, r6), r5.getCipherAlgorithm().jceId);
    }

    private Cipher getCipher(SecretKey r4) {
        SecretKey r5 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.memorydata.plugin");
        EncryptionHeader r3 = getEncryptionInfo().getHeader();
        ChainingMode r0 = r3.getChainingMode();
        return CryptoFunctions.getCipher(r5, r3.getCipherAlgorithm(), r0, null, 2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode r8) {
        DocumentInputStream r9 = r8.createDocumentInputStream("EncryptedPackage");
        this._length = r9.readLong();
        if (getSecretKey() != null) goto L5;
        verifyPassword(null);
    L5:
        long r3 = getEncryptionInfo().getHeader().getCipherAlgorithm().blockSize;
        long r1 = ((this._length / r3) + 1) * r3;
        return new BoundedInputStream(new CipherInputStream(new BoundedInputStream(r9, r1), getCipher(getSecretKey())), this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String r5) {
        EncryptionVerifier r0 = getEncryptionInfo().getVerifier();
        SecretKey r6 = generateSecretKey(r5, r0, getKeySizeInBytes());
        Cipher r1 = getCipher(r6);
        byte[] r2 = r1.doFinal(r0.getEncryptedVerifier());     // Catch: GeneralSecurityException -> L10
        setVerifier(r2);     // Catch: GeneralSecurityException -> L10
        byte[] r3 = CryptoFunctions.getMessageDigest(r0.getHashAlgorithm()).digest(r2);     // Catch: GeneralSecurityException -> L10
        if (Arrays.equals(r3, Arrays.copyOf(r1.doFinal(r0.getEncryptedVerifierHash()), r3.length)) == false) goto L8;
        setSecretKey(r6);     // Catch: GeneralSecurityException -> L10
        return true;
    L8:
        return false;
    L10:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    }
}
