package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 {
    public static void a(String r2, String r3, String r4, String r5, Boolean r6, Boolean r7, String r8, String r9, String r10, JSONObject r11, by7.e r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 64) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 128) == 0) goto L12;
        r4 = null;
    L12:
        if ((524288 & r13) == 0) goto L15;
        r5 = null;
    L15:
        if ((4194304 & r13) == 0) goto L18;
        r6 = null;
    L18:
        if ((8388608 & r13) == 0) goto L21;
        r7 = null;
    L21:
        if ((16777216 & r13) == 0) goto L24;
        r8 = null;
    L24:
        if ((33554432 & r13) == 0) goto L27;
        r9 = null;
    L27:
        if ((67108864 & r13) == 0) goto L30;
        r10 = null;
    L30:
        if ((134217728 & r13) == 0) goto L33;
        r11 = new JSONObject();
    L33:
        if ((r13 & 268435456) == 0) goto L35;
        r12 = null;
    L35:
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r2 != null) goto L72;
    L40:
        if (r3 == null) goto L42;
        r11.put("is_immersive_background", r3);     // Catch: JSONException -> L38
    L42:
        if (r4 == null) goto L44;
        r11.put("message_id", r4);     // Catch: JSONException -> L38
    L44:
        if (r5 == null) goto L46;
        r11.put("message_is_interrupted", r5);     // Catch: JSONException -> L38
    L46:
        String r14 = "1";
        if (r6 != null) goto L49;
    L53:
        if (r7 != null) goto L55;
    L59:
        if (r8 == null) goto L61;
        r11.put("click_module", r8);     // Catch: JSONException -> L38
    L61:
        if (r9 == null) goto L63;
        r11.put("select_range", r9);     // Catch: JSONException -> L38
    L63:
        if (r10 == null) goto L67;
        r11.put("call_id", r10);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.a.e("ChooseEventHelper", "error in ChooseEventHelper copy " + e.getLocalizedMessage());
    L67:
        TrackParams r15 = new TrackParams().merge(r11);
        by7.a r16 = new by7.a("choose_text");
        if (r12 == null) goto L70;
        r16.b = r12;
    L70:
        r16.a.merge(r15);
        r16.b();
        return;
    L55:
        if (r7.booleanValue() == true) goto L58;
        r14 = "0";
    L58:
        r11.put("is_thinking_generating", r14);     // Catch: JSONException -> L38
        goto L59
    L49:
        if (r6.booleanValue() == false) goto L51;
        Object r17 = "1";
    L52:
        r11.put("is_message_generating", r17);     // Catch: JSONException -> L38
        goto L53
    L51:
        r17 = "0";
        goto L52
    L72:
        r11.put("click_from", r2);     // Catch: JSONException -> L38
        goto L40
    }
}
