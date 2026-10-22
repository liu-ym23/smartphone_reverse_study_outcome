package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public final class q extends he.j implements ge.a<xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f503a;

    public q(OnBackPressedDispatcher r8) {
        this.f503a = r8;
        super(0);
    }

    @Override // ge.a
    public final xd.j f() {
        this.f503a.b();
        return xd.j.f13877a;
    }
}
