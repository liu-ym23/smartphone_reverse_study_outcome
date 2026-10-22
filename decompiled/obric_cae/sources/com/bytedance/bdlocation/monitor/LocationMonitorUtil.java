package com.bytedance.bdlocation.monitor;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import defpackage.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import u7.a;
import u7.d;
import x7.f;
import x7.m;
import x7.n;

/* JADX INFO: loaded from: classes.dex */
public class LocationMonitorUtil {
    private static final String CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static boolean sIsInit;
    private static volatile m sSDKMonitor;

    public LocationMonitorUtil() {
    }

    private static JSONObject getHeader() {
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutString(r8, "device_id", BDLocationConfig.getDeviceId());
        JsonUtil.safePutString(r8, "host_aid", BDLocationConfig.getAppId());
        JsonUtil.safePutString(r8, "sdk_version", BDLocationConfig.getSdkVersion());
        JsonUtil.safePutString(r8, "channel", BDLocationConfig.getChannel());
        JsonUtil.safePutString(r8, "app_version", BDLocationConfig.getAppVersion());
        JsonUtil.safePutString(r8, "update_version_code", BDLocationConfig.getUpdateVersionCode());
        JsonUtil.safePutString(r8, "package_name", BDLocationConfig.getPackageName());
        return r8;
    }

    public static void init(Context r8) {
        if (sIsInit == true) goto L40;
        if (r8 == null) goto L43;
        n.c(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{CONFIG_URL}));
        n.d(BDLocationConfig.getSlardarAid(), Arrays.asList(new String[]{DEFAULT_REPORT_URL}));
        String r10 = BDLocationConfig.getSlardarAid();
        JSONObject r11 = getHeader();
        m.a r12 = new AnonymousClass1();
        monitor-enter(n.class);
    L37:
        th = move-exception;
        throw th;
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L36;
        if (r11 == null) goto L34;
        ConcurrentHashMap<String, m> r13 = n.f13664a;     // Catch: Throwable -> L37
        if (r13.get(r10) != null) goto L14;
    L17:
        m r14 = r13.get(r10);     // Catch: Throwable -> L37
        if (r14 != null) goto L20;
        r14 = new m(r10);     // Catch: Throwable -> L37
        r13.put(r10, r14);     // Catch: Throwable -> L37
    L20:
        List<String> r15 = n.f13666c.remove(r10);     // Catch: Throwable -> L37
        if (r15 != null) goto L23;
    L25:
        List<String> r16 = n.f13665b.remove(r10);     // Catch: Throwable -> L37
        if (r16 != null) goto L28;
    L30:
        r14.f13662y = true;     // Catch: Throwable -> L37
        a r17 = a.b.f12503a;     // Catch: Throwable -> L37
        f r18 = new f(r14, r8, r11, r12);     // Catch: Throwable -> L37
        d r19 = r17.f12499a;     // Catch: Throwable -> L37
        r19.e(Message.obtain(r19.f12514d, r18), 5000);     // Catch: Throwable -> L37
    L15:
        monitor-exit(n.class);
        sSDKMonitor = n.b(BDLocationConfig.getSlardarAid());
        sIsInit = true;
        return;
    L28:
        if (c.P(r16) == true) goto L30;
        r14.A.clear();     // Catch: Throwable -> L37
        r14.A.addAll(r16);     // Catch: Throwable -> L37
        goto L30
    L23:
        if (c.P(r15) == true) goto L25;
        LinkedList r20 = r14.f13658u;     // Catch: Throwable -> L37
        r20.clear();     // Catch: Throwable -> L37
        r20.addAll(r15);     // Catch: Throwable -> L37
        goto L25
    L14:
        if (r13.get(r10).f13662y == false) goto L17;
    L34:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L37
    L43:
        return;
    }

    public static void monitorEvent(String r8) {
        monitorEvent(r8, null, null, null);
    }

    public static void monitorEventWithException(String r8, JSONObject r10, JSONObject r11, JSONObject r12, Throwable r13) {
        if (r10 == null) goto L9;
        if (r13 == null) goto L10;
        r10.put("throwable", Log.getStackTraceString(r13));     // Catch: Throwable -> L6
        monitorEvent(r8, r10, r11, r12);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void monitorException(Throwable r8, String r10, Map<String, String> r11) {
        if (sSDKMonitor != null) goto L10;
        return;
    L10:
        new JSONObject().put("errMsg", r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L12;
        new HashMap();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static void monitorEvent(String r8, JSONObject r10, JSONObject r11) {
        monitorEvent(r8, r10, r11, null);
    }

    public static void monitorEvent(String r8, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (sSDKMonitor == null) goto L6;
        sSDKMonitor.r(r8, r10, r11, r12);
        return;
    }
}
