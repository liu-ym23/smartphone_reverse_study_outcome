package com.bytedance.android.live.profit.scoreboard;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ScoreboardApiClient implements com.bytedance.android.scope.o {
    public final Lazy a;
    public final yz0.k b;
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a c;

    public final ScoreboardApi a() {
        return (ScoreboardApi) this.a.getValue();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public ScoreboardApiClient(yz0.k r2, com.bytedance.android.livesdk.revenue.service.broadcast.a r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "gameService");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ScoreboardApiClient$api$2(this));
    }
}
