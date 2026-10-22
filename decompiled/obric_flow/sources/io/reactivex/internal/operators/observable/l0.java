package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17849b;

    public /* synthetic */ l0(Object r5, int r10) {
        this.f17848a = r10;
        this.f17849b = r5;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17848a) {
            case 0: goto L50;
            case 1: goto L35;
            case 2: goto L59;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        ((mt.s) this.f17849b).subscribe(r5);
        return;
    L6:
        m1 r10 = new m1(r5);
        ((zu.b) this.f17849b).subscribe(r10);
        return;
    L35:
        Object[] r11 = (Object[]) this.f17849b;
        j1 r12 = new j1(r5, r11);
        r5.onSubscribe(r12);
        if (r12.d == true) goto L87;
        int r13 = r11.length;
        int r14 = 0;
    L39:
        if (r14 >= r13) goto L47;
        if (r12.e == true) goto L47;
        Object r15 = r11[r14];
        if (r15 == null) goto L44;
        r12.f17826a.onNext(r15);
        r14 = r14 + 1;
        goto L39
    L44:
        r12.f17826a.onError(new NullPointerException(ai.j0.h(r14, "The element at index ", " is null")));
        return;
    L47:
        if (r12.e == true) goto L86;
        r12.f17826a.onComplete();
        return;
    L86:
        return;
    L87:
        return;
    L50:
        ObservableCreate$CreateEmitter r16 = new ObservableCreate$CreateEmitter(r5);
        r5.onSubscribe(r16);
        Object r17 = ((c.q0) ((com.lynx.tasm.behavior.x0) ((mt.q) this.f17849b)).f10812a).a();     // Catch: Throwable -> L56
        if (r17 == null) goto L54;
        r16.onNext(r17);     // Catch: Throwable -> L56
    L54:
        r16.onComplete();     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r16.onError(th);
        return;
    L59:
        Iterator r18 = ((Iterable) this.f17849b).iterator();     // Catch: Throwable -> L32
        if (r18.hasNext() == true) goto L12;
        EmptyDisposable.complete(r5);
        return;
    L12:
        l1 r19 = new l1(r5, r18);
        r5.onSubscribe(r19);
        if (r19.d == false) goto L15;
        return;
    L15:
        if (r19.f17852c == true) goto L84;
        Object r20 = r19.f17851b.next();     // Catch: Throwable -> L28
        io.reactivex.internal.functions.e.d(r20, "The iterator returned a null value");     // Catch: Throwable -> L28
        r19.f17850a.onNext(r20);
        if (r19.f17852c == true) goto L83;
        if (r19.f17851b.hasNext() == true) goto L15;
        if (r19.f17852c == true) goto L78;
        r19.f17850a.onComplete();
        return;
    L78:
        return;
    L26:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r19.f17850a.onError(th);
        return;
    L83:
        return;
    L28:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r19.f17850a.onError(th);
        return;
    L84:
        return;
    L30:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
        return;
    L32:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }
}
