package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class p<T> implements FlowCollector<T> {
    public final SendChannel<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public p(SendChannel<? super T> r1) {
        this.a = r1;
    }

    public final Object emit(T r2, Continuation<? super Unit> r3) {
        Object r4 = this.a.send(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
