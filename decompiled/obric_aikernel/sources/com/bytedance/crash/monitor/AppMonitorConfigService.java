package com.bytedance.crash.monitor;

import android.os.Build;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.Global;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.anr.AnrDumper;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.anr.AnrProfiler;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.coredump.CoreDumpConfig;
import com.bytedance.crash.coredump.CoredumpAdapter;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.crash.NativeCrashHandler;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.event.BizExceptionConfig;
import com.bytedance.crash.event.BizExceptionManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.repair.RepairConfig;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.runtime.AllDefaultUrls;
import com.bytedance.crash.terminate.TerminateMonitor;
import com.bytedance.crash.upload.NetworkDisasterManager;
import com.bytedance.crash.upload.UploadLimitConfig;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.librarian.a;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppMonitorConfigService extends EventConfigService {
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    protected static final String KEY_CORE_DUMP_CONFIG = "enable_coredump_config";
    protected static final String KEY_DISABLE_API_LEVEL_PROFILER = "disable_api_level_profiler";
    protected static final String KEY_ENABLE_API_LEVEL = "enable_api_level";
    protected static final String KEY_ENABLE_ASYNC_CORE_DUMP = "enable_async_coredump";
    protected static final String KEY_ENABLE_COREDUMP = "enable_coredump";
    protected static final String KEY_ENABLE_CORE_DUMP_UPLOAD = "upload_core_dump";
    protected static final String KEY_ENABLE_DEVICE_BRAND = "enable_device_brand";
    protected static final String KEY_ENABLE_KILL_HISTORY = "enable_kill_history_err";
    protected static final String KEY_ENABLE_KILL_HISTORY_FG = "enable_kill_history_fg";
    protected static final String KEY_GWP_ASAN_CONFIG = "gwp_asan_set_init_param";
    protected static final String KEY_REPAIR_DEBUG = "enable_debug_repair";
    protected static final String KEY_REPAIR_DELAYED_TIME = "repair_delayed_time";
    protected static final String KEY_REPAIR_PORTRAIT = "repair_portrait";
    protected static final String KEY_REPAIR_TYPE = "repair_type";
    protected static final String KEY_UPLOAD_BG_ANR = "enable_upload_bg_anr";
    private static final String LOG_TAG = "NPTH_CFG";
    protected static final String NPTH_FD_TRACKER_SETTING = "fd_track";
    private static JSONObject mFdTrackerSettings = null;
    private static JSONArray mGwpAsanSettings = null;
    private static boolean sDumpAnrInfoEnable = true;
    private static boolean sDumpCustomDataEnable = true;
    private static boolean sDumpLogcatEnable = true;
    private static boolean sDumpMessageEnable = true;
    private static boolean sDumpNativeInfoEnable = true;
    private static boolean sEnableSLIException = false;
    private static boolean sIsUseLocalDomain = false;
    private static boolean sSceneException = false;
    private static boolean sSoLoaded = false;
    protected CoreDumpConfig coreDumpConfig;
    protected RepairConfig repairConfig;
    protected UploadLimitConfig uploadLimitConfig;

    static {
    }

    public AppMonitorConfigService(CrashListener r10) {
        super(r10);
    }

    public static boolean disableAnrProfiler() {
        return "true".equals(FileUtils.readFile(new File(Global.getConfigDir(), "anr_profiler.config")));
    L4:
        return false;
    }

    public static boolean enableAnrInfoReport() {
        return true;
    }

    public static boolean enableDumpMessage() {
        return true;
    }

    public static boolean enableLogcatReport() {
        return true;
    }

    public static boolean enableNativeInfo() {
        return true;
    }

    public static boolean enableUserCustomData() {
        return true;
    }

    public static boolean enable_SLI_exception() {
        return sEnableSLIException;
    }

    public static boolean enable_scene_exception() {
        return sSceneException;
    }

    private static JSONObject getFdTrackObject(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("custom_event_settings");
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.optJSONObject(NPTH_FD_TRACKER_SETTING);
    }

    public static JSONArray getGwpAsanConfig() {
        return mGwpAsanSettings;
    }

    private static JSONObject getNpthSimpleObject(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("custom_event_settings");
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.optJSONObject(EventConfigService.NPTH_SIMPLE_SETTING);
    }

    private static JSONObject getProtectorObject(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(EventConfigService.EXCEPTION_MODULE);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.optJSONObject("protector");
    }

    public static boolean isSupportApiLevel(JSONArray r10) {
        if (r10 != null) goto L23;
        return false;
    L23:
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        return false;
    L6:
        if (r10.toString().contains("none") == false) goto L9;
        return false;
    L9:
        if (r10.toString().contains("all") == false) goto L12;
        return true;
    L12:
        if (r10.length() <= 0) goto L22;
        int r11 = 0;
    L15:
        if (r11 >= r10.length()) goto L22;
        if (Build.VERSION.SDK_INT == Integer.parseInt(r10.optString(r11))) goto L18;
        r11 = r11 + 1;
        goto L15
    L18:
        return true;
    }

    public static boolean isSupportDeviceBrand(JSONArray r10) {
        if (r10 != null) goto L28;
        return false;
    L28:
    L25:
        th = move-exception;
        th.printStackTrace();
    L27:
        return false;
    L6:
        if (r10.toString().contains("none") == true) goto L24;
        String r11 = Build.BRAND;     // Catch: Throwable -> L25
        if (r11.isEmpty() == true) goto L24;
        if (r11.contains("ubia") == true) goto L24;
        if (r10.toString().contains("all") == false) goto L16;
        return true;
    L16:
        if (r10.length() <= 0) goto L27;
        int r12 = 0;
    L19:
        if (r12 >= r10.length()) goto L27;
        if (Build.BRAND.equals(r10.optString(r12)) == true) goto L22;
        r12 = r12 + 1;
        goto L19
    L22:
        return true;
    L24:
        return false;
    }

    private void parseBizException(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject(EventConfigService.EXCEPTION_MODULE);
        if (r11 != null) goto L5;
        return;
    L5:
        JSONObject r12 = r11.optJSONObject("biz_exception");
        if (r12 != null) goto L8;
        return;
    L8:
        boolean r13 = false;
        int r14 = r12.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0);
        HashSet r15 = new HashSet();
        JSONObject r16 = r12.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        if (r16 == null) goto L16;
        Iterator<String> r17 = r16.keys();
    L12:
        if (r17.hasNext() == false) goto L16;
        String r18 = r17.next();
        if (r16.optInt(r18) != 1) goto L12;
        r15.add(r18);
    L16:
        BizExceptionManager r19 = BizExceptionManager.getInstance();
        if (r14 != 1) goto L19;
        r13 = true;
    L19:
        r19.setConfig(new BizExceptionConfig(r13, r15));
    }

    private static void parseDumpData(JSONObject r10) {
        if (r10 == null) goto L24;
        boolean r11 = false;
        if (r10.optInt("enable_anrinfo_report") != 1) goto L6;
        boolean r12 = true;
    L7:
        sDumpAnrInfoEnable = r12;
        if (r10.optInt("enable_user_custom_data") != 1) goto L10;
        boolean r13 = true;
    L11:
        sDumpCustomDataEnable = r13;
        if (r10.optInt("enable_logcat_report") != 1) goto L14;
        boolean r14 = true;
    L15:
        sDumpLogcatEnable = r14;
        if (r10.optInt("enable_native_info") != 1) goto L18;
        boolean r15 = true;
    L19:
        sDumpNativeInfoEnable = r15;
        if (r10.optInt("enable_dump_message") != 1) goto L22;
        r11 = true;
    L22:
        sDumpMessageEnable = r11;
        return;
    L18:
        r15 = false;
        goto L19
    L14:
        r14 = false;
        goto L15
    L10:
        r13 = false;
        goto L11
    L6:
        r12 = false;
        goto L7
    }

    public static void parseSetPriorityMonitorConfig(JSONObject r10) {
        if (r10.optInt("enable_setpriority_monitor") != 1) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L16;
        JSONArray r12 = r10.optJSONArray("setpriority_params");     // Catch: Throwable -> L13
        NativeBridge.priorityMonitorInit(FileSystemUtils.createDirectory(LogPathConfig.getPrioMonitorPath(), CrashManager.getProcessDirectoryName()).toString());     // Catch: Throwable -> L13
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.length() <= 0) goto L18;
        NativeBridge.setPriorityParams(r12.optBoolean(0), r12.optBoolean(1), r12.optInt(2));     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L16:
        return;
    L5:
        r11 = false;
    }

    private void parseUploadDomain(JSONObject r10) {
        if (sIsUseLocalDomain == true) goto L6;
        AllDefaultUrls.setDomainName(JSONUtils.getStringFromParent(r10, new String[]{"custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain"}), JSONUtils.getArrayFromParent(r10, new String[]{"custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain_list"}));
        return;
    }

    public static void setUseLocalDomain(boolean r10) {
        sIsUseLocalDomain = r10;
    }

    private static boolean tlsMonitorLoadLibrary() {
        NpthLog.i(LOG_TAG, "loadLibrary...");
        if (sSoLoaded == false) goto L7;
    L5:
        return true;
    L7:
        a.a("npth_tls_monitor", Global.getContext());     // Catch: Throwable -> L6
        sSoLoaded = true;     // Catch: Throwable -> L6
        goto L5
    }

    public CoreDumpConfig getCoreDumpConfig() {
        return this.coreDumpConfig;
    }

    public RepairConfig getRepairConfig() {
        return this.repairConfig;
    }

    public UploadLimitConfig getUploadLimitConfig() {
        return this.uploadLimitConfig;
    }

    @Override // com.bytedance.crash.monitor.EventConfigService, com.bytedance.crash.config.IConfigChangeListener
    public void onConfigChanged(JSONObject r10) {
        super.onConfigChanged(r10);
        JSONObject r11 = getNpthSimpleObject(r10);
        mFdTrackerSettings = getFdTrackObject(r10);
        mGwpAsanSettings = r11.optJSONArray(KEY_GWP_ASAN_CONFIG);
        parseUploadDomain(r10);
        parseBizException(r10);
        boolean r12 = true;
        if (r11.optInt("enable_upload_custom_java_crash") != 1) goto L5;
        boolean r13 = true;
    L6:
        Ensure.setUploadCustomJavaCrashEnable(r13);
        if (r11.optInt("enable_dump_history_message_java") != 1) goto L9;
        boolean r14 = true;
    L10:
        JavaCrashHandler.setDumpHistoryMessageEnable(r14);
        if (r11.optInt("enable_dump_history_message_native") != 1) goto L13;
        boolean r15 = true;
    L14:
        NativeCrashHandler.setDumpHistoryMessageEnable(r15);
        if (r11.optInt("enable_dump_view_tree_java") != 1) goto L17;
        boolean r16 = true;
    L18:
        JavaCrashHandler.setDumpViewTreeEnable(r16);
        if (r11.optInt("enable_dump_view_tree_native") != 1) goto L21;
        boolean r17 = true;
    L22:
        NativeCrashHandler.setDumpViewTreeEnable(r17);
        if (r11.optInt("enable_dump_view_tree_anr") != 1) goto L25;
        boolean r18 = true;
    L26:
        AnrDumper.setDumpViewTreeEnable(r18);
        parseDumpData(r11);
        r11.optInt("disable_looper_monitor");
        if (r11.optInt("enable_npth_looper_monitor") != 1) goto L29;
        boolean r19 = true;
    L31:
        if (r11.optInt("disable_dump_trace_try_catch") != 1) goto L33;
        boolean r20 = true;
    L34:
        if (r19 == false) goto L36;
        LooperMessageRecorder.getInstance().start();
    L36:
        parseAttributionConfig(r11);
        parseAnrConfig(r11);
        if (r11.optInt("SLI_exception") != 1) goto L39;
        boolean r21 = true;
    L40:
        sEnableSLIException = r21;
        if (r11.optInt("scene_exception") != 1) goto L43;
        boolean r22 = true;
    L44:
        sSceneException = r22;
        if (r11.optInt("enable_profiler_java_lock_monitor") != 1) goto L47;
        boolean r23 = true;
    L48:
        AnrProfiler.startJvmLockMonitor(r23);
        if (r11.optInt("disable_anr_profiler") == 1) goto L52;
        r12 = false;
    L52:
        if (r12 == true) goto L54;
        r12 = isSupportApiLevel(r11.optJSONArray(KEY_DISABLE_API_LEVEL_PROFILER));
    L54:
        writeAnrProfilerConfig(r12);
        if (r20 == false) goto L57;
        NativeBridge.setDumpTraceTryCatch(false);
    L57:
        CrashProtector.updateConfig(getProtectorObject(r10));
        return;
    L47:
        r23 = false;
        goto L48
    L43:
        r22 = false;
        goto L44
    L39:
        r21 = false;
        goto L40
    L33:
        r20 = false;
        goto L34
    L29:
        r19 = false;
        goto L31
    L25:
        r18 = false;
        goto L26
    L21:
        r17 = false;
        goto L22
    L17:
        r16 = false;
        goto L18
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    protected void parseAnrConfig(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.optInt(KEY_UPLOAD_BG_ANR);
        boolean r12 = true;
        if (r11 == 1) goto L8;
        r12 = false;
    L8:
        AnrManager.setUploadBackgroundANR(r12);
    }

    protected void parseAttributionConfig(JSONObject r10) {
        parseTerminateConfig(r10);
        parseSetPriorityMonitorConfig(r10);
        if (isSupportApiLevel(r10.optJSONArray(KEY_ENABLE_API_LEVEL)) == true) goto L5;
    L7:
        parseTombConfig(r10);
        parseRepairConfig(r10);
        parseCustomFile(r10);
        parseHprof(r10);
        parseNetDisaster(r10);
        parseUploadLimits(r10);
        UploadLimits.updateConfig(getUploadLimitConfig());
        return;
    L5:
        if (isSupportDeviceBrand(r10.optJSONArray(KEY_ENABLE_DEVICE_BRAND)) == false) goto L7;
        parseCoredumpConfig(r10);
        ResourceMonitor.updateConfig(r10, mFdTrackerSettings);
        goto L7
    }

    protected void parseCoredumpConfig(JSONObject r10) {
        boolean r11 = false;
        if (r10.optInt(KEY_ENABLE_COREDUMP) != 1) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        return;
    L8:
        if (r10.optInt(KEY_ENABLE_CORE_DUMP_UPLOAD) != 1) goto L10;
        boolean r13 = true;
    L12:
        if (r10.optInt(KEY_ENABLE_ASYNC_CORE_DUMP) != 1) goto L14;
        r11 = true;
    L14:
        this.coreDumpConfig = new CoreDumpConfig(r10.optJSONArray(KEY_CORE_DUMP_CONFIG), r12, r13, r11);
        CoredumpAdapter.updateConfig(getCoreDumpConfig());
        return;
    L10:
        r13 = false;
        goto L12
    L5:
        r12 = false;
        goto L6
    }

    protected void parseCustomFile(JSONObject r10) {
        if (r10.optInt("disable_crash_with_custom_files") != 1) goto L5;
        boolean r11 = true;
    L6:
        CustomFile.updateConfig(!r11, r10.optInt("crash_file_size_limit"));
        return;
    L5:
        r11 = false;
        goto L6
    }

    protected void parseHprof(JSONObject r10) {
        int r11 = r10.optInt("enable_hprof_all_java_crash");
        boolean r12 = true;
        if (r11 == 1) goto L6;
        r12 = false;
    L6:
        JavaCrashHandler.setHprofEnable(r12);
    }

    protected void parseNetDisaster(JSONObject r10) {
        int r11 = r10.optInt("disable_network_disaster");
        boolean r12 = true;
        if (r11 == 1) goto L6;
        r12 = false;
    L6:
        NetworkDisasterManager.setDisableNetDisaster(r12);
    }

    protected void parseRepairConfig(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = r10.optInt(KEY_REPAIR_TYPE);
        int r12 = r10.optInt(KEY_REPAIR_DELAYED_TIME);
        boolean r13 = true;
        if (r10.optInt(KEY_REPAIR_DEBUG) == 1) goto L8;
        r13 = false;
    L8:
        this.repairConfig = new RepairConfig(r11, r12, r13, r10.optJSONArray(KEY_REPAIR_PORTRAIT));
        RepairAdapter.updateConfig(getRepairConfig());
    }

    protected void parseTerminateConfig(JSONObject r10) {
        boolean r11 = false;
        if (r10.optInt(KEY_ENABLE_KILL_HISTORY) != 1) goto L5;
        boolean r12 = true;
    L7:
        if (r10.optInt(KEY_ENABLE_KILL_HISTORY_FG) != 1) goto L9;
        r11 = true;
    L9:
        if (r12 == true) goto L13;
        if (r11 == true) goto L13;
        if (UserDataCenter.isTerminateOpt() == true) goto L13;
        return;
    L13:
        TerminateMonitor.init();
        TerminateMonitor.setUploadFlag(r12, r11);
        TerminateMonitor.upload(MonitorManager.getAppMonitor());
        return;
    L5:
        r12 = false;
        goto L7
    }

    protected void parseTombConfig(JSONObject r10) {
        int r11 = r10.optInt("reg_memory_level");
        if (r11 != 0) goto L11;
        return;
    L11:
        File r12 = new File(Global.getConfigDir(), "tomb.config");     // Catch: Throwable -> L10
        if (r12.exists() == true) goto L8;
        r12.createNewFile();     // Catch: Throwable -> L10
    L8:
        FileUtils.writeFile(r12, "V001\n" + r11, false);     // Catch: Throwable -> L10
        return;
    }

    protected void parseUploadLimits(JSONObject r10) {
        NpthLog.i(LOG_TAG, "SimpleSettings:" + r10);
        this.uploadLimitConfig = new UploadLimitConfig(r10.optInt("crash_limit_issue"), r10.optInt("crash_limit_all"), r10.optInt("crash_limit_exception"), r10.optInt("crash_limit_exception_md5"), r10.optInt("crash_limit_exception_stack"));
    }

    protected void writeAnrProfilerConfig(boolean r10) {
        File r11 = new File(Global.getConfigDir(), "anr_profiler.config");
        FileUtils.writeFile(r11, String.valueOf(r10), false);     // Catch: Throwable -> L5
        return;
    }
}
