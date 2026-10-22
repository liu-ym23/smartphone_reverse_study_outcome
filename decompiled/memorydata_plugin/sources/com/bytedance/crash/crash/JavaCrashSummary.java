package com.bytedance.crash.crash;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.BuildId;
import com.bytedance.crash.dumper.tools.StringDumper;
import com.bytedance.crash.dumper.tools.ThrowableDumper;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
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
public class JavaCrashSummary extends CrashSummary {
    private static final String CRASH_TIME_TAG = "crash_time=";
    public static final String FILE_NAME = null;
    private static final String LAUNCH_TAG = "launch=";
    private static final String OOM_TAG = "oom=";
    private static final String PID_TAG = "pid=";
    private static final String PROCESS_NAME_TAG = "process_name=";
    private static final String START_TIME_TAG = "start_time=";
    private static final String START_UP_TIME_TAG = "start_up_time=";
    private static final String THREAD_NAME_TAG = "thread_name=";
    private static final String THROWABLE_TAG = "throwable=";
    private static final String TID_TAG = "tid=";
    private static final Pattern sContentPattern = null;
    private final boolean mIsOom;
    private final String mThrowable;

    static {
        FILE_NAME = CrashType.JAVA + ".summary";
        sContentPattern = Pattern.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\nthread_name=(.*)\\npid=(\\d+)\\ntid=(\\d+)\\noom=(\\d+)\\nlaunch=(\\d+)\\nthrowable=(.*)");
    }

    private JavaCrashSummary(File r15, long r16, long r18, long r20, String r22, String r23, int r24, int r25, boolean r26, String r27, boolean r28) {
        if (r28 == false) goto L5;
        CrashType r0 = CrashType.LAUNCH;
    L6:
        super(r15, r0, r16, r18, r20, r22, r23, r24, r25);
        this.mThrowable = r27;
        this.mIsOom = r26;
        this.mStackTrace = loadStackTrace();
        return;
    L5:
        r0 = CrashType.JAVA;
        goto L6
    }

    public static void dump(File r9, Thread r10, Throwable r11, long r12, boolean r14, boolean r15) {
        StringDumper r1 = new StringDumper(r9.getAbsolutePath() + "/" + FILE_NAME);     // Catch: Throwable -> L14
        String r0 = App.getProcessName();     // Catch: Throwable -> L14
        String r13 = r10.getName();     // Catch: Throwable -> L14
        long r2 = Global.getAppStartTime();     // Catch: Throwable -> L14
        long r4 = Global.getAppStartUpTime();     // Catch: Throwable -> L14
        int r6 = Process.myPid();     // Catch: Throwable -> L14
        StringDumper r16 = r1.append(START_TIME_TAG).append(r2).append('\n').append(START_UP_TIME_TAG).append(r4).append('\n').append(CRASH_TIME_TAG).append(r12).append('\n').append(PROCESS_NAME_TAG).append(r0).append('\n').append(THREAD_NAME_TAG).append(r13).append('\n').append(PID_TAG).append(r6).append('\n').append(TID_TAG).append(Process.myTid()).append('\n').append(OOM_TAG);     // Catch: Throwable -> L14
        int r17 = 1;
        if (r15 == false) goto L5;
        int r18 = 1;
    L6:
        StringDumper r19 = r16.append(r18).append('\n').append(LAUNCH_TAG);     // Catch: Throwable -> L14
        if (r14 == true) goto L10;
        r17 = 0;
    L10:
        r19.append(r17).append('\n').append(THROWABLE_TAG).append(r11).append('\n').release();     // Catch: Throwable -> L14
        if (r14 == false) goto L21;
        new File(r9, Constants.LAUNCH_TAG).createNewFile();     // Catch: Throwable -> L14 Exception -> L17
        goto L23
    L22:
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r18 = 0;
    L14:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP_SUMMARY", th);
    }

    private static String extractCrashType(String r5) {
        if (r5 != null) goto L21;
    L19:
        return null;
    L21:
        if (r5.isEmpty() == true) goto L19;
        String[] r6 = r5.split("\n", 2);     // Catch: Throwable -> L20
        if (r6.length != 0) goto L10;
        return null;
    L10:
        int r2 = r6[0].indexOf(58);     // Catch: Throwable -> L20
        if (r2 != (-1)) goto L13;
        r2 = r6[0].indexOf(65306);     // Catch: Throwable -> L20
    L13:
        if (r2 == (-1)) goto L16;
        String r7 = r6[0].substring(0, r2);     // Catch: Throwable -> L20
    L15:
        return r7.trim();
    L16:
        r7 = r6[0];     // Catch: Throwable -> L20
        goto L15
    }

