package com.bytedance.crash.crash;

import androidx.annotation.NonNull;
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

/* JADX INFO: loaded from: classes.dex */
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

    CrashDumper(@NonNull File r10) {
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
        this.mDirectory = r10;
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
        ICrashBodyExtensionDumper r10 = MonitorManager.getAppMonitor().getBodyDumper();
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.mExtension.compareAndSet(false, true) == false) goto L12;
        r10.dump(this.mDirectory);
        return;
    }

    private void dumpGfxInfo() {
        if (this.mGfxInfoLatch.compareAndSet(false, true) == false) goto L6;
        GfxInfo.dump(this.mDirectory);
        return;
    }

    private void dumpJavaInfo(boolean r10, boolean r11, boolean r12) {
        dumpCommonParams();
        dumpLocaleInfo();
        dumpCustomFilter();
        dumpMemoryInfo();
        dumpScraps();
        if (r12 == false) goto L5;
        dumpLooperMessages();
    L5:
        dumpSdkInfo();
        dumpActivityInfo();
        if (r10 == false) goto L8;
        dumpAllStacks();
    L8:
        dumpGfxInfo();
        if (r11 == false) goto L11;
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

    private long dumpNativeInfo(long r10) {
        return NativeBridge.dumpCrashNativeInfo(r10);
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

    static void loadCrashInfo(JSONObject r10, JSONObject r11, File r12) {
        MemoryInfo.pushTo(r10, r12);
        LooperMessageRecorder.load(r10, r12);
        PluginInfoManager.pushTo(r10, r12);
        SdkInfo.pushTo(r10, r12);
        Logcat.pushTo(r10, r12);
        ActivityLifecycle.load(r10, r12);
        JavaStack.pushAllStackTo(r10, r12);
        Scraps.pushTo(r10, r12);
        pushExtension(r10, r11, r12);
        CustomData.pushTo(r10, r12);
    }

    private static void pushExtension(JSONObject r10, JSONObject r11, File r12) {
        AppMonitor r13 = MonitorManager.getAppMonitor();
        if (r13 != null) goto L5;
        return;
    L5:
        ICrashBodyExtensionDumper r14 = r13.getBodyDumper();
        if (r14 == null) goto L9;
        r14.load(r10, r11, r12);
        return;
    }

    private void updateCrashTid(int r10) {
        this.mCrashTid = r10;
    }

    private void updateCrashType(CrashType r10, long r11) {
        if (r11 == 0) goto L10;
        long r12 = this.mCrashTime;
        if (r12 != 0) goto L7;
    L8:
        this.mCrashTime = r11;
        this.mCrashType = r10;
        return;
    L7:
        if (r12 > r11) goto L8;
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

    void dumpCrashInfoFromJava(CrashType r10, long r11, boolean r12, boolean r13) {
        updateCrashType(r10, r11);     // Catch: Throwable -> L4
        dumpJavaInfoAfterNative(dumpNativeInfo(r11), true, r12, r13, 0);     // Catch: Throwable -> L4
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

    void dumpJavaInfoAfterNative(long r10, boolean r11, boolean r12, boolean r13, int r14) {
        updateCrashType(CrashType.NATIVE, r10);
        updateCrashTid(r14);
        dumpJavaInfo(r11, r12, r13);
    }

    void dumpLooperMessages() {
        if (this.mLooperMessagesLatch.compareAndSet(false, true) == false) goto L9;
        LooperMessageRecorder.getInstance().dumpMessages(this.mDirectory);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @NonNull
    File getDirectory() {
        return this.mDirectory;
    }
}
