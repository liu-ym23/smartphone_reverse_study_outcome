package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Process;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IExitReasonCallback;
import com.bytedance.crash.IExitReasonListCallback;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ProcessTracker;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TerminateMonitor {
    public static final String EXIT_INFO_PATH = "exit_info";
    public static final String HAS_PROCESS_TRACK = "has_process_track";
    private static final String KILL_HISTORY_DIR = "killHistory";
    public static final String KILL_INFO_PATH = "kill_info";
    private static final String LOG_TAG = "TerminateMonitor";
    private static final int MAX_SIZE = 20;
    private static final String PROC = "proc";
    private static ConcurrentLinkedQueue<IExitReasonListCallback> callbacks = null;
    private static boolean isClean = false;
    private static boolean mInit = false;
    private static File mProcDirectory = null;
    private static File mProcProcessDirectory = null;
    public static File mTerminateHistoryDirectory = null;
    public static File mTerminateInfoDirectory = null;
    private static String mlogcatStr = null;
    private static ConcurrentLinkedQueue<IExitReasonCallback> sExitReasonCallbacks = null;
    private static boolean sUploadEnd = false;
    private static boolean uploadAll = false;
    private static boolean uploadFG = false;

    static {
        sExitReasonCallbacks = new ConcurrentLinkedQueue();
        callbacks = new ConcurrentLinkedQueue();
        sUploadEnd = false;
        isClean = false;
    }

    public TerminateMonitor() {
    }

    static /* synthetic */ void access$000(AppMonitor r0, ApplicationExitInfo r1, boolean r2, boolean r3) {
        uploadOne(r0, r1, r2, r3);
    }

    static /* synthetic */ void access$100() {
        cleanLogcat();
    }

    static /* synthetic */ boolean access$200() {
        return uploadAll;
    }

    static /* synthetic */ boolean access$300(int r0) {
        return isImportantKillHistory(r0);
    }

    static void callExitReasonCallback(List<ApplicationExitInfo> r4) {
        List<ApplicationExitInfo> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Iterator<IExitReasonListCallback> r0 = callbacks.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L19;
        ((IExitReasonListCallback) ZeusTransformUtils.preCheckCast(r0.next(), IExitReasonListCallback.class, "com.obric.memorydata.plugin")).findExitReasons(r5);     // Catch: Throwable -> L10
        goto L5
    L19:
        return;
    }

    static void callExitReasonCallbacks(ApplicationExitInfo r4) {
        Iterator<IExitReasonCallback> r0 = sExitReasonCallbacks.iterator();     // Catch: Throwable -> L10
    L4:
        if (r0.hasNext() == false) goto L18;
        ((IExitReasonCallback) ZeusTransformUtils.preCheckCast(r0.next(), IExitReasonCallback.class, "com.obric.memorydata.plugin")).findOneExitReason(r4);     // Catch: Throwable -> L9
        goto L4
    L18:
        return;
    }

    private static void cleanLogcat() {
        new File(mTerminateHistoryDirectory, "custom_data").listFiles(new AnonymousClass5());     // Catch: Throwable -> L4
        return;
    }

    static void clearExitInfo() {
        if (mProcProcessDirectory.exists() == true) goto L6;
        return;
    L6:
        if (isClean == false) goto L8;
        return;
    L8:
        isClean = true;
        File[] r0 = mProcProcessDirectory.listFiles(new AnonymousClass7());
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.length <= 20) goto L18;
        Arrays.sort(r0, new AnonymousClass8());
        int r1 = 0;
    L14:
        if (r1 >= (r0.length - 20)) goto L19;
        FileUtils.deleteFile(r0[r1]);
        r1 = r1 + 1;
        goto L14
    L19:
        return;
    }

    public static long decodeWithCatch(String r0, long r1) {
        return Long.decode(r0).longValue();
    L4:
        return r1;
    }

    private static void dumpActivityInfo(File r2, Map<String, String> r3, AppExitInfo r4, long r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        File r7 = ProcessTracker.getInstance().getProcessTrackFile(r4.getProcessName(), r5);     // Catch: Throwable -> L31
        if (r7 != null) goto L7;
    L29:
        r6.put("has_process_track", "false");     // Catch: Throwable -> L31
        return;
    L7:
        if (r7.exists() == false) goto L29;
        File r8 = new File(r2, "process_track.txt");     // Catch: Throwable -> L31
        String r9 = null;
        FileUtils.copyAppend(r7, r8);     // Catch: Throwable -> L25
        r6.put("has_process_track", "true");     // Catch: Throwable -> L25
        BufferedReader r10 = new BufferedReader(new FileReader(r8));     // Catch: Throwable -> L25
    L37:
        String r11 = r10.readLine();     // Catch: Throwable -> L23
        if (r11 == null) goto L16;
        if (r11.contains("onResume") == false) goto L37;
        r9 = r11;
        goto L37
    L16:
        if (r9 == null) goto L22;
        String[] r12 = r9.split(" ", 3);     // Catch: Throwable -> L23
        if (r12.length <= 1) goto L22;
        String r13 = r12[1];     // Catch: Throwable -> L23
        int r14 = r13.indexOf(".onResume");     // Catch: Throwable -> L23
        if (r14 <= 0) goto L22;
        r6.put(MemoryInfoSectionEditActivity.KIND_SCENE, r13.substring(0, r14));     // Catch: Throwable -> L23
    L22:
        IoUtil.close(r10);     // Catch: Throwable -> L31
        return;
    L23:
        Throwable th = th;
    L27:
        IoUtil.close(r10);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L25:
        th = move-exception;
        r10 = null;
        th = th;
    L31:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpActivityInfo", th);
    }

    private static void dumpAlogInfo(ApplicationExitInfo r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        AlogManager.record(r6.getProcessName(), 0, r6.getTimestamp(), CrashType.NATIVE_CUSTOMIZE);     // Catch: Throwable -> L5
        r8.put("has_alog", "true");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        NpthLog.w("KillInfo:" + th);
    }

    private static boolean dumpLogcat(File r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Logcat.npthDump(r3, true);     // Catch: Throwable -> L11
        if (Logcat.isLogcatExists(r3) == false) goto L17;
        String r6 = FileUtils.readFile(new File(r3, "logcat.txt"));     // Catch: Throwable -> L11
        mlogcatStr = r6;     // Catch: Throwable -> L11
        if (r6.isEmpty() == false) goto L8;
        return false;
    L8:
        if (mlogcatStr.length() <= 10) goto L19;
        r5.put("has_logcat", "true");     // Catch: Throwable -> L11
        return true;
    L19:
        return false;
    L17:
        return false;
    L11:
        th = move-exception;
        NpthLog.w("KillInfo:" + th);
        return false;
    }

    private static boolean dumpOsMemoryInfo(File r7, Map<String, String> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        NativeBridge.dumpMeminfo(r7.getAbsolutePath(), true);     // Catch: IOException -> L16
        File r0 = new File(r7, "os_memory.txt");     // Catch: IOException -> L16
        if (r0.exists() == true) goto L7;
    L14:
        r9.put("has_os_memory", "false");     // Catch: IOException -> L16
        return false;
    L7:
        if (r0.length() <= 10) goto L14;
        String r10 = FileUtils.readFile(r0);     // Catch: IOException -> L16
        if (r10 == null) goto L14;
        if (r10.contains("kB") == false) goto L14;
        r9.put("has_os_memory", "true");     // Catch: IOException -> L16
        return true;
    L16:
        e = move-exception;
        NpthLog.w("KillInfo:" + e);
        return false;
    }

    static void forceStart(final AppMonitor r2, boolean r3, final boolean r4, final boolean r5) {
    L26:
        Runnable r6 = new AnonymousClass2();
    L27:
        DefaultWorkThread.post(r6);
        return;
    L3:
        if (NpthCore.isStopUpload() == false) goto L5;
    L25:
        Runnable r7 = new AnonymousClass2();
    L9:
        DefaultWorkThread.post(r7);
        return;
    L5:
        if (sUploadEnd == true) goto L25;
        if (r2 != null) goto L11;
        r7 = new AnonymousClass2();
        goto L9
    L11:
        init();     // Catch: Throwable -> L26
        if (App.isMainProcess() == true) goto L15;
        r7 = new AnonymousClass2();
        goto L9
    L15:
        sUploadEnd = true;     // Catch: Throwable -> L26
        final List<ApplicationExitInfo> r0 = ExitReasonMonitor.parseExitReason();     // Catch: Throwable -> L26
        if (r0 != null) goto L18;
    L24:
        r7 = new AnonymousClass2();
        goto L9
    L18:
        if (r0.size() == 0) goto L24;
        if (r3 == true) goto L22;
        r7 = new AnonymousClass2();
        goto L9
    L22:
        DefaultWorkThread.post(new AnonymousClass1(r0, r2, r4, r5));     // Catch: Throwable -> L26
        r6 = new AnonymousClass2();
        goto L27
    }

    public static void forceStart(boolean r1, boolean r2, boolean r3) {
        forceStart(MonitorManager.getAppMonitor(), r1, r2, r3);
    }

    public static void forceUploadAll() {
        forceStart(MonitorManager.getAppMonitor(), true, true, true);
    }

    public static void init() {
        if (mInit == false) goto L5;
        return;
    L5:
        File r0 = Global.getRootDirectory();
        if (r0 == null) goto L9;
        mInit = true;
        NpthLog.i("KillInfo", CommonConsts.APM_INNER_EVENT_COST_INIT);
        initFile(r0);
        return;
    }

    private static void initFile(File r4) {
        File r5 = FileSystemUtils.createDirectory(r4, KILL_HISTORY_DIR);
        mTerminateHistoryDirectory = r5;
        mTerminateInfoDirectory = FileSystemUtils.createDirectory(r5, KILL_INFO_PATH);
        mProcDirectory = FileSystemUtils.createDirectory(mTerminateHistoryDirectory, PROC);
        mProcProcessDirectory = FileSystemUtils.createDirectory(mProcDirectory, App.getCurProcessName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).replace(".", "_").replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "-"));
        new File(mProcProcessDirectory, Process.myPid() + "_" + Global.getAppStartTime()).createNewFile();     // Catch: IOException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        NpthLog.e(e);
        return;
    }

    private static boolean isImportantKillHistory(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= 300) goto L6;
        return true;
    }

    private static boolean killCustomizeExceptionUpload(AppMonitor r3, long r4, JSONObject r6, File r7) {
        JSONObject r5 = Header.createEventHeader(r3, r4, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();     // Catch: Exception -> L8
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L8
        JSONArray r9 = new JSONArray();     // Catch: Exception -> L8
        r9.put(r6);     // Catch: Exception -> L8
        r8.put("data", r9);     // Catch: Exception -> L8
        r8.put("header", r5);     // Catch: Exception -> L8
        if (mlogcatStr == null) goto L6;
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L8
        r10.put(mlogcatStr);     // Catch: Exception -> L8
        r8.put(Constants.LOGCAT, r10);     // Catch: Exception -> L8
    L6:
        return CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r5), r8.toString(), new File[]{r7});
    L8:
        return false;
    }

    public static void put(JSONObject r0, String r1, Object r2) {
        JSONUtils.put(r0, r1, r2);
    }

    public static void registerExitReasonCallback(IExitReasonCallback r2) {
        IExitReasonCallback r3 = (IExitReasonCallback) ZeusTransformUtils.wrapperContextForParams(r2, IExitReasonCallback.class, "com.obric.memorydata.plugin");
        sExitReasonCallbacks.add(r3);
    }

    public static void registerExitReasonList(IExitReasonListCallback r2) {
        IExitReasonListCallback r3 = (IExitReasonListCallback) ZeusTransformUtils.wrapperContextForParams(r2, IExitReasonListCallback.class, "com.obric.memorydata.plugin");
        callbacks.add(r3);
    }

    public static void setUploadFlag(boolean r0, boolean r1) {
        uploadAll = r0;
        uploadFG = r1;
    }

    public static void upload(final AppMonitor r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (mInit == false) goto L37;
    L25:
        th = move-exception;
        NpthLog.e(LOG_TAG, "upload exception:" + th);     // Catch: Throwable -> L29
        Runnable r4 = new AnonymousClass4();
    L28:
        DefaultWorkThread.post(r4);
        return;
    L29:
        th = move-exception;
        DefaultWorkThread.post(new AnonymousClass4());
        throw th;
    L6:
        if (NpthCore.isStopUpload() == false) goto L8;
    L24:
        Runnable r5 = new AnonymousClass4();
    L13:
        DefaultWorkThread.post(r5);
        return;
    L8:
        if (App.isMainProcess() == false) goto L24;
        if (sUploadEnd == false) goto L16;
        r5 = new AnonymousClass4();
        goto L13
    L16:
        sUploadEnd = true;     // Catch: Throwable -> L25
        final List<ApplicationExitInfo> r0 = ExitReasonMonitor.parseExitReason();     // Catch: Throwable -> L25
        if (r0 != null) goto L19;
    L23:
        r5 = new AnonymousClass4();
        goto L13
    L19:
        if (r0.size() == 0) goto L23;
        DefaultWorkThread.post(new AnonymousClass3(r0, r3));     // Catch: Throwable -> L25
        r4 = new AnonymousClass4();
        goto L28
    }

    private static void uploadOne(AppMonitor r11, ApplicationExitInfo r12, boolean r13, boolean r14) {
        HashMap r1 = new HashMap();
        final AppExitInfo r2 = AppExitInfo.get(r12);
        boolean r3 = true;
        final long[] r4 = {0};
        new File(mProcDirectory, r2.getProcessName().replace(".", "_").replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "-")).listFiles(new AnonymousClass6(r2, r4));     // Catch: Throwable -> L36
    L5:
        if (r4[0] != 0) goto L7;
        return;
    L7:
        String r6 = r2.getNativeStack(r4[0]);
        r1.put(Constants.EXIT_REASON, r2.getReason());
        r1.put("exit_sub_reason", r2.getSubReason());
        r1.put("exit_description", r2.getDescription());
        r1.put("exit_status", String.valueOf(r2.getStatus()));
        r1.put("exit_pss", AppExitInfoUtils.memValueToRange(r2.getRealPss()));
        r1.put("exit_rss", AppExitInfoUtils.memValueToRange(r2.getRealRss()));
        r1.put("importance", String.valueOf(r2.getImportance()));
        r1.put("has_exit_info", "true");
        if (((String) ZeusTransformUtils.preCheckCast(r1.get(Constants.EXIT_REASON), String.class, "com.obric.memorydata.plugin")).equals("not obtained") == false) goto L10;
    L13:
        if (r3 == true) goto L42;
        JSONObject r5 = r2.toJson(r4[0], r6);
        File r7 = new File(mTerminateHistoryDirectory, "custom_data");     // Catch: Throwable -> L33
        r7.mkdirs();     // Catch: Throwable -> L33
        File r8 = new File(r7, r2.getTimestamp() + "_" + r2.getPid());     // Catch: Throwable -> L33
        if (r8.exists() == true) goto L22;
        r8.mkdirs();     // Catch: Throwable -> L33
    L22:
        dumpActivityInfo(r8, r1, r2, r4[0]);     // Catch: Throwable -> L33
        if (r14 == false) goto L25;
        dumpLogcat(r8, r1);     // Catch: Throwable -> L33
    L25:
        dumpOsMemoryInfo(r8, r1);     // Catch: Throwable -> L33
        if (r13 == false) goto L28;
        dumpAlogInfo(r12, r1);     // Catch: Throwable -> L33
    L28:
        r2.appendFilters(r5, r1);     // Catch: Throwable -> L33
        boolean r15 = killCustomizeExceptionUpload(r11, r2.getTimestamp(), r5, r8);     // Catch: Throwable -> L33
        if (r15 == false) goto L31;
        NpthLog.i("KillInfo ", "upload success:" + r15);     // Catch: Throwable -> L33
        FileSystemUtils.deleteAll(r8);     // Catch: Throwable -> L33
    L31:
        FileSystemUtils.deleteAll(r8);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        NpthLog.w("KillInfo:" + th);
        return;
    L42:
        IApmAgent r16 = (IApmAgent) ZeusTransformUtils.preCheckCast(d.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L37
        if (r16 == null) goto L44;
        r17.put(InfoRequestQPSOptTraceLogger.REASON, r1.get(Constants.EXIT_REASON));     // Catch: Throwable -> L37
        r16.monitorEvent(AppExitInfoUtils.APP_EXIT, r17, null, null);     // Catch: Throwable -> L37
        return;
    L44:
        return;
    L45:
        return;
    L10:
        if (((String) ZeusTransformUtils.preCheckCast(r1.get(Constants.EXIT_REASON), String.class, "com.obric.memorydata.plugin")).equals("USER REQUESTED") == true) goto L13;
        r3 = false;
        goto L13
    }
}
