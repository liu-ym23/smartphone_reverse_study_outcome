package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.b("update switch status failed", (Throwable) r2);
    }
}
