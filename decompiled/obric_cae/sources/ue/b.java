package ue;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12589a = null;
    private volatile Object _consensus;

    static {
        f12589a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    }

    public b() {
        this._consensus = a.f12588a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ue.q
    public final Object a(Object r8) {
        AtomicReferenceFieldUpdater r10 = f12589a;
        Object r11 = r10.get(this);
        b9.a r12 = a.f12588a;
        if (r11 != r12) goto L16;
        b9.a r13 = c(r8);
        r11 = r10.get(this);
        if (r11 != r12) goto L16;
    L8:
        if (r10.compareAndSet(this, r12, r13) == true) goto L9;
        if (r10.get(this) == r12) goto L8;
        boolean r14 = false;
    L13:
        if (r14 == false) goto L15;
        r11 = r13;
        goto L16
    L15:
        r11 = r10.get(this);
        goto L16
    L9:
        r14 = true;
    L16:
        b(r8, r11);
        return r11;
    }

    public abstract void b(T r8, Object r10);

    public abstract b9.a c(Object r8);
}
