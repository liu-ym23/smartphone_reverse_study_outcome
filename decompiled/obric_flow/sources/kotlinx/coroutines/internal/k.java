package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18940a = null;
    private volatile /* synthetic */ Object _cur$volatile;

    static {
        f18940a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    }

    public k() {
        this._cur$volatile = new m(8, false);
    }

    public final boolean a(Runnable r5) {
    L2:
        AtomicReferenceFieldUpdater r10 = f18940a;
        m r11 = (m) r10.get(this);
        int r12 = r11.a(r5);
        if (r12 == 0) goto L17;
        if (r12 != 1) goto L6;
        m r13 = r11.c();
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
        AtomicReferenceFieldUpdater r5 = f18940a;
        m r10 = (m) r5.get(this);
        if (r10.b() == true) goto L4;
        m r11 = r10.c();
    L7:
        if (r5.compareAndSet(this, r10, r11) == true) goto L2;
        if (r5.get(this) == r10) goto L7;
    }

    public final int c() {
        m r5 = (m) f18940a.get(this);
        r5.getClass();
        long r10 = m.f.get(r5);
        int r11 = (int) (1073741823 & r10);
        return 1073741823 & (((int) ((r10 & 1152921503533105152L) >> 30)) - r11);
    }

    public final Object d() {
    L2:
        AtomicReferenceFieldUpdater r5 = f18940a;
        m r10 = (m) r5.get(this);
        Object r11 = r10.d();
        if (r11 != m.g) goto L4;
        m r12 = r10.c();
    L7:
        if (r5.compareAndSet(this, r10, r12) == true) goto L2;
        if (r5.get(this) == r10) goto L7;
    L4:
        return r11;
    }
}
