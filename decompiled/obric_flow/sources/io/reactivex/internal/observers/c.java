package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends CountDownLatch implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f17626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f17627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f17628c;
    public volatile boolean d;
    public final /* synthetic */ int e;

    public /* synthetic */ c(int r5, int r10) {
        this.e = r10;
        super(r5);
    }

    public final Object a() {
        if (getCount() != 0) goto L15;
    L9:
        Throwable r5 = this.f17627b;
        if (r5 != null) goto L14;
        return this.f17626a;
    L14:
        throw io.reactivex.internal.util.d.d(r5);
    L15:
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        dispose();
        throw io.reactivex.internal.util.d.d(e);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.d = true;
        Disposable r5 = this.f17628c;
        if (r5 == null) goto L6;
        r5.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d;
    }

    @Override // mt.u
    public final void onComplete() {
        countDown();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.e) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        this.f17626a = null;
        this.f17627b = r5;
        countDown();
        return;
    L7:
        if (this.f17626a != null) goto L9;
        this.f17627b = r5;
    L9:
        countDown();
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.e) {
            case 0: goto L7;
            default: goto L4;
        };
    L4:
        this.f17626a = r5;
        return;
    L7:
        if (this.f17626a != null) goto L10;
        this.f17626a = r5;
        this.f17628c.dispose();
        countDown();
        return;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        this.f17628c = r5;
        if (this.d == false) goto L6;
        r5.dispose();
        return;
    }
}
