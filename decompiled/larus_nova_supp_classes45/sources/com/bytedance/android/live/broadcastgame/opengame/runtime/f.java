package com.bytedance.android.live.broadcastgame.opengame.runtime;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "LiveBasePluginManager", "fetchCollectStatus error");
    }
}
