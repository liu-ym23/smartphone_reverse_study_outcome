package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void c(int r7, JSONObject r8, String r9, String r11) {
        JSONObject r2 = new JSONObject();
        r2.put("args", r8);
        r2.put("msg", r9);
        o r12 = j0.l().c(x.class);
        if (r12 == null) goto L8;
        Map r13 = r12.getMap();
        if (r13 == null) goto L8;
        String r14 = (String) r13.get("enter_from_merge");
        if (r14 == null) goto L8;
    L10:
        if (e.a(r14) == false) goto L12;
        String r4 = r14;
    L13:
        ActivityMonitor.d("ttlive_jsb_enter_room_result", r7, r2, null, r4, r11, 32);
        return;
    L12:
        r4 = "";
    L8:
        r14 = "";
        goto L10
    }

    @JvmStatic
    public static final void a(int r7, String r8, String r9, JsonObject r11, String r12, String r13) {
        JSONObject r2 = new JSONObject();
        r2.put(LiveSlardarConstants.EXTRA_KEY_URL, r8);
        r2.put("params", r11);
        r2.put("msg", r12);
        o r14 = j0.l().c(x.class);
        if (r14 == null) goto L8;
        Map r15 = r14.getMap();
        if (r15 == null) goto L8;
        String r16 = (String) r15.get("enter_from_merge");
        if (r16 == null) goto L8;
    L10:
        if (e.a(r16) == false) goto L12;
        String r4 = r16;
    L13:
        ActivityMonitor.d("ttlive_jsb_fetch_result", r7, r2, r9, r4, r13, 32);
        return;
    L12:
        r4 = "";
    L8:
        r16 = "";
        goto L10
    }

    @JvmStatic
    public static final void b(int r7, String r8, String r9, JSONObject r11, String r12, String r13) {
        JSONObject r2 = new JSONObject();
        r2.put(LiveSlardarConstants.EXTRA_KEY_URL, r8);
        r2.put("params", r11);
        r2.put("msg", r12);
        o r14 = j0.l().c(x.class);
        if (r14 == null) goto L8;
        Map r15 = r14.getMap();
        if (r15 == null) goto L8;
        String r16 = (String) r15.get("enter_from_merge");
        if (r16 == null) goto L8;
    L10:
        if (e.a(r16) == false) goto L12;
        String r4 = r16;
    L13:
        ActivityMonitor.d("ttlive_jsb_fetch_result", r7, r2, r9, r4, r13, 32);
        return;
    L12:
        r4 = "";
    L8:
        r16 = "";
        goto L10
    }
}
