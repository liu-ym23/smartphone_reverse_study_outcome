package sw9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements pw9.d {
    public final CopyOnWriteArrayList<pw9.d> a;

    public b() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // pw9.d
    public final void P(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pw9.d) r0.next()).P(r3);
        goto L4
    }

    @Override // pw9.d
    public final void b(String r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pw9.d) r0.next()).b(r3);
        goto L4
    }

    @Override // pw9.d
    public final void a(String r3, String r4, Integer r5) {
        Iterator<pw9.d> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4, r5);
        goto L4
    }
}
