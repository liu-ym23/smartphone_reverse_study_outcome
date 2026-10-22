package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
class s0<T> extends a<T> implements r0<T> {
    public s0(CoroutineContext r10, boolean r11) {
        super(r10, true, r11);
    }

    static /* synthetic */ <T> Object j1(s0<T> r10, Continuation<? super T> r11) {
        Object r12 = r10.b0(r11);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r12;
    }

    @Override // kotlinx.coroutines.r0
    public T f() {
        return (T) p0();
    }

    @Override // kotlinx.coroutines.r0
    public Object r(Continuation<? super T> r10) {
        return j1(this, r10);
    }
}
