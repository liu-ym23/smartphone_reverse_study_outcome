package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class s {
    public static final Object a(c<?> r10, Continuation<? super Unit> r11) {
        Object r12 = r10.a(kotlinx.coroutines.flow.internal.m.f10494c, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object b(c<? extends T> r10, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super Unit> r12) {
        Object r13 = e.f(e.c(e.A(r10, r11), 0, null, 2, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object c(d<? super T> r10, c<? extends T> r11, Continuation<? super Unit> r12) {
        e.o(r10);
        Object r13 = r11.a(r10, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
