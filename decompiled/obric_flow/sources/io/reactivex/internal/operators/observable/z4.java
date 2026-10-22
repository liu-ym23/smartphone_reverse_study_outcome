package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class z4 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f18100c;
    public final Object d;

    public /* synthetic */ z4(mt.n r5, Object r10, Object r11, int r12) {
        this.f18099b = r12;
        super(r5);
        this.f18100c = r10;
        this.d = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f18099b) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L33;
            default: goto L4;
        };
    L4:
        f4 r10 = new f4(r5, (TimeUnit) this.d, (mt.z) this.f18100c);
        this.f17702a.subscribe(r10);
        return;
    L11:
        io.reactivex.internal.observers.e r11 = new io.reactivex.internal.observers.e(r5, 0, (pt.g) this.f18100c, (pt.a) this.d);
        this.f17702a.subscribe(r11);
        return;
    L13:
        v0 r12 = new v0(r5, (pt.o) this.f18100c, (pt.d) this.d);
        this.f17702a.subscribe(r12);
        return;
    L25:
        t r13 = new t(new io.reactivex.observers.d(r5), (Callable) this.f18100c, (mt.s) this.d);
        this.f17702a.subscribe(r13);
        return;
    L27:
        t r14 = new t(new io.reactivex.observers.d(r5), (Callable) this.d, (Callable) this.f18100c);
        this.f17702a.subscribe(r14);
        return;
    L29:
        io.reactivex.observers.d r15 = new io.reactivex.observers.d(r5);
        ObservableWithLatestFrom$WithLatestFromObserver r16 = new ObservableWithLatestFrom$WithLatestFromObserver(r15, (pt.c) this.f18100c);
        r15.onSubscribe(r16);
        o3 r17 = new o3(r16, 1);
        ((mt.s) this.d).subscribe(r17);
        this.f17702a.subscribe(r16);
        return;
    L31:
        Object r18 = ((Callable) this.d).call();     // Catch: Throwable -> L17
        io.reactivex.internal.functions.e.d(r18, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L17
        Collection r19 = (Collection) r18;     // Catch: Throwable -> L17
        u0 r20 = new u0(r5, (pt.o) this.f18100c, r19);
        this.f17702a.subscribe(r20);
        return;
    L17:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return;
    L33:
        Object r21 = ((Callable) this.d).call();     // Catch: Throwable -> L8
        io.reactivex.internal.functions.e.d(r21, "The seed supplied is null");     // Catch: Throwable -> L8
        p3 r22 = new p3(r5, (pt.c) this.f18100c, r21);
        this.f17702a.subscribe(r22);
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return;
    L35:
        Object r23 = ((Callable) this.f18100c).call();     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r23, "The initialSupplier returned a null value");     // Catch: Throwable -> L22
        c0 r24 = new c0(r5, r23, (pt.b) this.d, 0);
        this.f17702a.subscribe(r24);
        return;
    L22:
        th = move-exception;
        EmptyDisposable.error(th, r5);
    }

    public /* synthetic */ z4(mt.n r5, Object r10, Object r11, int r12, boolean r13) {
        this.f18099b = r12;
        super(r5);
        this.d = r10;
        this.f18100c = r11;
    }
}
