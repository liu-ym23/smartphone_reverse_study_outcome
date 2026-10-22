package x4;

import android.app.Application;
import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r0 implements i5.b, q0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i0 f13544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z4.c f13545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13546c;

    public r0(j r8) {
        this.f13546c = r8;
        int r10 = r.f13543a;
    }

    @Override // i5.b
    public final boolean a() {
        return false;
    }

    @Override // i5.b
    public final void b(HashMap r8) {
    }

    @Override // i5.b
    public final void c(Application r8, HashMap r10) {
    }

    @Override // i5.b
    public final i0 d() {
        i0 r8 = this.f13544a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.a();
    }

    @Override // i5.b
    public final boolean e(JSONObject r8) {
        return false;
    }

    @Override // i5.b
    public final void f(j0 r8, s r10) {
        Context r11 = r8.f13465c;
        q0 r12 = new q0(r11);
        r12.f13542b = r8;
        v0.a(r11).b(r12.f13542b.a(), "install_info", new p0(this));
        m.b(r8);
        i5.d.b(p.class, new n(r8), String.valueOf(r8.f13463a));
    }

    @Override // i5.b
    public final void g(s r8) {
    }

    @Override // i5.b
    public final String h() {
        i0 r8 = this.f13544a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.f13443a;
    }

    @Override // i5.b
    public final void i(s r8) {
    }

    @Override // i5.b
    public final void j(i0 r8) {
        this.f13544a = r8;
    }

    @Override // i5.b
    public final void start() {
    }
}
