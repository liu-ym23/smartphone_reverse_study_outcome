package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void accept(Object r3) {
        int r0 = qo0.a.a;
        qo0.a.b("MemoryContextService", "upgrade fail, error: " + ((Throwable) r3), null);
    }
}
