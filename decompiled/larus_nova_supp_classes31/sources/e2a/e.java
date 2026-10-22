package e2a;

import com.larus.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final List<a> a = null;

    static {
        a = new CopyOnWriteArrayList();
    }

    public static void a() {
        Iterator r0 = ((CopyOnWriteArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final a r1 = (a) r0.next();
        y.c(new b(r1));
        goto L4
    }

    public static void b() {
        Iterator r0 = ((CopyOnWriteArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final a r1 = (a) r0.next();
        y.c(new d(r1));
        goto L4
    }

    public static void c() {
        Iterator r0 = ((CopyOnWriteArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final a r1 = (a) r0.next();
        y.c(new c(r1));
        goto L4
    }
}
