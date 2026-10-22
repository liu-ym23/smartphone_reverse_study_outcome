package com.larus.audio.call.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ouc.a0;
import ouc.b;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public static final ouc.i a(Object r5) {
        if (r5 == null) goto L26;
        if (r5 == JSONObject.NULL) goto L26;
        if ((r5 instanceof Boolean) == false) goto L10;
        return ouc.k.a((Boolean) r5);
    L10:
        if ((r5 instanceof Number) == false) goto L13;
        return ouc.k.b((Number) r5);
    L13:
        if ((r5 instanceof String) == false) goto L16;
        return ouc.k.c((String) r5);
    L16:
        if ((r5 instanceof JSONObject) == false) goto L19;
        return b((JSONObject) r5);
    L19:
        if ((r5 instanceof JSONArray) == false) goto L33;
        ArrayList r0 = new ArrayList();
        JSONArray r6 = (JSONArray) r5;
        int r1 = r6.length();
        int r2 = 0;
    L21:
        if (r2 >= r1) goto L32;
        ouc.i r3 = a(r6.opt(r2));
        Intrinsics.checkNotNullParameter(r3, "element");
        r0.add(r3);
        r2 = r2 + 1;
        goto L21
    L32:
        return new b(r0);
    L33:
        return ouc.k.c(r5.toString());
    L26:
        return a0.INSTANCE;
    }

    public static final d0 b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();
        Object r3 = r5.opt(r2);
        Intrinsics.checkNotNull(r2);
        ouc.i r4 = a(r3);
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "element");
        ouc.i r6 = (ouc.i) r0.put(r2, r4);
        goto L4
    L7:
        return new d0(r0);
    }
}
