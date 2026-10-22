package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;
import mt.b0;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends CountDownLatch implements b0, mt.b, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f17629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f17630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17631c;
    public volatile boolean d;

    public final Object a() {
        if (getCount() != 0) goto L18;
    L12:
        Throwable r5 = this.f17630b;
        if (r5 != null) goto L17;
        return this.f17629a;
    L17:
        throw io.reactivex.internal.util.d.d(r5);
    L18:
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        this.d = true;
        Disposable r10 = this.f17631c;
        if (r10 == null) goto L11;
        r10.dispose();
    L11:
        throw io.reactivex.internal.util.d.d(e);
    }

    @Override // mt.b
    public final void onComplete() {
        countDown();
    }

    @Override // mt.b0, mt.j
    public final void onError(Throwable r5) {
        this.f17630b = r5;
        countDown();
    }

    @Override // mt.b0, mt.j
    public final void onSubscribe(Disposable r5) {
        this.f17631c = r5;
        if (this.d == false) goto L6;
        r5.dispose();
        return;
    }

    @Override // mt.b0, mt.j
    public final void onSuccess(Object r5) {
        this.f17629a = r5;
        countDown();
    }
}
