package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 extends com.bytedance.android.live.broadcastgame.d0<y> {
    public a0() {
    }

    @Override // com.bytedance.android.live.broadcastgame.d0
    public final Observable a(com.bytedance.android.live.broadcastgame.v r11) {
        y r12 = (y) r11;
        Intrinsics.checkNotNullParameter(r12, "message");
        Lazy r0 = LiveOpenGameClient.d;
        return ((AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class)).sendStatusMessage(r12.b, r12.a, r12.e, r12.f, r12.a().toString()).compose(RxUtil.rxSchedulerHelper()).map(z.a);
    }
}
