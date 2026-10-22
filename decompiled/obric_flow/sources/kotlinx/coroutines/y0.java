package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y0 implements Runnable, Comparable, t0 {
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19031b;

    public y0(long r5) {
        this.f19030a = r5;
        this.f19031b = -1;
    }

    public final int b(long r10, z0 r11, a1 r12) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this._heap != j0.f18966b) goto L8;
        monitor-exit(this);
        return 2;
    L8:
        monitor-enter(r11);     // Catch: Throwable -> L22
        y0[] r5 = r11.f18961a;     // Catch: Throwable -> L27
        if (r5 == null) goto L12;
        y0 r13 = r5[0];     // Catch: Throwable -> L27
    L13:
        AtomicReferenceFieldUpdater r14 = a1.e;     // Catch: Throwable -> L27
        r12.getClass();     // Catch: Throwable -> L27
        if (a1.g.get(r12) == 0) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == false) goto L25;
        monitor-exit(r11);     // Catch: Throwable -> L22
        monitor-exit(this);
        return 1;
    L25:
        if (r13 != null) goto L29;
        r11.f19032c = r10;     // Catch: Throwable -> L27
    L36:
        long r16 = this.f19030a;     // Catch: Throwable -> L27
        long r17 = r11.f19032c;     // Catch: Throwable -> L27
        if ((r16 - r17) >= 0) goto L39;
        this.f19030a = r17;     // Catch: Throwable -> L27
    L39:
        r11.a(this);     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L22
        monitor-exit(this);
        return 0;
    L29:
        long r18 = r13.f19030a;     // Catch: Throwable -> L27
        if ((r18 - r10) >= 0) goto L34;
        r10 = r18;
    L34:
        if ((r10 - r11.f19032c) <= 0) goto L36;
        r11.f19032c = r10;     // Catch: Throwable -> L27
        goto L36
    L17:
        r15 = false;
        goto L18
    L12:
        r13 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    }

    public final void c(z0 r5) {
        if (this._heap == j0.f18966b) goto L7;
        this._heap = r5;
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        long r10 = this.f19030a - ((y0) r5).f19030a;
        if (r10 <= 0) goto L5;
        return 1;
    L5:
        if (r10 >= 0) goto L7;
        return -1;
    L7:
        return 0;
    }

    @Override // kotlinx.coroutines.t0
    public final void dispose() {
        kotlinx.coroutines.internal.y r5 = null;
        monitor-enter(this);
        Object r10 = this._heap;     // Catch: Throwable -> L11
        g8.g r11 = j0.f18966b;     // Catch: Throwable -> L11
        if (r10 != r11) goto L9;
        monitor-exit(this);
        return;
    L9:
        if ((r10 instanceof z0) == false) goto L13;
        z0 r12 = (z0) r10;     // Catch: Throwable -> L11
    L14:
        if (r12 == null) goto L27;
        monitor-enter(r12);     // Catch: Throwable -> L11
        Object r13 = this._heap;     // Catch: Throwable -> L24
        if ((r13 instanceof kotlinx.coroutines.internal.y) == false) goto L19;
        r5 = (kotlinx.coroutines.internal.y) r13;     // Catch: Throwable -> L24
    L19:
        if (r5 == null) goto L22;
        r12.b(this.f19031b);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r12);     // Catch: Throwable -> L11
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L27:
        this._heap = r11;     // Catch: Throwable -> L11
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L13:
        r12 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return androidx.room.jarjarred.org.antlr.runtime.a.t(new StringBuilder("Delayed[nanos="), this.f19030a, ']');
    }
}
