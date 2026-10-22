package com.obric.aikernel.init.tasks.autoupdate;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoUpdateProcessWakeWorker extends Worker {
    public AutoUpdateProcessWakeWorker(Context r10, WorkerParameters r11) {
        Intrinsics.checkNotNullParameter(r10, "appContext");
        Intrinsics.checkNotNullParameter(r11, "workerParams");
        super(r10, r11);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result r10 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(r10, "success()");
        return r10;
    }
}
