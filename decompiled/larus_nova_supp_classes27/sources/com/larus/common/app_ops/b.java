package com.larus.common.app_ops;

import com.larus.common.app_ops.trasmitter.AsyncContext;
import com.larus.common.app_ops.trasmitter.AsyncContextLegacy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final b a = null;
    public static final ThreadLocal<AsyncContextLegacy> b = null;

    public b() {
    }

    static {
        a = new b();
        b = new ThreadLocal();
    }

    public final AsyncContext getContext() {
        return b.get();
    }
}
