package x81;

import kotlin.Pair;
import u81.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T extends d> {
    public final Pair<Integer, T>[] a;

    public b() {
        this.a = new Pair[99];
    }

    public final int a(int r6, Integer r7) {
        int r1 = 0;
    L4:
        if (r1 >= 99) goto L15;
        Pair<Integer, T> r2 = this.a[r1];
        if (r2 == null) goto L14;
        int r3 = ((Number) r2.getFirst()).intValue();
        int r4 = r6 * 10;
        if (r7 == null) goto L10;
        int r5 = r7.intValue();
    L12:
        if (r3 != (r4 + r5)) goto L14;
        return r1;
    L10:
        r5 = 0;
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return -1;
    }
}
