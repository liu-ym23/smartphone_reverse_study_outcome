package k;

import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class u implements c, l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f18570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShapeTrimPath$Type f18571c;
    public final l.f d;
    public final l.f e;
    public final l.f f;

    public u(r.c r5, q.i r10) {
        this.f18570b = new ArrayList();
        r10.getClass();
        this.f18569a = r10.d;
        this.f18571c = (ShapeTrimPath$Type) r10.f21421b;
        l.d r11 = r10.f21422c.d();
        this.d = (l.f) r11;
        l.d r12 = ((p.b) r10.e).d();
        this.e = (l.f) r12;
        l.d r13 = ((p.b) r10.f).d();
        this.f = (l.f) r13;
        r5.f(r11);
        r5.f(r12);
        r5.f(r13);
        r11.a(this);
        r12.a(this);
        r13.a(this);
    }

    @Override // l.a
    public final void a() {
        int r5 = 0;
    L3:
        ArrayList r10 = this.f18570b;
        if (r5 >= r10.size()) goto L6;
        ((l.a) r10.get(r5)).a();
        r5 = r5 + 1;
        goto L3
    }

    @Override // k.c
    public final void b(List r5, List r10) {
    }

    public final void c(l.a r5) {
        this.f18570b.add(r5);
    }
}
