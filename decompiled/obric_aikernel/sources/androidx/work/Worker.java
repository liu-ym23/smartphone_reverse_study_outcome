package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.work.impl.utils.futures.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {
    SettableFuture<ListenableWorker.Result> mFuture;

    public Worker(@NonNull Context r10, @NonNull WorkerParameters r11) {
        super(r10, r11);
    }

    @NonNull
    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @NonNull
    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public c6.a<ForegroundInfo> getForegroundInfoAsync() {
        final SettableFuture r10 = SettableFuture.create();
        getBackgroundExecutor().execute(new AnonymousClass2(this, r10));
        return r10;
    }

    @Override // androidx.work.ListenableWorker
    @NonNull
    public final c6.a<ListenableWorker.Result> startWork() {
        this.mFuture = SettableFuture.create();
        getBackgroundExecutor().execute(new AnonymousClass1(this));
        return this.mFuture;
    }
}
