package ff0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final Map<String, String> a(JSONObject r4) {
        if (r4 == null) goto L4;
        Iterator<String> r0 = r4.keys();
        HashMap r1 = new HashMap();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r2 = r0.next();
        if (r4.optJSONObject(r2) == null) goto L14;
        Map<String, String> r3 = a(r4.optJSONObject(r2));     // Catch: NullPointerException -> L12
        Intrinsics.checkNotNull(r3);     // Catch: NullPointerException -> L12
        r1.putAll(r3);     // Catch: NullPointerException -> L12
    L12:
        e = move-exception;
        e.getMessage();
        goto L7
    L14:
        r1.put(r2, r4.optString(r2));
        goto L7
    L15:
        return r1;
    L4:
        return new LinkedHashMap();
    }
}
