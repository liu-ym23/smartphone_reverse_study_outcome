package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends mt.a0 implements rt.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mt.n f17860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17861c;

    public /* synthetic */ m(mt.n r5, Object r10, int r11) {
        this.f17859a = r11;
        this.f17860b = r5;
        this.f17861c = r10;
    }

    @Override // rt.b
    public final mt.n a() {
        switch(this.f17859a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new h0(this.f17860b, (Callable) this.f17861c, 8);
    L7:
        return new k(this.f17860b, (pt.p) this.f17861c, 1);
    L9:
        return new k(this.f17860b, (pt.p) this.f17861c, 0);
    }

    @Override // mt.a0
    public final void c(mt.b0 r5) {
        switch(this.f17859a) {
            case 0: goto L11;
            case 1: goto L9;
            default: goto L13;
        };
    L9:
        l r10 = new l(r5, (pt.p) this.f17861c, 1);
        this.f17860b.subscribe(r10);
        return;
    L11:
        l r11 = new l(r5, (pt.p) this.f17861c, 0);
        this.f17860b.subscribe(r11);
        return;
    L13:
        Object r12 = ((Callable) this.f17861c).call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r12, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
        g2 r13 = new g2(r5, (Collection) r12, 3);
        this.f17860b.subscribe(r13);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }

    public m(mt.n r5, int r10) {
        this.f17859a = 2;
        this.f17860b = r5;
        this.f17861c = new io.reactivex.internal.functions.a(r10);
    }
}
