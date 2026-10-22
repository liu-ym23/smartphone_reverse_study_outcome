package pe;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10017c = null;
    private volatile int _resumed;

    static {
        f10017c = AtomicIntegerFieldUpdater.newUpdater(i.class, "_resumed");
    }

    public i(ae.d<?> r8, Throwable r10, boolean r11) {
        if (r10 != null) goto L4;
        r10 = new CancellationException("Continuation " + r8 + " was cancelled normally");
    L4:
        super(r11, r10);
        this._resumed = 0;
    }
}
