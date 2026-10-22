package com.larus.suggest.impl.wcb.loading;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final ConcurrentHashMap<Long, b> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static b a(long r1) {
        return a.get(Long.valueOf(r1));
    }

    public static boolean b(long r6, long r8) {
    L2:
        ConcurrentHashMap<Long, b> r0 = a;
        b r1 = r0.get(Long.valueOf(r6));
        if (r1 == null) goto L4;
        if (r1.b != r8) goto L7;
        if (r0.remove(Long.valueOf(r6), r1) == false) goto L2;
        r1.o.complete(Unit.INSTANCE);
        return true;
    L7:
        return false;
    L4:
        return false;
    }
}
