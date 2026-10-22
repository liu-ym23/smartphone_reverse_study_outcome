package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ com.bytedance.platform.aio.channel.b b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public k0(h0 r1, AbstractChannelClient.a r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        Pair r0 = (Pair) this.a.e.invoke();
        View r1 = (View) r0.component1();
        String r2 = (String) r0.component2();
        int r3 = d.a;
        d.d(r1, r2, this.b.getChannelId(), this.c, this.d, r8);
        jy0.b.c("RevenueJsMethodServer", "write err " + this.c + ", methodId: " + this.d + "  " + r8, null, 4);
    }
}
