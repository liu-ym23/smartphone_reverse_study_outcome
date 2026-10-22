package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
            int[] r0 = new int[CrashType.values().length];
            $SwitchMap$com$bytedance$crash$CrashType = r0;
            r0[CrashType.ANR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
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

        /* synthetic */ CrashInfo(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        mCrashMap = new HashMap();
    }

    public CrashAccessibilityMonitor() {
    }

    public static long decodeWithCatch(String r0, long r1) {
        return Long.decode(r0).longValue();
    L4:
        return r1;
    }

    private static CrashType getCrashType(int r1) {
        if (r1 != 6) goto L7;
        return CrashType.ANR;
    L7:
        if (r1 != 5) goto L11;
        return CrashType.NATIVE;
    L11:
        if (r1 != 4) goto L15;
        return CrashType.JAVA;
    L15:
        return CrashType.UNKNOWN;
    }

    public static String getExitDir() {
        init();
        File r0 = sCrashHistoryDir;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getAbsolutePath();
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
        List<ApplicationExitInfo> r0 = AppExitInfoUtils.getProcessExitReasons();
        if (r0 != null) goto L15;
        return;
    L15:
        sHistoryProcessExitReason = new ArrayList();
        long r1 = getLastExitReasonTime();
        Iterator<ApplicationExitInfo> r2 = r0.iterator();
    L17:
        if (r2.hasNext() == false) goto L22;
        ApplicationExitInfo r3 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r2.next(), ApplicationExitInfo.class, "com.obric.memorydata.plugin");
        if (r3.getTimestamp() < r1) goto L22;
        sHistoryProcessExitReason.add(r3);
    L22:
        setExitReasonTime();
    }

    private static long getLastExitReasonTime() {
        init();
        File r0 = new File(sAppCrashExitDir, "lastReasonTime");
        if (r0.exists() == true) goto L8;
    L6:
        return -1;
    L8:
        return decodeWithCatch(FileUtils.readFile(r0), -1);
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

    public static String readTrace(InputStream r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        BufferedInputStream r1 = null;
        BufferedInputStream r2 = new BufferedInputStream(r8);     // Catch: Throwable -> L23
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L16
        byte[] r4 = new byte[8192];     // Catch: Throwable -> L16
    L8:
        int r6 = r2.read(r4, 0, 8192);     // Catch: Throwable -> L16
        if (r6 <= 0) goto L10;
        r3.append(new String(r4, 0, r6));     // Catch: Throwable -> L16
        goto L8
    L10:
        String r0 = r3.toString();     // Catch: Throwable -> L16
        r8.close();     // Catch: Throwable -> L21
    L32:
        r2.close();     // Catch: Throwable -> L22
    L13:
        return r0;
    L16:
        r1 = r2;
    L30:
        r8.close();     // Catch: Throwable -> L24
    L18:
        if (r1 != null) goto L34;
    L20:
        return "";
    L34:
        r1.close();     // Catch: Throwable -> L25
        goto L20
    }

    public static void setCrashAccessibilityEnable(boolean r0) {
        sIsEnable = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCrashInfo(CrashType r3, String r4, int r5, long r6) {
        List<ApplicationExitInfo> r0 = sHistoryProcessExitReason;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L21;
        List<CrashInfo> r1 = null;
        CrashInfo r2 = new CrashInfo(0 == true ? 1 : 0);     // Catch: Throwable -> L17
        if (r3 != CrashType.LAUNCH) goto L10;
        r3 = CrashType.JAVA;     // Catch: Throwable -> L17
    L10:
        r2.crashType = r3;     // Catch: Throwable -> L17
        r2.pid = r5;     // Catch: Throwable -> L17
        r2.crashTime = r6;     // Catch: Throwable -> L17
        if (mCrashMap.containsKey(r4) == false) goto L13;
        r1 = (List) ZeusTransformUtils.preCheckCast(mCrashMap.get(r4), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L13:
        if (r1 != null) goto L15;
        r1 = new ArrayList();     // Catch: Throwable -> L17
        mCrashMap.put(r4, r1);     // Catch: Throwable -> L17
    L15:
        r1.add(r2);     // Catch: Throwable -> L17
        return;
    L22:
        return;
    }

    private static void setExitReasonTime() {
        File r0 = new File(sAppCrashExitDir, "lastReasonTime");
        FileUtils.writeFile(r0, String.valueOf(System.currentTimeMillis()), false);     // Catch: Throwable -> L5
        return;
    }

    public static void upload() {
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L46
        Iterator<ApplicationExitInfo> r1 = sHistoryProcessExitReason.iterator();     // Catch: Throwable -> L46
    L4:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L31;
        ApplicationExitInfo r2 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r1.next(), ApplicationExitInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        if (r2.getReason() == 6) goto L13;
        if (r2.getReason() == 4) goto L13;
        if (r2.getReason() != 5) goto L4;
    L13:
        List r5 = (List) ZeusTransformUtils.preCheckCast(mCrashMap.get(r2.getProcessName()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        if (r5 == null) goto L15;
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L46
    L18:
        if (r6.hasNext() == false) goto L28;
        CrashInfo r7 = (CrashInfo) ZeusTransformUtils.preCheckCast(r6.next(), CrashInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        long r8 = r2.getTimestamp() - r7.crashTime;     // Catch: Throwable -> L46
        if (getCrashType(r2.getReason()).getName().equals(r7.crashType.getName()) == false) goto L18;
        if (r2.getPid() != r7.pid) goto L18;
        if (r8 <= 0) goto L18;
        if (r8 >= 30000) goto L18;
    L29:
        if (r3 == true) goto L4;
    L28:
        r3 = false;
    L15:
        r0.add(r2);     // Catch: Throwable -> L46
        goto L4
    L31:
        setExitReasonTime();     // Catch: Throwable -> L46
        Iterator r4 = r0.iterator();     // Catch: Throwable -> L46
    L32:
        if (r4.hasNext() == false) goto L82;
        ApplicationExitInfo r9 = (ApplicationExitInfo) ZeusTransformUtils.preCheckCast(r4.next(), ApplicationExitInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        int r10 = AnonymousClass1.$SwitchMap$com$bytedance$crash$CrashType[getCrashType(r9.getReason()).ordinal()];     // Catch: Throwable -> L46
        if (r10 != 1) goto L37;
        uploadANR(r9);     // Catch: Throwable -> L46
        goto L32
    L37:
        if (r10 != 2) goto L39;
        uploadNativeCrash(r9);     // Catch: Throwable -> L46
        goto L32
    L39:
        if (r10 != 3) goto L32;
        uploadJavaCrash(r9);     // Catch: Throwable -> L46
        goto L32
    L82:
        return;
    }

    private static void uploadANR(ApplicationExitInfo r15) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r0 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r15.getTimestamp(), CrashType.ANR, r15.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        JSONUtils.put(r1, "header", r0.getJson());
        r1.put("filters", r2);     // Catch: Throwable -> L62
    L7:
        JSONUtils.put(r1, "is_anr", 1);
        JSONUtils.put(r1, "crash_time", Long.valueOf(r15.getTimestamp()));
        String r5 = "true";
        JSONUtils.put(r1, Constants.HAS_DUMP, "true");
        String r4 = r15.getDescription();
        if (TextUtils.isEmpty(r4) == false) goto L10;
        r4 = ERR_ANR_INFO;
    L10:
        JSONUtils.put(r1, AnrInfoParser.ANR_INFO, r4);
        JSONUtils.put(r1, "app_start_time", Long.valueOf(r15.getTimestamp()));
        JSONUtils.put(r1, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        JSONObject r6 = new JSONObject();
        JSONUtils.put(r6, "thread_number", 1);
        JSONUtils.put(r6, "mainStackFromTrace", NO_STACK_ANR);
        JSONUtils.put(r6, CrashBody.PID, Integer.valueOf(r15.getPid()));
        JSONUtils.put(r6, "package", r15.getProcessName());
        JSONUtils.put(r6, ERR_ANR_INFO, false);
        JSONUtils.put(r6, "is_new_stack", 10);
        JSONUtils.put(r6, "not_current", 1);
        JSONUtils.put(r6, "is_remote_process", 0);
        JSONUtils.put(r1, "data", r6.toString());
        JSONUtils.put(r2, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L13;
        Object r7 = "true";
    L14:
        JSONUtils.put(r2, "is_64_runtime", r7);
        String r8 = r0.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r8) == true) goto L18;
        boolean r9 = r8.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
        JSONUtils.put(r2, "is_x86_devices", Boolean.valueOf(r8.contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE)));
        JSONUtils.put(r2, Constants.IS_64_DEVICES, Boolean.valueOf(r9));
    L18:
        if (GeneralInfoManager.isRoot() == true) goto L21;
        r5 = "false";
    L21:
        JSONUtils.put(r2, "is_root", r5);
        JSONUtils.put(r2, "kernel_version", r0.getJson().optString("kernel_version"));
        JSONUtils.put(r2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        JSONUtils.put(r2, Constants.EXIT_REASON, String.valueOf(r15.getReason()));
        JSONUtils.put(r2, "exit_status", String.valueOf(r15.getStatus()));
        JSONUtils.put(r2, "crash_from", "app_exit_history");
        JSONUtils.put(r2, "description", String.valueOf(r15.getDescription()));
        JSONUtils.put(r2, "importance", String.valueOf(r15.getImportance()));
        JSONUtils.put(r2, "pss", String.valueOf(r15.getPss()));
        JSONUtils.put(r2, "rss", String.valueOf(r15.getRss()));
        JSONObject r10 = new JSONObject();
        r1.put("custom", r10);     // Catch: Throwable -> L63
    L23:
        String r11 = r15.getDescription();
        if (r11 == null) goto L56;
        JSONUtils.put(r2, "description", r11);
        JSONUtils.put(r10, "description", r11);
        if (r11.contains("bg anr") == false) goto L28;
        boolean r12 = true;
    L29:
        JSONUtils.put(r1, "is_background", r12);
        if (r11.contains("Input dispatching timed out") == false) goto L40;
        JSONUtils.put(r2, Constants.ANR_REASON, "Input dispatching timed out");
        int r13 = r11.indexOf("Activity");
        int r14 = r13;
    L32:
        if (r14 <= 0) goto L37;
        if ('/' == r11.charAt(r14)) goto L37;
        r14 = r14 - 1;
    L37:
        if (r13 == r14) goto L56;
        String r3 = r11.substring(r14 + 1, r13) + "Activity";
        JSONUtils.put(r2, ActivityLifecycle.LAST_RESUME_ACTIVITY, r3);
    L55:
        JSONUtils.put(r2, "anr_tag", r3);
        goto L56
    L40:
        if (r11.contains("executing service") == false) goto L50;
        JSONUtils.put(r2, Constants.ANR_REASON, "executing service");
        int r16 = r11.indexOf("Service");
        int r17 = r16;
    L42:
        if (r17 <= 0) goto L47;
        if ('/' == r11.charAt(r17)) goto L47;
        r17 = r17 - 1;
    L47:
        if (r16 == r17) goto L56;
        r3 = r11.substring(r17 + 1, r16) + "Service";
        goto L55
    L50:
        if (r11.contains("Broadcast of Intent") == false) goto L56;
        JSONUtils.put(r2, Constants.ANR_REASON, "Broadcast of Intent");
        int r18 = r11.indexOf("{");
        int r19 = r11.indexOf("}");
        if (r18 == (-1)) goto L56;
        if (r19 == (-1)) goto L56;
        r3 = r11.substring(r18 + 1, r19).trim();
        goto L55
    L28:
        r12 = false;
    L56:
        JSONUtils.put(r10, "importance", String.valueOf(r15.getImportance()));
        JSONUtils.put(r10, "pss", String.valueOf(r15.getPss()));
        JSONUtils.put(r10, "rss", String.valueOf(r15.getRss()));
        JSONUtils.put(r10, "app_info_description", r15.toString());
        String r20 = null;
        r20 = readTrace(r15.getTraceInputStream());     // Catch: Throwable -> L64
    L58:
        if (r20 == null) goto L60;
        JSONUtils.put(r10, "anr_trace_description", r20);
    L60:
        String r110 = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.ANR, r0.getJson());
        ArrayList r21 = new ArrayList();
        r21.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(CrashType.ANR.getName(), r110, r1.toString(), r21);
        return;
    L13:
        r7 = "false";
        goto L14
    }

    private static void uploadJavaCrash(ApplicationExitInfo r9) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r0 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r9.getTimestamp(), CrashType.JAVA, r9.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        JSONUtils.put(r1, "header", r0.getJson());
        r1.put("filters", r2);     // Catch: Throwable -> L37
    L7:
        String r3 = null;
        r3 = readTrace(r9.getTraceInputStream());     // Catch: Throwable -> L38
    L9:
        boolean r4 = TextUtils.isEmpty(r3);
        String r5 = NO_STACK_ANR;
        if (r4 == false) goto L12;
    L13:
        r3 = NO_STACK_ANR;
    L14:
        JSONUtils.put(r1, "isJava", 1);
        JSONUtils.put(r1, "crash_time", Long.valueOf(r9.getTimestamp()));
        String r6 = "true";
        JSONUtils.put(r1, Constants.HAS_DUMP, "true");
        JSONUtils.put(r1, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        if (TextUtils.isEmpty(r3) == true) goto L18;
        r5 = r3;
    L18:
        JSONUtils.put(r1, "data", r5);
        JSONUtils.put(r2, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L21;
        Object r7 = "true";
    L22:
        JSONUtils.put(r2, "is_64_runtime", r7);
        String r8 = r0.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r8) == true) goto L26;
        boolean r10 = r8.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
        JSONUtils.put(r2, "is_x86_devices", Boolean.valueOf(r8.contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE)));
        JSONUtils.put(r2, Constants.IS_64_DEVICES, Boolean.valueOf(r10));
    L26:
        if (GeneralInfoManager.isRoot() == false) goto L28;
        Object r11 = "true";
    L29:
        JSONUtils.put(r2, "is_root", r11);
        JSONUtils.put(r2, "kernel_version", r0.getJson().optString("kernel_version"));
        JSONUtils.put(r2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        if (GeneralInfoManager.isRoot() == true) goto L33;
        r6 = "false";
    L33:
        JSONUtils.put(r2, "is_root", r6);
        JSONUtils.put(r2, Constants.EXIT_REASON, String.valueOf(r9.getReason()));
        JSONUtils.put(r2, "exit_status", String.valueOf(r9.getStatus()));
        JSONUtils.put(r2, "crash_from", "app_exit_history");
        JSONUtils.put(r2, "description", String.valueOf(r9.getDescription()));
        JSONUtils.put(r2, "importance", String.valueOf(r9.getImportance()));
        JSONUtils.put(r2, "pss", String.valueOf(r9.getPss()));
        JSONUtils.put(r2, "rss", String.valueOf(r9.getRss()));
        JSONObject r12 = new JSONObject();
        r1.put("custom", r12);     // Catch: Throwable -> L39
    L35:
        JSONUtils.put(r12, "app_info_description", r9.toString());
        String r13 = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.JAVA, r0.getJson());
        ArrayList r14 = new ArrayList();
        r14.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(CrashType.JAVA.getName(), r13, r1.toString(), r14);
        return;
    L28:
        r11 = "false";
        goto L29
    L21:
        r7 = "false";
        goto L22
    L12:
        if (r3.contains("failed to read status response from tombstoned:") == false) goto L14;
        goto L13
    }

    private static void uploadNativeCrash(ApplicationExitInfo r8) {
        if (AppExitInfoUtils.enableProcessExitReason() == true) goto L5;
        return;
    L5:
        Header r0 = Header.createHeaderWithoutCommon(MonitorManager.getAppMonitor(), r8.getTimestamp(), CrashType.NATIVE, r8.getPid());
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        JSONUtils.put(r1, "header", r0.getJson());
        r1.put("filters", r2);     // Catch: Throwable -> L33
    L7:
        JSONUtils.put(r1, CrashBody.IS_NATIVE_CRASH, 1);
        JSONUtils.put(r1, "crash_time", Long.valueOf(r8.getTimestamp()));
        String r5 = "true";
        JSONUtils.put(r1, Constants.HAS_DUMP, "true");
        JSONUtils.put(r1, Constants.KEY_HW_JIFFIES, Long.valueOf(GeneralInfoManager.getJiffy()));
        JSONUtils.put(r1, "data", "Signal 111(CRASH_FROM_EXIT)\n\n");
        JSONUtils.put(r2, "sdk_version", NpthBuildConfig.VERSION_NAME);
        if (NativeBridge.is64BitRuntime() == false) goto L10;
        Object r3 = "true";
    L11:
        JSONUtils.put(r2, "is_64_runtime", r3);
        String r4 = r0.getJson().optString("cpu_abi");
        if (TextUtils.isEmpty(r4) == true) goto L15;
        boolean r6 = r4.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON);
        JSONUtils.put(r2, "is_x86_devices", Boolean.valueOf(r4.contains(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE)));
        JSONUtils.put(r2, Constants.IS_64_DEVICES, Boolean.valueOf(r6));
    L15:
        if (GeneralInfoManager.isRoot() == false) goto L17;
        Object r7 = "true";
    L18:
        JSONUtils.put(r2, "is_root", r7);
        JSONUtils.put(r2, "kernel_version", r0.getJson().optString("kernel_version"));
        JSONUtils.put(r2, Constants.IS_HM_OS, String.valueOf(RomUtils.isHarmonyOs()));
        if (GeneralInfoManager.isRoot() == true) goto L22;
        r5 = "false";
    L22:
        JSONUtils.put(r2, "is_root", r5);
        JSONUtils.put(r2, Constants.EXIT_REASON, String.valueOf(r8.getReason()));
        JSONUtils.put(r2, "exit_status", String.valueOf(r8.getStatus()));
        JSONUtils.put(r2, "crash_from", "app_exit_history");
        JSONUtils.put(r2, "description", String.valueOf(r8.getDescription()));
        JSONUtils.put(r2, "importance", String.valueOf(r8.getImportance()));
        JSONUtils.put(r2, "pss", String.valueOf(r8.getPss()));
        JSONUtils.put(r2, "rss", String.valueOf(r8.getRss()));
        JSONObject r9 = new JSONObject();
        r1.put("custom", r9);     // Catch: Throwable -> L34
    L24:
        JSONUtils.put(r9, "app_info_description", r8.toString());
        String r10 = null;
        r10 = readTrace(r8.getTraceInputStream());     // Catch: Throwable -> L35
    L27:
        if (TextUtils.isEmpty(r10) == false) goto L29;
    L31:
        String r11 = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.NATIVE, r0.getJson());
        ArrayList r12 = new ArrayList();
        r12.add(sAppCrashExitDir);
        CrashUploader.uploadCrashLogWithAttachment(CrashType.NATIVE.getName(), r11, r1.toString(), r12);
        return;
    L29:
        if (r10.contains("failed to read status response from tombstoned:") == true) goto L31;
        JSONUtils.put(r9, "native_crash_trace", r10);
        goto L31
    L17:
        r7 = "false";
        goto L18
    L10:
        r3 = "false";
        goto L11
    }
}
