package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v1 {
    public static void a(String r3, String r4, int r5, String r6, int r7) {
        JSONObject r1 = null;
        if ((r7 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r1 = new JSONObject();
    L8:
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.put("scene", r3);     // Catch: JSONException -> L13
        r1.put("method", r4);     // Catch: JSONException -> L13
        r1.put("result", r5);     // Catch: JSONException -> L13
        if (r6 == null) goto L15;
        r1.put("error_msg", r6);     // Catch: JSONException -> L13
    L15:
        TrackParams r8 = new TrackParams().merge(r1);
        by7.a r9 = new by7.a("jump_luna_triggered");
        r9.a.merge(r8);
        r9.b();
        return;
    L13:
        e = move-exception;
        FLogger.a.e("LunaEventHelper", "error in LunaEventHelper mobJumpLunaTriggered " + e.getLocalizedMessage());
        goto L15
    }
}
