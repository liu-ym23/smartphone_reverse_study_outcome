package com.larus.bmhome.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g3 {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new e3());
        b = LazyKt.lazy(new f3());
    }

    public static long a() {
        return ((Number) b.getValue()).longValue();
    }
}
