package com.bytedance.android.live.broadcastgame.opengame;

import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements a20.a {
    public final /* synthetic */ w a;

    @Override // a20.a
    public final void onFailed() {
        this.a.onFail();
    }

    public r(InteractGameService.e r1) {
        this.a = r1;
    }

    @Override // a20.a
    public final void a(u r2) {
        Intrinsics.checkNotNullParameter(r2, "gameItem");
        this.a.a(r2);
    }
}
