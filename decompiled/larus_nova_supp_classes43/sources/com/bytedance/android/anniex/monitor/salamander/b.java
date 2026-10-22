package com.bytedance.android.anniex.monitor.salamander;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    static {
    }

    public static List a(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonArray");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L11;
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == false) goto L8;
        r12 = b((JSONObject) r12);
    L10:
        r0.add(r12);
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof JSONArray) == false) goto L10;
        r12 = a((JSONArray) r12);
        goto L10
    L11:
        return r0;
    }

    public static Map b(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L12;
        String r11 = r1.next();
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == false) goto L9;
        r12 = b((JSONObject) r12);
    L11:
        r0.put(r11, r12);
        goto L4
    L9:
        if ((r12 instanceof JSONArray) == false) goto L11;
        r12 = a((JSONArray) r12);
        goto L11
    L12:
        return r0;
    }
}
