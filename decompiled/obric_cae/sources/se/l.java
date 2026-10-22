package se;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends te.b<j<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12130a = null;
    private volatile Object _state;

    static {
        f12130a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    }

    public l() {
    }

    @Override // te.b
    public final boolean a(f r8) {
        j r10 = (j) r8;
        AtomicReferenceFieldUpdater r11 = f12130a;
        if (r11.get(this) == null) goto L5;
        return false;
    L5:
        r11.set(this, k.f12128a);
        return true;
    }

    public final void b(j r8) {
        f12130a.set(this, null);
    }
}
