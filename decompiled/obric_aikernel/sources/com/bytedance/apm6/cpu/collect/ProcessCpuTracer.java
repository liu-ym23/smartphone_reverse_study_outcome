package com.bytedance.apm6.cpu.collect;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.bytedance.monitor.collector.k;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ProcessCpuTracer {
    private static final boolean DEBUG = false;
    private static final int[] PROCESS_FULL_STATS_FORMAT = null;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    private static final int[] PROCESS_STATS_FORMAT = null;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    public static final int PROC_CHAR = 2048;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_NEWLINE_TERM = 10;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_QUOTES = 1024;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    private static final String TAG = "ProcessCpuTracker";
    private static final boolean localLOGV = false;
    private int mCpuNumber;
    private boolean mFirst;
    private final long mJiffyMillis;
    private final long[] mProcessFullStatsData;
    private final String[] mProcessFullStatsStringData;
    private final long[] mProcessStatsData;
    private final long[] mSinglePidStatsData;
    private Stats mSt;

    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        public boolean interesting;
        public String name;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        public final int uid;
        public long vsize;
        public boolean working;

        Stats(int r10) {
            this.pid = r10;
            File r11 = new File("/proc", Integer.toString(r10));
            this.uid = getUid(r11.toString());
            this.statFile = new File(r11, "stat").toString();
        }

        private static int getUid(String r10) {
            if (Build.VERSION.SDK_INT >= 21) goto L9;
        L8:
            return -1;
        L9:
            return Os.stat(r10).st_uid;
        L6:
            e = move-exception;
            Log.w(ProcessCpuTracer.TAG, "Failed to stat(" + r10 + "): " + e);
            goto L8
        }
    }

    static {
        PROCESS_STATS_FORMAT = new int[]{32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224};
        PROCESS_FULL_STATS_FORMAT = new int[]{32, 4640, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 8224};
    }

    public ProcessCpuTracer() {
        this.mProcessStatsData = new long[4];
        this.mSinglePidStatsData = new long[4];
        this.mProcessFullStatsStringData = new String[6];
        this.mProcessFullStatsData = new long[6];
        this.mFirst = true;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.mJiffyMillis = 1000 / Os.sysconf(OsConstants._SC_CLK_TCK);
        return;
    L5:
        this.mJiffyMillis = 0;
    }

    private void collectStats(boolean r17) {
        int r10 = Process.myPid();
        Stats r11 = this.mSt;
        if (r11 != null) goto L5;
    L24:
        if (r11 != null) goto L26;
    L30:
        Stats r12 = new Stats(r10);
        this.mSt = r12;
        String[] r13 = this.mProcessFullStatsStringData;
        long[] r14 = this.mProcessFullStatsData;
        r12.base_uptime = SystemClock.uptimeMillis();
        if (k.n().w(this.mSt.statFile.toString(), PROCESS_FULL_STATS_FORMAT, r13, r14, null) == false) goto L33;
        Stats r15 = this.mSt;
        r15.vsize = r14[5];
        r15.interesting = true;
        r15.baseName = r13[0];
        r15.base_minfaults = r14[1];
        r15.base_majfaults = r14[2];
        long r16 = r14[3];
        long r18 = this.mJiffyMillis;
        r15.base_utime = r16 * r18;
        r15.base_stime = r14[4] * r18;
    L34:
        Stats r19 = this.mSt;
        r19.rel_utime = 0;
        r19.rel_stime = 0;
        r19.rel_minfaults = 0;
        r19.rel_majfaults = 0;
        r19.added = true;
        if (r17 == false) goto L37;
        return;
    L37:
        if (r19.interesting == false) goto L43;
        r19.working = true;
        return;
    L43:
        return;
    L33:
        Log.w(TAG, "Skipping unknown process pid " + r10);
        Stats r20 = this.mSt;
        r20.baseName = "<unknown>";
        r20.base_stime = 0;
        r20.base_utime = 0;
        r20.base_majfaults = 0;
        r20.base_minfaults = 0;
        goto L34
    L26:
        if (r11.pid > r10) goto L30;
        r11.rel_utime = 0;
        r11.rel_stime = 0;
        r11.rel_minfaults = 0;
        r11.rel_majfaults = 0;
        r11.removed = true;
        r11.working = true;
        r11.rel_utime = 0;
        r11.rel_stime = 0;
        r11.rel_minfaults = 0;
        r11.rel_majfaults = 0;
        r11.removed = true;
        r11.working = true;
        return;
    L5:
        if (r11.pid != r10) goto L24;
        r11.added = false;
        r11.working = false;
        if (r11.interesting == false) goto L41;
        long r21 = SystemClock.uptimeMillis();
        long[] r110 = this.mProcessStatsData;
        if (k.n().w(this.mSt.statFile.toString(), PROCESS_STATS_FORMAT, null, r110, null) == true) goto L11;
        return;
    L11:
        long r22 = r110[0];
        long r23 = r110[1];
        long r111 = r110[2];
        long r112 = this.mJiffyMillis;
        long r113 = r111 * r112;
        long r24 = r110[3] * r112;
        Stats r25 = this.mSt;
        long r114 = r25.base_utime;
        if (r113 != r114) goto L20;
        if (r24 != r25.base_stime) goto L20;
        r25.rel_utime = 0;
        r25.rel_stime = 0;
        r25.rel_minfaults = 0;
        r25.rel_majfaults = 0;
        if (r25.active == false) goto L40;
        r25.active = false;
        return;
    L40:
        return;
    L20:
        if (r25.active == true) goto L22;
        r25.active = true;
    L22:
        r25.rel_uptime = r21 - r25.base_uptime;
        r25.base_uptime = r21;
        r25.rel_utime = (int) (r113 - r114);
        r25.rel_stime = (int) (r24 - r25.base_stime);
        r25.base_utime = r113;
        r25.base_stime = r24;
        r25.rel_minfaults = (int) (r22 - r25.base_minfaults);
        r25.rel_majfaults = (int) (r23 - r25.base_majfaults);
        r25.base_minfaults = r22;
        r25.base_majfaults = r23;
        r25.working = true;
        return;
    }

    private void printProcessCPU(StringBuffer r18, String r19, int r20, String r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29) {
        r18.append(r19);
        if (r22 != 0) goto L5;
        int r10 = 1;
    L6:
        long r11 = r10;
        printRatio(r18, (((r23 + r24) + r25) + r26) + r27, r11);
        r18.append("% ");
        if (r20 < 0) goto L9;
        r18.append(r20);
        r18.append("/");
    L9:
        r18.append(r21);
        r18.append(": ");
        printRatio(r18, r23, r11);
        r18.append("% user + ");
        printRatio(r18, r24, r11);
        r18.append("% kernel");
        if (r25 <= 0) goto L12;
        r18.append(" + ");
        printRatio(r18, r25, r11);
        r18.append("% iowait");
    L12:
        if (r26 <= 0) goto L14;
        r18.append(" + ");
        printRatio(r18, r26, r11);
        r18.append("% irq");
    L14:
        if (r27 <= 0) goto L16;
        r18.append(" + ");
        printRatio(r18, r27, r11);
        r18.append("% softirq");
    L16:
        if (r28 > 0) goto L18;
        if (r29 > 0) goto L18;
        return;
    L18:
        r18.append(" / faults:");
        if (r28 <= 0) goto L21;
        r18.append(" ");
        r18.append(r28);
        r18.append(" minor");
    L21:
        if (r29 <= 0) goto L25;
        r18.append(" ");
        r18.append(r29);
        r18.append(" major");
        return;
    L25:
        return;
    L5:
        r10 = r22;
        goto L6
    }

    private void printRatio(StringBuffer r10, long r11, long r12) {
        long r13 = (r11 * 1000) / r12;
        long r14 = r13 / 10;
        r10.append(r14);
        if (r14 >= 10) goto L8;
        long r15 = r13 - (r14 * 10);
        if (r15 == 0) goto L9;
        r10.append('.');
        r10.append(r15);
        return;
    L9:
        return;
    }

    public int getMajfaults() {
        Stats r10 = this.mSt;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.rel_majfaults;
    }

    public int getMinfaults() {
        Stats r10 = this.mSt;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.rel_minfaults;
    }

    public float getProcessCpuPercent() {
        if (this.mCpuNumber > 0) goto L7;
        return 0.0f;
    L7:
        return getProcessCpuPercentAllCore() / this.mCpuNumber;
    }

    public float getProcessCpuPercentAllCore() {
        Stats r10 = this.mSt;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        long r11 = r10.rel_utime + r10.rel_stime;
        long r12 = (int) r10.rel_uptime;
        if (r12 > 0) goto L9;
        return 0.0f;
    L9:
        return (float) (((r11 * 1000) / r12) / 10.0d);
    }

    public int getProcessStatStime() {
        Stats r10 = this.mSt;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.rel_stime;
    }

    public int getProcessStatUtime() {
        Stats r10 = this.mSt;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.rel_utime;
    }

    public void init() {
        this.mFirst = true;
        this.mCpuNumber = Runtime.getRuntime().availableProcessors();
        update();
    }

    public String printCurrentState() {
        StringBuffer r13 = new StringBuffer();
        Stats r10 = this.mSt;
        if (r10.added == false) goto L7;
        String r11 = " +";
    L5:
        String r12 = r11;
        printProcessCPU(r13, r12, r10.pid, r10.baseName, (int) r10.rel_uptime, r10.rel_utime, r10.rel_stime, 0, 0, 0, r10.rel_minfaults, r10.rel_majfaults);
        return r13.toString();
    L7:
        if (r10.removed == false) goto L9;
        r11 = " -";
        goto L5
    L9:
        r11 = "  ";
        goto L5
    }

    public void update() {
        if (k.t() == true) goto L11;
        return;
    L11:
        collectStats(this.mFirst);     // Catch: Exception -> L7
    L9:
        this.mFirst = false;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
