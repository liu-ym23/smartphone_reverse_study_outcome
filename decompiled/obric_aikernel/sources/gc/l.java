package gc;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class l extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f9118c = null;

    static {
        f9118c = new l();
    }

    private l() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        b.f9099k.e0(r11, k.f9117h, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext r10, Runnable r11) {
        b.f9099k.e0(r11, k.f9117h, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        r.a(r10);
        if (r10 < k.f9113d) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r10);
    }
}
