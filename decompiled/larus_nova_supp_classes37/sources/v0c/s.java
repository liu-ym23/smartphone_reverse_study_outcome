package v0c;

import com.ss.android.lark.player.widget.SuperContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s implements p {
    public final Map<String, o> a;
    public final List<o> b;
    public final List<p.b> c;

    public s() {
        this.a = new ConcurrentHashMap(8);
        this.b = Collections.synchronizedList(new ArrayList());
        this.c = new CopyOnWriteArrayList();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new CopyOnWriteArrayList();
    }

    @Override // v0c.p
    public final void a(SuperContainer.b r2) {
        if (((CopyOnWriteArrayList) this.c).contains(r2) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArrayList) this.c).add(r2);
    }

    @Override // v0c.p
    public final void c(SuperContainer.b r2) {
        ((CopyOnWriteArrayList) this.c).remove(r2);
    }

    @Override // v0c.p
    public final void d(p.a r2) {
        b(null, r2);
    }

    @Override // v0c.p
    public final void b(g.a r4, p.a r5) {
        Iterator<o> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        o r1 = r0.next();
        if (r4 == null) goto L9;
        if ((r1 instanceof y0c.b) == false) goto L4;
    L9:
        r5.a(r1);
        goto L4
    }

    public final void e(String r2, a r3) {
        r3.getClass();
        r3.getClass();
        r3.g();
        ((ConcurrentHashMap) this.a).put(r2, r3);
        this.b.add(r3);
        Iterator r4 = ((CopyOnWriteArrayList) this.c).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((p.b) r4.next()).a(r3);
        goto L4
    }
}
