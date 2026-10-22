package com.bytedance.crash.anr;

import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    private AnrManager(@NonNull Context r10, @NonNull File r11) {
        this.mIsRunning = false;
        this.lastSignalTime = 0;
        this.mAnrSignalMonitor = new AnrSignalMonitor();
        File r12 = FileSystemUtils.createDirectory(r11, ANR_ROOT_DIR);
        this.mAnrRootDirectory = r12;
        this.mAnrInfoMonitor = new AnrInfoMonitor(r10, r12);
        this.mAnrProfiler = new AnrProfiler();
    }

    /* synthetic */ AnrManager(Context r10, File r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    static /* synthetic */ AnrManager access$000() {
        return sInstance;
    }

    static /* synthetic */ AnrManager access$002(AnrManager r10) {
        sInstance = r10;
        return r10;
    }

    static /* synthetic */ void access$200(AnrManager r10) {
        r10.start();
    }

    static /* synthetic */ AnrInfoMonitor access$300(AnrManager r10) {
        return r10.mAnrInfoMonitor;
    }

    static /* synthetic */ void access$400(AnrManager r10, AnrSummary r11, AppMonitor r12) {
        r10.uploadOne(r11, r12);
    }

    public static void dumpProfilerWithNativeInfo(File r10, long r11) {
        if (isRunning() == false) goto L8;
        AnrProfiler r12 = sInstance.mAnrProfiler;
        if (r12 == null) goto L9;
        r12.dumpWithNativeInfo(r10, r11);
        return;
    L9:
        return;
    }

    private File[] getCrashDirectories(File r10) {
        return r10.listFiles(new AnonymousClass2(this));
    }

    @Nullable
    private synchronized AnrHandler getPendingHandler(long r10, boolean r11) {
        monitor-enter(this);
        AnrHandler r12 = this.mPendingHandler;     // Catch: Throwable -> L14
        if (r12 != null) goto L7;
        this.mPendingHandler = AnrHandler.get(this.mAnrInfoMonitor, this.mAnrRootDirectory, r10, r11);     // Catch: Throwable -> L14
    L11:
        AnrHandler r13 = this.mPendingHandler;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r13;
    L7:
        if (r12.isDiscarded(r11) == false) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private File[] getProcessDirectories() {
        return this.mAnrRootDirectory.listFiles(new AnonymousClass1(this));
    }

    @Nullable
    public static File getRootDirectory() {
        AnrManager r10 = sInstance;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.mAnrRootDirectory;
    }

    public static void handlePreANRs() {
        AppMonitor r10 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L12
        if (r10 == null) goto L10;
        Iterator<IPreANRCallback> r11 = r10.getUserDataCenter().getPreANRCallback().iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L21;
        r11.next().onSignal();     // Catch: Throwable -> L11
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
        AnrManager r10 = sInstance;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.mIsRunning == false) goto L7;
        return true;
    }

    private static void notifyAnrUpload(long r10, long r11, String r13, JSONObject r14) {
        AppMonitor r12 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L13
        if (r12 != null) goto L5;
        return;
    L5:
        List<IAnrUploadCallback> r15 = r12.getUserDataCenter().getAnrUploadCallback();     // Catch: Throwable -> L13
        if (r15.isEmpty() == true) goto L12;
        Iterator<IAnrUploadCallback> r16 = r15.iterator();     // Catch: Throwable -> L13
    L9:
        if (r16.hasNext() == false) goto L19;
        r16.next().onCrash(r11, r10, r13, r14);     // Catch: Throwable -> L13
    L19:
        return;
    L12:
        return;
    }

    private void onAnrDetected(long r10, boolean r11, File r12, int r13, int r14) {
        AnrHandler r15 = getPendingHandler(r10, r11);
        if (r15 == null) goto L6;
        r15.start(r10, r11, r12, r13, r14);
        return;
    }

    public static void onAnrInfoDetected(long r10, File r11) {
        if (isRunning() == false) goto L11;
        sInstance.onAnrDetected(r10, false, r11, 0, 1000);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        ANRUtils.reportInnerError(th);
        return;
    }

    public static void onSigquitDetected(int r10, int r11) {
        if (isRunning() == false) goto L19;
        handlePreANRs();
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (GlobalSwitch.isOpenNewAnrMonitor() == false) goto L8;
        sInstance.onSigquitDetected(r12, r10, r11);     // Catch: Throwable -> L12
    L15:
        return;
    L8:
        AnrManager r13 = sInstance;     // Catch: Throwable -> L12
        if ((r12 - r13.lastSignalTime) < MIN_SIGNAL_INTERVAL) goto L15;
        r13.lastSignalTime = r12;     // Catch: Throwable -> L12
        r13.onAnrDetected(r12, true, null, r10, r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ANRUtils.reportInnerError(th);
        return;
    }

    private void onSigquitDetected(long r10, int r11, int r12) {
        if (GlobalSwitch.isAnrMonitorOpt() == true) goto L9;
        if ((r10 - this.lastSignalTime) >= MIN_SIGNAL_INTERVAL) goto L7;
        return;
    L7:
        this.lastSignalTime = r10;
    L9:
        if (enableUploadBackgroundANR == true) goto L13;
        if (r11 <= 200) goto L13;
        return;
    L13:
        if (Math.abs(lastAnrTime - r10) >= ANR_MIN_INTERVAL) goto L15;
        return;
    L15:
        if (ANRUtils.isANR() == false) goto L20;
        lastAnrTime = r10;
        sInstance.mAnrInfoMonitor.startCheckAnrInfo(r10);
        sInstance.onAnrDetected(r10, true, null, r11, r12);
        return;
    }

    public static void registerAnrInfoObserver(final String r10, final IFileContentGetter r11) {
        DefaultWorkThread.post(new AnonymousClass4(r10, r11));
    }

    private synchronized void resetPendingAnrHandler(AnrHandler r10) {
        monitor-enter(this);
        AnrManager r11 = sInstance;     // Catch: Throwable -> L8
        if (r11.mPendingHandler != r10) goto L6;
        r11.mPendingHandler = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static void resetPendingAnrProcess(AnrHandler r10) {
        AnrManager r11 = sInstance;
        if (r11 == null) goto L6;
        r11.resetPendingAnrHandler(r10);
        return;
    }

    public static void setAnrDisableDumpData(boolean r10) {
        isDumpData = !r10;
    }

    public static void setDropData(boolean r10) {
        sIsDropData = r10;
    }

    public static void setUploadBackgroundANR(boolean r10) {
        enableUploadBackgroundANR = r10;
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

    public static synchronized void startMonitor(@NonNull final Context r10, @NonNull final File r11) {
        monitor-enter(AnrManager.class);
        DefaultWorkThread.post(new AnonymousClass3(r10, r11));     // Catch: Throwable -> L7
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
        AnrManager r10 = sInstance;
        if (r10 == null) goto L6;
        r10.stop();
        return;
    }

    public static void upload(@NonNull AppMonitor r10, long r11) {
        AnrManager r12 = sInstance;     // Catch: Exception -> L6
        if (r12 == null) goto L11;
        r12.uploadAll(r10, r11);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_upload", e);
    }

    private void uploadAll(@NonNull AppMonitor r19, long r20) {
        this.mAnrInfoMonitor.processUndetectedAnrInfo(this.mAnrRootDirectory);     // Catch: Exception -> L5
    L7:
        File[] r10 = getProcessDirectories();
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L32;
        File r13 = r10[r12];
        String[] r14 = r13.getName().split("-");     // Catch: Throwable -> L17
        if (r14.length != 2) goto L16;
        long r15 = Long.parseLong(r14[0]);     // Catch: Throwable -> L17
        long r16 = Integer.parseInt(r14[1]);     // Catch: Throwable -> L33
    L20:
        if (r15 == Global.getAppStartTime()) goto L22;
    L24:
        File[] r17 = getCrashDirectories(r13);
        if (r20 <= 0) goto L27;
        uploadAll(r17, r19, r20);
    L29:
        if (getCrashDirectories(r13).length != 0) goto L31;
        FileSystemUtils.deleteAll(r13);
    L31:
        r12 = r12 + 1;
        goto L8
    L27:
        uploadAll(r17, r19);
        goto L29
    L22:
        if (r16 != Process.myPid()) goto L24;
    L18:
        r16 = 0;
        goto L20
    L16:
        r15 = 0;
        r16 = 0;
    L17:
        r15 = 0;
        goto L18
    L32:
        return;
    L5:
        e = move-exception;
        ANRUtils.reportInnerError(e);
        goto L7
    }

    private void uploadAll(File[] r10, AppMonitor r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        File r14 = r10[r13];
        AnrSummary r15 = AnrSummary.loadFromDirectory(r14);
        if (r15 != null) goto L7;
        FileSystemUtils.deleteAll(r14);
        ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L8:
        r13 = r13 + 1;
        goto L3
    L7:
        CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, r15.getProcessName(), r15.getPid(), r15.getCrashTime());
        uploadOne(r15, r11);
        goto L8
    }

    private void uploadAll(File[] r10, final AppMonitor r11, long r12) {
        final ArrayList r13 = new ArrayList();
        int r14 = r10.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L13;
        File r16 = r10[r15];
        AnrSummary r17 = AnrSummary.loadFromDirectory(r16);
        if (r17 != null) goto L7;
        FileSystemUtils.deleteAll(r16);
        ANRUtils.reportInnerError(new Exception("invalid summary : neither AnrInfo nor Stack"));
    L11:
        r15 = r15 + 1;
        goto L3
    L7:
        CrashAccessibilityMonitor.setCrashInfo(CrashType.ANR, r17.getProcessName(), r17.getPid(), r17.getCrashTime());
        if ((r17.getCrashTime() - r17.getStartTime()) > RuntimeConfig.getLaunchCrashInterval()) goto L10;
        uploadOne(r17, r11);
        goto L11
    L10:
        r13.add(r17);
        goto L11
    L13:
        if (r13.isEmpty() == true) goto L20;
        DefaultWorkThread.postDelayed(new AnonymousClass5(this, r13, r11), r12);
        return;
    }

    private void uploadOne(AnrSummary r10, AppMonitor r11) {
        r10.upload(r11, null);
    }
}
