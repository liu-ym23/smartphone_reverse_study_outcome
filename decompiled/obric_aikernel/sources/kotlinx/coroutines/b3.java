package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final class b3 implements CoroutineContext.Element, CoroutineContext.Key<b3> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b3 f10246c = null;

    static {
        f10246c = new b3();
    }

    private b3() {
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r10) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r10) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r10);
    }
}
