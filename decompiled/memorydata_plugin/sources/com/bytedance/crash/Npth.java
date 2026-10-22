package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.alog.IALogCrashObserver;
import com.bytedance.crash.alog.IAlogUploadStrategy;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.InnerCrashBodyDumper;
import com.bytedance.crash.event.BizException;
import com.bytedance.crash.event.BizExceptionManager;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.event.IGetBizException;
import com.bytedance.crash.java.CrashIgnoreHandler;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.runtime.AllDefaultUrls;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.runtime.ILogcatImpl;
import com.bytedance.crash.service.IHttpUrlConnectionInterceptor;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.bytedance.crash.soloader.NpthSoData;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.IRequestIntercept;
import com.bytedance.crash.upload.IRequestPermission;
import com.bytedance.crash.upload.LaunchScanner;
import com.bytedance.crash.util.App;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Npth {
    private static final UserDataCenter sCachedDataCenter = null;

    static class DefaultNpthApiImpl extends NpthApi {
        DefaultNpthApiImpl() {
        }

        static void registerImplObject() {
            new DefaultNpthApiImpl();
            NpthApi.setRetraceData(new AnonymousClass4());
        }

        @Override // com.bytedance.crash.NpthApi
        public void addANRInfoCallbackInner(NpthApi.IANRInfoCallback r3) {
            final NpthApi.IANRInfoCallback r4 = (NpthApi.IANRInfoCallback) ZeusTransformUtils.wrapperContextForParams(r3, NpthApi.IANRInfoCallback.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            Npth.addTag("has_register_evil_callback", String.valueOf(true));
            EvilDumpFile.setANRCallback(new AnonymousClass3(this, r4));
        }

        @Override // com.bytedance.crash.NpthApi
        public void addCustomInner(NpthApi.CustomDataCallback r3) {
            final NpthApi.CustomDataCallback r4 = (NpthApi.CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r3, NpthApi.CustomDataCallback.class, "com.obric.memorydata.plugin");
            Npth.addAttachUserData(new AnonymousClass1(this, r4), CrashType.ALL);
        }

        @Override // com.bytedance.crash.NpthApi
        public void addCustomInner(NpthApi.CustomDataCallback r6, String r7) {
            final NpthApi.CustomDataCallback r8 = (NpthApi.CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r6, NpthApi.CustomDataCallback.class, "com.obric.memorydata.plugin");
            CrashType[] r0 = CrashType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L11;
            CrashType r3 = r0[r2];
            if (r3.getName().equals(r7) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            Npth.addAttachUserData(new AnonymousClass2(this, r8), r3);
            return;
        }

        @Override // com.bytedance.crash.NpthApi
        public void addTagsInner(Map<String, String> r2) {
            Npth.addTags((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bytedance.crash.NpthApi
        public void checkInnerSo(String r1) {
            NpthSoData.checkSoFile(r1, NpthBuildConfig.VERSION_NAME);
        }

        @Override // com.bytedance.crash.NpthApi
        public void checkInnerSo(String r1, String r2) {
            NpthSoData.checkSoFile(r1, r2);
        }

        @Override // com.bytedance.crash.NpthApi
        public String getByTraceIDInner() {
            return BytestConfig.getBytraceId();
        }

        @Override // com.bytedance.crash.NpthApi
        public void uploadKilledHistoryInner() {
        }
    }

    static {
        sCachedDataCenter = MonitorManager.getAppMonitorUserDataCenter();
    }

    public Npth() {
    }

    public static void addAttachLongUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addAttachUserData(r4, r3);
    }

    public static void addAttachUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addAttachUserData(r4, r3);
    }

    public static void addCustomCrashReasonArray(String r1, String r2) {
        sCachedDataCenter.addCrashReasonArray(r1, r2);
    }

    public static void addImportTag(String r0, String r1) {
        TagService.addImportTag(r0, r1);
    }

    public static void addImportTags(Map<? extends String, ? extends String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L9;
        TagService.addImportTags(r3);
        return;
    }

    public static boolean addNativeProtectorConfig(JSONObject r0) {
        return CrashProtector.addConfig(r0);
    }

    public static void addTag(String r1, String r2) {
        TagService.addTag(r1, r2, sCachedDataCenter);
    }

    public static void addTags(Map<? extends String, ? extends String> r2) {
        TagService.addTags((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), sCachedDataCenter);
    }

    public static void addUserCrashInfoCallback(IUserCrashInfoCallback r2, CrashType r3) {
        IUserCrashInfoCallback r4 = (IUserCrashInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, IUserCrashInfoCallback.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        sCachedDataCenter.addUserCrashInfoCallback(r4, r3);
        return;
    }

    public static void addWhiteLogType(String r0) {
        EnsureDeliverer.addWhiteLogType(r0);
    }

    public static void clean() {
        EnsureDeliverer.clean();
    }

    public static void customActivityName(CustomActivity r2) {
        ActivityLifecycle.setCustomActivity((CustomActivity) ZeusTransformUtils.wrapperContextForParams(r2, CustomActivity.class, "com.obric.memorydata.plugin"));
    }

    public static void dumpHprof(String r0) {
        NativeBridge.dumpHprof(r0);
    }

    public static void enableALogCollector(String r2, IALogCrashObserver r3, IAlogUploadStrategy r4) {
        NpthCore.enableALogCollector(r2, (IALogCrashObserver) ZeusTransformUtils.wrapperContextForParams(r3, IALogCrashObserver.class, "com.obric.memorydata.plugin"), (IAlogUploadStrategy) ZeusTransformUtils.wrapperContextForParams(r4, IAlogUploadStrategy.class, "com.obric.memorydata.plugin"));
    }

    public static void enableGwpAsan(boolean r0) {
        if (r0 == false) goto L5;
        NpthCore.EnableGwpAsan();
        return;
    }

    public static int fixScudoVmaLeak() {
        return RepairAdapter.fixScudoVmaLeak();
    }

    public static ConfigManager getConfigManager() {
        return NpthBus.getConfigManager();
    }

    @Deprecated
    public static long getFileSize(String r2) {
        return 0;
    }

    @Deprecated
    public static long getFolderSize(String r2) {
        return 0;
    }

    public static boolean hasCrash() {
        return NpthCore.hasCrash();
    }

    @Deprecated
    public static boolean hasCrashWhenNativeCrash() {
        return false;
    }

    public static void ignoreExceptionTag(boolean r0) {
        UserDataCenter.setIgnoreExceptionTagEnable(r0);
    }

    public static synchronized void init(Application r0, Context r1, ICommonParams r2, boolean r3, boolean r4, boolean r5, boolean r6, long r7) {
        monitor-enter(Npth.class);
        Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r0, Application.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        init((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r2, ICommonParams.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r3, ICommonParams r4) {
        monitor-enter(Npth.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        ICommonParams r6 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r4, ICommonParams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (isInit() == false) goto L8;
        monitor-exit(Npth.class);
        return;
    L8:
        InitMonitor.start();     // Catch: Throwable -> L11
        final AppMonitor r7 = MonitorManager.createInnerAppMonitor(r5, r6);     // Catch: Throwable -> L11
        r7.registerBodyHeaderDumper(new InnerCrashBodyDumper(r6));     // Catch: Throwable -> L11
        DefaultNpthApiImpl.registerImplObject();     // Catch: Throwable -> L11
        DefaultWorkThread.post(new AnonymousClass1(r7));     // Catch: Throwable -> L11
        InitMonitor.end();     // Catch: Throwable -> L11
        monitor-exit(Npth.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r7, ICommonParams r8, boolean r9, boolean r10, boolean r11) {
        monitor-enter(Npth.class);
        init((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.memorydata.plugin"), r9, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r9, ICommonParams r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(Npth.class);
        init((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r10, ICommonParams.class, "com.obric.memorydata.plugin"), r11, r12, r13, r14, 0);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r11, ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        init(null, (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r12, ICommonParams.class, "com.obric.memorydata.plugin"), r13, r14, r15, r16, r17);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(Context r7, ICommonParams r8) {
        monitor-enter(Npth.class);
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        ICommonParams r2 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        NpthCore.setCurrentMiniAppProcess(true);     // Catch: Throwable -> L7
        init(r1, r2, true, false, true, true);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(Context r7, ICommonParams r8, int r9, String r10) {
        monitor-enter(Npth.class);
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        ICommonParams r2 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        NpthCore.setCurrentMiniAppProcess(true);     // Catch: Throwable -> L7
        NpthCore.registerMiniApp(r9, r10);     // Catch: Throwable -> L7
        init(r1, r2, true, true, true, true);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized EventMonitor initSDK(Context r8, String r9, int r10, long r11, String r13) {
        monitor-enter(Npth.class);
        EventMonitor r12 = MonitorManager.createEventMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), r9, r10, r11, r13);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isANREnable() {
        return NpthCore.isInit();
    }

    public static boolean isInit() {
        if (MonitorManager.getAppMonitor() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isJavaCrashEnable() {
        return NpthCore.isInit();
    }

    public static boolean isNativeCrashEnable() {
        return NpthCore.isInit();
    }

    public static boolean isRunning() {
        return NpthCore.isAnrThreadRunning();
    }

    @Deprecated
    public static boolean isStopUpload() {
        return NpthCore.isStopUpload();
    }

    @Deprecated
    public static void openANRMonitor() {
    }

    @Deprecated
    public static void openJavaCrashMonitor() {
    }

    @Deprecated
    public static boolean openNativeCrashMonitor() {
        return false;
    }

    public static int optMtkBuffer(int r0) {
        return RepairAdapter.startOptMtkBuffer(r0);
    }

    public static void optProcessTrackDisk() {
        UserDataCenter.optProcessTrackDisk();
    }

    public static void pause() {
        EnsureConfig.setStopEnable(true);
        EventConfig.setStopEnable(true);
    }

    public static void registerANRCallback(IANRCallback r2) {
        IANRCallback r3 = (IANRCallback) ZeusTransformUtils.wrapperContextForParams(r2, IANRCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addANRCallback(r3);
    }

    public static void registerAnrUploadCallback(IAnrUploadCallback r2) {
        IAnrUploadCallback r3 = (IAnrUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, IAnrUploadCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addAnrUploadCallback(r3);
    }

    public static void registerCrashCallback(ICrashCallback r2, CrashType r3) {
        ICrashCallback r4 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICrashCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addCrashCallback(r4, r3);
    }

    @Deprecated
    public static void registerCrashCallbackOnDrop(CrashCallbackEx r0, CrashType r1) {
    }

    public static void registerCrashInfoCallback(CrashInfoCallback r1, CrashType r2) {
        sCachedDataCenter.addCrashInfoCallback(r1, r2);
    }

    public static void registerHprofCallback(IOOMCallback r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOOMCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addHprofCallback(r3);
    }

    public static void registerOOMCallback(IOOMCallback r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOOMCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addOOMCallback(r3);
    }

    public static void registerPreANRCallback(IPreANRCallback r2) {
        IPreANRCallback r3 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r2, IPreANRCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addPreANRCallback(r3);
    }

    @Deprecated
    public static void registerPreCrashCallback(IPreCrashCallback r2, CrashType r3) {
        IPreCrashCallback r4 = (IPreCrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, IPreCrashCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.addPreCrashCallback(r4, r3);
    }

    public static void registerSdk(int r1, String r2) {
        sCachedDataCenter.registerSdkInfo(r1, r2);
    }

    public static void registerSdk(String r1, String r2) {
        sCachedDataCenter.registerInnerSdkInfo(r1, r2);
    }

    public static void removeAttachLongUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removeAttachUserData(r3, r4);
    }

    public static void removeAttachUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removeAttachUserData(r3, r4);
    }

    public static void removeCrashInfoCallback(IUserCrashInfoCallback r2, CrashType r3) {
        IUserCrashInfoCallback r4 = (IUserCrashInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, IUserCrashInfoCallback.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        sCachedDataCenter.removeUserCrashInfoCallback(r4, r3);
        return;
    }

    public static void removeCustomCrashReasonArray(String r1) {
        sCachedDataCenter.removeCrashReasonArray(r1);
    }

    public static void removeImportTag(String r0) {
        TagService.removeImportTag(r0);
    }

    public static void removeTag(String r1) {
        TagService.remove(r1, sCachedDataCenter);
    }

    public static void reportBizException(String r2, IGetBizException r3) {
        reportBizException(r2, (IGetBizException) ZeusTransformUtils.wrapperContextForParams(r3, IGetBizException.class, "com.obric.memorydata.plugin"), false);
    }

    public static void reportBizException(String r7, IGetBizException r8, boolean r9) {
        IGetBizException r10 = (IGetBizException) ZeusTransformUtils.wrapperContextForParams(r8, IGetBizException.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        if (r10 != null) goto L7;
        return;
    L7:
        if (BizExceptionManager.isConfigValid() == true) goto L9;
    L11:
        BizException r11 = r10.getException();
        if (r11 != null) goto L14;
        return;
    L14:
        BizExceptionManager.getInstance().reportException(r7, r11.getThrowable(), r11.getMessage(), r11.getFilters(), r11.getCustomData(), r9);
        return;
    L9:
        if (BizExceptionManager.isSample(r7) == true) goto L11;
        return;
    }

    public static void reportBizException(String r2, Throwable r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        if (r3 == null) goto L9;
        reportBizException(r2, r3, r4, r6, false);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r8, Throwable r9, String r10, Map<String, String> r11, Map<String, String> r12) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L9;
        reportBizException(r8, r9, r10, r5, r6, false);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r9, Throwable r10, String r11, Map<String, String> r12, Map<String, String> r13, boolean r14) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L9;
        BizExceptionManager.getInstance().reportException(r9, r10, r11, r6, r7, r14);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r7, Throwable r8, String r9, Map<String, String> r10, boolean r11) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        if (r8 == null) goto L9;
        BizExceptionManager.getInstance().reportException(r7, r8, r9, r4, null, r11);
        return;
    L9:
        return;
    }

    public static void reportDartError(String r0) {
        NpthCore.reportDartError(r0);
    }

    public static void reportDartError(String r2, Map<? extends String, ? extends String> r3, Map<String, String> r4, IUploadCallback r5) {
        NpthCore.reportDartError(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), (IUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, IUploadCallback.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public static void reportError(String r0) {
        NpthCore.reportError(r0);
    }

    @Deprecated
    public static void reportError(Throwable r0) {
        NpthCore.reportError(r0);
    }

    public static void reportGameException(String r0, String r1, String r2) {
        NpthCore.reportGameException(r0, r1, r2);
    }

    public static void resume() {
        EnsureConfig.setStopEnable(false);
        EventConfig.setStopEnable(false);
    }

    public static void scanNativeCrash(Context r13, CrashCallbackEx r14, String[] r15) {
        List<CrashSummary> r16 = CrashManager.getNativeCrashList((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin"));
        if (r16 != null) goto L5;
        return;
    L5:
        Iterator<CrashSummary> r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L12;
        CrashSummary r18 = (CrashSummary) ZeusTransformUtils.preCheckCast(r17.next(), CrashSummary.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L7;
        r14.onCrash(0, null, r18.getCrashType(), r18.getStartTime(), r18.getCrashTime(), r18.getProcessName(), r18.getStackTrace(), null, null);
        goto L7
    }

    @Deprecated
    public static void setANRCheckEnable(boolean r0) {
    }

    public static void setANRImprovementOpt(boolean r0) {
        GlobalSwitch.setANRImprovementOpt(r0);
    }

    @Deprecated
    public static void setAlogFlushAddr(long r0) {
    }

    public static void setAlogFlushV2Addr(long r0) {
        AlogManager.setAlogFlushFunction(r0);
    }

    @Deprecated
    public static void setAlogLogDirAddr(long r0) {
    }

    @Deprecated
    public static void setAlogWriteAddr(long r0) {
    }

    public static void setAnrDisableDumpData(boolean r0) {
        AnrManager.setAnrDisableDumpData(r0);
    }

    @Deprecated
    public static void setAnrInfoFileObserver(String r2, IFileContentGetter r3) {
        NpthCore.setAnrInfoFileObserver(r2, (IFileContentGetter) ZeusTransformUtils.wrapperContextForParams(r3, IFileContentGetter.class, "com.obric.memorydata.plugin"));
    }

    public static void setAnrMonitorOpt(boolean r0) {
        GlobalSwitch.setAnrMonitorOpt(r0);
    }

    public static void setAnrResendSigquit(boolean r0) {
        NpthCore.setAnrResendSigquit(r0);
    }

    public static void setApplication(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        Global.setApplication(r3);
        return;
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData r2, CrashType r3) {
        addAttachUserData((AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.memorydata.plugin"), r3);
    }

    @Deprecated
    public static void setBusiness(String r0) {
        Global.setBusiness(r0);
    }

    public static void setCloseBgAnr(boolean r0) {
        UserDataCenter.setCloseBgAnr(r0);
    }

    public static void setCrashAccessibilityEnable(boolean r0) {
        CrashAccessibilityMonitor.setCrashAccessibilityEnable(r0);
    }

    public static void setCrashFilter(ICrashFilter r2) {
        ICrashFilter r3 = (ICrashFilter) ZeusTransformUtils.wrapperContextForParams(r2, ICrashFilter.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.setCrashFilter(r3);
    }

    public static void setCrashMonitorService(ICrashMonitorService r2) {
        Global.setCrashMonitorService((ICrashMonitorService) ZeusTransformUtils.wrapperContextForParams(r2, ICrashMonitorService.class, "com.obric.memorydata.plugin"));
    }

    public static void setCrashUploadCallback(CrashUploadCallback r2) {
        CrashUploadCallback r3 = (CrashUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, CrashUploadCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.setUploadCallback(r3);
    }

    public static void setCurProcessName(String r0) {
        App.setCurProcessName(r0);
    }

    public static void setCustomCrashReasonArrayLimit(String r1, int r2) {
        sCachedDataCenter.setCrashReasonArrayLimit(r1, r2);
    }

    public static void setDomainName(String r1) {
        AllDefaultUrls.setDomainName(new URL(r1).getHost());     // Catch: Throwable -> L4
        return;
    }

    public static void setDumpAnrAsync(boolean r0) {
        NpthCore.setDumpAnrAsync(r0);
    }

    public static void setEncryptImpl(IEncrypt r2) {
        NpthCore.setEncryptImpl((IEncrypt) ZeusTransformUtils.wrapperContextForParams(r2, IEncrypt.class, "com.obric.memorydata.plugin"));
    }

    public static void setFixDumpStack(boolean r0) {
        RepairAdapter.setFixDumpStack(r0);
    }

    public static void setIgnoreHandler(CrashIgnoreHandler r0) {
        JavaCrashHandler.setIgnoreHandler(r0);
    }

    @Deprecated
    public static void setInitAnrAhead(boolean r0) {
    }

    @Deprecated
    public static void setLogcatImpl(ILogcatImpl r2) {
        NpthCore.setLogcatImpl((ILogcatImpl) ZeusTransformUtils.wrapperContextForParams(r2, ILogcatImpl.class, "com.obric.memorydata.plugin"));
    }

    public static void setMaxCacheSize(int r0) {
        EnsureDeliverer.setMaxCacheCount(r0);
    }

    public static void setNetworkCallback(INetworkCallback r2) {
        NpthNetworkApi.setNetworkCallback((INetworkCallback) ZeusTransformUtils.wrapperContextForParams(r2, INetworkCallback.class, "com.obric.memorydata.plugin"));
    }

    public static void setNpthInitOptEnable(boolean r0) {
        UserDataCenter.setNpthInitOptEnable(r0);
    }

    public static void setOpenDumpTraceOpt(boolean r0) {
        UserDataCenter.setOpenDumpTraceOpt(r0);
    }

    public static void setOpenNewAnrMonitor(boolean r0) {
        GlobalSwitch.setOpenNewAnrMonitor(r0);
    }

    public static void setQueueLimitSize(int r0) {
        EnsureDeliverer.setQueueLimitSize(r0);
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider r2) {
        NpthNetworkApi.setRequestHeaderProvider((IRequestHeaderProvider) ZeusTransformUtils.wrapperContextForParams(r2, IRequestHeaderProvider.class, "com.obric.memorydata.plugin"));
    }

    public static void setRequestIntercept(IRequestIntercept r2) {
        NpthCore.setRequestIntercept((IRequestIntercept) ZeusTransformUtils.wrapperContextForParams(r2, IRequestIntercept.class, "com.obric.memorydata.plugin"));
    }

    public static void setRequestPermission(IRequestPermission r2) {
        CrashUploader.setRequestPermission((IRequestPermission) ZeusTransformUtils.wrapperContextForParams(r2, IRequestPermission.class, "com.obric.memorydata.plugin"));
    }

    public static void setScriptStackCallback(IScriptCallback r2) {
        NpthCore.setScriptStackCallback((IScriptCallback) ZeusTransformUtils.wrapperContextForParams(r2, IScriptCallback.class, "com.obric.memorydata.plugin"));
    }

    public static void setTagCacheService(ITagCacheService r2) {
        TagService.setTagCacheService((ITagCacheService) ZeusTransformUtils.wrapperContextForParams(r2, ITagCacheService.class, "com.obric.memorydata.plugin"));
        UserDataCenter r0 = sCachedDataCenter;
        TagService.addTags(new HashMap(r0.getCacheCustomTags()), r0);
        r0.clearCustomTags();
    }

    public static void setTagOpt(boolean r1) {
        sCachedDataCenter.setTagOpt(r1);
    }

    public static void setTerminateMonitorDelayTime(long r0) {
    }

    public static void setTerminateOpt(boolean r0) {
        UserDataCenter.setTerminateOpt(r0);
    }

    public static void setUploadDelayTime(long r0) {
        LaunchScanner.setUploadDelayTime(r0);
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor r2) {
        CrashUploader.setUrlConnectionInterceptor((IHttpUrlConnectionInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, IHttpUrlConnectionInterceptor.class, "com.obric.memorydata.plugin"));
    }

    public static void setUseLocalDomain(boolean r0) {
        AppMonitorConfigService.setUseLocalDomain(r0);
    }

    public static int startOptMtkBuffer(int r0) {
        return NpthCore.startOptMtkBuffer(r0);
    }

    public static void stopAnr() {
        NpthCore.stopAnr();
    }

    @Deprecated
    public static void stopEnsure() {
    }

    @Deprecated
    public static void stopUpload() {
    }

    public static void unregisterCrashCallback(ICrashCallback r2, CrashType r3) {
        ICrashCallback r4 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICrashCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removeCrashCallback(r4, r3);
    }

    public static void unregisterHprofCallback(IOOMCallback r1, CrashType r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r1, IOOMCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removeHprofCallback(r3);
    }

    public static void unregisterOOMCallback(IOOMCallback r1, CrashType r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r1, IOOMCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removeOOMCallback(r3);
    }

    public static void unregisterPreANRCallback(IPreANRCallback r2) {
        IPreANRCallback r3 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r2, IPreANRCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removePreANRCallback(r3);
    }

    @Deprecated
    public static void unregisterPreCrashCallback(IPreCrashCallback r2, CrashType r3) {
        IPreCrashCallback r4 = (IPreCrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, IPreCrashCallback.class, "com.obric.memorydata.plugin");
        sCachedDataCenter.removePreCrashCallback(r4, r3);
    }
}
