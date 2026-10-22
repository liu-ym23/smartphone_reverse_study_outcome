package fa8;

import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final LinkedList<b> a;
    public long b;

    public a() {
        this.a = new LinkedList();
    }

    public final void a(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.a.add(new b(r5));
        this.b += (long) r5.length;
    }

    public final int b(byte[] r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "destination");
        if (r9 < 0) goto L20;
        int r1 = 0;
        if (r9 > (r8.length - 0)) goto L20;
        if (r9 == 0) goto L18;
        long r2 = this.b;
        if (r2 == 0) goto L18;
        int r10 = (int) Math.min(r9, r2);
        Iterator<b> r0 = this.a.iterator();
        int r3 = 0;
    L12:
        if (r0.hasNext() == false) goto L17;
        if (r1 >= r10) goto L17;
        b r4 = r0.next();
        int r5 = Math.min(r10 - r1, r4.a.length - r4.b);
        System.arraycopy(r4.a, r4.b, r8, r3, r5);
        int r6 = r4.b + r5;
        r4.b = r6;
        r1 = r1 + r5;
        r3 = r3 + r5;
        if (r6 != r4.a.length) goto L12;
        r0.remove();
    L17:
        this.b -= (long) r1;
    L18:
        return r1;
    L20:
        throw new IllegalArgumentException("Invalid read parameters");
    }
}
