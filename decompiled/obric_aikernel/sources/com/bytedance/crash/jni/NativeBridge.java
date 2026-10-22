package com.bytedance.crash.jni;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.runtime.NpthHandlerThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.SoUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class NativeBridge {
    private static final double NATIVE_CHECK_FACT = 1.4d;
    private static final long NATIVE_CHECK_INTERVAL_MAX = 3600000;
    private static final int TIMEOUT = 1000;
    private static final String UNKNOWN = "unknown";

    @Keep
    private static volatile boolean isSoLoaded = false;
    private static long sNativeCheckInterval = 100;

    static {
    }

    public NativeBridge() {
    }

    @Nullable
    public static String GetBuildID(String r10) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nGetBuildID(r10);
    }

    public static int PthreadKeyCount(String r10) {
        if (isSoLoaded() == true) goto L7;
        return 0;
    L7:
        return nNativePthreadKeyCount(r10);
    }

    static /* synthetic */ long access$000() {
        return sNativeCheckInterval;
    }

    static /* synthetic */ long access$002(long r10) {
        sNativeCheckInterval = r10;
        return r10;
    }

    static /* synthetic */ void access$100() {
        checkSigHandler();
    }

    public static void anrDumpNativeInfo(long r10) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpNativeInfo(r10);
        return;
    }

    public static void anrDumpNativeRelease(long r10) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpNativeRelease(r10);
        return;
    }

    public static void anrDumpTrace(String r10) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpTrace(r10);
        return;
    }

    public static long anrDumperNativeInit(String r10) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nAnrDumpNativeInit(r10);
    }

    public static void anrEnterMonitorLooper() {
        if (isSoLoaded() == false) goto L6;
        nAnrEnterMonitorLooper();
        return;
    }

    public static void anrInitOnMainThread() {
        if (isSoLoaded() == false) goto L6;
        nAnrInitOnMainThread();
        return;
    }

    private static void checkSigHandler() {
        if (isSoLoaded() == false) goto L6;
        nCheckSigHandler();
        return;
    }

    public static void coredumpNativeInit(String r10) {
        if (isSoLoaded() == false) goto L6;
        nCoredumpNativeInit(r10);
        return;
    }

    @Keep
    private static native void doRegister(String r10, String r11);

    @Keep
    private static native void doSetDropDataState(int r10);

    @Deprecated
    public static void doSignalRecover() {
        if (isSoLoaded() == false) goto L6;
        NpthHandlerThread.getDefaultHandler().postDelayed(new AnonymousClass1(), sNativeCheckInterval);
        return;
    }

    public static long dumpCrashNativeInfo(long r10) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nCrashDumpNativeInfo(r10);
    }

    public static int dumpHprof(String r10) {
        if (isSoLoaded() == true) goto L10;
        return -1;
    L10:
        return nativeDumpHprof(Build.VERSION.SDK_INT, r10);
    L8:
        return -2;
    }

    public static void dumpLogcat(String r10, int r11, boolean r12) {
        if (isSoLoaded() == false) goto L18;
        if (Build.VERSION.SDK_INT != 23) goto L11;
        String r13 = Build.MANUFACTURER;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r13) == true) goto L11;
        if (r13.toLowerCase(Locale.getDefault()).contains("oppo") == false) goto L11;
        return;
    L11:
        nDumpLogcat(r10, r11);
        if (r12 == false) goto L19;
        SystemClock.sleep(1000);
        return;
    L19:
        return;
    }

    public static void dumpMeminfo(String r10, boolean r11) {
        if (isSoLoaded() == false) goto L8;
        nDumpOsMemory(r10);
        if (r11 == false) goto L9;
        SystemClock.sleep(1000);
        return;
    L9:
        return;
    }

    public static void dumpTags(String r10) {
        if (isSoLoaded() == true) goto L8;
        return;
    L8:
        nativeDumpTags(r10);     // Catch: Throwable -> L7
        return;
    }

    public static void dumperLateInit() {
        if (isSoLoaded() == false) goto L6;
        nDumperLateInit();
        return;
    }

    public static int fLock(String r10) {
        if (isSoLoaded() == true) goto L5;
        return -1;
    L5:
        return nFlock(r10);
    }

    public static int getApexVersion() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetApexVersion();
    L11:
        return -1;
    }

    public static int getFdCount(String r10) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetFdCount(r10);
    }

    public static String getFdLeakReason(File r10) {
        if (isSoLoaded() == false) goto L5;
        String r11 = nGetFdLeakReason(r10.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return "unknown";
    L10:
        return r11;
    L5:
        r11 = null;
        goto L7
    }

    public static int getFdLimit() {
        if (isSoLoaded() == false) goto L7;
        return nGetFdLimit();
    L7:
        if (Build.VERSION.SDK_INT <= 27) goto L9;
        return 32768;
    L9:
        return 1024;
    }

    @Deprecated
    public static List<String> getFdListForAPM() {
        if (isSoLoaded() == true) goto L11;
        return null;
    L11:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L10
        String[] r11 = nativeGetFdListForAPM();     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        r10.addAll(Arrays.asList(r11));     // Catch: Throwable -> L10
    L7:
        return r10;
    L13:
        return null;
    }

    public static int getJvmMonitorState() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetJvmMonitorState();
    L11:
        return -1;
    }

    public static String getMallocType() {
        if (isSoLoaded() == true) goto L9;
        return null;
    L9:
        return nGetMallocType();
    L11:
        return null;
    }

    public static String[] getOOMReason(String r10) {
        if (isSoLoaded() == true) goto L7;
        return null;
    L7:
        return nGetOOMReason(r10);
    }

    public static String getPthreadKeyLeakLibrary(File r10) {
        if (isSoLoaded() == false) goto L5;
        String r11 = nGetNativePthreadKeyLeakLibrary(r10.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return "unknown";
    L10:
        return r11;
    L5:
        r11 = null;
        goto L7
    }

    public static String getStackTrace(boolean r10) {
        if (isSoLoaded() == true) goto L8;
        return null;
    L8:
        return nGetStackTrace(r10);
    L7:
        return null;
    }

    public static HashMap<String, String> getTags() {
        String[] r10 = nativeGetTags();
        HashMap<String, String> r11 = new HashMap();
        if (r10 != null) goto L15;
        return r11;
    L15:
        if (r10.length >= 1) goto L8;
        return r11;
    L8:
        int r12 = 0;
    L10:
        if (r12 >= r10.length) goto L13;
        r11.put(r10[r12], r10[r12 + 1]);     // Catch: Throwable -> L14
        r12 = r12 + 2;
    L13:
        return r11;
    }

    public static int getThreadCount(String r10) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetThreadCount(r10);
    }

    public static long getThreadCpuTimeMills(int r10) {
        if (isSoLoaded() == true) goto L5;
        return -1;
    L5:
        return nGetThreadCpuTimeMills(r10);
    }

    public static String getThreadLeakLibrary(File r10) {
        if (isSoLoaded() == false) goto L5;
        String r11 = nGetThreadLeakLibrary(r10.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return "unknown";
    L10:
        return r11;
    L5:
        r11 = null;
        goto L7
    }

    public static String getThreadLeakName(File r10) {
        if (isSoLoaded() == false) goto L5;
        String r11 = nGetThreadLeakName(r10.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L10;
        return "unknown";
    L10:
        return r11;
    L5:
        r11 = null;
        goto L7
    }

    public static long getVmRss(String r10) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetVmRss(r10);
    }

    public static long getVmSize(String r10, boolean r11) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetVmSize(r10, r11 ? 1 : 0);
    }

    public static int getVmaCount(String r10) {
        if (isSoLoaded() == true) goto L7;
        return 0;
    L7:
        return nGetVmaCount(r10);
    }

    @Keep
    private static void handleCrashFromDumperThread(long r10, int r11) {
        CrashManager.handleNativeCrash(r10, r11);
    }

    public static boolean increaseFdLimit() {
        if (isSoLoaded() == true) goto L5;
        return false;
    L5:
        return nIncreaseFdLimit();
    }

    public static boolean is64BitRuntime() {
        if (isSoLoaded() == true) goto L5;
        return false;
    L5:
        return nIs64BitRuntime();
    }

    public static boolean isSoLoaded() {
        return isSoLoaded;
    }

    public static void loadLibrary() {
        SoUtils.loadLib("npth");
    }

    @Nullable
    public static String loadNativeCrashAbortReason(String r10) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashAbortReason(r10);
    }

    @Nullable
    public static String loadNativeCrashBacktrace(String r10) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashBacktrace(r10);
    }

    @Nullable
    public static NativeCrashSummary loadNativeCrashSummary(String r10) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashSummary(r10);
    }

    @Keep
    private static native void nAnrDumpNativeInfo(long r10);

    @Keep
    private static native long nAnrDumpNativeInit(String r10);

    @Keep
    private static native void nAnrDumpNativeRelease(long r10);

    @Keep
    private static native void nAnrDumpTrace(String r10);

    @Keep
    private static native void nAnrEnterMonitorLooper();

    @Keep
    private static native void nAnrInitOnMainThread();

    @Keep
    public static native void nAnrNativeProfilerDump(long r10, String r11, long r12);

    @Keep
    public static native void nAnrNativeProfilerExit(long r10);

    @Keep
    public static native void nAnrNativeProfilerFormat(String r10, long[] r11);

    @Keep
    public static native int nAnrNativeProfilerJvmStart(long r10);

    @Keep
    public static native String nAnrNativeProfilerRunTest(String r10);

    @Keep
    public static native long nAnrNativeProfilerStart();

    @Keep
    public static native void nAnrNativeProfilerStop(long r10);

    @Keep
    private static native void nCheckSigHandler();

    @Keep
    private static native void nCoredumpNativeInit(String r10);

    @Keep
    private static native long nCrashDumpNativeInfo(long r10);

    @Keep
    private static native void nDumpLogcat(String r10, int r11);

    @Keep
    private static native void nDumpOsMemory(String r10);

    @Keep
    private static native void nDumperLateInit();

    @Keep
    private static native void nEnablePrioriryParams(boolean r10, boolean r11, int r12);

    @Keep
    private static native int nFlock(String r10);

    @Keep
    private static native int nGetApexVersion();

    @Keep
    private static native String nGetBuildID(String r10);

    @Keep
    private static native int nGetFdCount(String r10);

    @Keep
    private static native String nGetFdLeakReason(String r10);

    @Keep
    private static native int nGetFdLimit();

    @Keep
    private static native int nGetJvmMonitorState();

    @Keep
    private static native String nGetMallocType();

    @Keep
    private static native String nGetNativePthreadKeyLeakLibrary(String r10);

    @Keep
    private static native String[] nGetOOMReason(String r10);

    @Keep
    private static native String nGetStackTrace(boolean r10);

    @Keep
    private static native int nGetThreadCount(String r10);

    @Keep
    private static native long nGetThreadCpuTimeMills(int r10);

    @Keep
    private static native String nGetThreadLeakLibrary(String r10);

    @Keep
    private static native String nGetThreadLeakName(String r10);

    @Keep
    private static native long nGetVmRss(String r10);

    @Keep
    private static native long nGetVmSize(String r10, int r11);

    @Keep
    private static native int nGetVmaCount(String r10);

    @Keep
    private static native boolean nIncreaseFdLimit();

    @Keep
    private static native boolean nIs64BitRuntime();

    @Keep
    private static native String nLoadNativeCrashAbortReason(String r10);

    @Keep
    private static native String nLoadNativeCrashBacktrace(String r10);

    @Keep
    private static native NativeCrashSummary nLoadNativeCrashSummary(String r10);

    @Keep
    private static native int nNativePthreadKeyCount(String r10);

    @Keep
    private static native void nNotifyUploadDone();

    @Keep
    private static native void nParseSmaps(String r10);

    @Keep
    private static native void nPriorityMonitorInit(String r10);

    @Keep
    private static native void nRecoverSignalHandler();

    @Keep
    private static native void nResetNativeInfoLatches();

    @Keep
    private static native void nSet64Bit(boolean r10);

    @Keep
    private static native void nSetAlogFlushAddr(long r10);

    @Keep
    private static native void nSetAnrDumpAsync(boolean r10);

    @Keep
    private static native void nSetAnrResendSigquit(boolean r10);

    @Keep
    private static native void nSetAppVersion(String r10);

    @Keep
    private static native void nSetDumpTraceTryCatch(boolean r10);

    @Keep
    private static native boolean nSignalToProcess(int r10, int r11);

    @Keep
    private static native void nStartDumperThread();

    @Keep
    private static native int nStartNativeCrashMonitor(int r10, String r11, String r12, String r13, String r14, String r15, int r16, long r17, long r18, String r19);

    @Keep
    private static native void nStartProfilerJavaLockMonitor();

    @Keep
    private static native long nStringDumperCreate(String r10, int r11);

    @Keep
    private static native void nStringDumperDumpByteArray(long r10, byte[] r11, int r12);

    @Keep
    private static native void nStringDumperDumpCharArray(long r10, char[] r11, int r12);

    @Keep
    private static native void nStringDumperDumpString(long r10, String r11, int r12);

    @Keep
    private static native void nStringDumperFlushBuffer(long r10);

    @Keep
    private static native void nStringDumperRelease(long r10);

    @Keep
    private static native void nUnFlock(int r10);

    @Keep
    private static native int nativeDumpHprof(int r10, String r11);

    @Keep
    private static native void nativeDumpTags(String r10);

    @Keep
    private static native String[] nativeGetFdListForAPM();

    @Keep
    private static native String[] nativeGetTags();

    public static void notifyUploadDone() {
        if (isSoLoaded() == false) goto L6;
        nNotifyUploadDone();
        return;
    }

    public static void parseSmaps(String r10) {
        if (isSoLoaded() == false) goto L6;
        nParseSmaps(r10);
        return;
    }

    public static void priorityMonitorInit(String r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        if (r10.length() <= 0) goto L9;
        nPriorityMonitorInit(r10);
        return;
    }

    public static void recoverSignalHandler() {
        if (isSoLoaded() == false) goto L6;
        nRecoverSignalHandler();
        return;
    }

    public static boolean register(String r10, String r11) {
        if (isSoLoaded() == true) goto L6;
        return false;
    L6:
        doRegister(r10, r11);
        return true;
    }

    public static boolean remove(String r10) {
        if (isSoLoaded() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        unRegister(r10);
        return true;
    }

    @Keep
    private static void reportAnrEventFromNative(int r10, int r11) {
        AnrManager.onSigquitDetected(r10, r11);
    }

    public static void resetNativeInfoLatches() {
        if (isSoLoaded() == false) goto L6;
        nResetNativeInfoLatches();
        return;
    }

    public static void set64Bit(boolean r10) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSet64Bit(r10);
    }

    public static void setAlogFlushFunction(long r10) {
        if (isSoLoaded() == false) goto L6;
        nSetAlogFlushAddr(r10);
        return;
    }

    public static void setAnrDumpAsync(boolean r10) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrDumpAsync(r10);
    }

    public static void setAnrResendSigquit(boolean r10) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrResendSigquit(r10);
    }

    public static void setAppVersion(@NonNull String r10) {
        if (isSoLoaded() == false) goto L6;
        nSetAppVersion(r10);
        return;
    }

    public static void setDropDataState(int r10) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        doSetDropDataState(r10);
    }

    public static void setDumpTraceTryCatch(boolean r10) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetDumpTraceTryCatch(r10);
    }

    public static void setPriorityParams(boolean r10, boolean r11, int r12) {
        if (isSoLoaded() == false) goto L6;
        nEnablePrioriryParams(r10, r11, r12);
        return;
    }

    public static boolean signalToProcess(int r10, int r11) {
        if (isSoLoaded() == true) goto L5;
        return false;
    L5:
        return nSignalToProcess(r10, r11);
    }

    public static void startDumperThread() {
        if (isSoLoaded() == false) goto L6;
        nStartDumperThread();
        return;
    }

    public static void startNativeCrashMonitor(@NonNull Context r13, @NonNull File r14) {
        if (isSoLoaded() == false) goto L8;
        String r10 = r14.getAbsolutePath();
        String r11 = r13.getApplicationInfo().nativeLibraryDir;
        File r15 = LogPathConfig.getCoreDumpPath();
        if (r15.exists() == true) goto L7;
        r15.mkdirs();
    L7:
        String r12 = new File(r15, CrashManager.getProcessDirectoryName()).getAbsolutePath();
        nStartNativeCrashMonitor(Build.VERSION.SDK_INT, r11, r10, r12, CrashAccessibilityMonitor.getExitDir(), Global.getRootDirectory(r13).getAbsolutePath(), 4020254, Global.getAppStartTime(), Global.getAppStartUpTime(), Global.getNativeAppVersion());
        return;
    L8:
        NpthMonitor.reportInnerException("npth so load fail", new Exception());
    }

    public static void startProfilerJavaLockMonitor() {
        if (isSoLoaded() == false) goto L6;
        nStartProfilerJavaLockMonitor();
        return;
    }

    public static long stringDumperCreate(String r10, int r11) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nStringDumperCreate(r10, r11);
    }

    public static void stringDumperDumpByteArray(long r10, byte[] r11, int r12) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpByteArray(r10, r11, r12);
        return;
    }

    public static void stringDumperDumpCharArray(long r10, char[] r11, int r12) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpCharArray(r10, r11, r12);
        return;
    }

    public static void stringDumperDumpString(long r10, String r11, int r12) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpString(r10, r11, r12);
        return;
    }

    public static void stringDumperFlushBuffer(long r10) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperFlushBuffer(r10);
        return;
    }

    public static void stringDumperRelease(long r10) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperRelease(r10);
        return;
    }

    public static void unFlock(int r10) {
        if (isSoLoaded() == false) goto L6;
        nUnFlock(r10);
        return;
    }

    @Keep
    private static native void unRegister(String r10);
}
