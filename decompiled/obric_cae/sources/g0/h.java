package g0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements i0.a<k.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f7514a;

    public h(c r8) {
        this.f7514a = r8;
    }

    @Override // i0.a
    public final void accept(k.a r8) {
        k.a r10 = r8;
        if (r10 != null) goto L5;
        r10 = new k.a(-3);
    L5:
        this.f7514a.a(r10);
    }
}
