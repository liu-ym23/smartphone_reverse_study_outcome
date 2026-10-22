package com.larus.voicecall.impl.component.feedback;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public static void b(String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, LynxResourceModule.PARAMS_KEY);
        if (r4 != null) goto L10;
    L8:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("call_feedback_popup_show");
        r1.a.merge(r5);
        r1.b();
        return;
    L10:
        r0.put("call_id", r4);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.a.e("RealtimeFeedbackTracer", "error in mobCallFeedbackPopupShow " + e.getLocalizedMessage());
        goto L8
    }

    public static void a(String r3, String r4) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, LynxResourceModule.PARAMS_KEY);
        if (r3 != null) goto L12;
    L7:
        r0.put("click_from", r4);     // Catch: JSONException -> L5
    L10:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("call_feedback_popup_click");
        r6.a.merge(r5);
        r6.b();
        return;
    L5:
        e = move-exception;
        FLogger.a.e("RealtimeFeedbackTracer", "error in mobCallFeedbackPopupClick " + e.getLocalizedMessage());
        goto L10
    L12:
        r0.put("call_id", r3);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r3, String r4, String r5) {
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r1.put("call_id", r3);     // Catch: JSONException -> L8
        r1.put("click_from", r4);     // Catch: JSONException -> L8
        if (r5 == null) goto L6;
        r1.put("message_id", r5);     // Catch: JSONException -> L8
    L6:
        r1.put("click_module", "call_subtitle");     // Catch: JSONException -> L8
    L10:
        TrackParams r6 = new TrackParams().merge(r1);
        by7.a r7 = new by7.a("complete_dislike_reason");
        r7.a.merge(r6);
        r7.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.e("RealtimeFeedbackTracer", "error in mobCompleteDislikeReason " + e.getLocalizedMessage());
        goto L10
    }
}
