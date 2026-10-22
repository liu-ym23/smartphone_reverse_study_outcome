package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z0<T> implements Consumer {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ dv0.f b;

    public z0(r0 r1, dv0.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        jy0.b.d("ScoreboardInvitationHandler", "error while processing invitation: " + ((Throwable) r3));
        r0.a(this.a, this.b, false);
    }
}
