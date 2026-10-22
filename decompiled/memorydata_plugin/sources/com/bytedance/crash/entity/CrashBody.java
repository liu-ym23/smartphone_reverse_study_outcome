package com.bytedance.crash.entity;

import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashBody {
    public static final String ABORT_REASON = "abort_msg";
    public static final String APP_START_UP_TIME = "app_start_up_time";
    public static final String CRASH_LIB_UUID = "crash_lib_uuid";
    public static final String CRASH_PROCESS_NAME = "process_name";
    public static final String CRASH_THREAD_NAME = "crash_thread_name";
    public static final String CRASH_TIME = "crash_time";
    public static final String CUSTOM = "custom";
    public static final String DATA = "data";
    public static final String FILE_NAME = "crash_body.json";
    public static final String FILTERS = "filters";
    public static final String HEADER = "header";
    public static final String IS_NATIVE_CRASH = "is_native_crash";
    public static final String KEY_APP_CRASH_TIME = "crash_time";
    public static final String KEY_APP_START_TIME = "app_start_time";
    public static final String LAUNCH_MODE = "launch_mode";
    public static final String LAUNCH_TIME = "launch_time";
    public static final String LIB_NAME = "lib_name";
    public static final String LIB_UUID = "lib_uuid";
    public static final String LOGCAT_ANR_INFO = "logcat_anr_info";
    public static final String LOGCAT_GC_INFO = "logcat_gc_info";
    public static final String PID = "pid";
    public static final String STACK = "stack";
    public static final String STACK_MD5 = "crash_md5";
    public static final String START_PID = "start_pid";
    public static final String TID = "tid";
    private JSONObject mCrashJson;
    private Header mHeader;

    public CrashBody() {
        this.mCrashJson = new JSONObject();
        this.mHeader = new Header();
    }

    @Deprecated
    public CrashBody(JSONObject r1) {
        this.mCrashJson = r1;
    }

    @Deprecated
    public static void putInJson(JSONObject r1, String r2, String r3, Object r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        JSONObject r0 = r1.optJSONObject(r2);
        if (r0 != null) goto L7;
        r0 = new JSONObject();
        JSONUtils.put(r1, r2, r0);
    L7:
        JSONUtils.put(r0, r3, r4);
    }

    @Deprecated
    public CrashBody addCustom(String r3, String r4) {
        putInJson(this.mCrashJson, "custom", r3, r4);
        return this;
    }

    public CrashBody addCustomLong(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return this;
    L5:
        JSONArray r0 = new JSONArray();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        r0.put((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        addCustomLong(r5, r0);
        return this;
    }

    CrashBody addCustomLong(String r2, JSONArray r3) {
        CustomLong.add(getJson(), r2, r3);
        return this;
    }

    @Deprecated
    public CrashBody addFilter(String r3, String r4) {
        putInJson(this.mCrashJson, "filters", r3, r4);
        return this;
    }

    public Header getHeader() {
        return this.mHeader;
    }

    public JSONObject getHeaderJson() {
        return this.mCrashJson.optJSONObject("header");
    }

    public JSONObject getJson() {
        return this.mCrashJson;
    }

    public void put(String r1, Object r2) {
        JSONUtils.put(this.mCrashJson, r1, r2);
    }

    @Deprecated
    public CrashBody setAppStartTime(long r3) {
        return setAppStartTime(r3, 0);
    }

    @Deprecated
    public CrashBody setAppStartTime(long r3, long r5) {
        put("app_start_time", Long.valueOf(r3));     // Catch: Exception -> L7
        if (r5 == 0) goto L5;
        put(APP_START_UP_TIME, Long.valueOf(r5));     // Catch: Exception -> L7
    L5:
        put("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(r3)));     // Catch: Exception -> L7
    L9:
        return this;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public CrashBody setHeader(Header r3) {
        put("header", r3.getJson());
        this.mHeader = r3;
        return this;
    }

    public void setJson(JSONObject r1) {
        this.mCrashJson = r1;
    }
}
