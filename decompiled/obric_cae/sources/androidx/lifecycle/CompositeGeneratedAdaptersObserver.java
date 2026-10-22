package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e[] f2091a;

    public CompositeGeneratedAdaptersObserver(e[] r8) {
        this.f2091a = r8;
    }

    @Override // androidx.lifecycle.k
    public final void onStateChanged(m r8, h.a r10) {
        int r11 = 0;
        new s(0);
        e[] r12 = this.f2091a;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r14].a();
        r14 = r14 + 1;
        goto L3
    L5:
        int r15 = r12.length;
    L6:
        if (r11 >= r15) goto L8;
        r12[r11].a();
        r11 = r11 + 1;
        goto L6
    }
}
