package tx9;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x0 {
    public static void a(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("scene", r4);
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("spring_client_downgrade_toast");
        r1.a.merge(r5);
        r1.b();
        com.larus.platform.service.g.a.monitorEventForSlardar("spring_client_downgrade_toast", r0, null, null);
    }
}
