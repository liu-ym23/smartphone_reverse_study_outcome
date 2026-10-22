package com.obric.miniapp.alarm;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Long a(w r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return Long.valueOf(r2.b());
    }

    public static Map b(String r4) {
        if (r4 == null) goto L7;
        LinkedHashMap r0 = new LinkedHashMap();
        JSONObject r1 = new JSONObject(r4);
        Iterator<String> r5 = r1.keys();
    L5:
        if (r5.hasNext() == false) goto L10;
        String r2 = r5.next();
        r0.put(r2, r1.optString(r2));
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    public static String c(Map r3) {
        if (r3 == null) goto L8;
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L5:
        if (r4.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), (String) r1.getValue());
        goto L5
    L11:
        return r0.toString();
    L8:
        return null;
    }

    public static w d(Long r2) {
        if (r2 == null) goto L4;
        long r0 = r2.longValue();
        boolean r3 = w.b;
        return w.a.b(r0);
    L4:
        return null;
    }
}
