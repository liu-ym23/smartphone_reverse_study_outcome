package bb;

import cb.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<e> f548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f551d;

    public b(h r10) {
        this.f548a = new CopyOnWriteArrayList();
        this.f551d = false;
        this.f550c = r10;
    }

    @Override // bb.f
    public void a() {
        this.f551d = true;
    }

    @Override // bb.f
    public void b() {
        if (this.f549b != this.f548a.size()) goto L5;
        return;
    L5:
        e r10 = this.f548a.get(this.f549b);
        this.f549b++;
        r10.k(this);
    }

    public b c(e r10) {
        e r11 = r10.e(this.f550c);
        if (r11 != null) goto L5;
        return this;
    L5:
        this.f548a.add(r11);
        return this;
    }

    public void d() {
        Iterator<e> r10 = this.f548a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().cancel();
        goto L4
    }

    public boolean e() {
        return this.f551d;
    }

    public void f() {
        Iterator<e> r10 = this.f548a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().f();
        goto L4
    }

    public void g() {
        this.f549b = 0;
        this.f550c.f684i = false;
    }

    public void h(boolean r10) {
        Iterator<e> r11 = this.f548a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().h(r10);
        goto L4
    }

    public void i(long r10, int r11) {
        Iterator<e> r12 = this.f548a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().c(r10, r11);
        goto L4
    }
}
