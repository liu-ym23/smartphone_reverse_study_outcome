package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Consumer {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        int r0 = XplayLog.a;
        XplayLog.c("XplayCoreService", "ask for switch guide resp failed, code=" + com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r4) + ", message=" + r4.getMessage());
    }
}
