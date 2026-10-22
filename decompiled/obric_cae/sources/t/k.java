package t;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k extends p {
    @Override // t.p, t.d
    public final void a(d r8) {
        s.a r10 = (s.a) this.f12194b;
        int r11 = r10.f11809u0;
        f r12 = this.f12200h;
        Iterator r13 = r12.f12170l.iterator();
        int r14 = 0;
        int r15 = -1;
    L4:
        if (r13.hasNext() == false) goto L11;
        int r16 = ((f) r13.next()).f12165g;
        if (r15 == (-1)) goto L8;
        if (r16 < r15) goto L8;
    L9:
        if (r14 >= r16) goto L4;
        r14 = r16;
    L8:
        r15 = r16;
        goto L9
    L11:
        if (r11 != 0) goto L13;
    L16:
        r12.d(r15 + r10.f11811w0);
        return;
    L13:
        if (r11 == 2) goto L16;
        r12.d(r14 + r10.f11811w0);
    }

    @Override // t.p
    public final void d() {
        s.e r8 = this.f12194b;
        if ((r8 instanceof s.a) == false) goto L68;
        f r10 = this.f12200h;
        r10.f12160b = true;
        s.a r11 = (s.a) r8;
        int r12 = r11.f11809u0;
        boolean r13 = r11.f11810v0;
        ArrayList r14 = r10.f12170l;
        int r15 = 0;
        if (r12 == 0) goto L43;
        if (r12 != 1) goto L8;
        r10.f12163e = f.a.f12175o;
    L35:
        if (r15 >= r11.f11932t0) goto L53;
        s.e r16 = r11.f11931s0[r15];
        if (r13 == false) goto L39;
    L41:
        f r17 = r16.f11854d.f12201i;
        r17.f12169k.add(r10);
        r14.add(r17);
    L42:
        r15 = r15 + 1;
        goto L35
    L39:
        if (r16.f11866j0 != 8) goto L41;
    L53:
        m(this.f12194b.f11854d.f12200h);
        p r18 = this.f12194b.f11854d;
    L54:
        m(r18.f12201i);
        return;
    L8:
        if (r12 != 2) goto L10;
        r10.f12163e = f.a.f12176p;
    L24:
        if (r15 >= r11.f11932t0) goto L32;
        s.e r19 = r11.f11931s0[r15];
        if (r13 == false) goto L28;
    L30:
        f r20 = r19.f11855e.f12200h;
        r20.f12169k.add(r10);
        r14.add(r20);
    L31:
        r15 = r15 + 1;
        goto L24
    L28:
        if (r19.f11866j0 != 8) goto L30;
    L32:
        m(this.f12194b.f11855e.f12200h);
        r18 = this.f12194b.f11855e;
        goto L54
    L10:
        if (r12 != 3) goto L69;
        r10.f12163e = f.a.f12177q;
    L14:
        if (r15 >= r11.f11932t0) goto L32;
        s.e r21 = r11.f11931s0[r15];
        if (r13 == false) goto L18;
    L20:
        f r22 = r21.f11855e.f12201i;
        r22.f12169k.add(r10);
        r14.add(r22);
    L21:
        r15 = r15 + 1;
        goto L14
    L18:
        if (r21.f11866j0 != 8) goto L20;
    L69:
        return;
    L43:
        r10.f12163e = f.a.f12174n;
    L45:
        if (r15 >= r11.f11932t0) goto L53;
        s.e r23 = r11.f11931s0[r15];
        if (r13 == false) goto L49;
    L51:
        f r24 = r23.f11854d.f12200h;
        r24.f12169k.add(r10);
        r14.add(r24);
    L52:
        r15 = r15 + 1;
        goto L45
    L49:
        if (r23.f11866j0 != 8) goto L51;
    }

    @Override // t.p
    public final void e() {
        s.e r8 = this.f12194b;
        if ((r8 instanceof s.a) == false) goto L12;
        int r10 = ((s.a) r8).f11809u0;
        f r11 = this.f12200h;
        if (r10 != 0) goto L7;
    L10:
        r8.f11851b0 = r11.f12165g;
        return;
    L7:
        if (r10 == 1) goto L10;
        r8.f11853c0 = r11.f12165g;
        return;
    }

    @Override // t.p
    public final void f() {
        this.f12195c = null;
        this.f12200h.c();
    }

    @Override // t.p
    public final boolean k() {
        return false;
    }

    public final void m(f r8) {
        f r10 = this.f12200h;
        r10.f12169k.add(r8);
        r8.f12170l.add(r10);
    }
}
