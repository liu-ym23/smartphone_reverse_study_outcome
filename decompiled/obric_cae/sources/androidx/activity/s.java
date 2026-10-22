package androidx.activity;

/* JADX INFO: loaded from: classes.dex */
public final class s extends he.j implements ge.a<xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f533a;

    public s(OnBackPressedDispatcher r8) {
        this.f533a = r8;
        super(0);
    }

    @Override // ge.a
    public final xd.j f() {
        this.f533a.b();
        return xd.j.f13877a;
    }
}
