package kotlinx.coroutines.internal;

import ai.j0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends kotlinx.coroutines.z implements o0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f18934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.z f18935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18936c;
    public final String d;
    public final k e;
    public final Object f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    static {
        g = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlinx.coroutines.z r5, int r10, String r11) {
        if ((r5 instanceof o0) == false) goto L5;
        o0 r12 = (o0) r5;
    L6:
        if (r12 != null) goto L8;
        r12 = l0.f18979a;
    L8:
        this.f18934a = r12;
        this.f18935b = r5;
        this.f18936c = r10;
        this.d = r11;
        this.e = new k();
        this.f = new Object();
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final boolean J() {
        Object r5 = this.f;
        monitor-enter(r5);
        AtomicIntegerFieldUpdater r10 = g;     // Catch: Throwable -> L13
        if (r10.get(this) < this.f18936c) goto L9;
        monitor-exit(r5);
        return false;
    L9:
        r10.incrementAndGet(this);     // Catch: Throwable -> L13
        monitor-exit(r5);
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        this.e.a(r10);
        if (g.get(this) < this.f18936c) goto L5;
        return;
    L5:
        if (J() == false) goto L12;
        Runnable r11 = g();
        if (r11 == null) goto L13;
        com.lynx.tasm.ui.image.v r12 = new com.lynx.tasm.ui.image.v(13, this, r11);
        this.f18935b.dispatch(this, r12);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.z
    public final void dispatchYield(CoroutineContext r5, Runnable r10) {
        this.e.a(r10);
        if (g.get(this) < this.f18936c) goto L5;
        return;
    L5:
        if (J() == false) goto L12;
        Runnable r11 = g();
        if (r11 == null) goto L13;
        com.lynx.tasm.ui.image.v r12 = new com.lynx.tasm.ui.image.v(13, this, r11);
        this.f18935b.dispatchYield(this, r12);
        return;
    L13:
        return;
    }

    @Override // kotlinx.coroutines.o0
    public final t0 e(long r5, Runnable r10, CoroutineContext r11) {
        return this.f18934a.e(r5, r10, r11);
    }

    @Override // kotlinx.coroutines.o0
    public final void f(long r5, kotlinx.coroutines.l r10) {
        this.f18934a.f(r5, r10);
    }

    public final Runnable g() {
    L2:
        Runnable r5 = (Runnable) this.e.d();
        if (r5 != null) goto L17;
        Object r10 = this.f;
        monitor-enter(r10);
        AtomicIntegerFieldUpdater r11 = g;     // Catch: Throwable -> L14
        r11.decrementAndGet(this);     // Catch: Throwable -> L14
        if (this.e.c() == 0) goto L8;
        r11.incrementAndGet(this);     // Catch: Throwable -> L14
        monitor-exit(r10);
        goto L2
    L8:
        monitor-exit(r10);
        return null;
    L14:
        th = move-exception;
        throw th;
    L17:
        return r5;
    }

    @Override // kotlinx.coroutines.z
    public final kotlinx.coroutines.z limitedParallelism(int r5, String r10) {
        f.c(r5);
        if (r5 < this.f18936c) goto L8;
        if (r10 != null) goto L6;
        return this;
    L6:
        return new o(this, r10);
    L8:
        return super.limitedParallelism(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        String r5 = this.d;
        if (r5 != null) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f18935b);
        r10.append(".limitedParallelism(");
        return j0.n(r10, this.f18936c, ')');
    L6:
        return r5;
    }
}
