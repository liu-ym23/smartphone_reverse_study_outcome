package o1;

import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static boolean a(JSONArray r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.length() == 0) goto L7;
        return false;
    }

    public static JSONObject b(JSONObject r10, JSONObject r11) {
        if (r10 != null) goto L4;
        return r11;
    L4:
        Iterator<String> r12 = r10.keys();
    L12:
    L9:
        e = move-exception;
        f1.n.B().u(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
    L11:
        return r11;
    L6:
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next();     // Catch: JSONException -> L9
        r11.put(r13, r10.opt(r13));     // Catch: JSONException -> L9
        goto L12
    }
}
