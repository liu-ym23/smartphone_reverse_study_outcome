package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0.d f1961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.d f1962b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1963m;

    public g(i0.d r8, i0.d r10, boolean r11, n.b r12) {
        this.f1961a = r8;
        this.f1962b = r10;
        this.f1963m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0.a(this.f1961a.f1985c, this.f1962b.f1985c, this.f1963m);
    }
}
