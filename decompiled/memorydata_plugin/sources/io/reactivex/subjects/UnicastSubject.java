package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class UnicastSubject<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.internal.queue.a<T> f17180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<t<? super T>> f17181b;
    final AtomicReference<Runnable> c;
    final boolean d;
    volatile boolean e;
    volatile boolean f;
    Throwable g;
    final AtomicBoolean h;
    final BasicIntQueueDisposable<T> i;
    boolean j;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;
        final /* synthetic */ UnicastSubject this$0;

        UnicastQueueDisposable(UnicastSubject r1) {
            this.this$0 = r1;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.this$0.f17180a.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.this$0.e == true) goto L10;
            this.this$0.e = true;
            this.this$0.d();
            this.this$0.f17181b.lazySet(null);
            if (this.this$0.i.getAndIncrement() != 0) goto L11;
            this.this$0.f17181b.lazySet(null);
            if (this.this$0.j == true) goto L12;
            this.this$0.f17180a.clear();
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.this$0.e;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.this$0.f17180a.isEmpty();
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return this.this$0.f17180a.poll();
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.this$0.j = true;
            return 2;
        L6:
            return 0;
        }
    }

    UnicastSubject(int r3, Runnable r4, boolean r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        this.f17180a = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.a(r3, "capacityHint"));
        this.c = new AtomicReference(io.reactivex.internal.functions.a.a(r6, "onTerminate"));
        this.d = r5;
        this.f17181b = new AtomicReference();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable(this);
    }

    UnicastSubject(int r3, boolean r4) {
        this.f17180a = new io.reactivex.internal.queue.a(io.reactivex.internal.functions.a.a(r3, "capacityHint"));
        this.c = new AtomicReference();
        this.d = r4;
        this.f17181b = new AtomicReference();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable(this);
    }

    public static <T> UnicastSubject<T> a(int r2, Runnable r3) {
        return new UnicastSubject(r2, (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), true);
    }

    public static <T> UnicastSubject<T> b() {
        return new UnicastSubject(a(), true);
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        if (this.h.get() == false) goto L5;
    L11:
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), r5);
        return;
    L5:
        if (this.h.compareAndSet(false, true) == false) goto L11;
        r5.onSubscribe(this.i);
        this.f17181b.lazySet(r5);
        if (this.e == false) goto L10;
        this.f17181b.lazySet(null);
        return;
    L10:
        e();
    }

    boolean a(f<T> r3, t<? super T> r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        Throwable r0 = this.g;
        if (r0 == null) goto L6;
        this.f17181b.lazySet(null);
        r5.clear();
        r6.onError(r0);
        return true;
    L6:
        return false;
    }

    void b(t<? super T> r10) {
        t<? super T> r11 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.queue.a<T> r0 = this.f17180a;
        boolean r1 = !this.d;
        boolean r3 = true;
        int r4 = 1;
    L4:
        if (this.e == true) goto L5;
        boolean r5 = this.f;
        T r6 = this.f17180a.poll();
        if (r6 != null) goto L10;
        boolean r8 = true;
    L11:
        if (r5 == false) goto L21;
        if (r1 == false) goto L18;
        if (r3 == false) goto L18;
        if (a(r0, r11) == true) goto L16;
        r3 = false;
        goto L18
    L16:
        return;
    L18:
        if (r8 == false) goto L21;
        d(r11);
        return;
    L21:
        if (r8 == true) goto L22;
        r11.onNext(r6);
        goto L4
    L22:
        r4 = this.i.addAndGet(-r4);
        if (r4 != 0) goto L4;
        return;
    L10:
        r8 = false;
        goto L11
    L5:
        this.f17181b.lazySet(null);
        r0.clear();
    }

    void c(t<? super T> r7) {
        t<? super T> r8 = (t) ZeusTransformUtils.wrapperContextForParams(r7, t.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.queue.a<T> r0 = this.f17180a;
        int r2 = 1;
        boolean r1 = !this.d;
    L4:
        if (this.e == true) goto L5;
        boolean r3 = this.f;
        if (r1 == false) goto L13;
        if (r3 == false) goto L13;
        if (a(r0, r8) == false) goto L13;
        return;
    L13:
        r8.onNext(null);
        if (r3 == true) goto L15;
        r2 = this.i.addAndGet(-r2);
        if (r2 != 0) goto L4;
        return;
    L15:
        d(r8);
        return;
    L5:
        this.f17181b.lazySet(null);
    }

    void d() {
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.c.get(), Runnable.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c.compareAndSet(r0, null) == false) goto L9;
        r0.run();
        return;
    }

    void d(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17181b.lazySet(null);
        Throwable r2 = this.g;
        if (r2 == null) goto L5;
        r4.onError(r2);
        return;
    L5:
        r4.onComplete();
    }

    void e() {
        if (this.i.getAndIncrement() == 0) goto L5;
        return;
    L5:
        t<? super T> r0 = (t) ZeusTransformUtils.preCheckCast(this.f17181b.get(), t.class, "com.obric.memorydata.plugin");
        int r1 = 1;
    L6:
        if (r0 != null) goto L8;
        r1 = this.i.addAndGet(-r1);
        if (r1 == 0) goto L14;
        r0 = (t) ZeusTransformUtils.preCheckCast(this.f17181b.get(), t.class, "com.obric.memorydata.plugin");
        goto L6
    L14:
        return;
    L8:
        if (this.j == false) goto L10;
        c(r0);
        return;
    L10:
        b(r0);
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L10;
        this.f = true;
        d();
        e();
        return;
    }

    @Override // io.reactivex.t
    public void onError(Throwable r2) {
        io.reactivex.internal.functions.a.a(r2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f == false) goto L5;
    L9:
        io.reactivex.d.a.a(r2);
        return;
    L5:
        if (this.e == true) goto L9;
        this.g = r2;
        this.f = true;
        d();
        e();
    }

    @Override // io.reactivex.t
    public void onNext(T r2) {
        io.reactivex.internal.functions.a.a(r2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f == false) goto L5;
        return;
    L5:
        if (this.e == true) goto L10;
        this.f17180a.offer(r2);
        e();
        return;
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.f == false) goto L5;
    L6:
        r4.dispose();
        return;
    L5:
        if (this.e == true) goto L6;
    }
}
