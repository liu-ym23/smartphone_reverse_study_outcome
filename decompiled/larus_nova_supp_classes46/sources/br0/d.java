package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends lr0.a {
    public d(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        LiveMgCastContextService r4 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);
        Bundle r0 = new Bundle();
        r0.putBoolean("is_live_casting", r4.i());
        return r0;
    }
}
