package com.bytedance.crash.anr;

import android.app.ActivityManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

        CpuUsage(AnrInfoParser r10, String r11, int[] r12) {
            this.this$0 = r10;
            this.mProcessList = new ArrayList();
            this.mDex2oatTotalRatioList = new ArrayList();
            this.mContent = r11;
            boolean r13 = false;
            this.mHeaderBegin = r12[0];
            this.mHeaderEnd = r12[1];
            this.mFooterBegin = r12[2];
            this.mFooterEnd = r12[3];
            if (parseHeaderLine() == true) goto L5;
        L7:
            this.mValid = r13;
            return;
        L5:
            if (parseFooterLine() == false) goto L7;
            r13 = true;
            goto L7
        }

        @Nullable
        ProcessCpuUsage getAnrProcess() {
            Iterator<ProcessCpuUsage> r10 = this.mProcessList.iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            ProcessCpuUsage r11 = r10.next();
            if (r11.mPid != AnrInfoParser.access$000(this.this$0)) goto L4;
            return r11;
        L8:
            return null;
        }

        long getAnrTime() {
            long r10 = 0;
            long r11 = DateUtils.parseDateMs(this.mHeaderFromTime);     // Catch: Throwable -> L9
            if (this.mHeaderAgo == false) goto L7;
            r10 = r11 + this.mHeaderFromMs;     // Catch: Throwable -> L9
        L10:
            goto L8
        L7:
            r10 = r11 - this.mHeaderFromMs;
        L8:
            return r10;
        }

        JSONObject getProcessList() {
            JSONObject r10 = new JSONObject();
            Iterator<ProcessCpuUsage> r11 = this.mProcessList.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ProcessCpuUsage r12 = r11.next();
            JSONUtils.put(r10, String.valueOf(r12.mPid), JSONUtils.put(JSONUtils.put(new JSONObject(), "process_name", r12.mProcessName), "cpu", Double.valueOf(r12.mTotalRatio)));
            goto L4
        L6:
            return r10;
        }

        ProcessCpuUsage getTopProcess() {
            if (this.mProcessList.size() != 0) goto L7;
            return null;
        L7:
            return this.mProcessList.get(0);
        }

        void parseAllProcessLine() {
            int r10 = this.mHeaderEnd + 1;
        L4:
            if (r10 >= this.mFooterBegin) goto L20;
            int r11 = this.mContent.indexOf("\n", r10);
            if (r11 < 0) goto L32;
            if ((r11 - r10) > 4) goto L10;
        L11:
            ProcessCpuUsage r12 = null;
            r12 = parseOneProcessLine(this.mContent, r10, r11);     // Catch: Throwable -> L21
        L13:
            if (r12 == null) goto L4;
            if (r12.mTotalRatio < 1.0d) goto L33;
            this.mProcessList.add(r12);
        L19:
            r10 = r11 + 1;
            goto L4
        L33:
            return;
        L10:
            if (this.mContent.charAt(r10 + 2) == ' ') goto L19;
        L32:
            return;
        }

        boolean parseFooterLine() {
            LineParser r10 = new LineParser(this.mContent.substring(this.mFooterBegin, this.mFooterEnd));
            String r11 = r10.parse(null, "% TOTAL:");
            if (r11 != null) goto L5;
            return false;
        L5:
            String r12 = r10.parse(" ", "% user");
            if (r12 == null) goto L8;
            r10.incPos(2);
        L8:
            String r13 = r10.parse(" ", "% kernel");
            if (r13 == null) goto L11;
            r10.incPos(2);
        L11:
            String r14 = r10.parse(" ", "% iowait");
            if (r14 == null) goto L14;
            r10.incPos(2);
        L14:
            String r15 = r10.parse(" ", "% irq");
            if (r15 == null) goto L17;
            r10.incPos(2);
        L17:
            String r16 = r10.parse(" ", "% softirq");
            if (r16 != null) goto L44;
            r10.incPos(2);
        L44:
            this.mFooterTotal = Double.parseDouble(r11);     // Catch: Throwable -> L43
            double r17 = 0.0d;
            if (r12 != null) goto L23;
            double r18 = 0.0d;
        L24:
            this.mFooterUser = r18;     // Catch: Throwable -> L43
            if (r13 != null) goto L27;
            double r19 = 0.0d;
        L28:
            this.mFooterKernel = r19;     // Catch: Throwable -> L43
            if (r14 != null) goto L31;
            double r20 = 0.0d;
        L32:
            this.mFooterIowait = r20;     // Catch: Throwable -> L43
            if (r15 != null) goto L35;
            double r21 = 0.0d;
        L36:
            this.mFooterIrq = r21;     // Catch: Throwable -> L43
            if (r16 == null) goto L40;
            r17 = Double.parseDouble(r16);     // Catch: Throwable -> L43
        L40:
            this.mFooterSoftirq = r17;     // Catch: Throwable -> L43
            return true;
        L35:
            r21 = Double.parseDouble(r15);     // Catch: Throwable -> L43
            goto L36
        L31:
            r20 = Double.parseDouble(r14);     // Catch: Throwable -> L43
            goto L32
        L27:
            r19 = Double.parseDouble(r13);     // Catch: Throwable -> L43
            goto L28
        L23:
            r18 = Double.parseDouble(r12);     // Catch: Throwable -> L43
        L43:
            return false;
        }

        boolean parseHeaderLine() {
            LineParser r10 = new LineParser(this.mContent.substring(this.mHeaderBegin, this.mHeaderEnd));
            String r11 = r10.parse("CPU usage from ", "ms");
            if (r11 != null) goto L5;
            return false;
        L5:
            String r12 = r10.parse(" to ", "ms");
            if (r12 != null) goto L8;
            return false;
        L8:
            String r13 = r10.parse(" ", " ");
            if (r13 != null) goto L11;
            return false;
        L11:
            String r14 = r10.parse("(", " t");
            if (r14 != null) goto L14;
            return false;
        L14:
            String r15 = r10.parse("o ", ")");
            if (r15 != null) goto L21;
            return false;
        L21:
            this.mHeaderFromMs = Long.parseLong(r11);     // Catch: Throwable -> L20
            this.mHeaderToMs = Long.parseLong(r12);     // Catch: Throwable -> L20
            this.mHeaderAgo = "ago".equals(r13);     // Catch: Throwable -> L20
            this.mHeaderFromTime = r14;     // Catch: Throwable -> L20
            this.mHeaderToTime = r15;     // Catch: Throwable -> L20
            return true;
        L20:
            return false;
        }

        @Nullable
        ProcessCpuUsage parseOneProcessLine(String r10, int r11, int r12) {
            int r13 = r11 + 2;
            int r14 = r10.indexOf(37, r13);
            ProcessCpuUsage r15 = null;
            if (r14 < 0) goto L36;
            if (r14 > r12) goto L36;
            double r16 = Double.parseDouble(r10.substring(r13, r14));
            int r17 = r14 + 2;
            int r18 = r10.indexOf(47, r17);
            if (r18 < 0) goto L36;
            if (r18 > r12) goto L36;
            int r19 = Integer.parseInt(r10.substring(r17, r18));
            int r20 = r18 + 1;
            int r21 = r10.indexOf(": ", r20);
            if (r21 < 0) goto L36;
            if (r21 > r12) goto L36;
            r15 = new ProcessCpuUsage(r19, r10.substring(r20, r21), r16);
            if (r19 != AnrInfoParser.access$000(this.this$0)) goto L36;
            int r22 = r21 + 2;
            int r23 = r10.indexOf("% user + ", r22);
            if (r23 < 0) goto L36;
            if (r23 > r12) goto L36;
            r15.mUserRatio = Double.parseDouble(r10.substring(r22, r23));
            int r24 = r23 + 9;
            int r25 = r10.indexOf("% kernel", r24);
            if (r25 < 0) goto L36;
            if (r25 > r12) goto L36;
            r15.mKernelRatio = Double.parseDouble(r10.substring(r24, r25));
            int r26 = r10.indexOf("faults: ", r25);
            if (r26 < 0) goto L36;
            if (r26 > r12) goto L36;
            int r27 = r26 + 8;
            int r28 = r10.indexOf(" minor", r27);
            if (r28 <= 0) goto L32;
            if (r28 >= r12) goto L32;
            r15.mMinor = Long.parseLong(r10.substring(r27, r28));
            r27 = r28 + 7;
        L32:
            int r29 = r10.indexOf(" major", r27);
            if (r29 <= 0) goto L36;
            if (r29 >= r12) goto L36;
            r15.mMajor = Long.parseLong(r10.substring(r27, r29));
        L36:
            return r15;
        }

        void parseSpecialProcess() {
            Iterator<ProcessCpuUsage> r10 = this.mProcessList.iterator();
        L4:
            if (r10.hasNext() == false) goto L23;
            ProcessCpuUsage r11 = r10.next();
            String r12 = r11.mProcessName;
            double r13 = r11.mTotalRatio;
            if (r12.contains("kworker") == true) goto L7;
            if (r12.contains("kswapd") == true) goto L10;
            if (r12.contains("mmcqd") == true) goto L13;
            if (r12.contains("system_server") == true) goto L16;
            if (r12.contains("lmkd") == true) goto L19;
            if (r12.contains("dex2oat") == false) goto L4;
            this.mDex2oatTotalRatioList.add(Double.valueOf(r13));
            goto L4
        L19:
            this.mLmkdTotalRatio += r13;
            goto L4
        L16:
            this.mSystemServerTotalRatio += r13;
            goto L4
        L13:
            this.mMmcqdTotalRatio += r13;
            goto L4
        L10:
            this.mKswapdTotalRatio += r13;
            goto L4
        L7:
            this.mKworkTotalRatio += r13;
            goto L4
        }

        void putFooterToAttribute(@NonNull JSONObject r10, boolean r11) {
            if (r11 == false) goto L4;
            String r12 = "user";
        L37:
            r10.put(r12, this.mFooterUser);     // Catch: Throwable -> L36
            if (r11 == false) goto L8;
            String r13 = NotificationCompat.CATEGORY_SYSTEM;
        L9:
            r10.put(r13, this.mFooterKernel);     // Catch: Throwable -> L36
            if (r11 == false) goto L12;
            String r14 = "iowait";
        L13:
            r10.put(r14, this.mFooterIowait);     // Catch: Throwable -> L36
            if (r11 == false) goto L16;
            String r15 = "irq";
        L17:
            r10.put(r15, this.mFooterIrq);     // Catch: Throwable -> L36
            if (r11 == false) goto L20;
            String r16 = "softirq";
        L21:
            r10.put(r16, this.mFooterSoftirq);     // Catch: Throwable -> L36
            ProcessCpuUsage r17 = getAnrProcess();     // Catch: Throwable -> L36
            if (r17 == null) goto L31;
            if (r11 == false) goto L25;
            String r18 = "minor";
        L26:
            r10.put(r18, r17.mMinor);     // Catch: Throwable -> L36
            if (r11 == false) goto L29;
            String r19 = "major";
        L30:
            r10.put(r19, r17.mMajor);     // Catch: Throwable -> L36
            goto L31
        L29:
            r19 = "major2";
            goto L30
        L25:
            r18 = "minor2";
        L31:
            if (r11 == false) goto L33;
            String r20 = "before_cpu_list";
        L34:
            r10.put(r20, getProcessList());     // Catch: Throwable -> L36
            return;
        L33:
            r20 = "after_cpu_list";
            goto L34
        L20:
            r16 = "softirq2";
            goto L21
        L16:
            r15 = "irq2";
            goto L17
        L12:
            r14 = "iowait2";
            goto L13
        L8:
            r13 = "sys2";
        L39:
            return;
        L4:
            r12 = "user2";
            goto L37
        }

        void putSpecialProcessToAttribute(@NonNull JSONObject r10) {
            r10.put("kswapd", this.mKswapdTotalRatio);     // Catch: Throwable -> L10
            r10.put("mmcqd", this.mMmcqdTotalRatio);     // Catch: Throwable -> L10
            r10.put("kwork", this.mKworkTotalRatio);     // Catch: Throwable -> L10
            r10.put("system_server", this.mSystemServerTotalRatio);     // Catch: Throwable -> L10
            r10.put("lmkd", this.mLmkdTotalRatio);     // Catch: Throwable -> L10
            if (this.mDex2oatTotalRatioList.isEmpty() == true) goto L14;
            JSONArray r11 = new JSONArray();     // Catch: Throwable -> L10
            Iterator<Double> r12 = this.mDex2oatTotalRatioList.iterator();     // Catch: Throwable -> L10
        L6:
            if (r12.hasNext() == false) goto L8;
            r11.put(r12.next());     // Catch: Throwable -> L10
            goto L6
        L8:
            r10.put("dex2oat", r11);     // Catch: Throwable -> L10
            return;
        L14:
            return;
        }

        void putToFeature(@NonNull JSONObject r10, @NonNull JSONObject r11) {
            JSONUtils.put(r10, "cpu_total", Double.valueOf(this.mFooterTotal));
            JSONUtils.put(r10, "cpu_user", Double.valueOf(this.mFooterUser));
            JSONUtils.put(r10, "cpu_kernel", Double.valueOf(this.mFooterKernel));
            JSONUtils.put(r10, "cpu_iowait", Double.valueOf(this.mFooterIowait));
            JSONUtils.put(r10, "cpu_irq", Double.valueOf(this.mFooterIrq));
            JSONUtils.put(r10, "cpu_softirq", Double.valueOf(this.mFooterSoftirq));
            ProcessCpuUsage r12 = getTopProcess();
            if (r12 == null) goto L5;
            JSONUtils.put(r11, "top_cpu_process_name", r12.mProcessName);
        L5:
            ProcessCpuUsage r13 = getAnrProcess();
            if (r13 == null) goto L15;
            JSONUtils.put(r10, "cpu_app_total", Double.valueOf(r13.mTotalRatio));
            JSONUtils.put(r10, "cpu_app_user", Double.valueOf(r13.mUserRatio));
            JSONUtils.put(r10, "cpu_app_kernel", Double.valueOf(r13.mKernelRatio));
            JSONUtils.put(r10, "minor_rate", Long.valueOf(r13.mMinor));
            JSONUtils.put(r10, "major_rate", Long.valueOf(r13.mMajor));
        L15:
            r10.put("cpu_kswapd", this.mKswapdTotalRatio);     // Catch: Throwable -> L14
            r10.put("cpu_mmcqd", this.mMmcqdTotalRatio);     // Catch: Throwable -> L14
            r10.put("cpu_kwork", this.mKworkTotalRatio);     // Catch: Throwable -> L14
            r10.put("cpu_system_server", this.mSystemServerTotalRatio);     // Catch: Throwable -> L14
            r10.put("cpu_lmkd", this.mLmkdTotalRatio);     // Catch: Throwable -> L14
            float r14 = 0.0f;
            Iterator<Double> r15 = this.mDex2oatTotalRatioList.iterator();     // Catch: Throwable -> L14
        L10:
            if (r15.hasNext() == false) goto L12;
            r14 = (float) (((double) r14) + r15.next().doubleValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r10.put("cpu_dex2oat", r14);     // Catch: Throwable -> L14
            return;
        }
    }

    static class LineParser {
        String mLine;
        int mPos;

        LineParser(String r10) {
            this.mLine = r10;
            this.mPos = 0;
        }

        int getPos() {
            return this.mPos;
        }

        void incPos(int r10) {
            this.mPos += r10;
        }

        @Nullable
        String parse(String r10, String r11) {
            int r12 = this.mPos;
            if (r10 == null) goto L8;
            int r13 = this.mLine.indexOf(r10, r12);
            if (r13 >= 0) goto L7;
            return null;
        L7:
            this.mPos = r13 + r10.length();
        L8:
            String r14 = this.mLine;
            if (r11 == null) goto L15;
            int r15 = r14.indexOf(r11, this.mPos);
            if (r15 >= 0) goto L14;
            this.mPos = r12;
            return null;
        L14:
            String r16 = this.mLine.substring(this.mPos, r15);
            int r17 = r15 + r11.length();
        L16:
            this.mPos = r17;
            return r16;
        L15:
            r16 = r14.substring(this.mPos);
            r17 = this.mLine.length() - 1;
            goto L16
        }

        void setPos(int r10) {
            this.mPos = r10;
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

        ProcessCpuUsage(int r10, String r11, double r12) {
            this.mPid = r10;
            this.mProcessName = r11;
            this.mTotalRatio = r12;
        }
    }

    public AnrInfoParser(File r10) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        String r11 = FileSystemUtils.readUtf8File(new File(r10, FILE_NAME));
        if (r11 != null) goto L5;
    L18:
        this.mContent = r11;
        this.mIsCurrentProcess = !new File(r10, AnrInfoMonitor.ANR_FROM_EXTERNAL).exists();
        return;
    L5:
        if (r11.isEmpty() == true) goto L18;
        if (r11.equals(AnrManager.SILENT_ANR_NO_ANR_INFO) == false) goto L11;
        String r12 = Constants.SILENT_ANR;
    L9:
        this.mReason = r12;
        this.mTag = getTagFromShortMsg();
        goto L18
    L11:
        if (r11.equals(AnrManager.CLOSE_ANR_INFO) == false) goto L13;
        r12 = "Not report anrInfo";
        goto L9
    L13:
        int r13 = parseAnrInfoContent(r11);
        if (r13 >= 0) goto L16;
        NpthLog.e("NPTH", "Anr Info Parse Error:" + r13);
    L16:
        r12 = getAnrReasonFromShortMessage();
        goto L9
    }

    public AnrInfoParser(String r10) {
        this.mLoads = new float[]{-1.0f, -1.0f, -1.0f};
        this.mContent = r10;
        this.mIsCurrentProcess = false;
        parseAnrInfoContent(r10);
    }

    static /* synthetic */ int access$000(AnrInfoParser r10) {
        return r10.mAnrProcessPid;
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

    private static boolean equalString(String r10, String r11) {
        if (r10 == null) goto L5;
        if (r11 == null) goto L5;
        return r10.equals(r11);
    L5:
        if (r10 != null) goto L8;
        if (r11 != null) goto L8;
        return true;
    L8:
        return false;
    }

    private static String faultsPageRange(float r21) {
        if (r21 >= 0.0f) goto L6;
        return "invalid";
    L6:
        float[] r10 = {2000.0f, 3000.0f, 4000.0f, 5000.0f, 10000.0f, 20000.0f, 30000.0f, 40000.0f, 50000.0f, 60000.0f, 70000.0f, 80000.0f, 90000.0f, 100000.0f, 150000.0f, 200000.0f, 300000.0f, 400000.0f, 500000.0f};
        String[] r11 = {"0~2k", "2k~3k", "3k~4k", "4k~5k", "5k~1w", "1w~2w", "2w~3w", "3w~4w", "4w~5w", "5w~6w", "7w~8w", "8w~9w", "9w~10w", "10w~15w", "15w~20w", "20w~30w", "30w~40w", "40w~50w", "> 50w"};
        int r12 = 0;
    L7:
        if (r12 >= 19) goto L14;
        if (r21 <= r10[r12]) goto L11;
        r12 = r12 + 1;
        goto L7
    L11:
        return r11[r12];
    L14:
        return r11[18];
    }

    static String format(ActivityManager.ProcessErrorStateInfo r10) {
        return HEADER + TAG_CONDITION + r10.condition + "\n" + TAG_PROCESS_NAME + r10.processName + "\n" + TAG_PID + r10.pid + "\n" + TAG_UID + r10.uid + "\n" + TAG_TAG + r10.tag + "\n" + TAG_SHORT_MSG + r10.shortMsg + "\n" + TAG_LONG_MSG + r10.longMsg + "\n" + FOOTER;
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

    @Nullable
    private static int[] getCpuUsageLinePos(String r10, int r11) {
        int[] r12 = new int[4];
    L3:
        int r13 = r10.indexOf("\n", r11);
        if (r13 < 0) goto L16;
        if (r10.startsWith("CPU usage from", r11) == true) goto L7;
        r11 = r13 + 1;
        goto L3
    L7:
        r12[0] = r11;
        r12[1] = r13;
        int r14 = r10.indexOf("% TOTAL: ", r13 + 1);
        if (r14 <= 0) goto L14;
        int r15 = r10.lastIndexOf(10, r14) + 1;
        int r16 = r10.indexOf(10, r14);
        if (r15 <= 0) goto L14;
        if (r16 <= 0) goto L14;
        r12[2] = r15;
        r12[3] = r16;
        return r12;
    L14:
        return null;
    L16:
        return null;
    }

    static String getFileName() {
        return FILE_NAME;
    }

    private static String getInputANRReason(String r10) {
        if (r10.contains("Waiting to send non-key event") == false) goto L9;
        if (r10.contains("finished processing certain input events that were delivered") == false) goto L9;
        return "Input dispatching timed out (Waiting to send non-key event because the touched window has not finished processing certain input events that were delivered to it over xxms ago.  Wait queue length: xx.  Wait queue head age: xxms.)";
    L9:
        if (r10.contains("Application does not have a focused window") == false) goto L13;
        return "Input dispatching timed out (Application does not have a focused window)";
    L13:
        if (r10.contains("Waiting because no window has focus but there is a focused") == false) goto L17;
        return "Input dispatching timed out (Waiting because no window has focus but there is a focused application that may eventually add a window when it finishes starting up.)";
    L17:
        if (r10.contains("window's input channel is full.") == false) goto L20;
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
        String r10 = this.mShortMsg;
        String r11 = r10.substring(r10.indexOf("service ") + 8).trim();
        String[] r12 = r11.split("/");
        if (r12.length <= 1) goto L25;
        r11 = r12[r12.length - 1];
    L25:
        return r11;
    L20:
        if (this.mShortMsg.contains(REASON_BROADCAST_OF_INTENT) == false) goto L26;
        String r13 = this.mShortMsg;
        r11 = r13.substring(r13.indexOf("{") + 1, this.mShortMsg.indexOf("}")).trim();
        String[] r14 = r11.split("/");
        if (r14.length <= 1) goto L25;
        r11 = r14[r14.length - 1];
        goto L25
    L26:
        return "unknown";
    }

    static boolean isSameProcessErrorStateInfo(ActivityManager.ProcessErrorStateInfo r10, ActivityManager.ProcessErrorStateInfo r11) {
        if (r10.condition == r11.condition) goto L5;
    L17:
        return false;
    L5:
        if (r10.pid != r11.pid) goto L17;
        if (r10.uid != r11.uid) goto L17;
        if (equalString(r10.processName, r11.processName) == false) goto L17;
        if (equalString(r10.tag, r11.tag) == false) goto L17;
        if (equalString(r10.shortMsg, r11.shortMsg) == false) goto L17;
        if (equalString(r10.longMsg, r11.longMsg) == false) goto L17;
        return true;
    }

    public static String parseAnrInfoHideOthersApp(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L23;
        return "";
    L23:
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L22
        String[] r13 = r10.split("\n");     // Catch: Throwable -> L22
        int r14 = r13.length;     // Catch: Throwable -> L22
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L20;
        String r16 = r13[r15];     // Catch: Throwable -> L22
        int r17 = r16.indexOf(47);     // Catch: Throwable -> L22
        int r18 = r16.indexOf(": ");     // Catch: Throwable -> L22
        if (r17 == (-1)) goto L19;
        if (r18 == (-1)) goto L19;
        if (r17 >= r18) goto L19;
        String r19 = r16.substring(r17, r18);     // Catch: Throwable -> L22
        if (r19.contains(r11) == true) goto L19;
        if (r19.contains("com.") == false) goto L17;
    L18:
        r16 = r16.replace(r19, "/*.*.*");     // Catch: Throwable -> L22
        goto L19
    L17:
        if (r19.contains(".google") == true) goto L18;
    L19:
        r12.append(r16);     // Catch: Throwable -> L22
        r12.append("\n");     // Catch: Throwable -> L22
        r15 = r15 + 1;     // Catch: Throwable -> L22
        goto L7
    L20:
        return r12.toString();
    L32:
        return r10;
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
    private void pushAttribute(@NonNull JSONObject r10) {
        ?? r11 = JSONUtils.get(r10, "anr_atribute");
        ?? r12 = new JSONObject();
        putLoadsToJObject(r12);     // Catch: Throwable -> L16
        ?? r13 = this.mFirstCpuUsage;     // Catch: Throwable -> L16
        if (r13 == 0) goto L6;
        r13.putFooterToAttribute(r12, true);     // Catch: Throwable -> L16
    L6:
        ?? r14 = this.mSecondCpuUsage;     // Catch: Throwable -> L16
        if (r14 == 0) goto L9;
        r14.putFooterToAttribute(r12, false);     // Catch: Throwable -> L16
    L9:
        ?? r15 = -1;
        r15 = -1;
        ?? r16 = this.mCloserCpuUsage;     // Catch: Throwable -> L16
        if (r16 == 0) goto L14;
        r16.putSpecialProcessToAttribute(r12);     // Catch: Throwable -> L16
        ProcessCpuUsage r17 = this.mCloserCpuUsage.getTopProcess();     // Catch: Throwable -> L16
        if (r17 == null) goto L14;
        r12.put("top_cpu_process_name", r17.mProcessName);     // Catch: Throwable -> L16
        r15 = this.mAnrProcessName.equals(r17.mProcessName);     // Catch: Throwable -> L16
    L14:
        r12.put("top_cpu_process_is_anrapp", r15);     // Catch: Throwable -> L16
        r12.put("process_name", this.mAnrProcessName);     // Catch: Throwable -> L16
        r11.put("cpu", r12);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        NpthLog.i(th);
    }

    public static String replaceNumbersWithX(String r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.replaceAll("\\d+", "xxx");
    L10:
        return r10;
    }

    private static Float safeFloat(String r10) {
        return Float.valueOf(r10);
    L5:
        return Float.valueOf(-1.0f);
    }

    @Nullable
    ProcessCpuUsage getAnrProcessInfo(CpuUsage r10) {
        Iterator<ProcessCpuUsage> r11 = r10.mProcessList.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ProcessCpuUsage r12 = r11.next();
        if (r12.mPid != this.mAnrProcessPid) goto L4;
        return r12;
    L8:
        return null;
    }

    int getAnrProcessPid() {
        return this.mAnrProcessPid;
    }

    long getAnrTime() {
        CpuUsage r10 = this.mCloserCpuUsage;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getAnrTime();
    }

    String getContent() {
        return this.mContent;
    }

    String getInputTimeoutReason() {
        String r10 = this.mReason;
        if (r10 != null) goto L5;
        return "invalid";
    L5:
        if (r10.equals(REASON_INPUT_DISPATCHING_TIMED_OUT) == false) goto L43;
        String r11 = this.mShortMsg.toLowerCase();
        if (r11.contains("no window has focus but there is a focused application") == false) goto L9;
        return "no focused window";
    L9:
        if (r11.contains("does not have a focused window") == false) goto L12;
        return "no focused window";
    L12:
        if (r11.contains("waiting to send non-key event because the touched window has not finished") == false) goto L16;
        return "non-key event not finished";
    L16:
        if (r11.contains("waiting to send key event because the focused window has not finished") == false) goto L20;
        return "key event not finished";
    L20:
        if (r11.contains("window is paused") == false) goto L23;
        return "window is paused";
    L23:
        if (r11.contains("window’s input channel is not registered") == false) goto L27;
        return "input channel not registered";
    L27:
        if (r11.contains("window’s input connection is") == false) goto L31;
        return "window being removed";
    L31:
        if (r11.contains("window’s input channel is full") == false) goto L35;
        return "input channel is full";
    L35:
        if (r11.contains("is not responding. waited") == false) goto L44;
        return "activity is not responding";
    L44:
        return "invalid";
    L43:
        return "invalid";
    }

    ProcessCpuUsage getTopProcessInfo(CpuUsage r10) {
        if (r10.mProcessList.size() != 0) goto L7;
        return null;
    L7:
        return r10.mProcessList.get(0);
    }

    boolean isValid() {
        return !TextUtils.isEmpty(this.mContent);
    }

    int parseAnrInfoContent(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return -1;
    L5:
        if (r10.startsWith(HEADER) == true) goto L7;
        return -1;
    L7:
        if (r10.endsWith(FOOTER) == false) goto L102;
        LineParser r11 = new LineParser(r10);     // Catch: Throwable -> L83
        r11.setPos(52);     // Catch: Throwable -> L83
        if (r11.parse(TAG_CONDITION, "\n") != null) goto L13;
        return -2;
    L13:
        String r12 = r11.parse(TAG_PROCESS_NAME, "\n");     // Catch: Throwable -> L83
        if (r12 != null) goto L17;
        return -3;
    L17:
        this.mAnrProcessName = r12;     // Catch: Throwable -> L83
        String r13 = r11.parse(TAG_PID, "\n");     // Catch: Throwable -> L83
        if (r13 != null) goto L88;
        return -4;
    L88:
        this.mAnrProcessPid = Integer.parseInt(r13);     // Catch: Throwable -> L81
        if (r11.parse(TAG_UID, "\n") != null) goto L26;
        return -6;
    L26:
        String r14 = r11.parse(TAG_TAG, "\n");     // Catch: Throwable -> L83
        if (r14 != null) goto L30;
        return -7;
    L30:
        this.mTag = r14;     // Catch: Throwable -> L83
        int r15 = r10.indexOf(TAG_SHORT_MSG, r11.getPos());     // Catch: Throwable -> L83
        if (r15 >= 0) goto L34;
        return -8;
    L34:
        int r16 = r15 + 11;     // Catch: Throwable -> L83
        int r17 = r10.indexOf(10, r16);     // Catch: Throwable -> L83
        if (r17 >= 0) goto L38;
        return -9;
    L38:
        int r18 = r10.indexOf(TAG_LONG_MSG, r17);     // Catch: Throwable -> L83
        if (r18 >= 0) goto L42;
        return -10;
    L42:
        this.mLongMsgBegin = r18 + 10;     // Catch: Throwable -> L83
        this.mShortMsg = r10.substring(r16, r18 - 1);     // Catch: Throwable -> L83
        int r19 = r10.length() - 54;     // Catch: Throwable -> L83
        this.mLongMsgEnd = r19;     // Catch: Throwable -> L83
        if (r19 == 0) goto L71;
        int r20 = this.mLongMsgBegin;     // Catch: Throwable -> L83
    L46:
        if (r20 >= this.mLongMsgEnd) goto L61;
        int r21 = r10.indexOf("\n", r20);     // Catch: Throwable -> L83
        if (r21 < 0) goto L61;
        int[] r22 = getCpuUsageLinePos(r10, r20);     // Catch: Throwable -> L83
        if (r22 != null) goto L51;
        r20 = r21 + 1;     // Catch: Throwable -> L83
        goto L46
    L51:
        CpuUsage r23 = new CpuUsage(this, r10, r22);     // Catch: Throwable -> L83
        if (r23.mValid == true) goto L54;
    L59:
        r20 = r22[3] + 1;     // Catch: Throwable -> L83
        goto L46
    L54:
        if (this.mFirstCpuUsage != null) goto L57;
        this.mFirstCpuUsage = r23;     // Catch: Throwable -> L83
        r23.parseAllProcessLine();     // Catch: Throwable -> L83
        goto L59
    L57:
        if (this.mSecondCpuUsage != null) goto L59;
        this.mSecondCpuUsage = r23;     // Catch: Throwable -> L83
        r23.parseAllProcessLine();     // Catch: Throwable -> L83
    L61:
        CpuUsage r24 = this.mFirstCpuUsage;     // Catch: Throwable -> L83
        this.mCloserCpuUsage = r24;     // Catch: Throwable -> L83
        if (this.mSecondCpuUsage != null) goto L64;
    L68:
        CpuUsage r25 = this.mCloserCpuUsage;     // Catch: Throwable -> L83
        if (r25 == null) goto L71;
        r25.parseSpecialProcess();     // Catch: Throwable -> L83
        goto L71
    L64:
        if (r24.mHeaderAgo == false) goto L68;
        long r26 = Math.abs(r24.mHeaderFromMs + r24.mHeaderToMs);     // Catch: Throwable -> L83
        CpuUsage r27 = this.mSecondCpuUsage;     // Catch: Throwable -> L83
        if (r26 <= Math.abs(r27.mHeaderFromMs + r27.mHeaderToMs)) goto L68;
        this.mCloserCpuUsage = this.mSecondCpuUsage;     // Catch: Throwable -> L83
    L71:
        String r28 = r11.parse(TAG_LOAD, "\n");     // Catch: Throwable -> L83
        if (r28 == null) goto L80;
        String[] r29 = r28.split("/");     // Catch: Throwable -> L83
        if (this.mLoads.length != r29.length) goto L80;
        int r30 = 0;
    L76:
        if (r30 >= r29.length) goto L80;
        this.mLoads[r30] = safeFloat(r29[r30].trim()).floatValue();     // Catch: Throwable -> L83
        r30 = r30 + 1;
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

    public void pushFeature(@NonNull JSONObject r11) {
        JSONObject r10 = JSONUtils.get(r11, "features_str");
        JSONObject r12 = JSONUtils.get(r11, "features_num");
        CpuUsage r13 = this.mCloserCpuUsage;
        if (r13 == null) goto L5;
        r13.putToFeature(r12, r10);
    L5:
        JSONObject r14 = r11.optJSONObject("app_memory_info");
        if (r14 == null) goto L10;
        long r15 = r14.optLong("max_memory");
        long r16 = r14.optLong("free_memory");
        long r17 = r14.optLong("total_memory");
        if (r15 <= 0) goto L10;
        JSONUtils.put(r12, "java_heap_usage", Long.valueOf(((r17 - r16) * 100) / r15));
    L10:
        JSONObject r18 = r11.optJSONObject("memory_info");
        if (r18 == null) goto L14;
        JSONUtils.put(r12, "total_pss", Long.valueOf(r18.optLong("totalPss") / 1048576));
        return;
    }

    void pushToCrashBody(@NonNull JSONObject r10) {
        long r11 = getAnrTime();
        long r12 = r10.optLong("crash_time");
        if (r11 > 0) goto L5;
    L7:
        JSONUtils.put(r10, ANR_INFO, getContent());
        pushAttribute(r10);
        pushFeature(r10);
        return;
    L5:
        if (r11 >= r12) goto L7;
        JSONUtils.put(r10, "crash_time", Long.valueOf(r11));
        goto L7
    }

    public void pushToFilter(@NonNull JSONObject r14) {
        r14.put("anr_tag", this.mTag);     // Catch: Throwable -> L39
        r14.put(Constants.ANR_REASON, this.mReason);     // Catch: Throwable -> L39
        r14.put("is_current_process", this.mIsCurrentProcess);     // Catch: Throwable -> L39
        r14.put("input_timeout_type", getInputTimeoutReason());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(this.mContent) == false) goto L6;
    L9:
        String r10 = "false";
    L8:
        r14.put("has_anrinfo", r10);     // Catch: Throwable -> L39
        CpuUsage r11 = this.mFirstCpuUsage;     // Catch: Throwable -> L39
        if (r11 != null) goto L13;
    L15:
        boolean r12 = false;
    L16:
        r14.put("anr_has_ago", String.valueOf(r12));     // Catch: Throwable -> L39
        if (this.mFirstCpuUsage == null) goto L19;
        boolean r13 = true;
    L20:
        r14.put("success_end_anrinfo", String.valueOf(r13));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_1", cpuRange(this.mLoads[0]));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_5", cpuRange(this.mLoads[1]));     // Catch: Throwable -> L39
        r14.put("anr_cpu_load_15", cpuRange(this.mLoads[2]));     // Catch: Throwable -> L39
        CpuUsage r15 = this.mFirstCpuUsage;     // Catch: Throwable -> L39
        if (r15 == null) goto L31;
        r14.put("anr_cpu_total", cpuRange((float) r15.mFooterTotal));     // Catch: Throwable -> L39
        r14.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));     // Catch: Throwable -> L39
        r14.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));     // Catch: Throwable -> L39
        r14.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));     // Catch: Throwable -> L39
        ProcessCpuUsage r16 = getAnrProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r16 == null) goto L26;
        r14.put("anr_app_cpu_total", cpuRange((float) r16.mTotalRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_user", cpuRange((float) r16.mUserRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_kernel", cpuRange((float) r16.mKernelRatio));     // Catch: Throwable -> L39
        r14.put("anr_faults_minor", faultsPageRange(r16.mMinor));     // Catch: Throwable -> L39
        r14.put("anr_faults_major", faultsPageRange(r16.mMajor));     // Catch: Throwable -> L39
    L26:
        ProcessCpuUsage r17 = getTopProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r17 == null) goto L44;
        String r18 = r17.mProcessName;     // Catch: Throwable -> L39
    L29:
        r14.put("anr_top_cpu_process", r18);     // Catch: Throwable -> L39
        return;
    L44:
        return;
    L31:
        if (this.mSecondCpuUsage == null) goto L46;
        r14.put("anr_cpu_total", cpuRange((float) r15.mFooterTotal));     // Catch: Throwable -> L39
        r14.put("anr_cpu_user", cpuRange((float) this.mFirstCpuUsage.mFooterUser));     // Catch: Throwable -> L39
        r14.put("anr_cpu_kernel", cpuRange((float) this.mFirstCpuUsage.mFooterKernel));     // Catch: Throwable -> L39
        r14.put("anr_cpu_iowait", cpuRange((float) this.mFirstCpuUsage.mFooterIowait));     // Catch: Throwable -> L39
        ProcessCpuUsage r19 = getAnrProcessInfo(this.mSecondCpuUsage);     // Catch: Throwable -> L39
        if (r19 == null) goto L35;
        r14.put("anr_app_cpu_total", cpuRange((float) r19.mTotalRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_user", cpuRange((float) r19.mUserRatio));     // Catch: Throwable -> L39
        r14.put("anr_app_cpu_kernel", cpuRange((float) r19.mKernelRatio));     // Catch: Throwable -> L39
        r14.put("anr_faults_minor", faultsPageRange(r19.mMinor));     // Catch: Throwable -> L39
        r14.put("anr_faults_major", faultsPageRange(r19.mMajor));     // Catch: Throwable -> L39
    L35:
        ProcessCpuUsage r110 = getTopProcessInfo(this.mFirstCpuUsage);     // Catch: Throwable -> L39
        if (r110 == null) goto L47;
        r18 = r110.mProcessName;     // Catch: Throwable -> L39
        goto L29
    L47:
        return;
    L46:
        return;
    L19:
        r13 = false;
        goto L20
    L13:
        if (r11.mHeaderAgo == false) goto L15;
        r12 = true;
        goto L16
    L6:
        if (this.mContent.equals(AnrManager.SILENT_ANR_NO_ANR_INFO) == true) goto L9;
        r10 = "true";
    L39:
        th = move-exception;
        NpthLog.i(th);
    }

    void putLoadsToJObject(JSONObject r10) {
        int r11 = this.mLongMsgBegin;
    L4:
        if (r11 >= this.mLongMsgEnd) goto L11;
        int r12 = this.mContent.indexOf("\n", r11);
        if (r12 < 0) goto L11;
        if (this.mContent.startsWith(TAG_LOAD, r11) == true) goto L9;
        r11 = r12 + 1;
        goto L4
    L9:
        String r13 = this.mContent.substring(r11 + 6, r12);
    L12:
        if (r13 == null) goto L24;
        String[] r14 = r13.split(" / ");
        if (r14.length == 3) goto L19;
        return;
    L19:
        double r15 = Double.parseDouble(r14[0].trim());     // Catch: Throwable -> L18
        double r16 = Double.parseDouble(r14[1].trim());     // Catch: Throwable -> L18
        double r17 = Double.parseDouble(r14[2].trim());     // Catch: Throwable -> L18
        JSONArray r18 = new JSONArray();     // Catch: Throwable -> L18
        r18.put(r15);     // Catch: Throwable -> L18
        r18.put(r16);     // Catch: Throwable -> L18
        r18.put(r17);     // Catch: Throwable -> L18
        r10.put("load", r18);     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L24:
        return;
    L11:
        r13 = null;
        goto L12
    }
}
