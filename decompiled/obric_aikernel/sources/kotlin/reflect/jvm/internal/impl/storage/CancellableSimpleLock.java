package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CancellableSimpleLock extends DefaultSimpleLock {
    private final Runnable checkCancelled;
    private final Function1<InterruptedException, Unit> interruptedExceptionHandler;

    public CancellableSimpleLock(Runnable r10, Function1<? super InterruptedException, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "checkCancelled");
        Intrinsics.checkNotNullParameter(r11, "interruptedExceptionHandler");
        this(new ReentrantLock(), r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock r10, Runnable r11, Function1<? super InterruptedException, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "lock");
        Intrinsics.checkNotNullParameter(r11, "checkCancelled");
        Intrinsics.checkNotNullParameter(r12, "interruptedExceptionHandler");
        super(r10);
        this.checkCancelled = r11;
        this.interruptedExceptionHandler = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    L9:
    L6:
        e = move-exception;
        this.interruptedExceptionHandler.invoke(e);
        return;
    L3:
        if (getLock().tryLock(50, TimeUnit.MILLISECONDS) == true) goto L13;
        this.checkCancelled.run();     // Catch: InterruptedException -> L6
        goto L9
    }
}
