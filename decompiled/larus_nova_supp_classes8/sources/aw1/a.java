package aw1;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static Map a() {
        o r0 = u.l().c(x.class);
        String r2 = "";
        if (r0 == null) goto L8;
        Map r3 = r0.getMap();
        if (r3 == null) goto L8;
        String r4 = (String) r3.get("enter_from_merge");
        if (r4 == null) goto L8;
    L10:
        if (r0 == null) goto L15;
        Map r1 = r0.getMap();
        if (r1 == null) goto L15;
        String r5 = (String) r1.get("enter_method");
        if (r5 == null) goto L15;
    L16:
        IRoomService r6 = k.f(IRoomService.class);
        if (r6 == null) goto L19;
        Room r7 = r6.getCurrentRoomFromRoomContext();
    L20:
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L26;
        User r9 = r7.getOwner();
        if (r9 == null) goto L26;
        String r10 = r9.getIdString();
        if (r10 == null) goto L26;
    L27:
        r8.put("anchor_id", r10);
        if (r7 == null) goto L31;
        String r11 = r7.getIdStr();
        if (r11 == null) goto L31;
    L32:
        r8.put("room_id", r11);
        r8.put("enter_from_merge", r4);
        r8.put("enter_method", r5);
        r8.put("action_type", "click");
        if (r7 == null) goto L37;
        String r12 = r7.getRequestId();
        if (r12 == null) goto L37;
        r2 = r12;
    L37:
        r8.put("request_id", r2);
        return r8;
    L31:
        r11 = "";
    L26:
        r10 = "";
        goto L27
    L19:
        r7 = null;
    L15:
        r5 = "";
    L8:
        r4 = "";
        goto L10
    }

    static {
    }

    public static void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "beforeNama");
        Intrinsics.checkNotNullParameter(r3, "afterName");
        Map r0 = a();
        r0.put("tab_name_before", r2);
        r0.put("tab_name_after", r3);
        u.l().sendLog("livesdk_drawer_tab_change", r0, new Object[0]);
    }
}
