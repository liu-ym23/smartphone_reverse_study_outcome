package com.lark.kmp.containerization;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<TKey> {
    public final d<TKey> a;
    public final Map<TKey, b> b;

    public final d<TKey> getType() {
        return this.a;
    }

    public c(d<TKey> r10) {
        Intrinsics.checkNotNullParameter(r10, "type");
        this.a = r10;
        this.b = new LinkedHashMap();
    }

    public final b a(TKey r10) {
        Intrinsics.checkNotNullParameter(r10, "id");
        return (b) ((LinkedHashMap) this.b).get(r10);
    }

    public final b b(TKey r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        LinkedHashMap r0 = (LinkedHashMap) this.b;
        Object r1 = r0.get(r10);
        if (r1 != null) goto L6;
        r1 = new Container(r11);
        r0.put(r10, r1);
    L6:
        return (b) r1;
    }
}
