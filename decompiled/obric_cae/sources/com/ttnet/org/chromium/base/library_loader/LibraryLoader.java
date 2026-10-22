package com.ttnet.org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.system.Os;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.base.BuildConfig;
import com.ttnet.org.chromium.base.BuildInfo;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.FileUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StreamUtil;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.metrics.CachedMetrics;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import o5.q;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String LIBRARY_DIR = "native_libraries";
    public static final boolean PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION = false;
    private static final String REACHED_CODE_PROFILER_ENABLED_KEY = "reached_code_profiler_enabled";
    private static final String TAG = "LibraryLoader";
    private static LibraryLoader sInstance;
    private static final CachedMetrics.EnumeratedHistogramSample sRelinkerCountHistogram = null;
    private boolean mCommandLineSwitched;
    private volatile boolean mInitialized;
    private boolean mIsUsingBrowserSharedRelros;
    private long mLibraryLoadTimeMs;
    private NativeLibraryPreloader mLibraryPreloader;
    private boolean mLibraryPreloaderCalled;
    private int mLibraryPreloaderStatus;
    private int mLibraryProcessType;
    private boolean mLibraryWasLoadedFromApk;
    private boolean mLoadAtFixedAddressFailed;
    private boolean mLoaded;
    private boolean mLoadedByZygote;
    private final Object mLock;

    private static /* synthetic */ void $closeResource(Throwable r8, AutoCloseable r10) {
        if (r8 != null) goto L9;
        r10.close();
        return;
    L9:
        r10.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.addSuppressed(th);
    }

    static {
        PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION = false;
        sRelinkerCountHistogram = new CachedMetrics.EnumeratedHistogramSample("ChromiumAndroidLinker.RelinkerFallbackCount", 2);
        sInstance = new LibraryLoader();
    }

    private LibraryLoader() {
        this.mLock = new Object();
        this.mLibraryPreloaderStatus = -1;
    }

    public static /* synthetic */ void a() {
        lambda$initializeAlreadyLocked$0();
    }

    private void ensureCommandLineSwitchedAlreadyLocked() {
        if (this.mCommandLineSwitched == false) goto L5;
        return;
    L5:
        CommandLine.enableNativeProxy();
        this.mCommandLineSwitched = true;
    }

    @SuppressLint({"SetWorldReadable"})
    private static String extractFileIfStale(ApplicationInfo r8, String r10, File r11) {
        String r12 = r8.sourceDir;
        File r13 = new File(r11, new File(r10).getName() + BuildInfo.getInstance().extractedFileSuffix);
        if (r13.exists() == true) goto L24;
        ZipFile r14 = null;
        ZipFile r15 = new ZipFile(r12);     // Catch: Throwable -> L16 IOException -> L18
        ZipEntry r16 = r15.getEntry(r10);     // Catch: Throwable -> L12 IOException -> L14
        if (r16 == null) goto L11;
        FileUtils.copyStreamToFile(r15.getInputStream(r16), r13);     // Catch: Throwable -> L12 IOException -> L14
        r13.setReadable(true, false);     // Catch: Throwable -> L12 IOException -> L14
        r13.setExecutable(true, false);     // Catch: Throwable -> L12 IOException -> L14
        StreamUtil.closeQuietly(r15);
        goto L24
    L11:
        throw new RuntimeException("Cannot find ZipEntry" + r10);     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = e;
    L20:
        throw new RuntimeException(e);     // Catch: Throwable -> L16
    L12:
        th = th;
        r14 = r15;
    L21:
        StreamUtil.closeQuietly(r14);
        throw th;
    L16:
        th = th;
    L18:
        e = e;
    L24:
        return r13.getAbsolutePath();
    }

    public static String getExtractedLibraryPath(ApplicationInfo r8, String r10) {
        Log.w(TAG, "Failed to load libName %s, attempting fallback extraction then trying again", new Object[]{r10});
        return extractFileIfStale(r8, makeLibraryPathInZipFile(r10, false, false), makeLibraryDirAndSetPermission());
    }

    public static LibraryLoader getInstance() {
        return sInstance;
    }

    private static File getLibraryDir() {
        Context r8 = ContextUtils.getApplicationContext();
        Object r10 = androidx.core.content.a.f1674a;
        return new File(androidx.core.content.a.b.a(r8), LIBRARY_DIR);
    }

    public static void incrementRelinkerCountHitHistogram() {
        sRelinkerCountHistogram.record(1);
    }

    public static void incrementRelinkerCountNotHitHistogram() {
        sRelinkerCountHistogram.record(0);
    }

    private void initializeAlreadyLocked(int r8) {
        int r10 = 2;
        if (this.mInitialized == true) goto L5;
        this.mLibraryProcessType = r8;
        if (r8 == 1) goto L12;
    L14:
        ensureCommandLineSwitchedAlreadyLocked();
        if (nativeLibraryLoaded(this.mLibraryProcessType) == false) goto L27;
        Log.i(TAG, String.format("Expected native library version number \"%s\", actual native library version number \"%s\"", new Object[]{NativeLibraries.sVersionNumber, nativeGetVersionNumber()}), new Object[0]);
        if (NativeLibraries.sVersionNumber.equals(nativeGetVersionNumber()) == false) goto L26;
        TraceEvent.registerNativeEnabledObserver();
        if (r8 == 1) goto L21;
    L23:
        this.mInitialized = true;
        return;
    L21:
        if (PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION == false) goto L23;
        new Thread(new q(r10)).start();
        goto L23
    L26:
        throw new ProcessInitException(3);
    L27:
        Log.e(TAG, "error calling nativeLibraryLoaded", new Object[0]);
        throw new ProcessInitException(1);
    L12:
        if (isReachedCodeProfilerEnabled() == false) goto L14;
        CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_REACHED_CODE_PROFILER);
        goto L14
    L5:
        if (this.mLibraryProcessType != r8) goto L8;
        return;
    L8:
        throw new ProcessInitException(2);
    }

    private static boolean isInZipFile() {
        return NativeLibraries.sUseLibraryInZipFile;
    }

    private static boolean isReachedCodeProfilerEnabled() {
        StrictModeContext r8 = StrictModeContext.allowDiskReads();
        boolean r10 = ContextUtils.getAppSharedPreferences().getBoolean(REACHED_CODE_PROFILER_ENABLED_KEY, false);     // Catch: Throwable -> L7
        if (r8 == null) goto L6;
        $closeResource(null, r8);
    L6:
        return r10;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r8 == null) goto L12;
        $closeResource(th, r8);
    L12:
        throw th;
    }

    private static /* synthetic */ void lambda$initializeAlreadyLocked$0() {
        String r8 = BuildInfo.getInstance().extractedFileSuffix;
        File[] r10 = getLibraryDir().listFiles();
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L14;
        File r13 = r10[r12];
        if (r13.getName().contains(r8) == true) goto L13;
        String r14 = r13.getName();
        if (r13.delete() == true) goto L12;
        Log.w(TAG, "Unable to remove %s", new Object[]{r14});
        goto L13
    L12:
        Log.i(TAG, "Removed obsolete file %s", new Object[]{r14});
    L13:
        r12 = r12 + 1;
        goto L6
    }

    @SuppressLint({"DefaultLocale", "UnsafeDynamicallyLoadedCode"})
    private void loadAlreadyLocked(ApplicationInfo r17, boolean r18) {
        TraceEvent r8 = TraceEvent.scoped("LibraryLoader.loadAlreadyLocked");     // Catch: UnsatisfiedLinkError -> L59
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        if (r8 == null) goto L80;
        $closeResource(th, r8);     // Catch: UnsatisfiedLinkError -> L59
        throw th;     // Catch: UnsatisfiedLinkError -> L59
    L80:
        throw th;     // Catch: UnsatisfiedLinkError -> L59
    L5:
        if (this.mLoaded == true) goto L47;
        long r10 = SystemClock.uptimeMillis();     // Catch: Throwable -> L51
        if (useCrazyLinker() == false) goto L35;
        if (r18 == true) goto L35;
        Linker r12 = Linker.getInstance();     // Catch: Throwable -> L51
        if (isInZipFile() == false) goto L13;
        String r13 = r17.sourceDir;     // Catch: Throwable -> L51
    L14:
        r12.prepareLibraryLoad(r13);     // Catch: Throwable -> L51
        String[] r14 = NativeLibraries.LIBRARIES;     // Catch: Throwable -> L51
        int r15 = r14.length;     // Catch: Throwable -> L51
        int r11 = 0;
    L15:
        if (r11 >= r15) goto L34;
        String r16 = r14[r11];     // Catch: Throwable -> L51
        if (r12.isChromiumLinkerLibrary(r16) == false) goto L19;
        r14 = r14;
    L31:
        r11 = r11 + 1;     // Catch: Throwable -> L51
        r14 = r14;
        goto L15
    L19:
        String r19 = System.mapLibraryName(r16);     // Catch: Throwable -> L51
        if (r13 == null) goto L22;
        Log.i(TAG, " Loading " + r16 + " from within " + r13, new Object[0]);     // Catch: Throwable -> L51
    L67:
        loadLibraryWithCustomLinkerAlreadyLocked(r12, r13, r19);     // Catch: UnsatisfiedLinkError -> L25 Throwable -> L51
        incrementRelinkerCountNotHitHistogram();     // Catch: UnsatisfiedLinkError -> L25 Throwable -> L51
    L25:
        e = move-exception;
        if (isInZipFile() == true) goto L32;
        if (PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION == false) goto L32;
        loadLibraryWithCustomLinkerAlreadyLocked(r12, null, getExtractedLibraryPath(r17, r16));     // Catch: Throwable -> L51
        incrementRelinkerCountHitHistogram();     // Catch: Throwable -> L51
    L32:
        Log.e(TAG, "Unable to load library: " + r16, new Object[0]);     // Catch: Throwable -> L51
        throw e;     // Catch: Throwable -> L51
    L22:
        Log.i(TAG, "Loading " + r16, new Object[0]);     // Catch: Throwable -> L51
        goto L67
    L34:
        r12.finishLibraryLoad();     // Catch: Throwable -> L51
    L46:
        long r20 = SystemClock.uptimeMillis();     // Catch: Throwable -> L51
        long r21 = r20 - r10;     // Catch: Throwable -> L51
        this.mLibraryLoadTimeMs = r21;     // Catch: Throwable -> L51
        Log.i(TAG, String.format("Time to load native libraries: %d ms (timestamps %d-%d)", new Object[]{Long.valueOf(r21), Long.valueOf(r10 % 10000), Long.valueOf(r20 % 10000)}), new Object[0]);     // Catch: Throwable -> L51
        this.mLoaded = true;     // Catch: Throwable -> L51
        goto L47
    L13:
        r13 = null;
    L35:
        setEnvForNative();     // Catch: Throwable -> L51
        preloadAlreadyLocked(r17);     // Catch: Throwable -> L51
        String[] r22 = NativeLibraries.LIBRARIES;     // Catch: Throwable -> L51
        int r23 = r22.length;     // Catch: Throwable -> L51
        int r24 = 0;
    L36:
        if (r24 >= r23) goto L46;
        String r25 = r22[r24];     // Catch: Throwable -> L51
        if (isInZipFile() == true) goto L41;
        System.loadLibrary(r25);     // Catch: UnsatisfiedLinkError -> L43 Throwable -> L51
    L42:
        r24 = r24 + 1;
        goto L36
    L41:
        boolean r110 = ApiHelperForM.isProcess64Bit();     // Catch: UnsatisfiedLinkError -> L43 Throwable -> L51
        String r111 = r17.sourceDir + "!/" + makeLibraryPathInZipFile(r25, true, r110);     // Catch: UnsatisfiedLinkError -> L43 Throwable -> L51
        Log.i(TAG, "libraryName: " + r111, new Object[0]);     // Catch: UnsatisfiedLinkError -> L43 Throwable -> L51
        System.load(r111);     // Catch: UnsatisfiedLinkError -> L43 Throwable -> L51
        goto L42
    L43:
        e = move-exception;
        Log.e(TAG, "Unable to load library: " + r25, new Object[0]);     // Catch: Throwable -> L51
        throw e;     // Catch: Throwable -> L51
    L47:
        if (r8 != null) goto L49;
        return;
    L49:
        $closeResource(null, r8);     // Catch: UnsatisfiedLinkError -> L59
        return;
    L59:
        e = move-exception;
        throw new ProcessInitException(2, e);
    }

    private void loadLibraryWithCustomLinkerAlreadyLocked(Linker r8, String r10, String r11) {
        if (r8.isUsingBrowserSharedRelros() == false) goto L8;
        this.mIsUsingBrowserSharedRelros = true;
        r8.loadLibrary(r11);     // Catch: UnsatisfiedLinkError -> L7
    L9:
        if (r10 == null) goto L14;
        this.mLibraryWasLoadedFromApk = true;
        return;
    L14:
        return;
    L7:
        Log.w(TAG, "Failed to load native library with shared RELRO, retrying without", new Object[0]);
        this.mLoadAtFixedAddressFailed = true;
        r8.loadLibraryNoFixedAddress(r11);
        goto L9
    L8:
        r8.loadLibrary(r11);
        goto L9
    }

    private static File makeLibraryDirAndSetPermission() {
        if (ContextUtils.isIsolatedProcess() == true) goto L6;
        Context r8 = ContextUtils.getApplicationContext();
        Object r10 = androidx.core.content.a.f1674a;
        File r11 = androidx.core.content.a.b.a(r8);
        File r12 = new File(r11, LIBRARY_DIR);
        r11.mkdir();
        r11.setExecutable(true, false);
        r12.mkdir();
        r12.setExecutable(true, false);
    L6:
        return getLibraryDir();
    }

    public static String makeLibraryPathInZipFile(String r8, boolean r10, boolean r11) {
        int r12 = NativeLibraries.sCpuFamily;
        if (r12 != 1) goto L5;
        if (r11 == false) goto L18;
        String r13 = "arm64-v8a";
    L19:
        if (r10 == false) goto L21;
        String r14 = "crazy.";
    L23:
        return String.format("lib/%s/%s%s", new Object[]{r13, r14, System.mapLibraryName(r8)});
    L21:
        r14 = "";
        goto L23
    L18:
        r13 = "armeabi-v7a";
        goto L19
    L5:
        if (r12 != 2) goto L7;
        if (r11 == false) goto L15;
        r13 = "mips64";
        goto L19
    L15:
        r13 = "mips";
        goto L19
    L7:
        if (r12 != 3) goto L12;
        if (r11 == false) goto L10;
        r13 = "x86_64";
        goto L19
    L10:
        r13 = "x86";
        goto L19
    L12:
        throw new RuntimeException("Unknown CPU ABI for native libraries");
    }

    private native String nativeGetVersionNumber();

    private native boolean nativeLibraryLoaded(int r8);

    private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(long r8);

    private native void nativeRecordLibraryPreloaderBrowserHistogram(int r8);

    private native void nativeRegisterChromiumAndroidLinkerRendererHistogram(long r8);

    private native void nativeRegisterLibraryPreloaderRendererHistogram(int r8);

    private void preloadAlreadyLocked(ApplicationInfo r8) {
        TraceEvent r10 = TraceEvent.scoped("LibraryLoader.preloadAlreadyLocked");
        NativeLibraryPreloader r11 = this.mLibraryPreloader;     // Catch: Throwable -> L11
        if (r11 != null) goto L6;
    L8:
        if (r10 == null) goto L21;
        $closeResource(null, r10);
        return;
    L21:
        return;
    L6:
        if (this.mLibraryPreloaderCalled == true) goto L8;
        this.mLibraryPreloaderStatus = r11.loadLibrary(r8);     // Catch: Throwable -> L11
        this.mLibraryPreloaderCalled = true;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r10 == null) goto L16;
        $closeResource(th, r10);
    L16:
        throw th;
    }

    private void recordBrowserProcessHistogramAlreadyLocked() {
        if (useCrazyLinker() == false) goto L6;
        nativeRecordChromiumAndroidLinkerBrowserHistogram(this.mLibraryLoadTimeMs);
    L6:
        if (this.mLibraryPreloader == null) goto L9;
        nativeRecordLibraryPreloaderBrowserHistogram(this.mLibraryPreloaderStatus);
        return;
    }

    public static void setEnvForNative() {
        if (BuildConfig.IS_UBSAN == false) goto L11;
        Os.setenv("UBSAN_OPTIONS", "print_stacktrace=1 stack_trace_format='#%n pc %o %m' handle_segv=0 handle_sigbus=0 handle_sigfpe=0", true);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.w(TAG, "failed to set UBSAN_OPTIONS", new Object[]{e});
        return;
    }

    @VisibleForTesting
    public static void setLibraryLoaderForTesting(LibraryLoader r8) {
        sInstance = r8;
    }

    public static void setReachedCodeProfilerEnabledOnNextRuns(boolean r8) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(REACHED_CODE_PROFILER_ENABLED_KEY, r8).apply();
    }

    public static boolean useCrazyLinker() {
        return NativeLibraries.sUseLinker;
    }

    public void ensureInitialized(int r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mInitialized == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        loadAlreadyLocked(ContextUtils.getApplicationContext().getApplicationInfo(), false);     // Catch: Throwable -> L11
        initializeAlreadyLocked(r8);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    public void initialize(int r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        initializeAlreadyLocked(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public boolean isLoadedByZygote() {
        return this.mLoadedByZygote;
    }

    public void loadNow() {
        loadNowOverrideApplicationContext(ContextUtils.getApplicationContext());
    }

    public void loadNowInZygote(ApplicationInfo r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        loadAlreadyLocked(r8, true);     // Catch: Throwable -> L10
        this.mLoadedByZygote = true;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void loadNowOverrideApplicationContext(Context r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoaded == true) goto L7;
    L11:
        loadAlreadyLocked(r8.getApplicationInfo(), false);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (r8 == ContextUtils.getApplicationContext()) goto L11;
        throw new IllegalStateException("Attempt to load again from alternate context.");     // Catch: Throwable -> L14
    }

    public void onNativeInitializationComplete() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        recordBrowserProcessHistogramAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void preloadNow() {
        preloadNowOverrideApplicationContext(ContextUtils.getApplicationContext());
    }

    public void preloadNowOverrideApplicationContext(Context r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (useCrazyLinker() == true) goto L7;
        preloadAlreadyLocked(r8.getApplicationInfo());     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public void registerRendererProcessHistogram() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (useCrazyLinker() == false) goto L8;
        nativeRegisterChromiumAndroidLinkerRendererHistogram(this.mLibraryLoadTimeMs);     // Catch: Throwable -> L12
    L8:
        if (this.mLibraryPreloader == null) goto L10;
        nativeRegisterLibraryPreloaderRendererHistogram(this.mLibraryPreloaderStatus);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L12
    }

    public void setNativeLibraryPreloader(NativeLibraryPreloader r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mLibraryPreloader = r8;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void switchCommandLineForWebView() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureCommandLineSwitchedAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
