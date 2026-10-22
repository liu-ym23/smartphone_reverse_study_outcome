package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f1<T> implements Consumer {
    public static final f1 a = null;

    static {
        a = new f1();
    }

    public f1() {
    }

    public final void accept(Object r4) {
        jy0.b.c("ScoreboardInvitationHandler", "readyForRound failed: " + ((Throwable) r4), null, 4);
    }
}
