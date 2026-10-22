package org.apache.poi.poifs.crypt.binaryrc4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class BinaryRC4Decryptor extends Decryptor {
    private int chunkSize;
    private long length;

    private class BinaryRC4CipherInputStream extends ChunkedCipherInputStream {
        final /* synthetic */ BinaryRC4Decryptor this$0;

        public BinaryRC4CipherInputStream(BinaryRC4Decryptor r7, InputStream r8, int r9, int r10) {
            this.this$0 = r7;
            super(r8, r9, BinaryRC4Decryptor.access$000(r7), r10);
        }

        public BinaryRC4CipherInputStream(BinaryRC4Decryptor r1, DocumentInputStream r2, long r3) {
            this.this$0 = r1;
            super(r2, r3, BinaryRC4Decryptor.access$000(r1));
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher r1, int r2) {
            return this.this$0.initCipherForBlock(r1, r2);
        }
    }

    public BinaryRC4Decryptor() {
        this.length = -1;
        this.chunkSize = 512;
    }

    static /* synthetic */ int access$000(BinaryRC4Decryptor r0) {
        return r0.chunkSize;
    }

    public static SecretKey generateSecretKey(String r6, EncryptionVerifier r7) {
        if (r6.length() <= 255) goto L5;
        r6 = r6.substring(0, 255);
    L5:
        MessageDigest r0 = CryptoFunctions.getMessageDigest(r7.getHashAlgorithm());
        byte[] r8 = r0.digest(StringUtil.getToUnicodeLE(r6));
        byte[] r1 = r7.getSalt();
        r0.reset();
        int r3 = 0;
    L7:
        if (r3 >= 16) goto L10;
        r0.update(r8, 0, 5);
        r0.update(r1);
        r3 = r3 + 1;
        goto L7
    L10:
        return new SecretKeySpec(Arrays.copyOf(r0.digest(), 5), r7.getCipherAlgorithm().jceId);
    }

    public static Cipher initCipherForBlock(Cipher r4, int r5, EncryptionInfo r6, SecretKey r7, int r8) {
        SecretKey r9 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.memorydata.plugin");
        HashAlgorithm r0 = r6.getVerifier().getHashAlgorithm();
        byte[] r1 = new byte[4];
        LittleEndian.putUInt(r1, 0, r5);
        SecretKeySpec r2 = new SecretKeySpec(CryptoFunctions.generateKey(r9.getEncoded(), r0, r1, 16), r9.getAlgorithm());
        if (r4 == null) goto L7;
        r4.init(r8, r2);
        return r4;
    L7:
        return CryptoFunctions.getCipher(r2, r6.getHeader().getCipherAlgorithm(), null, null, r8);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream r2, int r3, int r4) {
        return new BinaryRC4CipherInputStream(this, r2, r3, r4);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public /* bridge */ /* synthetic */ InputStream getDataStream(DirectoryNode r1) {
        return getDataStream(r1);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode r4) {
        DocumentInputStream r5 = r4.createDocumentInputStream("EncryptedPackage");
        this.length = r5.readLong();
        return new BinaryRC4CipherInputStream(this, r5, this.length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher r3, int r4) {
        return initCipherForBlock(r3, r4, getEncryptionInfo(), getSecretKey(), 2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int r1) {
        this.chunkSize = r1;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String r7) {
        EncryptionVerifier r0 = getEncryptionInfo().getVerifier();
        SecretKey r8 = generateSecretKey(r7, r0);
        Cipher r1 = initCipherForBlock(null, 0, getEncryptionInfo(), r8, 2);     // Catch: GeneralSecurityException -> L9
        byte[] r2 = r0.getEncryptedVerifier();     // Catch: GeneralSecurityException -> L9
        byte[] r3 = new byte[r2.length];     // Catch: GeneralSecurityException -> L9
        r1.update(r2, 0, r2.length, r3);     // Catch: GeneralSecurityException -> L9
        setVerifier(r3);     // Catch: GeneralSecurityException -> L9
        byte[] r4 = r1.doFinal(r0.getEncryptedVerifierHash());     // Catch: GeneralSecurityException -> L9
        if (Arrays.equals(CryptoFunctions.getMessageDigest(r0.getHashAlgorithm()).digest(r3), r4) == false) goto L8;
        setSecretKey(r8);     // Catch: GeneralSecurityException -> L9
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    }
}
