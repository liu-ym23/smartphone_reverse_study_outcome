package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class k4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f17844b;

    public /* synthetic */ k4(Object r5, int r10) {
        this.f17843a = r10;
        this.f17844b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f17843a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        q0 r5 = (q0) this.f17844b;
        r5.f17917a.onComplete();     // Catch: Throwable -> L8
        r5.d.dispose();
        return;
    L8:
        th = move-exception;
        r5.d.dispose();
        throw th;
    L11:
        ((ObservableUnsubscribeOn$UnsubscribeObserver) this.f17844b).upstream.dispose();
    }
}
