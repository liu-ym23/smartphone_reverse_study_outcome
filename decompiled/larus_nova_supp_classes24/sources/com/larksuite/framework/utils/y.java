package com.larksuite.framework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y {

    public interface a<S, R> {
        R get(S r1);
    }

    public static <S, R> List<R> a(List<S> r2, a<S, R> r3) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L10;
        Iterator<S> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        R r1 = r3.get(r4.next());
        if (r1 == null) goto L6;
        r0.add(r1);
    L10:
        return r0;
    }

    public static <S, R> Map<String, R> b(Map<String, S> r4, a<S, R> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L10;
        Iterator<String> r1 = r4.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        R r3 = r5.get(r4.get(r2));
        if (r3 == null) goto L6;
        r0.put(r2, r3);
    L10:
        return r0;
    }
}
