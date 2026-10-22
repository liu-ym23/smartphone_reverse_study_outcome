package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public k0(PayMethod r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r9) {
        BaseResponse r11 = (BaseResponse) r9;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch order status success, order id: ", ((com.bytedance.android.live.broadcastgame.opengame.network.i0) r11.data).a(), ", order status: ", Integer.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.i0) r11.data).b())});
        Object r12 = r11.data;
        if (r12 == null) goto L20;
        int r13 = ((com.bytedance.android.live.broadcastgame.opengame.network.i0) r12).b();
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L8;
        PayMethod r14 = this.a;
        PayMethod.v(r14, this.b, r14.j);
        return;
    L8:
        if (r13 == 3) goto L12;
        if (r13 != 4) goto L25;
        PayMethod r15 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        String r4 = r15.j;
        r15.z(r3, 2131921032);
        int r16 = x10.f.a;
        x10.f.b(this.a.d, 4, r3, null, -2);
        return;
    L25:
        return;
    L12:
        PayMethod.w(this.a);
        PayMethod r17 = this.a;
        OpenApiErrorInfo r5 = OpenApiErrorInfo.NO_SUFFICIENT_BALANCE;
        String r6 = r17.j;
        r17.z(r5, 2131921032);
        int r18 = x10.f.a;
        x10.f.b(this.a.d, 4, r5, null, -2);
        return;
    L15:
        if (this.c != 1) goto L17;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"query still fail, order id: " + this.a.j});
        PayMethod r19 = this.a;
        OpenApiErrorInfo r2 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        String r7 = r19.j;
        r19.z(r2, 2131921035);
        int r21 = x10.f.a;
        x10.f.b(this.a.d, 4, r2, null, -2);
        return;
    L17:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"continue query, order id: " + this.a.j});
        PayMethod.s(this.a, this.b, this.c - 1);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.PayOrderStatusResponse");
    }
}
