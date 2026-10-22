package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 implements CoroutineContext.Element, CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f18923a = null;

    static {
        f18923a = new h2();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final Object fold(Object r5, Function2 r10) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key r5) {
        return CoroutineContext.Element.DefaultImpls.get(this, r5);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key r5) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r5);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r5) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r5);
    }
}
