package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class InstallWaitingLock {
    private volatile boolean mHasInstallFinished;
    private final AtomicBoolean mHasRegisterEvent;
    private final Object mLock;
    private volatile boolean sIsOldWayNotWaiting;
    private final ThreadLocal<Boolean> sIsRequesting;
    private volatile boolean sLoadingOnlineConfig;

    InstallWaitingLock() {
        this.mLock = new Object();
        this.mHasInstallFinished = false;
        this.mHasRegisterEvent = new AtomicBoolean(false);
        this.sIsRequesting = new ThreadLocal();
        this.sIsOldWayNotWaiting = false;
        this.sLoadingOnlineConfig = false;
    }

    static /* synthetic */ void access$000(InstallWaitingLock r0) {
        r0.notifyInstallFinish();
    }

    private void notifyInstallFinish() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHasInstallFinished = true;     // Catch: Throwable -> L8
        this.mLock.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void tryRegisterInstallEvent(Integer r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mHasRegisterEvent.compareAndSet(false, true) == false) goto L14;
        DrLog.d("start register install event");
        BdInstallInstance r5 = (BdInstallInstance) ZeusTransformUtils.preCheckCast(BDInstall.getInstance(String.valueOf(r4)), BdInstallInstance.class, "com.obric.memorydata.plugin");
        r5.addInstallListener(false, new AnonymousClass1(this));
        InstallInfo r6 = r5.getInstallInfo();
        if (r6 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r6.getDid()) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r6.getIid()) == true) goto L17;
        notifyInstallFinish();
        return;
    L17:
        return;
    }

    void reset() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHasInstallFinished = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setRequestingActive(boolean r1) {
        ThreadLocal<Boolean> r0 = this.sIsRequesting;
        if (r1 == false) goto L5;
        r0.set(Boolean.valueOf(r1));
        return;
    L5:
        r0.remove();
    }

    void setRequestingRegister(boolean r1) {
        this.sLoadingOnlineConfig = r1;
        if (r1 == false) goto L5;
        this.sIsRequesting.set(Boolean.valueOf(r1));
        return;
    L5:
        this.sIsRequesting.remove();
        this.sIsOldWayNotWaiting = true;
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    void tryWaitingForInstallFinish(long r3, Integer r5) {
        if (this.sIsRequesting.get() == null) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        tryRegisterInstallEvent(r5);     // Catch: Throwable -> L15
        if (Looper.myLooper() != ExecutorUtil.getLooper(String.valueOf(r5))) goto L11;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L15
    L11:
        if (this.mHasInstallFinished == true) goto L13;
        this.mLock.wait(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void tryWaitingForInstallFinishInOldWay(Integer r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.sIsRequesting.get() != null) goto L34;
        DrLog.d("tryWaitingForInstallFinishWithOldWay");
        Object r0 = this.mLock;
        monitor-enter(r0);
        tryRegisterInstallEvent(r4);     // Catch: Throwable -> L27
        if (this.sIsOldWayNotWaiting == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L13:
        if (Looper.myLooper() != ExecutorUtil.getLooper(String.valueOf(r4))) goto L15;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L27
    L15:
        long r1 = 1500;
        if (this.sLoadingOnlineConfig == false) goto L19;
        r1 = WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS;
    L19:
        if (this.mHasInstallFinished == false) goto L31;
    L24:
        this.sIsOldWayNotWaiting = true;     // Catch: Throwable -> L27
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish");     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L31:
        this.mLock.wait(r1);     // Catch: InterruptedException -> L22 Throwable -> L27
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }
}
