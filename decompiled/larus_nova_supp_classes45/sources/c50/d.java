package c50;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public String a;
    public int b;
    public final f c;
    public final ArrayList<c> d;

    public final void b() {
        this.d.size();
    }

    public final c a(Runnable r5) {
        c r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<c> r1 = this.d.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        c r2 = r1.next();
        if (r2 == null) goto L7;
        if (r2.a != r5) goto L7;
        r0 = r2;
    L13:
        if (r0 == null) goto L15;
        this.d.remove(r0);
    L15:
        return r0;
    }

    public d(String r3, int r4, e.a r5) {
        this.a = null;
        this.b = -1;
        this.d = new ArrayList(32);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
