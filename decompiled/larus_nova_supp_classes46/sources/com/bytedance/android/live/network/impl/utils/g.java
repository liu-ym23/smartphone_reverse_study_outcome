package com.bytedance.android.live.network.impl.utils;

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
        ALogger.stacktrace(6, "NinePatchUtil", ((Throwable) r3).getStackTrace());
    }
}
