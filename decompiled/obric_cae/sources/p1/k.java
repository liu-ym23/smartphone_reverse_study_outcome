package p1;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public final class k extends h<n1.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f9929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f9930g;

    public k(Context r8, u1.b r10) {
        super(r8, r10);
        Object r11 = this.f9923b.getSystemService("connectivity");
        he.i.d(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f9929f = (ConnectivityManager) r11;
        this.f9930g = new j(this);
    }

    @Override // p1.h
    public final n1.b a() {
        return l.a(this.f9929f);
    }

    @Override // p1.h
    public final void d() {
        androidx.work.m.d().a(l.f9931a, "Registering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        s1.l.a(this.f9929f, this.f9930g);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L13:
        return;
    L7:
        e = e;
        androidx.work.m r8 = androidx.work.m.d();
    L9:
        r8.c(l.f9931a, "Received exception while registering network callback", e);
        return;
    L5:
        e = e;
        r8 = androidx.work.m.d();
        goto L9
    }

    @Override // p1.h
    public final void e() {
        androidx.work.m.d().a(l.f9931a, "Unregistering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        s1.j.c(this.f9929f, this.f9930g);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L13:
        return;
    L7:
        e = e;
        androidx.work.m r8 = androidx.work.m.d();
    L9:
        r8.c(l.f9931a, "Received exception while unregistering network callback", e);
        return;
    L5:
        e = e;
        r8 = androidx.work.m.d();
        goto L9
    }
}
