package dmc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final int a;
    public final vlc.b b;

    public static final class a {
    }

    static {
    }

    public d(int r1) {
        this.a = -1;
        this.b = null;
    }

    public final List<tlc.d> a(List<? extends tlc.d> r5) {
        if (r5 == null) goto L22;
        LinkedList r0 = new LinkedList();
        Iterator<T> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L12;
        tlc.d r1 = (tlc.d) r6.next();
        vlc.b r3 = this.b;
        if (r3 == null) goto L10;
        if (r3.onMessage(r1) == true) goto L5;
    L10:
        r0.addLast(r1);
        goto L5
    L12:
        if (this.a <= 0) goto L21;
        int r7 = r0.size() - this.a;
        if (r7 <= 0) goto L21;
        int r2 = 0;
    L16:
        if (r2 >= r7) goto L21;
        if ((!r0.isEmpty()) == false) goto L20;
        r0.removeFirst();
    L20:
        r2 = r2 + 1;
    L21:
        return r0;
    L22:
        return null;
    }
}
