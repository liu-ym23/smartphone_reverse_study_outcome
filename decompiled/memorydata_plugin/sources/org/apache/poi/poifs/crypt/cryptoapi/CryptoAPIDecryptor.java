package org.apache.poi.poifs.crypt.cryptoapi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
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
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoAPIDecryptor extends Decryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int chunkSize;
    private long length;

    private class CryptoAPICipherInputStream extends ChunkedCipherInputStream {
        final /* synthetic */ CryptoAPIDecryptor this$0;

        public CryptoAPICipherInputStream(CryptoAPIDecryptor r7, InputStream r8, long r9, int r11) {
            this.this$0 = r7;
            super(r8, r9, CryptoAPIDecryptor.access$000(r7), r11);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher r1, int r2) {
            return this.this$0.initCipherForBlock(r1, r2);
        }
    }

    static {
    }

    public CryptoAPIDecryptor() {
        this.length = -1;
        this.chunkSize = -1;
    }

    static /* synthetic */ int access$000(CryptoAPIDecryptor r0) {
        return r0.chunkSize;
    }

    public static SecretKey generateSecretKey(String r2, EncryptionVerifier r3) {
        if (r2.length() <= 255) goto L5;
        r2 = r2.substring(0, 255);
    L5:
        MessageDigest r0 = CryptoFunctions.getMessageDigest(r3.getHashAlgorithm());
        r0.update(r3.getSalt());
        return new SecretKeySpec(r0.digest(StringUtil.getToUnicodeLE(r2)), r3.getCipherAlgorithm().jceId);
    }

    public static Cipher initCipherForBlock(Cipher r4, int r5, EncryptionInfo r6, SecretKey r7, int r8) {
        SecretKey r9 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r7, SecretKey.class, "com.obric.memorydata.plugin");
        HashAlgorithm r0 = r6.getVerifier().getHashAlgorithm();
        byte[] r1 = new byte[4];
        LittleEndian.putUInt(r1, 0, r5);
        MessageDigest r10 = CryptoFunctions.getMessageDigest(r0);
        r10.update(r9.getEncoded());
        byte[] r11 = r10.digest(r1);
        EncryptionHeader r12 = r6.getHeader();
        int r2 = r12.getKeySize();
        byte[] r13 = CryptoFunctions.getBlock0(r11, r2 / 8);
        if (r2 != 40) goto L5;
        r13 = CryptoFunctions.getBlock0(r13, 16);
    L5:
        SecretKeySpec r3 = new SecretKeySpec(r13, r9.getAlgorithm());
        if (r4 == null) goto L10;
        r4.init(r8, r3);
        return r4;
    L10:
        return CryptoFunctions.getCipher(r3, r12.getCipherAlgorithm(), null, null, r8);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public /* bridge */ /* synthetic */ InputStream getDataStream(InputStream r1, int r2, int r3) {
        return getDataStream(r1, r2, r3);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public /* bridge */ /* synthetic */ InputStream getDataStream(DirectoryNode r1) {
        return getDataStream(r1);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(InputStream r8, int r9, int r10) {
        return new CryptoAPICipherInputStream(this, r8, r9, r10);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode r1) {
        throw new IOException("not supported");
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
