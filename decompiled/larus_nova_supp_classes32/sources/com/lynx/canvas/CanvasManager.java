package com.lynx.canvas;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.callback.RenderFrameCallback;
import com.lynx.canvas.worker.KryptonNapiRuntimeFactoryService;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c;
import com.lynx.tasm.behavior.ui.krypton.ICanvasManager;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonAudioDownstreamMode;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonAudioFrameCallback;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.EnvUtils;
import i8a.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasManager extends ICanvasManager {
    private static final LynxEnvKey KEY_SETUP_CANVAS_SURFACE_EARLIER = null;
    private static final String TAG = "KryptonCanvasManager";
    private static boolean sIsAudioForceUseAdaptiveSampler;
    private static boolean sIsEventReportEnabled;
    private static boolean sIsSettingsCached;
    private static boolean sIsUseAurumAudioEngine;
    private static boolean sSetupCanvasSurfaceEarlier;
    private LynxKryptonAudioFrameCallback mAudioDownstreamCallback;
    private final Object mAudioDownstreamLock;
    private LynxKryptonAudioDownstreamMode mAudioDownstreamMode;
    private Context mContext;
    private KryptonApp mKryptonApp;
    private LynxKryptonNapiRuntimeFactoryService mNapiRuntimeFactoryService;
    private boolean mRuntimeAttached;
    private LynxKryptonDefaultServiceLazyLoader mServiceLazyLoader;
    private String mTemporaryDirectory;

    public static class KryptonRenderFrameCallbackWrapper implements RenderFrameCallback {
        private final com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback mCallback;

        public KryptonRenderFrameCallbackWrapper(com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.lynx.canvas.callback.RenderFrameCallback
        public void onFrameRender(String r7, long r8, long r10) {
            this.mCallback.onFrameRender(r7, r8, r10);
        }
    }

    public static class LynxKryptonJavaLogger implements Krypton.IKryptonJavaLogger {
        private LynxKryptonJavaLogger() {
        }

        public /* synthetic */ LynxKryptonJavaLogger(AnonymousClass1 r1) {
            this();
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        public void d(String r1, String r2) {
            LLog.d(r1, r2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        public void e(String r1, String r2) {
            LLog.e(r1, r2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        public void i(String r1, String r2) {
            LLog.i(r1, r2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        public void v(String r1, String r2) {
            LLog.v(r1, r2);
        }

        @Override // com.lynx.canvas.Krypton.IKryptonJavaLogger
        public void w(String r1, String r2) {
            LLog.w(r1, r2);
        }
    }

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    private native long nativeGetLogFunctionPtr();

    private static native void nativeRegisterTraceFunc();

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onRuntimeMediatorDestroy() {
    }

    static {
        KEY_SETUP_CANVAS_SURFACE_EARLIER = LynxEnvKey.SETUP_CANVAS_SURFACE_EARLIER;
        sIsUseAurumAudioEngine = true;
    }

    private void makeSureSettingsCached() {
        if (sIsSettingsCached == false) goto L6;
        return;
    L6:
        if (((ILynxTrailService) n.c().a(ILynxTrailService.class)) != null) goto L8;
        return;
    L8:
        sIsEventReportEnabled = LynxSettingsUtils.booleanValueForKey("krypton_enable_event_report", false);
        sIsUseAurumAudioEngine = LynxSettingsUtils.booleanValueForKey("krypton_use_aurum_audio_engine", true);
        sIsAudioForceUseAdaptiveSampler = LynxSettingsUtils.booleanValueForKey("krypton_audio_force_use_adaptive_sampler", false);
        sSetupCanvasSurfaceEarlier = LynxEnv.getBooleanFromExternalEnv(KEY_SETUP_CANVAS_SURFACE_EARLIER, false);
        sIsSettingsCached = true;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void deInit() {
        LLog.i(TAG, "Canvas manager deInit ");
    }

    public String getTemporaryDirectory() {
        String r0 = this.mTemporaryDirectory;
        if (r0 == null) goto L9;
        if (r0.length() <= 0) goto L9;
        return this.mTemporaryDirectory;
    L9:
        return EnvUtils.getCacheDir();
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public boolean isNativeCanvasAppReady() {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isNativeReady();
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public long newNativeCanvasAppWeakPtr() {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.newNativeWeakPtr();
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onAppEnterBackground() {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 == null) goto L6;
        r0.onHide();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onAppEnterForeground() {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 == null) goto L6;
        r0.onShow();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onRuntimeDetach() {
        Object r0 = this.mAudioDownstreamLock;
        monitor-enter(r0);
        this.mRuntimeAttached = false;     // Catch: Throwable -> L10
        this.mAudioDownstreamCallback = null;     // Catch: Throwable -> L10
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;     // Catch: Throwable -> L10
        KryptonApp r2 = this.mKryptonApp;     // Catch: Throwable -> L10
        if (r2 == null) goto L8;
        r2.destroy();     // Catch: Throwable -> L10
        this.mKryptonApp = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public CanvasManager() {
        this.mAudioDownstreamLock = new Object();
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        initJavaLoggerForKrypton();
        if (Krypton.inst().hasInitialized() == true) goto L6;
        Krypton.inst().init(null, LynxEnv.inst().getAppContext());
        return;
    }

    private KryptonApp createKryptonApp() {
        makeSureSettingsCached();
        KryptonFeatureFlag.Builder r0 = new KryptonFeatureFlag.Builder();
        r0.setEnableSar(true);
        r0.setUseVsyncMonitorFromService(false);
        r0.setEnableEventReport(sIsEventReportEnabled);
        r0.setUseAurumAudioEngine(sIsUseAurumAudioEngine);
        r0.setAudioForceUseAdaptiveSampler(sIsAudioForceUseAdaptiveSampler);
        r0.setSetupGLGraphicsBackendWhenSurfaceCreated(sSetupCanvasSurfaceEarlier);
        r0.setEnableMemoryReporting(true);
        return new KryptonApp(r0.build(), this.mContext);
    }

    private void initJavaLoggerForKrypton() {
        Krypton.inst().registerLogger("Lynx", new LynxKryptonJavaLogger(null));
    }

    private void registerLogFunc() {
        Krypton.inst().nativeRegisterLogger("Lynx", nativeGetLogFunctionPtr());
        if (TraceEvent.enableTrace() == false) goto L6;
        LLog.i(TAG, "now in lynx debugmode, load trace func");
        nativeRegisterTraceFunc();
        return;
    }

    private boolean tryLoadLynxKryptonSo() {
        if (Krypton.inst().hasInitialized() == true) goto L15;
        LLog.e(TAG, "Krypton not initialized, Ensure that the host has added the krypton AAR dependency and current device supports OpenGL ES3.0 .");
        return false;
    L15:
    L13:
        LLog.e(TAG, "lynx_krypton.so load failed! Ensure that the host has added the krypton-lynx AAR dependency.");
        return false;
    L8:
        if (LynxEnv.inst().getLibraryLoader() == null) goto L10;
        LynxEnv.inst().getLibraryLoader().loadLibrary("lynx_krypton");     // Catch: ExceptionInInitializerError -> L13
        LLog.i(TAG, "lynx_krypton.so loaded via library loader");     // Catch: ExceptionInInitializerError -> L13
        return true;
    L10:
        INVOKESTATIC_com_lynx_canvas_CanvasManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynx_krypton");     // Catch: ExceptionInInitializerError -> L13
        LLog.i(TAG, "lynx_krypton.so loaded via system loader");     // Catch: ExceptionInInitializerError -> L13
        return true;
    }

    public KryptonApp getKryptonApp() {
        return this.mKryptonApp;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_canvas_CanvasManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private AudioDownstreamMode toKryptonAudioDownstreamMode(LynxKryptonAudioDownstreamMode r2) {
        if (r2 != LynxKryptonAudioDownstreamMode.REPLACE_PLAYBACK) goto L7;
        return AudioDownstreamMode.REPLACE_PLAYBACK;
    L7:
        return AudioDownstreamMode.KEEP_PLAYBACK;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public boolean init(LynxContext r4) {
        if (tryLoadLynxKryptonSo() == true) goto L6;
        LLog.e(TAG, "Load lynx_krypton.so failed !");
        return false;
    L6:
        registerLogFunc();
        this.mContext = r4.getApplicationContext();
        this.mKryptonApp = createKryptonApp();
        LynxKryptonDefaultServiceLazyLoader r0 = new LynxKryptonDefaultServiceLazyLoader(r4);
        this.mServiceLazyLoader = r0;
        r0.registerToKryptonApp(this.mKryptonApp);
        LynxKryptonNapiRuntimeFactoryService r5 = new LynxKryptonNapiRuntimeFactoryService();
        this.mNapiRuntimeFactoryService = r5;
        this.mKryptonApp.registerService(KryptonNapiRuntimeFactoryService.class, r5);
        LLog.i(TAG, "Canvas manager init success");
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onNapiEnvReady(long r2) {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 == null) goto L15;
        r0.bootstrap(r2);
        Object r3 = this.mAudioDownstreamLock;
        monitor-enter(r3);
        this.mRuntimeAttached = true;     // Catch: Throwable -> L12
        LynxKryptonAudioFrameCallback r4 = this.mAudioDownstreamCallback;     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        applyAudioDownstreamCallbackToKryptonApp(r4, this.mAudioDownstreamMode);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onRuntimeInit(long r1) {
        LLog.i(TAG, "CanvasManager runtime init");
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onRuntimeMediatorReady(long r4) {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerService(KryptonFrameService.class, new LynxKryptonFrameService(r4));
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void onTemplateLoad(String r2) {
        KryptonApp r0 = this.mKryptonApp;
        if (r0 == null) goto L6;
        r0.setScenarioTag(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void registerCanvasBehavior(c r4) {
        final String r1 = "canvas";
        final boolean r2 = false;
        r4.a(new AnonymousClass1(this, r1, r2));
        final String r3 = "canvas-ng";
        r4.a(new AnonymousClass2(this, r3, r2));
        final String r5 = "surface-canvas-experiment";
        r4.a(new AnonymousClass3(this, r5, r2));
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void setRenderFrameCallback(com.lynx.tasm.behavior.ui.krypton.RenderFrameCallback r3) {
        this.mKryptonApp.setRenderFrameCallback(new KryptonRenderFrameCallbackWrapper(r3));
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void setTaskRunner(long r2) {
        this.mKryptonApp.setRuntimeTaskRunner(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void setTemporaryDirectory(String r2) {
        this.mTemporaryDirectory = r2;
        LynxKryptonDefaultServiceLazyLoader r0 = this.mServiceLazyLoader;
        if (r0 == null) goto L5;
        r0.setTemporaryDirectory(r2);
        return;
    L5:
        LLog.e(TAG, "setTemporaryDirectory should be called after init");
    }

    private void applyAudioDownstreamCallbackToKryptonApp(LynxKryptonAudioFrameCallback r2, LynxKryptonAudioDownstreamMode r3) {
        if (this.mKryptonApp != null) goto L6;
        LLog.e(TAG, "setAudioDownstreamCallback failed: KryptonApp is null");
        return;
    L6:
        if (r2 == null) goto L8;
        LynxKryptonAudioFrameCallbackWrapper r0 = new LynxKryptonAudioFrameCallbackWrapper(r2);
    L9:
        this.mKryptonApp.setAudioDownstreamCallback(r0, toKryptonAudioDownstreamMode(r3));
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void registerService(Class<?> r3, Object r4) {
        if ((r4 instanceof KryptonService) == true) goto L6;
        LLog.e(TAG, "register service class error");
        return;
    L6:
        KryptonApp r0 = this.mKryptonApp;
        if (r0 != null) goto L10;
        LLog.e(TAG, "register service failed : canvas app is null");
        return;
    L10:
        r0.registerService(r3, (KryptonService) r4);
    }

    @Override // com.lynx.tasm.behavior.ui.krypton.ICanvasManager
    public void setAudioDownstreamCallback(LynxKryptonAudioFrameCallback r3, LynxKryptonAudioDownstreamMode r4) {
        Object r0 = this.mAudioDownstreamLock;
        monitor-enter(r0);
        this.mAudioDownstreamCallback = r3;     // Catch: Throwable -> L14
        if (r4 != null) goto L7;
        r4 = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;     // Catch: Throwable -> L14
    L7:
        this.mAudioDownstreamMode = r4;     // Catch: Throwable -> L14
        if (this.mRuntimeAttached == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        applyAudioDownstreamCallbackToKryptonApp(r3, r4);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
