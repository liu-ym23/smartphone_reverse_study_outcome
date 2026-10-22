package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ALogger.e("square_tab", "get square message error");
    }
}
