package com.larus.search.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z0 implements com.larus.ivykit.plugin.a {
    public z0() {
    }

    public final com.larus.ivykit.plugin.b a() {
        com.larus.ivykit.plugin.b r0 = new com.larus.ivykit.plugin.b();
        boolean r1 = v19.h.a;
        List r2 = null;
        r0.a = v19.h.a(null);
        com.larus.settings.ivy.webView.b r3 = com.larus.settings.ivy.webView.c.a();
        r0.b = r3.b();
        List<String> r4 = r3.a();
        if (r4 == null) goto L5;
        r2 = CollectionsKt.filterNotNull(r4);
    L5:
        r0.c = r2;
        return r0;
    }
}
