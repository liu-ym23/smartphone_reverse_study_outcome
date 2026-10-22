package lsc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r implements j.a {
    public final List<j> a;
    public final List<j> b;
    public final Set<j> c;

    public r(List<j> r2) {
        this.a = r2;
        this.b = new ArrayList(r2.size());
        this.c = new HashSet(3);
    }

    public final void a(j r3) {
        if (((ArrayList) this.b).contains(r3) == false) goto L5;
        return;
    L5:
        if (((HashSet) this.c).contains(r3) == true) goto L13;
        ((HashSet) this.c).add(r3);
        r3.j(this);
        ((HashSet) this.c).remove(r3);
        if (((ArrayList) this.b).contains(r3) == false) goto L9;
        return;
    L9:
        if (msc.o.class.isAssignableFrom(r3.getClass()) == false) goto L11;
        ListProtector.add(this.b, 0, r3);
        return;
    L11:
        ((ArrayList) this.b).add(r3);
        return;
    L13:
        throw new IllegalStateException("Cyclic dependency chain found: " + this.c);
    }

    public final <P extends j> P c(Class<P> r4) {
        P r0 = (P) b(this.b, r4);
        if (r0 != null) goto L9;
        r0 = (P) b(this.a, r4);
        if (r0 == null) goto L8;
        a(r0);
        goto L9
    L8:
        throw new IllegalStateException("Requested plugin is not added: " + r4.getName() + ", plugins: " + this.a);
    L9:
        return r0;
    }

    public static <P extends j> P b(List<j> r2, Class<P> r3) {
        Iterator<j> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        P r0 = (P) r4.next();
        if (r3.isAssignableFrom(r0.getClass()) == false) goto L4;
        return r0;
    L8:
        return null;
    }
}
