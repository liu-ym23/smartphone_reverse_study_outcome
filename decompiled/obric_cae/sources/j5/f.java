package j5;

import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class f implements e.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f8661a;

    public f(e r8) {
        this.f8661a = r8;
    }

    @Override // j5.e.c
    public final boolean a(String r8, String r10) {
        return x0.e(r8, r10);
    }

    @Override // j5.e.c
    public final String b(String r8, String r10, e r11) {
        return (String) r11.g(r8, r10, new f(r11));
    }

    @Override // j5.e.c
    public final boolean c(String r8) {
        return x0.g(r8);
    }

    @Override // j5.e.c
    public final void d(String r8) {
        e r10 = this.f8661a;
        r10.b("clientudid", r8);
    }

    @Override // j5.e.c
    public final String e() {
        return this.f8661a.c("clientudid");
    }
}
