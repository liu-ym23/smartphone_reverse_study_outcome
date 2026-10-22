package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.disposables.a f18133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f18134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f18135c;
    public final AtomicBoolean d;

    public g(f r5) {
        this.d = new AtomicBoolean();
        this.f18134b = r5;
        this.f18133a = new io.reactivex.disposables.a();
        if (r5.f18132c.f17606b == false) goto L6;
        h r10 = i.g;
    L11:
        this.f18135c = r10;
        return;
    L6:
        if (r5.f18131b.isEmpty() == true) goto L10;
        h r11 = (h) r5.f18131b.poll();
        if (r11 == null) goto L6;
    L9:
        r10 = r11;
        goto L11
    L10:
        r11 = new h(r5.f);
        r5.f18132c.b(r11);
        goto L9
    }

    @Override // mt.y
    public final Disposable b(Runnable r10, long r11, TimeUnit r12) {
        if (this.f18133a.f17606b == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return this.f18135c.d(r10, r11, r12, this.f18133a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.d.compareAndSet(false, true) == false) goto L6;
        this.f18133a.dispose();
        f r5 = this.f18134b;
        r5.getClass();
        long r10 = System.nanoTime() + r5.f18130a;
        h r11 = this.f18135c;
        r11.f18136c = r10;
        r5.f18131b.offer(r11);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d.get();
    }
}
