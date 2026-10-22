package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0<T> implements Consumer {
    public final /* synthetic */ r0.e a;
    public final /* synthetic */ dv0.n b;

    public v0(r0.e r1, dv0.n r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        if ((this.b instanceof dv0.c) == false) goto L8;
        r0 r0 = this.a.a;
        int r1 = r0.g;
        r0.getClass();
        ToastUtil.a(2131922338, 0);
        this.a.a.f.i(this.b.c, r7.longValue(), ScoreboardEventTracker.ToastContent.InvitationSent);
        if (this.b.d == 0) goto L9;
        RxUtilKt.c(this.a.a.c.q().filter(new t0(r7)).take(1).subscribe(new u0(this)), this.a.a.a);
        return;
    L9:
        return;
    }
}
