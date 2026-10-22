package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.g;
import kotlinx.coroutines.selects.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class e0<T> extends a<T> implements Deferred<T> {
    @Override // kotlinx.coroutines.Deferred
    public final T getCompleted() {
        return (T) C();
    }

    @Override // kotlinx.coroutines.Deferred
    public final g<T> getOnAwait() {
        h r0 = H();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return r0;
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object await(Continuation<? super T> r1) {
        Object r2 = q(r1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r2;
    }

    public e0(CoroutineContext r2, boolean r3) {
        super(r2, true, r3);
    }
}
