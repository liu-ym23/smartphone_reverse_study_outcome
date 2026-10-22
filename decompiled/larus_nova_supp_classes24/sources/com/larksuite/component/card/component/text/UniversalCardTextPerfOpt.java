package com.larksuite.component.card.component.text;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardTextPerfOpt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(UniversalCardTextPerfOpt$enable$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }
}
