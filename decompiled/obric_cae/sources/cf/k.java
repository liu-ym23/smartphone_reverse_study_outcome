package cf;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3547b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g f3548m;

    public k(g r8, Object[] r10, int r11, b r12) {
        this.f3548m = r8;
        this.f3547b = r11;
        super("OkHttp %s Push Reset[%s]", r10);
    }

    @Override // xe.b
    public final void a() {
        this.f3548m.f3508t.getClass();
        g r8 = this.f3548m;
        monitor-enter(r8);
        this.f3548m.H.remove(Integer.valueOf(this.f3547b));     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
