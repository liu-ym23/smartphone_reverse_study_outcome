package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
final class x<T> extends c2 implements w<T> {
    public x(v1 r10) {
        super(true);
        z0(r10);
    }

    @Override // kotlinx.coroutines.w
    public boolean G(Throwable r10) {
        return E0(new b0(r10, false, 2, null));
    }

    @Override // kotlinx.coroutines.w
    public boolean K(T r10) {
        return E0(r10);
    }

    @Override // kotlinx.coroutines.r0
    public T f() {
        return (T) p0();
    }

    @Override // kotlinx.coroutines.r0
    public Object r(Continuation<? super T> r10) {
        Object r11 = b0(r10);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r11;
    }

    @Override // kotlinx.coroutines.c2
    public boolean t0() {
        return true;
    }
}
