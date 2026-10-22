package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
        String r1 = this.a.f();
        long r2 = this.a.d();
        String r4 = q0.a(r8);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        int r9 = r0.a(r8);
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.ERROR);
        JSONObject r10 = com.bytedance.android.live.profit.privilege.e.k(false, r4, Integer.valueOf(r9));
        JSONObject r3 = com.bytedance.android.live.profit.privilege.e.n(null);
        JSONObject r5 = com.bytedance.android.live.profit.privilege.e.m(r0, Long.valueOf(r2), 4);
        com.bytedance.android.live.profit.privilege.e.p("ttlive_gift_panel_touch_status_all", r10, r3, r5);
        com.bytedance.android.live.profit.privilege.e.p("ttlive_gift_panel_touch_status_error", r10, r3, r5);
    }
}
