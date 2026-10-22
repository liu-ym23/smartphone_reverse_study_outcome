package z5;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b6.d f14275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.e f14276b;

    public m(b.e r8, b6.c r10) {
        this.f14276b = r8;
        this.f14275a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.e r8 = this.f14276b;
        b6.c r10 = b.a(r8.f14247c);
        if (this.f14275a == r10) goto L6;
        return;
    L6:
        if (b.m(r8.f14247c).a() == false) goto L9;
        b.m(r8.f14247c).b();
        return;
    L9:
        ((h6.b) b.c(r8.f14247c)).e();
    }
}
