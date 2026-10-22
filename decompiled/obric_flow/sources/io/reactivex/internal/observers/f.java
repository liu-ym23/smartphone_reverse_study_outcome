package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends CountDownLatch implements u, Future, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f17635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f17636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f17637c;

    public f() {
        super(1);
        this.f17637c = new AtomicReference();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r5) {
    L2:
        AtomicReference r10 = this.f17637c;
        Disposable r11 = (Disposable) r10.get();
        if (r11 == this) goto L16;
        DisposableHelper r12 = DisposableHelper.DISPOSED;
        if (r11 == r12) goto L23;
    L8:
        if (r10.compareAndSet(r11, r12) == true) goto L9;
        if (r10.get() == r11) goto L8;
    L9:
        if (r11 == null) goto L11;
        r11.dispose();
    L11:
        countDown();
        return true;
    L23:
        return false;
    L16:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        if (getCount() == 0) goto L6;
        await();
    L6:
        if (isCancelled() == true) goto L14;
        Throwable r5 = this.f17636b;
        if (r5 != null) goto L12;
        return this.f17635a;
    L12:
        throw new ExecutionException(r5);
    L14:
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return DisposableHelper.isDisposed((Disposable) this.f17637c.get());
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        if (getCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.f17635a != null) goto L6;
        onError(new NoSuchElementException("The source is empty"));
        return;
    L6:
        AtomicReference r5 = this.f17637c;
        Disposable r10 = (Disposable) r5.get();
        if (r10 == this) goto L18;
        if (r10 == DisposableHelper.DISPOSED) goto L24;
    L12:
        if (r5.compareAndSet(r10, this) == true) goto L13;
        if (r5.get() == r10) goto L12;
    L13:
        countDown();
        return;
    L24:
        return;
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.f17636b != null) goto L19;
        this.f17636b = r5;
    L5:
        AtomicReference r10 = this.f17637c;
        Disposable r11 = (Disposable) r10.get();
        if (r11 == this) goto L17;
        if (r11 == DisposableHelper.DISPOSED) goto L17;
    L11:
        if (r10.compareAndSet(r11, this) == true) goto L12;
        if (r10.get() == r11) goto L11;
    L12:
        countDown();
        return;
    L17:
        wn.f.k(r5);
        return;
    L19:
        wn.f.k(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.f17635a == null) goto L6;
        ((Disposable) this.f17637c.get()).dispose();
        onError(new IndexOutOfBoundsException("More than one element received"));
        return;
    L6:
        this.f17635a = r5;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.f17637c, r5);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r5, TimeUnit r10) {
        if (getCount() == 0) goto L10;
        if (await(r5, r10) == true) goto L10;
        throw new TimeoutException(io.reactivex.internal.util.d.c(r5, r10));
    L10:
        if (isCancelled() == true) goto L18;
        Throwable r11 = this.f17636b;
        if (r11 != null) goto L16;
        return this.f17635a;
    L16:
        throw new ExecutionException(r11);
    L18:
        throw new CancellationException();
    }
}
