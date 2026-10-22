package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ Long b;

    public o(d r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        Intrinsics.checkNotNullParameter(r9, "t");
        com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
        String r1 = this.a.f();
        long r2 = this.a.d();
        Long r4 = this.b;
        String r5 = q0.a(r9);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        int r10 = r0.a(r9);
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.ERROR);
        JSONObject r12 = com.bytedance.android.live.profit.privilege.e.k(false, r5, Integer.valueOf(r10));
        JSONObject r3 = com.bytedance.android.live.profit.privilege.e.n(null);
        JSONObject r6 = com.bytedance.android.live.profit.privilege.e.m(r0, Long.valueOf(r2), 4);
        if (r4 == null) goto L8;
        long r7 = r4.longValue();
    L9:
        com.bytedance.android.live.profit.privilege.e.t(r6, "meta_id", Long.valueOf(r7));
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_ack_entrance_status_all", r12, r3, r6);
        return;
    L8:
        r7 = 0;
        goto L9
    }
}
