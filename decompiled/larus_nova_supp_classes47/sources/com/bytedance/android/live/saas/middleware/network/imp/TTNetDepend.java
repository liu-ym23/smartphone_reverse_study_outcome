package com.bytedance.android.live.saas.middleware.network.imp;

import android.content.Context;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.utils.CornetPlugin;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.ITTNetDepend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class TTNetDepend implements ITTNetDepend {
    public static final String API_HOST_API = "api.snssdk.com";
    public static final String API_HOST_FEEDBACK = "xgfe.snssdk.com";
    public static final String API_HOST_I = "ib.snssdk.com";
    public static final String API_HOST_I2 = "i.snssdk.com";
    public static final String API_HOST_ISUB = "isub.snssdk.com";
    public static final String API_HOST_LOG = "log.snssdk.com";
    public static final String API_HOST_MON = "mon.snssdk.com";
    public static final String API_HOST_SI = "security.snssdk.com";
    public static final String API_HOST_SRV = "ichannel.snssdk.com";
    public static final String API_HOST_WEBCAST = "webcast.ixigua.com";
    public static final String API_HOST_XGADMIN = "xigua-admin.bytedance.net";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static volatile TTNetDepend sInstance;

    public TTNetDepend() {
    }

    public int checkHttpRequestException(Throwable r1, String[] r2) {
        return 1;
    }

    public String executeGet(int r1, String r2) throws Exception {
        return null;
    }

    public String getApiIHostPrefix() {
        return "ib";
    }

    public String getCdnHostSuffix() {
        return ".pstatp.com";
    }

    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    public String getHostSuffix() {
        return ".snssdk.com";
    }

    public int getProviderInt(Context r1, String r2, int r3) {
        return r3;
    }

    public String getProviderString(Context r1, String r2, String r3) {
        return r3;
    }

    public String getShareCookieMainDomain() {
        return ".snssdk.com";
    }

    public boolean isPrivateApiAccessEnabled() {
        return false;
    }

    public void mobOnEvent(Context r1, String r2, String r3, JSONObject r4) {
    }

    public void monitorLogSend(String r1, JSONObject r2) {
    }

    public void onColdStartFinish() {
    }

    public void onNetConfigUpdate(JSONObject r1, boolean r2) {
    }

    public void onShareCookieConfigUpdated(String r1) {
    }

    public void saveMapToProvider(Context r1, Map<String, ?> r2) {
    }

    public static TTNetDepend inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTNetDepend.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTNetDepend();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetDepend.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Map<String, String> getHostReverseMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(API_HOST_I, "i");
        r0.put(API_HOST_SI, "si");
        r0.put(API_HOST_ISUB, "isub");
        r0.put(API_HOST_SRV, "ichannel");
        r0.put(API_HOST_LOG, "log");
        r0.put(API_HOST_MON, "mon");
        return r0;
    }

    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r0 = new HashMap();
        r0.put(DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r0.put(DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r0.put("boe", ".boe-gateway.byted.org");
        return r0;
    }

    public boolean isCronetPluginInstalled() {
        return CornetPlugin.INSTANCE.isCornetSoInstalled(getContext());
    }

    public int getAppId() {
        return BDLiveSdk.getAppInfo().appId();
    }

    public String[] getConfigServers() {
        if ("local_test".equalsIgnoreCase(BDLiveSdk.getAppInfo().channel()) == false) goto L7;
        return null;
    L7:
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm-hl.toutiao.com"};
    }

    public Context getContext() {
        return BDLiveSdk.getContext();
    }

    public void onAppConfigUpdated(Context r2, JSONObject r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d("AppConfig", "TTNetDepend.onAppConfigUpdated:" + r3);
        return;
    }
}
