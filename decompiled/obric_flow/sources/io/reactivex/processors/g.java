package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.internal.queue.b f18187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18188c;
    public final boolean d;
    public volatile boolean e;
    public Throwable f;
    public final AtomicReference g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f18189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f18190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BasicIntQueueSubscription f18191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f18192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18193l;

    public g(Runnable r5, int r10) {
        io.reactivex.internal.functions.e.e(r10, "capacityHint");
        this.f18187b = new io.reactivex.internal.queue.b(r10);
        this.f18188c = new AtomicReference(r5);
        this.d = true;
        this.g = new AtomicReference();
        this.f18190i = new AtomicBoolean();
        this.f18191j = new UnicastProcessor$UnicastQueueSubscription(this);
        this.f18192k = new AtomicLong();
    }

    @Override // mt.e
    public final void b(mt.g r5) {
        if (this.f18190i.get() == false) goto L5;
    L10:
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), r5);
        return;
    L5:
        if (this.f18190i.compareAndSet(false, true) == false) goto L10;
        r5.onSubscribe(this.f18191j);
        this.g.set(r5);
        if (this.f18189h == false) goto L9;
        this.g.lazySet(null);
        return;
    L9:
        d();
    }

    public final boolean c(boolean r5, boolean r10, boolean r11, zu.c r12, io.reactivex.internal.queue.b r13) {
        if (this.f18189h == false) goto L6;
        r13.clear();
        this.g.lazySet(null);
        return true;
    L6:
        if (r10 == false) goto L18;
        if (r5 == true) goto L9;
    L12:
        if (r11 == false) goto L20;
        Throwable r14 = this.f;
        this.g.lazySet(null);
        if (r14 == null) goto L16;
        r12.onError(r14);
    L17:
        return true;
    L16:
        r12.onComplete();
        goto L17
    L20:
        return false;
    L9:
        if (this.f == null) goto L12;
        r13.clear();
        this.g.lazySet(null);
        r12.onError(this.f);
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        if (this.f18191j.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
        zu.c r11 = (zu.c) this.g.get();
        int r5 = 1;
    L6:
        if (r11 != null) goto L8;
        r5 = this.f18191j.addAndGet(-r5);
        if (r5 == 0) goto L58;
        r11 = (zu.c) this.g.get();
        r10 = 1;
        goto L6
    L58:
        return;
    L8:
        if (this.f18193l == false) goto L28;
        io.reactivex.internal.queue.b r12 = this.f18187b;
        boolean r13 = this.d;
    L11:
        if (this.f18189h == true) goto L12;
        boolean r14 = this.e;
        if (r13 == true) goto L19;
        if (r14 == false) goto L19;
        if (this.f == null) goto L19;
        r12.clear();
        this.g.lazySet(null);
        r11.onError(this.f);
        return;
    L19:
        r11.onNext(null);
        if (r14 == true) goto L21;
        r10 = this.f18191j.addAndGet(-r10);
        if (r10 != 0) goto L11;
        return;
    L21:
        this.g.lazySet(null);
        Throwable r15 = this.f;
        if (r15 == null) goto L24;
        r11.onError(r15);
        return;
    L24:
        r11.onComplete();
        return;
    L12:
        r12.clear();
        this.g.lazySet(null);
        return;
    L28:
        io.reactivex.internal.queue.b r16 = this.f18187b;
        boolean r17 = !this.d;
        int r18 = r10;
    L29:
        long r19 = this.f18192k.get();
        long r20 = 0;
    L31:
        if (r19 == r20) goto L42;
        boolean r21 = this.e;
        Object r22 = r16.poll();
        if (r22 != null) goto L35;
        int r110 = r10;
    L36:
        long r111 = r20;
        if (c(r17, r21, r110, r11, r16) == true) goto L76;
        if (r110 != 0) goto L43;
        r11.onNext(r22);
        r20 = r111 + 1;
        r10 = 1;
    L43:
        if (r19 != r20) goto L48;
        if (c(r17, this.e, r16.isEmpty(), r11, r16) == false) goto L48;
        return;
    L48:
        if (r111 != 0) goto L50;
    L52:
        r18 = this.f18191j.addAndGet(-r18);
        if (r18 == 0) goto L78;
        r10 = 1;
        goto L29
    L78:
        return;
    L50:
        if (r19 == Long.MAX_VALUE) goto L52;
        this.f18192k.addAndGet(-r111);
        goto L52
    L76:
        return;
    L35:
        r110 = 0;
        goto L36
    L42:
        r111 = r20;
        goto L43
    }

    @Override // zu.c
    public final void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        if (this.f18189h == true) goto L13;
        this.e = true;
        Runnable r5 = (Runnable) this.f18188c.getAndSet(null);
        if (r5 == null) goto L10;
        r5.run();
    L10:
        d();
        return;
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        io.reactivex.internal.functions.e.d(r5, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L5;
    L12:
        wn.f.k(r5);
        return;
    L5:
        if (this.f18189h == true) goto L12;
        this.f = r5;
        this.e = true;
        Runnable r10 = (Runnable) this.f18188c.getAndSet(null);
        if (r10 == null) goto L10;
        r10.run();
    L10:
        d();
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        io.reactivex.internal.functions.e.d(r5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e == false) goto L5;
        return;
    L5:
        if (this.f18189h == true) goto L10;
        this.f18187b.offer(r5);
        d();
        return;
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        if (this.e == false) goto L5;
    L8:
        r5.cancel();
        return;
    L5:
        if (this.f18189h == true) goto L8;
        r5.request(Long.MAX_VALUE);
    }
}
