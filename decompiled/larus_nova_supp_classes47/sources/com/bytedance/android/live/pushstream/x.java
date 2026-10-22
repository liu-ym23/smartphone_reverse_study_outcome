package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T> implements Consumer {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    public final void accept(Object r2) {
        ALogger.e("LiveStream", (Throwable) r2);
    }
}
