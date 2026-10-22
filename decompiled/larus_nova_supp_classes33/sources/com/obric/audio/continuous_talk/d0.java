package com.obric.audio.continuous_talk;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 {
    public static final void a(JSONObject r2, a r3) {
        String r0 = r3.a;
        if (r0 == null) goto L5;
        r2.put("bot_id", r0);
    L5:
        String r1 = r3.c;
        if (r1 == null) goto L8;
        r2.put("call_id", r1);
    L8:
        String r4 = r3.b;
        if (r4 == null) goto L11;
        r2.put("conversation_id", r4);
    L11:
        String r5 = r3.d;
        if (r5 == null) goto L15;
        r2.put("enter_method", r5);
        return;
    }

    public static final void b(String r3, String r4, String r5, String r6, Integer r7) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("bot_id", r3);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0.put("conversation_id", r4);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r0.put("call_id", r5);
        r0.put("message_id", "");
        r0.put(ObricAssistantForAudioDelegate.b.b5(), r6);
        r0.put("duration", r7);
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("obric_continuous_talk_end");
        r9.a.merge(r8);
        r9.b();
        FLogger.a.i("mobObricContinuousTalkEnd", "params:" + r0);
    }

    public static final void c(String r3, String r4, String r5, boolean r6, String r7) {
        JSONObject r0 = new JSONObject();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("bot_id", r3);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0.put("conversation_id", r4);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r0.put("call_id", r5);
        if (r6 == false) goto L14;
        String r8 = WindowEvent.WindowOpenPerfResult.SUCCESS;
    L15:
        r0.put("status", r8);
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r0.put("fail_type", r7);
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("obric_continuous_talk_start");
        r10.a.merge(r9);
        r10.b();
        FLogger.a.i("mobObricContinuousTalkStart", "params:" + r0);
        return;
    L14:
        r8 = "failure";
        goto L15
    }

    public static final void d(a r3, String r4, String r5, Integer r6, Long r7) {
        Intrinsics.checkNotNullParameter(r3, "commonTraceParams");
        JSONObject r0 = new JSONObject();
        a(r0, r3);
        if (r7 == null) goto L5;
        r0.put("duration", r7.longValue());
    L5:
        if (r5 == null) goto L7;
        r0.put("fail_reason", r5);
    L7:
        if (r6 == null) goto L9;
        r0.put("error_code", r6.intValue());
    L9:
        r0.put(WindowEvent.WindowOpenPerfResult.SUCCESS, r4);
        r0.put("status", !Intrinsics.areEqual(r4, "1") ? 1 : 0);
        TrackParams r8 = new TrackParams().merge(r0);
        by7.a r9 = new by7.a("obric_continuous_talk_start_finish");
        r9.a.merge(r8);
        r9.b();
        FLogger.a.i("mobObricContinuousTalkStarted", "params:" + r0);
    }
}
