package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes3.dex */
public class u<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10585a = null;

    @Volatile
    private volatile Object _cur;

    static {
        f10585a = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_cur");
    }

    public u(boolean r10) {
        this._cur = new v(8, r10);
    }

    public final boolean a(E r10) {
        AtomicReferenceFieldUpdater r11 = f10585a;
    L3:
        v r12 = (v) r11.get(this);
        int r13 = r12.a(r10);
        if (r13 == 0) goto L12;
        if (r13 != 1) goto L7;
        f10585a.compareAndSet(this, r12, r12.i());
        goto L3
    L7:
        if (r13 != 2) goto L3;
        return false;
    L12:
        return true;
    }

    public final void b() {
        AtomicReferenceFieldUpdater r10 = f10585a;
    L3:
        v r11 = (v) r10.get(this);
        if (r11.d() == true) goto L5;
        f10585a.compareAndSet(this, r11, r11.i());
        goto L3
    }

    public final int c() {
        return ((v) f10585a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater r10 = f10585a;
    L3:
        v r11 = (v) r10.get(this);
        E r12 = (E) r11.j();
        if (r12 != v.f10589h) goto L5;
        f10585a.compareAndSet(this, r11, r11.i());
        goto L3
    L5:
        return r12;
    }
}
