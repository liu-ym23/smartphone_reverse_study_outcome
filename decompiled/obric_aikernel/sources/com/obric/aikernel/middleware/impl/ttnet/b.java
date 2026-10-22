package com.obric.aikernel.middleware.impl.ttnet;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.chromium.CronetAppProviderManager;
import org.chromium.CronetDependManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends x4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f4622b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a() {
            CronetDependManager.inst().setAdapter(b.e());
            CronetAppProviderManager.inst().setAdapter(b.e());
        }
    }

    static {
        f4621a = new a(null);
        f4622b = new b();
    }

    public b() {
    }

    public static final /* synthetic */ b e() {
        return f4622b;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return String.valueOf(AppContext.INSTANCE.getAid());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return AppContext.INSTANCE.getAppName();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return AppContext.INSTANCE.getChannel();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        return AppContext.INSTANCE.getServerDeviceId();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getGetDomainDefaultJSON() {
        return "{\"data\": {\"clear_pool_enabled\": 1,\"ttnet_url_dispatcher_enabled\": 1,\"https_dns\": [],\"ttnet_http_dns_google\": 0,\"ttnet_min_dns_ttl\": {\"fa.oceancloudapi.com\": 600,\"ofa.oceancloudapi.com\": 600},\"tnc_config\": {\"host_replace_map\": {},\"local_enable\": 0,\"local_host_filter\": [],\"probe_enable\": 1,\"update_interval\": 1800,\"update_random_range\": 30},\"ttnet_http_dns_addr\": {\"ofa.oceancloudapi.com\": \"220.243.141.188,122.14.229.81,101.126.58.84,220.243.141.187,122.14.229.87,101.126.58.83,122.14.229.80,101.126.58.85,220.243.141.189\",\"tnc0-aliec2.zijieapi.com\": \"8.133.123.137,8.133.123.138,8.133.123.139,8.133.123.140\",\"lf6-device-intelligence-sign.oceancloudapi.com\": \"122.14.229.108,122.14.229.106,122.14.229.107\",\"lf26-device-intelligence-sign.oceancloudapi.com\": \"122.14.229.108,122.14.229.107,122.14.229.106\",\"lf3-device-intelligence-sign.oceancloudapi.com\": \"122.14.229.108,122.14.229.107,122.14.229.106\",\"direct.faceu-normal-lb-v3.lq.bytelb.net\": \"101.126.58.85,220.243.141.188,101.126.58.83,101.126.58.84,220.243.141.189,220.243.141.187\",\"fa.oceancloudapi.com\": \"101.126.58.177,101.126.58.175,220.243.141.216,220.243.141.215,220.243.141.217,101.126.58.176,122.14.229.102,122.14.229.7,122.14.229.103\",\"tnc0-alisc1.zijieapi.com\": \"47.106.88.76,47.106.84.116,120.78.234.27,120.78.189.22\",\"tnc0-bjlgy.zijieapi.com\": \"101.36.166.16,101.36.166.17,101.36.166.18,101.36.166.19\",\"lf9-device-intelligence-sign.oceancloudapi.com\": \"122.14.229.107,122.14.229.106,122.14.229.108\",\"direct.faceu-normal-lb-v3.hl.bytelb.net\": \"220.243.141.189,101.126.58.83,101.126.58.84,220.243.141.187,101.126.58.85,220.243.141.188\",\"direct.faceu-normal-lb-v3.lf.bytelb.net\": \"122.14.229.80,220.243.141.189,122.14.229.87,220.243.141.187,101.126.58.84,220.243.141.188,101.126.58.85,101.126.58.83,122.14.229.81\"},\"ttnet_http_dns_prefer\": 1,\"ttnet_http_dns_timeout_map\": {\"fa.oceancloudapi.com\": 600,\"ofa.oceancloudapi.com\": 600,\"os.oceancloudapi.com\": 600,\"api-device-intelligence.bytedance.net\": 600,\"api-device-intelligence.oceancloudapi.com\": 600,\"api-normal-ocean.doubao.com\": 600},\"ttnet_h2_config\": {\"ping\": {\"enabled\": 1,\"rule_list\": [{\"host_eq\": [\"api-device-intelligence.oceancloudapi.com\"],\"path_eq\": [\"/ocean/device_intelligence/vlm\", \"/ocean/device_intelligence/chat\", \"/api/v1/aicorex/distribute\"],\"value\": {\"timeout\": 2}}]}},\"ttnet_enable_cronet_request_report\": 1,\"ttnet_tt_http_dns\": 1,\"chromium_open\": 1,\"ttnet_http_dns_timeout\": 2,\"ttnet_local_dns_time_out\": 120,\"send_tnc_host_arrays\": [\"tnc0-alisc1.zijieapi.com\", \"tnc0-bjlgy.zijieapi.com\", \"tnc0-aliec2.zijieapi.com\"],\"ttnet_http_dns_enabled\": 1,\"ttnet_local_dns_timeout_map\": {\"api-device-intelligence.bytedance.net\": 600,\"api-device-intelligence.oceancloudapi.com\": 600,\"api-normal-ocean.doubao.com\": 600,\"fa.oceancloudapi.com\": 600,\"ofa.oceancloudapi.com\": 600,\"os.oceancloudapi.com\": 600}}}";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return AppContext.INSTANCE.getVersionName();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return String.valueOf(AppContext.INSTANCE.getUpdateVersionCode());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return com.bytedance.applog.a.h();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return String.valueOf(AppContext.INSTANCE.getVersionCode());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return AppContext.INSTANCE.getVersionName();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        AppContext r10 = AppContext.INSTANCE;
        if (r10.isLocalTest() == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.isDebug() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r10, String r11) {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        AIKLog.INSTANCE.d("CronetDependAdapter", "sendAppMonitorEvent: " + r10);     // Catch: JSONException -> L8
    L5:
        if (r10 == null) goto L11;
        com.bytedance.apm.c.e(r11, new JSONObject(r10));     // Catch: JSONException -> L8
        return;
    L11:
        return;
    }
}
