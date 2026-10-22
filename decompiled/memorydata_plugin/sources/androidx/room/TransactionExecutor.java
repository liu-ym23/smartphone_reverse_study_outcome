package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0006\u0010\r\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/room/TransactionExecutor;", "Ljava/util/concurrent/Executor;", "executor", "(Ljava/util/concurrent/Executor;)V", "active", "Ljava/lang/Runnable;", "syncLock", "", "tasks", "Ljava/util/ArrayDeque;", "execute", "", "command", "scheduleNext", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionExecutor implements Executor {
    private Runnable active;
    private final Executor executor;
    private final Object syncLock;
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "executor");
        this.executor = r4;
        this.tasks = new ArrayDeque();
        this.syncLock = new Object();
    }

    private static final void execute$lambda$1$lambda$0(Runnable r2, TransactionExecutor r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$command");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        r4.run();     // Catch: Throwable -> L6
        r3.scheduleNext();
        return;
    L6:
        th = move-exception;
        r3.scheduleNext();
        throw th;
    }

    public static /* synthetic */ void lambda$AympDHYBb78s7_N_9gRsXF0sHiw(Runnable r0, TransactionExecutor r1) {
        execute$lambda$1$lambda$0(r0, r1);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "command");
        Object r0 = this.syncLock;
        monitor-enter(r0);
        this.tasks.offer(new $$Lambda$TransactionExecutor$AympDHYBb78s7_N_9gRsXF0sHiw(r5, this));     // Catch: Throwable -> L10
        if (this.active != null) goto L7;
        scheduleNext();     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void scheduleNext() {
        Object r0 = this.syncLock;
        monitor-enter(r0);
        Runnable r1 = this.tasks.poll();     // Catch: Throwable -> L10
        Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.active = r2;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        this.executor.execute(r2);     // Catch: Throwable -> L10
    L7:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
