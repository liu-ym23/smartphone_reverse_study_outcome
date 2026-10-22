package u89;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final List<Object> a(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        Object r3 = r5.get(r2);     // Catch: Exception -> L13
        if ((r3 instanceof JSONArray) == false) goto L8;
        r3 = a((JSONArray) r3);     // Catch: Exception -> L13
    L10:
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L13
        r0.add(r3);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r3 instanceof JSONObject) == false) goto L10;
        r3 = b((JSONObject) r3);     // Catch: Exception -> L13
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r0;
    }

    public static final Map<String, Object> b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: Exception -> L13
        Object r3 = r5.get(r2);     // Catch: Exception -> L13
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = a((JSONArray) r3);     // Catch: Exception -> L13
    L11:
        r0.put(r2, r3);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = b((JSONObject) r3);     // Catch: Exception -> L13
        goto L11
    L14:
        return r0;
    }

    public static final Map<String, Object> c(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: Exception -> L13
        Object r3 = r5.get(r2);     // Catch: Exception -> L13
        if ((r3 instanceof JSONArray) == false) goto L9;
        r3 = a((JSONArray) r3);     // Catch: Exception -> L13
    L11:
        r0.put(r2, r3);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r3 instanceof JSONObject) == false) goto L11;
        r3 = c((JSONObject) r3);     // Catch: Exception -> L13
        goto L11
    L14:
        return r0;
    }
}
