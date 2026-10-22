package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    public CombineContinuationsWorker(Context r10, WorkerParameters r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "workerParams");
        super(r10, r11);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result r10 = ListenableWorker.Result.success(getInputData());
        Intrinsics.checkNotNullExpressionValue(r10, "success(inputData)");
        return r10;
    }
}
