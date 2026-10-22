package com.bytedance.bdlocation.monitor;

import android.content.Context;
import android.util.Log;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.g;
import com.bytedance.services.apm.api.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationMonitorUtil {
    private static final String CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static boolean sIsInit;
    private static volatile SDKMonitor sSDKMonitor;

    public LocationMonitorUtil() {
    }

    private static JSONObject getHeader() {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, "device_id", BDLocationConfig.getDeviceId());
        JsonUtil.safePutString(r0, "host_aid", BDLocationConfig.getAppId());
        JsonUtil.safePutString(r0, "sdk_version", BDLocationConfig.getSdkVersion());
        JsonUtil.safePutString(r0, "channel", BDLocationConfig.getChannel());
        JsonUtil.safePutString(r0, "app_version", BDLocationConfig.getAppVersion());
        JsonUtil.safePutString(r0, "update_version_code", BDLocationConfig.getUpdateVersionCode());
        JsonUtil.safePutString(r0, "package_name", BDLocationConfig.getPackageName());
        return r0;
    }

    public static void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (sIsInit == true) goto L8;
        if (r4 == null) goto L9;
        g.a(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{CONFIG_URL}));
        g.b(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{DEFAULT_REPORT_URL}));
        g.a(r4, BDLocationConfig.getSlardarAid(), getHeader(), new AnonymousClass1());
        sSDKMonitor = g.a(BDLocationConfig.getSlardarAid());
        sIsInit = true;
        return;
    L9:
        return;
    }

    public static void monitorEvent(String r1) {
        monitorEvent(r1, null, null, null);
    }

    public static void monitorEvent(String r1, JSONObject r2, JSONObject r3) {
        monitorEvent(r1, r2, r3, null);
    }

    public static void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        if (sSDKMonitor == null) goto L6;
        sSDKMonitor.monitorEvent(r1, r2, r3, r4);
        return;
    }

    public static void monitorEventWithException(String r1, JSONObject r2, JSONObject r3, JSONObject r4, Throwable r5) {
        if (r2 == null) goto L9;
        if (r5 == null) goto L10;
        r2.put("throwable", Log.getStackTraceString(r5));     // Catch: Throwable -> L6
        monitorEvent(r1, r2, r3, r4);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void monitorException(Throwable r2, String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (sSDKMonitor != null) goto L12;
        return;
    L12:
        new JSONObject().put("errMsg", r3);     // Catch: Throwable -> L11
        if (r5 != null) goto L8;
        r5 = new HashMap();     // Catch: Throwable -> L11
    L8:
        if (r2 == null) goto L14;
        a.a(r2, r3, r5);     // Catch: Throwable -> L11
        return;
    L14:
        return;
    }
}
