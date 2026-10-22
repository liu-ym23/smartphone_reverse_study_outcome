package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public static HashMap<String, String> a(DataCenter r6) {
        HashMap<String, String> r0 = new HashMap();
        if (r6 != null) goto L5;
        return r0;
    L5:
        IRoom r7 = (IRoom) r6.get("data_room", null);
        if (r7 != null) goto L8;
    L10:
        r0.put("is_ecom", DataType.FALSE);
    L11:
        r0.put("anchor_id", jc1.k.f(IMiddlewareUserService.class).user().b().getIdString() + "");
        if (r7 == null) goto L14;
        r0.put("room_id", r7.getId() + "");
    L16:
        if (r7 != null) goto L18;
    L20:
        r0.put("live_status_type", "live_before");
    L21:
        r0.put("_param_live_platform", "live");
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        return r0;
    L18:
        if (r7.getId() <= 0) goto L20;
        r0.put("live_status_type", "live_on");
        goto L21
    L14:
        r0.put("room_id", DataType.FALSE);
        goto L16
    L8:
        if (r7.isHasCommerceGoods() != true) goto L10;
        r0.put("is_ecom", DataType.TRUE);
        goto L11
    }
}
