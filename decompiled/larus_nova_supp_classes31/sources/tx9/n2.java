package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n2 {
    public static final void a(String r2, String r3, String r4) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L5;
        r0.put("offline_device_id", r3);
    L5:
        if (r4 == null) goto L7;
        r0.put("computer_type", r4);
    L7:
        by7.a r5 = new by7.a(r2);
        TrackParams r6 = new TrackParams().merge(r0);
        r5.a.merge(r6);
        r5.b();
    }
}
