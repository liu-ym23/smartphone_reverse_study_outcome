package com.bytedance.android.live.pushstream;

import com.bytedance.common.utility.StringUtils;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Predicate {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final boolean test(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return !StringUtils.isEmpty(r3);
    }
}
