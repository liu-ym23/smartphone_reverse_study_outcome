package com.bytedance.badger.network;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public static final String a(List<Pair<String, String>> r3, String r4, boolean r5) {
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (StringsKt.equals((String) ((Pair) r0).getFirst(), r4, r5) == false) goto L4;
    L9:
        Pair r1 = (Pair) r0;
        if (r1 != null) goto L12;
        return null;
    L12:
        return (String) r1.getSecond();
    L8:
        r0 = null;
        goto L9
    }
}
