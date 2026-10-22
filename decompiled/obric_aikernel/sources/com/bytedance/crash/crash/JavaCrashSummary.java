package com.bytedance.crash.crash;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

/* JADX INFO: loaded from: classes.dex */
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
        CrashType r10 = CrashType.LAUNCH;
    L6:
        super(r15, r10, r16, r18, r20, r22, r23, r24, r25);
        this.mThrowable = r27;
        this.mIsOom = r26;
        this.mStackTrace = loadStackTrace();
        return;
    L5:
        r10 = CrashType.JAVA;
        goto L6
    }

    public static void dump(@NonNull File r10, Thread r11, Throwable r12, long r13, boolean r14, boolean r15) {
        StringDumper r16 = new StringDumper(r10.getAbsolutePath() + "/" + FILE_NAME);     // Catch: Throwable -> L14
        String r17 = App.getProcessName();     // Catch: Throwable -> L14
        String r18 = r11.getName();     // Catch: Throwable -> L14
        long r19 = Global.getAppStartTime();     // Catch: Throwable -> L14
        long r20 = Global.getAppStartUpTime();     // Catch: Throwable -> L14
        int r21 = Process.myPid();     // Catch: Throwable -> L14
        StringDumper r110 = r16.append(START_TIME_TAG).append(r19).append('\n').append(START_UP_TIME_TAG).append(r20).append('\n').append(CRASH_TIME_TAG).append(r13).append('\n').append(PROCESS_NAME_TAG).append(r17).append('\n').append(THREAD_NAME_TAG).append(r18).append('\n').append(PID_TAG).append(r21).append('\n').append(TID_TAG).append(Process.myTid()).append('\n').append(OOM_TAG);     // Catch: Throwable -> L14
        int r111 = 1;
        if (r15 == false) goto L5;
        int r112 = 1;
    L6:
        StringDumper r113 = r110.append(r112).append('\n').append(LAUNCH_TAG);     // Catch: Throwable -> L14
        if (r14 == true) goto L10;
        r111 = 0;
    L10:
        r113.append(r111).append('\n').append(THROWABLE_TAG).append(r12).append('\n').release();     // Catch: Throwable -> L14
        if (r14 == false) goto L21;
        new File(r10, Constants.LAUNCH_TAG).createNewFile();     // Catch: Throwable -> L14 Exception -> L17
        goto L23
    L22:
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r112 = 0;
    L14:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP_SUMMARY", th);
    }

    private static String extractCrashType(String r10) {
        if (r10 != null) goto L21;
    L19:
        return null;
    L21:
        if (r10.isEmpty() == true) goto L19;
        String[] r11 = r10.split("\n", 2);     // Catch: Throwable -> L20
        if (r11.length != 0) goto L10;
        return null;
    L10:
        int r12 = r11[0].indexOf(58);     // Catch: Throwable -> L20
        if (r12 != (-1)) goto L13;
        r12 = r11[0].indexOf(65306);     // Catch: Throwable -> L20
    L13:
        if (r12 == (-1)) goto L16;
        String r13 = r11[0].substring(0, r12);     // Catch: Throwable -> L20
    L15:
        return r13.trim();
    L16:
        r13 = r11[0];     // Catch: Throwable -> L20
        goto L15
    }

    @Nullable
    public static JavaCrashSummary load(File r19) {
        if (r19.getName().equals(FILE_NAME) == true) goto L5;
        return null;
    L5:
        String r10 = FileSystemUtils.readUtf8File(r19);
        if (r10 != null) goto L27;
        return null;
    L27:
        Matcher r11 = sContentPattern.matcher(r10);     // Catch: Throwable -> L24
        if (r11.find() == true) goto L11;
    L26:
        return null;
    L11:
        if (r11.groupCount() != 10) goto L26;
        String r17 = r11.group(10);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r17) == true) goto L26;
        long r12 = Long.parseLong(r11.group(1));     // Catch: Throwable -> L24
        long r13 = Long.parseLong(r11.group(2));     // Catch: Throwable -> L24
        long r14 = Long.parseLong(r11.group(3));     // Catch: Throwable -> L24
        String r15 = r11.group(4);     // Catch: Throwable -> L24
        String r16 = r11.group(5);     // Catch: Throwable -> L24
        int r18 = Integer.parseInt(r11.group(6));     // Catch: Throwable -> L24
        int r110 = Integer.parseInt(r11.group(7));     // Catch: Throwable -> L24
        if (Integer.parseInt(r11.group(8)) == 0) goto L17;
        boolean r111 = true;
    L19:
        if (Integer.parseInt(r11.group(9)) == 0) goto L21;
        boolean r112 = true;
    L22:
        return new JavaCrashSummary(r19.getParentFile(), r12, r13, r14, r15, r16, r18, r110, r111, r17, r112);
    L21:
        r112 = false;
        goto L22
    L17:
        r111 = false;
    L24:
        th = move-exception;
        NpthMonitor.reportInnerException("NPTH_JAVA_SUMMARY", th);
        goto L26
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void appendSpecialFilter(JSONObject r10) {
        CrashType r11 = this.mCrashType;
        CrashType r12 = CrashType.LAUNCH;
        if (r11 != r12) goto L5;
        r10 = getOriginalBody(r10);
    L5:
        JSONObject r13 = JSONUtils.get(r10, "filters");
        if (new File(this.mDirectory, "ignore").exists() == false) goto L8;
        JSONUtils.put(r13, "has_ignore", String.valueOf(true));
    L8:
        CrashType r14 = this.mCrashType;
        if (r14 != r12) goto L11;
    L12:
        String r15 = extractCrashType(this.mStackTrace);
        if (r15 == null) goto L15;
        JSONUtils.put(r13, "java_reason", r15);
    L15:
        JSONUtils.put(r13, "malloc_type", NativeBridge.getMallocType());
        JSONUtils.put(r13, Constants.FROM_CUSTOM, Boolean.FALSE);
        return;
    L11:
        if (r14 != CrashType.JAVA) goto L15;
        goto L12
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    protected void assemblySpecialCrashBody(CrashBody r10, Header r11) {
        BuildId.putCrashBuildIdToJson(r10.getJson(), this.mDirectory, false);
        r10.put("isOOM", Boolean.valueOf(this.mIsOom));
        r10.put("launch_did", GeneralInfoManager.getRandomDeviceId());
        if (this.mCrashType != CrashType.LAUNCH) goto L7;
        r10.put(Header.KEY_CRASH_TYPE, "java");
        r10.put(Constants.EVENT_TYPE, "start_crash");
        r10.put("stack", String.valueOf(r10.getJson().remove("data")));
        JSONObject r12 = new JSONObject();
        r12.put("data", new JSONArray().put(r10.getJson()));     // Catch: JSONException -> L9
        r10.setJson(r12);     // Catch: JSONException -> L9
        return;
    L13:
        return;
    L7:
        r10.put("isJava", 1);
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public JSONObject getOriginalBody(JSONObject r10) {
        if (this.mCrashType != CrashType.LAUNCH) goto L10;
        JSONArray r11 = r10.optJSONArray("data");
        if (r11 == null) goto L10;
        if (r11.length() <= 0) goto L10;
        return r11.optJSONObject(0);
    L10:
        return r10;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    @NonNull
    protected String loadStackTrace() {
        String r10 = ThrowableDumper.load(this.mDirectory);
        if (TextUtils.isEmpty(r10) == false) goto L10;
        StringBuilder r11 = new StringBuilder();
        r11.append(this.mThrowable);
        r11.append("\n\tat InvalidStack.NoStackAvailable: ");
        if (this.mIsOom == false) goto L7;
        String r12 = "Is OOM";
    L8:
        r11.append(r12);
        r11.append(" (SourceFile.java:-1).\n");
        return r11.toString();
    L7:
        r12 = "Not OOM";
        goto L8
    L10:
        return r10;
    }
}
