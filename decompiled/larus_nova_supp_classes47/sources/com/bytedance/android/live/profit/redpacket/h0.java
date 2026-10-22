package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public h0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        if (this.a.u.c().isShowing() == false) goto L5;
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        this.a.v.h(r5);
        RxUtilKt.c(this.a.v.u.subscribe(g0.a), this.a.f);
        ToastUtil.a(2131922030, 0);
        this.a.v.h(r5);
        return;
    L12:
        return;
    L7:
        r0 = false;
        goto L8
    }
}
