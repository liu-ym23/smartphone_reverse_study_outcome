package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ d a;

    public l(d r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        Intrinsics.checkNotNullParameter(r8, "t");
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
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_info_growth_status_all", com.bytedance.android.live.profit.privilege.e.k(false, r4, Integer.valueOf(r9)), com.bytedance.android.live.profit.privilege.e.n(null), com.bytedance.android.live.profit.privilege.e.m(r0, Long.valueOf(r2), 4));
        d.a(this.a, null);
    }
}
