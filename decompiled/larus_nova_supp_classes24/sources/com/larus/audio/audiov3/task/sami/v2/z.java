package com.larus.audio.audiov3.task.sami.v2;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new y());
    }

    public static final SamiConnectionPoolImpl a() {
        return (SamiConnectionPoolImpl) a.getValue();
    }
}
