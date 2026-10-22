package com.bytedance.crypto.cloudsync.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.network.NetworkConfig;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
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
    private static final String PKG_ST_NOTES = "Y29tLnNtYXJ0aXNhbm9zLm5vdGVz";
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

        public WhiteListApp(String r1, String r2) {
            this.pkgName = r1;
            this.appId = r2;
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

    public static /* synthetic */ String access$000(String r0) {
        return decodePkgName(r0);
    }

    private boolean checkVersionUpdate(String r3, String r4) {
        if (new File(r3).exists() == true) goto L7;
        LogUtils.d(TAG, "cloud_sync_white_list file not exist!! need update file.");
        return true;
    L7:
        if (getWhiteListFileVersion(r3) < getWhiteListDataVersion(r4)) goto L11;
        return false;
    L11:
        return true;
    }

    private static String decodePkgName(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return "";
    L14:
        return new String(Base64.decode(r4, 0), StandardCharsets.UTF_8);
    L10:
        e = move-exception;
        String r0 = TAG;
        StringBuilder r2 = new StringBuilder().append("Decode package name failed, error:");
        String r5 = e.getMessage();
    L12:
        LogUtils.e(r0, r2.append(r5).toString());
        return "";
    L8:
        e = move-exception;
        r0 = TAG;
        r2 = new StringBuilder().append("Decode package name failed, exception:");
        r5 = e.getMessage();
        goto L12
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

    private int getWhiteListDataVersion(String r3) {
        int r2 = new JSONObject(new JSONObject(r3).getString("content")).getInt("version");     // Catch: Exception -> L4 JSONException -> L6
        LogUtils.i(TAG, "WhiteList apps data version:" + r2);     // Catch: Exception -> L4 JSONException -> L6
        return r2;
    L6:
        e = move-exception;
        String r4 = TAG;
        StringBuilder r0 = new StringBuilder().append("JSONException error:");
        String r5 = e.getMessage();
    L8:
        LogUtils.e(r4, r0.append(r5).toString());
        return 0;
    L4:
        e = move-exception;
        r4 = TAG;
        r0 = new StringBuilder().append("Exception error:");
        r5 = e.getMessage();
        goto L8
    }

    private int getWhiteListFileVersion(String r5) {
        FileReader r0 = new FileReader(r5);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        char[] r6 = new char[1024];     // Catch: Throwable -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L12
    L6:
        int r2 = r0.read(r6);     // Catch: Throwable -> L12
        if (r2 <= 0) goto L9;
        r1.append(r6, 0, r2);     // Catch: Throwable -> L12
        goto L6
    L9:
        int r7 = new JSONObject(new JSONObject(r1.toString()).getString("content")).getInt("version");     // Catch: Throwable -> L12
        LogUtils.i(TAG, "WhiteList apps file version:" + r7);     // Catch: Throwable -> L12
        r0.close();     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
        return r7;
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 JSONException -> L20 IOException -> L22
    L22:
        e = move-exception;
        String r3 = TAG;
        StringBuilder r4 = new StringBuilder().append("Get white list file version failed, IOException error:");
        String r8 = e.getMessage();
    L24:
        LogUtils.e(r3, r4.append(r8).toString());
        return 0;
    L20:
        e = move-exception;
        r3 = TAG;
        r4 = new StringBuilder().append("Get white list file version failed, JSONException error:");
        r8 = e.getMessage();
    L18:
        e = move-exception;
        r3 = TAG;
        r4 = new StringBuilder().append("Get white list file version failed, Exception error:");
        r8 = e.getMessage();
        goto L24
    }

    private synchronized int parseWhiteListApps(String r10) {
        monitor-enter(this);
        JSONObject r1 = new JSONObject(new JSONObject(r10).getString("content"));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.i(TAG, "WhiteList apps file version:" + r1.getInt("version"));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        Vector r11 = new Vector();     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        JSONArray r2 = new JSONArray(r1.getString(JSON_TAG_APPS));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        int r3 = 0;
    L6:
        if (r3 >= r2.length()) goto L16;
        JSONObject r4 = r2.getJSONObject(r3);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        String r5 = r4.getString("package");     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        String r6 = r4.getString(JSON_TAG_APP_ID);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        if (TextUtils.isEmpty(r5) == true) goto L13;
        if (TextUtils.isEmpty(r6) == true) goto L13;
        r11.add(new WhiteListApp(r5, r6));     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.d(TAG, "Cloud WhiteList apps pkgName:" + r5 + " appId:" + r6);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        r3 = r3 + 1;     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
    L13:
        LogUtils.e(TAG, "Parse white list apps failed, pkgName or appId is empty!!");     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        monitor-exit(this);
        return -8;
    L16:
        this.cloudAppList.clear();     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        this.cloudAppList.addAll(r11);     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        LogUtils.d(TAG, "WhiteList apps size:" + this.cloudAppList.size());     // Catch: Throwable -> L19 Exception -> L21 JSONException -> L24
        monitor-exit(this);
        return 0;
    L19:
        th = move-exception;
        throw th;
    L24:
        e = move-exception;
        String r7 = TAG;     // Catch: Throwable -> L19
        String r12 = "Parse white list apps failed, JSONException error:" + e.getMessage();     // Catch: Throwable -> L19
    L23:
        LogUtils.e(r7, r12);     // Catch: Throwable -> L19
        monitor-exit(this);
        return -8;
    L21:
        e = move-exception;
        r7 = TAG;     // Catch: Throwable -> L19
        r12 = "Parse white list apps failed, Exception error:" + e.getMessage();     // Catch: Throwable -> L19
        goto L23
    }

    private void readWhiteListFile() {
        String r0 = this.mContext.getFilesDir().getAbsolutePath() + "/" + WHITE_LIST_FILE_NAME;
        String r1 = TAG;
        LogUtils.d(r1, "cloud_sync_white_list file path:" + r0);
        if (new File(r0).exists() == true) goto L46;
        LogUtils.d(r1, "cloud_sync_white_list file not exist!!");
        return;
    L46:
        FileReader r2 = new FileReader(r0);     // Catch: Exception -> L37 IOException -> L40
        char[] r3 = new char[1024];     // Catch: Throwable -> L31
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L31
        int r5 = 0;
    L9:
        int r6 = r2.read(r3);     // Catch: Throwable -> L31
        if (r6 <= 0) goto L17;
        r5 = r5 + r6;     // Catch: Throwable -> L31
        if (r5 > 1048576) goto L13;
        r4.append(r3, 0, r6);     // Catch: Throwable -> L31
        goto L9
    L13:
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r5);     // Catch: Throwable -> L31
        r2.close();     // Catch: Exception -> L37 IOException -> L40
        return;
    L17:
        String r7 = r4.toString();     // Catch: Throwable -> L31
        r2.close();     // Catch: Exception -> L37 IOException -> L40
        if (TextUtils.isEmpty(r7) == false) goto L24;
        LogUtils.e(TAG, "Read whiteList file failed!");
        return;
    L24:
        if (verifyWhiteListData(r7) == 0) goto L28;
        LogUtils.e(TAG, "WhiteList file verify failed!");
        return;
    L28:
        if (parseWhiteListApps(r7) == 0) goto L49;
        LogUtils.e(TAG, "Parse white list apps failed!");
        return;
    L49:
        return;
    L31:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L34
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

    private int verifyWhiteListData(String r5) {
    L24:
        e = move-exception;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("Verify white list data failed, InvalidKeyException error:");
        String r6 = e.getMessage();
    L32:
        LogUtils.e(r0, r1.append(r6).toString());
        return -9;
    L28:
        e = move-exception;
        r0 = TAG;
        r1 = new StringBuilder().append("Verify white list data failed, NoSuchAlgorithmException error:");
        r6 = e.getMessage();
    L26:
        e = move-exception;
        r0 = TAG;
        r1 = new StringBuilder().append("Verify white list data failed, SignatureException error:");
        r6 = e.getMessage();
    L30:
        e = move-exception;
        r0 = TAG;
        r1 = new StringBuilder().append("Verify white list data failed, JSONException error:");
        r6 = e.getMessage();
    L22:
        e = move-exception;
        r0 = TAG;
        r1 = new StringBuilder().append("Verify white list data failed, Exception error:");
        r6 = e.getMessage();
        goto L32
    L4:
        if (r5.length() <= 1048576) goto L7;
        LogUtils.e(TAG, "WhiteList file is too large, size:" + r5.length());     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L7:
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r7 = r2.getString("content");     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r3 = r2.getString(JSON_TAG_SIGNATURE);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        String r4 = TAG;     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.d(r4, "verifyWhiteListData contentStr:" + r7);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.d(r4, "verifyWhiteListData signHash:" + r3);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        byte[] r8 = CryptoUtils.hexStringToByteArray(r3);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        if (r8 != null) goto L10;
    L20:
        LogUtils.e(r4, "Signature parse error! signHash:" + r3);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L10:
        if (r8.length == 0) goto L20;
        if (r8.length <= 2048) goto L16;
        LogUtils.e(r4, "Signature is too large, size:" + r8.length);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        return -9;
    L16:
        Signature r9 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        r9.initVerify(CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(SIGN_PUBLIC_KEY)));     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        r9.update(r7.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        boolean r10 = r9.verify(r8);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        LogUtils.i(r4, "WhiteList file signature verify result:" + r10);     // Catch: Exception -> L22 InvalidKeyException -> L24 SignatureException -> L26 NoSuchAlgorithmException -> L28 JSONException -> L30
        if (r10 == false) goto L35;
        return 0;
    L35:
        return -9;
    }

    private synchronized int writeWhiteListFile(String r5, String r6) {
        monitor-enter(this);
        String r0 = TAG;     // Catch: Throwable -> L21
        LogUtils.i(r0, "cloud_sync_white_list file path:" + r5);     // Catch: Throwable -> L21
        File r1 = new File(r5);     // Catch: Throwable -> L21
        if (r1.exists() == false) goto L27;
        LogUtils.i(r0, "File exist:" + r5 + ", need delete first!!");     // Catch: Throwable -> L21
        r1.delete();     // Catch: Throwable -> L21
    L27:
        FileOutputStream r2 = new FileOutputStream(r5);     // Catch: Exception -> L18 Throwable -> L21
        r2.write(r6.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L12
        r2.flush();     // Catch: Throwable -> L12
        r2.close();     // Catch: Exception -> L18 Throwable -> L21
        int r7 = 0;
    L10:
        monitor-exit(this);
        return r7;
    L12:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Exception -> L18 Throwable -> L21
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18 Throwable -> L21
    L18:
        e = move-exception;
        LogUtils.e(TAG, "Write json data failed, error:" + e.getMessage());     // Catch: Throwable -> L21
        r7 = -100;
    L21:
        th = move-exception;
        throw th;
    }

    public String getAppId(String r5) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(localAppMap.get(r5), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r0) == false) goto L14;
        Iterator<WhiteListApp> r4 = this.cloudAppList.iterator();
    L6:
        if (r4.hasNext() == false) goto L15;
        WhiteListApp r1 = (WhiteListApp) ZeusTransformUtils.preCheckCast(r4.next(), WhiteListApp.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r5, r1.getPackageName()) == false) goto L6;
        return r1.getAppId();
    L15:
        return r0;
    L14:
        return r0;
    }

    public String getPkgName(String r6) {
        Iterator<String> r0 = localAppMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r6, (CharSequence) ZeusTransformUtils.preCheckCast(localAppMap.get(r1), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L4;
        return r1;
    L8:
        Iterator<WhiteListApp> r5 = this.cloudAppList.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        WhiteListApp r2 = (WhiteListApp) ZeusTransformUtils.preCheckCast(r5.next(), WhiteListApp.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r2.getAppId(), r6) == false) goto L10;
        return r2.getPackageName();
    L15:
        return "";
    }

    public void init(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        readWhiteListFile();
    }

    public boolean isWhiteListApp(String r5) {
        boolean r0 = localAppMap.containsValue(r5);
        if (r0 == true) goto L10;
        Iterator<WhiteListApp> r4 = this.cloudAppList.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        if (TextUtils.equals(((WhiteListApp) ZeusTransformUtils.preCheckCast(r4.next(), WhiteListApp.class, "com.obric.memorydata.plugin")).getAppId(), r5) == false) goto L6;
        r0 = true;
    L10:
        return r0;
    }

    public void updateWhiteListApps(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L21:
        LogUtils.e(TAG, "White list file name or data is null!!");
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L21;
        if (verifyWhiteListData(r3) == 0) goto L12;
        LogUtils.e(TAG, "Verify white list file failed!!");
        return;
    L12:
        if (checkVersionUpdate(r2, r3) == true) goto L16;
        LogUtils.i(TAG, "No need to update white list file!!");
        return;
    L16:
        if (writeWhiteListFile(r2, r3) == 0) goto L19;
        LogUtils.e(TAG, "Write white list file failed!!");
        return;
    L19:
        LogUtils.i(TAG, "White list update result:" + parseWhiteListApps(r3));
    }
}
