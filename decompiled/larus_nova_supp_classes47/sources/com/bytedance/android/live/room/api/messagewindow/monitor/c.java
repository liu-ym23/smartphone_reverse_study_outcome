package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Map<String, Object> a;
    public final String b;

    public final b a() {
        String r0 = this.b;
        HashMap r1 = (HashMap) this.a;
        LinkedHashMap r2 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r3.next();
        Object r5 = r4.getKey();
        Object r6 = r4.getValue();
        if (r6 == null) goto L9;
        String r7 = r6.toString();
        if (r7 == null) goto L9;
    L10:
        r2.put(r5, r7);
    L9:
        r7 = "";
        goto L10
    L12:
        return new b(r0, r2);
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        this.b = r2;
        this.a = new HashMap();
    }

    public final void c(Pair... r6) {
        Intrinsics.checkNotNullParameter(r6, "pairs");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Pair r2 = r6[r1];
        if (r2 == null) goto L9;
        if (r2.getSecond() == null) goto L9;
        Map<String, Object> r3 = this.a;
        HashMap r4 = (HashMap) r3;
        r4.put(r2.getFirst(), r2.getSecond());
    L9:
        r1 = r1 + 1;
        goto L3
    }

    public final void b(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        ((HashMap) this.a).put(r2, r3);
    }
}
