package com.obric.assistant.oauto;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static final IOAutoApi a() {
        return (IOAutoApi) a.getValue();
    }
}
