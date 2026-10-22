package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.InnerCrashBodyDumper;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.entity.CrashBody;
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

/* JADX INFO: loaded from: classes2.dex */
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

    private static void checkBodyInherentCommon(JSONObject r4, JSONObject r5) {
        checkNotNull(r4.opt("miniapp_info"), "miniapp_info", r5);
        checkNotNull(r4.opt("plugin_info"), "plugin_info", r5);
        checkNotNull(r4.opt("process_name"), "process_name", r5);
        checkNotNull(r4.opt(Scraps.BATTERY), Scraps.BATTERY, r5);
        checkNotNull(r4.opt(Constants.LOGCAT), Constants.LOGCAT, r5);
        checkNotNull(r4.opt("crash_time"), "crash_time", r5);
        checkNotNull(r4.opt(Scraps.STORAGE), Scraps.STORAGE, r5);
        checkNotNull(r4.opt("filters"), "filters", r5);
        checkNotNull(r4.opt(InnerCrashBodyDumper.PATCH_INFO), InnerCrashBodyDumper.PATCH_INFO, r5);
        checkNotNull(r4.opt(CrashBody.PID), CrashBody.PID, r5);
        checkNotNull(r4.opt("is_background"), "is_background", r5);
        checkNotNull(r4.opt(ActivityLifecycle.ACTIVITY_TRACE), ActivityLifecycle.ACTIVITY_TRACE, r5);
        checkNotNull(r4.opt(CustomLong.TAG), CustomLong.TAG, r5);
        if (AppMonitorConfigService.enableUserCustomData() == false) goto L6;
        checkNotNull(r4.opt("custom"), "custom", r5);
    L6:
        if (r4.optJSONObject(CustomLong.TAG) == null) goto L9;
        checkNotNull(r4.optJSONObject(CustomLong.TAG).opt(ActivityLifecycle.ACTIVITY_TRACK), ActivityLifecycle.ACTIVITY_TRACK, r5);
    L9:
        if (r4.opt("filters") == null) goto L12;
        checkNotNull(r4.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", r5);
        checkNotNull(r4.optJSONObject("filters").opt(AppInfo.KEY_NPTH_VERSION_NAME), "filters:sdk_version_name", r5);
        checkNotNull(r4.optJSONObject("filters").opt("is_root"), "filters:is_root", r5);
        checkNotNull(r4.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", r5);
        checkNotNull(r4.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", r5);
        checkNotNull(r4.optJSONObject("filters").opt("kernel_version"), "filters:kernel_version", r5);
        return;
    }

    private static void checkEquals(Object r2, Object r3, String r4, JSONObject r5) {
        if (r2 != r3) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        StringBuilder r6 = new StringBuilder();
    L9:
        doErr(r6.append("err_").append(r4).append("_not_").append(r2).toString(), r5);
        return;
    L6:
        if (r2.equals(r3) == true) goto L12;
        r6 = new StringBuilder();
        goto L9
    }

    public static boolean checkFileContainsString(File r2, String r3) {
        BufferedReader r0 = new BufferedReader(new FileReader(r2));     // Catch: IOException -> L9
    L3:
        String r4 = r0.readLine();     // Catch: IOException -> L9
        if (r4 == null) goto L18;
        if (r4.contains(r3) == false) goto L3;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static void checkFileExist(JSONObject r2, File r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (new File(r3, "logcat.txt").exists() == true) goto L8;
        doErr("has_logcat_file_false", r2);
    L8:
        if (new File(r3, "maps.txt").exists() == true) goto L11;
        doErr("has_maps_file_false", r2);
    L11:
        if (new File(r3, "threads.txt").exists() == true) goto L14;
        doErr("has_threads_file_false", r2);
    L14:
        if (new File(r3, "fds.txt").exists() == true) goto L17;
        doErr("has_fds_file_false", r2);
    L17:
        if (new File(r3, "meminfo.txt").exists() == true) goto L20;
        doErr("has_meminfo_file_false", r2);
    L20:
        if (new File(r3, ViewTree.FILE_NAME).exists() == true) goto L23;
        doErr("has_view_tree_false", r2);
    L23:
        if (new File(r3, "pthread_key_info.txt").exists() == true) goto L26;
        doErr("has_pthread_key_file_false", r2);
    L26:
        if (new File(r3, "pthread_key_map.txt").exists() == true) goto L29;
        doErr("has_pthread_key_map_file_false", r2);
    L29:
        if (new File(r3, "malloc.txt").exists() == true) goto L32;
        doErr("has_malloc_file_false", r2);
    L32:
        if (new File(r3, "pthreads.txt").exists() == true) goto L35;
        doErr("has_pthreads_file_false", r2);
    L35:
        if (new File(r3, "setpriority.txt").exists() == true) goto L38;
        doErr("has_setpriority_file_false", r2);
    L38:
        if (new File(r3, "leak_heap.txt").exists() == true) goto L41;
        doErr("has_heaptrack_file_false", r2);
        return;
    }

    private static void checkHeaderCommon(JSONObject r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        checkNotEmpty(r3.optString(AppInfo.KEY_NPTH_VERSION_NAME), AppInfo.KEY_NPTH_VERSION_NAME, r4);
        checkNotEmpty(r3.optString("sdk_version"), "sdk_version", r4);
        checkEquals(LocationInfoConst.SYSTEM, r3.optString("os"), "os", r4);
        checkNotEmpty(r3.optString("os_version"), "os_version", r4);
        checkNotEmpty(r3.optString("os_api"), "os_api", r4);
        checkNotEmpty(r3.optString("device_model"), "device_model", r4);
        checkNotEmpty(r3.optString("device_brand"), "device_brand", r4);
        checkNotEmpty(r3.optString("device_manufacturer"), "device_manufacturer", r4);
        checkNotEmpty(r3.optString("cpu_abi"), "cpu_abi", r4);
        checkNotEmpty(r3.optString(Header.KEY_UNIQUE_KEY), Header.KEY_UNIQUE_KEY, r4);
    }

    private static void checkNotEmpty(String r1, String r2, JSONObject r3) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        doErr("err_empty_" + r2, r3);
        return;
    }

    private static void checkNotNull(Object r1, String r2, JSONObject r3) {
        if (r1 != null) goto L5;
        doErr("err_null_" + r2, r3);
        return;
    }

    public static void checkUploadData(CrashType r2, File r3, JSONObject r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        JSONUtils.put(r0, Header.KEY_CRASH_TYPE, r2.getName());
        checkFileExist(r0, r3);
        checkBodyInherentCommon(r4, r0);
        checkHeaderCommon(r5, r0);
        new NpthMonitor.Event("crash_data_check", r0).upload();
    }

    private static void doErr(String r1, JSONObject r2) {
        r2.put(r1, 1);     // Catch: JSONException -> L5
        return;
    }
}
