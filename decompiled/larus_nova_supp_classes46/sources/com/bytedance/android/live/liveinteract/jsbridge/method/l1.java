package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "bigPartyAudienceApply")
public final class l1 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public l1() {
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.optString("reason", "");
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        int r3 = r12.optInt("paid_count", com.bytedance.android.live.liveinteract.api.data.a.C0017a.g());
        int r4 = r12.optInt("limit_time", com.bytedance.android.live.liveinteract.api.data.a.C0017a.f());
        boolean r5 = r12.optBoolean("isAnonymous", false);
        boolean r6 = r12.optBoolean("use_member_benefits", false);
        int r7 = r12.optInt("member_discount_amount", 0);
        tc0.c r0 = tc0.c.h();
        if (r13.length() <= 25) goto L5;
        String r1 = r13.substring(0, 25);
    L6:
        r0.F = r1;
        ALogger.i("ttlive_link_paid", "VideoTalkApplyMethod paidCount=" + r3 + " limitTime=" + r4 + " reason=" + r13 + ' ' + r12 + ", isAnonymous=" + r5);
        ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().k(r3, r4, r5, r6, r7, null);
        return null;
    L5:
        r1 = r13;
        goto L6
    }
}
