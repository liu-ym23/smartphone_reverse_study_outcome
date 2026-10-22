package com.bytedance.ttnet;

import ai.w0;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.crash.Npth;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.ies.bullet.core.r;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.lynx.tasm.utils.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import rj.b;
import rj.f;
import s9.d;
import s9.g;
import sj.j;
import u9.h;
import u9.i;
import u9.l;
import u9.n;
import wj.a;
import wj.c;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetInit {
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static volatile ENV env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static b sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static com.bytedance.frameworks.baselib.network.b sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;

    public static final enum ENV extends Enum<ENV> {
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ENV[] f7524a = null;

        static {
            ENV r5 = new ENV("DEBUG", 0);
            DEBUG = r5;
            ENV r10 = new ENV("RELEASE", 1);
            RELEASE = r10;
            f7524a = new ENV[]{r5, r10};
        }

        public static ENV valueOf(String r5) {
            return (ENV) Enum.valueOf(ENV.class, r5);
        }

        public static ENV[] values() {
            return (ENV[]) f7524a.clone();
        }
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sMainThreadInitCookieEnabled = true;
        com.bytedance.frameworks.baselib.network.b r5 = new com.bytedance.frameworks.baselib.network.b();
        r5.f4662a = new CopyOnWriteArrayList();
        Activity r10 = null;
        Class<?> r11 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L13
        Object r12 = r11.getMethod("currentActivityThread", null).invoke(null, null);     // Catch: Throwable -> L13
        Field r13 = r11.getDeclaredField("mActivities");     // Catch: Throwable -> L13
        r13.setAccessible(true);     // Catch: Throwable -> L13
        Map r14 = (Map) r13.get(r12);     // Catch: Throwable -> L13
        if (r14 == null) goto L15;
        Iterator r15 = r14.values().iterator();     // Catch: Throwable -> L13
    L8:
        if (r15.hasNext() == false) goto L15;
        Object r16 = r15.next();     // Catch: Throwable -> L13
        Class<?> r17 = r16.getClass();     // Catch: Throwable -> L13
        Field r18 = r17.getDeclaredField("paused");     // Catch: Throwable -> L13
        r18.setAccessible(true);     // Catch: Throwable -> L13
        if (r18.getBoolean(r16) == true) goto L8;
        Field r19 = r17.getDeclaredField("activity");     // Catch: Throwable -> L13
        r19.setAccessible(true);     // Catch: Throwable -> L13
        r10 = (Activity) r19.get(r16);     // Catch: Throwable -> L13
    L15:
        if (r10 == null) goto L17;
        com.bytedance.frameworks.baselib.network.b.f4660b = true;
    L17:
        sLifeCycleMonitor = r5;
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public TTNetInit() {
    }

    private static void CookieInitFailedReport(Context r5, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put("init", MessageIndication.STATUS_FAILED);     // Catch: JSONException -> L5
        r11.put("exception", r10);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend();
        throw null;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static c TTDnsResolve(String r5, int r10) throws Exception {
        a r11 = a.a();
        r11.getClass();
        wj.b r12 = new wj.b();
        String r13 = UUID.randomUUID().toString();
        r12.f22869a = new CountDownLatch(1);
        r11.f22868a.put(r13, r12);
        getTTNetDepend();
        throw null;
    }

    public static /* synthetic */ void access$000(Context r5, boolean r10, boolean r11) {
        tryInitCookieManager(r5, r10, r11);
    }

    public static void addClientOpaqueData(Context r5, String[] r10, byte[] r11, byte[] r12) {
        l.m(r5).getClass();
        ICronetClient r13 = l.f22316b;     // Catch: Throwable -> L10
        if (r13 != null) goto L6;
        return;
    L6:
        if (l.f22315a == null) goto L16;
        Reflect.on(r13).call("addClientOpaqueData", new Class[]{Context.class, String[].class, byte[].class, byte[].class}, new Object[]{l.f22315a, r10, r11, r12});     // Catch: Throwable -> L10
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

    public static void clearClientOpaqueData(Context r5) {
        l.m(r5).getClass();
        ICronetClient r10 = l.f22316b;     // Catch: Throwable -> L10
        if (r10 != null) goto L6;
        return;
    L6:
        if (l.f22315a == null) goto L16;
        Reflect.on(r10).call("clearClientOpaqueData", new Class[]{Context.class}, new Object[]{l.f22315a});     // Catch: Throwable -> L10
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
    public static List<InetAddress> dnsLookup(String r5) throws Exception {
        getTTNetDepend();
        throw null;
    }

    @Deprecated
    public static void doCommand(Context r5, String r10) {
    }

    public static void enableApiHttpIntercept(boolean r5) {
        sApiHttpInterceptEnabled = r5;
    }

    public static void enableCookieLogReport(boolean r5) {
        sCookieLogReportEnabled = r5;
    }

    public static void enableTTBizHttpDns(boolean r5, String r10, String r11, String r12, boolean r13, String r14) {
        if (r5 == true) goto L4;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        if (getCronetHttpClient() == null) goto L21;
        l.f(r5, r10, r11, r12, r13, r14);     // Catch: Throwable -> L14
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

    private static void feedBackCronetInitFailedLog(int r5, String r10) {
        JSONObject r11 = new JSONObject();
        r11.put("fallback", r5);     // Catch: JSONException -> L11
        r11.put("exception", r10);     // Catch: JSONException -> L11
        r11.put("model", Build.MODEL);     // Catch: JSONException -> L11
        String r12 = "";
        String[] r13 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L11
        if (r13 != null) goto L6;
    L8:
        r11.put("abis", r12);     // Catch: JSONException -> L11
        getTTNetDepend();     // Catch: JSONException -> L11
        throw null;
    L6:
        if (r13.length <= 0) goto L8;
        r12 = Arrays.asList(r13).toString();     // Catch: JSONException -> L11
    }

    public static void forceInitCronetKernel() throws Exception {
        com.bytedance.frameworks.baselib.network.http.cronet.b.e().getClass();
        getTTNetDepend();
        throw null;
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    private static l getCronetHttpClient() throws Exception {
        e.h();
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        getTTNetDepend();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static ENV getEnv() {
        return env;
    }

    public static String getGetDomainConfigByRegion(String r5) {
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
        if (TextUtils.isEmpty(r5) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r5.toLowerCase());
    }

    public static Map<String, h> getGroupRttEstimates() throws Exception {
        getTTNetDepend();
        throw null;
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

    public static void getMappingRequestState(String r5) {
        getTTNetDepend();     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static h getNetworkQuality() throws Exception {
        getTTNetDepend();
        throw null;
    }

    public static i getPacketLossRateMetrics(int r5) throws Exception {
        getTTNetDepend();
        throw null;
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static b getTTNetDepend() {
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    private static void injectOkhttp3HttpDnsDepend() {
        throw null;
    }

    public static boolean isPrivateApiAccessEnabled() {
        getTTNetDepend();
        throw null;
    }

    public static void monitorLogSend(String r5, JSONObject r10) {
    }

    public static void notifyColdStartFinish() {
    }

    public static void onActivityResume(Activity r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        new f(r5).a();
    }

    public static void onClientIPChanged(String r5) {
        if (r5 == null) goto L5;
        sClientIPString = r5;
        return;
    }

    public static void onPublicIPsChanged(List<String> r5, List<String> r10) {
        sPublicIPv4List = r5;
        sPublicIPv6List = r10;
    }

    public static void preInitCronetKernel() throws Exception {
        com.bytedance.frameworks.baselib.network.http.cronet.b.e().getClass();
        int r5 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L13;
        r5 = 3;
    L13:
        String r10 = null;
        StringWriter r11 = new StringWriter();     // Catch: Throwable -> L24
        PrintWriter r12 = new PrintWriter(r11);     // Catch: Throwable -> L24
        th.printStackTrace(r12);     // Catch: Throwable -> L20
        Throwable r13 = th.getCause();     // Catch: Throwable -> L20
        if (r13 == null) goto L22;
        r13.printStackTrace(r12);     // Catch: Throwable -> L20
        Throwable r14 = r13.getCause();     // Catch: Throwable -> L20
        if (r14 == null) goto L22;
        r14.printStackTrace(r12);     // Catch: Throwable -> L20
    L22:
        r10 = r11.toString();     // Catch: Throwable -> L20
    L23:
        r12.close();
    L30:
        if (r10.length() <= 1024) goto L32;
        r10 = r10.substring(0, 1024);
    L32:
        feedBackCronetInitFailedLog(r5, r10);
        throw th;
    L20:
        th = th;
    L38:
        th.printStackTrace();     // Catch: Throwable -> L34
        if (r12 == null) goto L30;
    L34:
        th = move-exception;
        if (r12 == null) goto L37;
        r12.close();
    L37:
        throw th;
    L24:
        th = th;
        r12 = null;
        goto L38
    L4:
        if (getCronetHttpClient() != null) goto L9;
        r5 = com.bytedance.frameworks.baselib.network.http.ok3.impl.a.f4682a;     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r5, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r5) throws Exception {
        new URL(r5).toURI();
        getTTNetDepend();
        throw null;
    }

    public static void removeClientOpaqueData(Context r5, String r10) {
        l.m(r5).getClass();
        ICronetClient r11 = l.f22316b;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        return;
    L6:
        if (l.f22315a == null) goto L16;
        Reflect.on(r11).call("removeClientOpaqueData", new Class[]{Context.class, String.class}, new Object[]{l.f22315a, r10});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    @Deprecated
    public static void setALogFuncAddr(long r5) throws Exception {
    }

    public static void setBypassOfflineCheck(boolean r5) {
        l.d = r5;
    }

    public static void setCookieHandler(Context r5) {
        CookieHandler r10 = CookieHandler.getDefault();     // Catch: Throwable -> L8
        if (r10 == null) goto L11;
        if ((r10 instanceof v9.c) == false) goto L11;
        s9.h.c();     // Catch: Throwable -> L8
        return;
    L11:
        if (sCookieManagerInitStartTime > 0) goto L23;
        s9.h.c();     // Catch: Throwable -> L8
        return;
    L23:
        CookieManager.getInstance();     // Catch: Throwable -> L16
    L19:
        getTTNetDepend();     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L16:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L8
        CookieInitFailedReport(r5, th.getMessage());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CookieInitFailedReport(r5, th.getMessage());
        th.printStackTrace();
    }

    public static void setCronetDepend(ICronetAppProvider r5) {
        if (r5 == null) goto L9;
        sCronetProvider = r5;
        String r10 = r5.getCarrierRegion();
        String r11 = r5.getSysRegion();
        r5.getRegion();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        TextUtils.isEmpty(r11);
    L6:
        ba.a.f();
        r5.getStoreIdcRuleJSON();
        getTTNetDepend();
        throw null;
    L9:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setDelayTime(int r5) {
        sDelayTime = r5;
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r5) throws Exception {
    }

    public static void setEnv(ENV r5) {
        env = r5;
    }

    public static void setFirstRequestWaitTime(long r5) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r5) {
        if (r5 == null) goto L6;
        sGetDomainRegionMap = r5;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static void setHostResolverRulesForTesting(String r5) throws Exception {
        if (getCronetHttpClient() == null) goto L9;
        ICronetClient r10 = l.f22316b;
        if (r10 == null) goto L8;
        Reflect.on(r10).call("setHostResolverRules", new Class[]{String.class}, new Object[]{r5});
        return;
    L8:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void setHttpDnsForTesting(boolean r5, boolean r10, boolean r11) throws Exception {
    }

    public static void setListenAppStateIndependently(boolean r5) {
        sListenAppStateIndependently = r5;
    }

    public static void setMainThreadInitCookieEnabled(boolean r5) {
        sMainThreadInitCookieEnabled = r5;
    }

    public static void setProcessFlag(int r5) {
        com.bytedance.frameworks.baselib.network.http.util.b.f4692a.set(r5);
    }

    public static void setProxy(String r5) throws Exception {
        getTTNetDepend();
        throw null;
    }

    public static void setTTNetDepend(b r5) {
        getTTNetDepend();
        throw null;
    }

    public static void trigerGetDomain(Context r5) {
        triggerGetDomain(r5, false);
    }

    public static void triggerGetDomain(Context r5, boolean r10) {
        l.m(r5).getClass();
        ICronetClient r11 = l.f22316b;     // Catch: Throwable -> L10
        if (r11 != null) goto L6;
        return;
    L6:
        if (l.f22315a == null) goto L16;
        Reflect.on(r11).call("triggerGetDomain", new Class[]{Context.class, Boolean.TYPE}, new Object[]{l.f22315a, Boolean.valueOf(r10)});     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    private static void tryInitCookieManager(Context r16, boolean r17, boolean r18) {
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        if (r17 == false) goto L10;
        CookieSyncManager.createInstance(r16);     // Catch: Throwable -> L8
        CookieManager r5 = CookieManager.getInstance();     // Catch: Throwable -> L8
        r5.setAcceptCookie(true);     // Catch: Throwable -> L8
        setCookieHandler(r16);     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L112;
        Logger.d("Process", " CookieManager = " + r5.toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L8
    L112:
    L25:
        ClientKeyManager r10 = ClientKeyManager.d();
        r10.getClass();
        ClientKeyManager.f7529j = r18;
        ClientKeyManager.f7527h = Keva.getRepo("ttnet_client_key_config", 1);     // Catch: Throwable -> L28
    L30:
        Keva r11 = ClientKeyManager.f7527h;
        if (r11 == null) goto L124;
        String r12 = r11.getString("client_key_config", "");
        if (TextUtils.isEmpty(r12) == true) goto L37;
        r10.a(new JSONObject(r12));     // Catch: Throwable -> L102
    L37:
        if (ClientKeyManager.f7528i == false) goto L125;
        String r13 = ClientKeyManager.f7527h.getString("session_id", "");
        long r14 = 0;
        long r15 = ClientKeyManager.f7527h.getLong("session_time", 0);
        r10.e = ClientKeyManager.f7527h.getString("session_url", "");
        r10.f7533c = ClientKeyManager.f7527h.getString("client_key", "");
        String r19 = ClientKeyManager.f7527h.getString("kms_version", "");
        r10.f = r19;
        ClientKeyManager.f7530k = ClientKeyManager.c(r10.f7533c, r19);
        if (r13.isEmpty() == false) goto L42;
        return;
    L42:
        if (r10.e.isEmpty() == true) goto L126;
        String[] r20 = r13.split(";");
        int r21 = 0;
        if (r20 == null) goto L50;
        if (r20.length <= 0) goto L50;
        r10.d = r20[0].trim();
    L50:
        if (TextUtils.isEmpty(r10.d) == true) goto L127;
        if (r20 != null) goto L54;
    L74:
        String r22 = null;
    L81:
        if (TextUtils.isEmpty(r22) == true) goto L83;
        r13 = r22;
    L83:
        StringBuilder r23 = new StringBuilder("client key: ");
        r23.append(r10.f7533c);
        r23.append(" | kms version: ");
        androidx.constraintlayout.motion.widget.a.C(r23, r10.f, " | session cookie: ", r13, " | sessionid: ");
        r23.append(r10.d);
        r23.append(" | session time: ");
        r23.append(r15);
        r23.append(" session url: ");
        r23.append(r10.e);
        r23.append(" config: ");
        r23.append(r12);
        Logger.d("ClientKeyManager", r23.toString());
        CookieHandler r24 = CookieHandler.getDefault();
        if (r24 == null) goto L128;
        URI r25 = e.j(r10.e);     // Catch: Throwable -> L104
        if (r25 == null) goto L105;
        Map<String, List<String>> r26 = r24.get(r25, null);     // Catch: Throwable -> L104
        if (r26 == null) goto L105;
        if (r26.isEmpty() == true) goto L105;
        if (r26.containsKey("Cookie") == false) goto L105;
        String r27 = r26.get("Cookie").toString();     // Catch: Throwable -> L104
        Logger.d("ClientKeyManager", "cookieStr: " + r27 + " sessionId: " + r10.d);     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r27) == false) goto L98;
        ClientKeyManager.e(r13, r24, r25);     // Catch: Throwable -> L104
        r10.b("empty");     // Catch: Throwable -> L104
        goto L105
    L98:
        if (r27.contains(r10.d) == true) goto L105;
        ClientKeyManager.e(r13, r24, r25);     // Catch: Throwable -> L104
        r10.b(r27);     // Catch: Throwable -> L104
    L105:
        return;
    L129:
        return;
    L128:
        return;
    L54:
        if (r20.length < 2) goto L74;
        if (r15 <= 0) goto L74;
        int r110 = r20.length;
    L60:
        if (r21 >= r110) goto L67;
        String r111 = r20[r21];
        if (TextUtils.isEmpty(r111) == true) goto L66;
        if (r111.toLowerCase().trim().startsWith("Max-Age=".toLowerCase()) == false) goto L66;
        String[] r28 = r111.split("=");
    L68:
        if (r28 == null) goto L74;
        if (r28.length != 2) goto L74;
        long r29 = Long.parseLong(r28[1]);     // Catch: Throwable -> L103
        if (r29 <= 0) goto L74;
        long r30 = r29 - ((System.currentTimeMillis() - r15) / 1000);     // Catch: Throwable -> L103
        if (r30 <= 0) goto L79;
        r14 = r30;
    L79:
        r22 = r13.replaceFirst(r111.trim(), "Max-Age=" + r14);     // Catch: Throwable -> L103
    L66:
        r21 = r21 + 1;
        goto L60
    L67:
        r28 = null;
        r111 = null;
        goto L68
    L127:
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L28:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L10:
        s9.h.c();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        if (com.bytedance.frameworks.baselib.network.http.util.b.b(r16) == false) goto L25;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L25;
        if (sMainThreadInitCookieEnabled == false) goto L115;
        new Handler(Looper.getMainLooper()).post(new rj.e(r16, r17, r18));
    L115:
        new JSONObject().put("error", th.getMessage());     // Catch: JSONException -> L22
    L24:
        CookieInitFailedReport(r16, th.getMessage());
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public static void tryInitTTNet(Context r10, Application r11, d r12, g r13, s9.e r14, boolean r15, boolean... r16) {
        int r17 = 1;
        com.bytedance.frameworks.baselib.network.http.cronet.b r18 = com.bytedance.frameworks.baselib.network.http.cronet.b.e();
        System.currentTimeMillis();
        r18.getClass();
        if (r10 == null) goto L84;
        Reflect.on(Npth.class.newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.1.79.42-pico"});     // Catch: Throwable -> L6
    L9:
        if (ENV.RELEASE == getEnv()) goto L11;
        boolean r19 = true;
    L13:
        if (r19 == true) goto L15;
        Logger.d("ttnet_debug_mode", "debug_mode close");
    L18:
        w0.f306b = Logger.getLogLevel();
        sj.d r20 = s9.h.f21879a;
        s9.b.f21857y = new com.bytedance.sdk.xbridge.cn.auth.g(17);
        KevaBuilder.getInstance().setContext(r10);
        if (r16 != null) goto L21;
    L23:
        boolean r21 = false;
    L24:
        boolean r110 = com.bytedance.frameworks.baselib.network.http.util.b.b(r10);
        j.b(r10);
        if (r110 == false) goto L27;
        new rj.c(r10, r15).a();
    L27:
        yj.b r111 = yj.b.a();
        monitor-enter(r111);
    L37:
        th = move-exception;
        throw th;
    L30:
        if (r111.f23291b == true) goto L40;
        r111.f23292c = r10;     // Catch: Throwable -> L37
        o r5 = new o(12);     // Catch: Throwable -> L37
        r5.f23310b = new yj.a();     // Catch: Throwable -> L37
        r111.d = r5;     // Catch: Throwable -> L37
        if (r110 == false) goto L35;
        SharedPreferences r22 = r10.getSharedPreferences("ttnet_tnc_config", 0);     // Catch: Throwable -> L37
        r111.e = r22.getInt("tnc_probe_cmd", 0);     // Catch: Throwable -> L37
        r111.f = r22.getLong("tnc_probe_version", 0);     // Catch: Throwable -> L37
    L35:
        if (Logger.debug() == false) goto L39;
        Logger.d("TNCManager", "initTnc, isMainProc: " + r110 + " probeCmd: " + r111.e + " probeVersion: " + r111.f);     // Catch: Throwable -> L37
    L39:
        r111.f23291b = true;     // Catch: Throwable -> L37
    L40:
        monitor-exit(r111);
        x9.b.b().f22998a = r10;
        sj.d.h(r10);
        com.bytedance.frameworks.baselib.network.http.cronet.b.e().getClass();
        System.currentTimeMillis();
        Class<?> r112 = Class.forName("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L44
    L45:
        if (r112 == null) goto L90;
    L47:
        if (r112 != null) goto L88;
    L53:
        System.currentTimeMillis();
        String r113 = com.bytedance.frameworks.baselib.network.http.util.b.a(r10);
        if (r113 != null) goto L56;
    L60:
        if (r110 == true) goto L63;
        if (r21 == false) goto L63;
    L62:
        new rj.d(r10, r15).a();
    L63:
        if (r110 == true) goto L68;
        String r23 = com.bytedance.frameworks.baselib.network.http.util.b.a(r10);
        if (r23 != null) goto L67;
    L69:
        countDownInitCompletedLatch();
        if (r110 == true) goto L73;
        com.bytedance.frameworks.baselib.network.http.cronet.b.e().getClass();
        com.bytedance.frameworks.baselib.network.http.cronet.b r24 = com.bytedance.frameworks.baselib.network.http.cronet.b.e();
        System.currentTimeMillis();
        r24.getClass();
        return;
    L73:
        sj.d r25 = s9.h.f21879a;
        if (com.lynx.tasm.behavior.utils.d.f10793b != null) goto L76;
        com.lynx.tasm.behavior.utils.d.f10793b = new uj.a();
    L76:
        com.bytedance.frameworks.baselib.network.b r26 = sLifeCycleMonitor;
        r26.f4662a.add(ca.f.a());
        if (r11 == null) goto L79;
        r11.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
        r11.registerActivityLifecycleCallbacks(new r(r17));
    L79:
        e.h();
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
        com.bytedance.frameworks.baselib.network.http.cronet.b r27 = com.bytedance.frameworks.baselib.network.http.cronet.b.e();
        System.currentTimeMillis();
        r27.getClass();
        return;
    L67:
        if (r23.contains(":miniapp") == false) goto L69;
    L68:
        sj.d r28 = s9.h.f21879a;
        goto L69
    L56:
        if (r113.endsWith(":push") == true) goto L62;
        if (r113.endsWith(":pushservice") == false) goto L60;
    L88:
        r112.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r112, new Object[]{r10, 1, null});     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L90:
        r112 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L85
    L44:
        r112 = null;
        goto L45
    L21:
        if (r16.length <= 0) goto L23;
        r21 = r16[0];
        goto L24
    L15:
        Logger.d("ttnet_debug_mode", "debug_mode open");
        if ("true".equals(r10.getSharedPreferences("ttnet_debug_setting", 0).getString("log_switcher", null)) == false) goto L18;
        Logger.setLogLevel(2);
        w0.f306b = Logger.getLogLevel();
        goto L18
    L11:
        r19 = false;
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L84:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r10) {
        sj.d r5 = s9.h.f21879a;
        if (r10 != null) goto L20;
    L17:
        s9.h.f21880b = r10;
        return;
    L20:
        if (r10.length() <= 0) goto L17;
        char[] r11 = r10.toCharArray();     // Catch: Exception -> L19
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
        r10 = new String(r11);     // Catch: Exception -> L19
        goto L17
    }

    public static boolean tryStartTTNetDetect(String[] r5, int r10, int r11) {
        if (r5 != null) goto L5;
    L15:
        return false;
    L5:
        if (r5.length <= 0) goto L15;
        if (r10 <= 0) goto L15;
        if (r10 > 180) goto L15;
        if (r11 < 0) goto L15;
        getTTNetDepend();     // Catch: Throwable -> L13
        throw null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static n ttUrlDispatch(String r5) throws Exception {
        new URL(r5).toURI();
        getTTNetDepend();
        throw null;
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public static void useCustomizedCookieStoreName() {
        int r5 = v9.b.f22563a;
    }
}
