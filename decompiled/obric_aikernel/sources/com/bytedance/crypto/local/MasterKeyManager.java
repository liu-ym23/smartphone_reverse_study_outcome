package com.bytedance.crypto.local;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.obfuscated.h;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class MasterKeyManager {
    private static final String MASTER_KEY_ALIAS = "local_master_key";
    private static final int MASTER_KEY_VERSION = 1;
    public static final String TAG = "MasterKeyManager";
    private static volatile MasterKeyManager keyManager;
    private byte[] localMasterKey;

    public MasterKeyManager() {
        this.localMasterKey = null;
    }

    public static MasterKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(MasterKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new MasterKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MasterKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private boolean isMasterKeyExist(Context r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 0);
        if (j.a().a(r10, MASTER_KEY_ALIAS, r11).f1486a == 0) goto L5;
        return false;
    L5:
        return true;
    }

    private byte[] loadMasterKey(Context r10) {
        if (isMasterKeyExist(r10) == true) goto L5;
        byte[] r11 = CryptoUtils.generateSecureRandom(32);
        if (r11.length != 0) goto L11;
        String r12 = TAG;
        String r13 = "Generate master key failed!!";
    L9:
        LogUtils.e(r12, r13);
        return new byte[0];
    L11:
        i r14 = new i();
        r14.f1493f = CryptoUtils.byteArrayToHexString(r11);
        r14.f1488a = MASTER_KEY_ALIAS;
        r14.f1489b = "local_key";
        if (j.a().a(r10, r14, new Bundle()).f1470a == 0) goto L14;
        r12 = TAG;
        r13 = "Store master key failed!!";
        goto L9
    L14:
        return r11;
    L5:
        return queryMasterKey(r10);
    }

    private byte[] queryMasterKey(Context r10) {
        Bundle r11 = new Bundle();
        r11.putInt("query_mode", 2);
        h r12 = j.a().a(r10, MASTER_KEY_ALIAS, r11);
        if (r12.f1486a == 0) goto L7;
        LogUtils.e(TAG, "Query master key failed!!");
        return new byte[0];
    L7:
        return CryptoUtils.hexStringToByteArray(r12.f1487b.get(0).f1493f);
    }

    public byte[] decryptByMasterKey(Context r10, String r11, byte[] r12) {
        if (this.localMasterKey != null) goto L9;
        byte[] r13 = loadMasterKey(r10);
        this.localMasterKey = r13;
        if (r13 != null) goto L9;
        String r14 = TAG;
        String r15 = "Load master key failed!!";
    L7:
        LogUtils.e(r14, r15);
        return new byte[0];
    L9:
        byte[] r16 = new byte[4];
        if (r12.length >= 4) goto L14;
        r14 = TAG;
        StringBuilder r17 = new StringBuilder();
        r17.append("Input data len is too short! len:");
    L12:
        r17.append(r12.length);
    L13:
        r15 = r17.toString();
        goto L7
    L14:
        System.arraycopy(r12, 0, r16, 0, 4);
        int r18 = CryptoUtils.byteArrayToInt(r16);
        if (r18 == 317657839) goto L18;
        r14 = TAG;
        r17 = new StringBuilder();
        r17.append("Cannot parse input cipher data! magic:");
        r17.append(r18);
        goto L13
    L18:
        if (r12.length >= 5) goto L21;
        r14 = TAG;
        r17 = new StringBuilder();
    L20:
        r17.append("Input data len is too short!! len:");
        goto L12
    L21:
        int r19 = Byte.toUnsignedInt(r12[4]);
        if (r19 == 1) goto L25;
        r14 = TAG;
        r15 = "Input cipher data version is wrong! version:" + r19;
        goto L7
    L25:
        if (r12.length >= 17) goto L27;
        r14 = TAG;
        r17 = new StringBuilder();
        goto L20
    L27:
        byte[] r20 = new byte[12];
        System.arraycopy(r12, 5, r20, 0, 12);
        if (r12.length >= 33) goto L30;
        r14 = TAG;
        r17 = new StringBuilder();
        goto L20
    L30:
        int r21 = r12.length - 17;
        byte[] r22 = new byte[r21];
        System.arraycopy(r12, 17, r22, 0, r21);
        byte[] r23 = AES.gcmXcrypt(2, this.localMasterKey, r11.getBytes(), r20, r22);
        if (r23 != null) goto L33;
    L36:
        r14 = TAG;
        r15 = "Data key decrypt failed!!";
        goto L7
    L33:
        if (r23.length == 0) goto L36;
        return r23;
    }

    public byte[] encryptByMasterKey(Context r10, String r11, byte[] r12) {
        byte[] r13 = this.localMasterKey;
        if (r13 != null) goto L5;
    L6:
        byte[] r14 = loadMasterKey(r10);
        this.localMasterKey = r14;
        if (r14 != null) goto L9;
    L24:
        String r15 = TAG;
        String r16 = "Load master key failed!!";
    L14:
        LogUtils.e(r15, r16);
        return new byte[0];
    L9:
        if (r14.length == 0) goto L24;
    L11:
        byte[] r17 = CryptoUtils.generateSecureRandom(12);
        if (r17.length != 0) goto L16;
        r15 = TAG;
        r16 = "Generate IV failed!!";
        goto L14
    L16:
        byte[] r18 = AES.gcmXcrypt(1, this.localMasterKey, r11.getBytes(), r17, r12);
        if (r18 != null) goto L19;
    L23:
        r15 = TAG;
        r16 = "Data key encrypt failed!!";
        goto L14
    L19:
        if (r18.length == 0) goto L23;
        byte[] r19 = new byte[(r17.length + 5) + r18.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r19, 0, 4);
        r19[4] = 1;
        System.arraycopy(r17, 0, r19, 5, r17.length);
        System.arraycopy(r18, 0, r19, r17.length + 5, r18.length);
        return r19;
    L5:
        if (r13.length != 0) goto L11;
        goto L6
    }
}
