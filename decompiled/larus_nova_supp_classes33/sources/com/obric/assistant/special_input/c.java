package com.obric.assistant.special_input;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new b());
    }

    public static final ISpecialInputTask a() {
        return (ISpecialInputTask) a.getValue();
    }
}
