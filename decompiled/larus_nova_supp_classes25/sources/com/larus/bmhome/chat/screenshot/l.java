package com.larus.bmhome.chat.screenshot;

import com.ixigua.lib.track.TrackParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static void a(List r3, List r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter("screen_record", "captureType");
        Intrinsics.checkNotNullParameter(r3, "msgIds");
        Intrinsics.checkNotNullParameter(r4, "logIds");
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.put("capture_type", "screen_record");
        r0.put("message_id_list", new JSONArray(r3));
        r0.put("log_id_list", new JSONArray(r4));
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("screen_capture_messages");
        r6.a.merge(r5);
        r6.b();
    }
}
