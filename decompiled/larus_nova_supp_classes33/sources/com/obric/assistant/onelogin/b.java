package com.obric.assistant.onelogin;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final ConcurrentHashMap<String, Boolean> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(int r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        String r4 = r1 + ':' + r2;
        if (r3 == false) goto L5;
        a.put(r4, Boolean.TRUE);
        return;
    L5:
        a.remove(r4);
    }
}
