package q;

import com.airbnb.lottie.w;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.e f21392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f21393c;
    public final boolean d;
    public final boolean e;

    public a(String r5, p.e r10, p.a r11, boolean r12, boolean r13) {
        this.f21391a = r5;
        this.f21392b = r10;
        this.f21393c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new k.f(r5, r10, this);
    }
}
