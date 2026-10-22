package com.bytedance.android.live.revlink.impl.control;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n<T> implements Consumer {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if (r3 == null) goto L6;
        com.bytedance.android.live.revlink.impl.utils.t.b("LinkRevControlPresenter", r3);
        return;
    }
}
