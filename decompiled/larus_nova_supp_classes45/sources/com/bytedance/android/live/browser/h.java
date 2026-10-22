package com.bytedance.android.live.browser;

import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements f8.b {
    public h() {
    }

    public final Map<String, k7a.a> provide() {
        boolean r0 = AnnieNGInitHelper.a;
        IMiddlewareHostAction r1 = jc1.k.f(IMiddlewareHostAction.class);
        if (r1 == null) goto L31;
        Map r2 = r1.getBizComponentFetchers();
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((!r2.isEmpty()) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L33;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = r2.entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L23;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r6 = r5.getValue();
        if (r6 == null) goto L13;
        if ((r6 instanceof k7a.a) == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L13;
        r3.put(r5.getKey(), (k7a.a) r6);
        goto L13
    L23:
        return r3;
    L33:
        return null;
    L31:
        return null;
    }
}
