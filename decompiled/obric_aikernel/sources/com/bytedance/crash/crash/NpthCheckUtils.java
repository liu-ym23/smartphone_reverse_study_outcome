package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.InnerCrashBodyDumper;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.JSONUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NpthCheckUtils {
    private static final String HAS_FDS_FILE = "has_fds_file";
    private static final String HAS_HEAPTRACK_FILE = "has_heaptrack_file";
    private static final String HAS_KEYMAP_FILE = "has_pthread_key_map_file";
    private static final String HAS_LOGCAT_FILE = "has_logcat_file";
    private static final String HAS_MALLOC_INFO_FILE = "has_malloc_file";
    private static final String HAS_MAPS_FILE = "has_maps_file";
    private static final String HAS_MEMINFO_FILE = "has_meminfo_file";
    private static final String HAS_PRIO_FILE = "has_setpriority_file";
    private static final String HAS_PTHREADKEY_FILE = "has_pthread_key_file";
    private static final String HAS_PTHREADS_FILE = "has_pthreads_file";
    private static final String HAS_THREADS_FILE = "has_threads_file";
    private static final String HAS_VIEW_TREE = "has_view_tree";

    public NpthCheckUtils() {
    }

    private static void checkBodyInherentCommon(JSONObject r10, JSONObject r11) {
        checkNotNull(r10.opt("miniapp_info"), "miniapp_info", r11);
        checkNotNull(r10.opt("plugin_info"), "plugin_info", r11);
        checkNotNull(r10.opt("process_name"), "process_name", r11);
        checkNotNull(r10.opt(Scraps.BATTERY), Scraps.BATTERY, r11);
        checkNotNull(r10.opt(Constants.LOGCAT), Constants.LOGCAT, r11);
        checkNotNull(r10.opt("crash_time"), "crash_time", r11);
        checkNotNull(r10.opt(Scraps.STORAGE), Scraps.STORAGE, r11);
        checkNotNull(r10.opt("filters"), "filters", r11);
        checkNotNull(r10.opt(InnerCrashBodyDumper.PATCH_INFO), InnerCrashBodyDumper.PATCH_INFO, r11);
        checkNotNull(r10.opt("pid"), "pid", r11);
        checkNotNull(r10.opt(Constants.IS_BACKGROUND), Constants.IS_BACKGROUND, r11);
        checkNotNull(r10.opt(ActivityLifecycle.ACTIVITY_TRACE), ActivityLifecycle.ACTIVITY_TRACE, r11);
        checkNotNull(r10.opt(CustomLong.TAG), CustomLong.TAG, r11);
        if (AppMonitorConfigService.enableUserCustomData() == false) goto L6;
        checkNotNull(r10.opt("custom"), "custom", r11);
    L6:
        if (r10.optJSONObject(CustomLong.TAG) == null) goto L9;
        checkNotNull(r10.optJSONObject(CustomLong.TAG).opt(ActivityLifecycle.ACTIVITY_TRACK), ActivityLifecycle.ACTIVITY_TRACK, r11);
    L9:
        if (r10.opt("filters") == null) goto L12;
        checkNotNull(r10.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", r11);
        checkNotNull(r10.optJSONObject("filters").opt(AppInfo.KEY_NPTH_VERSION_NAME), "filters:sdk_version_name", r11);
        checkNotNull(r10.optJSONObject("filters").opt("is_root"), "filters:is_root", r11);
        checkNotNull(r10.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r11);
        checkNotNull(r10.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r11);
        checkNotNull(r10.optJSONObject("filters").opt("kernel_version"), "filters:kernel_version", r11);
        return;
    }

    private static void checkEquals(Object r10, Object r11, String r12, JSONObject r13) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
        StringBuilder r14 = new StringBuilder();
    L9:
        r14.append("err_");
        r14.append(r12);
        r14.append("_not_");
        r14.append(r10);
        doErr(r14.toString(), r13);
        return;
    L6:
        if (r10.equals(r11) == true) goto L12;
        r14 = new StringBuilder();
        goto L9
    }

    public static boolean checkFileContainsString(File r10, String r11) {
        BufferedReader r12 = new BufferedReader(new FileReader(r10));     // Catch: IOException -> L9
    L3:
        String r13 = r12.readLine();     // Catch: IOException -> L9
        if (r13 == null) goto L18;
        if (r13.contains(r11) == false) goto L3;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static void checkFileExist(JSONObject r10, File r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (new File(r11, "logcat.txt").exists() == true) goto L8;
        doErr("has_logcat_file_false", r10);
    L8:
        if (new File(r11, "maps.txt").exists() == true) goto L11;
        doErr("has_maps_file_false", r10);
    L11:
        if (new File(r11, "threads.txt").exists() == true) goto L14;
        doErr("has_threads_file_false", r10);
    L14:
        if (new File(r11, "fds.txt").exists() == true) goto L17;
        doErr("has_fds_file_false", r10);
    L17:
        if (new File(r11, "meminfo.txt").exists() == true) goto L20;
        doErr("has_meminfo_file_false", r10);
    L20:
        if (new File(r11, ViewTree.FILE_NAME).exists() == true) goto L23;
        doErr("has_view_tree_false", r10);
    L23:
        if (new File(r11, "pthread_key_info.txt").exists() == true) goto L26;
        doErr("has_pthread_key_file_false", r10);
    L26:
        if (new File(r11, "pthread_key_map.txt").exists() == true) goto L29;
        doErr("has_pthread_key_map_file_false", r10);
    L29:
        if (new File(r11, "malloc.txt").exists() == true) goto L32;
        doErr("has_malloc_file_false", r10);
    L32:
        if (new File(r11, "pthreads.txt").exists() == true) goto L35;
        doErr("has_pthreads_file_false", r10);
    L35:
        if (new File(r11, "setpriority.txt").exists() == true) goto L38;
        doErr("has_setpriority_file_false", r10);
    L38:
        if (new File(r11, "leak_heap.txt").exists() == true) goto L41;
        doErr("has_heaptrack_file_false", r10);
        return;
    }

    private static void checkHeaderCommon(JSONObject r10, JSONObject r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        checkNotEmpty(r10.optString(AppInfo.KEY_NPTH_VERSION_NAME), AppInfo.KEY_NPTH_VERSION_NAME, r11);
        checkNotEmpty(r10.optString("sdk_version"), "sdk_version", r11);
        checkEquals("Android", r10.optString("os"), "os", r11);
        checkNotEmpty(r10.optString("os_version"), "os_version", r11);
        checkNotEmpty(r10.optString("os_api"), "os_api", r11);
        checkNotEmpty(r10.optString("device_model"), "device_model", r11);
        checkNotEmpty(r10.optString("device_brand"), "device_brand", r11);
        checkNotEmpty(r10.optString("device_manufacturer"), "device_manufacturer", r11);
        checkNotEmpty(r10.optString("cpu_abi"), "cpu_abi", r11);
        checkNotEmpty(r10.optString(Header.KEY_UNIQUE_KEY), Header.KEY_UNIQUE_KEY, r11);
    }

    private static void checkNotEmpty(String r10, String r11, JSONObject r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        doErr("err_empty_" + r11, r12);
        return;
    }

    private static void checkNotNull(Object r10, String r11, JSONObject r12) {
        if (r10 != null) goto L5;
        doErr("err_null_" + r11, r12);
        return;
    }

    public static void checkUploadData(CrashType r10, File r11, JSONObject r12, JSONObject r13) {
        JSONObject r14 = new JSONObject();
        JSONUtils.put(r14, Header.KEY_CRASH_TYPE, r10.getName());
        checkFileExist(r14, r11);
        checkBodyInherentCommon(r12, r14);
        checkHeaderCommon(r13, r14);
        new NpthMonitor.Event("crash_data_check", r14).upload();
    }

    private static void doErr(String r10, JSONObject r11) {
        r11.put(r10, 1);     // Catch: JSONException -> L5
        return;
    }
}
