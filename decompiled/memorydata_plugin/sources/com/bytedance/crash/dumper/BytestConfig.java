package com.bytedance.crash.dumper;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BytestConfig {
    private static final String SETTINGS_KEY = "bytest_automation_info";
    private static volatile boolean isDump;
    private static BytestConfig sInstance;
    private final boolean mBytestDevice;
    private final String mBytraceId;
    private String mConfig;
    private final boolean mCoredumpEnabled;
    private final boolean mEnsureNoLimit;
    private final JSONObject mFilters;
    private final boolean mGwpasanEnabled;
    private final JSONObject mJson;

    BytestConfig() {
        JSONObject r0 = getConfigs();
        this.mJson = r0;
        if (r0.length() == 0) goto L5;
        this.mBytestDevice = true;
        JSONObject r1 = r0.optJSONObject("slardar_filter");
    L6:
        this.mFilters = r1;
        JSONObject r2 = this.mFilters;
        if (r2 == null) goto L9;
        this.mGwpasanEnabled = "true".equals(r2.optString("gwp_asan_switch"));
        this.mCoredumpEnabled = "true".equals(this.mFilters.optString("core_dump_switch"));
        this.mEnsureNoLimit = "true".equals(this.mFilters.optString("is_all_exception_collected"));
        RuntimeConfig.setDebugMode(true);
    L10:
        String r3 = r0.optString("bytrace_id_prefix");
        if (TextUtils.isEmpty(r3) == false) goto L13;
        r3 = UUID.randomUUID() + "-" + Process.myPid();
    L13:
        this.mBytraceId = r3;
        return;
    L9:
        this.mGwpasanEnabled = false;
        this.mCoredumpEnabled = false;
        this.mEnsureNoLimit = false;
        goto L10
    L5:
        this.mBytestDevice = false;
        r1 = null;
        goto L6
    }

    public static void dump(File r2) {
        if (isDump == false) goto L5;
        return;
    L5:
        isDump = true;
        String r0 = get().mConfig;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        return;
    L9:
        FileUtils.writeFile(r2, r0, false);     // Catch: Throwable -> L11
        return;
    }

    public static JSONObject expandFilters(File r5, JSONObject r6) {
        if (r5.isFile() == false) goto L22;
        if (r5.exists() == false) goto L22;
        JSONObject r2 = new JSONObject(FileUtils.readFile(r5));     // Catch: Exception -> L23
        JSONObject r7 = r2.optJSONObject("slardar_filter");     // Catch: Exception -> L23
        JSONObject r3 = r6.optJSONObject("filters");     // Catch: Exception -> L23
        if (r3 != null) goto L12;
        r3 = new JSONObject();     // Catch: Exception -> L23
        r6.put("filters", r3);     // Catch: Exception -> L23
    L12:
        if (r7 != null) goto L14;
    L20:
        r3.put("coredump_bytest", false);     // Catch: Exception -> L23
    L21:
        return r2;
    L14:
        if (r7.length() == 0) goto L20;
        if ("true".equals(r7.optString("core_dump_switch")) == false) goto L19;
        r3.put("coredump_bytest", true);     // Catch: Exception -> L23
    L19:
        JSONUtils.combineJson(r3, r7);     // Catch: Exception -> L23
    L22:
        return null;
    }

    public static void expandFilters(JSONObject r2) {
        JSONObject r0 = get().mFilters;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() == 0) goto L9;
        JSONUtils.combineJson(r2, r0);
        return;
    }

    private static BytestConfig get() {
        if (sInstance != null) goto L6;
        sInstance = new BytestConfig();
    L6:
        return sInstance;
    }

    public static String getBytraceId() {
        return get().mBytraceId;
    }

    private JSONObject getConfigs() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        ContentResolver r1 = r0.getContentResolver();     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT < 17) goto L10;
        this.mConfig = Settings.Global.getString(r1, SETTINGS_KEY);     // Catch: Throwable -> L11
        return new JSONObject(this.mConfig);
    L10:
        return new JSONObject();
    }

    public static boolean isBytestDevcice() {
        return get().mBytestDevice;
    }

    public static boolean isCoredumpEnabled() {
        return get().mCoredumpEnabled;
    }

    public static boolean isEnsureNoLimit() {
        return get().mEnsureNoLimit;
    }

    public static boolean isGwpasanEnabled() {
        return get().mGwpasanEnabled;
    }

    public static void load(JSONObject r5) {
        JSONObject r0 = get().mJson;
        Iterator<String> r1 = r0.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if ("slardar_filter".equals(r2) == true) goto L4;
        Object r3 = r0.opt(r2);
        if (r3 == null) goto L4;
        r5.put(r2, r3);     // Catch: JSONException -> L13
        goto L4
    }

    public static void load(JSONObject r4, JSONObject r5) {
        if (r4 != null) goto L17;
        return;
    L17:
        Iterator<String> r0 = r4.keys();     // Catch: Exception -> L16
    L6:
        if (r0.hasNext() == false) goto L27;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
        if ("slardar_filter".equals(r1) == true) goto L6;
        Object r2 = r4.opt(r1);     // Catch: Exception -> L16
        if (r2 == null) goto L6;
        r5.put(r1, r2);     // Catch: JSONException -> L15 Exception -> L16
    L27:
        return;
    }
}
