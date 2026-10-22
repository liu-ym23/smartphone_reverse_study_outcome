package oi8;

import com.larus.platform.service.o;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, String r5, boolean r6) {
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", r3);
        r1.put("previous_page", r4);
        r1.put("bot_id", r5);
        r1.put("option_name", "expert");
        if (r6 == false) goto L5;
        String r7 = "on";
    L6:
        r1.put("option_selected", r7);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("option_select", r1);
        return;
    L5:
        r7 = "off";
        goto L6
    }
}
