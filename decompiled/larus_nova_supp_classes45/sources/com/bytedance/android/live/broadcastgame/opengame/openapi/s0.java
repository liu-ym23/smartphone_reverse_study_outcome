package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.network.response.BaseResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public s0(p0 r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r11) {
        BaseResponse r12 = (BaseResponse) r11;
        Object r0 = r12.data;
        if ((r0 instanceof com.bytedance.android.live.broadcastgame.opengame.network.h0) == true) goto L5;
        int r13 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethodV3", new Object[]{"invalid pay diamond response, order id: " + this.b});
        p0 r14 = this.a;
        OpenApiErrorInfo r1 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        p0.x(r14, r1, this.b);
        int r15 = x10.f.a;
        x10.f.d(this.a.d, 4, r1, null, -1);
        return;
    L5:
        int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"pay diamond success, order id: ", ((com.bytedance.android.live.broadcastgame.opengame.network.h0) r0).a(), ", status: ", Integer.valueOf(((com.bytedance.android.live.broadcastgame.opengame.network.h0) r12.data).b())});
        Object r16 = r12.data;
        if (r16 == null) goto L19;
        int r17 = ((com.bytedance.android.live.broadcastgame.opengame.network.h0) r16).b();
        if (r17 == 1) goto L16;
        if (r17 == 2) goto L15;
        if (r17 == 3) goto L14;
        if (r17 == 4) goto L13;
        p0.s(this.a, this.c, this.b, 3);
        return;
    L13:
        p0 r18 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        p0.x(r18, r3, this.b);
        int r19 = x10.f.a;
        x10.f.d(this.a.d, 4, r3, null, 4);
        return;
    L14:
        p0.v(this.a, this.b);
        p0 r110 = this.a;
        OpenApiErrorInfo r4 = OpenApiErrorInfo.NO_SUFFICIENT_BALANCE;
        p0.x(r110, r4, this.b);
        int r111 = x10.f.a;
        x10.f.d(this.a.d, 4, r4, null, -1);
        return;
    L15:
        p0.u(this.a, this.c, this.b);
        return;
    L16:
        p0.s(this.a, this.c, this.b, 3);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.PayDiamondsV2Response");
    }
}
