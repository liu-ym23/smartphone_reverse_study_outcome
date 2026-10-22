package iia;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.audio.continuous_talk.d0;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public b() {
    }

    public static String a(RealtimeCallParam r2) {
        Object r3 = r2.r.get("obric_click_source_type");
        Integer r1 = null;
        if ((r3 instanceof g0) == false) goto L5;
        g0 r4 = (g0) r3;
    L6:
        if (r4 == null) goto L8;
        r1 = k.l(r4);
    L8:
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L16;
    L18:
        if (r1 != null) goto L21;
    L23:
        if (r1 != null) goto L26;
    L28:
        if (r1 != null) goto L31;
    L33:
        if (r1 != null) goto L36;
    L38:
        if (r1 != null) goto L41;
    L43:
        if (r1 != null) goto L46;
    L48:
        return IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L46:
        if (r1.intValue() != 7) goto L48;
    L47:
        return "physical_button_tap";
    L41:
        if (r1.intValue() != 6) goto L43;
        return "bottom_bar";
    L36:
        if (r1.intValue() != 5) goto L38;
    L31:
        if (r1.intValue() != 4) goto L33;
        return "intent_iauto_mic";
    L26:
        if (r1.intValue() != 3) goto L28;
        return "special_input";
    L21:
        if (r1.intValue() != 2) goto L23;
        return "auto_mic";
    L16:
        if (r1.intValue() != 1) goto L18;
        return "bluetooth_headset_wakeup";
    L11:
        if (r1.intValue() != 0) goto L13;
        return "voice_wakeup";
    L5:
        r4 = null;
        goto L6
    }

    public static com.obric.audio.continuous_talk.a b(RealtimeCallParam r4) {
        RealtimeCallParam.p r1 = r4.o;
        return new com.obric.audio.continuous_talk.a(r1.h, r1.c, r4.e, r4.p.i);
    }

    public static void c(RealtimeCallParam r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "params");
        com.obric.audio.continuous_talk.a r4 = b(r1);
        Intrinsics.checkNotNullParameter(r4, "commonTraceParams");
        JSONObject r0 = new JSONObject();
        d0.a(r0, r4);
        r0.put("is_interrupt", r2);
        if (r3 == null) goto L5;
        r0.put("unique_id", r3);
    L5:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r6 = new by7.a("obric_continuous_talk_reply");
        r6.a.merge(r5);
        r6.b();
        FLogger.a.i("mobObricContinuousTalkReply", "params:" + r0);
    }

    public static void d(b r1, RealtimeCallParam r2, Integer r3, String r4, Map r5, Boolean r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r6 = Boolean.FALSE;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "params");
        com.obric.audio.continuous_talk.a r8 = b(r2);
        Intrinsics.checkNotNullParameter(r8, "commonTraceParams");
        JSONObject r9 = new JSONObject();
        d0.a(r9, r8);
        if (r3 == null) goto L11;
        r9.put("error_code", r3.intValue());
    L11:
        if (r4 == null) goto L13;
        r9.put("error_message", r4);
    L13:
        if (r5 == null) goto L18;
        Iterator r10 = r5.entrySet().iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.put((String) r11.getKey(), r11.getValue());
    L18:
        if (r6 == null) goto L20;
        r9.put("is_disconnect", r6.booleanValue());
    L20:
        TrackParams r12 = new TrackParams().merge(r9);
        by7.a r13 = new by7.a("obric_continuous_talking_error");
        r13.a.merge(r12);
        r13.b();
        FLogger.a.i("mobObricContinuousTalkError", "params:" + r9);
    }
}
