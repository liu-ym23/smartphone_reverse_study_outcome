package com.bytedance.android.live.profile.servicewidget;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Predicate {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2 instanceof ic6.a;
    }
}
