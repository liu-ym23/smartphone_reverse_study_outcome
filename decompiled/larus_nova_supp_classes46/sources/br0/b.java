package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.jsb.MiniGameCommonJsbContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends lr0.a {
    public b(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r4) {
        String r0 = "";
        if (r4 == null) goto L8;
        String r5 = r4.getString("mp_id", "");
        if (r5 == null) goto L8;
        r0 = r5;
    L8:
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r6 = AnchorMiniGameDataContext.a.a();
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m<String> r7 = r6.getOpenFeatureBinderId();
        if (r7 == null) goto L13;
        String r8 = (String) r7.getValue();
    L15:
        if (Intrinsics.areEqual(r0, r8) == true) goto L17;
    L19:
        return null;
    L17:
        if (((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).i() == false) goto L19;
        int r9 = qo0.a.a;
        qo0.a.c("OnGameProcessKillEventListener", "on_game_process_killed: ".concat(r0));
        ((MiniGameCommonJsbContextService) this.a.getService(MiniGameCommonJsbContextService.class)).f();
        ((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).q(r0, "game process killed");
    L13:
        r8 = null;
        goto L15
    }
}
