package com.bytedance.crypto.cloudsync.network;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.KeyDistributionManager;
import com.bytedance.crypto.cloudsync.account.AccountApi;
import com.bytedance.crypto.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.r;
import okhttp3.u;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    private NetworkResponse buildNetworkResponse(String r10) {
        int r11 = getResponseCode(r10);
        String r12 = getResponseMsg(r10);
        List<SyncKeyData> r13 = new ArrayList();
        String r14 = "";
        if (r11 < 200) goto L11;
        if (r11 >= 300) goto L11;
        r14 = getServerPubKey(r10);     // Catch: Exception -> L8
        r13 = getKeyDataList(r10);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        LogUtils.e(TAG, "buildNetworkResponse exception:" + e.getMessage());
    L11:
        return new NetworkResponse(r11, r12, r13, r14);
    }

    private String buildRequestBody(NetworkRequest r10, boolean r11) {
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L11
        r12.put(JSON_TAG_SOURCE_NAME, r10.getRootKeyName());     // Catch: Exception -> L11
        JSONArray r13 = new JSONArray();     // Catch: Exception -> L11
        Iterator<String> r14 = r10.getAppList().iterator();     // Catch: Exception -> L11
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.put(r14.next());     // Catch: Exception -> L11
        goto L4
    L6:
        r12.put(JSON_TAG_APPS, r13);     // Catch: Exception -> L11
        if (r11 == false) goto L9;
        r12.put(JSON_TAG_PUBLIC_KEY, r10.getPublicKey());     // Catch: Exception -> L11
    L9:
        String r15 = r12.toString();     // Catch: Exception -> L11
    L13:
        LogUtils.d(TAG, "buildRequestBody:" + r15);
        return r15;
    L11:
        e = move-exception;
        LogUtils.e(TAG, "buildRequestBody exception:" + e.getMessage());
        r15 = "";
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

    private List<SyncKeyData> getKeyDataList(String r10) {
        ArrayList r11 = new ArrayList();
        JSONArray r12 = new JSONArray(new JSONObject(new JSONObject(r10).getString("data")).getString(JSON_TAG_SYNC_KEY));     // Catch: Exception -> L8
        int r13 = 0;
    L5:
        if (r13 >= r12.length()) goto L10;
        JSONObject r14 = r12.getJSONObject(r13);     // Catch: Exception -> L8
        r11.add(new SyncKeyData(r14.getString(JSON_TAG_APP_ID), r14.getString(JSON_TAG_KEY), r14.getInt(JSON_TAG_VERSION)));     // Catch: Exception -> L8
        r13 = r13 + 1;
    L10:
        return r11;
    L8:
        e = move-exception;
        LogUtils.e(TAG, "getKeyDataList exception:" + e.getMessage());
        goto L10
    }

    private x getRequest(NetworkRequest r10, boolean r11) {
        y r12 = y.c(u.g("application/json"), buildRequestBody(r10, r11));
        Map<String, String> r13 = AccountApi.INSTANCE.getXttTokenMap();
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry<String, String> r15 = r14.next();
        LogUtils.d(TAG, "xttTokenMap entry key:" + r15.getKey() + " value:" + r15.getValue());
        goto L4
    L6:
        r r16 = r.f(r13);
        if (r11 == true) goto L11;
        x.a r17 = new x.a().k(r10.getRequestUrl()).f(r10.getRequestType(), r12).e(r16).a(NetConst.KEY_CONTENT_TYPE, "application/json").a("x-att-certchain", r10.getCertChain());
    L10:
        return r17.b();
    L11:
        r17 = new x.a().k(r10.getRequestUrl()).f(r10.getRequestType(), r12).e(r16).a(NetConst.KEY_CONTENT_TYPE, "application/json");
        goto L10
    }

    private int getResponseCode(String r10) {
        return new JSONObject(r10).getInt(JSON_TAG_CODE);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseCode exception:" + e.getMessage());
        return 400;
    }

    private String getResponseMsg(String r10) {
        return new JSONObject(r10).getString("msg");
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getResponseMsg exception:" + e.getMessage());
        return "";
    }

    private String getServerPubKey(String r10) {
        return new JSONObject(new JSONObject(r10).getString("data")).getString(JSON_TAG_SERVICE_PUBLIC_KEY);
    L4:
        e = move-exception;
        LogUtils.e(TAG, "getServerPubKey exception:" + e.getMessage());
        return "";
    }

    public NetworkResponse callApi(NetworkRequest r10, boolean r11) {
        String r12 = TAG;
        LogUtils.i(r12, "callApi enter");
        if (AccountApi.INSTANCE.isLogin() == true) goto L6;
        LogUtils.e(r12, "Account is not login!!");
        return new NetworkResponse(400, "", new ArrayList(), "");
    L6:
        w r13 = new w();
        x r14 = getRequest(r10, r11);
        LogUtils.d(r12, "Request:" + r14.toString());
        LogUtils.d(r12, "Request body:" + r14.a());
        NetworkResponse r15 = new NetworkResponse(400, "", new ArrayList(), "");
        z r16 = r13.A(r14).execute();     // Catch: Exception -> L13
        if (r16.B() == false) goto L11;
        String r17 = r16.a().l();     // Catch: Exception -> L13
        LogUtils.d(r12, "response:" + r16.toString());     // Catch: Exception -> L13
        LogUtils.d(r12, "response body:" + r17);     // Catch: Exception -> L13
        NetworkResponse r18 = buildNetworkResponse(r17);     // Catch: Exception -> L13
    L17:
        return r18;
    L11:
        LogUtils.i(r12, "newCall failed!! response:" + r16.toString());     // Catch: Exception -> L13
        LogUtils.i(r12, "newCall failed!! response body:" + r16.a().l());     // Catch: Exception -> L13
        r18 = new NetworkResponse(r16.k(), r16.C(), new ArrayList(), "");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        LogUtils.e(TAG, "callApi exception:" + e.getMessage());
        return r15;
    }
}
