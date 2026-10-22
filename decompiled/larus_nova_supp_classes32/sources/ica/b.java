package ica;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final ConcurrentHashMap<String, a> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a() {
        long r0 = System.currentTimeMillis();
        Iterator<Map.Entry<String, a>> r2 = a.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, a> r3 = r2.next();
        String r4 = r3.getKey();
        a r5 = r3.getValue();
        if ((r0 - r5.e) <= 120000) goto L4;
        if (a.remove(r4, r5) == false) goto L4;
        r5.a();
        goto L4
    }

    public static a b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestId");
        a();
        a r6 = a.remove(r5);
        if (r6 != null) goto L5;
    L12:
        return null;
    L5:
        if ((System.currentTimeMillis() - r6.e) <= 120000) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r6.a();
    L10:
        if (r0 == true) goto L12;
        return r6;
    L7:
        r0 = false;
        goto L8
    }
}
