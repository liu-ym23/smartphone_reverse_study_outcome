package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h0<T> extends x<T> {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = null;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        e = AtomicIntegerFieldUpdater.newUpdater(h0.class, "_decision$volatile");
    }

    public final void k0(Object r6) {
        AtomicIntegerFieldUpdater r0 = e;
    L3:
        int r1 = r0.get(this);
        boolean r2 = true;
        if (r1 != 0) goto L5;
        if (e.compareAndSet(this, 0, 2) == false) goto L3;
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        j.a(IntrinsicsKt.intercepted(((x) this).d), v.a(r6), null);
        return;
    L5:
        if (r1 != 1) goto L8;
        r2 = false;
        goto L11
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    public final void o(Object r1) {
        k0(r1);
    }

    public h0(CoroutineContext r1, Continuation<? super T> r2) {
        super(r1, r2);
    }
}
