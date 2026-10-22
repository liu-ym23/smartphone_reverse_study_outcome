package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
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

    static /* synthetic */ void access$000(InstallWaitingLock r10) {
        r10.notifyInstallFinish();
    }

    private void notifyInstallFinish() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mHasInstallFinished = true;     // Catch: Throwable -> L8
        this.mLock.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void tryRegisterInstallEvent(Integer r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mHasRegisterEvent.compareAndSet(false, true) == false) goto L14;
        DrLog.d("start register install event");
        BdInstallInstance r11 = (BdInstallInstance) BDInstall.getInstance(String.valueOf(r10));
        r11.addInstallListener(false, new AnonymousClass1(this));
        InstallInfo r12 = r11.getInstallInfo();
        if (r12 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r12.getDid()) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r12.getIid()) == true) goto L17;
        notifyInstallFinish();
        return;
    L17:
        return;
    }

    void reset() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mHasInstallFinished = false;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setRequestingActive(boolean r10) {
        ThreadLocal<Boolean> r11 = this.sIsRequesting;
        if (r10 == false) goto L5;
        r11.set(Boolean.valueOf(r10));
        return;
    L5:
        r11.remove();
    }

    void setRequestingRegister(boolean r10) {
        this.sLoadingOnlineConfig = r10;
        if (r10 == false) goto L5;
        this.sIsRequesting.set(Boolean.valueOf(r10));
        return;
    L5:
        this.sIsRequesting.remove();
        this.sIsOldWayNotWaiting = true;
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    void tryWaitingForInstallFinish(long r10, Integer r11) {
        if (this.sIsRequesting.get() == null) goto L5;
        return;
    L5:
        Object r12 = this.mLock;
        monitor-enter(r12);
        tryRegisterInstallEvent(r11);     // Catch: Throwable -> L15
        if (Looper.myLooper() != ExecutorUtil.getLooper(String.valueOf(r11))) goto L11;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L15
    L11:
        if (this.mHasInstallFinished == true) goto L13;
        this.mLock.wait(r10);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void tryWaitingForInstallFinishInOldWay(Integer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.sIsRequesting.get() != null) goto L34;
        DrLog.d("tryWaitingForInstallFinishWithOldWay");
        Object r11 = this.mLock;
        monitor-enter(r11);
        tryRegisterInstallEvent(r10);     // Catch: Throwable -> L27
        if (this.sIsOldWayNotWaiting == false) goto L13;
        monitor-exit(r11);     // Catch: Throwable -> L27
        return;
    L13:
        if (Looper.myLooper() != ExecutorUtil.getLooper(String.valueOf(r10))) goto L15;
        DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L27
    L15:
        long r12 = 1500;
        if (this.sLoadingOnlineConfig == false) goto L19;
        r12 = 4000;
    L19:
        if (this.mHasInstallFinished == false) goto L31;
    L24:
        this.sIsOldWayNotWaiting = true;     // Catch: Throwable -> L27
        DrLog.d("tryWaitingForInstallFinishWithOldWay finish");     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        return;
    L31:
        this.mLock.wait(r12);     // Catch: InterruptedException -> L22 Throwable -> L27
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }
}
