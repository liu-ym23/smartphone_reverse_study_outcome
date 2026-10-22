package qs;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WindowInsets f21570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f21571c;

    public e(i r5, WindowInsets r10) {
        super(r5);
        this.f21571c = null;
        this.f21570b = r10;
    }

    @Override // qs.h
    public final b i() {
        if (this.f21571c != null) goto L6;
        WindowInsets r5 = this.f21570b;
        this.f21571c = b.a(r5.getSystemWindowInsetLeft(), r5.getSystemWindowInsetTop(), r5.getSystemWindowInsetRight(), r5.getSystemWindowInsetBottom());
    L6:
        return this.f21571c;
    }

    @Override // qs.h
    public final boolean k() {
        return this.f21570b.isRound();
    }

    @Override // qs.h
    public final void l() {
    }

    @Override // qs.h
    public final void m(i r5) {
    }
}
