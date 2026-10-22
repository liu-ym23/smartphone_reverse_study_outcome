package com.obric.cae.location.city;

import android.os.Handler;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.log.CommSenseLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class CityAoiSyncRunner {
    private final ExecutorProvider mExecutorProvider;
    private final Handler mMainHandler;
    private final String mName;
    private final AtomicReference<String> mPendingPreferredCity;
    private final long mRetryDelayMs;
    private final Runnable mRetryRunnable;
    private final AtomicBoolean mRetryScheduled;
    private final SyncAction mSyncAction;
    private final AtomicBoolean mSyncRequested;
    private final AtomicBoolean mSyncScheduled;
    private final String mTag;
    private final AtomicBoolean mWorkInProgress;

    public interface ExecutorProvider {
        ExecutorService getExecutor();
    }

    public interface SyncAction {
        void run(String r8);
    }

    public CityAoiSyncRunner(String r8, String r10, Handler r11, long r12, ExecutorProvider r13, SyncAction r14) {
        this.mPendingPreferredCity = new AtomicReference(null);
        this.mSyncScheduled = new AtomicBoolean(false);
        this.mSyncRequested = new AtomicBoolean(false);
        this.mRetryScheduled = new AtomicBoolean(false);
        this.mWorkInProgress = new AtomicBoolean(false);
        this.mRetryRunnable = new AnonymousClass1(this);
        this.mTag = r8;
        this.mName = r10;
        this.mMainHandler = r11;
        this.mRetryDelayMs = r12;
        this.mExecutorProvider = r13;
        this.mSyncAction = r14;
    }

    public static /* synthetic */ void a(CityAoiSyncRunner r8) {
        r8.drainSyncRequests();
    }

    public static /* synthetic */ AtomicBoolean access$000(CityAoiSyncRunner r8) {
        return r8.mRetryScheduled;
    }

    private void drainSyncRequests() {
    L2:
        int r8 = 0;
        this.mSyncRequested.set(false);     // Catch: Throwable -> L16
        String r10 = this.mPendingPreferredCity.getAndSet(null);     // Catch: Throwable -> L16
        this.mSyncAction.run(r10);     // Catch: Throwable -> L6
    L9:
        if (this.mSyncRequested.get() == true) goto L2;
        this.mSyncScheduled.set(false);
        if (this.mSyncRequested.get() == true) goto L13;
        return;
    L13:
        if (this.mSyncScheduled.compareAndSet(false, true) == false) goto L30;
        this.mExecutorProvider.getExecutor().execute(new k(this, 2));
        return;
    L30:
        return;
    L6:
        th = move-exception;
        CommSenseLog.eWithMethodName(this.mTag, WsConstants.KEY_CONNECTION_ERROR, th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mSyncScheduled.set(false);
        if (this.mSyncRequested.get() == true) goto L20;
    L22:
        throw th;
    L20:
        if (this.mSyncScheduled.compareAndSet(false, true) == false) goto L22;
        this.mExecutorProvider.getExecutor().execute(new a(this, r8));
        goto L22
    }

    public boolean beginWork() {
        if (this.mWorkInProgress.compareAndSet(false, true) == true) goto L6;
        CommSenseLog.dWithMethodName(this.mTag, "skip: add in progress");
        return false;
    L6:
        return true;
    }

    public void destroy() {
        this.mMainHandler.removeCallbacks(this.mRetryRunnable);
        this.mRetryScheduled.set(false);
    }

    public void finishWork() {
        this.mWorkInProgress.set(false);
    }

    public void request(String r8) {
        if (r8 != null) goto L4;
    L6:
        this.mSyncRequested.set(true);
        int r10 = 0;
        if (this.mSyncScheduled.compareAndSet(false, true) == true) goto L10;
        CommSenseLog.dWithMethodName(this.mTag, "skip enqueue: " + this.mName + " sync already scheduled, preferredCity=" + r8);
        return;
    L10:
        this.mExecutorProvider.getExecutor().execute(new a(this, r10));
        return;
    L4:
        if (r8.isEmpty() == true) goto L6;
        this.mPendingPreferredCity.set(r8);
        goto L6
    }

    public void scheduleRetry() {
        if (this.mRetryScheduled.compareAndSet(false, true) == true) goto L6;
        CommSenseLog.dWithMethodName(this.mTag, "skip schedule retry: already scheduled");
        return;
    L6:
        this.mMainHandler.postDelayed(this.mRetryRunnable, this.mRetryDelayMs);
    }
}
