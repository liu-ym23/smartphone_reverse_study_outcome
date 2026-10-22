package v4;

import c4.m;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static boolean a(JSONArray r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.length() == 0) goto L7;
        return false;
    }

    public static void b(JSONObject r8, JSONObject r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        Iterator<String> r11 = r8.keys();
    L12:
    L9:
        e = move-exception;
        m.u().i(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
        return;
    L6:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();     // Catch: JSONException -> L9
        r10.put(r12, r8.opt(r12));     // Catch: JSONException -> L9
        goto L12
    }
}
