package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
final class h1<T> implements p1<T>, kotlinx.coroutines.flow.internal.k<T>, kotlinx.coroutines.flow.internal.k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v1 f10461c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ p1<T> f10462g;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(p1<? extends T> r10, v1 r11) {
        this.f10461c = r11;
        this.f10462g = r10;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    public Object a(d<? super T> r10, Continuation<?> r11) {
        return this.f10462g.a(r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public c<T> e(CoroutineContext r10, int r11, BufferOverflow r12) {
        return q1.d(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.p1
    public T getValue() {
        return this.f10462g.getValue();
    }
}
