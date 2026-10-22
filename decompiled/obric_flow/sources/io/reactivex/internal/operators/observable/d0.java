package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends mt.a0 implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.n f17751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable f17752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.b f17753c;

    public d0(mt.n r5, Callable r10, pt.b r11) {
        this.f17751a = r5;
        this.f17752b = r10;
        this.f17753c = r11;
    }

    @Override // rt.b
    public final mt.n a() {
        return new z4(this.f17751a, this.f17752b, this.f17753c, 3);
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        Object r10 = this.f17752b.call();     // Catch: Throwable -> L5
        io.reactivex.internal.functions.e.d(r10, "The initialSupplier returned a null value");     // Catch: Throwable -> L5
        c0 r11 = new c0(r5, r10, this.f17753c, 1);
        this.f17751a.subscribe(r11);
        return;
    L5:
        th = move-exception;
        EmptyDisposable.error(th, r5);
    }
}
