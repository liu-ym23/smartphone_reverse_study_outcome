package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o<T, R> implements Function {
    public static final o<T, R> a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final Object apply(Object r10) {
        Intrinsics.checkNotNullParameter((Throwable) r10, "it");
        return b.c;
    }
}
