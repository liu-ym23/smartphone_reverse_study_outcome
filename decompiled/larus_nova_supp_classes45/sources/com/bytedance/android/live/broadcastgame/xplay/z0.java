package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z0<T> implements Consumer {
    public static final z0 a = null;

    static {
        a = new z0();
    }

    public z0() {
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "XplayPanelService", "on registerShowPanelEvent login Error");
    }
}
