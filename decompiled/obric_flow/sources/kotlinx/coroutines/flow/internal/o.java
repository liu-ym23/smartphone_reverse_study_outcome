package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements CoroutineContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f18878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f18879b;

    public o(Throwable r5, CoroutineContext r10) {
        this.f18878a = r10;
        this.f18879b = r5;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object r5, Function2 r10) {
        return this.f18878a.fold(r5, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key r5) {
        return this.f18878a.get(r5);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key r5) {
        return this.f18878a.minusKey(r5);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r5) {
        return this.f18878a.plus(r5);
    }
}
