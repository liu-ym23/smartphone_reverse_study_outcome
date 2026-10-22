package com.bytedance.crash.monitor;

import android.content.Context;
import android.os.Build;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

    public AppMonitorConfigService(CrashListener r1) {
        super(r1);
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

    private static JSONObject getFdTrackObject(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject("custom_event_settings");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject(NPTH_FD_TRACKER_SETTING);
    }

    public static JSONArray getGwpAsanConfig() {
        return mGwpAsanSettings;
    }

    private static JSONObject getNpthSimpleObject(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject("custom_event_settings");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject(EventConfigService.NPTH_SIMPLE_SETTING);
    }

    private static JSONObject getProtectorObject(JSONObject r1) {
        JSONObject r2 = r1.optJSONObject(EventConfigService.EXCEPTION_MODULE);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.optJSONObject("protector");
    }

    public static boolean isSupportApiLevel(JSONArray r5) {
        if (r5 != null) goto L23;
        return false;
    L23:
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        return false;
    L6:
        if (r5.toString().contains("none") == false) goto L9;
        return false;
    L9:
        if (r5.toString().contains(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L12;
        return true;
    L12:
        if (r5.length() <= 0) goto L22;
        int r1 = 0;
    L15:
        if (r1 >= r5.length()) goto L22;
        if (Build.VERSION.SDK_INT == Integer.parseInt(r5.optString(r1))) goto L18;
        r1 = r1 + 1;
        goto L15
    L18:
        return true;
    }

    public static boolean isSupportDeviceBrand(JSONArray r5) {
        if (r5 != null) goto L28;
        return false;
    L28:
    L25:
        th = move-exception;
        th.printStackTrace();
    L27:
        return false;
    L6:
        if (r5.toString().contains("none") == false) goto L8;
    L24:
        return false;
    L8:
        if (Build.BRAND.isEmpty() == true) goto L24;
        if (Build.BRAND.contains("ubia") == true) goto L24;
        if (r5.toString().contains(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L16;
        return true;
    L16:
        if (r5.length() <= 0) goto L27;
        int r1 = 0;
    L19:
        if (r1 >= r5.length()) goto L27;
        if (Build.BRAND.equals(r5.optString(r1)) == true) goto L22;
        r1 = r1 + 1;
        goto L19
    L22:
        return true;
    }

    private void parseBizException(JSONObject r8) {
        JSONObject r7 = r8.optJSONObject(EventConfigService.EXCEPTION_MODULE);
        if (r7 != null) goto L5;
        return;
    L5:
        JSONObject r9 = r7.optJSONObject("biz_exception");
        if (r9 != null) goto L8;
        return;
    L8:
        boolean r0 = false;
        int r10 = r9.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0);
        HashSet r1 = new HashSet();
        JSONObject r11 = r9.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        if (r11 == null) goto L16;
        Iterator<String> r3 = r11.keys();
    L12:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r11.optInt(r4) != 1) goto L12;
        r1.add(r4);
    L16:
        BizExceptionManager r12 = BizExceptionManager.getInstance();
        if (r10 != 1) goto L19;
        r0 = true;
    L19:
        r12.setConfig(new BizExceptionConfig(r0, r1));
    }

    private static void parseDumpData(JSONObject r3) {
        if (r3 == null) goto L24;
        boolean r1 = false;
        if (r3.optInt("enable_anrinfo_report") != 1) goto L6;
        boolean r0 = true;
    L7:
        sDumpAnrInfoEnable = r0;
        if (r3.optInt("enable_user_custom_data") != 1) goto L10;
        boolean r2 = true;
    L11:
        sDumpCustomDataEnable = r2;
        if (r3.optInt("enable_logcat_report") != 1) goto L14;
        boolean r4 = true;
    L15:
        sDumpLogcatEnable = r4;
        if (r3.optInt("enable_native_info") != 1) goto L18;
        boolean r5 = true;
    L19:
        sDumpNativeInfoEnable = r5;
        if (r3.optInt("enable_dump_message") != 1) goto L22;
        r1 = true;
    L22:
        sDumpMessageEnable = r1;
        return;
    L18:
        r5 = false;
        goto L19
    L14:
        r4 = false;
        goto L15
    L10:
        r2 = false;
        goto L11
    L6:
        r0 = false;
        goto L7
    }

    public static void parseSetPriorityMonitorConfig(JSONObject r4) {
        if (r4.optInt("enable_setpriority_monitor") != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L16;
        JSONArray r5 = r4.optJSONArray("setpriority_params");     // Catch: Throwable -> L13
        NativeBridge.priorityMonitorInit(FileSystemUtils.createDirectory(LogPathConfig.getPrioMonitorPath(), CrashManager.getProcessDirectoryName()).toString());     // Catch: Throwable -> L13
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.length() <= 0) goto L18;
        NativeBridge.setPriorityParams(r5.optBoolean(0), r5.optBoolean(1), r5.optInt(2));     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L16:
        return;
    L5:
        r0 = false;
    }

    private void parseUploadDomain(JSONObject r4) {
        if (sIsUseLocalDomain == true) goto L6;
        AllDefaultUrls.setDomainName(JSONUtils.getStringFromParent(r4, new String[]{"custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain"}), JSONUtils.getArrayFromParent(r4, new String[]{"custom_event_settings", EventConfigService.NPTH_SIMPLE_SETTING, "crash_upload_domain_list"}));
        return;
    }

    public static void setUseLocalDomain(boolean r0) {
        sIsUseLocalDomain = r0;
    }

    private static boolean tlsMonitorLoadLibrary() {
        NpthLog.i(LOG_TAG, "loadLibrary...");
        if (sSoLoaded == false) goto L7;
    L5:
        return true;
    L7:
        a.a("npth_tls_monitor", (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
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
    public void onConfigChanged(JSONObject r6) {
        super.onConfigChanged(r6);
        JSONObject r0 = getNpthSimpleObject(r6);
        mFdTrackerSettings = getFdTrackObject(r6);
        mGwpAsanSettings = r0.optJSONArray(KEY_GWP_ASAN_CONFIG);
        parseUploadDomain(r6);
        parseBizException(r6);
        if (r0 == null) goto L59;
        boolean r3 = true;
        if (r0.optInt("enable_upload_custom_java_crash") != 1) goto L7;
        boolean r1 = true;
    L8:
        Ensure.setUploadCustomJavaCrashEnable(r1);
        if (r0.optInt("enable_dump_history_message_java") != 1) goto L11;
        boolean r2 = true;
    L12:
        JavaCrashHandler.setDumpHistoryMessageEnable(r2);
        if (r0.optInt("enable_dump_history_message_native") != 1) goto L15;
        boolean r4 = true;
    L16:
        NativeCrashHandler.setDumpHistoryMessageEnable(r4);
        if (r0.optInt("enable_dump_view_tree_java") != 1) goto L19;
        boolean r5 = true;
    L20:
        JavaCrashHandler.setDumpViewTreeEnable(r5);
        if (r0.optInt("enable_dump_view_tree_native") != 1) goto L23;
        boolean r7 = true;
    L24:
        NativeCrashHandler.setDumpViewTreeEnable(r7);
        if (r0.optInt("enable_dump_view_tree_anr") != 1) goto L27;
        boolean r8 = true;
    L28:
        AnrDumper.setDumpViewTreeEnable(r8);
        parseDumpData(r0);
        r0.optInt("disable_looper_monitor");
        if (r0.optInt("enable_npth_looper_monitor") != 1) goto L31;
        boolean r9 = true;
    L33:
        if (r0.optInt("disable_dump_trace_try_catch") != 1) goto L35;
        boolean r10 = true;
    L36:
        if (r9 == false) goto L38;
        LooperMessageRecorder.getInstance().start();
    L38:
        parseAttributionConfig(r0);
        parseAnrConfig(r0);
        if (r0.optInt("SLI_exception") != 1) goto L41;
        boolean r11 = true;
    L42:
        sEnableSLIException = r11;
        if (r0.optInt("scene_exception") != 1) goto L45;
        boolean r12 = true;
    L46:
        sSceneException = r12;
        if (r0.optInt("enable_profiler_java_lock_monitor") != 1) goto L49;
        boolean r13 = true;
    L50:
        AnrProfiler.startJvmLockMonitor(r13);
        if (r0.optInt("disable_anr_profiler") == 1) goto L54;
        r3 = false;
    L54:
        if (r3 == true) goto L56;
        r3 = isSupportApiLevel(r0.optJSONArray(KEY_DISABLE_API_LEVEL_PROFILER));
    L56:
        writeAnrProfilerConfig(r3);
        if (r10 == false) goto L59;
        NativeBridge.setDumpTraceTryCatch(false);
        goto L59
    L49:
        r13 = false;
        goto L50
    L45:
        r12 = false;
        goto L46
    L41:
        r11 = false;
        goto L42
    L35:
        r10 = false;
        goto L36
    L31:
        r9 = false;
        goto L33
    L27:
        r8 = false;
        goto L28
    L23:
        r7 = false;
        goto L24
    L19:
        r5 = false;
        goto L20
    L15:
        r4 = false;
        goto L16
    L11:
        r2 = false;
        goto L12
    L7:
        r1 = false;
    L59:
        CrashProtector.updateConfig(getProtectorObject(r6));
    }

    public void parseAnrConfig(JSONObject r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        int r0 = r1.optInt(KEY_UPLOAD_BG_ANR);
        boolean r2 = true;
        if (r0 == 1) goto L8;
        r2 = false;
    L8:
        AnrManager.setUploadBackgroundANR(r2);
    }

    public void parseAttributionConfig(JSONObject r2) {
        parseTerminateConfig(r2);
        parseSetPriorityMonitorConfig(r2);
        if (isSupportApiLevel(r2.optJSONArray(KEY_ENABLE_API_LEVEL)) == true) goto L5;
    L7:
        parseTombConfig(r2);
        parseRepairConfig(r2);
        parseCustomFile(r2);
        parseHprof(r2);
        parseNetDisaster(r2);
        parseUploadLimits(r2);
        UploadLimits.updateConfig(getUploadLimitConfig());
        return;
    L5:
        if (isSupportDeviceBrand(r2.optJSONArray(KEY_ENABLE_DEVICE_BRAND)) == false) goto L7;
        parseCoredumpConfig(r2);
        ResourceMonitor.updateConfig(r2, mFdTrackerSettings);
        goto L7
    }

    public void parseCoredumpConfig(JSONObject r6) {
        boolean r1 = false;
        if (r6.optInt(KEY_ENABLE_COREDUMP) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (r6.optInt(KEY_ENABLE_CORE_DUMP_UPLOAD) != 1) goto L10;
        boolean r3 = true;
    L12:
        if (r6.optInt(KEY_ENABLE_ASYNC_CORE_DUMP) != 1) goto L14;
        r1 = true;
    L14:
        this.coreDumpConfig = new CoreDumpConfig(r6.optJSONArray(KEY_CORE_DUMP_CONFIG), r0, r3, r1);
        CoredumpAdapter.updateConfig(getCoreDumpConfig());
        return;
    L10:
        r3 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public void parseCustomFile(JSONObject r3) {
        if (r3.optInt("disable_crash_with_custom_files") != 1) goto L5;
        boolean r2 = true;
    L6:
        CustomFile.updateConfig(!r2, r3.optInt("crash_file_size_limit"));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void parseHprof(JSONObject r1) {
        int r0 = r1.optInt("enable_hprof_all_java_crash");
        boolean r2 = true;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        JavaCrashHandler.setHprofEnable(r2);
    }

    public void parseNetDisaster(JSONObject r1) {
        int r0 = r1.optInt("disable_network_disaster");
        boolean r2 = true;
        if (r0 == 1) goto L6;
        r2 = false;
    L6:
        NetworkDisasterManager.setDisableNetDisaster(r2);
    }

    public void parseRepairConfig(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.optInt(KEY_REPAIR_TYPE);
        int r1 = r5.optInt(KEY_REPAIR_DELAYED_TIME);
        boolean r3 = true;
        if (r5.optInt(KEY_REPAIR_DEBUG) == 1) goto L8;
        r3 = false;
    L8:
        this.repairConfig = new RepairConfig(r0, r1, r3, r5.optJSONArray(KEY_REPAIR_PORTRAIT));
        RepairAdapter.updateConfig(getRepairConfig());
    }

    public void parseTerminateConfig(JSONObject r4) {
        boolean r0 = false;
        if (r4.optInt(KEY_ENABLE_KILL_HISTORY) != 1) goto L5;
        boolean r3 = true;
    L7:
        if (r4.optInt(KEY_ENABLE_KILL_HISTORY_FG) != 1) goto L9;
        r0 = true;
    L9:
        if (r3 == true) goto L13;
        if (r0 == true) goto L13;
        if (UserDataCenter.isTerminateOpt() == true) goto L13;
        return;
    L13:
        TerminateMonitor.init();
        TerminateMonitor.setUploadFlag(r3, r0);
        TerminateMonitor.upload(MonitorManager.getAppMonitor());
        return;
    L5:
        r3 = false;
        goto L7
    }

    public void parseTombConfig(JSONObject r3) {
        int r2 = r3.optInt("reg_memory_level");
        if (r2 != 0) goto L11;
        return;
    L11:
        File r4 = new File(Global.getConfigDir(), "tomb.config");     // Catch: Throwable -> L10
        if (r4.exists() == true) goto L8;
        r4.createNewFile();     // Catch: Throwable -> L10
    L8:
        FileUtils.writeFile(r4, "V001\n" + r2, false);     // Catch: Throwable -> L10
        return;
    }

    public void parseUploadLimits(JSONObject r9) {
        NpthLog.i(LOG_TAG, "SimpleSettings:" + r9);
        this.uploadLimitConfig = new UploadLimitConfig(r9.optInt("crash_limit_issue"), r9.optInt("crash_limit_all"), r9.optInt("crash_limit_exception"), r9.optInt("crash_limit_exception_md5"), r9.optInt("crash_limit_exception_stack"));
    }

    public void writeAnrProfilerConfig(boolean r3) {
        File r2 = new File(Global.getConfigDir(), "anr_profiler.config");
        FileUtils.writeFile(r2, String.valueOf(r3), false);     // Catch: Throwable -> L5
        return;
    }
}
