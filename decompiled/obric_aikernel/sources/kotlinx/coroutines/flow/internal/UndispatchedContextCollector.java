package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineContext f10482c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f10483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function2<T, Continuation<? super Unit>, Object> f10484h;

    public UndispatchedContextCollector(kotlinx.coroutines.flow.d<? super T> r10, CoroutineContext r11) {
        this.f10482c = r11;
        this.f10483g = ThreadContextKt.b(r11);
        this.f10484h = new UndispatchedContextCollector$emitRef$1(r10, null);
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        Object r12 = d.c(this.f10482c, r10, this.f10483g, this.f10484h, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
