package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        qo0.a.b("LiveMgMountContextService", "request live minigame meta config fail", (Throwable) r3);
    }
}
