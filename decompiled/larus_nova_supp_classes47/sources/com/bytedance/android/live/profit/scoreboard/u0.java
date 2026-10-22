package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u0<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public u0(v0 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        r0 r0 = this.a.a.a;
        int r1 = r0.g;
        r0.getClass();
        ToastUtil.a(2131922339, 0);
        v0 r2 = this.a;
        r2.a.a.f.i(r2.b.c, ((dv0.k) r5).getRoundId(), ScoreboardEventTracker.ToastContent.RoundStarted);
    }
}
