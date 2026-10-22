package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ p0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public r0(p0 r1, String r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r11) {
        Throwable r12 = (Throwable) r11;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch order status fail, error: ", r12, ", order id: ", this.b});
        if ((r12 instanceof CustomApiServerException) == true) goto L5;
        Throwable r1 = null;
    L6:
        CustomApiServerException r2 = (CustomApiServerException) r1;
        if (r2 == null) goto L18;
        int r13 = r2.getErrorCode();
        if (r13 != 10001) goto L11;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch service unavailable, order id: " + this.b});
        p0.s(this.a, this.c, this.b, this.d - 1);
        return;
    L11:
        if (r13 != 10011) goto L13;
    L15:
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"order status error, code: ", Integer.valueOf(r2.getErrorCode()), ", order id: ", this.b});
        p0 r14 = this.a;
        OpenApiErrorInfo r3 = OpenApiErrorInfo.ORDER_STATUS_ERROR;
        p0.x(r14, r3, this.b);
        int r15 = x10.f.a;
        x10.f.d(this.a.d, 4, r3, null, r2.getErrorCode());
        return;
    L13:
        if (r13 == 4014040) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"fetch again, code: ", Integer.valueOf(r2.getErrorCode()), ", order id:", this.b});
        p0.s(this.a, this.c, this.b, this.d - 1);
        return;
    L18:
        if ((r12 instanceof SocketTimeoutException) == false) goto L20;
    L25:
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"fetch request timeout, fetch again, order id: " + this.b});
        p0.s(this.a, this.c, this.b, this.d - 1);
        return;
    L20:
        if ((r12 instanceof IOException) == true) goto L25;
        if ((r12 instanceof NetworkErrorException) == true) goto L25;
        com.bytedance.android.live.broadcastgame.opengame.q.e("PayMethodV3", new Object[]{"unknown fetch error, order id: " + this.b});
        p0.y(this.a, r12);
        int r4 = x10.f.a;
        x10.f.d(this.a.d, 4, OpenApiErrorInfo.INTERNAL_ERROR, r12, com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r12));
        return;
    L5:
        r1 = r12;
        goto L6
    }
}
