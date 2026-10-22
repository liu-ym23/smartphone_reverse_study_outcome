package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0<T> implements Consumer {
    public static final g0 a = null;

    static {
        a = new g0();
    }

    public g0() {
    }

    public final void accept(Object r3) {
        ALogger.d("LandscapeTopMoreHolder", "bitmap download error: " + ((Throwable) r3).toString());
    }
}
