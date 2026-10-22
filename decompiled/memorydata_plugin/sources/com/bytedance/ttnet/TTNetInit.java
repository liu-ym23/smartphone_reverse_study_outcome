package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.o;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.j;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.k;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.AppActivityResumeSuspendRecorder;
import com.bytedance.retrofit2.AppLaunchTimeStampProvider;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.tnc.TNCManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
    private static volatile ENV env;
    private static volatile boolean sApiHttpInterceptEnabled;
    private static volatile int sAppSecurityLevel;
    private static volatile String sClientIPString;
    public static ICronetAppProvider sCronetProvider;
    public static Map<String, String> sGetDomainRegionMap;
    private static d sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static com.bytedance.frameworks.baselib.network.b sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static volatile boolean sStateDelayNewStrategyEnabled;
    private static e sSystemApiSandbox;
    private static g sTTNetThreadConfigInfoManager;

    public static final enum ENV extends Enum<ENV> {
        private static final /* synthetic */ ENV[] $VALUES = null;
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        static {
            ENV r0 = new ENV(CipherConst.LEVEL_DEBUG, 0);
            DEBUG = r0;
            ENV r1 = new ENV("RELEASE", 1);
            RELEASE = r1;
            $VALUES = new ENV[]{r0, r1};
        }

        private ENV(String r1, int r2) {
            super(r1, r2);
        }

        public static ENV valueOf(String r2) {
            return (ENV) ZeusTransformUtils.preCheckCast(Enum.valueOf(ENV.class, r2), ENV.class, "com.obric.memorydata.plugin");
        }

        public static ENV[] values() {
            return (ENV[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ENV[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
        void a(String r1, List<Header> r2, Map<String, List<String>> r3);
    }

    static {
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sListenAppStateIndependently = false;
        sStateDelayNewStrategyEnabled = false;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new com.bytedance.frameworks.baselib.network.b();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
    }

    public TTNetInit() {
    }

    public static void OnAppActivitySuspend() {
        AppActivityResumeSuspendRecorder.OnAppActivitySuspend();
    }

    public static void OnAppActiviyResume() {
        AppActivityResumeSuspendRecorder.OnAppActiviyResume();
    }

    public static com.bytedance.ttnet.c.c TTDnsResolve(String r1, int r2) {
        return TTDnsResolve(r1, r2, null);
    }

    public static com.bytedance.ttnet.c.c TTDnsResolve(String r2, int r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (TTNetInitMetrics.a() == false) goto L7;
        return com.bytedance.ttnet.c.a.a().a(r2, r3, r5);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$100() {
        return sStateDelayNewStrategyEnabled;
    }

    static /* synthetic */ void access$200(Context r2, boolean r3, boolean r4) {
        initCookie((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ void access$300() {
        setCookieInitCompleted();
    }

    public static void addClientOpaqueData(Context r9, String[] r10, byte[] r11, byte[] r12) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).a(r10, r11, r12, 0, 0, false);
    }

    public static void addClientOpaqueData(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r16) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).a(r11, r12, r13, r14, r16, false);
    }

    public static void addClientOpaqueDataV1(Context r9, String[] r10, byte[] r11, byte[] r12) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).a(r10, r11, r12, 0, 0, true);
    }

    public static void addClientOpaqueDataV1(Context r10, String[] r11, byte[] r12, byte[] r13, long r14, long r16) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).a(r11, r12, r13, r14, r16, true);
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static void clearClientOpaqueData(Context r2) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).d(false);
    }

    public static void clearClientOpaqueDataV1(Context r2) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).d(true);
    }

    private static void clearSharedPreferencesFile(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4.getSharedPreferences(r3, 0).edit().clear().apply();
        return;
    }

    public static void clearTNCFileBeforeStart(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        File r0 = new File(r4.getFilesDir(), "server.json");     // Catch: Throwable -> L14
        if (r0.exists() == false) goto L7;
        r0.delete();     // Catch: Throwable -> L14
    L7:
        File r1 = new File(r4.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L14
        if (r1.exists() == false) goto L10;
        r1.delete();     // Catch: Throwable -> L14
    L10:
        clearSharedPreferencesFile(r4, AppConfig.getSsAppConfigFileName());
        clearSharedPreferencesFile(r4, "ttnet_tnc_config");
        clearSharedPreferencesFile(r4, com.bytedance.frameworks.baselib.network.http.d.b.g());
        return;
    L13:
        throw new IllegalArgumentException("context is null");
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
    public static List<InetAddress> dnsLookup(String r5) {
        if (TTNetInitMetrics.a() == false) goto L24;
        com.bytedance.ttnet.c.c r0 = TTDnsResolve(r5, 0);
        if (r0.f3216a != 0) goto L22;
        if (r0.d == null) goto L22;
        if (r0.d.isEmpty() == true) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r0.d.iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        byte[] r3 = InetAddress.getByName((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")).getAddress();
        if (r3 == null) goto L12;
        r1.add(InetAddress.getByAddress(r5, r3));
        goto L12
    L17:
        if (r1.isEmpty() == true) goto L20;
        return r1;
    L20:
        throw new UnknownHostException(r5);
    L22:
        throw new UnknownHostException(r5);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    @Deprecated
    public static void doCommand(Context r1, String r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    public static void enableApiHttpIntercept(boolean r0) {
        sApiHttpInterceptEnabled = r0;
    }

    @Deprecated
    public static void enableCookieLogReport(boolean r0) {
    }

    public static void enableProceedWithoutHook(boolean r0) {
        RealInterceptorChain.setProceedWithoutHookEnabled(r0);
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r0) {
        com.bytedance.frameworks.baselib.network.http.impl.a.d(r0);
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r5, int r6) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.a.b(r5);
        if (r5 == false) goto L8;
        if (r6 <= 0) goto L9;
        final long r1 = ((long) r6) * 1000;
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass7(r1, r1));
        return;
    L9:
        return;
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (r8 == true) goto L4;
    L17:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        r1.a(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L17;
    }

    private static void feedBackCronetInitFailedLog(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("fallback", r2);     // Catch: JSONException -> L13
        r0.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r3);     // Catch: JSONException -> L13
        r0.put("model", Build.MODEL);     // Catch: JSONException -> L13
        String r4 = "";
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        r4 = Build.CPU_ABI;     // Catch: JSONException -> L13
    L11:
        r0.put("abis", r4);     // Catch: JSONException -> L13
        getTTNetDepend().a("cronet_failed", r0);     // Catch: JSONException -> L13
        return;
    L6:
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L13
        if (r5 == null) goto L11;
        if (r5.length <= 0) goto L11;
        r4 = Arrays.asList(r5).toString();     // Catch: JSONException -> L13
    }

    public static void forceInitCronetKernel() {
        if (TTNetInitMetrics.c().f2272b != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.c();
        r0.f2272b = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
    L5:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(false, false, false, AppConfig.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).isCronetHttpDnsOpen(), true, sCronetProvider);
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

    private static com.bytedance.frameworks.baselib.network.http.cronet.impl.h getCronetHttpClient(TTNetInitMetrics.CronetInitMode r9) {
        if (TTNetInitMetrics.c().f2272b != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics.c().f2272b = r9;
    L6:
        if (c.b() == false) goto L9;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r10 = com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r10.a(false, true, false, AppConfig.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).isCronetHttpDnsOpen(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r10;
    L9:
        return null;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static int getEffectiveConnectionType() {
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).d();
    L5:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static ENV getEnv() {
        return env;
    }

    public static String getGetDomainConfigByRegion(String r2) {
        Map<String, String> r0 = sGetDomainRegionMap;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return null;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(sGetDomainRegionMap.get(r2.toLowerCase()), String.class, "com.obric.memorydata.plugin");
    }

    public static Map<String, com.bytedance.frameworks.baselib.network.http.cronet.impl.f> getGroupRttEstimates() {
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).f();
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

    public static void getMappingRequestState(String r3) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).b(r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.impl.f getNetworkQuality() {
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).e();
    }

    public static com.bytedance.frameworks.baselib.network.http.cronet.impl.g getPacketLossRateMetrics(int r3) {
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).d(r3);
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

    public static e getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static d getTTNetDepend() {
        d r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static TTNetThreadConfig.a getThreadConfigCallbackImpl() {
        g r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        g r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    private static void initCookie(Context r2, boolean r3, boolean r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.cookie.a.a(r5, r3, r4, new AnonymousClass6(r5));
    }

    public static void monitorLogSend(String r1, JSONObject r2) {
        d r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.f();
        return;
    }

    public static void onClientIPChanged(String r0) {
        if (r0 == null) goto L5;
        sClientIPString = r0;
        return;
    }

    public static void onPublicIPsChanged(List<String> r2, List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        sPublicIPv4List = r4;
        sPublicIPv6List = r5;
    }

    public static void preInitCronetKernel() {
        int r0 = -1;
    L7:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, IllegalArgumentException.class) == false) goto L11;
        r0 = 3;
    L11:
        String r2 = com.bytedance.ttnet.utils.d.a(th);
        if (r2.length() <= 1024) goto L14;
        r2 = r2.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r0, r2);
        TNCManager.c().f();
        throw th;
    L4:
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) != null) goto L18;
        r0 = o.e();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r0, "");     // Catch: Throwable -> L7
        return;
    }

    public static void preconnectUrl(String r1) {
        preconnectUrl(r1, null);
    }

    public static void preconnectUrl(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (TTNetInitMetrics.a() == false) goto L9;
        new URL(r3).toURI();     // Catch: Exception -> L6
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r3, r5);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void removeClientOpaqueData(Context r2, String r3) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).a(r3, false);
    }

    public static void removeClientOpaqueDataV1(Context r2, String r3) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).a(r3, true);
    }

    public static void runInBackGround(Context r2, boolean r3) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).c(r3);
    }

    @Deprecated
    public static void setALogFuncAddr(long r0) {
    }

    public static void setAppSecurityLevel(int r0) {
        sAppSecurityLevel = r0;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r0);
    }

    @Deprecated
    public static void setCookieHandler(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    }

    private static void setCookieInitCompleted() {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.g();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void setCronetDepend(ICronetAppProvider r2) {
        ICronetAppProvider r3 = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r2, ICronetAppProvider.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        sCronetProvider = r3;
        TNCManager.a(r3);
        com.bytedance.ttnet.d.a.f().a(r3);
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r3);
        o.a(com.bytedance.ttnet.d.a.f());
        return;
    L7:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    @Deprecated
    public static void setDelayTime(int r0) {
    }

    @Deprecated
    public static void setEnableURLDispatcher(boolean r0) {
    }

    public static void setEnv(ENV r0) {
        env = r0;
    }

    @Deprecated
    public static void setFirstRequestWaitTime(long r0) {
    }

    public static void setGetDomainRegionMap(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        sGetDomainRegionMap = r3;
        return;
    L7:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    @Deprecated
    public static void setHostResolverRulesForTesting(String r1) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) {
    }

    public static void setListenAppStateIndependently(boolean r0) {
        sListenAppStateIndependently = r0;
    }

    @Deprecated
    public static void setMainThreadInitCookieEnabled(boolean r0) {
    }

    public static void setMaxHttpDiskCacheSize(long r2) {
        if (r2 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r2;
        return;
    }

    public static void setMonitorProcessHookV2(com.bytedance.frameworks.baselib.network.http.f.m<com.bytedance.ttnet.b.b> r2) {
        com.bytedance.frameworks.baselib.network.http.f.a((com.bytedance.frameworks.baselib.network.http.f.m) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.frameworks.baselib.network.http.f.m.class, "com.obric.memorydata.plugin"));
    }

    public static void setProcessFlag(int r0) {
        com.bytedance.frameworks.baselib.network.http.util.g.a(r0);
    }

    public static void setProxy(String r3) {
        if (TTNetInitMetrics.a() == false) goto L5;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).c(r3);
        return;
    L5:
        o.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        o.c(r3);
    }

    public static void setRetryEncryptedRequestEnabled(a r2) {
        final a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.f.a(ENCRYPT_RETRY_VERIFY_HEADER, new AnonymousClass5(r3));
    }

    public static void setSlaSamplingSetting(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L8:
        e = move-exception;
        e.printStackTrace();
        sSlaSamplingSettingObject = r3;
        return;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "setSlaSamplingSetting");     // Catch: Exception -> L8
    L6:
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r4).a(r3);     // Catch: Exception -> L8
    }

    public static void setStateDelayNewStrategyEnabled(boolean r0) {
        sStateDelayNewStrategyEnabled = r0;
    }

    public static void setSystemApiSandbox(e r2) {
        sSystemApiSandbox = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
    }

    public static void setTTNetDepend(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        sITTNetDepend = r8;
        Map<String, String> r0 = getTTNetDepend().i();
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_HTTPDNS_KEY), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L13:
        if (ZeusTransformUtils.instanceOf(sITTNetDepend, com.bytedance.ttnet.a.class) == false) goto L18;
        if (((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(sITTNetDepend, com.bytedance.ttnet.a.class, "com.obric.memorydata.plugin")).d() == true) goto L18;
        setAppSecurityLevel(sAppSecurityLevel | 1);
    L18:
        if (ZeusTransformUtils.instanceOf(sITTNetDepend, AppLaunchTimeStampProvider.class) == false) goto L20;
        RetrofitMetrics.sAppStartTimeProvider = (AppLaunchTimeStampProvider) ZeusTransformUtils.preCheckCast(sITTNetDepend, AppLaunchTimeStampProvider.class, "com.obric.memorydata.plugin");
    L20:
        com.bytedance.ttnet.b.b.b();
        com.bytedance.frameworks.baselib.network.http.util.c.b((String) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_KEY), String.class, "com.obric.memorydata.plugin"));
        com.bytedance.frameworks.baselib.network.http.util.c.c((String) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_HTTPS_KEY), String.class, "com.obric.memorydata.plugin"));
        com.bytedance.ttnet.d.a.f().a(r8);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_KEY), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L7;
    L9:
        r2 = false;
        goto L11
    L7:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0.get(DOMAIN_BOE_HTTPS_KEY), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(g r0) {
        sTTNetThreadConfigInfoManager = r0;
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (r1 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r18 + " decompressStreamAddr:" + r20 + " freeDctxAddr:" + r22 + " isErrorAddr:" + r24 + " createDDictAddr:" + r26 + " dctxRefDDictAddr:" + r28 + " freeDDictAddr:" + r30 + " dctxResetAddr:" + r32);
    L8:
        r1.a(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public static void trigerGetDomain(Context r2) {
        triggerGetDomain((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), false);
    }

    public static void triggerGetDomain(Context r2, boolean r3) {
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).b(r3);
    }

    @Deprecated
    private static void tryInitCookieManager(Context r0, boolean r1, boolean r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r0, Context.class, "com.obric.memorydata.plugin");
    }

    public static void tryInitTTNet(Context r2, Application r3, com.bytedance.frameworks.baselib.network.http.f.d<com.bytedance.ttnet.b.b> r4, com.bytedance.frameworks.baselib.network.http.f.l<com.bytedance.ttnet.b.b> r5, com.bytedance.frameworks.baselib.network.http.f.h r6, boolean r7, boolean... r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Application r10 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.f.d r11 = (com.bytedance.frameworks.baselib.network.http.f.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.frameworks.baselib.network.http.f.d.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.f.l r12 = (com.bytedance.frameworks.baselib.network.http.f.l) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.frameworks.baselib.network.http.f.l.class, "com.obric.memorydata.plugin");
        com.bytedance.frameworks.baselib.network.http.f.h r13 = (com.bytedance.frameworks.baselib.network.http.f.h) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.frameworks.baselib.network.http.f.h.class, "com.obric.memorydata.plugin");
        TTNetInitMetrics.c().e = System.currentTimeMillis();
        TTNetInitMetrics.c().f = System.nanoTime();
        if (r9 == null) goto L40;
        com.bytedance.ttnet.config.f.a();
        com.bytedance.ttnet.a.a.a(r9);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        com.bytedance.frameworks.baselib.network.http.f.a(r11);
        com.bytedance.ttnet.b.b.b();
        com.bytedance.frameworks.baselib.network.http.cronet.a.a(new AnonymousClass1());     // Catch: Throwable -> L7
    L9:
        KevaBuilder.getInstance().setContext(r9);
        if (r8 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        boolean r15 = com.bytedance.frameworks.baselib.network.http.util.g.b(r9);
        if (r15 == false) goto L18;
        final String r0 = "NetWork-AsyncInit";
        new AnonymousClass2(r0, r9).a();
    L25:
        f.a();
        TNCManager.c().a(r9, r15);
        j.a().a(r9);
        AppConfig.getInstance(r9);
        TTNetInitMetrics.c().a(r9);
        com.bytedance.frameworks.baselib.network.http.f.a(r12);
        countDownInitCompletedLatch();
        if (r15 == true) goto L30;
        TTNetInitMetrics.c().c = false;
    L28:
        TTNetInitMetrics.c().i = System.nanoTime();
        return;
    L30:
        com.bytedance.frameworks.baselib.network.http.f.a(r13);
        if (com.bytedance.ttnet.utils.c.a() != null) goto L33;
        com.bytedance.ttnet.utils.c.a(new AnonymousClass4(r9));
    L33:
        sLifeCycleMonitor.a(com.bytedance.frameworks.baselib.network.c.e.e());
        if (r10 == null) goto L37;
        r10.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L37:
        if (c.b() == true) goto L28;
        Log.d("TTNetInit", "cronet disable");
        notifyColdStartFinish();
        goto L28
    L18:
        if (r14 == false) goto L20;
    L23:
        final boolean r16 = true;
    L24:
        final String r1 = "NetWork-AsyncInit-other";
        new AnonymousClass3(r1, r9, r16).a();
        goto L25
    L20:
        if (com.bytedance.frameworks.baselib.network.http.util.g.a(r9) == true) goto L23;
        r16 = false;
        goto L24
    L12:
        if (r8.length <= 0) goto L14;
        r14 = r8[0];
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L40:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void trySetDefaultUserAgent(String r0) {
        com.bytedance.frameworks.baselib.network.http.f.b(r0);
    }

    public static boolean tryStartTTNetDetect(String[] r4, int r5, int r6) {
        if (r4 != null) goto L5;
    L16:
        return false;
    L5:
        if (r4.length <= 0) goto L16;
        if (r5 <= 0) goto L16;
        if (r5 > 180) goto L16;
        if (r6 < 0) goto L16;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r4, r5, r6);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    public static TTDispatchResult ttUrlDispatch(String r2) {
        return ttUrlDispatchInternal(r2, -1, true);
    }

    private static TTDispatchResult ttUrlDispatchInternal(String r7, int r8, boolean r9) {
        if (AppConfig.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).isChromiumOpen() == true) goto L11;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.d r10 = j.a().a(new k(r7, null, null));
        if (r10 == null) goto L9;
        return new TTDispatchResult(r7, r10.f2516a, String.valueOf(j.a().c()), j.a().f(), TTDispatchResult.DispatchState.SUCCESS, "");
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (TTNetInitMetrics.a() == false) goto L17;
        new URL(r7).toURI();     // Catch: Exception -> L14
        return com.bytedance.frameworks.baselib.network.http.cronet.impl.h.a(r7, r8, r9);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r1, int r2) {
        return ttUrlDispatchV2(r1, r2, true);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r1, int r2, boolean r3) {
        new URL(r1).toURI();     // Catch: Exception -> L51
        return ttUrlDispatchInternal(r1, r2, r3);
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (ZeusTransformUtils.instanceOf(e, IllegalArgumentException.class) == false) goto L13;
        if (OKHTTP_DISPATCH_FAILED.equals(r4) == false) goto L13;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED, e);
    L13:
        if (ZeusTransformUtils.instanceOf(e, IllegalStateException.class) == false) goto L19;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r4) == false) goto L19;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L19:
        if (ZeusTransformUtils.instanceOf(e, UnsupportedOperationException.class) == false) goto L25;
        if ("CronetEngine has not been initialized.".equals(r4) == false) goto L25;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L25:
        if (ZeusTransformUtils.instanceOf(e, IllegalStateException.class) == false) goto L31;
        if ("Engine is shut down.".equals(r4) == false) goto L31;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L31:
        if (ZeusTransformUtils.instanceOf(e, UnknownFormatConversionException.class) == false) goto L37;
        if (RETURN_WRONG_FORMAT.equals(r4) == false) goto L37;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.WRONG_FORMAT, e);
    L37:
        if (ZeusTransformUtils.instanceOf(e, URISyntaxException.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, MalformedURLException.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(e, SocketTimeoutException.class) == false) goto L48;
        if (INetworkCallback.TYPE_TTNET.equals(r4) == false) goto L48;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.TIMEOUT, e);
    L48:
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.NOT_REACHED, e);
    L50:
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.INVALID_FINAL_URL, e);
    L51:
        e = move-exception;
        return new TTDispatchResult(r1, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL, e);
    }

    @Deprecated
    public static boolean urlDispatchEnabled() {
        return true;
    }

    @Deprecated
    public static void useCustomizedCookieStoreName() {
        com.bytedance.frameworks.baselib.network.http.cookie.f.b();
    }
}
