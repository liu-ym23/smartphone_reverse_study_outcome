package com.bytedance.android.live.broadcastgame.opengame.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "LiveBasePluginManager", "on registerShowPanelEvent login Error");
    }
}
