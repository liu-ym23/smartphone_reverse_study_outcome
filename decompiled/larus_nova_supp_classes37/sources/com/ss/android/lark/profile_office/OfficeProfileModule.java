package com.ss.android.lark.profile_office;

import kotlin.Lazy;
import kotlin.LazyKt;
import s1c.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileModule {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(OfficeProfileModule$dependency$2.INSTANCE);
    }

    public static b a() {
        return (b) a.getValue();
    }
}
