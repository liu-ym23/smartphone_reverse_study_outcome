package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.link.model.n9;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends e implements com.bytedance.android.live.revlink.link.biz.service.k {
    public final com.bytedance.android.live.revlink.impl.global.c e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.e;
    }

    public e0(ld.a r2, com.bytedance.android.livesdk.revenue.service.room.c r3, LinkFakeGlobalService r4) {
        Intrinsics.checkNotNullParameter(r4, "linkInstanceService");
        super(r2, r3, r4);
        this.e = r4;
    }

    public final void m(d11.o r24, n9 r25, Throwable r26, long r27) {
        Intrinsics.checkNotNullParameter(r24, "params");
        JSONObject r1 = new JSONObject();
        y50.b.a.d(r1, "invite_params", r24.toString());
        if (r25 == null) goto L5;
        y50.b.a.d(r1, "not_allow_map", r25.getNotAllowMap().toString());
    L5:
        c(r1);
        com.bytedance.android.live.revlink.link.biz.service.i.H(this).G("switch_channel_invite_failed", r26, r1, Long.valueOf(r27));
        com.bytedance.android.live.revlink.link.biz.service.i.b0(this).c("/webcast/linkmic/switch_channel_invite/", new d31.a(r24.b, 0, 0, 0, null, 0, 0, null, null, null, null, 4094), r26, r27);
    }
}
