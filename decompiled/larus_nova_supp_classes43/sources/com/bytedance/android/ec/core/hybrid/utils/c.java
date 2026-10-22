package com.bytedance.android.ec.core.hybrid.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final Map<String, JSONObject> a = null;
    public static final Map<String, Object> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    public static com.bytedance.android.ec.core.imagex.r a(String r10, String r11, Map r12) {
        com.bytedance.android.ec.core.imagex.r r0 = new com.bytedance.android.ec.core.imagex.r(r10, r11);
        if (r12 == null) goto L12;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        Set r14 = r13.keySet();
        if (r14 == null) goto L12;
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        String r16 = (String) r15.next();
        Object r1 = r13.get(r16);
        if (r1 == null) goto L8;
        r0.g(r16, r1);
    L12:
        return r0;
    }

    public static void b(JSONObject r12, JSONObject r13, List r14, Map r15) {
        Iterator<String> r0 = r12.keys();
    L4:
        if (r0.hasNext() == false) goto L117;
        String r1 = r0.next();
        Object r10 = r12.opt(r1);
        if (r10 == null) goto L4;
        if (Intrinsics.areEqual(r1, "__*_common_*__") == true) goto L11;
    L19:
        Object r11 = r13.opt(r1);
        if (r11 == null) goto L4;
        if ((r10 instanceof JSONObject) == true) goto L25;
        int r16 = 0;
        if ((r10 instanceof String) == true) goto L29;
        if ((r10 instanceof JSONArray) == false) goto L4;
        JSONArray r17 = (JSONArray) r10;
        if (r17.length() == 0) goto L4;
        if ((r17.get(0) instanceof JSONObject) == false) goto L4;
        if ((r11 instanceof JSONArray) == false) goto L4;
        JSONArray r18 = (JSONArray) r11;
        if (r18.length() < r17.length()) goto L4;
        Object r19 = r17.get(0);
        if (r19 == null) goto L116;
        JSONObject r20 = (JSONObject) r19;
        int r21 = Math.min(r18.length(), r20.optInt("iterator_limit", 2147483637));
        Object r22 = r20.opt("iterator_rules");
        if (r22 == null) goto L4;
        if ((r22 instanceof JSONObject) == false) goto L4;
        int r23 = r20.optInt("immediate_limit", Integer.MAX_VALUE);
        long r24 = r20.optLong("wait_time", -1);
        if (r23 >= r21) goto L102;
        if (r24 <= 0) goto L102;
    L78:
        if (r16 >= r23) goto L88;
        if ((r18.get(r16) instanceof JSONObject) == false) goto L85;
        JSONObject r25 = (JSONObject) r22;
        Object r110 = r18.get(r16);
        if (r110 == null) goto L87;
        b(r25, (JSONObject) r110, r14, r15);
        goto L85
    L87:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L85:
        r16 = r16 + 1;
        goto L78
    L88:
        List r26 = (List) ((LinkedHashMap) r15).get(Long.valueOf(r24));
        if (r26 != null) goto L92;
        r26 = new ArrayList();
        r15.put(Long.valueOf(r24), r26);
    L92:
        if (r23 >= r21) goto L4;
        if ((r18.get(r23) instanceof JSONObject) == false) goto L99;
        JSONObject r27 = (JSONObject) r22;
        Object r28 = r18.get(r23);
        if (r28 == null) goto L101;
        b(r27, (JSONObject) r28, r26, r15);
        goto L99
    L101:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L99:
        r23 = r23 + 1;
    L102:
        if (r16 >= r21) goto L4;
        if ((r18.get(r16) instanceof JSONObject) == false) goto L110;
        JSONObject r29 = (JSONObject) r22;
        Object r30 = r18.get(r16);
        if (r30 == null) goto L114;
        b(r29, (JSONObject) r30, r14, r15);     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        throw th;
    L114:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L110:
        r16 = r16 + 1;
        goto L102
    L116:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    L29:
        String r31 = (String) r10;
        int r32 = r31.hashCode();
        if (r32 != (-1324034071)) goto L32;
        if (r31.equals("__preload_first_image_in_this_array__") == false) goto L4;
        Object r33 = null;
        if ((r11 instanceof JSONArray) == true) goto L44;
        r11 = null;
    L44:
        JSONArray r34 = (JSONArray) r11;
        if (r34 == null) goto L4;
        if (r34.length() <= 0) goto L4;
        Object r35 = r34.get(0);
        if ((r35 instanceof String) == false) goto L52;
        r33 = r35;
    L52:
        String r36 = (String) r33;
        if (r36 == null) goto L4;
        r14.add(r36);
        goto L4
    L32:
        if (r32 != 1905217760) goto L4;
        if (r31.equals("__preload_this_image_url__") == false) goto L4;
        if ((r11 instanceof String) == false) goto L4;
        r14.add(r11);
        goto L4
    L25:
        if ((r11 instanceof JSONObject) == false) goto L4;
        b((JSONObject) r10, (JSONObject) r11, r14, r15);
        goto L4
    L11:
        if ((r10 instanceof JSONObject) == false) goto L19;
        JSONObject r37 = (JSONObject) r10;
        Iterator<String> r111 = r13.keys();
    L14:
        if (r111.hasNext() == false) goto L18;
        Object r38 = r13.opt(r111.next());
        if ((r38 instanceof JSONObject) == false) goto L14;
        b(r37, (JSONObject) r38, r14, r15);
        goto L14
    L18:
        return;
    }
}
