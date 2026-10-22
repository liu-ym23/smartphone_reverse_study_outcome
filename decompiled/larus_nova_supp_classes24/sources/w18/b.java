package w18;

import android.util.ArrayMap;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements a {
    public b() {
    }

    public static boolean a(Collection r3) {
        ArrayMap r0 = new ArrayMap(r3.size());
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r1 = r4.next();
        if (((Boolean) r0.get(r1)) != null) goto L7;
        r0.put(r1, Boolean.TRUE);
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
