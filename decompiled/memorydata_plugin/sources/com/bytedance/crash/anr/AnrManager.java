package com.bytedance.crash.anr;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IAnrUploadCallback;
import com.bytedance.crash.IFileContentGetter;
import com.bytedance.crash.IPreANRCallback;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnrManager {
    public static final long ANR_MIN_INTERVAL = 120000;
    public static final String ANR_ROOT_DIR = "anr";
    public static final String CLOSE_ANR_INFO = "close anr_info report";
    private static final long MIN_SIGNAL_INTERVAL = 5000;
    public static final String SILENT_ANR_NO_ANR_INFO = "silent anr no anr info";
    private static volatile boolean enableUploadBackgroundANR = true;
    private static boolean isDumpData = true;
    private static long lastAnrTime;
    private static AnrManager sInstance;
    private static boolean sIsDropData;
    private long lastSignalTime;
    private final AnrInfoMonitor mAnrInfoMonitor;
    private final AnrProfiler mAnrProfiler;
    final File mAnrRootDirectory;
    private final AnrSignalMonitor mAnrSignalMonitor;
    private boolean mIsRunning;
    private AnrHandler mPendingHandler;

    static {
    }

    private AnrManager(Context r3, File r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mIsRunning = false;
        this.lastSignalTime = 0;
        this.mAnrSignalMonitor = new AnrSignalMonitor();
        File r6 = FileSystemUtils.createDirectory(r4, ANR_ROOT_DIR);
        this.mAnrRootDirectory = r6;
        this.mAnrInfoMonitor = new AnrInfoMonitor(r5, r6);
        this.mAnrProfiler = new AnrProfiler();
    }

    /* synthetic */ AnrManager(Context r2, File r3, AnonymousClass1 r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ AnrManager access$000() {
        return sInstance;
    }

    static /* synthetic */ AnrManager access$002(AnrManager r0) {
        sInstance = r0;
        return r0;
    }

    static /* synthetic */ void access$200(AnrManager r0) {
        r0.start();
    }

    static /* synthetic */ AnrInfoMonitor access$300(AnrManager r0) {
        return r0.mAnrInfoMonitor;
    }

    static /* synthetic */ void access$400(AnrManager r0, AnrSummary r1, AppMonitor r2) {
        r0.uploadOne(r1, r2);
    }

    public static void dumpProfilerWithNativeInfo(File r1, long r2) {
        if (isRunning() == false) goto L8;
        AnrProfiler r0 = sInstance.mAnrProfiler;
        if (r0 == null) goto L9;
        r0.dumpWithNativeInfo(r1, r2);
        return;
    L9:
        return;
    }

    private File[] getCrashDirectories(File r2) {
        return r2.listFiles(new AnonymousClass2(this));
    }

    private synchronized AnrHandler getPendingHandler(long r3, boolean r5) {
        monitor-enter(this);
        AnrHandler r0 = this.mPendingHandler;     // Catch: Throwable -> L14
        if (r0 != null) goto L7;
        this.mPendingHandler = AnrHandler.get(this.mAnrInfoMonitor, this.mAnrRootDirectory, r3, r5);     // Catch: Throwable -> L14
    L11:
        AnrHandler r4 = this.mPendingHandler;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L7:
        if (r0.isDiscarded(r5) == false) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private File[] getProcessDirectories() {
        return this.mAnrRootDirectory.listFiles(new AnonymousClass1(this));
    }

    public static File getRootDirectory() {
        AnrManager r0 = sInstance;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mAnrRootDirectory;
    }

    public static void handlePreANRs() {
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        Iterator<IPreANRCallback> r1 = r0.getUserDataCenter().getPreANRCallback().iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L21;
        ((IPreANRCallback) ZeusTransformUtils.preCheckCast(r1.next(), IPreANRCallback.class, "com.obric.memorydata.plugin")).onSignal();     // Catch: Throwable -> L11
        goto L6
    L21:
        return;
    L10:
        return;
    }

    public static boolean isDropData() {
        if (sIsDropData == false) goto L5;
    L8:
        return true;
    L5:
        if (Global.hasCrashBefore() == true) goto L8;
        return false;
    }

    public static boolean isDumpData() {
        return isDumpData;
    }

    public static boolean isRunning() {
        AnrManager r0 = sInstance;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.mIsRunning == false) goto L7;
        return true;
    }

    private static void notifyAnrUpload(long r9, long r11, String r13, JSONObject r14) {
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r0 != null) goto L5;
        return;
    L5:
        List<IAnrUploadCallback> r1 = r0.getUserDataCenter().getAnrUploadCallback();     // Catch: Throwable -> L13
        if (r1.isEmpty() == true) goto L12;
        Iterator<IAnrUploadCallback> r2 = r1.iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L19;
        ((IAnrUploadCallback) ZeusTransformUtils.preCheckCast(r2.next(), IAnrUploadCallback.class, "com.obric.memorydata.plugin")).onCrash(r11, r9, r13, r14);     // Catch: Throwable -> L13
    L19:
        return;
    L12:
        return;
    }

    private void onAnrDetected(long r8, boolean r10, File r11, int r12, int r13) {
        AnrHandler r0 = getPendingHandler(r8, r10);
        if (r0 == null) goto L6;
        r0.start(r8, r10, r11, r12, r13);
        return;
    }

    public static void onAnrInfoDetected(long r8, File r10) {
        if (isRunning() == false) goto L11;
        sInstance.onAnrDetected(r8, false, r10, 0, 1000);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ANRUtils.reportInnerError(th);
        return;
    }

    public static void onSigquitDetected(int r8, int r9) {
        if (isRunning() == false) goto L19;
        handlePreANRs();
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (GlobalSwitch.isOpenNewAnrMonitor() == false) goto L8;
        sInstance.onSigquitDetected(r2, r8, r9);     // Catch: Throwable -> L12
    L15:
        return;
    L8:
        AnrManager r1 = sInstance;     // Catch: Throwable -> L12
        if ((r2 - r1.lastSignalTime) < 5000) goto L15;
        r1.lastSignalTime = r2;     // Catch: Throwable -> L12
        r1.onAnrDetected(r2, true, null, r8, r9);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ANRUtils.reportInnerError(th);
        return;
    }

    private void onSigquitDetected(long r8, int r10, int r11) {
        if (GlobalSwitch.isAnrMonitorOpt() == true) goto L9;
        if ((r8 - this.lastSignalTime) >= 5000) goto L7;
        return;
    L7:
        this.lastSignalTime = r8;
    L9:
        if (enableUploadBackgroundANR == true) goto L13;
        if (r10 <= 200) goto L13;
        return;
    L13:
        if (Math.abs(lastAnrTime - r8) >= 120000) goto L15;
        return;
    L15:
        if (ANRUtils.isANR() == false) goto L20;
        lastAnrTime = r8;
        sInstance.mAnrInfoMonitor.startCheckAnrInfo(r8);
        sInstance.onAnrDetected(r8, true, null, r10, r11);
        return;
    }

    public static void registerAnrInfoObserver(final String r2, IFileContentGetter r3) {
        final IFileContentGetter r4 = (IFileContentGetter) ZeusTransformUtils.wrapperContextForParams(r3, IFileContentGetter.class, "com.obric.memorydata.plugin");
        DefaultWorkThread.post(new AnonymousClass4(r2, r4));
    }

    private synchronized void resetPendingAnrHandler(AnrHandler r3) {
        monitor-enter(this);
        AnrManager r0 = sInstance;     // Catch: Throwable -> L8
        if (r0.mPendingHandler != r3) goto L6;
        r0.mPendingHandler = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static void resetPendingAnrProcess(AnrHandler r1) {
        AnrManager r0 = sInstance;
        if (r0 == null) goto L6;
        r0.resetPendingAnrHandler(r1);
        return;
    }

    public static void setAnrDisableDumpData(boolean r0) {
        isDumpData = !r0;
    }

    public static void setDropData(boolean r0) {
        sIsDropData = r0;
    }

    public static void setUploadBackgroundANR(boolean r0) {
        enableUploadBackgroundANR = r0;
    }

    private void start() {
        if (this.mIsRunning == true) goto L8;
        this.mIsRunning = true;
        this.mAnrSignalMonitor.start();
        this.mAnrInfoMonitor.start();
        this.mAnrProfiler.start();
        if (GlobalSwitch.isOpenLooperMonitor() == false) goto L9;
        LooperMessageRecorder.getInstance().start();
        return;
    L9:
        return;
    }

    public static synchronized void startMonitor(Context r3, final File r4) {
        monitor-enter(AnrManager.class);
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        DefaultWorkThread.post(new AnonymousClass3(r5, r4));     // Catch: Throwable -> L7
        monitor-exit(AnrManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void stop() {
        if (this.mIsRunning == false) goto L6;
        this.mIsRunning = false;
        this.mAnrSignalMonitor.stop();
        this.mAnrInfoMonitor.stop();
        this.mAnrProfiler.exit();
        LooperMessageRecorder.getInstance().stop();
        return;
    }

    public static void stopMonitor() {
        AnrManager r0 = sInstance;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public static void upload(AppMonitor r1, long r2) {
        AnrManager r0 = sInstance;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.uploadAll(r1, r2);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_upload", e);
    }

    private void uploadAll(AppMonitor r19, long r20) {
        this.mAnrInfoMonitor.processUndetectedAnrInfo(this.mAnrRootDirectory);     // Catch: Exception -> L5
    L7:
        File[] r0 = getProcessDirectories();
        int r5 = r0.length;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L32;
        File r8 = r0[r7];
        String[] r11 = r8.getName().split("-");     // Catch: Throwable -> L17
        if (r11.length != 2) goto L16;
        long r12 = Long.parseLong(r11[0]);     // Catch: Throwable -> L17
        long r14 = Integer.parseInt(r11[1]);     // Catch: Throwable -> L33
    L20:
        if (r12 == Global.getAppStartTime()) goto L22;
    L24:
        File[] r13 = getCrashDirectories(r8);
        if (r20 <= 0) goto L27;
        uploadAll(r13, r19, r20);
    L29:
        if (getCrashDirectories(r8).length != 0) goto L31;
        FileSystemUtils.deleteAll(r8);
    L31:
        r7 = r7 + 1;
        goto L8
    L27:
        uploadAll(r13, r19);
        goto L29
    L22:
        if (r14 != Process.myPid()) goto L24;
    L18:
        r14 = 0;
        goto L20
    L16:
        r12 = 0;
        r14 = 0;
    L17:
        r12 = 0;
        goto L18
    L32:
        return;
    L5:
        e = move-exception;
        ANRUtils.reportInnerError(e);
        goto L7
    }

    private void uploadAll(File[] r9, AppMonitor r10) {
        int r0 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        File r2 = r9[r1];
        AnrSummary r3 = AnrSummary.loadFromDirectory(r2);
        if (r3 != null) goto L7;
        FileSystemUtils.deleteAll(r2);
        ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, r3.getProcessName(), r3.getPid(), r3.getCrashTime());
        uploadOne(r3, r10);
        goto L8
    }

    private void uploadAll(File[] r10, final AppMonitor r11, long r12) {
        final ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        File r3 = r10[r2];
        AnrSummary r4 = AnrSummary.loadFromDirectory(r3);
        if (r4 != null) goto L7;
        FileSystemUtils.deleteAll(r3);
        ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L11:
        r2 = r2 + 1;
        goto L3
    L7:
        CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, r4.getProcessName(), r4.getPid(), r4.getCrashTime());
        if ((r4.getCrashTime() - r4.getStartTime()) > RuntimeConfig.getLaunchCrashInterval()) goto L10;
        uploadOne(r4, r11);
        goto L11
    L10:
        r0.add(r4);
        goto L11
    L13:
        if (r0.isEmpty() == true) goto L20;
        DefaultWorkThread.postDelayed(new AnonymousClass5(this, r0, r11), r12);
        return;
    }

    private void uploadOne(AnrSummary r1, AppMonitor r2) {
        r1.upload(r2, null);
    }
}
