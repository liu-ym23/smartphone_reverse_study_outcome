package l;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f19484c;
    public float d;
    public v.c e;
    public Object f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f19485h;

    public d(List r5) {
        this.f19482a = new ArrayList(1);
        this.f19483b = false;
        this.d = 0.0f;
        this.f = null;
        this.g = -1.0f;
        this.f19485h = -1.0f;
        if (r5.isEmpty() == false) goto L6;
        b r10 = new uj.a();
    L10:
        this.f19484c = r10;
        return;
    L6:
        if (r5.size() != 1) goto L9;
        b r11 = new c(r5);
    L8:
        r10 = r11;
        goto L10
    L9:
        r11 = new b0.e(r5);
        goto L8
    }

    public final void a(a r5) {
        this.f19482a.add(r5);
    }

    public final v.a b() {
        v.a r5 = this.f19484c.b();
        com.airbnb.lottie.c.a();
        return r5;
    }

    public float c() {
        if (this.f19485h != (-1.0f)) goto L6;
        this.f19485h = this.f19484c.g();
    L6:
        return this.f19485h;
    }

    public final float d() {
        v.a r5 = b();
        if (r5.c() == false) goto L7;
        return 0.0f;
    L7:
        return r5.d.getInterpolation(e());
    }

    public final float e() {
        if (this.f19483b == false) goto L5;
        return 0.0f;
    L5:
        v.a r5 = b();
        if (r5.c() == false) goto L9;
        return 0.0f;
    L9:
        return (this.d - r5.b()) / (r5.a() - r5.b());
    }

    public Object f() {
        float r5 = d();
        if (this.e == null) goto L5;
    L8:
        Object r10 = g(b(), r5);
        this.f = r10;
        return r10;
    L5:
        if (this.f19484c.a(r5) == false) goto L8;
        return this.f;
    }

    public abstract Object g(v.a r5, float r10);

    public void h() {
        int r5 = 0;
    L3:
        ArrayList r10 = this.f19482a;
        if (r5 >= r10.size()) goto L6;
        ((a) r10.get(r5)).a();
        r5 = r5 + 1;
        goto L3
    }

    public void i(float r5) {
        b r10 = this.f19484c;
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.g != (-1.0f)) goto L8;
        this.g = r10.f();
    L8:
        float r11 = this.g;
        if (r5 >= r11) goto L15;
        if (r11 != (-1.0f)) goto L13;
        this.g = r10.f();
    L13:
        r5 = this.g;
    L18:
        if (r5 != this.d) goto L20;
        return;
    L20:
        this.d = r5;
        if (r10.c(r5) == false) goto L24;
        h();
        return;
    L24:
        return;
    L15:
        if (r5 <= c()) goto L18;
        r5 = c();
        goto L18
    }

    public final void j(v.c r5) {
        v.c r10 = this.e;
        if (r10 == null) goto L5;
        r10.getClass();
    L5:
        this.e = r5;
    }
}
