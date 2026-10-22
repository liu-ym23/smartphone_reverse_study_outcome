package com.bytedance.crash.anr;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.entity.CrashFilter;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnrTraceParser {
    private static final String BACKUP_TRACE_FILE_NAME = "trace_by_child.txt";
    private static final int BACKUP_TRACE_FILE_SIZE_MIN = 1024;
    private static final String DEFAULT_NATIVE_STACK_HEADER = "backtrace: \n";
    private static final String FILE_NAME = "trace.txt";
    private static final String FILTER_ANR_DUMP_ASYNC = "anr_dump_async";
    private static final String TAG_NATIVE_BT_FAIL = "Unwind failed for thread";
    private final File mBackupTraceFile;
    private final File mDirectory;
    private final ExtraInfo mExtraInfo;
    private final ThreadBlock mMainThread;
    private final JavaHeapMemoryInfo mMemoryInfo;
    private final ArrayList<ThreadBlock> mSubThreadList;
    private final int mThreadCount;

    public static class ExtraInfo {
        public boolean dumpCrash;
        public boolean dumpSuccess;
        public String timeRangeStr;

        public ExtraInfo() {
            this.dumpSuccess = false;
            this.dumpCrash = false;
            this.timeRangeStr = null;
        }

        private static String getTimeRange(String r4) {
            long r0 = Long.parseLong(r4);     // Catch: Throwable -> L68
            if (r0 > 50) goto L7;
            return "0~50ms";
        L7:
            if (r0 > 100) goto L11;
            return "50~100ms";
        L11:
            if (r0 > 150) goto L15;
            return "100~150ms";
        L15:
            if (r0 > 200) goto L19;
            return "150~200ms";
        L19:
            if (r0 > 300) goto L23;
            return "200~300ms";
        L23:
            if (r0 > 400) goto L27;
            return "300~400ms";
        L27:
            if (r0 > 500) goto L31;
            return "400~500ms";
        L31:
            if (r0 > 700) goto L35;
            return "500~700ms";
        L35:
            if (r0 > 1000) goto L39;
            return "700~1000ms";
        L39:
            if (r0 > 1500) goto L43;
            return "1000~1500ms";
        L43:
            if (r0 > 2000) goto L47;
            return "1500~2000ms";
        L47:
            if (r0 > 3000) goto L51;
            return "2000~3000ms";
        L51:
            if (r0 > WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS) goto L55;
            return "3000~4000ms";
        L55:
            if (r0 > 5000) goto L59;
            return "4000~5000ms";
        L59:
            if (r0 > 7000) goto L63;
            return "5000~7000ms";
        L63:
            if (r0 > 10000) goto L66;
            return "7000~10000ms";
        L66:
            return "> 10000ms";
        L68:
            return "none";
        }

        public boolean parse(String r4) {
            if (r4.startsWith("Dump cost time:") == false) goto L9;
            this.dumpSuccess = true;
            int r0 = r4.indexOf(58);
            if (r0 == (-1)) goto L7;
            this.timeRangeStr = getTimeRange(r4.substring(r0 + 1).trim());
        L7:
            return true;
        L9:
            if (r4.startsWith("Dump crash") == false) goto L12;
            this.dumpCrash = true;
            return true;
        L12:
            return false;
        }
    }

    public static class JavaHeapMemoryInfo {
        private String TAG_FREE_MEMORY;
        private String TAG_MAX_MEMORY;
        private String TAG_TOTAL_MEMORY;
        public long freeMemory;
        public long maxMemory;
        public long totalMemory;

        public JavaHeapMemoryInfo() {
            this.TAG_FREE_MEMORY = "Free memory ";
            this.TAG_TOTAL_MEMORY = "Total memory ";
            this.TAG_MAX_MEMORY = "Max memory ";
        }

        private long getSize(int r3, String r4) {
            int r2 = 0;
        L4:
            if (r3 >= r4.length()) goto L11;
            char r0 = r4.charAt(r3);
            if (r0 < '0') goto L11;
            if (r0 > '9') goto L11;
            r2 = (r2 * 10) + (r0 - '0');
            r3 = r3 + 1;
        L11:
            return (r2 * 1024) * 1024;
        }

        public boolean parse(String r7) {
            if (r7.startsWith(this.TAG_FREE_MEMORY) == false) goto L9;
            long r2 = getSize(this.TAG_FREE_MEMORY.length(), r7);
            if (r2 <= 0) goto L7;
            this.freeMemory = r2;
        L7:
            return true;
        L9:
            if (r7.startsWith(this.TAG_TOTAL_MEMORY) == false) goto L13;
            this.totalMemory = getSize(this.TAG_TOTAL_MEMORY.length(), r7);
            return true;
        L13:
            if (r7.startsWith(this.TAG_MAX_MEMORY) == false) goto L16;
            this.maxMemory = getSize(this.TAG_MAX_MEMORY.length(), r7);
            return true;
        L16:
            return false;
        }
    }

    private static class ThreadBlock {
        private final ArrayList<String> mAllLines;
        JSONArray mBackupNativeStack;
        HashMap<String, JSONArray> mBackupNativeStackMap;
        private int mCpuCore;
        private int mHeldByThread;
        private boolean mIsAttached;
        private boolean mIsUseBackupNativeStack;
        private int mNice;
        private long mRunningTime;
        private int mStackLineIndex;
        private long mSwitchCount;
        private String mSysState;
        private int mSysTid;
        private long mSysTime;
        private String mThreadName;
        private long mUserTime;
        private String mVmState;
        private int mVmTid;
        private long mWaitingTime;

        ThreadBlock(ArrayList<String> r2, HashMap<String, JSONArray> r3) {
            this.mBackupNativeStack = null;
            this.mBackupNativeStackMap = null;
            this.mAllLines = r2;
            this.mBackupNativeStackMap = r3;
        }

        static /* synthetic */ String access$000(ThreadBlock r0) {
            return r0.getAllString();
        }

        static /* synthetic */ boolean access$100(ThreadBlock r0) {
            return r0.mIsUseBackupNativeStack;
        }

        static /* synthetic */ int access$1000(ThreadBlock r0) {
            return r0.mSysTid;
        }

        static /* synthetic */ int access$200(ThreadBlock r0) {
            return r0.mNice;
        }

        static /* synthetic */ String access$300(ThreadBlock r0) {
            return r0.mThreadName;
        }

        static /* synthetic */ long access$400(ThreadBlock r2) {
            return r2.mUserTime;
        }

        static /* synthetic */ long access$500(ThreadBlock r2) {
            return r2.mSysTime;
        }

        static /* synthetic */ String access$600(ThreadBlock r0) {
            return r0.mVmState;
        }

        static /* synthetic */ boolean access$700(ThreadBlock r0) {
            return r0.mIsAttached;
        }

        static /* synthetic */ ArrayList access$800(ThreadBlock r0) {
            return r0.mAllLines;
        }

        static /* synthetic */ boolean access$900(ThreadBlock r0) {
            return r0.parseAllLine();
        }

        private int findHeldByThreadVmTid(String r1) {
            if (r1.startsWith("  - waiting to lock") == false) goto L8;
            int r0 = r1.indexOf("held by thread ");
            if (r0 > 0) goto L7;
            return -1;
        L7:
            return Integer.parseInt(r1.substring(r0 + 15));
        L8:
            return -1;
        }

        private String getAllString() {
            StringBuilder r0 = new StringBuilder();
            Iterator<String> r4 = this.mAllLines.iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            r0.append((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin")).append('\n');
            goto L4
        L7:
            return r0.toString();
        }

        private boolean parseAllLine() {
            if (this.mAllLines.size() > 5) goto L6;
            return false;
        L6:
            if (parseThreadNameLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(0), String.class, "com.obric.memorydata.plugin")) == true) goto L9;
            return false;
        L9:
            if (this.mIsAttached == false) goto L13;
            int r4 = 2;
            if (parseGroupLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(1), String.class, "com.obric.memorydata.plugin")) == true) goto L14;
            return false;
        L14:
            int r5 = r4 + 1;
            if (parseSysTidLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(r4), String.class, "com.obric.memorydata.plugin")) == true) goto L17;
            return false;
        L17:
            int r6 = r5 + 1;
            if (parseSysStateLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(r5), String.class, "com.obric.memorydata.plugin")) == true) goto L21;
            return false;
        L21:
            if (this.mIsAttached == false) goto L27;
            int r7 = r6 + 1;
            if (parseStackLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(r6), String.class, "com.obric.memorydata.plugin")) == true) goto L25;
            return false;
        L25:
            r6 = r7;
        L27:
            if (this.mIsAttached == true) goto L29;
        L31:
            this.mStackLineIndex = r6 + parseNativeFailLine(this.mAllLines, r6);
            return true;
        L29:
            if (parseHeldMutexesLine((String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(r6), String.class, "com.obric.memorydata.plugin")) == false) goto L31;
            r6 = r6 + 1;
            goto L31
        L13:
            r4 = 1;
            goto L14
        }

        private boolean parseGroupLine(String r1) {
            return r1.startsWith("  | group=");
        }

        private boolean parseHeldMutexesLine(String r1) {
            return r1.startsWith("  | held mutexes=");
        }

        private int parseNativeFailLine(ArrayList<String> r5, int r6) {
            if (r6 < r5.size()) goto L5;
            return 0;
        L5:
            String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r6), String.class, "com.obric.memorydata.plugin");
            if (this.mBackupNativeStack != null) goto L8;
            return 0;
        L8:
            if (r7.contains(AnrTraceParser.TAG_NATIVE_BT_FAIL) == false) goto L21;
            this.mIsUseBackupNativeStack = true;
            this.mAllLines.remove(r6);     // Catch: Throwable -> L16
            int r8 = 0;
        L12:
            if (r8 >= this.mBackupNativeStack.length()) goto L14;
            this.mAllLines.add(r6, this.mBackupNativeStack.getString(r8));     // Catch: Throwable -> L16
            r8 = r8 + 1;     // Catch: Throwable -> L16
            r6 = r6 + 1;     // Catch: Throwable -> L16
            goto L12
        L14:
            return this.mBackupNativeStack.length();
        L22:
            return 0;
        L21:
            return 0;
        }

        private boolean parseStackLine(String r1) {
            return r1.startsWith("  | stack=");
        }

        private boolean parseSysStateLine(String r7) {
            Matcher r8 = Pattern.compile("^  \\| state=([A-Z?]) schedstat=\\((.*)\\) utm=(\\d+) stm=(\\d+) core=(\\d+) HZ=\\d+$").matcher(r7);
            if (r8.find() == true) goto L5;
        L13:
            return false;
        L5:
            if (r8.groupCount() != 5) goto L13;
            this.mSysState = r8.group(1);
            this.mUserTime = Long.parseLong(r8.group(3));
            this.mSysTime = Long.parseLong(r8.group(4));
            this.mCpuCore = Integer.parseInt(r8.group(5));
            String r9 = r8.group(2);
            if (r9 == null) goto L12;
            String[] r10 = r9.trim().split(" ");
            if (r10.length != 3) goto L12;
            this.mRunningTime = Long.parseLong(r10[0]);
            this.mWaitingTime = Long.parseLong(r10[1]);
            this.mSwitchCount = Long.parseLong(r10[2]);
        L12:
            return true;
        }

        private boolean parseSysTidLine(String r4) {
            Matcher r5 = Pattern.compile("^  \\| sysTid=(\\d+) nice=(-?)(\\d+) .*$").matcher(r4);
            if (r5.find() == true) goto L5;
            return false;
        L5:
            if (r5.groupCount() != 3) goto L16;
            this.mSysTid = Integer.parseInt(r5.group(1));
            this.mNice = Integer.parseInt(r5.group(3));
            if ("-".equals(r5.group(2)) == false) goto L10;
            this.mNice *= -1;
        L10:
            HashMap<String, JSONArray> r1 = this.mBackupNativeStackMap;
            if (r1 == null) goto L13;
            this.mBackupNativeStack = (JSONArray) ZeusTransformUtils.preCheckCast(r1.get(r5.group(1)), JSONArray.class, "com.obric.memorydata.plugin");
        L13:
            return true;
        L16:
            return false;
        }

        private boolean parseThreadNameLine(String r6) {
            Pattern r0 = Pattern.compile("^\"(.*)\"(?: daemon)? prio=-?\\d+ (.*)$");
            Pattern r1 = Pattern.compile("tid=(\\d+) ([a-zA-Z]+)$");
            Matcher r7 = r0.matcher(r6);
            if (r7.find() == true) goto L5;
        L16:
            return false;
        L5:
            if (r7.groupCount() != 2) goto L16;
            this.mThreadName = r7.group(1);
            String r8 = r7.group(2);
            Matcher r2 = r1.matcher(r8);
            if (r2.find() == false) goto L13;
            if (r2.groupCount() != 2) goto L13;
            this.mVmTid = Integer.parseInt(r2.group(1));
            this.mVmState = r2.group(2);
            this.mIsAttached = true;
        L15:
            return true;
        L13:
            if ("(not attached)".equals(r8) == false) goto L16;
            this.mIsAttached = false;
            goto L15
        }

        long getSysTick() {
            return this.mSysTime;
        }

        long getUserTick() {
            return this.mUserTime;
        }

        boolean isLockedByJava() {
            if (this.mVmState.equals("TimedWaiting") == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mVmState.equals("Waiting") == true) goto L10;
            if (this.mVmState.equals("Blocked") == true) goto L10;
            return false;
        }

        boolean isLockedByNative() {
            if (this.mVmState.equals("Native") == false) goto L20;
            int r0 = this.mStackLineIndex;
        L6:
            if (r0 >= this.mAllLines.size()) goto L29;
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.mAllLines.get(r0), String.class, "com.obric.memorydata.plugin");
            if (r1.startsWith("  at") == true) goto L10;
            if (r1.startsWith("  native: #") == false) goto L19;
            if (r1.contains("__futex_wait_ex") == true) goto L28;
            if (r1.startsWith("talkWithDriver") == false) goto L19;
            return true;
        L28:
            return true;
        L19:
            r0 = r0 + 1;
            goto L6
        L10:
            return r1.contains("BinderProxy.transactNative");
        L29:
            return false;
        L20:
            return false;
        }
    }

    AnrTraceParser(File r6, int r7) {
        ArrayList<ThreadBlock> r0 = new ArrayList();
        this.mBackupTraceFile = new File(r6, BACKUP_TRACE_FILE_NAME);
        ExtraInfo r1 = new ExtraInfo();
        JavaHeapMemoryInfo r2 = new JavaHeapMemoryInfo();
        ThreadBlock r8 = parseTraceFile(r6, r7, r0, r2, r1);
        int r3 = r0.size();
        if (r8 == null) goto L5;
        int r4 = 1;
    L6:
        this.mThreadCount = r3 + r4;
        this.mMainThread = r8;
        this.mSubThreadList = r0;
        this.mMemoryInfo = r2;
        this.mExtraInfo = r1;
        this.mDirectory = r6;
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private JSONObject getSubThreadList() {
        JSONArray r0 = new JSONArray();
        Iterator<ThreadBlock> r1 = this.mSubThreadList.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        ThreadBlock r2 = (ThreadBlock) ZeusTransformUtils.preCheckCast(r1.next(), ThreadBlock.class, "com.obric.memorydata.plugin");
        JSONArray r3 = new JSONArray();
        JSONObject r4 = new JSONObject();
        int r5 = 1;
    L16:
        if (r5 >= ThreadBlock.access$800(r2).size()) goto L9;
        r3.put(ThreadBlock.access$800(r2).get(r5));     // Catch: JSONException -> L14
        r5 = r5 + 1;     // Catch: JSONException -> L14
        goto L16
    L9:
        r4.put(LBSLightLocationTraceLogger.THREAD_NAME, ThreadBlock.access$800(r2).get(0));     // Catch: JSONException -> L14
        r4.put("thread_stack", r3);     // Catch: JSONException -> L14
        r0.put(r4);     // Catch: JSONException -> L14
        goto L4
    L11:
        JSONObject r6 = new JSONObject();
        r6.put("thread_stacks", r0);     // Catch: JSONException -> L15
        r6.put("thread_all_count", this.mThreadCount);     // Catch: JSONException -> L15
    L13:
        return r6;
    }

    static File getTraceFile(File r2) {
        return new File(r2, FILE_NAME);
    }

    private static HashMap<String, JSONArray> parseOtherNativeStack(File r4) {
        BufferedReader r0 = null;
        JSONArray r1 = null;
        if (r4 != null) goto L5;
    L26:
        return null;
    L5:
        if (r4.exists() == false) goto L26;
        HashMap<String, JSONArray> r2 = new HashMap();
        BufferedReader r3 = new BufferedReader(new FileReader(r4));     // Catch: Throwable -> L27
    L28:
        String r5 = r3.readLine();     // Catch: Throwable -> L23
        if (r5 == null) goto L22;
        if (TextUtils.isEmpty(r5) == true) goto L28;
        if (r5.contains("sysTid") == true) goto L16;
        if (r1 == null) goto L28;
        String r6 = r5.trim();     // Catch: Throwable -> L23
        if (r6.startsWith("#") == false) goto L28;
        r1.put(r6);     // Catch: Throwable -> L23
        goto L28
    L16:
        String r7 = r5.substring(r5.indexOf(61) + 1);     // Catch: Throwable -> L23
        r1 = new JSONArray();     // Catch: Throwable -> L23
        r1.put(DEFAULT_NATIVE_STACK_HEADER);     // Catch: Throwable -> L23
        r2.put(r7, r1);     // Catch: Throwable -> L23
        goto L28
    L22:
        FileSystemUtils.close(r3);
    L25:
        return r2;
    L23:
        r0 = r3;
    L24:
        FileSystemUtils.close(r0);
        goto L25
    }

    public static ThreadBlock parseTraceFile(File r5, int r6, ArrayList<ThreadBlock> r7, JavaHeapMemoryInfo r8, ExtraInfo r9) {
        File r0 = getTraceFile(r5);
        ThreadBlock r2 = null;
        if (r0.exists() == true) goto L5;
    L42:
        return r2;
    L5:
        if (r0.isDirectory() == true) goto L42;
        HashMap<String, JSONArray> r10 = parseOtherNativeStack(new File(r5, BACKUP_TRACE_FILE_NAME));
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream(r0)));
    L47:
        String r3 = r1.readLine();     // Catch: Throwable -> L43
        if (r3 == null) goto L41;
        if (r3.isEmpty() == true) goto L47;
        if (r9 == null) goto L19;
        if (r9.parse(r3) == true) goto L47;
    L19:
        if (r8 == null) goto L24;
        if (r8.parse(r3) == true) goto L47;
    L24:
        if (r3.charAt(0) != '\"') goto L47;
        if (r3.contains(" prio=") == false) goto L47;
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L43
    L29:
        r4.add(r3);     // Catch: Throwable -> L43
        r3 = r1.readLine();     // Catch: Throwable -> L43
        if (r3 == null) goto L34;
        if (r3.startsWith("  ") == true) goto L29;
    L34:
        ThreadBlock r11 = new ThreadBlock(r4, r10);     // Catch: Throwable -> L43
        if (ThreadBlock.access$900(r11) == false) goto L47;
        if (ThreadBlock.access$1000(r11) == r6) goto L38;
        r7.add(r11);     // Catch: Throwable -> L43
        goto L47
    L38:
        r2 = r11;
    L41:
        FileSystemUtils.close(r1);
        goto L42
    }

    String getMainStack() {
        ThreadBlock r0 = this.mMainThread;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ThreadBlock.access$000(r0);
    }

    long getSysTick() {
        ThreadBlock r2 = this.mMainThread;
        if (r2 != null) goto L5;
        return -1;
    L5:
        return r2.getSysTick();
    }

    long getUserTick() {
        ThreadBlock r2 = this.mMainThread;
        if (r2 != null) goto L5;
        return -1;
    L5:
        return r2.getUserTick();
    }

    boolean hasMainStack() {
        if (this.mMainThread == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLockedByJava() {
        ThreadBlock r0 = this.mMainThread;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLockedByJava() == false) goto L7;
        return true;
    }

    boolean isLockedByNative() {
        ThreadBlock r0 = this.mMainThread;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLockedByNative() == false) goto L7;
        return true;
    }

    boolean isPerformingGc() {
        ThreadBlock r1 = this.mMainThread;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ("WaitingPerformingGc".equals(ThreadBlock.access$600(r1)) == false) goto L7;
        return true;
    }

    boolean isWaitForGc() {
        ThreadBlock r0 = this.mMainThread;
        if (r0 != null) goto L5;
    L7:
        Iterator<ThreadBlock> r8 = this.mSubThreadList.iterator();
        int r3 = 0;
        int r4 = 0;
    L9:
        if (r8.hasNext() == false) goto L17;
        ThreadBlock r5 = (ThreadBlock) ZeusTransformUtils.preCheckCast(r8.next(), ThreadBlock.class, "com.obric.memorydata.plugin");
        if (ThreadBlock.access$700(r5) == false) goto L9;
        if ("WaitingForGcToComplete".equals(ThreadBlock.access$600(r5)) == false) goto L15;
        r3 = r3 + 1;
    L15:
        r4 = r4 + 1;
        goto L9
    L17:
        if (r3 < 5) goto L19;
        return true;
    L19:
        if ((r3 * 4) <= r4) goto L22;
        return true;
    L22:
        return false;
    L5:
        if ("WaitingForGcToComplete".equals(ThreadBlock.access$600(r0)) == false) goto L7;
        return true;
    }

    void pushToCrashBody(JSONObject r6) {
        JSONUtils.put(r6, JavaStack.ALL_THREAD_STACKS, getSubThreadList());
        JSONUtils.put(r6, "main_thread_cpu_tick", Long.valueOf(getSysTick() + getUserTick()));
        BuildId.putAnrBuildIDToJson(r6, getTraceFile(this.mDirectory));
        if (r6.optJSONObject("app_memory_info") == null) goto L6;
        return;
    L6:
        if (this.mMemoryInfo.maxMemory <= 0) goto L13;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r6.put("app_memory_info", r1);     // Catch: Throwable -> L9
        r1.put("max_memory", this.mMemoryInfo.maxMemory);     // Catch: Throwable -> L9
        r1.put("free_memory", this.mMemoryInfo.freeMemory);     // Catch: Throwable -> L9
        r1.put("total_memory", this.mMemoryInfo.totalMemory);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    void pushToFilters(JSONObject r18, JSONObject r19) {
        if (this.mSubThreadList.isEmpty() == true) goto L5;
        JSONUtils.put(r19, "anr_replace_mainstack", "OnlyJavaStack");
    L5:
        ThreadBlock r3 = this.mMainThread;
        boolean r4 = false;
        if (r3 == null) goto L8;
        boolean r2 = ThreadBlock.access$100(r3);
        int r5 = ThreadBlock.access$200(this.mMainThread);
    L9:
        long[] r6 = {0, 0, 0};
        Iterator<ThreadBlock> r7 = this.mSubThreadList.iterator();
        String r8 = "unknown";
        int r10 = 0;
        String r9 = "unknown";
        String r11 = r9;
    L11:
        if (r7.hasNext() == false) goto L29;
        ThreadBlock r12 = (ThreadBlock) ZeusTransformUtils.preCheckCast(r7.next(), ThreadBlock.class, "com.obric.memorydata.plugin");
        if ("RenderThread".equals(ThreadBlock.access$300(r12)) == false) goto L16;
        JSONUtils.put(r19, "anr_renderthread_nice", Integer.valueOf(ThreadBlock.access$200(r12)));
    L20:
        r2 = r2 | ThreadBlock.access$100(r12);
        if (ThreadBlock.access$400(r12) <= r6[0]) goto L24;
        r6[0] = ThreadBlock.access$400(r12);
        r8 = ThreadBlock.access$300(r12);
    L24:
        if (ThreadBlock.access$500(r12) <= r6[1]) goto L27;
        r6[1] = ThreadBlock.access$500(r12);
        r9 = ThreadBlock.access$300(r12);
    L27:
        if ((ThreadBlock.access$400(r12) + ThreadBlock.access$500(r12)) <= r6[2]) goto L11;
        r6[2] = ThreadBlock.access$400(r12) + ThreadBlock.access$500(r12);
        r11 = ThreadBlock.access$300(r12);
        goto L11
    L16:
        if (ThreadBlock.access$200(r12) >= r5) goto L20;
        if (ThreadBlock.access$200(r12) > (-16)) goto L20;
        r10 = r10 + 1;
        goto L20
    L29:
        JSONUtils.put(r19, "anr_trace_has_mainstack", Boolean.valueOf(hasMainStack()));
        JSONUtils.put(r19, "anr_trace_cost_time", this.mExtraInfo.timeRangeStr);
        JSONUtils.put(r19, "anr_trace_crash", Boolean.valueOf(this.mExtraInfo.dumpCrash));
        if (this.mExtraInfo.dumpSuccess == true) goto L32;
    L36:
        JSONUtils.put(r19, "anr_trace_done", Boolean.valueOf(r4));
        JSONUtils.put(r19, "anr_trace_thread_count", ProcInfo.getThreadCountRange(this.mSubThreadList.size() + 1));
        JSONUtils.put(r19, "max_utm_thread", r8);
        JSONUtils.put(r19, "max_stm_thread", r9);
        JSONUtils.put(r19, "max_utm_stm_thread", r11);
        JSONUtils.put(r19, "anr_backup_native_stack", Boolean.valueOf(r2));
        JSONUtils.put(r19, "anr_subthread_count_nice<=-16", Integer.valueOf(r10));
        JSONUtils.put(r19, "npth_is_wait_for_gc", Boolean.valueOf(isWaitForGc()));
        CrashFilter.appendJavaHeapFilters(r19, r18);
        File r13 = this.mBackupTraceFile;
        if (r13 != null) goto L39;
    L46:
        JSONUtils.put(r19, FILTER_ANR_DUMP_ASYNC, "false");
        return;
    L39:
        if (r13.exists() == false) goto L46;
        if (this.mBackupTraceFile.length() <= 1024) goto L44;
        String r14 = "success";
    L45:
        JSONUtils.put(r19, FILTER_ANR_DUMP_ASYNC, r14);
        this.mBackupTraceFile.delete();
        return;
    L44:
        r14 = "fail";
        goto L45
    L32:
        if (this.mMainThread == null) goto L36;
        if (this.mSubThreadList.isEmpty() == true) goto L36;
        r4 = true;
        goto L36
    L8:
        r5 = -10;
        r2 = false;
        goto L9
    }
}
