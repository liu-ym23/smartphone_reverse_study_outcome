package c;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes.dex */
public final class p0 implements mt.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f1075a;

    public p0(q0 r5) {
        this.f1075a = r5;
    }

    @Override // mt.u
    public final void onComplete() {
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        this.f1075a.onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        this.f1075a.a(r5);
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
    }
}
