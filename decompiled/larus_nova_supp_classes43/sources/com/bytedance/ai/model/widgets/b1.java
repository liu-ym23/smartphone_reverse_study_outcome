package com.bytedance.ai.model.widgets;

import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b1 implements k5.j {
    public final /* synthetic */ PageInfo a;

    public b1(PageInfo r1) {
        this.a = r1;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        String r0 = this.a.getMessageId();
        if (r0 == null) goto L5;
        r10.f("message_id", r0);
    L5:
        r10.i(new JSONObject(GsonProtectorUtils.toJson(new Gson(), this.a)));
        r10.g("success", true);
    }
}
