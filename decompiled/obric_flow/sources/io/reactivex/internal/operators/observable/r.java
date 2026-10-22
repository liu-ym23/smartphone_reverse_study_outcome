package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17938c;
    public final pt.o d;
    public final Object e;

    public /* synthetic */ r(mt.n r5, mt.s r10, pt.o r11, Object r12, int r13) {
        this.f17937b = r13;
        super(r5);
        this.f17938c = r10;
        this.d = r11;
        this.e = r12;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        switch(this.f17937b) {
            case 0: goto L31;
            case 1: goto L26;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        pt.o r5 = (pt.o) this.f17938c;
        Callable r11 = (Callable) this.e;
        j2 r12 = new j2(r10, this.d, r5, r11);
        this.f17702a.subscribe(r12);
        return;
    L6:
        mt.s[] r13 = (mt.s[]) this.e;
        if (r13 != null) goto L20;
        r13 = new mt.s[8];
        Iterator r14 = ((Iterable) this.f17938c).iterator();     // Catch: Throwable -> L15
        int r15 = 0;
    L10:
        if (r14.hasNext() == false) goto L21;
        mt.s r16 = (mt.s) r14.next();     // Catch: Throwable -> L15
        if (r15 != r13.length) goto L17;
        r13 = (mt.s[]) Arrays.copyOf(r13, (r15 >> 1) + r15);     // Catch: Throwable -> L15
    L17:
        int r17 = r15 + 1;     // Catch: Throwable -> L15
        r13[r15] = r16;     // Catch: Throwable -> L15
        r15 = r17;
    L21:
        mt.s r18 = this.f17702a;
        if (r15 != 0) goto L24;
        new v2(r18, new b2(this, 3), 4).subscribeActual(r10);
        return;
    L24:
        ObservableWithLatestFromMany$WithLatestFromObserver r19 = new ObservableWithLatestFromMany$WithLatestFromObserver(r10, this.d, r15);
        r10.onSubscribe(r19);
        r19.subscribe(r13, r15);
        r18.subscribe(r19);
        return;
    L15:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r10);
        return;
    L20:
        r15 = r13.length;
        goto L21
    L26:
        mt.s r20 = this.f17702a;
        mt.s r21 = (mt.s) this.f17938c;
        pt.o r22 = this.d;
        mt.s r23 = (mt.s) this.e;
        if (r23 != null) goto L29;
        ObservableTimeout$TimeoutObserver r24 = new ObservableTimeout$TimeoutObserver(r10, r22);
        r10.onSubscribe(r24);
        r24.startFirstTimeout(r21);
        r20.subscribe(r24);
        return;
    L29:
        ObservableTimeout$TimeoutFallbackObserver r25 = new ObservableTimeout$TimeoutFallbackObserver(r10, r22, r23);
        r10.onSubscribe(r25);
        r25.startFirstTimeout(r21);
        r20.subscribe(r25);
        return;
    L31:
        pt.o r26 = this.d;
        Callable r27 = (Callable) this.e;
        ObservableBufferBoundary$BufferBoundaryObserver r28 = new ObservableBufferBoundary$BufferBoundaryObserver(r10, (mt.s) this.f17938c, r26, r27);
        r10.onSubscribe(r28);
        this.f17702a.subscribe(r28);
    }

    public r(mt.n r5, pt.o r10, pt.o r11, Callable r12) {
        this.f17937b = 3;
        super(r5);
        this.d = r10;
        this.f17938c = r11;
        this.e = r12;
    }

    public r(mt.n r5, mt.s[] r10, pt.o r11) {
        this.f17937b = 2;
        super(r5);
        this.e = r10;
        this.f17938c = null;
        this.d = r11;
    }

    public r(mt.n r5, Iterable r10, pt.o r11) {
        this.f17937b = 2;
        super(r5);
        this.e = null;
        this.f17938c = r10;
        this.d = r11;
    }
}
