package com.larus.canvas.feature.component.logic.helper;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static void a(String r3, Integer r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
        r0.putOpt("canvas_id", r3);     // Catch: JSONException -> L5
        r0.putOpt("cnt_sub_canvas", r4);     // Catch: JSONException -> L5
    L7:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("click_close_ai_generate_canvas");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("mobClickCloseAIGenerateCanvas", "error: " + e.getLocalizedMessage());
        goto L7
    }
}
