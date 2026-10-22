package f58;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static void a(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("interact_type", r4);     // Catch: Exception -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("edit_box_interact");
        r1.a.merge(r5);
        r1.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("EditBoxInteractEventHelper", "error in EditBoxInteractEventHelper mobEditBoxInteractEvent " + e.getLocalizedMessage());
        goto L7
    }
}
