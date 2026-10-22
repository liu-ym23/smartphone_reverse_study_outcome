package com.bytedance.crash.anr;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* JADX INFO: loaded from: classes.dex */
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

    protected AnrSummary(File r15, long r16, long r18, long r20, String r22, int r23, int r24, boolean r25) {
        super(r15, CrashType.ANR, r16, r18, r20, r22, "main", r23, r23);
        this.mBySignal = r25;
        this.mTrigger = r24;
        this.mAnrTraceParser = new AnrTraceParser(r15, r23);
        this.mStackTrace = loadStackTrace();
    }

    private void appendMainStackToCustom(@NonNull JSONObject r10) {
        if (JavaStack.isStackFromTrace(r10.optString("data")) == true) goto L5;
        return;
    L5:
        String r11 = JavaStack.getMainStack(this.mDirectory);
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        String[] r12 = r11.split("\n");
        JSONArray r13 = new JSONArray();
        int r14 = r12.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        r13.put(r12[r15]);
        r15 = r15 + 1;
        goto L9
    L11:
        CustomLong.add(r10, "main_stack_2nd", r13);
    }

    static void dump(File r10, long r11, boolean r12, int r13) {
        StringDumper r14 = new StringDumper(r10 + "/" + FILE_NAME);
        String r15 = App.getProcessName();
        long r16 = Global.getAppStartTime();
        long r17 = Global.getAppStartUpTime();
        r14.append(START_TIME_TAG).append(r16).append('\n').append(START_UP_TIME_TAG).append(r17).append('\n').append(CRASH_TIME_TAG).append(r11).append('\n').append(PROCESS_NAME_TAG).append(r15).append('\n').append(PID_TAG).append(Process.myPid()).append('\n').append(FROM_SIG_TAG).append(r12).append('\n').append(TRIGGER_TAG).append(r13).append('\n').release();
    }

    static boolean hasSummaryFile(File r10) {
        return new File(r10, FILE_NAME).exists();
    }

    @Nullable
    private static AnrSummary load(File r14) {
        String r10 = FileSystemUtils.readUtf8File(r14);
        if (TextUtils.isEmpty(r10) == true) goto L18;
        Matcher r11 = sContentPattern.matcher(r10);     // Catch: Throwable -> L12
        if (r11.find() == false) goto L19;
        long r12 = Long.parseLong(r11.group(1));     // Catch: Throwable -> L12
        long r13 = Long.parseLong(r11.group(2));     // Catch: Throwable -> L12
        long r15 = Long.parseLong(r11.group(3));     // Catch: Throwable -> L12
        String r16 = r11.group(4);     // Catch: Throwable -> L12
        int r17 = Integer.parseInt(r11.group(5));     // Catch: Throwable -> L12
        boolean r18 = Boolean.parseBoolean(r11.group(6));     // Catch: Throwable -> L12
        if (r11.group(7) == null) goto L9;
        int r19 = Integer.parseInt(r11.group(7));     // Catch: Throwable -> L12
    L10:
        return new AnrSummary(r14.getParentFile(), r12, r13, r15, r16, r17, r19, r18);
    L9:
        r19 = 9999;
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

    @Nullable
    public static AnrSummary loadFromDirectory(File r10) {
        return load(new File(r10, FILE_NAME));
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject r10) {
        JSONObject r11 = JSONUtils.get(r10, "filters");
        if (this.mBySignal == false) goto L5;
        String r12 = "true";
    L6:
        JSONUtils.put(r11, "by_signal", r12);
        JSONUtils.put(r11, "anr_trigger", Integer.valueOf(this.mTrigger));
        this.mAnrTraceParser.pushToFilters(r10, r11);
        AnrInfoParser r13 = this.mAnrInfoParser;
        if (r13 == null) goto L9;
        r13.pushToFilter(r11);
    L9:
        AnrProfiler.Parser r14 = this.mAnrProfilerParser;
        if (r14 == null) goto L12;
        r14.pushToFilters(r11);
    L12:
        LooperMessageParser.pushToFilters(r10, r11);
        AnrDumper.ConfigDump.push(this.mDirectory, r11);
        EvilDumpFile.push(this.mDirectory, r11);
        ProcessState.pushFilters(this.mDirectory, r10, r11);
        AnrHistoryProcessExitParser.pushToFilters(r10, r11);
        JSONUtils.put(r11, "malloc_type", NativeBridge.getMallocType());
        return;
    L5:
        r12 = "false";
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody r10, Header r11) {
        r10.put("is_anr", 1);     // Catch: Throwable -> L4
        this.mAnrTraceParser.pushToCrashBody(r10.getJson());     // Catch: Throwable -> L4
        AnrInfoParser r12 = new AnrInfoParser(this.mDirectory);     // Catch: Throwable -> L4
        this.mAnrInfoParser = r12;     // Catch: Throwable -> L4
        r12.pushToCrashBody(r10.getJson());     // Catch: Throwable -> L4
        LooperMessageParser.pushToCrashBody(r10.getJson());     // Catch: Throwable -> L4
        Logcat.pushToAnrFeature(r10.getJson());     // Catch: Throwable -> L4
        AnrProfiler.Parser r13 = new AnrProfiler.Parser(this.mDirectory, r10.getJson(), this.mAnrTraceParser, this.mAnrInfoParser);     // Catch: Throwable -> L4
        this.mAnrProfilerParser = r13;     // Catch: Throwable -> L4
        r13.pushToCrashBody(r10.getJson(), this.mDirectory);     // Catch: Throwable -> L4
        appendMainStackToCustom(r10.getJson());     // Catch: Throwable -> L4
        AnrHistoryProcessExitParser.parseProcessExitReason(r10.getJson());     // Catch: Throwable -> L4
    L7:
        if (this.mAnrInfoParser.isValid() == true) goto L9;
    L17:
        JSONUtils.put(r11.getJson(), "aid", 2010);
        return;
    L9:
        if (this.mMainStack == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L17;
        if (GlobalSwitch.isFilterNotAnr() == false) goto L21;
        String r14 = r10.getJson().optString(Constants.EXIT_REASON);
        if (TextUtils.isEmpty(r14) == false) goto L16;
        return;
    L16:
        if (r14.contains("6") == false) goto L17;
        return;
    L21:
        return;
    L4:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L7
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void loadCrashInfo(JSONObject r10, JSONObject r11, File r12) {
        AnrDumper.loadCrashInfo(r10, r11, r12);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    @NonNull
    protected String loadStackTrace() {
        JSONObject r10 = new JSONObject();
        String r11 = this.mAnrTraceParser.getMainStack();
        this.mMainStack = r11;
        if (TextUtils.isEmpty(r11) == false) goto L6;
        this.mMainStack = JavaStack.getMainStack(this.mDirectory);
    L6:
        if (TextUtils.isEmpty(this.mMainStack) == false) goto L16;
        this.mMainStack = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    L16:
        r10.put("mainStackFromTrace", this.mMainStack);     // Catch: JSONException -> L15
        if (this.mMainStack != "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L11;
        boolean r12 = true;
    L12:
        r10.put("invalid", r12);     // Catch: JSONException -> L15
        r10.put("is_new_stack", 10);     // Catch: JSONException -> L15
        goto L14
    L11:
        r12 = false;
    L14:
        return r10.toString();
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public boolean upload(@NonNull AppMonitor r10, JSONObject r11) {
        boolean r12 = super.upload(r10, r11);
        if (GlobalSwitch.isAnrMonitorOpt() == true) goto L6;
        if (r12 == true) goto L6;
        FileSystemUtils.deleteAll(this.mDirectory);
    L6:
        return r12;
    }
}
