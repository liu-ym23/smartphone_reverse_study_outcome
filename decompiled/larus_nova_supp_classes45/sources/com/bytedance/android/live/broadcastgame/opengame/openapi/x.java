package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.ExtraResponse;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x {
    public final /* synthetic */ w.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ExtraResponse d;

    public final void a() {
        Intrinsics.checkNotNullParameter("feature not support", "errMsg");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("GetUserInfoV2Method", new Object[]{"auth fail, msg: feature not support"});
        this.a.a.n(OpenApiErrorInfo.INTERNAL_ERROR, new Throwable("feature not support"));
    }

    public final void b(List<Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        int r5 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("GetUserInfoV2Method", new Object[]{"auth success"});
        JSONObject r6 = new JSONObject().put("nickName", this.b).put("avatarUrl", this.c).put("role", ((com.bytedance.android.live.broadcastgame.opengame.network.d0) this.d.data).a().d()).put("openUID", ((com.bytedance.android.live.broadcastgame.opengame.network.d0) this.d.data).a().c());
        w r0 = this.a.a;
        JSONObject r1 = new JSONObject();
        r1.put("userInfo", r6);
        Unit r7 = Unit.INSTANCE;
        r0.r(r1);
    }

    public x(w.b r1, String r2, String r3, ExtraResponse r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
