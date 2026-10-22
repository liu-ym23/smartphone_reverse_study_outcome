package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Consumer {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
    }

    public final void accept(Object r2) {
        f2.c(((Throwable) r2).getMessage(), 0);
    }
}
