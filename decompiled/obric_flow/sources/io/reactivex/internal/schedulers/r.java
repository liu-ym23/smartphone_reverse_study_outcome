package io.reactivex.internal.schedulers;

import com.lynx.tasm.ui.image.v;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f18157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f18158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f18159c;
    public volatile boolean d;

    public r() {
        this.f18157a = new PriorityBlockingQueue();
        this.f18158b = new AtomicInteger();
        this.f18159c = new AtomicInteger();
    }

    @Override // mt.y
    public final Disposable a(Runnable r5) {
        TimeUnit r10 = TimeUnit.MILLISECONDS;
        return d(r10.convert(System.currentTimeMillis(), r10), r5);
    }

    @Override // mt.y
    public final Disposable b(Runnable r5, long r10, TimeUnit r11) {
        TimeUnit r12 = TimeUnit.MILLISECONDS;
        long r13 = r12.convert(System.currentTimeMillis(), r12);
        long r14 = r11.toMillis(r10) + r13;
        return d(r14, new com.bytedance.iesgurd.request.e(r5, this, r14));
    }

    public final Disposable d(long r5, Runnable r10) {
        if (this.d == true) goto L5;
        q r11 = new q(r10, Long.valueOf(r5), this.f18159c.incrementAndGet());
        this.f18157a.add(r11);
        if (this.f18158b.getAndIncrement() != 0) goto L23;
        int r12 = 1;
    L10:
        if (this.d == true) goto L11;
        q r13 = (q) this.f18157a.poll();
        if (r13 == null) goto L15;
        if (r13.d == true) goto L10;
        r13.f18154a.run();
        goto L10
    L15:
        r12 = this.f18158b.addAndGet(-r12);
        if (r12 != 0) goto L10;
        return EmptyDisposable.INSTANCE;
    L11:
        this.f18157a.clear();
        return EmptyDisposable.INSTANCE;
    L23:
        return io.reactivex.disposables.b.a(new v(11, this, r11));
    L5:
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }
}
