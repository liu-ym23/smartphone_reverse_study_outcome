package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p<T> implements kotlinx.coroutines.flow.d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.channels.n<T> f10498c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(kotlinx.coroutines.channels.n<? super T> r10) {
        this.f10498c = r10;
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        Object r12 = this.f10498c.H(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
