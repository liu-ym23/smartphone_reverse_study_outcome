package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
class DataEncryptHelper {
    private static final String ALGORITHM_AES = "AES";
    private static final String ALGORITHM_TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int GCM_TAG_LENGTH = 16;
    private static final String TAG = "DataEncryptHelper";

    public DataEncryptHelper() {
    }

    public static byte[] dataDecrypt(byte[] r9, SensitiveData r10) {
        int r2 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, 0, 4));     // Catch: Exception -> L37
        if (r2 != 315433677) goto L36;
        int r1 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, 4, 8));     // Catch: Exception -> L37
        if (r1 != 1) goto L34;
        if (Arrays.equals(r10.getExtraInfo(), Arrays.copyOfRange(r9, 8, r10.getExtraInfo().length + 8)) == false) goto L32;
        int r3 = r10.getExtraInfo().length + 8;     // Catch: Exception -> L37
        int r4 = r3 + 32;     // Catch: Exception -> L37
        byte[] r5 = Arrays.copyOfRange(r9, r3, r4);     // Catch: Exception -> L37
        int r6 = r4 + 4;     // Catch: Exception -> L37
        int r7 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, r4, r6));     // Catch: Exception -> L37
        if (r7 != 317666031) goto L30;
        int r8 = r6 + 8;     // Catch: Exception -> L37
        long r11 = TransUtils.bytesToLong(Arrays.copyOfRange(r9, r6, r8));     // Catch: Exception -> L37
        if (r11 != r10.getKeyVersion()) goto L18;
        SecretKeySpec r12 = new SecretKeySpec(HKDFHelper.deriveKey(r10.getDeviceShareKey(), r5, r10.getHKDFInfo()), "AES");     // Catch: Exception -> L37
    L22:
        int r13 = r8 + 4;     // Catch: Exception -> L37
        int r14 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, r8, r13));     // Catch: Exception -> L37
        int r15 = r13 + 12;     // Catch: Exception -> L37
        byte[] r16 = Arrays.copyOfRange(r9, r13, r15);     // Catch: Exception -> L37
        int r17 = r13 + r14;     // Catch: Exception -> L37
        byte[] r18 = decrypt(Arrays.copyOfRange(r9, r15, r17), r12, r16, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L37
        int r19 = r17 + 12;     // Catch: Exception -> L37
        byte[] r20 = decrypt(Arrays.copyOfRange(r9, r19, r9.length), new SecretKeySpec(r18, "AES"), Arrays.copyOfRange(r9, r17, r19), CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L37
        byte[] r110 = Arrays.copyOfRange(r20, 0, r20.length - 32);     // Catch: Exception -> L37
        if (Arrays.equals(Arrays.copyOfRange(r20, r20.length - 32, r20.length), TransUtils.sha256(r110)) == false) goto L26;
        return r110;
    L26:
        throw new CloudTransException("data decrypt failed，sha256 is error");     // Catch: Exception -> L37
    L18:
        if (r10.isOlidKeyExist() == false) goto L28;
        if (r11 != r10.getOldKeyVersion()) goto L28;
        LogUtils.w(TAG, "use old key decrypt, key version is " + r11);     // Catch: Exception -> L37
        r12 = new SecretKeySpec(HKDFHelper.deriveKey(r10.getOldDeviceShareKey(), r5, r10.getHKDFInfo()), "AES");     // Catch: Exception -> L37
    L28:
        throw new CloudTransException("key version is error, web version: " + r11 + ", current version: " + r10.getKeyVersion(), -22);     // Catch: Exception -> L37
    L30:
        throw new CloudTransException("key cipher magic num is error, web magic num: " + r7 + ", current magic num: " + CryptoConst.TRANS_KEY_CIPHER_MAGIC_NUM);     // Catch: Exception -> L37
    L32:
        throw new CloudTransException("dId and appId is error, " + CryptoUtils.byteArrayToHexString(Arrays.copyOfRange(r9, 8, r10.getExtraInfo().length + 8)));     // Catch: Exception -> L37
    L34:
        throw new CloudTransException("cipher version is error, web version: " + r1);     // Catch: Exception -> L37
    L36:
        throw new CloudTransException("magic num is error, web num: " + r2 + ", current magic num: " + CryptoConst.TRANS_DATA_MAGIC_NUM);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L43;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));
    L43:
        throw new CloudTransException("data decrypt failed, error: " + e);
    }

    public static byte[] dataEncrypt(byte[] r10, SensitiveData r11) {
        byte[] r0 = generateAES256Key();
        SecretKeySpec r1 = new SecretKeySpec(r0, "AES");
        byte[] r4 = new byte[12];
        new SecureRandom().nextBytes(r4);
        byte[] r12 = encrypt(TransUtils.concatenate(new byte[][]{r10, TransUtils.sha256(r10)}), r1, r4, CryptoConst.TRANS_AES_DATA_AAD.getBytes());     // Catch: Exception -> L18
        byte[] r2 = new byte[12];
        new SecureRandom().nextBytes(r2);
        byte[] r3 = encrypt(r0, new SecretKeySpec(r11.getSessionEncryptKey(), "AES"), r2, CryptoConst.TRANS_AES_KEY_AAD.getBytes());     // Catch: Exception -> L15
        byte[] r13 = TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(CryptoConst.TRANS_DATA_MAGIC_NUM), TransUtils.intToByteArray(1), r11.getExtraInfo(), r11.getHKDFSalt(), TransUtils.intToByteArray(CryptoConst.TRANS_KEY_CIPHER_MAGIC_NUM), TransUtils.longToByteArray(r11.getKeyVersion()), TransUtils.intToByteArray(r3.length + 12), r2, r3, r4, r12});     // Catch: IOException -> L13
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
        SecretKey r7 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.memorydata.plugin");
        Cipher r0 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r0.init(2, r7, new GCMParameterSpec(128, r5));
        if (r6 == null) goto L6;
        r0.updateAAD(r6);
    L6:
        return r0.doFinal(r3);
    }

    public static byte[] encrypt(byte[] r3, SecretKey r4, byte[] r5, byte[] r6) {
        SecretKey r7 = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r4, SecretKey.class, "com.obric.memorydata.plugin");
        Cipher r0 = Cipher.getInstance(ALGORITHM_TRANSFORMATION);
        r0.init(1, r7, new GCMParameterSpec(128, r5));
        if (r6 == null) goto L6;
        r0.updateAAD(r6);
    L6:
        return r0.doFinal(r3);
    }

    public static void fullStreamDecrypt(Context r7, SensitiveData r8, boolean r9, InputStream r10, OutputStream r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L5;
        if (r11 == null) goto L5;
    L50:
        byte[] r2 = new byte[4];     // Catch: Exception -> L47
        if (r10.read(r2) == 4) goto L10;
        TransUtils.printErrorInfo(TAG, "Input stream read magicNumBytes failed!");     // Catch: Exception -> L47
    L10:
        int r3 = CryptoUtils.byteArrayToInt(r2);     // Catch: Exception -> L47
        if (r9 == true) goto L13;
    L15:
        if (r9 == false) goto L17;
    L19:
        byte[] r4 = new byte[4];     // Catch: Exception -> L47
        if (r10.read(r4) == 4) goto L22;
        TransUtils.printErrorInfo(TAG, "Input stream read cipherVersionBytes failed!");     // Catch: Exception -> L47
    L22:
        int r1 = CryptoUtils.byteArrayToInt(r4);     // Catch: Exception -> L47
        if (r1 == 1) goto L25;
        TransUtils.printErrorInfo(TAG, "Input full cipher data version is wrong! version:" + r1);     // Catch: Exception -> L47
    L25:
        int r5 = r8.getExtraInfo().length;     // Catch: Exception -> L47
        byte[] r6 = new byte[r5];     // Catch: Exception -> L47
        if (r10.read(r6) == r5) goto L29;
        TransUtils.printErrorInfo(TAG, "Input stream read extraInfo failed!");     // Catch: Exception -> L47
    L29:
        if (Arrays.equals(r8.getExtraInfo(), r6) == true) goto L31;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r6));     // Catch: Exception -> L47
    L31:
        byte[] r12 = new byte[32];     // Catch: Exception -> L47
        if (r10.read(r12) == 32) goto L34;
        TransUtils.printErrorInfo(TAG, "Input stream read hkdfSalt failed!");     // Catch: Exception -> L47
    L34:
        byte[] r13 = new byte[76];     // Catch: Exception -> L47
        if (r10.read(r13) == 76) goto L37;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherBytes failed!");     // Catch: Exception -> L47
    L37:
        SecretKey r14 = initFullDecryptContext(r0, r6, r13, r9, r12, r8).getEncryptKey();     // Catch: Exception -> L47
        LogUtils.d(TAG, "data key len:" + r14.getEncoded().length);     // Catch: Exception -> L47
        byte[] r15 = new byte[12];     // Catch: Exception -> L47
        if (r10.read(r15) == 12) goto L40;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L47
    L40:
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r15));     // Catch: Exception -> L47
        if (r9 == false) goto L43;
        int r16 = ChaCha20.decryptStreamDynamic(r14, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r15, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r10, r11);     // Catch: Exception -> L47
    L44:
        if (r16 == 0) goto L52;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 decryptStreamDynamic failed! error:" + r16);     // Catch: Exception -> L47
        return;
    L52:
        return;
    L43:
        r16 = ChaCha20.decryptStreamDynamic(r14, CryptoConst.ALGORITHM_CHACHA20, r15, new byte[0], 32768, r10, r11);     // Catch: Exception -> L47
        goto L44
    L17:
        if (r3 == 305441707) goto L19;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r3);     // Catch: Exception -> L47
        goto L19
    L13:
        if (r3 == 305424265) goto L15;
        TransUtils.printErrorInfo(TAG, "Cannot parse input full cipher data! magic:" + r3);     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full decrypt failed! exception:" + e.getMessage());
        return;
    L5:
        TransUtils.printErrorInfo(TAG, "Input full stream is null!!");
        goto L50
    }

    public static void fullStreamEncrypt(TransCryptoContext r8, SensitiveData r9, boolean r10, InputStream r11, OutputStream r12) {
        SecretKey r0 = r8.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r0.getEncoded().length);
        byte[] r2 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L14
        if (r10 == false) goto L6;
        int r1 = CryptoConst.TRANS_FILE_FULL_CIPHER_MAGIC_NUM;
    L7:
        r12.write(TransUtils.concatenate(new byte[][]{TransUtils.intToByteArray(r1), TransUtils.intToByteArray(1), r9.getExtraInfo(), r9.getHKDFSalt(), r8.getKeyCipher(), r2}));     // Catch: Exception -> L14
        if (r10 == false) goto L10;
        int r13 = ChaCha20.encryptStreamDynamic(r0, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r2, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r11, r12);     // Catch: Exception -> L14
    L11:
        if (r13 == 0) goto L19;
        TransUtils.printErrorInfo(TAG, "Full ChaCha20 encryptStreamDynamic failed! error:" + r13);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L10:
        r13 = ChaCha20.encryptStreamDynamic(r0, CryptoConst.ALGORITHM_CHACHA20, r2, new byte[0], 32768, r11, r12);     // Catch: Exception -> L14
        goto L11
    L6:
        r1 = CryptoConst.STREAM_CIPHER_MAGIC_NUM;
    L14:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data full encrypt failed! exception:" + e.getMessage());
    }

    private static byte[] generateAES256Key() {
        byte[] r0 = new byte[32];
        new SecureRandom().nextBytes(r0);
        return new SecretKeySpec(r0, "AES").getEncoded();
    }

    public static TransCryptoContext initEncryptContextInner(Context r2, String r3, String r4, SensitiveData r5, boolean r6, boolean r7) {
        TransCryptoContext r0 = new TransCryptoContext((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r4, r3);
    L8:
        e = move-exception;
        throw new CloudTransException("initEncryptContextInner failed, error:" + e.getMessage());
    L4:
        if (r0.initEncryptKey(r5, r6, r7) == false) goto L7;
        return r0;
    L7:
        throw new CloudTransException("initEncryptContextInner failed, initEncryptKey failed");     // Catch: Exception -> L8
    }

    private static TransCryptoContext initFullDecryptContext(Context r5, byte[] r6, byte[] r7, boolean r8, byte[] r9, SensitiveData r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        int r0 = Byte.toUnsignedInt(r6[0]) + 1;
        String r3 = new String(Arrays.copyOfRange(r6, 1, r0), StandardCharsets.UTF_8);
        int r2 = Byte.toUnsignedInt(r6[r0]);
        int r1 = r0 + 1;
        String r4 = new String(Arrays.copyOfRange(r6, r1, r2 + r1), StandardCharsets.UTF_8);
        LogUtils.d(TAG, "did:" + r3 + " appid:" + r4);
        TransCryptoContext r12 = new TransCryptoContext(r11, r3, r4);
    L8:
        e = move-exception;
        throw new CloudTransException("initFullDecryptContext failed, error:" + e.getMessage());
    L4:
        if (r12.initFullDecryptKey(r7, r9, r8, r10) == false) goto L7;
        return r12;
    L7:
        throw new CloudTransException("initFullDecryptContext failed, initFullDecryptKey failed");     // Catch: Exception -> L8
    }

    public static void streamDecrypt(TransCryptoContext r9, InputStream r10, OutputStream r11) {
        byte[] r2 = new byte[4];     // Catch: Exception -> L22
        if (r10.read(r2) == 4) goto L6;
        TransUtils.printErrorInfo(TAG, "Input stream is empty!");     // Catch: Exception -> L22
    L6:
        int r1 = CryptoUtils.byteArrayToInt(r2);     // Catch: Exception -> L22
        if (r1 == 591755408) goto L9;
        TransUtils.printErrorInfo(TAG, "Cannot parse input page cipher data! magic:" + r1);     // Catch: Exception -> L22
    L9:
        int r3 = r10.read();     // Catch: Exception -> L22
        LogUtils.i(TAG, "Cipher Version:" + r3);     // Catch: Exception -> L22
        if (r3 == 1) goto L13;
        TransUtils.printErrorInfo(TAG, "Input page cipher data version is wrong! version:" + r3);     // Catch: Exception -> L22
    L13:
        if (r10.read(new byte[16]) == 16) goto L15;
        TransUtils.printErrorInfo(TAG, "Input stream read keyCipherHash failed!");     // Catch: Exception -> L22
    L15:
        byte[] r4 = new byte[12];     // Catch: Exception -> L22
        if (r10.read(r4) == 12) goto L18;
        TransUtils.printErrorInfo(TAG, "Input stream read ivBytes failed!");     // Catch: Exception -> L22
    L18:
        SecretKey r5 = r9.getEncryptKey();     // Catch: Exception -> L22
        LogUtils.d(TAG, "data key len:" + r5.getEncoded().length);     // Catch: Exception -> L22
        int r12 = ChaCha20.decryptStreamDynamic(r5, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r4, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r10, r11);     // Catch: Exception -> L22
        if (r12 == 0) goto L27;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 decryptStreamDynamic failed! error:" + r12);     // Catch: Exception -> L22
        return;
    L27:
        return;
    L22:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page decrypt failed! exception:" + e.getMessage());
    }

    public static byte[] streamDecryptBytes(TransCryptoContext r2, byte[] r3) {
        byte[] r4 = ChaCha20.decryptStreamBytes(r2.getEncryptKey(), CryptoConst.ALGORITHM_CHACHA20, r2.getDataIv(), r3);
        if (r4 != null) goto L5;
        TransUtils.printErrorInfo(TAG, "streamDecryptBytes failed! cipherData len:" + r3.length);
    L5:
        return r4;
    }

    public static TransCryptoContext streamDecryptFirstBytes(Context r7, SensitiveData r8, byte[] r9) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        int r10 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, 0, 4));
        if (r10 == 305441707) goto L5;
        TransUtils.printErrorInfo(TAG, "Cannot parse input stream cipher data! magic:" + r10);
    L5:
        int r1 = TransUtils.bytesToInt(Arrays.copyOfRange(r9, 4, 8));
        if (r1 == 1) goto L8;
        TransUtils.printErrorInfo(TAG, "Input stream cipher data version is wrong! version:" + r1);
    L8:
        byte[] r2 = Arrays.copyOfRange(r9, 8, r8.getExtraInfo().length + 8);
        if (Arrays.equals(r8.getExtraInfo(), r2) == true) goto L11;
        TransUtils.printErrorInfo(TAG, "dId and appId is error, " + CryptoUtils.byteArrayToHexString(r2));
    L11:
        int r11 = 8 + r8.getExtraInfo().length;
        int r3 = r11 + 32;
        byte[] r4 = Arrays.copyOfRange(r9, r11, r3);
        int r12 = r3 + 76;
        TransCryptoContext r13 = initFullDecryptContext(r0, r2, Arrays.copyOfRange(r9, r3, r12), false, r4, r8);
        LogUtils.d(TAG, "data key len:" + r13.getEncryptKey().getEncoded().length);
        byte[] r14 = Arrays.copyOfRange(r9, r12, r12 + 12);
        LogUtils.d(TAG, "ivBytes:" + CryptoUtils.byteArrayToHexString(r14));
        r13.setDataIv(r14);
        return r13;
    }

    public static void streamEncrypt(TransCryptoContext r8, InputStream r9, OutputStream r10) {
        SecretKey r0 = r8.getEncryptKey();
        LogUtils.d(TAG, "data key len:" + r0.getEncoded().length);
        byte[] r2 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L7
        r10.write(CryptoUtils.intToBytes(CryptoConst.TRANS_FILE_PAGE_CIPHER_MAGIC_NUM));     // Catch: Exception -> L7
        r10.write(1);     // Catch: Exception -> L7
        r10.write(r8.getKeyCipherHash());     // Catch: Exception -> L7
        r10.write(r2);     // Catch: Exception -> L7
        int r11 = ChaCha20.encryptStreamDynamic(r0, CryptoConst.ALGORITHM_CHACHA20_POLY1305, r2, CryptoConst.TRANS_AES_DATA_AAD.getBytes(), 32768, r9, r10);     // Catch: Exception -> L7
        if (r11 == 0) goto L12;
        TransUtils.printErrorInfo(TAG, "Page ChaCha20 encryptStreamDynamic failed! error:" + r11);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        TransUtils.printErrorInfo(TAG, "Data page encrypt failed! exception:" + e.getMessage());
    }
}
