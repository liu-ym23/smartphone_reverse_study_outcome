package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Npth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1468a = 0;
    private static final UserDataCenter sCachedDataCenter = null;

    static class DefaultNpthApiImpl extends NpthApi {
        DefaultNpthApiImpl() {
        }

        static void registerImplObject() {
            new DefaultNpthApiImpl();
            NpthApi.setRetraceData(new AnonymousClass4());
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addANRInfoCallbackInner(final NpthApi.IANRInfoCallback r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            Npth.addTag("has_register_evil_callback", String.valueOf(true));
            EvilDumpFile.setANRCallback(new AnonymousClass3(this, r10));
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addCustomInner(final NpthApi.CustomDataCallback r10) {
            Npth.addAttachUserData(new AnonymousClass1(this, r10), CrashType.ALL);
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addCustomInner(final NpthApi.CustomDataCallback r10, String r11) {
            CrashType[] r12 = CrashType.values();
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L11;
            CrashType r15 = r12[r14];
            if (r15.getName().equals(r11) == true) goto L6;
            r14 = r14 + 1;
            goto L3
        L6:
            Npth.addAttachUserData(new AnonymousClass2(this, r10), r15);
            return;
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addTagsInner(Map<String, String> r10) {
            Npth.addTags(r10);
        }

        @Override // com.bytedance.crash.NpthApi
        protected void checkInnerSo(String r10) {
            NpthSoData.checkSoFile(r10, NpthBuildConfig.VERSION_NAME);
        }

        @Override // com.bytedance.crash.NpthApi
        protected void checkInnerSo(String r10, String r11) {
            NpthSoData.checkSoFile(r10, r11);
        }

        @Override // com.bytedance.crash.NpthApi
        protected String getByTraceIDInner() {
            return BytestConfig.getBytraceId();
        }

        @Override // com.bytedance.crash.NpthApi
        protected void uploadKilledHistoryInner() {
        }
    }

    static {
        sCachedDataCenter = MonitorManager.getAppMonitorUserDataCenter();
    }

    public Npth() {
    }

    public static void addAttachLongUserData(AttachUserData r10, CrashType r11) {
        sCachedDataCenter.addAttachUserData(r10, r11);
    }

    public static void addAttachUserData(AttachUserData r10, CrashType r11) {
        sCachedDataCenter.addAttachUserData(r10, r11);
    }

    public static void addCustomCrashReasonArray(@NonNull String r10, String r11) {
        sCachedDataCenter.addCrashReasonArray(r10, r11);
    }

    public static void addImportTag(String r10, String r11) {
        TagService.addImportTag(r10, r11);
    }

    public static void addImportTags(Map<? extends String, ? extends String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        TagService.addImportTags(r10);
        return;
    }

    public static boolean addNativeProtectorConfig(JSONObject r10) {
        return CrashProtector.addConfig(r10);
    }

    public static void addTag(String r10, String r11) {
        TagService.addTag(r10, r11, sCachedDataCenter);
    }

    public static void addTags(Map<? extends String, ? extends String> r10) {
        TagService.addTags(r10, sCachedDataCenter);
    }

    public static void addUserCrashInfoCallback(IUserCrashInfoCallback r10, CrashType r11) {
        if (r10 == null) goto L5;
        sCachedDataCenter.addUserCrashInfoCallback(r10, r11);
        return;
    }

    public static void addWhiteLogType(String r10) {
        EnsureDeliverer.addWhiteLogType(r10);
    }

    public static void clean() {
        EnsureDeliverer.clean();
    }

    @Keep
    public static void customActivityName(CustomActivity r10) {
        ActivityLifecycle.setCustomActivity(r10);
    }

    public static void dumpHprof(String r10) {
        NativeBridge.dumpHprof(r10);
    }

    public static void enableALogCollector(String r10, IALogCrashObserver r11, IAlogUploadStrategy r12) {
        NpthCore.enableALogCollector(r10, r11, r12);
    }

    public static void enableGwpAsan(boolean r10) {
        if (r10 == false) goto L5;
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
    public static long getFileSize(String r10) {
        return 0;
    }

    @Deprecated
    public static long getFolderSize(String r10) {
        return 0;
    }

    public static boolean hasCrash() {
        return NpthCore.hasCrash();
    }

    @Deprecated
    public static boolean hasCrashWhenNativeCrash() {
        return false;
    }

    public static void ignoreExceptionTag(boolean r10) {
        UserDataCenter.setIgnoreExceptionTagEnable(r10);
    }

    public static synchronized void init(@Nullable Application r10, @NonNull Context r11, @NonNull ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        init(r11, r12);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(@NonNull Context r10, @NonNull ICommonParams r11) {
        monitor-enter(Npth.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isInit() == false) goto L8;
        monitor-exit(Npth.class);
        return;
    L8:
        InitMonitor.start();     // Catch: Throwable -> L11
        final AppMonitor r12 = MonitorManager.createInnerAppMonitor(r10, r11);     // Catch: Throwable -> L11
        r12.registerBodyHeaderDumper(new InnerCrashBodyDumper(r11));     // Catch: Throwable -> L11
        DefaultNpthApiImpl.registerImplObject();     // Catch: Throwable -> L11
        DefaultWorkThread.post(new AnonymousClass1(r12));     // Catch: Throwable -> L11
        InitMonitor.end();     // Catch: Throwable -> L11
        monitor-exit(Npth.class);
    }

    public static synchronized void init(@NonNull Context r10, @NonNull ICommonParams r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(Npth.class);
        init(r10, r11, r12, r12, r13, r14);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(@NonNull Context r10, @NonNull ICommonParams r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        monitor-enter(Npth.class);
        init(r10, r11, r12, r13, r14, r15, 0);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(@NonNull Context r11, @NonNull ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        init(null, r11, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(@NonNull Context r10, @NonNull ICommonParams r11) {
        monitor-enter(Npth.class);
        NpthCore.setCurrentMiniAppProcess(true);     // Catch: Throwable -> L8
        init(r10, r11, true, false, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(@NonNull Context r10, @NonNull ICommonParams r11, int r12, String r13) {
        monitor-enter(Npth.class);
        NpthCore.setCurrentMiniAppProcess(true);     // Catch: Throwable -> L8
        NpthCore.registerMiniApp(r12, r13);     // Catch: Throwable -> L8
        init(r10, r11, true, true, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized EventMonitor initSDK(@NonNull Context r10, String r11, int r12, long r13, String r14) {
        monitor-enter(Npth.class);
        EventMonitor r15 = MonitorManager.createEventMonitor(r10, r11, r12, r13, r14);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return r15;
    L8:
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

    public static int optMtkBuffer(int r10) {
        return RepairAdapter.startOptMtkBuffer(r10);
    }

    public static void optProcessTrackDisk() {
        UserDataCenter.optProcessTrackDisk();
    }

    public static void pause() {
        EnsureConfig.setStopEnable(true);
        EventConfig.setStopEnable(true);
    }

    public static void registerANRCallback(IANRCallback r10) {
        sCachedDataCenter.addANRCallback(r10);
    }

    public static void registerAnrUploadCallback(IAnrUploadCallback r10) {
        sCachedDataCenter.addAnrUploadCallback(r10);
    }

    public static void registerCrashCallback(ICrashCallback r10, CrashType r11) {
        sCachedDataCenter.addCrashCallback(r10, r11);
    }

    @Deprecated
    public static void registerCrashCallbackOnDrop(CrashCallbackEx r10, CrashType r11) {
    }

    public static void registerCrashInfoCallback(CrashInfoCallback r10, CrashType r11) {
        sCachedDataCenter.addCrashInfoCallback(r10, r11);
    }

    public static void registerHprofCallback(IOOMCallback r10) {
        sCachedDataCenter.addHprofCallback(r10);
    }

    public static void registerOOMCallback(IOOMCallback r10) {
        sCachedDataCenter.addOOMCallback(r10);
    }

    public static void registerPreANRCallback(IPreANRCallback r10) {
        sCachedDataCenter.addPreANRCallback(r10);
    }

    @Deprecated
    public static void registerPreCrashCallback(IPreCrashCallback r10, CrashType r11) {
        sCachedDataCenter.addPreCrashCallback(r10, r11);
    }

    public static void registerSdk(int r10, String r11) {
        sCachedDataCenter.registerSdkInfo(r10, r11);
    }

    public static void registerSdk(String r10, String r11) {
        sCachedDataCenter.registerInnerSdkInfo(r10, r11);
    }

    public static void removeAttachLongUserData(AttachUserData r10, CrashType r11) {
        sCachedDataCenter.removeAttachUserData(r11, r10);
    }

    public static void removeAttachUserData(AttachUserData r10, CrashType r11) {
        sCachedDataCenter.removeAttachUserData(r11, r10);
    }

    public static void removeCrashInfoCallback(IUserCrashInfoCallback r10, CrashType r11) {
        if (r10 == null) goto L5;
        sCachedDataCenter.removeUserCrashInfoCallback(r10, r11);
        return;
    }

    public static void removeCustomCrashReasonArray(String r10) {
        sCachedDataCenter.removeCrashReasonArray(r10);
    }

    public static void removeImportTag(String r10) {
        TagService.removeImportTag(r10);
    }

    public static void removeTag(String r10) {
        TagService.remove(r10, sCachedDataCenter);
    }

    public static void reportBizException(String r10, IGetBizException r11) {
        reportBizException(r10, r11, false);
    }

    public static void reportBizException(String r10, IGetBizException r11, boolean r12) {
        if (r10 == null) goto L15;
        if (r11 != null) goto L6;
        return;
    L6:
        if (BizExceptionManager.isConfigValid() == true) goto L8;
    L10:
        BizException r13 = r11.getException();
        if (r13 != null) goto L13;
        return;
    L13:
        BizExceptionManager.getInstance().reportException(r10, r13.getThrowable(), r13.getMessage(), r13.getFilters(), r13.getCustomData(), r12);
        return;
    L8:
        if (BizExceptionManager.isSample(r10) == true) goto L10;
        return;
    }

    public static void reportBizException(String r10, Throwable r11, String r12, Map<String, String> r13) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        reportBizException(r10, r11, r12, r13, false);
        return;
    L8:
        return;
    }

    public static void reportBizException(String r10, Throwable r11, String r12, Map<String, String> r13, Map<String, String> r14) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        reportBizException(r10, r11, r12, r13, r14, false);
        return;
    L8:
        return;
    }

    public static void reportBizException(String r10, Throwable r11, String r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        BizExceptionManager.getInstance().reportException(r10, r11, r12, r13, r14, r15);
        return;
    L8:
        return;
    }

    public static void reportBizException(String r10, Throwable r11, String r12, Map<String, String> r13, boolean r14) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        BizExceptionManager.getInstance().reportException(r10, r11, r12, r13, null, r14);
        return;
    L8:
        return;
    }

    public static void reportDartError(String r10) {
        NpthCore.reportDartError(r10);
    }

    public static void reportDartError(String r10, @Nullable Map<? extends String, ? extends String> r11, @Nullable Map<String, String> r12, @Nullable IUploadCallback r13) {
        NpthCore.reportDartError(r10, r11, r12, r13);
    }

    @Deprecated
    public static void reportError(String r10) {
        NpthCore.reportError(r10);
    }

    @Deprecated
    public static void reportError(@NonNull Throwable r10) {
        NpthCore.reportError(r10);
    }

    public static void reportGameException(String r10, String r11, String r12) {
        NpthCore.reportGameException(r10, r11, r12);
    }

    public static void resume() {
        EnsureConfig.setStopEnable(false);
        EventConfig.setStopEnable(false);
    }

    public static void scanNativeCrash(Context r12, CrashCallbackEx r13, String[] r14) {
        List<CrashSummary> r15 = CrashManager.getNativeCrashList(r12);
        if (r15 != null) goto L5;
        return;
    L5:
        Iterator<CrashSummary> r16 = r15.iterator();
    L7:
        if (r16.hasNext() == false) goto L12;
        CrashSummary r17 = r16.next();
        if (r17 == null) goto L7;
        r13.onCrash(0, null, r17.getCrashType(), r17.getStartTime(), r17.getCrashTime(), r17.getProcessName(), r17.getStackTrace(), null, null);
        goto L7
    }

    @Deprecated
    public static void setANRCheckEnable(boolean r10) {
    }

    public static void setANRImprovementOpt(boolean r10) {
        GlobalSwitch.setANRImprovementOpt(r10);
    }

    @Deprecated
    public static void setAlogFlushAddr(long r10) {
    }

    public static void setAlogFlushV2Addr(long r10) {
        AlogManager.setAlogFlushFunction(r10);
    }

    @Deprecated
    public static void setAlogLogDirAddr(long r10) {
    }

    @Deprecated
    public static void setAlogWriteAddr(long r10) {
    }

    public static void setAnrDisableDumpData(boolean r10) {
        AnrManager.setAnrDisableDumpData(r10);
    }

    @Deprecated
    public static void setAnrInfoFileObserver(String r10, IFileContentGetter r11) {
        NpthCore.setAnrInfoFileObserver(r10, r11);
    }

    public static void setAnrMonitorOpt(boolean r10) {
        GlobalSwitch.setAnrMonitorOpt(r10);
    }

    public static void setAnrResendSigquit(boolean r10) {
        NpthCore.setAnrResendSigquit(r10);
    }

    public static void setApplication(Application r10) {
        if (r10 == null) goto L5;
        Global.setApplication(r10);
        return;
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData r10, CrashType r11) {
        addAttachUserData(r10, r11);
    }

    @Deprecated
    public static void setBusiness(String r10) {
        Global.setBusiness(r10);
    }

    public static void setCloseBgAnr(boolean r10) {
        UserDataCenter.setCloseBgAnr(r10);
    }

    public static void setCrashAccessibilityEnable(boolean r10) {
        CrashAccessibilityMonitor.setCrashAccessibilityEnable(r10);
    }

    public static void setCrashFilter(ICrashFilter r10) {
        sCachedDataCenter.setCrashFilter(r10);
    }

    public static void setCrashMonitorService(ICrashMonitorService r10) {
        Global.setCrashMonitorService(r10);
    }

    public static void setCrashUploadCallback(CrashUploadCallback r10) {
        sCachedDataCenter.setUploadCallback(r10);
    }

    public static void setCurProcessName(String r10) {
        App.setCurProcessName(r10);
    }

    public static void setCustomCrashReasonArrayLimit(String r10, int r11) {
        sCachedDataCenter.setCrashReasonArrayLimit(r10, r11);
    }

    public static void setDomainName(String r10) {
        AllDefaultUrls.setDomainName(new URL(r10).getHost());     // Catch: Throwable -> L4
        return;
    }

    public static void setDumpAnrAsync(boolean r10) {
        NpthCore.setDumpAnrAsync(r10);
    }

    @Keep
    public static void setEncryptImpl(@NonNull IEncrypt r10) {
        NpthCore.setEncryptImpl(r10);
    }

    public static void setFixDumpStack(boolean r10) {
        RepairAdapter.setFixDumpStack(r10);
    }

    public static void setIgnoreHandler(CrashIgnoreHandler r10) {
        JavaCrashHandler.setIgnoreHandler(r10);
    }

    @Deprecated
    public static void setInitAnrAhead(boolean r10) {
    }

    @Deprecated
    public static void setLogcatImpl(ILogcatImpl r10) {
        NpthCore.setLogcatImpl(r10);
    }

    public static void setMaxCacheSize(int r10) {
        EnsureDeliverer.setMaxCacheCount(r10);
    }

    public static void setNetworkCallback(INetworkCallback r10) {
        NpthNetworkApi.setNetworkCallback(r10);
    }

    public static void setNpthInitOptEnable(boolean r10) {
        UserDataCenter.setNpthInitOptEnable(r10);
    }

    public static void setOpenDumpTraceOpt(boolean r10) {
        UserDataCenter.setOpenDumpTraceOpt(r10);
    }

    public static void setOpenNewAnrMonitor(boolean r10) {
        GlobalSwitch.setOpenNewAnrMonitor(r10);
    }

    public static void setQueueLimitSize(int r10) {
        EnsureDeliverer.setQueueLimitSize(r10);
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider r10) {
        NpthNetworkApi.setRequestHeaderProvider(r10);
    }

    public static void setRequestIntercept(IRequestIntercept r10) {
        NpthCore.setRequestIntercept(r10);
    }

    public static void setRequestPermission(IRequestPermission r10) {
        CrashUploader.setRequestPermission(r10);
    }

    public static void setScriptStackCallback(IScriptCallback r10) {
        NpthCore.setScriptStackCallback(r10);
    }

    public static void setTagCacheService(ITagCacheService r10) {
        TagService.setTagCacheService(r10);
        UserDataCenter r11 = sCachedDataCenter;
        TagService.addTags(new HashMap(r11.getCacheCustomTags()), r11);
        r11.clearCustomTags();
    }

    public static void setTagOpt(boolean r10) {
        sCachedDataCenter.setTagOpt(r10);
    }

    public static void setTerminateMonitorDelayTime(long r10) {
    }

    public static void setTerminateOpt(boolean r10) {
        UserDataCenter.setTerminateOpt(r10);
    }

    public static void setUploadDelayTime(long r10) {
        LaunchScanner.setUploadDelayTime(r10);
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor r10) {
        CrashUploader.setUrlConnectionInterceptor(r10);
    }

    public static void setUseLocalDomain(boolean r10) {
        AppMonitorConfigService.setUseLocalDomain(r10);
    }

    public static int startOptMtkBuffer(int r10) {
        return NpthCore.startOptMtkBuffer(r10);
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

    public static void unregisterCrashCallback(ICrashCallback r10, CrashType r11) {
        sCachedDataCenter.removeCrashCallback(r10, r11);
    }

    public static void unregisterHprofCallback(IOOMCallback r10, CrashType r11) {
        sCachedDataCenter.removeHprofCallback(r10);
    }

    public static void unregisterOOMCallback(IOOMCallback r10, CrashType r11) {
        sCachedDataCenter.removeOOMCallback(r10);
    }

    public static void unregisterPreANRCallback(IPreANRCallback r10) {
        sCachedDataCenter.removePreANRCallback(r10);
    }

    @Deprecated
    public static void unregisterPreCrashCallback(IPreCrashCallback r10, CrashType r11) {
        sCachedDataCenter.removePreCrashCallback(r10, r11);
    }
}
