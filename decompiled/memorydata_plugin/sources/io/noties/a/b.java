package io.noties.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
abstract class b {
    @SafeVarargs
    static <T> List<T> a(T... r2) {
        if (r2 == null) goto L4;
        int r0 = r2.length;
    L5:
        ArrayList r1 = new ArrayList(r0);
        if (r0 <= 0) goto L8;
        Collections.addAll(r1, r2);
    L8:
        return r1;
    L4:
        r0 = 0;
        goto L5
    }
}
