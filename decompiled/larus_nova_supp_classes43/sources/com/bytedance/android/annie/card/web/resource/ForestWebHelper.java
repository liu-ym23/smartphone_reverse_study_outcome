package com.bytedance.android.annie.card.web.resource;

import kotlin.Lazy;
import kotlin.LazyKt;
import y9.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ForestWebHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ForestWebHelper$config$2.INSTANCE);
    }

    public static q a() {
        return (q) a.getValue();
    }
}
