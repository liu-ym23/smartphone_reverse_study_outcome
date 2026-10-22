package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public m0(PayMethod r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        BaseResponse r12 = (BaseResponse) r11;
        Object r0 = r12.data;
        if ((r0 instanceof com.bytedance.android.live.broadcastgame.opengame.network.g0) == true) goto L5;
        int r13 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethod", new Object[]{"invalid pay diamond response, order id: " + this.b});
        PayMethod r14 = this.a;
        OpenApiErrorInfo r1 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        r14.y(r1);
        int r15 = x10.f.a;
        x10.f.b(this.a.d, 4, r1, null, -1);
        return;
    L5:
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"pay diamond success, order id: ", ((com.bytedance.android.live.broadcastgame.opengame.network.g0) r0).a(), ", status: ", Integer.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.g0) r12.data).b())});
        Object r16 = r12.data;
        if (r16 == null) goto L20;
        int r17 = ((com.bytedance.android.live.broadcastgame.opengame.network.g0) r16).b();
        if (r17 == 1) goto L17;
        if (r17 != 2) goto L11;
        PayMethod.v(this.a, this.c, this.b);
        return;
    L11:
        if (r17 == 3) goto L15;
        if (r17 != 4) goto L25;
        PayMethod r18 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        r18.z(r3, 2131921032);
        int r19 = x10.f.a;
        x10.f.b(this.a.d, 4, r3, null, 4);
        return;
    L25:
        return;
    L15:
        PayMethod.w(this.a);
        PayMethod r110 = this.a;
        OpenApiErrorInfo r4 = OpenApiErrorInfo.NO_SUFFICIENT_BALANCE;
        r110.z(r4, 2131921032);
        int r111 = x10.f.a;
        x10.f.b(this.a.d, 4, r4, null, -1);
        return;
    L17:
        PayMethod.s(this.a, this.c, 3);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.PayDiamondsResponse");
    }
}
