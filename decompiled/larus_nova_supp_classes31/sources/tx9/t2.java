package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t2 {
    public static void a(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("click_module", r4);     // Catch: JSONException -> L9
        if (r2 == null) goto L6;
        r0.put("message_id", r2);     // Catch: JSONException -> L9
    L6:
        if (r3 == null) goto L11;
        r0.put("phone_number", r3);     // Catch: JSONException -> L9
    L11:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("phone_number_panel");
        r6.a.merge(r5);
        r6.b();
        return;
    L9:
        e = move-exception;
        FLogger.a.e("PhoneNumberEventHelper", "error in PhoneNumberEventHelper phone_number_panel " + e.getLocalizedMessage());
        goto L11
    }
}
