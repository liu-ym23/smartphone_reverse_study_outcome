package androidx.fragment.app;

import androidx.lifecycle.l0;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements androidx.lifecycle.f, z0.c, l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.lifecycle.k0 f1964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.lifecycle.n f1965b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z0.b f1966m;

    public g0(androidx.lifecycle.k0 r8) {
        this.f1965b = null;
        this.f1966m = null;
        this.f1964a = r8;
    }

    public final void a(androidx.lifecycle.h.a r8) {
        this.f1965b.f(r8);
    }

    public final void b() {
        if (this.f1965b != null) goto L6;
        this.f1965b = new androidx.lifecycle.n(this);
        this.f1966m = z0.b.a.a(this);
        return;
    }

    @Override // androidx.lifecycle.m
    public final androidx.lifecycle.h getLifecycle() {
        b();
        return this.f1965b;
    }

    @Override // z0.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f1966m.f14170b;
    }

    @Override // androidx.lifecycle.l0
    public final androidx.lifecycle.k0 getViewModelStore() {
        b();
        return this.f1964a;
    }
}
