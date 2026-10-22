package hu;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends AbstractExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f17474a;

    public c(Looper r5) {
        this.f17474a = new Handler(r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r5, TimeUnit r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        Handler r10 = this.f17474a;
        if (r10.getLooper() != Looper.myLooper()) goto L5;
        r5.run();
        return;
    L5:
        r10.post(r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
