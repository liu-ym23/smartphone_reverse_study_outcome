package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r2, String r3, long r4) {
        if (ActivityMonitor.a.booleanValue() == false) goto L9;
        HashMap r0 = new HashMap();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.put(LiveSlardarConstants.EXTRA_KEY_URL, r3);
        r0.put("status_code", String.valueOf(r2));
        r0.put("tti", String.valueOf(r4));
        j0.l().sendLog("banner_icon_show", r0, new Object[]{IRoom.class, x.class});
        return;
    }
}
