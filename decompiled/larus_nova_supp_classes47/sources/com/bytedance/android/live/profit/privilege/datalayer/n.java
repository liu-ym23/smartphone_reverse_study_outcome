package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ Long b;

    public n(d r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        com.bytedance.android.live.profit.privilege.e r8 = com.bytedance.android.live.profit.privilege.e.a;
        String r0 = this.a.f();
        long r1 = this.a.d();
        Long r3 = this.b;
        Intrinsics.checkNotNullParameter(r0, "userId");
        JSONObject r2 = com.bytedance.android.live.profit.privilege.e.k(true, null, null);
        JSONObject r9 = com.bytedance.android.live.profit.privilege.e.m(r8, Long.valueOf(r1), 4);
        if (r3 == null) goto L5;
        long r4 = r3.longValue();
    L6:
        com.bytedance.android.live.profit.privilege.e.t(r9, "meta_id", Long.valueOf(r4));
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_ack_entrance_status_all", r2, null, r9);
        return;
    L5:
        r4 = 0;
        goto L6
    }
}
