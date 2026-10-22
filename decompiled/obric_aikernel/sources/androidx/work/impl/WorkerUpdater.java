package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "WorkerUpdater")
public final class WorkerUpdater {
    public static /* synthetic */ void a(WorkManagerImpl r10, String r11, OperationImpl r12, Function0 r13, WorkRequest r14) {
        enqueueUniquelyNamedPeriodic$lambda$3(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(WorkDatabase r10, WorkSpec r11, WorkSpec r12, List r13, String r14, Set r15, boolean r16) {
        updateWorkImpl$lambda$1(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void c(SettableFuture r10, WorkManagerImpl r11, WorkRequest r12) {
        updateWorkImpl$lambda$2(r10, r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(final WorkManagerImpl r10, final String r11, final WorkRequest r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "workRequest");
        final OperationImpl r13 = new OperationImpl();
        final Function0<Unit> r14 = new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(r12, r10, r11, r13);
        r10.getWorkTaskExecutor().getSerialTaskExecutor().execute(new e(r10, r11, r13, r14, r12));
        return r13;
    }

    private static final void enqueueUniquelyNamedPeriodic$lambda$3(WorkManagerImpl r43, String r44, OperationImpl r45, Function0 r46, WorkRequest r47) {
        Intrinsics.checkNotNullParameter(r43, "$this_enqueueUniquelyNamedPeriodic");
        Intrinsics.checkNotNullParameter(r44, "$name");
        Intrinsics.checkNotNullParameter(r45, "$operation");
        Intrinsics.checkNotNullParameter(r46, "$enqueueNew");
        Intrinsics.checkNotNullParameter(r47, "$workRequest");
        WorkSpecDao r10 = r43.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> r11 = r10.getWorkSpecIdAndStatesForName(r44);
        if (r11.size() <= 1) goto L6;
        failWorkTypeChanged(r45, "Can't apply UPDATE policy to the chains of work.");
        return;
    L6:
        WorkSpec.IdAndState r12 = (WorkSpec.IdAndState) CollectionsKt.firstOrNull(r11);
        if (r12 != null) goto L10;
        r46.invoke();
        return;
    L10:
        WorkSpec r13 = r10.getWorkSpec(r12.id);
        if (r13 != null) goto L15;
        r45.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + r12.id + ", that matches a name \"" + r44 + "\", wasn't found")));
        return;
    L15:
        if (r13.isPeriodic() == true) goto L19;
        failWorkTypeChanged(r45, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
        return;
    L19:
        if (r12.state != WorkInfo.State.CANCELLED) goto L22;
        r10.delete(r12.id);
        r46.invoke();
        return;
    L22:
        WorkSpec r41 = WorkSpec.copy$default(r47.getWorkSpec(), r12.id, null, null, null, null, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, 1048574, null);
        Processor r14 = r43.getProcessor();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r14, "processor");     // Catch: Throwable -> L25
        WorkDatabase r15 = r43.getWorkDatabase();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r15, "workDatabase");     // Catch: Throwable -> L25
        Configuration r16 = r43.getConfiguration();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r16, "configuration");     // Catch: Throwable -> L25
        List<Scheduler> r17 = r43.getSchedulers();     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r17, "schedulers");     // Catch: Throwable -> L25
        updateWorkImpl(r14, r15, r16, r17, r41, r47.getTags());     // Catch: Throwable -> L25
        r45.markState(Operation.SUCCESS);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        r45.markState(new Operation.State.FAILURE(th));
    }

    private static final void failWorkTypeChanged(OperationImpl r10, String r11) {
        r10.markState(new Operation.State.FAILURE(new UnsupportedOperationException(r11)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor r10, final WorkDatabase r11, Configuration r12, final List<? extends Scheduler> r13, final WorkSpec r14, final Set<String> r15) {
        final String r16 = r14.id;
        final WorkSpec r17 = r11.workSpecDao().getWorkSpec(r16);
        if (r17 == null) goto L26;
        if (r17.state.isFinished() == false) goto L9;
        return WorkManager.UpdateResult.NOT_APPLIED;
    L9:
        if ((r17.isPeriodic() ^ r14.isPeriodic()) == true) goto L23;
        final boolean r18 = r10.isEnqueued(r16);
        if (r18 == true) goto L16;
        Iterator<T> r19 = r13.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        ((Scheduler) r19.next()).cancel(r16);
    L16:
        r11.runInTransaction(new d(r11, r14, r17, r13, r16, r15, r18));
        if (r18 == true) goto L19;
        Schedulers.schedule(r12, r11, r13);
    L19:
        if (r18 == false) goto L22;
        return WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN;
    L22:
        return WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    L23:
        WorkerUpdater$updateWorkImpl$type$1 r20 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
        throw new UnsupportedOperationException("Can't update " + r20.invoke(r17) + " Worker to " + r20.invoke(r14) + " Worker. Update operation must preserve worker's type.");
    L26:
        throw new IllegalArgumentException("Worker with " + r16 + " doesn't exist");
    }

    public static final c6.a<WorkManager.UpdateResult> updateWorkImpl(final WorkManagerImpl r10, final WorkRequest r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "workRequest");
        final SettableFuture r12 = SettableFuture.create();
        r10.getWorkTaskExecutor().getSerialTaskExecutor().execute(new f(r12, r10, r11));
        Intrinsics.checkNotNullExpressionValue(r12, "future");
        return r12;
    }

    private static final void updateWorkImpl$lambda$1(WorkDatabase r35, WorkSpec r36, WorkSpec r37, List r38, String r39, Set r40, boolean r41) {
        Intrinsics.checkNotNullParameter(r35, "$workDatabase");
        Intrinsics.checkNotNullParameter(r36, "$newWorkSpec");
        Intrinsics.checkNotNullParameter(r37, "$oldWorkSpec");
        Intrinsics.checkNotNullParameter(r38, "$schedulers");
        Intrinsics.checkNotNullParameter(r39, "$workSpecId");
        Intrinsics.checkNotNullParameter(r40, "$tags");
        WorkSpecDao r13 = r35.workSpecDao();
        WorkTagDao r14 = r35.workTagDao();
        r13.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r38, WorkSpec.copy$default(r36, null, r37.state, null, null, null, null, 0, 0, 0, null, r37.runAttemptCount, null, 0, r37.lastEnqueueTime, 0, 0, false, null, 0, r37.getGeneration() + 1, 515069, null)));
        r14.deleteByWorkSpecId(r39);
        r14.insertTags(r39, r40);
        if (r41 == true) goto L6;
        r13.markWorkSpecScheduled(r39, -1);
        r35.workProgressDao().delete(r39);
        return;
    }

    private static final void updateWorkImpl$lambda$2(SettableFuture r10, WorkManagerImpl r11, WorkRequest r12) {
        Intrinsics.checkNotNullParameter(r11, "$this_updateWorkImpl");
        Intrinsics.checkNotNullParameter(r12, "$workRequest");
        if (r10.isCancelled() == false) goto L10;
        return;
    L10:
        Processor r13 = r11.getProcessor();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r13, "processor");     // Catch: Throwable -> L7
        WorkDatabase r14 = r11.getWorkDatabase();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r14, "workDatabase");     // Catch: Throwable -> L7
        Configuration r15 = r11.getConfiguration();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r15, "configuration");     // Catch: Throwable -> L7
        List<Scheduler> r16 = r11.getSchedulers();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r16, "schedulers");     // Catch: Throwable -> L7
        r10.set(updateWorkImpl(r13, r14, r15, r16, r12.getWorkSpec(), r12.getTags()));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r10.setException(th);
    }
}
