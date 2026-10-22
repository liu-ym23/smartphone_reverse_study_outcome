package qs;

import android.view.WindowInsets;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f21572a;

    static {
        new i();
        h r5 = i.a(null, new WindowInsets.Builder().build()).f21573a;
        r5.l();
        r5.a().f21573a.b().f21573a.c();
    }

    public h(i r5) {
        this.f21572a = r5;
    }

    public i a() {
        return this.f21572a;
    }

    public i b() {
        return this.f21572a;
    }

    public i c() {
        return this.f21572a;
    }

    public void d() {
    }

    public a e() {
        return null;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r5;
        if (k() != r10.k()) goto L20;
        if (j() != r10.j()) goto L20;
        if (ObjectsCompat.equals(i(), r10.i()) == false) goto L20;
        if (ObjectsCompat.equals(h(), r10.h()) == false) goto L20;
        if (ObjectsCompat.equals(e(), r10.e()) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public b f() {
        return b.e;
    }

    public b g() {
        return b.e;
    }

    public b h() {
        return b.e;
    }

    public int hashCode() {
        return ObjectsCompat.hash(new Object[]{Boolean.valueOf(k()), Boolean.valueOf(j()), i(), h(), e()});
    }

    public b i() {
        return b.e;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public void l() {
    }

    public void m(i r5) {
    }
}
