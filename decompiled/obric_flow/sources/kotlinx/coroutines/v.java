package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f19024b = null;
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f19025a;

    static {
        f19024b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled$volatile");
    }

    public v(boolean r5, Throwable r10) {
        this.f19025a = r10;
        this._handled$volatile = r5 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f19025a + ']';
    }
}
