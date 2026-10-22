package s4;

import androidx.core.util.Consumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<T> {
    public final AtomicReference<Consumer<T>> a;
    public final ConcurrentLinkedQueue<T> b;
    public final AtomicBoolean c;
    public volatile boolean d;

    public final void a() {
        this.d = true;
        c();
        this.a.set(null);
    }

    public final void c() {
        if (this.a.get() != null) goto L6;
        return;
    L6:
        if (this.c.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if ((!this.b.isEmpty()) == false) goto L14;
        T r0 = this.b.poll();
        if (r0 == null) goto L8;
        Consumer<T> r10 = this.a.get();
        if (r10 == null) goto L8;
        r10.accept(r0);
        goto L8
    L14:
        this.c.set(false);
    }

    public c() {
        this.a = new AtomicReference();
        this.b = new ConcurrentLinkedQueue();
        this.c = new AtomicBoolean(false);
    }

    public final void b(T r10) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.b.offer(r10);
        c();
    }

    public final void d(Consumer<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        if (this.d == false) goto L5;
        return;
    L5:
        AtomicReference<Consumer<T>> r0 = this.a;
    L7:
        if (r0.compareAndSet(null, r10) == true) goto L8;
        if (r0.get() == null) goto L7;
        boolean r11 = false;
    L12:
        if (r11 == false) goto L18;
        c();
        return;
    L18:
        return;
    L8:
        r11 = true;
        goto L12
    }
}
