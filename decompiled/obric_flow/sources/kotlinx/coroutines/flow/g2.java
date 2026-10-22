package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g2 implements kotlinx.coroutines.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2 f18847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18849c;
    public final kotlinx.coroutines.l d;

    public g2(i2 r5, long r10, Object r11, kotlinx.coroutines.l r12) {
        this.f18847a = r5;
        this.f18848b = r10;
        this.f18849c = r11;
        this.d = r12;
    }

    @Override // kotlinx.coroutines.t0
    public final void dispose() {
        i2 r5 = this.f18847a;
        monitor-enter(r5);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.f18848b >= r5.o()) goto L9;
        monitor-exit(r5);
        return;
    L9:
        Object[] r10 = r5.f18854h;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L16
        if (i.c(r10, this.f18848b) == this) goto L13;
        monitor-exit(r5);
        return;
    L13:
        i.d(r10, this.f18848b, i.f18851a);     // Catch: Throwable -> L16
        r5.j();     // Catch: Throwable -> L16
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r5);
    }
}
