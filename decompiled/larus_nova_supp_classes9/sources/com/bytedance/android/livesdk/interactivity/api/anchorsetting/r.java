package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r2) {
        f2.c(((Throwable) r2).getMessage(), 0);
    }
}
