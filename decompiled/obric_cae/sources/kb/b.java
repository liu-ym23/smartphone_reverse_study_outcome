package kb;

import ha.t;
import he.i;
import java.util.List;
import ke.c;
import lb.d;
import lb.f;
import lb.g;
import lb.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f9099b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f9100a;

    static {
        c r8 = new c(8, 48);
        int r10 = 2;
        i.f(2, "step");
        if (r8.f9111m > 0) goto L6;
        r10 = -2;
    L6:
        f9099b = yd.i.n1(new ke.a(8, r8.f9110b, r10));
    }

    public b() {
        new mb.b();
        this.f9100a = new g();
    }

    public final void a(a r8) {
        mb.a.a("SmoothCornerHelper", "setCurveType: " + r8);
        int r10 = r8.ordinal();
        if (r10 == 0) goto L19;
        if (r10 != 1) goto L7;
        d r11 = new h();
    L22:
        this.f9100a = r11;
        return;
    L7:
        if (r10 != 2) goto L9;
        r11 = new lb.c();
        goto L22
    L9:
        if (r10 != 3) goto L11;
        r11 = new lb.a();
        goto L22
    L11:
        if (r10 != 4) goto L14;
        r11 = new f();
        goto L22
    L14:
        throw new t();
    L19:
        if ((-1.0f) <= 0) goto L21;
        r11 = new g(-1.0f);
        goto L22
    L21:
        r11 = new g();
        goto L22
    }
}
