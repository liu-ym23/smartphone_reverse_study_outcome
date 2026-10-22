package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ DynamicTeamFightWidget a;
    public final /* synthetic */ long b;

    public b(DynamicTeamFightWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        DynamicTeamFightWidget r0 = this.a;
        r0.j = false;
        long r1 = this.b;
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", "create");
        r0.yq(r3, r1, null);
        JsonObject r2 = new JsonObject();
        JsonObject r4 = new JsonObject();
        r4.addProperty("prompts", com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r8));
        r2.addProperty("status_code", Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8)));
        r2.add("data", r4);
        r3.add("data", r2);
        ALogger.d("DynamicTeamFightWidget", "sendCreateFailToMainLynx updateInfo=" + r3);
        r0.xq("playmode_manage_result", r3);
    }
}
