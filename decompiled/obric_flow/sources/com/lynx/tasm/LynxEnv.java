package com.lynx.tasm;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.writer.DaoWriter;
import com.google.gson.Gson;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.base.LynxBaseTrace;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.JNINamespace;
import com.lynx.tasm.base.LynxNativeMemoryTracer;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.fluency.FluencySample;
import com.lynx.tasm.icu.ICURegister;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.ILynxI18nService;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@JNINamespace
public class LynxEnv {
    public static final String SP_NAME = "lynx_env_config";
    protected static final String TAG = "LynxEnv";
    private static ILynxDevToolService devtoolService;
    protected static final ConcurrentHashMap<String, String> sExperimentSettingsMap = null;
    protected static final com.lynx.tasm.base.d sGlobalRefQueue = null;
    protected static o sInitializer;
    protected static volatile LynxEnv sInstance;
    protected volatile boolean hasCalledInitializer;
    protected final AtomicBoolean hasInit;
    protected final Map<String, com.lynx.tasm.behavior.a> mBehaviorMap;
    protected an.b mBgImageLoader;
    protected final p0 mClient;
    protected Application mContext;
    protected boolean mCreateViewAsync;

    @Deprecated
    protected boolean mDebug;
    protected boolean mDebugModeEnabled;
    protected boolean mDevToolComponentAttach;
    protected boolean mDisableImagePostProcessor;
    protected boolean mEnableCheckAccessFromNonUIThread;
    protected boolean mEnableComponentStatisticReport;
    protected boolean mEnableDataListFix;
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

    @Deprecated
    protected boolean mEnableJSDebug;
    private boolean mEnableLazyInitA11y;
    protected boolean mEnableLoadImageFromService;
    protected boolean mEnableRefreshRateOpt;
    protected boolean mEnableSVGAsync;
    protected boolean mEnableTextBoringLayout;
    private boolean mEnableTextLayoutCache;
    protected boolean mEnableTransformForPositionCalculation;
    private boolean mForceDisableQuickJsCache;
    protected Map<String, fo.h> mGlobalResourceProvider;
    private Boolean mHasV8BridgeLoadSuccess;
    protected boolean mHighlightTouchEnabled;
    protected InputMethodManager mInputMethodManager;
    protected boolean mIsCheckPropsSetter;
    protected boolean mIsDevLibraryLoaded;
    protected volatile boolean mIsNativeLibraryLoaded;
    protected boolean mIsNativeUIThreadInited;
    protected String mLastUrl;
    protected boolean mLayoutOnlyEnabled;
    protected final Object mLazyInitLock;
    protected h mLibraryLoader;
    protected String mLocale;
    protected LynxModuleFactory mModuleFactory;
    protected fo.a mNetworkingModuleProvider;
    protected boolean mRecordEnable;
    protected fo.i mResProvider;
    protected SharedPreferences mSharedPreferences;
    protected fo.c mTemplateProvider;
    protected fo.j mThemeResourceProvider;
    protected com.lynx.tasm.behavior.b mViewManagerBundle;
    protected boolean mVsyncAlignedFlushGlobalSwitch;

    static {
        sExperimentSettingsMap = new ConcurrentHashMap();
        if (jm.c.f18358b == true) goto L5;
        jm.c.f18358b = true;
    L5:
        devtoolService = null;
        sGlobalRefQueue = new com.lynx.tasm.base.d();
    }

    public LynxEnv() {
        this.hasInit = new AtomicBoolean(false);
        this.mDevToolComponentAttach = false;
        this.mDebugModeEnabled = false;
        this.mLayoutOnlyEnabled = true;
        this.mRecordEnable = false;
        this.mHighlightTouchEnabled = false;
        this.mCreateViewAsync = true;
        this.mVsyncAlignedFlushGlobalSwitch = true;
        this.mEnableJSDebug = true;
        this.mDebug = false;
        this.mIsNativeLibraryLoaded = false;
        this.mIsDevLibraryLoaded = false;
        this.mIsNativeUIThreadInited = false;
        this.mBehaviorMap = new HashMap();
        this.mClient = new p0();
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
        this.mEnableDataListFix = false;
        this.mEnableImageRequestOptimize = false;
        this.mEnableFlattenImageFlickerFix = false;
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
        this.mEnableTextLayoutCache = true;
        this.mEnableInitDisplayMetricsInEnv = true;
    }

