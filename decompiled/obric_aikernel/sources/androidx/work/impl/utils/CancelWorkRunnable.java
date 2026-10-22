package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CancelWorkRunnable implements Runnable {
    private final OperationImpl mOperation;

    public CancelWorkRunnable() {
        this.mOperation = new OperationImpl();
    }

    @NonNull
    public static CancelWorkRunnable forAll(@NonNull final WorkManagerImpl r10) {
        return new AnonymousClass4(r10);
    }

    @NonNull
    public static CancelWorkRunnable forId(@NonNull final UUID r10, @NonNull final WorkManagerImpl r11) {
        return new AnonymousClass1(r11, r10);
    }

    @NonNull
    public static CancelWorkRunnable forName(@NonNull final String r10, @NonNull final WorkManagerImpl r11, final boolean r12) {
        return new AnonymousClass3(r11, r10, r12);
    }

    @NonNull
    public static CancelWorkRunnable forTag(@NonNull final String r10, @NonNull final WorkManagerImpl r11) {
        return new AnonymousClass2(r11, r10);
    }

    private void iterativelyCancelWorkAndDependents(WorkDatabase r10, String r11) {
        WorkSpecDao r12 = r10.workSpecDao();
        DependencyDao r13 = r10.dependencyDao();
        LinkedList r14 = new LinkedList();
        r14.add(r11);
    L4:
        if (r14.isEmpty() == true) goto L11;
        String r15 = (String) r14.remove();
        WorkInfo.State r16 = r12.getState(r15);
        if (r16 == WorkInfo.State.SUCCEEDED) goto L10;
        if (r16 == WorkInfo.State.FAILED) goto L10;
        r12.setState(WorkInfo.State.CANCELLED, r15);
    L10:
        r14.addAll(r13.getDependentWorkIds(r15));
        goto L4
    }

    void cancel(WorkManagerImpl r10, String r11) {
        iterativelyCancelWorkAndDependents(r10.getWorkDatabase(), r11);
        r10.getProcessor().stopAndCancelWork(r11);
        Iterator<Scheduler> r12 = r10.getSchedulers().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().cancel(r11);
        goto L4
    }

    @NonNull
    public Operation getOperation() {
        return this.mOperation;
    }

    void reschedulePendingWorkers(WorkManagerImpl r10) {
        Schedulers.schedule(r10.getConfiguration(), r10.getWorkDatabase(), r10.getSchedulers());
    }

    @Override // java.lang.Runnable
    public void run() {
        runInternal();     // Catch: Throwable -> L4
        this.mOperation.markState(Operation.SUCCESS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mOperation.markState(new Operation.State.FAILURE(th));
    }

    abstract void runInternal();
}
