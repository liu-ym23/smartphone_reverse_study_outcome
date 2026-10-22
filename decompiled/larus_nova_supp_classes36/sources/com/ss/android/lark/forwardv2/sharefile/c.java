package com.ss.android.lark.forwardv2.sharefile;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements RxScheduledExecutor.Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void consume(Object r3) {
        Log.e("FileShareEnhancedView", "get file error", (Throwable) r3);
    }
}
