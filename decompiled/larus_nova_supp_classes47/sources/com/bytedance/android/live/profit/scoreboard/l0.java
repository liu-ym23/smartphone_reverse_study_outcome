package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0 implements Action {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public l0(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        jy0.b.d("ScoreboardServiceFacade", "subscription disposed: " + this.a + ' ' + this.b);
    }
}
