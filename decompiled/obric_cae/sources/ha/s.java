package ha;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.s<String, p> f8003a;

    public s() {
        this.f8003a = new ja.s(false);
    }

    @Override // ha.p
    public final p a() {
        s r8 = new s();
        ja.s.b.a r10 = new ja.s.b.a((ja.s.b) this.f8003a.entrySet());
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = r10.a();
        r8.k((String) r11.getKey(), ((p) r11.getValue()).a());
        goto L4
    L6:
        return r8;
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r8 instanceof s) == true) goto L6;
    L8:
        return false;
    L6:
        if (((s) r8).f8003a.equals(this.f8003a) == false) goto L8;
        goto L8
    }

    public final int hashCode() {
        return this.f8003a.hashCode();
    }

    public final void k(String r8, p r10) {
        if (r10 != null) goto L4;
        r10 = r.f8002a;
    L4:
        this.f8003a.put(r8, r10);
    }

    public final void l(String r8, Boolean r10) {
        if (r10 != null) goto L4;
        p r11 = r.f8002a;
    L5:
        k(r8, r11);
        return;
    L4:
        r11 = new u(r10);
        goto L5
    }

    public final void m(String r8, Number r10) {
        if (r10 != null) goto L4;
        p r11 = r.f8002a;
    L5:
        k(r8, r11);
        return;
    L4:
        r11 = new u(r10);
        goto L5
    }

    public final void n(String r8, String r10) {
        if (r10 != null) goto L4;
        p r11 = r.f8002a;
    L5:
        k(r8, r11);
        return;
    L4:
        r11 = new u(r10);
        goto L5
    }

    public final ja.s.b o() {
        return (ja.s.b) this.f8003a.entrySet();
    }

    public final p p(String r8) {
        return this.f8003a.get(r8);
    }

    public final m q(String r8) {
        return (m) this.f8003a.get(r8);
    }

    public final s r(String r8) {
        return (s) this.f8003a.get(r8);
    }

    public final u s(String r8) {
        return (u) this.f8003a.get(r8);
    }

    public final boolean t(String r8) {
        return this.f8003a.containsKey(r8);
    }

    public final ja.s.c u() {
        return (ja.s.c) this.f8003a.keySet();
    }
}
