package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f17774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f17775b;

    @Override // mt.u
    public final void onComplete() {
        this.f17775b = NotificationLite.complete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f17775b = NotificationLite.error(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f17775b = NotificationLite.next(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        Disposable r10 = this.f17774a;
        io.reactivex.internal.functions.e.d(r5, "next is null");
        if (r10 == null) goto L7;
        r5.dispose();
        if (r10 == DisposableHelper.DISPOSED) goto L9;
        com.lynx.tasm.behavior.ui.utils.e.p(f.class);
        return;
    L9:
        return;
    L7:
        this.f17774a = r5;
    }
}
