package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10628c = null;

    @Volatile
    private volatile int _resumed;

    static {
        f10628c = AtomicIntegerFieldUpdater.newUpdater(r.class, "_resumed");
    }

    public r(Continuation<?> r10, Throwable r11, boolean r12) {
        if (r11 != null) goto L4;
        r11 = new CancellationException("Continuation " + r10 + " was cancelled normally");
    L4:
        super(r11, r12);
        this._resumed = 0;
    }

    public final boolean c() {
        return f10628c.compareAndSet(this, 0, 1);
    }
}
