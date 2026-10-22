package v4a;

import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.animax.util.AnimaXLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static String a(String r2) {
        if (r2 == null) goto L13;
    L7:
        e = move-exception;
        AnimaXLog.a("AnimaXMonitor", "clearUrlQuery failed, error: " + e.toString());
        return "unknown";
    L4:
        if (r2.isEmpty() == true) goto L14;
        return UriProtector.parse(r2).buildUpon().clearQuery().build().toString();
    L14:
        return "unknown";
    L13:
        return "unknown";
    }

    public static JSONObject b(Map<String, Object> r3) {
        JSONObject r0 = new JSONObject();
        Iterator r4 = ((HashMap) r3).entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r4.next();     // Catch: JSONException -> L8
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: JSONException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        AnimaXLog.a("AnimaXMonitor", "Converting hashMap to JSON failed, error: " + e.toString());
        goto L10
    }
}
