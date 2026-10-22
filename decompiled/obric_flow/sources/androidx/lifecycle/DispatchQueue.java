package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\tH\u0003J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "()V", "finished", "", "isDraining", "paused", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "canRun", "dispatchAndEnqueue", "", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "drainQueue", "enqueue", "finish", "pause", "resume", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused;
    private final Queue<Runnable> queue;

    public DispatchQueue() {
        this.paused = true;
        this.queue = new ArrayDeque();
    }

    public static /* synthetic */ void a(DispatchQueue r5, Runnable r10) {
        dispatchAndEnqueue$lambda$2$lambda$1(r5, r10);
    }

    private static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue r5, Runnable r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$runnable");
        r5.enqueue(r10);
    }

    @MainThread
    private final void enqueue(Runnable r5) {
        if (this.queue.offer(r5) == false) goto L7;
        drainQueue();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    @MainThread
    public final boolean canRun() {
        if (this.finished == false) goto L5;
    L8:
        return true;
    L5:
        if (this.paused == false) goto L8;
        return false;
    }

    @AnyThread
    public final void dispatchAndEnqueue(CoroutineContext r5, Runnable r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "runnable");
        MainCoroutineDispatcher r11 = Dispatchers.getMain().getImmediate();
        if (r11.isDispatchNeeded(r5) == false) goto L5;
    L8:
        r11.dispatch(r5, new a2.b(2, this, r10));
        return;
    L5:
        if (canRun() == true) goto L8;
        enqueue(r10);
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining == false) goto L22;
        return;
    L22:
        this.isDraining = true;     // Catch: Throwable -> L16
    L8:
        if (this.queue.isEmpty() == true) goto L18;
        if (canRun() == false) goto L18;
        Runnable r5 = this.queue.poll();     // Catch: Throwable -> L16
        if (r5 == null) goto L8;
        r5.run();     // Catch: Throwable -> L16
    L18:
        this.isDraining = false;
        return;
    L16:
        th = move-exception;
        this.isDraining = false;
        throw th;
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused == true) goto L6;
        return;
    L6:
        if (this.finished == true) goto L10;
        this.paused = false;
        drainQueue();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher");
    }
}
