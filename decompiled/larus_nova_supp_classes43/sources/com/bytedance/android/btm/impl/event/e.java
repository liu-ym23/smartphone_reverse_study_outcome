package com.bytedance.android.btm.impl.event;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(JSONObject r13, JSONObject r14) {
        ArrayList r0 = new ArrayList();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<String> r10 = r13.keys();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L50;
        String r12 = r10.next();
        r11 = r11 + 1;
        if (r14.has(r12) == false) goto L4;
        Object r15 = r14.opt(r12);
        if ((r15 instanceof String) == false) goto L14;
        if (Intrinsics.areEqual(r15, "NULL") == false) goto L14;
        r0.add(r12);
    L14:
        if ((r15 instanceof JSONObject) == false) goto L4;
        Object r16 = r13.opt(r12);
        if ((r16 instanceof JSONObject) == false) goto L22;
        if (a((JSONObject) r16, (JSONObject) r15) == false) goto L22;
        r0.add(r12);
    L22:
        if ((r16 instanceof String) == false) goto L4;
        String r17 = (String) r16;
        String r18 = null;
        JSONObject r19 = new JSONObject(r17);     // Catch: Exception -> L26
    L28:
        if (r19 == null) goto L63;
        Pair r20 = new Pair(0, r19);
    L36:
        if (r20 == null) goto L4;
        if (a((JSONObject) r20.getSecond(), (JSONObject) r15) == true) goto L39;
        int r21 = ((Number) r20.getFirst()).intValue();
        if (r21 != 0) goto L43;
        r1.put(r12, ((JSONObject) r20.getSecond()).toString());
    L43:
        if (r21 != 1) goto L4;
        r18 = URLEncoder.encode(((JSONObject) r20.getSecond()).toString(), "UTF-8");     // Catch: Exception -> L46
    L47:
        if (r18 == null) goto L4;
        r1.put(r12, r18);
        goto L4
    L39:
        r0.add(r12);
        goto L4
    L63:
        JSONObject r110 = new JSONObject(URLDecoder.decode(r17, "UTF-8"));     // Catch: Exception -> L32
    L33:
        if (r110 == null) goto L35;
        r20 = new Pair(1, r110);
        goto L36
    L35:
        r20 = null;
    L32:
        r110 = null;
    L26:
        r19 = null;
        goto L28
    L50:
        if (r11 != r0.size()) goto L52;
        return true;
    L52:
        Iterator r111 = r0.iterator();
    L54:
        if (r111.hasNext() == false) goto L56;
        r13.remove((String) r111.next());
        goto L54
    L56:
        Iterator r112 = r1.entrySet().iterator();
    L58:
        if (r112.hasNext() == false) goto L96;
        Map.Entry r22 = (Map.Entry) r112.next();
        String r23 = (String) r22.getKey();
        String r24 = (String) r22.getValue();
        if (r24 == null) goto L58;
        r13.put(r23, r24);
        goto L58
    L96:
        return false;
    }
}
