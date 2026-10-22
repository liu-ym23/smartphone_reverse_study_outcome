package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b1 extends d1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = null;
    private volatile /* synthetic */ int _invoked$volatile;
    public final z0 e;

    static {
        f = AtomicIntegerFieldUpdater.newUpdater(b1.class, "_invoked$volatile");
    }

    public b1(z0 r1) {
        this.e = r1;
    }

    public final void a(Throwable r4) {
        if (f.compareAndSet(this, 0, 1) == false) goto L6;
        this.e.a(r4);
        return;
    }
}
