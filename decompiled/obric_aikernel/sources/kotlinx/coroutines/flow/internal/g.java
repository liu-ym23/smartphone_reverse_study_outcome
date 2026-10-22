package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements CoroutineContext {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final Throwable f10490c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ CoroutineContext f10491g;

    public g(Throwable r10, CoroutineContext r11) {
        this.f10490c = r10;
        this.f10491g = r11;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
        return (R) this.f10491g.fold(r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r10) {
        return (E) this.f10491g.get(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r10) {
        return this.f10491g.minusKey(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return this.f10491g.plus(r10);
    }
}
