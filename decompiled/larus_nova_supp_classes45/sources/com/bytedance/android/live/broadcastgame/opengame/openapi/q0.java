package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q0<T> implements Consumer {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public q0(p0 r1, long r2, String r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r12) {
        BaseResponse r13 = (BaseResponse) r12;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch order status success, order id: ", ((com.bytedance.android.live.broadcastgame.opengame.network.i0) r13.data).a(), ", order status: ", Integer.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.i0) r13.data).b())});
        Object r14 = r13.data;
        if (r14 == null) goto L22;
        int r15 = ((com.bytedance.android.live.broadcastgame.opengame.network.i0) r14).b();
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L15;
        if (r15 == 3) goto L14;
        if (r15 != 4) goto L10;
        p0 r16 = this.a;
        OpenApiErrorInfo r2 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        p0.x(r16, r2, this.c);
        int r17 = x10.f.a;
        x10.f.d(this.a.d, 4, r2, null, -2);
        return;
    L10:
        if (this.d != 1) goto L12;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"query still fail, order id: " + this.c});
        p0 r18 = this.a;
        OpenApiErrorInfo r1 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r18.w(r1, this.c, 2131921035);
        int r19 = x10.f.a;
        x10.f.d(this.a.d, 4, r1, null, -3);
        return;
    L12:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"continue query, order id: " + this.c});
        p0.s(this.a, this.b, this.c, this.d - 1);
        return;
    L14:
        p0.v(this.a, this.c);
        p0 r110 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.NO_SUFFICIENT_BALANCE;
        p0.x(r110, r3, this.c);
        int r111 = x10.f.a;
        x10.f.d(this.a.d, 4, r3, null, -2);
        return;
    L15:
        p0.u(this.a, this.b, this.c);
        return;
    L17:
        if (this.d != 1) goto L19;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"query still fail, order id: " + this.c});
        p0 r112 = this.a;
        OpenApiErrorInfo r4 = OpenApiErrorInfo.UNKNOWN_ORDER_STATUS;
        r112.w(r4, this.c, 2131921035);
        int r113 = x10.f.a;
        x10.f.d(this.a.d, 4, r4, null, -2);
        return;
    L19:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"continue query, order id: " + this.c});
        p0.s(this.a, this.b, this.c, this.d - 1);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.PayOrderStatusResponse");
    }
}
