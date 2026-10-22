package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0<T> implements Consumer {
    public final /* synthetic */ PayMethod a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public l0(PayMethod r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r11) {
        Throwable r12 = (Throwable) r11;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch order status fail, error: ", r12, ", order id: ", this.a.j});
        if ((r12 instanceof CustomApiServerException) == true) goto L5;
        Throwable r1 = null;
    L6:
        CustomApiServerException r2 = (CustomApiServerException) r1;
        if (r2 == null) goto L18;
        int r13 = r2.getErrorCode();
        if (r13 != 10001) goto L11;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch service unavailable, order id: " + this.a.j});
        PayMethod.s(this.a, this.b, this.c - 1);
        return;
    L11:
        if (r13 != 10011) goto L13;
    L15:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"order status error, code: ", Integer.valueOf(r2.getErrorCode()), ", order id: ", this.a.j});
        PayMethod r14 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        r14.y(r3);
        int r15 = x10.f.a;
        x10.f.b(this.a.d, 4, r3, null, r2.getErrorCode());
        return;
    L13:
        if (r13 == 4014040) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"fetch again, code: ", Integer.valueOf(r2.getErrorCode()), ", order id:", this.a.j});
        PayMethod.s(this.a, this.b, this.c - 1);
        return;
    L18:
        if ((r12 instanceof SocketTimeoutException) == false) goto L20;
    L25:
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"fetch request timeout, fetch again, order id: " + this.a.j});
        PayMethod.s(this.a, this.b, this.c - 1);
        return;
    L20:
        if ((r12 instanceof IOException) == true) goto L25;
        if ((r12 instanceof NetworkErrorException) == true) goto L25;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethod", new Object[]{"unknown fetch error, order id: " + this.a.j});
        PayMethod.u(this.a, r12);
        int r4 = x10.f.a;
        x10.f.b(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, r12, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r12));
        return;
    L5:
        r1 = r12;
        goto L6
    }
}
