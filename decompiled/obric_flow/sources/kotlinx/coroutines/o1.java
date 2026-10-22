package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends m1 {
    public final r1 e;
    public final p1 f;
    public final p g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f18983h;

    public o1(r1 r5, p1 r10, p r11, Object r12) {
        this.e = r5;
        this.f = r10;
        this.g = r11;
        this.f18983h = r12;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        return false;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r10) {
        p r11 = this.g;
        r1 r5 = this.e;
        r5.getClass();
        p r12 = r1.Q(r11);
        p1 r13 = this.f;
        Object r14 = this.f18983h;
        if (r12 != null) goto L5;
    L7:
        r13.f18986a.c(new kotlinx.coroutines.internal.h(2), 2);
        p r15 = r1.Q(r11);
        if (r15 != null) goto L10;
    L12:
        r5.t(r5.D(r13, r14));
        return;
    L10:
        if (r5.a0(r13, r15, r14) == false) goto L12;
        return;
    L5:
        if (r5.a0(r13, r12, r14) == false) goto L7;
    }
}
