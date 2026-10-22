package com.bytedance.android.ec.core.monitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u<T> implements Consumer {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public final void accept(Object r1) {
        ((Throwable) r1).printStackTrace();
    }
}
