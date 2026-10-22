package j01;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final void a(JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$putAll");
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        Iterator<String> r0 = r4.keys();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        b(r3, r1, r4.opt(r1));
        goto L4
    }

    public static final void b(JSONObject r1, String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$safePut");
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L13;
        return;
    L13:
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        jy0.b.c("RevenueMonitorJsonException", r4, null, 4);
    }
}
