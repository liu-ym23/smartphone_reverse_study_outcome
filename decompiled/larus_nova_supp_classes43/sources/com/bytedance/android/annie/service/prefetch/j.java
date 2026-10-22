package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j<T> implements Predicate {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final boolean test(Object r10) {
        o.a r11 = (o.a) r10;
        Intrinsics.checkNotNullParameter(r11, "<name for destructuring parameter 0>");
        return !StringsKt.isBlank(r11.b);
    }
}
