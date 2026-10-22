package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends mt.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f18094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pt.c f18095c;
    public final Object d;

    public /* synthetic */ z2(mt.n r5, Object r10, pt.c r11, int r12) {
        this.f18093a = r12;
        this.f18094b = r5;
        this.d = r10;
        this.f18095c = r11;
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        switch(this.f18093a) {
            case 0: goto L9;
            default: goto L11;
        };
    L9:
        io.reactivex.internal.observers.e r10 = new io.reactivex.internal.observers.e(r5, 2, this.f18095c, this.d);
        this.f18094b.subscribe(r10);
        return;
    L11:
        Object r11 = ((Callable) this.d).call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r11, "The seedSupplier returned a null value");     // Catch: Throwable -> L6
        io.reactivex.internal.observers.e r12 = new io.reactivex.internal.observers.e(r5, 2, this.f18095c, r11);
        this.f18094b.subscribe(r12);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
