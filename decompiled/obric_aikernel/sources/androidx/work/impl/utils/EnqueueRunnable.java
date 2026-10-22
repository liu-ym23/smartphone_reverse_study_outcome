package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    private static final String TAG = null;
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    static {
        TAG = Logger.tagWithPrefix("EnqueueRunnable");
    }

    public EnqueueRunnable(@NonNull WorkContinuationImpl r10) {
        this(r10, new OperationImpl());
    }

    public EnqueueRunnable(@NonNull WorkContinuationImpl r10, @NonNull OperationImpl r11) {
        this.mWorkContinuation = r10;
        this.mOperation = r11;
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl r10) {
        Set<String> r11 = WorkContinuationImpl.prerequisitesFor(r10);
        boolean r12 = enqueueWorkWithPrerequisites(r10.getWorkManagerImpl(), r10.getWork(), (String[]) r11.toArray(new String[0]), r10.getName(), r10.getExistingWorkPolicy());
        r10.markEnqueued();
        return r12;
    }

    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl r18, @NonNull List<? extends WorkRequest> r19, String[] r20, String r21, ExistingWorkPolicy r22) {
        String[] r10 = r20;
        long r11 = System.currentTimeMillis();
        WorkDatabase r12 = r18.getWorkDatabase();
        boolean r13 = true;
        if (r10 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L26;
        int r15 = r10.length;
        boolean r16 = true;
        int r17 = 0;
        boolean r110 = false;
        boolean r111 = false;
    L10:
        if (r17 >= r15) goto L27;
        String r112 = r10[r17];
        WorkSpec r113 = r12.workSpecDao().getWorkSpec(r112);
        if (r113 == null) goto L13;
        WorkInfo.State r114 = r113.state;
        if (r114 != WorkInfo.State.SUCCEEDED) goto L18;
        boolean r115 = true;
    L19:
        r16 = r16 & r115;
        if (r114 != WorkInfo.State.FAILED) goto L23;
        r111 = true;
    L25:
        r17 = r17 + 1;
        goto L10
    L23:
        if (r114 != WorkInfo.State.CANCELLED) goto L25;
        r110 = true;
        goto L25
    L18:
        r115 = false;
        goto L19
    L13:
        Logger.get().error(TAG, "Prerequisite " + r112 + " doesn't exist; not enqueuing");
        return false;
    L27:
        boolean r23 = !TextUtils.isEmpty(r21);
        if (r23 == false) goto L31;
        if (r14 == true) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == false) goto L86;
        List<WorkSpec.IdAndState> r117 = r12.workSpecDao().getWorkSpecIdAndStatesForName(r21);
        if (r117.isEmpty() == true) goto L86;
        if (r22 != ExistingWorkPolicy.APPEND) goto L38;
    L54:
        DependencyDao r24 = r12.dependencyDao();
        List r118 = new ArrayList();
        Iterator<WorkSpec.IdAndState> r119 = r117.iterator();
    L56:
        if (r119.hasNext() == false) goto L73;
        WorkSpec.IdAndState r25 = r119.next();
        if (r24.hasDependents(r25.id) == true) goto L71;
        WorkInfo.State r26 = r25.state;
        if (r26 != WorkInfo.State.SUCCEEDED) goto L62;
        boolean r27 = true;
    L63:
        boolean r28 = r27 & r16;
        if (r26 != WorkInfo.State.FAILED) goto L67;
        r111 = true;
    L69:
        r118.add(r25.id);
        r16 = r28;
        goto L71
    L67:
        if (r26 != WorkInfo.State.CANCELLED) goto L69;
        r110 = true;
        goto L69
    L62:
        r27 = false;
    L71:
        r24 = r24;
        goto L56
    L73:
        if (r22 != ExistingWorkPolicy.APPEND_OR_REPLACE) goto L81;
        if (r110 == true) goto L76;
        if (r111 == false) goto L81;
    L76:
        WorkSpecDao r29 = r12.workSpecDao();
        Iterator<WorkSpec.IdAndState> r30 = r29.getWorkSpecIdAndStatesForName(r21).iterator();
    L78:
        if (r30.hasNext() == false) goto L80;
        r29.delete(r30.next().id);
        goto L78
    L80:
        r118 = Collections.emptyList();
        r110 = false;
        r111 = false;
    L81:
        r10 = (String[]) r118.toArray(r10);
        if (r10.length <= 0) goto L84;
        r14 = true;
        goto L86
    L84:
        r14 = false;
        goto L86
    L38:
        if (r22 == ExistingWorkPolicy.APPEND_OR_REPLACE) goto L54;
        if (r22 != ExistingWorkPolicy.KEEP) goto L50;
        Iterator<WorkSpec.IdAndState> r31 = r117.iterator();
    L44:
        if (r31.hasNext() == false) goto L50;
        WorkInfo.State r120 = r31.next().state;
        if (r120 == WorkInfo.State.ENQUEUED) goto L49;
        if (r120 != WorkInfo.State.RUNNING) goto L44;
    L49:
        return false;
    L50:
        CancelWorkRunnable.forName(r21, r18, false).run();
        WorkSpecDao r32 = r12.workSpecDao();
        Iterator<WorkSpec.IdAndState> r121 = r117.iterator();
    L52:
        if (r121.hasNext() == false) goto L87;
        r32.delete(r121.next().id);
    L87:
        Iterator<? extends WorkRequest> r33 = r19.iterator();
    L89:
        if (r33.hasNext() == false) goto L112;
        WorkRequest r34 = r33.next();
        WorkSpec r122 = r34.getWorkSpec();
        if (r14 == false) goto L99;
        if (r16 == true) goto L99;
        if (r111 == false) goto L96;
        WorkInfo.State r123 = WorkInfo.State.FAILED;
    L95:
        r122.state = r123;
    L100:
        Iterator<? extends WorkRequest> r124 = r33;
        if (r122.state != WorkInfo.State.ENQUEUED) goto L103;
        r13 = true;
    L103:
        r12.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r18.getSchedulers(), r122));
        if (r14 == false) goto L108;
        int r35 = r10.length;
        int r125 = 0;
    L106:
        if (r125 >= r35) goto L108;
        String[] r126 = r10;
        r12.dependencyDao().insertDependency(new Dependency(r34.getStringId(), r10[r125]));
        r125 = r125 + 1;
        r35 = r35;
        r10 = r126;
    L108:
        String[] r127 = r10;
        r12.workTagDao().insertTags(r34.getStringId(), r34.getTags());
        if (r23 == false) goto L111;
        r12.workNameDao().insert(new WorkName(r21, r34.getStringId()));
    L111:
        r33 = r124;
        r10 = r127;
        goto L89
    L96:
        if (r110 == false) goto L98;
        r123 = WorkInfo.State.CANCELLED;
        goto L95
    L98:
        r123 = WorkInfo.State.BLOCKED;
    L99:
        r122.lastEnqueueTime = r11;
        goto L100
    L112:
        return r13;
    L86:
        r13 = false;
    L31:
        r116 = false;
        goto L32
    L26:
        r16 = true;
        r110 = false;
        r111 = false;
        goto L27
    L5:
        if (r10.length <= 0) goto L7;
        r14 = true;
        goto L8
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl r10) {
        List<WorkContinuationImpl> r11 = r10.getParents();
        boolean r12 = false;
        if (r11 == null) goto L12;
        Iterator<WorkContinuationImpl> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L12;
        WorkContinuationImpl r14 = r13.next();
        if (r14.isEnqueued() == false) goto L9;
        Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", r14.getIds()) + ")");
        goto L6
    L9:
        r12 = r12 | processContinuation(r14);
    L12:
        return enqueueContinuation(r10) | r12;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkDatabase r10 = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        r10.beginTransaction();
        boolean r11 = processContinuation(this.mWorkContinuation);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return r11;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @NonNull
    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
    L10:
        th = move-exception;
        this.mOperation.markState(new Operation.State.FAILURE(th));
        return;
    L3:
        if (this.mWorkContinuation.hasCycles() == true) goto L9;
        if (addToDatabase() == false) goto L7;
        PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);     // Catch: Throwable -> L10
        scheduleWorkInBackground();     // Catch: Throwable -> L10
    L7:
        this.mOperation.markState(Operation.SUCCESS);     // Catch: Throwable -> L10
        return;
    L9:
        throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");     // Catch: Throwable -> L10
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl r10 = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(r10.getConfiguration(), r10.getWorkDatabase(), r10.getSchedulers());
    }
}
