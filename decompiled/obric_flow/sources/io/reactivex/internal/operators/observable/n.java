package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mt.u f17870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableAmb$AmbInnerObserver[] f17871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f17872c;

    public n(mt.u r5, int r10) {
        this.f17872c = new AtomicInteger();
        this.f17870a = r5;
        this.f17871b = new ObservableAmb$AmbInnerObserver[r10];
    }

    public final boolean a(int r5) {
        AtomicInteger r10 = this.f17872c;
        int r11 = r10.get();
        int r12 = 0;
        if (r11 == 0) goto L5;
        if (r11 != r5) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r10.compareAndSet(0, r5) == false) goto L13;
        ObservableAmb$AmbInnerObserver[] r13 = this.f17871b;
        int r14 = r13.length;
    L7:
        if (r12 >= r14) goto L12;
        int r15 = r12 + 1;
        if (r15 == r5) goto L11;
        r13[r12].dispose();
    L11:
        r12 = r15;
        goto L7
    L12:
        return true;
    L13:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AtomicInteger r5 = this.f17872c;
        if (r5.get() == (-1)) goto L7;
        r5.lazySet(-1);
        ObservableAmb$AmbInnerObserver[] r10 = this.f17871b;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        r10[r12].dispose();
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f17872c.get() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
