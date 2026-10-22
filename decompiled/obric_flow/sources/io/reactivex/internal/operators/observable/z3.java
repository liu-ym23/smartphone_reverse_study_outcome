package io.reactivex.internal.operators.observable;

/* JADX INFO: loaded from: classes3.dex */
public final class z3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18098c;

    public /* synthetic */ z3(int r5, Object r10, Object r11) {
        this.f18096a = r5;
        this.f18098c = r10;
        this.f18097b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18096a) {
            case 0: goto L17;
            case 1: goto L10;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        x4 r5 = (x4) this.f18098c;
        r5.getClass();
        w4 r10 = new w4((io.reactivex.subjects.i) this.f18097b, false);
        r5.f17640c.offer(r10);
        if (r5.i() == false) goto L21;
        r5.t();
        return;
    L21:
        return;
    L8:
        ((q0) this.f18098c).f17917a.onNext(this.f18097b);
        return;
    L10:
        q0 r11 = (q0) this.f18098c;
        r11.f17917a.onError((Throwable) this.f18097b);     // Catch: Throwable -> L14
        r11.d.dispose();
        return;
    L14:
        th = move-exception;
        r11.d.dispose();
        throw th;
    L17:
        ((a4) this.f18098c).f17702a.subscribe((ObservableSubscribeOn$SubscribeOnObserver) this.f18097b);
    }
}
