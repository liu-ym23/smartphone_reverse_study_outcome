package com.bytedance.crash.entity;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
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
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.AppInfoUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NumRanges;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CrashFilter {
    public static final String FILTERS = "filters";
    public static final String IS_64_RUNTIME = "is_64_runtime";
    public static final String IS_ROOT = "is_root";
    public static final String IS_X86_DEVICES = "is_x86_devices";

    public CrashFilter() {
    }

    private static void appendCombineSinceCrashed(JSONObject r10, JSONObject r11) {
        long r12 = r11.optLong("crash_time");
        long r13 = System.currentTimeMillis();
        if (r12 > 0) goto L5;
        return;
    L5:
        if (r13 <= r12) goto L9;
        JSONUtils.append(r10, "crash_length", millisToReadable(r13 - r12));
        return;
    }

    public static void appendCommonFilter(JSONObject r10, JSONObject r11, File r12) {
        JSONObject r13 = JSONUtils.get(r11, "filters");
        CustomFilter.pushTo(r11, r12);
        CustomFilter.pushCustomReasonTo(r11, r12);
        JSONUtils.append(r13, Constants.HAS_DUMP, Boolean.TRUE);
        JSONUtils.append(r13, "is_root", Boolean.valueOf(GeneralInfoManager.isRoot()));
        JSONUtils.append(r13, "alog_inited", Boolean.valueOf(AlogManager.isInit()));
        JSONUtils.append(r13, "sdk_version", NpthBuildConfig.VERSION_NAME);
        JSONUtils.append(r13, CrashBody.CRASH_THREAD_NAME, r11.optString(CrashBody.CRASH_THREAD_NAME, "unknown"));
        JSONUtils.append(r13, "is_64_runtime", Boolean.valueOf(NativeBridge.is64BitRuntime()));
        JSONUtils.append(r13, Constants.IS_HM_OS, r10.optString(Constants.IS_HM_OS));
        JSONUtils.append(r13, "version_type", r10.optString("version_type"));
        JSONUtils.append(r13, "kernel_version", r10.optString("kernel_version"));
        JSONUtils.append(r13, "app_version_exact", r10.optString("app_version_exact"));
        JSONUtils.append(r13, "crash_md5", r11.optString("crash_md5"));
        JSONUtils.append(r13, HardwareInfo.KEY_HW_CPU_MODEL, r10.optString(HardwareInfo.KEY_HW_CPU_MODEL));
        JSONUtils.append(r13, HardwareInfo.KEY_HW_CPU_HARDWARE, r10.optString(HardwareInfo.KEY_HW_CPU_HARDWARE));
        JSONUtils.append(r13, HardwareInfo.KEY_HW_RAM_SIZE, r10.optString(HardwareInfo.KEY_HW_RAM_SIZE));
        JSONUtils.append(r13, ActivityLifecycle.LAST_RESUME_ACTIVITY, ActivityLifecycle.getLastResumedActivityFromBody(r11));
        String r14 = NativeBridge.loadNativeCrashAbortReason(r12.getAbsolutePath());
        if (r14 == null) goto L5;
        JSONUtils.append(r13, CrashBody.ABORT_REASON, r14);
    L5:
        JSONObject r15 = r11.optJSONObject(Scraps.STORAGE);
        if (r15 == null) goto L8;
        JSONUtils.append(r13, Scraps.INNER_TOTAL, r15.optString(Scraps.INNER_TOTAL));
        JSONUtils.append(r13, Scraps.INNER_FREE, r15.optString(Scraps.INNER_FREE));
    L8:
        String r16 = r10.optString("cpu_abi");
        if (TextUtils.isEmpty(r16) == true) goto L11;
        boolean r17 = r16.contains("64");
        JSONUtils.append(r13, "is_x86_devices", Boolean.valueOf(r16.contains("86")));
        JSONUtils.append(r13, Constants.IS_64_DEVICES, Boolean.valueOf(r17));
        appendVmFilter(r13, r11, r12, r17);
    L11:
        appendTimeRelated(r13, r10, r11);
        AppInfoUtils.expandFilters(r13);
        appendThread(r13, r12);
        appendFd(r13, r12);
        appendPthreadKey(r13, r12);
        appendDumpFiles(r13, r12);
        appendNpthDumperStatus(r13, r12);
        appendProtectorInfo(r13, r12);
        appendLogcatFilter(r13, r11);
        appendMemoryInfo(r13, r11);
        ResourceMonitor.appendResourceMonitorTags(r13, r12);
        appendCombineSinceCrashed(r13, r11);
        appendCrashSinceUpdated(r13, r10, r11);
        appendImportTags(r13, r11);
    }

    private static void appendCrashSinceUpdated(JSONObject r10, JSONObject r11, JSONObject r12) {
        long r13 = r11.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        long r14 = r12.optLong("crash_time");
        if (r13 <= 0) goto L6;
        JSONUtils.append(r10, "crash_since_updated", millisToReadable(r14 - r13));
        return;
    }

    private static void appendDumpFiles(JSONObject r10, File r11) {
        JSONUtils.append(r10, "has_tombstone_file", Boolean.valueOf(validFile(r11, "tombstone.txt", 10)));
        JSONUtils.append(r10, "has_dlog_file", Boolean.valueOf(validFile(r11, "dlog.txt", 10)));
        JSONUtils.append(r10, "has_logcat_file", Boolean.valueOf(validFile(r11, "logcat.txt", 512)));
        JSONUtils.append(r10, "has_logcat_file_os", Boolean.valueOf(validFile(r11, "logcat_os.txt", 512)));
        JSONUtils.append(r10, "has_malloc_file", Boolean.valueOf(validFile(r11, "malloc.txt", 64)));
        JSONUtils.append(r10, "has_meminfo_file", Boolean.valueOf(validFile(r11, "meminfo.txt", 64)));
        JSONUtils.append(r10, "has_maps_file", Boolean.valueOf(validFile(r11, "maps.txt", 1024)));
        JSONUtils.append(r10, "has_smaps_file", Boolean.valueOf(validFile(r11, "smaps.txt", 1024)));
        JSONUtils.append(r10, "has_pthreads_file", Boolean.valueOf(validFile(r11, "pthreads.txt", 64)));
        JSONUtils.append(r10, "has_threads_file", Boolean.valueOf(validFile(r11, "threads.txt", 64)));
        JSONUtils.append(r10, "has_fds_file", Boolean.valueOf(validFile(r11, "fds.txt", 64)));
        JSONUtils.append(r10, "has_view_tree", Boolean.valueOf(validFile(r11, ViewTree.FILE_NAME, 64)));
        JSONUtils.append(r10, "has_pthread_key_map_file", Boolean.valueOf(validFile(r11, "pthread_key_map.txt", 10)));
        JSONUtils.append(r10, "has_pthread_key_file", Boolean.valueOf(validFile(r11, "pthread_key_info.txt", 10)));
        JSONUtils.append(r10, "has_routine_file", Boolean.valueOf(validFile(r11, "rountines.txt", 64)));
        JSONUtils.append(r10, "has_gfx_file", Boolean.valueOf(validFile(r11, "gfxinfo.txt", 64)));
        JSONUtils.append(r10, "has_os_memory", Boolean.valueOf(validFile(r11, "os_memory.txt", 64)));
        JSONUtils.append(r10, "has_environ", Boolean.valueOf(validFile(r11, "environ.txt", 64)));
        JSONUtils.append(r10, "has_signal_monitor_file", Boolean.valueOf(validFile(r11, "signal_monitor.txt", 64)));
        JSONUtils.append(r10, "has_heaptrack_file", Boolean.valueOf(validFile(r11, "leak_heap.txt", 64)));
        JSONUtils.append(r10, "has_setpriority_file", Boolean.valueOf(validFile(r11, "priority_stack.txt", 64)));
        JSONUtils.append(r10, "has_setpriority_file", Boolean.valueOf(validFile(r11, "priority_jstack.txt", 64)));
        JSONUtils.append(r10, "has_memtrack_dump", Boolean.valueOf(validFile(r11, "sys_memtrack.txt", 16)));
    }

    private static void appendFd(JSONObject r10, File r11) {
        int r12 = ProcInfo.getFdCount(r11);
        if (r12 == 0) goto L8;
        JSONUtils.append(r10, "fd_count_range", ProcInfo.getFdCountRange(r12));
        boolean r13 = ProcInfo.isFdLeak(r12);
        JSONUtils.append(r10, "fd_leak", Boolean.valueOf(r13));
        if (r13 == false) goto L9;
        JSONUtils.append(r10, "fd_leak_reason", NativeBridge.getFdLeakReason(r11));
        return;
    L9:
        return;
    }

    private static void appendImportTags(JSONObject r10, JSONObject r11) {
        String r12 = r11.optString("process_name");
        long r13 = r11.optLong("app_start_time");
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return;
    L5:
        if (r13 == 0) goto L9;
        TagService.dumpImportTags(r10, r13, r12);
        return;
    }

    public static void appendJavaHeapFilters(JSONObject r10, JSONObject r11) {
        JSONObject r12 = r11.optJSONObject("app_memory_info");
        if (r12 == null) goto L15;
        long r13 = r12.optLong("max_memory");
        long r14 = r12.optLong("free_memory");
        long r15 = r12.optLong("total_memory");
        long r16 = r15 - r14;
        if (r16 <= 0) goto L10;
        JSONUtils.append(r10, "java_heap_range", getJavaHeapRange(r16 / 1048576));
        if (r13 <= r16) goto L10;
        JSONUtils.append(r10, "java_heap_alloc_usage", getHeapUsage(r15, r16));
        JSONUtils.append(r10, "java_heap_usage", getHeapUsage(r13, r15));
    L10:
        if (r16 <= (r13 * 0.95f)) goto L12;
        boolean r17 = true;
    L13:
        JSONUtils.append(r10, "java_heap_leak", String.valueOf(r17));
        return;
    L12:
        r17 = false;
        goto L13
    }

    private static void appendLogcatFilter(JSONObject r10, JSONObject r11) {
        JSONUtils.append(r10, "has_logcat", Boolean.valueOf(!JSONUtils.isEmpty(r11.optJSONArray(Constants.LOGCAT))));
    }

    private static void appendMemoryInfo(JSONObject r12, JSONObject r13) {
        appendJavaHeapFilters(r12, r13);
        JSONObject r10 = r13.optJSONObject("app_memory_info");
        if (r10 == null) goto L17;
        long r11 = r10.optLong("native_heap_size");
        JSONUtils.append(r12, "native_heap_range", getNativeHeapRange(r11));
        if (r11 <= 0) goto L17;
        JSONUtils.append(r12, "native_heap_range", getNativeHeapRange(r11));
        boolean r14 = true;
        if (r11 <= 268435456) goto L9;
        boolean r15 = true;
    L10:
        JSONUtils.append(r12, "native_heap_leak", Boolean.valueOf(r15));
        long r16 = r10.optLong("native_heap_alloc_size");
        if (r16 <= 0) goto L17;
        if (r16 > 268435456) goto L16;
        r14 = false;
    L16:
        JSONUtils.append(r12, "native_heap_alloc_leak", Boolean.valueOf(r14));
        JSONUtils.append(r12, "native_heap_alloc_usage", getHeapUsage(r11, r16));
        goto L17
    L9:
        r15 = false;
    L17:
        JSONObject r17 = r13.optJSONObject("memory_info");
        if (r17 == null) goto L23;
        long r18 = r17.optLong("totalPss");
        if (r18 <= 0) goto L24;
        JSONUtils.append(r12, "total_pss_range", getNativeHeapRange(r18));
        return;
    L24:
        return;
    }

    private static void appendMemoryReasonFilter(JSONObject r10, File r11) {
        String[] r12 = NativeBridge.getOOMReason(r11.getAbsolutePath());
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length != 5) goto L9;
        JSONUtils.append(r10, "native_oom_reason", r12[0]);
        JSONUtils.append(r10, "vma_leak_reason", r12[1]);
        JSONUtils.append(r10, "mem_rss_reason", r12[2]);
        JSONUtils.append(r10, "mem_pss_reason", r12[3]);
        JSONUtils.append(r10, "mem_ref_reason", r12[4]);
        return;
    }

    private static void appendNpthDumperStatus(JSONObject r10, File r11) {
        File r12 = new File(r11, "dlog.txt");
        boolean r13 = false;
        String r14 = "none";
        if (r12.exists() == true) goto L5;
    L19:
        boolean r15 = false;
    L20:
        JSONUtils.append(r10, "dumper_loaded", Boolean.valueOf(r13));
        JSONUtils.append(r10, "dumper_exit_code", r14);
        JSONUtils.append(r10, "npth_dumper_success", Boolean.valueOf(r15));
        return;
    L5:
        if (r12.length() <= 0) goto L19;
        BufferedReader r16 = new BufferedReader(new FileReader(r12));     // Catch: Throwable -> L23
        r15 = false;
    L26:
        String r17 = r16.readLine();     // Catch: Throwable -> L22
        if (r17 == null) goto L20;
        if (r17.contains("[dumper] onload") == true) goto L12;
        if (r17.contains("[dumper] exit status:") == false) goto L26;
        int r18 = r17.lastIndexOf(58);     // Catch: Throwable -> L22
        if (r18 == (-1)) goto L26;
        r14 = r17.substring(r18 + 1).trim();     // Catch: Throwable -> L22
        r15 = r14.equals(NetConst.NOT_ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L22
    L12:
        r13 = true;
        goto L26
    }

    private static void appendProtectorInfo(JSONObject r10, File r11) {
        ProtectorInfo r12 = new ProtectorInfo(r11);
        if (r12.init() == true) goto L5;
        return;
    L5:
        JSONUtils.append(r10, "has_protector_history", Boolean.valueOf(r12.hasHistory()));
        if (r12.hasHistory() == false) goto L12;
        JSONUtils.append(r10, "protector_sid", r12.getSid());
        JSONUtils.append(r10, "protector_performed_count", Integer.valueOf(r12.getPerformedCount()));
        JSONUtils.append(r10, "protector_total_performed_count", Integer.valueOf(r12.getTotalPerformedCount()));
        JSONUtils.append(r10, "protector_performed", Boolean.valueOf(r12.isPerformed()));
        JSONUtils.append(r10, "protector_final_performed", Boolean.valueOf(r12.isFinalPerformed()));
        JSONUtils.append(r10, "protector_origin_scope", r12.getOriginScope());
        JSONUtils.append(r10, "protector_previous_scope", r12.getPreviousScope());
        if (r12.isPerformed() == false) goto L10;
        JSONUtils.append(r10, "protector_scope", r12.getScope());
    L10:
        r12.dump();
        return;
    }

    private static void appendPthreadKey(JSONObject r10, File r11) {
        int r12 = ProcInfo.getPthreadKeyCount(r11);
        if (r12 == 0) goto L8;
        JSONUtils.append(r10, "pthread_key_range", ProcInfo.getPthreadKeyCountRange(r12));
        JSONUtils.append(r10, "has_pthread_key_leak", Boolean.valueOf(ProcInfo.isPthreadKeyLeak(r12)));
        if (ProcInfo.isPthreadKeyLeak(r12) == false) goto L9;
        JSONUtils.append(r10, "pthread_key_leak_lib", NativeBridge.getPthreadKeyLeakLibrary(r11));
        return;
    L9:
        return;
    }

    private static void appendThread(JSONObject r10, File r11) {
        int r12 = ProcInfo.getThreadCount(r11);
        if (r12 == 0) goto L8;
        JSONUtils.append(r10, "thread_count_range", ProcInfo.getThreadCountRange(r12));
        boolean r13 = ProcInfo.isThreadLeak(r12);
        JSONUtils.append(r10, "threads_leak", Boolean.valueOf(r13));
        if (r13 == false) goto L9;
        JSONUtils.append(r10, "threads_leak_name", NativeBridge.getThreadLeakName(r11));
        JSONUtils.append(r10, "threads_leak_library", NativeBridge.getThreadLeakLibrary(r11));
        return;
    L9:
        return;
    }

    private static void appendTimeRelated(JSONObject r10, JSONObject r11, JSONObject r12) {
        long r13 = r12.optLong("crash_time");
        long r14 = r12.optLong("app_start_time");
        if (r13 != 0) goto L5;
    L7:
        long r15 = r11.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        if (r15 != 0) goto L10;
        return;
    L10:
        String r16 = "true";
        if (r14 != 0) goto L13;
    L17:
        long r17 = GeneralInfoManager.getLastUpdateTime(0);
        if (r17 != 0) goto L21;
        return;
    L21:
        if (r15 != r17) goto L23;
        String r18 = "true";
    L24:
        JSONUtils.append(r10, "crash_same_upload", r18);
        if (r15 == r17) goto L35;
        if (r13 == 0) goto L36;
        long r19 = GeneralInfoManager.getLastUpdateTime(r13);
        if (r19 != 0) goto L30;
        return;
    L30:
        if (r15 != r19) goto L33;
        r16 = "false";
    L33:
        JSONUtils.append(r10, "crash_when_update", r16);
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r18 = "false";
        goto L24
    L13:
        if (r14 <= r15) goto L15;
        String r110 = "true";
    L16:
        JSONUtils.append(r10, "valid_app_info", r110);
        goto L17
    L15:
        r110 = "false";
        goto L16
    L5:
        if (r14 == 0) goto L7;
        JSONUtils.append(r10, "use_time", Long.valueOf((r13 - r14) / 1000));
        goto L7
    }

    private static void appendVmFilter(JSONObject r10, JSONObject r11, File r12, boolean r13) {
        boolean r14 = NativeBridge.is64BitRuntime();
        long r15 = ProcInfo.getVmPeakKb(r12);
        boolean r16 = ProcInfo.isVmaCountLeak(ProcInfo.getVmaCount(r12));
        JSONUtils.append(r10, "vma_leak", Boolean.valueOf(r16));
        if (r15 <= 0) goto L7;
        if (r14 == false) goto L6;
        JSONUtils.append(r10, "vm_peak_range", ProcInfo.getVmRange64(r15));
        goto L7
    L6:
        JSONUtils.append(r10, "vm_peak_usage", ProcInfo.getVmUsage32(r15, r13));
        boolean r17 = ProcInfo.isMemoryLeak32(r15, r13);
        JSONUtils.append(r10, "memory_leak", Boolean.valueOf(r17));
    L8:
        long r18 = ProcInfo.getVmSizeKb(r12);
        if (r18 <= 0) goto L13;
        if (r14 == false) goto L12;
        String r19 = ProcInfo.getVmRange64(r18);
    L14:
        JSONUtils.append(r10, "vmsize_range", r19);
        JSONUtils.appendLong(r11, "memory_size", r18);
        long r20 = ProcInfo.getVmRssKb(r12);
        JSONUtils.appendLong(r11, "rss", r20);
        boolean r110 = ProcInfo.isRssExcess(1024 * r20);
        if (r20 <= 0) goto L17;
        JSONUtils.append(r10, "rss_size_range", ProcInfo.getVmRssRange(r20));
    L17:
        if (r17 == true) goto L20;
        if (r16 == true) goto L20;
        if (r110 == true) goto L20;
        return;
    L20:
        appendMemoryReasonFilter(r10, r12);
        return;
    L12:
        r19 = ProcInfo.getVmUsage32(r18, r13);
        goto L14
    L13:
        r19 = "(0 - 0)";
    L7:
        r17 = false;
        goto L8
    }

    private static String getHeapUsage(long r10, long r11) {
        float r12 = r11;
        float r13 = r10;
        if (r12 <= (0.95f * r13)) goto L7;
        return "(95% - 100%]";
    L7:
        if (r12 <= (0.9f * r13)) goto L11;
        return "(90% - 95%]";
    L11:
        if (r12 <= (0.8f * r13)) goto L15;
        return "(80% - 90%]";
    L15:
        if (r12 <= (0.7f * r13)) goto L19;
        return "(70% - 80%]";
    L19:
        if (r12 <= (0.6f * r13)) goto L23;
        return "(60% - 70%]";
    L23:
        if (r12 <= (r13 * 0.5f)) goto L26;
        return "(50% - 60%]";
    L26:
        return "(0% - 50%]";
    }

    private static String getJavaHeapRange(long r10) {
        NumRanges r11 = new NumRanges("MB");
        r11.set(0, 512, 64);
        return r11.get(r10);
    }

    private static String getNativeHeapRange(long r10) {
        NumRanges r11 = new NumRanges("MB");
        r11.set(new Long[]{0L, 1L, 64L, 128L, 256L, 384L, 512L, 768L, 1024L, 1536L});
        return r11.get(r10);
    }

    private static String millisToReadable(long r10) {
        if (r10 >= 0) goto L7;
        return "( - 0s)";
    L7:
        if (r10 >= VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L11;
        return "(0s - 1m)";
    L11:
        if (r10 >= 600000) goto L15;
        return "[1m - 10m)";
    L15:
        if (r10 >= 3600000) goto L19;
        return "[10m - 1h)";
    L19:
        if (r10 >= 10800000) goto L23;
        return "[1h - 3h)";
    L23:
        if (r10 >= 43200000) goto L27;
        return "[3h - 12h)";
    L27:
        if (r10 >= 86400000) goto L31;
        return "[12h - 1d)";
    L31:
        if (r10 >= 259200000) goto L35;
        return "[1d - 3d)";
    L35:
        if (r10 >= 604800000) goto L39;
        return "[3d - 7d)";
    L39:
        if (r10 >= 1209600000) goto L43;
        return "[7d - 14d)";
    L43:
        if (r10 >= 2592000000L) goto L46;
        return "[14d - 30d)";
    L46:
        return "[30d - )";
    }

    private static boolean validFile(File r10, String r11, int r12) {
        File r13 = new File(r10, r11);
        if (r13.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r13.length() <= r12) goto L7;
        return true;
    }
}
