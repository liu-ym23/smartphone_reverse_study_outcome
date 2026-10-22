package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0<T> implements Consumer {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "XplayGlobalService", "开播后恢复app/stop");
    }
}
