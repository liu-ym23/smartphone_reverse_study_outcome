package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class c<T> extends kotlinx.coroutines.flow.internal.d<T> {
    public final Function2<k<? super T>, Continuation<? super Unit>, Object> d;

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object c(k<? super T> r2, Continuation<? super Unit> r3) {
        Object r4 = this.d.invoke(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r3, int r4, BufferOverflow r5) {
        return new c(this.d, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r2, r3, r4);
        this.d = r1;
    }
}
