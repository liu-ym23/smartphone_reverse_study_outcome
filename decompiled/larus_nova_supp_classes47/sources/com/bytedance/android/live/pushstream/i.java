package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r2) {
        ALogger.e("LiveStream", (Throwable) r2);
    }
}
