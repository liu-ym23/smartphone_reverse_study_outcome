package com.bytedance.android.live.room.discovery;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.business.IHostSocial;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ LiveHashtagWidget a;

    public a0(LiveHashtagWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        LiveHashtagWidget.wq(this.a);
        int r12 = jc1.k.f(IInteractService.class).getCurrentScene();
        com.bytedance.android.live.liveinteract.api.utils.a.a.getClass();
        String r8 = com.bytedance.android.live.liveinteract.api.utils.a.a.a(r12);
        if (this.a.h.isLiveTypeAudio() == false) goto L5;
        String r13 = "voice_live";
    L6:
        String r7 = r13;
        IHostSocial r1 = jc1.k.f(IHostSocial.class);
        LiveHashtagWidget r14 = this.a;
        r1.showLiveCircleDetailDialog((Activity) ((Widget) r14).context, r14.m.getCircleId(), this.a.m.getCircleName(), "live_detail", r7, r8);
        return;
    L5:
        r13 = "video_live";
        goto L6
    }
}
