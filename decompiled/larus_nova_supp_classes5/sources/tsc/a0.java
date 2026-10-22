package tsc;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a0 {
    public a0() {
    }

    public abstract void a(lsc.m r1, v r2, l r3);

    public CharSequence b(m r1, g r2) {
        return null;
    }

    public abstract Collection<String> c();

    public static void d(lsc.m r2, v r3, l.a r4) {
        Iterator<l.a> r5 = r4.children().iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        l.a r0 = r5.next();
        if (r0.isClosed() == false) goto L4;
        a0 r1 = r3.b(r0.name());
        if (r1 != null) goto L10;
        d(r2, r3, r0);
        goto L4
    L10:
        r1.a(r2, r3, r0);
        goto L4
    }
}
