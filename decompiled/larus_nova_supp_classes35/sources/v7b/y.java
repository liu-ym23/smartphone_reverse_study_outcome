package v7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y {
    public List<x> a;

    public y() {
    }

    public final void a(List<x> r9) {
        if (r9.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.a != null) goto L9;
        this.a = new ArrayList();
    L9:
        if (this.a.isEmpty() == false) goto L11;
        this.a.addAll(r9);
        return;
    L11:
        int r0 = this.a.size() - 1;
        x r2 = (x) ListProtector.get(this.a, r0);
        x r3 = (x) ListProtector.get(r9, 0);
        int r4 = r2.a;
        if (r4 != r3.a) goto L16;
        int r5 = r2.b;
        int r6 = r2.c;
        if ((r5 + r6) != r3.b) goto L16;
        ListProtector.set(this.a, r0, new x(r4, r5, r6 + r3.c));
        this.a.addAll(r9.subList(1, r9.size()));
        return;
    L16:
        this.a.addAll(r9);
    }

    public final void b(Iterable<? extends s> r2) {
        Iterator<? extends s> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        a(r3.next().j());
        goto L4
    }
}
