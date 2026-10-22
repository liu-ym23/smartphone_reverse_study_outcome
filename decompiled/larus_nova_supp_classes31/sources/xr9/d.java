package xr9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements wr9.i {
    public final c a;
    public final AtomicBoolean b;
    public final CopyOnWriteArraySet<wr9.f> c;

    public final void b() {
        if (this.b.compareAndSet(true, false) == false) goto L6;
        c r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "session");
        r0.e.remove(this);
        return;
    }

    @Override // wr9.i
    public final wr9.j o() {
        return this.a.f.get();
    }

    @Override // wr9.i
    public final void start() {
        if (this.b.compareAndSet(false, true) == false) goto L9;
        c r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "session");
        if (r0.e.add(this) == false) goto L10;
        a(r0.f.get());
        return;
    L10:
        return;
    }

    @Override // wr9.i, java.lang.AutoCloseable
    public final void close() {
        b();
    }

    public d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        this.a = r2;
        this.b = new AtomicBoolean(false);
        this.c = new CopyOnWriteArraySet();
    }

    @Override // wr9.i
    public final void G8(com.larus.avlink.gallery.power.monitor.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    @Override // wr9.i
    public final void Gb(com.larus.avlink.gallery.power.monitor.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }

    public final void a(wr9.j r3) {
        Intrinsics.checkNotNullParameter(r3, "snapshot");
        if (this.b.get() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        ((wr9.f) r0.next()).a(r3);     // Catch: Throwable -> L11
        goto L7
    }
}
