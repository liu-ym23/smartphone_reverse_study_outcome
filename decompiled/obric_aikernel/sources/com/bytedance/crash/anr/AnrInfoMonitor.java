package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IFileContentGetter;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class AnrInfoMonitor {
    public static final String ANR_FROM_EXTERNAL = "from_external_flag";
    private static final String ANR_INFO_DIR = "anr_info";
    private static final String PREFIX = "ai_";
    private static final String SUFFIX_CURRENT = "_current";
    private static final String SUFFIX_OTHER = "_other";
    private static final String TAG = "AnrInfoMonitor";
    private LightAnrInfoGetThread lightGetAnrInfoThread;
    private final Context mContext;
    private final File mDirectory;
    private final InnerObserver mObserver;
    private boolean mStarted;

    class AnrInfoWriter extends Thread {
        private final File mLockFile;
        final /* synthetic */ AnrInfoMonitor this$0;

        AnrInfoWriter(AnrInfoMonitor r10, File r11) {
            this.this$0 = r10;
            super("NPTH-AnrInfoPolling");
            this.mLockFile = FileSystemUtils.createFile(r11, "monitor.lock");
        }

        private void threadLooper() {
            ActivityManager r10 = (ActivityManager) AnrInfoMonitor.access$100(this.this$0).getSystemService("activity");
            long r11 = RuntimeConfig.getAnrCheckInterval();
            ActivityManager.ProcessErrorStateInfo r12 = null;
        L4:
            if (AnrInfoMonitor.access$200(this.this$0) == false) goto L35;
            SystemClock.sleep(r11);
            if (r10 != null) goto L8;
            r10 = (ActivityManager) AnrInfoMonitor.access$100(this.this$0).getSystemService("activity");
        L8:
            if (r10 == null) goto L4;
            List<ActivityManager.ProcessErrorStateInfo> r13 = r10.getProcessesInErrorState();     // Catch: Throwable -> L36
            if (r13 == null) goto L4;
            Iterator<ActivityManager.ProcessErrorStateInfo> r14 = r13.iterator();     // Catch: Throwable -> L36
        L15:
            if (r14.hasNext() == false) goto L4;
            ActivityManager.ProcessErrorStateInfo r15 = r14.next();     // Catch: Throwable -> L36
            if (r15.condition != 2) goto L15;
            if (r12 == null) goto L23;
            if (AnrInfoParser.isSameProcessErrorStateInfo(r12, r15) == true) goto L15;
        L23:
            long r16 = System.currentTimeMillis();     // Catch: Throwable -> L36
            int r17 = r15.pid;     // Catch: Throwable -> L36
            if (Process.myPid() != r15.pid) goto L26;
            boolean r18 = true;
        L27:
            String r19 = AnrInfoMonitor.getAnrInfoFileName(r16, r17, r18);     // Catch: Throwable -> L36
            File r110 = new File(AnrInfoMonitor.access$000(this.this$0), r19);     // Catch: Throwable -> L36
            FileSystemUtils.writeFile(r110, AnrInfoParser.format(r15));     // Catch: Throwable -> L36
            if (r110.exists() == false) goto L15;
            if (Process.myPid() != r15.pid) goto L32;
            AnrManager.onAnrInfoDetected(r16, r110);     // Catch: Throwable -> L34
        L32:
            SystemClock.sleep(20 * r11);     // Catch: Throwable -> L34
            r12 = r15;
        L34:
            r12 = r15;
            goto L4
        L26:
            r18 = false;
            goto L27
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NpthLog.i(AnrInfoMonitor.TAG, "AnrInfoMonitor:prepare lock：" + App.getProcessName());
            int r10 = NativeBridge.fLock(this.mLockFile.getAbsolutePath());
            NpthLog.i(AnrInfoMonitor.TAG, "AnrInfoMonitor:run：" + App.getProcessName());
            threadLooper();
            if (r10 == (-1)) goto L11;
            NativeBridge.unFlock(r10);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            NpthLog.e(th);
            return;
        }
    }

    static class InnerObserver extends FileObserver {
        private final File mDirectory;

        public InnerObserver(String r10) {
            super(r10, 264);
            this.mDirectory = new File(r10);
        }

        @Override // android.os.FileObserver
        public void onEvent(int r10, String r11) {
            if ((r10 & 8) != 0) goto L5;
            return;
        L5:
            if (r11.startsWith(AnrInfoMonitor.PREFIX) == true) goto L7;
            return;
        L7:
            if (AnrInfoMonitor.getPidFromFileName(r11) == Process.myPid()) goto L9;
            return;
        L9:
            if (r11.endsWith(AnrInfoMonitor.SUFFIX_OTHER) == false) goto L15;
            AnrManager.onAnrInfoDetected(AnrInfoMonitor.getCrashTimeFromFileName(r11), new File(this.mDirectory, r11));
            return;
        }
    }

    class LightAnrInfoGetThread extends Thread {
        private final LinkedBlockingQueue<Long> mQueue;
        final /* synthetic */ AnrInfoMonitor this$0;

        LightAnrInfoGetThread(AnrInfoMonitor r10) {
            this.this$0 = r10;
            super("FetchingAnrInfo");
            this.mQueue = new LinkedBlockingQueue();
        }

        private void dumpAnrInfo(long r10) {
            System.out.println("get_anr_info_start_" + r10);     // Catch: Throwable -> L8
            String r11 = ANRUtils.getNewCurrentProcessANRInfo(AnrInfoMonitor.access$100(this.this$0), 150);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r11) == false) goto L6;
            System.out.println("get_anr_info_is_empty");     // Catch: Throwable -> L8
            r11 = AnrManager.SILENT_ANR_NO_ANR_INFO;
        L6:
            notifyAnrInfo(r10, r11);     // Catch: Throwable -> L8
            return;
        L8:
            notifyAnrInfo(r10, AnrManager.SILENT_ANR_NO_ANR_INFO);
        }

        private void notifyAnrInfo(long r10, String r11) {
            String r12 = AnrInfoMonitor.getAnrInfoFileName(r10, Process.myPid(), true);
            File r13 = new File(AnrInfoMonitor.access$000(this.this$0), r12);
            FileSystemUtils.writeFile(r13, r11);
            AnrManager.onAnrInfoDetected(r10, r13);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L8:
            Long r10 = this.mQueue.take();     // Catch: Throwable -> L7
            if (r10 != null) goto L4;
            System.out.println("get_anr_info_start_time_null");     // Catch: Throwable -> L7
            goto L8
        L4:
            dumpAnrInfo(r10.longValue());     // Catch: Throwable -> L7
            goto L8
        }

        public void startCheckAnrInfo(long r10) {
            if (GlobalSwitch.isAnrMonitorOpt() == false) goto L5;
            FileSystemUtils.writeFile(new File(AnrInfoMonitor.access$000(this.this$0), AnrInfoMonitor.getAnrInfoFileName(r10, Process.myPid(), true)), AnrManager.SILENT_ANR_NO_ANR_INFO);
        L5:
            this.mQueue.add(Long.valueOf(r10));
        }
    }

    AnrInfoMonitor(@NonNull Context r10, @NonNull File r11) {
        this.mContext = r10;
        File r12 = FileSystemUtils.createDirectory(r11, "anr_info");
        this.mDirectory = r12;
        this.mObserver = new InnerObserver(r12.getAbsolutePath());
    }

    static /* synthetic */ File access$000(AnrInfoMonitor r10) {
        return r10.mDirectory;
    }

    static /* synthetic */ Context access$100(AnrInfoMonitor r10) {
        return r10.mContext;
    }

    static /* synthetic */ boolean access$200(AnrInfoMonitor r10) {
        return r10.mStarted;
    }

    @Nullable
    private static File findMatchedCrashDirectory(File r17, long r18, final long r20, StringBuffer r22) {
        File[] r10 = r17.listFiles(new AnonymousClass4(r20));
        if (r10 != null) goto L5;
    L54:
        r22.append("processDirs==null");
        return null;
    L5:
        if (r10.length == 0) goto L54;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r13 >= r11) goto L52;
        File r14 = r10[r13];
        if (r14.isDirectory() == true) goto L12;
    L11:
        int r15 = r11;
    L51:
        r13 = r13 + 1;
        r11 = r15;
        r12 = 0;
        goto L8
    L12:
        String[] r16 = r14.getName().split("-");
        if (r16.length != 2) goto L11;
        long r19 = Long.parseLong(r16[r12]);     // Catch: Throwable -> L18
    L20:
        if (r19 != 0) goto L22;
    L50:
        r15 = r11;
        r22.append("startTime:" + r19 + "_" + r18);
        goto L51
    L22:
        if (r19 > r18) goto L50;
        File[] r21 = r14.listFiles();
        if (r21 != null) goto L27;
        r22.append("crashDirs is null ");
        goto L11
    L27:
        int r23 = r21.length;
        int r110 = r12;
    L28:
        if (r110 >= r23) goto L11;
        File r111 = r21[r110];
        if (r111.isDirectory() == true) goto L35;
        String r112 = "crashDirs is not directory ";
    L32:
        r22.append(r112);
    L33:
        r11 = r11;
    L49:
        r110 = r110 + 1;
        r11 = r11;
        goto L28
    L35:
        if (AnrSummary.hasSummaryFile(r111) == true) goto L38;
        r112 = "hasSummaryFile is false ";
        goto L32
    L38:
        if (new File(r111, AnrInfoParser.getFileName()).exists() == false) goto L58;
        r22.append("anrinfo exist:");
        goto L33
    L58:
        long r24 = Long.parseLong(r111.getName());     // Catch: Throwable -> L42
    L44:
        if (r24 != 0) goto L46;
    L48:
        r22.append("last error:" + r24 + "_" + r18);
        goto L49
    L46:
        if (AnrHandler.isSameTask(r24, r18) == false) goto L48;
        return r111;
    L42:
        r24 = 0;
    L18:
        r19 = 0;
        goto L20
    L52:
        return null;
    }

    @Nullable
    private File[] findUndetectedAnrInfoFiles() {
        if (this.mDirectory.exists() == true) goto L7;
        return null;
    L7:
        return this.mDirectory.listFiles(new AnonymousClass3(this));
    }

    static String getAnrInfoFileName(long r10, int r11, boolean r12) {
        if (r12 == false) goto L4;
        String r13 = SUFFIX_CURRENT;
    L6:
        return PREFIX + r10 + "_" + r11 + r13;
    L4:
        r13 = SUFFIX_OTHER;
        goto L6
    }

    static long getCrashTimeFromFileName(String r10) {
        String[] r11 = r10.split("_");
        if (r11.length != 4) goto L8;
        return Long.decode(r11[1]).longValue();
    L8:
        return System.currentTimeMillis();
    }

    static int getPidFromFileName(String r10) {
        String[] r11 = r10.split("_");
        if (r11.length == 4) goto L10;
        return 0;
    L10:
        return Integer.decode(r11[2]).intValue();
    L12:
        return 0;
    }

    @Nullable
    File findMatchedAnrInfoFile(int r10, long r11) {
        File[] r12 = findUndetectedAnrInfoFiles();
        if (r12 == null) goto L12;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L18;
        File r15 = r12[r14];
        if (getPidFromFileName(r15.getName()) != r10) goto L11;
        if (AnrHandler.isSameTask(r11, getCrashTimeFromFileName(r15.getName())) == false) goto L11;
        return r15;
    L11:
        r14 = r14 + 1;
        goto L5
    L18:
        return null;
    L12:
        return null;
    }

    void processUndetectedAnrInfo(File r12) {
        File[] r11 = findUndetectedAnrInfoFiles();
        if (r11 != null) goto L5;
        return;
    L5:
        int r10 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L22;
        File r14 = r11[r13];
        int r15 = getPidFromFileName(r14.getName());     // Catch: Throwable -> L19
        long r16 = getCrashTimeFromFileName(r14.getName());     // Catch: Throwable -> L19
        if (r15 != 0) goto L11;
    L17:
        r14.delete();     // Catch: Throwable -> L19
        ANRUtils.reportInnerError(new Exception("Invalid ANR Info File Name :{" + r14.getName() + "}"));     // Catch: Throwable -> L19
    L21:
        r13 = r13 + 1;
        goto L6
    L11:
        if (r16 == 0) goto L17;
        StringBuffer r17 = new StringBuffer();     // Catch: Throwable -> L19
        File r18 = findMatchedCrashDirectory(r12, r16, r15, r17);     // Catch: Throwable -> L19
        if (r18 != null) goto L16;
        r14.delete();     // Catch: Throwable -> L19
        ANRUtils.reportInnerError(new Exception("Not found matched directory pid:" + r15 + "_" + r14.getName() + "_:reason:" + r17));     // Catch: Throwable -> L19
        goto L21
    L16:
        r14.renameTo(new File(r18, AnrInfoParser.getFileName()));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", th);
        goto L21
    }

    void registerExternalObserver(final String r10, final IFileContentGetter r11) {
        final int r12 = 136;
        new AnonymousClass2(this, r10, r12, r11, r10).startWatching();
    }

    void start() {
        if (this.mStarted == true) goto L10;
        this.mStarted = true;
        this.mObserver.startWatching();
        if (GlobalSwitch.isOpenNewAnrMonitor() == true) goto L7;
        Thread r10 = new AnrInfoWriter(this, this.mDirectory);
    L8:
        r10.start();
        return;
    L7:
        LightAnrInfoGetThread r11 = new LightAnrInfoGetThread(this);
        this.lightGetAnrInfoThread = r11;
        r10 = r11;
        goto L8
    }

    public void startCheckAnrInfo(long r10) {
        this.lightGetAnrInfoThread.startCheckAnrInfo(r10);
    }

    void startFastBootAnrMonitor() {
        if (App.isMainProcess(this.mContext) == true) goto L13;
        return;
    L13:
        File r10 = this.mContext.getExternalFilesDir("fastbot");     // Catch: Exception -> L12
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.exists() == false) goto L16;
        registerExternalObserver(r10.getAbsolutePath(), new AnonymousClass1(this));     // Catch: Exception -> L12
        return;
    L16:
        return;
    }

    void stop() {
        if (this.mStarted == false) goto L6;
        this.mStarted = false;
        this.mObserver.stopWatching();
        return;
    }
}
