package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends kotlinx.coroutines.z implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f18946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.z f18947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18948c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(kotlinx.coroutines.z r5, String r10) {
        if ((r5 instanceof o0) == false) goto L5;
        o0 r11 = (o0) r5;
    L6:
        if (r11 != null) goto L8;
        r11 = l0.f18979a;
    L8:
        this.f18946a = r11;
        this.f18947b = r5;
        this.f18948c = r10;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        this.f18947b.dispatch(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final void dispatchYield(CoroutineContext r5, Runnable r10) {
        this.f18947b.dispatchYield(r5, r10);
    }

    @Override // kotlinx.coroutines.o0
    public final t0 e(long r5, Runnable r10, CoroutineContext r11) {
        return this.f18946a.e(r5, r10, r11);
    }

    @Override // kotlinx.coroutines.o0
    public final void f(long r5, kotlinx.coroutines.l r10) {
        this.f18946a.f(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final boolean isDispatchNeeded(CoroutineContext r5) {
        return this.f18947b.isDispatchNeeded(r5);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return this.f18948c;
    }
}
