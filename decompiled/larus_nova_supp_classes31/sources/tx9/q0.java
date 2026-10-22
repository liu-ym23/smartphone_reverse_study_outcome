package tx9;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q0 {
    public static void a(String r2, String r3, String r4, String r5, Integer r6, Boolean r7, String r8, boolean r9, int r10) {
        JSONObject r1 = null;
        if ((r10 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r10 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 32) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 128) == 0) goto L18;
        r9 = false;
    L18:
        if ((r10 & 256) == 0) goto L20;
        r1 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r2 == null) goto L23;
        r1.put("answer_mode", r2);
    L23:
        if (r3 == null) goto L25;
        r1.put("select_type", r3);
    L25:
        if (r4 == null) goto L27;
        r1.put("menu_id", r4);
        r1.put("model_item_key", r4);
        r1.put("model_key", r4);
    L27:
        if (r5 == null) goto L29;
        r1.put("mode_id", r5);
    L29:
        if (r6 == null) goto L31;
        r1.put("agent_mode", r6.intValue());
    L31:
        if (r7 == null) goto L33;
        r1.put("is_custom_model", r7.booleanValue());
    L33:
        r1.put("provider_id", r8);
        r1.put("is_folded", r9);
        TrackParams r11 = new TrackParams().merge(r1);
        by7.a r12 = new by7.a("click_default_answer_mode_switch");
        r12.a.merge(r11);
        r12.b();
    }
}
