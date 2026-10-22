package d60;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final void a(JSONObject r3, String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$safePut");
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 != null) goto L24;
        return;
    L24:
    L21:
        e = move-exception;
        ALogger.e("TraceClientMonitor", e.getMessage());
        return;
    L6:
        if ((r5 instanceof Collection) == false) goto L13;
        JSONArray r0 = new JSONArray();     // Catch: JSONException -> L21
        Iterator r6 = ((Iterable) r5).iterator();     // Catch: JSONException -> L21
    L9:
        if (r6.hasNext() == false) goto L11;
        r0.put(r6.next());     // Catch: JSONException -> L21
        goto L9
    L11:
        Unit r7 = Unit.INSTANCE;     // Catch: JSONException -> L21
        r3.put(r4, r0);     // Catch: JSONException -> L21
        return;
    L13:
        if ((r5 instanceof Map) == false) goto L19;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L21
        Iterator r8 = ((Map) r5).entrySet().iterator();     // Catch: JSONException -> L21
    L16:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) r8.next();     // Catch: JSONException -> L21
        Object r9 = r2.getKey();     // Catch: JSONException -> L21
        Object r11 = r2.getValue();     // Catch: JSONException -> L21
        a(r1, String.valueOf(r9), r11);     // Catch: JSONException -> L21
        goto L16
    L18:
        Unit r12 = Unit.INSTANCE;     // Catch: JSONException -> L21
        r3.put(r4, r1);     // Catch: JSONException -> L21
        return;
    L19:
        r3.put(r4, r5);     // Catch: JSONException -> L21
    }
}
