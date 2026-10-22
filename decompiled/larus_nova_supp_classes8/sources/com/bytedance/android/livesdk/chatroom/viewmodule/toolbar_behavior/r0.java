package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r0 implements View.OnClickListener {
    public final /* synthetic */ LandscapeToolbarMoreBehavior a;

    public r0(LandscapeToolbarMoreBehavior r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tc0.c.h().z = "guide_show";
        LandscapeToolbarMoreBehavior r3 = this.a;
        int r0 = LandscapeToolbarMoreBehavior.T;
        r3.r();
        jc1.k.f(IInteractService.class).handleInteractClick();
    }
}
