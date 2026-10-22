package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r3) {
        ALogger.d("OpenPlatformPerfReporter", "/data/upload/ error: " + ((Throwable) r3).getMessage());
    }
}
