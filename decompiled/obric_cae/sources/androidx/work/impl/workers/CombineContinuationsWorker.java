package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.l;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    public CombineContinuationsWorker(Context r8, WorkerParameters r10) {
        i.f(r8, "context");
        i.f(r10, "workerParams");
        super(r8, r10);
    }

    @Override // androidx.work.Worker
    public final l.a doWork() {
        return new l.a.c(getInputData());
    }
}