    private void addBehaviorInner(com.lynx.tasm.behavior.a r5) {
        if (r5 == null) goto L12;
        String r10 = r5.f10172a;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.mBehaviorMap.containsKey(r10) == false) goto L10;
        LynxLog.b(4, TAG, "Duplicated Behavior For Name " + r10 + " was added, oldBehavior will be override");
    L10:
        this.mBehaviorMap.put(r10, r5);
        return;
    }

    public static void clearBytecode(String r5, boolean r10) {
        if (inst().isNativeLibraryLoaded() == false) goto L6;
        nativeClearBytecode(r5, r10);
        return;
    }

    public static boolean getBooleanFromExternalEnv(LynxEnvKey r5, boolean r10) {
        String r11 = getStringFromExternalEnv(r5.f9989a);
        if (r11 != null) goto L5;
    L15:
        return r10;
    L5:
        if (r11.isEmpty() == true) goto L15;
        if (IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r11) == false) goto L9;
        return true;
    L9:
        if ("true".equalsIgnoreCase(r11) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static String getStringFromExternalEnv(LynxEnvKey r5) {
        return getStringFromExternalEnv(r5.f9989a);
    }

    private void initBase(h r5) {
        if (r5 == null) goto L4;
        d0 r10 = new d0(r5);
    L5:
        km.a r11 = km.a.a();
        boolean r12 = isDevtoolEnabled();
        if (r11.f18685a == true) goto L51;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (r11.f18685a == false) goto L49;
        boolean r13 = r11.f18685a;     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
    L23:
        r11.f18685a = r13;
        goto L51
    L49:
        if (r10 == null) goto L17;
        ((h) r10.f10837a).a("lynxbase");     // Catch: Throwable -> L13 Exception -> L20
    L18:
        monitor-exit(r11);
        r13 = true;
        goto L23
    L17:
        System.loadLibrary("lynxbase");     // Catch: Throwable -> L13 Exception -> L20
    L20:
        Log.e("lynx base env init", "failed to load liblynxbase.so");     // Catch: Throwable -> L13
        r13 = false;
    L51:
    L29:
        e = move-exception;
        Log.e("lynx", "init LynxLogging exception [ " + e.getMessage() + " ]");
    L47:
    L39:
        e = move-exception;
        LynxLog.b(4, "lynx", "init LynxBaseTrace exception [ " + e.getMessage() + " ]");
        return;
    L37:
        if (LynxBaseTrace.f9719a == true) goto L42;
        LynxBaseTrace.f9719a = km.a.a().f18685a;     // Catch: ArrayIndexOutOfBoundsException -> L39
    L42:
        if (LynxBaseTrace.f9719a == false) goto L54;
        LynxBaseTrace.a();     // Catch: ArrayIndexOutOfBoundsException -> L39
        return;
    L54:
        return;
    L27:
        if (LynxLog.f9721b == true) goto L32;
        LynxLog.f9721b = km.a.a().f18685a;     // Catch: ArrayIndexOutOfBoundsException -> L29
    L32:
        if (LynxLog.f9721b == false) goto L47;
        LynxLog.c(r12);     // Catch: ArrayIndexOutOfBoundsException -> L29
        goto L47
    L4:
        r10 = null;
        goto L5
    }

    private void initDisplayMetrics() {
        boolean r5 = getBooleanFromExternalEnv(LynxEnvKey.L, true);
        this.mEnableInitDisplayMetricsInEnv = r5;
        if (r5 == false) goto L6;
        DisplayMetricsHolder.c(this.mContext, null);
        return;
    }

    private void initEnableDataListFix() {
        this.mEnableDataListFix = getBooleanFromExternalEnv(LynxEnvKey.J, false);
    }

    private void initVsyncMonitor() {
        if (enableFreshRateOpt() == false) goto L11;
        DisplayManager r5 = (DisplayManager) this.mContext.getSystemService("display");
        if (r5 == null) goto L12;
        VSyncMonitor.f10832b = r5;
        VSyncMonitor.b();
        if (VSyncMonitor.e != null) goto L9;
        VSyncMonitor.e = new mn.j(0);
    L9:
        r5.registerDisplayListener(VSyncMonitor.e, new Handler(Looper.getMainLooper()));
        VSyncMonitor.d = true;
        return;
    L12:
        return;
    }

    public static LynxEnv inst() {
        if (sInstance != null) goto L16;
        monitor-enter(LynxEnv.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new LynxEnv();     // Catch: Throwable -> L9
    L11:
        monitor-exit(LynxEnv.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private static native void nativeClearBytecode(String r5, boolean r10);

    public static native void nativeInitUIThread();

    public static native void nativePrepareLynxGlobalPool();

    public static native void nativeRunJavaTaskOnConcurrentLoop(long r5, int r10);

    @CalledByNative
    public static void onJavaTaskOnConcurrentLoop(long r5, int r10) {
        com.lynx.tasm.base.d r11 = sGlobalRefQueue;
        if (r5 >= 0) goto L5;
        r11.getClass();
        Object r12 = null;
    L6:
        Runnable r13 = (Runnable) r12;
        if (r13 != null) goto L10;
        LynxLog.b(4, TAG, "Failed to get java task for id " + r5 + " type " + r10);
        return;
    L10:
        r13.run();
        return;
    L5:
        r12 = r11.f10123a.remove(Long.valueOf(r5));
        goto L6
    }

    @CalledByNative
    public static void reportPiperInvoked(String r5, String r10, String r11, String r12) {
        HashMap r13 = new HashMap();
        r13.put("module-name", r5);
        r13.put("method-name", r10);
        r13.put("url", r12);
        if (r11.isEmpty() == true) goto L5;
        ArrayList r14 = new ArrayList();
        r14.add(r11);
        r13.put(LynxResourceModule.PARAMS_KEY, r14);
    L5:
        inst().onPiperInvoked(r13);
    }

    public static boolean runJavaTaskOnConcurrentLoop(Runnable r5, int r10) {
        com.lynx.tasm.base.d r11 = sGlobalRefQueue;
        if (r5 != null) goto L5;
        r11.getClass();
        long r12 = -1;
    L7:
        if (r12 >= 0) goto L10;
        LynxLog.b(4, TAG, "Failed to get free slot for java task");
        return false;
    L10:
        nativeRunJavaTaskOnConcurrentLoop(r12, r10);
        return true;
    L5:
        long r13 = r11.f10124b.incrementAndGet();
        r11.f10123a.put(Long.valueOf(r13), r5);
        r12 = r13;
        goto L7
    }

    @Deprecated
    public static void setLazyInitializer(o r5) {
    }

    public HashMap<String, String> GetNativeEnvDebugDescription() {
        return (HashMap) new Gson().fromJson(nativeGetDebugEnvDescription(), HashMap.class);
    L5:
        e = move-exception;
        LynxLog.b(4, TAG, "Convert native env json string failed. e: " + e.getMessage());
        return null;
    }

    public HashMap<String, String> GetPlatformEnvDebugDescription() {
        HashMap<String, String> r5 = new HashMap();
        LynxEnvKey[] r10 = LynxEnvKey.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        LynxEnvKey r13 = r10[r12];
        String r14 = r13.f9989a;
        if (r14 == null) goto L9;
        String r15 = getStringFromExternalEnv(r13);
        if (r15 == null) goto L9;
        r5.put(r14, r15);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r5;
    }

    public void addBehavior(@NonNull com.lynx.tasm.behavior.a r5) {
        Map<String, com.lynx.tasm.behavior.a> r10 = this.mBehaviorMap;
        monitor-enter(r10);
        addBehaviorInner(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addBehaviors(@NonNull List<com.lynx.tasm.behavior.a> r5) {
        Map<String, com.lynx.tasm.behavior.a> r10 = this.mBehaviorMap;
        monitor-enter(r10);
        Iterator<com.lynx.tasm.behavior.a> r11 = r5.iterator();     // Catch: Throwable -> L8
    L6:
        if (r11.hasNext() == false) goto L10;
        addBehaviorInner(r11.next());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void addLynxViewClient(o0 r5) {
        if (r5 == null) goto L9;
        p0 r10 = this.mClient;
        if (r10.f10927a.contains(r5) == true) goto L8;
        r10.f10927a.add(r5);
        return;
    L8:
        return;
    }

    public void addResourceProvider(String r5, fo.h r10) {
        if (TextUtils.isEmpty(r5) == true) goto L6;
        this.mGlobalResourceProvider.put(r5, r10);
        return;
    }

    public boolean disableImagePostProcessor() {
        return this.mDisableImagePostProcessor;
    }

    public boolean enableCheckAccessFromNonUIThread() {
        return this.mEnableCheckAccessFromNonUIThread;
    }

    @AnyThread
    public boolean enableComponentStatisticReport() {
        return this.mEnableComponentStatisticReport;
    }

    public boolean enableDataListFix() {
        return this.mEnableDataListFix;
    }

    public void enableDebugMode(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on DebugMode";
    L5:
        LynxLog.b(2, TAG, r10);
        this.mDebugModeEnabled = r5;
        TraceEvent.f10115c = r5;
        SharedPreferences r11 = this.mSharedPreferences;
        if (r11 != null) goto L9;
        LynxLog.b(4, TAG, "enableDebugMode() must be called after init()");
        return;
    L9:
        r11.edit().putBoolean("enable_debug_mode", r5).apply();
        return;
    L4:
        r10 = "Turn off DebugMode";
        goto L5
    }

    public void enableDevtool(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on devtool";
    L5:
        LynxLog.b(2, TAG, r10);
        if (r5 == false) goto L8;
        LynxLog.a(0);
    L9:
        setDevtoolEnv("enable_devtool", Boolean.valueOf(r5));
        return;
    L8:
        LynxLog.a(2);
        goto L9
    L4:
        r10 = "Turn off devtool";
        goto L5
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

    public void enableHighlightTouch(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on highlighttouch";
    L5:
        LynxLog.b(2, TAG, r10);
        setDevtoolEnv("enable_highlight_touch", Boolean.valueOf(r5));
        this.mHighlightTouchEnabled = r5;
        return;
    L4:
        r10 = "Turn off highlighttouch";
        goto L5
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

    @AnyThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean enableImageMemoryReport() {
        return this.mEnableImageMemoryReport;
    }

    public boolean enableImageRequestOptimize() {
        return this.mEnableImageRequestOptimize;
    }

    public void enableLaunchRecord(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on launch record";
    L5:
        LynxLog.b(2, TAG, r10);
        setDevtoolEnv("enable_launch_record", Boolean.valueOf(r5));
        return;
    L4:
        r10 = "Turn off launch record";
        goto L5
    }

    public void enableLayoutOnly(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on LayoutOnly";
    L5:
        LynxLog.b(2, TAG, r10);
        this.mLayoutOnlyEnabled = r5;
        return;
    L4:
        r10 = "Turn off LayoutOnly";
        goto L5
    }

    public boolean enableLazyInitA11y() {
        return this.mEnableLazyInitA11y;
    }

    public boolean enableLoadImageFromService() {
        return this.mEnableLoadImageFromService;
    }

    public void enableLogBox(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "Turn on logbox";
    L5:
        LynxLog.b(2, TAG, r10);
        setDevtoolEnv("enable_logbox", Boolean.valueOf(r5));
        return;
    L4:
        r10 = "Turn off logbox";
        goto L5
    }

    public void enableLynxDebug(boolean r5) {
        if (r5 == false) goto L4;
        String r10 = "enable lynx debug";
    L5:
        LynxLog.b(2, TAG, r10);
        ILynxDevToolService r11 = (ILynxDevToolService) ko.r.g().e(ILynxDevToolService.class);
        if (r11 == null) goto L8;
        r11.setLynxDebugPresetValue(r5);
    L8:
        initDevtoolEnv();
        return;
    L4:
        r10 = "disable lynx debug";
        goto L5
    }

    public void enablePixelCopy(boolean r5) {
        setDevtoolEnv("enable_pixel_copy", Boolean.valueOf(r5));
    }

    @Deprecated
    public void enableRadonCompatible(boolean r5) {
    }

    @Deprecated
    public void enableRedBox(boolean r5) {
        enableLogBox(r5);
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

    @AnyThread
    public boolean enableTransformForPositionCalculation() {
        return this.mEnableTransformForPositionCalculation;
    }

    public boolean enableVSyncAlignedMessageLoopGlobal() {
        return getBooleanFromExternalEnv(LynxEnvKey.f9979p, false);
    }

    public void forceDisableQuickJsCache() {
        this.mForceDisableQuickJsCache = true;
        setBooleanLocalEnv(LynxEnvKey.f9969b, true);
    }

    public Context getAppContext() {
        return this.mContext;
    }

    public an.b getBackgroundImageLoader() {
        return this.mBgImageLoader;
    }

    public com.lynx.tasm.behavior.b getBehaviorBundle() {
        return this.mViewManagerBundle;
    }

    public Map<String, com.lynx.tasm.behavior.a> getBehaviorMap() {
        Map<String, com.lynx.tasm.behavior.a> r5 = this.mBehaviorMap;
        monitor-enter(r5);
        HashMap r10 = new HashMap(this.mBehaviorMap);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public List<com.lynx.tasm.behavior.a> getBehaviors() {
        Map<String, com.lynx.tasm.behavior.a> r5 = this.mBehaviorMap;
        monitor-enter(r5);
        ArrayList r10 = new ArrayList(this.mBehaviorMap.values());     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean getCreateViewAsync() {
        return this.mCreateViewAsync;
    }

    public boolean getDevtoolEnv(String r5, boolean r10) {
        return ((Boolean) getDevtoolEnvInternal(r5, Boolean.valueOf(r10))).booleanValue();
    }

    public Object getDevtoolEnvInternal(String r5, Object r10) {
        if (isNativeLibraryLoaded() == true) goto L7;
        LynxLog.b(4, TAG, "getDevtoolEnv must be called after init! key: " + r5);
        return r10;
    L7:
        if (isLynxDebugEnabled() == true) goto L10;
        LynxLog.b(4, TAG, "getDevtoolEnv must be called when isLynxDebugEnabled = true key: " + r5);
        return r10;
    L10:
        ILynxDevToolService r11 = mm.d.f20112a;
        if ((r10 instanceof Boolean) == false) goto L19;
        ILynxDevToolService r12 = mm.d.f20112a;
        if (r12 != null) goto L15;
        LynxLog.b(4, "LynxDevToolUtils", "failed to get DevToolService");
        return r10;
    L15:
        return Boolean.valueOf(r12.getDevtoolBooleanEnv(r5, (Boolean) r10));
    L19:
        if ((r10 instanceof Integer) == false) goto L26;
        ILynxDevToolService r13 = mm.d.f20112a;
        if (r13 != null) goto L23;
        LynxLog.b(4, "LynxDevToolUtils", "failed to get DevToolService");
        return r10;
    L23:
        return r13.getDevtoolIntEnv(r5, (Integer) r10);
    L26:
        StringBuilder r14 = com.lynx.tasm.utils.e.b("value type error! key: ", r5, ", value: ");
        r14.append(r10.toString());
        LynxLog.b(4, "LynxDevToolUtils", r14.toString());
        return r10;
    }

    public Boolean getEnableMemoryMonitor() {
        return Boolean.valueOf(getBooleanFromExternalEnv(LynxEnvKey.G, false));
    }

    public xm.i getHeroTransitionManager() {
        return xm.f.f23173a;
    }

    public InputMethodManager getInputMethodManager() {
        if (this.mInputMethodManager != null) goto L6;
        this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
    L6:
        return this.mInputMethodManager;
    }

    public synchronized String getLastUrl() {
        monitor-enter(this);
        String r5 = this.mLastUrl;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public h getLibraryLoader() {
        return this.mLibraryLoader;
    }

    public String getLocale() {
        if (this.mLocale != null) goto L10;
        if (ko.r.g().e(ko.h.class) != null) goto L8;
        this.mLocale = Locale.getDefault().getLanguage() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + Locale.getDefault().getCountry();
        goto L10
    L8:
        throw new ClassCastException();
    L10:
        return this.mLocale;
    }

    public String getLynxVersion() {
        return "3.5.23-rc.34";
    }

    public p0 getLynxViewClient() {
        return this.mClient;
    }

    public String getMemoryAcquisitionDelaySec() {
        return getStringFromExternalEnv(LynxEnvKey.H);
    }

    public long getMemoryReportIntervalSec() {
        String r5 = getStringFromExternalEnv(LynxEnvKey.I);
        if (r5 != null) goto L5;
        return 1200;
    L5:
        if (r5.isEmpty() == true) goto L13;
        return Long.parseLong(r5);
    L14:
        return 1200;
    L13:
        return 1200;
    }

    public LynxModuleFactory getModuleFactory() {
        if (this.mModuleFactory != null) goto L6;
        this.mModuleFactory = new LynxModuleFactory(this.mContext);
    L6:
        return this.mModuleFactory;
    }

    public fo.a getNetworkingModuleProvider() {
        return null;
    }

    public boolean getRecordEnable() {
        return this.mRecordEnable;
    }

    public fo.i getResProvider() {
        return this.mResProvider;
    }

    public Map<String, fo.h> getResourceProvider() {
        return this.mGlobalResourceProvider;
    }

    public String getSSRApiVersion() {
        if (this.mIsNativeLibraryLoaded == true) goto L7;
        LynxLog.b(4, TAG, "The local library is not loaded, getting the ssr api version failed.");
        return "";
    L7:
        return nativeGetSSRApiVersion();
    }

    public fo.c getTemplateProvider() {
        return this.mTemplateProvider;
    }

    public fo.j getThemeResourceProviderProvider() {
        return null;
    }

    public boolean getVsyncAlignedFlushGlobalSwitch() {
        return this.mVsyncAlignedFlushGlobalSwitch;
    }

    public boolean hasInited() {
        return this.hasInit.get();
    }

    public synchronized void init(Application r10, h r11, fo.c r12, com.lynx.tasm.behavior.b r13) {
        monitor-enter(this);
        init(r10, r11, r12, r13, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void initBehaviors() {
        Map<String, com.lynx.tasm.behavior.a> r5 = this.mBehaviorMap;
        monitor-enter(r5);
        Iterator r10 = ((ArrayList) new com.lynx.tasm.behavior.d(0).create()).iterator();     // Catch: Throwable -> L8
    L6:
        if (r10.hasNext() == false) goto L11;
        addBehaviorInner((com.lynx.tasm.behavior.a) r10.next());     // Catch: Throwable -> L8
        goto L6
    L11:
        if (getBehaviorBundle() == null) goto L20;
        List r11 = getBehaviorBundle().create();     // Catch: Throwable -> L8
        if (r11 != null) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L16:
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L8
    L18:
        if (r12.hasNext() == false) goto L20;
        addBehaviorInner((com.lynx.tasm.behavior.a) r12.next());     // Catch: Throwable -> L8
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void initDevtool() {
        initDevtoolComponentAttachSwitch();
        initDevtoolEnv();
        syncDevtoolComponentAttachSwitch();
    }

    public void initDevtoolComponentAttachSwitch() {
        ILynxDevToolService r5 = (ILynxDevToolService) ko.r.g().e(ILynxDevToolService.class);
        devtoolService = r5;
        if (r5 == null) goto L5;
        this.mDevToolComponentAttach = r5.isDevtoolAttached();
    L6:
        LynxLog.b(2, TAG, "The current application has embedded the DevTool Component: " + this.mDevToolComponentAttach);
        return;
    L5:
        this.mDevToolComponentAttach = false;
        goto L6
    }

    public void initDevtoolEnv() {
        if (isLynxDebugEnabled() == true) goto L5;
        return;
    L5:
        if (this.mContext != null) goto L17;
        return;
    L17:
        ILynxDevToolService r5 = (ILynxDevToolService) ko.r.g().e(ILynxDevToolService.class);     // Catch: Exception -> L11
        devtoolService = r5;     // Catch: Exception -> L11
        if (r5 == null) goto L13;
        r5.devtoolEnvInit(this.mContext);     // Catch: Exception -> L11
        return;
    L13:
        LynxLog.b(4, TAG, "failed to get DevtoolService");     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, TAG, "initDevtoolEnv failed: " + e.toString());
    }

    public void initEnableCheckAccessFromNonUiThread() {
        this.mEnableCheckAccessFromNonUIThread = getBooleanFromExternalEnv(LynxEnvKey.f, false);
    }

    public void initEnableComponentStatisticReport() {
        this.mEnableComponentStatisticReport = getBooleanFromExternalEnv(LynxEnvKey.f9976m, false);
    }

    public void initEnableGenericResourceFetcher() {
        this.mEnableGenericResourceFetcher = getBooleanFromExternalEnv(LynxEnvKey.A, false);
    }

    public void initEnableLazyInitA11y() {
        this.mEnableLazyInitA11y = getBooleanFromExternalEnv(LynxEnvKey.E, true);
    }

    public void initEnableRefreshRateOpt() {
        this.mEnableRefreshRateOpt = getBooleanFromExternalEnv(LynxEnvKey.C, true);
    }

    public void initEnableSvgAsync() {
        this.mEnableSVGAsync = getBooleanFromExternalEnv(LynxEnvKey.s, false);
    }

    public void initEnableTextBoringLayout() {
        this.mEnableTextBoringLayout = getBooleanFromExternalEnv(LynxEnvKey.B, true);
    }

    public void initEnableTextLayoutCache() {
        this.mEnableTextLayoutCache = getBooleanFromExternalEnv(LynxEnvKey.F, true);
    }

    public void initEnableTransformForPositionCalculation() {
        this.mEnableTransformForPositionCalculation = getBooleanFromExternalEnv(LynxEnvKey.f9977n, false);
    }

    public void initImageExperimentSettings() {
        this.mDisableImagePostProcessor = getBooleanFromExternalEnv(LynxEnvKey.f9974k, false);
        this.mEnableLoadImageFromService = getBooleanFromExternalEnv(LynxEnvKey.f9971h, false);
        this.mEnableImageAsyncRedirect = getBooleanFromExternalEnv(LynxEnvKey.f9984v, false);
        this.mEnableImageAsyncRedirectOnCreate = getBooleanFromExternalEnv(LynxEnvKey.f9985w, false);
        this.mEnableImageAsyncRequest = getBooleanFromExternalEnv(LynxEnvKey.f9986x, false);
        this.mEnableImageEventReport = getBooleanFromExternalEnv(LynxEnvKey.f9982t, false);
        this.mEnableImageAsyncLayout = getBooleanFromExternalEnv(LynxEnvKey.f9983u, false);
        this.mEnableImageRequestOptimize = getBooleanFromExternalEnv(LynxEnvKey.f9987y, false);
        this.mEnableFlattenImageFlickerFix = getBooleanFromExternalEnv(LynxEnvKey.f9988z, true);
    }

    public void initLibraryLoader(h r5) {
        if (r5 == null) goto L6;
        this.mLibraryLoader = r5;
        return;
    L6:
        if (this.mLibraryLoader != null) goto L9;
        this.mLibraryLoader = new com.bytedance.ai.resource.core.net.a(15);
        return;
    }

    public void initMemoryReportExperimentSettings() {
        this.mEnableImageMemoryReport = getBooleanFromExternalEnv(LynxEnvKey.f9975l, false);
    }

    public void initNativeGlobalPool() {
        if (this.mIsNativeLibraryLoaded == false) goto L6;
        nativePrepareLynxGlobalPool();
        return;
    }

    public synchronized boolean initNativeLibraries(h r5) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsNativeLibraryLoaded == false) goto L8;
        monitor-exit(this);
        return true;
    L8:
        initLibraryLoader(r5);     // Catch: Throwable -> L12
        this.mLibraryLoader.a("quick");     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        if (km.a.a().f18685a == true) goto L16;
        initBase(this.mLibraryLoader);     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L16:
        this.mLibraryLoader.a("lynx");     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        if (com.lynx.tasm.base.f.a().f10127a == true) goto L19;
        this.mLibraryLoader.a("lynxtrace");     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        com.lynx.tasm.base.f.a().f10127a = true;     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
        TraceEvent.f10114b = true;     // Catch: Throwable -> L12 UnsatisfiedLinkError -> L14
    L19:
        this.mIsNativeLibraryLoaded = true;     // Catch: Throwable -> L12
        LynxLog.b(2, TAG, "Loading native libraries succeeded");     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L14:
        e = move-exception;
        LynxLog.b(4, TAG, e.getMessage() + ". Loader used was: " + this.mLibraryLoader);     // Catch: Throwable -> L12
        return false;
    }

    public void initNativeUIThread() {
        if (this.mIsNativeUIThreadInited == false) goto L5;
        return;
    L5:
        com.lynx.tasm.utils.j.f(new n(this, 0));
    }

    public void initTrace(Context r5) {
        if (this.mIsNativeLibraryLoaded == true) goto L5;
        return;
    L5:
        if (TraceEvent.f10115c == false) goto L14;
        TraceController.b().a(r5);     // Catch: Exception -> L8
        TraceController.b().d();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        LynxLog.b(4, TAG, "trace controller init failed");
        return;
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

    public boolean isDevtoolComponentAttach() {
        return this.mDevToolComponentAttach;
    }

    public boolean isDevtoolEnabled() {
        if (isLynxDebugEnabled() == true) goto L6;
        return false;
    L6:
        return getDevtoolEnv("enable_devtool", false);
    }

    @Deprecated
    public boolean isEnableDevtoolDebug() {
        return isDevtoolEnabled();
    }

    @Deprecated
    public boolean isEnableJSDebug() {
        return this.mEnableJSDebug;
    }

    @Deprecated
    public boolean isEnableLogBox() {
        return isLogBoxEnabled();
    }

    public boolean isHighlightTouchEnabled() {
        if (this.mHighlightTouchEnabled == true) goto L5;
        return false;
    L5:
        if (isLynxDebugEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isLaunchRecordEnabled() {
        return getDevtoolEnv("enable_launch_record", false);
    }

    public boolean isLayoutOnlyEnabled() {
        return this.mLayoutOnlyEnabled;
    }

    public boolean isLogBoxEnabled() {
        ILynxDevToolService r5 = (ILynxDevToolService) ko.r.g().e(ILynxDevToolService.class);
        if (isLynxDebugEnabled() == true) goto L5;
        return false;
    L5:
        if (getDevtoolEnv("enable_logbox", true) == false) goto L12;
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r5.getLogBoxPresetValue() == false) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    public boolean isLynxDebugEnabled() {
        ILynxDevToolService r5 = (ILynxDevToolService) ko.r.g().e(ILynxDevToolService.class);
        if (this.mDevToolComponentAttach == false) goto L9;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getLynxDebugPresetValue() == false) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public boolean isNativeLibraryLoaded() {
        lazyInitIfNeeded();
        return this.mIsNativeLibraryLoaded;
    }

    public boolean isPixelCopyEnabled() {
        return getDevtoolEnv("enable_pixel_copy", true);
    }

    @Deprecated
    public boolean isRadonCompatibleEnabled() {
        return true;
    }

    @Deprecated
    public boolean isRedBoxEnabled() {
        return isLogBoxEnabled();
    }

    public boolean isSettingsEnableNewImage() {
        return getBooleanFromExternalEnv(LynxEnvKey.f9971h, true);
    }

    public void lazyInitIfNeeded() {
        Object r5 = this.mLazyInitLock;
        monitor-enter(r5);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInit.get() == false) goto L7;
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.hasCalledInitializer == true) goto L14;
        this.hasCalledInitializer = false;     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
    }

    @Deprecated
    public void loadNativeLynxLibrary(h r5) {
        initNativeLibraries(r5);
    }

    public native void nativeCleanExternalCache();

    public native String nativeGetDebugEnvDescription();

    public native String nativeGetSSRApiVersion();

    public native void nativeSetEnvMask(String r5, boolean r10);

    public native void nativeSetGroupedEnv(String r5, boolean r10, String r11);

    public native void nativeSetGroupedEnvWithGroupSet(String r5, Set<String> r10);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public native void nativeSetLocalEnv(String r5, String r10);

    public void onLowMemory() {
        ((LruCache) zm.y.f23548a.f23549a).evictAll();
    }

    public void onPiperInvoked(Map<String, Object> r5) {
        this.mClient.onPiperInvoked(r5);
    }

    public void postUpdateSettings() {
        if (this.mIsNativeLibraryLoaded == false) goto L6;
        nativeCleanExternalCache();
        FluencySample.a();
        return;
    }

    public void registerModule(String r5, Class<? extends LynxModule> r10) {
        registerModule(r5, r10, null);
    }

    public void removeLynxViewClient(o0 r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mClient.f10927a.remove(r5);
    }

    public void reportModuleCustomError(String r5) {
        this.mClient.onReceivedError(new LynxError(r5, 99800));
    }

    public void setAppTracingAllowed() {
        if (TraceEvent.i() == false) goto L21;
        LynxLog.b(1, TAG, "turn on systrace for app");     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
        Class.forName("android.os.Trace").getDeclaredMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 ClassNotFoundException -> L12
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

    public void setBackgroundImageLoader(an.b r5) {
        this.mBgImageLoader = r5;
    }

    public void setBooleanLocalEnv(LynxEnvKey r5, boolean r10) {
        String r11 = r5.f9989a;
        if (r10 == false) goto L5;
        String r12 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L6:
        nativeSetLocalEnv(r11, r12);
        return;
    L5:
        r12 = "0";
        goto L6
    }

    public void setCheckPropsSetter(boolean r5) {
        this.mIsCheckPropsSetter = r5;
    }

    public void setCreateViewAsync(boolean r5) {
        this.mCreateViewAsync = r5;
        if (r5 == false) goto L5;
        String r10 = "true";
    L6:
        LynxLog.b(2, "LynxEnv_mCreateViewAsync:", r10);
        return;
    L5:
        r10 = "false";
        goto L6
    }

    @Deprecated
    public void setDebug(boolean r5) {
        this.mDebug = r5;
    }

    public void setDebugMode(Context r5) {
        SharedPreferences r10 = r5.getSharedPreferences(SP_NAME, 0);
        this.mSharedPreferences = r10;
        if (r10 != null) goto L5;
        this.mDebugModeEnabled = false;
    L6:
        TraceEvent.f10115c = this.mDebugModeEnabled;
        return;
    L5:
        this.mDebugModeEnabled = r10.getBoolean("enable_debug_mode", false);
        goto L6
    }

    public void setDevLibraryLoaded(boolean r5) {
        this.mIsDevLibraryLoaded = r5;
    }

    public void setDevtoolEnv(String r5, Object r10) {
        if (isNativeLibraryLoaded() == true) goto L5;
        return;
    L5:
        if (isLynxDebugEnabled() == false) goto L13;
        ILynxDevToolService r11 = mm.d.f20112a;
        if (r11 == null) goto L10;
        r11.setDevtoolEnv(r5, r10);
        return;
    L10:
        LynxLog.b(4, "LynxDevToolUtils", "failed to get DevToolService");
        return;
    }

    @Deprecated
    public void setEnableDevtoolDebug(boolean r5) {
        enableDevtool(r5);
    }

    @Deprecated
    public void setEnableJSDebug(boolean r5) {
        this.mEnableJSDebug = r5;
    }

    @Deprecated
    public void setEnableLogBox(boolean r5) {
        enableLogBox(r5);
    }

    public void setLastUrl(String r5) {
        this.mLastUrl = r5;
    }

    public void setLocale(String r5) {
        this.mLocale = r5;
    }

    public void setNativeLibraryLoaded(boolean r5) {
        this.mIsNativeLibraryLoaded = r5;
    }

    @Deprecated
    public void setNetworkingModuleProvider(fo.a r5) {
    }

    public void setPiperMonitorState(boolean r5) {
        setBooleanLocalEnv(LynxEnvKey.f9972i, r5);
    }

    public void setRecordEnable(boolean r5) {
        this.mRecordEnable = r5;
    }

    public void setResProvider(fo.i r5) {
        this.mResProvider = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSettings(HashMap<String, Object> r5) {
        sExperimentSettingsMap.clear();
        postUpdateSettings();
    }

    public void setStringLocalEnv(LynxEnvKey r5, String r10) {
        nativeSetLocalEnv(r5.f9989a, r10);
    }

    public void setThemeResourceProvider(fo.j r5) {
    }

    public void setUpNativeMemoryTracer(Context r5, int r10) {
        if (r10 <= 0) goto L6;
        LynxNativeMemoryTracer.f10105a = r10;
        LynxNativeMemoryTracer.c(r5);
        return;
    L6:
        throw new IllegalArgumentException("min watched size should be greater than 0");
    }

    public void setVsyncAlignedFlushGlobalSwitch(boolean r5) {
        this.mVsyncAlignedFlushGlobalSwitch = r5;
        setBooleanLocalEnv(LynxEnvKey.f9970c, r5);
        LynxLog.b(2, TAG, "mVsyncAlignedFlushGlobalSwitch: " + this.mVsyncAlignedFlushGlobalSwitch);
    }

    public boolean shouldForceLayoutOnBackgroundThread() {
        return getBooleanFromExternalEnv(LynxEnvKey.f9980q, false);
    }

    public void syncDevtoolComponentAttachSwitch() {
        if (isNativeLibraryLoaded() == true) goto L5;
        return;
    L5:
        if (this.mDevToolComponentAttach == false) goto L9;
        setBooleanLocalEnv(LynxEnvKey.f9978o, true);
        setBooleanLocalEnv(LynxEnvKey.K, isLynxDebugEnabled());
        return;
    }

    public boolean tryToLoadV8Bridge(boolean r5) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHasV8BridgeLoadSuccess.booleanValue() == false) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L9
        return true;
    L25:
        h r10 = this.mLibraryLoader;     // Catch: Throwable -> L14
        if (r10 == null) goto L16;
        r10.a("lynx_v8_bridge");     // Catch: Throwable -> L14
    L17:
        this.mHasV8BridgeLoadSuccess = Boolean.TRUE;     // Catch: Throwable -> L14
    L20:
        boolean r11 = this.mHasV8BridgeLoadSuccess.booleanValue();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r11;
    L16:
        System.loadLibrary("lynx_v8_bridge");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        LynxLog.b(3, TAG, "try to load library lynx_v8_bridge error" + th.toString());     // Catch: Throwable -> L9
        this.mHasV8BridgeLoadSuccess = Boolean.FALSE;     // Catch: Throwable -> L9
        goto L20
    }

    @Deprecated
    public void warmClass() {
    }

    public int getDevtoolEnv(String r5, int r10) {
        return ((Integer) getDevtoolEnvInternal(r5, Integer.valueOf(r10))).intValue();
    }

    @Deprecated
    public synchronized void init(Application r5, h r10, fo.c r11, com.lynx.tasm.behavior.b r12, @Nullable e r13) {
        monitor-enter(this);
        ko.r.g().j(r5);     // Catch: Throwable -> L8
        initBase(r10);     // Catch: Throwable -> L8
        initDevtoolComponentAttachSwitch();     // Catch: Throwable -> L8
        if (this.hasInit.get() == false) goto L10;
        LynxLog.b(3, TAG, "LynxEnv is already initialized");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        this.hasInit.set(true);     // Catch: Throwable -> L8
        LynxLog.b(2, TAG, "LynxEnv start init");     // Catch: Throwable -> L8
        setAppTracingAllowed();     // Catch: Throwable -> L8
        if (com.lynx.tasm.behavior.utils.d.f10792a == true) goto L13;
        com.lynx.tasm.behavior.utils.d.f10792a = true;     // Catch: Throwable -> L8
    L13:
        this.mContext = r5;     // Catch: Throwable -> L8
        this.mViewManagerBundle = r12;     // Catch: Throwable -> L8
        this.mTemplateProvider = r11;     // Catch: Throwable -> L8
        this.mLibraryLoader = r10;     // Catch: Throwable -> L8
        setDebugMode(r5);     // Catch: Throwable -> L8
        initBehaviors();     // Catch: Throwable -> L8
        LynxModuleFactory r14 = getModuleFactory();     // Catch: Throwable -> L8
        r14.getClass();     // Catch: Throwable -> L8
        r14.f9894c = new WeakReference(r5);     // Catch: Throwable -> L8
        initDevtoolEnv();     // Catch: Throwable -> L8
        if (initNativeLibraries(r10) == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        syncDevtoolComponentAttachSwitch();     // Catch: Throwable -> L8
        initTrace(this.mContext);     // Catch: Throwable -> L8
        postUpdateSettings();     // Catch: Throwable -> L8
        initNativeUIThread();     // Catch: Throwable -> L8
        initDisplayMetrics();     // Catch: Throwable -> L8
        initNativeGlobalPool();     // Catch: Throwable -> L8
        initImageExperimentSettings();     // Catch: Throwable -> L8
        initMemoryReportExperimentSettings();     // Catch: Throwable -> L8
        initEnableComponentStatisticReport();     // Catch: Throwable -> L8
        initEnableTransformForPositionCalculation();     // Catch: Throwable -> L8
        initEnableSvgAsync();     // Catch: Throwable -> L8
        initEnableGenericResourceFetcher();     // Catch: Throwable -> L8
        initEnableTextBoringLayout();     // Catch: Throwable -> L8
        initEnableRefreshRateOpt();     // Catch: Throwable -> L8
        initEnableCheckAccessFromNonUiThread();     // Catch: Throwable -> L8
        initEnableLazyInitA11y();     // Catch: Throwable -> L8
        initEnableTextLayoutCache();     // Catch: Throwable -> L8
        initEnableDataListFix();     // Catch: Throwable -> L8
        h r15 = this.mLibraryLoader;     // Catch: Throwable -> L8
        monitor-enter(ICURegister.class);     // Catch: Throwable -> L8
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L20:
        if (ICURegister.f10883a == true) goto L25;
        ILynxI18nService r16 = (ILynxI18nService) ko.r.g().e(ILynxI18nService.class);     // Catch: Throwable -> L27
        if (r16 == null) goto L25;
        ICURegister.f10883a = r16.loadLibrary(r15);     // Catch: Throwable -> L27
    L25:
        monitor-exit(ICURegister.class);     // Catch: Throwable -> L8
        ko.b r17 = (ko.b) ko.r.g().e(ko.b.class);     // Catch: Throwable -> L8
        if (r17 == null) goto L32;
        r17.onLynxEnvSetup();     // Catch: Throwable -> L8
    L33:
        ILynxImageService r18 = (ILynxImageService) ko.r.g().e(ILynxImageService.class);     // Catch: Throwable -> L8
        if ((r18 instanceof ILynxImageServiceExtension) == false) goto L36;
        ((ILynxImageServiceExtension) r18).onLynxEnvSetup();     // Catch: Throwable -> L8
    L37:
        initVsyncMonitor();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L36:
        LynxLog.b(3, TAG, "LynxEnv failed to get ILynxImageServiceExtension");     // Catch: Throwable -> L8
        goto L37
    L32:
        LynxLog.b(3, TAG, "LynxEnv failed to get LynxExtensionService");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void registerModule(String r5, Class<? extends LynxModule> r10, Object r11) {
        getModuleFactory().c(r10, r11, r5);
    }

    @CalledByNative
    public static String getStringFromExternalEnv(String r5) {
        ConcurrentHashMap<String, String> r10 = sExperimentSettingsMap;
        String r11 = r10.get(r5);
        if (r11 != null) goto L10;
        ILynxTrailService r12 = (ILynxTrailService) ko.r.g().e(ILynxTrailService.class);
        if (r12 == null) goto L7;
        r11 = r12.stringValueForTrailKey(r5);
    L7:
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        r10.put(r5, r11);
    L10:
        return r11;
    }

    public Set<String> getDevtoolEnv(String r5) {
        if (isNativeLibraryLoaded() == true) goto L7;
        return new HashSet();
    L7:
        if (isLynxDebugEnabled() == true) goto L10;
        LynxLog.b(4, TAG, "getDevtoolEnv must be called when isLynxDebugEnabled = true groupKey: " + r5);
        return new HashSet();
    L10:
        ILynxDevToolService r10 = mm.d.f20112a;
        if (r10 == null) goto L13;
        Set<String> r11 = r10.getDevtoolGroupEnv(r5);
    L14:
        if (r11 == null) goto L17;
        return r11;
    L17:
        return new HashSet();
    L13:
        LynxLog.b(4, "LynxDevToolUtils", "failed to get DevToolService");
        r11 = null;
        goto L14
    }

    public void setUpNativeMemoryTracer(Context r5) {
        LynxNativeMemoryTracer.c(r5);
    }

    public void setDevtoolEnv(String r5, Set<String> r10) {
        if (isNativeLibraryLoaded() == true) goto L5;
        return;
    L5:
        if (isLynxDebugEnabled() == false) goto L13;
        ILynxDevToolService r11 = mm.d.f20112a;
        if (r11 == null) goto L10;
        r11.setDevtoolGroupEnv(r5, r10);
        return;
    L10:
        LynxLog.b(4, "LynxDevToolUtils", "failed to get DevToolService");
        return;
    }
}
