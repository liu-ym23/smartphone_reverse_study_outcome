package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;

    public k(d r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e r2 = com.bytedance.android.live.profit.privilege.e.a;
        String r3 = this.a.f();
        long r4 = this.a.d();
        Intrinsics.checkNotNullParameter(r3, "userId");
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_info_growth_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r1)), com.bytedance.android.live.profit.privilege.e.m(r2, Long.valueOf(r4), 4));
        d.a(this.a, ((com.bytedance.android.live.profit.privilege.model.touch.j) ((ExtraResponse) r8).data).getTouchPositionMap());
    }
}
