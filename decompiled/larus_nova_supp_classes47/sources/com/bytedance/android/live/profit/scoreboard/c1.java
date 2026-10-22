package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c1<T> implements Consumer {
    public static final c1 a = null;

    static {
        a = new c1();
    }

    public c1() {
    }

    public final void accept(Object r4) {
        jy0.b.c("ScoreboardInvitationHandler", "acceptRound failed: " + ((Throwable) r4), null, 4);
    }
}
