package com.bytedance.android.live.room.util;

import am2.x;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(IRoom r4) {
        HashMap r0 = new HashMap();
        r0.put("event_belong", "live");
        r0.put("event_type", "click");
        r0.put("event_page", "live_detail");
        r0.put("event_module", "top_tab");
        if (r4 == null) goto L6;
        String r1 = r4.getIdStr();
        if (r1 == null) goto L6;
    L7:
        r0.put("room_id", r1);
        if (r4 == null) goto L10;
        String r2 = r4.getOwnerUserIdString();
    L11:
        r0.put("anchor_id", String.valueOf(r2));
        if (r4 != null) goto L14;
    L16:
        j0.l().sendLog("livesdk_audience_list_click_v2", r0, new Object[]{new x()});
        return;
    L14:
        if (r4.isEcomNew() != true) goto L16;
        r0.put("is_ecom_new", DataType.TRUE);
        goto L16
    L10:
        r2 = null;
    L6:
        r1 = "";
        goto L7
    }
}
