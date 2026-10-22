package gc;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9097c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CoroutineDispatcher f9098g = null;

    static {
        f9097c = new a();
        f9098g = l.f9118c.limitedParallelism(j0.g("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, j0.a()), 0, 0, 12, null));
    }

    private a() {
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor c0() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        f9098g.dispatch(r10, r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r10, Runnable r11) {
        f9098g.dispatchYield(r10, r11);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        dispatch(EmptyCoroutineContext.INSTANCE, r10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        return l.f9118c.limitedParallelism(r10);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }
}
