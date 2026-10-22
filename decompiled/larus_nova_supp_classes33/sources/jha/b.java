package jha;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements CoroutineContext.Element {
    public static final b a = null;
    public static final a b = null;
    public static final ThreadLocal<Boolean> c = null;

    public static final class a implements CoroutineContext.Key<b> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = a.a;
        c = new ThreadLocal();
    }

    public final CoroutineContext.Key<?> getKey() {
        return b;
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
