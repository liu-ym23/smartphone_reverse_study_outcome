package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import mt.y;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qt.b f18119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.disposables.a f18120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qt.b f18121c;
    public final c d;
    public volatile boolean e;

    public a(c r5) {
        this.d = r5;
        qt.b r10 = new qt.b();
        this.f18119a = r10;
        io.reactivex.disposables.a r11 = new io.reactivex.disposables.a();
        this.f18120b = r11;
        qt.b r12 = new qt.b();
        this.f18121c = r12;
        r12.b(r10);
        r12.b(r11);
    }

    @Override // mt.y
    public final Disposable a(Runnable r10) {
        if (this.e == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return this.d.d(r10, 0, TimeUnit.MILLISECONDS, this.f18119a);
    }

    @Override // mt.y
    public final Disposable b(Runnable r10, long r11, TimeUnit r12) {
        if (this.e == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return this.d.d(r10, r11, r12, this.f18120b);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.e == true) goto L6;
        this.e = true;
        this.f18121c.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.e;
    }
}
