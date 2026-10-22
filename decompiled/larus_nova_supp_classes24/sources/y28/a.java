package y28;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static boolean a(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static <T extends b> boolean b(List<T> r6, List<T> r7) {
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (r6 == null) goto L24;
        if (r7 == null) goto L24;
        if (r6.size() == r7.size()) goto L12;
        return false;
    L12:
        Iterator<T> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L23;
        T r2 = r8.next();
        Iterator<T> r3 = r7.iterator();
        boolean r4 = false;
    L17:
        if (r3.hasNext() == false) goto L21;
        if (c(r2, r3.next()) == false) goto L17;
        r4 = true;
        goto L17
    L21:
        if (r4 == true) goto L14;
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static <T extends b> boolean c(b<T> r2, T r3) {
        if (r2 != null) goto L6;
        if (r3 != null) goto L6;
        return true;
    L6:
        if (r2 == null) goto L13;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r2.getClass() == r3.getClass()) goto L12;
        return false;
    L12:
        return r2.isContentSame(r3);
    L13:
        return false;
    }
}
