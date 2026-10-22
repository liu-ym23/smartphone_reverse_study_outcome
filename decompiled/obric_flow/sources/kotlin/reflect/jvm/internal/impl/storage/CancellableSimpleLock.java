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

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(Lock r5, Runnable r10, Function1<? super InterruptedException, Unit> r11) {
        Intrinsics.checkNotNullParameter(r5, "lock");
        Intrinsics.checkNotNullParameter(r10, "checkCancelled");
        Intrinsics.checkNotNullParameter(r11, "interruptedExceptionHandler");
        super(r5);
        this.checkCancelled = r10;
        this.interruptedExceptionHandler = r11;
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

    public CancellableSimpleLock(Runnable r5, Function1<? super InterruptedException, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "checkCancelled");
        Intrinsics.checkNotNullParameter(r10, "interruptedExceptionHandler");
        this(new ReentrantLock(), r5, r10);
    }
}
