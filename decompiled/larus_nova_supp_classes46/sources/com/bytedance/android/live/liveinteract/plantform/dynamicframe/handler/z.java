package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ v a;

    public z(v r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Integer r7 = (Integer) r6;
        JsonObject r0 = new JsonObject();
        int r2 = 2;
        if (r7 != null) goto L6;
    L8:
        if (r7 != null) goto L11;
    L13:
        r2 = 0;
    L14:
        r0.addProperty("linkmic_audience_status", Integer.valueOf(r2));
        r0.addProperty("is_audience", Boolean.TRUE);
        this.a.z.Dk("root", "self_apply_type", r0, false);
        return;
    L11:
        if (r7.intValue() != 2) goto L13;
        r2 = 4;
        goto L14
    L6:
        if (r7.intValue() != 1) goto L8;
        goto L8
    }
}
