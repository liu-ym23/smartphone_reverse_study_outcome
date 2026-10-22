package l9;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19559b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f19558a = r10;
        this.f19559b = r5;
    }

    @Override // l9.b
    public final void a() {
        switch(this.f19558a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((i) this.f19559b).e();
        return;
    L6:
        ((g) this.f19559b).c();
    }

    @Override // l9.b
    public final void b() {
        switch(this.f19558a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((i) this.f19559b).e();
        return;
    L6:
        ((g) this.f19559b).c();
    }
}
