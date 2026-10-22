package org.chromium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static List a(Class r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
    L6:
        if (r6 == null) goto L21;
        Class<?>[] r1 = r6.getInterfaces();
        int r2 = 0;
    L9:
        if (r2 >= r1.length) goto L20;
        if (r0.contains(r1[r2]) == true) goto L13;
        r0.add(r1[r2]);
    L13:
        Iterator r3 = a(r1[r2]).iterator();
    L15:
        if (r3.hasNext() == false) goto L19;
        Class r4 = (Class) r3.next();
        if (r0.contains(r4) == true) goto L15;
        r0.add(r4);
        goto L15
    L19:
        r2 = r2 + 1;
        goto L9
    L20:
        r6 = r6.getSuperclass();
        goto L6
    L21:
        return r0;
    }
}
