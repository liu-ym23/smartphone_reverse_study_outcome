package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkTimer {
    private static final String TAG = null;
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull WorkGenerationalId r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        static final String TAG = "WrkTimerRunnable";
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(@NonNull WorkTimer r10, @NonNull WorkGenerationalId r11) {
            this.mWorkTimer = r10;
            this.mWorkGenerationalId = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = this.mWorkTimer.mLock;
            monitor-enter(r10);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) == null) goto L9;
            TimeLimitExceededListener r11 = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);     // Catch: Throwable -> L12
            if (r11 == null) goto L10;
            r11.onTimeLimitExceeded(this.mWorkGenerationalId);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L9:
            Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", new Object[]{this.mWorkGenerationalId}));     // Catch: Throwable -> L12
            goto L10
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkTimer");
    }

    public WorkTimer(@NonNull RunnableScheduler r10) {
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mRunnableScheduler = r10;
    }

    @NonNull
    @VisibleForTesting
    public Map<WorkGenerationalId, TimeLimitExceededListener> getListeners() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        Map<WorkGenerationalId, TimeLimitExceededListener> r11 = this.mListeners;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    @VisibleForTesting
    public Map<WorkGenerationalId, WorkTimerRunnable> getTimerMap() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        Map<WorkGenerationalId, WorkTimerRunnable> r11 = this.mTimerMap;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public void startTimer(@NonNull WorkGenerationalId r10, long r11, @NonNull TimeLimitExceededListener r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        Logger.get().debug(TAG, "Starting timer for " + r10);     // Catch: Throwable -> L7
        stopTimer(r10);     // Catch: Throwable -> L7
        WorkTimerRunnable r14 = new WorkTimerRunnable(this, r10);     // Catch: Throwable -> L7
        this.mTimerMap.put(r10, r14);     // Catch: Throwable -> L7
        this.mListeners.put(r10, r12);     // Catch: Throwable -> L7
        this.mRunnableScheduler.scheduleWithDelay(r11, r14);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopTimer(@NonNull WorkGenerationalId r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimerMap.remove(r10) == null) goto L7;
        Logger.get().debug(TAG, "Stopping timer for " + r10);     // Catch: Throwable -> L9
        this.mListeners.remove(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }
}
