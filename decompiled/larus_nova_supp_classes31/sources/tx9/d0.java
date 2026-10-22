package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 {
    public static void a(TraceFragment r3) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        TrackParams r1 = new TrackParams().merge(r0);
        by7.a r2 = new by7.a("click_sky_luck_entrance");
        if (r3 == null) goto L5;
        r2.b = r3;
    L5:
        r2.a.merge(r1);
        r2.b();
    }
}
