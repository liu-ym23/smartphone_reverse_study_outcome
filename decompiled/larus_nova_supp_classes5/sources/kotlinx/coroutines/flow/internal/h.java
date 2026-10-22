package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h<T> extends g<T, T> {
    @Override // kotlinx.coroutines.flow.internal.d
    public final Flow<T> e() {
        return (Flow<T>) this.d;
    }

    @Override // kotlinx.coroutines.flow.internal.g
    public final Object g(FlowCollector<? super T> r2, Continuation<? super Unit> r3) {
        Object r4 = this.d.collect(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final d<T> d(CoroutineContext r3, int r4, BufferOverflow r5) {
        return new h(this.d, r3, r4, r5);
    }

    public h(Flow<? extends T> r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r1, r2, r3, r4);
    }

    public h(Flow r2, CoroutineDispatcher r3, int r4, BufferOverflow r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -3;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = BufferOverflow.SUSPEND;
    L11:
        super(r2, r3, r4, r5);
    }
}
