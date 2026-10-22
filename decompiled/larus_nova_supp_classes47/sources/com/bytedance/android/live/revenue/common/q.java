package com.bytedance.android.live.revenue.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public static final Map<String, String> a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$jsonObjToMap");
        Iterator<String> r0 = r5.keys();
        LinkedHashMap r1 = new LinkedHashMap();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next();
        String r3 = r5.optString(r2);
        if (r3.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.put(r2, r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L12:
        return MapsKt.toMap(r1);
    }

    public static final <V> JSONObject b(Pair<String, ? extends V>... r5) {
        Intrinsics.checkNotNullParameter(r5, "entries");
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair<String, ? extends V> r3 = r5[r2];
        r0.put((String) r3.getFirst(), r3.getSecond());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final JSONObject c(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new JSONObject(r2);
    }
}
