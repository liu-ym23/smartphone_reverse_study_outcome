package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    private static final String TAG = null;
    private final Set<WorkSpec> mConstrainedWorkSpecs;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("GreedyScheduler");
    }

    public GreedyScheduler(@NonNull Context r10, @NonNull Configuration r11, @NonNull Trackers r12, @NonNull WorkManagerImpl r13) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = r10;
        this.mWorkManagerImpl = r13;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(r12, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, r11.getRunnableScheduler());
        this.mLock = new Object();
    }

    @VisibleForTesting
    public GreedyScheduler(@NonNull Context r10, @NonNull WorkManagerImpl r11, @NonNull WorkConstraintsTracker r12) {
        this.mConstrainedWorkSpecs = new HashSet();
        this.mStartStopTokens = new StartStopTokens();
        this.mContext = r10;
        this.mWorkManagerImpl = r11;
        this.mWorkConstraintsTracker = r12;
        this.mLock = new Object();
    }

    private void checkDefaultProcess() {
        Configuration r10 = this.mWorkManagerImpl.getConfiguration();
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, r10));
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener == true) goto L6;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
        return;
    }

    private void removeConstraintTrackingFor(@NonNull WorkGenerationalId r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        Iterator<WorkSpec> r12 = this.mConstrainedWorkSpecs.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L10;
        WorkSpec r13 = r12.next();     // Catch: Throwable -> L12
        if (WorkSpecKt.generationalId(r13).equals(r10) == false) goto L6;
        Logger.get().debug(TAG, "Stopping tracking for " + r10);     // Catch: Throwable -> L12
        this.mConstrainedWorkSpecs.remove(r13);     // Catch: Throwable -> L12
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String r10) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in non-main process");
        return;
    L9:
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, "Cancelling work ID " + r10);
        DelayedWorkTracker r11 = this.mDelayedWorkTracker;
        if (r11 == null) goto L12;
        r11.unschedule(r10);
    L12:
        Iterator<StartStopToken> r12 = this.mStartStopTokens.remove(r10).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        this.mWorkManagerImpl.stopWork(r12.next());
        goto L14
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<WorkSpec> r10) {
        Iterator<WorkSpec> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        WorkGenerationalId r12 = WorkSpecKt.generationalId(r11.next());
        if (this.mStartStopTokens.contains(r12) == true) goto L4;
        Logger.get().debug(TAG, "Constraints met: Scheduling work ID " + r12);
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r12));
        goto L4
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<WorkSpec> r10) {
        Iterator<WorkSpec> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        WorkGenerationalId r12 = WorkSpecKt.generationalId(r11.next());
        Logger.get().debug(TAG, "Constraints not met: Cancelling work ID " + r12);
        StartStopToken r13 = this.mStartStopTokens.remove(r12);
        if (r13 == null) goto L4;
        this.mWorkManagerImpl.stopWork(r13);
        goto L4
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        this.mStartStopTokens.remove(r10);
        removeConstraintTrackingFor(r10);
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... r12) {
        if (this.mInDefaultProcess != null) goto L6;
        checkDefaultProcess();
    L6:
        if (this.mInDefaultProcess.booleanValue() == true) goto L9;
        Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
        return;
    L9:
        registerExecutionListenerIfNeeded();
        HashSet r10 = new HashSet();
        HashSet r11 = new HashSet();
        int r13 = r12.length;
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L39;
        WorkSpec r15 = r12[r14];
        if (this.mStartStopTokens.contains(WorkSpecKt.generationalId(r15)) == true) goto L38;
        long r16 = r15.calculateNextRunTime();
        long r17 = System.currentTimeMillis();
        if (r15.state != WorkInfo.State.ENQUEUED) goto L38;
        if (r17 >= r16) goto L22;
        DelayedWorkTracker r18 = this.mDelayedWorkTracker;
        if (r18 == null) goto L38;
        r18.schedule(r15);
        goto L38
    L22:
        if (r15.hasConstraints() == false) goto L36;
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 23) goto L30;
        if (r15.constraints.requiresDeviceIdle() == false) goto L30;
        Logger r20 = Logger.get();
        String r21 = TAG;
        StringBuilder r22 = new StringBuilder();
        r22.append("Ignoring ");
        r22.append(r15);
        String r23 = ". Requires device idle.";
    L28:
        r22.append(r23);
        r20.debug(r21, r22.toString());
    L30:
        if (r19 >= 24) goto L32;
    L34:
        r10.add(r15);
        r11.add(r15.id);
        goto L38
    L32:
        if (r15.constraints.hasContentUriTriggers() == false) goto L34;
        r20 = Logger.get();
        r21 = TAG;
        r22 = new StringBuilder();
        r22.append("Ignoring ");
        r22.append(r15);
        r23 = ". Requires ContentUri triggers.";
        goto L28
    L36:
        if (this.mStartStopTokens.contains(WorkSpecKt.generationalId(r15)) == true) goto L38;
        Logger.get().debug(TAG, "Starting work for " + r15.id);
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r15));
    L38:
        r14 = r14 + 1;
        goto L10
    L39:
        Object r110 = this.mLock;
        monitor-enter(r110);
    L46:
        th = move-exception;
        throw th;
    L42:
        if (r10.isEmpty() == true) goto L44;
        String r24 = TextUtils.join(",", r11);     // Catch: Throwable -> L46
        Logger.get().debug(TAG, "Starting tracking for " + r24);     // Catch: Throwable -> L46
        this.mConstrainedWorkSpecs.addAll(r10);     // Catch: Throwable -> L46
        this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);     // Catch: Throwable -> L46
    L44:
        monitor-exit(r110);     // Catch: Throwable -> L46
    }

    @VisibleForTesting
    public void setDelayedWorkTracker(@NonNull DelayedWorkTracker r10) {
        this.mDelayedWorkTracker = r10;
    }
}
