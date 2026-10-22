package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s2 {
    public static void a(String r3, by7.e r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        JSONObject r0 = new JSONObject();
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = null;
    L12:
        Intrinsics.checkNotNullParameter(r0, "params");
        if (r3 != null) goto L23;
    L18:
        TrackParams r6 = new TrackParams().merge(r0);
        by7.a r7 = new by7.a("personal_info_pv");
        if (r4 == null) goto L21;
        r7.b = r4;
    L21:
        r7.a.merge(r6);
        r7.b();
        return;
    L23:
        r0.put("previous_page", r3);     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        FLogger.a.e("PersonalEventHelper", "error in PersonalEventHelper personalInfoPv " + e.getLocalizedMessage());
        goto L18
    L8:
        r0 = null;
        goto L10
    }
}
