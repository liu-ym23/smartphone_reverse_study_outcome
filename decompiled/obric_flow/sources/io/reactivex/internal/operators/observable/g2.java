package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class g2 implements mt.u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f17791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17792c;
    public final Object d;

    public /* synthetic */ g2(Object r5, int r10) {
        this.f17790a = r10;
        this.d = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        switch(this.f17790a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        this.f17791b.dispose();
        return;
    L6:
        this.f17791b.dispose();
        return;
    L8:
        this.f17792c = null;
        this.f17791b.dispose();
        return;
    L10:
        this.f17791b.dispose();
        this.f17791b = DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        switch(this.f17790a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return this.f17791b.isDisposed();
    L7:
        return this.f17791b.isDisposed();
    L9:
        return this.f17791b.isDisposed();
    L11:
        if (this.f17791b != DisposableHelper.DISPOSED) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17790a) {
            case 0: goto L13;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Collection r5 = (Collection) this.f17792c;
        this.f17792c = null;
        ((mt.b0) this.d).onSuccess(r5);
        return;
    L6:
        Collection r10 = (Collection) this.f17792c;
        this.f17792c = null;
        mt.u r11 = (mt.u) this.d;
        r11.onNext(r10);
        r11.onComplete();
        return;
    L8:
        Object r12 = this.f17792c;
        mt.u r13 = (mt.u) this.d;
        if (r12 == null) goto L11;
        this.f17792c = null;
        r13.onNext(r12);
    L11:
        r13.onComplete();
        return;
    L13:
        this.f17791b = DisposableHelper.DISPOSED;
        Object r14 = this.f17792c;
        mt.j r15 = (mt.j) this.d;
        if (r14 == null) goto L16;
        this.f17792c = null;
        r15.onSuccess(r14);
        return;
    L16:
        r15.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17790a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        this.f17792c = null;
        ((mt.b0) this.d).onError(r5);
        return;
    L6:
        this.f17792c = null;
        ((mt.u) this.d).onError(r5);
        return;
    L8:
        this.f17792c = null;
        ((mt.u) this.d).onError(r5);
        return;
    L10:
        this.f17791b = DisposableHelper.DISPOSED;
        this.f17792c = null;
        ((mt.j) this.d).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17790a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        ((Collection) this.f17792c).add(r5);
        return;
    L6:
        ((Collection) this.f17792c).add(r5);
        return;
    L8:
        this.f17792c = r5;
        return;
    L10:
        this.f17792c = r5;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        switch(this.f17790a) {
            case 0: goto L17;
            case 1: goto L13;
            case 2: goto L9;
            default: goto L5;
        };
    L5:
        if (DisposableHelper.validate(this.f17791b, r5) == false) goto L20;
        this.f17791b = r5;
        ((mt.b0) this.d).onSubscribe(this);
        return;
    L20:
        return;
    L9:
        if (DisposableHelper.validate(this.f17791b, r5) == false) goto L21;
        this.f17791b = r5;
        ((mt.u) this.d).onSubscribe(this);
        return;
    L21:
        return;
    L13:
        if (DisposableHelper.validate(this.f17791b, r5) == false) goto L22;
        this.f17791b = r5;
        ((mt.u) this.d).onSubscribe(this);
        return;
    L22:
        return;
    L17:
        if (DisposableHelper.validate(this.f17791b, r5) == false) goto L23;
        this.f17791b = r5;
        ((mt.j) this.d).onSubscribe(this);
        return;
    }

    public /* synthetic */ g2(Object r5, Collection r10, int r11) {
        this.f17790a = r11;
        this.d = r5;
        this.f17792c = r10;
    }
}
