package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends com.bytedance.android.live.broadcastgame.d0<f> {
    public j() {
    }

    @Override // com.bytedance.android.live.broadcastgame.d0
    public final Observable a(com.bytedance.android.live.broadcastgame.v r11) {
        f r12 = (f) r11;
        Intrinsics.checkNotNullParameter(r12, "message");
        Lazy r0 = LiveOpenGameClient.d;
        AudienceGameNetApi r1 = (AudienceGameNetApi) LiveOpenGameClient.a.a().a(AudienceGameNetApi.class);
        long r2 = r12.b;
        String r4 = r12.a;
        String r5 = r12.d;
        JSONObject r3 = new JSONObject();
        r3.put(OpenPlatformBaseDebugger.APP_ID, r12.a);
        r3.put("room_id", r12.b);
        r3.put("conn_id", r12.c);
        return r1.sendMessageToAnchor(r2, r4, r5, r3.toString()).compose(RxUtil.rxSchedulerHelper()).map(i.a);
    }
}
