package l2;

import androidx.core.util.Consumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f19511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f19512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f19513c;
    public volatile boolean d;

    public a() {
        this.f19511a = new AtomicReference();
        this.f19512b = new ConcurrentLinkedQueue();
        this.f19513c = new AtomicBoolean(false);
    }

    public final void a() {
        this.d = true;
        d();
        this.f19511a.set(null);
    }

    public final void b(Consumer r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        if (this.d == true) goto L12;
        AtomicReference r10 = this.f19511a;
    L7:
        if (r10.compareAndSet(null, r5) == true) goto L8;
        if (r10.get() == null) goto L7;
        return;
    L8:
        d();
        return;
    }

    public final void c(Object r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        this.f19512b.offer(r5);
        d();
    }

    public final void d() {
        AtomicReference r5 = this.f19511a;
        if (((Consumer) r5.get()) == null) goto L24;
        AtomicBoolean r10 = this.f19513c;
        if (r10.compareAndSet(false, true) == false) goto L23;
    L7:
        ConcurrentLinkedQueue r11 = this.f19512b;
        if (r11.isEmpty() == true) goto L14;
        Object r12 = r11.poll();
        if (r12 == null) goto L7;
        Consumer r13 = (Consumer) r5.get();
        if (r13 == null) goto L7;
        r13.accept(r12);
        goto L7
    L14:
        r10.set(false);
        return;
    L23:
        return;
    }
}
