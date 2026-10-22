package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends kotlinx.coroutines.internal.r {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = null;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        e = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_decision$volatile");
    }

    @Override // kotlinx.coroutines.internal.r, kotlinx.coroutines.r1
    public final void t(Object r5) {
        u(r5);
    }

    @Override // kotlinx.coroutines.internal.r, kotlinx.coroutines.r1
    public final void u(Object r5) {
    L2:
        AtomicIntegerFieldUpdater r10 = e;
        int r11 = r10.get(this);
        if (r11 != 0) goto L5;
        if (r10.compareAndSet(this, 0, 2) == false) goto L2;
        return;
    L5:
        if (r11 != 1) goto L9;
        Continuation r12 = IntrinsicsKt.intercepted(this.d);
        kotlinx.coroutines.internal.f.h(w.a(r5), r12);
        return;
    L9:
        throw new IllegalStateException("Already resumed");
    }
}
