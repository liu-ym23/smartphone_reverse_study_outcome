package com.bytedance.crash.crash;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.CustomData;
import com.bytedance.crash.dumper.CustomFile;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.GfxInfo;
import com.bytedance.crash.dumper.JavaStack;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.RepairInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.looper.LooperMessageRecorder;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashDumper {
    private final AtomicBoolean mALogLatch;
    private final AtomicBoolean mActivityInfoLatch;
    private final AtomicBoolean mAllStacksLatch;
    private final AtomicBoolean mAppVersion;
    private final AtomicBoolean mCommonParamsLatch;
    private int mCrashTid;
    private long mCrashTime;
    private CrashType mCrashType;
    private final AtomicBoolean mCustomDataLatch;
    private final AtomicBoolean mCustomFileLatch;
    private final AtomicBoolean mCustomFilterLatch;
    private final File mDirectory;
    private final AtomicBoolean mExtension;
    private final AtomicBoolean mGfxInfoLatch;
    private final AtomicBoolean mLocaleInfoLatch;
    private final AtomicBoolean mLooperMessagesLatch;
    private final AtomicBoolean mMemoryInfoLatch;
    private final AtomicBoolean mRepairInfoLatch;
    private final AtomicBoolean mScrapsLatch;
    private final AtomicBoolean mSdkInfoLatch;
    private final AtomicBoolean mViewTreeLatch;

    CrashDumper(File r5) {
        this.mAppVersion = new AtomicBoolean(false);
        this.mCommonParamsLatch = new AtomicBoolean(false);
        this.mLocaleInfoLatch = new AtomicBoolean(false);
        this.mCustomFilterLatch = new AtomicBoolean(false);
        this.mMemoryInfoLatch = new AtomicBoolean(false);
        this.mScrapsLatch = new AtomicBoolean(false);
        this.mLooperMessagesLatch = new AtomicBoolean(false);
        this.mSdkInfoLatch = new AtomicBoolean(false);
        this.mActivityInfoLatch = new AtomicBoolean(false);
        this.mAllStacksLatch = new AtomicBoolean(false);
        this.mGfxInfoLatch = new AtomicBoolean(false);
        this.mRepairInfoLatch = new AtomicBoolean(false);
        this.mViewTreeLatch = new AtomicBoolean(false);
        this.mCustomDataLatch = new AtomicBoolean(false);
        this.mCustomFileLatch = new AtomicBoolean(false);
        this.mALogLatch = new AtomicBoolean(false);
        this.mExtension = new AtomicBoolean(false);
        this.mDirectory = r5;
        this.mCrashTime = 0;
        this.mCrashType = CrashType.UNKNOWN;
        this.mCrashTid = 0;
    }

    private void dumpALog() {
        if (this.mALogLatch.compareAndSet(false, true) == false) goto L6;
        Flavor.dumpAppLog(this.mDirectory);
        return;
    }

    private void dumpActivityInfo() {
        if (this.mActivityInfoLatch.compareAndSet(false, true) == false) goto L6;
        ActivityLifecycle.dump(this.mDirectory);
        return;
    }

    private void dumpAllStacks() {
        if (this.mAllStacksLatch.compareAndSet(false, true) == false) goto L6;
        JavaStack.dumpAllStack(this.mDirectory);
        return;
    }

    private void dumpCustomFile() {
        if (this.mCustomFileLatch.compareAndSet(false, true) == false) goto L6;
        CustomFile.dump(this.mDirectory, this.mCrashType);
        return;
    }

    private void dumpCustomFilter() {
        if (this.mCustomFilterLatch.compareAndSet(false, true) == false) goto L6;
        CustomFilter.dump(this.mDirectory);
        CustomFilter.dumpCustomCrashReason(this.mDirectory);
        return;
    }

    private void dumpExtension() {
        if (MonitorManager.getAppMonitor() != null) goto L5;
        return;
    L5:
        ICrashBodyExtensionDumper r0 = MonitorManager.getAppMonitor().getBodyDumper();
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mExtension.compareAndSet(false, true) == false) goto L12;
        r0.dump(this.mDirectory);
        return;
    }

    private void dumpGfxInfo() {
        if (this.mGfxInfoLatch.compareAndSet(false, true) == false) goto L6;
        GfxInfo.dump(this.mDirectory);
        return;
    }

    private void dumpJavaInfo(boolean r1, boolean r2, boolean r3) {
        dumpCommonParams();
        dumpLocaleInfo();
        dumpCustomFilter();
        dumpMemoryInfo();
        dumpScraps();
        if (r3 == false) goto L5;
        dumpLooperMessages();
    L5:
        dumpSdkInfo();
        dumpActivityInfo();
        if (r1 == false) goto L8;
        dumpAllStacks();
    L8:
        dumpGfxInfo();
        if (r2 == false) goto L11;
        dumpViewTree();
    L11:
        dumpExtension();
        dumpCustomData();
        dumpCustomFile();
        dumpALog();
        dumpRepairInfo();
    }

    private void dumpLocaleInfo() {
        if (this.mLocaleInfoLatch.compareAndSet(false, true) == false) goto L6;
        LocaleInfo.dump(this.mDirectory);
        return;
    }

    private void dumpMemoryInfo() {
        if (this.mMemoryInfoLatch.compareAndSet(false, true) == false) goto L6;
        MemoryInfo.dump(this.mDirectory);
        return;
    }

    private long dumpNativeInfo(long r1) {
        return NativeBridge.dumpCrashNativeInfo(r1);
    }

    private void dumpRepairInfo() {
        if (this.mRepairInfoLatch.compareAndSet(false, true) == false) goto L6;
        RepairInfo.dumpSignalMonitorInfo(this.mDirectory);
        return;
    }

    private void dumpScraps() {
        if (this.mScrapsLatch.compareAndSet(false, true) == false) goto L6;
        Scraps.dump(this.mDirectory);
        return;
    }

    private void dumpSdkInfo() {
        if (this.mSdkInfoLatch.compareAndSet(false, true) == false) goto L6;
        SdkInfo.dump(this.mDirectory);
        return;
    }

    private void dumpViewTree() {
        if (this.mViewTreeLatch.compareAndSet(false, true) == false) goto L6;
        ViewTree.dump(this.mDirectory);
        return;
    }

    static void loadCrashInfo(JSONObject r0, JSONObject r1, File r2) {
        MemoryInfo.pushTo(r0, r2);
        LooperMessageRecorder.load(r0, r2);
        PluginInfoManager.pushTo(r0, r2);
        SdkInfo.pushTo(r0, r2);
        Logcat.pushTo(r0, r2);
        ActivityLifecycle.load(r0, r2);
        JavaStack.pushAllStackTo(r0, r2);
        Scraps.pushTo(r0, r2);
        pushExtension(r0, r1, r2);
        CustomData.pushTo(r0, r2);
    }

    private static void pushExtension(JSONObject r1, JSONObject r2, File r3) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        ICrashBodyExtensionDumper r4 = r0.getBodyDumper();
        if (r4 == null) goto L9;
        r4.load(r1, r2, r3);
        return;
    }

    private void updateCrashTid(int r1) {
        this.mCrashTid = r1;
    }

    private void updateCrashType(CrashType r5, long r6) {
        if (r6 == 0) goto L10;
        long r2 = this.mCrashTime;
        if (r2 != 0) goto L7;
    L8:
        this.mCrashTime = r6;
        this.mCrashType = r5;
        return;
    L7:
        if (r2 > r6) goto L8;
        return;
    }

    void dumpAppVersion() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP", th);
        return;
    L3:
        if (this.mAppVersion.compareAndSet(false, true) == false) goto L11;
        AppVersion.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    void dumpCommonParams() {
    L6:
        th = move-exception;
        NpthMonitor.directReportInnerException("dumpCommonParams", th);
        return;
    L3:
        if (this.mCommonParamsLatch.compareAndSet(false, true) == false) goto L11;
        CommonParamInfo.dump(this.mDirectory);     // Catch: Throwable -> L6
        return;
    }

    void dumpCrashInfoFromJava(CrashType r8, long r9, boolean r11, boolean r12) {
        updateCrashType(r8, r9);     // Catch: Throwable -> L4
        dumpJavaInfoAfterNative(dumpNativeInfo(r9), true, r11, r12, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP", th);
    }

    void dumpCustomData() {
        if (this.mCustomDataLatch.compareAndSet(false, true) == false) goto L6;
        CustomData.dump(this.mDirectory, this.mCrashType, this.mCrashTid);
        return;
    }

    void dumpJavaInfoAfterNative(long r2, boolean r4, boolean r5, boolean r6, int r7) {
        updateCrashType(CrashType.NATIVE, r2);
        updateCrashTid(r7);
        dumpJavaInfo(r4, r5, r6);
    }

    void dumpLooperMessages() {
        if (this.mLooperMessagesLatch.compareAndSet(false, true) == false) goto L9;
        LooperMessageRecorder.getInstance().dumpMessages(this.mDirectory);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    File getDirectory() {
        return this.mDirectory;
    }
}
