package com.bytedance.crash.coredump;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CoredumpAdapter {
    private static final String CORE_CONFIG_FILE = "core.config";
    public static final String CORE_DUMP_DELETE = "coredump_delete";
    public static final String HAVE_CORE_DUMP = "may_have_core_dump";
    private static final String LOG_TAG = "NPTH_COREDUMP";
    private static File mConfigFile = null;
    private static CoreDumpConfig mCoreConfig = null;
    private static String mCoreDeleteCause = "disable";
    private static File mCoreDir = null;
    private static final String mCoreLocalTestConfig = "1#all#all#null#lib#SIG#0#0#7#";
    private static String mCoredumpAsyncMode = null;
    private static String mCoredumpDone = null;
    private static String mCoredumpReturnCode = null;
    private static String mCoredumpSize = "0";
    private static String mCoredumpTime = null;
    private static String mCoredumpUUID = "none";
    private static boolean mIsInit = false;

    static {
    }

    public CoredumpAdapter() {
    }

    private static void appendMetric(JSONObject r2, Map<String, String> r3, String r4) {
        JSONUtils.append(r2, r4, getOrNone((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4));
    }

    private static void appendMetrics(JSONObject r4, Map<String, String> r5, String[] r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r6[r1];
        JSONUtils.append(r4, r2, getOrNone(r7, r2));
        r1 = r1 + 1;
        goto L3
    }

    private static boolean checkCoredumpEnable() {
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        mCoreDeleteCause = "config init exception";
        return false;
    L3:
        if (RuntimeConfig.isLocalTest() == false) goto L6;
        writeConfig(mCoreLocalTestConfig);     // Catch: Throwable -> L12
        return true;
    L6:
        CoreDumpConfig r0 = mCoreConfig;     // Catch: Throwable -> L12
        if (r0 == null) goto L14;
        if (r0.isEnable() == false) goto L14;
        writeConfig(mCoreConfig.getCoreDumpConfig());     // Catch: Throwable -> L12
        return true;
    }

    private static boolean checkCoredumpUpload(AppMonitor r5, File r6, JSONObject r7) {
    L23:
        th = move-exception;
        mCoreDeleteCause = "check coredump upload error";
        th.printStackTrace();
        NpthLog.w("corefile upload failed:" + th);
        NpthMonitor.reportInnerException(th);
    L25:
        return true;
    L4:
        if (mCoredumpSize == null) goto L22;
        if (r5 == null) goto L22;
        if (r6.exists() == false) goto L22;
        String[] r8 = r6.getAbsolutePath().split("/");     // Catch: Throwable -> L23
        mCoredumpUUID = r8[r8.length - 1];     // Catch: Throwable -> L23
        File r9 = new File(LogPathConfig.getNpthRootPath(), "asdawd/" + mCoredumpUUID);     // Catch: Throwable -> L23
        mCoreDir = r9;     // Catch: Throwable -> L23
        if (r9.exists() == true) goto L15;
        JSONUtils.append(r7, CORE_DUMP_DELETE, "core_dir_null");     // Catch: Throwable -> L23
        return false;
    L15:
        if (RuntimeConfig.isLocalTest() == false) goto L17;
        return true;
    L17:
        CoreDumpConfig r10 = mCoreConfig;     // Catch: Throwable -> L23
        if (r10 == null) goto L25;
        if (r10.isUploadEnable() == true) goto L25;
        mCoreDeleteCause = "config no init";     // Catch: Throwable -> L23
        JSONUtils.append(r7, CORE_DUMP_DELETE, "config no init");     // Catch: Throwable -> L23
        FileUtils.deleteFile(mCoreDir);     // Catch: Throwable -> L23
    L22:
        return false;
    }

    public static void deleteCoreDir() {
        File r0 = mCoreDir;
        if (r0 == null) goto L6;
        FileUtils.deleteFile(r0);
        return;
    }

    private static String getAllFramesCountRange(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L34
        if (r0 <= 5000) goto L7;
        return "(5000 - MAX)";
    L7:
        if (r0 <= WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS) goto L11;
        return "(4000 - 5000]";
    L11:
        if (r0 <= 3000) goto L15;
        return "(3000 - 4000]";
    L15:
        if (r0 <= 2000) goto L19;
        return "(2000 - 3000]";
    L19:
        if (r0 <= 1500) goto L23;
        return "(1500 - 2000]";
    L23:
        if (r0 <= 1000) goto L27;
        return "(1000 - 1500]";
    L27:
        if (r0 <= 500) goto L31;
        return "(500 - 1000]";
    L31:
        if (r0 <= 1) goto L38;
        return "(1 - 500]";
    L38:
        return r4;
    L34:
        return "none";
    }

    public static String getCoredumpMissReason() {
        return mCoreDeleteCause;
    }

    public static String getCoredumpUUID() {
        return mCoredumpUUID;
    }

    private static String getCrashFramesCountRange(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L50
        if (r0 <= 200) goto L7;
        return "(200 - MAX)";
    L7:
        if (r0 <= 150) goto L11;
        return "(150 - 200]";
    L11:
        if (r0 <= 100) goto L15;
        return "(100 - 150]";
    L15:
        if (r0 <= 70) goto L19;
        return "(70 - 100]";
    L19:
        if (r0 <= 50) goto L23;
        return "(50 - 70]";
    L23:
        if (r0 <= 40) goto L27;
        return "(40 - 50]";
    L27:
        if (r0 <= 30) goto L31;
        return "(30 - 40]";
    L31:
        if (r0 <= 20) goto L35;
        return "(20 - 30]";
    L35:
        if (r0 <= 15) goto L39;
        return "(15 - 20]";
    L39:
        if (r0 <= 10) goto L43;
        return "(10 - 15]";
    L43:
        if (r0 <= 5) goto L47;
        return "(5 - 10]";
    L47:
        if (r0 <= 1) goto L54;
        return "(1 - 5]";
    L54:
        return r4;
    L50:
        return "none";
    }

    public static File getDirectory(File r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String[] r5 = r4.getAbsolutePath().split("/");
        return new File(LogPathConfig.getNpthRootPath(), "asdawd/" + r5[r5.length - 1]);
    }

    public static String getDumpSize() {
        Long r0 = Long.valueOf(Long.parseLong(mCoredumpSize.trim()));     // Catch: Throwable -> L9
        if (r0.longValue() < 1048576) goto L6;
        Long r1 = Long.valueOf(r0.longValue() / 1048576);     // Catch: Throwable -> L9
        StringBuilder r2 = new StringBuilder().append(r1.toString());     // Catch: Throwable -> L9
        String r3 = "MB";
    L5:
        return r2.append(r3).toString();
    L6:
        r2 = new StringBuilder().append(r0.toString());     // Catch: Throwable -> L9
        r3 = "KB";
    L9:
        return "0";
    }

    public static String getDumpSizeRange() {
        long r0 = Long.parseLong(mCoredumpSize.trim());     // Catch: Throwable -> L36
        if (r0 >= 1048576) goto L6;
        return "size < 1MB";
    L6:
        long r1 = r0 / 1048576;     // Catch: Throwable -> L36
        if (r1 > 50) goto L11;
        return "1~50MB";
    L11:
        if (r1 > 100) goto L15;
        return "51~100MB";
    L15:
        if (r1 > 200) goto L19;
        return "101~200MB";
    L19:
        if (r1 > 300) goto L23;
        return "201~300MB";
    L23:
        if (r1 > 400) goto L27;
        return "301~400MB";
    L27:
        if (r1 > 500) goto L31;
        return "401~500MB";
    L31:
        if (r1 > 1000) goto L34;
        return "501MB~1GB";
    L34:
        return "size > 1GB";
    L36:
        return "0";
    }

    private static String getOrDefault(Map<String, String> r2, String r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        if (r6.isEmpty() == true) goto L9;
        return r6;
    L9:
        return r4;
    }

    private static String getOrNone(Map<String, String> r2, String r3) {
        return getOrDefault((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), r3, "none");
    }

    private static String getTimeRange(String r4) {
        long r0 = Long.parseLong(r4);     // Catch: Throwable -> L68
        if (r0 > 50) goto L7;
        return "0~50ms";
    L7:
        if (r0 > 100) goto L11;
        return "50~100ms";
    L11:
        if (r0 > 150) goto L15;
        return "100~150ms";
    L15:
        if (r0 > 200) goto L19;
        return "150~200ms";
    L19:
        if (r0 > 300) goto L23;
        return "200~300ms";
    L23:
        if (r0 > 400) goto L27;
        return "300~400ms";
    L27:
        if (r0 > 500) goto L31;
        return "400~500ms";
    L31:
        if (r0 > 700) goto L35;
        return "500~700ms";
    L35:
        if (r0 > 1000) goto L39;
        return "700~1000ms";
    L39:
        if (r0 > 1500) goto L43;
        return "1000~1500ms";
    L43:
        if (r0 > 2000) goto L47;
        return "1500~2000ms";
    L47:
        if (r0 > 3000) goto L51;
        return "2000~3000ms";
    L51:
        if (r0 > WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS) goto L55;
        return "3000~4000ms";
    L55:
        if (r0 > 5000) goto L59;
        return "4000~5000ms";
    L59:
        if (r0 > 7000) goto L63;
        return "5000~7000ms";
    L63:
        if (r0 > 10000) goto L66;
        return "7000~10000ms";
    L66:
        return "> 10000ms";
    L68:
        return "none";
    }

    public static void init() {
        if (mIsInit == false) goto L6;
        return;
    L6:
        if (checkCoredumpEnable() == false) goto L15;
        mIsInit = true;     // Catch: Exception -> L12
        File r0 = LogPathConfig.getCoreDumpPath();     // Catch: Exception -> L12
        if (r0.exists() == true) goto L10;
        r0.mkdirs();     // Catch: Exception -> L12
    L10:
        NativeBridge.coredumpNativeInit(new File(r0, CrashManager.getProcessDirectoryName()).toString());     // Catch: Exception -> L12
        NpthLog.i(LOG_TAG, "Coredump Init ok");     // Catch: Exception -> L12
        return;
    L15:
        return;
    }

    public static boolean isCoredumpExists() {
        if (mCoreDir != null) goto L5;
    L23:
        return false;
    L5:
        if ("0".equals(mCoredumpSize) == true) goto L23;
        File[] r0 = mCoreDir.listFiles();
        if (r0 != null) goto L10;
        return false;
    L10:
        int r2 = r0.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L23;
        File r4 = r0[r3];
        if (r4.getName().startsWith("core-") == false) goto L22;
        if (r4.length() <= 0) goto L22;
        if (Long.valueOf(Long.parseLong(mCoredumpSize.trim())).longValue() != r4.length()) goto L22;
        return true;
    L22:
        r3 = r3 + 1;
        goto L11
    }

    private static Map<String, String> readMetricsFromTombstone(File r7) {
        BufferedReader r0 = null;
        HashMap r1 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        File r2 = new File(r7, "tombstone.txt");
        if (r2.exists() == true) goto L8;
    L45:
        return null;
    L8:
        if (r2.length() == 0) goto L45;
        BufferedReader r8 = new BufferedReader(new FileReader(r2));     // Catch: Throwable -> L37
    L12:
        boolean r3 = false;
    L46:
        String r4 = r8.readLine();     // Catch: Throwable -> L35
        if (r4 == null) goto L34;
        if (r3 == false) goto L17;
        if (r4.startsWith("--- --- --- ") == true) goto L12;
        int r5 = r4.indexOf(58);     // Catch: Throwable -> L35
        if (r5 == (-1)) goto L46;
        String r6 = r4.substring(0, r5);     // Catch: Throwable -> L35
        String r9 = r4.substring(r5 + 1).trim();     // Catch: Throwable -> L35
        if (r6.isEmpty() == true) goto L46;
        if (r9.isEmpty() == true) goto L46;
        if (r1 != null) goto L32;
        r1 = new HashMap();     // Catch: Throwable -> L35
    L32:
        r1.put(r6, r9);     // Catch: Throwable -> L35
        goto L46
    L17:
        if (r4.equals("metrics:") == false) goto L46;
        r3 = true;
        goto L46
    L34:
        IoUtil.close(r8);
        return r1;
    L35:
        th = th;
        HashMap r10 = r1;
        r0 = r8;
        HashMap r11 = r10;
    L48:
        NpthLog.w("Failed to read metrics from tombstone." + th);     // Catch: Throwable -> L42
        IoUtil.close(r0);
        return r11;
    L42:
        th = move-exception;
        IoUtil.close(r0);
        throw th;
    L37:
        th = th;
        r11 = null;
        goto L48
    }

    public static void updateConfig(CoreDumpConfig r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        mCoreConfig = r1;
        NpthLog.i("NPTH_CORE", "updateConfig init");
        init();
    }

    public static boolean upload(AppMonitor r18, CrashSummary r19, File r20, JSONObject r21) {
        if (r19.getCrashType() == CrashType.NATIVE) goto L5;
        return false;
    L5:
        Map<String, String> r5 = readMetricsFromTombstone(r20);
        appendMetrics(r21, r5, new String[]{"unwind_return_code", "unwind_to_entrypoint", "unwind_last_name", "dumper_has_stack", "dumper_has_dex", "dump_crash_thread_done", "tombstone_done", "dumper_warning_code", "dumper_all_done", "has_protector"});
        JSONUtils.append(r21, "has_dumper_metrics", true);
        String r9 = getOrNone(r5, "crash_frames_count");
        JSONUtils.append(r21, "crash_frames_count", r9);
        JSONUtils.append(r21, "crash_frames_count_range", getCrashFramesCountRange(r9));
        String r10 = getOrNone(r5, "all_frames_count");
        JSONUtils.append(r21, "all_frames_count", r10);
        JSONUtils.append(r21, "all_frames_count_range", getAllFramesCountRange(r10));
        String r11 = getOrNone(r5, "tombstone_time");
        JSONUtils.append(r21, "tombstone_time", r11);
        JSONUtils.append(r21, "tombstone_time_range", getTimeRange(r11));
        String r12 = getOrNone(r5, "dumper_total_time");
        JSONUtils.append(r21, "dumper_total_time", r12);
        JSONUtils.append(r21, "dumper_total_time_range", getTimeRange(r12));
        String r13 = getOrNone(r5, "minidump_done");
        File r14 = new File(r20, "minidump");
        appendMetric(r21, r5, "minidump_enabled");
        JSONUtils.append(r21, "minidump_done", r13);
        JSONUtils.append(r21, "has_minidump", String.valueOf(r14.exists()));
        String r15 = getOrNone(r5, "minidump_time");
        JSONUtils.append(r21, "minidump_time", r15);
        JSONUtils.append(r21, "minidump_time_range", getTimeRange(r15));
        appendMetric(r21, r5, "coredump_enabled");
        mCoredumpSize = getOrDefault(r5, "coredump_size", "0");
        mCoredumpAsyncMode = getOrNone(r5, "coredump_async_mode");
        mCoredumpReturnCode = getOrNone(r5, "coredump_return_code");
        mCoredumpTime = getOrNone(r5, "coredump_time");
    L12:
        mCoredumpDone = "none";
    L14:
        if (checkCoredumpUpload(r18, r20, r21) == true) goto L21;
        if (r21.length() <= 0) goto L18;
        JSONUtils.append(r21, "coredump_miss", true);
    L18:
        JSONUtils.append(r21, HAVE_CORE_DUMP, "false");
        return false;
    L21:
        if (isCoredumpExists() == false) goto L69;
        File r16 = null;
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI.equals(LocaleInfo.getNetworkAccessType()) == true) goto L84;
        String r17 = CORE_DUMP_DELETE;
        String r22 = "coredump_miss";
        mCoreDeleteCause = "network is not wifi";     // Catch: Throwable -> L57
        boolean r7 = false;
    L80:
        String r1 = r17;
        JSONUtils.append(r21, r1, mCoreDeleteCause);     // Catch: Throwable -> L53
        if (r16 == null) goto L70;
    L52:
        FileUtils.deleteFile(r16);
    L70:
        if (r7 == false) goto L72;
    L75:
        return r7;
    L72:
        if (r21.length() <= 0) goto L74;
        JSONUtils.append(r21, r22, true);
    L74:
        JSONUtils.append(r21, HAVE_CORE_DUMP, "false");
    L53:
        th = th;
    L76:
        JSONUtils.append(r21, r1, "execption");     // Catch: Throwable -> L65
        th.printStackTrace();     // Catch: Throwable -> L65
        NpthLog.w("corefile upload failed:" + th);     // Catch: Throwable -> L65
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L65
        if (r16 == null) goto L70;
    L65:
        th = move-exception;
        if (r16 == null) goto L68;
        FileUtils.deleteFile(r16);
    L68:
        throw th;
    L55:
        th = th;
    L56:
        r1 = r17;
    L57:
        th = th;
    L58:
        r1 = r17;
    L61:
        r7 = false;
        goto L76
    L84:
        File r110 = new File(LogPathConfig.getNpthRootPath(), "asdawd/coredump.zip");     // Catch: Throwable -> L43
        FileUtils.zip(mCoreDir.getAbsolutePath(), r110.getAbsolutePath());     // Catch: Throwable -> L28
    L30:
        Header r0 = r19.assemblyCrashHeader(r18);     // Catch: Throwable -> L41
        String r2 = NetConfig.getCoreDumpUrl();     // Catch: Throwable -> L41
        String r3 = r0.getJson().toString();     // Catch: Throwable -> L41
        JSONObject r6 = new JSONObject().put(Constants.EVENT_TYPE, "raphael_file");     // Catch: Throwable -> L41
        r17 = CORE_DUMP_DELETE;
        r22 = "coredump_miss";
        boolean r4 = CrashUploader.uploadCoreFile("coredump", r2, r3, r6.put("timestamp", System.currentTimeMillis()).put(Api.KEY_UUID, mCoredumpUUID).toString(), r110);     // Catch: Throwable -> L39
        if (r4 == false) goto L35;
        mCoreDeleteCause = "corefile upload";     // Catch: Throwable -> L37
        JSONUtils.append(r21, HAVE_CORE_DUMP, true);     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_no_upload", "false");     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_real_size", getDumpSize());     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_size_range", getDumpSizeRange());     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_async_mode", mCoredumpAsyncMode);     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_return_code", mCoredumpReturnCode);     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_done", mCoredumpDone);     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_time", mCoredumpTime);     // Catch: Throwable -> L37
        JSONUtils.append(r21, "coredump_time_range", getTimeRange(mCoredumpTime));     // Catch: Throwable -> L37
        NpthLog.i("corefile upload");     // Catch: Throwable -> L37
    L36:
        r7 = r4;
        r16 = r110;
        goto L80
    L35:
        mCoreDeleteCause = "corefile upload exception";     // Catch: Throwable -> L37
    L37:
        th = th;
        r7 = r4;
        r16 = r110;
    L39:
        th = th;
        r16 = r110;
        goto L58
    L41:
        th = th;
        r22 = "coredump_miss";
        r1 = CORE_DUMP_DELETE;
        r16 = r110;
    L28:
        th = move-exception;
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L41
    L43:
        th = th;
        r22 = "coredump_miss";
        r1 = CORE_DUMP_DELETE;
    L59:
        th = th;
        r1 = CORE_DUMP_DELETE;
        r22 = "coredump_miss";
        goto L61
    L69:
        r22 = "coredump_miss";
        r7 = false;
        goto L70
    L7:
        if (Long.parseLong(mCoredumpReturnCode) != 0) goto L9;
        boolean r8 = true;
    L10:
        mCoredumpDone = String.valueOf(r8);     // Catch: Throwable -> L12
        goto L14
    L9:
        r8 = false;
        goto L10
    }

    private static void writeConfig(String r3) {
        if (r3 != null) goto L14;
        return;
    L14:
        File r0 = new File(Global.getConfigDir(), CORE_CONFIG_FILE);     // Catch: Throwable -> L11
        mConfigFile = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L7;
    L9:
        NpthLog.i(LOG_TAG, "Core Init enable");     // Catch: Throwable -> L11
        FileUtils.writeFile(mConfigFile, r3, false);     // Catch: Throwable -> L11
        return;
    L7:
        if (r0.exists() == true) goto L9;
        mConfigFile.createNewFile();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public String getCoreDeleteCause() {
        return mCoreDeleteCause;
    }
}
