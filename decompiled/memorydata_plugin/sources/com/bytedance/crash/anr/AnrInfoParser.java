package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnrInfoParser {
    public static final String ANR_INFO = "anr_info";
    private static final String FILE_NAME = "anr_info.txt";
    private static final String FOOTER = "-----------------------end----------------------------";
    private static final String HEADER = "|------------- processErrorStateInfo--------------|\n";
    private static final String REASON_BROADCAST_OF_INTENT = "Broadcast of Intent";
    private static final String REASON_EXECUTING_SERVICE = "executing service";
    private static final String REASON_INPUT_DISPATCHING_TIMED_OUT = "Input dispatching timed out";
    private static final String REASON_KEY_DISPATCHING_TIMED_OUT = "keyDispatchingTimedOut";
    private static final String REASON_NOT_CALL_FOREGROUND = "not then call Service.startForeground";
    private static final String TAG_CONDITION = "condition: ";
    private static final String TAG_LOAD = "Load: ";
    private static final String TAG_LONG_MSG = "longMsg : ";
    private static final String TAG_PID = "pid: ";
    private static final String TAG_PROCESS_NAME = "processName: ";
    private static final String TAG_SHORT_MSG = "shortMsg : ";
    private static final String TAG_TAG = "tag: ";
    private static final String TAG_UID = "uid: ";
    private static final String UNKNOWN = "unknown";
    private String mAnrProcessName;
    private int mAnrProcessPid;
    CpuUsage mCloserCpuUsage;
    private final String mContent;
    CpuUsage mFirstCpuUsage;
    private final boolean mIsCurrentProcess;
    private final float[] mLoads;
    private int mLongMsgBegin;
    private int mLongMsgEnd;
    private String mReason;
    CpuUsage mSecondCpuUsage;
    private String mShortMsg;
    private String mTag;

    class CpuUsage {
        String mContent;
        ArrayList<Double> mDex2oatTotalRatioList;
        int mFooterBegin;
        int mFooterEnd;
        double mFooterIowait;
        double mFooterIrq;
        double mFooterKernel;
        double mFooterSoftirq;
        double mFooterTotal;
        double mFooterUser;
        boolean mHeaderAgo;
        int mHeaderBegin;
        int mHeaderEnd;
        long mHeaderFromMs;
        String mHeaderFromTime;
        long mHeaderToMs;
        String mHeaderToTime;
        double mKswapdTotalRatio;
        double mKworkTotalRatio;
        double mLmkdTotalRatio;
        double mMmcqdTotalRatio;
        ArrayList<ProcessCpuUsage> mProcessList;
        double mSystemServerTotalRatio;
        boolean mValid;
        final /* synthetic */ AnrInfoParser this$0;

        CpuUsage(AnrInfoParser r2, String r3, int[] r4) {
            this.this$0 = r2;
            this.mProcessList = new ArrayList();
            this.mDex2oatTotalRatioList = new ArrayList();
            this.mContent = r3;
            boolean r5 = false;
            this.mHeaderBegin = r4[0];
            this.mHeaderEnd = r4[1];
            this.mFooterBegin = r4[2];
            this.mFooterEnd = r4[3];
            if (parseHeaderLine() == true) goto L5;
        L7:
            this.mValid = r5;
            return;
        L5:
            if (parseFooterLine() == false) goto L7;
            r5 = true;
            goto L7
        }

        ProcessCpuUsage getAnrProcess() {
            Iterator<ProcessCpuUsage> r0 = this.mProcessList.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            ProcessCpuUsage r1 = (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(r0.next(), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
            if (r1.mPid != AnrInfoParser.access$000(this.this$0)) goto L4;
            return r1;
        L8:
            return null;
        }

        long getAnrTime() {
            long r0 = 0;
            long r1 = DateUtils.parseDateMs(this.mHeaderFromTime);     // Catch: Throwable -> L9
            if (this.mHeaderAgo == false) goto L7;
            r0 = r1 + this.mHeaderFromMs;     // Catch: Throwable -> L9
        L10:
            goto L8
        L7:
            r0 = r1 - this.mHeaderFromMs;
        L8:
            return r0;
        }

        JSONObject getProcessList() {
            JSONObject r0 = new JSONObject();
            Iterator<ProcessCpuUsage> r6 = this.mProcessList.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ProcessCpuUsage r1 = (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(r6.next(), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
            JSONUtils.put(r0, String.valueOf(r1.mPid), JSONUtils.put(JSONUtils.put(new JSONObject(), "process_name", r1.mProcessName), "cpu", Double.valueOf(r1.mTotalRatio)));
            goto L4
        L6:
            return r0;
        }

        ProcessCpuUsage getTopProcess() {
            if (this.mProcessList.size() != 0) goto L7;
            return null;
        L7:
            return (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(this.mProcessList.get(0), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
        }

        void parseAllProcessLine() {
            int r0 = this.mHeaderEnd + 1;
        L4:
            if (r0 >= this.mFooterBegin) goto L20;
            int r1 = this.mContent.indexOf("\n", r0);
            if (r1 < 0) goto L32;
            if ((r1 - r0) > 4) goto L10;
        L11:
            ProcessCpuUsage r2 = null;
            r2 = parseOneProcessLine(this.mContent, r0, r1);     // Catch: Throwable -> L21
        L13:
            if (r2 == null) goto L4;
            if (r2.mTotalRatio < 1.0d) goto L33;
            this.mProcessList.add(r2);
        L19:
            r0 = r1 + 1;
            goto L4
        L33:
            return;
        L10:
            if (this.mContent.charAt(r0 + 2) == ' ') goto L19;
        L32:
            return;
        }

        boolean parseFooterLine() {
            LineParser r1 = new LineParser(this.mContent.substring(this.mFooterBegin, this.mFooterEnd));
            String r0 = r1.parse(null, "% TOTAL:");
            if (r0 != null) goto L5;
            return false;
        L5:
            String r4 = r1.parse(" ", "% user");
            if (r4 == null) goto L8;
            r1.incPos(2);
        L8:
            String r6 = r1.parse(" ", "% kernel");
            if (r6 == null) goto L11;
            r1.incPos(2);
        L11:
            String r7 = r1.parse(" ", "% iowait");
            if (r7 == null) goto L14;
            r1.incPos(2);
        L14:
            String r8 = r1.parse(" ", "% irq");
            if (r8 == null) goto L17;
            r1.incPos(2);
        L17:
            String r3 = r1.parse(" ", "% softirq");
            if (r3 != null) goto L44;
            r1.incPos(2);
        L44:
            this.mFooterTotal = Double.parseDouble(r0);     // Catch: Throwable -> L43
            double r2 = 0.0d;
            if (r4 != null) goto L23;
            double r5 = 0.0d;
        L24:
            this.mFooterUser = r5;     // Catch: Throwable -> L43
            if (r6 != null) goto L27;
            double r9 = 0.0d;
        L28:
            this.mFooterKernel = r9;     // Catch: Throwable -> L43
            if (r7 != null) goto L31;
            double r10 = 0.0d;
        L32:
            this.mFooterIowait = r10;     // Catch: Throwable -> L43
            if (r8 != null) goto L35;
            double r11 = 0.0d;
        L36:
            this.mFooterIrq = r11;     // Catch: Throwable -> L43
            if (r3 == null) goto L40;
            r2 = Double.parseDouble(r3);     // Catch: Throwable -> L43
        L40:
            this.mFooterSoftirq = r2;     // Catch: Throwable -> L43
            return true;
        L35:
            r11 = Double.parseDouble(r8);     // Catch: Throwable -> L43
            goto L36
        L31:
            r10 = Double.parseDouble(r7);     // Catch: Throwable -> L43
            goto L32
        L27:
            r9 = Double.parseDouble(r6);     // Catch: Throwable -> L43
            goto L28
        L23:
            r5 = Double.parseDouble(r4);     // Catch: Throwable -> L43
        L43:
            return false;
        }

        boolean parseHeaderLine() {
            LineParser r1 = new LineParser(this.mContent.substring(this.mHeaderBegin, this.mHeaderEnd));
            String r0 = r1.parse("CPU usage from ", "ms");
            if (r0 != null) goto L5;
            return false;
        L5:
            String r2 = r1.parse(" to ", "ms");
            if (r2 != null) goto L8;
            return false;
        L8:
            String r4 = r1.parse(" ", " ");
            if (r4 != null) goto L11;
            return false;
        L11:
            String r5 = r1.parse("(", " t");
            if (r5 != null) goto L14;
            return false;
        L14:
            String r3 = r1.parse("o ", ")");
            if (r3 != null) goto L21;
            return false;
        L21:
            this.mHeaderFromMs = Long.parseLong(r0);     // Catch: Throwable -> L20
            this.mHeaderToMs = Long.parseLong(r2);     // Catch: Throwable -> L20
            this.mHeaderAgo = "ago".equals(r4);     // Catch: Throwable -> L20
            this.mHeaderFromTime = r5;     // Catch: Throwable -> L20
            this.mHeaderToTime = r3;     // Catch: Throwable -> L20
            return true;
        L20:
            return false;
        }

        ProcessCpuUsage parseOneProcessLine(String r6, int r7, int r8) {
            int r9 = r7 + 2;
            int r0 = r6.indexOf(37, r9);
            ProcessCpuUsage r1 = null;
            if (r0 < 0) goto L36;
            if (r0 > r8) goto L36;
            double r2 = Double.parseDouble(r6.substring(r9, r0));
            int r3 = r0 + 2;
            int r10 = r6.indexOf(47, r3);
            if (r10 < 0) goto L36;
            if (r10 > r8) goto L36;
            int r4 = Integer.parseInt(r6.substring(r3, r10));
            int r11 = r10 + 1;
            int r5 = r6.indexOf(": ", r11);
            if (r5 < 0) goto L36;
            if (r5 > r8) goto L36;
            r1 = new ProcessCpuUsage(r4, r6.substring(r11, r5), r2);
            if (r4 != AnrInfoParser.access$000(this.this$0)) goto L36;
            int r12 = r5 + 2;
            int r13 = r6.indexOf("% user + ", r12);
            if (r13 < 0) goto L36;
            if (r13 > r8) goto L36;
            r1.mUserRatio = Double.parseDouble(r6.substring(r12, r13));
            int r14 = r13 + 9;
            int r15 = r6.indexOf("% kernel", r14);
            if (r15 < 0) goto L36;
            if (r15 > r8) goto L36;
            r1.mKernelRatio = Double.parseDouble(r6.substring(r14, r15));
            int r16 = r6.indexOf("faults: ", r15);
            if (r16 < 0) goto L36;
            if (r16 > r8) goto L36;
            int r17 = r16 + 8;
            int r18 = r6.indexOf(" minor", r17);
            if (r18 <= 0) goto L32;
            if (r18 >= r8) goto L32;
            r1.mMinor = Long.parseLong(r6.substring(r17, r18));
            r17 = r18 + 7;
        L32:
            int r19 = r6.indexOf(" major", r17);
            if (r19 <= 0) goto L36;
            if (r19 >= r8) goto L36;
            r1.mMajor = Long.parseLong(r6.substring(r17, r19));
        L36:
            return r1;
        }

        void parseSpecialProcess() {
            Iterator<ProcessCpuUsage> r0 = this.mProcessList.iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            ProcessCpuUsage r1 = (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(r0.next(), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
            String r2 = r1.mProcessName;
            double r3 = r1.mTotalRatio;
            if (r2.contains("kworker") == true) goto L7;
            if (r2.contains("kswapd") == true) goto L10;
            if (r2.contains("mmcqd") == true) goto L13;
            if (r2.contains("system_server") == true) goto L16;
            if (r2.contains("lmkd") == true) goto L19;
            if (r2.contains("dex2oat") == false) goto L4;
            this.mDex2oatTotalRatioList.add(Double.valueOf(r3));
            goto L4
        L19:
            this.mLmkdTotalRatio += r3;
            goto L4
        L16:
            this.mSystemServerTotalRatio += r3;
            goto L4
        L13:
            this.mMmcqdTotalRatio += r3;
            goto L4
        L10:
            this.mKswapdTotalRatio += r3;
            goto L4
        L7:
            this.mKworkTotalRatio += r3;
            goto L4
        }

        void putFooterToAttribute(JSONObject r5, boolean r6) {
            if (r6 == false) goto L4;
            String r0 = "user";
        L37:
            r5.put(r0, this.mFooterUser);     // Catch: Throwable -> L36
            if (r6 == false) goto L8;
            String r1 = NotificationCompat.CATEGORY_SYSTEM;
        L9:
            r5.put(r1, this.mFooterKernel);     // Catch: Throwable -> L36
            if (r6 == false) goto L12;
            String r2 = "iowait";
        L13:
            r5.put(r2, this.mFooterIowait);     // Catch: Throwable -> L36
            if (r6 == false) goto L16;
            String r3 = "irq";
        L17:
            r5.put(r3, this.mFooterIrq);     // Catch: Throwable -> L36
            if (r6 == false) goto L20;
            String r4 = "softirq";
        L21:
            r5.put(r4, this.mFooterSoftirq);     // Catch: Throwable -> L36
            ProcessCpuUsage r7 = getAnrProcess();     // Catch: Throwable -> L36
            if (r7 == null) goto L31;
            if (r6 == false) goto L25;
            String r8 = "minor";
        L26:
            r5.put(r8, r7.mMinor);     // Catch: Throwable -> L36
            if (r6 == false) goto L29;
            String r9 = "major";
        L30:
            r5.put(r9, r7.mMajor);     // Catch: Throwable -> L36
            goto L31
        L29:
            r9 = "major2";
            goto L30
        L25:
            r8 = "minor2";
        L31:
            if (r6 == false) goto L33;
            String r10 = "before_cpu_list";
        L34:
            r5.put(r10, getProcessList());     // Catch: Throwable -> L36
            return;
        L33:
            r10 = "after_cpu_list";
            goto L34
        L20:
            r4 = "softirq2";
            goto L21
        L16:
            r3 = "irq2";
            goto L17
        L12:
            r2 = "iowait2";
            goto L13
        L8:
            r1 = "sys2";
        L39:
            return;
        L4:
            r0 = "user2";
            goto L37
        }

        void putSpecialProcessToAttribute(JSONObject r5) {
            r5.put("kswapd", this.mKswapdTotalRatio);     // Catch: Throwable -> L10
            r5.put("mmcqd", this.mMmcqdTotalRatio);     // Catch: Throwable -> L10
            r5.put("kwork", this.mKworkTotalRatio);     // Catch: Throwable -> L10
            r5.put("system_server", this.mSystemServerTotalRatio);     // Catch: Throwable -> L10
            r5.put("lmkd", this.mLmkdTotalRatio);     // Catch: Throwable -> L10
            if (this.mDex2oatTotalRatioList.isEmpty() == true) goto L14;
            JSONArray r0 = new JSONArray();     // Catch: Throwable -> L10
            Iterator<Double> r4 = this.mDex2oatTotalRatioList.iterator();     // Catch: Throwable -> L10
        L6:
            if (r4.hasNext() == false) goto L8;
            r0.put((Double) ZeusTransformUtils.preCheckCast(r4.next(), Double.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
            goto L6
        L8:
            r5.put("dex2oat", r0);     // Catch: Throwable -> L10
            return;
        L14:
            return;
        }

        void putToFeature(JSONObject r6, JSONObject r7) {
            JSONUtils.put(r6, "cpu_total", Double.valueOf(this.mFooterTotal));
            JSONUtils.put(r6, "cpu_user", Double.valueOf(this.mFooterUser));
            JSONUtils.put(r6, "cpu_kernel", Double.valueOf(this.mFooterKernel));
            JSONUtils.put(r6, "cpu_iowait", Double.valueOf(this.mFooterIowait));
            JSONUtils.put(r6, "cpu_irq", Double.valueOf(this.mFooterIrq));
            JSONUtils.put(r6, "cpu_softirq", Double.valueOf(this.mFooterSoftirq));
            ProcessCpuUsage r0 = getTopProcess();
            if (r0 == null) goto L5;
            JSONUtils.put(r7, "top_cpu_process_name", r0.mProcessName);
        L5:
            ProcessCpuUsage r8 = getAnrProcess();
            if (r8 == null) goto L15;
            JSONUtils.put(r6, "cpu_app_total", Double.valueOf(r8.mTotalRatio));
            JSONUtils.put(r6, "cpu_app_user", Double.valueOf(r8.mUserRatio));
            JSONUtils.put(r6, "cpu_app_kernel", Double.valueOf(r8.mKernelRatio));
            JSONUtils.put(r6, "minor_rate", Long.valueOf(r8.mMinor));
            JSONUtils.put(r6, "major_rate", Long.valueOf(r8.mMajor));
        L15:
            r6.put("cpu_kswapd", this.mKswapdTotalRatio);     // Catch: Throwable -> L14
            r6.put("cpu_mmcqd", this.mMmcqdTotalRatio);     // Catch: Throwable -> L14
            r6.put("cpu_kwork", this.mKworkTotalRatio);     // Catch: Throwable -> L14
            r6.put("cpu_system_server", this.mSystemServerTotalRatio);     // Catch: Throwable -> L14
            r6.put("cpu_lmkd", this.mLmkdTotalRatio);     // Catch: Throwable -> L14
            float r9 = 0.0f;
            Iterator<Double> r5 = this.mDex2oatTotalRatioList.iterator();     // Catch: Throwable -> L14
        L10:
            if (r5.hasNext() == false) goto L12;
            r9 = (float) (((double) r9) + ((Double) ZeusTransformUtils.preCheckCast(r5.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r6.put("cpu_dex2oat", r9);     // Catch: Throwable -> L14
            return;
        }
    }

    static class LineParser {
        String mLine;
        int mPos;

        LineParser(String r1) {
            this.mLine = r1;
            this.mPos = 0;
        }

        int getPos() {
            return this.mPos;
        }

        void incPos(int r2) {
            this.mPos += r2;
        }

        String parse(String r4, String r5) {
            int r0 = this.mPos;
            if (r4 == null) goto L8;
            int r2 = this.mLine.indexOf(r4, r0);
            if (r2 >= 0) goto L7;
            return null;
        L7:
            this.mPos = r2 + r4.length();
        L8:
            String r6 = this.mLine;
            if (r5 == null) goto L15;
            int r7 = r6.indexOf(r5, this.mPos);
            if (r7 >= 0) goto L14;
            this.mPos = r0;
            return null;
        L14:
            String r1 = this.mLine.substring(this.mPos, r7);
            int r8 = r7 + r5.length();
        L16:
            this.mPos = r8;
            return r1;
        L15:
            r1 = r6.substring(this.mPos);
            r8 = this.mLine.length() - 1;
            goto L16
        }

        void setPos(int r1) {
            this.mPos = r1;
        }
    }

    static class ProcessCpuUsage {
        double mKernelRatio;
        long mMajor;
        long mMinor;
        int mPid;
        String mProcessName;
        double mTotalRatio;
        double mUserRatio;

        ProcessCpuUsage(int r1, String r2, double r3) {
            this.mPid = r1;
            this.mProcessName = r2;
            this.mTotalRatio = r3;
        }
    }

    public AnrInfoParser(File r5) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        String r0 = FileSystemUtils.readUtf8File(new File(r5, FILE_NAME));
        if (r0 != null) goto L5;
    L18:
        this.mContent = r0;
        this.mIsCurrentProcess = !new File(r5, AnrInfoMonitor.ANR_FROM_EXTERNAL).exists();
        return;
    L5:
        if (r0.isEmpty() == true) goto L18;
        if (r0.equals(AnrManager.SILENT_ANR_NO_ANR_INFO) == false) goto L11;
        String r1 = Constants.SILENT_ANR;
    L9:
        this.mReason = r1;
        this.mTag = getTagFromShortMsg();
        goto L18
    L11:
        if (r0.equals(AnrManager.CLOSE_ANR_INFO) == false) goto L13;
        r1 = "Not report anrInfo";
        goto L9
    L13:
        int r2 = parseAnrInfoContent(r0);
        if (r2 >= 0) goto L16;
        NpthLog.e("NPTH", "Anr Info Parse Error:" + r2);
    L16:
        r1 = getAnrReasonFromShortMessage();
        goto L9
    }

    public AnrInfoParser(String r2) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        this.mContent = r2;
        this.mIsCurrentProcess = false;
        parseAnrInfoContent(r2);
    }

    static /* synthetic */ int access$000(AnrInfoParser r0) {
        return r0.mAnrProcessPid;
    }

    private static String cpuRange(float r10) {
        if (r10 >= 0.0f) goto L7;
        return "invalid";
    L7:
        if (r10 <= 100.0f) goto L11;
        return "> 100";
    L11:
        return new String[]{"0~10", "10~20", "20~30", "30~40", "40~50", "50~60", "60~70", "70~80", "80~90", "90~100"}[((int) r10) / 10];
    }

    private static boolean equalString(String r0, String r1) {
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return r0.equals(r1);
    L5:
        if (r0 != null) goto L8;
        if (r1 != null) goto L8;
        return true;
    L8:
        return false;
    }

    private static String faultsPageRange(float r21) {
        if (r21 >= 0.0f) goto L6;
        return "invalid";
    L6:
        float[] r1 = {2000.0f, 3000.0f, 4000.0f, 5000.0f, 10000.0f, 20000.0f, 30000.0f, 40000.0f, 50000.0f, 60000.0f, 70000.0f, 80000.0f, 90000.0f, 100000.0f, 150000.0f, 200000.0f, 300000.0f, 400000.0f, 500000.0f};
        String[] r2 = {"0~2k", "2k~3k", "3k~4k", "4k~5k", "5k~1w", "1w~2w", "2w~3w", "3w~4w", "4w~5w", "5w~6w", "7w~8w", "8w~9w", "9w~10w", "10w~15w", "15w~20w", "20w~30w", "30w~40w", "40w~50w", "> 50w"};
        int r3 = 0;
    L7:
        if (r3 >= 19) goto L14;
        if (r21 <= r1[r3]) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        return r2[r3];
    L14:
        return r2[18];
    }

    static String format(ActivityManager.ProcessErrorStateInfo r3) {
        return HEADER + TAG_CONDITION + r3.condition + "\n" + TAG_PROCESS_NAME + r3.processName + "\n" + TAG_PID + r3.pid + "\n" + TAG_UID + r3.uid + "\n" + TAG_TAG + r3.tag + "\n" + TAG_SHORT_MSG + r3.shortMsg + "\n" + TAG_LONG_MSG + r3.longMsg + "\n" + FOOTER;
    }

    private String getAnrReasonFromShortMessage() {
        if (TextUtils.isEmpty(this.mShortMsg) == false) goto L5;
        return "unknown";
    L5:
        if ("null".equals(this.mShortMsg) == false) goto L8;
        return "unknown";
    L8:
        if (this.mShortMsg.startsWith("ANR ") == false) goto L28;
        if (this.mShortMsg.startsWith(REASON_INPUT_DISPATCHING_TIMED_OUT, 4) == false) goto L14;
        return getInputANRReason(this.mShortMsg);
    L14:
        if (this.mShortMsg.startsWith(REASON_EXECUTING_SERVICE, 4) == false) goto L17;
        return REASON_EXECUTING_SERVICE;
    L17:
        if (this.mShortMsg.startsWith(REASON_BROADCAST_OF_INTENT, 4) == false) goto L20;
        return REASON_BROADCAST_OF_INTENT;
    L20:
        if (this.mShortMsg.startsWith(REASON_KEY_DISPATCHING_TIMED_OUT, 4) == false) goto L23;
        return REASON_KEY_DISPATCHING_TIMED_OUT;
    L23:
        if (this.mShortMsg.contains(REASON_NOT_CALL_FOREGROUND) == false) goto L26;
        return REASON_NOT_CALL_FOREGROUND;
    L26:
        return replaceNumbersWithX(this.mShortMsg.substring(4));
    L28:
        return this.mShortMsg;
    }

    private static int[] getCpuUsageLinePos(String r5, int r6) {
        int[] r0 = new int[4];
    L3:
        int r1 = r5.indexOf("\n", r6);
        if (r1 < 0) goto L16;
        if (r5.startsWith("CPU usage from", r6) == true) goto L7;
        r6 = r1 + 1;
        goto L3
    L7:
        r0[0] = r6;
        r0[1] = r1;
        int r2 = r5.indexOf("% TOTAL: ", r1 + 1);
        if (r2 <= 0) goto L14;
        int r4 = r5.lastIndexOf(10, r2) + 1;
        int r7 = r5.indexOf(10, r2);
        if (r4 <= 0) goto L14;
        if (r7 <= 0) goto L14;
        r0[2] = r4;
        r0[3] = r7;
        return r0;
    L14:
        return null;
    L16:
        return null;
    }

    static String getFileName() {
        return FILE_NAME;
    }

    private static String getInputANRReason(String r1) {
        if (r1.contains("Waiting to send non-key event") == false) goto L9;
        if (r1.contains("finished processing certain input events that were delivered") == false) goto L9;
        return "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)";
    L9:
        if (r1.contains("Application does not have a focused window") == false) goto L13;
        return "Input dispatching timed out (Application does not have a focused window)";
    L13:
        if (r1.contains("Waiting because no window has focus but there is a focused") == false) goto L17;
        return "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)";
    L17:
        if (r1.contains("window's input channel is full.") == false) goto L20;
        return "Input dispatching timed out (Waiting because the touched window input channel is full.Outbound queue length: XXX.Wait queue length: XX.)";
    L20:
        return REASON_INPUT_DISPATCHING_TIMED_OUT;
    }

    private String getTagFromShortMsg() {
        if (TextUtils.isEmpty(this.mTag) == true) goto L9;
        if ("null".equals(this.mTag) == true) goto L9;
        return this.mTag;
    L9:
        if (TextUtils.isEmpty(this.mShortMsg) == false) goto L11;
        return "unknown";
    L11:
        if ("null".equals(this.mShortMsg) == false) goto L14;
        return "unknown";
    L14:
        if (this.mShortMsg.contains(REASON_EXECUTING_SERVICE) == false) goto L20;
        String r5 = this.mShortMsg;
        String r6 = r5.substring(r5.indexOf("service ") + 8).trim();
        String[] r0 = r6.split("/");
        if (r0.length <= 1) goto L25;
        r6 = r0[r0.length - 1];
    L25:
        return r6;
    L20:
        if (this.mShortMsg.contains(REASON_BROADCAST_OF_INTENT) == false) goto L26;
        String r1 = this.mShortMsg;
        r6 = r1.substring(r1.indexOf("{") + 1, this.mShortMsg.indexOf("}")).trim();
        String[] r2 = r6.split("/");
        if (r2.length <= 1) goto L25;
        r6 = r2[r2.length - 1];
        goto L25
    L26:
        return "unknown";
    }

    static boolean isSameProcessErrorStateInfo(ActivityManager.ProcessErrorStateInfo r2, ActivityManager.ProcessErrorStateInfo r3) {
        if (r2.condition == r3.condition) goto L5;
    L17:
        return false;
    L5:
        if (r2.pid != r3.pid) goto L17;
        if (r2.uid != r3.uid) goto L17;
        if (equalString(r2.processName, r3.processName) == false) goto L17;
        if (equalString(r2.tag, r3.tag) == false) goto L17;
        if (equalString(r2.shortMsg, r3.shortMsg) == false) goto L17;
        if (equalString(r2.longMsg, r3.longMsg) == false) goto L17;
        return true;
    }

    public static String parseAnrInfoHideOthersApp(String r9, String r10) {
        if (TextUtils.isEmpty(r9) == false) goto L23;
        return "";
    L23:
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L22
        String[] r2 = r9.split("\n");     // Catch: Throwable -> L22
        int r3 = r2.length;     // Catch: Throwable -> L22
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L20;
        String r5 = r2[r4];     // Catch: Throwable -> L22
        int r6 = r5.indexOf(47);     // Catch: Throwable -> L22
        int r7 = r5.indexOf(": ");     // Catch: Throwable -> L22
        if (r6 == (-1)) goto L19;
        if (r7 == (-1)) goto L19;
        if (r6 >= r7) goto L19;
        String r8 = r5.substring(r6, r7);     // Catch: Throwable -> L22
        if (r8.contains(r10) == true) goto L19;
        if (r8.contains("com.") == false) goto L17;
    L18:
        r5 = r5.replace(r8, "/*.*.*");     // Catch: Throwable -> L22
        goto L19
    L17:
        if (r8.contains(".google") == true) goto L18;
    L19:
        r1.append(r5).append("\n");     // Catch: Throwable -> L22
        r4 = r4 + 1;     // Catch: Throwable -> L22
        goto L7
    L20:
        return r1.toString();
    L32:
        return r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.crash.anr.AnrInfoParser$CpuUsage] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.crash.anr.AnrInfoParser$CpuUsage] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.crash.anr.AnrInfoParser$CpuUsage] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.crash.anr.AnrInfoParser] */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void pushAttribute(JSONObject r5) {
        ?? r6 = JSONUtils.get(r5, "anr_atribute");
        ?? r0 = new JSONObject();
        putLoadsToJObject(r0);     // Catch: Throwable -> L16
        ?? r1 = this.mFirstCpuUsage;     // Catch: Throwable -> L16
        if (r1 == 0) goto L6;
        r1.putFooterToAttribute(r0, true);     // Catch: Throwable -> L16
    L6:
        ?? r2 = this.mSecondCpuUsage;     // Catch: Throwable -> L16
        if (r2 == 0) goto L9;
        r2.putFooterToAttribute(r0, false);     // Catch: Throwable -> L16
    L9:
        ?? r3 = -1;
        r3 = -1;
        ?? r4 = this.mCloserCpuUsage;     // Catch: Throwable -> L16
        if (r4 == 0) goto L14;
        r4.putSpecialProcessToAttribute(r0);     // Catch: Throwable -> L16
        ProcessCpuUsage r7 = this.mCloserCpuUsage.getTopProcess();     // Catch: Throwable -> L16
        if (r7 == null) goto L14;
        r0.put("top_cpu_process_name", r7.mProcessName);     // Catch: Throwable -> L16
        r3 = this.mAnrProcessName.equals(r7.mProcessName);     // Catch: Throwable -> L16
    L14:
        r0.put("top_cpu_process_is_anrapp", r3);     // Catch: Throwable -> L16
        r0.put("process_name", this.mAnrProcessName);     // Catch: Throwable -> L16
        r6.put("cpu", r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        NpthLog.i(th);
    }

    public static String replaceNumbersWithX(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.replaceAll("\\d+", "xxx");
    L10:
        return r2;
    }

    private static Float safeFloat(String r0) {
        return Float.valueOf(r0);
    L5:
        return Float.valueOf(-1.0f);
    }

    ProcessCpuUsage getAnrProcessInfo(CpuUsage r4) {
        Iterator<ProcessCpuUsage> r5 = r4.mProcessList.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        ProcessCpuUsage r0 = (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(r5.next(), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
        if (r0.mPid != this.mAnrProcessPid) goto L4;
        return r0;
    L8:
        return null;
    }

    int getAnrProcessPid() {
        return this.mAnrProcessPid;
    }

    long getAnrTime() {
        CpuUsage r2 = this.mCloserCpuUsage;
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.getAnrTime();
    }

    String getContent() {
        return this.mContent;
    }

    String getInputTimeoutReason() {
        String r0 = this.mReason;
        if (r0 != null) goto L5;
        return "invalid";
    L5:
        if (r0.equals(REASON_INPUT_DISPATCHING_TIMED_OUT) == false) goto L43;
        String r2 = this.mShortMsg.toLowerCase();
        if (r2.contains("no window has focus but there is a focused application") == false) goto L9;
        return "no focused window";
    L9:
        if (r2.contains("does not have a focused window") == false) goto L12;
        return "no focused window";
    L12:
        if (r2.contains("waiting to send non-key event because the touched window has not finished") == false) goto L16;
        return "non-key event not finished";
    L16:
        if (r2.contains("waiting to send key event because the focused window has not finished") == false) goto L20;
        return "key event not finished";
    L20:
        if (r2.contains("window is paused") == false) goto L23;
        return "window is paused";
    L23:
        if (r2.contains("window’s input channel is not registered") == false) goto L27;
        return "input channel not registered";
    L27:
        if (r2.contains("window’s input connection is") == false) goto L31;
        return "window being removed";
    L31:
        if (r2.contains("window’s input channel is full") == false) goto L35;
        return "input channel is full";
    L35:
        if (r2.contains("is not responding. waited") == false) goto L44;
        return "activity is not responding";
    L44:
        return "invalid";
    L43:
        return "invalid";
    }

    ProcessCpuUsage getTopProcessInfo(CpuUsage r2) {
        if (r2.mProcessList.size() != 0) goto L7;
        return null;
    L7:
        return (ProcessCpuUsage) ZeusTransformUtils.preCheckCast(r2.mProcessList.get(0), ProcessCpuUsage.class, "com.obric.memorydata.plugin");
    }

    boolean isValid() {
        return !TextUtils.isEmpty(this.mContent);
    }

    int parseAnrInfoContent(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return -1;
    L5:
        if (r9.startsWith(HEADER) == true) goto L7;
        return -1;
    L7:
        if (r9.endsWith(FOOTER) == false) goto L102;
        LineParser r1 = new LineParser(r9);     // Catch: Throwable -> L83
        r1.setPos(52);     // Catch: Throwable -> L83
        if (r1.parse(TAG_CONDITION, "\n") != null) goto L13;
        return -2;
    L13:
        String r2 = r1.parse(TAG_PROCESS_NAME, "\n");     // Catch: Throwable -> L83
        if (r2 != null) goto L17;
        return -3;
    L17:
        this.mAnrProcessName = r2;     // Catch: Throwable -> L83
        String r3 = r1.parse(TAG_PID, "\n");     // Catch: Throwable -> L83
        if (r3 != null) goto L88;
        return -4;
    L88:
        this.mAnrProcessPid = Integer.parseInt(r3);     // Catch: Throwable -> L81
        if (r1.parse(TAG_UID, "\n") != null) goto L26;
        return -6;
    L26:
        String r4 = r1.parse(TAG_TAG, "\n");     // Catch: Throwable -> L83
        if (r4 != null) goto L30;
        return -7;
    L30:
        this.mTag = r4;     // Catch: Throwable -> L83
        int r5 = r9.indexOf(TAG_SHORT_MSG, r1.getPos());     // Catch: Throwable -> L83
        if (r5 >= 0) goto L34;
        return -8;
    L34:
        int r6 = r5 + 11;     // Catch: Throwable -> L83
        int r7 = r9.indexOf(10, r6);     // Catch: Throwable -> L83
        if (r7 >= 0) goto L38;
        return -9;
    L38:
        int r8 = r9.indexOf(TAG_LONG_MSG, r7);     // Catch: Throwable -> L83
        if (r8 >= 0) goto L42;
        return -10;
    L42:
        this.mLongMsgBegin = r8 + 10;     // Catch: Throwable -> L83
        this.mShortMsg = r9.substring(r6, r8 - 1);     // Catch: Throwable -> L83
        int r10 = r9.length() - 54;     // Catch: Throwable -> L83
        this.mLongMsgEnd = r10;     // Catch: Throwable -> L83
        if (r10 == 0) goto L71;
        int r11 = this.mLongMsgBegin;     // Catch: Throwable -> L83
    L46:
        if (r11 >= this.mLongMsgEnd) goto L61;
        int r12 = r9.indexOf("\n", r11);     // Catch: Throwable -> L83
        if (r12 < 0) goto L61;
        int[] r13 = getCpuUsageLinePos(r9, r11);     // Catch: Throwable -> L83
        if (r13 != null) goto L51;
        r11 = r12 + 1;     // Catch: Throwable -> L83
        goto L46
    L51:
        CpuUsage r14 = new CpuUsage(this, r9, r13);     // Catch: Throwable -> L83
        if (r14.mValid == true) goto L54;
    L59:
        r11 = r13[3] + 1;     // Catch: Throwable -> L83
        goto L46
    L54:
        if (this.mFirstCpuUsage != null) goto L57;
        this.mFirstCpuUsage = r14;     // Catch: Throwable -> L83
        r14.parseAllProcessLine();     // Catch: Throwable -> L83
        goto L59
    L57:
        if (this.mSecondCpuUsage != null) goto L59;
        this.mSecondCpuUsage = r14;     // Catch: Throwable -> L83
        r14.parseAllProcessLine();     // Catch: Throwable -> L83
    L61:
        CpuUsage r15 = this.mFirstCpuUsage;     // Catch: Throwable -> L83
        this.mCloserCpuUsage = r15;     // Catch: Throwable -> L83
        if (this.mSecondCpuUsage != null) goto L64;
    L68:
        CpuUsage r16 = this.mCloserCpuUsage;     // Catch: Throwable -> L83
        if (r16 == null) goto L71;
        r16.parseSpecialProcess();     // Catch: Throwable -> L83
        goto L71
    L64:
        if (r15.mHeaderAgo == false) goto L68;
        if (Math.abs(this.mCloserCpuUsage.mHeaderFromMs + this.mCloserCpuUsage.mHeaderToMs) <= Math.abs(this.mSecondCpuUsage.mHeaderFromMs + this.mSecondCpuUsage.mHeaderToMs)) goto L68;
        this.mCloserCpuUsage = this.mSecondCpuUsage;     // Catch: Throwable -> L83
    L71:
        String r17 = r1.parse(TAG_LOAD, "\n");     // Catch: Throwable -> L83
        if (r17 == null) goto L80;
        String[] r18 = r17.split("/");     // Catch: Throwable -> L83
        if (this.mLoads.length != r18.length) goto L80;
        int r19 = 0;
    L76:
        if (r19 >= r18.length) goto L80;
        this.mLoads[r19] = safeFloat(r18[r19].trim()).floatValue();     // Catch: Throwable -> L83
        r19 = r19 + 1;
    L80:
        return 0;
    L81:
        return -5;
    L83:
        th = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR", th);
        return -11;
    L102:
        return -1;
    }

    public void pushFeature(JSONObject r11) {
        JSONObject r0 = JSONUtils.get(r11, "features_str");
        JSONObject r1 = JSONUtils.get(r11, "features_num");
        CpuUsage r10 = this.mCloserCpuUsage;
        if (r10 == null) goto L5;
        r10.putToFeature(r1, r0);
    L5:
        JSONObject r12 = r11.optJSONObject("app_memory_info");
        if (r12 == null) goto L10;
        long r2 = r12.optLong("max_memory");
        long r4 = r12.optLong("free_memory");
        long r6 = r12.optLong("total_memory");
        if (r2 <= 0) goto L10;
        JSONUtils.put(r1, "java_heap_usage", Long.valueOf(((r6 - r4) * 100) / r2));
    L10:
        JSONObject r13 = r11.optJSONObject("memory_info");
        if (r13 == null) goto L14;
        JSONUtils.put(r1, "total_pss", Long.valueOf(r13.optLong("totalPss") / 1048576));
        return;
    }

    void pushToCrashBody(JSONObject r8) {
        long r0 = getAnrTime();
        long r3 = r8.optLong("crash_time");
        if (r0 > 0) goto L5;
    L7:
        JSONUtils.put(r8, ANR_INFO, getContent());
        pushAttribute(r8);
        pushFeature(r8);
        return;
    L5:
        if (r0 >= r3) goto L7;
        JSONUtils.put(r8, "crash_time", Long.valueOf(r0));
        goto L7
    }

    public void pushToFilter(JSONObject r14) {
        r14.put("anr_tag", this.mTag);     // Catch: Throwable -> L39
        r14.put(Constants.ANR_REASON, this.mReason);     // Catch: Throwable -> L39
        r14.put("is_current_process", this.mIsCurrentProcess);     // Catch: Throwable -> L39
        r14.put("input_timeout_type", getInputTimeoutReason());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(this.mContent) == false) goto L6;
    L9:
        String r0 = "false";
    L8:
        r14.put("has_anrinfo", r0);     // Catch: Throwable -> L39
        CpuUsage r1 = this.mFirstCpuUsage;     // Catch: Throwable -> L39
        if (r1 != null) goto L13;
    L15:
        boolean r2 = false;
    L16:
        r14.put("anr_has_ago", String.valueOf(r2));     // Catch: Throwable -> L39
        if (this.mFirstCpuUsage == null) goto L19;
        boolean r3 = true;
    L20:
        r14.put("success_end_anrinfo", String.valueOf(r3));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_1", cpuRange(this.mLoads[0]));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_5", cpuRange(this.mLoads[1]));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_15", cpuRange(this.mLoads[2]));     // Catch: Throwable -> L39
        CpuUsage r4 = this.mFirstCpuUsage;     // Catch: Throwable -> L39
        if (r4 == null) goto L31;
        r14.put("anr_cpu_total", cpuRange((float) r4.mFooterTotal));     // Catch: Throwable -> L39
        r14.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));     // Catch: Throwable -> L39
        r14.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));     // Catch: Throwable -> L39
        r14.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));     // Catch: Throwable -> L39
        ProcessCpuUsage r5 = getAnrProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r5 == null) goto L26;
        r14.put("anr_app_cpu_total", cpuRange((float) r5.mTotalRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_user", cpuRange((float) r5.mUserRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_kernel", cpuRange((float) r5.mKernelRatio));     // Catch: Throwable -> L39
        r14.put("anr_faults_minor", faultsPageRange(r5.mMinor));     // Catch: Throwable -> L39
        r14.put("anr_faults_major", faultsPageRange(r5.mMajor));     // Catch: Throwable -> L39
    L26:
        ProcessCpuUsage r13 = getTopProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r13 == null) goto L44;
        String r15 = r13.mProcessName;     // Catch: Throwable -> L39
    L29:
        r14.put("anr_top_cpu_process", r15);     // Catch: Throwable -> L39
        return;
    L44:
        return;
    L31:
        if (this.mSecondCpuUsage == null) goto L46;
        r14.put("anr_cpu_total", cpuRange((float) r4.mFooterTotal));     // Catch: Throwable -> L39
        r14.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));     // Catch: Throwable -> L39
        r14.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));     // Catch: Throwable -> L39
        r14.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));     // Catch: Throwable -> L39
        ProcessCpuUsage r6 = getAnrProcessInfo(this.mSecondCpuUsage);     // Catch: Throwable -> L39
        if (r6 == null) goto L35;
        r14.put("anr_app_cpu_total", cpuRange((float) r6.mTotalRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_user", cpuRange((float) r6.mUserRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_kernel", cpuRange((float) r6.mKernelRatio));     // Catch: Throwable -> L39
        r14.put("anr_faults_minor", faultsPageRange(r6.mMinor));     // Catch: Throwable -> L39
        r14.put("anr_faults_major", faultsPageRange(r6.mMajor));     // Catch: Throwable -> L39
    L35:
        ProcessCpuUsage r16 = getTopProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r16 == null) goto L47;
        r15 = r16.mProcessName;     // Catch: Throwable -> L39
        goto L29
    L47:
        return;
    L46:
        return;
    L19:
        r3 = false;
        goto L20
    L13:
        if (r1.mHeaderAgo == false) goto L15;
        r2 = true;
        goto L16
    L6:
        if (this.mContent.equals(AnrManager.SILENT_ANR_NO_ANR_INFO) == true) goto L9;
        r0 = "true";
    L39:
        th = move-exception;
        NpthLog.i(th);
    }

    void putLoadsToJObject(JSONObject r7) {
        int r0 = this.mLongMsgBegin;
    L4:
        if (r0 >= this.mLongMsgEnd) goto L11;
        int r1 = this.mContent.indexOf("\n", r0);
        if (r1 < 0) goto L11;
        if (this.mContent.startsWith(TAG_LOAD, r0) == true) goto L9;
        r0 = r1 + 1;
        goto L4
    L9:
        String r6 = this.mContent.substring(r0 + 6, r1);
    L12:
        if (r6 == null) goto L24;
        String[] r8 = r6.split(" / ");
        if (r8.length == 3) goto L19;
        return;
    L19:
        double r2 = Double.parseDouble(r8[0].trim());     // Catch: Throwable -> L18
        double r3 = Double.parseDouble(r8[1].trim());     // Catch: Throwable -> L18
        double r4 = Double.parseDouble(r8[2].trim());     // Catch: Throwable -> L18
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L18
        r9.put(r2);     // Catch: Throwable -> L18
        r9.put(r3);     // Catch: Throwable -> L18
        r9.put(r4);     // Catch: Throwable -> L18
        r7.put("load", r9);     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L24:
        return;
    L11:
        r6 = null;
        goto L12
    }
}
