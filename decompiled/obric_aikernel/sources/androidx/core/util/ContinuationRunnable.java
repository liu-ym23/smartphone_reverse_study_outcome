package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final Continuation<Unit> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(Continuation<? super Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "continuation");
        super(false);
        this.continuation = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true) == false) goto L6;
        Continuation<Unit> r10 = this.continuation;
        Result.Companion r11 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
