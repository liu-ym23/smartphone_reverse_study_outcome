package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
final class a1 implements b1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Future<?> f10233c;

    public a1(Future<?> r10) {
        this.f10233c = r10;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
        this.f10233c.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f10233c + ']';
    }
}
