package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f17919c;
    public final mt.y d;
    public final boolean e;
    public Disposable f;

    public q0(mt.u r5, long r10, TimeUnit r11, mt.y r12, boolean r13) {
        this.f17917a = r5;
        this.f17918b = r10;
        this.f17919c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f.dispose();
        this.d.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        k4 r5 = new k4(this, 1);
        long r10 = this.f17918b;
        TimeUnit r11 = this.f17919c;
        this.d.b(r5, r10, r11);
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        z3 r10 = new z3(1, this, r5);
        if (this.e == false) goto L5;
        long r11 = this.f17918b;
    L6:
        TimeUnit r12 = this.f17919c;
        this.d.b(r10, r11, r12);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        z3 r10 = new z3(2, this, r5);
        long r11 = this.f17918b;
        TimeUnit r12 = this.f17919c;
        this.d.b(r10, r11, r12);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f, r5) == false) goto L6;
        this.f = r5;
        this.f17917a.onSubscribe(this);
        return;
    }
}
