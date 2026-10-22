package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.ReflectException;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.n;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.v;
import com.bytedance.retrofit2.z;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ttnet.tnc.TNCManager;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.CookieHandler;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import r2.i;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";

    @Deprecated
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final String ENCRYPT_RETRY_HEADER = "x-ttnet-retry-encrypt";
    public static final String ENCRYPT_RETRY_VERIFY_HEADER = "x-tt-e-ignore-status-code-verify";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static final String OKHTTP_DISPATCH_FAILED = "okhttp dispatch failed.";
    private static final String RETURN_WRONG_FORMAT = "Conversion = 'ttUrlDispatch returns wrong format'";
    private static final String TAG = "TTNetInit";
    private static final String TTNET_CRONET_NOT_INITIALIZED = "cronet not init.";
    private static volatile ENV env = null;
    private static volatile boolean sApiHttpInterceptEnabled = false;
    private static volatile int sAppSecurityLevel = 0;
    private static volatile String sClientIPString = null;
    private static volatile boolean sCookieLogReportEnabled = false;
    private static long sCookieManagerInitStartTime = 0;
    public static ICronetAppProvider sCronetProvider = null;
    private static volatile int sDelayTime = 10;
    public static Map<String, String> sGetDomainRegionMap;
    private static com.bytedance.ttnet.d sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static com.bytedance.frameworks.baselib.network.a sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile boolean sMainThreadInitCookieEnabled;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static volatile boolean sStateDelayNewStrategyEnabled;
    private static com.bytedance.ttnet.e sSystemApiSandbox;
    private static com.bytedance.ttnet.g sTTNetThreadConfigInfoManager;

    public static final enum ENV extends Enum<ENV> {
        private static final /* synthetic */ ENV[] $VALUES = null;
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        static {
            ENV r10 = new ENV("DEBUG", 0);
            DEBUG = r10;
            ENV r11 = new ENV("RELEASE", 1);
            RELEASE = r11;
            $VALUES = new ENV[]{r10, r11};
        }

        private ENV(String r10, int r11) {
            super(r10, r11);
        }

        public static ENV valueOf(String r10) {
            return (ENV) Enum.valueOf(ENV.class, r10);
        }

        public static ENV[] values() {
            return (ENV[]) $VALUES.clone();
        }
    }

    class a extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Context f2770j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f2771k;

        a(String r10, Context r11, boolean r12) {
            this.f2770j = r11;
            this.f2771k = r12;
            super(r10);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTNetInit.access$000(), "throttle control use new logic " + TTNetInit.access$100());
        L6:
            if (TTNetInit.access$100() == false) goto L8;
            s4.b r10 = TTHttpCallPriorityControl.h();
        L9:
            z.u(r10);
            w4.a.r(this.f2770j).G();
            w4.a.r(this.f2770j).I(TNCManager.TNCUpdateSource.TTSERVER, true);
            TTNetInit.access$200(this.f2770j, this.f2771k, true);
            return;
        L8:
            r10 = TTHttpCallThrottleControl.l();
            goto L9
        }
    }

    class b extends r1.c {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Context f2772j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f2773k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f2774l;

        b(String r10, Context r11, boolean r12, boolean r13) {
            this.f2772j = r11;
            this.f2773k = r12;
            this.f2774l = r13;
            super(r10);
        }

        @Override // r1.c, java.lang.Runnable
        public void run() {
            w4.a.r(this.f2772j).G();
            w4.a.r(this.f2772j).I(TNCManager.TNCUpdateSource.TTSERVER, true);
            if (this.f2773k == false) goto L5;
            TTNetInit.access$200(this.f2772j, this.f2774l, false);
            return;
        L5:
            o2.f.L(true);
            TTNetInit.access$300();
        }
    }

    class c implements com.bytedance.ttnet.utils.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2775a;

        c(Context r10) {
            this.f2775a = r10;
        }

        @Override // com.bytedance.ttnet.utils.c.b
        public void a(String r10, String r11, String r12, a5.b r13) {
        }

        @Override // com.bytedance.ttnet.utils.c.b
        public void b(String r10, String r11, int r12, boolean r13, JSONObject r14) {
            if (r13 == false) goto L4;
            int r15 = 1;
        L10:
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L7
            r16.put("url", r11);     // Catch: Throwable -> L7
            r16.put(EventBody.KEY_VALUE, r12);     // Catch: Throwable -> L7
            r16.put("ext_value", r15);     // Catch: Throwable -> L7
            r16.put("extraObject", r14);     // Catch: Throwable -> L7
            TTNetInit.getTTNetDepend().d(this.f2775a, "set_cookie", r10, r16);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();
            return;
        L4:
            r15 = 0;
            goto L10
        }
    }

    class d implements o2.f.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f2776a;

        d(g r10) {
            this.f2776a = r10;
        }

        @Override // o2.f.o
        public o2.h a(Map<String, List<String>> r10) {
            return null;
        }

        @Override // o2.f.p
        public o2.h b(String r10, List<n4.b> r11, Map<String, List<String>> r12) {
            o2.h r13 = new o2.h(false, false, null);
            List<String> r14 = r12.get(TTNetInit.ENCRYPT_RETRY_VERIFY_HEADER);     // Catch: Throwable -> L18
            if (r14 != null) goto L6;
        L17:
            return r13;
        L6:
            if (r14.isEmpty() == true) goto L17;
            String r15 = r14.get(0);     // Catch: Throwable -> L18
            if (com.bytedance.common.utility.g.b(r15) == true) goto L17;
            if (r15.startsWith("2") == false) goto L17;
            g r16 = this.f2776a;     // Catch: Throwable -> L18
            if (r16 == null) goto L15;
            r16.a(r10, r11, r12);     // Catch: Throwable -> L18
        L15:
            HashMap r17 = new HashMap();     // Catch: Throwable -> L18
            r17.put(TTNetInit.ENCRYPT_RETRY_HEADER, r15);     // Catch: Throwable -> L18
            return new o2.h(true, false, r17);
        L18:
            th = move-exception;
            th.printStackTrace();
            return r13;
        }
    }

    class e implements SSCookieHandler.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2777a;

        e(Context r10) {
            this.f2777a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.b
        public boolean a() {
            return TTNetInit.cookieLogReportEnabled();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.b
        public void b(String r10, String r11, JSONObject r12) {
            if (TTNetInit.cookieLogReportEnabled() == false) goto L6;
            TTNetInit.getTTNetDepend().d(this.f2777a, r10, r11, r12);
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f2778c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f2779g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f2780h;

        f(Context r10, boolean r11, boolean r12) {
            this.f2778c = r10;
            this.f2779g = r11;
            this.f2780h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTNetInit.access$200(this.f2778c, this.f2779g, this.f2780h);
        }
    }

    public interface g {
        void a(String r10, List<n4.b> r11, Map<String, List<String>> r12);
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sCookieLogReportEnabled = false;
        sListenAppStateIndependently = false;
        sStateDelayNewStrategyEnabled = false;
        sMainThreadInitCookieEnabled = true;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new com.bytedance.frameworks.baselib.network.a();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
        sCookieManagerInitStartTime = 0;
    }

    public TTNetInit() {
    }

    private static void CookieInitFailedReport(Context r10, String r11) {
        JSONObject r12 = new JSONObject();
        r12.put(CommonConsts.APM_INNER_EVENT_COST_INIT, "failed");     // Catch: JSONException -> L5
        r12.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r11);     // Catch: JSONException -> L5
    L7:
        getTTNetDepend().d(r10, "TTNET-COOKIE", CommonConsts.APM_INNER_EVENT_COST_INIT, r12);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void OnAppActivitySuspend() {
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ACTIVITY_RESUME_SUSPEND) == null) goto L9;
        o2.a.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void OnAppActiviyResume() {
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ACTIVITY_RESUME_SUSPEND) == null) goto L9;
        o2.a.d();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static b5.c TTDnsResolve(String r10, int r11) {
        return TTDnsResolve(r10, r11, null);
    }

    public static b5.c TTDnsResolve(String r10, int r11, Map<String, String> r12) {
        if (TTNetInitMetrics.l() == false) goto L7;
        return b5.a.c().b(r10, r11, r12);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$100() {
        return sStateDelayNewStrategyEnabled;
    }

    static /* synthetic */ void access$200(Context r10, boolean r11, boolean r12) {
        tryInitCookieManager(r10, r11, r12);
    }

    static /* synthetic */ void access$300() {
        setCookieInitCompleted();
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13) {
        i.w(r10).f(r11, r12, r13, 0, 0, false);
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r15) {
        i.w(r10).f(r11, r12, r13, r14, r15, false);
    }

    public static void addClientOpaqueDataV1(Context r10, String[] r11, byte[] r12, byte[] r13) {
        i.w(r10).f(r11, r12, r13, 0, 0, true);
    }

    public static void addClientOpaqueDataV1(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r15) {
        i.w(r10).f(r11, r12, r13, r14, r15, true);
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void clearClientOpaqueData(Context r10) {
        i.w(r10).h(false);
    }

    public static void clearClientOpaqueDataV1(Context r10) {
        i.w(r10).h(true);
    }

    private static void clearSharedPreferencesFile(Context r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r10.getSharedPreferences(r11, 0).edit().clear().apply();
        return;
    }

    public static void clearTNCFileBeforeStart(Context r10) {
        if (r10 == null) goto L12;
        File r11 = new File(r10.getFilesDir(), "server.json");     // Catch: Throwable -> L13
        if (r11.exists() == false) goto L6;
        r11.delete();     // Catch: Throwable -> L13
    L6:
        File r12 = new File(r10.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L13
        if (r12.exists() == false) goto L9;
        r12.delete();     // Catch: Throwable -> L13
    L9:
        clearSharedPreferencesFile(r10, w4.a.s());
        clearSharedPreferencesFile(r10, "ttnet_tnc_config");
        clearSharedPreferencesFile(r10, c3.b.k());
        return;
    L12:
        throw new IllegalArgumentException("context is null");
    }

    private static TTDispatchResult convertReflectException(String r10, Exception r11) {
        Throwable r12 = r11.getCause();
        if ((r12 instanceof InvocationTargetException) == false) goto L5;
        Throwable r13 = r12.getCause();
        if (r13 == null) goto L9;
        String r14 = r13.getMessage();
    L11:
        if ((r13 instanceof SocketTimeoutException) == false) goto L17;
        if (INetworkCallback.TYPE_TTNET.equals(r14) == false) goto L17;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.TIMEOUT);
    L17:
        if ((r13 instanceof UnsupportedOperationException) == false) goto L23;
        if ("CronetEngine has not been initialized.".equals(r14) == false) goto L23;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L23:
        if ((r13 instanceof IllegalStateException) == false) goto L29;
        if ("Engine is shut down.".equals(r14) == false) goto L29;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L29:
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.NOT_REACHED);
    L9:
        r14 = "";
        goto L11
    L5:
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.NOT_REACHED);
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
    public static List<InetAddress> dnsLookup(String r10) {
        if (TTNetInitMetrics.l() == false) goto L24;
        b5.c r11 = TTDnsResolve(r10, 0);
        if (r11.f532a != 0) goto L22;
        List<String> r12 = r11.f533b;
        if (r12 == null) goto L22;
        if (r12.isEmpty() == true) goto L22;
        ArrayList r13 = new ArrayList();
        Iterator<String> r14 = r11.f533b.iterator();
    L12:
        if (r14.hasNext() == false) goto L17;
        byte[] r15 = InetAddress.getByName(r14.next()).getAddress();
        if (r15 == null) goto L12;
        r13.add(InetAddress.getByAddress(r10, r15));
        goto L12
    L17:
        if (r13.isEmpty() == true) goto L20;
        return r13;
    L20:
        throw new UnknownHostException(r10);
    L22:
        throw new UnknownHostException(r10);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    @Deprecated
    public static void doCommand(Context r10, String r11) {
    }

    public static void enableApiHttpIntercept(boolean r10) {
        sApiHttpInterceptEnabled = r10;
    }

    public static void enableCookieLogReport(boolean r10) {
        sCookieLogReportEnabled = r10;
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r10) {
        com.bytedance.frameworks.baselib.network.http.impl.a.P(r10);
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r10) {
        r2.b.l0(r10);
    }

    public static void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        if (r10 == true) goto L4;
    L17:
        i r16 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);     // Catch: Throwable -> L14
        if (r16 == null) goto L21;
        r16.i(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r13) == false) goto L17;
    }

    private static void feedBackCronetInitFailedLog(int r10, String r11) {
        JSONObject r12 = new JSONObject();
        r12.put("fallback", r10);     // Catch: JSONException -> L13
        r12.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r11);     // Catch: JSONException -> L13
        r12.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r13 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r13 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r12.put("abis", r13);     // Catch: JSONException -> L13
        getTTNetDepend().c("cronet_failed", r12);     // Catch: JSONException -> L13
        return;
    L6:
        String[] r14 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r14 == null) goto L11;
        if (r14.length <= 0) goto L11;
        r13 = Arrays.asList(r14).toString();     // Catch: JSONException -> L13
    }

    public static void forceInitCronetKernel() {
        if (TTNetInitMetrics.k().f1524a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r10 = TTNetInitMetrics.k();
        r10.f1524a = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
    L5:
        i.w(getTTNetDepend().getContext()).Z(false, false, false, w4.a.r(getTTNetDepend().getContext()).h(), true, sCronetProvider);
    }

    @Deprecated
    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    private static i getCronetHttpClient(TTNetInitMetrics.CronetInitMode r10) {
        if (TTNetInitMetrics.k().f1524a != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics.k().f1524a = r10;
    L6:
        if (com.bytedance.ttnet.c.c() == false) goto L9;
        i r11 = i.w(getTTNetDepend().getContext());
        r11.Z(false, true, false, w4.a.r(getTTNetDepend().getContext()).h(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r11;
    L9:
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        return i.w(getTTNetDepend().getContext()).p();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static ENV getEnv() {
        return env;
    }

    public static String getGetDomainConfigByRegion(String r10) {
        Map<String, String> r11 = sGetDomainRegionMap;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r10.toLowerCase());
    }

    public static Map<String, r2.g> getGroupRttEstimates() {
        return i.w(getTTNetDepend().getContext()).r();
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

    public static void getMappingRequestState(String r10) {
        i.w(getTTNetDepend().getContext()).s(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static r2.g getNetworkQuality() {
        return i.w(getTTNetDepend().getContext()).t();
    }

    public static r2.h getPacketLossRateMetrics(int r10) {
        return i.w(getTTNetDepend().getContext()).u(r10);
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static JSONObject getSlaSamplingSetting() {
        return sSlaSamplingSettingObject;
    }

    public static boolean getStateDelayNewStrategyEnabled() {
        return sStateDelayNewStrategyEnabled;
    }

    public static com.bytedance.ttnet.e getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static com.bytedance.ttnet.d getTTNetDepend() {
        com.bytedance.ttnet.d r10 = sITTNetDepend;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static TTNetThreadConfig.a getThreadConfigCallbackImpl() {
        return null;
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        return null;
    }

    public static void monitorLogSend(String r10, JSONObject r11) {
        com.bytedance.ttnet.d r12 = sITTNetDepend;
        if (r12 == null) goto L6;
        r12.c(r10, r11);
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

    public static void onClientIPChanged(String r10) {
        if (r10 == null) goto L5;
        sClientIPString = r10;
        return;
    }

    public static void onPublicIPsChanged(List<String> r10, List<String> r11) {
        sPublicIPv4List = r10;
        sPublicIPv6List = r11;
    }

    public static void preInitCronetKernel() {
        int r10 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r10 = 3;
    L11:
        String r11 = com.bytedance.ttnet.utils.d.c(th);
        if (r11.length() <= 1024) goto L14;
        r11 = r11.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r10, r11);
        TNCManager.m().p();
        throw th;
    L4:
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) != null) goto L18;
        r10 = n.l();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r10, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r10) {
        preconnectUrl(r10, null);
    }

    public static void preconnectUrl(String r10, Map<String, String> r11) {
        if (TTNetInitMetrics.l() == false) goto L9;
        new URL(r10).toURI();     // Catch: Exception -> L6
        i.w(getTTNetDepend().getContext()).F(r10, r11);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void removeClientOpaqueData(Context r10, String r11) {
        i.w(r10).G(r11, false);
    }

    public static void removeClientOpaqueDataV1(Context r10, String r11) {
        i.w(r10).G(r11, true);
    }

    public static void runInBackGround(Context r10, boolean r11) {
        i.w(r10).I(r11);
    }

    @Deprecated
    public static void setALogFuncAddr(long r10) {
    }

    public static void setAppSecurityLevel(int r10) {
        sAppSecurityLevel = r10;
    }

    public static void setBypassOfflineCheck(boolean r10) {
        i.L(r10);
    }

    public static void setCookieHandler(Context r10) {
        CookieHandler r11 = CookieHandler.getDefault();     // Catch: Throwable -> L23
        if (r11 == null) goto L9;
        if ((r11 instanceof SSCookieHandler) == false) goto L9;
        o2.f.L(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        return;
    L9:
        if (sCookieManagerInitStartTime > 0) goto L13;
        o2.f.L(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        return;
    L13:
        if (TTNetInitMetrics.k().f1532i != 0) goto L15;
        TTNetInitMetrics r12 = TTNetInitMetrics.k();     // Catch: Throwable -> L23
        r12.f1532i = System.nanoTime();     // Catch: Throwable -> L23
    L15:
        CookieManager r13 = null;
        r13 = CookieManager.getInstance();     // Catch: Throwable -> L18
    L17:
        CookieManager r14 = r13;
        CookieHandler.setDefault(new SSCookieHandler(r10, sDelayTime, r14, getTTNetDepend().m(), new e(r10)));     // Catch: Throwable -> L23
        o2.f.L(true);     // Catch: Throwable -> L23
        setCookieInitCompleted();     // Catch: Throwable -> L23
        TTNetInitMetrics r15 = TTNetInitMetrics.k();     // Catch: Throwable -> L23
        r15.f1533j = System.nanoTime();     // Catch: Throwable -> L23
        return;
    L18:
        th = move-exception;
        sDelayTime = 0;     // Catch: Throwable -> L23
        CookieInitFailedReport(r10, th.getMessage());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CookieInitFailedReport(r10, th.getMessage());
        th.printStackTrace();
    }

    private static void setCookieInitCompleted() {
        i r10 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);     // Catch: Throwable -> L6
        if (r10 == null) goto L9;
        r10.M();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void setCronetDepend(ICronetAppProvider r10) {
        if (r10 == null) goto L6;
        sCronetProvider = r10;
        TNCManager.u(r10);
        c5.a.d().e(r10);
        i.N(r10);
        n.s(c5.a.d());
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setDelayTime(int r10) {
        sDelayTime = r10;
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r10) {
    }

    public static void setEnv(ENV r10) {
        env = r10;
    }

    public static void setFirstRequestWaitTime(long r10) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r10) {
        if (r10 == null) goto L6;
        sGetDomainRegionMap = r10;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String r10) {
        i r11 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (r11 == null) goto L6;
        r11.R(r10);
        return;
    }

    public static void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) {
    }

    public static void setListenAppStateIndependently(boolean r10) {
        sListenAppStateIndependently = r10;
    }

    public static void setMainThreadInitCookieEnabled(boolean r10) {
        sMainThreadInitCookieEnabled = r10;
    }

    public static void setMaxHttpDiskCacheSize(long r10) {
        if (r10 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r10;
        return;
    }

    public static void setProcessFlag(int r10) {
        com.bytedance.frameworks.baselib.network.http.util.g.j(r10);
    }

    public static void setProxy(String r10) {
        if (TTNetInitMetrics.l() == false) goto L5;
        i.w(getTTNetDepend().getContext()).S(r10);
        return;
    L5:
        n.t(getTTNetDepend().getContext());
        n.x(r10);
    }

    public static void setRetryEncryptedRequestEnabled(g r10) {
        o2.f.d(ENCRYPT_RETRY_VERIFY_HEADER, new d(r10));
    }

    public static void setSlaSamplingSetting(Context r10, JSONObject r11) {
        i.w(r10).T(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        sSlaSamplingSettingObject = r11;
    }

    public static void setStateDelayNewStrategyEnabled(boolean r10) {
        sStateDelayNewStrategyEnabled = r10;
    }

    public static void setSystemApiSandbox(com.bytedance.ttnet.e r10) {
        sSystemApiSandbox = r10;
    }

    public static void setTTNetDepend(com.bytedance.ttnet.d r10) {
        sITTNetDepend = r10;
        Map<String, String> r11 = getTTNetDepend().j();
        if (TextUtils.isEmpty(r11.get("httpdns")) == false) goto L5;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L19;
        Object r13 = sITTNetDepend;
        if ((r13 instanceof com.bytedance.ttnet.a) == true) goto L15;
    L17:
        a5.b.d();
        com.bytedance.frameworks.baselib.network.http.util.c.m(r11.get(DOMAIN_BOE_KEY));
        com.bytedance.frameworks.baselib.network.http.util.c.l(r11.get(DOMAIN_BOE_HTTPS_KEY));
        c5.a.d().f(r10);
        return;
    L15:
        if (((com.bytedance.ttnet.a) r13).d() == true) goto L17;
        setAppSecurityLevel(sAppSecurityLevel | 1);
        goto L17
    L19:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty(r11.get(DOMAIN_BOE_KEY)) == true) goto L7;
    L9:
        r12 = false;
        goto L11
    L7:
        if (TextUtils.isEmpty(r11.get(DOMAIN_BOE_HTTPS_KEY)) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(com.bytedance.ttnet.g r10) {
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        i r10 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (r10 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r18 + " decompressStreamAddr:" + r20 + " freeDctxAddr:" + r22 + " isErrorAddr:" + r24 + " createDDictAddr:" + r26 + " dctxRefDDictAddr:" + r28 + " freeDDictAddr:" + r30 + " dctxResetAddr:" + r32);
    L8:
        r10.U(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public static void trigerGetDomain(Context r10) {
        triggerGetDomain(r10, false);
    }

    public static void triggerGetDomain(Context r10, boolean r11) {
        i.w(r10).X(r11);
    }

    private static void tryInitCookieManager(Context r10, boolean r11, boolean r12) {
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "tryInitCookieManager needSetCookieHandler:" + r11 + ", isMain:" + r12);
    L34:
        sCookieManagerInitStartTime = System.currentTimeMillis();     // Catch: Throwable -> L15
        if (r11 == true) goto L8;
        o2.f.L(true);     // Catch: Throwable -> L15
        setCookieInitCompleted();     // Catch: Throwable -> L15
    L32:
        ClientKeyManager.k().b(r12);
        return;
    L8:
        if (TTNetInitMetrics.k().f1532i != 0) goto L10;
        TTNetInitMetrics.k().f1532i = System.nanoTime();     // Catch: Throwable -> L15
    L10:
        CookieSyncManager.createInstance(r10);     // Catch: Throwable -> L15
        CookieManager r13 = CookieManager.getInstance();     // Catch: Throwable -> L15
        r13.setAcceptCookie(true);     // Catch: Throwable -> L15
        setCookieHandler(r10);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L32;
        Logger.d("Process", " CookieManager = " + r13.toString() + " pid = " + Process.myPid());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        if (com.bytedance.frameworks.baselib.network.http.util.g.h(r10) == false) goto L32;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) goto L32;
        if (sMainThreadInitCookieEnabled == false) goto L23;
        new Handler(Looper.getMainLooper()).post(new f(r10, r11, r12));
    L23:
        JSONObject r14 = new JSONObject();
        r14.put("error", th.getMessage());     // Catch: JSONException -> L26
    L28:
        com.bytedance.ttnet.d r15 = sITTNetDepend;
        if (r15 == null) goto L31;
        r15.c("async_init_cookie_manager_fail", r14);
    L31:
        CookieInitFailedReport(r10, th.getMessage());
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public static void tryInitTTNet(Context r10, Application r11, o2.f.d<a5.b> r12, o2.f.l<a5.b> r13, o2.f.h r14, boolean r15, boolean... r16) {
        TTNetInitMetrics.k().f1527d = System.currentTimeMillis();
        TTNetInitMetrics.k().f1528e = System.nanoTime();
        if (r10 == null) goto L35;
        w4.f.a();
        y4.a.b(r10);
        v.b(Logger.getLogLevel());
        o2.f.G(r12);
        a5.b.d();
        KevaBuilder.getInstance().setContext(r10);
        if (r16 != null) goto L7;
    L9:
        boolean r17 = false;
    L10:
        boolean r18 = com.bytedance.frameworks.baselib.network.http.util.g.h(r10);
        if (r18 == false) goto L13;
        new a("NetWork-AsyncInit", r10, r15).a();
    L20:
        TNCManager.m().v(r10, r18);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().r(r10);
        w4.a.r(r10);
        TTNetInitMetrics.k().j(r10);
        o2.f.Q(r13);
        countDownInitCompletedLatch();
        if (r18 == true) goto L25;
        TTNetInitMetrics.k().f1525b = false;
    L23:
        TTNetInitMetrics.k().f1531h = System.nanoTime();
        return;
    L25:
        o2.f.J(r14);
        if (com.bytedance.ttnet.utils.c.c() != null) goto L28;
        com.bytedance.ttnet.utils.c.f(new c(r10));
    L28:
        sLifeCycleMonitor.c(d3.e.f());
        if (r11 == null) goto L32;
        r11.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L32:
        if (com.bytedance.ttnet.c.c() == true) goto L23;
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
        goto L23
    L13:
        if (r17 == false) goto L15;
    L18:
        boolean r19 = true;
    L19:
        new b("NetWork-AsyncInit-other", r10, r19, r15).a();
        goto L20
    L15:
        if (com.bytedance.frameworks.baselib.network.http.util.g.i(r10) == true) goto L18;
        r19 = false;
        goto L19
    L7:
        if (r16.length <= 0) goto L9;
        r17 = r16[0];
        goto L10
    L35:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r10) {
        o2.f.N(r10);
    }

    public static boolean tryStartTTNetDetect(String[] r10, int r11, int r12) {
        if (r10 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.length <= 0) goto L16;
        if (r11 <= 0) goto L16;
        if (r11 > 180) goto L16;
        if (r12 < 0) goto L16;
        i.w(getTTNetDepend().getContext()).b0(r10, r11, r12);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static TTDispatchResult ttUrlDispatch(String r10) {
        return ttUrlDispatchInternal(r10, -1, true);
    }

    private static TTDispatchResult ttUrlDispatchInternal(String r10, int r11, boolean r12) {
        if (w4.a.r(getTTNetDepend().getContext()).i() == true) goto L11;
        y2.b r13 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().d(new y2.c(r10, null, null));
        if (r13 == null) goto L9;
        return new TTDispatchResult(r10, r13.f13666a, String.valueOf(com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().e()), com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.h.l().h(), TTDispatchResult.DispatchState.SUCCESS, "");
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (TTNetInitMetrics.l() == false) goto L17;
        new URL(r10).toURI();     // Catch: Exception -> L14
        return i.e0(r10, r11, r12);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r10, int r11) {
        return ttUrlDispatchV2(r10, r11, true);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r10, int r11, boolean r12) {
        new URL(r10).toURI();     // Catch: Exception -> L37
        return ttUrlDispatchInternal(r10, r11, r12);
    L5:
        e = move-exception;
        String r13 = e.getMessage();
        if ((e instanceof ReflectException) == false) goto L11;
        return convertReflectException(r10, e);
    L11:
        if ((e instanceof IllegalArgumentException) == false) goto L17;
        if (OKHTTP_DISPATCH_FAILED.equals(r13) == false) goto L17;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED);
    L17:
        if ((e instanceof IllegalStateException) == false) goto L23;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r13) == false) goto L23;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.CRONET_NOT_INIT);
    L23:
        if ((e instanceof UnknownFormatConversionException) == false) goto L29;
        if (RETURN_WRONG_FORMAT.equals(r13) == false) goto L29;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.WRONG_FORMAT);
    L29:
        if ((e instanceof URISyntaxException) == true) goto L36;
        if ((e instanceof MalformedURLException) == true) goto L36;
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.NOT_REACHED);
    L36:
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.INVALID_FINAL_URL);
    L38:
        return new TTDispatchResult(r10, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL);
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    public static void useCustomizedCookieStoreName() {
        com.bytedance.frameworks.baselib.network.http.impl.h.l();
    }
}
