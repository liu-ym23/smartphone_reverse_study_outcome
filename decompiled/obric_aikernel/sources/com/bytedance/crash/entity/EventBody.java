package com.bytedance.crash.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.assembly.ActivityDataManager;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EventBody extends CrashBody {
    public static final String BLOCK_INTERVAL = "caton_interval";
    private static final String CLASS_REF = "class_ref";
    private static final String ENSURE_TYPE = "ensure_type";
    private static final String EVENT_TYPE = "event_type";
    private static final String EXCEPTION = "exception";
    private static final String EXCEPTION_TYPE = "exception_type";
    private static final String IS_CORE = "is_core";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_METRIC = "metric";
    public static final String KEY_SERVICE = "service";
    public static final String KEY_START_ID = "sid";
    public static final String KEY_STATUS = "status";
    public static final String KEY_VALUE = "value";
    private static final String LAG = "lag";
    private static final String LINE_NUM = "line_num";
    public static final String LOG_TYPE = "log_type";
    public static final String LOG_TYPE_SERVICE_MONITOR = "service_monitor";
    public static final String MESSAGE = "message";
    private static final String METHOD = "method";
    private static final String NATIVE_EXCEPTION = "native_exception";
    public static final String STACK = "stack";
    public static final String TIMESTAMP = "timestamp";
    private static final String TYPE_BLOCK_MONITOR = "caton_monitor";
    public static final String TYPE_ENSURE_MONITOR = "core_exception_monitor";

    private EventBody(String r10) {
    }

    public static EventBody wrapBlock(String r10) {
        EventBody r11 = new EventBody("caton_monitor");
        r11.put("event_type", LAG);
        r11.put("log_type", "caton_monitor");
        r11.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r11.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r11.put("process_name", App.getProcessName());
        r11.put(CrashBody.CRASH_THREAD_NAME, "main");
        r11.put("stack", r10);
        return r11;
    }

    @NonNull
    public static EventBody wrapEnsure(@NonNull StackTraceElement r10, @NonNull String r11, @Nullable String r12, @NonNull String r13, boolean r14, String r15) {
        EventBody r16 = new EventBody("core_exception_monitor");
        String r17 = r10.getClassName();
        String r18 = r10.getMethodName();
        int r19 = r10.getLineNumber();
        r16.put("event_type", "exception");
        r16.put("log_type", "core_exception_monitor");
        r16.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r16.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r16.put("class_ref", r17);
        r16.put("method", r18);
        r16.put("line_num", Integer.valueOf(r19));
        r16.put("stack", r11);
        r16.put("exception_type", 1);
        r16.put("ensure_type", r15);
        r16.put(IS_CORE, Integer.valueOf(r14 ? 1 : 0));
        r16.put("message", r12);
        r16.put("process_name", App.getProcessName());
        r16.put(CrashBody.CRASH_THREAD_NAME, r13);
        JSONObject r20 = r16.getJson().optJSONObject("filters");
        if (r20 != null) goto L6;
        r20 = new JSONObject();
        r16.getJson().put("filters", r20);     // Catch: JSONException -> L8
    L6:
        BytestConfig.expandFilters(r20);
        return r16;
    }

    @NonNull
    public static EventBody wrapEnsure(@NonNull StackTraceElement r10, @NonNull String r11, @Nullable String r12, @NonNull String r13, boolean r14, String r15, String r16) {
        EventBody r17 = new EventBody(r16);
        String r18 = r10.getClassName();
        String r19 = r10.getMethodName();
        int r20 = r10.getLineNumber();
        r17.put("event_type", "exception");
        r17.put("log_type", r16);
        r17.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r17.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r17.put("class_ref", r18);
        r17.put("method", r19);
        r17.put("line_num", Integer.valueOf(r20));
        r17.put("stack", r11);
        r17.put("crash_md5", Digest.getMD5(r11));
        r17.put("exception_type", 1);
        r17.put("ensure_type", r15);
        r17.put(IS_CORE, Integer.valueOf(r14 ? 1 : 0));
        r17.put("message", r12);
        r17.put("process_name", App.getProcessName());
        r17.put(CrashBody.CRASH_THREAD_NAME, r13);
        JSONObject r21 = r17.getJson().optJSONObject("filters");
        if (r21 != null) goto L6;
        r21 = new JSONObject();
        r17.getJson().put("filters", r21);     // Catch: JSONException -> L8
    L6:
        BytestConfig.expandFilters(r21);
        return r17;
    }

    public static EventBody wrapNativeEnsure(String r10, String r11, String r12, @NonNull String r13, String r14) {
        EventBody r15 = wrapEnsure(new StackTraceElement("Native", "Native", "Native.java", -1), r11, r12, r13, true, EnsureDeliverer.ENSURE_NOT_REACH_HERE, r14);
        r15.put("event_type", NATIVE_EXCEPTION);
        r15.put("java_data", r10);
        return r15;
    }

    public JSONObject getDataJson() {
        Object r10 = getJson().opt("data");
        if ((r10 instanceof JSONArray) == false) goto L7;
        return ((JSONArray) r10).optJSONObject(0);
    L7:
        return getJson();
    }

    public boolean isEvent() {
        return false;
    }

    public CrashBody setActivityTrace(ActivityDataManager r10) {
        put(ActivityLifecycle.ACTIVITY_TRACE, r10.getActivityTrace());
        addCustomLong(ActivityLifecycle.ACTIVITY_TRACK, r10.getActivityLife());
        return this;
    }
}
