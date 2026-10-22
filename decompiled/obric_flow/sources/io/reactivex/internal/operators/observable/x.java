package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection f18047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f18048c;

    public /* synthetic */ x(y r5, Collection r10, int r11) {
        this.f18046a = r11;
        this.f18048c = r5;
        this.f18047b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18046a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        y r5 = this.f18048c;
        monitor-enter(r5);
        this.f18048c.f18073m.remove(this.f18047b);     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        y r10 = this.f18048c;
        r10.l(this.f18047b, r10.f18072l);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        y r11 = this.f18048c;
        monitor-enter(r11);
        this.f18048c.f18073m.remove(this.f18047b);     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        y r12 = this.f18048c;
        r12.l(this.f18047b, r12.f18072l);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
