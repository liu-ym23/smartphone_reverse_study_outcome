package nu;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f20332a;

    public q(f0 r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f20332a = r5;
    }

    @Override // nu.f0
    public final f0 clearDeadline() {
        return this.f20332a.clearDeadline();
    }

    @Override // nu.f0
    public final f0 clearTimeout() {
        return this.f20332a.clearTimeout();
    }

    @Override // nu.f0
    public final long deadlineNanoTime() {
        return this.f20332a.deadlineNanoTime();
    }

    @Override // nu.f0
    public final boolean hasDeadline() {
        return this.f20332a.hasDeadline();
    }

    @Override // nu.f0
    public final void throwIfReached() {
        this.f20332a.throwIfReached();
    }

    @Override // nu.f0
    public final f0 timeout(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        return this.f20332a.timeout(r5, r10);
    }

    @Override // nu.f0
    public final long timeoutNanos() {
        return this.f20332a.timeoutNanos();
    }

    @Override // nu.f0
    public final f0 deadlineNanoTime(long r5) {
        return this.f20332a.deadlineNanoTime(r5);
    }
}
