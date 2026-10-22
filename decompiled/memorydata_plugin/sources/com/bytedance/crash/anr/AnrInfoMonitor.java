package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IFileContentGetter;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
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

        AnrInfoWriter(AnrInfoMonitor r1, File r2) {
            this.this$0 = r1;
            super("NPTH-AnrInfoPolling");
            this.mLockFile = FileSystemUtils.createFile(r2, "monitor.lock");
        }

        private void threadLooper() {
            ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.access$100(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
            long r3 = RuntimeConfig.getAnrCheckInterval();
            ActivityManager.ProcessErrorStateInfo r5 = null;
        L4:
            if (AnrInfoMonitor.access$200(this.this$0) == false) goto L35;
            SystemClock.sleep(r3);
            if (r0 != null) goto L8;
            r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.access$100(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        L8:
            if (r0 == null) goto L4;
            List<ActivityManager.ProcessErrorStateInfo> r6 = r0.getProcessesInErrorState();     // Catch: Throwable -> L36
            if (r6 == null) goto L4;
            Iterator<ActivityManager.ProcessErrorStateInfo> r7 = r6.iterator();     // Catch: Throwable -> L36
        L15:
            if (r7.hasNext() == false) goto L4;
            ActivityManager.ProcessErrorStateInfo r8 = (ActivityManager.ProcessErrorStateInfo) ZeusTransformUtils.preCheckCast(r7.next(), ActivityManager.ProcessErrorStateInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
            if (r8.condition != 2) goto L15;
            if (r5 == null) goto L23;
            if (AnrInfoParser.isSameProcessErrorStateInfo(r5, r8) == true) goto L15;
        L23:
            long r9 = System.currentTimeMillis();     // Catch: Throwable -> L36
            int r10 = r8.pid;     // Catch: Throwable -> L36
            if (Process.myPid() != r8.pid) goto L26;
            boolean r11 = true;
        L27:
            String r12 = AnrInfoMonitor.getAnrInfoFileName(r9, r10, r11);     // Catch: Throwable -> L36
            File r13 = new File(AnrInfoMonitor.access$000(this.this$0), r12);     // Catch: Throwable -> L36
            FileSystemUtils.writeFile(r13, AnrInfoParser.format(r8));     // Catch: Throwable -> L36
            if (r13.exists() == false) goto L15;
            if (Process.myPid() != r8.pid) goto L32;
            AnrManager.onAnrInfoDetected(r9, r13);     // Catch: Throwable -> L34
        L32:
            SystemClock.sleep(20 * r3);     // Catch: Throwable -> L34
            r5 = r8;
        L34:
            r5 = r8;
            goto L4
        L26:
            r11 = false;
            goto L27
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NpthLog.i(AnrInfoMonitor.TAG, "AnrInfoMonitor:prepare lock：" + App.getProcessName());
            int r0 = NativeBridge.fLock(this.mLockFile.getAbsolutePath());
            NpthLog.i(AnrInfoMonitor.TAG, "AnrInfoMonitor:run：" + App.getProcessName());
            threadLooper();
            if (r0 == (-1)) goto L11;
            NativeBridge.unFlock(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            NpthLog.e(th);
            return;
        }
    }

    static class InnerObserver extends FileObserver {
        private final File mDirectory;

        public InnerObserver(String r2) {
            super(r2, 264);
            this.mDirectory = new File(r2);
        }

        @Override // android.os.FileObserver
        public void onEvent(int r3, String r4) {
            if ((r3 & 8) != 0) goto L5;
            return;
        L5:
            if (r4.startsWith(AnrInfoMonitor.PREFIX) == true) goto L7;
            return;
        L7:
            if (AnrInfoMonitor.getPidFromFileName(r4) == Process.myPid()) goto L9;
            return;
        L9:
            if (r4.endsWith(AnrInfoMonitor.SUFFIX_OTHER) == false) goto L15;
            AnrManager.onAnrInfoDetected(AnrInfoMonitor.getCrashTimeFromFileName(r4), new File(this.mDirectory, r4));
            return;
        }
    }

    class LightAnrInfoGetThread extends Thread {
        private final LinkedBlockingQueue<Long> mQueue;
        final /* synthetic */ AnrInfoMonitor this$0;

        LightAnrInfoGetThread(AnrInfoMonitor r1) {
            this.this$0 = r1;
            super("FetchingAnrInfo");
            this.mQueue = new LinkedBlockingQueue();
        }

        private void dumpAnrInfo(long r6) {
            System.out.println("get_anr_info_start_" + r6);     // Catch: Throwable -> L8
            String r0 = ANRUtils.getNewCurrentProcessANRInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AnrInfoMonitor.access$100(this.this$0), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r0) == false) goto L6;
            System.out.println("get_anr_info_is_empty");     // Catch: Throwable -> L8
            r0 = AnrManager.SILENT_ANR_NO_ANR_INFO;
        L6:
            notifyAnrInfo(r6, r0);     // Catch: Throwable -> L8
            return;
        L8:
            notifyAnrInfo(r6, AnrManager.SILENT_ANR_NO_ANR_INFO);
        }

        private void notifyAnrInfo(long r3, String r5) {
            String r0 = AnrInfoMonitor.getAnrInfoFileName(r3, Process.myPid(), true);
            File r1 = new File(AnrInfoMonitor.access$000(this.this$0), r0);
            FileSystemUtils.writeFile(r1, r5);
            AnrManager.onAnrInfoDetected(r3, r1);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L8:
            Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.mQueue.take(), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (r0 != null) goto L4;
            System.out.println("get_anr_info_start_time_null");     // Catch: Throwable -> L7
            goto L8
        L4:
            dumpAnrInfo(r0.longValue());     // Catch: Throwable -> L7
            goto L8
        }

        public void startCheckAnrInfo(long r5) {
            if (GlobalSwitch.isAnrMonitorOpt() == false) goto L5;
            FileSystemUtils.writeFile(new File(AnrInfoMonitor.access$000(this.this$0), AnrInfoMonitor.getAnrInfoFileName(r5, Process.myPid(), true)), AnrManager.SILENT_ANR_NO_ANR_INFO);
        L5:
            this.mQueue.add(Long.valueOf(r5));
        }
    }

    AnrInfoMonitor(Context r3, File r4) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        File r5 = FileSystemUtils.createDirectory(r4, "anr_info");
        this.mDirectory = r5;
        this.mObserver = new InnerObserver(r5.getAbsolutePath());
    }

    static /* synthetic */ File access$000(AnrInfoMonitor r0) {
        return r0.mDirectory;
    }

    static /* synthetic */ Context access$100(AnrInfoMonitor r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$200(AnrInfoMonitor r0) {
        return r0.mStarted;
    }

    private static File findMatchedCrashDirectory(File r17, long r18, final long r20, StringBuffer r22) {
        File[] r3 = r17.listFiles(new AnonymousClass4(r20));
        if (r3 != null) goto L5;
    L54:
        r22.append("processDirs==null");
        return null;
    L5:
        if (r3.length == 0) goto L54;
        int r5 = r3.length;
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L52;
        File r8 = r3[r7];
        if (r8.isDirectory() == true) goto L12;
    L11:
        int r9 = r5;
    L51:
        r7 = r7 + 1;
        r5 = r9;
        r6 = 0;
        goto L8
    L12:
        String[] r10 = r8.getName().split("-");
        if (r10.length != 2) goto L11;
        long r12 = Long.parseLong(r10[r6]);     // Catch: Throwable -> L18
    L20:
        if (r12 != 0) goto L22;
    L50:
        r9 = r5;
        r22.append("startTime:" + r12 + "_" + r18);
        goto L51
    L22:
        if (r12 > r18) goto L50;
        File[] r11 = r8.listFiles();
        if (r11 != null) goto L27;
        r22.append("crashDirs is null ");
        goto L11
    L27:
        int r13 = r11.length;
        int r14 = r6;
    L28:
        if (r14 >= r13) goto L11;
        File r15 = r11[r14];
        if (r15.isDirectory() == true) goto L35;
        String r16 = "crashDirs is not directory ";
    L32:
        r22.append(r16);
    L33:
        r5 = r5;
    L49:
        r14 = r14 + 1;
        r5 = r5;
        goto L28
    L35:
        if (AnrSummary.hasSummaryFile(r15) == true) goto L38;
        r16 = "hasSummaryFile is false ";
        goto L32
    L38:
        if (new File(r15, AnrInfoParser.getFileName()).exists() == false) goto L58;
        r22.append("anrinfo exist:");
        goto L33
    L58:
        long r4 = Long.parseLong(r15.getName());     // Catch: Throwable -> L42
    L44:
        if (r4 != 0) goto L46;
    L48:
        r22.append("last error:" + r4 + "_" + r18);
        goto L49
    L46:
        if (AnrHandler.isSameTask(r4, r18) == false) goto L48;
        return r15;
    L42:
        r4 = 0;
    L18:
        r12 = 0;
        goto L20
    L52:
        return null;
    }

    private File[] findUndetectedAnrInfoFiles() {
        if (this.mDirectory.exists() == true) goto L7;
        return null;
    L7:
        return this.mDirectory.listFiles(new AnonymousClass3(this));
    }

    static String getAnrInfoFileName(long r2, int r4, boolean r5) {
        if (r5 == false) goto L4;
        String r6 = SUFFIX_CURRENT;
    L6:
        return PREFIX + r2 + "_" + r4 + r6;
    L4:
        r6 = SUFFIX_OTHER;
        goto L6
    }

    static long getCrashTimeFromFileName(String r2) {
        String[] r3 = r2.split("_");
        if (r3.length != 4) goto L8;
        return Long.decode(r3[1]).longValue();
    L8:
        return System.currentTimeMillis();
    }

    static int getPidFromFileName(String r2) {
        String[] r3 = r2.split("_");
        if (r3.length == 4) goto L10;
        return 0;
    L10:
        return Integer.decode(r3[2]).intValue();
    L12:
        return 0;
    }

    File findMatchedAnrInfoFile(int r6, long r7) {
        File[] r5 = findUndetectedAnrInfoFiles();
        if (r5 == null) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L18;
        File r2 = r5[r1];
        if (getPidFromFileName(r2.getName()) != r6) goto L11;
        if (AnrHandler.isSameTask(r7, getCrashTimeFromFileName(r2.getName())) == false) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
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
        int r0 = r11.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L22;
        File r2 = r11[r1];
        int r3 = getPidFromFileName(r2.getName());     // Catch: Throwable -> L19
        long r6 = getCrashTimeFromFileName(r2.getName());     // Catch: Throwable -> L19
        if (r3 != 0) goto L11;
    L17:
        r2.delete();     // Catch: Throwable -> L19
        ANRUtils.reportInnerError(new Exception("Invalid ANR Info File Name :{" + r2.getName() + "}"));     // Catch: Throwable -> L19
    L21:
        r1 = r1 + 1;
        goto L6
    L11:
        if (r6 == 0) goto L17;
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L19
        File r5 = findMatchedCrashDirectory(r12, r6, r3, r4);     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        r2.delete();     // Catch: Throwable -> L19
        ANRUtils.reportInnerError(new Exception("Not found matched directory pid:" + r3 + "_" + r2.getName() + "_:reason:" + r4));     // Catch: Throwable -> L19
        goto L21
    L16:
        r2.renameTo(new File(r5, AnrInfoParser.getFileName()));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR", th);
        goto L21
    }

    void registerExternalObserver(final String r7, IFileContentGetter r8) {
        final IFileContentGetter r4 = (IFileContentGetter) ZeusTransformUtils.wrapperContextForParams(r8, IFileContentGetter.class, "com.obric.memorydata.plugin");
        final int r3 = 136;
        new AnonymousClass2(this, r7, r3, r4, r7).startWatching();
    }

    void start() {
        if (this.mStarted == true) goto L9;
        this.mStarted = true;
        this.mObserver.startWatching();
        if (GlobalSwitch.isOpenNewAnrMonitor() == true) goto L7;
        new AnrInfoWriter(this, this.mDirectory).start();
        return;
    L7:
        LightAnrInfoGetThread r0 = new LightAnrInfoGetThread(this);
        this.lightGetAnrInfoThread = r0;
        r0.start();
        return;
    }

    public void startCheckAnrInfo(long r1) {
        this.lightGetAnrInfoThread.startCheckAnrInfo(r1);
    }

    void startFastBootAnrMonitor() {
        if (App.isMainProcess(this.mContext) == true) goto L13;
        return;
    L13:
        File r0 = this.mContext.getExternalFilesDir("fastbot");     // Catch: Exception -> L12
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.exists() == false) goto L16;
        registerExternalObserver(r0.getAbsolutePath(), new AnonymousClass1(this));     // Catch: Exception -> L12
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
