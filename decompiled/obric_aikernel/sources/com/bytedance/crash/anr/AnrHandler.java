package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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

        DefaultAnrHandler(AnrInfoMonitor r10, File r11, long r12, boolean r13) {
            super(r10, r11, r12, r13);
            this.mInProcessCount = new AtomicInteger(0);
            this.mWaitAnrInfoTimeoutHandler = new AnonymousClass1(this);
        }

        static /* synthetic */ void access$200(DefaultAnrHandler r10) {
            r10.processTimeout();
        }

        private boolean processEnter(long r10, boolean r11, File r12) {
            if (this.mInProcessCount.incrementAndGet() > 0) goto L7;
            return false;
        L7:
            if (r11 == false) goto L18;
            monitor-enter(this);
            this.mSignalTime = r10;     // Catch: Throwable -> L14
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
            this.mAnrInfoTime = moveAnrInfoToDumperDirectory(r12);     // Catch: Throwable -> L25
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
            File r10 = this.mAnrInfoMonitor.findMatchedAnrInfoFile(Process.myPid(), this.mCrashTime);
            monitor-enter(this);
            this.mAnrInfoTime = moveAnrInfoToDumperDirectory(r10);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L16:
            if (this.mAnrInfoTime == 0) goto L19;
            DefaultWorkThread.postDelayed(new AnonymousClass2(this), AnrManager.ANR_MIN_INTERVAL);
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
        boolean isDiscarded(boolean r10) {
            if (r10 == false) goto L8;
            if (this.mSignalTime == 0) goto L11;
            return true;
        L11:
            return false;
        L8:
            if (this.mAnrInfoTime == 0) goto L11;
            return true;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long r10, boolean r11, File r12, int r13, int r14) {
            if (processEnter(r10, r11, r12) == true) goto L5;
            return;
        L5:
            processDump(r13, r14);
            if (r12 == null) goto L8;
            handleCallbacks(r12);
        L8:
            processExit();
        }
    }

    private static class RunningAppAnrHandler extends AnrHandler {
        private final AtomicInteger mInProcessCount;
        private Runnable runnable;

        RunningAppAnrHandler(AnrInfoMonitor r10, File r11, long r12, boolean r13) {
            super(r10, r11, r12, r13);
            this.mInProcessCount = new AtomicInteger(2);
        }

        static /* synthetic */ AtomicInteger access$000(RunningAppAnrHandler r10) {
            return r10.mInProcessCount;
        }

        static /* synthetic */ void access$100(RunningAppAnrHandler r10) {
            r10.processExit();
        }

        private boolean processEnter() {
            if (this.mInProcessCount.decrementAndGet() >= 0) goto L7;
            return false;
        L7:
            if (this.runnable != null) goto L11;
            Runnable r10 = new AnonymousClass1(this);
            this.runnable = r10;
            DefaultWorkThread.postDelayed(r10, AnrManager.ANR_MIN_INTERVAL);
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
        boolean isDiscarded(boolean r10) {
            return false;
        }

        @Override // com.bytedance.crash.anr.AnrHandler
        void start(long r10, boolean r11, File r12, int r13, int r14) {
            if (processEnter() == true) goto L5;
            return;
        L5:
            if (r12 != null) goto L7;
        L9:
            processDump(r13, r14);
            if (new File(this.mDumpDirectory, AnrInfoParser.getFileName()).exists() == true) goto L12;
            FileSystemUtils.writeFile(new File(this.mDumpDirectory, AnrInfoParser.getFileName()), AnrManager.SILENT_ANR_NO_ANR_INFO);
        L12:
            processExit();
            return;
        L7:
            if (r12.exists() == false) goto L9;
            moveAnrInfoToDumperDirectory(r12);
            goto L9
        }
    }

    AnrHandler(AnrInfoMonitor r10, File r11, long r12, boolean r13) {
        this.mAnrInfoMonitor = r10;
        this.mCrashTime = r12;
        File r14 = createAnrDirectory(r11, r12);
        this.mDumpDirectory = r14;
        this.mDumper = AnrDumper.create(r14, r12, r13);
    }

    private File createAnrDirectory(File r10, long r11) {
        return FileSystemUtils.createDirectory(FileSystemUtils.createDirectory(r10, CrashManager.getProcessDirectoryName()), String.valueOf(r11));
    }

    public static AnrHandler get(AnrInfoMonitor r10, File r11, long r12, boolean r13) {
        if (GlobalSwitch.isOpenNewAnrMonitor() == false) goto L7;
        return new RunningAppAnrHandler(r10, r11, r12, r13);
    L7:
        return new DefaultAnrHandler(r10, r11, r12, r13);
    }

    static boolean isSameTask(long r10, long r11) {
        if (Math.abs(r10 - r11) > 35000) goto L5;
        return true;
    L5:
        return false;
    }

    void handleCallbacks(@NonNull File r10) {
        String r11 = FileSystemUtils.readUtf8File(r10);
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        Iterator<CrashListener> r12 = MonitorManager.getCrashListenerList().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        handleMonitorCallbacks(r12.next(), r11);
        goto L7
    }

    void handleMonitorCallbacks(CrashListener r10, String r11) {
        Iterator<ICrashCallback> r12 = r10.getUserDataCenter().getCrashCallback(CrashType.ANR).iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ICrashCallback r13 = r12.next();
        r13.onCrash(CrashType.ANR, r11, null);     // Catch: Throwable -> L9
        goto L4
    }

    abstract boolean isDiscarded(boolean r10);

    protected long moveAnrInfoToDumperDirectory(File r10) {
        if (r10 != null) goto L4;
    L6:
        return 0;
    L4:
        if (r10.exists() == false) goto L6;
        long r11 = AnrInfoMonitor.getCrashTimeFromFileName(r10.getName());
        r10.renameTo(new File(this.mDumpDirectory, AnrInfoParser.getFileName()));
        return r11;
    }

    final void processDump(int r10, int r11) {
        this.mAllData = this.mDumper.dumpAllInfo(r10, r11);
    }

    abstract void start(long r10, boolean r11, File r12, int r13, int r14);
}
