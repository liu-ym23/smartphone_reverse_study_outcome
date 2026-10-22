package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.view.View;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T, R> implements Function {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r2) {
        h80.c r3 = (h80.c) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return (View) r3.a();
    }
}
