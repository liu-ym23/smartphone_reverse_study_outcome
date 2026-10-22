package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,314:1\n1#2:315\n107#3,13:316\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:316,13\n*E\n"})
public final class a3<T> extends kotlinx.coroutines.internal.e0<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ThreadLocal<Pair<CoroutineContext, Object>> f10234j;
    private volatile boolean threadLocalIsSet;

    public a3(CoroutineContext r10, Continuation<? super T> r11) {
        b3 r12 = b3.f10246c;
        if (r10.get(r12) != null) goto L5;
        CoroutineContext r13 = r10.plus(r12);
    L6:
        super(r13, r11);
        this.f10234j = new ThreadLocal();
        if ((r11.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher) == true) goto L10;
        Object r14 = ThreadContextKt.c(r10, null);
        ThreadContextKt.a(r10, r14);
        k1(r10, r14);
        return;
    L10:
        return;
    L5:
        r13 = r10;
        goto L6
    }

    @Override // kotlinx.coroutines.internal.e0, kotlinx.coroutines.a
    protected void f1(Object r10) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair<CoroutineContext, Object> r11 = this.f10234j.get();
        if (r11 == null) goto L7;
        ThreadContextKt.a(r11.component1(), r11.component2());
    L7:
        this.f10234j.remove();
    L8:
        Object r12 = e0.a(r10, this.f10546i);
        Continuation<T> r13 = this.f10546i;
        CoroutineContext r14 = r13.getContext();
        a3<?> r15 = null;
        Object r16 = ThreadContextKt.c(r14, null);
        if (r16 == ThreadContextKt.f10533a) goto L23;
        r15 = CoroutineContextKt.g(r13, r14, r16);
    L23:
        this.f10546i.resumeWith(r12);     // Catch: Throwable -> L17
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r15 != null) goto L14;
    L15:
        ThreadContextKt.a(r14, r16);
        return;
    L14:
        if (r15.j1() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r15 != null) goto L20;
    L21:
        ThreadContextKt.a(r14, r16);
    L22:
        throw th;
    L20:
        if (r15.j1() == false) goto L22;
        goto L21
    }

    public final boolean j1() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f10234j.remove();
        return !r10;
    L5:
        if (this.f10234j.get() != null) goto L7;
        r10 = true;
        goto L8
    }

    public final void k1(CoroutineContext r10, Object r11) {
        this.threadLocalIsSet = true;
        this.f10234j.set(TuplesKt.to(r10, r11));
    }
}
