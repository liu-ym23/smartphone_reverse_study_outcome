package com.bytedance.android.live.liveinteract.linkpanel.widget;

import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvFeedbackDialog;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements fd2.c {
    public final /* synthetic */ LinkPanelTopBarWidget a;

    public final void onCancelClick() {
    }

    public z(LinkPanelTopBarWidget r1) {
        this.a = r1;
    }

    public final void a(KtvFeedbackDialog r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        DataCenter r10 = ((Widget) this.a).dataCenter;
        if (r10 == null) goto L5;
        r10.put("data_voice_chat_room_close_page", "link_panel");
    L5:
        LinkPanelTopBarWidget r11 = this.a;
        r11.getClass();
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 8) == true) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.core.utils.a0.d(((Widget) r11).dataCenter, false) == false) goto L12;
        IKtvService r12 = jc1.k.f(IKtvService.class);
        if (r12 == null) goto L17;
        r12.finishAudioTalk();
        return;
    L17:
        return;
    L12:
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L19;
        IKtvService.b.a(r0, r9, false, !r8, false, 24);
        return;
    }
}
