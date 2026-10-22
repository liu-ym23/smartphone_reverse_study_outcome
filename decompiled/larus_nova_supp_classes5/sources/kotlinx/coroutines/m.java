package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m extends t {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = null;
    private volatile /* synthetic */ int _resumed$volatile;

    static {
        c = AtomicIntegerFieldUpdater.newUpdater(m.class, "_resumed$volatile");
    }

    public m(Continuation<?> r3, Throwable r4, boolean r5) {
        if (r4 != null) goto L4;
        r4 = new CancellationException("Continuation " + r3 + " was cancelled normally");
    L4:
        super(r4, r5);
        this._resumed$volatile = 0;
    }
}
