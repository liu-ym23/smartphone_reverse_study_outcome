package com.bytedance.crypto.cloudsync.network;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.KeyDistributionManager;
import com.bytedance.crypto.cloudsync.account.AccountApi;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkManager {
    private static final String JSON_TAG_APPS = "apps";
    private static final String JSON_TAG_APP_ID = "app_id";
    private static final String JSON_TAG_CODE = "code";
    private static final String JSON_TAG_DATA = "data";
    private static final String JSON_TAG_KEY = "key";
    private static final String JSON_TAG_MSG = "msg";
    private static final String JSON_TAG_PUBLIC_KEY = "public_key";
    private static final String JSON_TAG_SERVICE_PUBLIC_KEY = "service_public_key";
    private static final String JSON_TAG_SOURCE_NAME = "source_name";
    private static final String JSON_TAG_SYNC_KEY = "sync_key";
    private static final String JSON_TAG_VERSION = "version";
    private static final String TAG = "NetworkManager";
    private static volatile NetworkManager networkManager;

    public NetworkManager() {
    }

    private NetworkResponse buildNetworkResponse(String r7) {
        int r0 = getResponseCode(r7);
        String r1 = getResponseMsg(r7);
        List<SyncKeyData> r2 = new ArrayList();
        String r3 = "";
        if (r0 < 200) goto L11;
        if (r0 >= 300) goto L11;
        r3 = getServerPubKey(r7);     // Catch: Exception -> L8
        r2 = getKeyDataList(r7);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        LogUtils.e(TAG, "buildNetworkResponse exception:" + e.getMessage());
    L11:
        return new NetworkResponse(r0, r1, r2, r3);
    }

    private String buildRequestBody(NetworkRequest r6, boolean r7) {
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L11
        r5.put(JSON_TAG_SOURCE_NAME, r6.getRootKeyName());     // Catch: Exception -> L11
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L11
        Iterator<String> r1 = r6.getAppList().iterator();     // Catch: Exception -> L11
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L11
        goto L4
    L6:
        r5.put(JSON_TAG_APPS, r0);     // Catch: Exception -> L11
        if (r7 == false) goto L9;
        r5.put(JSON_TAG_PUBLIC_KEY, r6.getPublicKey());     // Catch: Exception -> L11
    L9:
        String r8 = r5.toString();     // Catch: Exception -> L11
    L13:
        LogUtils.d(TAG, "buildRequestBody:" + r8);
        return r8;
    L11:
        e = move-exception;
        LogUtils.e(TAG, "buildRequestBody exception:" + e.getMessage());
        r8 = "";
        goto L13
    }

    public static NetworkManager getInstance() {
        if (networkManager != null) goto L15;
        monitor-enter(KeyDistributionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (networkManager != null) goto L9;
        networkManager = new NetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(KeyDistributionManager.class);     // Catch: Throwable -> L11
    L15:
        return networkManager;
    }

    private List<SyncKeyData> getKeyDataList(String r6) {
        ArrayList r5 = new ArrayList();
        JSONArray r0 = new JSONArray(new JSONObject(new JSONObject(r6).getString("data")).getString(JSON_TAG_SYNC_KEY));     // Catch: Exception -> L8
        int r7 = 0;
    L5:
        if (r7 >= r0.length()) goto L10;
        JSONObject r1 = r0.getJSONObject(r7);     // Catch: Exception -> L8
        r5.add(new SyncKeyData(r1.getString("app_id"), r1.getString(JSON_TAG_KEY), r1.getInt("version")));     // Catch: Exception -> L8
        r7 = r7 + 1;
    L10:
        return r5;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "getKeyDataList exception:" + e.getMessage());
        goto L10
    }

    private Request getRequest(NetworkRequest r10, boolean r11) {
        RequestBody r9 = RequestBody.create(MediaType.parse("application/json"), buildRequestBody(r10, r11));
        Map<String, String> r1 = AccountApi.INSTANCE.getXttTokenMap();
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        LogUtils.d(TAG, "xttTokenMap entry key:" + ((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")) + " value:" + ((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Headers r4 = Headers.of(r1);
        if (r11 == true) goto L11;
        Request.Builder r12 = new Request.Builder().url(r10.getRequestUrl()).method(r10.getRequestType(), r9).headers(r4).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json").addHeader("x-att-certchain", r10.getCertChain());
    L10:
        return r12.build();
    L11:
        r12 = new Request.Builder().url(r10.getRequestUrl()).method(r10.getRequestType(), r9).headers(r4).addHeader(NetConst.KEY_CONTENT_TYPE, "application/json");
        goto L10
    }

    private int getResponseCode(String r3) {
        return new JSONObject(r3).getInt(JSON_TAG_CODE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception:" + e.getMessage());
        return 400;
    }

    private String getResponseMsg(String r3) {
        return new JSONObject(r3).getString("msg");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseMsg exception:" + e.getMessage());
        return "";
    }

    private String getServerPubKey(String r3) {
        return new JSONObject(new JSONObject(r3).getString("data")).getString(JSON_TAG_SERVICE_PUBLIC_KEY);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getServerPubKey exception:" + e.getMessage());
        return "";
    }

    public NetworkResponse callApi(NetworkRequest r6, boolean r7) {
        String r0 = TAG;
        LogUtils.i(r0, "callApi enter");
        if (AccountApi.INSTANCE.isLogin() == true) goto L6;
        LogUtils.e(r0, "Account is not login!!");
        return new NetworkResponse(400, "", new ArrayList(), "");
    L6:
        OkHttpClient r1 = new OkHttpClient();
        Request r8 = getRequest(r6, r7);
        LogUtils.d(r0, "Request:" + r8.toString());
        LogUtils.d(r0, "Request body:" + r8.body());
        NetworkResponse r9 = new NetworkResponse(400, "", new ArrayList(), "");
        Response r10 = r1.newCall(r8).execute();     // Catch: Exception -> L13
        if (r10.isSuccessful() == false) goto L11;
        String r2 = r10.body().string();     // Catch: Exception -> L13
        LogUtils.d(r0, "response:" + r10.toString());     // Catch: Exception -> L13
        LogUtils.d(r0, "response body:" + r2);     // Catch: Exception -> L13
        NetworkResponse r5 = buildNetworkResponse(r2);     // Catch: Exception -> L13
    L17:
        return r5;
    L11:
        LogUtils.i(r0, "newCall failed!! response:" + r10.toString());     // Catch: Exception -> L13
        LogUtils.i(r0, "newCall failed!! response body:" + r10.body().string());     // Catch: Exception -> L13
        r5 = new NetworkResponse(r10.code(), r10.message(), new ArrayList(), "");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        LogUtils.e(TAG, "callApi exception:" + e.getMessage());
        return r9;
    }
}
