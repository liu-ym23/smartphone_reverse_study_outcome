package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends io.reactivex.observers.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.reactivex.internal.observers.h f17981c;

    public /* synthetic */ u(io.reactivex.internal.observers.h r5, int r10) {
        this.f17980b = r10;
        this.f17981c = r5;
    }

    @Override // mt.u
    public final void onComplete() {
        switch(this.f17980b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((q4) this.f17981c).onComplete();
        return;
    L6:
        ((t) this.f17981c).onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        switch(this.f17980b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        q4 r10 = (q4) this.f17981c;
        r10.f17932l.dispose();
        r10.f17931k.dispose();
        r10.onError(r5);
        return;
    L6:
        ((t) this.f17981c).onError(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        switch(this.f17980b) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        q4 r10 = (q4) this.f17981c;
        r10.getClass();
        r4 r11 = new r4(null, r5);
        r10.f17640c.offer(r11);
        if (r10.i() == false) goto L30;
        r10.t();
        return;
    L30:
        return;
    L8:
        t r12 = (t) this.f17981c;
        r12.getClass();
        Object r13 = r12.f17964i.call();     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r13, "The buffer supplied is null");     // Catch: Throwable -> L22
        Collection r14 = (Collection) r13;     // Catch: Throwable -> L22
        monitor-enter(r12);
        Object r15 = r12.f17966k;     // Catch: Throwable -> L15
        if (r15 != null) goto L17;
        monitor-exit(r12);     // Catch: Throwable -> L15
    L27:
        return;
    L17:
        r12.f17966k = r14;     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        r12.k(r15, r12);
    L15:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r12.dispose();
        r12.f17639b.onError(th);
    }
}
