package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class AppLog {
    private static final f gAppLogInstance = null;
    private static volatile boolean gAppLogInstanceInitialized;

    static {
        gAppLogInstance = newInstance();
        gAppLogInstanceInitialized = false;
    }

    public AppLog() {
    }

    public static void addDataObserver(g r2) {
        g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void addEventObserver(int r2, h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r2, r4);
    }

    public static void addEventObserver(h r2) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void addLaunchObserver(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void addLogReportMonitor(l r2) {
        l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static String addNetCommonParams(Context r2, String r3, boolean r4, Level r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return gAppLogInstance.a(r6, r3, r4, r5);
    }

    public static String addNetCommonParams(Context r2, StringBuilder r3, boolean r4, Level r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return gAppLogInstance.a(r6, r3, r4, r5);
    }

    public static void addRegisterCustomHeader(Context r2, JSONObject r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r4, r3);
    }

    public static void addSessionHook(n r2) {
        n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void allowHeaderKey(String r1) {
        gAppLogInstance.k(r1);
    }

    public static void blockHeaderKey(String r1) {
        gAppLogInstance.j(r1);
    }

    public static void clearAndSetEnv() {
        gAppLogInstance.X();
    }

    public static void clearWhenSwitchChildMode(boolean r1) {
        gAppLogInstance.n(r1);
    }

    public static void disableInsertCache() {
        gAppLogInstance.ak();
    }

    public static void enableInsertCache(HashSet<String> r1, int r2, int r3) {
        gAppLogInstance.a(r1, r2, r3);
    }

    @Deprecated
    public static void flush() {
        gAppLogInstance.g();
    }

    public static void flushAsync() {
        gAppLogInstance.h();
    }

    public static void forceTimeoutReportSync(long r1) {
        gAppLogInstance.b(r1);
    }

    public static String getAbSdkVersion() {
        return gAppLogInstance.i();
    }

    public static boolean getAdjustTerminate() {
        return gAppLogInstance.J();
    }

    @Deprecated
    public static String getAid() {
        return gAppLogInstance.j();
    }

    public static String getAppId() {
        return gAppLogInstance.b();
    }

    public static IBDAccountCallback getBDAccountCallback() {
        return gAppLogInstance.G();
    }

    public static IBDInstallApi getBDInstallApi() {
        return gAppLogInstance.ac();
    }

    public static com.bytedance.applog.b.b getBatchReportSettings() {
        return gAppLogInstance.ae();
    }

    public static String getClientUdid() {
        return gAppLogInstance.r();
    }

    public static com.bytedance.applog.params.b getCommonParams() {
        return gAppLogInstance.ad();
    }

    public static Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(gAppLogInstance.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static String getDid() {
        return gAppLogInstance.m();
    }

    public static Integer getDisablePersonalization() {
        return gAppLogInstance.Y();
    }

    public static boolean getEnableEventUserId() {
        return gAppLogInstance.F();
    }

    public static boolean getEncryptAndCompress() {
        return gAppLogInstance.k();
    }

    public static com.bytedance.applog.filter.a getEventFilterByClient() {
        return gAppLogInstance.C();
    }

    public static JSONObject getHeader() {
        return gAppLogInstance.w();
    }

    public static i getHeaderCustomCallback() {
        return gAppLogInstance.z();
    }

    public static <T> T getHeaderValue(String r1, T r2, Class<T> r3) {
        return (T) gAppLogInstance.a(r1, r2, r3);
    }

    public static int getHttpMonitorPort() {
        return gAppLogInstance.B();
    }

    public static String getIid() {
        return gAppLogInstance.n();
    }

    public static o getInitConfig() {
        return gAppLogInstance.f();
    }

    public static f getInstance() {
        return gAppLogInstance;
    }

    public static k getLogCompressor() {
        return gAppLogInstance.Z();
    }

    public static m getLogSettingsCallback() {
        return gAppLogInstance.A();
    }

    public static INetworkClient getNetClient() {
        return gAppLogInstance.v();
    }

    public static String getOpenUdid() {
        return gAppLogInstance.s();
    }

    public static com.bytedance.applog.g.b getParamsExtractApi() {
        return gAppLogInstance.ah();
    }

    public static Map<String, String> getRequestHeader() {
        return gAppLogInstance.D();
    }

    public static com.bytedance.applog.filter.h getSamplingFilter() {
        return gAppLogInstance.O();
    }

    public static String getSessionId() {
        return gAppLogInstance.E();
    }

    public static String getSsid() {
        return gAppLogInstance.o();
    }

    public static void getSsidGroup(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static String getUserID() {
        return gAppLogInstance.q();
    }

    public static String getUserUniqueID() {
        return gAppLogInstance.p();
    }

    public static boolean hasStarted() {
        return gAppLogInstance.e();
    }

    public static void init(Context r2, o r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(AppLog.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (gAppLogInstanceInitialized == false) goto L9;
        Log.e("AppLog", "Default AppLog is initialized, please new a instance by `AppLog.newInstance()`");     // Catch: Throwable -> L15
        monitor-exit(AppLog.class);     // Catch: Throwable -> L15
        return;
    L9:
        gAppLogInstanceInitialized = true;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r3.F()) == false) goto L12;
        r3.d("applog_stats");     // Catch: Throwable -> L15
    L12:
        gAppLogInstance.a(r4, r3);     // Catch: Throwable -> L15
        monitor-exit(AppLog.class);     // Catch: Throwable -> L15
    }

    public static void initGroupPriority() {
        gAppLogInstance.M();
    }

    public static boolean isEnableBgSessionTask() {
        return gAppLogInstance.R();
    }

    public static boolean isEnableEventInTouristMode() {
        return gAppLogInstance.I();
    }

    public static boolean isEnableEventPriority() {
        return gAppLogInstance.K();
    }

    @Deprecated
    public static boolean isEventHitSamplingDrop(String r1) {
        return gAppLogInstance.i(r1);
    }

    @Deprecated
    public static boolean isEventHitSamplingDrop(String r1, JSONObject r2) {
        return gAppLogInstance.c(r1, r2);
    }

    public static boolean isEventHitStickySamplingDrop(String r1) {
        return gAppLogInstance.i(r1);
    }

    public static boolean isEventHitStickySamplingDrop(String r1, JSONObject r2) {
        return gAppLogInstance.c(r1, r2);
    }

    public static boolean isEventMapEnabled() {
        return gAppLogInstance.af();
    }

    public static boolean isEventParamsExtractEnabled() {
        return gAppLogInstance.ag();
    }

    public static boolean isGroupPriorityEnabled() {
        return gAppLogInstance.L();
    }

    public static boolean isNewUser() {
        return gAppLogInstance.x();
    }

    public static boolean isNewUserMode(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return gAppLogInstance.a(r3);
    }

    public static boolean isNewUserModeAvailable() {
        return gAppLogInstance.t();
    }

    public static boolean isTouristMode() {
        return gAppLogInstance.H();
    }

    public static boolean manualActivate() {
        return gAppLogInstance.l();
    }

    public static void monitorCount(String r1, int r2) {
        gAppLogInstance.b(r1, r2);
    }

    public static void monitorError(String r1, Throwable r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static f newInstance() {
        return new b();
    }

    public static NUApi newUserMode(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return gAppLogInstance.b(r3);
    }

    public static void onActivityPause() {
        gAppLogInstance.y();
    }

    public static void onActivityResumed(Activity r2, int r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r4, r3);
    }

    public static void onActivityResumed(String r1, int r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void onBgSessionTaskPause() {
        gAppLogInstance.Q();
    }

    public static void onBgSessionTaskResume() {
        gAppLogInstance.P();
    }

    public static void onEvent(String r1) {
        gAppLogInstance.g(r1);
    }

    public static void onEvent(String r1, String r2) {
        gAppLogInstance.b(r1, r2);
    }

    public static void onEvent(String r8, String r9, String r10, long r11, long r13) {
        gAppLogInstance.a(r8, r9, r10, r11, r13);
    }

    public static void onEvent(String r9, String r10, String r11, long r12, long r14, JSONObject r16) {
        gAppLogInstance.a(r9, r10, r11, r12, r14, r16);
    }

    public static void onEventV3(String r1) {
        gAppLogInstance.h(r1);
    }

    public static void onEventV3(String r1, Bundle r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void onEventV3(String r1, JSONObject r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void onEventV3WithView(View r1, String r2, String r3, JSONObject r4) {
        gAppLogInstance.a(r1, r2, r3, r4);
    }

    public static void onInternalEventV3(String r6, Bundle r7, String r8, String r9, String r10) {
        gAppLogInstance.a(r6, r7, r8, r9, r10);
    }

    public static void onInternalEventV3(String r6, JSONObject r7, String r8, String r9, String r10) {
        gAppLogInstance.a(r6, r7, r8, r9, r10);
    }

    public static void onMiscEvent(String r1, JSONObject r2) {
        gAppLogInstance.b(r1, r2);
    }

    public static void onPause(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        gAppLogInstance.d(r3);
    }

    public static void onResume(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        gAppLogInstance.c(r3);
    }

    public static void putCommonParams(Context r2, Map<String, String> r3, boolean r4, Level r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r6, r7, r4, r5);
    }

    public static void registerAbSdkVersionCallback(e r2) {
        e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void registerBgSessionTaskCallback(com.bytedance.applog.p.a r2) {
        com.bytedance.applog.p.a r3 = (com.bytedance.applog.p.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.p.a.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void registerHeaderCustomCallback(i r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void removeAllDataObserver() {
        gAppLogInstance.u();
    }

    public static void removeDataObserver(g r2) {
        g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
        gAppLogInstance.b(r3);
    }

    public static void removeEventObserver(h r2) {
        h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin");
        gAppLogInstance.b(r3);
    }

    public static void removeHeaderInfo(String r1) {
        gAppLogInstance.c(r1);
    }

    public static void removeLaunchObserver(j r2) {
        j r3 = (j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin");
        gAppLogInstance.b(r3);
    }

    public static void removeSessionHook(n r2) {
        n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
        gAppLogInstance.b(r3);
    }

    public static void resetAndReInstall(long r2, OnResetListener r4) {
        OnResetListener r5 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r4, OnResetListener.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r2, r5);
    }

    public static void resetDidWhenSwitchChildMode(Context r8, boolean r9, long r10, OnResetListener r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r12, OnResetListener.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3, r9, r10, r7);
    }

    public static void setAccount(Account r1) {
        gAppLogInstance.a(r1);
    }

    public static void setAdjustTerminate(boolean r1) {
        gAppLogInstance.e(r1);
    }

    public static void setAppLanguageAndRegion(String r1, String r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void setAppTrack(JSONObject r1) {
        gAppLogInstance.a(r1);
    }

    public static void setAutoStartGroupPriority(boolean r1) {
        gAppLogInstance.j(r1);
    }

    public static void setBDAccountCallback(IBDAccountCallback r2) {
        IBDAccountCallback r3 = (IBDAccountCallback) ZeusTransformUtils.wrapperContextForParams(r2, IBDAccountCallback.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setBDInstallEventTrackEnabled(boolean r1) {
        gAppLogInstance.v(r1);
    }

    public static void setBatchProcessEventCount(int r1) {
        gAppLogInstance.d(r1);
    }

    public static void setBatchProcessInterval(int r1) {
        gAppLogInstance.e(r1);
    }

    public static void setBgSessionReportOnPause(boolean r1) {
        gAppLogInstance.k(r1);
    }

    public static void setBgSessionTaskEnabled(boolean r1) {
        gAppLogInstance.l(r1);
    }

    public static void setBgSessionTaskNavigatorCallback(com.bytedance.applog.collector.b r2) {
        com.bytedance.applog.collector.b r3 = (com.bytedance.applog.collector.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.collector.b.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setCommonParamsEnabled(boolean r1) {
        gAppLogInstance.B(r1);
    }

    public static void setCustomHeaderControlEnabled(boolean r1) {
        gAppLogInstance.A(r1);
    }

    public static void setDataIsolateCallback(com.bytedance.applog.isolate.b r2) {
        com.bytedance.applog.isolate.b r3 = (com.bytedance.applog.isolate.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.isolate.b.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setDataIsolateEnabled(boolean r1) {
        gAppLogInstance.m(r1);
    }

    public static void setDataIsolateKey(DataIsolateKey r1) {
        gAppLogInstance.a(r1);
    }

    public static void setDefaultHttpClientProxy(Proxy r1) {
        gAppLogInstance.a(r1);
    }

    public static void setDevToolsEnable(boolean r0) {
        com.bytedance.applog.log.p.a(r0);
    }

    public static void setDisablePersonalization(int r1) {
        gAppLogInstance.c(r1);
    }

    public static void setEnableEventInTouristMode(boolean r1) {
        gAppLogInstance.d(r1);
    }

    public static void setEnableEventPriority(boolean r1) {
        gAppLogInstance.h(r1);
    }

    public static void setEnableEventUserId(boolean r1) {
        gAppLogInstance.b(r1);
    }

    public static void setEncryptAndCompress(boolean r1) {
        gAppLogInstance.a(r1);
    }

    public static void setEventFilterByClient(List<String> r2, boolean r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r4, r3);
    }

    public static void setEventForwardEnabled(boolean r1) {
        gAppLogInstance.t(r1);
    }

    public static void setEventForwardHttpHeader(String r1, String r2) {
        gAppLogInstance.d(r1, r2);
    }

    public static void setEventHandler(com.bytedance.applog.i.a r2) {
        com.bytedance.applog.i.a r3 = (com.bytedance.applog.i.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.i.a.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setEventMapEnabled(boolean r1) {
        gAppLogInstance.F(r1);
    }

    public static void setEventParamControlEnabled(boolean r1) {
        gAppLogInstance.z(r1);
    }

    public static void setEventParamsExtractEnabled(boolean r1) {
        gAppLogInstance.G(r1);
    }

    public static void setEventSamplingEnable(boolean r1) {
        gAppLogInstance.f(r1);
    }

    public static void setEventSenderEnable(boolean r1, String r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void setExpectedBatchInterval(String r1, String r2, int r3) {
        gAppLogInstance.a(r1, r2, r3);
    }

    public static void setExternalAbVersion(String r1) {
        gAppLogInstance.d(r1);
    }

    public static void setExtraParams(IExtraParams r2) {
        IExtraParams r3 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r2, IExtraParams.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setFetchConfigFirstDelayMills(long r1) {
        gAppLogInstance.c(r1);
    }

    public static void setFlushAsyncDefault(boolean r1) {
        gAppLogInstance.x(r1);
    }

    public static void setFlushThresholdEnable(boolean r1) {
        gAppLogInstance.y(r1);
    }

    public static void setGroupPriorityEnable(boolean r1) {
        gAppLogInstance.i(r1);
    }

    public static void setHeaderInfo(String r1, Object r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void setHeaderInfo(HashMap<String, Object> r1) {
        gAppLogInstance.a(r1);
    }

    public static void setHttpMonitorPort(int r1) {
        gAppLogInstance.a(r1);
    }

    public static void setInsertByTransactionEnabled(boolean r1) {
        gAppLogInstance.H(r1);
    }

    public static void setInsertEventOptEnabled(boolean r1) {
        gAppLogInstance.o(r1);
    }

    public static void setLogCompressor(k r2) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setLogSettingsCallback(m r2) {
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setLogger(ILogger r2) {
        ILogger r3 = (ILogger) ZeusTransformUtils.wrapperContextForParams(r2, ILogger.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setMaxCacheEventNum(int r1) {
        gAppLogInstance.g(r1);
    }

    public static void setMaxRequestOnceReport(int r1) {
        gAppLogInstance.f(r1);
    }

    public static void setMigrateOldAppLogDataEnabled(boolean r1) {
        gAppLogInstance.p(r1);
    }

    public static void setNavigatorCallback(com.bytedance.applog.collector.b r2) {
        com.bytedance.applog.collector.b r3 = (com.bytedance.applog.collector.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.collector.b.class, "com.obric.memorydata.plugin");
        gAppLogInstance.b(r3);
    }

    public static void setNewMonitorEnabled(boolean r1) {
        gAppLogInstance.q(r1);
    }

    public static void setNewMonitorInDebugMode(boolean r1) {
        gAppLogInstance.r(r1);
    }

    public static void setNewUserMode(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r4, r3);
    }

    public static void setPackLaunchByDesc(boolean r1) {
        gAppLogInstance.u(r1);
    }

    public static void setPageId(String r1) {
        gAppLogInstance.l(r1);
    }

    public static void setPageInfoEnabled(boolean r1) {
        gAppLogInstance.C(r1);
    }

    public static void setPageName(String r1) {
        gAppLogInstance.m(r1);
    }

    public static void setReportDropStrategy(com.bytedance.applog.o.b r2) {
        com.bytedance.applog.o.b r3 = (com.bytedance.applog.o.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.applog.o.b.class, "com.obric.memorydata.plugin");
        gAppLogInstance.a(r3);
    }

    public static void setServerFilterByNative(boolean r1) {
        gAppLogInstance.D(r1);
    }

    public static void setServerFilterSaveToKeva(boolean r1) {
        gAppLogInstance.E(r1);
    }

    public static void setTeaEventSamplingEnable(boolean r1) {
        gAppLogInstance.g(r1);
    }

    public static void setTerminateImmediately(boolean r1) {
        gAppLogInstance.s(r1);
    }

    public static void setTouchPoint(String r1) {
        gAppLogInstance.b(r1);
    }

    public static void setTouristMode(boolean r1) {
        gAppLogInstance.c(r1);
    }

    public static void setTrackResumeEvent(boolean r1) {
        gAppLogInstance.w(r1);
    }

    public static void setUriRuntime(p r1) {
        gAppLogInstance.a(r1);
    }

    public static void setUserAgent(String r1) {
        gAppLogInstance.f(r1);
    }

    public static void setUserID(long r1) {
        gAppLogInstance.a(r1);
    }

    public static void setUserUniqueID(String r1) {
        gAppLogInstance.a(r1);
    }

    public static void start() {
        gAppLogInstance.c();
    }

    public static void stop() {
        gAppLogInstance.d();
    }
}
