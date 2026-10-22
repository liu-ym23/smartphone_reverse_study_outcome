package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        int r0 = qo0.a.a;
        String r4 = ((Throwable) r3).getMessage();
        if (r4 != null) goto L5;
        r4 = "receive anchor exit room event";
    L5:
        qo0.a.b("MiniGameDetailPageDialog", r4, null);
    }
}
