package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.HKDFHelper;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class DataEncryptHelper {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final String TAG = "DataEncryptHelper";

    public DataEncryptHelper() {
    }

    public static byte[] dataDecrypt(byte[] r12, SensitiveData r13) {
        int r10 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 0, 4));     // Catch: Exception -> L35
        if (r10 != 315433677) goto L34;
        int r7 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 4, 8));     // Catch: Exception -> L35
        if (r7 != 1) goto L32;
        if (Arrays.equals(r13.getExtraInfo(), Arrays.copyOfRange(r12, 8, r13.getExtraInfo().length + 8)) == false) goto L30;
        int r4 = r13.getExtraInfo().length + 8;     // Catch: Exception -> L35
        int r5 = r4 + 32;     // Catch: Exception -> L35
        byte[] r6 = Arrays.copyOfRange(r12, r4, r5);     // Catch: Exception -> L35
        int r8 = r5 + 4;     // Catch: Exception -> L35
        int r9 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, r5, r8));     // Catch: Exception -> L35
        if (r9 != 317666031) goto L28;
        int r2 = r8 + 8;     // Catch: Exception -> L35
        long r11 = TransUtils.bytesToLong(Arrays.copyOfRange(r12, r8, r2));     // Catch: Exception -> L35
        if (r11 != r13.getKeyVersion()) goto L16;
        SecretKeySpec r0 = new SecretKeySpec(HKDFHelper.deriveKey(r13.getDeviceShareKey(), r6, r13.getHKDFInfo()), ALGORITHM_AES);     // Catch: Exception -> L35
    L20:
        int r14 = r2 + 4;     // Catch: Exception -> L35
        int r1 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, r2, r14));     // Catch: Exception -> L35
        int r3 = r14 + 12;     // Catch: Exception -> L35
        byte[] r15 = Arrays.copyOfRange(r12, r14, r3);     // Catch: Exception -> L35
        int r16 = r14 + r1;     // Catch: Exception -> L35
        byte[] r17 = decrypt(Arrays.copyOfRange(r12, r3, r16), r0, r15, "cloud_trans_key_v2".getBytes());     // Catch: Exception -> L35
        int r18 = r16 + 12;     // Catch: Exception -> L35
        byte[] r19 = decrypt(Arrays.copyOfRange(r12, r18, r12.length), new SecretKeySpec(r17, ALGORITHM_AES), Arrays.copyOfRange(r12, r16, r18), "cloud_trans_data_v2".getBytes());     // Catch: Exception -> L35
        byte[] r110 = Arrays.copyOfRange(r19, 0, r19.length - 32);     // Catch: Exception -> L35
        if (Arrays.equals(Arrays.copyOfRange(r19, r19.length - 32, r19.length), TransUtils.sha256(r110)) == false) goto L24;
        return r110;
    L24:
        throw new CloudTransException("data decrypt failed，sha256 is error");     // Catch: Exception -> L35
    L16:
        if (r13.isOlidKeyExist() == false) goto L26;
        if (r11 != r13.getOldKeyVersion()) goto L26;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r11);     // Catch: Exception -> L35
        r0 = new SecretKeySpec(HKDFHelper.deriveKey(r13.getOldDeviceShareKey(), r6, r13.getHKDFInfo()), ALGORITHM_AES);     // Catch: Exception -> L35
    L26:
        throw new CloudTransException("key version is error, web version: " + r11 + ", current version: " + r13.getKeyVersion(), -22);     // Catch: Exception -> L35
    L28:
        throw new CloudTransException("key cipher magic num is error, web magic num: " + r9 + ", current magic num: 317666031");     // Catch: Exception -> L35
    L30:
        throw new CloudTransException("dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r12, 8, r13.getExtraInfo().length + 8)));     // Catch: Exception -> L35
    L32:
        throw new CloudTransException("cipher version is error, web version: " + r7);     // Catch: Exception -> L35
    L34:
        throw new CloudTransException("magic num is error, web num: " + r10 + ", current magic num: 315433677");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L41;
        throw ((CloudTransException) e);
    L41:
        throw new CloudTransException("data decrypt failed, error: " + e);
    }

    public static byte[] dataEncrypt(byte[] r10, SensitiveData r11) {
        byte[] r0 = generateAES256Key();
        SecretKeySpec r1 = new SecretKeySpec(r0, ALGORITHM_AES);
        byte[] r4 = new byte[12];
        new SecureRandom().nextBytes(r4);
        byte[] r12 = encrypt(TransUtils.concatenate(new byte[][]{r10, TransUtils.sha256(r10)}), r1, r4, "cloud_trans_data_v2".getBytes());     // Catch: Exception -> L18
        byte[] r2 = new byte[12];
        new SecureRandom().nextBytes(r2);
        byte[] r3 = encrypt(r0, new SecretKeySpec(r11.getSessionEncryptKey(), ALGORITHM_AES), r2, "cloud_trans_key_v2".getBytes());     // Catch: Exception -> L15
        byte[] r13 = TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(315433677), TransUtils.intToByteArray(1), r11.getExtraInfo(), r11.getHKDFSalt(), TransUtils.intToByteArray(317666031), TransUtils.longToByteArray(r11.getKeyVersion()), TransUtils.intToByteArray(r3.length + 12), r2, r3, r4, r12});     // Catch: IOException -> L13
        if (r13.length == 0) goto L12;
        return r13;
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

    public static byte[] decrypt(byte[] r3, SecretKey r4, byte[] r5, byte[] r6) {
        Cipher r0 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r0.init(2, r4, new GCMParameterSpec(128, r5));
        if (r6 == null) goto L6;
        r0.updateAAD(r6);
    L6:
        return r0.doFinal(r3);
    }

    public static byte[] encrypt(byte[] r3, SecretKey r4, byte[] r5, byte[] r6) {
        Cipher r0 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r0.init(1, r4, new GCMParameterSpec(128, r5));
        if (r6 == null) goto L6;
        r0.updateAAD(r6);
    L6:
        return r0.doFinal(r3);
    }

    public static void fullStreamDecrypt(Context r12, SensitiveData r13, boolean r14, InputStream r15, OutputStream r16) {
        if (r15 == null) goto L5;
        if (r16 == null) goto L5;
    L50:
        byte[] r6 = new byte[4];     // Catch: Exception -> L47
        if (r15.read(r6) == 4) goto L10;
        TransUtils.printErrorInfo(TAG, "Input stream read magicNumBytes failed!");     // Catch: Exception -> L47
    L10:
        int r7 = CryptoUtils.byteArrayToInt(r6);     // Catch: Exception -> L47
        if (r14 == true) goto L13;
    L15:
        if (r14 == false) goto L17;
    L19:
        byte[] r3 = new byte[4];     // Catch: Exception -> L47
        if (r15.read(r3) == 4) goto L22;
        TransUtils.printErrorInfo(TAG, "Input stream read cipherVersionBytes failed!");     // Catch: Exception -> L47
    L22:
        int r4 = CryptoUtils.byteArrayToInt(r3);     // Catch: Exception -> L47
        if (r4 == 1) goto L25;
        TransUtils.printErrorInfo(TAG, "Input full cipher data version is wrong! version:" + r4);     // Catch: Exception -> L47
    L25:
        int r2 = r13.getExtraInfo().length;     // Catch: Exception -> L47
        byte[] r5 = new byte[r2];     // Catch: Exception -> L47
        if (r15.read(r5) == r2) goto L29;
        TransUtils.printErrorInfo(TAG, "Input stream read extraInfo failed!");     // Catch: Exception -> L47
    L29:
        if (Arrays.equals(r13.getExtraInfo(), r5) == true) goto L31;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r5));     // Catch: Exception -> L47
    L31:
        byte[] r8 = new byte[32];     // Catch: Exception -> L47
        if (r15.read(r8) == 32) goto L34;
        TransUtils.printErrorInfo(TAG, "Input stream read hkdfSalt failed!");     // Catch: Exception -> L47
    L34:
        byte[] r9 = new byte[76];     // Catch: Exception -> L47
        if (r15.read(r9) == 76) goto L37;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherBytes failed!");     // Catch: Exception -> L47
    L37:
        SecretKey r1 = initFullDecryptContext(r12, r5, r9, r14, r8, r13).getEncryptKey();     // Catch: Exception -> L47
        LogUtils.d(TAG, "data key len:" + r1.getEncoded().length);     // Catch: Exception -> L47
        byte[] r10 = new byte[12];     // Catch: Exception -> L47
        if (r15.read(r10) == 12) goto L40;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L47
    L40:
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r10));     // Catch: Exception -> L47
        if (r14 == false) goto L43;
        int r0 = ChaCha20.decryptStreamDynamic(r1, "ChaCha20-Poly1305", r10, "cloud_trans_data_v2".getBytes(), 32768, r15, r16);     // Catch: Exception -> L47
    L44:
        if (r0 == 0) goto L52;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 decryptStreamDynamic failed! error:" + r0);     // Catch: Exception -> L47
        return;
    L52:
        return;
    L43:
        r0 = ChaCha20.decryptStreamDynamic(r1, "ChaCha20", r10, new byte[0], 32768, r15, r16);     // Catch: Exception -> L47
        goto L44
    L17:
        if (r7 == 305441707) goto L19;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r7);     // Catch: Exception -> L47
        goto L19
    L13:
        if (r7 == 305424265) goto L15;
        TransUtils.printErrorInfo(TAG, "Cannot parse input full cipher data! magic:" + r7);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full decrypt failed! exception:" + e.getMessage());
        return;
    L5:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L50
    }

    public static void fullStreamEncrypt(TransCryptoContext r9, SensitiveData r10, boolean r11, InputStream r12, OutputStream r13) {
        SecretKey r1 = r9.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r1.getEncoded().length);
        byte[] r3 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L14
        if (r11 == false) goto L6;
        int r2 = 305424265;
    L7:
        r13.write(TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r2), TransUtils.intToByteArray(1), r10.getExtraInfo(), r10.getHKDFSalt(), r9.getKeyCipher(), r3}));     // Catch: Exception -> L14
        if (r11 == false) goto L10;
        int r14 = ChaCha20.encryptStreamDynamic(r1, "ChaCha20-Poly1305", r3, "cloud_trans_data_v2".getBytes(), 32768, r12, r13);     // Catch: Exception -> L14
    L11:
        if (r14 == 0) goto L19;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 encryptStreamDynamic failed! error:" + r14);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L10:
        r14 = ChaCha20.encryptStreamDynamic(r1, "ChaCha20", r3, new byte[0], 32768, r12, r13);     // Catch: Exception -> L14
        goto L11
    L6:
        r2 = 313201323;
    L14:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full encrypt failed! exception:" + e.getMessage());
    }

    private static byte[] generateAES256Key() {
        byte[] r0 = new byte[32];
        new SecureRandom().nextBytes(r0);
        return new SecretKeySpec(r0, ALGORITHM_AES).getEncoded();
    }

    public static TransCryptoContext initEncryptContextInner(Context r1, String r2, String r3, SensitiveData r4, boolean r5, boolean r6) {
        TransCryptoContext r0 = new TransCryptoContext(r1, r3, r2);
    L8:
        e = move-exception;
        throw new CloudTransException("initEncryptContextInner failed, error:" + e.getMessage());
    L4:
        if (r0.initEncryptKey(r4, r5, r6) == false) goto L7;
        return r0;
    L7:
        throw new CloudTransException("initEncryptContextInner failed, initEncryptKey failed");     // Catch: Exception -> L8
    }

    private static TransCryptoContext initFullDecryptContext(Context r5, byte[] r6, byte[] r7, boolean r8, byte[] r9, SensitiveData r10) {
        int r0 = (r6[0] & 255) + 1;
        String r3 = new String(Arrays.copyOfRange(r6, 1, r0), StandardCharsets.UTF_8);
        int r2 = r6[r0] & 255;
        int r1 = r0 + 1;
        String r4 = new String(Arrays.copyOfRange(r6, r1, r2 + r1), StandardCharsets.UTF_8);
        LogUtils.d(TAG, "did:" + r3 + " appid:" + r4);
        TransCryptoContext r11 = new TransCryptoContext(r5, r3, r4);
    L8:
        e = move-exception;
        throw new CloudTransException("initFullDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r11.initFullDecryptKey(r7, r9, r8, r10) == false) goto L7;
        return r11;
    L7:
        throw new CloudTransException("initFullDecryptContext failed, initFullDecryptKey failed");     // Catch: Exception -> L8
    }

    public static void streamDecrypt(TransCryptoContext r11, InputStream r12, OutputStream r13) {
        byte[] r7 = new byte[4];     // Catch: Exception -> L22
        if (r12.read(r7) == 4) goto L6;
        TransUtils.printErrorInfo(TAG, "Input stream is empty!");     // Catch: Exception -> L22
    L6:
        int r6 = CryptoUtils.byteArrayToInt(r7);     // Catch: Exception -> L22
        if (r6 == 591755408) goto L9;
        TransUtils.printErrorInfo(TAG, "Cannot parse input page cipher data! magic:" + r6);     // Catch: Exception -> L22
    L9:
        int r5 = r12.read();     // Catch: Exception -> L22
        LogUtils.i(TAG, "Cipher Version:" + r5);     // Catch: Exception -> L22
        if (r5 == 1) goto L13;
        TransUtils.printErrorInfo(TAG, "Input page cipher data version is wrong! version:" + r5);     // Catch: Exception -> L22
    L13:
        if (r12.read(new byte[16]) == 16) goto L15;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherHash failed!");     // Catch: Exception -> L22
    L15:
        byte[] r8 = new byte[12];     // Catch: Exception -> L22
        if (r12.read(r8) == 12) goto L18;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L22
    L18:
        SecretKey r4 = r11.getEncryptKey();     // Catch: Exception -> L22
        LogUtils.d(TAG, "data key len:" + r4.getEncoded().length);     // Catch: Exception -> L22
        int r14 = ChaCha20.decryptStreamDynamic(r4, "ChaCha20-Poly1305", r8, "cloud_trans_data_v2".getBytes(), 32768, r12, r13);     // Catch: Exception -> L22
        if (r14 == 0) goto L27;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 decryptStreamDynamic failed! error:" + r14);     // Catch: Exception -> L22
        return;
    L27:
        return;
    L22:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page decrypt failed! exception:" + e.getMessage());
    }

    public static byte[] streamDecryptBytes(TransCryptoContext r2, byte[] r3) {
        byte[] r4 = ChaCha20.decryptStreamBytes(r2.getEncryptKey(), "ChaCha20", r2.getDataIv(), r3);
        if (r4 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "streamDecryptBytes failed! cipherData len:" + r3.length);
    L5:
        return r4;
    }

    public static TransCryptoContext streamDecryptFirstBytes(Context r10, SensitiveData r11, byte[] r12) {
        int r0 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 0, 4));
        if (r0 == 305441707) goto L5;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r0);
    L5:
        int r1 = TransUtils.bytesToInt(Arrays.copyOfRange(r12, 4, 8));
        if (r1 == 1) goto L8;
        TransUtils.printErrorInfo(TAG, "Input stream cipher data version is wrong! version:" + r1);
    L8:
        byte[] r5 = Arrays.copyOfRange(r12, 8, r11.getExtraInfo().length + 8);
        if (Arrays.equals(r11.getExtraInfo(), r5) == true) goto L11;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r5));
    L11:
        int r2 = 8 + r11.getExtraInfo().length;
        int r3 = r2 + 32;
        byte[] r8 = Arrays.copyOfRange(r12, r2, r3);
        int r4 = r3 + 76;
        TransCryptoContext r13 = initFullDecryptContext(r10, r5, Arrays.copyOfRange(r12, r3, r4), false, r8, r11);
        LogUtils.d(TAG, "data key len:" + r13.getEncryptKey().getEncoded().length);
        byte[] r14 = Arrays.copyOfRange(r12, r4, r4 + 12);
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r14));
        r13.setDataIv(r14);
        return r13;
    }

    public static void streamEncrypt(TransCryptoContext r9, InputStream r10, OutputStream r11) {
        SecretKey r1 = r9.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r1.getEncoded().length);
        byte[] r3 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L7
        r11.write(CryptoUtils.intToBytes(591755408));     // Catch: Exception -> L7
        r11.write(1);     // Catch: Exception -> L7
        r11.write(r9.getKeyCipherHash());     // Catch: Exception -> L7
        r11.write(r3);     // Catch: Exception -> L7
        int r12 = ChaCha20.encryptStreamDynamic(r1, "ChaCha20-Poly1305", r3, "cloud_trans_data_v2".getBytes(), 32768, r10, r11);     // Catch: Exception -> L7
        if (r12 == 0) goto L12;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 encryptStreamDynamic failed! error:" + r12);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page encrypt failed! exception:" + e.getMessage());
    }
}
