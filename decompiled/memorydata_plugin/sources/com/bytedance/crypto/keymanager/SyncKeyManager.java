package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.account.AccountApi;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.cloudsync.network.SyncKeyData;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SyncKeyManager {
    public static final String TAG = "SyncKeyManager";
    private static volatile SyncKeyManager keyManager;
    private volatile HashMap<String, Integer> keyVersionMap;

    public SyncKeyManager() {
        this.keyVersionMap = new HashMap();
    }

    private String buildKeyAlias(String r1, int r2) {
        return r1 + "_" + r2;
    }

    private String buildVersionMapKey(String r2) {
        return r2 + "_" + getCurrentUid();
    }

    private String getCurrentUid() {
        return AccountApi.INSTANCE.getUserId();
    }

    public static SyncKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(SyncKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new SyncKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SyncKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    private synchronized int importToVersionMap(Context r8, List<SyncKeyData> r9) {
        monitor-enter(this);
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Iterator r11 = ((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
        boolean r0 = false;
    L5:
        if (r11.hasNext() == false) goto L13;
        SyncKeyData r1 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r11.next(), SyncKeyData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        String r2 = buildVersionMapKey(r1.getAppId());     // Catch: Throwable -> L17
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r2), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r3 == null) goto L12;
        if (r1.getKeyVersion() > r3.intValue()) goto L12;
        LogUtils.i(TAG, "Key info exist, no need to update. key:" + r2 + " localVersion:" + r3 + " incomingVersion:" + r1.getKeyVersion());     // Catch: Throwable -> L17
    L12:
        this.keyVersionMap.put(r2, Integer.valueOf(r1.getKeyVersion()));     // Catch: Throwable -> L17
        r0 = true;
        LogUtils.i(TAG, "updateVersionMap trigger, reason:importToVersionMap, key:" + r2);     // Catch: Throwable -> L17
        goto L5
    L13:
        if (r0 == true) goto L15;
        LogUtils.i(TAG, "Key info exist, no need to update.");     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    private int preHandleForXcrypt(Context r3, String r4, byte[] r5, String r6) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")) != null) goto L5;
    L22:
        String r2 = TAG;
        String r7 = "Input param is empty!!";
    L20:
        LogUtils.e(r2, r7);
        return -2;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L22;
        if (TextUtils.isEmpty(r6) == true) goto L22;
        if (r5 != null) goto L11;
    L19:
        r2 = TAG;
        r7 = "Input data is empty!!";
        goto L20
    L11:
        if (r5.length == 0) goto L19;
        if (this.keyVersionMap.containsKey(buildVersionMapKey(r4)) == true) goto L17;
        LogUtils.e(TAG, "AppId not found in key version map!! appId:" + r4);
        return -5;
    L17:
        return 0;
    }

    public byte[] decryptByKeyManager(Context r9, String r10, byte[] r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r0 = TAG;
        LogUtils.i(r0, "Decrypt enter, appId:" + r10);
        LogUtils.d(r0, "Decrypt enter, aad:" + r12);
        if (preHandleForXcrypt(r13, r10, r11, r12) == 0) goto L6;
        LogUtils.e(r0, "Pre handle for Decrypt failed!!");
        return new byte[0];
    L6:
        byte[] r4 = new byte[4];
        if (r11.length >= 4) goto L10;
        LogUtils.e(r0, "Input data len is too short! len:" + r11.length);
        return new byte[0];
    L10:
        System.arraycopy(r11, 0, r4, 0, 4);
        int r5 = CryptoUtils.byteArrayToInt(r4);
        if (r5 == 317657839) goto L15;
        LogUtils.e(r0, "Cannot parse input cipher data! magic:" + r5);
        return new byte[0];
    L15:
        if (r11.length >= 5) goto L18;
        LogUtils.e(r0, "Input data len is too short!! len:" + r11.length);
        return new byte[0];
    L18:
        int r2 = Byte.toUnsignedInt(r11[4]);
        String r6 = buildVersionMapKey(r10);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        LogUtils.e(r0, "Decrypt failed, key version not found!! appId:" + r10);
        return new byte[0];
    L23:
        if (r2 <= r1.intValue()) goto L26;
        LogUtils.e(r0, "Input cipher data version is wrong! version:" + r2);
        return new byte[0];
    L26:
        LogUtils.i(r0, "Decrypt enter, keyVersion:" + r2);
        if (r11.length >= 21) goto L30;
        LogUtils.e(r0, "Input data len is too short for data cipher! len:" + r11.length);
        return new byte[0];
    L30:
        int r14 = r11.length - 5;
        byte[] r3 = new byte[r14];
        System.arraycopy(r11, 5, r3, 0, r14);
        Bundle r15 = new Bundle();
        r15.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r12);
        r15.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), buildKeyAlias(r6, r2));
        FrameworkSecurityCompat.KmResult r8 = FrameworkSecurityCompat.xcrypt(r13, 1, r3, r15);
        if (r8.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L34;
        LogUtils.e(r0, "Decrypt failed, error code:" + r8.getResultCode());
        return new byte[0];
    L34:
        LogUtils.i(r0, "Decrypt succeed, out data len:" + r8.getOutData().length);
        return r8.getOutData();
    }

    public int deleteSyncKey(Context r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
    L25:
        LogUtils.e(TAG, "Input param is empty!!");
        return -2;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L25;
        LogUtils.i(TAG, "delete sync key start, appId:" + r13);
        Iterator<Map.Entry<String, Integer>> r0 = this.keyVersionMap.entrySet().iterator();
        boolean r4 = false;
    L9:
        if (r0.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");
        if (r6.startsWith(r13 + "_") == false) goto L9;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r5.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L14:
        if (r7 < 1) goto L20;
        String r8 = buildKeyAlias(r6, r7);
        int r9 = FrameworkSecurityCompat.deleteSyncKey(r14, r8);
        LogUtils.i(TAG, "delete sync key, keyAlias:" + r8 + " package:" + r14.getPackageName() + " ret:" + r9);
        if (r9 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L17;
        r7 = r7 - 1;
        goto L14
    L17:
        return -100;
    L20:
        r0.remove();
        LogUtils.i(TAG, "removeFromVersionMap trigger, reason:deleteSyncKey, key:" + r6);
        r4 = true;
        goto L9
    L21:
        if (r4 == true) goto L24;
        LogUtils.e(TAG, "Key version map find app failed!! appId:" + r13);
        return -5;
    L24:
        return 0;
    }

    public byte[] encryptByKeyManager(Context r7, String r8, byte[] r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        String r0 = TAG;
        LogUtils.i(r0, "Encrypt enter, keyAlias:" + r8);
        LogUtils.d(r0, "Encrypt enter, aad:" + r10);
        if (preHandleForXcrypt(r11, r8, r9, r10) == 0) goto L7;
        String r6 = "Pre handle for Encrypt failed!!";
    L5:
        LogUtils.e(r0, r6);
        return new byte[0];
    L7:
        Bundle r2 = new Bundle();
        r2.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r10);
        String r12 = buildVersionMapKey(r8);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.keyVersionMap.get(r12), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
        StringBuilder r13 = new StringBuilder().append("Encrypt failed, key version not found!! appId:").append(r8);
    L10:
        r6 = r13.toString();
        goto L5
    L11:
        LogUtils.i(r0, "Encrypt enter, keyVersion:" + r1);
        r2.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), buildKeyAlias(r12, r1.intValue()));
        FrameworkSecurityCompat.KmResult r14 = FrameworkSecurityCompat.xcrypt(r11, 0, r9, r2);
        if (r14.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L14;
        r13 = new StringBuilder().append("Encrypt failed, error code:").append(r14.getResultCode());
        goto L10
    L14:
        LogUtils.i(r0, "Encrypt succeed, out data len:" + r14.getOutData().length);
        byte[] r15 = new byte[r14.getOutData().length + 5];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r15, 0, 4);
        r15[4] = r1.byteValue();
        System.arraycopy(r14.getOutData(), 0, r15, 5, r14.getOutData().length);
        return r15;
    }

    public boolean importSyncKey(Context r9, List<SyncKeyData> r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List<SyncKeyData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L28:
        LogUtils.e(TAG, "Input param is empty!!");
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L28;
        if (TextUtils.isEmpty(r12) == true) goto L28;
        if (r14 != null) goto L11;
    L26:
        LogUtils.e(TAG, "Key data list is empty!!");
        return false;
    L11:
        if (r14.isEmpty() == true) goto L26;
        Iterator<SyncKeyData> r2 = r14.iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        SyncKeyData r3 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r2.next(), SyncKeyData.class, "com.obric.memorydata.plugin");
        Bundle r4 = new Bundle();
        String r5 = TAG;
        LogUtils.i(r5, "Import key enter, appid:" + r3.getAppId() + " key version:" + r3.getKeyVersion());
        LogUtils.d(r5, "Import key enter, attKeyAlias:" + r12);
        LogUtils.d(r5, "Import key enter, serverPubKey:" + r11);
        LogUtils.d(r5, "Import key enter, SyncKeyCipher:" + r3.getSyncKeyCipher());
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), buildKeyAlias(buildVersionMapKey(r3.getAppId()), r3.getKeyVersion()));
        r4.putString("attest_key_alias", r12);
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r11);
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r3.getSyncKeyCipher());
        String r6 = CloudConfig.getInstance().getPkgName(r3.getAppId());
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r6);
        LogUtils.d(r5, "Import key enter, aad:" + r6);
        int r7 = FrameworkSecurityCompat.importKey(r13, r4);
        if (r7 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L15;
        LogUtils.e(r5, "Import key failed, error code:" + r7);
        return false;
    L21:
        if (importToVersionMap(r13, r14) == 0) goto L24;
        LogUtils.e(TAG, "Update version map failed!!");
        return false;
    L24:
        return true;
    }

    public boolean importSyncKeyLegacy(Context r9, List<SyncKeyData> r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List<SyncKeyData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L28:
        LogUtils.e(TAG, "Input param is empty!! legacy.");
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L28;
        if (TextUtils.isEmpty(r12) == true) goto L28;
        if (r14 != null) goto L11;
    L26:
        LogUtils.e(TAG, "Key data list is empty!! legacy.");
        return false;
    L11:
        if (r14.isEmpty() == true) goto L26;
        Iterator<SyncKeyData> r2 = r14.iterator();
    L15:
        if (r2.hasNext() == false) goto L21;
        SyncKeyData r3 = (SyncKeyData) ZeusTransformUtils.preCheckCast(r2.next(), SyncKeyData.class, "com.obric.memorydata.plugin");
        Bundle r4 = new Bundle();
        String r5 = TAG;
        LogUtils.i(r5, "Import key legacy enter, appid:" + r3.getAppId() + " key version:" + r3.getKeyVersion());
        LogUtils.d(r5, "Import key enter, localPrivKey:" + r12);
        LogUtils.d(r5, "Import key enter, serverPubKey:" + r11);
        LogUtils.d(r5, "Import key enter, SyncKeyCipher:" + r3.getSyncKeyCipher());
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), buildKeyAlias(buildVersionMapKey(r3.getAppId()), r3.getKeyVersion()));
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PRIVATE_KEY(), r12);
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r11);
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r3.getSyncKeyCipher());
        String r6 = CloudConfig.getInstance().getPkgName(r3.getAppId());
        r4.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r6);
        LogUtils.d(r5, "Import key legacy enter, aad:" + r6);
        int r7 = FrameworkSecurityCompat.importKeyLegacy(r13, r4);
        if (r7 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L15;
        LogUtils.e(r5, "Import key legacy failed, error code:" + r7);
        return false;
    L21:
        if (importToVersionMap(r13, r14) == 0) goto L24;
        LogUtils.e(TAG, "Update version map failed!! legacy.");
        return false;
    L24:
        return true;
    }
}
