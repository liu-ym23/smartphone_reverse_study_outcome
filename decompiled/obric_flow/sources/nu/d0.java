package nu;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends f0 {
    @Override // nu.f0
    public final f0 deadlineNanoTime(long r5) {
        return this;
    }

    @Override // nu.f0
    public final void throwIfReached() {
    }

    @Override // nu.f0
    public final f0 timeout(long r5, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r10, "unit");
        return this;
    }
}
