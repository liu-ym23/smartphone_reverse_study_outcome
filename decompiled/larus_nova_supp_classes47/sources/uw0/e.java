package uw0;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.panel.g;
import com.bytedance.android.live.recharge.utils.m;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements b {
    public final com.bytedance.android.live.recharge.deal.f a;

    public e(com.bytedance.android.live.recharge.deal.f r2) {
        Intrinsics.checkNotNullParameter(r2, "deal");
        this.a = r2;
    }

    @Override // uw0.b
    public final k a(k r6) {
        Intrinsics.checkNotNullParameter(r6, "orderOptions");
        com.bytedance.android.live.recharge.panel.context.c r0 = g.a();
        if (r0 == null) goto L5;
        com.bytedance.android.live.recharge.model.d r1 = r0.a();
    L6:
        j r2 = r6.a;
        int r3 = m.a;
        r2.put("recharge_package_source", m.d(this.a, r1));
        if ((this.a instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L9;
        r2.put("cj_extra", UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("enter_from", "live_room_in_app_custom_recharge")}).toString());
    L9:
        com.bytedance.android.live.recharge.deal.f r4 = this.a;
        if ((r4 instanceof u) == false) goto L12;
        r2.put("diamond_safe", ((u) r4).k);
    L12:
        r2.put("given_scores", String.valueOf(this.a.h()));
        r2.put("counter_opt_enable", DataType.TRUE);
        r2.put("diamond_extra_safe", this.a.c().i());
        if (r1 == null) goto L16;
        String r5 = r1.l;
        if (r5 == null) goto L16;
    L17:
        r2.put("promotion_source", r5);
        return r6;
    L16:
        r5 = "";
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}
