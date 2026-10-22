package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayMetCommandHandler implements WorkConstraintsCallback, WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = null;
    private final Context mContext;
    private int mCurrentState;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints;
    private final Object mLock;
    private final Executor mMainThreadExecutor;
    private final Executor mSerialExecutor;
    private final int mStartId;
    private final StartStopToken mToken;

    @Nullable
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;
    private final WorkGenerationalId mWorkGenerationalId;

    static {
        TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    }

    DelayMetCommandHandler(@NonNull Context r10, int r11, @NonNull SystemAlarmDispatcher r12, @NonNull StartStopToken r13) {
        this.mContext = r10;
        this.mStartId = r11;
        this.mDispatcher = r12;
        this.mWorkGenerationalId = r13.getId();
        this.mToken = r13;
        Trackers r14 = r12.getWorkManager().getTrackers();
        this.mSerialExecutor = r12.getTaskExecutor().getSerialTaskExecutor();
        this.mMainThreadExecutor = r12.getTaskExecutor().getMainThreadExecutor();
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(r14, this);
        this.mHasConstraints = false;
        this.mCurrentState = 0;
        this.mLock = new Object();
    }

    public static /* synthetic */ void a(DelayMetCommandHandler r10) {
        r10.startWork();
    }

    public static /* synthetic */ void b(DelayMetCommandHandler r10) {
        r10.stopWork();
    }

    private void cleanUp() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mWorkConstraintsTracker.reset();     // Catch: Throwable -> L11
        this.mDispatcher.getWorkTimer().stopTimer(this.mWorkGenerationalId);     // Catch: Throwable -> L11
        PowerManager.WakeLock r11 = this.mWakeLock;     // Catch: Throwable -> L11
        if (r11 != null) goto L7;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        if (r11.isHeld() == false) goto L9;
        Logger.get().debug(TAG, "Releasing wakelock " + this.mWakeLock + "for WorkSpec " + this.mWorkGenerationalId);     // Catch: Throwable -> L11
        this.mWakeLock.release();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void startWork() {
        if (this.mCurrentState != 0) goto L8;
        this.mCurrentState = 1;
        Logger.get().debug(TAG, "onAllConstraintsMet for " + this.mWorkGenerationalId);
        if (this.mDispatcher.getProcessor().startWork(this.mToken) == false) goto L7;
        this.mDispatcher.getWorkTimer().startTimer(this.mWorkGenerationalId, 600000, this);
        return;
    L7:
        cleanUp();
        return;
    L8:
        Logger.get().debug(TAG, "Already started work for " + this.mWorkGenerationalId);
    }

    private void stopWork() {
        String r10 = this.mWorkGenerationalId.getWorkSpecId();
        if (this.mCurrentState >= 2) goto L8;
        this.mCurrentState = 2;
        Logger r11 = Logger.get();
        String r12 = TAG;
        r11.debug(r12, "Stopping work for WorkSpec " + r10);
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createStopWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
        if (this.mDispatcher.getProcessor().isEnqueued(this.mWorkGenerationalId.getWorkSpecId()) == false) goto L7;
        Logger.get().debug(r12, "WorkSpec " + r10 + " needs to be rescheduled");
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
        return;
    L7:
        Logger.get().debug(r12, "Processor does not have WorkSpec " + r10 + ". No need to reschedule");
        return;
    L8:
        Logger.get().debug(TAG, "Already stopped work for " + r10);
    }

    @WorkerThread
    void handleProcessWork() {
        String r10 = this.mWorkGenerationalId.getWorkSpecId();
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, r10 + " (" + this.mStartId + ")");
        Logger r11 = Logger.get();
        String r12 = TAG;
        r11.debug(r12, "Acquiring wakelock " + this.mWakeLock + "for WorkSpec " + r10);
        this.mWakeLock.acquire();
        WorkSpec r13 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getWorkSpec(r10);
        if (r13 != null) goto L6;
        this.mSerialExecutor.execute(new b(this));
        return;
    L6:
        boolean r14 = r13.hasConstraints();
        this.mHasConstraints = r14;
        if (r14 == true) goto L9;
        Logger.get().debug(r12, "No constraints for " + r10);
        onAllConstraintsMet(Collections.singletonList(r13));
        return;
    L9:
        this.mWorkConstraintsTracker.replace(Collections.singletonList(r13));
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<WorkSpec> r10) {
        Iterator<WorkSpec> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        if (WorkSpecKt.generationalId(r11.next()).equals(this.mWorkGenerationalId) == false) goto L4;
        this.mSerialExecutor.execute(new a(this));
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<WorkSpec> r10) {
        this.mSerialExecutor.execute(new b(this));
    }

    void onExecuted(boolean r10) {
        Logger.get().debug(TAG, "onExecuted " + this.mWorkGenerationalId + ", " + r10);
        cleanUp();
        if (r10 == false) goto L6;
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkGenerationalId), this.mStartId));
    L6:
        if (this.mHasConstraints == false) goto L9;
        this.mMainThreadExecutor.execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, CommandHandler.createConstraintsChangedIntent(this.mContext), this.mStartId));
        return;
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public void onTimeLimitExceeded(@NonNull WorkGenerationalId r10) {
        Logger.get().debug(TAG, "Exceeded time limits on execution for " + r10);
        this.mSerialExecutor.execute(new b(this));
    }
}
