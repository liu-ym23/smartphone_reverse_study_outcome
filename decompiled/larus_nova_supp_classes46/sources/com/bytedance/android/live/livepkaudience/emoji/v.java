package com.bytedance.android.live.livepkaudience.emoji;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    public final void accept(Object r3) {
        int r0 = x8.a.a;
        x8.a.b("interact_emoji", "query_user failed " + ((Throwable) r3), false);
    }
}
