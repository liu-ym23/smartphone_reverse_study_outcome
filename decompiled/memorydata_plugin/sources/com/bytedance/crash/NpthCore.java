package com.bytedance.crash;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.alog.IALogCrashObserver;
import com.bytedance.crash.alog.IAlogUploadStrategy;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.applog.NpthApplog;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.dart.DartCrash;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.ensure.EnsureApi;
import com.bytedance.crash.game.GameCrash;
import com.bytedance.crash.game.GameScriptStack;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.resource.gwpasan.GwpAsanAdapter;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.runtime.ILogcatImpl;
import com.bytedance.crash.soloader.NpthSoData;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.tracker.TrackerManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.IRequestIntercept;
import com.bytedance.crash.upload.LaunchScanner;
import com.bytedance.crash.util.NpthDiskMonitor;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IFdCheck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NpthCore {
    private static boolean dumpAnrAsync = false;
    private static boolean sIsCurrentMiniAppProcess;
    private static volatile int sMiniAppId;
    private static volatile String sMiniAppVersion;

    static class CrashCore {
        private static CrashCore sInstance;

        private CrashCore(Context r3, File r4) {
            startMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        }

        static void createInstance(Context r2, File r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (sInstance == null) goto L5;
            return;
        L5:
            monitor-enter(CrashCore.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sInstance != null) goto L9;
            sInstance = new CrashCore(r4, r3);     // Catch: Throwable -> L11
        L9:
            monitor-exit(CrashCore.class);     // Catch: Throwable -> L11
        }

        static void init(Context r2, File r3) {
            createInstance((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        }

        static boolean isInit() {
            if (sInstance == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void startMonitor(Context r3, File r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if (CrashManager.isDirectoryExist(r4) == true) goto L5;
            ActivityLifecycle.markFirstLaunch();
        L5:
            CrashManager.startMonitor(r5, r4);
            InitMonitor.step("Crash_Init");
            AnrManager.startMonitor(r5, r4);
            InitMonitor.step("Anr_Init");
            DefaultWorkThread.postAtFront(new AnonymousClass1(this));
            ProcessTracker.getInstance().setEnable(true);
            DefaultWorkThread.post(new AnonymousClass2(this));
            InitMonitor.step("DefaultWorkThread_Init");
        }
    }

    static class EventCore {
        private static EventCore sInstance;

        private EventCore() {
            startMonitor();
        }

        static void createInstance() {
            if (sInstance == null) goto L5;
            return;
        L5:
            monitor-enter(EventCore.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sInstance != null) goto L9;
            sInstance = new EventCore();     // Catch: Throwable -> L11
        L9:
            monitor-exit(EventCore.class);     // Catch: Throwable -> L11
        }

        static void init() {
            createInstance();
        }

        static boolean isInit() {
            if (sInstance == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void startMonitor() {
            DefaultWorkThread.post(new AnonymousClass1(this));
        }
    }

    static {
    }

    public NpthCore() {
    }

    public static void EnableGwpAsan() {
        GwpAsanAdapter.GwpAsanInit();
    }

    static /* synthetic */ void access$000() {
        initAsyncForEvent();
    }

    static /* synthetic */ void access$100() {
        initAsyncForCrash();
    }

    public static void enableALogCollector(String r2, IALogCrashObserver r3, IAlogUploadStrategy r4) {
        IALogCrashObserver r5 = (IALogCrashObserver) ZeusTransformUtils.wrapperContextForParams(r3, IALogCrashObserver.class, "com.obric.memorydata.plugin");
        IAlogUploadStrategy r6 = (IAlogUploadStrategy) ZeusTransformUtils.wrapperContextForParams(r4, IAlogUploadStrategy.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (new File(r2).exists() == false) goto L9;
        AlogManager.setInnerController(r2, r5, r6);
        return;
    }

    public static boolean getDumpAnrAsync() {
        return dumpAnrAsync;
    }

    public static int getMiniAppId() {
        return sMiniAppId;
    }

    public static String getMiniAppVersion() {
        return sMiniAppVersion;
    }

    @Deprecated
    public static boolean hasCrash() {
        return false;
    }

    private static void initAsyncForCrash() {
        NpthLog.i("initAsyncForCrash");
        NpthSoData.checkDumperFile();
        initAsyncForEvent();
        TrackerManager.start();
        CrashManager.startDumperThread();
        CrashManager.dumperLateInit();
        CrashProtector.addDefaultConfig();
        NpthApplog.init();     // Catch: Throwable -> L9
    L19:
        NpthApm.init();     // Catch: Throwable -> L10
    L13:
        NpthAlog.init();     // Catch: Throwable -> L11
        AlogManager.setExternalController();     // Catch: Throwable -> L11
    L15:
        TagService.cleanTags();     // Catch: Throwable -> L12
    L7:
        PluginInfoManager.init();
        LaunchScanner.start();
        d.a(IFdCheck.class, new AnonymousClass1());
        NpthDiskMonitor.getInstance().init();
    }

    private static void initAsyncForEvent() {
        NpthLog.i("initAsyncForEvent");
        NpthMonitor.init();
        GeneralInfoManager.init();
        EnsureApi.init();
    }

    public static void initForCrashMonitor(Context r2, File r3) {
        CrashCore.init((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void initForEventMonitor() {
        EventCore.init();
    }

    public static boolean isAnrThreadRunning() {
        if (isInit() == true) goto L7;
        return false;
    L7:
        return AnrManager.isRunning();
    }

    public static boolean isCurrentMiniAppProcess() {
        return sIsCurrentMiniAppProcess;
    }

    public static boolean isInit() {
        return CrashCore.isInit();
    }

    public static boolean isInitForEvent() {
        if (EventCore.isInit() == false) goto L5;
    L8:
        return true;
    L5:
        if (CrashCore.isInit() == true) goto L8;
        return false;
    }

    public static boolean isStopUpload() {
        return RuntimeConfig.isStopUpload();
    }

    static void registerMiniApp(int r0, String r1) {
        sMiniAppId = r0;
        sMiniAppVersion = r1;
    }

    public static void reportDartError(String r1) {
        if (isInit() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        DartCrash.reportError(r1);
        return;
    }

    public static void reportDartError(String r2, Map<? extends String, ? extends String> r3, Map<String, String> r4, IUploadCallback r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        IUploadCallback r8 = (IUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, IUploadCallback.class, "com.obric.memorydata.plugin");
        if (isInit() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        DartCrash.reportError(r2, r6, r7, r8);
        return;
    }

    @Deprecated
    public static void reportError(String r0) {
    }

    @Deprecated
    public static void reportError(Throwable r0) {
        NpthBus.getConfigManager().isReportErrorEnable();
    }

    public static void reportGameException(String r1, String r2, String r3) {
        if (isInit() == true) goto L5;
        return;
    L5:
        GameCrash.reportError(r1, r2, r3);
    }

    public static void setAnrInfoFileObserver(String r2, IFileContentGetter r3) {
        AnrManager.registerAnrInfoObserver(r2, (IFileContentGetter) ZeusTransformUtils.wrapperContextForParams(r3, IFileContentGetter.class, "com.obric.memorydata.plugin"));
    }

    public static void setAnrResendSigquit(boolean r0) {
        NativeBridge.setAnrResendSigquit(r0);
    }

    public static void setCurrentMiniAppProcess(boolean r0) {
        sIsCurrentMiniAppProcess = r0;
    }

    public static void setDumpAnrAsync(boolean r0) {
        dumpAnrAsync = r0;
    }

    public static void setEncryptImpl(IEncrypt r2) {
        RuntimeConfig.setEncryptImpl((IEncrypt) ZeusTransformUtils.wrapperContextForParams(r2, IEncrypt.class, "com.obric.memorydata.plugin"));
    }

    public static void setLogcatImpl(ILogcatImpl r2) {
        ILogcatImpl r3 = (ILogcatImpl) ZeusTransformUtils.wrapperContextForParams(r2, ILogcatImpl.class, "com.obric.memorydata.plugin");
    }

    public static void setRequestIntercept(IRequestIntercept r2) {
        CrashUploader.setRequestIntercept((IRequestIntercept) ZeusTransformUtils.wrapperContextForParams(r2, IRequestIntercept.class, "com.obric.memorydata.plugin"));
    }

    public static void setScriptStackCallback(IScriptCallback r2) {
        IScriptCallback r3 = (IScriptCallback) ZeusTransformUtils.wrapperContextForParams(r2, IScriptCallback.class, "com.obric.memorydata.plugin");
        if (isInit() == true) goto L5;
        return;
    L5:
        GameScriptStack.setCallback(r3);
    }

    public static int startOptMtkBuffer(int r0) {
        return RepairAdapter.startOptMtkBuffer(r0);
    }

    public static void stopAnr() {
        if (isInit() == true) goto L5;
        return;
    L5:
        AnrManager.stopMonitor();
    }

    public static void stopEnsure() {
        RuntimeConfig.stopEnsure();
    }

    public static void stopUpload() {
        RuntimeConfig.stopUpload();
    }
}
