package com.bytedance.crash.crash;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CrashManager {
    public static final String DIR_NAME = "crash";
    private static CrashManager sInstance;
    private final File crashDumpDir;
    private final CustomJavaHandler customJavaHandler;
    private final File mDirectory;
    private final JavaCrashHandler mJavaCrashHandler;
    private final NativeCrashHandler mNativeCrashHandler;

    CrashManager(@NonNull Context r10, @NonNull File r11) {
        File r12 = FileSystemUtils.createDirectory(r11, DIR_NAME);
        this.mDirectory = r12;
        FileSystemUtils.createDirectory(r11, "protector");
        File r13 = new File(r12, getProcessDirectoryName());
        this.crashDumpDir = r13;
        CrashDumper r14 = new CrashDumper(r13);
        this.customJavaHandler = new CustomJavaHandler(r11);
        this.mJavaCrashHandler = new JavaCrashHandler(r14);
        InitMonitor.step("JavaCrash_Init");
        this.mNativeCrashHandler = new NativeCrashHandler(r10, r14);
        InitMonitor.step("NativeCrash_Init");
    }

    static /* synthetic */ void access$000(CrashManager r10, CrashSummary r11, AppMonitor r12, File r13) {
        r10.updateOne(r11, r12, r13);
    }

    public static void dumperLateInit() {
        NativeBridge.dumperLateInit();
    }

    public static CustomJavaHandler getCustomJavaHandler() {
        CrashManager r10 = sInstance;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.customJavaHandler;
    }

    public static List<CrashSummary> getNativeCrashList(Context r10) {
        File[] r11 = new File(Global.getRootDirectory(r10), DIR_NAME).listFiles();
        if (r11 != null) goto L6;
        return null;
    L6:
        NativeBridge.loadLibrary();
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L13;
        CrashSummary r15 = CrashSummary.loadFromDirectory(r11[r14], true);
        if (r15 == null) goto L12;
        r12.add(r15);
    L12:
        r14 = r14 + 1;
        goto L7
    L13:
        return r12;
    }

    public static String getProcessDirectoryName() {
        return getProcessDirectoryName(Global.getAppStartTime(), Process.myPid());
    }

    public static String getProcessDirectoryName(long r10, int r11) {
        return r10 + "-" + r11;
    }

    @Nullable
    public static File getRootDirectory() {
        CrashManager r10 = sInstance;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mDirectory;
    }

    public static void handleNativeCrash(long r10, int r11) {
        Global.setHasCrashBefore(true);
        CrashManager r12 = sInstance;
        if (r12 == null) goto L6;
        r12.mNativeCrashHandler.nativeDumperFinished(r10, r11);
        return;
    }

    public static boolean isDirectoryExist(@NonNull File r10) {
        if (new File(r10, DIR_NAME).exists() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static void startDumperThread() {
        NativeBridge.startDumperThread();
    }

    public static synchronized void startMonitor(@NonNull Context r10, @NonNull File r11) {
        monitor-enter(CrashManager.class);
        NpthLog.i("CrashManager startMonitor");     // Catch: Throwable -> L9
        if (sInstance != null) goto L7;
        sInstance = new CrashManager(r10, r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(CrashManager.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void updateOne(CrashSummary r10, AppMonitor r11, File r12) {
        NpthLog.i("uploadAll create summary");
        JSONObject r13 = new JSONObject();
        CoredumpAdapter.upload(r11, r10, r12, r13);
        CrashType r14 = r10.mCrashType;
        if (r14 != CrashType.JAVA) goto L5;
    L6:
        JSONUtils.put(r13, Constants.FROM_CUSTOM, Boolean.FALSE);
    L7:
        r10.upload(r11, r13);
        return;
    L5:
        if (r14 != CrashType.LAUNCH) goto L7;
        goto L6
    }

    public static void upload(@NonNull AppMonitor r10, long r11) {
    L6:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_AppMonitor", e);
        return;
    L3:
        if (sInstance == null) goto L11;
        NpthLog.i("uploadAll");     // Catch: Exception -> L6
        sInstance.uploadAll(r10, r11);     // Catch: Exception -> L6
        return;
    }

    private void uploadAll(@NonNull final AppMonitor r10, long r11) {
        File[] r12 = this.mDirectory.listFiles();
        if (r12 == null) goto L8;
        NpthLog.i("uploadAll:crashDumpDir:" + this.crashDumpDir.getName());
        if (r11 <= 0) goto L7;
        uploadAll(r10, r12, r11);
        goto L8
    L7:
        uploadAll(r10, r12);
    L8:
        DefaultWorkThread.postDelayed(new AnonymousClass2(this, r10), r11);
    }

    private void uploadAll(@NonNull AppMonitor r10, File[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        File r14 = r11[r13];
        if (r14.getName().equals(this.crashDumpDir.getName()) == true) goto L11;
        NpthLog.i("uploadAll " + r14.getAbsolutePath());
        CrashSummary r15 = CrashSummary.loadFromDirectory(r14);
        if (r15 == null) goto L10;
        CrashAccessibilityMonitor.setCrashInfo(r15.mCrashType, r15.getProcessName(), r15.getPid(), r15.getCrashTime());
        NpthLog.i("uploadAll create summary");
        JSONObject r16 = new JSONObject();
        CoredumpAdapter.upload(r10, r15, r14, r16);
        r15.upload(r10, r16);
        goto L11
    L10:
        NpthLog.i("uploadAll delete dir" + r14.getAbsolutePath());
        FileSystemUtils.deleteAll(r14);
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r14.getAbsolutePath()));
    L11:
        r13 = r13 + 1;
        goto L3
    }

    private void uploadAll(@NonNull final AppMonitor r12, File[] r13, long r14) {
        final ArrayList r10 = new ArrayList();
        final ArrayList r11 = new ArrayList();
        int r15 = r13.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L16;
        File r17 = r13[r16];
        if (r17.getName().equals(this.crashDumpDir.getName()) == true) goto L14;
        NpthLog.i("uploadAll " + r17.getAbsolutePath());
        CrashSummary r18 = CrashSummary.loadFromDirectory(r17);
        if (r18 == null) goto L13;
        CrashAccessibilityMonitor.setCrashInfo(r18.mCrashType, r18.getProcessName(), r18.getPid(), r18.getCrashTime());
        if ((r18.getCrashTime() - r18.getStartTime()) <= RuntimeConfig.getLaunchCrashInterval()) goto L12;
        r10.add(r18);
        r11.add(r17);
        goto L14
    L12:
        updateOne(r18, r12, r17);
        goto L14
    L13:
        NpthLog.i("uploadAll delete dir" + r17.getAbsolutePath());
        FileSystemUtils.deleteAll(r17);
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r17.getAbsolutePath()));
    L14:
        r16 = r16 + 1;
        goto L3
    L16:
        if (r10.isEmpty() == true) goto L24;
        DefaultWorkThread.postDelayed(new AnonymousClass1(this, r10, r12, r11), r14);
        return;
    }
}
