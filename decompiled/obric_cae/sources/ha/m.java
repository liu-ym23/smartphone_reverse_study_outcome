package ha;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class m extends p implements Iterable<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<p> f8001a;

    public m() {
        this.f8001a = new ArrayList();
    }

    @Override // ha.p
    public final /* bridge */ /* synthetic */ p a() {
        return n();
    }

    @Override // ha.p
    public final boolean b() {
        return p().b();
    }

    @Override // ha.p
    public final double c() {
        return p().c();
    }

    @Override // ha.p
    public final int d() {
        return p().d();
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r8 instanceof m) == true) goto L6;
    L8:
        return false;
    L6:
        if (((m) r8).f8001a.equals(this.f8001a) == false) goto L8;
        goto L8
    }

    @Override // ha.p
    public final long h() {
        return p().h();
    }

    public final int hashCode() {
        return this.f8001a.hashCode();
    }

    @Override // ha.p
    public final Number i() {
        return p().i();
    }

    public final boolean isEmpty() {
        return this.f8001a.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator<p> iterator() {
        return this.f8001a.iterator();
    }

    @Override // ha.p
    public final String j() {
        return p().j();
    }

    public final void k(p r8) {
        if (r8 != null) goto L4;
        r8 = r.f8002a;
    L4:
        this.f8001a.add(r8);
    }

    public final void l(Number r8) {
        ArrayList<p> r10 = this.f8001a;
        if (r8 != null) goto L5;
        p r11 = r.f8002a;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new u(r8);
        goto L6
    }

    public final void m(String r8) {
        ArrayList<p> r10 = this.f8001a;
        if (r8 != null) goto L5;
        p r11 = r.f8002a;
    L6:
        r10.add(r11);
        return;
    L5:
        r11 = new u(r8);
        goto L6
    }

    public final m n() {
        ArrayList<p> r8 = this.f8001a;
        if (r8.isEmpty() == true) goto L10;
        m r10 = new m(r8.size());
        Iterator<p> r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.k(r11.next().a());
        goto L6
    L8:
        return r10;
    L10:
        return new m();
    }

    public final p o(int r8) {
        return this.f8001a.get(r8);
    }

    public final p p() {
        ArrayList<p> r8 = this.f8001a;
        int r10 = r8.size();
        if (r10 != 1) goto L7;
        return r8.get(0);
    L7:
        throw new IllegalStateException(defpackage.a.d("Array must have size 1, but has size ", r10));
    }

    public final int size() {
        return this.f8001a.size();
    }

    public m(int r8) {
        this.f8001a = new ArrayList(r8);
    }
}
