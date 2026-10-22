package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17798c;

    public /* synthetic */ h0(mt.n r5, Object r10, int r11) {
        this.f17797b = r11;
        super(r5);
        this.f17798c = r10;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        switch(this.f17797b) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L25;
        };
    L9:
        p3 r10 = new p3(r5, (pt.c) this.f17798c);
        this.f17702a.subscribe(r10);
        return;
    L11:
        w0 r11 = new w0(r5, (pt.g) this.f17798c, 0);
        this.f17702a.subscribe(r11);
        return;
    L13:
        SequentialDisposable r12 = new SequentialDisposable();
        r5.onSubscribe(r12);
        new ObservableRetryBiPredicate$RetryBiObserver(r5, (pt.d) this.f17798c, r12, this.f17702a).subscribeNext();
        return;
    L15:
        SequentialDisposable r13 = new SequentialDisposable();
        r5.onSubscribe(r13);
        new ObservableRepeatUntil$RepeatUntilObserver(r5, (pt.e) this.f17798c, r13, this.f17702a).subscribeNext();
        return;
    L17:
        ObservableDoFinally$DoFinallyObserver r14 = new ObservableDoFinally$DoFinallyObserver(r5, (pt.a) this.f17798c);
        this.f17702a.subscribe(r14);
        return;
    L19:
        ObservableConcatWithSingle$ConcatWithObserver r15 = new ObservableConcatWithSingle$ConcatWithObserver(r5, (mt.c0) this.f17798c);
        this.f17702a.subscribe(r15);
        return;
    L21:
        ObservableConcatWithMaybe$ConcatWithObserver r16 = new ObservableConcatWithMaybe$ConcatWithObserver(r5, (mt.k) this.f17798c);
        this.f17702a.subscribe(r16);
        return;
    L23:
        ObservableConcatWithCompletable$ConcatWithObserver r17 = new ObservableConcatWithCompletable$ConcatWithObserver(r5, (mt.c) this.f17798c);
        this.f17702a.subscribe(r17);
        return;
    L25:
        Object r18 = ((Callable) this.f17798c).call();     // Catch: Throwable -> L6
        io.reactivex.internal.functions.e.d(r18, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L6
        g2 r19 = new g2(r5, (Collection) r18, 2);
        this.f17702a.subscribe(r19);
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        EmptyDisposable.error(th, r5);
    }

    public h0(mt.s r5) {
        this.f17797b = 8;
        super(r5);
        this.f17798c = new io.reactivex.internal.functions.a(16);
    }
}
