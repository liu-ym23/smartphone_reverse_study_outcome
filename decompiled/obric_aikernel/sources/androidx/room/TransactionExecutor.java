package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(Executor r10) {
        Intrinsics.checkNotNullParameter(r10, "executor");
        this.executor = r10;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    public static /* synthetic */ void a(Runnable r10, TransactionExecutor r11) {
        execute$lambda$1$lambda$0(r10, r11);
    }

    private static final void execute$lambda$1$lambda$0(Runnable r10, TransactionExecutor r11) {
        Intrinsics.checkNotNullParameter(r10, "$command");
        Intrinsics.checkNotNullParameter(r11, "this$0");
        r10.run();     // Catch: Throwable -> L6
        r11.scheduleNext();
        return;
    L6:
        th = move-exception;
        r11.scheduleNext();
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "command");
        Object r11 = this.syncLock;
        monitor-enter(r11);
        this.tasks.offer(new a0(r10, this));     // Catch: Throwable -> L10
        if (this.active != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L10
    L7:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void scheduleNext() {
        Object r10 = this.syncLock;
        monitor-enter(r10);
        Runnable r11 = this.tasks.poll();     // Catch: Throwable -> L10
        Runnable r12 = r11;     // Catch: Throwable -> L10
        this.active = r12;     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        this.executor.execute(r12);     // Catch: Throwable -> L10
    L7:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
