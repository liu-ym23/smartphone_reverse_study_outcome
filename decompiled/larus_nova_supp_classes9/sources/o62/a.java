package o62;

import am2.x;
import com.bytedance.android.livesdk.log.filter.n;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4, Map r5) {
        u.l().sendLog(r4, r5, new Object[]{x.class, Room.class, n.class});
    }

    public static void b(long r5, boolean r7) {
        Intrinsics.checkNotNullParameter("panel", "location");
        HashMap r2 = new HashMap();
        String r4 = "0";
        r2.put("is_levitation_ball", "0");
        MultiTabType.Companion.getClass();
        r2.put("tab_type", MultiTabType.a.a(r5).getLogParam());
        if (r7 == false) goto L5;
        r4 = "1";
    L5:
        r2.put("micro_state", r4);
        r2.put("location", "panel");
        a("livesdk_match_chat_voice_button_show", r2);
    }
}
