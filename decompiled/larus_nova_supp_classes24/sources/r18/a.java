package r18;

import com.alibaba.fastjson.JSONArray;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static JSONObject a(com.alibaba.fastjson.JSONObject r4) {
        if (r4 == null) goto L4;
        JSONObject r0 = new JSONObject();
        Iterator r1 = r4.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) r1.next();
        r0.put(r2, b(r4.get(r2)));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new RuntimeException("Error converting key: " + r2, e);
    L14:
        return r0;
    L4:
        return new JSONObject();
    }

    public static Object b(Object r2) {
        if (r2 != null) goto L6;
        return JSONObject.NULL;
    L6:
        if ((r2 instanceof com.alibaba.fastjson.JSONObject) == false) goto L10;
        return a((com.alibaba.fastjson.JSONObject) r2);
    L10:
        if ((r2 instanceof JSONArray) == false) goto L17;
        org.json.JSONArray r0 = new org.json.JSONArray();
        Iterator r3 = ((JSONArray) r2).iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r0.put(b(r3.next()));
        goto L13
    L15:
        return r0;
    L17:
        if ((r2 instanceof BigDecimal) == false) goto L21;
        return r2.toString();
    L21:
        if ((r2 instanceof String) == false) goto L23;
        return r2;
    L23:
        if ((r2 instanceof Number) == false) goto L25;
        return r2;
    L25:
        if ((r2 instanceof Boolean) == false) goto L28;
        return r2;
    L28:
        return r2.toString();
    }
}
