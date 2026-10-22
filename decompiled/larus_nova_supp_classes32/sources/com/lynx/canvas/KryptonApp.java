package com.lynx.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.lynx.canvas.callback.AudioFrameCallback;
import com.lynx.canvas.callback.AudioFrameCallbackWrapper;
import com.lynx.canvas.callback.FirstOnScreenCanvasFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallbackWrapper;
import com.lynx.canvas.callback.TimeToInteractiveCallback;
import com.lynx.canvas.loader.CanvasResourceLoader;
import com.lynx.canvas.worker.KryptonNapiRuntimeFactory;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonApp {
    private static final String TAG = "KryptonApp";
    private long jsEnv;
    private boolean mBootstrapped;
    private Context mContext;
    private boolean mDestroyed;
    private KryptonFeatureFlag mFeatureFlag;
    private Runnable mFirstOnScreenCanvasFrameCallback;
    private Map<Class, KryptonModule> mModuleMap;
    private KryptonNapiRuntimeFactory mNapiFactory;
    private long mNativeHandler;
    private CanvasPermissionManager mPermissionManager;
    private float mRatio;
    private RemoteDelegate mRemoteDelegate;
    private CanvasResourceLoader mResourceLoader;
    private Handler mRuntimeHandler;
    private Map<Class, KryptonServiceLazyLoader> mServiceLazyLoaderMap;
    private Map<Class, KryptonService> mServiceMap;
    private TimeToInteractiveCallback mTimeToInteractiveCallback;
    private ScriptErrorHandler mUncaughtExceptionHandler;
    private KryptonVSyncMonitor mVSyncMonitor;

    public static class KryptonImageData {
        public int height;
        public ByteBuffer pixels;
        public int width;

        public KryptonImageData() {
        }
    }

    public interface RemoteDelegate {
        void bootstrap(KryptonApp r1, long r2);

        String getRemoteHookJS();

        void runBuffer(byte[] r1, Consumer<byte[]> r2);
    }

    public interface ScriptErrorHandler {
        void handle(String r1);
    }

    private native void nativeBootstrap(long r1, long r3);

    private native long nativeCreateInstance(KryptonFeatureFlag r1, CanvasResourceLoader r2, KryptonVSyncMonitor r3, KryptonNapiRuntimeFactory r4);

    private native long nativeCreateWeakPtr(long r1);

    private native void nativeDestroyInstance(long r1);

    private native String nativeGetAndResetPerformanceStatistics(long r1);

    private native String nativeGetDrawCallStatistics(long r1);

    private native int[] nativeGetSizeFromTheOnlyOneOnScreenCanvas(long r1);

    private native void nativeOnHide(long r1);

    private native void nativeOnShow(long r1);

    private native void nativePause(long r1, long r3);

    private native boolean nativeReadPixelsFromTheOnlyOneOnScreenCanvas(long r1, ByteBuffer r3, int r4, int r5);

    private native void nativeResume(long r1, long r3);

    private native void nativeSetAudioDownstreamCallback(long r1, AudioFrameCallbackWrapper r3, int r4);

    private native void nativeSetAudioMuted(long r1, boolean r3);

    private native void nativeSetDevicePixelRatio(long r1, float r3);

    private native void nativeSetEnableDrawCallStatistics(long r1, boolean r3);

    private native void nativeSetEnablePerformanceStatistics(long r1, boolean r3);

    private native void nativeSetFirstOnScreenCanvasFrameCallback(long r1, FirstOnScreenCanvasFrameCallback r3);

    private native void nativeSetRenderFrameCallback(long r1, RenderFrameCallbackWrapper r3);

    private native void nativeSetRuntimeTaskRunner(long r1, long r3);

    private native void nativeSetScenarioTag(long r1, String r3);

    private native void nativeSetTimeToInteractiveCallback(long r1, TimeToInteractiveCallback r3);

    private native void nativeSetUncaughtExceptionHandler(long r1, long r3);

    private void onBootstrap() {
        this.mBootstrapped = true;
        Iterator<KryptonModule> r0 = this.mModuleMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onBootstrap(this);
        goto L4
    L6:
        Iterator<KryptonService> r1 = this.mServiceMap.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().onBootstrap(this);
        goto L8
    }

    public boolean isNativeReady() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeHandler == 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L6:
        r0 = false;
        goto L7
    }

    public long newNativeWeakPtr() {
        monitor-enter(this);
        long r0 = this.mNativeHandler;     // Catch: Throwable -> L8
        long r2 = 0;
        if (r0 == 0) goto L6;
        r2 = nativeCreateWeakPtr(r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private void checkFirstOnScreenCanvasIsTheOnlyOnScreen() {
        if (this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Only supported when KryptonFeatureFlag isFirstOnScreenCanvasIsTheOnlyOnScreen is true.");
    }

    private void checkPerformanceStatisticsRelatedFeatureFlags() {
        if (this.mFeatureFlag.enablePerformanceStatisticsRelatedInterface() == false) goto L7;
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        return;
    L7:
        throw new IllegalStateException("Only supported when KryptonFeatureFlag enablePerformanceStatisticsRelatedInterface is true.");
    }

    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "destroy");
        this.mDestroyed = true;
        Iterator<KryptonService> r0 = this.mServiceMap.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onDestroy();
        goto L7
    L9:
        this.mServiceMap.clear();
        Iterator<KryptonModule> r1 = this.mModuleMap.values().iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        r1.next().onDestroy();
        goto L11
    L13:
        this.mModuleMap.clear();
        long r2 = this.mNativeHandler;
        if (r2 == 0) goto L22;
        monitor-enter(this);
        this.mNativeHandler = 0;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        nativeDestroyInstance(r2);
    L19:
        th = move-exception;
        throw th;
    L22:
        this.jsEnv = 0;
    }

    public void finalize() throws Throwable {
        if (this.mDestroyed == true) goto L6;
        KryptonLLog.e(TAG, "Destroy function must be called to prevent native object leakage");
        return;
    }

    public String getRemoteHookJS() {
        RemoteDelegate r0 = this.mRemoteDelegate;
        if (r0 != null) goto L7;
        KryptonLLog.e(TAG, "getRemoteHookJS failed: remote delegate is null");
        return null;
    L7:
        return r0.getRemoteHookJS();
    }

    public void onHide() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "onHide");
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L8;
        nativeOnHide(r0);
    L8:
        Iterator<KryptonService> r1 = this.mServiceMap.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().onHide();
        goto L10
    L12:
        Iterator<KryptonModule> r2 = this.mModuleMap.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r2.next().onHide();
        goto L14
    }

    public void onShow() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "onShow");
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L8;
        nativeOnShow(r0);
    L8:
        Iterator<KryptonModule> r1 = this.mModuleMap.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().onShow();
        goto L10
    L12:
        Iterator<KryptonService> r2 = this.mServiceMap.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r2.next().onShow();
        goto L14
    }

    public void pause() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "pause");
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L8;
        nativePause(r0, this.jsEnv);
    L8:
        Iterator<KryptonService> r1 = this.mServiceMap.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().onPause();
        goto L10
    L12:
        Iterator<KryptonModule> r2 = this.mModuleMap.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r2.next().onPause();
        goto L14
    }

    public void resume() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "resume");
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L8;
        nativeResume(r0, this.jsEnv);
    L8:
        Iterator<KryptonModule> r1 = this.mModuleMap.values().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r1.next().onResume();
        goto L10
    L12:
        Iterator<KryptonService> r2 = this.mServiceMap.values().iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r2.next().onResume();
        goto L14
    }

    private void prepareRuntimeHandler() {
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L7;
        this.mRuntimeHandler = new Handler(r0);
        return;
    L7:
        throw new IllegalStateException("Looper.myLooper() null on bootstrap");
    }

    public String getAndResetPerformanceStatistics() {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long r0 = this.mNativeHandler;
        if (r0 != 0) goto L5;
        KryptonLLog.w(TAG, "native handler null");
        return null;
    L5:
        return nativeGetAndResetPerformanceStatistics(r0);
    }

    public String getDrawCallStatistics() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r0 = this.mNativeHandler;
        if (r0 != 0) goto L5;
        KryptonLLog.w(TAG, "native handler null");
        return null;
    L5:
        return nativeGetDrawCallStatistics(r0);
    }

    public KryptonImageData screenshot() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r0 = this.mNativeHandler;
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "screenshot error without native handler");
        return null;
    L6:
        int[] r1 = nativeGetSizeFromTheOnlyOneOnScreenCanvas(r0);
        if (r1 != null) goto L9;
    L23:
        KryptonLLog.w(TAG, "screenshot get canvas size error");
        return null;
    L9:
        if (r1.length < 2) goto L23;
        int r2 = r1[0];
        int r3 = r1[1];
        if (r2 <= 0) goto L21;
        if (r3 <= 0) goto L21;
        ByteBuffer r4 = ByteBuffer.allocateDirect((r2 * r3) * 4);
        if (nativeReadPixelsFromTheOnlyOneOnScreenCanvas(this.mNativeHandler, r4, r2, r3) == true) goto L19;
        KryptonLLog.w(TAG, "screenshot read pixels error");
        return null;
    L19:
        KryptonImageData r5 = new KryptonImageData();
        r5.width = r2;
        r5.height = r3;
        r5.pixels = r4;
        return r5;
    L21:
        KryptonLLog.w(TAG, "screenshot get canvas size result error: width = " + r2 + " height = " + r3);
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public KryptonFeatureFlag getFeatureFlag() {
        return this.mFeatureFlag;
    }

    public long getJsEnv() {
        return this.jsEnv;
    }

    public CanvasPermissionManager getPermissionManager() {
        return this.mPermissionManager;
    }

    public float getSystemRatio() {
        return this.mRatio;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_canvas_KryptonApp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ boolean access$100(KryptonApp r0) {
        return r0.mDestroyed;
    }

    public static /* synthetic */ RemoteDelegate access$200(KryptonApp r0) {
        return r0.mRemoteDelegate;
    }

    public static /* synthetic */ Runnable access$300(KryptonApp r0) {
        return r0.mFirstOnScreenCanvasFrameCallback;
    }

    private static CanvasVSyncMonitor createCanvasVSyncMonitor(KryptonApp r2) {
        CanvasVSyncMonitor r0 = new CanvasVSyncMonitor();
        r0.setFrameService((KryptonFrameService) r2.getService(KryptonFrameService.class));
        return r0;
    }

    private void onBootstrapForModule(KryptonModule r3) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "run onBootstrap on register module after KryptonApp's bootstrap");
        r3.onBootstrap(this);
    }

    private void onBootstrapForService(KryptonService r3) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "run onBootstrap on register service after KryptonApp's bootstrap");
        r3.onBootstrap(this);
    }

    private void onUncaughtException(String r3) {
        KryptonLLog.e(TAG, "onUncaughtException msg: " + r3);
        ScriptErrorHandler r0 = this.mUncaughtExceptionHandler;
        if (r0 == null) goto L6;
        r0.handle(r3);
        return;
    }

    private void setPreferredFramesPerSecond(int r4) {
        KryptonFrameService r0 = (KryptonFrameService) getService(KryptonFrameService.class);
        if (r0 == null) goto L6;
        KryptonLLog.i(TAG, "setPreferredFramesPerSecond " + r4);
        r0.setPreferredFramesPerSecond((long) r4);
        return;
    }

    public void bootstrap(long r6) {
        if (this.mBootstrapped == false) goto L7;
        KryptonLLog.e(TAG, "already bootstrapped.");
        return;
    L7:
        if (this.mDestroyed == false) goto L9;
        return;
    L9:
        this.jsEnv = r6;
        KryptonLLog.i(TAG, "bootstrap.");
        prepareRuntimeHandler();
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L14;
        nativeBootstrap(r0, r6);
        if (this.mUncaughtExceptionHandler == null) goto L14;
        nativeSetUncaughtExceptionHandler(this.mNativeHandler, this.jsEnv);
    L14:
        onBootstrap();
    }

    public void bootstrapRemote(RemoteDelegate r3) {
        if (r3 != null) goto L7;
        KryptonLLog.e(TAG, "bootstrapRemote failed: remote delegate is null");
        return;
    L7:
        if (this.mBootstrapped == false) goto L11;
        KryptonLLog.e(TAG, "already bootstrapped.");
        return;
    L11:
        if (this.mDestroyed == false) goto L14;
        KryptonLLog.e(TAG, "already destroyed.");
        return;
    L14:
        KryptonLLog.i(TAG, "bootstrap remote.");
        prepareRuntimeHandler();
        this.mRemoteDelegate = r3;
        r3.bootstrap(this, this.mNativeHandler);
        onBootstrap();
    }

    public <T extends KryptonModule> T getModule(Class<T> r5) {
        if (this.mDestroyed == false) goto L6;
        return null;
    L6:
        T r0 = (T) this.mModuleMap.get(r5);
        if (r0 == null) goto L9;
        return r0;
    L9:
        T r1 = (T) KryptonReflectLoader.inst().getModuleDefaultInstance(r5, this);
        if (r1 == null) goto L12;
        registerModule(r5, r1);
        KryptonLLog.i(TAG, "get default instance for module " + r5.getName() + " success, auto registered.");
    L13:
        return r1;
    L12:
        KryptonLLog.w(TAG, "get module " + r5.getName() + " failed");
        goto L13
    }

    public <T extends KryptonService> T getService(Class<T> r5) {
        if (this.mDestroyed == false) goto L5;
        return null;
    L5:
        T r0 = (T) this.mServiceMap.get(r5);
        if (r0 == null) goto L8;
        return r0;
    L8:
        KryptonServiceLazyLoader r1 = this.mServiceLazyLoaderMap.get(r5);
        if (r1 != null) goto L11;
        return null;
    L11:
        this.mServiceLazyLoaderMap.remove(r5);
        T r2 = (T) r1.createServiceInstance(r5);
        if (r2 != null) goto L15;
        KryptonLLog.e(TAG, "lazy load service for " + r5.getName() + " failed");
        return null;
    L15:
        registerServiceAutoBootstrap(r5, r2);
        KryptonLLog.i(TAG, "lazy load service for " + r5.getName() + " success");
        return r2;
    }

    public void setAudioMuted(boolean r6) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (this.mFeatureFlag.getUseAurumAudioEngine() == false) goto L9;
        KryptonLLog.w(TAG, "setAudioMuted is only supported by audio, not aurum");
        return;
    L9:
        KryptonLLog.i(TAG, "setAudioMuted " + r6);
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L13;
        nativeSetAudioMuted(r0, r6);
        return;
    }

    public void setDevicePixelRatio(float r6) {
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L6;
        nativeSetDevicePixelRatio(r0, r6);
        return;
    }

    public void setEnableDrawCallStatistics(Boolean r6) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L5;
        nativeSetEnableDrawCallStatistics(r0, r6.booleanValue());
        return;
    L5:
        KryptonLLog.w(TAG, "native handler null");
    }

    public void setEnablePerformanceStatistics(Boolean r6) {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L5;
        nativeSetEnablePerformanceStatistics(r0, r6.booleanValue());
        return;
    L5:
        KryptonLLog.w(TAG, "native handler null");
    }

    public void setFirstOnScreenCanvasFrameCallback(Runnable r6) {
        if (this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen() == true) goto L10;
        if (this.mFeatureFlag.enableFirstFrameCallback() == true) goto L10;
        throw new IllegalStateException("KryptonFeatureFlag isFirstCanvasIsTheOnlyOnScreen and enableFirstFrameCallback is false");
    L10:
        if (this.mNativeHandler != 0) goto L13;
        KryptonLLog.e(TAG, "setFirstOnScreenCanvasFrameCallback but no native handler");
        return;
    L13:
        this.mFirstOnScreenCanvasFrameCallback = r6;
        FirstOnScreenCanvasFrameCallback r7 = new AnonymousClass3(this);
        nativeSetFirstOnScreenCanvasFrameCallback(this.mNativeHandler, r7);
    }

    public void setRenderFrameCallback(RenderFrameCallback r6) {
        long r0 = this.mNativeHandler;
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "setRenderFrameCallback but no native handler");
        return;
    L6:
        nativeSetRenderFrameCallback(r0, new RenderFrameCallbackWrapper(r6));
    }

    public void setRuntimeTaskRunner(long r6) {
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L5;
        nativeSetRuntimeTaskRunner(r0, r6);
        return;
    L5:
        KryptonLLog.e(TAG, "setRuntimeTaskRunner should be called after init");
    }

    public void setScenarioTag(String r6) {
        if (this.mDestroyed == true) goto L9;
        long r0 = this.mNativeHandler;
        if (r0 == 0) goto L10;
        nativeSetScenarioTag(r0, r6);
        return;
    L10:
        return;
    }

    public void setTimeToInteractiveCallback(TimeToInteractiveCallback r7) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r0 = this.mNativeHandler;
        if (r0 != 0) goto L6;
        KryptonLLog.e(TAG, "setTimeToInteractiveCallback but no native handler");
        return;
    L6:
        this.mTimeToInteractiveCallback = r7;
        if (r7 != null) goto L10;
        KryptonLLog.w(TAG, "setTimeToInteractiveCallback but with null");
        return;
    L10:
        nativeSetTimeToInteractiveCallback(r0, r7);
    }

    public void setUncaughtExceptionHandler(ScriptErrorHandler r7) {
        this.mUncaughtExceptionHandler = r7;
        long r0 = this.jsEnv;
        if (r0 == 0) goto L8;
        long r4 = this.mNativeHandler;
        if (r4 == 0) goto L9;
        nativeSetUncaughtExceptionHandler(r4, r0);
        return;
    L9:
        return;
    }

    public KryptonApp(KryptonFeatureFlag r6, Context r7) {
        this.mServiceMap = new ConcurrentHashMap();
        this.mServiceLazyLoaderMap = new ConcurrentHashMap();
        this.mModuleMap = new ConcurrentHashMap();
        this.jsEnv = 0;
        this.mUncaughtExceptionHandler = null;
        this.mRatio = 1.0f;
        KryptonLLog.i(TAG, "construct with " + r6);
        this.mFeatureFlag = r6;
        this.mContext = r7;
        this.mPermissionManager = new CanvasPermissionManager();
        this.mResourceLoader = new CanvasResourceLoader(this);
        this.mVSyncMonitor = new KryptonVSyncMonitor(this);
        this.mNapiFactory = new KryptonNapiRuntimeFactory(this);
        this.mRatio = INVOKEVIRTUAL_com_lynx_canvas_KryptonApp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
        long r8 = nativeCreateInstance(this.mFeatureFlag, this.mResourceLoader, this.mVSyncMonitor, this.mNapiFactory);
        this.mNativeHandler = r8;
        if (r8 == 0) goto L5;
        nativeSetDevicePixelRatio(r8, this.mRatio);
        return;
    L5:
        KryptonLLog.e(TAG, "construct error! nativeCreateInstance result null");
    }

    public static /* synthetic */ void access$000(KryptonApp r0, KryptonService r1) {
        r0.onBootstrapForService(r1);
    }

    public static /* synthetic */ void access$400(KryptonApp r0, KryptonModule r1) {
        r0.onBootstrapForModule(r1);
    }

    private void registerServiceAutoBootstrap(Class r5, final KryptonService r6) {
        this.mServiceMap.put(r5, r6);
        if (this.mRuntimeHandler != null) goto L5;
        return;
    L5:
        if (this.jsEnv == 0) goto L14;
        Looper r7 = Looper.myLooper();
        if (r7 != null) goto L9;
    L11:
        this.mRuntimeHandler.post(new AnonymousClass1(this, r6));
        return;
    L9:
        if (r7.equals(this.mRuntimeHandler.getLooper()) == false) goto L11;
        onBootstrapForService(r6);
        return;
    }

    public <T extends KryptonModule> void registerModule(Class r5, final T r6) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (r6 == null) goto L23;
        if (r5 == null) goto L23;
        if (r5.isAssignableFrom(r6.getClass()) == true) goto L11;
        KryptonLLog.w(TAG, "module class type error");
        return;
    L11:
        KryptonLLog.i(TAG, "register module: ".concat(r5.getName()));
        this.mModuleMap.put(r5, r6);
        if (this.mRuntimeHandler != null) goto L14;
        return;
    L14:
        if (this.jsEnv == 0) goto L25;
        Looper r7 = Looper.myLooper();
        if (r7 != null) goto L18;
    L20:
        this.mRuntimeHandler.post(new AnonymousClass4(this, r6));
        return;
    L18:
        if (r7.equals(this.mRuntimeHandler.getLooper()) == false) goto L20;
        onBootstrapForModule(r6);
        return;
    L25:
        return;
    L23:
        throw new IllegalArgumentException("do not support unregister module or register null module");
    }

    public <T extends KryptonService> void registerService(Class r5, T r6) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (r6 == null) goto L17;
        if (r5 == null) goto L17;
        if (r5.isAssignableFrom(r6.getClass()) == false) goto L13;
        KryptonLLog.i(TAG, "register ".concat(r5.getName()));
        this.mServiceLazyLoaderMap.remove(r5);
        registerServiceAutoBootstrap(r5, r6);
        return;
    L13:
        if (KryptonServiceLazyLoader.class.isAssignableFrom(r6.getClass()) == false) goto L15;
        KryptonLLog.i(TAG, "register " + r5.getName() + " lazy loader");
        this.mServiceMap.remove(r5);
        this.mServiceLazyLoaderMap.put(r5, (KryptonServiceLazyLoader) r6);
        return;
    L15:
        KryptonLLog.e(TAG, "register " + r5.getName() + " failed: service class type error");
        return;
    L17:
        KryptonLLog.e(TAG, "register service failed: empty interface class or service");
    }

    public void runBuffer(final byte[] r3, final Consumer<byte[]> r4) {
        if (r3 != null) goto L4;
    L10:
        KryptonLLog.e(TAG, "runBuffer failed: data is null");
        return;
    L4:
        if (r3.length == 0) goto L10;
        Handler r0 = this.mRuntimeHandler;
        if (r0 == null) goto L12;
        r0.post(new AnonymousClass2(this, r3, r4));
        return;
    }

    public void setAudioDownstreamCallback(AudioFrameCallback r8, AudioDownstreamMode r9) {
        if (r9 != null) goto L4;
        r9 = AudioDownstreamMode.KEEP_PLAYBACK;
    L4:
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.mDestroyed == false) goto L10;
        KryptonLLog.e(TAG, "setAudioDownstreamCallback but app has been destroyed");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L10:
        long r0 = this.mNativeHandler;     // Catch: Throwable -> L30
        if (r0 != 0) goto L15;
        KryptonLLog.e(TAG, "setAudioDownstreamCallback but no native handler");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L15:
        if (r8 != null) goto L20;
        nativeSetAudioDownstreamCallback(r0, null, r9.value);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L20:
        if (this.mBootstrapped == true) goto L22;
    L27:
        KryptonLLog.e(TAG, "setAudioDownstreamCallback before bootstrap");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L22:
        if (this.jsEnv == 0) goto L27;
        nativeSetAudioDownstreamCallback(r0, new AudioFrameCallbackWrapper(r8), r9.value);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
    }

    public void sendToRemoteChannel(String r8, long r9, String r11, String r12) {
        KryptonRemoteChannelService r1 = (KryptonRemoteChannelService) getService(KryptonRemoteChannelService.class);
        if (r1 == null) goto L5;
        r1.send(r8, r9, r11, r12);
        return;
    L5:
        KryptonLLog.w(TAG, "sendToRemoteChannel failed: channel not registered. class: " + r8 + ", type: " + r11);
    }
}
