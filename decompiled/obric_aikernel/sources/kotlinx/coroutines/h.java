package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final <T> r0<T> a(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r13) {
        return j.a(r10, r11, r12, r13);
    }

    public static /* synthetic */ r0 b(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        return j.b(r10, r11, r12, r13, r14, r15);
    }

    public static final v1 c(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r13) {
        return j.c(r10, r11, r12, r13);
    }

    public static /* synthetic */ v1 d(l0 r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        return j.d(r10, r11, r12, r13, r14, r15);
    }

    public static final <T> T e(CoroutineContext r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11) {
        return (T) i.a(r10, r11);
    }

    public static /* synthetic */ Object f(CoroutineContext r10, Function2 r11, int r12, Object r13) {
        return i.b(r10, r11, r12, r13);
    }

    public static final <T> Object g(CoroutineContext r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return j.e(r10, r11, r12);
    }
}
