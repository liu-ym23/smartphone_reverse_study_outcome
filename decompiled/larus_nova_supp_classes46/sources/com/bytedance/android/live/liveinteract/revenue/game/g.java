package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r3) {
        ALogger.e("LinkMicGameWidget", "[preEnterRoom] error: url=get_play_mode_info, errorCode=" + com.bytedance.android.live.broadcastgame.api.openplatform.h.a((Throwable) r3));
    }
}
