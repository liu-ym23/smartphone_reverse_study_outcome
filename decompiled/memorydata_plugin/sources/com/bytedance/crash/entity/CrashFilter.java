package com.bytedance.crash.entity;

import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.TagService;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.dumper.ProtectorInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.AppInfoUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NumRanges;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashFilter {
    public static final String FILTERS = "filters";
    public static final String IS_64_RUNTIME = "is_64_runtime";
    public static final String IS_ROOT = "is_root";
    public static final String IS_X86_DEVICES = "is_x86_devices";

    public CrashFilter() {
    }

    private static void appendCombineSinceCrashed(JSONObject r6, JSONObject r7) {
        long r0 = r7.optLong("crash_time");
        long r2 = System.currentTimeMillis();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r2 <= r0) goto L9;
        JSONUtils.append(r6, "crash_length", millisToReadable(r2 - r0));
        return;
    }

    public static void appendCommonFilter(JSONObject r4, JSONObject r5, File r6) {
        JSONObject r0 = JSONUtils.get(r5, "filters");
        CustomFilter.pushTo(r5, r6);
        CustomFilter.pushCustomReasonTo(r5, r6);
        JSONUtils.append(r0, Constants.HAS_DUMP, true);
        JSONUtils.append(r0, "is_root", Boolean.valueOf(GeneralInfoManager.isRoot()));
        JSONUtils.append(r0, "alog_inited", Boolean.valueOf(AlogManager.isInit()));
        JSONUtils.append(r0, "sdk_version", NpthBuildConfig.VERSION_NAME);
        JSONUtils.append(r0, CrashBody.CRASH_THREAD_NAME, r5.optString(CrashBody.CRASH_THREAD_NAME, "unknown"));
        JSONUtils.append(r0, "is_64_runtime", Boolean.valueOf(NativeBridge.is64BitRuntime()));
        JSONUtils.append(r0, Constants.IS_HM_OS, r4.optString(Constants.IS_HM_OS));
        JSONUtils.append(r0, "version_type", r4.optString("version_type"));
        JSONUtils.append(r0, "kernel_version", r4.optString("kernel_version"));
        JSONUtils.append(r0, "app_version_exact", r4.optString("app_version_exact"));
        JSONUtils.append(r0, "crash_md5", r5.optString("crash_md5"));
        JSONUtils.append(r0, HardwareInfo.KEY_HW_CPU_MODEL, r4.optString(HardwareInfo.KEY_HW_CPU_MODEL));
        JSONUtils.append(r0, HardwareInfo.KEY_HW_CPU_HARDWARE, r4.optString(HardwareInfo.KEY_HW_CPU_HARDWARE));
        JSONUtils.append(r0, HardwareInfo.KEY_HW_RAM_SIZE, r4.optString(HardwareInfo.KEY_HW_RAM_SIZE));
        JSONUtils.append(r0, ActivityLifecycle.LAST_RESUME_ACTIVITY, ActivityLifecycle.getLastResumedActivityFromBody(r5));
        String r1 = NativeBridge.loadNativeCrashAbortReason(r6.getAbsolutePath());
        if (r1 == null) goto L5;
        JSONUtils.append(r0, CrashBody.ABORT_REASON, r1);
    L5:
        JSONObject r2 = r5.optJSONObject(Scraps.STORAGE);
        if (r2 == null) goto L8;
        JSONUtils.append(r0, Scraps.INNER_TOTAL, r2.optString(Scraps.INNER_TOTAL));
        JSONUtils.append(r0, Scraps.INNER_FREE, r2.optString(Scraps.INNER_FREE));
    L8:
        String r3 = r4.optString("cpu_abi");
        if (TextUtils.isEmpty(r3) == true) goto L11;
        boolean r7 = r3.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
        JSONUtils.append(r0, "is_x86_devices", Boolean.valueOf(r3.contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE)));
        JSONUtils.append(r0, Constants.IS_64_DEVICES, Boolean.valueOf(r7));
        appendVmFilter(r0, r5, r6, r7);
    L11:
        appendTimeRelated(r0, r4, r5);
        AppInfoUtils.expandFilters(r0);
        appendThread(r0, r6);
        appendFd(r0, r6);
        appendPthreadKey(r0, r6);
        appendDumpFiles(r0, r6);
        appendNpthDumperStatus(r0, r6);
        appendProtectorInfo(r0, r6);
        appendLogcatFilter(r0, r5);
        appendMemoryInfo(r0, r5);
        ResourceMonitor.appendResourceMonitorTags(r0, r6);
        appendCombineSinceCrashed(r0, r5);
        appendCrashSinceUpdated(r0, r4, r5);
        appendImportTags(r0, r5);
    }

    private static void appendCrashSinceUpdated(JSONObject r4, JSONObject r5, JSONObject r6) {
        long r0 = r5.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        long r7 = r6.optLong("crash_time");
        if (r0 <= 0) goto L6;
        JSONUtils.append(r4, "crash_since_updated", millisToReadable(r7 - r0));
        return;
    }

    private static void appendDumpFiles(JSONObject r5, File r6) {
        JSONUtils.append(r5, "has_tombstone_file", Boolean.valueOf(validFile(r6, "tombstone.txt", 10)));
        JSONUtils.append(r5, "has_dlog_file", Boolean.valueOf(validFile(r6, "dlog.txt", 10)));
        JSONUtils.append(r5, "has_logcat_file", Boolean.valueOf(validFile(r6, "logcat.txt", 512)));
        JSONUtils.append(r5, "has_logcat_file_os", Boolean.valueOf(validFile(r6, "logcat_os.txt", 512)));
        JSONUtils.append(r5, "has_malloc_file", Boolean.valueOf(validFile(r6, "malloc.txt", 64)));
        JSONUtils.append(r5, "has_meminfo_file", Boolean.valueOf(validFile(r6, "meminfo.txt", 64)));
        JSONUtils.append(r5, "has_maps_file", Boolean.valueOf(validFile(r6, "maps.txt", 1024)));
        JSONUtils.append(r5, "has_smaps_file", Boolean.valueOf(validFile(r6, "smaps.txt", 1024)));
        JSONUtils.append(r5, "has_pthreads_file", Boolean.valueOf(validFile(r6, "pthreads.txt", 64)));
        JSONUtils.append(r5, "has_threads_file", Boolean.valueOf(validFile(r6, "threads.txt", 64)));
        JSONUtils.append(r5, "has_fds_file", Boolean.valueOf(validFile(r6, "fds.txt", 64)));
        JSONUtils.append(r5, "has_view_tree", Boolean.valueOf(validFile(r6, ViewTree.FILE_NAME, 64)));
        JSONUtils.append(r5, "has_pthread_key_map_file", Boolean.valueOf(validFile(r6, "pthread_key_map.txt", 10)));
        JSONUtils.append(r5, "has_pthread_key_file", Boolean.valueOf(validFile(r6, "pthread_key_info.txt", 10)));
        JSONUtils.append(r5, "has_routine_file", Boolean.valueOf(validFile(r6, "rountines.txt", 64)));
        JSONUtils.append(r5, "has_gfx_file", Boolean.valueOf(validFile(r6, "gfxinfo.txt", 64)));
        JSONUtils.append(r5, "has_os_memory", Boolean.valueOf(validFile(r6, "os_memory.txt", 64)));
        JSONUtils.append(r5, "has_environ", Boolean.valueOf(validFile(r6, "environ.txt", 64)));
        JSONUtils.append(r5, "has_signal_monitor_file", Boolean.valueOf(validFile(r6, "signal_monitor.txt", 64)));
        JSONUtils.append(r5, "has_heaptrack_file", Boolean.valueOf(validFile(r6, "leak_heap.txt", 64)));
        JSONUtils.append(r5, "has_setpriority_file", Boolean.valueOf(validFile(r6, "priority_stack.txt", 64)));
        JSONUtils.append(r5, "has_setpriority_file", Boolean.valueOf(validFile(r6, "priority_jstack.txt", 64)));
        JSONUtils.append(r5, "has_memtrack_dump", Boolean.valueOf(validFile(r6, "sys_memtrack.txt", 16)));
    }

    private static void appendFd(JSONObject r3, File r4) {
        int r0 = ProcInfo.getFdCount(r4);
        if (r0 == 0) goto L8;
        JSONUtils.append(r3, "fd_count_range", ProcInfo.getFdCountRange(r0));
        boolean r1 = ProcInfo.isFdLeak(r0);
        JSONUtils.append(r3, "fd_leak", Boolean.valueOf(r1));
        if (r1 == false) goto L9;
        JSONUtils.append(r3, "fd_leak_reason", NativeBridge.getFdLeakReason(r4));
        return;
    L9:
        return;
    }

    private static void appendImportTags(JSONObject r5, JSONObject r6) {
        String r0 = r6.optString("process_name");
        long r1 = r6.optLong("app_start_time");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (r1 == 0) goto L9;
        TagService.dumpImportTags(r5, r1, r0);
        return;
    }

    public static void appendJavaHeapFilters(JSONObject r8, JSONObject r9) {
        JSONObject r10 = r9.optJSONObject("app_memory_info");
        if (r10 == null) goto L15;
        long r0 = r10.optLong("max_memory");
        long r2 = r10.optLong("free_memory");
        long r4 = r10.optLong("total_memory");
        long r3 = r4 - r2;
        if (r3 <= 0) goto L10;
        JSONUtils.append(r8, "java_heap_range", getJavaHeapRange(r3 / 1048576));
        if (r0 <= r3) goto L10;
        JSONUtils.append(r8, "java_heap_alloc_usage", getHeapUsage(r4, r3));
        JSONUtils.append(r8, "java_heap_usage", getHeapUsage(r0, r4));
    L10:
        if (r3 <= (r0 * 0.95f)) goto L12;
        boolean r11 = true;
    L13:
        JSONUtils.append(r8, "java_heap_leak", String.valueOf(r11));
        return;
    L12:
        r11 = false;
        goto L13
    }

    private static void appendLogcatFilter(JSONObject r1, JSONObject r2) {
        JSONUtils.append(r1, "has_logcat", Boolean.valueOf(!JSONUtils.isEmpty(r2.optJSONArray(Constants.LOGCAT))));
    }

    private static void appendMemoryInfo(JSONObject r12, JSONObject r13) {
        appendJavaHeapFilters(r12, r13);
        JSONObject r0 = r13.optJSONObject("app_memory_info");
        if (r0 == null) goto L17;
        long r3 = r0.optLong("native_heap_size");
        JSONUtils.append(r12, "native_heap_range", getNativeHeapRange(r3));
        if (r3 <= 0) goto L17;
        JSONUtils.append(r12, "native_heap_range", getNativeHeapRange(r3));
        boolean r8 = true;
        if (r3 <= 268435456) goto L9;
        boolean r7 = true;
    L10:
        JSONUtils.append(r12, "native_heap_leak", Boolean.valueOf(r7));
        long r10 = r0.optLong("native_heap_alloc_size");
        if (r10 <= 0) goto L17;
        if (r10 > 268435456) goto L16;
        r8 = false;
    L16:
        JSONUtils.append(r12, "native_heap_alloc_leak", Boolean.valueOf(r8));
        JSONUtils.append(r12, "native_heap_alloc_usage", getHeapUsage(r3, r10));
        goto L17
    L9:
        r7 = false;
    L17:
        JSONObject r14 = r13.optJSONObject("memory_info");
        if (r14 == null) goto L23;
        long r4 = r14.optLong("totalPss");
        if (r4 <= 0) goto L24;
        JSONUtils.append(r12, "total_pss_range", getNativeHeapRange(r4));
        return;
    L24:
        return;
    }

    private static void appendMemoryReasonFilter(JSONObject r2, File r3) {
        String[] r4 = NativeBridge.getOOMReason(r3.getAbsolutePath());
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.length != 5) goto L9;
        JSONUtils.append(r2, "native_oom_reason", r4[0]);
        JSONUtils.append(r2, "vma_leak_reason", r4[1]);
        JSONUtils.append(r2, "mem_rss_reason", r4[2]);
        JSONUtils.append(r2, "mem_pss_reason", r4[3]);
        JSONUtils.append(r2, "mem_ref_reason", r4[4]);
        return;
    }

    private static void appendNpthDumperStatus(JSONObject r7, File r8) {
        File r0 = new File(r8, "dlog.txt");
        boolean r1 = false;
        String r2 = "none";
        if (r0.exists() == true) goto L5;
    L19:
        boolean r3 = false;
    L20:
        JSONUtils.append(r7, "dumper_loaded", Boolean.valueOf(r1));
        JSONUtils.append(r7, "dumper_exit_code", r2);
        JSONUtils.append(r7, "npth_dumper_success", Boolean.valueOf(r3));
        return;
    L5:
        if (r0.length() <= 0) goto L19;
        BufferedReader r9 = new BufferedReader(new FileReader(r0));     // Catch: Throwable -> L23
        r3 = false;
    L26:
        String r4 = r9.readLine();     // Catch: Throwable -> L22
        if (r4 == null) goto L20;
        if (r4.contains("[dumper] onload") == true) goto L12;
        if (r4.contains("[dumper] exit status:") == false) goto L26;
        int r5 = r4.lastIndexOf(58);     // Catch: Throwable -> L22
        if (r5 == (-1)) goto L26;
        r2 = r4.substring(r5 + 1).trim();     // Catch: Throwable -> L22
        r3 = r2.equals("0");     // Catch: Throwable -> L22
    L12:
        r1 = true;
        goto L26
    }

    private static void appendProtectorInfo(JSONObject r2, File r3) {
        ProtectorInfo r0 = new ProtectorInfo(r3);
        if (r0.init() == true) goto L5;
        return;
    L5:
        JSONUtils.append(r2, "has_protector_history", Boolean.valueOf(r0.hasHistory()));
        if (r0.hasHistory() == false) goto L12;
        JSONUtils.append(r2, "protector_sid", r0.getSid());
        JSONUtils.append(r2, "protector_performed_count", Integer.valueOf(r0.getPerformedCount()));
        JSONUtils.append(r2, "protector_total_performed_count", Integer.valueOf(r0.getTotalPerformedCount()));
        JSONUtils.append(r2, "protector_performed", Boolean.valueOf(r0.isPerformed()));
        JSONUtils.append(r2, "protector_final_performed", Boolean.valueOf(r0.isFinalPerformed()));
        JSONUtils.append(r2, "protector_origin_scope", r0.getOriginScope());
        JSONUtils.append(r2, "protector_previous_scope", r0.getPreviousScope());
        if (r0.isPerformed() == false) goto L10;
        JSONUtils.append(r2, "protector_scope", r0.getScope());
    L10:
        r0.dump();
        return;
    }

    private static void appendPthreadKey(JSONObject r3, File r4) {
        int r0 = ProcInfo.getPthreadKeyCount(r4);
        if (r0 == 0) goto L8;
        JSONUtils.append(r3, "pthread_key_range", ProcInfo.getPthreadKeyCountRange(r0));
        JSONUtils.append(r3, "has_pthread_key_leak", Boolean.valueOf(ProcInfo.isPthreadKeyLeak(r0)));
        if (ProcInfo.isPthreadKeyLeak(r0) == false) goto L9;
        JSONUtils.append(r3, "pthread_key_leak_lib", NativeBridge.getPthreadKeyLeakLibrary(r4));
        return;
    L9:
        return;
    }

    private static void appendThread(JSONObject r3, File r4) {
        int r0 = ProcInfo.getThreadCount(r4);
        if (r0 == 0) goto L8;
        JSONUtils.append(r3, "thread_count_range", ProcInfo.getThreadCountRange(r0));
        boolean r1 = ProcInfo.isThreadLeak(r0);
        JSONUtils.append(r3, "threads_leak", Boolean.valueOf(r1));
        if (r1 == false) goto L9;
        JSONUtils.append(r3, "threads_leak_name", NativeBridge.getThreadLeakName(r4));
        JSONUtils.append(r3, "threads_leak_library", NativeBridge.getThreadLeakLibrary(r4));
        return;
    L9:
        return;
    }

    private static void appendTimeRelated(JSONObject r10, JSONObject r11, JSONObject r12) {
        long r0 = r12.optLong("crash_time");
        long r2 = r12.optLong("app_start_time");
        if (r0 != 0) goto L5;
    L7:
        long r6 = r11.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        if (r6 != 0) goto L10;
        return;
    L10:
        String r8 = "true";
        if (r2 != 0) goto L13;
    L17:
        long r3 = GeneralInfoManager.getLastUpdateTime(0);
        if (r3 != 0) goto L21;
        return;
    L21:
        if (r6 != r3) goto L23;
        String r4 = "true";
    L24:
        JSONUtils.append(r10, "crash_same_upload", r4);
        if (r6 == r3) goto L35;
        if (r0 == 0) goto L36;
        long r13 = GeneralInfoManager.getLastUpdateTime(r0);
        if (r13 != 0) goto L30;
        return;
    L30:
        if (r6 != r13) goto L33;
        r8 = "false";
    L33:
        JSONUtils.append(r10, "crash_when_update", r8);
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r4 = "false";
        goto L24
    L13:
        if (r2 <= r6) goto L15;
        String r14 = "true";
    L16:
        JSONUtils.append(r10, "valid_app_info", r14);
        goto L17
    L15:
        r14 = "false";
        goto L16
    L5:
        if (r2 == 0) goto L7;
        JSONUtils.append(r10, "use_time", Long.valueOf((r0 - r2) / 1000));
        goto L7
    }

    private static void appendVmFilter(JSONObject r10, JSONObject r11, File r12, boolean r13) {
        boolean r0 = NativeBridge.is64BitRuntime();
        long r1 = ProcInfo.getVmPeakKb(r12);
        boolean r3 = ProcInfo.isVmaCountLeak(ProcInfo.getVmaCount(r12));
        JSONUtils.append(r10, "vma_leak", Boolean.valueOf(r3));
        if (r1 <= 0) goto L7;
        if (r0 == false) goto L6;
        JSONUtils.append(r10, "vm_peak_range", ProcInfo.getVmRange64(r1));
        goto L7
    L6:
        JSONUtils.append(r10, "vm_peak_usage", ProcInfo.getVmUsage32(r1, r13));
        boolean r2 = ProcInfo.isMemoryLeak32(r1, r13);
        JSONUtils.append(r10, "memory_leak", Boolean.valueOf(r2));
    L8:
        long r6 = ProcInfo.getVmSizeKb(r12);
        if (r6 <= 0) goto L13;
        if (r0 == false) goto L12;
        String r14 = ProcInfo.getVmRange64(r6);
    L14:
        JSONUtils.append(r10, "vmsize_range", r14);
        JSONUtils.appendLong(r11, "memory_size", r6);
        long r7 = ProcInfo.getVmRssKb(r12);
        JSONUtils.appendLong(r11, "rss", r7);
        boolean r15 = ProcInfo.isRssExcess(1024 * r7);
        if (r7 <= 0) goto L17;
        JSONUtils.append(r10, "rss_size_range", ProcInfo.getVmRssRange(r7));
    L17:
        if (r2 == true) goto L20;
        if (r3 == true) goto L20;
        if (r15 == true) goto L20;
        return;
    L20:
        appendMemoryReasonFilter(r10, r12);
        return;
    L12:
        r14 = ProcInfo.getVmUsage32(r6, r13);
        goto L14
    L13:
        r14 = "(0 - 0)";
    L7:
        r2 = false;
        goto L8
    }

    private static String getHeapUsage(long r0, long r2) {
        float r3 = r2;
        float r1 = r0;
        if (r3 <= (0.95f * r1)) goto L7;
        return "(95% - 100%]";
    L7:
        if (r3 <= (0.9f * r1)) goto L11;
        return "(90% - 95%]";
    L11:
        if (r3 <= (0.8f * r1)) goto L15;
        return "(80% - 90%]";
    L15:
        if (r3 <= (0.7f * r1)) goto L19;
        return "(70% - 80%]";
    L19:
        if (r3 <= (0.6f * r1)) goto L23;
        return "(60% - 70%]";
    L23:
        if (r3 <= (r1 * 0.5f)) goto L26;
        return "(50% - 60%]";
    L26:
        return "(0% - 50%]";
    }

    private static String getJavaHeapRange(long r8) {
        NumRanges r7 = new NumRanges("MB");
        r7.set(0, 512, 64);
        return r7.get(r8);
    }

    private static String getNativeHeapRange(long r4) {
        NumRanges r0 = new NumRanges("MB");
        r0.set(new Long[]{0L, 1L, 64L, 128L, 256L, 384L, 512L, 768L, 1024L, 1536L});
        return r0.get(r4);
    }

    private static String millisToReadable(long r2) {
        if (r2 >= 0) goto L7;
        return "( - 0s)";
    L7:
        if (r2 >= 60000) goto L11;
        return "(0s - 1m)";
    L11:
        if (r2 >= 600000) goto L15;
        return "[1m - 10m)";
    L15:
        if (r2 >= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L19;
        return "[10m - 1h)";
    L19:
        if (r2 >= 10800000) goto L23;
        return "[1h - 3h)";
    L23:
        if (r2 >= 43200000) goto L27;
        return "[3h - 12h)";
    L27:
        if (r2 >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L31;
        return "[12h - 1d)";
    L31:
        if (r2 >= 259200000) goto L35;
        return "[1d - 3d)";
    L35:
        if (r2 >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) goto L39;
        return "[3d - 7d)";
    L39:
        if (r2 >= 1209600000) goto L43;
        return "[7d - 14d)";
    L43:
        if (r2 >= 2592000000L) goto L46;
        return "[14d - 30d)";
    L46:
        return "[30d - )";
    }

    private static boolean validFile(File r2, String r3, int r4) {
        File r0 = new File(r2, r3);
        if (r0.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.length() <= r4) goto L7;
        return true;
    }
}
