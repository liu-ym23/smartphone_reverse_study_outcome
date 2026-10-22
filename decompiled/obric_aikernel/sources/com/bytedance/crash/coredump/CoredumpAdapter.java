package com.bytedance.crash.coredump;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsConstants;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    private static void appendMetric(JSONObject r10, Map<String, String> r11, String r12) {
        JSONUtils.append(r10, r12, getOrNone(r11, r12));
    }

    private static void appendMetrics(JSONObject r10, Map<String, String> r11, String[] r12) {
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        String r15 = r12[r14];
        JSONUtils.append(r10, r15, getOrNone(r11, r15));
        r14 = r14 + 1;
        goto L3
    }

    @Nullable
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
        CoreDumpConfig r10 = mCoreConfig;     // Catch: Throwable -> L12
        if (r10 == null) goto L14;
        if (r10.isEnable() == false) goto L14;
        writeConfig(mCoreConfig.getCoreDumpConfig());     // Catch: Throwable -> L12
        return true;
    }

    private static boolean checkCoredumpUpload(AppMonitor r10, File r11, JSONObject r12) {
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
        if (r10 == null) goto L22;
        if (r11.exists() == false) goto L22;
        String[] r13 = r11.getAbsolutePath().split("/");     // Catch: Throwable -> L23
        mCoredumpUUID = r13[r13.length - 1];     // Catch: Throwable -> L23
        File r14 = new File(LogPathConfig.getNpthRootPath(), "asdawd/" + mCoredumpUUID);     // Catch: Throwable -> L23
        mCoreDir = r14;     // Catch: Throwable -> L23
        if (r14.exists() == true) goto L15;
        JSONUtils.append(r12, CORE_DUMP_DELETE, "core_dir_null");     // Catch: Throwable -> L23
        return false;
    L15:
        if (RuntimeConfig.isLocalTest() == false) goto L17;
        return true;
    L17:
        CoreDumpConfig r15 = mCoreConfig;     // Catch: Throwable -> L23
        if (r15 == null) goto L25;
        if (r15.isUploadEnable() == true) goto L25;
        mCoreDeleteCause = "config no init";     // Catch: Throwable -> L23
        JSONUtils.append(r12, CORE_DUMP_DELETE, "config no init");     // Catch: Throwable -> L23
        FileUtils.deleteFile(mCoreDir);     // Catch: Throwable -> L23
    L22:
        return false;
    }

    public static void deleteCoreDir() {
        File r10 = mCoreDir;
        if (r10 == null) goto L6;
        FileUtils.deleteFile(r10);
        return;
    }

    private static String getAllFramesCountRange(String r10) {
        long r11 = Long.parseLong(r10);     // Catch: Throwable -> L34
        if (r11 <= 5000) goto L7;
        return "(5000 - MAX)";
    L7:
        if (r11 <= 4000) goto L11;
        return "(4000 - 5000]";
    L11:
        if (r11 <= WsConstants.EXIT_DELAY_TIME) goto L15;
        return "(3000 - 4000]";
    L15:
        if (r11 <= 2000) goto L19;
        return "(2000 - 3000]";
    L19:
        if (r11 <= 1500) goto L23;
        return "(1500 - 2000]";
    L23:
        if (r11 <= 1000) goto L27;
        return "(1000 - 1500]";
    L27:
        if (r11 <= 500) goto L31;
        return "(500 - 1000]";
    L31:
        if (r11 <= 1) goto L38;
        return "(1 - 500]";
    L38:
        return r10;
    L34:
        return "none";
    }

    public static String getCoredumpMissReason() {
        return mCoreDeleteCause;
    }

    public static String getCoredumpUUID() {
        return mCoredumpUUID;
    }

    private static String getCrashFramesCountRange(String r10) {
        long r11 = Long.parseLong(r10);     // Catch: Throwable -> L50
        if (r11 <= 200) goto L7;
        return "(200 - MAX)";
    L7:
        if (r11 <= 150) goto L11;
        return "(150 - 200]";
    L11:
        if (r11 <= 100) goto L15;
        return "(100 - 150]";
    L15:
        if (r11 <= 70) goto L19;
        return "(70 - 100]";
    L19:
        if (r11 <= 50) goto L23;
        return "(50 - 70]";
    L23:
        if (r11 <= 40) goto L27;
        return "(40 - 50]";
    L27:
        if (r11 <= 30) goto L31;
        return "(30 - 40]";
    L31:
        if (r11 <= 20) goto L35;
        return "(20 - 30]";
    L35:
        if (r11 <= 15) goto L39;
        return "(15 - 20]";
    L39:
        if (r11 <= 10) goto L43;
        return "(10 - 15]";
    L43:
        if (r11 <= 5) goto L47;
        return "(5 - 10]";
    L47:
        if (r11 <= 1) goto L54;
        return "(1 - 5]";
    L54:
        return r10;
    L50:
        return "none";
    }

    public static File getDirectory(File r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r11 = r10.getAbsolutePath().split("/");
        String r12 = r11[r11.length - 1];
        return new File(LogPathConfig.getNpthRootPath(), "asdawd/" + r12);
    }

    public static String getDumpSize() {
        Long r10 = Long.valueOf(Long.parseLong(mCoredumpSize.trim()));     // Catch: Throwable -> L9
        if (r10.longValue() < 1048576) goto L6;
        Long r11 = Long.valueOf(r10.longValue() / 1048576);     // Catch: Throwable -> L9
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L9
        r12.append(r11.toString());     // Catch: Throwable -> L9
        String r13 = "MB";
    L5:
        r12.append(r13);     // Catch: Throwable -> L9
        return r12.toString();
    L6:
        r12 = new StringBuilder();     // Catch: Throwable -> L9
        r12.append(r10.toString());     // Catch: Throwable -> L9
        r13 = "KB";
    L9:
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    }

    public static String getDumpSizeRange() {
        long r10 = Long.parseLong(mCoredumpSize.trim());     // Catch: Throwable -> L36
        if (r10 >= 1048576) goto L6;
        return "size < 1MB";
    L6:
        long r11 = r10 / 1048576;     // Catch: Throwable -> L36
        if (r11 > 50) goto L11;
        return "1~50MB";
    L11:
        if (r11 > 100) goto L15;
        return "51~100MB";
    L15:
        if (r11 > 200) goto L19;
        return "101~200MB";
    L19:
        if (r11 > 300) goto L23;
        return "201~300MB";
    L23:
        if (r11 > 400) goto L27;
        return "301~400MB";
    L27:
        if (r11 > 500) goto L31;
        return "401~500MB";
    L31:
        if (r11 > 1000) goto L34;
        return "501MB~1GB";
    L34:
        return "size > 1GB";
    L36:
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    }

    private static String getOrDefault(Map<String, String> r10, String r11, String r12) {
        if (r10 == null) goto L8;
        String r13 = r10.get(r11);
        if (r13 == null) goto L8;
        if (r13.isEmpty() == true) goto L8;
        return r13;
    L8:
        return r12;
    }

    private static String getOrNone(Map<String, String> r10, String r11) {
        return getOrDefault(r10, r11, "none");
    }

    private static String getTimeRange(String r10) {
        long r11 = Long.parseLong(r10);     // Catch: Throwable -> L68
        if (r11 > 50) goto L7;
        return "0~50ms";
    L7:
        if (r11 > 100) goto L11;
        return "50~100ms";
    L11:
        if (r11 > 150) goto L15;
        return "100~150ms";
    L15:
        if (r11 > 200) goto L19;
        return "150~200ms";
    L19:
        if (r11 > 300) goto L23;
        return "200~300ms";
    L23:
        if (r11 > 400) goto L27;
        return "300~400ms";
    L27:
        if (r11 > 500) goto L31;
        return "400~500ms";
    L31:
        if (r11 > 700) goto L35;
        return "500~700ms";
    L35:
        if (r11 > 1000) goto L39;
        return "700~1000ms";
    L39:
        if (r11 > 1500) goto L43;
        return "1000~1500ms";
    L43:
        if (r11 > 2000) goto L47;
        return "1500~2000ms";
    L47:
        if (r11 > WsConstants.EXIT_DELAY_TIME) goto L51;
        return "2000~3000ms";
    L51:
        if (r11 > 4000) goto L55;
        return "3000~4000ms";
    L55:
        if (r11 > 5000) goto L59;
        return "4000~5000ms";
    L59:
        if (r11 > 7000) goto L63;
        return "5000~7000ms";
    L63:
        if (r11 > WorkRequest.MIN_BACKOFF_MILLIS) goto L66;
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
        File r10 = LogPathConfig.getCoreDumpPath();     // Catch: Exception -> L12
        if (r10.exists() == true) goto L10;
        r10.mkdirs();     // Catch: Exception -> L12
    L10:
        NativeBridge.coredumpNativeInit(new File(r10, CrashManager.getProcessDirectoryName()).toString());     // Catch: Exception -> L12
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
        if (NetConst.NOT_ENCRYPT_VERISON_CODE.equals(mCoredumpSize) == true) goto L23;
        File[] r10 = mCoreDir.listFiles();
        if (r10 != null) goto L10;
        return false;
    L10:
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L23;
        File r13 = r10[r12];
        if (r13.getName().startsWith("core-") == false) goto L22;
        if (r13.length() <= 0) goto L22;
        if (Long.valueOf(Long.parseLong(mCoredumpSize.trim())).longValue() != r13.length()) goto L22;
        return true;
    L22:
        r12 = r12 + 1;
        goto L11
    }

    private static Map<String, String> readMetricsFromTombstone(File r10) {
        BufferedReader r11 = null;
        HashMap r12 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        File r13 = new File(r10, "tombstone.txt");
        if (r13.exists() == true) goto L8;
    L45:
        return null;
    L8:
        if (r13.length() == 0) goto L45;
        BufferedReader r14 = new BufferedReader(new FileReader(r13));     // Catch: Throwable -> L37
    L12:
        boolean r15 = false;
    L48:
        String r16 = r14.readLine();     // Catch: Throwable -> L35
        if (r16 == null) goto L34;
        if (r15 == false) goto L17;
        if (r16.startsWith("--- --- --- ") == true) goto L12;
        int r17 = r16.indexOf(58);     // Catch: Throwable -> L35
        if (r17 == (-1)) goto L48;
        String r18 = r16.substring(0, r17);     // Catch: Throwable -> L35
        String r19 = r16.substring(r17 + 1).trim();     // Catch: Throwable -> L35
        if (r18.isEmpty() == true) goto L48;
        if (r19.isEmpty() == true) goto L48;
        if (r12 != null) goto L32;
        r12 = new HashMap();     // Catch: Throwable -> L35
    L32:
        r12.put(r18, r19);     // Catch: Throwable -> L35
        goto L48
    L17:
        if (r16.equals("metrics:") == false) goto L48;
        r15 = true;
        goto L48
    L34:
        IoUtil.close(r14);
        return r12;
    L35:
        th = th;
        HashMap r20 = r12;
        r11 = r14;
        HashMap r21 = r20;
    L46:
        NpthLog.w("Failed to read metrics from tombstone." + th);     // Catch: Throwable -> L42
        IoUtil.close(r11);
        return r21;
    L42:
        th = move-exception;
        IoUtil.close(r11);
        throw th;
    L37:
        th = th;
        r21 = null;
        goto L46
    }

    public static void updateConfig(CoreDumpConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        mCoreConfig = r10;
        NpthLog.i("NPTH_CORE", "updateConfig init");
        init();
    }

    public static boolean upload(AppMonitor r18, CrashSummary r19, File r20, JSONObject r21) {
        if (r19.getCrashType() == CrashType.NATIVE) goto L5;
        return false;
    L5:
        Map<String, String> r10 = readMetricsFromTombstone(r20);
        appendMetrics(r21, r10, new String[]{"unwind_return_code", "unwind_to_entrypoint", "unwind_last_name", "dumper_has_stack", "dumper_has_dex", "dump_crash_thread_done", "tombstone_done", "dumper_warning_code", "dumper_all_done", "has_protector"});
        JSONUtils.append(r21, "has_dumper_metrics", Boolean.TRUE);
        String r11 = getOrNone(r10, "crash_frames_count");
        JSONUtils.append(r21, "crash_frames_count", r11);
        JSONUtils.append(r21, "crash_frames_count_range", getCrashFramesCountRange(r11));
        String r12 = getOrNone(r10, "all_frames_count");
        JSONUtils.append(r21, "all_frames_count", r12);
        JSONUtils.append(r21, "all_frames_count_range", getAllFramesCountRange(r12));
        String r13 = getOrNone(r10, "tombstone_time");
        JSONUtils.append(r21, "tombstone_time", r13);
        JSONUtils.append(r21, "tombstone_time_range", getTimeRange(r13));
        String r14 = getOrNone(r10, "dumper_total_time");
        JSONUtils.append(r21, "dumper_total_time", r14);
        JSONUtils.append(r21, "dumper_total_time_range", getTimeRange(r14));
        String r15 = getOrNone(r10, "minidump_done");
        File r16 = new File(r20, "minidump");
        appendMetric(r21, r10, "minidump_enabled");
        JSONUtils.append(r21, "minidump_done", r15);
        JSONUtils.append(r21, "has_minidump", String.valueOf(r16.exists()));
        String r17 = getOrNone(r10, "minidump_time");
        JSONUtils.append(r21, "minidump_time", r17);
        JSONUtils.append(r21, "minidump_time_range", getTimeRange(r17));
        appendMetric(r21, r10, "coredump_enabled");
        mCoredumpSize = getOrDefault(r10, "coredump_size", NetConst.NOT_ENCRYPT_VERISON_CODE);
        mCoredumpAsyncMode = getOrNone(r10, "coredump_async_mode");
        mCoredumpReturnCode = getOrNone(r10, "coredump_return_code");
        mCoredumpTime = getOrNone(r10, "coredump_time");
    L12:
        mCoredumpDone = "none";
    L14:
        if (checkCoredumpUpload(r18, r20, r21) == true) goto L21;
        if (r21.length() <= 0) goto L18;
        JSONUtils.append(r21, "coredump_miss", Boolean.TRUE);
    L18:
        JSONUtils.append(r21, HAVE_CORE_DUMP, "false");
        return false;
    L21:
        if (isCoredumpExists() == false) goto L69;
        File r110 = null;
        if ("wifi".equals(LocaleInfo.getNetworkAccessType()) == true) goto L90;
        String r111 = CORE_DUMP_DELETE;
        String r22 = "coredump_miss";
        mCoreDeleteCause = "network is not wifi";     // Catch: Throwable -> L57
        boolean r23 = false;
    L86:
        String r24 = r111;
        JSONUtils.append(r21, r24, mCoreDeleteCause);     // Catch: Throwable -> L53
        if (r110 == null) goto L70;
    L52:
        FileUtils.deleteFile(r110);
    L70:
        if (r23 == false) goto L72;
    L75:
        return r23;
    L72:
        if (r21.length() <= 0) goto L74;
        JSONUtils.append(r21, r22, Boolean.TRUE);
    L74:
        JSONUtils.append(r21, HAVE_CORE_DUMP, "false");
    L53:
        th = th;
    L78:
        JSONUtils.append(r21, r24, "execption");     // Catch: Throwable -> L65
        th.printStackTrace();     // Catch: Throwable -> L65
        NpthLog.w("corefile upload failed:" + th);     // Catch: Throwable -> L65
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L65
        if (r110 == null) goto L70;
    L65:
        th = move-exception;
        if (r110 == null) goto L68;
        FileUtils.deleteFile(r110);
    L68:
        throw th;
    L55:
        th = th;
    L56:
        r24 = r111;
    L57:
        th = th;
    L58:
        r24 = r111;
    L61:
        r23 = false;
        goto L78
    L90:
        File r112 = new File(LogPathConfig.getNpthRootPath(), "asdawd/coredump.zip");     // Catch: Throwable -> L43
        FileUtils.zip(mCoreDir.getAbsolutePath(), r112.getAbsolutePath());     // Catch: Throwable -> L28
    L30:
        Header r25 = r19.assemblyCrashHeader(r18);     // Catch: Throwable -> L41
        String r26 = NetConfig.getCoreDumpUrl();     // Catch: Throwable -> L41
        String r27 = r25.getJson().toString();     // Catch: Throwable -> L41
        JSONObject r28 = new JSONObject().put(Constants.EVENT_TYPE, "raphael_file");     // Catch: Throwable -> L41
        r111 = CORE_DUMP_DELETE;
        r22 = "coredump_miss";
        boolean r29 = CrashUploader.uploadCoreFile("coredump", r26, r27, r28.put("timestamp", System.currentTimeMillis()).put(Api.KEY_UUID, mCoredumpUUID).toString(), r112);     // Catch: Throwable -> L39
        if (r29 == false) goto L35;
        mCoreDeleteCause = "corefile upload";     // Catch: Throwable -> L37
        JSONUtils.append(r21, HAVE_CORE_DUMP, Boolean.TRUE);     // Catch: Throwable -> L37
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
        r23 = r29;
        r110 = r112;
        goto L86
    L35:
        mCoreDeleteCause = "corefile upload exception";     // Catch: Throwable -> L37
    L37:
        th = th;
        r23 = r29;
        r110 = r112;
    L39:
        th = th;
        r110 = r112;
        goto L58
    L41:
        th = th;
        r22 = "coredump_miss";
        r24 = CORE_DUMP_DELETE;
        r110 = r112;
    L28:
        th = move-exception;
        NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L41
    L43:
        th = th;
        r22 = "coredump_miss";
        r24 = CORE_DUMP_DELETE;
    L59:
        th = th;
        r24 = CORE_DUMP_DELETE;
        r22 = "coredump_miss";
        goto L61
    L69:
        r22 = "coredump_miss";
        r23 = false;
        goto L70
    L7:
        if (Long.parseLong(mCoredumpReturnCode) != 0) goto L9;
        boolean r30 = true;
    L10:
        mCoredumpDone = String.valueOf(r30);     // Catch: Throwable -> L12
        goto L14
    L9:
        r30 = false;
        goto L10
    }

    private static void writeConfig(String r10) {
        if (r10 != null) goto L12;
        return;
    L12:
        File r11 = new File(Global.getConfigDir(), CORE_CONFIG_FILE);     // Catch: Throwable -> L9
        mConfigFile = r11;     // Catch: Throwable -> L9
        if (r11.exists() == true) goto L7;
        mConfigFile.createNewFile();     // Catch: Throwable -> L9
    L7:
        NpthLog.i(LOG_TAG, "Core Init enable");     // Catch: Throwable -> L9
        FileUtils.writeFile(mConfigFile, r10, false);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public String getCoreDeleteCause() {
        return mCoreDeleteCause;
    }
}
