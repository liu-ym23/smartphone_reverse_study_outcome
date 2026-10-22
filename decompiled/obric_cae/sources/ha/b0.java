package ha;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends c0<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f7963a;

    public b0(c0 r8) {
        this.f7963a = r8;
    }

    @Override // ha.c0
    public final Object a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L7;
        r8.V();
        return null;
    L7:
        return this.f7963a.a(r8);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Object r10) {
        if (r10 != null) goto L4;
        r8.z();
        return;
    L4:
        this.f7963a.b(r8, r10);
    }
}
