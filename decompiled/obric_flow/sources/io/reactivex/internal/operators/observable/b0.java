package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends a implements mt.u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ObservableCache$CacheDisposable[] f17719k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ObservableCache$CacheDisposable[] f17720l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f17721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17722c;
    public final AtomicReference d;
    public volatile long e;
    public final a0 f;
    public a0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f17724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f17725j;

    static {
        f17719k = new ObservableCache$CacheDisposable[0];
        f17720l = new ObservableCache$CacheDisposable[0];
    }

    public b0(mt.n r5, int r10) {
        super(r5);
        this.f17722c = r10;
        this.f17721b = new AtomicBoolean();
        a0 r11 = new a0(r10);
        this.f = r11;
        this.g = r11;
        this.d = new AtomicReference(f17719k);
    }

    public final void d(ObservableCache$CacheDisposable r13) {
        if (r13.getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r5 = r13.index;
        int r10 = r13.offset;
        a0 r11 = r13.node;
        mt.u r12 = r13.downstream;
        int r14 = this.f17722c;
        int r15 = 1;
    L7:
        if (r13.disposed == true) goto L8;
        boolean r16 = this.f17725j;
        if (this.e != r5) goto L13;
        boolean r17 = true;
    L14:
        if (r16 == false) goto L21;
        if (r17 == false) goto L21;
        r13.node = null;
        Throwable r18 = this.f17724i;
        if (r18 == null) goto L19;
        r12.onError(r18);
        return;
    L19:
        r12.onComplete();
        return;
    L21:
        if (r17 == false) goto L22;
        r13.index = r5;
        r13.offset = r10;
        r13.node = r11;
        r15 = r13.addAndGet(-r15);
        if (r15 != 0) goto L7;
        return;
    L22:
        if (r10 != r14) goto L24;
        r11 = r11.f17704b;
        r10 = 0;
    L24:
        r12.onNext(r11.f17703a[r10]);
        r10 = r10 + 1;
        r5 = r5 + 1;
        goto L7
    L13:
        r17 = false;
        goto L14
    L8:
        r13.node = null;
    }

    @Override // mt.u
    public final void onComplete() {
        this.f17725j = true;
        ObservableCache$CacheDisposable[] r5 = (ObservableCache$CacheDisposable[]) this.d.getAndSet(f17720l);
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        d(r5[r11]);
        r11 = r11 + 1;
        goto L3
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f17724i = r5;
        this.f17725j = true;
        ObservableCache$CacheDisposable[] r10 = (ObservableCache$CacheDisposable[]) this.d.getAndSet(f17720l);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        d(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        int r5 = this.f17723h;
        int r11 = 0;
        if (r5 != this.f17722c) goto L5;
        a0 r12 = new a0(r5);
        r12.f17703a[0] = r10;
        this.f17723h = 1;
        this.g.f17704b = r12;
        this.g = r12;
    L6:
        this.e++;
        ObservableCache$CacheDisposable[] r13 = (ObservableCache$CacheDisposable[]) this.d.get();
        int r14 = r13.length;
    L7:
        if (r11 >= r14) goto L9;
        d(r13[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return;
    L5:
        this.g.f17703a[r5] = r10;
        this.f17723h = r5 + 1;
        goto L6
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        ObservableCache$CacheDisposable r5 = new ObservableCache$CacheDisposable(r10, this);
        r10.onSubscribe(r5);
    L3:
        AtomicReference r11 = this.d;
        ObservableCache$CacheDisposable[] r12 = (ObservableCache$CacheDisposable[]) r11.get();
        if (r12 == f17720l) goto L9;
        int r13 = r12.length;
        ObservableCache$CacheDisposable[] r14 = new ObservableCache$CacheDisposable[r13 + 1];
        System.arraycopy(r12, 0, r14, 0, r13);
        r14[r13] = r5;
    L8:
        if (r11.compareAndSet(r12, r14) == true) goto L9;
        if (r11.get() == r12) goto L8;
    L9:
        AtomicBoolean r15 = this.f17721b;
        if (r15.get() == false) goto L12;
    L14:
        d(r5);
        return;
    L12:
        if (r15.compareAndSet(false, true) == false) goto L14;
        this.f17702a.subscribe(this);
    }
}
