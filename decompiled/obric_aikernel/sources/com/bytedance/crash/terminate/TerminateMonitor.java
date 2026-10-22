package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c4.d;
import com.bytedance.apm6.util.constant.CommonConsts;
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
import com.bytedance.services.apm.api.IApmAgent;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    static /* synthetic */ void access$000(AppMonitor r10, ApplicationExitInfo r11, boolean r12, boolean r13) {
        uploadOne(r10, r11, r12, r13);
    }

    static /* synthetic */ void access$100() {
        cleanLogcat();
    }

    static /* synthetic */ boolean access$200() {
        return uploadAll;
    }

    static /* synthetic */ boolean access$300(int r10) {
        return isImportantKillHistory(r10);
    }

    static void callExitReasonCallback(List<ApplicationExitInfo> r10) {
        Iterator<IExitReasonListCallback> r11 = callbacks.iterator();     // Catch: Throwable -> L10
    L4:
        if (r11.hasNext() == false) goto L18;
        r11.next().findExitReasons(r10);     // Catch: Throwable -> L9
        goto L4
    L18:
        return;
    }

    static void callExitReasonCallbacks(ApplicationExitInfo r10) {
        Iterator<IExitReasonCallback> r11 = sExitReasonCallbacks.iterator();     // Catch: Throwable -> L10
    L4:
        if (r11.hasNext() == false) goto L18;
        r11.next().findOneExitReason(r10);     // Catch: Throwable -> L9
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
        File[] r10 = mProcProcessDirectory.listFiles(new AnonymousClass7());
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.length <= 20) goto L18;
        Arrays.sort(r10, new AnonymousClass8());
        int r11 = 0;
    L14:
        if (r11 >= (r10.length - 20)) goto L19;
        FileUtils.deleteFile(r10[r11]);
        r11 = r11 + 1;
        goto L14
    L19:
        return;
    }

    public static long decodeWithCatch(String r10, long r11) {
        return Long.decode(r10).longValue();
    L4:
        return r11;
    }

    private static void dumpActivityInfo(File r10, Map<String, String> r11, AppExitInfo r12, long r13) {
        File r14 = ProcessTracker.getInstance().getProcessTrackFile(r12.getProcessName(), r13);     // Catch: Throwable -> L30
        if (r14 != null) goto L6;
    L28:
        r11.put("has_process_track", "false");     // Catch: Throwable -> L30
        return;
    L6:
        if (r14.exists() == false) goto L28;
        File r15 = new File(r10, "process_track.txt");     // Catch: Throwable -> L30
        String r16 = null;
        FileUtils.copyAppend(r14, r15);     // Catch: Throwable -> L24
        r11.put("has_process_track", "true");     // Catch: Throwable -> L24
        BufferedReader r17 = new BufferedReader(new FileReader(r15));     // Catch: Throwable -> L24
    L34:
        String r18 = r17.readLine();     // Catch: Throwable -> L22
        if (r18 == null) goto L15;
        if (r18.contains("onResume") == false) goto L34;
        r16 = r18;
        goto L34
    L15:
        if (r16 == null) goto L21;
        String[] r19 = r16.split(" ", 3);     // Catch: Throwable -> L22
        if (r19.length <= 1) goto L21;
        String r20 = r19[1];     // Catch: Throwable -> L22
        int r21 = r20.indexOf(".onResume");     // Catch: Throwable -> L22
        if (r21 <= 0) goto L21;
        r11.put("scene", r20.substring(0, r21));     // Catch: Throwable -> L22
    L21:
        IoUtil.close(r17);     // Catch: Throwable -> L30
        return;
    L22:
        Throwable th = th;
    L26:
        IoUtil.close(r17);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L24:
        th = move-exception;
        r17 = null;
        th = th;
    L30:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpActivityInfo", th);
    }

    private static void dumpAlogInfo(ApplicationExitInfo r10, Map<String, String> r11) {
        AlogManager.record(r10.getProcessName(), 0, r10.getTimestamp(), CrashType.NATIVE_CUSTOMIZE);     // Catch: Throwable -> L4
        r11.put("has_alog", "true");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthLog.w("KillInfo:" + th);
    }

    private static boolean dumpLogcat(File r10, Map<String, String> r11) {
        Logcat.npthDump(r10, true);     // Catch: Throwable -> L11
        if (Logcat.isLogcatExists(r10) == false) goto L17;
        String r12 = FileUtils.readFile(new File(r10, "logcat.txt"));     // Catch: Throwable -> L11
        mlogcatStr = r12;     // Catch: Throwable -> L11
        if (r12.isEmpty() == false) goto L8;
        return false;
    L8:
        if (mlogcatStr.length() <= 10) goto L19;
        r11.put("has_logcat", "true");     // Catch: Throwable -> L11
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

    private static boolean dumpOsMemoryInfo(File r10, Map<String, String> r11) {
        NativeBridge.dumpMeminfo(r10.getAbsolutePath(), true);     // Catch: IOException -> L15
        File r12 = new File(r10, "os_memory.txt");     // Catch: IOException -> L15
        if (r12.exists() == true) goto L6;
    L13:
        r11.put("has_os_memory", "false");     // Catch: IOException -> L15
        return false;
    L6:
        if (r12.length() <= 10) goto L13;
        String r13 = FileUtils.readFile(r12);     // Catch: IOException -> L15
        if (r13 == null) goto L13;
        if (r13.contains("kB") == false) goto L13;
        r11.put("has_os_memory", "true");     // Catch: IOException -> L15
        return true;
    L15:
        e = move-exception;
        NpthLog.w("KillInfo:" + e);
        return false;
    }

    static void forceStart(final AppMonitor r10, boolean r11, final boolean r12, final boolean r13) {
    L26:
        Runnable r14 = new AnonymousClass2();
    L27:
        DefaultWorkThread.post(r14);
        return;
    L3:
        if (NpthCore.isStopUpload() == false) goto L5;
    L25:
        Runnable r15 = new AnonymousClass2();
    L9:
        DefaultWorkThread.post(r15);
        return;
    L5:
        if (sUploadEnd == true) goto L25;
        if (r10 != null) goto L11;
        r15 = new AnonymousClass2();
        goto L9
    L11:
        init();     // Catch: Throwable -> L26
        if (App.isMainProcess() == true) goto L15;
        r15 = new AnonymousClass2();
        goto L9
    L15:
        sUploadEnd = true;     // Catch: Throwable -> L26
        final List<ApplicationExitInfo> r16 = ExitReasonMonitor.parseExitReason();     // Catch: Throwable -> L26
        if (r16 != null) goto L18;
    L24:
        r15 = new AnonymousClass2();
        goto L9
    L18:
        if (r16.size() == 0) goto L24;
        if (r11 == true) goto L22;
        r15 = new AnonymousClass2();
        goto L9
    L22:
        DefaultWorkThread.post(new AnonymousClass1(r16, r10, r12, r13));     // Catch: Throwable -> L26
        r14 = new AnonymousClass2();
        goto L27
    }

    public static void forceStart(boolean r10, boolean r11, boolean r12) {
        forceStart(MonitorManager.getAppMonitor(), r10, r11, r12);
    }

    public static void forceUploadAll() {
        forceStart(MonitorManager.getAppMonitor(), true, true, true);
    }

    public static void init() {
        if (mInit == false) goto L5;
        return;
    L5:
        File r10 = Global.getRootDirectory();
        if (r10 == null) goto L9;
        mInit = true;
        NpthLog.i("KillInfo", CommonConsts.APM_INNER_EVENT_COST_INIT);
        initFile(r10);
        return;
    }

    private static void initFile(File r10) {
        File r11 = FileSystemUtils.createDirectory(r10, KILL_HISTORY_DIR);
        mTerminateHistoryDirectory = r11;
        mTerminateInfoDirectory = FileSystemUtils.createDirectory(r11, KILL_INFO_PATH);
        mProcDirectory = FileSystemUtils.createDirectory(mTerminateHistoryDirectory, PROC);
        mProcProcessDirectory = FileSystemUtils.createDirectory(mProcDirectory, App.getCurProcessName(Global.getContext()).replace(".", "_").replace(":", "-"));
        new File(mProcProcessDirectory, Process.myPid() + "_" + Global.getAppStartTime()).createNewFile();     // Catch: IOException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        NpthLog.e(e);
        return;
    }

    private static boolean isImportantKillHistory(int r10) {
        if (r10 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r10 >= 300) goto L6;
        return true;
    }

    private static boolean killCustomizeExceptionUpload(AppMonitor r10, long r11, JSONObject r12, File r13) {
        JSONObject r14 = Header.createEventHeader(r10, r11, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).getJson();     // Catch: Exception -> L8
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L8
        JSONArray r16 = new JSONArray();     // Catch: Exception -> L8
        r16.put(r12);     // Catch: Exception -> L8
        r15.put("data", r16);     // Catch: Exception -> L8
        r15.put("header", r14);     // Catch: Exception -> L8
        if (mlogcatStr == null) goto L6;
        JSONArray r17 = new JSONArray();     // Catch: Exception -> L8
        r17.put(mlogcatStr);     // Catch: Exception -> L8
        r15.put(Constants.LOGCAT, r17);     // Catch: Exception -> L8
    L6:
        return CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), r14), r15.toString(), new File[]{r13});
    L8:
        return false;
    }

    public static void put(@NonNull JSONObject r10, @NonNull String r11, @Nullable Object r12) {
        JSONUtils.put(r10, r11, r12);
    }

    public static void registerExitReasonCallback(IExitReasonCallback r10) {
        sExitReasonCallbacks.add(r10);
    }

    public static void registerExitReasonList(IExitReasonListCallback r10) {
        callbacks.add(r10);
    }

    public static void setUploadFlag(boolean r10, boolean r11) {
        uploadAll = r10;
        uploadFG = r11;
    }

    public static void upload(final AppMonitor r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (mInit == false) goto L37;
    L25:
        th = move-exception;
        NpthLog.e(LOG_TAG, "upload exception:" + th);     // Catch: Throwable -> L29
        Runnable r11 = new AnonymousClass4();
    L28:
        DefaultWorkThread.post(r11);
        return;
    L29:
        th = move-exception;
        DefaultWorkThread.post(new AnonymousClass4());
        throw th;
    L6:
        if (NpthCore.isStopUpload() == false) goto L8;
    L24:
        Runnable r12 = new AnonymousClass4();
    L13:
        DefaultWorkThread.post(r12);
        return;
    L8:
        if (App.isMainProcess() == false) goto L24;
        if (sUploadEnd == false) goto L16;
        r12 = new AnonymousClass4();
        goto L13
    L16:
        sUploadEnd = true;     // Catch: Throwable -> L25
        final List<ApplicationExitInfo> r13 = ExitReasonMonitor.parseExitReason();     // Catch: Throwable -> L25
        if (r13 != null) goto L19;
    L23:
        r12 = new AnonymousClass4();
        goto L13
    L19:
        if (r13.size() == 0) goto L23;
        DefaultWorkThread.post(new AnonymousClass3(r13, r10));     // Catch: Throwable -> L25
        r11 = new AnonymousClass4();
        goto L28
    }

    private static void uploadOne(AppMonitor r11, ApplicationExitInfo r12, boolean r13, boolean r14) {
        HashMap r10 = new HashMap();
        final AppExitInfo r15 = AppExitInfo.get(r12);
        boolean r16 = true;
        final long[] r17 = {0};
        new File(mProcDirectory, r15.getProcessName().replace(".", "_").replace(":", "-")).listFiles(new AnonymousClass6(r15, r17));     // Catch: Throwable -> L36
    L5:
        if (r17[0] != 0) goto L7;
        return;
    L7:
        String r18 = r15.getNativeStack(r17[0]);
        r10.put(Constants.EXIT_REASON, r15.getReason());
        r10.put("exit_sub_reason", r15.getSubReason());
        r10.put("exit_description", r15.getDescription());
        r10.put("exit_status", String.valueOf(r15.getStatus()));
        r10.put("exit_pss", AppExitInfoUtils.memValueToRange(r15.getRealPss()));
        r10.put("exit_rss", AppExitInfoUtils.memValueToRange(r15.getRealRss()));
        r10.put("importance", String.valueOf(r15.getImportance()));
        r10.put("has_exit_info", "true");
        if (((String) r10.get(Constants.EXIT_REASON)).equals("not obtained") == false) goto L10;
    L13:
        if (r16 == true) goto L40;
        JSONObject r19 = r15.toJson(r17[0], r18);
        File r20 = new File(mTerminateHistoryDirectory, "custom_data");     // Catch: Throwable -> L33
        r20.mkdirs();     // Catch: Throwable -> L33
        File r21 = new File(r20, r15.getTimestamp() + "_" + r15.getPid());     // Catch: Throwable -> L33
        if (r21.exists() == true) goto L22;
        r21.mkdirs();     // Catch: Throwable -> L33
    L22:
        dumpActivityInfo(r21, r10, r15, r17[0]);     // Catch: Throwable -> L33
        if (r14 == false) goto L25;
        dumpLogcat(r21, r10);     // Catch: Throwable -> L33
    L25:
        dumpOsMemoryInfo(r21, r10);     // Catch: Throwable -> L33
        if (r13 == false) goto L28;
        dumpAlogInfo(r12, r10);     // Catch: Throwable -> L33
    L28:
        r15.appendFilters(r19, r10);     // Catch: Throwable -> L33
        boolean r110 = killCustomizeExceptionUpload(r11, r15.getTimestamp(), r19, r21);     // Catch: Throwable -> L33
        if (r110 == false) goto L31;
        NpthLog.i("KillInfo ", "upload success:" + r110);     // Catch: Throwable -> L33
        FileSystemUtils.deleteAll(r21);     // Catch: Throwable -> L33
    L31:
        FileSystemUtils.deleteAll(r21);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        NpthLog.w("KillInfo:" + th);
        return;
    L40:
        IApmAgent r111 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Throwable -> L37
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L37
        if (r111 == null) goto L44;
        r112.put("reason", r10.get(Constants.EXIT_REASON));     // Catch: Throwable -> L37
        r111.monitorEvent(AppExitInfoUtils.APP_EXIT, r112, null, null);     // Catch: Throwable -> L37
        return;
    L44:
        return;
    L45:
        return;
    L10:
        if (((String) r10.get(Constants.EXIT_REASON)).equals("USER REQUESTED") == true) goto L13;
        r16 = false;
        goto L13
    }
}
