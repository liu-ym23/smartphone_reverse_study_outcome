package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i1 extends q implements o0, z0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j1 f10018n;

    public i1() {
    }

    @Override // pe.z0
    public final boolean a() {
        return true;
    }

    @Override // pe.z0
    public final m1 c() {
        return null;
    }

    @Override // pe.o0
    public final void e() {
        j1 r8 = n();
    L3:
        Object r10 = r8.t();
        boolean r11 = false;
        if ((r10 instanceof i1) == false) goto L16;
        if (r10 != this) goto L58;
        r0 r12 = k1.f10039g;
    L8:
        AtomicReferenceFieldUpdater r13 = j1.f10020a;
        if (r13.compareAndSet(r8, r10, r12) == true) goto L10;
        if (r13.get(r8) == r10) goto L8;
    L13:
        if (r11 == false) goto L3;
        return;
    L10:
        r11 = true;
        goto L13
    L58:
        return;
    L16:
        if ((r10 instanceof z0) == true) goto L18;
        return;
    L18:
        if (((z0) r10).c() == null) goto L55;
    L19:
        Object r14 = i();
        if ((r14 instanceof ue.r) == true) goto L21;
        if (r14 == this) goto L23;
        he.i.d(r14, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        ue.l r15 = (ue.l) r14;
        AtomicReferenceFieldUpdater r16 = ue.l.f12611m;
        ue.r r17 = (ue.r) r16.get(r15);
        if (r17 != null) goto L27;
        r17 = new ue.r(r15);
        r16.lazySet(r15, r17);
    L27:
        AtomicReferenceFieldUpdater r18 = ue.l.f12609a;
        if (r18.compareAndSet(this, r14, r17) == true) goto L29;
        if (r18.get(this) == r14) goto L27;
        boolean r19 = false;
    L33:
        if (r19 == false) goto L19;
        r15.g();
        return;
    L29:
        r19 = true;
        goto L33
    L23:
        ue.l r20 = (ue.l) r14;
        return;
    L21:
        ue.l r21 = ((ue.r) r14).f12624a;
        return;
    }

    public e1 getParent() {
        return n();
    }

    public final j1 n() {
        j1 r8 = this.f10018n;
        if (r8 == null) goto L5;
        return r8;
    L5:
        he.i.j("job");
        throw null;
    }

    @Override // ue.l
    public final String toString() {
        return getClass().getSimpleName() + '@' + d0.c(this) + "[job@" + d0.c(n()) + ']';
    }
}
