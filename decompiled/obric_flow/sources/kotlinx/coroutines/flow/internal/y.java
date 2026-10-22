package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i2;
import kotlinx.coroutines.flow.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends i2 implements p2 {
    @Override // kotlinx.coroutines.flow.p2
    public final Object getValue() {
        monitor-enter(this);
        Object[] r5 = this.f18854h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L6
        Integer r10 = Integer.valueOf(((Number) kotlinx.coroutines.flow.i.c(r5, (this.f18855i + ((long) ((int) ((o() + ((long) this.f18857k)) - this.f18855i)))) - 1)).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void v(int r10) {
        monitor-enter(this);
        Object[] r5 = this.f18854h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L6
        a(Integer.valueOf(((Number) kotlinx.coroutines.flow.i.c(r5, (this.f18855i + ((long) ((int) ((o() + ((long) this.f18857k)) - this.f18855i)))) - 1)).intValue() + r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
