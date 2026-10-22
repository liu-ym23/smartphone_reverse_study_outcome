package f1;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class m extends h {
    public ArrayList<h> H;
    public boolean I;
    public int J;
    public boolean K;
    public int L;

    public class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f7293a;

        public a(h r8) {
            this.f7293a = r8;
        }

        @Override // f1.h.d
        public final void d(h r8) {
            this.f7293a.y();
            r8.v(this);
        }
    }

    public static class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f7294a;

        public b(m r8) {
            this.f7294a = r8;
        }

        @Override // f1.h.d
        public final void d(h r8) {
            m r10 = this.f7294a;
            int r11 = r10.J - 1;
            r10.J = r11;
            if (r11 != 0) goto L5;
            r10.K = false;
            r10.m();
        L5:
            r8.v(this);
        }

        @Override // f1.k, f1.h.d
        public final void e() {
            m r8 = this.f7294a;
            if (r8.K == true) goto L6;
            r8.F();
            r8.K = true;
            return;
        }
    }

    public m() {
        this.H = new ArrayList();
        this.I = true;
        this.K = false;
        this.L = 0;
    }

    @Override // f1.h
    public final void A(h.c r8) {
        this.C = r8;
        this.L |= 8;
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.H.get(r11).A(r8);
        r11 = r11 + 1;
        goto L3
    }

    @Override // f1.h
    public final void B(TimeInterpolator r8) {
        this.L |= 1;
        ArrayList<h> r10 = this.H;
        if (r10 == null) goto L7;
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        this.H.get(r12).B(r8);
        r12 = r12 + 1;
    L7:
        this.f7265n = r8;
    }

    @Override // f1.h
    public final void C(android.support.v4.media.a r8) {
        super.C(r8);
        this.L |= 4;
        if (this.H == null) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.H.size()) goto L10;
        this.H.get(r10).C(r8);
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    @Override // f1.h
    public final void D() {
        this.L |= 2;
        int r8 = this.H.size();
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L5;
        this.H.get(r10).D();
        r10 = r10 + 1;
        goto L3
    }

    @Override // f1.h
    public final void E(long r8) {
        this.f7263b = r8;
    }

    @Override // f1.h
    public final String G(String r8) {
        String r10 = super.G(r8);
        int r11 = 0;
    L4:
        if (r11 >= this.H.size()) goto L6;
        StringBuilder r12 = android.aimedia.a.k(r10, "\n");
        r12.append(this.H.get(r11).G(r8 + "  "));
        r10 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public final void H(h r8) {
        this.H.add(r8);
        r8.f7270s = this;
        long r10 = this.f7264m;
        if (r10 < 0) goto L6;
        r8.z(r10);
    L6:
        if ((this.L & 1) == 0) goto L9;
        r8.B(this.f7265n);
    L9:
        if ((this.L & 2) == 0) goto L12;
        r8.D();
    L12:
        if ((this.L & 4) == 0) goto L15;
        r8.C(this.D);
    L15:
        if ((this.L & 8) == 0) goto L18;
        r8.A(this.C);
        return;
    }

    @Override // f1.h
    public final void a(h.d r8) {
        super.a(r8);
    }

    @Override // f1.h
    public final void b(View r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.H.size()) goto L6;
        this.H.get(r10).b(r8);
        r10 = r10 + 1;
        goto L4
    L6:
        this.f7267p.add(r8);
    }

    @Override // f1.h
    public final /* bridge */ /* synthetic */ Object clone() {
        return j();
    }

    @Override // f1.h
    public final void d(n r8) {
        View r10 = r8.f7296b;
        if (s(r10) == false) goto L10;
        Iterator<h> r11 = this.H.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        h r12 = r11.next();
        if (r12.s(r10) == false) goto L6;
        r12.d(r8);
        r8.f7297c.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // f1.h
    public final void f(n r8) {
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.H.get(r11).f(r8);
        r11 = r11 + 1;
        goto L3
    }

    @Override // f1.h
    public final void g(n r8) {
        View r10 = r8.f7296b;
        if (s(r10) == false) goto L10;
        Iterator<h> r11 = this.H.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        h r12 = r11.next();
        if (r12.s(r10) == false) goto L6;
        r12.g(r8);
        r8.f7297c.add(r12);
        goto L6
    L16:
        return;
    }

    @Override // f1.h
    public final h j() {
        m r8 = (m) super.j();
        r8.H = new ArrayList();
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        h r12 = this.H.get(r11).j();
        r8.H.add(r12);
        r12.f7270s = r8;
        r11 = r11 + 1;
        goto L3
    L5:
        return r8;
    }

    @Override // f1.h
    public final void l(ViewGroup r13, p.c r14, p.c r15, ArrayList<n> r16, ArrayList<n> r17) {
        long r8 = this.f7263b;
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        h r12 = this.H.get(r11);
        if (r8 <= 0) goto L13;
        if (this.I == true) goto L9;
        if (r11 != 0) goto L13;
    L9:
        long r18 = r12.f7263b;
        if (r18 <= 0) goto L12;
        r12.E(r18 + r8);
        goto L13
    L12:
        r12.E(r8);
    L13:
        r12.l(r13, r14, r15, r16, r17);
        r11 = r11 + 1;
        goto L3
    }

    @Override // f1.h
    public final void u(View r8) {
        super.u(r8);
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.H.get(r11).u(r8);
        r11 = r11 + 1;
        goto L3
    }

    @Override // f1.h
    public final void v(h.d r8) {
        super.v(r8);
    }

    @Override // f1.h
    public final void w(View r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.H.size()) goto L6;
        this.H.get(r10).w(r8);
        r10 = r10 + 1;
        goto L4
    L6:
        this.f7267p.remove(r8);
    }

    @Override // f1.h
    public final void x(ViewGroup r8) {
        super.x(r8);
        int r10 = this.H.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.H.get(r11).x(r8);
        r11 = r11 + 1;
        goto L3
    }

    @Override // f1.h
    public final void y() {
        if (this.H.isEmpty() == false) goto L6;
        F();
        m();
        return;
    L6:
        b r8 = new b(this);
        Iterator<h> r10 = this.H.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().a(r8);
        goto L8
    L10:
        this.J = this.H.size();
        if (this.I == true) goto L19;
        int r11 = 1;
    L14:
        if (r11 >= this.H.size()) goto L16;
        this.H.get(r11 - 1).a(new a(this.H.get(r11)));
        r11 = r11 + 1;
        goto L14
    L16:
        h r12 = this.H.get(0);
        if (r12 == null) goto L23;
        r12.y();
        return;
    L23:
        return;
    L19:
        Iterator<h> r13 = this.H.iterator();
    L21:
        if (r13.hasNext() == false) goto L28;
        r13.next().y();
        goto L21
    }

    @Override // f1.h
    public final void z(long r8) {
        this.f7264m = r8;
        if (r8 < 0) goto L9;
        ArrayList<h> r10 = this.H;
        if (r10 == null) goto L11;
        int r11 = r10.size();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L12;
        this.H.get(r12).z(r8);
        r12 = r12 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }
}
