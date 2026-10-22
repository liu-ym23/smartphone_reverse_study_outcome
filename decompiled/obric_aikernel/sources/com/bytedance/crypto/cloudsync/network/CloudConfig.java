package com.bytedance.crypto.cloudsync.network;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CloudConfig {
    private static final String GET_SYNC_KEY_URL = "https://ocean-secret.oceancloudapi.com/api/user/getSyncKeyV2";
    private static final String GET_SYNC_KEY_URL_BOE = "http://ocean-secret-boe.bytedance.net/api/user/getSyncKeyV2";
    private static final String GET_SYNC_KEY_URL_BOE_LEGACY = "http://ocean-secret-boe.bytedance.net/api/user/getSyncKey";
    private static final String GET_SYNC_KEY_URL_LEGACY = "https://ocean-secret.oceancloudapi.com/api/user/getSyncKey";
    private static final String JSON_TAG_APPS = "apps";
    private static final String JSON_TAG_APP_ID = "appid";
    private static final String JSON_TAG_CONTENT = "content";
    private static final String JSON_TAG_PACKAGE = "package";
    private static final String JSON_TAG_SIGNATURE = "signature";
    private static final String JSON_TAG_VERSION = "version";
    private static final int MAX_SIGNATURE_SIZE = 2048;
    private static final int MAX_VERIFY_SRC_DATA_SIZE = 1048576;
    public static final String REQUEST_TYPE_POST = "POST";
    public static final String ROOT_NAME_CLOUD_SYNC = "OCEAN_CLOUD_SYNC";
    private static final String SIGN_PUBLIC_KEY = "3059301306072a8648ce3d020106082a8648ce3d030107034200042a37535f0898cd6bc1d58eeeb0d76f980ce18b144b171f8ed83bf05b0f9df32abe408f1c4d783933d18c18ff65234817bff4cae61374468923424e3face1938b";
    private static final String TAG = "CloudConfig";
    public static final String WHITE_LIST_FILE_NAME = "cloud_sync_white_list.xml";
    private static volatile CloudConfig cloudConfig;
    private static final HashMap<String, String> localAppMap = null;
    private Vector<WhiteListApp> cloudAppList;
    private Context mContext;

    public static class WhiteListApp {
        private String appId;
        private String pkgName;

        public WhiteListApp(String r10, String r11) {
            this.pkgName = r10;
            this.appId = r11;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getPackageName() {
            return this.pkgName;
        }
    }

    static {
        localAppMap = new AnonymousClass1();
    }

    public CloudConfig() {
        this.cloudAppList = new Vector();
    }

    private boolean checkVersionUpdate(String r10, String r11) {
        if (new File(r10).exists() == true) goto L7;
        LogUtils.d(TAG, "cloud_sync_white_list file not exist!! need update file.");
        return true;
    L7:
        if (getWhiteListFileVersion(r10) < getWhiteListDataVersion(r11)) goto L11;
        return false;
    L11:
        return true;
    }

    public static String getGetSyncKeyUrl() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_SYNC_KEY_URL_BOE;
    L6:
        return GET_SYNC_KEY_URL;
    }

    public static String getGetSyncKeyUrlLegacy() {
        if (NetworkConfig.getInstance().isBoeEnv() == false) goto L6;
        return GET_SYNC_KEY_URL_BOE_LEGACY;
    L6:
        return GET_SYNC_KEY_URL_LEGACY;
    }

    public static CloudConfig getInstance() {
        if (cloudConfig != null) goto L15;
        monitor-enter(CloudConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (cloudConfig != null) goto L9;
        cloudConfig = new CloudConfig();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CloudConfig.class);     // Catch: Throwable -> L11
    L15:
        return cloudConfig;
    }

    private int getWhiteListDataVersion(String r10) {
        int r11 = new JSONObject(new JSONObject(r10).getString(JSON_TAG_CONTENT)).getInt(JSON_TAG_VERSION);     // Catch: Exception -> L4 JSONException -> L6
        LogUtils.i(TAG, "WhiteList apps data version:" + r11);     // Catch: Exception -> L4 JSONException -> L6
        return r11;
    L6:
        e = move-exception;
        String r12 = TAG;
        StringBuilder r13 = new StringBuilder();
        r13.append("JSONException error:");
        String r14 = e.getMessage();
    L8:
        r13.append(r14);
        LogUtils.e(r12, r13.toString());
        return 0;
    L4:
        e = move-exception;
        r12 = TAG;
        r13 = new StringBuilder();
        r13.append("Exception error:");
        r14 = e.getMessage();
        goto L8
    }

    private int getWhiteListFileVersion(String r10) {
        FileReader r11 = new FileReader(r10);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        char[] r12 = new char[1024];     // Catch: Throwable -> L12
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L12
    L6:
        int r14 = r11.read(r12);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L9;
        r13.append(r12, 0, r14);     // Catch: Throwable -> L12
        goto L6
    L9:
        int r15 = new JSONObject(new JSONObject(r13.toString()).getString(JSON_TAG_CONTENT)).getInt(JSON_TAG_VERSION);     // Catch: Throwable -> L12
        LogUtils.i(TAG, "WhiteList apps file version:" + r15);     // Catch: Throwable -> L12
        r11.close();     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        return r15;
    L12:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L22:
        e = move-exception;
        String r16 = TAG;
        StringBuilder r17 = new StringBuilder();
        r17.append("Get white list file version failed, IOException error:");
        String r18 = e.getMessage();
    L24:
        r17.append(r18);
        LogUtils.e(r16, r17.toString());
        return 0;
    L20:
        e = move-exception;
        r16 = TAG;
        r17 = new StringBuilder();
        r17.append("Get white list file version failed, JSONException error:");
        r18 = e.getMessage();
    L18:
        e = move-exception;
        r16 = TAG;
        r17 = new StringBuilder();
        r17.append("Get white list file version failed, Exception error:");
        r18 = e.getMessage();
        goto L24
    }

    private synchronized int parseWhiteListApps(String r10) {
        monitor-enter(this);
        JSONObject r11 = new JSONObject(new JSONObject(r10).getString(JSON_TAG_CONTENT));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        int r12 = r11.getInt(JSON_TAG_VERSION);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.i(TAG, "WhiteList apps file version:" + r12);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        Vector r13 = new Vector();     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        JSONArray r14 = new JSONArray(r11.getString(JSON_TAG_APPS));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        int r15 = 0;
    L6:
        if (r15 >= r14.length()) goto L16;
        JSONObject r16 = r14.getJSONObject(r15);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        String r17 = r16.getString("package");     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        String r18 = r16.getString(JSON_TAG_APP_ID);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        if (TextUtils.isEmpty(r17) == true) goto L13;
        if (TextUtils.isEmpty(r18) == true) goto L13;
        r13.add(new WhiteListApp(r17, r18));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.d(TAG, "Cloud WhiteList apps pkgName:" + r17 + " appId:" + r18);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        r15 = r15 + 1;     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
    L13:
        LogUtils.e(TAG, "Parse white list apps failed, pkgName or appId is empty!!");     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        monitor-exit(this);
        return -8;
    L16:
        this.cloudAppList.clear();     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        this.cloudAppList.addAll(r13);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.d(TAG, "WhiteList apps size:" + this.cloudAppList.size());     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        monitor-exit(this);
        return 0;
    L19:
        th = move-exception;
        throw th;
    L24:
        e = move-exception;
        String r19 = TAG;     // Catch: Throwable -> L19
        String r110 = "Parse white list apps failed, JSONException error:" + e.getMessage();     // Catch: Throwable -> L19
    L23:
        LogUtils.e(r19, r110);     // Catch: Throwable -> L19
        monitor-exit(this);
        return -8;
    L21:
        e = move-exception;
        r19 = TAG;     // Catch: Throwable -> L19
        r110 = "Parse white list apps failed, Exception error:" + e.getMessage();     // Catch: Throwable -> L19
        goto L23
    }

    private void readWhiteListFile() {
        String r10 = this.mContext.getFilesDir().getAbsolutePath() + "/" + WHITE_LIST_FILE_NAME;
        String r11 = TAG;
        LogUtils.d(r11, "cloud_sync_white_list file path:" + r10);
        if (new File(r10).exists() == true) goto L46;
        LogUtils.d(r11, "cloud_sync_white_list file not exist!!");
        return;
    L46:
        FileReader r12 = new FileReader(r10);     // Catch: Exception -> L37 IOException -> L40
        char[] r13 = new char[1024];     // Catch: Throwable -> L31
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L31
        int r15 = 0;
    L9:
        int r16 = r12.read(r13);     // Catch: Throwable -> L31
        if (r16 <= 0) goto L17;
        r15 = r15 + r16;     // Catch: Throwable -> L31
        if (r15 > 1048576) goto L13;
        r14.append(r13, 0, r16);     // Catch: Throwable -> L31
        goto L9
    L13:
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r15);     // Catch: Throwable -> L31
        r12.close();     // Catch: Exception -> L37 IOException -> L40
        return;
    L17:
        String r17 = r14.toString();     // Catch: Throwable -> L31
        r12.close();     // Catch: Exception -> L37 IOException -> L40
        if (TextUtils.isEmpty(r17) == false) goto L24;
        LogUtils.e(TAG, "Read whiteList file failed!");
        return;
    L24:
        if (verifyWhiteListData(r17) == 0) goto L28;
        LogUtils.e(TAG, "WhiteList file verify failed!");
        return;
    L28:
        if (parseWhiteListApps(r17) == 0) goto L49;
        LogUtils.e(TAG, "Parse white list apps failed!");
        return;
    L49:
        return;
    L31:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L40
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L40
    L40:
        e = move-exception;
        LogUtils.e(TAG, "Read white list file failed, IOException error:" + e.getMessage());
        return;
    L37:
        e = move-exception;
        LogUtils.e(TAG, "Read white list file failed, Exception error:" + e.getMessage());
    }

    private int verifyWhiteListData(String r10) {
    L24:
        e = move-exception;
        String r11 = TAG;
        StringBuilder r12 = new StringBuilder();
        r12.append("Verify white list data failed, InvalidKeyException error:");
        String r13 = e.getMessage();
    L32:
        r12.append(r13);
        LogUtils.e(r11, r12.toString());
        return -9;
    L28:
        e = move-exception;
        r11 = TAG;
        r12 = new StringBuilder();
        r12.append("Verify white list data failed, NoSuchAlgorithmException error:");
        r13 = e.getMessage();
    L26:
        e = move-exception;
        r11 = TAG;
        r12 = new StringBuilder();
        r12.append("Verify white list data failed, SignatureException error:");
        r13 = e.getMessage();
    L30:
        e = move-exception;
        r11 = TAG;
        r12 = new StringBuilder();
        r12.append("Verify white list data failed, JSONException error:");
        r13 = e.getMessage();
    L22:
        e = move-exception;
        r11 = TAG;
        r12 = new StringBuilder();
        r12.append("Verify white list data failed, Exception error:");
        r13 = e.getMessage();
        goto L32
    L4:
        if (r10.length() <= 1048576) goto L7;
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r10.length());     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L7:
        JSONObject r14 = new JSONObject(r10);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r15 = r14.getString(JSON_TAG_CONTENT);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r16 = r14.getString(JSON_TAG_SIGNATURE);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r17 = TAG;     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.d(r17, "verifyWhiteListData contentStr:" + r15);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.d(r17, "verifyWhiteListData signHash:" + r16);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        byte[] r18 = CryptoUtils.hexStringToByteArray(r16);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        if (r18 != null) goto L10;
    L20:
        LogUtils.e(r17, "Signature parse error! signHash:" + r16);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L10:
        if (r18.length == 0) goto L20;
        if (r18.length <= 2048) goto L16;
        LogUtils.e(r17, "Signature is too large, size:" + r18.length);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L16:
        Signature r19 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        r19.initVerify(CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(SIGN_PUBLIC_KEY)));     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        r19.update(r15.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        boolean r20 = r19.verify(r18);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.i(r17, "WhiteList file signature verify result:" + r20);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        if (r20 == false) goto L35;
        return 0;
    L35:
        return -9;
    }

    private synchronized int writeWhiteListFile(String r10, String r11) {
        monitor-enter(this);
        String r12 = TAG;     // Catch: Throwable -> L21
        LogUtils.i(r12, "cloud_sync_white_list file path:" + r10);     // Catch: Throwable -> L21
        File r13 = new File(r10);     // Catch: Throwable -> L21
        if (r13.exists() == false) goto L24;
        LogUtils.i(r12, "File exist:" + r10 + ", need delete first!!");     // Catch: Throwable -> L21
        r13.delete();     // Catch: Throwable -> L21
    L24:
        FileOutputStream r14 = new FileOutputStream(r10);     // Catch: Exception -> L18 Throwable -> L21
        r14.write(r11.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L12
        r14.flush();     // Catch: Throwable -> L12
        r14.close();     // Catch: Exception -> L18 Throwable -> L21
        int r15 = 0;
    L10:
        monitor-exit(this);
        return r15;
    L12:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18 Throwable -> L21
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 Throwable -> L21
    L18:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L21
        r15 = -100;
    L21:
        th = move-exception;
        throw th;
    }

    public String getAppId(String r10) {
        String r11 = localAppMap.get(r10);
        if (TextUtils.isEmpty(r11) == false) goto L14;
        Iterator<WhiteListApp> r12 = this.cloudAppList.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        WhiteListApp r13 = r12.next();
        if (TextUtils.equals(r10, r13.getPackageName()) == false) goto L6;
        return r13.getAppId();
    L15:
        return r11;
    L14:
        return r11;
    }

    public String getPkgName(String r10) {
        Iterator<String> r11 = localAppMap.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        String r12 = r11.next();
        if (TextUtils.equals(r10, localAppMap.get(r12)) == false) goto L4;
        return r12;
    L8:
        Iterator<WhiteListApp> r13 = this.cloudAppList.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        WhiteListApp r14 = r13.next();
        if (TextUtils.equals(r14.getAppId(), r10) == false) goto L10;
        return r14.getPackageName();
    L15:
        return "";
    }

    public void init(Context r10) {
        this.mContext = r10;
        readWhiteListFile();
    }

    public boolean isWhiteListApp(String r10) {
        boolean r11 = localAppMap.containsValue(r10);
        if (r11 == true) goto L10;
        Iterator<WhiteListApp> r12 = this.cloudAppList.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        if (TextUtils.equals(r12.next().getAppId(), r10) == false) goto L6;
        r11 = true;
    L10:
        return r11;
    }

    public void updateWhiteListApps(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L21:
        LogUtils.e(TAG, "White list file name or data is null!!");
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        if (verifyWhiteListData(r11) == 0) goto L12;
        LogUtils.e(TAG, "Verify white list file failed!!");
        return;
    L12:
        if (checkVersionUpdate(r10, r11) == true) goto L16;
        LogUtils.i(TAG, "No need to update white list file!!");
        return;
    L16:
        if (writeWhiteListFile(r10, r11) == 0) goto L19;
        LogUtils.e(TAG, "Write white list file failed!!");
        return;
    L19:
        int r12 = parseWhiteListApps(r11);
        LogUtils.i(TAG, "White list update result:" + r12);
    }
}
