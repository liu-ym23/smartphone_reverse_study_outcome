package com.bytedance.crash.entity;

import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.assembly.ActivityDataManager;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    private EventBody(String r1) {
    }

    public static EventBody wrapBlock(String r4) {
        EventBody r0 = new EventBody("caton_monitor");
        r0.put("event_type", LAG);
        r0.put("log_type", "caton_monitor");
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r0.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r0.put("process_name", App.getProcessName());
        r0.put(CrashBody.CRASH_THREAD_NAME, "main");
        r0.put("stack", r4);
        return r0;
    }

    public static EventBody wrapEnsure(StackTraceElement r6, String r7, String r8, String r9, boolean r10, String r11) {
        EventBody r0 = new EventBody("core_exception_monitor");
        String r2 = r6.getClassName();
        String r3 = r6.getMethodName();
        int r12 = r6.getLineNumber();
        r0.put("event_type", "exception");
        r0.put("log_type", "core_exception_monitor");
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r0.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r0.put("class_ref", r2);
        r0.put("method", r3);
        r0.put("line_num", Integer.valueOf(r12));
        r0.put("stack", r7);
        r0.put("exception_type", 1);
        r0.put("ensure_type", r11);
        r0.put(IS_CORE, Integer.valueOf(r10 ? 1 : 0));
        r0.put("message", r8);
        r0.put("process_name", App.getProcessName());
        r0.put(CrashBody.CRASH_THREAD_NAME, r9);
        JSONObject r13 = r0.getJson().optJSONObject("filters");
        if (r13 != null) goto L6;
        r13 = new JSONObject();
        r0.getJson().put("filters", r13);     // Catch: JSONException -> L8
    L6:
        BytestConfig.expandFilters(r13);
        return r0;
    }

    public static EventBody wrapEnsure(StackTraceElement r5, String r6, String r7, String r8, boolean r9, String r10, String r11) {
        EventBody r0 = new EventBody(r11);
        String r1 = r5.getClassName();
        String r2 = r5.getMethodName();
        int r12 = r5.getLineNumber();
        r0.put("event_type", "exception");
        r0.put("log_type", r11);
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r0.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        r0.put("class_ref", r1);
        r0.put("method", r2);
        r0.put("line_num", Integer.valueOf(r12));
        r0.put("stack", r6);
        r0.put("crash_md5", Digest.getMD5(r6));
        r0.put("exception_type", 1);
        r0.put("ensure_type", r10);
        r0.put(IS_CORE, Integer.valueOf(r9 ? 1 : 0));
        r0.put("message", r7);
        r0.put("process_name", App.getProcessName());
        r0.put(CrashBody.CRASH_THREAD_NAME, r8);
        JSONObject r13 = r0.getJson().optJSONObject("filters");
        if (r13 != null) goto L6;
        r13 = new JSONObject();
        r0.getJson().put("filters", r13);     // Catch: JSONException -> L8
    L6:
        BytestConfig.expandFilters(r13);
        return r0;
    }

    public static EventBody wrapNativeEnsure(String r7, String r8, String r9, String r10, String r11) {
        EventBody r12 = wrapEnsure(new StackTraceElement("Native", "Native", "Native.java", -1), r8, r9, r10, true, EnsureDeliverer.ENSURE_NOT_REACH_HERE, r11);
        r12.put("event_type", NATIVE_EXCEPTION);
        r12.put("java_data", r7);
        return r12;
    }

    public JSONObject getDataJson() {
        Object r0 = getJson().opt("data");
        if (ZeusTransformUtils.instanceOf(r0, JSONArray.class) == false) goto L7;
        return ((JSONArray) ZeusTransformUtils.preCheckCast(r0, JSONArray.class, "com.obric.memorydata.plugin")).optJSONObject(0);
    L7:
        return getJson();
    }

    public boolean isEvent() {
        return false;
    }

    public CrashBody setActivityTrace(ActivityDataManager r3) {
        put(ActivityLifecycle.ACTIVITY_TRACE, r3.getActivityTrace());
        addCustomLong(ActivityLifecycle.ACTIVITY_TRACK, r3.getActivityLife());
        return this;
    }
}
