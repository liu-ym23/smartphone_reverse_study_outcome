package com.bytedance.android.live.profile.servicewidget;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final T apply(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (T) ((ic6.a) r2);
    }
}
