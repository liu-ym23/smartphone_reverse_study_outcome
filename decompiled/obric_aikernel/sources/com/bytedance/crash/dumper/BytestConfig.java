package com.bytedance.crash.dumper;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
        JSONObject r10 = getConfigs();
        this.mJson = r10;
        if (r10.length() == 0) goto L5;
        this.mBytestDevice = true;
        JSONObject r11 = r10.optJSONObject("slardar_filter");
    L6:
        this.mFilters = r11;
        JSONObject r12 = this.mFilters;
        if (r12 == null) goto L9;
        this.mGwpasanEnabled = "true".equals(r12.optString("gwp_asan_switch"));
        this.mCoredumpEnabled = "true".equals(this.mFilters.optString("core_dump_switch"));
        this.mEnsureNoLimit = "true".equals(this.mFilters.optString("is_all_exception_collected"));
        RuntimeConfig.setDebugMode(true);
    L10:
        String r13 = r10.optString("bytrace_id_prefix");
        if (TextUtils.isEmpty(r13) == false) goto L13;
        r13 = UUID.randomUUID() + "-" + Process.myPid();
    L13:
        this.mBytraceId = r13;
        return;
    L9:
        this.mGwpasanEnabled = false;
        this.mCoredumpEnabled = false;
        this.mEnsureNoLimit = false;
        goto L10
    L5:
        this.mBytestDevice = false;
        r11 = null;
        goto L6
    }

    public static void dump(File r10) {
        if (isDump == false) goto L5;
        return;
    L5:
        isDump = true;
        String r11 = get().mConfig;     // Catch: Throwable -> L11
        if (r11 != null) goto L9;
        return;
    L9:
        FileUtils.writeFile(r10, r11, false);     // Catch: Throwable -> L11
        return;
    }

    public static JSONObject expandFilters(File r10, JSONObject r11) {
        if (r10.isFile() == false) goto L22;
        if (r10.exists() == false) goto L22;
        JSONObject r12 = new JSONObject(FileUtils.readFile(r10));     // Catch: Exception -> L23
        JSONObject r13 = r12.optJSONObject("slardar_filter");     // Catch: Exception -> L23
        JSONObject r14 = r11.optJSONObject("filters");     // Catch: Exception -> L23
        if (r14 != null) goto L12;
        r14 = new JSONObject();     // Catch: Exception -> L23
        r11.put("filters", r14);     // Catch: Exception -> L23
    L12:
        if (r13 != null) goto L14;
    L20:
        r14.put("coredump_bytest", false);     // Catch: Exception -> L23
    L21:
        return r12;
    L14:
        if (r13.length() == 0) goto L20;
        if ("true".equals(r13.optString("core_dump_switch")) == false) goto L19;
        r14.put("coredump_bytest", true);     // Catch: Exception -> L23
    L19:
        JSONUtils.combineJson(r14, r13);     // Catch: Exception -> L23
    L22:
        return null;
    }

    public static void expandFilters(JSONObject r10) {
        JSONObject r11 = get().mFilters;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() == 0) goto L9;
        JSONUtils.combineJson(r10, r11);
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

    @NonNull
    private JSONObject getConfigs() {
        Context r10 = Global.getContext();     // Catch: Throwable -> L10
        if (r10 == null) goto L9;
        ContentResolver r11 = r10.getContentResolver();     // Catch: Throwable -> L10
        if (Build.VERSION.SDK_INT < 17) goto L9;
        this.mConfig = Settings.Global.getString(r11, SETTINGS_KEY);     // Catch: Throwable -> L10
        return new JSONObject(this.mConfig);
    L9:
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

    public static void load(JSONObject r10) {
        JSONObject r11 = get().mJson;
        Iterator<String> r12 = r11.keys();
    L4:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        if ("slardar_filter".equals(r13) == true) goto L4;
        Object r14 = r11.opt(r13);
        if (r14 == null) goto L4;
        r10.put(r13, r14);     // Catch: JSONException -> L13
        goto L4
    }

    public static void load(JSONObject r10, JSONObject r11) {
        if (r10 != null) goto L19;
        return;
    L19:
        Iterator<String> r12 = r10.keys();     // Catch: Exception -> L16
    L6:
        if (r12.hasNext() == false) goto L27;
        String r13 = r12.next();     // Catch: Exception -> L16
        if ("slardar_filter".equals(r13) == true) goto L6;
        Object r14 = r10.opt(r13);     // Catch: Exception -> L16
        if (r14 == null) goto L6;
        r11.put(r13, r14);     // Catch: JSONException -> L15 Exception -> L16
    L27:
        return;
    }
}
