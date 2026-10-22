package com.bytedance.crypto.local;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class LocalDataCrypto {
    public static final String TAG = "LocalDataCrypto";
    private static volatile LocalDataCrypto dataCrypto;
    private Context mContext;

    public LocalDataCrypto() {
    }

    private byte[] bytesDecrypt(Context r10, int r11, String r12, String r13, byte[] r14) {
        byte[] r15 = new byte[4];
        if (r14.length >= 4) goto L10;
        String r16 = TAG;
        StringBuilder r17 = new StringBuilder();
        String r18 = "Input data len is too short! len:";
    L5:
        r17.append(r18);
        r17.append(r14.length);
    L6:
        String r19 = r17.toString();
    L7:
        LogUtils.e(r16, r19);
    L9:
        return new byte[0];
    L10:
        System.arraycopy(r14, 0, r15, 0, 4);
        int r20 = CryptoUtils.byteArrayToInt(r15);
        if (r20 == 315429581) goto L14;
        r16 = TAG;
        r17 = new StringBuilder();
        r17.append("Cannot parse input cipher data! magic:");
        r17.append(r20);
        goto L6
    L14:
        if (r14.length >= 5) goto L16;
        r16 = TAG;
        r17 = new StringBuilder();
        r18 = "Input data len is too short!! len:";
        goto L5
    L16:
        int r21 = Byte.toUnsignedInt(r14[4]);
        if (r21 == 1) goto L22;
        if (r21 == 2) goto L22;
        LogUtils.e(TAG, "Input cipher data version is wrong! version:" + r21);
    L22:
        if (r14.length >= 17) goto L24;
        r16 = TAG;
        r17 = new StringBuilder();
        r18 = "Input data len is too short for iv! len:";
        goto L5
    L24:
        byte[] r22 = new byte[12];
        System.arraycopy(r14, 5, r22, 0, 12);
        if (r14.length >= 82) goto L27;
        r16 = TAG;
        r17 = new StringBuilder();
        r18 = "Input data len is too short for key cipher! len:";
        goto L5
    L27:
        byte[] r23 = new byte[65];
        System.arraycopy(r14, 17, r23, 0, 65);
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_CHACHA20) == false) goto L30;
        int r24 = 0;
    L32:
        if (r14.length >= (r24 + 82)) goto L34;
        r16 = TAG;
        r17 = new StringBuilder();
        r18 = "Input data len is too short for data cipher! len:";
        goto L5
    L34:
        int r25 = r14.length - 82;
        byte[] r26 = new byte[r25];
        System.arraycopy(r14, 82, r26, 0, r25);
        String r27 = r10.getPackageName() + r13;
        byte[] r28 = MasterKeyManager.getInstance().decryptByMasterKey(r10, r27, r23);
        if (r28 != null) goto L37;
    L49:
        r16 = TAG;
        r19 = "Data key decrypt failed!!";
        goto L7
    L37:
        if (r28.length == 0) goto L49;
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_AES) == false) goto L42;
        byte[] r29 = AES.gcmXcrypt(r11, r28, r27.getBytes(), r22, r26);
    L43:
        if (r29 != null) goto L45;
    L48:
        r16 = TAG;
        r19 = "Data decrypt failed!!";
        goto L7
    L45:
        if (r29.length == 0) goto L48;
        return r29;
    L42:
        r29 = ChaCha20.xcryptBytes(r11, r12, r28, r22, r26);
        goto L43
    L30:
        r24 = 16;
        goto L32
    }

    private byte[] bytesEncrypt(Context r10, int r11, String r12, String r13, byte[] r14) {
        byte[] r15 = CryptoUtils.generateSecureRandom(32);
        if (r15.length != 0) goto L8;
        String r16 = TAG;
        String r17 = "Generate data key failed!!";
    L5:
        LogUtils.e(r16, r17);
    L7:
        return new byte[0];
    L8:
        byte[] r18 = CryptoUtils.generateSecureRandom(12);
        if (r18.length != 0) goto L11;
        r16 = TAG;
        r17 = "Generate IV failed!!";
        goto L5
    L11:
        String r19 = r10.getPackageName() + r13;
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_AES) == false) goto L14;
        byte[] r20 = AES.gcmXcrypt(r11, r15, r19.getBytes(), r18, r14);
    L15:
        if (r20 != null) goto L17;
    L30:
        r16 = TAG;
        r17 = "Data encrypt failed!!";
        goto L5
    L17:
        if (r20.length == 0) goto L30;
        byte[] r21 = MasterKeyManager.getInstance().encryptByMasterKey(r10, r19, r15);
        if (r21 != null) goto L22;
    L29:
        r16 = TAG;
        r17 = "Data key encrypt failed!!";
        goto L5
    L22:
        if (r21.length == 0) goto L29;
        if (r21.length == 65) goto L27;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r21.length);
        goto L7
    L27:
        byte[] r22 = new byte[(r21.length + 17) + r20.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r22, 0, 4);
        r22[4] = 2;
        System.arraycopy(r18, 0, r22, 5, 12);
        System.arraycopy(r21, 0, r22, 17, 65);
        System.arraycopy(r20, 0, r22, 82, r20.length);
        return r22;
    L14:
        r20 = ChaCha20.xcryptBytes(r11, r12, r15, r18, r14);
        goto L15
    }

    private int checkInputParams(Context r10, int r11, String r12, String r13, byte[] r14) {
        if (r10 != null) goto L7;
        String r15 = TAG;
        String r16 = "Context is null!!";
    L5:
        LogUtils.e(r15, r16);
        return -2;
    L7:
        if (r14 != null) goto L9;
    L35:
        r15 = TAG;
        r16 = "Input data is empty!!";
        goto L5
    L9:
        if (r14.length == 0) goto L35;
        if (r11 != 1) goto L14;
        int r17 = 1048576;
    L16:
        if (r14.length <= r17) goto L20;
        r15 = TAG;
        StringBuilder r18 = new StringBuilder();
        r18.append("Input data is too large!! len:");
        r18.append(r14.length);
    L18:
        r16 = r18.toString();
        goto L5
    L20:
        if (TextUtils.isEmpty(r13) == false) goto L22;
        r15 = TAG;
        r16 = "Input alias is empty!!";
        goto L5
    L22:
        if (r11 == 1) goto L27;
        if (r11 == 2) goto L27;
        r15 = TAG;
        r16 = "Input mode is invalid!! mode:" + r11;
    L27:
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_AES) == false) goto L29;
        return 0;
    L29:
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_CHACHA20_POLY1305) == false) goto L31;
        return 0;
    L31:
        if (TextUtils.equals(r12, CryptoConst.ALGORITHM_CHACHA20) == true) goto L37;
        r15 = TAG;
        r18 = new StringBuilder();
        r18.append("Input algorithm is invalid!! algorithm:");
        r18.append(r12);
        goto L18
    L37:
        return 0;
    L14:
        r17 = CryptoConst.DECRYPT_BYTES_MAX_SIZE;
        goto L16
    }

    public static LocalDataCrypto getInstance() {
        if (dataCrypto != null) goto L15;
        monitor-enter(LocalDataCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (dataCrypto != null) goto L9;
        dataCrypto = new LocalDataCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LocalDataCrypto.class);     // Catch: Throwable -> L11
    L15:
        return dataCrypto;
    }

    public byte[] bytesXcrypt(int r10, String r11, String r12, byte[] r13) {
        if (checkInputParams(this.mContext, r10, r11, r12, r13) == 0) goto L7;
        LogUtils.e(TAG, "Input param is invalid!!");
        return new byte[0];
    L7:
        if (r10 != 1) goto L11;
        return bytesEncrypt(this.mContext, r10, r11, r12, r13);
    L11:
        return bytesDecrypt(this.mContext, r10, r11, r12, r13);
    }

    public void init(Context r10) {
        this.mContext = r10;
    }
}
