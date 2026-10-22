package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f2115a;

    public SavedStateHandleAttacher(c0 r8) {
        this.f2115a = r8;
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        if (r10 != h.a.ON_CREATE) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L12;
        r8.getLifecycle().c(this);
        c0 r12 = this.f2115a;
        if (r12.f2138b == true) goto L13;
        r12.f2139c = r12.f2137a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        r12.f2138b = true;
        d0 r13 = (d0) r12.f2140d.getValue();
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + r10).toString());
    L5:
        r11 = false;
        goto L6
    }
}
