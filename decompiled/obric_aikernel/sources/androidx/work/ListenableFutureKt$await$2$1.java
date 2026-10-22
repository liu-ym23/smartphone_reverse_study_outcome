package androidx.work;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ n<R> $cancellableContinuation;
    final /* synthetic */ c6.a<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(n<? super R> r10, c6.a<R> r11) {
        this.$cancellableContinuation = r10;
        this.$this_await = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Continuation r10 = this.$cancellableContinuation;     // Catch: Throwable -> L4
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L4
        r10.resumeWith(Result.m32constructorimpl(this.$this_await.get()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Throwable r12 = th.getCause();
        if (r12 != null) goto L8;
        r12 = th;
    L8:
        boolean r13 = th instanceof CancellationException;
        n<R> r14 = this.$cancellableContinuation;
        if (r13 == false) goto L11;
        r14.z(r12);
        return;
    L11:
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r12)));
    }
}
