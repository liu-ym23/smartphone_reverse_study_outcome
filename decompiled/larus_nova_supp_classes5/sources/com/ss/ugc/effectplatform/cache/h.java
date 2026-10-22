package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.util.r;
import z.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static final b<String, j> a = null;

    static {
        a = new b(true);
    }

    public static j a(String r3) {
        if (r.b(r3) == false) goto L5;
        return null;
    L5:
        b<String, j> r0 = a;
        if (r0.containsKey(r3) == true) goto L9;
        return null;
    L9:
        return (j) r0.get(r3);
    }
}
