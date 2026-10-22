package com.bytedance.android.live.revlink.impl.plantform;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        if (r2 == null) goto L6;
        r2.printStackTrace();
        return;
    }
}
