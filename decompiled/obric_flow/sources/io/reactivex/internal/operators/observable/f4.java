package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f4 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f17782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mt.z f17783c;
    public long d;
    public Disposable e;

    public f4(mt.u r5, TimeUnit r10, mt.z r11) {
        this.f17781a = r5;
        this.f17783c = r11;
        this.f17782b = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.e.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.e.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        this.f17781a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f17781a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        mt.z r5 = this.f17783c;
        TimeUnit r11 = this.f17782b;
        long r12 = r5.b(r11);
        long r13 = this.d;
        this.d = r12;
        ut.f r14 = new ut.f(r10, r12 - r13, r11);
        this.f17781a.onNext(r14);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.e, r5) == false) goto L6;
        this.e = r5;
        this.d = this.f17783c.b(this.f17782b);
        this.f17781a.onSubscribe(this);
        return;
    }
}
