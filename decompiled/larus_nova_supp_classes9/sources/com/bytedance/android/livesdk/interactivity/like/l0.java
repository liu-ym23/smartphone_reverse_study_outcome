package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0<T> implements Predicate {
    public static final l0 a = null;

    static {
        a = new l0();
    }

    public l0() {
    }

    public final boolean test(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "events");
        if (r3.size() < 2) goto L5;
        return true;
    L5:
        return false;
    }
}
