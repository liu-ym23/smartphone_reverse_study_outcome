package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.cloudsync.network.SyncKeyData;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SyncKeyManager {
    private static final String JSON_TAG_APP_ID = "app_id";
    private static final String JSON_TAG_KEY_INFO_LIST = "key_info_list";
    private static final String JSON_TAG_LATEST_VERSION = "latest_version";
    private static final String KEY_INFO_FILE_NAME = "key_info.xml";
    public static final String TAG = "SyncKeyManager";
    private static volatile SyncKeyManager keyManager;
    private volatile HashMap<String, Integer> keyVersionMap;

    public SyncKeyManager() {
        this.keyVersionMap = new HashMap();
    }

    private synchronized int deleteVersionMap(Context r10) {
        monitor-enter(this);
        String r11 = r10.getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L11
        String r12 = TAG;     // Catch: Throwable -> L11
        LogUtils.d(r12, "key_info file path:" + r11);     // Catch: Throwable -> L11
        File r13 = new File(r11);     // Catch: Throwable -> L11
        if (r13.exists() == true) goto L8;
        LogUtils.e(r12, "File not exist:" + r11 + ", need create!!");     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L8:
        r13.delete();     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L11:
        th = move-exception;
        throw th;
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

    private synchronized int importToVersionMap(Context r10, List<SyncKeyData> r11) {
        monitor-enter(this);
        Iterator<SyncKeyData> r12 = r11.iterator();     // Catch: Throwable -> L20
        boolean r13 = false;
    L5:
        if (r12.hasNext() == false) goto L13;
        SyncKeyData r14 = r12.next();     // Catch: Throwable -> L20
        if (this.keyVersionMap.containsKey(r14.getAppId()) == false) goto L11;
        if (r14.getKeyVersion() <= this.keyVersionMap.get(r14.getAppId()).intValue()) goto L5;
        this.keyVersionMap.replace(r14.getAppId(), Integer.valueOf(r14.getKeyVersion()));     // Catch: Throwable -> L20
    L12:
        r13 = true;
        goto L5
    L11:
        this.keyVersionMap.put(r14.getAppId(), Integer.valueOf(r14.getKeyVersion()));     // Catch: Throwable -> L20
        goto L12
    L13:
        if (r13 == false) goto L17;
        int r15 = writeVersionMap(r10);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r15;
    L17:
        LogUtils.i(TAG, "Key info exist, no need to update.");     // Catch: Throwable -> L20
        monitor-exit(this);
        return 0;
    L20:
        th = move-exception;
        throw th;
    }

    private int preHandleForXcrypt(Context r10, String r11, byte[] r12, String r13) {
        if (r10 != null) goto L5;
    L24:
        String r14 = TAG;
        String r15 = "Input param is empty!!";
    L22:
        LogUtils.e(r14, r15);
        return -2;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L24;
        if (TextUtils.isEmpty(r13) == true) goto L24;
        if (r12 != null) goto L11;
    L21:
        r14 = TAG;
        r15 = "Input data is empty!!";
        goto L22
    L11:
        if (r12.length == 0) goto L21;
        if (this.keyVersionMap.isEmpty() == false) goto L19;
        int r16 = readVersionMap(r10);
        if (r16 == 0) goto L25;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r16);
        return r16;
    L25:
        return 0;
    L19:
        return 0;
    }

    private synchronized int readVersionMap(Context r10) {
        monitor-enter(this);
        String r11 = r10.getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L38
        String r12 = TAG;     // Catch: Throwable -> L38
        LogUtils.d(r12, "key_info file path:" + r11);     // Catch: Throwable -> L38
        if (new File(r11).exists() == true) goto L44;
        LogUtils.e(r12, "file not exist:" + r11);     // Catch: Throwable -> L38
        int r13 = -5;
    L7:
        monitor-exit(this);
        return r13;
    L44:
        FileInputStream r14 = new FileInputStream(r11);     // Catch: Exception -> L35 Throwable -> L38
        byte[] r15 = new byte[4096];     // Catch: Throwable -> L29
        r14.read(r15);     // Catch: Throwable -> L29
        JSONArray r16 = new JSONArray(new JSONObject(new String(r15, StandardCharsets.UTF_8)).getString(JSON_TAG_KEY_INFO_LIST));     // Catch: Throwable -> L29
        int r17 = 0;
    L13:
        if (r17 >= r16.length()) goto L21;
        JSONObject r18 = r16.getJSONObject(r17);     // Catch: Throwable -> L29
        String r19 = r18.getString(JSON_TAG_APP_ID);     // Catch: Throwable -> L29
        int r20 = r18.getInt(JSON_TAG_LATEST_VERSION);     // Catch: Throwable -> L29
        if (this.keyVersionMap.containsKey(r19) == true) goto L17;
        this.keyVersionMap.put(r19, Integer.valueOf(r20));     // Catch: Throwable -> L29
    L20:
        r17 = r17 + 1;     // Catch: Throwable -> L29
        goto L13
    L17:
        if (r20 <= this.keyVersionMap.get(r19).intValue()) goto L20;
        this.keyVersionMap.replace(r19, Integer.valueOf(r20));     // Catch: Throwable -> L29
        goto L20
    L21:
        Iterator<String> r21 = this.keyVersionMap.keySet().iterator();     // Catch: Throwable -> L29
    L22:
        if (r21.hasNext() == false) goto L26;
        String r22 = r21.next();     // Catch: Throwable -> L29
        LogUtils.i(TAG, "keyVersionMap key:" + r22 + " version:" + this.keyVersionMap.get(r22));     // Catch: Throwable -> L29
        goto L22
    L26:
        r14.close();     // Catch: Exception -> L35 Throwable -> L38
        monitor-exit(this);
        return 0;
    L29:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L35 Throwable -> L38
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L35 Throwable -> L38
    L35:
        e = move-exception;
        LogUtils.e(TAG, "Parse key_info file failed, error:" + e.getMessage());     // Catch: Throwable -> L38
        r13 = -100;
    L38:
        th = move-exception;
        throw th;
    }

    private synchronized int removeFromVersionMap(Context r10, String r11) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.keyVersionMap.containsKey(r11) == true) goto L9;
        LogUtils.e(TAG, "AppId not in version map!! appId:" + r11);     // Catch: Throwable -> L17
        monitor-exit(this);
        return -5;
    L9:
        this.keyVersionMap.remove(r11);     // Catch: Throwable -> L17
        if (this.keyVersionMap.isEmpty() == false) goto L14;
        int r12 = deleteVersionMap(r10);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r12;
    L14:
        int r13 = writeVersionMap(r10);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r13;
    }

    private String versionMapToJson() {
        if (this.keyVersionMap.isEmpty() == false) goto L15;
        LogUtils.e(TAG, "Key version map is empty!!!");
        return "";
    L15:
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L12
        Iterator<String> r11 = this.keyVersionMap.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();     // Catch: Exception -> L12
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L12
        r13.put(JSON_TAG_APP_ID, r12);     // Catch: Exception -> L12
        r13.put(JSON_TAG_LATEST_VERSION, this.keyVersionMap.get(r12));     // Catch: Exception -> L12
        r10.put(r13);     // Catch: Exception -> L12
        goto L8
    L10:
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L12
        r14.put(JSON_TAG_KEY_INFO_LIST, r10);     // Catch: Exception -> L12
        return r14.toString();
    L12:
        e = move-exception;
        LogUtils.e(TAG, "Version map to json failed, error:" + e.getMessage());
        return "";
    }

    private synchronized int writeVersionMap(Context r10) {
        monitor-enter(this);
        String r11 = r10.getFilesDir().getAbsolutePath() + "/" + KEY_INFO_FILE_NAME;     // Catch: Throwable -> L22
        String r12 = TAG;     // Catch: Throwable -> L22
        LogUtils.d(r12, "key_info file path:" + r11);     // Catch: Throwable -> L22
        if (new File(r11).exists() == true) goto L6;
        LogUtils.e(r12, "File not exist:" + r11 + ", need create!!");     // Catch: Throwable -> L22
    L6:
        String r13 = versionMapToJson();     // Catch: Throwable -> L22
        FileOutputStream r14 = new FileOutputStream(r11);     // Catch: Exception -> L19 Throwable -> L22
        r14.write(r13.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L13
        r14.flush();     // Catch: Throwable -> L13
        r14.close();     // Catch: Exception -> L19 Throwable -> L22
        int r15 = 0;
    L11:
        monitor-exit(this);
        return r15;
    L13:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L19 Throwable -> L22
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19 Throwable -> L22
    L19:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L22
        r15 = -100;
    L22:
        th = move-exception;
        throw th;
    }

    public byte[] decryptByKeyManager(Context r10, String r11, byte[] r12, String r13) {
        String r14 = TAG;
        LogUtils.i(r14, "Decrypt enter, appId:" + r11);
        LogUtils.d(r14, "Decrypt enter, aad:" + r13);
        if (preHandleForXcrypt(r10, r11, r12, r13) == 0) goto L6;
        LogUtils.e(r14, "Pre handle for Decrypt failed!!");
        return new byte[0];
    L6:
        byte[] r15 = new byte[4];
        if (r12.length >= 4) goto L10;
        LogUtils.e(r14, "Input data len is too short! len:" + r12.length);
        return new byte[0];
    L10:
        System.arraycopy(r12, 0, r15, 0, 4);
        int r16 = CryptoUtils.byteArrayToInt(r15);
        if (r16 == 317657839) goto L15;
        LogUtils.e(r14, "Cannot parse input cipher data! magic:" + r16);
        return new byte[0];
    L15:
        if (r12.length >= 5) goto L18;
        LogUtils.e(r14, "Input data len is too short!! len:" + r12.length);
        return new byte[0];
    L18:
        int r17 = Byte.toUnsignedInt(r12[4]);
        if (r17 <= this.keyVersionMap.get(r11).intValue()) goto L22;
        LogUtils.e(r14, "Input cipher data version is wrong! version:" + r17);
        return new byte[0];
    L22:
        LogUtils.i(r14, "Decrypt enter, keyVersion:" + r17);
        if (r12.length >= 21) goto L26;
        LogUtils.e(r14, "Input data len is too short for data cipher! len:" + r12.length);
        return new byte[0];
    L26:
        int r18 = r12.length - 5;
        byte[] r19 = new byte[r18];
        System.arraycopy(r12, 5, r19, 0, r18);
        Bundle r20 = new Bundle();
        r20.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r13);
        r20.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r11 + "_" + r17);
        FrameworkSecurityCompat.KmResult r21 = FrameworkSecurityCompat.xcrypt(r10, 1, r19, r20);
        if (r21.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L30;
        LogUtils.e(r14, "Decrypt failed, error code:" + r21.getResultCode());
        return new byte[0];
    L30:
        LogUtils.i(r14, "Decrypt succeed, out data len:" + r21.getOutData().length);
        return r21.getOutData();
    }

    public int deleteSyncKey(Context r10, String r11) {
        if (r10 != null) goto L4;
    L27:
        LogUtils.e(TAG, "Input param is empty!!");
        return -2;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L27;
        if (this.keyVersionMap.isEmpty() == false) goto L12;
        int r12 = readVersionMap(r10);
        if (r12 == 0) goto L12;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r12);
        return r12;
    L12:
        boolean r13 = true;
        if (this.keyVersionMap.containsKey(r11) == false) goto L22;
        int r14 = this.keyVersionMap.get(r11).intValue();
    L15:
        if (r14 < 1) goto L20;
        String r15 = r11 + "_" + r14;
        int r16 = FrameworkSecurityCompat.deleteSyncKey(r10, r15);
        LogUtils.i(TAG, "delete sync key, keyAlias:" + r15 + " package:" + r10.getPackageName() + " ret:" + r16);
        if (r16 != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L18;
        r14 = r14 - 1;
        goto L15
    L18:
        r13 = false;
    L20:
        if (r13 == false) goto L23;
        removeFromVersionMap(r10, r11);
    L23:
        if (r13 == true) goto L31;
        return -100;
    L31:
        return 0;
    L22:
        LogUtils.e(TAG, "Key version map find app failed!! appId:" + r11);
        goto L23
    }

    public byte[] encryptByKeyManager(Context r10, String r11, byte[] r12, String r13) {
        String r14 = TAG;
        LogUtils.i(r14, "Encrypt enter, keyAlias:" + r11);
        LogUtils.d(r14, "Encrypt enter, aad:" + r13);
        if (preHandleForXcrypt(r10, r11, r12, r13) == 0) goto L7;
        String r15 = "Pre handle for Encrypt failed!!";
    L5:
        LogUtils.e(r14, r15);
        return new byte[0];
    L7:
        Bundle r16 = new Bundle();
        r16.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r13);
        int r17 = this.keyVersionMap.get(r11).intValue();
        LogUtils.i(r14, "Encrypt enter, keyVersion:" + r17);
        r16.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r11 + "_" + r17);
        FrameworkSecurityCompat.KmResult r18 = FrameworkSecurityCompat.xcrypt(r10, 0, r12, r16);
        if (r18.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L10;
        r15 = "Encrypt failed, error code:" + r18.getResultCode();
        goto L5
    L10:
        LogUtils.i(r14, "Encrypt succeed, out data len:" + r18.getOutData().length);
        byte[] r19 = new byte[r18.getOutData().length + 5];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_KEY_CIPHER_MAGIC_NUM), 0, r19, 0, 4);
        r19[4] = (byte) r17;
        System.arraycopy(r18.getOutData(), 0, r19, 5, r18.getOutData().length);
        return r19;
    }

    public boolean importSyncKey(Context r10, List<SyncKeyData> r11, String r12, String r13) {
        if (r10 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!!");
        return false;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L36;
        if (TextUtils.isEmpty(r13) == true) goto L36;
        if (r11 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!!");
        return false;
    L11:
        if (r11.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r14 = readVersionMap(r10);
        if (r14 == 0) goto L21;
        if (r14 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!! errorCode:" + r14);
        return false;
    L21:
        Iterator<SyncKeyData> r15 = r11.iterator();
    L23:
        if (r15.hasNext() == false) goto L29;
        SyncKeyData r16 = r15.next();
        Bundle r17 = new Bundle();
        String r18 = TAG;
        LogUtils.i(r18, "Import key enter, appid:" + r16.getAppId() + " key version:" + r16.getKeyVersion());
        LogUtils.d(r18, "Import key enter, attKeyAlias:" + r13);
        LogUtils.d(r18, "Import key enter, serverPubKey:" + r12);
        LogUtils.d(r18, "Import key enter, SyncKeyCipher:" + r16.getSyncKeyCipher());
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r16.getAppId() + "_" + r16.getKeyVersion());
        r17.putString("attest_key_alias", r13);
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r12);
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r16.getSyncKeyCipher());
        String r19 = CloudConfig.getInstance().getPkgName(r16.getAppId());
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r19);
        LogUtils.d(r18, "Import key enter, aad:" + r19);
        int r20 = FrameworkSecurityCompat.importKey(r10, r17);
        if (r20 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r18, "Import key failed, error code:" + r20);
        return false;
    L29:
        if (importToVersionMap(r10, r11) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!!");
        return false;
    L32:
        return true;
    }

    public boolean importSyncKeyLegacy(Context r10, List<SyncKeyData> r11, String r12, String r13) {
        if (r10 != null) goto L5;
    L36:
        LogUtils.e(TAG, "Input param is empty!! legacy.");
        return false;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L36;
        if (TextUtils.isEmpty(r13) == true) goto L36;
        if (r11 != null) goto L11;
    L34:
        LogUtils.e(TAG, "Key data list is empty!! legacy.");
        return false;
    L11:
        if (r11.isEmpty() == true) goto L34;
        if (this.keyVersionMap.isEmpty() == false) goto L21;
        int r14 = readVersionMap(r10);
        if (r14 == 0) goto L21;
        if (r14 == (-5)) goto L21;
        LogUtils.e(TAG, "Read version map failed!!  legacy errorCode:" + r14);
        return false;
    L21:
        Iterator<SyncKeyData> r15 = r11.iterator();
    L23:
        if (r15.hasNext() == false) goto L29;
        SyncKeyData r16 = r15.next();
        Bundle r17 = new Bundle();
        String r18 = TAG;
        LogUtils.i(r18, "Import key legacy enter, appid:" + r16.getAppId() + " key version:" + r16.getKeyVersion());
        LogUtils.d(r18, "Import key enter, localPrivKey:" + r13);
        LogUtils.d(r18, "Import key enter, serverPubKey:" + r12);
        LogUtils.d(r18, "Import key enter, SyncKeyCipher:" + r16.getSyncKeyCipher());
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.KEY_ALIAS(), r16.getAppId() + "_" + r16.getKeyVersion());
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PRIVATE_KEY(), r13);
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.ECC_PUBLIC_KEY(), r12);
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.WRAPPED_KEY_DATA(), r16.getSyncKeyCipher());
        String r19 = CloudConfig.getInstance().getPkgName(r16.getAppId());
        r17.putString(FrameworkSecurityCompat.KeyManagerConst.ADDITIONAL_DATA(), r19);
        LogUtils.d(r18, "Import key legacy enter, aad:" + r19);
        int r20 = FrameworkSecurityCompat.importKeyLegacy(r10, r17);
        if (r20 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L23;
        LogUtils.e(r18, "Import key legacy failed, error code:" + r20);
        return false;
    L29:
        if (importToVersionMap(r10, r11) == 0) goto L32;
        LogUtils.e(TAG, "Update version map failed!! legacy.");
        return false;
    L32:
        return true;
    }
}
