package pe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10051b = null;
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f10052a;

    static {
        f10051b = AtomicIntegerFieldUpdater.newUpdater(o.class, "_handled");
    }

    public o(boolean r8, Throwable r10) {
        this.f10052a = r10;
        this._handled = r8 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f10052a + ']';
    }
}
