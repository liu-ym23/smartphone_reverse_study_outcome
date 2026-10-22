package com.larus.voicecall.impl.museum;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(RealtimeCallParam r3, a r4) {
        Intrinsics.checkNotNullParameter(r4, "banner");
        if (f.a() == true) goto L5;
        return;
    L5:
        String r0 = r4.j;
        if (r0 != null) goto L10;
        if (r3 == null) goto L9;
        r0 = r3.e;
        goto L10
    L9:
        r0 = null;
    L10:
        String r5 = e.c(r4.e);
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        if (r0 != null) goto L19;
    L13:
        r1.put("trigger_scene", r5);     // Catch: JSONException -> L15
        r1.put("card_type", "museum_extension");     // Catch: JSONException -> L15
    L17:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("museum_card_show");
        r7.a.merge(r6);
        r7.b();
        return;
    L15:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobMuseumCardShow " + e.getLocalizedMessage());
        goto L17
    L19:
        r1.put("call_id", r0);     // Catch: JSONException -> L15
        goto L13
    }
}
