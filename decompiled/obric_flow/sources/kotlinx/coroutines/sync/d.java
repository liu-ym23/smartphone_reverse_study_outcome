package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = null;
    private volatile /* synthetic */ Object owner$volatile;

    static {
        g = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "owner$volatile");
    }

    public d(boolean r5) {
        super(r5 ? 1 : 0);
        if (r5 == false) goto L5;
        g8.g r10 = null;
    L6:
        this.owner$volatile = r10;
        return;
    L5:
        r10 = e.f19013a;
        goto L6
    }

    public final Object c(ContinuationImpl r10) {
    L2:
        AtomicIntegerFieldUpdater r5 = g.f;
        int r11 = r5.get(this);
        if (r11 > 1) goto L4;
        if (r11 <= 0) goto L10;
        if (r5.compareAndSet(this, r11, r11 - 1) == false) goto L2;
        g.set(this, null);
        char r12 = 0;
    L14:
        if (r12 == 0) goto L45;
        if (r12 != 1) goto L17;
        l r13 = j0.h(IntrinsicsKt.intercepted(r10));
        b r14 = new b(this, r13);     // Catch: Throwable -> L41
    L24:
        int r15 = r5.getAndDecrement(this);     // Catch: Throwable -> L41
        if (r15 > 1) goto L24;
        if (r15 > 0) goto L27;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");     // Catch: Throwable -> L41
        if (a(r14) == false) goto L24;
    L30:
        Object r16 = r13.v();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L34:
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
        r16 = Unit.INSTANCE;
    L38:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        return r16;
    L63:
        return Unit.INSTANCE;
    L27:
        r14.k(Unit.INSTANCE, this.f19017a);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        r13.D();
        throw th;
    L17:
        if (r12 == 2) goto L21;
        throw new IllegalStateException("unexpected");
    L21:
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    L45:
        return Unit.INSTANCE;
    L10:
        r12 = 1;
    L4:
        int r17 = r5.get(this);
        if (r17 <= 1) goto L2;
        if (r5.compareAndSet(this, r17, 1) == false) goto L4;
        goto L2
    }

    public final void d(Object r5) {
    L3:
        if (Math.max(g.f.get(this), 0) != 0) goto L19;
        AtomicReferenceFieldUpdater r10 = g;
        Object r11 = r10.get(this);
        g8.g r12 = e.f19013a;
        if (r11 == r12) goto L3;
        if (r11 == r5) goto L12;
        if (r5 == null) goto L12;
        throw new IllegalStateException(("This mutex is locked by " + r11 + ", but " + r5 + " is expected").toString());
    L12:
        if (r10.compareAndSet(this, r11, r12) == true) goto L13;
        if (r10.get(this) == r11) goto L12;
    L13:
        b();
        return;
    L19:
        throw new IllegalStateException("This mutex is not locked");
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Mutex@");
        r5.append(j0.f(this));
        r5.append("[isLocked=");
        boolean r10 = false;
        if (Math.max(g.f.get(this), 0) != 0) goto L5;
        r10 = true;
    L5:
        r5.append(r10);
        r5.append(",owner=");
        r5.append(g.get(this));
        r5.append(']');
        return r5.toString();
    }
}
