package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMiniGamePlayService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 implements ILiveMiniGamePlayService {
    public c0() {
    }

    public final void closeMiniGamePlayGame(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        jc1.k.n(IInteractGameService.class).closeOpenPlatformGame(r2);
    }

    public final boolean isMiniGamePlayRunning(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.getCurrentOpenPlatformAppInfo();
        if (r1 == null) goto L9;
        i0 r3 = (i0) r1.getValue();
        if (r3 == null) goto L9;
        String r4 = r3.b;
    L11:
        return Intrinsics.areEqual(r4, r2);
    L9:
        r4 = null;
        goto L11
    }

    public final void preloadMiniGamePlayGame(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        jc1.k.n(IInteractGameService.class).preloadOpenPlatformGame(r2);
    }

    public final void openMiniGamePlayGame(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "startParmaMap");
        jc1.k.n(IInteractGameService.class).openOpenPlatformGame(r2, r3);
    }
}
