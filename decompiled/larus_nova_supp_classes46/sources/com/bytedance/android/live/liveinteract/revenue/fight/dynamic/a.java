package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.model.interact.x1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ DynamicTeamFightWidget a;
    public final /* synthetic */ long b;

    public a(DynamicTeamFightWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        DynamicTeamFightWidget r0 = this.a;
        r0.j = false;
        long r2 = this.b;
        JsonObject r4 = new JsonObject();
        r4.addProperty("type", "create");
        r0.yq(r4, r2, r9.logId);
        JsonObject r3 = new JsonObject();
        JsonObject r5 = new JsonObject();
        r3.addProperty("status_code", 0);
        com.bytedance.android.live.liveinteract.multiscene.a r10 = ((x1) r9.data).getTeamFightInfo();
        if (r10 == null) goto L5;
        r5.add("teamfight_info", GsonProtectorUtils.toJsonTree(new Gson(), r10));
    L5:
        r3.add("data", r5);
        r4.add("data", r3);
        ALogger.d("DynamicTeamFightWidget", "sendCreateSucToMainLynx updateInfo=" + r4);
        r0.xq("playmode_manage_result", r4);
    }
}
