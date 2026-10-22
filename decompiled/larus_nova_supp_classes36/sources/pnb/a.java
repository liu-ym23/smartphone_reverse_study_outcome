package pnb;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements tnb.f {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // tnb.f
    public final void c(String r3) {
        b r0 = this.a;
        Set<d> r1 = r0.c;
        if (r1 != null) goto L5;
    L11:
        rnb.c.c("bridge_receive", "responseFromDocs: no listener");
        return;
    L5:
        if (((CopyOnWriteArraySet) r1).isEmpty() == true) goto L11;
        Iterator r2 = ((CopyOnWriteArraySet) r0.c).iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        ((d) r2.next()).b(r3);
        goto L9
    }

    @Override // tnb.f
    public final void d(String r3) {
        b r0 = this.a;
        Set<d> r1 = r0.c;
        if (r1 != null) goto L5;
    L11:
        rnb.c.c("bridge_receive", "responseFromJs: no listener");
        return;
    L5:
        if (((CopyOnWriteArraySet) r1).isEmpty() == true) goto L11;
        Iterator r2 = ((CopyOnWriteArraySet) r0.c).iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        ((d) r2.next()).a(r3);
        goto L9
    }
}
