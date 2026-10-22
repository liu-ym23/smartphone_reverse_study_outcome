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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public EnsureReportData(String r10, String r11, String r12, Map<String, String> r13, String r14, String r15, String r16, int r17) {
        this.javaStack = r10;
        this.nativeStack = getPackedNativeStack(r11, r12);
        this.message = r12;
        this.threadName = r14;
        this.logType = r15;
        this.data = r13;
        this.eventTime = System.currentTimeMillis();
        this.eventType = r16;
        pid = r17;
    }

    public EnsureReportData(String r10, String r11, String r12, JSONObject r13, String r14) {
        this.totalData = r13;
        this.logType = r10;
        this.javaStack = r11;
        this.nativeStack = r12;
        this.eventType = r14;
        this.message = r13.optString("message");
    }

    public EnsureReportData(Throwable r10, StackTraceElement[] r11, int r12, String r13, boolean r14, Map<String, String> r15, String r16, String r17, String r18, String r19) {
        this.throwable = r10;
        this.traceElements = r11;
        this.stackDepth = r12;
        this.message = r13;
        this.isCore = r14;
        this.data = r15;
        this.threadName = r16;
        this.exceptionType = r17;
        this.logType = r18;
        this.eventTime = System.currentTimeMillis();
        this.eventType = r19;
    }

    private void appendCustomData(JSONObject r10, EventMonitor r11) {
        if (AppMonitorConfigService.enableUserCustomData() == true) goto L5;
        return;
    L5:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L22
        Map<String, String> r13 = this.data;     // Catch: Throwable -> L22
        if (r13 == null) goto L11;
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r14.hasNext() == false) goto L11;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Throwable -> L22
        r12.put(r15.getKey(), r15.getValue());     // Catch: Throwable -> L22
    L11:
        if (r11 == null) goto L19;
        Map<String, String> r16 = r11.getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE);     // Catch: Throwable -> L22
        if (r16 == null) goto L19;
        Iterator<Map.Entry<String, String>> r17 = r16.entrySet().iterator();     // Catch: Throwable -> L22
    L16:
        if (r17.hasNext() == false) goto L19;
        Map.Entry<String, String> r18 = r17.next();     // Catch: Throwable -> L22
        r12.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L22
    L19:
        if (JSONUtils.isEmpty(r12) == true) goto L27;
        r10.put("custom", r12);     // Catch: Throwable -> L22
        return;
    L27:
        return;
    }

    private void appendExtension(JSONObject r10, EventMonitor r11) {
        ICrashBodyExtensionDumper r12 = r11.getBodyDumper();     // Catch: Throwable -> L6
        if (r12 == null) goto L9;
        JSONUtils.combineJson(r10, r12.load(CrashType.ENSURE));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private String getCurrentJavaStack(StackTraceElement[] r10, int r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length <= 0) goto L15;
        StringBuilder r12 = new StringBuilder();
    L8:
        if (r11 >= r10.length) goto L11;
        Stack.getStackTraceElementInfo(r10[r11], r12);
        r11 = r11 + 1;
        goto L8
    L11:
        return r12.toString();
    L15:
        return null;
    }

    private static String getPackedNativeStack(String r10, String r11) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.startsWith("Signal") == true) goto L21;
        StringBuilder r12 = new StringBuilder();
        if (r11 != null) goto L18;
        String r13 = DEFULT_NATIVE_STACK_HEADER;
    L9:
        r12.append(r13);     // Catch: Throwable -> L17
        r12.append(r10);     // Catch: Throwable -> L17
    L16:
        return r12.toString();
    L18:
        r12.append("Signal 111(");     // Catch: Throwable -> L17
        if (r11.length() <= 30) goto L13;
        r11 = r11.substring(0, 30);     // Catch: Throwable -> L17
    L13:
        r12.append(r11);     // Catch: Throwable -> L17
        r13 = ")\n";
        goto L9
    L21:
        return r10;
    }

    protected void appendFilters(JSONObject r10, EventMonitor r11, Map<String, String> r12) {
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L31
        r13.put("storage_free_range", Storage.getInnerFreeSizeRange());     // Catch: Throwable -> L31
        r13.put("alog_inited", AlogManager.isInit());     // Catch: Throwable -> L31
        r10.put("filters", r13);     // Catch: Throwable -> L31
        if (this.nativeStack == null) goto L5;
        r13.put(Constants.HAS_DUMP, "true");     // Catch: Throwable -> L31
    L5:
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.nativeStack == null) goto L19;
        Map<String, String> r14 = this.data;     // Catch: Throwable -> L31
        if (r14 == null) goto L19;
        Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();     // Catch: Throwable -> L31
    L13:
        if (r15.hasNext() == false) goto L19;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r16.getKey()) == true) goto L13;
        if (r16.getValue() == null) goto L13;
        r13.put(r16.getKey(), r16.getValue());     // Catch: Throwable -> L31
    L19:
        if (r12 != null) goto L21;
        return;
    L21:
        if (r12.size() <= 0) goto L51;
        Iterator<Map.Entry<String, String>> r17 = r12.entrySet().iterator();     // Catch: Throwable -> L31
    L23:
        if (r17.hasNext() == false) goto L52;
        Map.Entry<String, String> r18 = r17.next();     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r18.getKey()) == true) goto L23;
        if (r18.getValue() == null) goto L23;
        r13.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L31
        goto L23
    L52:
        return;
    L51:
        return;
    L31:
        th = move-exception;
        NpthLog.e("EnsureReportData", th);
    }

    public String getJavaStack() {
        String r10 = this.javaStack;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Throwable r11 = this.throwable;
        if (r11 == null) goto L8;
        String r12 = Stack.getExceptionStack(r11);
    L9:
        this.javaStack = r12;
        return r12;
    L8:
        r12 = getCurrentJavaStack(this.traceElements, this.stackDepth);
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
        String r10 = this.md5;
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = this.nativeStack;
        if (r11 != null) goto L9;
        r11 = getJavaStack();
    L9:
        this.md5 = Digest.getMD5(r11);
        return this.md5;
    }

    public JSONObject toJsonObject(EventMonitor r10) {
        if (UserDataCenter.isIgnoreExceptionTag() == true) goto L5;
        Map<String, String> r11 = r10.getUserDataCenter().getCustomTags();
        Map<String, String> r12 = TagService.getImportTagMap();
        if (r12 == null) goto L10;
        HashMap r13 = new HashMap();
        r13.putAll(r11);
        r13.putAll(r12);
        r11 = r13;
    L10:
        return toJsonObject(r10, r11);
    L5:
        return toJsonObject(r10, null);
    }

    public JSONObject toJsonObject(EventMonitor r11, Map<String, String> r12) {
        JSONObject r10 = this.totalData;
        if (r10 != null) goto L41;
        JSONObject r13 = new JSONObject();
        r13.put(Constants.EVENT_TYPE, this.eventType);     // Catch: Exception -> L35
        r13.put("crash_time", this.eventTime);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.logType) == false) goto L13;
        String r14 = "core_exception_monitor";
    L14:
        r13.put("log_type", r14);     // Catch: Exception -> L35
        r13.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L35
        r13.put("crash_md5", getStackMD5());     // Catch: Exception -> L35
        r13.put("message", this.message);     // Catch: Exception -> L35
        r13.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L35
        r13.put("process_name", App.getProcessName());     // Catch: Exception -> L35
        r13.put("app_start_time", Global.getAppStartTime());     // Catch: Exception -> L35
        int r15 = 1;
        r13.put(ApiPerfDetails.exceptionType, 1);     // Catch: Exception -> L35
        r13.put("pid", pid);     // Catch: Exception -> L35
        if (this.nativeStack == null) goto L20;
        r13.put(CLASS_REF, "Native");     // Catch: Exception -> L35
        r13.put(METHOD, "Native");     // Catch: Exception -> L35
        r13.put("is_core", 1);     // Catch: Exception -> L35
        r13.put(LINE_NUM, -1);     // Catch: Exception -> L35
        r13.put(ENSURE_TYPE, "EnsureNotReachHere");     // Catch: Exception -> L35
        r13.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(this.nativeStack));     // Catch: Exception -> L35
        r13.put("stack", this.nativeStack);     // Catch: Exception -> L35
        r13.put(Constants.HAS_DUMP, "true");     // Catch: Exception -> L35
        String r16 = this.javaStack;     // Catch: Exception -> L35
        if (r16 == null) goto L30;
        r13.put("java_data", r16);     // Catch: Exception -> L35
    L30:
        String r17 = Global.getBusiness();     // Catch: Exception -> L35
        if (r17 == null) goto L33;
        r13.put("business", r17);     // Catch: Exception -> L35
    L33:
        appendCustomData(r13, r11);     // Catch: Exception -> L35
        appendFilters(r13, r11, r12);     // Catch: Exception -> L35
        SdkInfo.pushTo(r13);     // Catch: Exception -> L35
        r13.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());     // Catch: Exception -> L35
        ActivityLifecycle.loadActivityTrace(r13);     // Catch: Exception -> L35
        ActivityLifecycle.loadActivityTrack(r13);     // Catch: Exception -> L35
        appendExtension(r13, r11);     // Catch: Exception -> L35
    L37:
        return r13;
    L20:
        StackTraceElement[] r18 = this.traceElements;     // Catch: Exception -> L35
        if (r18 != null) goto L23;
        r18 = this.throwable.getStackTrace();     // Catch: Exception -> L35
    L23:
        StackTraceElement r19 = r18[this.stackDepth];     // Catch: Exception -> L35
        r13.put(CLASS_REF, r19.getClassName());     // Catch: Exception -> L35
        r13.put(METHOD, r19.getMethodName());     // Catch: Exception -> L35
        r13.put(LINE_NUM, r19.getLineNumber());     // Catch: Exception -> L35
        r13.put("stack", getJavaStack());     // Catch: Exception -> L35
        if (this.isCore == true) goto L27;
        r15 = 0;
    L27:
        r13.put("is_core", r15);     // Catch: Exception -> L35
        if (TextUtils.isEmpty(this.exceptionType) == true) goto L30;
        r13.put(ENSURE_TYPE, this.exceptionType);     // Catch: Exception -> L35
        goto L30
    L13:
        r14 = this.logType;     // Catch: Exception -> L35
    L35:
        e = move-exception;
        NpthLog.e("EnsureReportData", e);
        goto L37
    L41:
        if (r10.has("crash_md5") == true) goto L8;
        this.totalData.put("crash_md5", getStackMD5());     // Catch: Throwable -> L38
    L8:
        return this.totalData;
    }

    public String toString() {
        return "EnsureReportData{throwable=" + this.throwable + ", traceElements=" + Arrays.toString(this.traceElements) + ", stackDepth=" + this.stackDepth + ", message='" + this.message + "', isCore=" + this.isCore + ", data=" + this.data + ", threadName='" + this.threadName + "', exceptionType='" + this.exceptionType + "', logType='" + this.logType + "', javaStack='" + this.javaStack + "', nativeStack='" + this.nativeStack + "', eventTime=" + this.eventTime + ", md5='" + this.md5 + "', totalData=" + this.totalData + '}';
    }
}
