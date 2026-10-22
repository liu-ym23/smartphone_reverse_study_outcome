package com.obric.assistant.obric_action;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new b());
    }

    public static final IObricActionService a() {
        return (IObricActionService) a.getValue();
    }
}
