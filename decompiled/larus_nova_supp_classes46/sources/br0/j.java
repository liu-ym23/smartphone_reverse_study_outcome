package br0;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends lr0.a {
    public j(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r4) {
        LiveMgCastContextService r5 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);
        if (r5.i() == false) goto L11;
        MiniAppInstance r0 = this.a.getMiniGameInstance();
        if (r0 == null) goto L7;
        String r1 = r0.getAppId();
    L8:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        Intrinsics.checkNotNullParameter(r1, "appId");
        int r2 = qo0.a.a;
        qo0.a.c("LiveMgCastContextService", "resumeLiveCast appId: ".concat(r1));
        i0.c().post(new com.bytedance.android.live.openplatform.impl.minigameanchor.cast.f(r5));
        goto L11
    L7:
        r1 = null;
    L11:
        return null;
    }
}
