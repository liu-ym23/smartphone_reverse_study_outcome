package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrInfoParser;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.RomUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CrashAccessibilityMonitor {
    private static final String ERR_ANR_INFO = "invalid";
    public static final String NO_STACK_ANR = "at ApplicationExit InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    private static Map<String, List<CrashInfo>> mCrashMap = null;
    private static boolean sAnrReasonParsed = false;
    private static File sAppCrashExitDir = null;
    private static File sCrashHistoryDir = null;
    private static List<ApplicationExitInfo> sHistoryProcessExitReason = null;
    private static boolean sIsEnable = false;
    private static volatile boolean sIsInited = false;

    /* JADX INFO: renamed from: com.bytedance.crash.terminate.CrashAccessibilityMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$crash$CrashType = null;

        static {
            int[] r10 = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = r10;
            r10[CrashType.ANR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.NATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$crash$CrashType[CrashType.JAVA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class CrashInfo {
        long crashTime;
        CrashType crashType;
        int pid;

        private CrashInfo() {
        }

        /* synthetic */ CrashInfo(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        mCrashMap = new HashMap();
    }

    public CrashAccessibilityMonitor() {
    }

    public static long decodeWithCatch(String r10, long r11) {
        return Long.decode(r10).longValue();
    L4:
        return r11;
    }

    private static CrashType getCrashType(int r10) {
        if (r10 != 6) goto L7;
        return CrashType.ANR;
    L7:
        if (r10 != 5) goto L11;
        return CrashType.NATIVE;
    L11:
        if (r10 != 4) goto L15;
        return CrashType.JAVA;
    L15:
        return CrashType.UNKNOWN;
    }

    public static String getExitDir() {
        init();
        File r10 = sCrashHistoryDir;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10.getAbsolutePath();
    }

    public static void getHistoryProcessExitReason() {
        if (isEnable() == true) goto L6;
        return;
    L6:
        if (sAnrReasonParsed == false) goto L8;
        return;
    L8:
        sAnrReasonParsed = true;
        init();
        if (new File(sAppCrashExitDir, "lastReasonTime").exists() == true) goto L12;
        setExitReasonTime();
        return;
    L12:
        List<ApplicationExitInfo> r10 = AppExitInfoUtils.getProcessExitReasons();
        if (r10 != null) goto L15;
        return;
    L15:
        sHistoryProcessExitReason = new ArrayList();
        long r11 = getLastExitReasonTime();
        Iterator<ApplicationExitInfo> r12 = r10.iterator();
    L17:
        if (r12.hasNext() == false) goto L22;
        ApplicationExitInfo r13 = r12.next();
        if (r13.getTimestamp() < r11) goto L22;
        sHistoryProcessExitReason.add(r13);
    L22:
        setExitReasonTime();
    }

    private static long getLastExitReasonTime() {
        init();
        File r10 = new File(sAppCrashExitDir, "lastReasonTime");
        if (r10.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return decodeWithCatch(FileUtils.readFile(r10), -1);
    }

    public static void init() {
        if (isEnable() == true) goto L6;
        return;
    L6:
        if (sIsInited == false) goto L8;
        return;
    L8:
        sIsInited = true;
        if (sAppCrashExitDir != null) goto L12;
        sAppCrashExitDir = new File(Global.getRootDirectory(), "crash_exit_history");
    L12:
        if (sAppCrashExitDir.exists() == true) goto L15;
        sAppCrashExitDir.mkdirs();
    L15:
        if (sCrashHistoryDir != null) goto L18;
        sCrashHistoryDir = new File(sAppCrashExitDir, "history_crash_list");
    L18:
        if (sCrashHistoryDir.exists() == true) goto L21;
        sCrashHistoryDir.mkdirs();
        return;
    }

    private static boolean isEnable() {
        if (sIsEnable == true) goto L5;
        return false;
    L5:
        return AppExitInfoUtils.enableProcessExitReason();
    }

    public static String readTrace(InputStream r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        BufferedInputStream r11 = null;
        BufferedInputStream r12 = new BufferedInputStream(r10);     // Catch: Throwable -> L23
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L16
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L16
    L8:
        int r15 = r12.read(r14, 0, 8192);     // Catch: Throwable -> L16
        if (r15 <= 0) goto L10;
        r13.append(new String(r14, 0, r15));     // Catch: Throwable -> L16
        goto L8
    L10:
        String r16 = r13.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Throwable -> L21
    L32:
        r12.close();     // Catch: Throwable -> L22
    L13:
        return r16;
    L16:
        r11 = r12;
    L30:
        r10.close();     // Catch: Throwable -> L24
    L18:
        if (r11 != null) goto L34;
    L20:
        return "";
    L34:
        r11.close();     // Catch: Throwable -> L25
        goto L20
    }

    public static void setCrashAccessibilityEnable(boolean r10) {
        sIsEnable = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCrashInfo(CrashType r10, String r11, int r12, long r13) {
        List<ApplicationExitInfo> r14 = sHistoryProcessExitReason;
        if (r14 != null) goto L5;
        return;
    L5:
        if (r14.size() == 0) goto L21;
        List<CrashInfo> r15 = null;
        CrashInfo r16 = new CrashInfo(0 == true ? 1 : 0);     // Catch: Throwable -> L17
        if (r10 != CrashType.LAUNCH) goto L10;
        r10 = CrashType.JAVA;     // Catch: Throwable -> L17
    L10:
        r16.crashType = r10;     // Catch: Throwable -> L17
        r16.pid = r12;     // Catch: Throwable -> L17
        r16.crashTime = r13;     // Catch: Throwable -> L17
        if (mCrashMap.containsKey(r11) == false) goto L13;
        r15 = mCrashMap.get(r11);     // Catch: Throwable -> L17
    L13:
        if (r15 != null) goto L15;
        r15 = new ArrayList();     // Catch: Throwable -> L17
        mCrashMap.put(r11, r15);     // Catch: Throwable -> L17
    L15:
        r15.add(r16);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    }

    private static void setExitReasonTime() {
        File r10 = new File(sAppCrashExitDir, "lastReasonTime");
        FileUtils.writeFile(r10, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }

    public static void upload() {
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L45
        Iterator<ApplicationExitInfo> r11 = sHistoryProcessExitReason.iterator();     // Catch: Throwable -> L45
    L3:
        boolean r12 = true;
        if (r11.hasNext() == false) goto L30;
        ApplicationExitInfo r13 = r11.next();     // Catch: Throwable -> L45
        if (r13.getReason() == 6) goto L12;
        if (r13.getReason() == 4) goto L12;
        if (r13.getReason() != 5) goto L3;
    L12:
        List<CrashInfo> r14 = mCrashMap.get(r13.getProcessName());     // Catch: Throwable -> L45
        if (r14 == null) goto L14;
        Iterator<CrashInfo> r15 = r14.iterator();     // Catch: Throwable -> L45
    L17:
        if (r15.hasNext() == false) goto L27;
        CrashInfo r16 = r15.next();     // Catch: Throwable -> L45
        long r17 = r13.getTimestamp() - r16.crashTime;     // Catch: Throwable -> L45
        if (getCrashType(r13.getReason()).getName().equals(r16.crashType.getName()) == false) goto L17;
        if (r13.getPid() != r16.pid) goto L17;
        if (r17 <= 0) goto L17;
        if (r17 >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) goto L17;
    L28:
        if (r12 == true) goto L3;
    L27:
        r12 = false;
    L14:
        r10.add(r13);     // Catch: Throwable -> L45
        goto L3
    L30:
        setExitReasonTime();     // Catch: Throwable -> L45
        Iterator r18 = r10.iterator();     // Catch: Throwable -> L45
    L31:
        if (r18.hasNext() == false) goto L81;
        ApplicationExitInfo r19 = (ApplicationExitInfo) r18.next();     // Catch: Throwable -> L45
        int r20 = AnonymousClass1.$SwitchMap$com$bytedance$crash$CrashType[getCrashType(r19.getReason()).ordinal()];     // Catch: Throwable -> L45
        if (r20 != 1) goto L36;
        uploadANR(r19);     // Catch: Throwable -> L45
        goto L31
    L36:
        if (r20 != 2) goto L38;
        uploadNativeCrash(r19);     // Catch: Throwable -> L45
        goto L31
    L38:
        if (r20 != 3) goto L31;
        uploadJavaCrash(r19);     // Catch: Throwable -> L45
        goto L31
    L81:
        return;
    }

    private static void uploadANR(ApplicationExitInfo r15) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r10 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r15.getTimestamp(), CrashType.ANR, r15.getPid());
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        JSONUtils.put(r11, "header", r10.getJson());
        r11.put("filters", r12);     // Catch: Throwable -> L62
    L7:
        JSONUtils.put(r11, "is_anr", 1);
        JSONUtils.put(r11, "crash_time", Long.valueOf(r15.getTimestamp()));
        String r13 = "true";
        JSONUtils.put(r11, Constants.HAS_DUMP, "true");
        String r14 = r15.getDescription();
        if (TextUtils.isEmpty(r14) == false) goto L10;
        r14 = ERR_ANR_INFO;
    L10:
        JSONUtils.put(r11, AnrInfoParser.ANR_INFO, r14);
        JSONUtils.put(r11, "app_start_time", Long.valueOf(r15.getTimestamp()));
        JSONUtils.put(r11, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        JSONObject r16 = new JSONObject();
        JSONUtils.put(r16, "thread_number", 1);
        JSONUtils.put(r16, "mainStackFromTrace", NO_STACK_ANR);
        JSONUtils.put(r16, "pid", Integer.valueOf(r15.getPid()));
        JSONUtils.put(r16, "package", r15.getProcessName());
        JSONUtils.put(r16, ERR_ANR_INFO, Boolean.FALSE);
        JSONUtils.put(r16, "is_new_stack", 10);
        JSONUtils.put(r16, "not_current", 1);
        JSONUtils.put(r16, "is_remote_process", 0);
        JSONUtils.put(r11, "data", r16.toString());
        JSONUtils.put(r12, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L13;
        Object r17 = "true";
    L14:
        JSONUtils.put(r12, "is_64_runtime", r17);
        String r18 = r10.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r18) == true) goto L18;
        boolean r19 = r18.contains("64");
        JSONUtils.put(r12, "is_x86_devices", Boolean.valueOf(r18.contains("86")));
        JSONUtils.put(r12, Constants.IS_64_DEVICES, Boolean.valueOf(r19));
    L18:
        if (GeneralInfoManager.isRoot() == true) goto L21;
        r13 = "false";
    L21:
        JSONUtils.put(r12, "is_root", r13);
        JSONUtils.put(r12, "kernel_version", r10.getJson().optString("kernel_version"));
        JSONUtils.put(r12, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        JSONUtils.put(r12, Constants.EXIT_REASON, String.valueOf(r15.getReason()));
        JSONUtils.put(r12, "exit_status", String.valueOf(r15.getStatus()));
        JSONUtils.put(r12, "crash_from", "app_exit_history");
        JSONUtils.put(r12, "description", String.valueOf(r15.getDescription()));
        JSONUtils.put(r12, "importance", String.valueOf(r15.getImportance()));
        JSONUtils.put(r12, "pss", String.valueOf(r15.getPss()));
        JSONUtils.put(r12, "rss", String.valueOf(r15.getRss()));
        JSONObject r20 = new JSONObject();
        r11.put("custom", r20);     // Catch: Throwable -> L63
    L23:
        String r21 = r15.getDescription();
        if (r21 == null) goto L56;
        JSONUtils.put(r12, "description", r21);
        JSONUtils.put(r20, "description", r21);
        if (r21.contains("bg anr") == false) goto L28;
        Boolean r22 = Boolean.TRUE;
    L29:
        JSONUtils.put(r11, Constants.IS_BACKGROUND, r22);
        if (r21.contains("Input dispatching timed out") == false) goto L40;
        JSONUtils.put(r12, Constants.ANR_REASON, "Input dispatching timed out");
        int r110 = r21.indexOf("Activity");
        int r111 = r110;
    L32:
        if (r111 <= 0) goto L37;
        if ('/' == r21.charAt(r111)) goto L37;
        r111 = r111 - 1;
    L37:
        if (r110 == r111) goto L56;
        String r23 = r21.substring(r111 + 1, r110) + "Activity";
        JSONUtils.put(r12, ActivityLifecycle.LAST_RESUME_ACTIVITY, r23);
    L55:
        JSONUtils.put(r12, "anr_tag", r23);
        goto L56
    L40:
        if (r21.contains("executing service") == false) goto L50;
        JSONUtils.put(r12, Constants.ANR_REASON, "executing service");
        int r112 = r21.indexOf("Service");
        int r113 = r112;
    L42:
        if (r113 <= 0) goto L47;
        if ('/' == r21.charAt(r113)) goto L47;
        r113 = r113 - 1;
    L47:
        if (r112 == r113) goto L56;
        r23 = r21.substring(r113 + 1, r112) + "Service";
        goto L55
    L50:
        if (r21.contains("Broadcast of Intent") == false) goto L56;
        JSONUtils.put(r12, Constants.ANR_REASON, "Broadcast of Intent");
        int r24 = r21.indexOf("{");
        int r114 = r21.indexOf("}");
        if (r24 == (-1)) goto L56;
        if (r114 == (-1)) goto L56;
        r23 = r21.substring(r24 + 1, r114).trim();
        goto L55
    L28:
        r22 = Boolean.FALSE;
    L56:
        JSONUtils.put(r20, "importance", String.valueOf(r15.getImportance()));
        JSONUtils.put(r20, "pss", String.valueOf(r15.getPss()));
        JSONUtils.put(r20, "rss", String.valueOf(r15.getRss()));
        JSONUtils.put(r20, "app_info_description", r15.toString());
        String r25 = null;
        r25 = readTrace(r15.getTraceInputStream());     // Catch: Throwable -> L64
    L58:
        if (r25 == null) goto L60;
        JSONUtils.put(r20, "anr_trace_description", r25);
    L60:
        CrashType r115 = CrashType.ANR;
        String r26 = UploaderUrl.getUrlByCrashTypeAndHeader(r115, r10.getJson());
        ArrayList r27 = new ArrayList();
        r27.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(r115.getName(), r26, r11.toString(), r27);
        return;
    L13:
        r17 = "false";
        goto L14
    }

    private static void uploadJavaCrash(ApplicationExitInfo r10) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r11 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r10.getTimestamp(), CrashType.JAVA, r10.getPid());
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONUtils.put(r12, "header", r11.getJson());
        r12.put("filters", r13);     // Catch: Throwable -> L37
    L7:
        String r14 = null;
        r14 = readTrace(r10.getTraceInputStream());     // Catch: Throwable -> L38
    L9:
        boolean r15 = TextUtils.isEmpty(r14);
        String r16 = NO_STACK_ANR;
        if (r15 == false) goto L12;
    L13:
        r14 = NO_STACK_ANR;
    L14:
        JSONUtils.put(r12, "isJava", 1);
        JSONUtils.put(r12, "crash_time", Long.valueOf(r10.getTimestamp()));
        String r17 = "true";
        JSONUtils.put(r12, Constants.HAS_DUMP, "true");
        JSONUtils.put(r12, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        if (TextUtils.isEmpty(r14) == true) goto L18;
        r16 = r14;
    L18:
        JSONUtils.put(r12, "data", r16);
        JSONUtils.put(r13, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L21;
        Object r18 = "true";
    L22:
        JSONUtils.put(r13, "is_64_runtime", r18);
        String r19 = r11.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r19) == true) goto L26;
        boolean r20 = r19.contains("64");
        JSONUtils.put(r13, "is_x86_devices", Boolean.valueOf(r19.contains("86")));
        JSONUtils.put(r13, Constants.IS_64_DEVICES, Boolean.valueOf(r20));
    L26:
        if (GeneralInfoManager.isRoot() == false) goto L28;
        Object r21 = "true";
    L29:
        JSONUtils.put(r13, "is_root", r21);
        JSONUtils.put(r13, "kernel_version", r11.getJson().optString("kernel_version"));
        JSONUtils.put(r13, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        if (GeneralInfoManager.isRoot() == true) goto L33;
        r17 = "false";
    L33:
        JSONUtils.put(r13, "is_root", r17);
        JSONUtils.put(r13, Constants.EXIT_REASON, String.valueOf(r10.getReason()));
        JSONUtils.put(r13, "exit_status", String.valueOf(r10.getStatus()));
        JSONUtils.put(r13, "crash_from", "app_exit_history");
        JSONUtils.put(r13, "description", String.valueOf(r10.getDescription()));
        JSONUtils.put(r13, "importance", String.valueOf(r10.getImportance()));
        JSONUtils.put(r13, "pss", String.valueOf(r10.getPss()));
        JSONUtils.put(r13, "rss", String.valueOf(r10.getRss()));
        JSONObject r22 = new JSONObject();
        r12.put("custom", r22);     // Catch: Throwable -> L39
    L35:
        JSONUtils.put(r22, "app_info_description", r10.toString());
        CrashType r23 = CrashType.JAVA;
        String r24 = UploaderUrl.getUrlByCrashTypeAndHeader(r23, r11.getJson());
        ArrayList r25 = new ArrayList();
        r25.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(r23.getName(), r24, r12.toString(), r25);
        return;
    L28:
        r21 = "false";
        goto L29
    L21:
        r18 = "false";
        goto L22
    L12:
        if (r14.contains("failed to read status response from tombstoned:") == false) goto L14;
        goto L13
    }

    private static void uploadNativeCrash(ApplicationExitInfo r10) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r11 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r10.getTimestamp(), CrashType.NATIVE, r10.getPid());
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONUtils.put(r12, "header", r11.getJson());
        r12.put("filters", r13);     // Catch: Throwable -> L33
    L7:
        JSONUtils.put(r12, CrashBody.IS_NATIVE_CRASH, 1);
        JSONUtils.put(r12, "crash_time", Long.valueOf(r10.getTimestamp()));
        String r14 = "true";
        JSONUtils.put(r12, Constants.HAS_DUMP, "true");
        JSONUtils.put(r12, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        JSONUtils.put(r12, "data", "Signal 111(CRASH_FROM_EXIT)\n\n");
        JSONUtils.put(r13, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L10;
        Object r15 = "true";
    L11:
        JSONUtils.put(r13, "is_64_runtime", r15);
        String r16 = r11.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r16) == true) goto L15;
        boolean r17 = r16.contains("64");
        JSONUtils.put(r13, "is_x86_devices", Boolean.valueOf(r16.contains("86")));
        JSONUtils.put(r13, Constants.IS_64_DEVICES, Boolean.valueOf(r17));
    L15:
        if (GeneralInfoManager.isRoot() == false) goto L17;
        Object r18 = "true";
    L18:
        JSONUtils.put(r13, "is_root", r18);
        JSONUtils.put(r13, "kernel_version", r11.getJson().optString("kernel_version"));
        JSONUtils.put(r13, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        if (GeneralInfoManager.isRoot() == true) goto L22;
        r14 = "false";
    L22:
        JSONUtils.put(r13, "is_root", r14);
        JSONUtils.put(r13, Constants.EXIT_REASON, String.valueOf(r10.getReason()));
        JSONUtils.put(r13, "exit_status", String.valueOf(r10.getStatus()));
        JSONUtils.put(r13, "crash_from", "app_exit_history");
        JSONUtils.put(r13, "description", String.valueOf(r10.getDescription()));
        JSONUtils.put(r13, "importance", String.valueOf(r10.getImportance()));
        JSONUtils.put(r13, "pss", String.valueOf(r10.getPss()));
        JSONUtils.put(r13, "rss", String.valueOf(r10.getRss()));
        JSONObject r19 = new JSONObject();
        r12.put("custom", r19);     // Catch: Throwable -> L34
    L24:
        JSONUtils.put(r19, "app_info_description", r10.toString());
        String r20 = null;
        r20 = readTrace(r10.getTraceInputStream());     // Catch: Throwable -> L35
    L27:
        if (TextUtils.isEmpty(r20) == false) goto L29;
    L31:
        CrashType r21 = CrashType.NATIVE;
        String r22 = UploaderUrl.getUrlByCrashTypeAndHeader(r21, r11.getJson());
        ArrayList r23 = new ArrayList();
        r23.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(r21.getName(), r22, r12.toString(), r23);
        return;
    L29:
        if (r20.contains("failed to read status response from tombstoned:") == true) goto L31;
        JSONUtils.put(r19, "native_crash_trace", r20);
        goto L31
    L17:
        r18 = "false";
        goto L18
    L10:
        r15 = "false";
        goto L11
    }
}
