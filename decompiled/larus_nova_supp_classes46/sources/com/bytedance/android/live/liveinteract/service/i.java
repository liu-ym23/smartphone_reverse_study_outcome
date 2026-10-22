package com.bytedance.android.live.liveinteract.service;

import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import gd0.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements fd2.c {
    public final /* synthetic */ LinkPanelTransitService a;

    public final void onCancelClick() {
    }

    public i(LinkPanelTransitService r1) {
        this.a = r1;
    }

    public final void a(KtvFeedbackDialog r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        this.a.getClass();
        Boolean r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r10 == null) goto L5;
        boolean r11 = r10.booleanValue();
    L7:
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 8) == false) goto L22;
        if (r11 == false) goto L15;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r12 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r12 == null) goto L12;
        com.bytedance.android.live.liveinteract.voicechat.d.b.a(r12);
    L12:
        IKtvService r13 = jc1.k.f(IKtvService.class);
        if (r13 == null) goto L23;
        r13.finishAudioTalk();
        return;
    L23:
        return;
    L15:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L18;
        IVoiceChatGuestService.b.b(r0, r9, false, !r8, false, 24);
    L18:
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L25;
        IKtvService.b.a(r1, r9, false, !r8, false, 24);
        return;
    L25:
        return;
    L22:
        return;
    L5:
        r11 = false;
        goto L7
    }
}
