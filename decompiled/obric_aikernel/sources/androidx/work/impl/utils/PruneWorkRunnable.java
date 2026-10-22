package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PruneWorkRunnable implements Runnable {
    private final OperationImpl mOperation;
    private final WorkManagerImpl mWorkManagerImpl;

    public PruneWorkRunnable(@NonNull WorkManagerImpl r10) {
        this.mWorkManagerImpl = r10;
        this.mOperation = new OperationImpl();
    }

    @NonNull
    public Operation getOperation() {
        return this.mOperation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mWorkManagerImpl.getWorkDatabase().workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();     // Catch: Throwable -> L4
        this.mOperation.markState(Operation.SUCCESS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mOperation.markState(new Operation.State.FAILURE(th));
    }
}
