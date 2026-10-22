package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17886c;

    public /* synthetic */ o(int r5, Object r10, Object r11) {
        this.f17884a = r5;
        this.f17885b = r10;
        this.f17886c = r11;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17884a) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L60;
            default: goto L64;
        };
    L22:
        SequentialDisposable r5 = new SequentialDisposable();
        r10.onSubscribe(r5);
        ((mt.s) this.f17886c).subscribe(new r0(this, r5, r10));
        return;
    L24:
        mt.s[] r11 = (mt.s[]) this.f17885b;
        int r12 = 0;
        if (r11 != null) goto L41;
        r11 = new mt.n[8];
        Iterator r13 = ((Iterable) this.f17886c).iterator();     // Catch: Throwable -> L33
        int r14 = 0;
    L29:
        if (r13.hasNext() == false) goto L42;
        mt.s r15 = (mt.s) r13.next();     // Catch: Throwable -> L33
        if (r15 == null) goto L32;
        if (r14 != r11.length) goto L38;
        mt.s[] r16 = new mt.s[(r14 >> 2) + r14];     // Catch: Throwable -> L33
        System.arraycopy(r11, 0, r16, 0, r14);     // Catch: Throwable -> L33
        r11 = r16;
    L38:
        int r17 = r14 + 1;     // Catch: Throwable -> L33
        r11[r14] = r15;     // Catch: Throwable -> L33
        r14 = r17;
        goto L29
    L32:
        EmptyDisposable.error(new NullPointerException("One of the sources is null"), r10);     // Catch: Throwable -> L33
        return;
    L42:
        if (r14 != 0) goto L45;
        EmptyDisposable.complete(r10);
        return;
    L45:
        if (r14 != 1) goto L47;
        r11[0].subscribe(r10);
        return;
    L47:
        n r18 = new n(r10, r14);
        ObservableAmb$AmbInnerObserver[] r19 = r18.f17871b;
        int r20 = r19.length;
        int r21 = 0;
    L48:
        mt.u r22 = r18.f17870a;
        if (r21 >= r20) goto L51;
        int r23 = r21 + 1;
        r19[r21] = new ObservableAmb$AmbInnerObserver(r18, r23, r22);
        r21 = r23;
        goto L48
    L51:
        AtomicInteger r24 = r18.f17872c;
        r24.lazySet(0);
        r22.onSubscribe(r18);
    L52:
        if (r12 >= r20) goto L79;
        if (r24.get() != 0) goto L80;
        r11[r12].subscribe(r19[r12]);
        r12 = r12 + 1;
        goto L52
    L80:
        return;
    L79:
        return;
    L33:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r10);
        return;
    L41:
        r14 = r11.length;
        goto L42
    L60:
        Object r25 = ((Callable) this.f17885b).call();     // Catch: Throwable -> L19
        io.reactivex.internal.functions.e.d(r25, "The connectableFactory returned a null ConnectableObservable");     // Catch: Throwable -> L19
        st.a r26 = (st.a) r25;     // Catch: Throwable -> L19
        Object r27 = ((pt.o) this.f17886c).apply(r26);     // Catch: Throwable -> L19
        io.reactivex.internal.functions.e.d(r27, "The selector returned a null ObservableSource");     // Catch: Throwable -> L19
        mt.s r28 = (mt.s) r27;     // Catch: Throwable -> L19
        ObserverResourceWrapper r29 = new ObserverResourceWrapper(r10);
        r28.subscribe(r29);
        r26.d(new b2(r29, 2));
        return;
    L19:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r10);
        return;
    L64:
        Object r30 = ((pt.o) this.f17886c).apply(this.f17885b);     // Catch: Throwable -> L14
        io.reactivex.internal.functions.e.d(r30, "The mapper returned a null ObservableSource");     // Catch: Throwable -> L14
        mt.s r31 = (mt.s) r30;     // Catch: Throwable -> L14
        if ((r31 instanceof Callable) == true) goto L58;
        r31.subscribe(r10);
        return;
    L58:
        Object r32 = ((Callable) r31).call();     // Catch: Throwable -> L11
        if (r32 != null) goto L10;
        EmptyDisposable.complete(r10);
        return;
    L10:
        ObservableScalarXMap$ScalarDisposable r33 = new ObservableScalarXMap$ScalarDisposable(r10, r32);
        r10.onSubscribe(r33);
        r33.run();
        return;
    L11:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r10);
        return;
    L14:
        th = move-exception;
        EmptyDisposable.error(th, r10);
    }
}
