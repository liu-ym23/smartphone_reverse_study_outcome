package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final Continuation<R> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(Continuation<? super R> r10) {
        Intrinsics.checkNotNullParameter(r10, "continuation");
        super(false);
        this.continuation = r10;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        if (compareAndSet(false, true) == false) goto L6;
        Continuation<R> r11 = this.continuation;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r10)));
        return;
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        if (compareAndSet(false, true) == false) goto L6;
        Continuation<R> r11 = this.continuation;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m32constructorimpl(r10));
        return;
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
