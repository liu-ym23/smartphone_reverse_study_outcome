package com.bytedance.android.livesdk.gift.grouplive.component;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        jy0.b.c("GroupComponentView", "request failed: " + ((Throwable) r4), null, 4);
    }
}
