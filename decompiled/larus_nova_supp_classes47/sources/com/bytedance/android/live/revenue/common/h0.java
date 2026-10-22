package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 implements Consumer<Throwable> {
    public static final h0 a = null;

    public static final class a {
    }

    public h0() {
    }

    static {
        a = new h0();
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        if (r4 == null) goto L6;
        ALogger.stacktrace(6, "RxErrorConsumer", r4.getStackTrace());
        return;
    }
}
