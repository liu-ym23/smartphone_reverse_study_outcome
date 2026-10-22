package com.bytedance.android.live.schema.helper;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        ALogger.e("LynxCacheHelper", "evict failed", (Throwable) r3);
    }
}
