package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class g2 extends kotlinx.coroutines.internal.r {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    public g2(Continuation r5, CoroutineContext r10) {
        h2 r11 = h2.f18923a;
        if (r10.get(r11) != null) goto L5;
        CoroutineContext r12 = r10.plus(r11);
    L6:
        super(r5, r12);
        this.e = new ThreadLocal();
        if ((r5.getContext().get(ContinuationInterceptor.Key) instanceof z) == true) goto L10;
        Object r13 = kotlinx.coroutines.internal.v.c(r10, null);
        kotlinx.coroutines.internal.v.a(r10, r13);
        e0(r10, r13);
        return;
    L10:
        return;
    L5:
        r12 = r10;
        goto L6
    }

    public final boolean d0() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.e.remove();
        return !r5;
    L5:
        if (this.e.get() != null) goto L7;
        r5 = true;
        goto L8
    }

    public final void e0(CoroutineContext r5, Object r10) {
        this.threadLocalIsSet = true;
        this.e.set(TuplesKt.to(r5, r10));
    }

    @Override // kotlinx.coroutines.internal.r, kotlinx.coroutines.r1
    public final void u(Object r10) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair r5 = (Pair) this.e.get();
        if (r5 == null) goto L7;
        kotlinx.coroutines.internal.v.a((CoroutineContext) r5.component1(), r5.component2());
    L7:
        this.e.remove();
    L8:
        Object r11 = w.a(r10);
        Continuation r12 = this.d;
        CoroutineContext r13 = r12.getContext();
        g2 r14 = null;
        Object r15 = kotlinx.coroutines.internal.v.c(r13, null);
        if (r15 == kotlinx.coroutines.internal.v.f18953a) goto L23;
        r14 = x.c(r12, r13, r15);
    L23:
        this.d.resumeWith(r11);     // Catch: Throwable -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r14 != null) goto L14;
    L15:
        kotlinx.coroutines.internal.v.a(r13, r15);
        return;
    L14:
        if (r14.d0() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r14 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.v.a(r13, r15);
    L22:
        throw th;
    L20:
        if (r14.d0() == false) goto L22;
        goto L21
    }
}
