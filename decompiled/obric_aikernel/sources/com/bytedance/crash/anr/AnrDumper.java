package com.bytedance.crash.anr;

import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.IPreCrashCallback;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.CustomData;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.GfxInfo;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.ProcessState;
import com.bytedance.crash.dumper.RepairInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AnrDumper {
    private static volatile boolean enableUploadBackgroundANR;
    private static volatile boolean sIsDumpViewTree;
    private final AtomicBoolean mALogLatch;
    private final AtomicBoolean mActivityLifecycleLatch;
    private final AtomicBoolean mAdjDump;
    private JSONArray mAllData;
    private final AtomicBoolean mAnrProfilerLatch;
    private final AtomicBoolean mAnrTraceLatch;
    private final AtomicBoolean mAppVersionLatch;
    private final AtomicBoolean mCallbackLatch;
    private final AtomicBoolean mCommonParamsLatch;
    private final long mCrashTime;
    private final AtomicBoolean mCustomDataLatch;
    private final AtomicBoolean mCustomFileLatch;
    private final AtomicBoolean mCustomFilterLatch;
    private final File mDirectory;
    private final AtomicBoolean mEvilFileLatch;
    private final AtomicBoolean mExtension;
    private final boolean mFromSignal;
    private final AtomicBoolean mGfxInfoLatch;
    private final AtomicBoolean mLocaleInfoLatch;
    private final AtomicBoolean mLooperMessagesLatch;
    private final AtomicBoolean mMainStackLatch;
    private final AtomicBoolean mMemoryInfoLatch;
    private final long mNativeDumper;
    private boolean mNativeInfoDumped;
    private final AtomicBoolean mProcessStateLatch;
    private final AtomicBoolean mRepairInfoLatch;
    private final AtomicBoolean mScrapsLatch;
    private final AtomicBoolean mSdkInfoLatch;
    private final AtomicBoolean mSummaryLatch;
    private final AtomicBoolean mViewTreeLatch;

    public static class ConfigDump {
        private static final String KEY_TIME = "init_sub_launch_time";
        private static final String KEY_TIME_RANGE = "npth_init_sub_launch_range";

        public ConfigDump() {
        }

        public static void dump(File r10, int r11) {
            JsonDumper r12 = new JsonDumper(r10.getAbsolutePath() + "/anr_config.txt");
            r12.objectBegin();
            r12.key(Constants.PROCESS_ADJ);
            r12.value(r11);
            r12.next();
            r12.key("enable_upload_bg_anr");
            r12.value(AnrDumper.access$200());
            r12.next();
            r12.key("enable_new_anr");
            r12.value(GlobalSwitch.isOpenNewAnrMonitor());
            if (Build.VERSION.SDK_INT < 24) goto L5;
            long r13 = Global.getInitElapsedRealtime() - Process.getStartElapsedRealtime();
            r12.next();
            r12.key(KEY_TIME);
            r12.value(r13);
        L5:
            r12.objectEnd();
            r12.release();
        }

        public static void push(File r10, JSONObject r11) {
            String r12 = FileSystemUtils.readUtf8File(new File(r10, "anr_config.txt"));
            if (r12 == null) goto L39;
            JSONObject r13 = null;
            r13 = new JSONObject(r12);     // Catch: Throwable -> L31
        L7:
            if (r13 != null) goto L37;
            return;
        L37:
            int r14 = r13.optInt(Constants.PROCESS_ADJ, -1);     // Catch: Throwable -> L32
            if (r14 < 200) goto L12;
        L14:
            boolean r15 = false;
        L15:
            if (r14 < 0) goto L35;
            r11.put("is_background_v1", String.valueOf(r15));     // Catch: Throwable -> L32
            goto L35
        L12:
            if (new File(r10, "background_v2").exists() == false) goto L14;
            r15 = true;
        L35:
        L27:
            e = move-exception;
            NpthLog.i(e);
        L29:
            JSONUtils.combineJson(r11, r13);
            return;
        L18:
            if (r13.has(KEY_TIME) == false) goto L29;
            long r16 = r13.getLong(KEY_TIME) / 1000;     // Catch: Exception -> L27
            if (r16 <= 0) goto L24;
            String r17 = r16 + "~" + (r16 + 1);     // Catch: Exception -> L27
        L23:
            r11.put(KEY_TIME_RANGE, r17);     // Catch: Exception -> L27
            r13.remove(KEY_TIME);     // Catch: Exception -> L27
            goto L29
        L24:
            r17 = "<1";
            goto L23
        }
    }

    private AnrDumper(File r10, long r11, boolean r12) {
        this.mSummaryLatch = new AtomicBoolean(false);
        this.mAdjDump = new AtomicBoolean(false);
        this.mMainStackLatch = new AtomicBoolean(false);
        this.mAppVersionLatch = new AtomicBoolean(false);
        this.mCommonParamsLatch = new AtomicBoolean(false);
        this.mAnrProfilerLatch = new AtomicBoolean(false);
        this.mProcessStateLatch = new AtomicBoolean(false);
        this.mLooperMessagesLatch = new AtomicBoolean(false);
        this.mAnrTraceLatch = new AtomicBoolean(false);
        this.mLocaleInfoLatch = new AtomicBoolean(false);
        this.mCustomFilterLatch = new AtomicBoolean(false);
        this.mMemoryInfoLatch = new AtomicBoolean(false);
        this.mScrapsLatch = new AtomicBoolean(false);
        this.mSdkInfoLatch = new AtomicBoolean(false);
        this.mActivityLifecycleLatch = new AtomicBoolean(false);
        this.mGfxInfoLatch = new AtomicBoolean(false);
        this.mRepairInfoLatch = new AtomicBoolean(false);
        this.mViewTreeLatch = new AtomicBoolean(false);
        this.mCustomDataLatch = new AtomicBoolean(false);
        this.mCustomFileLatch = new AtomicBoolean(false);
        this.mEvilFileLatch = new AtomicBoolean(false);
        this.mALogLatch = new AtomicBoolean(false);
        this.mNativeInfoDumped = false;
        this.mExtension = new AtomicBoolean(false);
        this.mCallbackLatch = new AtomicBoolean(false);
        this.mDirectory = r10;
        this.mCrashTime = r11;
        this.mFromSignal = r12;
        this.mNativeDumper = NativeBridge.anrDumperNativeInit(r10.getAbsolutePath());
    }

    static /* synthetic */ AtomicBoolean access$000(AnrDumper r10) {
        return r10.mLooperMessagesLatch;
    }

    static /* synthetic */ File access$100(AnrDumper r10) {
        return r10.mDirectory;
    }

    static /* synthetic */ boolean access$200() {
        return enableUploadBackgroundANR;
    }

    public static AnrDumper create(File r10, long r11, boolean r12) {
        return new AnrDumper(r10, r11, r12);
    }

    private void dumpALog() {
        if (this.mALogLatch.compareAndSet(false, true) == false) goto L9;
        Flavor.dumpAppLog(this.mDirectory);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private void dumpActivityLifecycle() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpActivityLifecycle", th);
        return;
    L3:
        if (this.mActivityLifecycleLatch.compareAndSet(false, true) == false) goto L11;
        ActivityLifecycle.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpAdj(int r10) {
    L8:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpAdj", th);
        return;
    L3:
        if (this.mAdjDump.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r10 == Integer.MAX_VALUE) goto L14;
        ConfigDump.dump(this.mDirectory, r10);     // Catch: Throwable -> L8
        return;
    }

    private void dumpAfterTrace(int r10) {
        if (AnrManager.isDumpData() == true) goto L5;
        return;
    L5:
        dumpAdj(r10);
        dumpEvilMethodFile();
        dumpLooperMessages(false);
        dumpNativeInfo();
        dumpCommonParams();
        dumpMemoryInfo();
        dumpLocaleInfo();
        dumpCustomFilter();
        dumpScraps();
        dumpSdkInfo();
        dumpActivityLifecycle();
        dumpGfxInfo();
        dumpViewTree();
        dumpExtension();
        dumpALog();
        dumpCustomData();
        dumpCustomFile();
        dumpRepairInfo();
    }

    private void dumpAnrAllThreadTrace() {
        if (AnrManager.isDumpData() == false) goto L15;
    L10:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpAnrTrace", th);
        return;
    L5:
        if (this.mAnrTraceLatch.compareAndSet(false, true) == true) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L17;
        NativeBridge.anrDumpTrace(AnrTraceParser.getTraceFile(this.mDirectory).getAbsolutePath());     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    private void dumpAppVersion() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpAppVersion", th);
        return;
    L3:
        if (this.mAppVersionLatch.compareAndSet(false, true) == false) goto L11;
        AppVersion.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpBeforeTrace(int r10) {
        dumpSummary(r10);
        dumpAppVersion();
        dumpProfileInfoAndNativeInfo();
        dumpProcessState();
        dumpLooperMessages(true);
    }

    private void dumpCommonParams() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCommonParams", th);
        return;
    L3:
        if (this.mCommonParamsLatch.compareAndSet(false, true) == false) goto L11;
        CommonParamInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpCustomData() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCustomData", th);
        return;
    L3:
        if (this.mCustomDataLatch.compareAndSet(false, true) == false) goto L11;
        CustomData.dump(this.mDirectory, CrashType.ANR, 0);     // Catch: Throwable -> L6
        return;
    }

    private void dumpCustomFile() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCustomFile", th);
        return;
    L3:
        if (this.mCustomFileLatch.compareAndSet(false, true) == false) goto L11;
        CustomFile.dump(this.mDirectory, CrashType.ANR);     // Catch: Throwable -> L6
        return;
    }

    private void dumpCustomFilter() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCustomFilter", th);
        return;
    L3:
        if (this.mCustomFilterLatch.compareAndSet(false, true) == false) goto L11;
        CustomFilter.dump(this.mDirectory);     // Catch: Throwable -> L6
        CustomFilter.dumpCustomCrashReason(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpEvilMethodFile() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCustomFile", th);
        return;
    L3:
        if (this.mEvilFileLatch.compareAndSet(false, true) == false) goto L11;
        EvilDumpFile.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpExtension() {
        if (MonitorManager.getAppMonitor() != null) goto L5;
        return;
    L5:
        ICrashBodyExtensionDumper r10 = MonitorManager.getAppMonitor().getBodyDumper();     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.mExtension.compareAndSet(false, true) == false) goto L15;
        r10.dump(this.mDirectory);     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    private void dumpGfxInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpGfxInfo", th);
        return;
    L3:
        if (this.mGfxInfoLatch.compareAndSet(false, true) == false) goto L11;
        GfxInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpLocaleInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpLocaleInfo", th);
        return;
    L3:
        if (this.mLocaleInfoLatch.compareAndSet(false, true) == false) goto L11;
        LocaleInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpLooperMessages(boolean r10) {
        if (r10 == false) goto L11;
        DefaultWorkThread.post(new AnonymousClass1(this));
        return;
    L11:
    L8:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpLooperMessages", th);
        return;
    L5:
        if (this.mLooperMessagesLatch.compareAndSet(false, true) == false) goto L14;
        LooperMessageRecorder.getInstance().dumpMessages(this.mDirectory);     // Catch: Throwable -> L8
        return;
    }

    private void dumpMainStack() {
    L8:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpMainStack", th);
        return;
    L3:
        if (AnrManager.isDumpData() == true) goto L5;
        return;
    L5:
        if (this.mMainStackLatch.compareAndSet(false, true) == false) goto L14;
        JavaStack.StackResult r10 = JavaStack.dumpMainStack(this.mDirectory);     // Catch: Throwable -> L8
        this.mAllData = Flavor.Tob.saveAllData(CrashType.ANR, r10.getStackTraceElements(), this.mDirectory);     // Catch: Throwable -> L8
        return;
    }

    private void dumpMemoryInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpMemoryInfo", th);
        return;
    L3:
        if (this.mMemoryInfoLatch.compareAndSet(false, true) == false) goto L11;
        MemoryInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpNativeInfo() {
        if (this.mNativeInfoDumped == true) goto L6;
        NativeBridge.anrDumpNativeInfo(this.mNativeDumper);
        this.mNativeInfoDumped = true;
        return;
    }

    private void dumpProcessState() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpProfileInfo", th);
        return;
    L3:
        if (this.mProcessStateLatch.compareAndSet(false, true) == false) goto L11;
        ProcessState.getInstance().dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpProfileInfoAndNativeInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpProfileInfo", th);
        return;
    L3:
        if (this.mAnrProfilerLatch.compareAndSet(false, true) == false) goto L11;
        AnrManager.dumpProfilerWithNativeInfo(this.mDirectory, this.mNativeDumper);     // Catch: Throwable -> L6
        return;
    }

    private void dumpRepairInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpRepairInfo", th);
        return;
    L3:
        if (this.mRepairInfoLatch.compareAndSet(false, true) == false) goto L11;
        RepairInfo.dumpSignalMonitorInfo(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpScraps() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpScraps", th);
        return;
    L3:
        if (this.mScrapsLatch.compareAndSet(false, true) == false) goto L11;
        Scraps.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpSdkInfo() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpSdkInfo", th);
        return;
    L3:
        if (this.mSdkInfoLatch.compareAndSet(false, true) == false) goto L11;
        SdkInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    private void dumpSummary(int r10) {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpSummary", th);
        return;
    L3:
        if (this.mSummaryLatch.compareAndSet(false, true) == false) goto L11;
        AnrSummary.dump(this.mDirectory, this.mCrashTime, this.mFromSignal, r10);     // Catch: Throwable -> L6
        return;
    }

    private void dumpTrace() {
        dumpMainStack();
        dumpAnrAllThreadTrace();
    }

    private void dumpViewTree() {
        if (sIsDumpViewTree == false) goto L13;
    L8:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpViewTree", th);
        return;
    L5:
        if (this.mViewTreeLatch.compareAndSet(false, true) == false) goto L14;
        ViewTree.dump(this.mDirectory);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    }

    static void loadCrashInfo(JSONObject r10, JSONObject r11, File r12) {
        MemoryInfo.pushTo(r10, r12);
        LooperMessageRecorder.load(r10, r12);
        if (r12 == null) goto L5;
        PluginInfoManager.pushTo(r10, r12.getParentFile());
    L5:
        SdkInfo.pushTo(r10, r12);
        Logcat.pushTo(r10, r12);
        ActivityLifecycle.load(r10, r12);
        Scraps.pushTo(r10, r12);
        CustomData.pushTo(r10, r12);
        loadExtension(r10, r11, r12);
    }

    private static void loadExtension(JSONObject r10, JSONObject r11, File r12) {
        AppMonitor r13 = MonitorManager.getAppMonitor();
        if (r13 != null) goto L5;
        return;
    L5:
        ICrashBodyExtensionDumper r14 = r13.getBodyDumper();
        if (r14 == null) goto L9;
        r14.load(r10, r11, r12);
        return;
    }

    public static void setDumpViewTreeEnable(boolean r10) {
        sIsDumpViewTree = r10;
    }

    public static void setUploadBackgroundANR(boolean r10) {
        enableUploadBackgroundANR = r10;
    }

    JSONArray dumpAllInfo(int r10, int r11) {
        if (AnrManager.isDropData() == false) goto L6;
        return null;
    L6:
        dumpBeforeTrace(r11);
        handleCallback();
        dumpTrace();
        dumpAfterTrace(r10);
        return this.mAllData;
    }

    protected void finalize() {
        NativeBridge.anrDumpNativeRelease(this.mNativeDumper);
    }

    public void handleCallback() {
        if (this.mCallbackLatch.compareAndSet(false, true) == false) goto L13;
        AppMonitor r10 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L15
        if (r10 != null) goto L7;
        return;
    L7:
        Iterator<IPreCrashCallback> r11 = r10.getUserDataCenter().getPreCrashCallback(CrashType.ANR).iterator();     // Catch: Throwable -> L15
    L9:
        if (r11.hasNext() == false) goto L24;
        IPreCrashCallback r12 = r11.next();     // Catch: Throwable -> L15
        r12.onCrash(CrashType.ANR, this.mCrashTime);     // Catch: Throwable -> L14
        goto L9
    L24:
        return;
    L13:
        return;
    }
}
