package mha;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static void b(String r3, String r4, String r5, boolean r6, String r7) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
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
        by7.a r10 = new by7.a("obric_click_speak_start");
        r10.a.merge(r9);
        r10.b();
        FLogger.a.i("mobClickTalkStart", "params:" + r0);
        return;
    L14:
        r8 = "failure";
        goto L15
    }

    public static void a(String r3, String r4, String r5, String r6, String r7, Integer r8) {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter(r0, "params");
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
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r0.put("message_id", r6);
        r0.put("end_type", r7);
        r0.put("duration", r8);
        TrackParams r9 = new TrackParams().merge(r0);
        by7.a r10 = new by7.a("obric_click_speak_end");
        r10.a.merge(r9);
        r10.b();
        FLogger.a.i("mobClickTalkEnd", "params:" + r0);
    }
}
