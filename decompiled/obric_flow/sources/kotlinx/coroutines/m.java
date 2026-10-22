package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f18981c = null;
    private volatile /* synthetic */ int _resumed$volatile;

    static {
        f18981c = AtomicIntegerFieldUpdater.newUpdater(m.class, "_resumed$volatile");
    }

    public m(l r5, Throwable r10, boolean r11) {
        if (r10 != null) goto L4;
        r10 = new CancellationException("Continuation " + r5 + " was cancelled normally");
    L4:
        super(r11, r10);
        this._resumed$volatile = 0;
    }
}
