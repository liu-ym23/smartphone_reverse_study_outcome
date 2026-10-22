package xr9;

import com.larus.power.state.impl.AndroidPowerStateEventSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wr9.k;
import wr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements e {
    public final f a;
    public final wr9.e b;
    public final Object c;
    public final AtomicBoolean d;
    public final CopyOnWriteArraySet<d> e;
    public final AtomicReference<wr9.j> f;

    public static final class a {
    }

    static {
    }

    public final void d() {
        if (this.d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        long r2 = this.b.a();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(this.a.b(r2));     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r1) == false) goto L20;
        k r10 = (k) r1;
        Object r12 = this.c;
        monitor-enter(r12);
        wr9.j r3 = wr9.j.a(wr9.j.a(this.f.get(), 0, null, null, null, r10, 31), r2, null, null, null, null, 62);     // Catch: Throwable -> L17
        this.f.set(r3);     // Catch: Throwable -> L17
        monitor-exit(r12);
        e(r3);
    L17:
        th = move-exception;
        throw th;
    L20:
        Result.exceptionOrNull-impl(r1);
        this.a.a(this);     // Catch: Throwable -> L23
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.exceptionOrNull-impl(r4);
        return;
    L23:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void e(wr9.j r3) {
        Iterator<d> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(r3);     // Catch: Throwable -> L8
        goto L4
    }

    public c(AndroidPowerStateEventSource r3, wr9.e r4) {
        Intrinsics.checkNotNullParameter(r3, "eventSource");
        Intrinsics.checkNotNullParameter(r4, "clock");
        this.a = r3;
        this.b = r4;
        this.c = new Object();
        this.d = new AtomicBoolean(false);
        this.e = new CopyOnWriteArraySet();
        this.f = new AtomicReference(g.b(r4.a(), "not_initialized"));
    }

    @Override // xr9.e
    public final void a(l r20, long r21) {
        Intrinsics.checkNotNullParameter(r20, "thermal");
        Object r10 = this.c;
        monitor-enter(r10);
        wr9.j r0 = wr9.j.a(wr9.j.a(this.f.get(), 0, r20, null, null, null, 61), r21, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f.set(r0);     // Catch: Throwable -> L8
        monitor-exit(r10);
        e(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // xr9.e
    public final void b(wr9.a r20, long r21) {
        Intrinsics.checkNotNullParameter(r20, "battery");
        Object r10 = this.c;
        monitor-enter(r10);
        wr9.j r0 = wr9.j.a(wr9.j.a(this.f.get(), 0, null, null, r20, null, 47), r21, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f.set(r0);     // Catch: Throwable -> L8
        monitor-exit(r10);
        e(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // xr9.e
    public final void c(wr9.c r20, long r21) {
        Intrinsics.checkNotNullParameter(r20, "memory");
        Object r10 = this.c;
        monitor-enter(r10);
        wr9.j r0 = wr9.j.a(wr9.j.a(this.f.get(), 0, null, r20, null, null, 55), r21, null, null, null, null, 62);     // Catch: Throwable -> L8
        this.f.set(r0);     // Catch: Throwable -> L8
        monitor-exit(r10);
        e(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
