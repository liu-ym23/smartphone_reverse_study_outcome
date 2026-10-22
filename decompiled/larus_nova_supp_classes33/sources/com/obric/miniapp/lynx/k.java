package com.obric.miniapp.lynx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public static final List<Object> a(JSONArray r5) {
        ArrayList r0 = new ArrayList(r5.length());
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        Object r3 = r5.opt(r2);
        if ((r3 instanceof JSONObject) == false) goto L8;
        r3 = b((JSONObject) r3);
    L13:
        r0.add(r3);
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof JSONArray) == false) goto L11;
        r3 = a((JSONArray) r3);
        goto L13
    L11:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == false) goto L13;
        r3 = null;
        goto L13
    L14:
        return r0;
    }

    public static final Map<String, Object> b(JSONObject r5) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        Object r3 = r5.opt(r2);
        if ((r3 instanceof JSONObject) == false) goto L9;
        r3 = b((JSONObject) r3);
    L14:
        r0.put(r2, r3);
        goto L4
    L9:
        if ((r3 instanceof JSONArray) == false) goto L12;
        r3 = a((JSONArray) r3);
        goto L14
    L12:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == false) goto L14;
        r3 = null;
        goto L14
    L15:
        return r0;
    }
}
