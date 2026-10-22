package com.bytedance.android.live.liveinteract.interact.audience;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements View.OnClickListener {
    public m() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        tc0.c.h().z = "live_on_show";
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.e r6 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        int r0 = bh0.a.a;
        r6.c2(2, 101, "video_apply_container_click", LinkApplyType.NORMAL);
        return;
    }
}
