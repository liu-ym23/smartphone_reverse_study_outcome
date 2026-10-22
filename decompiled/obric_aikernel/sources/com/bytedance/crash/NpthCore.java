package com.bytedance.crash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c4.d;
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
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NpthCore {
    private static boolean dumpAnrAsync = false;
    private static boolean sIsCurrentMiniAppProcess;
    private static volatile int sMiniAppId;
    private static volatile String sMiniAppVersion;

    static class CrashCore {
        private static CrashCore sInstance;

        private CrashCore(@NonNull Context r10, @NonNull File r11) {
            startMonitor(r10, r11);
        }

        static void createInstance(@NonNull Context r10, @NonNull File r11) {
            if (sInstance == null) goto L5;
            return;
        L5:
            monitor-enter(CrashCore.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sInstance != null) goto L9;
            sInstance = new CrashCore(r10, r11);     // Catch: Throwable -> L11
        L9:
            monitor-exit(CrashCore.class);     // Catch: Throwable -> L11
        }

        static void init(@NonNull Context r10, @NonNull File r11) {
            createInstance(r10, r11);
        }

        static boolean isInit() {
            if (sInstance == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void startMonitor(@NonNull Context r10, @NonNull File r11) {
            if (CrashManager.isDirectoryExist(r11) == true) goto L5;
            ActivityLifecycle.markFirstLaunch();
        L5:
            CrashManager.startMonitor(r10, r11);
            InitMonitor.step("Crash_Init");
            AnrManager.startMonitor(r10, r11);
            InitMonitor.step("Anr_Init");
            DefaultWorkThread.postAtFront(new AnonymousClass1(this));
            ProcessTracker.getInstance().setEnable(true);
            DefaultWorkThread.post(new AnonymousClass2(this));
            InitMonitor.step("DefaultWorkThread_Init");
        }
    }

    @SuppressLint({"StaticFieldLeak"})
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

    public static void enableALogCollector(String r10, IALogCrashObserver r11, IAlogUploadStrategy r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (new File(r10).exists() == false) goto L9;
        AlogManager.setInnerController(r10, r11, r12);
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
        d.d(IFdCheck.class, new AnonymousClass1());
        NpthDiskMonitor.getInstance().init();
    }

    private static void initAsyncForEvent() {
        NpthLog.i("initAsyncForEvent");
        NpthMonitor.init();
        GeneralInfoManager.init();
        EnsureApi.init();
    }

    public static void initForCrashMonitor(@NonNull Context r10, @NonNull File r11) {
        CrashCore.init(r10, r11);
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

    static void registerMiniApp(int r10, String r11) {
        sMiniAppId = r10;
        sMiniAppVersion = r11;
    }

    public static void reportDartError(String r10) {
        if (isInit() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        DartCrash.reportError(r10);
        return;
    }

    public static void reportDartError(String r10, @Nullable Map<? extends String, ? extends String> r11, @Nullable Map<String, String> r12, @Nullable IUploadCallback r13) {
        if (isInit() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        DartCrash.reportError(r10, r11, r12, r13);
        return;
    }

    @Deprecated
    public static void reportError(String r10) {
    }

    @Deprecated
    public static void reportError(@NonNull Throwable r10) {
        NpthBus.getConfigManager().isReportErrorEnable();
    }

    public static void reportGameException(String r10, String r11, String r12) {
        if (isInit() == true) goto L5;
        return;
    L5:
        GameCrash.reportError(r10, r11, r12);
    }

    public static void setAnrInfoFileObserver(String r10, IFileContentGetter r11) {
        AnrManager.registerAnrInfoObserver(r10, r11);
    }

    public static void setAnrResendSigquit(boolean r10) {
        NativeBridge.setAnrResendSigquit(r10);
    }

    public static void setCurrentMiniAppProcess(boolean r10) {
        sIsCurrentMiniAppProcess = r10;
    }

    public static void setDumpAnrAsync(boolean r10) {
        dumpAnrAsync = r10;
    }

    public static void setEncryptImpl(@NonNull IEncrypt r10) {
        RuntimeConfig.setEncryptImpl(r10);
    }

    public static void setLogcatImpl(ILogcatImpl r10) {
    }

    public static void setRequestIntercept(IRequestIntercept r10) {
        CrashUploader.setRequestIntercept(r10);
    }

    public static void setScriptStackCallback(IScriptCallback r10) {
        if (isInit() == true) goto L5;
        return;
    L5:
        GameScriptStack.setCallback(r10);
    }

    public static int startOptMtkBuffer(int r10) {
        return RepairAdapter.startOptMtkBuffer(r10);
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
