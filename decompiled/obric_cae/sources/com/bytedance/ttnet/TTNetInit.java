package com.bytedance.ttnet;

import a7.i;
import a7.k;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.ttnet.org.chromium.base.ProcessUtils;
import d7.p;
import g7.j;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInit {
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static volatile h env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static w8.c sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile boolean sNotifiedColdStartFinsish;

    public static class a extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Context f4066o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ boolean f4067p;

        public a(Context r8, boolean r10) {
            this.f4066o = r8;
            this.f4067p = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            Context r8 = this.f4066o;
            x8.c.k(r8).r();
            x8.c.k(r8).s(d9.d.b.f6996o, true);
            TTNetInit.access$000(r8, this.f4067p, true);
        }
    }

    public static class b extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Context f4068o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ boolean f4069p;

        public b(Context r8, boolean r10) {
            this.f4068o = r8;
            this.f4069p = r10;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            Context r8 = this.f4068o;
            x8.c.k(r8).r();
            TTNetInit.access$000(r8, this.f4069p, false);
            x8.c.k(r8).s(d9.d.b.f6996o, true);
        }
    }

    public static class c implements e9.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4070a;

        public c(Context r8) {
            this.f4070a = r8;
        }
    }

    public static class d implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r8, Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r8) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r8) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r8) {
            TTNetInit.onActivityResume(r8);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r8, Bundle r10) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r8) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r8) {
        }
    }

    public static class e implements c7.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4071a;

        public e(Context r8) {
            this.f4071a = r8;
        }
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f4072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f4073b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f4074m;

        public f(Context r8, boolean r10, boolean r11) {
            this.f4072a = r8;
            this.f4073b = r10;
            this.f4074m = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = this.f4073b;
            boolean r10 = this.f4074m;
            TTNetInit.access$000(this.f4072a, r8, r10);
        }
    }

    public static class g extends s5.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Activity f4075o;

        public g(Activity r8) {
            this.f4075o = r8;
            super(0);
        }

        @Override // s5.c, java.lang.Runnable
        public final void run() {
            x8.c.k(this.f4075o).r();
        }
    }

    public static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f4076a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ h[] f4077b = null;

        static {
            h r8 = new h("DEBUG", 0);
            h r10 = new h("RELEASE", 1);
            f4076a = r10;
            f4077b = new h[]{r8, r10};
        }

        public h(String r8, int r10) {
            super(r8, r10);
        }

        public static h valueOf(String r8) {
            return (h) Enum.valueOf(h.class, r8);
        }

        public static h[] values() {
            return (h[]) f4077b.clone();
        }
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sMainThreadInitCookieEnabled = true;
        TTALog.init();
        env = h.f4076a;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
    }

    public TTNetInit() {
    }

    private static void CookieInitFailedReport(Context r8, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put("init", "failed");     // Catch: JSONException -> L5
        r11.put("exception", r10);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend().mobOnEvent(r8, "TTNET-COOKIE", "init", r11);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static b9.c TTDnsResolve(String r8, int r10) {
        monitor-enter(b9.a.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (b9.a.f3133c != null) goto L7;
        b9.a.f3133c = new b9.a(0);     // Catch: Throwable -> L15
    L7:
        b9.a r11 = b9.a.f3133c;     // Catch: Throwable -> L15
        monitor-exit(b9.a.class);
        r11.getClass();
        b9.b r12 = new b9.b(r8, r10);
        Map r13 = (Map) r11.f3135b;
        String r14 = r12.f3136a;
        r13.put(r14, r12);
        i.m(getTTNetDepend().getContext()).getClass();
        ICronetClient r15 = i.f111b;
        if (r15 == null) goto L14;
        Reflect.on(r15).call("ttDnsResolve", new Class[]{String[].class, Integer.TYPE, String.class}, new Object[]{r8, Integer.valueOf(r10), r14}).get();
        r12.f3137b.await();
        r13.remove(r14);
        return r12.f3138c;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static /* synthetic */ void access$000(Context r8, boolean r10, boolean r11) {
        tryInitCookieManager(r8, r10, r11);
    }

    public static void addClientOpaqueData(Context r8, String[] r10, byte[] r11, byte[] r12) {
        i.m(r8).getClass();
        ICronetClient r13 = i.f111b;     // Catch: Throwable -> L10
        if (r13 != null) goto L6;
        return;
    L6:
        if (i.f110a == null) goto L16;
        Reflect.on(r13).call("addClientOpaqueData", new Class[]{Context.class, String[].class, byte[].class, byte[].class}, new Object[]{i.f110a, r10, r11, r12});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void clearClientOpaqueData(Context r8) {
        i.m(r8).getClass();
        ICronetClient r10 = i.f111b;     // Catch: Throwable -> L10
        if (r10 != null) goto L6;
        return;
    L6:
        if (i.f110a == null) goto L16;
        Reflect.on(r10).call("clearClientOpaqueData", new Class[]{Context.class}, new Object[]{i.f110a});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean cookieLogReportEnabled() {
        return sCookieLogReportEnabled;
    }

    private static void countDownInitCompletedLatch() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (sLatchInitCompleted.getCount() <= 0) goto L11;
        sLatchInitCompleted.countDown();     // Catch: Exception -> L6
        return;
    }

    @Deprecated
    public static List<InetAddress> dnsLookup(String r8) {
        i.m(getTTNetDepend().getContext()).getClass();
        ICronetClient r10 = i.f111b;
        if (r10 == null) goto L7;
        return (List) Reflect.on(r10).call("dnsLookup", new Class[]{String.class}, new Object[]{r8}).get();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Deprecated
    public static void doCommand(Context r8, String r10) {
    }

    public static void enableApiHttpIntercept(boolean r8) {
        sApiHttpInterceptEnabled = r8;
    }

    public static void enableCookieLogReport(boolean r8) {
        sCookieLogReportEnabled = r8;
    }

    public static void enableTTBizHttpDns(boolean r8, String r10, String r11, String r12, boolean r13, String r14) {
        if (r8 == true) goto L4;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        if (getCronetHttpClient() == null) goto L21;
        i.f(r8, r10, r11, r12, r13, r14);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r12) == false) goto L17;
    }

    private static void feedBackCronetInitFailedLog(int r8, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put("fallback", r8);     // Catch: JSONException -> L10
        r11.put("exception", r10);     // Catch: JSONException -> L10
        r11.put("model", Build.MODEL);     // Catch: JSONException -> L10
        String r12 = "";
        String[] r13 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r13 != null) goto L6;
    L8:
        r11.put("abis", r12);     // Catch: JSONException -> L10
        getTTNetDepend().monitorLogSend("cronet_failed", r11);     // Catch: JSONException -> L10
        return;
    L6:
        if (r13.length <= 0) goto L8;
        r12 = Arrays.asList(r13).toString();     // Catch: JSONException -> L10
    }

    public static void forceInitCronetKernel() {
        y6.b r8 = y6.b.b();
        r8.f14010a = y6.b.a.f14038n;
        i.m(getTTNetDepend().getContext()).s(false, x8.c.k(getTTNetDepend().getContext()).g(), true);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    private static i getCronetHttpClient() {
        if (w8.b.b() == false) goto L6;
        i r8 = i.m(getTTNetDepend().getContext());
        r8.s(true, x8.c.k(getTTNetDepend().getContext()).g(), false);
        return r8;
    L6:
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        i.m(getTTNetDepend().getContext()).getClass();     // Catch: Throwable -> L4
        i.a();     // Catch: Throwable -> L4
        return ((Integer) Reflect.on(i.f111b).call("getEffectiveConnectionType").get()).intValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static h getEnv() {
        return env;
    }

    public static String getGetDomainConfigByRegion(String r8) {
        Map<String, String> r10 = sGetDomainRegionMap;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r8) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r8.toLowerCase());
    }

    public static Map<String, a7.g> getGroupRttEstimates() {
        i.m(getTTNetDepend().getContext()).getClass();
        i.a();
        HashMap r8 = new HashMap();
        Iterator r10 = ((Map) Reflect.on(i.f111b).call("getGroupRTTEstimates").get()).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r11 = (Map.Entry) r10.next();
        if (((int[]) r11.getValue()).length != 2) goto L9;
        a7.g r12 = new a7.g();
        int r13 = ((int[]) r11.getValue())[0];
        int r14 = ((int[]) r11.getValue())[1];
        r8.put(r11.getKey(), r12);
        goto L4
    L9:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L10:
        return r8;
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static void getMappingRequestState(String r8) {
        i.m(getTTNetDepend().getContext()).getClass();     // Catch: Throwable -> L4
        i.a();     // Catch: Throwable -> L4
        Reflect.on(i.f111b).call("getMappingRequestState", new Class[]{String.class}, new Object[]{r8}).get();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static a7.g getNetworkQuality() {
        i.m(getTTNetDepend().getContext()).getClass();
        i.a();
        int[] r8 = (int[]) Reflect.on(i.f111b).call("getNetworkQuality").get();
        if (r8.length != 3) goto L7;
        a7.g r10 = new a7.g();
        int r11 = r8[0];
        int r12 = r8[1];
        int r13 = r8[2];
        return r10;
    L7:
        throw new UnknownFormatConversionException("getNetworkQuality returns wrong format");
    }

    public static a7.h getPacketLossRateMetrics(int r8) {
        i.m(getTTNetDepend().getContext()).getClass();
        i.a();
        return (a7.h) Reflect.on(i.f111b).call("getPacketLossRateMetrics", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8)}).get();
    }

    public static w8.c getTTNetDepend() {
        w8.c r8 = sITTNetDepend;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    private static void injectOkhttp3HttpDnsDepend() {
        Object r8 = sITTNetDepend;
        if (r8 != null) goto L5;
    L7:
        int r10 = sITTNetDepend.getAppId();
        String r11 = sITTNetDepend.getTTNetServiceDomainMap().get("httpdns");
        p.f6910g = r10;
        p.f6911h = r11;
        p.f6913j = null;
        p.f6912i = null;
        return;
    L5:
        if ((r8 instanceof w8.a) == false) goto L7;
        ((w8.a) r8).getClass();
        ((w8.a) sITTNetDepend).getClass();
        goto L7
    }

    public static boolean isPrivateApiAccessEnabled() {
        return getTTNetDepend().isPrivateApiAccessEnabled();
    }

    public static void monitorLogSend(String r8, JSONObject r10) {
        w8.c r11 = sITTNetDepend;
        if (r11 == null) goto L6;
        r11.monitorLogSend(r8, r10);
        return;
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.onColdStartFinish();
        return;
    }

    public static void onActivityResume(Activity r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        new g(r8).a();
    }

    public static void onClientIPChanged(String r8) {
        if (r8 == null) goto L5;
        sClientIPString = r8;
        return;
    }

    public static void preInitCronetKernel() {
        y6.b r8 = y6.b.b();
        r8.f14010a = y6.b.a.f14037m;
        int r10 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r10 = 3;
    L11:
        String r11 = defpackage.c.W(th);
        if (r11.length() <= 1024) goto L14;
        r11 = r11.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r10, r11);
        throw th;
    L4:
        if (getCronetHttpClient() != null) goto L18;
        r10 = p.f6905b;     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r10, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r8) {
        new URL(r8).toURI();
        i.m(getTTNetDepend().getContext()).getClass();
        ICronetClient r10 = i.f111b;
        if (r10 == null) goto L7;
        Reflect.on(r10).call("preconnectUrl", new Class[]{String.class}, new Object[]{r8}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void removeClientOpaqueData(Context r8, String r10) {
        i.m(r8).getClass();
        ICronetClient r11 = i.f111b;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        return;
    L6:
        if (i.f110a == null) goto L16;
        Reflect.on(r11).call("removeClientOpaqueData", new Class[]{Context.class, String.class}, new Object[]{i.f110a, r10});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Deprecated
    public static void setALogFuncAddr(long r8) {
    }

    public static void setBypassOfflineCheck(boolean r8) {
        i.f113d = r8;
    }

    public static void setCookieHandler(Context r8) {
        CookieHandler r10 = CookieHandler.getDefault();     // Catch: Throwable -> L19
        if (r10 == null) goto L9;
        if ((r10 instanceof c7.g) == false) goto L9;
        w6.e.e();     // Catch: Throwable -> L19
        return;
    L9:
        if (sCookieManagerInitStartTime > 0) goto L22;
        w6.e.e();     // Catch: Throwable -> L19
        return;
    L22:
        CookieManager r11 = CookieManager.getInstance();     // Catch: Throwable -> L14
    L13:
        CookieManager r12 = r11;
        CookieHandler.setDefault(new c7.g(r8, sDelayTime, r12, getTTNetDepend().getCookieFlushPathList(), new e(r8)));     // Catch: Throwable -> L19
        w6.e.e();     // Catch: Throwable -> L19
        return;
    L14:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L19
        CookieInitFailedReport(r8, th.getMessage());     // Catch: Throwable -> L19
        r11 = null;
    L19:
        th = move-exception;
        CookieInitFailedReport(r8, th.getMessage());
        th.printStackTrace();
    }

    public static void setCronetDepend(ICronetAppProvider r11) {
        if (r11 == null) goto L48;
        sCronetProvider = r11;
        String r8 = r11.getCarrierRegion();
        String r10 = r11.getSysRegion();
        String r12 = r11.getRegion();
        if (TextUtils.isEmpty(r8) == true) goto L7;
    L10:
        k7.b r13 = k7.b.e();
        String r14 = r11.getStoreIdcRuleJSON();
        Context r15 = getTTNetDepend().getContext();
        d9.c r16 = new d9.c(r11);
        r13.getClass();
        Logger.d("b", "rule json: " + r14);
        if (TextUtils.isEmpty(r14) == true) goto L40;
        if (r15 == null) goto L40;
        JSONObject r17 = new JSONObject(r14);     // Catch: JSONException -> L37
        JSONArray r18 = r17.optJSONArray("update_store_idc_path_list");     // Catch: JSONException -> L37
        int r19 = 0;
        int r20 = 0;
    L14:
        int r21 = r18.length();     // Catch: JSONException -> L37
        ArrayList r22 = r13.f8967g;
        if (r20 >= r21) goto L21;
        String r23 = r18.getString(r20);     // Catch: JSONException -> L37
        if (TextUtils.isEmpty(r23) == true) goto L20;
        r22.add(r23);     // Catch: JSONException -> L37
    L20:
        r20 = r20 + 1;     // Catch: JSONException -> L37
        goto L14
    L21:
        JSONArray r24 = r17.optJSONArray("add_store_idc_host_list");     // Catch: JSONException -> L37
    L23:
        if (r19 >= r24.length()) goto L28;
        String r25 = r24.getString(r19);     // Catch: JSONException -> L37
        if (TextUtils.isEmpty(r25) == true) goto L27;
        r13.f8968h.add(r25);     // Catch: JSONException -> L37
    L27:
        r19 = r19 + 1;     // Catch: JSONException -> L37
        goto L23
    L28:
        r13.f8969i = r15;     // Catch: JSONException -> L37
        r13.f8972l = r16;     // Catch: JSONException -> L37
        if (TextUtils.isEmpty(r8) == true) goto L32;
        r13.f8966f = r8;     // Catch: JSONException -> L37
    L32:
        if (r22.isEmpty() == true) goto L40;
        if (r22.isEmpty() == true) goto L40;
        r13.f8970j = true;     // Catch: JSONException -> L37
        r13.f();     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L40:
        if (TextUtils.isEmpty(r8) == true) goto L43;
        d9.d.f6977p = getGetDomainConfigByRegion(r8);
    L43:
        if (TextUtils.isEmpty(d9.d.f6977p) == false) goto L45;
        d9.d.f6977p = r11.getGetDomainDefaultJSON();
    L45:
        StringBuilder r110 = defpackage.b.h("region: ", r8, " json: ");
        r110.append(d9.d.f6977p);
        Logger.d("TNCManager", r110.toString());
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r8 = r10;
        goto L10
    L9:
        r8 = r12;
        goto L10
    L48:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setDelayTime(int r8) {
        sDelayTime = r8;
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r8) {
    }

    public static void setEnv(h r8) {
        env = r8;
    }

    public static void setFirstRequestWaitTime(long r8) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r8) {
        if (r8 == null) goto L6;
        sGetDomainRegionMap = r8;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static void setHostResolverRulesForTesting(String r8) {
        if (getCronetHttpClient() == null) goto L6;
        i.a();
        Reflect.on(i.f111b).call("setHostResolverRules", new Class[]{String.class}, new Object[]{r8});
        return;
    }

    public static void setHttpDnsForTesting(boolean r8, boolean r10, boolean r11) {
    }

    public static void setListenAppStateIndependently(boolean r8) {
        sListenAppStateIndependently = r8;
    }

    public static void setMainThreadInitCookieEnabled(boolean r8) {
        sMainThreadInitCookieEnabled = r8;
    }

    public static void setProcessFlag(int r8) {
        l7.e.f9171a.set(r8);
    }

    public static void setProxy(String r8) {
        i.m(getTTNetDepend().getContext()).getClass();
        i.a();
        Reflect.on(i.f111b).call("setProxy", new Class[]{String.class}, new Object[]{r8}).get();
    }

    public static void setTTNetDepend(w8.c r8) {
        sITTNetDepend = r8;
        Map<String, String> r10 = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r10.get("httpdns")) == false) goto L5;
    L18:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty(r10.get(DOMAIN_NETLOG_KEY)) == true) goto L18;
        if (TextUtils.isEmpty(r10.get(DOMAIN_BOE_KEY)) == true) goto L9;
    L10:
        String r11 = r10.get(DOMAIN_BOE_KEY);
        l7.a.f9155a = r11;
        if (TextUtils.isEmpty(r11) == true) goto L13;
        l7.a.f9158d = true;
    L13:
        String r12 = r10.get(DOMAIN_BOE_HTTPS_KEY);
        l7.a.f9156b = r12;
        if (TextUtils.isEmpty(r12) == true) goto L16;
        l7.a.f9158d = false;
    L16:
        injectOkhttp3HttpDnsDepend();
        return;
    L9:
        if (TextUtils.isEmpty(r10.get(DOMAIN_BOE_HTTPS_KEY)) == true) goto L18;
        goto L10
    }

    public static void trigerGetDomain(Context r8) {
        triggerGetDomain(r8, false);
    }

    public static void triggerGetDomain(Context r8, boolean r10) {
        i.m(r8).getClass();
        ICronetClient r11 = i.f111b;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        return;
    L6:
        if (i.f110a == null) goto L16;
        Reflect.on(r11).call("triggerGetDomain", new Class[]{Context.class, Boolean.TYPE}, new Object[]{i.f110a, Boolean.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    private static void tryInitCookieManager(Context r18, boolean r19, boolean r20) {
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        if (r19 == false) goto L8;
        CookieSyncManager.createInstance(r18);     // Catch: Throwable -> L10
        CookieManager r8 = CookieManager.getInstance();     // Catch: Throwable -> L10
        r8.setAcceptCookie(true);     // Catch: Throwable -> L10
        setCookieHandler(r18);     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L113;
        Logger.d("Process", " CookieManager = " + r8.toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L10
    L113:
    L27:
        ClientKeyManager r10 = ClientKeyManager.d();
        r10.getClass();
        ClientKeyManager.f4081j = r20;
        ClientKeyManager.f4079h = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L30
    L32:
        Keva r11 = ClientKeyManager.f4079h;
        if (r11 == null) goto L132;
        String r12 = r11.getString("client_key_config", "");
        if (TextUtils.isEmpty(r12) == true) goto L39;
        r10.b(new JSONObject(r12));     // Catch: Throwable -> L106
    L39:
        if (ClientKeyManager.f4080i == false) goto L133;
        String r13 = ClientKeyManager.f4079h.getString(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, "");
        long r14 = ClientKeyManager.f4079h.getLong("session_time", 0);
        r10.f4087e = ClientKeyManager.f4079h.getString("session_url", "");
        r10.f4085c = ClientKeyManager.f4079h.getString("client_key", "");
        String r15 = ClientKeyManager.f4079h.getString("kms_version", "");
        r10.f4088f = r15;
        ClientKeyManager.f4082k = ClientKeyManager.c(r10.f4085c, r15);
        if (r13.isEmpty() == false) goto L44;
        return;
    L44:
        if (r10.f4087e.isEmpty() == true) goto L134;
        String[] r16 = r13.split(";");
        int r17 = 0;
        if (r16 == null) goto L52;
        if (r16.length <= 0) goto L52;
        r10.f4086d = r16[0].trim();
    L52:
        if (TextUtils.isEmpty(r10.f4086d) == true) goto L135;
        if (r16 != null) goto L56;
    L82:
        String r21 = null;
    L84:
        if (TextUtils.isEmpty(r21) == true) goto L86;
        r13 = r21;
    L86:
        Logger.d("ClientKeyManager", "client key: " + r10.f4085c + " | kms version: " + r10.f4088f + " | session cookie: " + r13 + " | sessionid: " + r10.f4086d + " | session time: " + r14 + " session url: " + r10.f4087e + " config: " + r12);
        CookieHandler r22 = CookieHandler.getDefault();
        if (r22 == null) goto L136;
        URI r23 = t2.b.T(r10.f4087e);     // Catch: Throwable -> L108
        if (r23 == null) goto L127;
        Map<String, List<String>> r24 = r22.get(r23, null);     // Catch: Throwable -> L108
        if (r24 != null) goto L95;
        return;
    L95:
        if (r24.isEmpty() == false) goto L97;
        return;
    L97:
        if (r24.containsKey("Cookie") == false) goto L130;
        String r25 = r24.get("Cookie").toString();     // Catch: Throwable -> L108
        Logger.d("ClientKeyManager", "cookieStr: " + r25 + " sessionId: " + r10.f4086d);     // Catch: Throwable -> L108
        if (TextUtils.isEmpty(r25) == false) goto L101;
        ClientKeyManager.e(r13, r22, r23);     // Catch: Throwable -> L108
        r25 = "empty";
    L104:
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L108
        r26.put("report_time", System.currentTimeMillis() + "");     // Catch: Throwable -> L108
        r26.put("cookie_line", r25);     // Catch: Throwable -> L108
        r26.put(QesdkUtils.TAGS.JSON_TAG_SESSION_ID, r10.f4086d);     // Catch: Throwable -> L108
        r26.put(WsConstants.KEY_CONNECTION_URL, r10.f4087e);     // Catch: Throwable -> L108
        getTTNetDepend().monitorLogSend("cookie_mismatch", r26);     // Catch: Throwable -> L108
        return;
    L101:
        if (r25.contains(r10.f4086d) == true) goto L131;
        ClientKeyManager.e(r13, r22, r23);     // Catch: Throwable -> L108
        goto L104
    L131:
        return;
    L130:
        return;
    L127:
        return;
    L137:
        return;
    L136:
        return;
    L56:
        if (r16.length < 2) goto L82;
        if (r14 <= 0) goto L82;
        int r110 = r16.length;
    L62:
        if (r17 >= r110) goto L69;
        String r111 = r16[r17];
        if (TextUtils.isEmpty(r111) == true) goto L68;
        if (r111.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L68;
        String[] r27 = r111.split("=");
    L70:
        if (r27 == null) goto L82;
        if (r27.length != 2) goto L82;
        long r28 = Long.parseLong(r27[1]);     // Catch: Throwable -> L107
        if (r28 <= 0) goto L82;
        long r29 = r28 - ((System.currentTimeMillis() - r14) / 1000);     // Catch: Throwable -> L107
        if (r29 > 0) goto L80;
        r29 = 0;
    L80:
        r21 = r13.replaceFirst(r111.trim(), "Max-Age=" + r29);     // Catch: Throwable -> L107
    L68:
        r17 = r17 + 1;
        goto L62
    L69:
        r27 = null;
        r111 = null;
        goto L70
    L135:
        return;
    L134:
        return;
    L133:
        return;
    L132:
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L8:
        w6.e.e();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        if (l7.e.c(r18) == false) goto L27;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L27;
        if (sMainThreadInitCookieEnabled == false) goto L18;
        new Handler(Looper.getMainLooper()).post(new f(r18, r19, r20));
    L18:
        JSONObject r30 = new JSONObject();
        r30.put(WsConstants.KEY_CONNECTION_ERROR, th.getMessage());     // Catch: JSONException -> L21
    L23:
        w8.c r31 = sITTNetDepend;
        if (r31 == null) goto L26;
        r31.monitorLogSend("async_init_cookie_manager_fail", r30);
    L26:
        CookieInitFailedReport(r18, th.getMessage());
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public static void tryInitTTNet(Context r8, Application r10, w6.e.a<a9.c> r11, w6.e.f<a9.c> r12, w6.e.c r13, boolean r14, boolean... r15) {
        y6.b.b().f14013d = System.currentTimeMillis();
        if (r8 == null) goto L80;
        boolean r16 = true;
        if (t2.b.G == false) goto L12;
        Reflect.on(Class.forName("com.bytedance.crash.Npth").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.0.76.2"});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (h.f4076a == getEnv()) goto L14;
        boolean r17 = true;
    L16:
        if (r17 == true) goto L18;
        Logger.d("ttnet_debug_mode", "debug_mode close");
    L21:
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        w6.e.f13022c = r11;
        w6.a.E = new a9.b();
        KevaBuilder.getInstance().setContext(r8);
        if (r15 != null) goto L24;
    L26:
        boolean r18 = false;
    L27:
        boolean r19 = l7.e.c(r8);
        x8.i.a(r8);
        if (r19 == false) goto L30;
        new a(r8, r14).a();
    L30:
        d9.d r110 = d9.d.c();
        monitor-enter(r110);
    L76:
        th = move-exception;
        throw th;
    L33:
        if (r110.f6979b == true) goto L41;
        r110.f6980c = r8;     // Catch: Throwable -> L76
        r110.f6990m = r19;     // Catch: Throwable -> L76
        r110.f6981d = new d9.b(r8, r19);     // Catch: Throwable -> L76
        if (r19 == false) goto L38;
        SharedPreferences r20 = r110.f6980c.getSharedPreferences("ttnet_tnc_config", 0);     // Catch: Throwable -> L76
        r110.f6982e = r20.getInt("tnc_probe_cmd", 0);     // Catch: Throwable -> L76
        r110.f6983f = r20.getLong("tnc_probe_version", 0);     // Catch: Throwable -> L76
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d("TNCManager", "initTnc, isMainProc: " + r19 + " probeCmd: " + r110.f6982e + " probeVersion: " + r110.f6983f);     // Catch: Throwable -> L76
    L40:
        r110.f6979b = true;     // Catch: Throwable -> L76
    L41:
        monitor-exit(r110);
        j.e().f7742a = r8;
        x8.c.k(r8);
        y6.b r111 = y6.b.b();
        r111.getClass();
        long r21 = System.currentTimeMillis();
        y6.b.c(r8, null);
        r111.f14017h = System.currentTimeMillis() - r21;
        String r112 = l7.e.a(r8);
        if (r112 != null) goto L45;
    L49:
        boolean r113 = false;
    L50:
        if (r113 == true) goto L53;
        if (r19 == true) goto L54;
        if (r18 == true) goto L53;
    L54:
        if (r19 == true) goto L62;
        String r114 = l7.e.a(r8);
        if (r114 != null) goto L58;
    L60:
        r16 = false;
    L61:
        if (r16 == true) goto L62;
    L63:
        countDownInitCompletedLatch();
        if (r19 == true) goto L67;
        y6.b.b().f14011b = false;
    L74:
        y6.b.b().f14014e = System.currentTimeMillis();
        return;
    L67:
        if (e9.b.f7206a != null) goto L69;
        e9.b.f7206a = new c(r8);
    L69:
        if (r10 == null) goto L72;
        r10.registerActivityLifecycleCallbacks(new d());
    L72:
        if (w8.b.b() == true) goto L74;
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
        goto L74
    L58:
        if (r114.contains(":miniapp") == false) goto L60;
    L62:
        w6.e.f13023d = r12;
    L53:
        new b(r8, r14).a();
        goto L54
    L45:
        if (r112.endsWith(ProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L47;
    L48:
        r113 = true;
        goto L50
    L47:
        if (r112.endsWith(ProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L49;
    L24:
        if (r15.length <= 0) goto L26;
        r18 = r15[0];
        goto L27
    L18:
        Logger.d("ttnet_debug_mode", "debug_mode open");
        if ("true".equals(r8.getSharedPreferences("ttnet_debug_setting", 0).getString("log_switcher", null)) == false) goto L21;
        Logger.setLogLevel(2);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        goto L21
    L14:
        r17 = false;
        goto L16
    L80:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r8) {
        w6.e.d r10 = w6.e.f13020a;
        if (r8 != null) goto L20;
    L17:
        w6.e.f13021b = r8;
        return;
    L20:
        if (r8.length() <= 0) goto L17;
        char[] r11 = r8.toCharArray();     // Catch: Exception -> L19
        int r12 = r11.length;     // Catch: Exception -> L19
        int r13 = 0;
        boolean r14 = false;
    L7:
        if (r13 >= r12) goto L14;
        char r15 = r11[r13];     // Catch: Exception -> L19
        if (r15 >= ' ') goto L11;
    L12:
        r11[r13] = '?';     // Catch: Exception -> L19
        r14 = true;
    L13:
        r13 = r13 + 1;     // Catch: Exception -> L19
        goto L7
    L11:
        if (r15 <= '~') goto L13;
    L14:
        if (r14 == false) goto L17;
        r8 = new String(r11);     // Catch: Exception -> L19
        goto L17
    }

    public static boolean tryStartTTNetDetect(String[] r8, int r10, int r11) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (r8.length <= 0) goto L20;
        if (r10 > 0) goto L7;
        return false;
    L7:
        if (r10 > 180) goto L22;
        if (r11 < 0) goto L23;
        i.m(getTTNetDepend().getContext()).getClass();     // Catch: Throwable -> L13
        i.v(r8, r10, r11);     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        th.printStackTrace();
        return false;
    L23:
        return false;
    L22:
        return false;
    L20:
        return false;
    }

    public static k ttUrlDispatch(String r8) {
        new URL(r8).toURI();
        i.m(getTTNetDepend().getContext()).getClass();
        return i.w(r8);
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public static void useCustomizedCookieStoreName() {
        c7.e.f3393d = "ttnetCookieStore";
    }
}
