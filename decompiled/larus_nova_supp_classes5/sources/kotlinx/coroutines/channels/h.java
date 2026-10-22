package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h<E> extends y<h<E>> {
    public final BufferedChannel<E> e;
    public final /* synthetic */ AtomicReferenceArray f;

    public final int g() {
        return e.b;
    }

    public final Object l(int r2) {
        return this.f.get((r2 * 2) + 1);
    }

    public final void h(int r6, CoroutineContext r7) {
        int r0 = e.b;
        if (r6 < r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r6 = r6 - r0;
    L8:
        Object r2 = this.f.get(r6 * 2);
    L9:
        Object r3 = l(r6);
        if ((r3 instanceof d2) == true) goto L41;
        if ((r3 instanceof n) == true) goto L41;
        if (r3 == e.j) goto L35;
        if (r3 == e.k) goto L35;
        if (r3 == e.g) goto L9;
        if (r3 == e.f) goto L9;
        if (r3 != e.i) goto L27;
        return;
    L27:
        if (r3 != e.d) goto L30;
        return;
    L30:
        if (r3 != e.l) goto L33;
        return;
    L33:
        throw new IllegalStateException(("unexpected state: " + r3).toString());
    L35:
        n(r6, null);
        if (r1 == false) goto L65;
        BufferedChannel<E> r8 = this.e;
        Intrinsics.checkNotNull(r8);
        Function1<E, Unit> r9 = r8.b;
        if (r9 == null) goto L66;
        OnUndeliveredElementKt.b(r9, r2, r7);
        return;
    L66:
        return;
    L65:
        return;
    L41:
        if (r1 == false) goto L43;
        b0 r4 = e.j;
    L45:
        if (k(r6, r3, r4) == false) goto L9;
        n(r6, null);
        m(r6, !r1);
        if (r1 == false) goto L67;
        BufferedChannel<E> r10 = this.e;
        Intrinsics.checkNotNull(r10);
        Function1<E, Unit> r11 = r10.b;
        if (r11 == null) goto L68;
        OnUndeliveredElementKt.b(r11, r2, r7);
        return;
    L68:
        return;
    L67:
        return;
    L43:
        r4 = e.k;
        goto L45
    L5:
        r1 = false;
        goto L6
    }

    public final void m(int r5, boolean r6) {
        if (r6 == false) goto L4;
        BufferedChannel<E> r7 = this.e;
        Intrinsics.checkNotNull(r7);
        r7.M((((y) this).c * ((long) e.b)) + ((long) r5));
    L4:
        i();
    }

    public final void n(int r2, Object r3) {
        this.f.set(r2 * 2, r3);
    }

    public final void o(int r2, b0 r3) {
        this.f.set((r2 * 2) + 1, r3);
    }

    public final boolean k(int r4, Object r5, Object r6) {
        AtomicReferenceArray r0 = this.f;
        int r7 = (r4 * 2) + 1;
    L4:
        if (r0.compareAndSet(r7, r5, r6) == true) goto L13;
        if (r0.get(r7) == r5) goto L4;
        return false;
    L13:
        return true;
    }

    public h(long r1, h<E> r3, BufferedChannel<E> r4, int r5) {
        super(r1, r3, r5);
        this.e = r4;
        this.f = new AtomicReferenceArray(e.b * 2);
    }
}
