package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends lr0.a {
    public o(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r2) {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r3 = AnchorMiniGameDataContext.a.a();
        if (r3 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getOpenLynxPanelInGame();
        if (r4 == null) goto L10;
        r4.setValue(Boolean.TRUE);
        return null;
    L10:
        return null;
    L9:
        return null;
    }
}
