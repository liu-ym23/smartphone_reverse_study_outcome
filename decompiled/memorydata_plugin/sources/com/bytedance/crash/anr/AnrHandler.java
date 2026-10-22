package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnrHandler {
    static final int PENDING_TIME_INTERVAL_MS = 120000;
    private static final int WAIT_ANR_INFO_TIME_OUT_MS = 35000;
    private JSONArray mAllData;
    protected final AnrInfoMonitor mAnrInfoMonitor;
    protected final long mCrashTime;
    protected final File mDumpDirectory;
    protected final AnrDumper mDumper;

    private static class DefaultAnrHandler extends AnrHandler {
        private long mAnrInfoTime;
        private volatile boolean mAnrInfoTimeout;
        private final AtomicInteger mInProcessCount;
        private long mSignalTime;
        private final Runnable mWaitAnrInfoTimeoutHandler;

        DefaultAnrHandler(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
            super(r1, r2, r3, r5);
            this.mInProcessCount = new AtomicInteger(0);
            this.mWaitAnrInfoTimeoutHandler = new AnonymousClass1(this);
        }

        static /* synthetic */ void access$200(DefaultAnrHandler r0) {
            r0.processTimeout();
        }

        private boolean processEnter(long r3, boolean r5, File r6) {
            if (this.mInProcessCount.incrementAndGet() > 0) goto L7;
            return false;
        L7:
            if (r5 == false) goto L18;
            monitor-enter(this);
            this.mSignalTime = r3;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            if (this.mAnrInfoTime != 0) goto L32;
            DefaultWorkThread.postDelayed(this.mWaitAnrInfoTimeoutHandler, 35000);
            return true;
        L32:
            return true;
        L14:
            th = move-exception;
            throw th;
        L18:
            if (this.mSignalTime == 0) goto L20;
            DefaultWorkThread.removeCallbacks(this.mWaitAnrInfoTimeoutHandler);
        L20:
            monitor-enter(this);
            this.mAnrInfoTime = moveAnrInfoToDumperDirectory(r6);     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            return true;
        L25:
            th = move-exception;
            throw th;
        }

        private void processExit() {
            if (this.mInProcessCount.decrementAndGet() <= 0) goto L6;
            return;
        L6:
            if (this.mAnrInfoTime != 0) goto L16;
            File r0 = this.mAnrInfoMonitor.findMatchedAnrInfoFile(Process.myPid(), this.mCrashTime);
            monitor-enter(this);
            this.mAnrInfoTime = moveAnrInfoToDumperDirectory(r0);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L16:
            if (this.mAnrInfoTime == 0) goto L19;
            DefaultWorkThread.postDelayed(new AnonymousClass2(this), 120000);
            return;
        L19:
            if (this.mAnrInfoTimeout == false) goto L27;
            AnrManager.resetPendingAnrProcess(this);
            if (this.mInProcessCount.decrementAndGet() >= 0) goto L28;
            FileSystemUtils.deleteAll(this.mDumpDirectory);
            return;
        L28:
            return;
        }

        private void processTimeout() {
            this.mAnrInfoTimeout = true;
            this.mInProcessCount.incrementAndGet();
            processExit();
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        boolean isDiscarded(boolean r5) {
            if (r5 == false) goto L8;
            if (this.mSignalTime == 0) goto L11;
            return true;
        L11:
            return false;
        L8:
            if (this.mAnrInfoTime == 0) goto L11;
            return true;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long r1, boolean r3, File r4, int r5, int r6) {
            if (processEnter(r1, r3, r4) == true) goto L5;
            return;
        L5:
            processDump(r5, r6);
            if (r4 == null) goto L8;
            handleCallbacks(r4);
        L8:
            processExit();
        }
    }

    private static class RunningAppAnrHandler extends AnrHandler {
        private final AtomicInteger mInProcessCount;
        private Runnable runnable;

        RunningAppAnrHandler(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
            super(r1, r2, r3, r5);
            this.mInProcessCount = new AtomicInteger(2);
        }

        static /* synthetic */ AtomicInteger access$000(RunningAppAnrHandler r0) {
            return r0.mInProcessCount;
        }

        static /* synthetic */ void access$100(RunningAppAnrHandler r0) {
            r0.processExit();
        }

        private boolean processEnter() {
            if (this.mInProcessCount.decrementAndGet() >= 0) goto L7;
            return false;
        L7:
            if (this.runnable != null) goto L11;
            Runnable r0 = new AnonymousClass1(this);
            this.runnable = r0;
            DefaultWorkThread.postDelayed(r0, 120000);
            return true;
        L11:
            return true;
        }

        private void processExit() {
            if (this.mInProcessCount.get() > 0) goto L6;
            handleCallbacks(new File(this.mDumpDirectory, AnrInfoParser.getFileName()));
            DefaultWorkThread.removeCallbacks(this.runnable);
            this.runnable = null;
            AnrManager.resetPendingAnrProcess(this);
            return;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        boolean isDiscarded(boolean r1) {
            return false;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long r1, boolean r3, File r4, int r5, int r6) {
            if (processEnter() == true) goto L5;
            return;
        L5:
            if (r4 != null) goto L7;
        L9:
            processDump(r5, r6);
            if (new File(this.mDumpDirectory, AnrInfoParser.getFileName()).exists() == true) goto L12;
            FileSystemUtils.writeFile(new File(this.mDumpDirectory, AnrInfoParser.getFileName()), AnrManager.SILENT_ANR_NO_ANR_INFO);
        L12:
            processExit();
            return;
        L7:
            if (r4.exists() == false) goto L9;
            moveAnrInfoToDumperDirectory(r4);
            goto L9
        }
    }

    AnrHandler(AnrInfoMonitor r1, File r2, long r3, boolean r5) {
        this.mAnrInfoMonitor = r1;
        this.mCrashTime = r3;
        File r4 = createAnrDirectory(r2, r3);
        this.mDumpDirectory = r4;
        this.mDumper = AnrDumper.create(r4, r3, r5);
    }

    private File createAnrDirectory(File r1, long r2) {
        return FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(r1, CrashManager.getProcessDirectoryName()), String.valueOf(r2));
    }

    public static AnrHandler get(AnrInfoMonitor r7, File r8, long r9, boolean r11) {
        if (GlobalSwitch.isOpenNewAnrMonitor() == false) goto L7;
        return new RunningAppAnrHandler(r7, r8, r9, r11);
    L7:
        return new DefaultAnrHandler(r7, r8, r9, r11);
    }

    static boolean isSameTask(long r0, long r2) {
        if (Math.abs(r0 - r2) > 35000) goto L5;
        return true;
    L5:
        return false;
    }

    void handleCallbacks(File r5) {
        String r6 = FileSystemUtils.readUtf8File(r5);
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        Iterator<CrashListener> r0 = MonitorManager.getCrashListenerList().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        handleMonitorCallbacks((CrashListener) ZeusTransformUtils.preCheckCast(r0.next(), CrashListener.class, "com.obric.memorydata.plugin"), r6);
        goto L7
    }

    void handleMonitorCallbacks(CrashListener r3, String r4) {
        Iterator<ICrashCallback> r2 = r3.getUserDataCenter().getCrashCallback(CrashType.ANR).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.preCheckCast(r2.next(), ICrashCallback.class, "com.obric.memorydata.plugin");
        r5.onCrash(CrashType.ANR, r4, null);     // Catch: Throwable -> L9
        goto L4
    }

    abstract boolean isDiscarded(boolean r1);

    public long moveAnrInfoToDumperDirectory(File r5) {
        if (r5 != null) goto L4;
    L6:
        return 0;
    L4:
        if (r5.exists() == false) goto L6;
        long r0 = AnrInfoMonitor.getCrashTimeFromFileName(r5.getName());
        r5.renameTo(new File(this.mDumpDirectory, AnrInfoParser.getFileName()));
        return r0;
    }

    final void processDump(int r2, int r3) {
        this.mAllData = this.mDumper.dumpAllInfo(r2, r3);
    }

    abstract void start(long r1, boolean r3, File r4, int r5, int r6);
}
