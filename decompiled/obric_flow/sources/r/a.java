package r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.f f21576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f21577b;

    public a(c r5, l.f r10) {
        this.f21577b = r5;
        this.f21576a = r10;
    }

    @Override // l.a
    public final void a() {
        if (this.f21576a.k() != 1.0f) goto L5;
        boolean r5 = true;
    L6:
        c r10 = this.f21577b;
        if (r5 == r10.f21595u) goto L10;
        r10.f21595u = r5;
        r10.f21588m.invalidateSelf();
        return;
    L10:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
