package cf;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3551b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ p.f f3552m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g.h f3553n;

    public m(g.h r8, Object[] r10, p.f r11) {
        this.f3553n = r8;
        this.f3551b = false;
        this.f3552m = r11;
        super("OkHttp %s ACK Settings", r10);
    }

    @Override // xe.b
    public final void a() {
        boolean r8 = this.f3551b;
        p.f r10 = this.f3552m;
        this.f3553n.b(r8, r10);
    }
}
