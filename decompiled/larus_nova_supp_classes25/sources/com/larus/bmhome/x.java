package com.larus.bmhome;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new w());
    }

    public static final IChatAzerothService a() {
        return (IChatAzerothService) a.getValue();
    }
}
