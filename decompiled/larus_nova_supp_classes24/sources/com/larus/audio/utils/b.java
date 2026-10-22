package com.larus.audio.utils;

import f2a.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements m58.k {
    public final f2a.c a;

    public b(f2a.c r2) {
        Intrinsics.checkNotNullParameter(r2, "logBuilder");
        this.a = r2;
    }

    public final b b(List r2) {
        this.a.c.b = r2;
        return this;
    }

    public final b c(Map r5) {
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator r6 = ((LinkedHashMap) r5).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.put(new f((String) r1.getKey()), r1.getValue());
        goto L4
    L6:
        this.a.d(r0);
        return this;
    }

    public final b d(String r2) {
        this.a.c.d = r2;
        return this;
    }

    public final b e(String r2) {
        this.a.c.e = r2;
        return this;
    }

    @Override // m58.k
    public final void a(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "function");
        this.a.b(r3, r4, r5, 5);
    }
}
