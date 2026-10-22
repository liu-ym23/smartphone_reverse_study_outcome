package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor$ContainerType;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void a(int r14, String r15, ActivityHybridMonitor$ContainerType r16, String r17, String r18, String r19, String r21, long r22) {
        String r0 = r19;
        if (ActivityMonitor.a() == false) goto L25;
        JSONObject r1 = new JSONObject();
        r1.put(LiveSlardarConstants.EXTRA_KEY_URL, r0);
        r1.put("room_id", r18);
        r1.put("msg", r15);
        r1.put("live_activity", r21);
        o r5 = j0.l().c(x.class);
        if (r5 == null) goto L10;
        Map r7 = r5.getMap();
        if (r7 == null) goto L10;
        String r8 = (String) r7.get("enter_method");
        if (r8 == null) goto L10;
    L12:
        if (r5 == null) goto L17;
        Map r6 = r5.getMap();
        if (r6 == null) goto L17;
        String r9 = (String) r6.get("enter_from_merge");
        if (r9 == null) goto L17;
    L18:
        JSONObject r11 = new JSONObject();
        r11.put("status_code", r14);
        if (r16 == null) goto L21;
        String r12 = r16.getType();
    L22:
        r11.put("category_1", r12);
        r11.put("category_2", r17);
        r11.put("enter_method", r8);
        r11.put("enter_from_merge", r9);
        ActivityMonitor.c("ttlive_activity_long_touch_container_show", r11, null, r1);
        goto L25
    L21:
        r12 = null;
    L17:
        r9 = "";
    L10:
        r8 = "";
    L25:
        if (ActivityMonitor.a.booleanValue() == false) goto L31;
        HashMap r2 = new HashMap();
        if (r0 != null) goto L29;
        r0 = "";
    L29:
        r2.put(LiveSlardarConstants.EXTRA_KEY_URL, r0);
        r2.put("status_code", String.valueOf(r14));
        r2.put("tti", String.valueOf(r22));
        j0.l().sendLog("long_touch_icon_show", r2, new Object[]{IRoom.class, x.class});
        return;
    }
}
