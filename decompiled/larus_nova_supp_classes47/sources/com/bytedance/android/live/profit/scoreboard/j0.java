package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ ScoreboardExternalServiceFacade a;

    public j0(ScoreboardExternalServiceFacade r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        jy0.b.d("ScoreboardServiceFacade", "current round changed: " + ((dv0.h) sh6.c.b(r4)));
        Object r5 = sh6.c.b(r4);
        if (r5 == null) goto L6;
        dv0.h r6 = (dv0.h) r5;
        this.a.b.onNext(r6);
        r6.c().subscribe(new i0(this));
        return;
    }
}
