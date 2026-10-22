package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.disposables.a f18150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f18151c;

    public o(ScheduledExecutorService r5) {
        this.f18149a = r5;
        this.f18150b = new io.reactivex.disposables.a();
    }

    @Override // mt.y
    public final Disposable b(Runnable r5, long r10, TimeUnit r11) {
        if (this.f18151c == true) goto L5;
        ScheduledRunnable r12 = new ScheduledRunnable(r5, this.f18150b);
        this.f18150b.b(r12);
        if (r10 > 0) goto L11;
        Future<?> r13 = this.f18149a.submit(r12);     // Catch: RejectedExecutionException -> L9
    L12:
        r12.setFuture(r13);     // Catch: RejectedExecutionException -> L9
        return r12;
    L11:
        r13 = this.f18149a.schedule(r12, r10, r11);     // Catch: RejectedExecutionException -> L9
    L9:
        e = move-exception;
        dispose();
        wn.f.k(e);
        return EmptyDisposable.INSTANCE;
    L5:
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f18151c == true) goto L6;
        this.f18151c = true;
        this.f18150b.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18151c;
    }
}
