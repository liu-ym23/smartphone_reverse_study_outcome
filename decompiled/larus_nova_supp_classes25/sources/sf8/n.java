package sf8;

import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final void a(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter("suggest_prompt", "enterMethod");
        b("deep_search_button_click", r8, r9, r10, r11, new k());
    }

    public static final void b(String r3, String r4, String r5, String r6, String r7, Function1 r8) {
        JSONObject r0 = new JSONObject();
        r0.put("current_page", "chat");
        if (r4 == null) goto L5;
        r0.put("previous_page", r4);
    L5:
        if (r5 == null) goto L7;
        r0.put("message_id", r5);
    L7:
        if (r6 == null) goto L9;
        r0.put("conversation_id", r6);
    L9:
        if (r7 == null) goto L11;
        r0.put("bot_id", r7);
    L11:
        r8.invoke(r0);
        by7.a r9 = new by7.a(r3);
        TrackParams r10 = new TrackParams().merge(r0);
        r9.a.merge(r10);
        r9.b();
    }
}
