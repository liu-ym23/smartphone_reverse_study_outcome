package com.bytedance.android.live.saas.middleware.network;

import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.BDLiveSdkInternal;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jta.g;
import org.chromium.c;
import org.chromium.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class CronetDependAdapter extends AbsCronetDependAdapter {
    public static CronetDependAdapter INSTANCE = null;
    private static final String TAG = "CronetDependAdapter";
    private static volatile boolean sIsInjectSuccess;

    public void doLoadLibrary(String r1) {
    }

    public String getAppInitialRegionInfo() {
        return null;
    }

    public String getIsDropFirstTnc() {
        return null;
    }

    public String getNetLogUserFilePath() {
        return null;
    }

    public boolean needCustomLoadLibrary() {
        return false;
    }

    public void onEffectiveConnectionTypeChanged(int r1) {
    }

    public void onNetworkQualityLevelChanged(int r1) {
    }

    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
    }

    public void onPublicIPsChanged(List<String> r1, List<String> r2) {
    }

    public void onServerConfigABTestChanged(String r1) {
    }

    public void onUserSpecifyingNetworkEnabled(boolean r1) {
    }

    static {
        INSTANCE = new CronetDependAdapter();
    }

    public String getAbFlag() {
        return BDLiveSdkInternal.getAppContext().getAbFlag() + "";
    }

    public String getBypassBOEJSON() {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        r1.put("pay-boe.snssdk.com");     // Catch: JSONException -> L6
        r1.put("103.25.21.46");     // Catch: JSONException -> L6
        r0.put("bypass_boe_host_list", r1);     // Catch: JSONException -> L6
    L5:
        return r0.toString();
    }

    public String getOpenUdid() {
        HashMap r0 = new HashMap();
        AppLog.g0.g(r0);
        String r1 = (String) r0.get("openudid");
        if (StringUtils.isEmpty(r1) == false) goto L6;
        return "";
    L6:
        return r1;
    }

    public String getSdkVersion() {
        return BDLiveSdkInternal.getAppContext().getVersionCode() + "";
    }

    public String getUpdateVersionCode() {
        return BDLiveSdkInternal.getAppContext().getUpdateVersionCode() + "";
    }

    public String getVersionCode() {
        return BDLiveSdkInternal.getAppContext().getVersionCode() + "";
    }

    public static void tryInject() {
        d r0 = d.a();     // Catch: Throwable -> L4
        r0.a = INSTANCE;     // Catch: Throwable -> L4
        c.h().l(INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.e(TAG, "[tryInit] load CronetDependManager exception: ", th);
    }

    public String getAbClient() {
        return BDLiveSdkInternal.getAppContext().getAbClient();
    }

    public String getAbFeature() {
        return BDLiveSdkInternal.getAppContext().getAbFeature();
    }

    public String getAbVersion() {
        return BDLiveSdkInternal.getAppContext().getAbVersion();
    }

    public String getAppId() {
        return BDLiveSdk.getAppInfo().hostAppId();
    }

    public String getAppName() {
        return BDLiveSdkInternal.getAppContext().getAppName();
    }

    public String getChannel() {
        return BDLiveSdkInternal.getAppContext().getChannel();
    }

    public String getDeviceId() {
        return BDLiveSdk.appLog().getDid();
    }

    public String getGetDomainDefaultJSON() {
        return "{\n    \"data\": {\n         \"opaque_data_enabled\":1,\n         \"chromium_open\": 1,\n         \"ttnet_http_dns_enabled\": 0,\n         \"ttnet_quic_enabled\": 1,\n         \"ttnet_local_dns_time_out\":120,\n         \"ttnet_h2_enabled\": 1,\n         \"ttnet_socket_pool_param\": {\n             \"max_sockets_per_group\": 20\n         },\n         \"ttnet_preconnect_urls\": {\n             \"" + BDLiveSdk.getAppInfo().apiHost() + "\": 1\n         },\n         \"ttnet_buffer_config\": {\n             \"ttnet_request_body_buffer_size\": 1048576\n         }\n    },\n    \"message\":\"success\"\n}";
    }

    public String getIId() {
        return BDLiveSdk.appLog().getInstallId();
    }

    public String getManifestVersionCode() {
        return BDLiveSdkInternal.getAppContext().getManifestVersion();
    }

    public ArrayList<byte[]> getOpaqueData() {
        if (BDLiveSdk.getAppInfo().isDebug() == false) goto L6;
        return null;
    L6:
        OpaqueData.Companion r0 = OpaqueData.Companion;
        ArrayList<byte[]> r1 = r0.getOpaqueDataList();
        r0.setHttpURLConnectionSelfCAPolicy(r1);
        return r1;
    }

    public String getSdkAppId() {
        return String.valueOf(BDLiveSdk.getAppInfo().appId());
    }

    public String getUUID() {
        return g.d();
    }

    public String getUserId() {
        return BDLiveSdk.appLog().getDid();
    }

    public String getVersionName() {
        return BDLiveSdkInternal.getAppContext().getVersion();
    }

    public boolean loggerDebug() {
        if (Logger.debug() == false) goto L5;
    L8:
        return true;
    L5:
        if ("local_test".equalsIgnoreCase(BDLiveSdk.getAppInfo().channel()) == true) goto L8;
        return false;
    }

    private CronetDependAdapter() {
    }

    public static boolean isInjected() {
        return sIsInjectSuccess;
    }

    public void sendAppMonitorEvent(String r4, String r5) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "Get monitor json = " + r4 + " logType = " + r5);     // Catch: Throwable -> L7
        return;
    }
}
