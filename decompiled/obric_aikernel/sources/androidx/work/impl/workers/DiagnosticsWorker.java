package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(Context r10, WorkerParameters r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        super(r10, r11);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        WorkManagerImpl r10 = WorkManagerImpl.getInstance(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(r10, "getInstance(applicationContext)");
        WorkDatabase r11 = r10.getWorkDatabase();
        Intrinsics.checkNotNullExpressionValue(r11, "workManager.workDatabase");
        WorkSpecDao r12 = r11.workSpecDao();
        WorkNameDao r13 = r11.workNameDao();
        WorkTagDao r14 = r11.workTagDao();
        SystemIdInfoDao r15 = r11.systemIdInfoDao();
        List<WorkSpec> r16 = r12.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> r17 = r12.getRunningWork();
        List<WorkSpec> r18 = r12.getAllEligibleWorkSpecsForScheduling(200);
        if ((!r16.isEmpty()) == false) goto L6;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Recently completed work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r13, r14, r15, r16));
    L6:
        if ((!r17.isEmpty()) == false) goto L9;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Running work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r13, r14, r15, r17));
    L9:
        if ((!r18.isEmpty()) == false) goto L11;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Enqueued work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r13, r14, r15, r18));
    L11:
        ListenableWorker.Result r19 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(r19, "success()");
        return r19;
    }
}
