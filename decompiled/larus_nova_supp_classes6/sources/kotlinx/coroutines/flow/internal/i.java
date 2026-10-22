package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i implements CoroutineContext {
    public final Throwable a;
    public final /* synthetic */ CoroutineContext b;

    public final <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r3) {
        return (R) this.b.fold(r2, r3);
    }

    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r2) {
        return (E) this.b.get(r2);
    }

    public final CoroutineContext minusKey(CoroutineContext.Key<?> r2) {
        return this.b.minusKey(r2);
    }

    public final CoroutineContext plus(CoroutineContext r2) {
        return this.b.plus(r2);
    }

    public i(Throwable r1, CoroutineContext r2) {
        this.a = r1;
        this.b = r2;
    }
}
