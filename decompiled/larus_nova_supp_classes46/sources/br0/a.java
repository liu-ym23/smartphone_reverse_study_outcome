package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends lr0.a {
    public a(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r4 = AnchorMiniGameDataContext.a.a();
        if (r4 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.getOpenAudiencePanel();
        if (r5 == null) goto L7;
        r5.setValue(Boolean.TRUE);
    L7:
        ((BridgeContextService) this.a.getService(BridgeContextService.class)).g("command_close_minigame", null);
        return null;
    }
}
