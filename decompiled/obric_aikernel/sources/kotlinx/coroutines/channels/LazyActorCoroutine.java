package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class LazyActorCoroutine<E> extends a<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Continuation<? super Unit> f10311j;

    public static final /* synthetic */ void l1(LazyActorCoroutine r10, kotlinx.coroutines.selects.k r11, Object r12) {
        r10.m1(r11, r12);
    }

    private final void m1(kotlinx.coroutines.selects.k<?> r10, Object r11) {
        P0();
        super.n().a().invoke(this, r10, r11);
    }

    @Override // kotlinx.coroutines.channels.e, kotlinx.coroutines.channels.n
    public Object E(E r10) {
        start();
        return super.E(r10);
    }

    @Override // kotlinx.coroutines.channels.e, kotlinx.coroutines.channels.n
    public Object H(E r10, Continuation<? super Unit> r11) {
        start();
        Object r12 = super.H(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.c2
    protected void P0() {
        fc.a.b(this.f10311j, this);
    }

    @Override // kotlinx.coroutines.channels.e, kotlinx.coroutines.channels.n
    public kotlinx.coroutines.selects.h<E, n<E>> n() {
        LazyActorCoroutine$onSend$1 r10 = LazyActorCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.i(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3), super.n().d(), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.e, kotlinx.coroutines.channels.n
    public boolean w(Throwable r10) {
        boolean r11 = super.w(r10);
        start();
        return r11;
    }
}
