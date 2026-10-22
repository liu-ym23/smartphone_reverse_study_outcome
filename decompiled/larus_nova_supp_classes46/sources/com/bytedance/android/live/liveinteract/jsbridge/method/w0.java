package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.PaidLinkMicApplyResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.x4;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "paidLinkMicApply")
public final class w0 extends x4<xc, PaidLinkMicApplyResultModel> {
    public w0() {
    }

    public final void invoke(Object r13, CallContext r14) {
        xc r15 = (xc) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        Integer r16 = r15.b();
        if (r16 == null) goto L5;
        int r17 = r16.intValue();
    L6:
        Integer r1 = r15.e();
        if (r1 == null) goto L9;
        int r2 = r1.intValue();
    L10:
        Integer r3 = r15.c();
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
    L14:
        int r9 = r4;
        String r5 = r15.g();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r10 = r5;
        Boolean r6 = r15.a();
        if (r6 == null) goto L20;
        boolean r11 = r6.booleanValue();
    L21:
        Boolean r7 = r15.h();
        if (r7 == null) goto L24;
        boolean r8 = r7.booleanValue();
    L25:
        Integer r12 = r15.d();
        if (r12 == null) goto L28;
        int r18 = r12.intValue();
    L29:
        xc.a r19 = r15.f();
        if (r19 != null) goto L32;
        r19 = new xc.a();
    L32:
        xc.a r20 = r19;
        tc0.c r110 = tc0.c.h();
        if (r10.length() <= 25) goto L35;
        String r21 = r10.substring(0, 25);
    L36:
        r110.F = r21;
        if (r17 != 2) goto L39;
        ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L48;
        com.bytedance.android.live.liveinteract.plantform.base.e.a.a().D5(r2, r9, r11, r8, r18, r20);
    L48:
        ALogger.d("ttlive_link_paid", "PaidLinkMicApplyMethod paidCount=" + r2 + " limitTime=" + r9 + " reason=" + r10 + " isAnonymous=" + r11);
        return;
    L39:
        if (r17 != 8) goto L41;
        ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().D5(r2, r9, r11, r8, r18, r20);
        goto L48
    L41:
        if (r17 == 32) goto L43;
        f2.c("付费申请失败，请重试!", 0);
        goto L48
    L43:
        ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().k(r2, r9, r11, r8, r18, r20);
        goto L48
    L35:
        r21 = r10;
        goto L36
    L28:
        r18 = 0;
        goto L29
    L24:
        r8 = false;
        goto L25
    L20:
        r11 = false;
        goto L21
    L13:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r4 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.f();
        goto L14
    L9:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r2 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.g();
        goto L10
    L5:
        r17 = 0;
        goto L6
    }
}
