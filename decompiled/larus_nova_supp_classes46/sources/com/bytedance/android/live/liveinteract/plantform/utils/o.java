package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final void accept(Object r2) {
        ALogger.i("IMStreamInfoSender", String.valueOf(((Throwable) r2).getMessage()));
    }
}
