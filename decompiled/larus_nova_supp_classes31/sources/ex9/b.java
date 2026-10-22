package ex9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements ax9.d {
    public final CopyOnWriteArrayList<ax9.d> a;

    public b() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // ax9.d
    public final void P(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.d) r0.next()).P(r3);
        goto L4
    }

    @Override // ax9.d
    public final void Q(String r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.d) r0.next()).Q(r3);
        goto L4
    }
}
