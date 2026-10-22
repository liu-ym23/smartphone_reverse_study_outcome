package com.bytedance.crash.anr;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.entity.CrashFilter;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
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

/* JADX INFO: loaded from: classes.dex */
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

        private static String getTimeRange(String r10) {
            long r11 = Long.parseLong(r10);     // Catch: Throwable -> L68
            if (r11 > 50) goto L7;
            return "0~50ms";
        L7:
            if (r11 > 100) goto L11;
            return "50~100ms";
        L11:
            if (r11 > 150) goto L15;
            return "100~150ms";
        L15:
            if (r11 > 200) goto L19;
            return "150~200ms";
        L19:
            if (r11 > 300) goto L23;
            return "200~300ms";
        L23:
            if (r11 > 400) goto L27;
            return "300~400ms";
        L27:
            if (r11 > 500) goto L31;
            return "400~500ms";
        L31:
            if (r11 > 700) goto L35;
            return "500~700ms";
        L35:
            if (r11 > 1000) goto L39;
            return "700~1000ms";
        L39:
            if (r11 > 1500) goto L43;
            return "1000~1500ms";
        L43:
            if (r11 > 2000) goto L47;
            return "1500~2000ms";
        L47:
            if (r11 > WsConstants.EXIT_DELAY_TIME) goto L51;
            return "2000~3000ms";
        L51:
            if (r11 > 4000) goto L55;
            return "3000~4000ms";
        L55:
            if (r11 > 5000) goto L59;
            return "4000~5000ms";
        L59:
            if (r11 > 7000) goto L63;
            return "5000~7000ms";
        L63:
            if (r11 > WorkRequest.MIN_BACKOFF_MILLIS) goto L66;
            return "7000~10000ms";
        L66:
            return "> 10000ms";
        L68:
            return "none";
        }

        public boolean parse(String r10) {
            if (r10.startsWith("Dump cost time:") == false) goto L9;
            this.dumpSuccess = true;
            int r11 = r10.indexOf(58);
            if (r11 == (-1)) goto L7;
            this.timeRangeStr = getTimeRange(r10.substring(r11 + 1).trim());
        L7:
            return true;
        L9:
            if (r10.startsWith("Dump crash") == false) goto L12;
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

        private long getSize(int r10, String r11) {
            int r12 = 0;
        L4:
            if (r10 >= r11.length()) goto L11;
            char r13 = r11.charAt(r10);
            if (r13 < '0') goto L11;
            if (r13 > '9') goto L11;
            r12 = (r12 * 10) + (r13 - '0');
            r10 = r10 + 1;
        L11:
            return (r12 * 1024) * 1024;
        }

        public boolean parse(String r10) {
            if (r10.startsWith(this.TAG_FREE_MEMORY) == false) goto L9;
            long r11 = getSize(this.TAG_FREE_MEMORY.length(), r10);
            if (r11 <= 0) goto L7;
            this.freeMemory = r11;
        L7:
            return true;
        L9:
            if (r10.startsWith(this.TAG_TOTAL_MEMORY) == false) goto L13;
            this.totalMemory = getSize(this.TAG_TOTAL_MEMORY.length(), r10);
            return true;
        L13:
            if (r10.startsWith(this.TAG_MAX_MEMORY) == false) goto L16;
            this.maxMemory = getSize(this.TAG_MAX_MEMORY.length(), r10);
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

        ThreadBlock(ArrayList<String> r10, HashMap<String, JSONArray> r11) {
            this.mBackupNativeStack = null;
            this.mBackupNativeStackMap = null;
            this.mAllLines = r10;
            this.mBackupNativeStackMap = r11;
        }

        static /* synthetic */ String access$000(ThreadBlock r10) {
            return r10.getAllString();
        }

        static /* synthetic */ boolean access$100(ThreadBlock r10) {
            return r10.mIsUseBackupNativeStack;
        }

        static /* synthetic */ int access$1000(ThreadBlock r10) {
            return r10.mSysTid;
        }

        static /* synthetic */ int access$200(ThreadBlock r10) {
            return r10.mNice;
        }

        static /* synthetic */ String access$300(ThreadBlock r10) {
            return r10.mThreadName;
        }

        static /* synthetic */ long access$400(ThreadBlock r10) {
            return r10.mUserTime;
        }

        static /* synthetic */ long access$500(ThreadBlock r10) {
            return r10.mSysTime;
        }

        static /* synthetic */ String access$600(ThreadBlock r10) {
            return r10.mVmState;
        }

        static /* synthetic */ boolean access$700(ThreadBlock r10) {
            return r10.mIsAttached;
        }

        static /* synthetic */ ArrayList access$800(ThreadBlock r10) {
            return r10.mAllLines;
        }

        static /* synthetic */ boolean access$900(ThreadBlock r10) {
            return r10.parseAllLine();
        }

        private int findHeldByThreadVmTid(String r10) {
            if (r10.startsWith("  - waiting to lock") == false) goto L8;
            int r11 = r10.indexOf("held by thread ");
            if (r11 > 0) goto L7;
            return -1;
        L7:
            return Integer.parseInt(r10.substring(r11 + 15));
        L8:
            return -1;
        }

        private String getAllString() {
            StringBuilder r10 = new StringBuilder();
            Iterator<String> r11 = this.mAllLines.iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            r10.append(r11.next());
            r10.append('\n');
            goto L4
        L7:
            return r10.toString();
        }

        private boolean parseAllLine() {
            if (this.mAllLines.size() > 5) goto L6;
            return false;
        L6:
            if (parseThreadNameLine(this.mAllLines.get(0)) == true) goto L9;
            return false;
        L9:
            if (this.mIsAttached == false) goto L13;
            int r10 = 2;
            if (parseGroupLine(this.mAllLines.get(1)) == true) goto L14;
            return false;
        L14:
            int r11 = r10 + 1;
            if (parseSysTidLine(this.mAllLines.get(r10)) == true) goto L17;
            return false;
        L17:
            int r12 = r11 + 1;
            if (parseSysStateLine(this.mAllLines.get(r11)) == true) goto L21;
            return false;
        L21:
            if (this.mIsAttached == false) goto L27;
            int r13 = r12 + 1;
            if (parseStackLine(this.mAllLines.get(r12)) == true) goto L25;
            return false;
        L25:
            r12 = r13;
        L27:
            if (this.mIsAttached == true) goto L29;
        L31:
            this.mStackLineIndex = r12 + parseNativeFailLine(this.mAllLines, r12);
            return true;
        L29:
            if (parseHeldMutexesLine(this.mAllLines.get(r12)) == false) goto L31;
            r12 = r12 + 1;
            goto L31
        L13:
            r10 = 1;
            goto L14
        }

        private boolean parseGroupLine(String r10) {
            return r10.startsWith("  | group=");
        }

        private boolean parseHeldMutexesLine(String r10) {
            return r10.startsWith("  | held mutexes=");
        }

        private int parseNativeFailLine(ArrayList<String> r10, int r11) {
            if (r11 < r10.size()) goto L5;
            return 0;
        L5:
            String r12 = r10.get(r11);
            if (this.mBackupNativeStack != null) goto L8;
            return 0;
        L8:
            if (r12.contains(AnrTraceParser.TAG_NATIVE_BT_FAIL) == false) goto L21;
            this.mIsUseBackupNativeStack = true;
            this.mAllLines.remove(r11);     // Catch: Throwable -> L16
            int r13 = 0;
        L12:
            if (r13 >= this.mBackupNativeStack.length()) goto L14;
            this.mAllLines.add(r11, this.mBackupNativeStack.getString(r13));     // Catch: Throwable -> L16
            r13 = r13 + 1;     // Catch: Throwable -> L16
            r11 = r11 + 1;     // Catch: Throwable -> L16
            goto L12
        L14:
            return this.mBackupNativeStack.length();
        L22:
            return 0;
        L21:
            return 0;
        }

        private boolean parseStackLine(String r10) {
            return r10.startsWith("  | stack=");
        }

        private boolean parseSysStateLine(String r10) {
            Matcher r11 = Pattern.compile("^  \\| state=([A-Z?]) schedstat=\\((.*)\\) utm=(\\d+) stm=(\\d+) core=(\\d+) HZ=\\d+$").matcher(r10);
            if (r11.find() == true) goto L5;
        L13:
            return false;
        L5:
            if (r11.groupCount() != 5) goto L13;
            this.mSysState = r11.group(1);
            this.mUserTime = Long.parseLong(r11.group(3));
            this.mSysTime = Long.parseLong(r11.group(4));
            this.mCpuCore = Integer.parseInt(r11.group(5));
            String r12 = r11.group(2);
            if (r12 == null) goto L12;
            String[] r13 = r12.trim().split(" ");
            if (r13.length != 3) goto L12;
            this.mRunningTime = Long.parseLong(r13[0]);
            this.mWaitingTime = Long.parseLong(r13[1]);
            this.mSwitchCount = Long.parseLong(r13[2]);
        L12:
            return true;
        }

        private boolean parseSysTidLine(String r10) {
            Matcher r11 = Pattern.compile("^  \\| sysTid=(\\d+) nice=(-?)(\\d+) .*$").matcher(r10);
            if (r11.find() == true) goto L5;
            return false;
        L5:
            if (r11.groupCount() != 3) goto L16;
            this.mSysTid = Integer.parseInt(r11.group(1));
            this.mNice = Integer.parseInt(r11.group(3));
            if ("-".equals(r11.group(2)) == false) goto L10;
            this.mNice *= -1;
        L10:
            HashMap<String, JSONArray> r12 = this.mBackupNativeStackMap;
            if (r12 == null) goto L13;
            this.mBackupNativeStack = r12.get(r11.group(1));
        L13:
            return true;
        L16:
            return false;
        }

        private boolean parseThreadNameLine(String r10) {
            Pattern r11 = Pattern.compile("^\"(.*)\"(?: daemon)? prio=-?\\d+ (.*)$");
            Pattern r12 = Pattern.compile("tid=(\\d+) ([a-zA-Z]+)$");
            Matcher r13 = r11.matcher(r10);
            if (r13.find() == true) goto L5;
        L16:
            return false;
        L5:
            if (r13.groupCount() != 2) goto L16;
            this.mThreadName = r13.group(1);
            String r14 = r13.group(2);
            Matcher r15 = r12.matcher(r14);
            if (r15.find() == false) goto L13;
            if (r15.groupCount() != 2) goto L13;
            this.mVmTid = Integer.parseInt(r15.group(1));
            this.mVmState = r15.group(2);
            this.mIsAttached = true;
        L15:
            return true;
        L13:
            if ("(not attached)".equals(r14) == false) goto L16;
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
            int r10 = this.mStackLineIndex;
        L6:
            if (r10 >= this.mAllLines.size()) goto L29;
            String r11 = this.mAllLines.get(r10);
            if (r11.startsWith("  at") == true) goto L10;
            if (r11.startsWith("  native: #") == false) goto L19;
            if (r11.contains("__futex_wait_ex") == true) goto L28;
            if (r11.startsWith("talkWithDriver") == false) goto L19;
            return true;
        L28:
            return true;
        L19:
            r10 = r10 + 1;
            goto L6
        L10:
            return r11.contains("BinderProxy.transactNative");
        L29:
            return false;
        L20:
            return false;
        }
    }

    AnrTraceParser(File r10, int r11) {
        ArrayList<ThreadBlock> r12 = new ArrayList();
        this.mBackupTraceFile = new File(r10, BACKUP_TRACE_FILE_NAME);
        ExtraInfo r13 = new ExtraInfo();
        JavaHeapMemoryInfo r14 = new JavaHeapMemoryInfo();
        ThreadBlock r15 = parseTraceFile(r10, r11, r12, r14, r13);
        int r16 = r12.size();
        if (r15 == null) goto L5;
        int r17 = 1;
    L6:
        this.mThreadCount = r16 + r17;
        this.mMainThread = r15;
        this.mSubThreadList = r12;
        this.mMemoryInfo = r14;
        this.mExtraInfo = r13;
        this.mDirectory = r10;
        return;
    L5:
        r17 = 0;
        goto L6
    }

    private JSONObject getSubThreadList() {
        JSONArray r10 = new JSONArray();
        Iterator<ThreadBlock> r11 = this.mSubThreadList.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        ThreadBlock r12 = r11.next();
        JSONArray r13 = new JSONArray();
        JSONObject r14 = new JSONObject();
        int r15 = 1;
    L18:
        if (r15 >= ThreadBlock.access$800(r12).size()) goto L9;
        r13.put(ThreadBlock.access$800(r12).get(r15));     // Catch: JSONException -> L14
        r15 = r15 + 1;     // Catch: JSONException -> L14
        goto L18
    L9:
        r14.put("thread_name", ThreadBlock.access$800(r12).get(0));     // Catch: JSONException -> L14
        r14.put("thread_stack", r13);     // Catch: JSONException -> L14
        r10.put(r14);     // Catch: JSONException -> L14
        goto L4
    L11:
        JSONObject r16 = new JSONObject();
        r16.put("thread_stacks", r10);     // Catch: JSONException -> L15
        r16.put("thread_all_count", this.mThreadCount);     // Catch: JSONException -> L15
    L13:
        return r16;
    }

    static File getTraceFile(File r10) {
        return new File(r10, FILE_NAME);
    }

    private static HashMap<String, JSONArray> parseOtherNativeStack(File r10) {
        BufferedReader r11 = null;
        JSONArray r12 = null;
        if (r10 != null) goto L5;
    L26:
        return null;
    L5:
        if (r10.exists() == false) goto L26;
        HashMap<String, JSONArray> r13 = new HashMap();
        BufferedReader r14 = new BufferedReader(new FileReader(r10));     // Catch: Throwable -> L27
    L28:
        String r15 = r14.readLine();     // Catch: Throwable -> L23
        if (r15 == null) goto L22;
        if (TextUtils.isEmpty(r15) == true) goto L28;
        if (r15.contains("sysTid") == true) goto L16;
        if (r12 == null) goto L28;
        String r16 = r15.trim();     // Catch: Throwable -> L23
        if (r16.startsWith("#") == false) goto L28;
        r12.put(r16);     // Catch: Throwable -> L23
        goto L28
    L16:
        String r17 = r15.substring(r15.indexOf(61) + 1);     // Catch: Throwable -> L23
        r12 = new JSONArray();     // Catch: Throwable -> L23
        r12.put(DEFAULT_NATIVE_STACK_HEADER);     // Catch: Throwable -> L23
        r13.put(r17, r12);     // Catch: Throwable -> L23
        goto L28
    L22:
        FileSystemUtils.close(r14);
    L25:
        return r13;
    L23:
        r11 = r14;
    L24:
        FileSystemUtils.close(r11);
        goto L25
    }

    public static ThreadBlock parseTraceFile(File r10, int r11, ArrayList<ThreadBlock> r12, JavaHeapMemoryInfo r13, ExtraInfo r14) {
        File r15 = getTraceFile(r10);
        ThreadBlock r16 = null;
        if (r15.exists() == true) goto L5;
    L42:
        return r16;
    L5:
        if (r15.isDirectory() == true) goto L42;
        HashMap<String, JSONArray> r17 = parseOtherNativeStack(new File(r10, BACKUP_TRACE_FILE_NAME));
        BufferedReader r18 = new BufferedReader(new InputStreamReader(new FileInputStream(r15)));
    L47:
        String r19 = r18.readLine();     // Catch: Throwable -> L43
        if (r19 == null) goto L41;
        if (r19.isEmpty() == true) goto L47;
        if (r14 == null) goto L19;
        if (r14.parse(r19) == true) goto L47;
    L19:
        if (r13 == null) goto L24;
        if (r13.parse(r19) == true) goto L47;
    L24:
        if (r19.charAt(0) != '\"') goto L47;
        if (r19.contains(" prio=") == false) goto L47;
        ArrayList r20 = new ArrayList();     // Catch: Throwable -> L43
    L29:
        r20.add(r19);     // Catch: Throwable -> L43
        r19 = r18.readLine();     // Catch: Throwable -> L43
        if (r19 == null) goto L34;
        if (r19.startsWith("  ") == true) goto L29;
    L34:
        ThreadBlock r21 = new ThreadBlock(r20, r17);     // Catch: Throwable -> L43
        if (ThreadBlock.access$900(r21) == false) goto L47;
        if (ThreadBlock.access$1000(r21) == r11) goto L38;
        r12.add(r21);     // Catch: Throwable -> L43
        goto L47
    L38:
        r16 = r21;
    L41:
        FileSystemUtils.close(r18);
        goto L42
    }

    String getMainStack() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L7;
        return null;
    L7:
        return ThreadBlock.access$000(r10);
    }

    long getSysTick() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.getSysTick();
    }

    long getUserTick() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.getUserTick();
    }

    boolean hasMainStack() {
        if (this.mMainThread == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLockedByJava() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isLockedByJava() == false) goto L7;
        return true;
    }

    boolean isLockedByNative() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isLockedByNative() == false) goto L7;
        return true;
    }

    boolean isPerformingGc() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ("WaitingPerformingGc".equals(ThreadBlock.access$600(r10)) == false) goto L7;
        return true;
    }

    boolean isWaitForGc() {
        ThreadBlock r10 = this.mMainThread;
        if (r10 != null) goto L5;
    L7:
        Iterator<ThreadBlock> r11 = this.mSubThreadList.iterator();
        int r12 = 0;
        int r13 = 0;
    L9:
        if (r11.hasNext() == false) goto L17;
        ThreadBlock r14 = r11.next();
        if (ThreadBlock.access$700(r14) == false) goto L9;
        if ("WaitingForGcToComplete".equals(ThreadBlock.access$600(r14)) == false) goto L15;
        r12 = r12 + 1;
    L15:
        r13 = r13 + 1;
        goto L9
    L17:
        if (r12 < 5) goto L19;
        return true;
    L19:
        if ((r12 * 4) <= r13) goto L22;
        return true;
    L22:
        return false;
    L5:
        if ("WaitingForGcToComplete".equals(ThreadBlock.access$600(r10)) == false) goto L7;
        return true;
    }

    void pushToCrashBody(@NonNull JSONObject r10) {
        JSONUtils.put(r10, JavaStack.ALL_THREAD_STACKS, getSubThreadList());
        JSONUtils.put(r10, "main_thread_cpu_tick", Long.valueOf(getSysTick() + getUserTick()));
        BuildId.putAnrBuildIDToJson(r10, getTraceFile(this.mDirectory));
        if (r10.optJSONObject("app_memory_info") == null) goto L6;
        return;
    L6:
        if (this.mMemoryInfo.maxMemory <= 0) goto L13;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L9
        r10.put("app_memory_info", r11);     // Catch: Throwable -> L9
        r11.put("max_memory", this.mMemoryInfo.maxMemory);     // Catch: Throwable -> L9
        r11.put("free_memory", this.mMemoryInfo.freeMemory);     // Catch: Throwable -> L9
        r11.put("total_memory", this.mMemoryInfo.totalMemory);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    void pushToFilters(JSONObject r18, @NonNull JSONObject r19) {
        if (this.mSubThreadList.isEmpty() == true) goto L5;
        JSONUtils.put(r19, "anr_replace_mainstack", "OnlyJavaStack");
    L5:
        ThreadBlock r10 = this.mMainThread;
        boolean r11 = false;
        if (r10 == null) goto L8;
        boolean r12 = ThreadBlock.access$100(r10);
        int r13 = ThreadBlock.access$200(this.mMainThread);
    L9:
        long[] r14 = {0, 0, 0};
        Iterator<ThreadBlock> r15 = this.mSubThreadList.iterator();
        String r16 = "unknown";
        int r17 = 0;
        String r20 = "unknown";
        String r21 = r20;
    L11:
        if (r15.hasNext() == false) goto L29;
        ThreadBlock r110 = r15.next();
        if ("RenderThread".equals(ThreadBlock.access$300(r110)) == false) goto L16;
        JSONUtils.put(r19, "anr_renderthread_nice", Integer.valueOf(ThreadBlock.access$200(r110)));
    L20:
        r12 = r12 | ThreadBlock.access$100(r110);
        if (ThreadBlock.access$400(r110) <= r14[0]) goto L24;
        r14[0] = ThreadBlock.access$400(r110);
        r16 = ThreadBlock.access$300(r110);
    L24:
        if (ThreadBlock.access$500(r110) <= r14[1]) goto L27;
        r14[1] = ThreadBlock.access$500(r110);
        r20 = ThreadBlock.access$300(r110);
    L27:
        if ((ThreadBlock.access$400(r110) + ThreadBlock.access$500(r110)) <= r14[2]) goto L11;
        r14[2] = ThreadBlock.access$400(r110) + ThreadBlock.access$500(r110);
        r21 = ThreadBlock.access$300(r110);
        goto L11
    L16:
        if (ThreadBlock.access$200(r110) >= r13) goto L20;
        if (ThreadBlock.access$200(r110) > (-16)) goto L20;
        r17 = r17 + 1;
        goto L20
    L29:
        JSONUtils.put(r19, "anr_trace_has_mainstack", Boolean.valueOf(hasMainStack()));
        JSONUtils.put(r19, "anr_trace_cost_time", this.mExtraInfo.timeRangeStr);
        JSONUtils.put(r19, "anr_trace_crash", Boolean.valueOf(this.mExtraInfo.dumpCrash));
        if (this.mExtraInfo.dumpSuccess == true) goto L32;
    L36:
        JSONUtils.put(r19, "anr_trace_done", Boolean.valueOf(r11));
        JSONUtils.put(r19, "anr_trace_thread_count", ProcInfo.getThreadCountRange(this.mSubThreadList.size() + 1));
        JSONUtils.put(r19, "max_utm_thread", r16);
        JSONUtils.put(r19, "max_stm_thread", r20);
        JSONUtils.put(r19, "max_utm_stm_thread", r21);
        JSONUtils.put(r19, "anr_backup_native_stack", Boolean.valueOf(r12));
        JSONUtils.put(r19, "anr_subthread_count_nice<=-16", Integer.valueOf(r17));
        JSONUtils.put(r19, "npth_is_wait_for_gc", Boolean.valueOf(isWaitForGc()));
        CrashFilter.appendJavaHeapFilters(r19, r18);
        File r22 = this.mBackupTraceFile;
        if (r22 != null) goto L39;
    L46:
        JSONUtils.put(r19, FILTER_ANR_DUMP_ASYNC, "false");
        return;
    L39:
        if (r22.exists() == false) goto L46;
        if (this.mBackupTraceFile.length() <= 1024) goto L44;
        String r23 = "success";
    L45:
        JSONUtils.put(r19, FILTER_ANR_DUMP_ASYNC, r23);
        this.mBackupTraceFile.delete();
        return;
    L44:
        r23 = "fail";
        goto L45
    L32:
        if (this.mMainThread == null) goto L36;
        if (this.mSubThreadList.isEmpty() == true) goto L36;
        r11 = true;
        goto L36
    L8:
        r13 = -10;
        r12 = false;
        goto L9
    }
}
