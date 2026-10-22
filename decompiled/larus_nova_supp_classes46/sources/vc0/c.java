package vc0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final Map<String, Object> a;

    public c(Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, Object> r1 = r6.next();
        Object r2 = r1.getValue();
        if ((r2 instanceof xh6.c) == true) goto L7;
        r0.put(r1.getKey(), r2);
        goto L4
    L7:
        r0.put(r1.getKey(), ((xh6.c) r2).getReal());
        goto L4
    L9:
        this.a = r0;
    }
}
