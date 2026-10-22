package com.lynx.tasm;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.base.IBaseNativeLibraryLoader;
import com.lynx.base.LynxBaseEnv;
import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.jsbridge.LynxBytecodeCallback;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.WebAssemblyBridge;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxNativeMemoryTracer;
import com.lynx.tasm.base.LynxTraceEnv;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.fluency.FluencySample;
import com.lynx.tasm.icu.ICURegister;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxEnv {
    private static final String AUTOLINK_GENERATED_CLASS_NAME = "com.lynx.tasm.library.LynxAutolinkGenerated";
    private static final String AUTOLINK_SETUP_GLOBAL_METHOD = "setupGlobal";
    private static final int CONCURRENT_TASK_NORMAL_PRIORITY = 1;
    private static final int MTS_CONTEXT_POOL_DEFAULT_SIZE = -1;
    public static final int MTS_CONTEXT_TYPE_LEPUS_NG = 1;
    public static final int MTS_CONTEXT_TYPE_RTS = 2;
    public static final int MTS_CONTEXT_TYPE_RTS_NATIVE = 3;
    public static final int MTS_CONTEXT_TYPE_VM = 0;
    public static final String SP_NAME = "lynx_env_config";
    protected static final String TAG = "LynxEnv";
    private static ILynxDevToolService devtoolService;
    protected static final ConcurrentHashMap<String, String> sExperimentSettingsMap = null;
    protected static final com.lynx.tasm.base.d sGlobalRefQueue = null;
    protected static c sInitializer;
    protected static volatile LynxEnv sInstance;
    protected volatile boolean hasCalledInitializer;
    protected final AtomicBoolean hasInit;
    protected final Map<String, com.lynx.tasm.behavior.a> mBehaviorMap;
    protected a7a.c mBgImageLoader;
    protected final r1 mClient;
    protected Application mContext;
    protected boolean mCreateViewAsync;
    protected boolean mDebug;
    protected boolean mDebugModeEnabled;
    protected boolean mDisableBigImageHelper;
    protected boolean mDisableImagePostProcessor;
    protected boolean mEnableCheckAccessFromNonUIThread;
    protected boolean mEnableComponentStatisticReport;
    protected boolean mEnableDataListFix;
    protected boolean mEnableFSP;
    protected boolean mEnableFlattenImageFlickerFix;
    protected boolean mEnableGenericResourceFetcher;
    protected boolean mEnableImageAsyncLayout;
    protected boolean mEnableImageAsyncRedirect;
    protected boolean mEnableImageAsyncRedirectOnCreate;
    protected boolean mEnableImageAsyncRequest;
    protected boolean mEnableImageEventReport;
    protected boolean mEnableImageMemoryReport;
    protected boolean mEnableImageRequestOptimize;
    private boolean mEnableInitDisplayMetricsInEnv;
    protected boolean mEnableJSDebug;
    private boolean mEnableLazyInitA11y;
    protected boolean mEnableLoadImageFromService;
    private volatile boolean mEnablePlatformObservability;
    protected boolean mEnableRefreshRateOpt;
    protected boolean mEnableSVGAsync;
    protected boolean mEnableTextBoringLayout;
    private boolean mEnableTextLayoutCache;
    protected boolean mEnableTransformForPositionCalculation;
    protected HashMap<String, String> mFSPConfig;
    private boolean mForceDisableQuickJsCache;
    protected Map<String, d8a.k> mGlobalResourceProvider;
    protected volatile boolean mHasInitCompleted;
    private Boolean mHasV8BridgeLoadSuccess;
    protected InputMethodManager mInputMethodManager;
    protected boolean mIsCheckPropsSetter;
    protected boolean mIsDevLibraryLoaded;
    protected volatile boolean mIsNativeLibraryLoaded;
    protected volatile boolean mIsNativeUIThreadInited;
    protected String mLastUrl;
    protected boolean mLayoutOnlyEnabled;
    protected final Object mLazyInitLock;
    protected INativeLibraryLoader mLibraryLoader;
    protected String mLocale;
    protected LynxModuleFactory mModuleFactory;
    protected d8a.a mNetworkingModuleProvider;
    protected boolean mRecordEnable;
    protected d8a.l mResProvider;
    protected SharedPreferences mSharedPreferences;
    protected d8a.b mTemplateProvider;
    protected d8a.m mThemeResourceProvider;
    protected com.lynx.tasm.behavior.b mViewManagerBundle;
    protected boolean mVsyncAlignedFlushGlobalSwitch;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MTSContextType {
    }

    public class a implements IBaseNativeLibraryLoader {
        public final /* synthetic */ INativeLibraryLoader a;

        public a(INativeLibraryLoader r1) {
            this.a = r1;
        }

        @Override // com.lynx.base.IBaseNativeLibraryLoader
        public final void loadLibrary(String r2) throws UnsatisfiedLinkError {
            this.a.loadLibrary(r2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LynxEnv a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a.mIsNativeLibraryLoaded == false) goto L10;
            LynxEnv.nativeInitUIThread();     // Catch: Throwable -> L7
            this.a.mIsNativeUIThreadInited = true;     // Catch: Throwable -> L7
            return;
        }

        public b(LynxEnv r1) {
            this.a = r1;
        }
    }

    public interface c {
    }

    public static /* synthetic */ Map a(String r0) {
        return lambda$reportEnableEvent$1(r0);
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void access$002(String r0) {
        System.loadLibrary(r0);
    }

    public static /* synthetic */ void b(int r0, int r1) {
        lambda$prepareLynxGlobalPoolByContextType$2(r0, r1);
    }

    public static /* synthetic */ void c(int r0) {
        lambda$registerNativeMemoryPressureCallback$0(r0);
    }

    private static native void nativeClearBytecode(String r0, boolean r1);

    public static native void nativeInitUIThread();

    private static native void nativeOnMemoryPressure(int r0);

    public static native void nativePrepareLynxGlobalPool();

    public static native void nativePrepareLynxGlobalPoolByContextType(int r0, int r1);

    public static native void nativePrepareLynxGlobalPoolByContextTypeOnJavaThread(int r0, int r1);

    public static native void nativeRunJavaTaskOnConcurrentLoop(long r0, int r2);

    private static native void nativeSetGlobalBytecodeGenerateCallback(LynxBytecodeCallback r0);

    public static void setLazyInitializer(c r0) {
    }

    public void enableRadonCompatible(boolean r1) {
    }

    public void forceDisableQuickJsCache() {
        this.mForceDisableQuickJsCache = true;
        setBooleanLocalEnv(LynxEnvKey.FORCE_DISABLE_QUICKJS_CACHE, true);
    }

    public synchronized String getLastUrl() {
        monitor-enter(this);
        String r0 = this.mLastUrl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public String getLynxVersion() {
        return "4.1.1-rc.34";
    }

    public void initNativeGlobalPool() {
        prepareLynxGlobalPoolByContextType(1, -1);
    }

    public boolean isRadonCompatibleEnabled() {
        return true;
    }

    public native void nativeCleanExternalCache();

    public native String nativeGetDebugEnvDescription();

    public native String nativeGetSSRApiVersion();

    public native void nativeSetGroupedEnv(String r1, boolean r2, String r3);

    public native void nativeSetGroupedEnvWithGroupSet(String r1, Set<String> r2);

    public native void nativeSetLocalEnv(String r1, String r2);

    public void warmClass() {
    }

    static {
        sExperimentSettingsMap = new ConcurrentHashMap();
        if (com.lynx.tasm.behavior.utils.c.a == true) goto L5;
        com.lynx.tasm.behavior.utils.c.a = true;
    L5:
        devtoolService = null;
        sGlobalRefQueue = new com.lynx.tasm.base.d();
    }

    private static ILynxDevToolService getDevtoolService() {
        if (devtoolService != null) goto L6;
        devtoolService = (ILynxDevToolService) i8a.n.c().a(ILynxDevToolService.class);
    L6:
        return devtoolService;
    }

    private void initDisplayMetrics() {
        boolean r0 = getBooleanFromExternalEnv(LynxEnvKey.INIT_DISPLAY_METRICS_IN_ENV, true);
        this.mEnableInitDisplayMetricsInEnv = r0;
        if (r0 == false) goto L6;
        DisplayMetricsHolder.updateOrInitDisplayMetrics(this.mContext);
        return;
    }

    private void initEnableDataListFix() {
        this.mEnableDataListFix = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_DATA_LIST_FIX, false);
    }

    private void initFSPConfig() {
        boolean r0 = getBooleanFromExternalEnv(LynxEnvKey.FSP_ENABLE, false);
        this.mEnableFSP = r0;
        if (r0 == false) goto L11;
        String r1 = getStringFromExternalEnv(LynxEnvKey.FSP_CONFIG_JSON_STRING);
        if (r1 == null) goto L12;
        this.mFSPConfig = (HashMap) new Gson().fromJson(r1, HashMap.class);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    public static LynxEnv inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxEnv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxEnv();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxEnv.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void registerNativeMemoryPressureCallback() {
        com.lynx.tasm.base.g r0 = com.lynx.tasm.base.g.b;
        MemoryPressureCallback r1 = new v();
        r0.a.addIfAbsent(r1);
    }

    public HashMap<String, String> GetPlatformEnvDebugDescription() {
        HashMap<String, String> r0 = new HashMap();
        LynxEnvKey[] r1 = LynxEnvKey.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        LynxEnvKey r4 = r1[r3];
        String r5 = r4.getDescription();
        if (r5 == null) goto L9;
        String r6 = getStringFromExternalEnv(r4);
        if (r6 == null) goto L9;
        r0.put(r5, r6);
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        return r0;
    }

    public boolean enableFallbackNewEngineRebuild() {
        return getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FALLBACK_NEW_ENGINE_REBUILD, true);
    }

    public boolean enableSkipUpdateViewportOnInitWhenMeasureSpecEmpty() {
        return getBooleanFromExternalEnv(LynxEnvKey.ENABLE_SKIP_UPDATE_VIEWPORT_ON_INIT_WHEN_MEASURE_SPEC_EMPTY, false);
    }

    public boolean enableVSyncAlignedMessageLoopGlobal() {
        return getBooleanFromExternalEnv(LynxEnvKey.ENABLE_VSYNC_ALIGNED_MESSAGE_LOOP_GLOBAL, false);
    }

    public Map<String, com.lynx.tasm.behavior.a> getBehaviorMap() {
        Map<String, com.lynx.tasm.behavior.a> r0 = this.mBehaviorMap;
        monitor-enter(r0);
        HashMap r1 = new HashMap(this.mBehaviorMap);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<com.lynx.tasm.behavior.a> getBehaviors() {
        Map<String, com.lynx.tasm.behavior.a> r0 = this.mBehaviorMap;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mBehaviorMap.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Boolean getEnableMemoryMonitor() {
        return Boolean.valueOf(getBooleanFromExternalEnv(LynxEnvKey.ENABLE_MEMORY_MONITOR, false));
    }

    public int getGlobalMemoryReportThresholdMB() {
        return getIntFromExternalEnv(LynxEnvKey.GLOBAL_MEMORY_REPORT_THRESHOLD_MB, 30);
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputMethodManager != null) goto L6;
        this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
    L6:
        return this.mInputMethodManager;
    }

    public String getLocale() {
        if (this.mLocale != null) goto L9;
        i8a.h r0 = (i8a.h) i8a.n.c().a(i8a.h.class);
        if (r0 == null) goto L7;
        this.mLocale = r0.getLocale();
        goto L9
    L7:
        this.mLocale = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    L9:
        return this.mLocale;
    }

    public String getMemoryAcquisitionDelaySec() {
        return getStringFromExternalEnv(LynxEnvKey.MEMORY_ACQUISITION_DELAY_SEC);
    }

    public long getMemoryReportIntervalSec() {
        String r0 = getStringFromExternalEnv(LynxEnvKey.MEMORY_REPORT_INTERVAL_SEC);
        if (r0 != null) goto L5;
    L8:
        return 1200;
    L5:
        if (r0.isEmpty() == true) goto L8;
        return CastLongProtector.parseLong(r0);
    }

    public LynxModuleFactory getModuleFactory() {
        if (this.mModuleFactory != null) goto L6;
        this.mModuleFactory = new LynxModuleFactory();
    L6:
        return this.mModuleFactory;
    }

    public String getSSRApiVersion() {
        if (this.mIsNativeLibraryLoaded == true) goto L7;
        LLog.e(TAG, "The local library is not loaded, getting the ssr api version failed.");
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return nativeGetSSRApiVersion();
    }

    public boolean hasInited() {
        return this.hasInit.get();
    }

    public void initBehaviors() {
        Map<String, com.lynx.tasm.behavior.a> r0 = this.mBehaviorMap;
        monitor-enter(r0);
        Iterator r1 = ((ArrayList) new com.lynx.tasm.behavior.d().create()).iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L9;
        addBehaviorInner((com.lynx.tasm.behavior.a) r1.next());     // Catch: Throwable -> L20
        goto L6
    L9:
        if (getBehaviorBundle() == null) goto L18;
        List<com.lynx.tasm.behavior.a> r2 = getBehaviorBundle().create();     // Catch: Throwable -> L20
        if (r2 != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L14:
        Iterator<com.lynx.tasm.behavior.a> r3 = r2.iterator();     // Catch: Throwable -> L20
    L16:
        if (r3.hasNext() == false) goto L18;
        addBehaviorInner(r3.next());     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void initDevtoolEnv() {
        if (isLynxDebugEnabled() == true) goto L5;
        return;
    L5:
        if (this.mContext == null) goto L19;
    L11:
        th = move-exception;
        LLog.e(TAG, "initDevtoolEnv failed: " + th.toString());
        return;
    L7:
        if (getDevtoolService() == null) goto L9;
        getDevtoolService().devtoolEnvInit(this.mContext);     // Catch: Throwable -> L11
    L14:
        return;
    L9:
        LLog.w(TAG, "DevtoolService not yet registered when initDevtoolEnv");     // Catch: Throwable -> L11
        goto L14
    }

    public void initEnableCheckAccessFromNonUiThread() {
        this.mEnableCheckAccessFromNonUIThread = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_CHECK_ACCESS_FROM_NON_UI_THREAD, false);
    }

    public void initEnableComponentStatisticReport() {
        this.mEnableComponentStatisticReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_COMPONENT_STATISTIC_REPORT, false);
    }

    public void initEnableGenericResourceFetcher() {
        this.mEnableGenericResourceFetcher = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_GENERIC_RESOURCE_FETCHER, false);
    }

    public void initEnableLazyInitA11y() {
        this.mEnableLazyInitA11y = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_LAZY_INIT_A11Y, true);
    }

    public void initEnableRefreshRateOpt() {
        this.mEnableRefreshRateOpt = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_REFRESH_RATE_OPT, true);
    }

    public void initEnableSvgAsync() {
        this.mEnableSVGAsync = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_SVG_ASYNC, false);
    }

    public void initEnableTextBoringLayout() {
        this.mEnableTextBoringLayout = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TEXT_BORING_LAYOUT, true);
    }

    public void initEnableTextLayoutCache() {
        this.mEnableTextLayoutCache = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TEXT_LAYOUT_CACHE, true);
    }

    public void initEnableTransformForPositionCalculation() {
        this.mEnableTransformForPositionCalculation = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_TRANSFORM_FOR_POSITION_CALCULATION, false);
    }

    public void initImageExperimentSettings() {
        this.mDisableImagePostProcessor = getBooleanFromExternalEnv(LynxEnvKey.DISABLE_POST_PROCESSOR, false);
        this.mEnableLoadImageFromService = getBooleanFromExternalEnv(LynxEnvKey.USE_NEW_IMAGE, false);
        this.mEnableImageAsyncRedirect = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REDIRECT, false);
        this.mEnableImageAsyncRedirectOnCreate = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REDIRECT_ON_CREATE, false);
        this.mEnableImageAsyncRequest = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_REQUEST, false);
        this.mEnableImageEventReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_EVENT_REPORT, false);
        this.mEnableImageAsyncLayout = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_ASYNC_LAYOUT, false);
        this.mEnableImageRequestOptimize = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_REQUEST_OPTIMIZE, false);
        this.mEnableFlattenImageFlickerFix = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FLATTEN_IMAGE_FLICKER_FIX, true);
        this.mDisableBigImageHelper = getBooleanFromExternalEnv(LynxEnvKey.DISABLE_BIG_IMAGE_HELPER, false);
    }

    public void initMemoryReportExperimentSettings() {
        this.mEnableImageMemoryReport = getBooleanFromExternalEnv(LynxEnvKey.ENABLE_IMAGE_MEMORY_REPORT, false);
    }

    public void initNativeUIThread() {
        if (this.mIsNativeUIThreadInited == false) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new b(this));
    }

    public boolean isInitCompleted() {
        if (this.mHasInitCompleted == true) goto L6;
        return false;
    L6:
        if (this.hasInit.get() == true) goto L8;
        return false;
    L8:
        if (this.mIsNativeLibraryLoaded == true) goto L10;
        return false;
    L10:
        if (this.mIsNativeUIThreadInited == false) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isSettingsEnableNewImage() {
        return getBooleanFromExternalEnv(LynxEnvKey.USE_NEW_IMAGE, true);
    }

    public void lazyInitIfNeeded() {
        Object r0 = this.mLazyInitLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInit.get() == false) goto L7;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L7:
        if (this.hasCalledInitializer == true) goto L18;
        z.a r1 = z.a;     // Catch: Throwable -> L20
        if (r1 != null) goto L12;
        boolean r2 = false;
    L13:
        this.hasCalledInitializer = r2;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == null) goto L24;
        r1.init();
        return;
    L24:
        return;
    L12:
        r2 = true;
        goto L13
    }

    public void onLowMemory() {
        z6a.v.a.a.a.evictAll();
    }

    public void postUpdateSettings() {
        if (this.mIsNativeLibraryLoaded == false) goto L6;
        nativeCleanExternalCache();
        FluencySample.a();
        return;
    }

    public boolean shouldForceLayoutOnBackgroundThread() {
        return getBooleanFromExternalEnv(LynxEnvKey.FORCE_LAYOUT_ON_BACKGROUND_THREAD, false);
    }

    public LynxEnv() {
        this.hasInit = new AtomicBoolean(false);
        this.mDebugModeEnabled = false;
        this.mLayoutOnlyEnabled = true;
        this.mRecordEnable = false;
        this.mCreateViewAsync = true;
        this.mVsyncAlignedFlushGlobalSwitch = true;
        this.mEnableJSDebug = true;
        this.mDebug = false;
        this.mIsNativeLibraryLoaded = false;
        this.mIsDevLibraryLoaded = false;
        this.mIsNativeUIThreadInited = false;
        this.mHasInitCompleted = false;
        this.mBehaviorMap = new HashMap();
        this.mClient = new r1();
        this.mBgImageLoader = null;
        this.mInputMethodManager = null;
        this.mIsCheckPropsSetter = true;
        this.hasCalledInitializer = false;
        this.mLibraryLoader = null;
        this.mGlobalResourceProvider = new HashMap();
        this.mLocale = null;
        this.mLastUrl = null;
        this.mDisableImagePostProcessor = false;
        this.mEnableLoadImageFromService = false;
        this.mEnableImageAsyncRedirect = false;
        this.mEnableImageAsyncRedirectOnCreate = false;
        this.mEnableImageAsyncRequest = false;
        this.mEnableImageRequestOptimize = false;
        this.mEnableFlattenImageFlickerFix = false;
        this.mDisableBigImageHelper = false;
        this.mEnableDataListFix = false;
        this.mEnableImageEventReport = false;
        this.mEnableImageAsyncLayout = false;
        this.mEnableImageMemoryReport = false;
        this.mEnableComponentStatisticReport = false;
        this.mEnableTransformForPositionCalculation = false;
        this.mEnableSVGAsync = false;
        this.mEnableGenericResourceFetcher = false;
        this.mEnableTextBoringLayout = true;
        this.mEnableRefreshRateOpt = true;
        this.mEnableCheckAccessFromNonUIThread = false;
        this.mLazyInitLock = new Object();
        this.mHasV8BridgeLoadSuccess = Boolean.FALSE;
        this.mForceDisableQuickJsCache = false;
        this.mEnableLazyInitA11y = true;
        this.mEnablePlatformObservability = false;
        this.mEnableTextLayoutCache = true;
        this.mEnableFSP = false;
        this.mFSPConfig = null;
        this.mEnableInitDisplayMetricsInEnv = true;
    }

    private void initVsyncMonitor() {
        if (enableFreshRateOpt() == false) goto L11;
        DisplayManager r0 = (DisplayManager) this.mContext.getSystemService("display");
        if (r0 == null) goto L12;
        VSyncMonitor.b = r0;
        VSyncMonitor.b();
        if (VSyncMonitor.e != null) goto L9;
        VSyncMonitor.e = new VSyncMonitor.d();
    L9:
        r0.registerDisplayListener(VSyncMonitor.e, new Handler(Looper.getMainLooper()));
        VSyncMonitor.d = true;
        return;
    L12:
        return;
    }

    public HashMap<String, String> GetNativeEnvDebugDescription() {
        return (HashMap) GsonProtectorUtils.fromJson(new Gson(), nativeGetDebugEnvDescription(), HashMap.class);
    L5:
        e = move-exception;
        LLog.e(TAG, "Convert native env json string failed. e: " + e.getMessage());
        return null;
    }

    public void initDevtool() {
        initDevtoolComponentAttachSwitch();
        initDevtoolEnv();
    }

    public void initDevtoolComponentAttachSwitch() {
        if (getDevtoolService() != null) goto L7;
        LLog.i(TAG, "attachDevToolComponent: DevTool service is null.");
        return;
    L7:
        if (getDevtoolService().isDevtoolAttached() == true) goto L10;
        LLog.i(TAG, "attachDevToolComponent: we are asked not to.");
        return;
    L10:
        DevToolLifecycle.getInstance().onAttached();
        LLog.i(TAG, "attachDevToolComponent: done.");
        if (DevToolSettings.inst().bootstrap().isLynxDebugEnabled() == false) goto L14;
        DevToolLifecycle.getInstance().onEnabled();
        return;
    }

    public boolean isDevtoolEnabled() {
        if (isLynxDebugEnabled() == true) goto L7;
        return false;
    L7:
        return DevToolSettings.inst().isDevToolEnabled();
    }

    public boolean isEnableDevtoolDebug() {
        return isDevtoolEnabled();
    }

    public boolean isEnableLogBox() {
        return isLogBoxEnabled();
    }

    public boolean isFspScreenshotEnabled() {
        if (isLynxDebugEnabled() == true) goto L7;
        return false;
    L7:
        return DevToolSettings.inst().isFSPScreenshotEnabled();
    }

    public boolean isHighlightTouchEnabled() {
        if (DevToolSettings.inst().isHighlightTouchEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isLynxDebugEnabled() == false) goto L7;
        return true;
    }

    public boolean isLaunchRecordEnabled() {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L7;
        return false;
    L7:
        return DevToolSettings.inst().isLaunchRecordEnabled();
    }

    public boolean isLogBoxEnabled() {
        if (isLynxDebugEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (DevToolSettings.inst().isLogBoxEnabled() == false) goto L9;
        if (DevToolSettings.inst().bootstrap().isLogBoxEnabled() == false) goto L9;
        return true;
    }

    public boolean isLynxDebugEnabled() {
        return DevToolLifecycle.getInstance().isEnabled();
    }

    public boolean isNativeLibraryLoaded() {
        lazyInitIfNeeded();
        return this.mIsNativeLibraryLoaded;
    }

    public boolean isPixelCopyEnabled() {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L7;
        return true;
    L7:
        return DevToolSettings.inst().isPixelCopyEnabled();
    }

    public boolean isRedBoxEnabled() {
        return isLogBoxEnabled();
    }

    public void setAppTracingAllowed() {
        if (TraceEvent.enableSystemTrace() == false) goto L17;
        LLog.d(TAG, "turn on systrace for app");     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
        INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Trace").getDeclaredMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
    L21:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public boolean disableBigImageHelper() {
        return this.mDisableBigImageHelper;
    }

    public boolean disableImagePostProcessor() {
        return this.mDisableImagePostProcessor;
    }

    public boolean enableCheckAccessFromNonUIThread() {
        return this.mEnableCheckAccessFromNonUIThread;
    }

    public boolean enableComponentStatisticReport() {
        return this.mEnableComponentStatisticReport;
    }

    public boolean enableDataListFix() {
        return this.mEnableDataListFix;
    }

    public boolean enableFSP() {
        return this.mEnableFSP;
    }

    public boolean enableFlattenImageFlickerFix() {
        return this.mEnableFlattenImageFlickerFix;
    }

    public boolean enableFreshRateOpt() {
        return this.mEnableRefreshRateOpt;
    }

    public boolean enableGenericResourceFetcher() {
        return this.mEnableGenericResourceFetcher;
    }

    public boolean enableImageAsyncLayout() {
        return this.mEnableImageAsyncLayout;
    }

    public boolean enableImageAsyncRedirect() {
        return this.mEnableImageAsyncRedirect;
    }

    public boolean enableImageAsyncRedirectOnCreate() {
        return this.mEnableImageAsyncRedirectOnCreate;
    }

    public boolean enableImageAsyncRequest() {
        return this.mEnableImageAsyncRequest;
    }

    public boolean enableImageEventReport() {
        return this.mEnableImageEventReport;
    }

    public boolean enableImageMemoryReport() {
        return this.mEnableImageMemoryReport;
    }

    public boolean enableImageRequestOptimize() {
        return this.mEnableImageRequestOptimize;
    }

    public boolean enableLazyInitA11y() {
        return this.mEnableLazyInitA11y;
    }

    public boolean enableLoadImageFromService() {
        return this.mEnableLoadImageFromService;
    }

    public boolean enableSvgAsync() {
        return this.mEnableSVGAsync;
    }

    public boolean enableTextBoringLayout() {
        return this.mEnableTextBoringLayout;
    }

    public boolean enableTextLayoutCache() {
        return this.mEnableTextLayoutCache;
    }

    public boolean enableTransformForPositionCalculation() {
        return this.mEnableTransformForPositionCalculation;
    }

    public Context getAppContext() {
        return this.mContext;
    }

    public a7a.c getBackgroundImageLoader() {
        return this.mBgImageLoader;
    }

    public com.lynx.tasm.behavior.b getBehaviorBundle() {
        return this.mViewManagerBundle;
    }

    public boolean getCreateViewAsync() {
        return this.mCreateViewAsync;
    }

    public HashMap<String, String> getFSPConfig() {
        return this.mFSPConfig;
    }

    public w6a.h getHeroTransitionManager() {
        return w6a.h.a.a;
    }

    public INativeLibraryLoader getLibraryLoader() {
        return this.mLibraryLoader;
    }

    public r1 getLynxViewClient() {
        return this.mClient;
    }

    public d8a.a getNetworkingModuleProvider() {
        return this.mNetworkingModuleProvider;
    }

    public boolean getRecordEnable() {
        return this.mRecordEnable;
    }

    public d8a.l getResProvider() {
        return this.mResProvider;
    }

    public Map<String, d8a.k> getResourceProvider() {
        return this.mGlobalResourceProvider;
    }

    public d8a.b getTemplateProvider() {
        return this.mTemplateProvider;
    }

    public d8a.m getThemeResourceProviderProvider() {
        return this.mThemeResourceProvider;
    }

    public boolean getVsyncAlignedFlushGlobalSwitch() {
        return this.mVsyncAlignedFlushGlobalSwitch;
    }

    public boolean isCheckPropsSetter() {
        return this.mIsCheckPropsSetter;
    }

    public boolean isDebugModeEnabled() {
        return this.mDebugModeEnabled;
    }

    public boolean isDevLibraryLoaded() {
        return this.mIsDevLibraryLoaded;
    }

    public boolean isEnableJSDebug() {
        return this.mEnableJSDebug;
    }

    public boolean isLayoutOnlyEnabled() {
        return this.mLayoutOnlyEnabled;
    }

    public boolean isPlatformObservabilityEnabled() {
        return this.mEnablePlatformObservability;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private void addBehaviorInner(com.lynx.tasm.behavior.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getName();
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mBehaviorMap.containsKey(r0) == false) goto L10;
        LLog.e(TAG, "Duplicated Behavior For Name " + r0 + " was added, oldBehavior will be override");
    L10:
        this.mBehaviorMap.put(r0, r4);
    }

    private void dispatchInitCompletionHandler(Runnable r1) {
        if (r1 == null) goto L5;
        UIThreadUtils.runOnUiThread(r1);
        return;
    }

    private String getDirectCaller(String r6) {
        String r0 = LynxEnv.class.getName();
        return DevToolSettings.getCallerBacktrace(r0, r6, new String[0], new String[]{Thread.class.getName(), r0});
    }

    public static String getStringFromExternalEnv(String r4) {
        ConcurrentHashMap<String, String> r0 = sExperimentSettingsMap;
        String r1 = r0.get(r4);
        if (r1 != null) goto L10;
        ILynxTrailService r2 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if (r2 == null) goto L7;
        r1 = r2.stringValueForTrailKey(r4);
    L7:
        if (r1 != null) goto L9;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r0.put(r4, r1);
    L10:
        return r1;
    }

    private void initBase(INativeLibraryLoader r3) {
        if (r3 == null) goto L4;
        a r0 = new a(r3);
    L5:
        LynxBaseEnv.inst().init(r0, isDevtoolEnabled());
        return;
    L4:
        r0 = null;
        goto L5
    }

    private static /* synthetic */ void lambda$registerNativeMemoryPressureCallback$0(int r0) {
        nativeOnMemoryPressure(r0);
    }

    private static /* synthetic */ Map lambda$reportEnableEvent$1(String r2) {
        HashMap r0 = new HashMap();
        r0.put("backtrace", r2);
        return r0;
    }

    public static void setGlobalBytecodeGenerateCallback(LynxBytecodeCallback r1) {
        if (inst().isNativeLibraryLoaded() == false) goto L6;
        nativeSetGlobalBytecodeGenerateCallback(r1);
        return;
    }

    public void addBehavior(com.lynx.tasm.behavior.a r2) {
        Map<String, com.lynx.tasm.behavior.a> r0 = this.mBehaviorMap;
        monitor-enter(r0);
        addBehaviorInner(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addBehaviors(List<com.lynx.tasm.behavior.a> r3) {
        Map<String, com.lynx.tasm.behavior.a> r0 = this.mBehaviorMap;
        monitor-enter(r0);
        Iterator<com.lynx.tasm.behavior.a> r4 = r3.iterator();     // Catch: Throwable -> L10
    L6:
        if (r4.hasNext() == false) goto L8;
        addBehaviorInner(r4.next());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void addLynxViewClient(q1 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mClient.a(r2);
    }

    public void enableDebugMode(boolean r3) {
        if (r3 == false) goto L4;
        String r0 = "Turn on DebugMode";
    L5:
        LLog.i(TAG, r0);
        this.mDebugModeEnabled = r3;
        TraceEvent.markTraceDebugMode(r3);
        DevToolSettings.inst().setDebugModeEnabled(r3);
        return;
    L4:
        r0 = "Turn off DebugMode";
        goto L5
    }

    public void enableDevtool(boolean r3) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        String r0 = "Turn on devtool";
    L8:
        LLog.i(TAG, r0);
        if (r3 == false) goto L11;
        LLog.setMinimumLoggingLevel(0);
    L12:
        DevToolSettings.inst().setDevToolEnabled(r3);
        return;
    L11:
        LLog.setMinimumLoggingLevel(2);
        goto L12
    L7:
        r0 = "Turn off devtool";
        goto L8
    }

    public void enableFspScreenshot(boolean r2) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        DevToolSettings.inst().setFSPScreenshotEnabled(r2);
    }

    public void enableHighlightTouch(boolean r3) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        String r0 = "Turn on highlighttouch";
    L8:
        LLog.i(TAG, r0);
        DevToolSettings.inst().setHighlightTouchEnabled(r3);
        return;
    L7:
        r0 = "Turn off highlighttouch";
        goto L8
    }

    public void enableLaunchRecord(boolean r3) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        String r0 = "Turn on launch record";
    L8:
        LLog.i(TAG, r0);
        DevToolSettings.inst().setLaunchRecordEnabled(r3);
        return;
    L7:
        r0 = "Turn off launch record";
        goto L8
    }

    public void enableLayoutOnly(boolean r3) {
        if (r3 == false) goto L4;
        String r0 = "Turn on LayoutOnly";
    L5:
        LLog.i(TAG, r0);
        this.mLayoutOnlyEnabled = r3;
        return;
    L4:
        r0 = "Turn off LayoutOnly";
        goto L5
    }

    public void enableLogBox(boolean r3) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        String r0 = "Turn on logbox";
    L8:
        LLog.i(TAG, r0);
        DevToolSettings.inst().setLogBoxEnabled(r3);
        return;
    L7:
        r0 = "Turn off logbox";
        goto L8
    }

    public void enableLynxDebug(boolean r4) {
        if (r4 == false) goto L4;
        String r0 = "enable lynx debug";
    L5:
        LLog.i(TAG, r0);
        if (DevToolLifecycle.getInstance().isAttached() == true) goto L11;
        if (r4 == false) goto L9;
        reportEnableEvent("enableLynxDebug", "lynxsdk_enable_lynx_debug_event");
    L9:
        DevToolSettings.inst().bootstrap().setLynxDebugEnabled(r4);
        return;
    L11:
        if (r4 == false) goto L13;
        reportEnableEvent("enableLynxDebug", "lynxsdk_enable_lynx_debug_event");
        DevToolLifecycle.getInstance().onEnabled();
        initDevtoolEnv();
        return;
    L13:
        DevToolLifecycle.getInstance().onDisabled();
        return;
    L4:
        r0 = "disable lynx debug";
        goto L5
    }

    public void enablePixelCopy(boolean r2) {
        if (DevToolLifecycle.getInstance().isEnabled() == true) goto L5;
        return;
    L5:
        DevToolSettings.inst().setPixelCopyEnabled(r2);
    }

    public void enablePlatformObservability(boolean r1) {
        this.mEnablePlatformObservability = r1;
    }

    public void enableRedBox(boolean r1) {
        enableLogBox(r1);
    }

    public void initLibraryLoader(INativeLibraryLoader r1) {
        if (r1 == null) goto L5;
        this.mLibraryLoader = r1;
        return;
    L5:
        if (this.mLibraryLoader != null) goto L9;
        this.mLibraryLoader = new x();
        return;
    }

    public synchronized boolean initNativeLibraries(INativeLibraryLoader r3) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsNativeLibraryLoaded == false) goto L8;
        monitor-exit(this);
        return true;
    L8:
        initLibraryLoader(r3);     // Catch: Throwable -> L26
    L21:
        e = move-exception;
        LLog.e(TAG, e.getMessage() + ". Loader used was: " + this.mLibraryLoader);     // Catch: Throwable -> L26
        return false;
    L10:
        if (LynxLiteConfigs.requireQuickSharedLibrary() == false) goto L13;
        this.mLibraryLoader.loadLibrary("quick");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
    L13:
        if (LynxBaseEnv.inst().isNativeLibraryLoaded() == true) goto L15;
        initBase(this.mLibraryLoader);     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
    L15:
        this.mLibraryLoader.loadLibrary("lynxgfx");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
        this.mLibraryLoader.loadLibrary("lynx");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
        if (LynxTraceEnv.inst().isNativeLibraryLoaded() == true) goto L18;
        this.mLibraryLoader.loadLibrary("lynxtrace");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
        LynxTraceEnv.inst().markNativeLibraryLoaded(true);     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L26
    L18:
        this.mIsNativeLibraryLoaded = true;     // Catch: Throwable -> L26
        LLog.i(TAG, "Loading native libraries succeeded");     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    }

    public void initTrace(Context r2) {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        return;
    L5:
        if (TraceEvent.enableTrace() == false) goto L14;
        TraceController.getInstance().init(r2);     // Catch: Exception -> L8
        TraceController.getInstance().startStartupTracingIfNeeded();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        LLog.e(TAG, "trace controller init failed");
        return;
    }

    public void loadNativeLynxLibrary(INativeLibraryLoader r1) {
        initNativeLibraries(r1);
    }

    public void onPiperInvoked(Map<String, Object> r2) {
        this.mClient.onPiperInvoked(r2);
    }

    public void removeLynxViewClient(q1 r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mClient.a.remove(r2);
    }

    public void reportModuleCustomError(String r4) {
        this.mClient.onReceivedError(new LynxError(r4, 99800));
    }

    public void setBackgroundImageLoader(a7a.c r1) {
        this.mBgImageLoader = r1;
    }

    public void setCheckPropsSetter(boolean r1) {
        this.mIsCheckPropsSetter = r1;
    }

    public void setCreateViewAsync(boolean r2) {
        this.mCreateViewAsync = r2;
        if (r2 == false) goto L5;
        String r3 = "true";
    L6:
        LLog.i("LynxEnv_mCreateViewAsync:", r3);
        return;
    L5:
        r3 = "false";
        goto L6
    }

    public void setDebug(boolean r1) {
        this.mDebug = r1;
    }

    public void setDebugMode(Context r1) {
        boolean r2 = DevToolSettings.inst().isDebugModeEnabled();
        this.mDebugModeEnabled = r2;
        TraceEvent.markTraceDebugMode(r2);
    }

    public void setDevLibraryLoaded(boolean r1) {
        this.mIsDevLibraryLoaded = r1;
    }

    public void setEnableDevtoolDebug(boolean r1) {
        enableDevtool(r1);
    }

    public void setEnableJSDebug(boolean r1) {
        this.mEnableJSDebug = r1;
    }

    public void setEnableLogBox(boolean r1) {
        enableLogBox(r1);
    }

    public void setLastUrl(String r1) {
        this.mLastUrl = r1;
    }

    public void setLocale(String r1) {
        this.mLocale = r1;
    }

    public void setNativeLibraryLoaded(boolean r1) {
        this.mIsNativeLibraryLoaded = r1;
    }

    public void setNetworkingModuleProvider(d8a.a r1) {
        this.mNetworkingModuleProvider = r1;
    }

    public void setPiperMonitorState(boolean r2) {
        setBooleanLocalEnv(LynxEnvKey.ENABLE_PIPER_MONITOR, r2);
    }

    public void setRecordEnable(boolean r1) {
        this.mRecordEnable = r1;
    }

    public void setResProvider(d8a.l r1) {
        this.mResProvider = r1;
    }

    public void setSettings(HashMap<String, Object> r1) {
        sExperimentSettingsMap.clear();
        postUpdateSettings();
    }

    public void setThemeResourceProvider(d8a.m r1) {
        this.mThemeResourceProvider = r1;
    }

    public void setUpNativeMemoryTracer(Context r1) {
        LynxNativeMemoryTracer.a(r1);
    }

    public void setVsyncAlignedFlushGlobalSwitch(boolean r2) {
        this.mVsyncAlignedFlushGlobalSwitch = r2;
        setBooleanLocalEnv(LynxEnvKey.ENABLE_VSYNC_ALIGNED_FLUSH, r2);
        LLog.i(TAG, "mVsyncAlignedFlushGlobalSwitch: " + this.mVsyncAlignedFlushGlobalSwitch);
    }

    public void setupAutolinkGlobal(Context r2) {
        setupAutolinkGlobal(r2, AUTOLINK_GENERATED_CLASS_NAME);
    }

    public void trimMemory(int r4) {
        TraceEvent.beginSection("LynxEnv.trimMemory");
        if (r4 != 2) goto L5;
        onLowMemory();
    L5:
        Iterator<MemoryPressureCallback> r1 = com.lynx.tasm.base.g.b.a.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().onPressure(r4);
        goto L7
    L9:
        TraceEvent.endSection("LynxEnv.trimMemory");
    }

    public boolean tryToLoadV8Bridge(boolean r4) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasV8BridgeLoadSuccess.booleanValue() == false) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L20
        return true;
    L23:
        INativeLibraryLoader r0 = this.mLibraryLoader;     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        r0.loadLibrary("lynx_v8_bridge");     // Catch: Throwable -> L15
    L13:
        this.mHasV8BridgeLoadSuccess = Boolean.TRUE;     // Catch: Throwable -> L15
    L17:
        boolean r5 = this.mHasV8BridgeLoadSuccess.booleanValue();     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r5;
    L12:
        INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynx_v8_bridge");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        LLog.w(TAG, "try to load library lynx_v8_bridge error" + th.toString());     // Catch: Throwable -> L20
        this.mHasV8BridgeLoadSuccess = Boolean.FALSE;     // Catch: Throwable -> L20
        goto L17
    }

    public static String getStringFromExternalEnv(LynxEnvKey r0) {
        return getStringFromExternalEnv(r0.getDescription());
    }

    public static void clearBytecode(String r1, boolean r2) {
        if (inst().isNativeLibraryLoaded() == false) goto L6;
        nativeClearBytecode(r1, r2);
        return;
    }

    private Class<?> findAutolinkGeneratedClass(Context r4, String r5) throws ClassNotFoundException {
        ClassLoader r6 = r4.getClassLoader();
        return INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r5, true, r6);
    L5:
        e = move-exception;
        ClassLoader r2 = ThreadMethodProxy.currentThread().getContextClassLoader();
        if (r2 == null) goto L11;
        if (r2 == r6) goto L11;
        return INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r5, true, r2);
    L11:
        throw e;
    }

    public static boolean getBooleanFromExternalEnv(LynxEnvKey r1, boolean r2) {
        String r3 = getStringFromExternalEnv(r1.getDescription());
        if (r3 != null) goto L5;
    L14:
        return r2;
    L5:
        if (r3.isEmpty() == true) goto L14;
        if ("1".equals(r3) == false) goto L9;
    L12:
        return true;
    L9:
        if ("true".equalsIgnoreCase(r3) == true) goto L12;
        return false;
    }

    public static int getIntFromExternalEnv(LynxEnvKey r1, int r2) {
        String r3 = getStringFromExternalEnv(r1.getDescription());
        if (r3 != null) goto L5;
    L8:
        return r2;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return CastIntegerProtector.parseInt(r3);
    }

    private static /* synthetic */ void lambda$prepareLynxGlobalPoolByContextType$2(int r0, int r1) {
        nativePrepareLynxGlobalPoolByContextTypeOnJavaThread(r0, r1);
    }

    public static void onJavaTaskOnConcurrentLoop(long r4, int r6) {
        com.lynx.tasm.base.d r0 = sGlobalRefQueue;
        if (r4 >= 0) goto L5;
        r0.getClass();
        Object r1 = null;
    L6:
        Runnable r2 = (Runnable) r1;
        if (r2 != null) goto L10;
        LLog.e(TAG, "Failed to get java task for id " + r4 + " type " + r6);
        return;
    L10:
        r2.run();
        return;
    L5:
        r1 = r0.a.remove(Long.valueOf(r4));
        goto L6
    }

    private void reportEnableEvent(String r2, String r3) {
        final String r4 = getDirectCaller(r2);
        LynxEventReporter.onEvent(r3, -1, new y(r4));
    }

    public static boolean runJavaTaskOnConcurrentLoop(Runnable r4, int r5) {
        com.lynx.tasm.base.d r0 = sGlobalRefQueue;
        if (r4 != null) goto L5;
        r0.getClass();
        long r1 = -1;
    L7:
        if (r1 >= 0) goto L10;
        LLog.e(TAG, "Failed to get free slot for java task");
        return false;
    L10:
        nativeRunJavaTaskOnConcurrentLoop(r1, r5);
        return true;
    L5:
        long r2 = r0.b.incrementAndGet();
        r0.a.put(Long.valueOf(r2), r4);
        r1 = r2;
        goto L7
    }

    public void addResourceProvider(String r2, d8a.k r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.mGlobalResourceProvider.put(r2, r3);
        return;
    }

    public void prepareLynxGlobalPoolByContextType(final int r2, final int r3) {
        if (this.mIsNativeLibraryLoaded == true) goto L6;
        return;
    L6:
        if (r2 != 3) goto L8;
        runJavaTaskOnConcurrentLoop(new w(r2, r3), 1);
        return;
    L8:
        nativePrepareLynxGlobalPoolByContextType(r2, r3);
    }

    public void registerModule(String r2, Class<? extends LynxModule> r3) {
        registerModule(r2, r3, null);
    }

    public void setBooleanLocalEnv(LynxEnvKey r1, boolean r2) {
        String r3 = r1.getDescription();
        if (r2 == false) goto L5;
        String r4 = "1";
    L6:
        nativeSetLocalEnv(r3, r4);
        return;
    L5:
        r4 = "0";
        goto L6
    }

    public void setStringLocalEnv(LynxEnvKey r1, String r2) {
        nativeSetLocalEnv(r1.getDescription(), r2);
    }

    public void setUpNativeMemoryTracer(Context r1, int r2) {
        if (r2 <= 0) goto L6;
        LynxNativeMemoryTracer.a = r2;
        LynxNativeMemoryTracer.a(r1);
        return;
    L6:
        throw new IllegalArgumentException("min watched size should be greater than 0");
    }

    public boolean setupAutolinkGlobal(Context r8, String r9) {
        Method r3 = findAutolinkGeneratedClass(r8, r9).getDeclaredMethod(AUTOLINK_SETUP_GLOBAL_METHOD, new Class[]{Context.class});     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L13 Throwable -> L16
        r3.setAccessible(true);     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L13 Throwable -> L16
        r3.invoke(null, new Object[]{r8});     // Catch: Throwable -> L5 InvocationTargetException -> L7 IllegalAccessException -> L13 Throwable -> L16
        return true;
    L16:
        LLog.d(TAG, "Lynx autolink generated entry is unavailable: " + r9);
        return false;
    L13:
        e = move-exception;
        LLog.e(TAG, "Failed to access Lynx autolink generated entry: " + e.getMessage());
    L15:
        return true;
    L7:
        e = move-exception;
        Throwable r10 = e.getTargetException();
        StringBuilder r1 = new StringBuilder("Failed to setup Lynx autolink generated entry: ");
        if (r10 == null) goto L11;
        String r11 = r10.toString();
    L12:
        r1.append(r11);
        LLog.e(TAG, r1.toString());
        goto L15
    L11:
        r11 = e.toString();
    L5:
        th = move-exception;
        LLog.e(TAG, "Failed to load Lynx autolink generated entry: " + th);
        goto L15
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_LynxEnv_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public void registerModule(String r2, Class<? extends LynxModule> r3, Object r4) {
        getModuleFactory().c(r2, r3, r4);
    }

    public static void reportPiperInvoked(String r2, String r3, String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("module-name", r2);
        r0.put("method-name", r3);
        r0.put(LynxEventReporter.PROP_NAME_URL, r5);
        if (r4.isEmpty() == true) goto L5;
        ArrayList r6 = new ArrayList();
        r6.add(r4);
        r0.put(LynxResourceModule.PARAMS_KEY, r6);
    L5:
        inst().onPiperInvoked(r0);
    }

    public synchronized void init(Application r8, INativeLibraryLoader r9, d8a.b r10, com.lynx.tasm.behavior.b r11) {
        monitor-enter(this);
        init(r8, r9, r10, r11, null, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void init(Application r8, INativeLibraryLoader r9, d8a.b r10, com.lynx.tasm.behavior.b r11, f r12) {
        monitor-enter(this);
        init(r8, r9, r10, r11, r12, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void init(Application r3, INativeLibraryLoader r4, d8a.b r5, com.lynx.tasm.behavior.b r6, f r7, Runnable r8) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.hasInit.compareAndSet(false, true) == true) goto L12;
        LLog.w(TAG, "LynxEnv is already initialized");     // Catch: Throwable -> L30
        if (this.mHasInitCompleted == true) goto L8;
    L10:
        monitor-exit(this);
        return;
    L8:
        if (this.mIsNativeLibraryLoaded == false) goto L10;
        dispatchInitCompletionHandler(r8);     // Catch: Throwable -> L30
        goto L10
    L12:
        this.mHasInitCompleted = false;     // Catch: Throwable -> L30
        LLog.i(TAG, "LynxEnv start init");     // Catch: Throwable -> L30
        i8a.n.c().b(r3);     // Catch: Throwable -> L30
        initBase(r4);     // Catch: Throwable -> L30
        initDevtoolComponentAttachSwitch();     // Catch: Throwable -> L30
        setAppTracingAllowed();     // Catch: Throwable -> L30
        if (com.lynx.tasm.behavior.utils.d.a == true) goto L15;
        com.lynx.tasm.behavior.utils.d.a = true;     // Catch: Throwable -> L30
    L15:
        this.mContext = r3;     // Catch: Throwable -> L30
        this.mViewManagerBundle = r6;     // Catch: Throwable -> L30
        this.mTemplateProvider = r5;     // Catch: Throwable -> L30
        this.mLibraryLoader = r4;     // Catch: Throwable -> L30
        initBehaviors();     // Catch: Throwable -> L30
        setupAutolinkGlobal(r3);     // Catch: Throwable -> L30
        DevToolSettings.inst().init(this.mContext);     // Catch: Throwable -> L30
        setDebugMode(this.mContext);     // Catch: Throwable -> L30
        initDevtoolEnv();     // Catch: Throwable -> L30
        if (initNativeLibraries(r4) == true) goto L19;
        monitor-exit(this);
        return;
    L19:
        initTrace(this.mContext);     // Catch: Throwable -> L30
        postUpdateSettings();     // Catch: Throwable -> L30
        WebAssemblyBridge.a();     // Catch: Throwable -> L30
        initNativeUIThread();     // Catch: Throwable -> L30
        initDisplayMetrics();     // Catch: Throwable -> L30
        initNativeGlobalPool();     // Catch: Throwable -> L30
        initImageExperimentSettings();     // Catch: Throwable -> L30
        initMemoryReportExperimentSettings();     // Catch: Throwable -> L30
        initEnableComponentStatisticReport();     // Catch: Throwable -> L30
        initEnableTransformForPositionCalculation();     // Catch: Throwable -> L30
        initEnableSvgAsync();     // Catch: Throwable -> L30
        initEnableGenericResourceFetcher();     // Catch: Throwable -> L30
        initEnableTextBoringLayout();     // Catch: Throwable -> L30
        initEnableRefreshRateOpt();     // Catch: Throwable -> L30
        initEnableCheckAccessFromNonUiThread();     // Catch: Throwable -> L30
        initEnableLazyInitA11y();     // Catch: Throwable -> L30
        initEnableTextLayoutCache();     // Catch: Throwable -> L30
        initEnableDataListFix();     // Catch: Throwable -> L30
        initFSPConfig();     // Catch: Throwable -> L30
        ICURegister.a(this.mLibraryLoader);     // Catch: Throwable -> L30
        i8a.b r9 = (i8a.b) i8a.n.c().a(i8a.b.class);     // Catch: Throwable -> L30
        if (r9 == null) goto L22;
        r9.onLynxEnvSetup();     // Catch: Throwable -> L30
    L23:
        ILynxImageService r10 = (ILynxImageService) i8a.n.c().a(ILynxImageService.class);     // Catch: Throwable -> L30
        if ((r10 instanceof ILynxImageServiceExtension) == false) goto L26;
        ((ILynxImageServiceExtension) r10).onLynxEnvSetup();     // Catch: Throwable -> L30
    L27:
        initVsyncMonitor();     // Catch: Throwable -> L30
        registerNativeMemoryPressureCallback();     // Catch: Throwable -> L30
        this.mHasInitCompleted = true;     // Catch: Throwable -> L30
        dispatchInitCompletionHandler(r8);     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L26:
        LLog.w(TAG, "LynxEnv failed to get ILynxImageServiceExtension");     // Catch: Throwable -> L30
        goto L27
    L22:
        LLog.w(TAG, "LynxEnv failed to get LynxExtensionService");     // Catch: Throwable -> L30
        goto L23
    }
}
