package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p2<T> implements Consumer {
    public final /* synthetic */ m2 a;

    public p2(m2 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Unit r6 = (Unit) r5;
        m2 r7 = this.a;
        LotteryState r0 = r7.d();
        if ((r0 instanceof LotteryState.g) == false) goto L6;
        com.bytedance.live.datacontext.k<Integer> r8 = r7.e.getOnIconClick();
        i.B0.getClass();
        r8.post(0);
        return;
    L6:
        if ((r0 instanceof LotteryState.d) == false) goto L9;
        com.bytedance.live.datacontext.k<Integer> r9 = r7.e.getOnIconClick();
        i.B0.getClass();
        r9.post(0);
        return;
    L9:
        if ((r0 instanceof LotteryState.f) == false) goto L14;
        int r10 = ToastUtil.a;
        String r12 = w2.e().reviewingString;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        ToastUtil.b(r12, 0);
        return;
    L14:
        String r1 = w2.e().anchorLotteryCreateUri;
        i.B0.getClass();
        r7.g(r1, r0, 0);
    }
}
