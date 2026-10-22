package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
class DataEncryptHelper {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final String TAG = "DataEncryptHelper";

    public DataEncryptHelper() {
    }

    public static byte[] dataDecrypt(byte[] r10, SensitiveData r11) {
        int r12 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, 0, 4));     // Catch: Exception -> L37
        if (r12 != 315433677) goto L36;
        int r13 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, 4, 8));     // Catch: Exception -> L37
        if (r13 != 1) goto L34;
        if (Arrays.equals(r11.getExtraInfo(), Arrays.copyOfRange(r10, 8, r11.getExtraInfo().length + 8)) == false) goto L32;
        int r14 = r11.getExtraInfo().length + 8;     // Catch: Exception -> L37
        int r15 = r14 + 32;     // Catch: Exception -> L37
        byte[] r16 = Arrays.copyOfRange(r10, r14, r15);     // Catch: Exception -> L37
        int r17 = r15 + 4;     // Catch: Exception -> L37
        int r18 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, r15, r17));     // Catch: Exception -> L37
        if (r18 != 317666031) goto L30;
        int r19 = r17 + 8;     // Catch: Exception -> L37
        long r20 = TransUtils.bytesToLong(Arrays.copyOfRange(r10, r17, r19));     // Catch: Exception -> L37
        if (r20 != r11.getKeyVersion()) goto L18;
        SecretKeySpec r21 = new SecretKeySpec(HKDFHelper.deriveKey(r11.getDeviceShareKey(), r16, r11.getHKDFInfo()), "AES");     // Catch: Exception -> L37
    L22:
        int r110 = r19 + 4;     // Catch: Exception -> L37
        int r22 = TransUtils.bytesToInt(Arrays.copyOfRange(r10, r19, r110));     // Catch: Exception -> L37
        int r23 = r110 + 12;     // Catch: Exception -> L37
        byte[] r24 = Arrays.copyOfRange(r10, r110, r23);     // Catch: Exception -> L37
        int r111 = r110 + r22;     // Catch: Exception -> L37
        byte[] r25 = decrypt(Arrays.copyOfRange(r10, r23, r111), r21, r24, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L37
        int r26 = r111 + 12;     // Catch: Exception -> L37
        byte[] r27 = decrypt(Arrays.copyOfRange(r10, r26, r10.length), new SecretKeySpec(r25, "AES"), Arrays.copyOfRange(r10, r111, r26), CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L37
        byte[] r112 = Arrays.copyOfRange(r27, 0, r27.length - 32);     // Catch: Exception -> L37
        if (Arrays.equals(Arrays.copyOfRange(r27, r27.length - 32, r27.length), TransUtils.sha256(r112)) == false) goto L26;
        return r112;
    L26:
        throw new CloudTransException("data decrypt failed，sha256 is error");     // Catch: Exception -> L37
    L18:
        if (r11.isOlidKeyExist() == false) goto L28;
        if (r20 != r11.getOldKeyVersion()) goto L28;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r20);     // Catch: Exception -> L37
        r21 = new SecretKeySpec(HKDFHelper.deriveKey(r11.getOldDeviceShareKey(), r16, r11.getHKDFInfo()), "AES");     // Catch: Exception -> L37
    L28:
        throw new CloudTransException("key version is error, web version: " + r20 + ", current version: " + r11.getKeyVersion(), -22);     // Catch: Exception -> L37
    L30:
        throw new CloudTransException("key cipher magic num is error, web magic num: " + r18 + ", current magic num: " + CryptoConst.TRANS_KEY_CIPHER_MAGIC_NUM);     // Catch: Exception -> L37
    L32:
        throw new CloudTransException("dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r10, 8, r11.getExtraInfo().length + 8)));     // Catch: Exception -> L37
    L34:
        throw new CloudTransException("cipher version is error, web version: " + r13);     // Catch: Exception -> L37
    L36:
        throw new CloudTransException("magic num is error, web num: " + r12 + ", current magic num: " + CryptoConst.TRANS_DATA_MAGIC_NUM);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L43;
        throw ((CloudTransException) e);
    L43:
        throw new CloudTransException("data decrypt failed, error: " + e);
    }

    public static byte[] dataEncrypt(byte[] r10, SensitiveData r11) {
        byte[] r12 = generateAES256Key();
        SecretKeySpec r13 = new SecretKeySpec(r12, "AES");
        byte[] r14 = new byte[12];
        new SecureRandom().nextBytes(r14);
        byte[] r15 = encrypt(TransUtils.concatenate(new byte[][]{r10, TransUtils.sha256(r10)}), r13, r14, CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L18
        byte[] r16 = new byte[12];
        new SecureRandom().nextBytes(r16);
        byte[] r17 = encrypt(r12, new SecretKeySpec(r11.getSessionEncryptKey(), "AES"), r16, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L15
        byte[] r18 = TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_DATA_MAGIC_NUM), TransUtils.intToByteArray(1), r11.getExtraInfo(), r11.getHKDFSalt(), TransUtils.intToByteArray(CryptoConst.TRANS_KEY_CIPHER_MAGIC_NUM), TransUtils.longToByteArray(r11.getKeyVersion()), TransUtils.intToByteArray(r17.length + 12), r16, r17, r14, r15});     // Catch: IOException -> L13
        if (r18.length == 0) goto L12;
        return r18;
    L12:
        throw new CloudTransException("data encrypt failed, cipher is empty.");
    L14:
        throw new CloudTransException("data encrypt failed, concatenate error.");
    L15:
        e = move-exception;
        throw new CloudTransException("key encrypt failed.", e);
    L18:
        e = move-exception;
        throw new CloudTransException("data encrypt failed", e);
    }

    public static byte[] decrypt(byte[] r10, SecretKey r11, byte[] r12, byte[] r13) {
        Cipher r14 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r14.init(2, r11, new GCMParameterSpec(128, r12));
        if (r13 == null) goto L6;
        r14.updateAAD(r13);
    L6:
        return r14.doFinal(r10);
    }

    public static byte[] encrypt(byte[] r10, SecretKey r11, byte[] r12, byte[] r13) {
        Cipher r14 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r14.init(1, r11, new GCMParameterSpec(128, r12));
        if (r13 == null) goto L6;
        r14.updateAAD(r13);
    L6:
        return r14.doFinal(r10);
    }

    public static void fullStreamDecrypt(Context r10, SensitiveData r11, boolean r12, InputStream r13, OutputStream r14) {
        if (r13 == null) goto L5;
        if (r14 == null) goto L5;
    L50:
        byte[] r15 = new byte[4];     // Catch: Exception -> L47
        if (r13.read(r15) == 4) goto L10;
        TransUtils.printErrorInfo(TAG, "Input stream read magicNumBytes failed!");     // Catch: Exception -> L47
    L10:
        int r16 = CryptoUtils.byteArrayToInt(r15);     // Catch: Exception -> L47
        if (r12 == true) goto L13;
    L15:
        if (r12 == false) goto L17;
    L19:
        byte[] r17 = new byte[4];     // Catch: Exception -> L47
        if (r13.read(r17) == 4) goto L22;
        TransUtils.printErrorInfo(TAG, "Input stream read cipherVersionBytes failed!");     // Catch: Exception -> L47
    L22:
        int r18 = CryptoUtils.byteArrayToInt(r17);     // Catch: Exception -> L47
        if (r18 == 1) goto L25;
        TransUtils.printErrorInfo(TAG, "Input full cipher data version is wrong! version:" + r18);     // Catch: Exception -> L47
    L25:
        int r19 = r11.getExtraInfo().length;     // Catch: Exception -> L47
        byte[] r20 = new byte[r19];     // Catch: Exception -> L47
        if (r13.read(r20) == r19) goto L29;
        TransUtils.printErrorInfo(TAG, "Input stream read extraInfo failed!");     // Catch: Exception -> L47
    L29:
        if (Arrays.equals(r11.getExtraInfo(), r20) == true) goto L31;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r20));     // Catch: Exception -> L47
    L31:
        byte[] r21 = new byte[32];     // Catch: Exception -> L47
        if (r13.read(r21) == 32) goto L34;
        TransUtils.printErrorInfo(TAG, "Input stream read hkdfSalt failed!");     // Catch: Exception -> L47
    L34:
        byte[] r22 = new byte[76];     // Catch: Exception -> L47
        if (r13.read(r22) == 76) goto L37;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherBytes failed!");     // Catch: Exception -> L47
    L37:
        SecretKey r23 = initFullDecryptContext(r10, r20, r22, r12, r21, r11).getEncryptKey();     // Catch: Exception -> L47
        LogUtils.d(TAG, "data key len:" + r23.getEncoded().length);     // Catch: Exception -> L47
        byte[] r24 = new byte[12];     // Catch: Exception -> L47
        if (r13.read(r24) == 12) goto L40;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L47
    L40:
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r24));     // Catch: Exception -> L47
        if (r12 == false) goto L43;
        int r25 = ChaCha20.decryptStreamDynamic(r23, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r24, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r13, r14);     // Catch: Exception -> L47
    L44:
        if (r25 == 0) goto L52;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 decryptStreamDynamic failed! error:" + r25);     // Catch: Exception -> L47
        return;
    L52:
        return;
    L43:
        r25 = ChaCha20.decryptStreamDynamic(r23, CryptoConst.ALGORITHM_CHACHA20, r24, new byte[0], 32768, r13, r14);     // Catch: Exception -> L47
        goto L44
    L17:
        if (r16 == 305441707) goto L19;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r16);     // Catch: Exception -> L47
        goto L19
    L13:
        if (r16 == 305424265) goto L15;
        TransUtils.printErrorInfo(TAG, "Cannot parse input full cipher data! magic:" + r16);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full decrypt failed! exception:" + e.getMessage());
        return;
    L5:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L50
    }

    public static void fullStreamEncrypt(TransCryptoContext r10, SensitiveData r11, boolean r12, InputStream r13, OutputStream r14) {
        SecretKey r15 = r10.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r15.getEncoded().length);
        byte[] r16 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L14
        if (r12 == false) goto L6;
        int r17 = CryptoConst.TRANS_FILE_FULL_CIPHER_MAGIC_NUM;
    L7:
        r14.write(TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r17), TransUtils.intToByteArray(1), r11.getExtraInfo(), r11.getHKDFSalt(), r10.getKeyCipher(), r16}));     // Catch: Exception -> L14
        if (r12 == false) goto L10;
        int r18 = ChaCha20.encryptStreamDynamic(r15, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r16, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r13, r14);     // Catch: Exception -> L14
    L11:
        if (r18 == 0) goto L19;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 encryptStreamDynamic failed! error:" + r18);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L10:
        r18 = ChaCha20.encryptStreamDynamic(r15, CryptoConst.ALGORITHM_CHACHA20, r16, new byte[0], 32768, r13, r14);     // Catch: Exception -> L14
        goto L11
    L6:
        r17 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L14:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full encrypt failed! exception:" + e.getMessage());
    }

    private static byte[] generateAES256Key() {
        byte[] r10 = new byte[32];
        new SecureRandom().nextBytes(r10);
        return new SecretKeySpec(r10, "AES").getEncoded();
    }

    public static TransCryptoContext initEncryptContextInner(Context r10, String r11, String r12, SensitiveData r13, boolean r14, boolean r15) {
        TransCryptoContext r16 = new TransCryptoContext(r10, r12, r11);
    L8:
        e = move-exception;
        throw new CloudTransException("initEncryptContextInner failed, error:" + e.getMessage());
    L4:
        if (r16.initEncryptKey(r13, r14, r15) == false) goto L7;
        return r16;
    L7:
        throw new CloudTransException("initEncryptContextInner failed, initEncryptKey failed");     // Catch: Exception -> L8
    }

    private static TransCryptoContext initFullDecryptContext(Context r10, byte[] r11, byte[] r12, boolean r13, byte[] r14, SensitiveData r15) {
        int r16 = Byte.toUnsignedInt(r11[0]) + 1;
        String r17 = new String(Arrays.copyOfRange(r11, 1, r16), StandardCharsets.UTF_8);
        int r18 = Byte.toUnsignedInt(r11[r16]);
        int r19 = r16 + 1;
        String r20 = new String(Arrays.copyOfRange(r11, r19, r18 + r19), StandardCharsets.UTF_8);
        LogUtils.d(TAG, "did:" + r17 + " appid:" + r20);
        TransCryptoContext r21 = new TransCryptoContext(r10, r17, r20);
    L8:
        e = move-exception;
        throw new CloudTransException("initFullDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r21.initFullDecryptKey(r12, r14, r13, r15) == false) goto L7;
        return r21;
    L7:
        throw new CloudTransException("initFullDecryptContext failed, initFullDecryptKey failed");     // Catch: Exception -> L8
    }

    public static void streamDecrypt(TransCryptoContext r10, InputStream r11, OutputStream r12) {
        byte[] r13 = new byte[4];     // Catch: Exception -> L22
        if (r11.read(r13) == 4) goto L6;
        TransUtils.printErrorInfo(TAG, "Input stream is empty!");     // Catch: Exception -> L22
    L6:
        int r14 = CryptoUtils.byteArrayToInt(r13);     // Catch: Exception -> L22
        if (r14 == 591755408) goto L9;
        TransUtils.printErrorInfo(TAG, "Cannot parse input page cipher data! magic:" + r14);     // Catch: Exception -> L22
    L9:
        int r15 = r11.read();     // Catch: Exception -> L22
        LogUtils.i(TAG, "Cipher Version:" + r15);     // Catch: Exception -> L22
        if (r15 == 1) goto L13;
        TransUtils.printErrorInfo(TAG, "Input page cipher data version is wrong! version:" + r15);     // Catch: Exception -> L22
    L13:
        if (r11.read(new byte[16]) == 16) goto L15;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherHash failed!");     // Catch: Exception -> L22
    L15:
        byte[] r16 = new byte[12];     // Catch: Exception -> L22
        if (r11.read(r16) == 12) goto L18;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L22
    L18:
        SecretKey r17 = r10.getEncryptKey();     // Catch: Exception -> L22
        LogUtils.d(TAG, "data key len:" + r17.getEncoded().length);     // Catch: Exception -> L22
        int r18 = ChaCha20.decryptStreamDynamic(r17, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r16, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r11, r12);     // Catch: Exception -> L22
        if (r18 == 0) goto L27;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 decryptStreamDynamic failed! error:" + r18);     // Catch: Exception -> L22
        return;
    L27:
        return;
    L22:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page decrypt failed! exception:" + e.getMessage());
    }

    public static byte[] streamDecryptBytes(TransCryptoContext r10, byte[] r11) {
        byte[] r12 = ChaCha20.decryptStreamBytes(r10.getEncryptKey(), CryptoConst.ALGORITHM_CHACHA20, r10.getDataIv(), r11);
        if (r12 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "streamDecryptBytes failed! cipherData len:" + r11.length);
    L5:
        return r12;
    }

    public static TransCryptoContext streamDecryptFirstBytes(Context r10, SensitiveData r11, byte[] r12) {
        int r13 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 0, 4));
        if (r13 == 305441707) goto L5;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r13);
    L5:
        int r14 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 4, 8));
        if (r14 == 1) goto L8;
        TransUtils.printErrorInfo(TAG, "Input stream cipher data version is wrong! version:" + r14);
    L8:
        byte[] r15 = Arrays.copyOfRange(r12, 8, r11.getExtraInfo().length + 8);
        if (Arrays.equals(r11.getExtraInfo(), r15) == true) goto L11;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r15));
    L11:
        int r16 = 8 + r11.getExtraInfo().length;
        int r17 = r16 + 32;
        byte[] r18 = Arrays.copyOfRange(r12, r16, r17);
        int r19 = r17 + 76;
        TransCryptoContext r20 = initFullDecryptContext(r10, r15, Arrays.copyOfRange(r12, r17, r19), false, r18, r11);
        LogUtils.d(TAG, "data key len:" + r20.getEncryptKey().getEncoded().length);
        byte[] r110 = Arrays.copyOfRange(r12, r19, r19 + 12);
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r110));
        r20.setDataIv(r110);
        return r20;
    }

    public static void streamEncrypt(TransCryptoContext r10, InputStream r11, OutputStream r12) {
        SecretKey r13 = r10.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r13.getEncoded().length);
        byte[] r14 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L7
        r12.write(CryptoUtils.intToBytes(CryptoConst.TRANS_FILE_PAGE_CIPHER_MAGIC_NUM));     // Catch: Exception -> L7
        r12.write(1);     // Catch: Exception -> L7
        r12.write(r10.getKeyCipherHash());     // Catch: Exception -> L7
        r12.write(r14);     // Catch: Exception -> L7
        int r15 = ChaCha20.encryptStreamDynamic(r13, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r14, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r11, r12);     // Catch: Exception -> L7
        if (r15 == 0) goto L12;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 encryptStreamDynamic failed! error:" + r15);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page encrypt failed! exception:" + e.getMessage());
    }
}
