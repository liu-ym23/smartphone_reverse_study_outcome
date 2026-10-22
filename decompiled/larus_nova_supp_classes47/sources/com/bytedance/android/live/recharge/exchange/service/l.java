package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ ExchangeRoomService a;

    public l(ExchangeRoomService r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        boolean r5 = com.bytedance.android.live.recharge.util.d.d((ExchangeInfo) r4);
        if (r5 == false) goto L11;
        ExchangeRoomService r0 = this.a;
        if (r0.c != null) goto L11;
        r0.c = new kw0.a();
        if (r0.d.getRoom().isMediaRoom() == true) goto L11;
        kw0.a r1 = r0.c;
        if (r1 == null) goto L11;
        r0.c().e(RevToolbarButton.CashExchange, r1);
    L11:
        ExchangeRoomService r2 = this.a;
        if (r5 == false) goto L16;
        r2.c().d(RevToolbarButton.FastGift);
        kw0.a r6 = r2.c;
        if (r6 == null) goto L18;
        r2.c().e(RevToolbarButton.CashExchange, r6);
        return;
    L18:
        return;
    L16:
        r2.c().d(RevToolbarButton.CashExchange);
    }
}
