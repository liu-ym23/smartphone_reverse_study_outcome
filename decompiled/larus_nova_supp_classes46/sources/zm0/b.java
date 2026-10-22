package zm0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements tn0.a {
    public final List<tn0.a> a;

    @Override // tn0.a
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tn0.a) r0.next()).a();
        goto L4
    }

    @Override // tn0.a
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tn0.a) r0.next()).b();
        goto L4
    }

    @Override // tn0.a
    public final void c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tn0.a) r0.next()).c();
        goto L4
    }

    public b() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        r0.add(new un0.a());
    }
}
