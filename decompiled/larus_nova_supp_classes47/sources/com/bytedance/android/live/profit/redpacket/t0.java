package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.profit.redpacket.api.LuckyBoxApi;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ r0.p a;

    public t0(r0.p r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        if (((Number) r5).longValue() != 0) goto L22;
        int r6 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", "regular timer is triggered");
        this.a.b.b(RedPacketAction.Ready.INSTANCE);
        r0.p r7 = this.a;
        r0 r0 = r7.a;
        RedPacket r8 = r7.b;
        com.bytedance.android.live.revenue.common.u0 r1 = r0.y;
        r0.getClass();
        if (i1.a() != 0) goto L7;
        return;
    L7:
        if (i1.a() == 2) goto L25;
        Map<String, RedPacketDrawStatus> r2 = r0.b;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        RedPacketDrawStatus r4 = (RedPacketDrawStatus) r3.get(r8.getState().getInfo().d);
        RedPacketDrawStatus r9 = RedPacketDrawStatus.UNREWARDED;
        if (r4 != r9) goto L15;
        if (r8.getState().getInfo().c == true) goto L15;
        r0.r.a(r8.getState().getInfo().d);
        r0.t.onNext(r8.getState().getInfo());
        return;
    L15:
        if (r8.getState().getInfo().c == false) goto L19;
        Map<String, RedPacketDrawStatus> r10 = r0.b;
        LinkedHashMap r12 = (LinkedHashMap) r10;
        if (((RedPacketDrawStatus) r12.get(r8.getState().getInfo().d)) != r9) goto L19;
        int r13 = LuckyBoxApi.ReceiveReqType.REQ_TYPE_EXPAND_AWARD.getValue();
    L20:
        r0.f(CollectionsKt.listOf(r8), r13);
        return;
    L19:
        r13 = LuckyBoxApi.ReceiveReqType.REQ_TYPE_NORMAL.getValue();
        goto L20
    L25:
        return;
    }
}
