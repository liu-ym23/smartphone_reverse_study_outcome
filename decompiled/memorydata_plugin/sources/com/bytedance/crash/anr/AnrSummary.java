package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.ProcessState;
import com.bytedance.crash.dumper.tools.StringDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageParser;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.terminate.AnrHistoryProcessExitParser;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnrSummary extends CrashSummary {
    private static final String CRASH_TIME_TAG = "crash_time=";
    public static final String FILE_NAME = null;
    private static final String FROM_SIG_TAG = "by_signal=";
    public static final String NO_STACK_ANR = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    private static final String PID_TAG = "pid=";
    private static final String PROCESS_NAME_TAG = "process_name=";
    private static final String START_TIME_TAG = "start_time=";
    private static final String START_UP_TIME_TAG = "start_up_time=";
    private static final String TRIGGER_TAG = "trigger=";
    private static final Pattern sContentPattern = null;
    private AnrInfoParser mAnrInfoParser;
    private AnrProfiler.Parser mAnrProfilerParser;
    private final AnrTraceParser mAnrTraceParser;
    private final boolean mBySignal;
    private LooperMessageParser mLooperManagerParser;
    private String mMainStack;
    private final int mTrigger;

    static {
        FILE_NAME = CrashType.ANR + ".summary";
        sContentPattern = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\npid=(\\d+)\\nby_signal=(true|false)\\n(?:trigger=(\\d+)\\n?)?");
    }

    public AnrSummary(File r15, long r16, long r18, long r20, String r22, int r23, int r24, boolean r25) {
        super(r15, CrashType.ANR, r16, r18, r20, r22, "main", r23, r23);
        this.mBySignal = r25;
        this.mTrigger = r24;
        this.mAnrTraceParser = new AnrTraceParser(r15, r23);
        this.mStackTrace = loadStackTrace();
    }

    private void appendMainStackToCustom(JSONObject r5) {
        if (JavaStack.isStackFromTrace(r5.optString("data")) == true) goto L5;
        return;
    L5:
        String r4 = JavaStack.getMainStack(this.mDirectory);
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        String[] r6 = r4.split("\n");
        JSONArray r0 = new JSONArray();
        int r1 = r6.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r0.put(r6[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        CustomLong.add(r5, "main_stack_2nd", r0);
    }

    static void dump(File r7, long r8, boolean r10, int r11) {
        StringDumper r0 = new StringDumper(r7 + "/" + FILE_NAME);
        String r9 = App.getProcessName();
        long r1 = Global.getAppStartTime();
        long r3 = Global.getAppStartUpTime();
        r0.append(START_TIME_TAG).append(r1).append('\n').append(START_UP_TIME_TAG).append(r3).append('\n').append(CRASH_TIME_TAG).append(r8).append('\n').append(PROCESS_NAME_TAG).append(r9).append('\n').append(PID_TAG).append(Process.myPid()).append('\n').append(FROM_SIG_TAG).append(r10).append('\n').append(TRIGGER_TAG).append(r11).append('\n').release();
    }

    static boolean hasSummaryFile(File r2) {
        return new File(r2, FILE_NAME).exists();
    }

    private static AnrSummary load(File r14) {
        String r0 = FileSystemUtils.readUtf8File(r14);
        if (TextUtils.isEmpty(r0) == true) goto L18;
        Matcher r1 = sContentPattern.matcher(r0);     // Catch: Throwable -> L12
        if (r1.find() == false) goto L19;
        long r4 = Long.parseLong(r1.group(1));     // Catch: Throwable -> L12
        long r6 = Long.parseLong(r1.group(2));     // Catch: Throwable -> L12
        long r8 = Long.parseLong(r1.group(3));     // Catch: Throwable -> L12
        String r10 = r1.group(4);     // Catch: Throwable -> L12
        int r11 = Integer.parseInt(r1.group(5));     // Catch: Throwable -> L12
        boolean r13 = Boolean.parseBoolean(r1.group(6));     // Catch: Throwable -> L12
        if (r1.group(7) == null) goto L9;
        int r12 = Integer.parseInt(r1.group(7));     // Catch: Throwable -> L12
    L10:
        return new AnrSummary(r14.getParentFile(), r4, r6, r8, r10, r11, r12, r13);
    L9:
        r12 = 9999;
        goto L10
    L19:
        return null;
    L12:
        th = move-exception;
        NpthMonitor.reportInnerException("NPTH_ANR_ERROR_LOAD", th);
        return null;
    L18:
        return null;
    }

    public static AnrSummary loadFromDirectory(File r2) {
        return load(new File(r2, FILE_NAME));
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r4) {
        JSONObject r0 = JSONUtils.get(r4, "filters");
        if (this.mBySignal == false) goto L5;
        String r1 = "true";
    L6:
        JSONUtils.put(r0, "by_signal", r1);
        JSONUtils.put(r0, "anr_trigger", Integer.valueOf(this.mTrigger));
        this.mAnrTraceParser.pushToFilters(r4, r0);
        AnrInfoParser r2 = this.mAnrInfoParser;
        if (r2 == null) goto L9;
        r2.pushToFilter(r0);
    L9:
        AnrProfiler.Parser r3 = this.mAnrProfilerParser;
        if (r3 == null) goto L12;
        r3.pushToFilters(r0);
    L12:
        LooperMessageParser.pushToFilters(r4, r0);
        AnrDumper.ConfigDump.push(this.mDirectory, r0);
        EvilDumpFile.push(this.mDirectory, r0);
        ProcessState.pushFilters(this.mDirectory, r4, r0);
        AnrHistoryProcessExitParser.pushToFilters(r4, r0);
        JSONUtils.put(r0, "malloc_type", NativeBridge.getMallocType());
        return;
    L5:
        r1 = "false";
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(CrashBody r6, Header r7) {
        r6.put("is_anr", 1);     // Catch: Throwable -> L4
        this.mAnrTraceParser.pushToCrashBody(r6.getJson());     // Catch: Throwable -> L4
        AnrInfoParser r0 = new AnrInfoParser(this.mDirectory);     // Catch: Throwable -> L4
        this.mAnrInfoParser = r0;     // Catch: Throwable -> L4
        r0.pushToCrashBody(r6.getJson());     // Catch: Throwable -> L4
        LooperMessageParser.pushToCrashBody(r6.getJson());     // Catch: Throwable -> L4
        Logcat.pushToAnrFeature(r6.getJson());     // Catch: Throwable -> L4
        AnrProfiler.Parser r1 = new AnrProfiler.Parser(this.mDirectory, r6.getJson(), this.mAnrTraceParser, this.mAnrInfoParser);     // Catch: Throwable -> L4
        this.mAnrProfilerParser = r1;     // Catch: Throwable -> L4
        r1.pushToCrashBody(r6.getJson(), this.mDirectory);     // Catch: Throwable -> L4
        appendMainStackToCustom(r6.getJson());     // Catch: Throwable -> L4
        AnrHistoryProcessExitParser.parseProcessExitReason(r6.getJson());     // Catch: Throwable -> L4
    L7:
        if (this.mAnrInfoParser.isValid() == true) goto L9;
    L17:
        JSONUtils.put(r7.getJson(), "aid", 2010);
        return;
    L9:
        if (this.mMainStack == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L17;
        if (GlobalSwitch.isFilterNotAnr() == false) goto L21;
        String r5 = r6.getJson().optString(Constants.EXIT_REASON);
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return;
    L16:
        if (r5.contains("6") == false) goto L17;
        return;
    L21:
        return;
    L4:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L7
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void loadCrashInfo(JSONObject r1, JSONObject r2, File r3) {
        AnrDumper.loadCrashInfo(r1, r2, r3);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        JSONObject r0 = new JSONObject();
        String r1 = this.mAnrTraceParser.getMainStack();
        this.mMainStack = r1;
        if (TextUtils.isEmpty(r1) == false) goto L6;
        this.mMainStack = JavaStack.getMainStack(this.mDirectory);
    L6:
        if (TextUtils.isEmpty(this.mMainStack) == false) goto L16;
        this.mMainStack = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    L16:
        r0.put("mainStackFromTrace", this.mMainStack);     // Catch: JSONException -> L15
        if (this.mMainStack != "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L11;
        boolean r4 = true;
    L12:
        r0.put("invalid", r4);     // Catch: JSONException -> L15
        r0.put("is_new_stack", 10);     // Catch: JSONException -> L15
        goto L14
    L11:
        r4 = false;
    L14:
        return r0.toString();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public boolean upload(AppMonitor r1, JSONObject r2) {
        boolean r3 = super.upload(r1, r2);
        if (GlobalSwitch.isAnrMonitorOpt() == true) goto L6;
        if (r3 == true) goto L6;
        FileSystemUtils.deleteAll(this.mDirectory);
    L6:
        return r3;
    }
}
