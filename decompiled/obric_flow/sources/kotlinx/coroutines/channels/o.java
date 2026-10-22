package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i2;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends kotlinx.coroutines.internal.s {
    public final f e;
    public final /* synthetic */ AtomicReferenceArray f;

    public o(long r5, o r10, f r11, int r12) {
        super(r5, r10, r12);
        this.e = r11;
        this.f = new AtomicReferenceArray(g.f18798b * 2);
    }

    @Override // kotlinx.coroutines.internal.s
    public final int g() {
        return g.f18798b;
    }

    @Override // kotlinx.coroutines.internal.s
    public final void h(int r10, CoroutineContext r11) {
        int r5 = g.f18798b;
        if (r10 < r5) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        r10 = r10 - r5;
    L8:
        Object r13 = this.f.get(r10 * 2);
    L9:
        Object r14 = l(r10);
        boolean r15 = r14 instanceof i2;
        f r16 = this.e;
        if (r15 == true) goto L41;
        if ((r14 instanceof z) == true) goto L41;
        if (r14 == g.f18802j) goto L35;
        if (r14 == g.f18803k) goto L35;
        if (r14 == g.g) goto L9;
        if (r14 == g.f) goto L9;
        if (r14 != g.f18801i) goto L27;
        return;
    L27:
        if (r14 != g.d) goto L30;
        return;
    L30:
        if (r14 != g.f18804l) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r14).toString());
    L35:
        n(r10, null);
        if (r12 == false) goto L65;
        Intrinsics.checkNotNull(r16);
        Function1 r17 = r16.f18795b;
        if (r17 == null) goto L66;
        kotlinx.coroutines.internal.f.a(r17, r13, r11);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r12 == false) goto L43;
        g8.g r18 = g.f18802j;
    L45:
        if (k(r10, r14, r18) == false) goto L9;
        n(r10, null);
        m(r10, !r12);
        if (r12 == false) goto L67;
        Intrinsics.checkNotNull(r16);
        Function1 r19 = r16.f18795b;
        if (r19 == null) goto L68;
        kotlinx.coroutines.internal.f.a(r19, r13, r11);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r18 = g.f18803k;
        goto L45
    L5:
        r12 = false;
        goto L6
    }

    public final boolean k(int r5, Object r10, Object r11) {
        AtomicReferenceArray r12 = this.f;
        int r13 = (r5 * 2) + 1;
    L4:
        if (r12.compareAndSet(r13, r10, r11) == true) goto L13;
        if (r12.get(r13) == r10) goto L4;
        return false;
    L13:
        return true;
    }

    public final Object l(int r5) {
        return this.f.get((r5 * 2) + 1);
    }

    public final void m(int r5, boolean r10) {
        if (r10 == false) goto L4;
        f r11 = this.e;
        Intrinsics.checkNotNull(r11);
        r11.O((this.f18950c * g.f18798b) + ((long) r5));
    L4:
        i();
    }

    public final void n(int r5, Object r10) {
        this.f.set(r5 * 2, r10);
    }

    public final void o(int r5, g8.g r10) {
        this.f.set((r5 * 2) + 1, r10);
    }
}
