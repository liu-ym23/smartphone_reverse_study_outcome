package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final class i1<T> extends AbstractFlow<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function2<d<? super T>, Continuation<? super Unit>, Object> f10463c;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(Function2<? super d<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        this.f10463c = r10;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object f(d<? super T> r10, Continuation<? super Unit> r11) {
        Object r12 = this.f10463c.invoke(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
