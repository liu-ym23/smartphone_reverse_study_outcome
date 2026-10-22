package com.bytedance.crash.crash;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashManager {
    public static final String DIR_NAME = "crash";
    private static CrashManager sInstance;
    private final File crashDumpDir;
    private final CustomJavaHandler customJavaHandler;
    private final File mDirectory;
    private final JavaCrashHandler mJavaCrashHandler;
    private final NativeCrashHandler mNativeCrashHandler;

    CrashManager(Context r4, File r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        File r0 = FileSystemUtils.createDirectory(r5, DIR_NAME);
        this.mDirectory = r0;
        FileSystemUtils.createDirectory(r5, "protector");
        File r1 = new File(r0, getProcessDirectoryName());
        this.crashDumpDir = r1;
        CrashDumper r2 = new CrashDumper(r1);
        this.customJavaHandler = new CustomJavaHandler(r5);
        this.mJavaCrashHandler = new JavaCrashHandler(r2);
        InitMonitor.step("JavaCrash_Init");
        this.mNativeCrashHandler = new NativeCrashHandler(r6, r2);
        InitMonitor.step("NativeCrash_Init");
    }

    static /* synthetic */ void access$000(CrashManager r0, CrashSummary r1, AppMonitor r2, File r3) {
        r0.updateOne(r1, r2, r3);
    }

    public static void dumperLateInit() {
        NativeBridge.dumperLateInit();
    }

    public static CustomJavaHandler getCustomJavaHandler() {
        CrashManager r0 = sInstance;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.customJavaHandler;
    }

    public static List<CrashSummary> getNativeCrashList(Context r5) {
        File[] r6 = new File(Global.getRootDirectory((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin")), DIR_NAME).listFiles();
        if (r6 != null) goto L6;
        return null;
    L6:
        NativeBridge.loadLibrary();
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        CrashSummary r3 = CrashSummary.loadFromDirectory(r6[r2], true);
        if (r3 == null) goto L12;
        r0.add(r3);
    L12:
        r2 = r2 + 1;
        goto L7
    L13:
        return r0;
    }

    public static String getProcessDirectoryName() {
        return getProcessDirectoryName(Global.getAppStartTime(), Process.myPid());
    }

    public static String getProcessDirectoryName(long r1, int r3) {
        return r1 + "-" + r3;
    }

    public static File getRootDirectory() {
        CrashManager r0 = sInstance;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mDirectory;
    }

    public static void handleNativeCrash(long r1, int r3) {
        Global.setHasCrashBefore(true);
        CrashManager r0 = sInstance;
        if (r0 == null) goto L6;
        r0.mNativeCrashHandler.nativeDumperFinished(r1, r3);
        return;
    }

    public static boolean isDirectoryExist(File r2) {
        if (new File(r2, DIR_NAME).exists() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static void startDumperThread() {
        NativeBridge.startDumperThread();
    }

    public static synchronized void startMonitor(Context r3, File r4) {
        monitor-enter(CrashManager.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        NpthLog.i("CrashManager startMonitor");     // Catch: Throwable -> L9
        if (sInstance != null) goto L7;
        sInstance = new CrashManager(r5, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(CrashManager.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void updateOne(CrashSummary r2, AppMonitor r3, File r4) {
        NpthLog.i("uploadAll create summary");
        JSONObject r1 = new JSONObject();
        CoredumpAdapter.upload(r3, r2, r4, r1);
        if (r2.mCrashType != CrashType.JAVA) goto L5;
    L6:
        JSONUtils.put(r1, Constants.FROM_CUSTOM, false);
    L7:
        r2.upload(r3, r1);
        return;
    L5:
        if (r2.mCrashType != CrashType.LAUNCH) goto L7;
        goto L6
    }

    public static void upload(AppMonitor r1, long r2) {
    L6:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
        return;
    L3:
        if (sInstance == null) goto L11;
        NpthLog.i("uploadAll");     // Catch: Exception -> L6
        sInstance.uploadAll(r1, r2);     // Catch: Exception -> L6
        return;
    }

    private void uploadAll(final AppMonitor r4, long r5) {
        File[] r0 = this.mDirectory.listFiles();
        if (r0 == null) goto L8;
        NpthLog.i("uploadAll:crashDumpDir:" + this.crashDumpDir.getName());
        if (r5 <= 0) goto L7;
        uploadAll(r4, r0, r5);
        goto L8
    L7:
        uploadAll(r4, r0);
    L8:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this, r4), r5);
    }

    private void uploadAll(AppMonitor r10, File[] r11) {
        int r0 = r11.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        File r2 = r11[r1];
        if (r2.getName().equals(this.crashDumpDir.getName()) == true) goto L11;
        NpthLog.i("uploadAll " + r2.getAbsolutePath());
        CrashSummary r3 = CrashSummary.loadFromDirectory(r2);
        if (r3 == null) goto L10;
        CrashAccessibilityMonitor.setCrashInfo(r3.mCrashType, r3.getProcessName(), r3.getPid(), r3.getCrashTime());
        NpthLog.i("uploadAll create summary");
        JSONObject r4 = new JSONObject();
        CoredumpAdapter.upload(r10, r3, r2, r4);
        r3.upload(r10, r4);
        goto L11
    L10:
        NpthLog.i("uploadAll delete dir" + r2.getAbsolutePath());
        FileSystemUtils.deleteAll(r2);
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r2.getAbsolutePath()));
    L11:
        r1 = r1 + 1;
        goto L3
    }

    private void uploadAll(final AppMonitor r12, File[] r13, long r14) {
        final ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        int r2 = r13.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L16;
        File r4 = r13[r3];
        if (r4.getName().equals(this.crashDumpDir.getName()) == true) goto L14;
        NpthLog.i("uploadAll " + r4.getAbsolutePath());
        CrashSummary r5 = CrashSummary.loadFromDirectory(r4);
        if (r5 == null) goto L13;
        CrashAccessibilityMonitor.setCrashInfo(r5.mCrashType, r5.getProcessName(), r5.getPid(), r5.getCrashTime());
        if ((r5.getCrashTime() - r5.getStartTime()) <= RuntimeConfig.getLaunchCrashInterval()) goto L12;
        r0.add(r5);
        r1.add(r4);
        goto L14
    L12:
        updateOne(r5, r12, r4);
        goto L14
    L13:
        NpthLog.i("uploadAll delete dir" + r4.getAbsolutePath());
        FileSystemUtils.deleteAll(r4);
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r4.getAbsolutePath()));
    L14:
        r3 = r3 + 1;
        goto L3
    L16:
        if (r0.isEmpty() == true) goto L24;
        DefaultWorkThread.postDelayed(new AnonymousClass1(this, r0, r12, r1), r14);
        return;
    }
}
