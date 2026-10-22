package com.bytedance.crypto.cloudsync;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public class DataCrypto {
    public static final String TAG = "DataCrypto";
    private static volatile DataCrypto dataCrypto;

    public DataCrypto() {
    }

    private byte[] bytesDecrypt(Context r10, int r11, String r12, byte[] r13) {
        byte[] r14 = new byte[4];
        if (r13.length >= 4) goto L10;
        String r15 = TAG;
        StringBuilder r16 = new StringBuilder();
        String r17 = "Input data len is too short! len:";
    L5:
        r16.append(r17);
        r16.append(r13.length);
    L6:
        String r18 = r16.toString();
    L7:
        LogUtils.e(r15, r18);
    L9:
        return new byte[0];
    L10:
        System.arraycopy(r13, 0, r14, 0, 4);
        int r19 = CryptoUtils.byteArrayToInt(r14);
        if (r19 == 315429581) goto L14;
        r15 = TAG;
        r16 = new StringBuilder();
        r16.append("Cannot parse input cipher data! magic:");
        r16.append(r19);
        goto L6
    L14:
        if (r13.length >= 5) goto L16;
        r15 = TAG;
        r16 = new StringBuilder();
        r17 = "Input data len is too short!! len:";
        goto L5
    L16:
        int r20 = Byte.toUnsignedInt(r13[4]);
        if (r20 == 1) goto L22;
        if (r20 == 2) goto L22;
        LogUtils.e(TAG, "Input cipher data version is wrong! version:" + r20);
    L22:
        if (r13.length >= 17) goto L24;
        r15 = TAG;
        r16 = new StringBuilder();
        r17 = "Input data len is too short for iv! len:";
        goto L5
    L24:
        byte[] r21 = new byte[12];
        System.arraycopy(r13, 5, r21, 0, 12);
        if (r13.length >= 82) goto L27;
        r15 = TAG;
        r16 = new StringBuilder();
        r17 = "Input data len is too short for key cipher! len:";
        goto L5
    L27:
        byte[] r22 = new byte[65];
        System.arraycopy(r13, 17, r22, 0, 65);
        if (r13.length >= 98) goto L30;
        r15 = TAG;
        r16 = new StringBuilder();
        r17 = "Input data len is too short for data cipher! len:";
        goto L5
    L30:
        int r23 = r13.length - 82;
        byte[] r24 = new byte[r23];
        System.arraycopy(r13, 82, r24, 0, r23);
        String r25 = CloudConfig.getInstance().getPkgName(r12) + r12;
        byte[] r26 = SyncKeyManager.getInstance().decryptByKeyManager(r10, r12, r22, r25);
        if (r26 != null) goto L33;
    L42:
        r15 = TAG;
        r18 = "Data key decrypt failed!!";
        goto L7
    L33:
        if (r26.length == 0) goto L42;
        byte[] r27 = AES.gcmXcrypt(r11, r26, r25.getBytes(), r21, r24);
        if (r27 != null) goto L38;
    L41:
        r15 = TAG;
        r18 = "AES GCM decrypt failed!!";
        goto L7
    L38:
        if (r27.length == 0) goto L41;
        return r27;
    }

    private byte[] bytesEncrypt(Context r10, int r11, String r12, byte[] r13) {
        byte[] r14 = CryptoUtils.generateSecureRandom(32);
        if (r14.length != 0) goto L8;
        String r15 = TAG;
        String r16 = "Generate data key failed!!";
    L5:
        LogUtils.e(r15, r16);
    L7:
        return new byte[0];
    L8:
        byte[] r17 = CryptoUtils.generateSecureRandom(12);
        if (r17.length != 0) goto L11;
        r15 = TAG;
        r16 = "Generate IV failed!!";
        goto L5
    L11:
        String r18 = CloudConfig.getInstance().getPkgName(r12) + r12;
        byte[] r19 = AES.gcmXcrypt(r11, r14, r18.getBytes(), r17, r13);
        if (r19 != null) goto L14;
    L27:
        r15 = TAG;
        r16 = "AES GCM encrypt failed!!";
        goto L5
    L14:
        if (r19.length == 0) goto L27;
        byte[] r20 = SyncKeyManager.getInstance().encryptByKeyManager(r10, r12, r14, r18);
        if (r20 != null) goto L19;
    L26:
        r15 = TAG;
        r16 = "Data key encrypt failed!!";
        goto L5
    L19:
        if (r20.length == 0) goto L26;
        if (r20.length == 65) goto L24;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r20.length);
        goto L7
    L24:
        byte[] r21 = new byte[(r20.length + 17) + r19.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r21, 0, 4);
        r21[4] = 2;
        System.arraycopy(r17, 0, r21, 5, 12);
        System.arraycopy(r20, 0, r21, 17, 65);
        System.arraycopy(r19, 0, r21, 82, r19.length);
        return r21;
    }

    private int checkInputParams(Context r10, int r11, String r12, byte[] r13) {
        if (r10 != null) goto L6;
        LogUtils.e(TAG, "Context is null!!");
        return -2;
    L6:
        if (r13 != null) goto L8;
    L29:
        LogUtils.e(TAG, "Input data is empty!!");
        return -2;
    L8:
        if (r13.length == 0) goto L29;
        if (r11 != 1) goto L13;
        int r14 = 1048576;
    L15:
        if (r13.length <= r14) goto L19;
        LogUtils.e(TAG, "Input data is too large!! len:" + r13.length);
        return -2;
    L19:
        if (TextUtils.isEmpty(r12) == false) goto L22;
        LogUtils.e(TAG, "Input alias is empty!!");
        return -2;
    L22:
        if (r11 != 1) goto L24;
    L27:
        LogUtils.i(TAG, "Byte xcrypt params check ok, mode:" + r11 + ", alias:" + r12 + ", data len:" + r13.length);
        return 0;
    L24:
        if (r11 == 2) goto L27;
        LogUtils.e(TAG, "Input mode is invalid!! mode:" + r11);
        return -2;
    L13:
        r14 = CryptoConst.DECRYPT_BYTES_MAX_SIZE;
        goto L15
    }

    private int checkInputParams(CryptoContext r10, int r11, InputStream r12, OutputStream r13) {
        if (r10 != null) goto L7;
        String r14 = TAG;
        String r15 = "CryptoContext is null!!";
    L5:
        LogUtils.e(r14, r15);
        return -2;
    L7:
        if (r12 == null) goto L32;
        if (r13 == null) goto L32;
        if (TextUtils.isEmpty(r10.getAppId()) == false) goto L14;
        r14 = TAG;
        r15 = "Input appid is empty!!";
        goto L5
    L14:
        if (r11 == 1) goto L33;
        if (r11 == 2) goto L33;
        r14 = TAG;
        r15 = "Input mode is invalid!! mode:" + r11;
    L33:
        int r16 = r12.available();     // Catch: Exception -> L21
    L23:
        if (r11 != 1) goto L25;
        int r17 = 1073741824;
    L26:
        if (r16 == 0) goto L31;
        if (r16 > r17) goto L31;
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r11 + ", app:" + r10.getAppId() + ", data len:" + r16);
        return 0;
    L31:
        r14 = TAG;
        r15 = "Input stream data is empty or too large, len:" + r16;
        goto L5
    L25:
        r17 = CryptoConst.DECRYPT_STREAM_MAX_SIZE;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "Input stream each block is encrypted, a TAG will be added to the ciphertexteach block is encrypted, a TAG will be added to the ciphertextatch exception:" + e.getMessage());
        r16 = 0;
    L32:
        r14 = TAG;
        r15 = "Input stream is null!!";
        goto L5
    }

    public static DataCrypto getInstance() {
        if (dataCrypto != null) goto L15;
        monitor-enter(DataCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (dataCrypto != null) goto L9;
        dataCrypto = new DataCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DataCrypto.class);     // Catch: Throwable -> L11
    L15:
        return dataCrypto;
    }

    public byte[] bytesXcrypt(Context r11, int r12, String r13, byte[] r14) {
        int r10 = checkInputParams(r11, r12, r13, r14);
        if (r12 != 1) goto L5;
        int r15 = 4;
    L6:
        int r16 = r15;
        if (r10 == 0) goto L10;
        LogUtils.e(TAG, "Input param is invalid!!");
        EventTrace.eventTrace(r10, r16, r11.getPackageName(), r13, 0, 0);
        return new byte[0];
    L10:
        long r17 = System.currentTimeMillis();
        if (r12 != 1) goto L13;
        byte[] r18 = bytesEncrypt(r11, r12, r13, r14);
    L14:
        long r19 = System.currentTimeMillis() - r17;
        if (r18.length != 0) goto L17;
        int r20 = -4;
    L18:
        EventTrace.eventTrace(r20, r16, r11.getPackageName(), r13, r19, r14.length);
        return r18;
    L17:
        r20 = 0;
        goto L18
    L13:
        r18 = bytesDecrypt(r11, r12, r13, r14);
        goto L14
    L5:
        r15 = 5;
        goto L6
    }

    public int streamXcrypt(CryptoContext r21, int r22, InputStream r23, OutputStream r24) {
        int r10 = checkInputParams(r21, r22, r23, r24);
        if (r10 == 0) goto L6;
        LogUtils.e(TAG, "Input param is invalid!!");
        return r10;
    L6:
        long r11 = System.currentTimeMillis();
        int r12 = -4;
        if (r22 != 1) goto L49;
        SecretKey r13 = r21.getFileEncryptKey();
        LogUtils.d(TAG, "data key len:" + r13.getEncoded().length);
        byte[] r14 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L11
        r24.write(CryptoUtils.intToBytes(CryptoConst.STREAM_CIPHER_MAGIC_NUM));     // Catch: Exception -> L11
        r24.write(2);     // Catch: Exception -> L11
        r24.write(r14.length);     // Catch: Exception -> L11
        r24.write(r14);     // Catch: Exception -> L11
        int r15 = ChaCha20.encryptStreamWithPoly1305(r13, r14, 32768, r23.available(), r23, r24);     // Catch: Exception -> L11
    L10:
        r12 = r15;
    L35:
        long r16 = System.currentTimeMillis() - r11;
        int r19 = r23.available();     // Catch: Exception -> L38
    L40:
        if (r22 != 1) goto L42;
        int r17 = 6;
    L43:
        EventTrace.eventTrace(r12, r17, r21.getContext().getPackageName(), r21.getAppId(), r16, r19);
        LogUtils.i(TAG, "Stream xcrypt end. result:" + r12 + " cost time:" + r16);
        return r12;
    L42:
        r17 = 7;
    L38:
        e = move-exception;
        LogUtils.e(TAG, "Get input stream length failed, exception:" + e.getMessage());
        r19 = 0;
    L11:
        e = e;
        String r18 = TAG;
        StringBuilder r20 = new StringBuilder();
        String r25 = "Data encrypt failed! exception:";
    L34:
        r20.append(r25);
        r20.append(e.getMessage());
        LogUtils.e(r18, r20.toString());
        goto L35
    L49:
        byte[] r26 = new byte[4];     // Catch: Exception -> L32
        r23.read(r26);     // Catch: Exception -> L32
        int r27 = CryptoUtils.byteArrayToInt(r26);     // Catch: Exception -> L32
        if (r27 == 313201323) goto L18;
        LogUtils.e(TAG, "Cannot parse input cipher data! magic:" + r27);     // Catch: Exception -> L32
        return -2;
    L18:
        int r28 = r23.read();     // Catch: Exception -> L32
        String r29 = TAG;     // Catch: Exception -> L32
        LogUtils.i(r29, "Cipher Version:" + r28);     // Catch: Exception -> L32
        if (r28 == 2) goto L23;
        if (r28 == 1) goto L23;
        LogUtils.e(r29, "Input cipher data version is wrong! version:" + r28);     // Catch: Exception -> L32
        return -2;
    L23:
        int r110 = r23.read();     // Catch: Exception -> L32
        LogUtils.d(r29, "ivLen:" + r110);     // Catch: Exception -> L32
        if (r110 == 12) goto L27;
        LogUtils.e(r29, "IV length is wrong! len:" + r110);     // Catch: Exception -> L32
        return -2;
    L27:
        byte[] r30 = new byte[r110];     // Catch: Exception -> L32
        r23.read(r30);     // Catch: Exception -> L32
        SecretKey r31 = r21.getFileEncryptKey();     // Catch: Exception -> L32
        LogUtils.d(r29, "data key len:" + r31.getEncoded().length);     // Catch: Exception -> L32
        if (r28 != 2) goto L30;
        r15 = ChaCha20.decryptStreamWithPoly1305(r31, r30, 32768, r23.available(), r23, r24);     // Catch: Exception -> L32
        goto L10
    L30:
        r15 = ChaCha20.decryptStream(r31, r30, r23, r24);     // Catch: Exception -> L32
    L32:
        e = e;
        r18 = TAG;
        r20 = new StringBuilder();
        r25 = "Data decrypt failed! exception:";
        goto L34
    }
}
