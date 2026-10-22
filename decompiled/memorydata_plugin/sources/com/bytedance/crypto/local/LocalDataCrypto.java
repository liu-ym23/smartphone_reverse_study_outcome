package com.bytedance.crypto.local;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class LocalDataCrypto {
    public static final String TAG = "LocalDataCrypto";
    private static volatile LocalDataCrypto dataCrypto;
    private Context mContext;

    public LocalDataCrypto() {
    }

    private byte[] bytesDecrypt(Context r6, int r7, String r8, String r9, byte[] r10) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[4];
        if (r10.length >= 4) goto L9;
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder();
        String r13 = "Input data len is too short! len:";
    L5:
        StringBuilder r14 = r12.append(r13).append(r10.length);
    L6:
        String r15 = r14.toString();
    L7:
        LogUtils.e(r11, r15);
        return new byte[0];
    L9:
        System.arraycopy(r10, 0, r0, 0, 4);
        int r1 = CryptoUtils.byteArrayToInt(r0);
        if (r1 == 315429581) goto L13;
        r11 = TAG;
        r14 = new StringBuilder().append("Cannot parse input cipher data! magic:").append(r1);
        goto L6
    L13:
        if (r10.length >= 5) goto L15;
        r11 = TAG;
        r12 = new StringBuilder();
        r13 = "Input data len is too short!! len:";
        goto L5
    L15:
        int r16 = Byte.toUnsignedInt(r10[4]);
        if (r16 == 1) goto L21;
        if (r16 == 2) goto L21;
        r11 = TAG;
        r14 = new StringBuilder().append("Input cipher data version is wrong! version:").append(r16);
    L21:
        if (r10.length >= 17) goto L23;
        r11 = TAG;
        r12 = new StringBuilder();
        r13 = "Input data len is too short for iv! len:";
        goto L5
    L23:
        byte[] r3 = new byte[12];
        System.arraycopy(r10, 5, r3, 0, 12);
        if (r10.length >= 82) goto L26;
        r11 = TAG;
        r12 = new StringBuilder();
        r13 = "Input data len is too short for key cipher! len:";
        goto L5
    L26:
        byte[] r2 = new byte[65];
        System.arraycopy(r10, 17, r2, 0, 65);
        if (TextUtils.equals(r8, CryptoConst.ALGORITHM_CHACHA20) == false) goto L29;
        int r17 = 0;
    L31:
        if (r10.length >= (r17 + 82)) goto L33;
        r11 = TAG;
        r12 = new StringBuilder();
        r13 = "Input data len is too short for data cipher! len:";
        goto L5
    L33:
        int r18 = r10.length - 82;
        byte[] r4 = new byte[r18];
        System.arraycopy(r10, 82, r4, 0, r18);
        String r19 = r5.getPackageName() + r9;
        byte[] r20 = MasterKeyManager.getInstance().decryptByMasterKey(r5, r19, r2);
        if (r20 != null) goto L36;
    L48:
        r11 = TAG;
        r15 = "Data key decrypt failed!!";
        goto L7
    L36:
        if (r20.length == 0) goto L48;
        if (TextUtils.equals(r8, CryptoConst.ALGORITHM_AES) == false) goto L41;
        byte[] r21 = AES.gcmXcrypt(r7, r20, r19.getBytes(), r3, r4);
    L42:
        if (r21 != null) goto L44;
    L47:
        r11 = TAG;
        r15 = "Data decrypt failed!!";
        goto L7
    L44:
        if (r21.length == 0) goto L47;
        return r21;
    L41:
        r21 = ChaCha20.xcryptBytes(r7, r8, r20, r3, r4);
        goto L42
    L29:
        r17 = 16;
        goto L31
    }

    private byte[] bytesEncrypt(Context r6, int r7, String r8, String r9, byte[] r10) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        byte[] r11 = CryptoUtils.generateSecureRandom(32);
        if (r11.length != 0) goto L8;
        String r12 = TAG;
        String r13 = "Generate data key failed!!";
    L5:
        LogUtils.e(r12, r13);
    L7:
        return new byte[0];
    L8:
        byte[] r2 = CryptoUtils.generateSecureRandom(12);
        if (r2.length != 0) goto L11;
        r12 = TAG;
        r13 = "Generate IV failed!!";
        goto L5
    L11:
        String r14 = r5.getPackageName() + r9;
        if (TextUtils.equals(r8, CryptoConst.ALGORITHM_AES) == false) goto L14;
        byte[] r15 = AES.gcmXcrypt(r7, r11, r14.getBytes(), r2, r10);
    L15:
        if (r15 != null) goto L17;
    L30:
        r12 = TAG;
        r13 = "Data encrypt failed!!";
        goto L5
    L17:
        if (r15.length == 0) goto L30;
        byte[] r16 = MasterKeyManager.getInstance().encryptByMasterKey(r5, r14, r11);
        if (r16 != null) goto L22;
    L29:
        r12 = TAG;
        r13 = "Data key encrypt failed!!";
        goto L5
    L22:
        if (r16.length == 0) goto L29;
        if (r16.length == 65) goto L27;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r16.length);
        goto L7
    L27:
        byte[] r17 = new byte[(r16.length + 17) + r15.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r17, 0, 4);
        r17[4] = 2;
        System.arraycopy(r2, 0, r17, 5, 12);
        System.arraycopy(r16, 0, r17, 17, 65);
        System.arraycopy(r15, 0, r17, 82, r15.length);
        return r17;
    L14:
        r15 = ChaCha20.xcryptBytes(r7, r8, r11, r2, r10);
        goto L15
    }

    private byte[] bytesSharedDecrypt(Context r7, int r8, String r9, String r10, byte[] r11) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[4];
        if (r11.length >= 4) goto L10;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder();
    L5:
        StringBuilder r14 = r13.append("Input data len is too short for shared decrypt! len:");
    L6:
        StringBuilder r15 = r14.append(r11.length);
    L7:
        String r16 = r15.toString();
    L8:
        LogUtils.e(r12, r16);
        return new byte[0];
    L10:
        System.arraycopy(r11, 0, r0, 0, 4);
        int r1 = CryptoUtils.byteArrayToInt(r0);
        if (r1 == (-1412584499)) goto L15;
        r12 = TAG;
        StringBuilder r17 = new StringBuilder();
        String r18 = "Cannot parse input cipher data for shared decrypt! magic:";
    L13:
        r15 = r17.append(r18).append(r1);
        goto L7
    L15:
        if (r11.length >= 5) goto L18;
        r12 = TAG;
        StringBuilder r19 = new StringBuilder();
        String r20 = "Input data len is too short for shared decrypt!! len:";
    L17:
        r14 = r19.append(r20);
        goto L6
    L18:
        r1 = Byte.toUnsignedInt(r11[4]);
        if (r1 == 2) goto L22;
        r12 = TAG;
        r17 = new StringBuilder();
        r18 = "Input cipher data version is wrong for shared decrypt! version:";
        goto L13
    L22:
        if (r11.length >= 17) goto L24;
        r12 = TAG;
        r19 = new StringBuilder();
        r20 = "Input data len is too short for iv for shared decrypt! len:";
        goto L17
    L24:
        byte[] r5 = new byte[12];
        System.arraycopy(r11, 5, r5, 0, 12);
        byte[] r2 = new byte[4];
        System.arraycopy(r11, 17, r2, 0, 4);
        int r3 = CryptoUtils.byteArrayToInt(r2);
        int r4 = r3 + 21;
        if (r11.length >= r4) goto L27;
        r12 = TAG;
        r13 = new StringBuilder();
        goto L5
    L27:
        byte[] r21 = new byte[r3];
        System.arraycopy(r11, 21, r21, 0, r3);
        if (TextUtils.equals(r9, CryptoConst.ALGORITHM_CHACHA20) == false) goto L30;
        int r22 = 0;
    L32:
        if (r11.length >= (r22 + r4)) goto L34;
        r12 = TAG;
        r19 = new StringBuilder();
        r20 = "Input data len is too short for data cipher shared decrypt! len:";
        goto L17
    L34:
        int r23 = r11.length - r4;
        byte[] r24 = new byte[r23];
        System.arraycopy(r11, r4, r24, 0, r23);
        byte[] r25 = PlatKeyManager.getInstance().decryptByPlatformKey(r6, r21);
        if (r25 != null) goto L37;
    L49:
        r12 = TAG;
        r16 = "Data key decrypt for shared decrypt failed!!";
        goto L8
    L37:
        if (r25.length == 0) goto L49;
        if (TextUtils.equals(r9, CryptoConst.ALGORITHM_AES) == false) goto L42;
        byte[] r26 = AES.gcmXcrypt(r8, r25, r10.getBytes(), r5, r24);
    L43:
        if (r26 != null) goto L45;
    L48:
        r12 = TAG;
        r16 = "Data decrypt failed for shared decrypt!!";
        goto L8
    L45:
        if (r26.length == 0) goto L48;
        return r26;
    L42:
        r26 = ChaCha20.xcryptBytes(r8, r9, r25, r5, r24);
        goto L43
    L30:
        r22 = 16;
        goto L32
    }

    private byte[] bytesSharedEncrypt(Context r5, int r6, String r7, String r8, byte[] r9) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        byte[] r10 = CryptoUtils.generateSecureRandom(32);
        if (r10.length != 0) goto L7;
        String r11 = TAG;
        String r12 = "Generate data key for shared encrypt failed!!";
    L5:
        LogUtils.e(r11, r12);
        return new byte[0];
    L7:
        byte[] r2 = CryptoUtils.generateSecureRandom(12);
        if (r2.length != 0) goto L11;
        r11 = TAG;
        r12 = "Generate IV for shared encrypt failed!!";
        goto L5
    L11:
        if (TextUtils.equals(r7, CryptoConst.ALGORITHM_AES) == false) goto L13;
        byte[] r13 = AES.gcmXcrypt(r6, r10, r8.getBytes(), r2, r9);
    L14:
        if (r13 != null) goto L16;
    L26:
        r11 = TAG;
        r12 = "Data encrypt for shared encrypt failed!!";
        goto L5
    L16:
        if (r13.length == 0) goto L26;
        byte[] r14 = PlatKeyManager.getInstance().encryptByPlatformKey(r4, r10);
        if (r14 != null) goto L21;
    L25:
        r11 = TAG;
        r12 = "Data key encrypt for shared encrypt failed!!";
        goto L5
    L21:
        if (r14.length == 0) goto L25;
        int r15 = r14.length;
        byte[] r16 = new byte[(r14.length + 21) + r13.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_SHARED_MAGIC_NUM), 0, r16, 0, 4);
        r16[4] = 2;
        System.arraycopy(r2, 0, r16, 5, 12);
        System.arraycopy(CryptoUtils.intToBytes(r15), 0, r16, 17, 4);
        System.arraycopy(r14, 0, r16, 21, r15);
        System.arraycopy(r13, 0, r16, r15 + 21, r13.length);
        return r16;
    L13:
        r13 = ChaCha20.xcryptBytes(r6, r7, r10, r2, r9);
        goto L14
    }

    private int checkInputParams(Context r3, int r4, String r5, String r6, byte[] r7) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")) != null) goto L7;
        String r2 = TAG;
        String r8 = "Context is null!!";
    L5:
        LogUtils.e(r2, r8);
        return -2;
    L7:
        if (r7 != null) goto L9;
    L35:
        r2 = TAG;
        r8 = "Input data is empty!!";
        goto L5
    L9:
        if (r7.length == 0) goto L35;
        if (r4 != 1) goto L14;
        int r0 = 1048576;
    L16:
        if (r7.length <= r0) goto L20;
        r2 = TAG;
        StringBuilder r9 = new StringBuilder().append("Input data is too large!! len:").append(r7.length);
    L18:
        r8 = r9.toString();
        goto L5
    L20:
        if (TextUtils.isEmpty(r6) == false) goto L22;
        r2 = TAG;
        r8 = "Input alias is empty!!";
        goto L5
    L22:
        if (r4 == 1) goto L27;
        if (r4 == 2) goto L27;
        r2 = TAG;
        r9 = new StringBuilder().append("Input mode is invalid!! mode:").append(r4);
    L27:
        if (TextUtils.equals(r5, CryptoConst.ALGORITHM_AES) == false) goto L29;
        return 0;
    L29:
        if (TextUtils.equals(r5, CryptoConst.ALGORITHM_CHACHA20_POLY1305) == false) goto L31;
        return 0;
    L31:
        if (TextUtils.equals(r5, CryptoConst.ALGORITHM_CHACHA20) == true) goto L37;
        r2 = TAG;
        r9 = new StringBuilder().append("Input algorithm is invalid!! algorithm:").append(r5);
        goto L18
    L37:
        return 0;
    L14:
        r0 = CryptoConst.DECRYPT_BYTES_MAX_SIZE;
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

    public byte[] bytesXcrypt(int r7, String r8, String r9, byte[] r10) {
        return bytesXcrypt(r7, r8, r9, r10, false);
    }

    public byte[] bytesXcrypt(int r8, String r9, String r10, byte[] r11, boolean r12) {
        if (checkInputParams(this.mContext, r8, r9, r10, r11) == 0) goto L7;
        LogUtils.e(TAG, "Input param is invalid!!");
        return new byte[0];
    L7:
        if (r12 == false) goto L13;
        if (r8 != 1) goto L12;
        return bytesSharedEncrypt(this.mContext, r8, r9, r10, r11);
    L12:
        return bytesSharedDecrypt(this.mContext, r8, r9, r10, r11);
    L13:
        Context r1 = this.mContext;
        if (r8 != 1) goto L18;
        return bytesEncrypt(r1, r8, r9, r10, r11);
    L18:
        return bytesDecrypt(r1, r8, r9, r10, r11);
    }

    public void init(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }
}
