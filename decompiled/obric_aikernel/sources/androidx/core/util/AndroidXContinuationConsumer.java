package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final Continuation<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXContinuationConsumer(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "continuation");
        super(false);
        this.continuation = r10;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T r10) {
        if (compareAndSet(false, true) == false) goto L6;
        Continuation<T> r11 = this.continuation;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m32constructorimpl(r10));
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
