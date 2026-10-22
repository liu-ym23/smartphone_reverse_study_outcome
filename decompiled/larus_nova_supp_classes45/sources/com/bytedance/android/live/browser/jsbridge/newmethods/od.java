package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class od<T, R> implements Function {
    public static final od a = null;

    static {
        a = new od();
    }

    public od() {
    }

    public final Object apply(Object r1) {
        return Flowable.error((Throwable) r1);
    }
}
