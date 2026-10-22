package com.bytedance.android.live.browser.jsbridge.prefetch;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Predicate {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final boolean test(Object r2) {
        com.bytedance.android.live.browser.jsbridge.g.a r3 = (com.bytedance.android.live.browser.jsbridge.g.a) r2;
        Intrinsics.checkNotNullParameter(r3, "<name for destructuring parameter 0>");
        return !StringsKt.isBlank(r3.b);
    }
}
