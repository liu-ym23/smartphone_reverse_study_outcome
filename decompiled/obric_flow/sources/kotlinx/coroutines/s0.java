package kotlinx.coroutines;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f18990a;

    public s0(ScheduledFuture r5) {
        this.f18990a = r5;
    }

    @Override // kotlinx.coroutines.t0
    public final void dispose() {
        this.f18990a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f18990a + ']';
    }
}
