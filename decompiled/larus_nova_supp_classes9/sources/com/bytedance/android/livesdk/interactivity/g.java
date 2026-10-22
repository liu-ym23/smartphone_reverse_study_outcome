package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r2) {
        ALogger.e("fetch History Mention Chat Res Error", (Throwable) r2);
    }
}
