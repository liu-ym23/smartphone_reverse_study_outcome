package com.bytedance.crash.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.util.JSONUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    public CrashBody(JSONObject r10) {
        this.mCrashJson = r10;
    }

    @Deprecated
    public static void putInJson(JSONObject r10, String r11, String r12, Object r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r14 = r10.optJSONObject(r11);
        if (r14 != null) goto L7;
        r14 = new JSONObject();
        JSONUtils.put(r10, r11, r14);
    L7:
        JSONUtils.put(r14, r12, r13);
    }

    @Deprecated
    public CrashBody addCustom(String r10, String r11) {
        putInJson(this.mCrashJson, "custom", r10, r11);
        return this;
    }

    public CrashBody addCustomLong(String r10, List<String> r11) {
        if (r11 != null) goto L4;
        return this;
    L4:
        JSONArray r12 = new JSONArray();
        Iterator<String> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12.put(r13.next());
        goto L6
    L8:
        addCustomLong(r10, r12);
        return this;
    }

    CrashBody addCustomLong(String r10, JSONArray r11) {
        CustomLong.add(getJson(), r10, r11);
        return this;
    }

    @Deprecated
    public CrashBody addFilter(String r10, String r11) {
        putInJson(this.mCrashJson, "filters", r10, r11);
        return this;
    }

    @NonNull
    public Header getHeader() {
        return this.mHeader;
    }

    public JSONObject getHeaderJson() {
        return this.mCrashJson.optJSONObject("header");
    }

    @NonNull
    public JSONObject getJson() {
        return this.mCrashJson;
    }

    public void put(@NonNull String r10, @Nullable Object r11) {
        JSONUtils.put(this.mCrashJson, r10, r11);
    }

    @Deprecated
    public CrashBody setAppStartTime(long r10) {
        return setAppStartTime(r10, 0);
    }

    @Deprecated
    public CrashBody setAppStartTime(long r10, long r11) {
        put("app_start_time", Long.valueOf(r10));     // Catch: Exception -> L7
        if (r11 == 0) goto L5;
        put(APP_START_UP_TIME, Long.valueOf(r11));     // Catch: Exception -> L7
    L5:
        put("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(r10)));     // Catch: Exception -> L7
    L9:
        return this;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public CrashBody setHeader(Header r10) {
        put("header", r10.getJson());
        this.mHeader = r10;
        return this;
    }

    public void setJson(JSONObject r10) {
        this.mCrashJson = r10;
    }
}
