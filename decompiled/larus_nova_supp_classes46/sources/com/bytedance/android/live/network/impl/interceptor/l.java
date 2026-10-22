package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        RxUtil.getNoOpThrowable();
    }
}
