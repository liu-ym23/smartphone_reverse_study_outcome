package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused;
    private final Queue<Runnable> queue;

    public DispatchQueue() {
        this.paused = true;
        this.queue = new ArrayDeque();
    }

    public static /* synthetic */ void a(DispatchQueue r10, Runnable r11) {
        dispatchAndEnqueue$lambda$2$lambda$1(r10, r11);
    }

    private static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$runnable");
        r10.enqueue(r11);
    }

    @MainThread
    private final void enqueue(Runnable r10) {
        if (this.queue.offer(r10) == false) goto L7;
        drainQueue();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
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
    public final void dispatchAndEnqueue(CoroutineContext r10, final Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "runnable");
        g2 r12 = z0.c().c0();
        if (r12.isDispatchNeeded(r10) == false) goto L5;
    L8:
        r12.dispatch(r10, new c(this, r11));
        return;
    L5:
        if (canRun() == true) goto L8;
        enqueue(r11);
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining == false) goto L21;
        return;
    L21:
        this.isDraining = true;     // Catch: Throwable -> L18
    L8:
        if ((!this.queue.isEmpty()) == false) goto L16;
        if (canRun() == false) goto L16;
        Runnable r10 = this.queue.poll();     // Catch: Throwable -> L18
        if (r10 == null) goto L8;
        r10.run();     // Catch: Throwable -> L18
    L16:
        this.isDraining = false;
        return;
    L18:
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
        if ((!this.finished) == false) goto L10;
        this.paused = false;
        drainQueue();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }
}
