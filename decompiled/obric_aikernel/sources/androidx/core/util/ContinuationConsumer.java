package androidx.core.util;

import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {
    private final Continuation<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(Continuation<? super T> r10) {
        Intrinsics.checkNotNullParameter(r10, "continuation");
        super(false);
        this.continuation = r10;
    }

    @Override // java.util.function.Consumer
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
