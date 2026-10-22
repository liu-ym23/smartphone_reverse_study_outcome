package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.livesdk.widget.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ LiveMgMountContextService a;
    public final /* synthetic */ c0 b;
    public final /* synthetic */ x0 c;

    public s(LiveMgMountContextService r1, c0 r2, x0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        LiveMgMountContextService r0 = this.a;
        int r8 = LiveMgMountContextService.h;
        LiveMgMountContextService.k(r0, r0.getOpenPlatformContext().getContext(), this.b, null, this.c, 16);
    }
}
