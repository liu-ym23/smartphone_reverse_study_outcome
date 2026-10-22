package cr9;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final int[] a = null;
    public static final Set<Integer> b = null;

    static {
        a = new int[]{4, 9, 14, 19, 24};
        b = SetsKt.setOf(new Integer[]{10, 11, 12, 9});
    }

    public static final boolean a(String r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r7.length();
        int[] r2 = a;
        if (r1 > ArraysKt.last(r2)) goto L8;
        return false;
    L8:
        Collection r3 = ArraysKt.getIndices(r2);
        if ((r3 instanceof Collection) == true) goto L11;
    L13:
        IntIterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L12;
        int r5 = r4.nextInt();
        if (r7.charAt(r2[r5]) != "OFL0X".charAt(r5)) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L15;
        return false;
    L19:
        r6 = false;
    L12:
        return true;
    L11:
        if (r3.isEmpty() == false) goto L13;
        goto L12
    }
}
