package com.bytedance.crypto.envelope;

import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.PublicKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class EnvelopeCryptoImpl {
    private static final int ENVELOPE_MAGIC = -57307;
    private static final int ENVELOPE_VERSION = 1;
    private static final int FILE_MAGIC = -57306;
    private static final int FILE_VERSION = 1;
    private static final String TAG = "EnvelopeCryptoImpl";
    private static volatile EnvelopeCryptoImpl instance;

    private EnvelopeCryptoImpl() {
    }

    private byte[] buildDEKEnvelope(byte[] r10, byte[] r11, byte[] r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append("buildDEKEnvelope enter, bizPubkeyLen: ");
        r13.append(r10.length);
        r13.append(", aadLen: ");
        if (r12 != null) goto L5;
        int r14 = 0;
    L6:
        r13.append(r14);
        LogUtils.i(TAG, r13.toString());
        KeyPair r15 = CryptoUtils.generateECCKeyPair();     // Catch: Exception -> L31
        if (r15 != null) goto L11;
        LogUtils.e(TAG, "Generate temp ECC keypair failed");     // Catch: Exception -> L31
        return null;
    L11:
        byte[] r16 = CryptoUtils.parseECCPublicKey(r15.getPublic().getEncoded());     // Catch: Exception -> L31
        PublicKey r17 = CryptoUtils.byteArrayToECPublicKey(r10);     // Catch: Exception -> L31
        if (r17 != null) goto L15;
        LogUtils.e(TAG, "Parse biz public key failed");     // Catch: Exception -> L31
        return null;
    L15:
        byte[] r18 = ECDHHelper.generateSharedSecret(r15.getPrivate(), r17);     // Catch: Exception -> L31
        if (r18 != null) goto L18;
    L29:
        LogUtils.e(TAG, "ECDH key agreement failed");     // Catch: Exception -> L31
        return null;
    L18:
        if (r18.length == 0) goto L29;
        LogUtils.d(TAG, "sharedKey length: " + r18.length);     // Catch: Exception -> L31
        byte[] r19 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L31
        byte[] r20 = AES.gcmXcrypt(1, r18, r12, r19, r11);     // Catch: Exception -> L31
        if (r20 != null) goto L23;
    L27:
        LogUtils.e(TAG, "AES-GCM encrypt DEK failed");     // Catch: Exception -> L31
        return null;
    L23:
        if (r20.length == 0) goto L27;
        ByteArrayOutputStream r21 = new ByteArrayOutputStream();     // Catch: Exception -> L31
        DataOutputStream r22 = new DataOutputStream(r21);     // Catch: Exception -> L31
        r22.writeInt(ENVELOPE_MAGIC);     // Catch: Exception -> L31
        r22.writeInt(1);     // Catch: Exception -> L31
        r22.writeInt(r16.length);     // Catch: Exception -> L31
        r22.write(r16);     // Catch: Exception -> L31
        r22.writeInt(r19.length);     // Catch: Exception -> L31
        r22.write(r19);     // Catch: Exception -> L31
        r22.writeLong(r20.length);     // Catch: Exception -> L31
        r22.write(r20);     // Catch: Exception -> L31
        r22.flush();     // Catch: Exception -> L31
        byte[] r23 = r21.toByteArray();     // Catch: Exception -> L31
        LogUtils.i(TAG, "buildDEKEnvelope success, envelopeLen: " + r23.length);     // Catch: Exception -> L31
        return r23;
    L31:
        e = move-exception;
        LogUtils.e(TAG, "Build DEK envelope failed, error: " + e.getMessage());
        return null;
    L5:
        r14 = r12.length;
        goto L6
    }

    public static EnvelopeCryptoImpl getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCryptoImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCryptoImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCryptoImpl.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r12, InputStream r13, OutputStream r14) {
        StringBuilder r11 = new StringBuilder();
        r11.append("decrypt enter, dekLen: ");
        if (r12 != null) goto L5;
        int r10 = 0;
    L6:
        r11.append(r10);
        LogUtils.i(TAG, r11.toString());
        if (r12 != null) goto L9;
    L37:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L9:
        if (r12.length != 32) goto L37;
        if (r13 == null) goto L37;
        if (r14 == null) goto L37;
        DataInputStream r15 = new DataInputStream(r13);     // Catch: IOException -> L34
        int r16 = r15.readInt();     // Catch: IOException -> L34
        if (r16 == FILE_MAGIC) goto L17;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r16));     // Catch: IOException -> L34
        return -10;
    L17:
        int r17 = r15.readInt();     // Catch: IOException -> L34
        if (r17 == 1) goto L21;
        LogUtils.e(TAG, "Unsupported file version: " + r17);     // Catch: IOException -> L34
        return -8;
    L21:
        int r18 = r15.readInt();     // Catch: IOException -> L34
        if (r18 > 0) goto L25;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r18);     // Catch: IOException -> L34
        return -8;
    L25:
        int r19 = r15.skipBytes(r18);     // Catch: IOException -> L34
        if (r19 == r18) goto L29;
        LogUtils.e(TAG, "Skip DEK envelope failed, expected: " + r18 + ", actual: " + r19);     // Catch: IOException -> L34
        return -8;
    L29:
        byte[] r20 = new byte[12];     // Catch: IOException -> L34
        r15.readFully(r20);     // Catch: IOException -> L34
        long r21 = r15.readLong();     // Catch: IOException -> L34
        long r22 = 4096;
        long r23 = ((r21 + r22) - 1) / r22;     // Catch: IOException -> L34
        long r24 = r21 + (16 * r23);     // Catch: IOException -> L34
        LogUtils.i(TAG, "decrypt stream, dataLen: " + r21 + ", cipherLen: " + r24 + ", numBlocks: " + r23);     // Catch: IOException -> L34
        int r110 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r12, CryptoConst.ALGORITHM_CHACHA20_POLY1305), r20, 4096, r24, r13, r14);     // Catch: IOException -> L34
        if (r110 == 0) goto L32;
        LogUtils.e(TAG, "Decrypt stream failed, ret: " + r110);     // Catch: IOException -> L34
    L33:
        return r110;
    L32:
        LogUtils.i(TAG, "decrypt success, dataLen: " + r21);     // Catch: IOException -> L34
    L34:
        e = move-exception;
        LogUtils.e(TAG, "Decrypt failed, error: " + e.getMessage());
        return -4;
    L5:
        r10 = r12.length;
        goto L6
    }

    public int encrypt(byte[] r14, byte[] r15, long r16, InputStream r18, OutputStream r19) {
        StringBuilder r10 = new StringBuilder();
        r10.append("encrypt enter, bizPubkeyLen: ");
        if (r14 != null) goto L5;
        int r11 = 0;
    L6:
        r10.append(r11);
        r10.append(", aadLen: ");
        if (r15 != null) goto L9;
        int r12 = 0;
    L10:
        r10.append(r12);
        r10.append(", dataLen: ");
        r10.append(r16);
        LogUtils.i(TAG, r10.toString());
        if (r14 != null) goto L13;
    L31:
        LogUtils.e(TAG, "Invalid input params");
        return -2;
    L13:
        if (r14.length == 0) goto L31;
        if (r18 == null) goto L31;
        if (r19 == null) goto L31;
        byte[] r13 = CryptoUtils.generateSecureRandom(32);     // Catch: Exception -> L28
        byte[] r17 = buildDEKEnvelope(r14, r13, r15);     // Catch: Exception -> L28
        if (r17 != null) goto L22;
        LogUtils.e(TAG, "Build DEK envelope failed");     // Catch: Exception -> L28
        return -4;
    L22:
        byte[] r20 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L28
        DataOutputStream r21 = new DataOutputStream(r19);     // Catch: Exception -> L28
        r21.writeInt(FILE_MAGIC);     // Catch: Exception -> L28
        r21.writeInt(1);     // Catch: Exception -> L28
        r21.writeInt(r17.length);     // Catch: Exception -> L28
        r21.write(r17);     // Catch: Exception -> L28
        r21.write(r20);     // Catch: Exception -> L28
        r21.writeLong(r16);     // Catch: Exception -> L28
        int r22 = ChaCha20.encryptStreamWithPoly1305(new SecretKeySpec(r13, CryptoConst.ALGORITHM_CHACHA20_POLY1305), r20, 4096, r16, r18, r19);     // Catch: Exception -> L28
        if (r22 == 0) goto L26;
        LogUtils.e(TAG, "Encrypt data stream failed, ret: " + r22);     // Catch: Exception -> L28
        return r22;
    L26:
        LogUtils.i(TAG, "encrypt success, dataLen: " + r16 + ", dekEnvelopeLen: " + r17.length);     // Catch: Exception -> L28
        return 0;
    L28:
        e = move-exception;
        LogUtils.e(TAG, "Encrypt failed, error: " + e.getMessage());
        return -4;
    L9:
        r12 = r15.length;
        goto L10
    L5:
        r11 = r14.length;
        goto L6
    }

    public byte[] extractDEKCipher(InputStream r10) {
        LogUtils.i(TAG, "extractDEKCipher enter");
        if (r10 != null) goto L23;
        String r11 = "Invalid input params";
    L5:
        LogUtils.e(TAG, r11);
        return null;
    L23:
        DataInputStream r12 = new DataInputStream(r10);     // Catch: IOException -> L21
        int r13 = r12.readInt();     // Catch: IOException -> L21
        if (r13 == FILE_MAGIC) goto L11;
        LogUtils.e(TAG, "File magic mismatch: 0x" + Integer.toHexString(r13));     // Catch: IOException -> L21
        return null;
    L11:
        int r14 = r12.readInt();     // Catch: IOException -> L21
        if (r14 == 1) goto L15;
        LogUtils.e(TAG, "Unsupported file version: " + r14);     // Catch: IOException -> L21
        return null;
    L15:
        int r15 = r12.readInt();     // Catch: IOException -> L21
        if (r15 > 0) goto L19;
        LogUtils.e(TAG, "Invalid DEK envelope length: " + r15);     // Catch: IOException -> L21
        return null;
    L19:
        byte[] r16 = new byte[r15];     // Catch: IOException -> L21
        r12.readFully(r16);     // Catch: IOException -> L21
        LogUtils.i(TAG, "extractDEKCipher success, dekEnvelopeLen: " + r15);     // Catch: IOException -> L21
        return r16;
    L21:
        e = move-exception;
        r11 = "Extract DEK cipher failed, error: " + e.getMessage();
        goto L5
    }
}
