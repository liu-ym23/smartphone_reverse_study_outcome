package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.TagService;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.Storage;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EnsureReportData {
    public static final String CLASS_REF = "class_ref";
    public static final String DEFAULT_ENSURE_LOG_TYPE = "core_exception_monitor";
    private static final int DEFAULT_MESSAGE_LIMIT = 30;
    private static final String DEFULT_NATIVE_STACK_HEADER = "Signal 111(NATIVE_EXCEPTION)\n";
    private static final String ENSURE_NOT_REACH_HERE = "EnsureNotReachHere";
    public static final String ENSURE_TYPE = "ensure_type";
    public static final String LINE_NUM = "line_num";
    public static final String METHOD = "method";
    public static final String STACK = "stack";
    private static int pid;
    private Map<String, String> data;
    private long eventTime;
    private String eventType;
    private String exceptionType;
    private boolean isCore;
    private String javaStack;
    private String logType;
    private String md5;
    private String message;
    private String nativeStack;
    private int stackDepth;
    private String threadName;
    private Throwable throwable;
    private JSONObject totalData;
    private StackTraceElement[] traceElements;

    static {
        pid = Process.myPid();
    }

    public EnsureReportData(String r3, String r4, String r5, Map<String, String> r6, String r7, String r8, String r9, int r10) {
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        this.javaStack = r3;
        this.nativeStack = getPackedNativeStack(r4, r5);
        this.message = r5;
        this.threadName = r7;
        this.logType = r8;
        this.data = r11;
        this.eventTime = System.currentTimeMillis();
        this.eventType = r9;
        pid = r10;
    }

    public EnsureReportData(String r1, String r2, String r3, JSONObject r4, String r5) {
        this.totalData = r4;
        this.logType = r1;
        this.javaStack = r2;
        this.nativeStack = r3;
        this.eventType = r5;
        this.message = r4.optString("message");
    }

    public EnsureReportData(Throwable r3, StackTraceElement[] r4, int r5, String r6, boolean r7, Map<String, String> r8, String r9, String r10, String r11, String r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        this.throwable = r3;
        this.traceElements = r4;
        this.stackDepth = r5;
        this.message = r6;
        this.isCore = r7;
        this.data = r13;
        this.threadName = r9;
        this.exceptionType = r10;
        this.logType = r11;
        this.eventTime = System.currentTimeMillis();
        this.eventType = r12;
    }

    private void appendCustomData(JSONObject r6, EventMonitor r7) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L23
        Map<String, String> r5 = this.data;     // Catch: Throwable -> L23
        if (r5 == null) goto L12;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();     // Catch: Throwable -> L23
    L10:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());     // Catch: Throwable -> L23
    L12:
        if (r7 == null) goto L20;
        Map<String, String> r9 = r7.getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE);     // Catch: Throwable -> L23
        if (r9 == null) goto L20;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        r0.put((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin"), r11.getValue());     // Catch: Throwable -> L23
    L20:
        if (JSONUtils.isEmpty(r0) == true) goto L28;
        r6.put("custom", r0);     // Catch: Throwable -> L23
        return;
    L28:
        return;
    }

    private void appendExtension(JSONObject r1, EventMonitor r2) {
        ICrashBodyExtensionDumper r0 = r2.getBodyDumper();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        JSONUtils.combineJson(r1, r0.load(CrashType.ENSURE));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private String getCurrentJavaStack(StackTraceElement[] r2, int r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.length <= 0) goto L15;
        StringBuilder r1 = new StringBuilder();
    L8:
        if (r3 >= r2.length) goto L11;
        Stack.getStackTraceElementInfo(r2[r3], r1);
        r3 = r3 + 1;
        goto L8
    L11:
        return r1.toString();
    L15:
        return null;
    }

    private static String getPackedNativeStack(String r3, String r4) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if (r3.startsWith("Signal") == true) goto L21;
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L18;
        String r5 = DEFULT_NATIVE_STACK_HEADER;
    L9:
        r0.append(r5);     // Catch: Throwable -> L17
        r0.append(r3);     // Catch: Throwable -> L17
    L16:
        return r0.toString();
    L18:
        r0.append("Signal 111(");     // Catch: Throwable -> L17
        if (r4.length() <= 30) goto L13;
        r4 = r4.substring(0, 30);     // Catch: Throwable -> L17
    L13:
        r0.append(r4);     // Catch: Throwable -> L17
        r5 = ")\n";
        goto L9
    L21:
        return r3;
    }

    public void appendFilters(JSONObject r5, EventMonitor r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L32
        r0.put("storage_free_range", Storage.getInnerFreeSizeRange());     // Catch: Throwable -> L32
        r0.put("alog_inited", AlogManager.isInit());     // Catch: Throwable -> L32
        r5.put("filters", r0);     // Catch: Throwable -> L32
        if (this.nativeStack == null) goto L6;
        r0.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L32
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.nativeStack == null) goto L20;
        Map<String, String> r4 = this.data;     // Catch: Throwable -> L32
        if (r4 == null) goto L20;
        Iterator<Map.Entry<String, String>> r9 = r4.entrySet().iterator();     // Catch: Throwable -> L32
    L14:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r10.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L14;
        if (r10.getValue() == null) goto L14;
        r0.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"), r10.getValue());     // Catch: Throwable -> L32
    L20:
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.size() <= 0) goto L52;
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L32
    L24:
        if (r11.hasNext() == false) goto L53;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r12.getKey(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L24;
        if (r12.getValue() == null) goto L24;
        r0.put((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin"), r12.getValue());     // Catch: Throwable -> L32
        goto L24
    L53:
        return;
    L52:
        return;
    L32:
        th = move-exception;
        NpthLog.e("EnsureReportData", th);
    }

    public String getJavaStack() {
        String r0 = this.javaStack;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Throwable r1 = this.throwable;
        if (r1 == null) goto L8;
        String r2 = Stack.getExceptionStack(r1);
    L9:
        this.javaStack = r2;
        return r2;
    L8:
        r2 = getCurrentJavaStack(this.traceElements, this.stackDepth);
        goto L9
    }

    public String getLogType() {
        return this.logType;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNativeStack() {
        return this.nativeStack;
    }

    public String getStackMD5() {
        String r0 = this.md5;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = this.nativeStack;
        if (r1 != null) goto L9;
        r1 = getJavaStack();
    L9:
        this.md5 = Digest.getMD5(r1);
        return this.md5;
    }

    public JSONObject toJsonObject(EventMonitor r4) {
        if (UserDataCenter.isIgnoreExceptionTag() == true) goto L5;
        Map<String, String> r0 = r4.getUserDataCenter().getCustomTags();
        Map<String, String> r1 = TagService.getImportTagMap();
        if (r1 == null) goto L10;
        HashMap r2 = new HashMap();
        r2.putAll(r0);
        r2.putAll(r1);
        r0 = r2;
    L10:
        return toJsonObject(r4, r0);
    L5:
        return toJsonObject(r4, null);
    }

    public JSONObject toJsonObject(EventMonitor r11, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        JSONObject r1 = this.totalData;
        if (r1 != null) goto L39;
        JSONObject r2 = new JSONObject();
        r2.put(Constants.EVENT_TYPE, this.eventType);     // Catch: Exception -> L35
        r2.put("crash_time", this.eventTime);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.logType) == false) goto L13;
        String r4 = "core_exception_monitor";
    L14:
        r2.put("log_type", r4);     // Catch: Exception -> L35
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L35
        r2.put("crash_md5", getStackMD5());     // Catch: Exception -> L35
        r2.put("message", this.message);     // Catch: Exception -> L35
        r2.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L35
        r2.put("process_name", App.getProcessName());     // Catch: Exception -> L35
        r2.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L35
        int r3 = 1;
        r2.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L35
        r2.put(CrashBody.PID, pid);     // Catch: Exception -> L35
        if (this.nativeStack == null) goto L20;
        r2.put(CLASS_REF, "Native");     // Catch: Exception -> L35
        r2.put("method", "Native");     // Catch: Exception -> L35
        r2.put("is_core", 1);     // Catch: Exception -> L35
        r2.put(LINE_NUM, -1);     // Catch: Exception -> L35
        r2.put(ENSURE_TYPE, "EnsureNotReachHere");     // Catch: Exception -> L35
        r2.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(this.nativeStack));     // Catch: Exception -> L35
        r2.put("stack", this.nativeStack);     // Catch: Exception -> L35
        r2.put(Constants.HAS_DUMP, "true");     // Catch: Exception -> L35
        String r0 = this.javaStack;     // Catch: Exception -> L35
        if (r0 == null) goto L30;
        r2.put("java_data", r0);     // Catch: Exception -> L35
    L30:
        String r5 = Global.getBusiness();     // Catch: Exception -> L35
        if (r5 == null) goto L33;
        r2.put("business", r5);     // Catch: Exception -> L35
    L33:
        appendCustomData(r2, r11);     // Catch: Exception -> L35
        appendFilters(r2, r11, r13);     // Catch: Exception -> L35
        SdkInfo.pushTo(r2);     // Catch: Exception -> L35
        r2.put("is_background", ActivityLifecycle.isBackground());     // Catch: Exception -> L35
        ActivityLifecycle.loadActivityTrace(r2);     // Catch: Exception -> L35
        ActivityLifecycle.loadActivityTrack(r2);     // Catch: Exception -> L35
        appendExtension(r2, r11);     // Catch: Exception -> L35
    L37:
        return r2;
    L20:
        StackTraceElement[] r6 = this.traceElements;     // Catch: Exception -> L35
        if (r6 != null) goto L23;
        r6 = this.throwable.getStackTrace();     // Catch: Exception -> L35
    L23:
        StackTraceElement r7 = r6[this.stackDepth];     // Catch: Exception -> L35
        r2.put(CLASS_REF, r7.getClassName());     // Catch: Exception -> L35
        r2.put("method", r7.getMethodName());     // Catch: Exception -> L35
        r2.put(LINE_NUM, r7.getLineNumber());     // Catch: Exception -> L35
        r2.put("stack", getJavaStack());     // Catch: Exception -> L35
        if (this.isCore == true) goto L27;
        r3 = 0;
    L27:
        r2.put("is_core", r3);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.exceptionType) == true) goto L30;
        r2.put(ENSURE_TYPE, this.exceptionType);     // Catch: Exception -> L35
        goto L30
    L13:
        r4 = this.logType;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        NpthLog.e("EnsureReportData", e);
        goto L37
    L39:
        if (r1.has("crash_md5") == true) goto L8;
        this.totalData.put("crash_md5", getStackMD5());     // Catch: Throwable -> L38
    L8:
        return this.totalData;
    }

    public String toString() {
        return "EnsureReportData{throwable=" + this.throwable + ", traceElements=" + Arrays.toString(this.traceElements) + ", stackDepth=" + this.stackDepth + ", message='" + this.message + "', isCore=" + this.isCore + ", data=" + this.data + ", threadName='" + this.threadName + "', exceptionType='" + this.exceptionType + "', logType='" + this.logType + "', javaStack='" + this.javaStack + "', nativeStack='" + this.nativeStack + "', eventTime=" + this.eventTime + ", md5='" + this.md5 + "', totalData=" + this.totalData + '}';
    }
}
