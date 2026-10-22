package ue;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class m<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12614a = null;
    private volatile Object _cur;

    static {
        f12614a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_cur");
    }

    public m() {
        this._cur = new n(8, false);
    }

    public final boolean a(E r8) {
    L2:
        AtomicReferenceFieldUpdater r10 = f12614a;
        n r11 = (n) r10.get(this);
        int r12 = r11.a(r8);
        if (r12 == 0) goto L17;
        if (r12 != 1) goto L6;
        n<E> r13 = r11.c();
    L12:
        if (r10.compareAndSet(this, r11, r13) == true) goto L2;
        if (r10.get(this) == r11) goto L12;
    L6:
        if (r12 != 2) goto L2;
        return false;
    L17:
        return true;
    }

    public final void b() {
    L2:
        AtomicReferenceFieldUpdater r8 = f12614a;
        n r10 = (n) r8.get(this);
        if (r10.b() == true) goto L4;
        n<E> r11 = r10.c();
    L7:
        if (r8.compareAndSet(this, r10, r11) == true) goto L2;
        if (r8.get(this) == r10) goto L7;
    }

    public final int c() {
        n r8 = (n) f12614a.get(this);
        r8.getClass();
        long r10 = n.f12616f.get(r8);
        int r11 = (int) ((1073741823 & r10) >> 0);
        return 1073741823 & (((int) ((r10 & 1152921503533105152L) >> 30)) - r11);
    }

    public final E d() {
    L2:
        AtomicReferenceFieldUpdater r8 = f12614a;
        n r10 = (n) r8.get(this);
        E r11 = (E) r10.d();
        if (r11 != n.f12617g) goto L4;
        n<E> r12 = r10.c();
    L7:
        if (r8.compareAndSet(this, r10, r12) == true) goto L2;
        if (r8.get(this) == r10) goto L7;
    L4:
        return r11;
    }
}
