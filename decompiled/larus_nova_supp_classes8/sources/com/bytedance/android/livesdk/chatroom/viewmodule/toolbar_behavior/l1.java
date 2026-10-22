package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.IInteractService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l1 implements View.OnClickListener {
    public final /* synthetic */ PortraitToolbarMoreBehavior a;

    public l1(PortraitToolbarMoreBehavior r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tc0.c.h().z = "guide_show";
        PortraitToolbarMoreBehavior r3 = this.a;
        int r0 = PortraitToolbarMoreBehavior.v1;
        r3.t();
        if (jc1.k.f(IInteractService.class) == null) goto L6;
        jc1.k.f(IInteractService.class).handleInteractClick();
        return;
    }
}
