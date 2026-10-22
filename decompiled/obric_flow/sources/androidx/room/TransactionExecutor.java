package androidx.room;

import cn.nubia.neopush.commons.Constant;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/TransactionExecutor;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Executor;)V", Constant.ClientMessageType.ACTIVE, "Ljava/lang/Runnable;", "syncLock", "", "tasks", "Ljava/util/ArrayDeque;", "execute", "", Constant.COMMAND, "scheduleNext", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(Executor r5) {
        Intrinsics.checkNotNullParameter(r5, "executor");
        this.executor = r5;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    public static /* synthetic */ void a(Runnable r5, TransactionExecutor r10) {
        execute$lambda$1$lambda$0(r5, r10);
    }

    private static final void execute$lambda$1$lambda$0(Runnable r5, TransactionExecutor r10) {
        Intrinsics.checkNotNullParameter(r5, "$command");
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r5.run();     // Catch: Throwable -> L6
        r10.scheduleNext();
        return;
    L6:
        th = move-exception;
        r10.scheduleNext();
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.COMMAND);
        Object r10 = this.syncLock;
        monitor-enter(r10);
        this.tasks.offer(new a2.b(5, r5, this));     // Catch: Throwable -> L7
        if (this.active != null) goto L9;
        scheduleNext();     // Catch: Throwable -> L7
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void scheduleNext() {
        Object r5 = this.syncLock;
        monitor-enter(r5);
        Runnable r10 = this.tasks.poll();     // Catch: Throwable -> L7
        Runnable r11 = r10;     // Catch: Throwable -> L7
        this.active = r11;     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        this.executor.execute(r11);     // Catch: Throwable -> L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
