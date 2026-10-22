package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.MultiAudioAudienceApplyResultModel;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "multiAudioAudienceApply")
public final class g0 extends com.bytedance.ies.xbridge.a<com.bytedance.ies.xbridge.k, MultiAudioAudienceApplyResultModel> {
    public g0() {
    }

    public final void invoke(Object r9, CallContext r10) {
        com.bytedance.ies.xbridge.k r11 = (com.bytedance.ies.xbridge.k) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        Integer r12 = r11.c();
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
    L6:
        int r1 = r13;
        Integer r14 = r11.a();
        if (r14 == null) goto L9;
        int r15 = r14.intValue();
    L10:
        int r2 = r15;
        String r16 = r11.d();
        if (r16 != null) goto L13;
        r16 = "";
    L13:
        Boolean r0 = r11.e();
        if (r0 == null) goto L16;
        boolean r4 = r0.booleanValue();
    L17:
        Integer r3 = r11.b();
        if (r3 == null) goto L20;
        int r5 = r3.intValue();
    L21:
        tc0.c r6 = tc0.c.h();
        if (r16.length() <= 25) goto L24;
        String r7 = r16.substring(0, 25);
    L25:
        r6.F = r7;
        ALogger.i("ttlive_link_paid", "InteractAudienceApplyMethod paidCount=" + r1 + " limitTime=" + r2 + " reason=" + r16 + ' ' + r11);
        ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().D5(r1, r2, false, r4, r5, null);
        return;
    L24:
        r7 = r16;
        goto L25
    L20:
        r5 = 0;
        goto L21
    L16:
        r4 = false;
        goto L17
    L9:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r15 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.f();
        goto L10
    L5:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r13 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.g();
        goto L6
    }
}
