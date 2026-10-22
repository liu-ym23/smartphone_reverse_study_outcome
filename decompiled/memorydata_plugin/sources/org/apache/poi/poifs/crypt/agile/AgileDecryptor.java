package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class AgileDecryptor extends Decryptor {
    static final byte[] kCryptoKeyBlock = null;
    static final byte[] kHashedVerifierBlock = null;
    static final byte[] kIntegrityKeyBlock = null;
    static final byte[] kIntegrityValueBlock = null;
    static final byte[] kVerifierInputBlock = null;
    private long _length;

    private class AgileCipherInputStream extends ChunkedCipherInputStream {
        final /* synthetic */ AgileDecryptor this$0;

        public AgileCipherInputStream(AgileDecryptor r1, DocumentInputStream r2, long r3) {
            this.this$0 = r1;
            super(r2, r3, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher r8, int r9) {
            return AgileDecryptor.initCipherForBlock(r8, r9, false, this.this$0.getEncryptionInfo(), this.this$0.getSecretKey(), 2);
        }
    }

    static {
        kVerifierInputBlock = longToBytes(-96877461722390919L);
        kHashedVerifierBlock = longToBytes(-2906493647876705202L);
        kCryptoKeyBlock = longToBytes(1472127217842311382L);
        kIntegrityKeyBlock = longToBytes(6895764199477731830L);
        kIntegrityValueBlock = longToBytes(-6888397455483960269L);
    }

    public AgileDecryptor() {
        this._length = -1;
    }

    public static int getNextBlockSize(int r4, int r5) {
        return ((int) Math.ceil(((double) r4) / ((double) r5))) * r5;
    }

    static byte[] hashInput(AgileEncryptionVerifier r5, byte[] r6, byte[] r7, byte[] r8, int r9) {
        CipherAlgorithm r0 = r5.getCipherAlgorithm();
        ChainingMode r1 = r5.getChainingMode();
        int r2 = r5.getKeySize() / 8;
        int r3 = r5.getBlockSize();
        HashAlgorithm r4 = r5.getHashAlgorithm();
        Cipher r10 = CryptoFunctions.getCipher(new SecretKeySpec(CryptoFunctions.generateKey(r6, r4, r7, r2), r0.jceId), r0, r1, CryptoFunctions.generateIv(r4, r5.getSalt(), null, r3), r9);
        if (r8 == null) goto L10;
        return r10.doFinal(CryptoFunctions.getBlock0(r8, getNextBlockSize(r8.length, r3)));
    L6:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    L10:
        throw new EncryptedDocumentException("Cannot has input without inputKey");
    }

    public static Cipher initCipherForBlock(Cipher r6, int r7, boolean r8, EncryptionInfo r9, SecretKey r10, int r11) {
        SecretKey r12 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r10, SecretKey.class, "com.obric.memorydata.plugin");
        EncryptionHeader r13 = r9.getHeader();
        if (r8 == false) goto L5;
        String r14 = "PKCS5Padding";
    L6:
        String r5 = r14;
        if (r6 != null) goto L9;
    L10:
        r6 = CryptoFunctions.getCipher(r12, r13.getCipherAlgorithm(), r13.getChainingMode(), r13.getKeySalt(), r11, r5);
    L11:
        byte[] r15 = new byte[4];
        LittleEndian.putInt(r15, 0, r7);
        byte[] r16 = CryptoFunctions.generateIv(r13.getHashAlgorithm(), r13.getKeySalt(), r15, r13.getBlockSize());
        if (r13.getCipherAlgorithm() != CipherAlgorithm.rc2) goto L14;
        AlgorithmParameterSpec r17 = new RC2ParameterSpec(r12.getEncoded().length * 8, r16);
    L15:
        r6.init(r11, r12, r17);
        return r6;
    L14:
        r17 = new IvParameterSpec(r16);
        goto L15
    L9:
        if (r6.getAlgorithm().endsWith(r5) == true) goto L11;
    L5:
        r14 = "NoPadding";
        goto L6
    }

    private static byte[] longToBytes(long r1) {
        return ByteBuffer.allocate(8).putLong(r1).array();
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode r4) {
        DocumentInputStream r5 = r4.createDocumentInputStream("EncryptedPackage");
        this._length = r5.readLong();
        return new AgileCipherInputStream(this, r5, this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String r12) {
        AgileEncryptionVerifier r0 = (AgileEncryptionVerifier) ZeusTransformUtils.preCheckCast(getEncryptionInfo().getVerifier(), AgileEncryptionVerifier.class, "com.obric.memorydata.plugin");
        AgileEncryptionHeader r1 = (AgileEncryptionHeader) ZeusTransformUtils.preCheckCast(getEncryptionInfo().getHeader(), AgileEncryptionHeader.class, "com.obric.memorydata.plugin");
        int r2 = r1.getBlockSize();
        byte[] r13 = CryptoFunctions.hashPassword(r12, r0.getHashAlgorithm(), r0.getSalt(), r0.getSpinCount());
        byte[] r3 = hashInput(r0, r13, kVerifierInputBlock, r0.getEncryptedVerifier(), 2);
        setVerifier(r3);
        byte[] r4 = CryptoFunctions.getMessageDigest(r0.getHashAlgorithm()).digest(r3);
        byte[] r5 = CryptoFunctions.getBlock0(hashInput(r0, r13, kHashedVerifierBlock, r0.getEncryptedVerifierHash(), 2), r0.getHashAlgorithm().hashSize);
        SecretKeySpec r6 = new SecretKeySpec(CryptoFunctions.getBlock0(hashInput(r0, r13, kCryptoKeyBlock, r0.getEncryptedKey(), 2), r1.getKeySize() / 8), r1.getCipherAlgorithm().jceId);
        byte[] r14 = CryptoFunctions.generateIv(r1.getHashAlgorithm(), r1.getKeySalt(), kIntegrityKeyBlock, r2);
        CipherAlgorithm r7 = r1.getCipherAlgorithm();
        byte[] r15 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(r6, r7, r1.getChainingMode(), r14, 2).doFinal(r1.getEncryptedHmacKey()), r1.getHashAlgorithm().hashSize);
        byte[] r8 = CryptoFunctions.generateIv(r1.getHashAlgorithm(), r1.getKeySalt(), kIntegrityValueBlock, r2);
        byte[] r9 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(r6, r7, r0.getChainingMode(), r8, 2).doFinal(r1.getEncryptedHmacValue()), r1.getHashAlgorithm().hashSize);
        if (Arrays.equals(r5, r4) == false) goto L6;
        setSecretKey(r6);
        setIntegrityHmacKey(r15);
        setIntegrityHmacValue(r9);
        return true;
    L6:
        return false;
    }
}
