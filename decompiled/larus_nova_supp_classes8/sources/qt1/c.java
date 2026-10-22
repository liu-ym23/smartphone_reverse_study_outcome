package qt1;

import am2.x;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(HashMap<String, String> r10, Room r11) {
        Intrinsics.checkNotNullParameter(r10, "logMap");
        o r0 = u.l().c(x.class);
        String r3 = "";
        if (r0.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r1 = (String) r0.getMap().get("enter_from_merge");
    L7:
        if (r0.getMap().containsKey("enter_method") == false) goto L9;
        String r4 = (String) r0.getMap().get("enter_method");
    L11:
        if (r0.getMap().containsKey("action_type") == false) goto L13;
        String r6 = (String) r0.getMap().get("action_type");
    L15:
        if (r0.getMap().containsKey("video_id") == false) goto L18;
        r3 = (String) r0.getMap().get("video_id");
    L18:
        if (tb1.c.a == false) goto L20;
        r1 = k1.c();
    L20:
        r10.put("enter_from_merge", r1);
        r10.put("enter_method", r4);
        r10.put("action_type", r6);
        r10.put("request_page", "long_press");
        if (r11 == null) goto L23;
        String r12 = r11.getOwnerUserIdString();
    L24:
        r10.put("to_user_id", String.valueOf(r12));
        r10.put("event_page", "live_detail");
        r10.put("is_vr_machine", VrUtils.o(null));
        r10.put("video_id", r3);
        return;
    L23:
        r12 = null;
        goto L24
    L13:
        r6 = "";
        goto L15
    L9:
        r4 = "";
        goto L11
    L5:
        r1 = "";
        goto L7
    }
}
