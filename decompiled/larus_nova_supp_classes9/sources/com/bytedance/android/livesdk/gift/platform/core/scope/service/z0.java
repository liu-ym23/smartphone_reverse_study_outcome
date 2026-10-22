package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0<T> implements Observer {
    public final /* synthetic */ a1 a;

    public z0(a1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r6 = r5.getKey();
    L7:
        if (Intrinsics.areEqual(r6, "data_link_state") == false) goto L13;
        int r7 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc().j(((Integer) this.a.c.get("data_link_state", 0)).intValue());
        if (this.a.b == r7) goto L11;
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "live_gift_common_interactive_scene_change");
        r0.put("roomScene", a1.c());
        r0.put("interactiveScene", r7);
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("H5_webcastNotification", r0);
    L11:
        this.a.b = r7;
        return;
    L13:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
