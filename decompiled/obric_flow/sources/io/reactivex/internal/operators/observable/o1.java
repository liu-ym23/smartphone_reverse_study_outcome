package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pt.c f17892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17893c;
    public final Object d;

    public o1(Callable r5, pt.c r10, pt.g r11) {
        this.f17891a = 0;
        this.f17893c = r5;
        this.f17892b = r10;
        this.d = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17891a) {
            case 0: goto L33;
            default: goto L31;
        };
    L31:
        Iterator r10 = ((Iterable) this.d).iterator();     // Catch: Throwable -> L11
        io.reactivex.internal.functions.e.d(r10, "The iterator returned by other is null");     // Catch: Throwable -> L11
        if (r10.hasNext() == true) goto L8;
        EmptyDisposable.complete(r5);
        return;
    L8:
        c0 r11 = new c0(r5, r10, this.f17892b);
        ((mt.n) this.f17893c).subscribe(r11);
        return;
    L9:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return;
    L33:
        Object r12 = ((Callable) this.f17893c).call();     // Catch: Throwable -> L28
        pt.c r13 = this.f17892b;
        n1 r14 = new n1(r5, r13, (pt.g) this.d, r12);
        r5.onSubscribe(r14);
        Object r15 = r14.f17878c;
        if (r14.d == false) goto L19;
        r14.f17878c = null;
        r14.a(r15);
        return;
    L19:
        if (r14.d == true) goto L20;
        r15 = r13.apply(r15, r14);     // Catch: Throwable -> L26
        if (r14.e == false) goto L19;
        r14.d = true;
        r14.f17878c = null;
        r14.a(r15);
        return;
    L26:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r14.f17878c = null;
        r14.d = true;
        r14.onError(th);
        r14.a(r15);
        return;
    L20:
        r14.f17878c = null;
        r14.a(r15);
        return;
    L28:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }

    public o1(mt.n r5, Iterable r10, pt.c r11) {
        this.f17891a = 1;
        this.f17893c = r5;
        this.d = r10;
        this.f17892b = r11;
    }
}
