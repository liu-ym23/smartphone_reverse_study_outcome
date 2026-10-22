package com.larus.platform.service;

import com.larus.platform.api.l2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l0 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new k0());
    }

    public static l2 a() {
        return (l2) a.getValue();
    }
}
