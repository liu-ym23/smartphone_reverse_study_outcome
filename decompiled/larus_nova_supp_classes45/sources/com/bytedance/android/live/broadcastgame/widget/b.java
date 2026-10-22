package com.bytedance.android.live.broadcastgame.widget;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.q;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.ies.sdk.widgets.Widget;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements gd0.d {
    public final /* synthetic */ InteractGameStartupWidget a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ u c;

    public final void onSuccess() {
        if (this.b == false) goto L6;
        u r0 = this.c;
        ((Widget) this.a).dataCenter.put("cmd_broadcast_game_click", new q(r0));
        ((Widget) this.a).dataCenter.put("data_is_playing_network_game", Boolean.TRUE);
        return;
    }

    public final void onFailed(int r5) {
        f2.b(2131916823, 0);
        if (r5 != 2) goto L5;
        IInteractGameMonitorService.b.c((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class), 1, this.c, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, 24);
        return;
    L5:
        if (r5 != 1) goto L9;
        IInteractGameMonitorService.b.c((IInteractGameMonitorService) k.n(IInteractGameMonitorService.class), 1, this.c, IInteractGameMonitorService.FAILURE_CODE_PK_MUTEX, 24);
        return;
    }

    public b(InteractGameStartupWidget r1, u r2) {
        this.a = r1;
        this.b = true;
        this.c = r2;
    }
}
