package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m1 extends kotlinx.coroutines.internal.j implements t0, g1 {
    public r1 d;

    @Override // kotlinx.coroutines.g1
    public final u1 b() {
        return null;
    }

    @Override // kotlinx.coroutines.t0
    public final void dispose() {
        r1 r5 = h();
        r5.getClass();
    L3:
        AtomicReferenceFieldUpdater r10 = r1.f18988a;
        Object r11 = r10.get(r5);
        if ((r11 instanceof m1) == false) goto L15;
        if (r11 != this) goto L48;
        v0 r12 = j0.f18970j;
    L9:
        if (r10.compareAndSet(r5, r11, r12) == true) goto L49;
        if (r10.get(r5) == r11) goto L9;
    L49:
        return;
    L48:
        return;
    L15:
        if ((r11 instanceof g1) == true) goto L17;
        return;
    L17:
        if (((g1) r11).b() == null) goto L44;
    L18:
        AtomicReferenceFieldUpdater r13 = kotlinx.coroutines.internal.j.f18937a;
        Object r14 = r13.get(this);
        if ((r14 instanceof kotlinx.coroutines.internal.p) == true) goto L20;
        if (r14 == this) goto L22;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        kotlinx.coroutines.internal.j r15 = (kotlinx.coroutines.internal.j) r14;
        r15.getClass();
        AtomicReferenceFieldUpdater r16 = kotlinx.coroutines.internal.j.f18939c;
        kotlinx.coroutines.internal.p r17 = (kotlinx.coroutines.internal.p) r16.get(r15);
        if (r17 != null) goto L27;
        r17 = new kotlinx.coroutines.internal.p(r15);
        r16.set(r15, r17);
    L27:
        if (r13.compareAndSet(this, r14, r17) == true) goto L28;
        if (r13.get(this) == r14) goto L27;
    L28:
        r15.d();
        return;
    L22:
        kotlinx.coroutines.internal.j r18 = (kotlinx.coroutines.internal.j) r14;
        return;
    L20:
        kotlinx.coroutines.internal.j r19 = ((kotlinx.coroutines.internal.p) r14).f18949a;
        return;
    }

    public Job getParent() {
        return h();
    }

    public final r1 h() {
        r1 r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public abstract boolean i();

    @Override // kotlinx.coroutines.g1
    public final boolean isActive() {
        return true;
    }

    public abstract void j(Throwable r5);

    @Override // kotlinx.coroutines.internal.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + j0.f(this) + "[job@" + j0.f(h()) + ']';
    }
}
