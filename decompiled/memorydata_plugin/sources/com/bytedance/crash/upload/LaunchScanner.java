package com.bytedance.crash.upload;

import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.NpthLog;

/* JADX INFO: loaded from: classes2.dex */
public final class LaunchScanner implements Runnable {
    private static long delayTime;

    public LaunchScanner() {
    }

    public static void setUploadDelayTime(long r0) {
        delayTime = r0;
    }

    public static void start() {
        NpthLog.i("LaunchScanner start");
        if (App.isMainProcess() == false) goto L6;
        DefaultWorkThread.postDelayed(new LaunchScanner(), 0);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        NpthLog.i("LaunchScanner run");     // Catch: Throwable -> L12
        if (Net.isNetworkAvailable() == false) goto L10;
        NpthLog.i("net available");     // Catch: Throwable -> L12
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        CrashAccessibilityMonitor.getHistoryProcessExitReason();     // Catch: Throwable -> L12
        NpthLog.i("upload crash");     // Catch: Throwable -> L12
        CrashManager.upload(r0, delayTime);     // Catch: Throwable -> L12
        AnrManager.upload(r0, delayTime);     // Catch: Throwable -> L12
        CrashAccessibilityMonitor.upload();     // Catch: Throwable -> L12
        UploadLimits.get().writeUploadTimesFile();     // Catch: Throwable -> L12
        AlogManager.upload(r0);     // Catch: Throwable -> L12
    L7:
        NativeBridge.notifyUploadDone();     // Catch: Throwable -> L12
        if (delayTime <= 0) goto L16;
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), delayTime);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L10:
        NpthLog.i("LaunchScanner, network is unavailable");     // Catch: Throwable -> L12
        NetWorkManager.registerNetAvailableCallback(new AnonymousClass2(this));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        NpthMonitor.reportInnerExceptionWithSpace("NPTH_ANR_ERROR_LaunchScanner", th);
        NpthLog.e(th);
    }
}
