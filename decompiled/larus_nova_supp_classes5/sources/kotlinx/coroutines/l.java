package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l {
    public static final <T> j<T> a(Continuation<? super T> r9) {
        boolean r1 = true;
        if ((r9 instanceof i) == false) goto L5;
        i r0 = (i) r9;
        r0.getClass();
        AtomicReferenceFieldUpdater r2 = i.h;
    L7:
        Object r3 = r2.get(r0);
        j<T> r5 = null;
        if (r3 == null) goto L9;
        if ((r3 instanceof j) == true) goto L12;
        if (r3 == j.b) goto L7;
        if ((r3 instanceof Throwable) == true) goto L7;
        throw new IllegalStateException(("Inconsistent state " + r3).toString());
    L12:
        AtomicReferenceFieldUpdater r6 = i.h;
        b0 r7 = j.b;
    L14:
        if (r6.compareAndSet(r0, r3, r7) == true) goto L15;
        if (r6.get(r0) == r3) goto L14;
        boolean r8 = false;
    L19:
        if (r8 == false) goto L7;
        j<T> r4 = (j) r3;
    L21:
        if (r4 == null) goto L34;
        AtomicReferenceFieldUpdater r10 = j.g;
        Object r11 = r10.get(r4);
        if ((r11 instanceof s) == true) goto L25;
    L27:
        j.f.set(r4, 536870911);
        r10.set(r4, b.a);
    L28:
        if (r1 == false) goto L30;
        r5 = r4;
    L30:
        if (r5 == null) goto L34;
        return r5;
    L25:
        if (((s) r11).d == null) goto L27;
        r4.y();
        r1 = false;
    L34:
        return new j(r9, 2);
    L15:
        r8 = true;
        goto L19
    L9:
        i.h.set(r0, j.b);
        r4 = null;
        goto L21
    L5:
        return new j(r9, 1);
    }

    public static final <T> void b(i<? super T> r1, h r2) {
        if ((r1 instanceof j) == false) goto L7;
        ((j) r1).E(r2);
        return;
    L7:
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}
