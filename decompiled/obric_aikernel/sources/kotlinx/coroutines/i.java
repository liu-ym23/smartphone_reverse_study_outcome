package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final /* synthetic */ class i {
    public static final <T> T a(CoroutineContext r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11) {
        Thread r12 = Thread.currentThread();
        ContinuationInterceptor r13 = (ContinuationInterceptor) r10.get(ContinuationInterceptor.Key);
        if (r13 != null) goto L6;
        f1 r14 = s2.f10631a.b();
        n1 r15 = n1.f10613c;
        r10 = r10.plus(r14);
    L19:
        f r16 = new f(CoroutineContextKt.e(r15, r10), r12, r14);
        r16.i1(CoroutineStart.DEFAULT, r16, r11);
        return (T) r16.j1();
    L6:
        f1 r17 = null;
        if ((r13 instanceof f1) == false) goto L9;
        f1 r18 = (f1) r13;
    L10:
        if (r18 != null) goto L12;
    L17:
        r14 = s2.f10631a.a();
    L18:
        r15 = n1.f10613c;
        goto L19
    L12:
        if (r18.n0() == false) goto L14;
        r17 = r18;
    L14:
        if (r17 == null) goto L17;
        r14 = r17;
        goto L18
    L9:
        r18 = null;
        goto L10
    }

    public static /* synthetic */ Object b(CoroutineContext r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        return h.e(r10, r11);
    }
}
