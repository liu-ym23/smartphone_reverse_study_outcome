package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w1 {
    public static void a(String r2, String r3, String r4, Boolean r5) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r2 != null) goto L20;
    L7:
        if (r3 == null) goto L9;
        r0.put("schema", r3);     // Catch: JSONException -> L5
    L9:
        r0.put("entrance", r4);     // Catch: JSONException -> L5
        if (r5 != null) goto L12;
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("lynx_page_schema_handled");
        r7.a.merge(r6);
        r7.b();
        return;
    L12:
        if (r5.booleanValue() == false) goto L14;
        int r8 = 1;
    L15:
        r0.put("is_ai_sdk", r8);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.a.e("LynxPageSchemaEventHelper", "error in LynxPageSchemaEventHelper mobLynxPageSchemaHandled " + e.getLocalizedMessage());
        goto L18
    L14:
        r8 = 0;
        goto L15
    L20:
        r0.put("target", r2);     // Catch: JSONException -> L5
        goto L7
    }
}
