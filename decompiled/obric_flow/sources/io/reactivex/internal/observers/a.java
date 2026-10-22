package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements u, rt.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f17624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rt.c f17625c;
    public boolean d;
    public int e;

    public a(u r5) {
        this.f17623a = r5;
    }

    public final void a(Throwable r5) {
        com.lynx.jsbridge.a.t(r5);
        this.f17624b.dispose();
        onError(r5);
    }

    @Override // rt.h
    public void clear() {
        this.f17625c.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f17624b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f17624b.isDisposed();
    }

    @Override // rt.h
    public final boolean isEmpty() {
        return this.f17625c.isEmpty();
    }

    @Override // rt.h
    public final boolean offer(Object r5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // mt.u
    public void onComplete() {
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        this.f17623a.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.d == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.d = true;
        this.f17623a.onError(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f17624b, r5) == false) goto L9;
        this.f17624b = r5;
        if ((r5 instanceof rt.c) == false) goto L7;
        this.f17625c = (rt.c) r5;
    L7:
        this.f17623a.onSubscribe(this);
        return;
    }

    @Override // rt.d
    public int requestFusion(int r5) {
        rt.c r10 = this.f17625c;
        if (r10 != null) goto L5;
    L9:
        return 0;
    L5:
        if ((r5 & 4) != 0) goto L9;
        int r11 = r10.requestFusion(r5);
        if (r11 == 0) goto L11;
        this.e = r11;
        return r11;
    L11:
        return r11;
    }
}
