package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f17679b;

    public /* synthetic */ b(AtomicReference r5, int r10) {
        this.f17678a = r10;
        this.f17679b = r5;
    }

    @Override // mt.j
    public final void onComplete() {
        switch(this.f17678a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((MaybeFlatten$FlatMapMaybeObserver) this.f17679b).downstream.onComplete();
        return;
    L6:
        ((MaybeFlatMapNotification$FlatMapMaybeObserver) this.f17679b).downstream.onComplete();
    }

    @Override // mt.j
    public final void onError(Throwable r5) {
        switch(this.f17678a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((MaybeFlatten$FlatMapMaybeObserver) this.f17679b).downstream.onError(r5);
        return;
    L6:
        ((MaybeFlatMapNotification$FlatMapMaybeObserver) this.f17679b).downstream.onError(r5);
    }

    @Override // mt.j
    public final void onSubscribe(Disposable r5) {
        switch(this.f17678a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.setOnce((MaybeFlatten$FlatMapMaybeObserver) this.f17679b, r5);
        return;
    L6:
        DisposableHelper.setOnce((MaybeFlatMapNotification$FlatMapMaybeObserver) this.f17679b, r5);
    }

    @Override // mt.j
    public final void onSuccess(Object r5) {
        switch(this.f17678a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((MaybeFlatten$FlatMapMaybeObserver) this.f17679b).downstream.onSuccess(r5);
        return;
    L6:
        ((MaybeFlatMapNotification$FlatMapMaybeObserver) this.f17679b).downstream.onSuccess(r5);
    }
}
