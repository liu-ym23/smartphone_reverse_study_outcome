package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "linkmicAudienceApply")
public final class u extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public u() {
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        int r2 = r12.optInt("paid_count", com.bytedance.android.live.liveinteract.api.data.a.C0017a.d());
        int r3 = r12.optInt("limit_time", com.bytedance.android.live.liveinteract.api.data.a.C0017a.c());
        String r13 = r12.optString("reason", "");
        boolean r4 = r12.optBoolean("isAnonymous", false);
        boolean r5 = r12.optBoolean("use_member_benefits", false);
        int r6 = r12.optInt("member_discount_amount", 0);
        tc0.c r0 = tc0.c.h();
        if (r13.length() <= 25) goto L5;
        String r1 = r13.substring(0, 25);
    L6:
        r0.F = r1;
        ALogger.i("ttlive_link_paid", "InteractAudienceApplyMethod paidCount=" + r2 + " limitTime=" + r3 + " reason=" + r13 + ' ' + r12 + ", isAnonymous=" + r4);
        ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.base.e.a.a().D5(r2, r3, r4, r5, r6, null);
        return null;
    L11:
        return null;
    L5:
        r1 = r13;
        goto L6
    }
}
