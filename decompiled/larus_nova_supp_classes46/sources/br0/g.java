package br0;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends lr0.a {
    public g(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r5) {
        if (((LiveMgMountContextService) this.a.getService(LiveMgMountContextService.class)).c == false) goto L8;
        if (r5 == null) goto L9;
        LiveMgCastContextService r0 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);
        boolean r1 = r5.getBoolean("result");
        String r6 = r5.getString("errMsg", "");
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "errMsg");
        i0.c().post(new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.d(r0, r1, r6));
        return null;
    L9:
        return null;
    L8:
        return null;
    }
}
