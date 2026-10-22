package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class la implements ca0.s {
    public final /* synthetic */ CallContext a;

    public la(CallContext r1) {
        this.a = r1;
    }

    @Override // ca0.s
    public final void j(com.bytedance.android.livesdk.gift.platform.business.sendGift.f r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        CallContext r0 = this.a;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("giftIds", new JSONArray(r5.a));
        r1[1] = TuplesKt.to("succeed", Boolean.valueOf(r5.c));
        Exception r6 = r5.d;
        if (r6 == null) goto L5;
        String r7 = r6.getMessage();
    L6:
        r1[2] = TuplesKt.to("error", r7);
        r0.b("Hybrid_sendGiftSucceed", com.bytedance.android.live.revenue.common.q.b(r1));
        return;
    L5:
        r7 = null;
        goto L6
    }
}
