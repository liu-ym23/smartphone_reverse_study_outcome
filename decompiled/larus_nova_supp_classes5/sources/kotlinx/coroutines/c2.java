package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c2 implements CoroutineContext.Element, CoroutineContext.Key<c2> {
    public static final c2 a = null;

    static {
        a = new c2();
    }

    public c2() {
    }

    public final CoroutineContext.Key<?> getKey() {
        return this;
    }

    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, r1);
    }

    public final CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r1);
    }

    public final CoroutineContext plus(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r1);
    }

    public final <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r1, r2);
    }
}
