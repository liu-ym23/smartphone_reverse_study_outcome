package com.bytedance.crash.jni;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.runtime.NpthHandlerThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.SoUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class NativeBridge {
    private static final double NATIVE_CHECK_FACT = 1.4d;
    private static final long NATIVE_CHECK_INTERVAL_MAX = 3600000;
    private static final int TIMEOUT = 1000;
    private static final String UNKNOWN = "unknown";
    private static volatile boolean isSoLoaded = false;
    private static long sNativeCheckInterval = 100;

    static {
    }

    public NativeBridge() {
    }

    public static String GetBuildID(String r1) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nGetBuildID(r1);
    }

    public static int PthreadKeyCount(String r1) {
        if (isSoLoaded() == true) goto L7;
        return 0;
    L7:
        return nNativePthreadKeyCount(r1);
    }

    static /* synthetic */ long access$000() {
        return sNativeCheckInterval;
    }

    static /* synthetic */ long access$002(long r0) {
        sNativeCheckInterval = r0;
        return r0;
    }

    static /* synthetic */ void access$100() {
        checkSigHandler();
    }

    public static void anrDumpNativeInfo(long r1) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpNativeInfo(r1);
        return;
    }

    public static void anrDumpNativeRelease(long r1) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpNativeRelease(r1);
        return;
    }

    public static void anrDumpTrace(String r1) {
        if (isSoLoaded() == false) goto L6;
        nAnrDumpTrace(r1);
        return;
    }

    public static long anrDumperNativeInit(String r2) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nAnrDumpNativeInit(r2);
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

    public static void coredumpNativeInit(String r1) {
        if (isSoLoaded() == false) goto L6;
        nCoredumpNativeInit(r1);
        return;
    }

    private static native void doRegister(String r0, String r1);

    private static native void doSetDropDataState(int r0);

    @Deprecated
    public static void doSignalRecover() {
        if (isSoLoaded() == false) goto L6;
        NpthHandlerThread.getDefaultHandler().postDelayed(new AnonymousClass1(), sNativeCheckInterval);
        return;
    }

    public static long dumpCrashNativeInfo(long r1) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nCrashDumpNativeInfo(r1);
    }

    public static int dumpHprof(String r1) {
        if (isSoLoaded() == true) goto L10;
        return -1;
    L10:
        return nativeDumpHprof(Build.VERSION.SDK_INT, r1);
    L8:
        return -2;
    }

    public static void dumpLogcat(String r2, int r3, boolean r4) {
        if (isSoLoaded() == false) goto L18;
        if (Build.VERSION.SDK_INT != 23) goto L11;
        String r0 = Build.MANUFACTURER;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (r0.toLowerCase(Locale.getDefault()).contains("oppo") == false) goto L11;
        return;
    L11:
        nDumpLogcat(r2, r3);
        if (r4 == false) goto L19;
        SystemClock.sleep(1000);
        return;
    L19:
        return;
    }

    public static void dumpMeminfo(String r1, boolean r2) {
        if (isSoLoaded() == false) goto L8;
        nDumpOsMemory(r1);
        if (r2 == false) goto L9;
        SystemClock.sleep(1000);
        return;
    L9:
        return;
    }

    public static void dumpTags(String r1) {
        if (isSoLoaded() == true) goto L8;
        return;
    L8:
        nativeDumpTags(r1);     // Catch: Throwable -> L7
        return;
    }

    public static void dumperLateInit() {
        if (isSoLoaded() == false) goto L6;
        nDumperLateInit();
        return;
    }

    public static int fLock(String r1) {
        if (isSoLoaded() == true) goto L5;
        return -1;
    L5:
        return nFlock(r1);
    }

    public static int getApexVersion() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetApexVersion();
    L11:
        return -1;
    }

    public static int getFdCount(String r1) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetFdCount(r1);
    }

    public static String getFdLeakReason(File r1) {
        if (isSoLoaded() == false) goto L5;
        String r2 = nGetFdLeakReason(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
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
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L10
        String[] r1 = nativeGetFdListForAPM();     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r0.addAll(Arrays.asList(r1));     // Catch: Throwable -> L10
    L7:
        return r0;
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

    public static String[] getOOMReason(String r1) {
        if (isSoLoaded() == true) goto L7;
        return null;
    L7:
        return nGetOOMReason(r1);
    }

    public static String getPthreadKeyLeakLibrary(File r1) {
        if (isSoLoaded() == false) goto L5;
        String r2 = nGetNativePthreadKeyLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String getStackTrace(boolean r2) {
        if (isSoLoaded() == true) goto L8;
        return null;
    L8:
        return nGetStackTrace(r2);
    L7:
        return null;
    }

    public static HashMap<String, String> getTags() {
        String[] r0 = nativeGetTags();
        HashMap<String, String> r1 = new HashMap();
        if (r0 != null) goto L15;
        return r1;
    L15:
        if (r0.length >= 1) goto L8;
        return r1;
    L8:
        int r2 = 0;
    L10:
        if (r2 >= r0.length) goto L13;
        r1.put(r0[r2], r0[r2 + 1]);     // Catch: Throwable -> L14
        r2 = r2 + 2;
    L13:
        return r1;
    }

    public static int getThreadCount(String r1) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetThreadCount(r1);
    }

    public static long getThreadCpuTimeMills(int r2) {
        if (isSoLoaded() == true) goto L5;
        return -1;
    L5:
        return nGetThreadCpuTimeMills(r2);
    }

    public static String getThreadLeakLibrary(File r1) {
        if (isSoLoaded() == false) goto L5;
        String r2 = nGetThreadLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String getThreadLeakName(File r1) {
        if (isSoLoaded() == false) goto L5;
        String r2 = nGetThreadLeakName(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static long getVmRss(String r2) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetVmRss(r2);
    }

    public static long getVmSize(String r1, boolean r2) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nGetVmSize(r1, r2 ? 1 : 0);
    }

    public static int getVmaCount(String r1) {
        if (isSoLoaded() == true) goto L7;
        return 0;
    L7:
        return nGetVmaCount(r1);
    }

    private static void handleCrashFromDumperThread(long r0, int r2) {
        CrashManager.handleNativeCrash(r0, r2);
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

    public static String loadNativeCrashAbortReason(String r1) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashAbortReason(r1);
    }

    public static String loadNativeCrashBacktrace(String r1) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashBacktrace(r1);
    }

    public static NativeCrashSummary loadNativeCrashSummary(String r1) {
        if (isSoLoaded() == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashSummary(r1);
    }

    private static native void nAnrDumpNativeInfo(long r0);

    private static native long nAnrDumpNativeInit(String r0);

    private static native void nAnrDumpNativeRelease(long r0);

    private static native void nAnrDumpTrace(String r0);

    private static native void nAnrEnterMonitorLooper();

    private static native void nAnrInitOnMainThread();

    public static native void nAnrNativeProfilerDump(long r0, String r2, long r3);

    public static native void nAnrNativeProfilerExit(long r0);

    public static native void nAnrNativeProfilerFormat(String r0, long[] r1);

    public static native int nAnrNativeProfilerJvmStart(long r0);

    public static native String nAnrNativeProfilerRunTest(String r0);

    public static native long nAnrNativeProfilerStart();

    public static native void nAnrNativeProfilerStop(long r0);

    private static native void nCheckSigHandler();

    private static native void nCoredumpNativeInit(String r0);

    private static native long nCrashDumpNativeInfo(long r0);

    private static native void nDumpLogcat(String r0, int r1);

    private static native void nDumpOsMemory(String r0);

    private static native void nDumperLateInit();

    private static native void nEnablePrioriryParams(boolean r0, boolean r1, int r2);

    private static native int nFlock(String r0);

    private static native int nGetApexVersion();

    private static native String nGetBuildID(String r0);

    private static native int nGetFdCount(String r0);

    private static native String nGetFdLeakReason(String r0);

    private static native int nGetFdLimit();

    private static native int nGetJvmMonitorState();

    private static native String nGetMallocType();

    private static native String nGetNativePthreadKeyLeakLibrary(String r0);

    private static native String[] nGetOOMReason(String r0);

    private static native String nGetStackTrace(boolean r0);

    private static native int nGetThreadCount(String r0);

    private static native long nGetThreadCpuTimeMills(int r0);

    private static native String nGetThreadLeakLibrary(String r0);

    private static native String nGetThreadLeakName(String r0);

    private static native long nGetVmRss(String r0);

    private static native long nGetVmSize(String r0, int r1);

    private static native int nGetVmaCount(String r0);

    private static native boolean nIncreaseFdLimit();

    private static native boolean nIs64BitRuntime();

    private static native String nLoadNativeCrashAbortReason(String r0);

    private static native String nLoadNativeCrashBacktrace(String r0);

    private static native NativeCrashSummary nLoadNativeCrashSummary(String r0);

    private static native int nNativePthreadKeyCount(String r0);

    private static native void nNotifyUploadDone();

    private static native void nParseSmaps(String r0);

    private static native void nPriorityMonitorInit(String r0);

    private static native void nRecoverSignalHandler();

    private static native void nResetNativeInfoLatches();

    private static native void nSet64Bit(boolean r0);

    private static native void nSetAlogFlushAddr(long r0);

    private static native void nSetAnrDumpAsync(boolean r0);

    private static native void nSetAnrResendSigquit(boolean r0);

    private static native void nSetAppVersion(String r0);

    private static native void nSetDumpTraceTryCatch(boolean r0);

    private static native boolean nSignalToProcess(int r0, int r1);

    private static native void nStartDumperThread();

    private static native int nStartNativeCrashMonitor(int r0, String r1, String r2, String r3, String r4, String r5, int r6, long r7, long r9, String r11);

    private static native void nStartProfilerJavaLockMonitor();

    private static native long nStringDumperCreate(String r0, int r1);

    private static native void nStringDumperDumpByteArray(long r0, byte[] r2, int r3);

    private static native void nStringDumperDumpCharArray(long r0, char[] r2, int r3);

    private static native void nStringDumperDumpString(long r0, String r2, int r3);

    private static native void nStringDumperFlushBuffer(long r0);

    private static native void nStringDumperRelease(long r0);

    private static native void nUnFlock(int r0);

    private static native int nativeDumpHprof(int r0, String r1);

    private static native void nativeDumpTags(String r0);

    private static native String[] nativeGetFdListForAPM();

    private static native String[] nativeGetTags();

    public static void notifyUploadDone() {
        if (isSoLoaded() == false) goto L6;
        nNotifyUploadDone();
        return;
    }

    public static void parseSmaps(String r1) {
        if (isSoLoaded() == false) goto L6;
        nParseSmaps(r1);
        return;
    }

    public static void priorityMonitorInit(String r1) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L9;
        nPriorityMonitorInit(r1);
        return;
    }

    public static void recoverSignalHandler() {
        if (isSoLoaded() == false) goto L6;
        nRecoverSignalHandler();
        return;
    }

    public static boolean register(String r1, String r2) {
        if (isSoLoaded() == true) goto L6;
        return false;
    L6:
        doRegister(r1, r2);
        return true;
    }

    public static boolean remove(String r2) {
        if (isSoLoaded() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        unRegister(r2);
        return true;
    }

    private static void reportAnrEventFromNative(int r0, int r1) {
        AnrManager.onSigquitDetected(r0, r1);
    }

    public static void resetNativeInfoLatches() {
        if (isSoLoaded() == false) goto L6;
        nResetNativeInfoLatches();
        return;
    }

    public static void set64Bit(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSet64Bit(r1);
    }

    public static void setAlogFlushFunction(long r1) {
        if (isSoLoaded() == false) goto L6;
        nSetAlogFlushAddr(r1);
        return;
    }

    public static void setAnrDumpAsync(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrDumpAsync(r1);
    }

    public static void setAnrResendSigquit(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrResendSigquit(r1);
    }

    public static void setAppVersion(String r1) {
        if (isSoLoaded() == false) goto L6;
        nSetAppVersion(r1);
        return;
    }

    public static void setDropDataState(int r1) {
        if (isSoLoaded() == true) goto L5;
        return;
    L5:
        doSetDropDataState(r1);
    }

    public static void setDumpTraceTryCatch(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetDumpTraceTryCatch(r1);
    }

    public static void setPriorityParams(boolean r1, boolean r2, int r3) {
        if (isSoLoaded() == false) goto L6;
        nEnablePrioriryParams(r1, r2, r3);
        return;
    }

    public static boolean signalToProcess(int r1, int r2) {
        if (isSoLoaded() == true) goto L5;
        return false;
    L5:
        return nSignalToProcess(r1, r2);
    }

    public static void startDumperThread() {
        if (isSoLoaded() == false) goto L6;
        nStartDumperThread();
        return;
    }

    public static void startNativeCrashMonitor(Context r13, File r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        if (isSoLoaded() == false) goto L8;
        String r3 = r14.getAbsolutePath();
        String r2 = r15.getApplicationInfo().nativeLibraryDir;
        File r16 = LogPathConfig.getCoreDumpPath();
        if (r16.exists() == true) goto L7;
        r16.mkdirs();
    L7:
        String r4 = new File(r16, CrashManager.getProcessDirectoryName()).getAbsolutePath();
        nStartNativeCrashMonitor(Build.VERSION.SDK_INT, r2, r3, r4, CrashAccessibilityMonitor.getExitDir(), Global.getRootDirectory(r15).getAbsolutePath(), 4020254, Global.getAppStartTime(), Global.getAppStartUpTime(), Global.getNativeAppVersion());
        return;
    L8:
        NpthMonitor.reportInnerException("npth so load fail", new Exception());
    }

    public static void startProfilerJavaLockMonitor() {
        if (isSoLoaded() == false) goto L6;
        nStartProfilerJavaLockMonitor();
        return;
    }

    public static long stringDumperCreate(String r1, int r2) {
        if (isSoLoaded() == true) goto L5;
        return 0;
    L5:
        return nStringDumperCreate(r1, r2);
    }

    public static void stringDumperDumpByteArray(long r1, byte[] r3, int r4) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpByteArray(r1, r3, r4);
        return;
    }

    public static void stringDumperDumpCharArray(long r1, char[] r3, int r4) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpCharArray(r1, r3, r4);
        return;
    }

    public static void stringDumperDumpString(long r1, String r3, int r4) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperDumpString(r1, r3, r4);
        return;
    }

    public static void stringDumperFlushBuffer(long r1) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperFlushBuffer(r1);
        return;
    }

    public static void stringDumperRelease(long r1) {
        if (isSoLoaded() == false) goto L6;
        nStringDumperRelease(r1);
        return;
    }

    public static void unFlock(int r1) {
        if (isSoLoaded() == false) goto L6;
        nUnFlock(r1);
        return;
    }

    private static native void unRegister(String r0);
}
