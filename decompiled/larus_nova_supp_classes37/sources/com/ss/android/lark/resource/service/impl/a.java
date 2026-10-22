package com.ss.android.lark.resource.service.impl;

import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static Map<String, Resource> a(Map<String, com.bytedance.lark.pb.media.v1.Resource> r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == null) goto L13;
        Iterator<String> r1 = r7.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        com.bytedance.lark.pb.media.v1.Resource r3 = r7.get(r2);
        if (r3 != null) goto L10;
        Resource r4 = null;
    L11:
        if (r4 == null) goto L6;
        r0.put(r2, r4);
        goto L6
    L10:
        r4 = new Resource(r3.key, r3.path, r3.is_encrypted);
    L13:
        return r0;
    }
}
