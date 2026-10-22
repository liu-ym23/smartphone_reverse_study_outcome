package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r2) {
        ALogger.e("ttlive_anchor_link_wm", (Throwable) r2);
    }
}
