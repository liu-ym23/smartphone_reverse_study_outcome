package androidx.work.impl.workers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import c.b;
import c6.a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future;
    private final Object lock;
    private final WorkerParameters workerParameters;

    public ConstraintTrackingWorker(Context r10, WorkerParameters r11) {
        Intrinsics.checkNotNullParameter(r10, "appContext");
        Intrinsics.checkNotNullParameter(r11, "workerParameters");
        super(r10, r11);
        this.workerParameters = r11;
        this.lock = new Object();
        this.future = SettableFuture.create();
    }

    public static /* synthetic */ void a(ConstraintTrackingWorker r10, a r11) {
        setupAndRunConstraintTrackingWork$lambda$2(r10, r11);
    }

    public static /* synthetic */ void b(ConstraintTrackingWorker r10) {
        startWork$lambda$0(r10);
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (this.future.isCancelled() == false) goto L5;
        return;
    L5:
        String r10 = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
        Logger r11 = Logger.get();
        Intrinsics.checkNotNullExpressionValue(r11, "get()");
        if (r10 != null) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L16;
        r11.error(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
    L14:
        SettableFuture<ListenableWorker.Result> r13 = this.future;
        Intrinsics.checkNotNullExpressionValue(r13, "future");
        ConstraintTrackingWorkerKt.access$setFailed(r13);
        return;
    L16:
        ListenableWorker r14 = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), r10, this.workerParameters);
        this.delegate = r14;
        if (r14 != null) goto L19;
        r11.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "No worker to delegate to.");
        goto L14
    L19:
        WorkManagerImpl r15 = WorkManagerImpl.getInstance(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(r15, "getInstance(applicationContext)");
        WorkSpecDao r16 = r15.getWorkDatabase().workSpecDao();
        String r17 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(r17, "id.toString()");
        WorkSpec r18 = r16.getWorkSpec(r17);
        if (r18 == null) goto L14;
        Trackers r19 = r15.getTrackers();
        Intrinsics.checkNotNullExpressionValue(r19, "workManagerImpl.trackers");
        WorkConstraintsTrackerImpl r20 = new WorkConstraintsTrackerImpl(r19, this);
        r20.replace(CollectionsKt.listOf(r18));
        String r21 = getId().toString();
        Intrinsics.checkNotNullExpressionValue(r21, "id.toString()");
        if (r20.areAllConstraintsMet(r21) == false) goto L39;
        r11.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints met for delegate " + r10);
        ListenableWorker r22 = this.delegate;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L27
        final a<ListenableWorker.Result> r23 = r22.startWork();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r23, "delegate!!.startWork()");     // Catch: Throwable -> L27
        r23.addListener(new b(this, r23), getBackgroundExecutor());     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        r11.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Delegated worker " + r10 + " threw exception in startWork.", th);
        monitor-enter(this.lock);
    L36:
        th = move-exception;
        throw th;
    L31:
        if (this.areConstraintsUnmet == false) goto L33;
        r11.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints were unmet, Retrying.");     // Catch: Throwable -> L36
        SettableFuture<ListenableWorker.Result> r24 = this.future;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r24, "future");     // Catch: Throwable -> L36
        ConstraintTrackingWorkerKt.access$setRetry(r24);     // Catch: Throwable -> L36
        return;
    L33:
        SettableFuture<ListenableWorker.Result> r25 = this.future;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r25, "future");     // Catch: Throwable -> L36
        ConstraintTrackingWorkerKt.access$setFailed(r25);     // Catch: Throwable -> L36
        return;
    L39:
        r11.debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints not met for delegate " + r10 + ". Requesting retry.");
        SettableFuture<ListenableWorker.Result> r26 = this.future;
        Intrinsics.checkNotNullExpressionValue(r26, "future");
        ConstraintTrackingWorkerKt.access$setRetry(r26);
        return;
    L8:
        if (r10.length() == 0) goto L11;
        r12 = false;
        goto L12
    }

    private static final void setupAndRunConstraintTrackingWork$lambda$2(ConstraintTrackingWorker r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$innerFuture");
        Object r12 = r10.lock;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r10.areConstraintsUnmet == false) goto L7;
        SettableFuture<ListenableWorker.Result> r13 = r10.future;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullExpressionValue(r13, "future");     // Catch: Throwable -> L11
        ConstraintTrackingWorkerKt.access$setRetry(r13);     // Catch: Throwable -> L11
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r12);
        return;
    L7:
        r10.future.setFuture(r11);     // Catch: Throwable -> L11
        goto L8
    }

    private static final void startWork$lambda$0(ConstraintTrackingWorker r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.setupAndRunConstraintTrackingWork();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List<WorkSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecs");
        Logger.get().debug(ConstraintTrackingWorkerKt.access$getTAG$p(), "Constraints changed for " + r10);
        Object r11 = this.lock;
        monitor-enter(r11);
        this.areConstraintsUnmet = true;     // Catch: Throwable -> L8
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r11);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker r10 = this.delegate;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isStopped() == true) goto L9;
        r10.stop();
        return;
    }

    @Override // androidx.work.ListenableWorker
    public a<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new c.a(this));
        SettableFuture<ListenableWorker.Result> r10 = this.future;
        Intrinsics.checkNotNullExpressionValue(r10, "future");
        return r10;
    }
}
