package p70;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<P> {
    public final List<c<P>> a;

    public a() {
        this.a = new ArrayList();
    }

    public final boolean a(P r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((c) r0.next()).a(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
