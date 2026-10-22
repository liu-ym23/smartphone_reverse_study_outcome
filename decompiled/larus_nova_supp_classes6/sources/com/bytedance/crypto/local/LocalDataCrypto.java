package com.bytedance.crypto.local;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class LocalDataCrypto {
    public static final String TAG = "LocalDataCrypto";
    private static volatile LocalDataCrypto dataCrypto;
    private Context mContext;

    public LocalDataCrypto() {
    }

    private byte[] bytesDecrypt(Context r7, int r8, String r9, String r10, byte[] r11) {
        byte[] r1 = new byte[4];
        if (r11.length >= 4) goto L9;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder("Input data len is too short! len:");
    L5:
        r13.append(r11.length);
    L6:
        String r14 = r13.toString();
    L7:
        LogUtils.e(r12, r14);
        return new byte[0];
    L9:
        System.arraycopy(r11, 0, r1, 0, 4);
        int r2 = CryptoUtils.byteArrayToInt(r1);
        if (r2 == 315429581) goto L13;
        r12 = TAG;
        r13 = new StringBuilder("Cannot parse input cipher data! magic:");
        r13.append(r2);
        goto L6
    L13:
        if (r11.length >= 5) goto L15;
        r12 = TAG;
        r13 = new StringBuilder("Input data len is too short!! len:");
        goto L5
    L15:
        int r0 = r11[4] & 255;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L21;
        r12 = TAG;
        r13 = new StringBuilder("Input cipher data version is wrong! version:");
        r13.append(r0);
    L21:
        if (r11.length >= 17) goto L23;
        r12 = TAG;
        r13 = new StringBuilder("Input data len is too short for iv! len:");
        goto L5
    L23:
        byte[] r4 = new byte[12];
        System.arraycopy(r11, 5, r4, 0, 12);
        if (r11.length >= 82) goto L26;
        r12 = TAG;
        r13 = new StringBuilder("Input data len is too short for key cipher! len:");
        goto L5
    L26:
        byte[] r5 = new byte[65];
        System.arraycopy(r11, 17, r5, 0, 65);
        if (TextUtils.equals(r9, "ChaCha20") == false) goto L29;
        int r3 = 0;
    L31:
        if (r11.length >= (r3 + 82)) goto L33;
        r12 = TAG;
        r13 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L5
    L33:
        int r6 = r11.length - 82;
        byte[] r15 = new byte[r6];
        System.arraycopy(r11, 82, r15, 0, r6);
        String r16 = r7.getPackageName() + r10;
        byte[] r17 = MasterKeyManager.getInstance().decryptByMasterKey(r7, r16, r5);
        if (r17 != null) goto L36;
    L48:
        r12 = TAG;
        r14 = "Data key decrypt failed!!";
        goto L7
    L36:
        if (r17.length == 0) goto L48;
        if (TextUtils.equals(r9, "AES") == false) goto L41;
        byte[] r18 = AES.gcmXcrypt(r8, r17, r16.getBytes(), r4, r15);
    L42:
        if (r18 != null) goto L44;
    L47:
        r12 = TAG;
        r14 = "Data decrypt failed!!";
        goto L7
    L44:
        if (r18.length == 0) goto L47;
        return r18;
    L41:
        r18 = ChaCha20.xcryptBytes(r8, r9, r17, r4, r15);
        goto L42
    L29:
        r3 = 16;
        goto L31
    }

    private byte[] bytesEncrypt(Context r7, int r8, String r9, String r10, byte[] r11) {
        byte[] r0 = CryptoUtils.generateSecureRandom(32);
        if (r0.length != 0) goto L8;
        String r12 = TAG;
        String r13 = "Generate data key failed!!";
    L5:
        LogUtils.e(r12, r13);
    L7:
        return new byte[0];
    L8:
        byte[] r3 = CryptoUtils.generateSecureRandom(12);
        if (r3.length != 0) goto L11;
        r12 = TAG;
        r13 = "Generate IV failed!!";
        goto L5
    L11:
        String r14 = r7.getPackageName() + r10;
        if (TextUtils.equals(r9, "AES") == false) goto L14;
        byte[] r15 = AES.gcmXcrypt(r8, r0, r14.getBytes(), r3, r11);
    L15:
        if (r15 != null) goto L17;
    L30:
        r12 = TAG;
        r13 = "Data encrypt failed!!";
        goto L5
    L17:
        if (r15.length == 0) goto L30;
        byte[] r16 = MasterKeyManager.getInstance().encryptByMasterKey(r7, r14, r0);
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
        System.arraycopy(CryptoUtils.intToBytes(315429581), 0, r17, 0, 4);
        r17[4] = 2;
        System.arraycopy(r3, 0, r17, 5, 12);
        System.arraycopy(r16, 0, r17, 17, 65);
        System.arraycopy(r15, 0, r17, 82, r15.length);
        return r17;
    L14:
        r15 = ChaCha20.xcryptBytes(r8, r9, r0, r3, r11);
        goto L15
    }

    private int checkInputParams(Context r4, int r5, String r6, String r7, byte[] r8) {
        if (r4 != null) goto L7;
        String r9 = TAG;
        String r10 = "Context is null!!";
    L5:
        LogUtils.e(r9, r10);
        return -2;
    L7:
        if (r8 != null) goto L9;
    L35:
        r9 = TAG;
        r10 = "Input data is empty!!";
        goto L5
    L9:
        if (r8.length == 0) goto L35;
        if (r5 != 1) goto L14;
        int r1 = 1048576;
    L16:
        if (r8.length <= r1) goto L20;
        r9 = TAG;
        StringBuilder r11 = new StringBuilder("Input data is too large!! len:");
        r11.append(r8.length);
    L18:
        r10 = r11.toString();
        goto L5
    L20:
        if (TextUtils.isEmpty(r7) == false) goto L22;
        r9 = TAG;
        r10 = "Input alias is empty!!";
        goto L5
    L22:
        if (r5 == 1) goto L27;
        if (r5 == 2) goto L27;
        r9 = TAG;
        r10 = "Input mode is invalid!! mode:" + r5;
    L27:
        if (TextUtils.equals(r6, "AES") == false) goto L29;
        return 0;
    L29:
        if (TextUtils.equals(r6, "ChaCha20-Poly1305") == false) goto L31;
        return 0;
    L31:
        if (TextUtils.equals(r6, "ChaCha20") == true) goto L37;
        r9 = TAG;
        r11 = new StringBuilder("Input algorithm is invalid!! algorithm:");
        r11.append(r6);
        goto L18
    L37:
        return 0;
    L14:
        r1 = 1048674;
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

    public byte[] bytesXcrypt(int r8, String r9, String r10, byte[] r11) {
        if (checkInputParams(this.mContext, r8, r9, r10, r11) == 0) goto L7;
        LogUtils.e(TAG, "Input param is invalid!!");
        return new byte[0];
    L7:
        if (r8 != 1) goto L11;
        return bytesEncrypt(this.mContext, r8, r9, r10, r11);
    L11:
        return bytesDecrypt(this.mContext, r8, r9, r10, r11);
    }

    public void init(Context r1) {
        this.mContext = r1;
    }
}
