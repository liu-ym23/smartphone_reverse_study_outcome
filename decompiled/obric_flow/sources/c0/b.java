package c0;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f1097b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f1098c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f1099a;

    static {
        f1097b = TimeUnit.SECONDS.toMillis(10);
    }

    public b(ThreadPoolExecutor r5) {
        this.f1099a = r5;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r5, TimeUnit r10) {
        return this.f1099a.awaitTermination(r5, r10);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        this.f1099a.execute(r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection r5) {
        return this.f1099a.invokeAll(r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection r5) {
        return this.f1099a.invokeAny(r5);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f1099a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f1099a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f1099a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f1099a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable r5) {
        return this.f1099a.submit(r5);
    }

    public final String toString() {
        return this.f1099a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection r5, long r10, TimeUnit r11) {
        return this.f1099a.invokeAll(r5, r10, r11);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection r5, long r10, TimeUnit r11) {
        return this.f1099a.invokeAny(r5, r10, r11);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable r5, Object r10) {
        return this.f1099a.submit(r5, r10);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable r5) {
        return this.f1099a.submit(r5);
    }
}
