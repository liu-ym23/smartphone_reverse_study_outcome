package br0;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService$pauseLiveCast$1;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends lr0.a {
    public i(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r6) {
        if (r6 == null) goto L5;
        final String r7 = r6.getString("exit_reason");
    L6:
        final LiveMgCastContextService r1 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);
        if (r1.i() == false) goto L15;
        MiniAppInstance r2 = this.a.getMiniGameInstance();
        if (r2 == null) goto L11;
        String r3 = r2.getAppId();
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        Intrinsics.checkNotNullParameter(r3, "appId");
        int r4 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "pauseLiveCast appId: " + r3 + ", reason:" + r7);
        i0.c().post(new LiveMgCastContextService$pauseLiveCast$1(r1, r7));
        goto L15
    L11:
        r3 = null;
    L15:
        DataCenter r8 = this.a.getDataCenter();
        if (r8 == null) goto L18;
        r8.put("cmd_notify_live_game_play_toolbar_show_bubble", Boolean.TRUE);
    L18:
        return null;
    L5:
        r7 = null;
        goto L6
    }
}