    public static JavaCrashSummary load(File r19) {
        if (r19.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        String r0 = FileSystemUtils.readUtf8File(r19);
        if (r0 != null) goto L27;
        return null;
    L27:
        Matcher r1 = sContentPattern.matcher(r0);     // Catch: Throwable -> L24
        if (r1.find() == true) goto L11;
    L26:
        return null;
    L11:
        if (r1.groupCount() != 10) goto L26;
        String r17 = r1.group(10);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r17) == true) goto L26;
        long r6 = Long.parseLong(r1.group(1));     // Catch: Throwable -> L24
        long r8 = Long.parseLong(r1.group(2));     // Catch: Throwable -> L24
        long r10 = Long.parseLong(r1.group(3));     // Catch: Throwable -> L24
        String r12 = r1.group(4);     // Catch: Throwable -> L24
        String r13 = r1.group(5);     // Catch: Throwable -> L24
        int r14 = Integer.parseInt(r1.group(6));     // Catch: Throwable -> L24
        int r15 = Integer.parseInt(r1.group(7));     // Catch: Throwable -> L24
        if (Integer.parseInt(r1.group(8)) == 0) goto L17;
        boolean r16 = true;
    L19:
        if (Integer.parseInt(r1.group(9)) == 0) goto L21;
        boolean r18 = true;
    L22:
        return new JavaCrashSummary(r19.getParentFile(), r6, r8, r10, r12, r13, r14, r15, r16, r17, r18);
    L21:
        r18 = false;
        goto L22
    L17:
        r16 = false;
    L24:
        th = move-exception;
        NpthMonitor.reportInnerException("NPTH_JAVA_SUMMARY", th);
        goto L26
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void appendSpecialFilter(JSONObject r4) {
        if (this.mCrashType != CrashType.LAUNCH) goto L5;
        r4 = getOriginalBody(r4);
    L5:
        JSONObject r5 = JSONUtils.get(r4, "filters");
        if (new File(this.mDirectory, "ignore").exists() == false) goto L9;
        JSONUtils.put(r5, "has_ignore", String.valueOf(true));
    L9:
        if (this.mCrashType != CrashType.LAUNCH) goto L11;
    L12:
        String r3 = extractCrashType(this.mStackTrace);
        if (r3 == null) goto L15;
        JSONUtils.put(r5, "java_reason", r3);
    L15:
        JSONUtils.put(r5, "malloc_type", NativeBridge.getMallocType());
        JSONUtils.put(r5, Constants.FROM_CUSTOM, false);
        return;
    L11:
        if (this.mCrashType != CrashType.JAVA) goto L15;
        goto L12
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public void assemblySpecialCrashBody(CrashBody r3, Header r4) {
        BuildId.putCrashBuildIdToJson(r3.getJson(), this.mDirectory, false);
        r3.put("isOOM", Boolean.valueOf(this.mIsOom));
        r3.put("launch_did", GeneralInfoManager.getRandomDeviceId());
        if (this.mCrashType != CrashType.LAUNCH) goto L7;
        r3.put(Header.KEY_CRASH_TYPE, "java");
        r3.put(Constants.EVENT_TYPE, "start_crash");
        r3.put("stack", String.valueOf(r3.getJson().remove("data")));
        JSONObject r2 = new JSONObject();
        r2.put("data", new JSONArray().put(r3.getJson()));     // Catch: JSONException -> L9
        r3.setJson(r2);     // Catch: JSONException -> L9
        return;
    L13:
        return;
    L7:
        r3.put("isJava", 1);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public JSONObject getOriginalBody(JSONObject r2) {
        if (this.mCrashType != CrashType.LAUNCH) goto L10;
        JSONArray r1 = r2.optJSONArray("data");
        if (r1 == null) goto L10;
        if (r1.length() <= 0) goto L10;
        return r1.optJSONObject(0);
    L10:
        return r2;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public String loadStackTrace() {
        String r0 = ThrowableDumper.load(this.mDirectory);
        if (TextUtils.isEmpty(r0) == false) goto L10;
        StringBuilder r1 = new StringBuilder().append(this.mThrowable).append("\n\tat InvalidStack.NoStackAvailable: ");
        if (this.mIsOom == false) goto L7;
        String r2 = "Is OOM";
    L9:
        return r1.append(r2).append(" (SourceFile.java:-1).\n").toString();
    L7:
        r2 = "Not OOM";
        goto L9
    L10:
        return r0;
    }
}
