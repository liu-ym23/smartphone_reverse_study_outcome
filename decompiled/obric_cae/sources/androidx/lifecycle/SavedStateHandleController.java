package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f2117b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2118m;

    public SavedStateHandleController(String r8, a0 r10) {
        this.f2116a = r8;
        this.f2117b = r10;
    }

    public final void b(h r8, androidx.savedstate.a r10) {
        he.i.f(r10, "registry");
        he.i.f(r8, "lifecycle");
        if ((!this.f2118m) == false) goto L7;
        this.f2118m = true;
        r8.a(this);
        r10.e(this.f2116a, this.f2117b.f2125e);
        return;
    L7:
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        if (r10 != h.a.ON_DESTROY) goto L6;
        this.f2118m = false;
        r8.getLifecycle().c(this);
        return;
    }
}
