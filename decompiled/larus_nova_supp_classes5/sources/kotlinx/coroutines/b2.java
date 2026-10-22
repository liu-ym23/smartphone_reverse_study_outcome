package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b2<T> extends x<T> {
    public final ThreadLocal<Pair<CoroutineContext, Object>> e;
    private volatile boolean threadLocalIsSet;

    public final boolean n0() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.e.remove();
        return !r0;
    L5:
        if (this.e.get() != null) goto L7;
        r0 = true;
        goto L8
    }

    public final void k0(Object r6) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair<CoroutineContext, Object> r0 = this.e.get();
        if (r0 == null) goto L7;
        ThreadContextKt.a((CoroutineContext) r0.component1(), r0.component2());
    L7:
        this.e.remove();
    L8:
        Object r7 = v.a(r6);
        Continuation r1 = ((x) this).d;
        CoroutineContext r2 = r1.getContext();
        b2 r3 = null;
        Object r4 = ThreadContextKt.c(r2, null);
        if (r4 == ThreadContextKt.a) goto L23;
        r3 = CoroutineContextKt.d(r1, r2, r4);
    L23:
        ((x) this).d.resumeWith(r7);     // Catch: Throwable -> L17
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r3 != null) goto L14;
    L15:
        ThreadContextKt.a(r2, r4);
        return;
    L14:
        if (r3.n0() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r3 != null) goto L20;
    L21:
        ThreadContextKt.a(r2, r4);
    L22:
        throw th;
    L20:
        if (r3.n0() == false) goto L22;
        goto L21
    }

    public b2(CoroutineContext r3, Continuation<? super T> r4) {
        c2 r0 = c2.a;
        if (r3.get(r0) != null) goto L5;
        CoroutineContext r1 = r3.plus(r0);
    L6:
        super(r1, r4);
        this.e = new ThreadLocal();
        if ((r4.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher) == true) goto L10;
        Object r5 = ThreadContextKt.c(r3, null);
        ThreadContextKt.a(r3, r5);
        q0(r3, r5);
        return;
    L10:
        return;
    L5:
        r1 = r3;
        goto L6
    }

    public final void q0(CoroutineContext r2, Object r3) {
        this.threadLocalIsSet = true;
        this.e.set(TuplesKt.to(r2, r3));
    }
}
